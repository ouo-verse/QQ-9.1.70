package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.collect.MapMakerInternalMap.h;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtIncompatible
/* loaded from: classes2.dex */
public class MapMakerInternalMap<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final v<Object, Object, d> UNSET_WEAK_VALUE_REFERENCE = new a();
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient i<K, V, E, S> entryHelper;

    @MonotonicNonNullDecl
    transient Set<Map.Entry<K, V>> entrySet;
    final Equivalence<Object> keyEquivalence;

    @MonotonicNonNullDecl
    transient Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V, E, S>[] segments;

    @MonotonicNonNullDecl
    transient Collection<V> values;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class CleanupMapTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final WeakReference<MapMakerInternalMap<?, ?, ?, ?>> f34942d;

        @Override // java.lang.Runnable
        public void run() {
            MapMakerInternalMap<?, ?, ?, ?> mapMakerInternalMap = this.f34942d.get();
            if (mapMakerInternalMap != null) {
                for (Segment<?, ?, ?, ?> segment : mapMakerInternalMap.segments) {
                    segment.runCleanup();
                }
                return;
            }
            throw new CancellationException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i3, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i3, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).i();
            readEntries(objectInputStream);
        }

        private Object readResolve() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Equivalence<Object> defaultEquivalence();

        /* synthetic */ Strength(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> {
        StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i3, int i16) {
            super(mapMakerInternalMap, i3, i16);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public m<K> castForTesting(h<K, MapMaker.Dummy, ?> hVar) {
            return (m) hVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> {
        StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i3, int i16) {
            super(mapMakerInternalMap, i3, i16);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public n<K, V> castForTesting(h<K, V, ?> hVar) {
            return (n) hVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i3, int i16) {
            super(mapMakerInternalMap, i3, i16);
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, o<K, V>> getWeakValueReferenceForTesting(h<K, V, ?> hVar) {
            return castForTesting((h) hVar).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, o<K, V>> newWeakValueReferenceForTesting(h<K, V, ?> hVar, V v3) {
            return new w(this.queueForValues, v3, castForTesting((h) hVar));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(h<K, V, ?> hVar, v<K, V, ? extends h<K, V, ?>> vVar) {
            o<K, V> castForTesting = castForTesting((h) hVar);
            v vVar2 = ((o) castForTesting).f34959h;
            ((o) castForTesting).f34959h = vVar;
            vVar2.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public o<K, V> castForTesting(h<K, V, ?> hVar) {
            return (o) hVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> {
        private final ReferenceQueue<K> queueForKeys;

        WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i3, int i16) {
            super(mapMakerInternalMap, i3, i16);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public r<K> castForTesting(h<K, MapMaker.Dummy, ?> hVar) {
            return (r) hVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i3, int i16) {
            super(mapMakerInternalMap, i3, i16);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public s<K, V> castForTesting(h<K, V, ?> hVar) {
            return (s) hVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i3, int i16) {
            super(mapMakerInternalMap, i3, i16);
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, t<K, V>> getWeakValueReferenceForTesting(h<K, V, ?> hVar) {
            return castForTesting((h) hVar).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, t<K, V>> newWeakValueReferenceForTesting(h<K, V, ?> hVar, V v3) {
            return new w(this.queueForValues, v3, castForTesting((h) hVar));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(h<K, V, ?> hVar, v<K, V, ? extends h<K, V, ?>> vVar) {
            t<K, V> castForTesting = castForTesting((h) hVar);
            v vVar2 = ((t) castForTesting).f34965f;
            ((t) castForTesting).f34965f = vVar;
            vVar2.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public t<K, V> castForTesting(h<K, V, ?> hVar) {
            return (t) hVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class b<K, V, E extends h<K, V, E>> implements h<K, V, E> {

        /* renamed from: d, reason: collision with root package name */
        final K f34943d;

        /* renamed from: e, reason: collision with root package name */
        final int f34944e;

        /* renamed from: f, reason: collision with root package name */
        @NullableDecl
        final E f34945f;

        b(K k3, int i3, @NullableDecl E e16) {
            this.f34943d = k3;
            this.f34944e = i3;
            this.f34945f = e16;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public int getHash() {
            return this.f34944e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public K getKey() {
            return this.f34943d;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public E getNext() {
            return this.f34945f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class c<K, V, E extends h<K, V, E>> extends WeakReference<K> implements h<K, V, E> {

        /* renamed from: d, reason: collision with root package name */
        final int f34946d;

        /* renamed from: e, reason: collision with root package name */
        @NullableDecl
        final E f34947e;

        c(ReferenceQueue<K> referenceQueue, K k3, int i3, @NullableDecl E e16) {
            super(k3, referenceQueue);
            this.f34946d = i3;
            this.f34947e = e16;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public int getHash() {
            return this.f34946d;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public K getKey() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public E getNext() {
            return this.f34947e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class d implements h<Object, Object, d> {
        d() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d getNext() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public int getHash() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public Object getValue() {
            throw new AssertionError();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    final class e extends MapMakerInternalMap<K, V, E, S>.g<Map.Entry<K, V>> {
        e() {
            super();
        }

        @Override // java.util.Iterator
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    final class f extends l<Map.Entry<K, V>> {
        f() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (obj2 = MapMakerInternalMap.this.get(key)) == null || !MapMakerInternalMap.this.valueEquivalence().equivalent(entry.getValue(), obj2)) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new e();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || !MapMakerInternalMap.this.remove(key, entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public abstract class g<T> implements Iterator<T> {

        @NullableDecl
        MapMakerInternalMap<K, V, E, S>.x C;

        /* renamed from: d, reason: collision with root package name */
        int f34949d;

        /* renamed from: e, reason: collision with root package name */
        int f34950e = -1;

        /* renamed from: f, reason: collision with root package name */
        @MonotonicNonNullDecl
        Segment<K, V, E, S> f34951f;

        /* renamed from: h, reason: collision with root package name */
        @MonotonicNonNullDecl
        AtomicReferenceArray<E> f34952h;

        /* renamed from: i, reason: collision with root package name */
        @NullableDecl
        E f34953i;

        /* renamed from: m, reason: collision with root package name */
        @NullableDecl
        MapMakerInternalMap<K, V, E, S>.x f34954m;

        g() {
            this.f34949d = MapMakerInternalMap.this.segments.length - 1;
            a();
        }

        final void a() {
            this.f34954m = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i3 = this.f34949d;
                if (i3 >= 0) {
                    Segment<K, V, E, S>[] segmentArr = MapMakerInternalMap.this.segments;
                    this.f34949d = i3 - 1;
                    Segment<K, V, E, S> segment = segmentArr[i3];
                    this.f34951f = segment;
                    if (segment.count != 0) {
                        this.f34952h = this.f34951f.table;
                        this.f34950e = r0.length() - 1;
                        if (e()) {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }

        boolean b(E e16) {
            try {
                Object key = e16.getKey();
                Object liveValue = MapMakerInternalMap.this.getLiveValue(e16);
                if (liveValue != null) {
                    this.f34954m = new x(key, liveValue);
                    this.f34951f.postReadCleanup();
                    return true;
                }
                this.f34951f.postReadCleanup();
                return false;
            } catch (Throwable th5) {
                this.f34951f.postReadCleanup();
                throw th5;
            }
        }

        MapMakerInternalMap<K, V, E, S>.x c() {
            MapMakerInternalMap<K, V, E, S>.x xVar = this.f34954m;
            if (xVar != null) {
                this.C = xVar;
                a();
                return this.C;
            }
            throw new NoSuchElementException();
        }

        boolean d() {
            E e16 = this.f34953i;
            if (e16 == null) {
                return false;
            }
            while (true) {
                this.f34953i = (E) e16.getNext();
                E e17 = this.f34953i;
                if (e17 != null) {
                    if (b(e17)) {
                        return true;
                    }
                    e16 = this.f34953i;
                } else {
                    return false;
                }
            }
        }

        boolean e() {
            while (true) {
                int i3 = this.f34950e;
                if (i3 >= 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.f34952h;
                    this.f34950e = i3 - 1;
                    E e16 = atomicReferenceArray.get(i3);
                    this.f34953i = e16;
                    if (e16 != null && (b(e16) || d())) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f34954m != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z16;
            if (this.C != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.google.common.collect.h.d(z16);
            MapMakerInternalMap.this.remove(this.C.getKey());
            this.C = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface h<K, V, E extends h<K, V, E>> {
        int getHash();

        K getKey();

        E getNext();

        V getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface i<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> {
        Strength a();

        Strength b();

        void c(S s16, E e16, V v3);

        E d(S s16, E e16, @NullableDecl E e17);

        S e(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i3, int i16);

        E f(S s16, K k3, int i3, @NullableDecl E e16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    final class j extends MapMakerInternalMap<K, V, E, S>.g<K> {
        j() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    final class k extends l<K> {
        k() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new j();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (MapMakerInternalMap.this.remove(obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static abstract class l<E> extends AbstractSet<E> {
        l() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.c(this).toArray();
        }

        /* synthetic */ l(a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.c(this).toArray(tArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class n<K, V> extends b<K, V, n<K, V>> {

        /* renamed from: h, reason: collision with root package name */
        @NullableDecl
        private volatile V f34957h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class a<K, V> implements i<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            private static final a<?, ?> f34958a = new a<>();

            a() {
            }

            static <K, V> a<K, V> h() {
                return (a<K, V>) f34958a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public n<K, V> d(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, n<K, V> nVar, @NullableDecl n<K, V> nVar2) {
                return nVar.a(nVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public n<K, V> f(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k3, int i3, @NullableDecl n<K, V> nVar) {
                return new n<>(k3, i3, nVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyStrongValueSegment<K, V> e(MapMakerInternalMap<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i3, int i16) {
                return new StrongKeyStrongValueSegment<>(mapMakerInternalMap, i3, i16);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void c(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, n<K, V> nVar, V v3) {
                nVar.b(v3);
            }
        }

        n(K k3, int i3, @NullableDecl n<K, V> nVar) {
            super(k3, i3, nVar);
            this.f34957h = null;
        }

        n<K, V> a(n<K, V> nVar) {
            n<K, V> nVar2 = new n<>(this.f34943d, this.f34944e, nVar);
            nVar2.f34957h = this.f34957h;
            return nVar2;
        }

        void b(V v3) {
            this.f34957h = v3;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        @NullableDecl
        public V getValue() {
            return this.f34957h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class o<K, V> extends b<K, V, o<K, V>> implements u<K, V, o<K, V>> {

        /* renamed from: h, reason: collision with root package name */
        private volatile v<K, V, o<K, V>> f34959h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class a<K, V> implements i<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            private static final a<?, ?> f34960a = new a<>();

            a() {
            }

            static <K, V> a<K, V> h() {
                return (a<K, V>) f34960a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public o<K, V> d(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, o<K, V> oVar, @NullableDecl o<K, V> oVar2) {
                if (Segment.isCollected(oVar)) {
                    return null;
                }
                return oVar.c(((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues, oVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public o<K, V> f(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k3, int i3, @NullableDecl o<K, V> oVar) {
                return new o<>(k3, i3, oVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyWeakValueSegment<K, V> e(MapMakerInternalMap<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i3, int i16) {
                return new StrongKeyWeakValueSegment<>(mapMakerInternalMap, i3, i16);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void c(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, o<K, V> oVar, V v3) {
                oVar.d(v3, ((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues);
            }
        }

        o(K k3, int i3, @NullableDecl o<K, V> oVar) {
            super(k3, i3, oVar);
            this.f34959h = MapMakerInternalMap.unsetWeakValueReference();
        }

        o<K, V> c(ReferenceQueue<V> referenceQueue, o<K, V> oVar) {
            o<K, V> oVar2 = new o<>(this.f34943d, this.f34944e, oVar);
            oVar2.f34959h = this.f34959h.b(referenceQueue, oVar2);
            return oVar2;
        }

        void d(V v3, ReferenceQueue<V> referenceQueue) {
            v<K, V, o<K, V>> vVar = this.f34959h;
            this.f34959h = new w(referenceQueue, v3, this);
            vVar.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public V getValue() {
            return this.f34959h.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public v<K, V, o<K, V>> getValueReference() {
            return this.f34959h;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    final class p extends MapMakerInternalMap<K, V, E, S>.g<V> {
        p() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    final class q extends AbstractCollection<V> {
        q() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new p();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return MapMakerInternalMap.c(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.c(this).toArray(tArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class s<K, V> extends c<K, V, s<K, V>> {

        /* renamed from: f, reason: collision with root package name */
        @NullableDecl
        private volatile V f34963f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class a<K, V> implements i<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            private static final a<?, ?> f34964a = new a<>();

            a() {
            }

            static <K, V> a<K, V> h() {
                return (a<K, V>) f34964a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength a() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public s<K, V> d(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, s<K, V> sVar, @NullableDecl s<K, V> sVar2) {
                if (sVar.getKey() == null) {
                    return null;
                }
                return sVar.a(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, sVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public s<K, V> f(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k3, int i3, @NullableDecl s<K, V> sVar) {
                return new s<>(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, k3, i3, sVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyStrongValueSegment<K, V> e(MapMakerInternalMap<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i3, int i16) {
                return new WeakKeyStrongValueSegment<>(mapMakerInternalMap, i3, i16);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void c(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, s<K, V> sVar, V v3) {
                sVar.b(v3);
            }
        }

        s(ReferenceQueue<K> referenceQueue, K k3, int i3, @NullableDecl s<K, V> sVar) {
            super(referenceQueue, k3, i3, sVar);
            this.f34963f = null;
        }

        s<K, V> a(ReferenceQueue<K> referenceQueue, s<K, V> sVar) {
            s<K, V> sVar2 = new s<>(referenceQueue, getKey(), this.f34946d, sVar);
            sVar2.b(this.f34963f);
            return sVar2;
        }

        void b(V v3) {
            this.f34963f = v3;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        @NullableDecl
        public V getValue() {
            return this.f34963f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class t<K, V> extends c<K, V, t<K, V>> implements u<K, V, t<K, V>> {

        /* renamed from: f, reason: collision with root package name */
        private volatile v<K, V, t<K, V>> f34965f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class a<K, V> implements i<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            private static final a<?, ?> f34966a = new a<>();

            a() {
            }

            static <K, V> a<K, V> h() {
                return (a<K, V>) f34966a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength a() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public t<K, V> d(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, t<K, V> tVar, @NullableDecl t<K, V> tVar2) {
                if (tVar.getKey() == null || Segment.isCollected(tVar)) {
                    return null;
                }
                return tVar.c(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, ((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues, tVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public t<K, V> f(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k3, int i3, @NullableDecl t<K, V> tVar) {
                return new t<>(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, k3, i3, tVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyWeakValueSegment<K, V> e(MapMakerInternalMap<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i3, int i16) {
                return new WeakKeyWeakValueSegment<>(mapMakerInternalMap, i3, i16);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void c(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, t<K, V> tVar, V v3) {
                tVar.d(v3, ((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues);
            }
        }

        t(ReferenceQueue<K> referenceQueue, K k3, int i3, @NullableDecl t<K, V> tVar) {
            super(referenceQueue, k3, i3, tVar);
            this.f34965f = MapMakerInternalMap.unsetWeakValueReference();
        }

        t<K, V> c(ReferenceQueue<K> referenceQueue, ReferenceQueue<V> referenceQueue2, t<K, V> tVar) {
            t<K, V> tVar2 = new t<>(referenceQueue, getKey(), this.f34946d, tVar);
            tVar2.f34965f = this.f34965f.b(referenceQueue2, tVar2);
            return tVar2;
        }

        void d(V v3, ReferenceQueue<V> referenceQueue) {
            v<K, V, t<K, V>> vVar = this.f34965f;
            this.f34965f = new w(referenceQueue, v3, this);
            vVar.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public V getValue() {
            return this.f34965f.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public v<K, V, t<K, V>> getValueReference() {
            return this.f34965f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface u<K, V, E extends h<K, V, E>> extends h<K, V, E> {
        v<K, V, E> getValueReference();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface v<K, V, E extends h<K, V, E>> {
        E a();

        v<K, V, E> b(ReferenceQueue<V> referenceQueue, E e16);

        void clear();

        @NullableDecl
        V get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class w<K, V, E extends h<K, V, E>> extends WeakReference<V> implements v<K, V, E> {

        /* renamed from: d, reason: collision with root package name */
        @Weak
        final E f34967d;

        w(ReferenceQueue<V> referenceQueue, V v3, E e16) {
            super(v3, referenceQueue);
            this.f34967d = e16;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public E a() {
            return this.f34967d;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public v<K, V, E> b(ReferenceQueue<V> referenceQueue, E e16) {
            return new w(referenceQueue, get(), e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public final class x extends com.google.common.collect.b<K, V> {

        /* renamed from: d, reason: collision with root package name */
        final K f34968d;

        /* renamed from: e, reason: collision with root package name */
        V f34969e;

        x(K k3, V v3) {
            this.f34968d = k3;
            this.f34969e = v3;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!this.f34968d.equals(entry.getKey()) || !this.f34969e.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return this.f34968d;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getValue() {
            return this.f34969e;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public int hashCode() {
            return this.f34968d.hashCode() ^ this.f34969e.hashCode();
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V setValue(V v3) {
            V v16 = (V) MapMakerInternalMap.this.put(this.f34968d, v3);
            this.f34969e = v3;
            return v16;
        }
    }

    MapMakerInternalMap(MapMaker mapMaker, i<K, V, E, S> iVar) {
        this.concurrencyLevel = Math.min(mapMaker.b(), 65536);
        this.keyEquivalence = mapMaker.d();
        this.entryHelper = iVar;
        int min = Math.min(mapMaker.c(), 1073741824);
        int i3 = 0;
        int i16 = 1;
        int i17 = 0;
        int i18 = 1;
        while (i18 < this.concurrencyLevel) {
            i17++;
            i18 <<= 1;
        }
        this.segmentShift = 32 - i17;
        this.segmentMask = i18 - 1;
        this.segments = newSegmentArray(i18);
        int i19 = min / i18;
        while (i16 < (i18 * i19 < min ? i19 + 1 : i19)) {
            i16 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.segments;
            if (i3 < segmentArr.length) {
                segmentArr[i3] = createSegment(i16, -1);
                i3++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ArrayList<E> c(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        com.google.common.collect.r.a(arrayList, collection.iterator());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> MapMakerInternalMap<K, V, ? extends h<K, V, ?>, ?> create(MapMaker mapMaker) {
        Strength e16 = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (e16 == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, n.a.h());
        }
        if (mapMaker.e() == strength && mapMaker.f() == Strength.WEAK) {
            return new MapMakerInternalMap<>(mapMaker, o.a.h());
        }
        Strength e17 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (e17 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, s.a.h());
        }
        if (mapMaker.e() == strength2 && mapMaker.f() == strength2) {
            return new MapMakerInternalMap<>(mapMaker, t.a.h());
        }
        throw new AssertionError();
    }

    static <K> MapMakerInternalMap<K, MapMaker.Dummy, ? extends h<K, MapMaker.Dummy, ?>, ?> createWithDummyValues(MapMaker mapMaker) {
        Strength e16 = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (e16 == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, m.a.h());
        }
        Strength e17 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (e17 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, r.a.h());
        }
        if (mapMaker.f() == strength2) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    static int rehash(int i3) {
        int i16 = i3 + ((i3 << 15) ^ (-12931));
        int i17 = i16 ^ (i16 >>> 10);
        int i18 = i17 + (i17 << 3);
        int i19 = i18 ^ (i18 >>> 6);
        int i26 = i19 + (i19 << 2) + (i19 << 14);
        return i26 ^ (i26 >>> 16);
    }

    static <K, V, E extends h<K, V, E>> v<K, V, E> unsetWeakValueReference() {
        return (v<K, V, E>) UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V, E, S> segment : this.segments) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).containsKey(obj, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.common.collect.MapMakerInternalMap$Segment] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>>[]] */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        boolean z16 = false;
        if (obj == null) {
            return false;
        }
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j3 = -1;
        int i3 = 0;
        while (i3 < 3) {
            int length = segmentArr.length;
            long j16 = 0;
            for (?? r102 = z16; r102 < length; r102++) {
                ?? r112 = segmentArr[r102];
                int i16 = r112.count;
                AtomicReferenceArray<E> atomicReferenceArray = r112.table;
                for (?? r132 = z16; r132 < atomicReferenceArray.length(); r132++) {
                    for (E e16 = atomicReferenceArray.get(r132); e16 != null; e16 = e16.getNext()) {
                        Object liveValue = r112.getLiveValue(e16);
                        if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
                j16 += r112.modCount;
                z16 = false;
            }
            if (j16 == j3) {
                return false;
            }
            i3++;
            j3 = j16;
            z16 = false;
        }
        return z16;
    }

    @VisibleForTesting
    E copyEntry(E e16, E e17) {
        return segmentFor(e16.getHash()).copyEntry(e16, e17);
    }

    Segment<K, V, E, S> createSegment(int i3, int i16) {
        return this.entryHelper.e(this, i3, i16);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set == null) {
            f fVar = new f();
            this.entrySet = fVar;
            return fVar;
        }
        return set;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    E getEntry(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    V getLiveValue(E e16) {
        V v3;
        if (e16.getKey() == null || (v3 = (V) e16.getValue()) == null) {
            return null;
        }
        return v3;
    }

    int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j3 = 0;
        for (int i3 = 0; i3 < segmentArr.length; i3++) {
            if (segmentArr[i3].count != 0) {
                return false;
            }
            j3 += segmentArr[i3].modCount;
        }
        if (j3 != 0) {
            for (int i16 = 0; i16 < segmentArr.length; i16++) {
                if (segmentArr[i16].count != 0) {
                    return false;
                }
                j3 -= segmentArr[i16].modCount;
            }
            if (j3 != 0) {
                return false;
            }
            return true;
        }
        return true;
    }

    @VisibleForTesting
    boolean isLiveForTesting(h<K, V, ?> hVar) {
        if (segmentFor(hVar.getHash()).getLiveValueForTesting(hVar) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set == null) {
            k kVar = new k();
            this.keySet = kVar;
            return kVar;
        }
        return set;
    }

    @VisibleForTesting
    Strength keyStrength() {
        return this.entryHelper.a();
    }

    final Segment<K, V, E, S>[] newSegmentArray(int i3) {
        return new Segment[i3];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V put(K k3, V v3) {
        com.google.common.base.j.m(k3);
        com.google.common.base.j.m(v3);
        int hash = hash(k3);
        return segmentFor(hash).put(k3, hash, v3, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V putIfAbsent(K k3, V v3) {
        com.google.common.base.j.m(k3);
        com.google.common.base.j.m(v3);
        int hash = hash(k3);
        return segmentFor(hash).put(k3, hash, v3, true);
    }

    void reclaimKey(E e16) {
        int hash = e16.getHash();
        segmentFor(hash).reclaimKey(e16, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void reclaimValue(v<K, V, E> vVar) {
        E a16 = vVar.a();
        int hash = a16.getHash();
        segmentFor(hash).reclaimValue(a16.getKey(), hash, vVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k3, @NullableDecl V v3, V v16) {
        com.google.common.base.j.m(k3);
        com.google.common.base.j.m(v16);
        if (v3 == null) {
            return false;
        }
        int hash = hash(k3);
        return segmentFor(hash).replace(k3, hash, v3, v16);
    }

    Segment<K, V, E, S> segmentFor(int i3) {
        return this.segments[(i3 >>> this.segmentShift) & this.segmentMask];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j3 = 0;
        for (int i3 = 0; i3 < this.segments.length; i3++) {
            j3 += r0[i3].count;
        }
        return s1.c.b(j3);
    }

    @VisibleForTesting
    Equivalence<Object> valueEquivalence() {
        return this.entryHelper.b().defaultEquivalence();
    }

    @VisibleForTesting
    Strength valueStrength() {
        return this.entryHelper.b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection == null) {
            q qVar = new q();
            this.values = qVar;
            return qVar;
        }
        return collection;
    }

    Object writeReplace() {
        return new SerializationProxy(this.entryHelper.a(), this.entryHelper.b(), this.keyEquivalence, this.entryHelper.b().defaultEquivalence(), this.concurrencyLevel, this);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static abstract class AbstractSerializationProxy<K, V> extends com.google.common.collect.m<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i3, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i3;
            this.delegate = concurrentMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void readEntries(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject == null) {
                    return;
                }
                this.delegate.put(readObject, objectInputStream.readObject());
            }
        }

        MapMaker readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            return new MapMaker().g(objectInputStream.readInt()).j(this.keyStrength).k(this.valueStrength).h(this.keyEquivalence).a(this.concurrencyLevel);
        }

        void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.m, com.google.common.collect.n, com.google.common.collect.o
        public ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V replace(K k3, V v3) {
        com.google.common.base.j.m(k3);
        com.google.common.base.j.m(v3);
        int hash = hash(k3);
        return segmentFor(hash).replace(k3, hash, v3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class Segment<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;

        @Weak
        final MapMakerInternalMap<K, V, E, S> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();

        @MonotonicNonNullDecl
        volatile AtomicReferenceArray<E> table;
        int threshold;

        Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i3, int i16) {
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i16;
            initTable(newEntryArray(i3));
        }

        static <K, V, E extends h<K, V, E>> boolean isCollected(E e16) {
            if (e16.getValue() == null) {
                return true;
            }
            return false;
        }

        abstract E castForTesting(h<K, V, ?> hVar);

        void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                        atomicReferenceArray.set(i3, null);
                    }
                    maybeClearReferenceQueues();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                }
            }
        }

        <T> void clearReferenceQueue(ReferenceQueue<T> referenceQueue) {
            do {
            } while (referenceQueue.poll() != null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        boolean clearValueForTesting(K k3, int i3, v<K, V, ? extends h<K, V, ?>> vVar) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i3;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    Object key = hVar2.getKey();
                    if (hVar2.getHash() == i3 && key != null && this.map.keyEquivalence.equivalent(k3, key)) {
                        if (((u) hVar2).getValueReference() != vVar) {
                            return false;
                        }
                        atomicReferenceArray.set(length, removeFromChain(hVar, hVar2));
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        boolean containsKey(Object obj, int i3) {
            try {
                boolean z16 = false;
                if (this.count == 0) {
                    return false;
                }
                E liveEntry = getLiveEntry(obj, i3);
                if (liveEntry != null) {
                    if (liveEntry.getValue() != null) {
                        z16 = true;
                    }
                }
                return z16;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @VisibleForTesting
        boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        for (E e16 = atomicReferenceArray.get(i3); e16 != null; e16 = e16.getNext()) {
                            Object liveValue = getLiveValue(e16);
                            if (liveValue != null && this.map.valueEquivalence().equivalent(obj, liveValue)) {
                                postReadCleanup();
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        E copyEntry(E e16, E e17) {
            return this.map.entryHelper.d(self(), e16, e17);
        }

        E copyForTesting(h<K, V, ?> hVar, @NullableDecl h<K, V, ?> hVar2) {
            return this.map.entryHelper.d(self(), castForTesting(hVar), castForTesting(hVar2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        void drainKeyReferenceQueue(ReferenceQueue<K> referenceQueue) {
            int i3 = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll != null) {
                    this.map.reclaimKey((h) poll);
                    i3++;
                } else {
                    return;
                }
            } while (i3 != 16);
        }

        @GuardedBy("this")
        void drainValueReferenceQueue(ReferenceQueue<V> referenceQueue) {
            int i3 = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll != null) {
                    this.map.reclaimValue((v) poll);
                    i3++;
                } else {
                    return;
                }
            } while (i3 != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        void expand() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i3 = this.count;
            SpscExactAtomicArrayQueue spscExactAtomicArrayQueue = (AtomicReferenceArray<E>) newEntryArray(length << 1);
            this.threshold = (spscExactAtomicArrayQueue.length() * 3) / 4;
            int length2 = spscExactAtomicArrayQueue.length() - 1;
            for (int i16 = 0; i16 < length; i16++) {
                E e16 = atomicReferenceArray.get(i16);
                if (e16 != null) {
                    h next = e16.getNext();
                    int hash = e16.getHash() & length2;
                    if (next == null) {
                        spscExactAtomicArrayQueue.set(hash, e16);
                    } else {
                        h hVar = e16;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                hVar = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        spscExactAtomicArrayQueue.set(hash, hVar);
                        while (e16 != hVar) {
                            int hash3 = e16.getHash() & length2;
                            h copyEntry = copyEntry(e16, (h) spscExactAtomicArrayQueue.get(hash3));
                            if (copyEntry != null) {
                                spscExactAtomicArrayQueue.set(hash3, copyEntry);
                            } else {
                                i3--;
                            }
                            e16 = e16.getNext();
                        }
                    }
                }
            }
            this.table = spscExactAtomicArrayQueue;
            this.count = i3;
        }

        V get(Object obj, int i3) {
            try {
                E liveEntry = getLiveEntry(obj, i3);
                if (liveEntry == null) {
                    postReadCleanup();
                    return null;
                }
                V v3 = (V) liveEntry.getValue();
                if (v3 == null) {
                    tryDrainReferenceQueues();
                }
                return v3;
            } finally {
                postReadCleanup();
            }
        }

        E getEntry(Object obj, int i3) {
            if (this.count != 0) {
                for (E first = getFirst(i3); first != null; first = (E) first.getNext()) {
                    if (first.getHash() == i3) {
                        Object key = first.getKey();
                        if (key == null) {
                            tryDrainReferenceQueues();
                        } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                            return first;
                        }
                    }
                }
                return null;
            }
            return null;
        }

        E getFirst(int i3) {
            return this.table.get(i3 & (r0.length() - 1));
        }

        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        E getLiveEntry(Object obj, int i3) {
            return getEntry(obj, i3);
        }

        @NullableDecl
        V getLiveValue(E e16) {
            if (e16.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v3 = (V) e16.getValue();
            if (v3 == null) {
                tryDrainReferenceQueues();
                return null;
            }
            return v3;
        }

        @NullableDecl
        V getLiveValueForTesting(h<K, V, ?> hVar) {
            return getLiveValue(castForTesting(hVar));
        }

        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        v<K, V, E> getWeakValueReferenceForTesting(h<K, V, ?> hVar) {
            throw new AssertionError();
        }

        void initTable(AtomicReferenceArray<E> atomicReferenceArray) {
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.threshold = length;
            if (length == this.maxSegmentSize) {
                this.threshold = length + 1;
            }
            this.table = atomicReferenceArray;
        }

        AtomicReferenceArray<E> newEntryArray(int i3) {
            return new AtomicReferenceArray<>(i3);
        }

        E newEntryForTesting(K k3, int i3, @NullableDecl h<K, V, ?> hVar) {
            return this.map.entryHelper.f(self(), k3, i3, castForTesting(hVar));
        }

        v<K, V, E> newWeakValueReferenceForTesting(h<K, V, ?> hVar, V v3) {
            throw new AssertionError();
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        @GuardedBy("this")
        void preWriteCleanup() {
            runLockedCleanup();
        }

        /* JADX WARN: Multi-variable type inference failed */
        V put(K k3, int i3, V v3, boolean z16) {
            lock();
            try {
                preWriteCleanup();
                int i16 = this.count + 1;
                if (i16 > this.threshold) {
                    expand();
                    i16 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i3;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    Object key = hVar2.getKey();
                    if (hVar2.getHash() == i3 && key != null && this.map.keyEquivalence.equivalent(k3, key)) {
                        V v16 = (V) hVar2.getValue();
                        if (v16 == null) {
                            this.modCount++;
                            setValue(hVar2, v3);
                            this.count = this.count;
                            return null;
                        }
                        if (z16) {
                            return v16;
                        }
                        this.modCount++;
                        setValue(hVar2, v3);
                        return v16;
                    }
                }
                this.modCount++;
                h f16 = this.map.entryHelper.f(self(), k3, i3, hVar);
                setValue(f16, v3);
                atomicReferenceArray.set(length, f16);
                this.count = i16;
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        boolean reclaimKey(E e16, int i3) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = i3 & (atomicReferenceArray.length() - 1);
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    if (hVar2 == e16) {
                        this.modCount++;
                        h removeFromChain = removeFromChain(hVar, hVar2);
                        int i16 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i16;
                        return true;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        boolean reclaimValue(K k3, int i3, v<K, V, E> vVar) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i3;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    Object key = hVar2.getKey();
                    if (hVar2.getHash() == i3 && key != null && this.map.keyEquivalence.equivalent(k3, key)) {
                        if (((u) hVar2).getValueReference() != vVar) {
                            return false;
                        }
                        this.modCount++;
                        h removeFromChain = removeFromChain(hVar, hVar2);
                        int i16 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i16;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        V remove(Object obj, int i3) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i3;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    Object key = hVar2.getKey();
                    if (hVar2.getHash() == i3 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        V v3 = (V) hVar2.getValue();
                        if (v3 == null && !isCollected(hVar2)) {
                            return null;
                        }
                        this.modCount++;
                        h removeFromChain = removeFromChain(hVar, hVar2);
                        int i16 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i16;
                        return v3;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        boolean removeEntryForTesting(E e16) {
            int hash = e16.getHash();
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = hash & (atomicReferenceArray.length() - 1);
            h hVar = (h) atomicReferenceArray.get(length);
            for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                if (hVar2 == e16) {
                    this.modCount++;
                    h removeFromChain = removeFromChain(hVar, hVar2);
                    int i3 = this.count - 1;
                    atomicReferenceArray.set(length, removeFromChain);
                    this.count = i3;
                    return true;
                }
            }
            return false;
        }

        @GuardedBy("this")
        E removeFromChain(E e16, E e17) {
            int i3 = this.count;
            E e18 = (E) e17.getNext();
            while (e16 != e17) {
                E copyEntry = copyEntry(e16, e18);
                if (copyEntry != null) {
                    e18 = copyEntry;
                } else {
                    i3--;
                }
                e16 = (E) e16.getNext();
            }
            this.count = i3;
            return e18;
        }

        E removeFromChainForTesting(h<K, V, ?> hVar, h<K, V, ?> hVar2) {
            return removeFromChain(castForTesting(hVar), castForTesting(hVar2));
        }

        @CanIgnoreReturnValue
        boolean removeTableEntryForTesting(h<K, V, ?> hVar) {
            return removeEntryForTesting(castForTesting(hVar));
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean replace(K k3, int i3, V v3, V v16) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i3;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    Object key = hVar2.getKey();
                    if (hVar2.getHash() == i3 && key != null && this.map.keyEquivalence.equivalent(k3, key)) {
                        Object value = hVar2.getValue();
                        if (value == null) {
                            if (isCollected(hVar2)) {
                                this.modCount++;
                                h removeFromChain = removeFromChain(hVar, hVar2);
                                int i16 = this.count - 1;
                                atomicReferenceArray.set(length, removeFromChain);
                                this.count = i16;
                            }
                            return false;
                        }
                        if (!this.map.valueEquivalence().equivalent(v3, value)) {
                            return false;
                        }
                        this.modCount++;
                        setValue(hVar2, v16);
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        void runCleanup() {
            runLockedCleanup();
        }

        void runLockedCleanup() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        abstract S self();

        void setTableEntryForTesting(int i3, h<K, V, ?> hVar) {
            this.table.set(i3, castForTesting(hVar));
        }

        void setValue(E e16, V v3) {
            this.map.entryHelper.c(self(), e16, v3);
        }

        void setValueForTesting(h<K, V, ?> hVar, V v3) {
            this.map.entryHelper.c(self(), castForTesting(hVar), v3);
        }

        void setWeakValueReferenceForTesting(h<K, V, ?> hVar, v<K, V, ? extends h<K, V, ?>> vVar) {
            throw new AssertionError();
        }

        void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        
            if (r8.map.valueEquivalence().equivalent(r11, r4.getValue()) == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        
            r8.modCount++;
            r9 = removeFromChain(r3, r4);
            r10 = r8.count - 1;
            r0.set(r1, r9);
            r8.count = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
        
            if (isCollected(r4) == false) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x005f, code lost:
        
            return false;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        boolean remove(Object obj, int i3, Object obj2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i3;
                h hVar = (h) atomicReferenceArray.get(length);
                h hVar2 = hVar;
                while (true) {
                    boolean z16 = false;
                    if (hVar2 == null) {
                        return false;
                    }
                    Object key = hVar2.getKey();
                    if (hVar2.getHash() == i3 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        break;
                    }
                    hVar2 = hVar2.getNext();
                }
            } finally {
                unlock();
            }
        }

        void maybeClearReferenceQueues() {
        }

        @GuardedBy("this")
        void maybeDrainReferenceQueues() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        V replace(K k3, int i3, V v3) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i3;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    Object key = hVar2.getKey();
                    if (hVar2.getHash() == i3 && key != null && this.map.keyEquivalence.equivalent(k3, key)) {
                        V v16 = (V) hVar2.getValue();
                        if (v16 == null) {
                            if (isCollected(hVar2)) {
                                this.modCount++;
                                h removeFromChain = removeFromChain(hVar, hVar2);
                                int i16 = this.count - 1;
                                atomicReferenceArray.set(length, removeFromChain);
                                this.count = i16;
                            }
                            return null;
                        }
                        this.modCount++;
                        setValue(hVar2, v3);
                        return v16;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class a implements v<Object, Object, d> {
        a() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public d a() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public Object get() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public void clear() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public v<Object, Object, d> b(ReferenceQueue<Object> referenceQueue, d dVar) {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class m<K> extends b<K, MapMaker.Dummy, m<K>> {
        m(K k3, int i3, @NullableDecl m<K> mVar) {
            super(k3, i3, mVar);
        }

        m<K> a(m<K> mVar) {
            return new m<>(this.f34943d, this.f34944e, mVar);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        static final class a<K> implements i<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> {

            /* renamed from: a, reason: collision with root package name */
            private static final a<?> f34956a = new a<>();

            a() {
            }

            static <K> a<K> h() {
                return (a<K>) f34956a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public m<K> d(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, m<K> mVar, @NullableDecl m<K> mVar2) {
                return mVar.a(mVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public m<K> f(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, K k3, int i3, @NullableDecl m<K> mVar) {
                return new m<>(k3, i3, mVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyDummyValueSegment<K> e(MapMakerInternalMap<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i3, int i16) {
                return new StrongKeyDummyValueSegment<>(mapMakerInternalMap, i3, i16);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void c(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, m<K> mVar, MapMaker.Dummy dummy) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class r<K> extends c<K, MapMaker.Dummy, r<K>> {
        r(ReferenceQueue<K> referenceQueue, K k3, int i3, @NullableDecl r<K> rVar) {
            super(referenceQueue, k3, i3, rVar);
        }

        r<K> a(ReferenceQueue<K> referenceQueue, r<K> rVar) {
            return new r<>(referenceQueue, getKey(), this.f34946d, rVar);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        static final class a<K> implements i<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> {

            /* renamed from: a, reason: collision with root package name */
            private static final a<?> f34962a = new a<>();

            a() {
            }

            static <K> a<K> h() {
                return (a<K>) f34962a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength a() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public r<K> d(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, r<K> rVar, @NullableDecl r<K> rVar2) {
                if (rVar.getKey() == null) {
                    return null;
                }
                return rVar.a(((WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, rVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public r<K> f(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, K k3, int i3, @NullableDecl r<K> rVar) {
                return new r<>(((WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, k3, i3, rVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyDummyValueSegment<K> e(MapMakerInternalMap<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i3, int i16) {
                return new WeakKeyDummyValueSegment<>(mapMakerInternalMap, i3, i16);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void c(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, r<K> rVar, MapMaker.Dummy dummy) {
            }
        }
    }
}
