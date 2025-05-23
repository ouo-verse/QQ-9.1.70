package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    static final Logger T = Logger.getLogger(LocalCache.class.getName());
    static final s<Object, Object> U = new a();
    static final Queue<?> V = new b();
    final Strength C;
    final Strength D;
    final long E;
    final com.google.common.cache.k<K, V> F;
    final long G;
    final long H;
    final long I;
    final Queue<RemovalNotification<K, V>> J;
    final com.google.common.cache.i<K, V> K;
    final com.google.common.base.q L;
    final EntryFactory M;
    final com.google.common.cache.b N;

    @NullableDecl
    final CacheLoader<? super K, V> P;

    @MonotonicNonNullDecl
    Set<K> Q;

    @MonotonicNonNullDecl
    Collection<V> R;

    @MonotonicNonNullDecl
    Set<Map.Entry<K, V>> S;

    /* renamed from: d, reason: collision with root package name */
    final int f34742d;

    /* renamed from: e, reason: collision with root package name */
    final int f34743e;

    /* renamed from: f, reason: collision with root package name */
    final Segment<K, V>[] f34744f;

    /* renamed from: h, reason: collision with root package name */
    final int f34745h;

    /* renamed from: i, reason: collision with root package name */
    final Equivalence<Object> f34746i;

    /* renamed from: m, reason: collision with root package name */
    final Equivalence<Object> f34747m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum EntryFactory {
        STRONG { // from class: com.google.common.cache.LocalCache.EntryFactory.1
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k3, int i3, @NullableDecl com.google.common.cache.h<K, V> hVar) {
                return new o(k3, i3, hVar);
            }
        },
        STRONG_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.2
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
                com.google.common.cache.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyAccessEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k3, int i3, @NullableDecl com.google.common.cache.h<K, V> hVar) {
                return new m(k3, i3, hVar);
            }
        },
        STRONG_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.3
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
                com.google.common.cache.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyWriteEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k3, int i3, @NullableDecl com.google.common.cache.h<K, V> hVar) {
                return new q(k3, i3, hVar);
            }
        },
        STRONG_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.4
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
                com.google.common.cache.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyAccessEntry(hVar, copyEntry);
                copyWriteEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k3, int i3, @NullableDecl com.google.common.cache.h<K, V> hVar) {
                return new n(k3, i3, hVar);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.EntryFactory.5
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k3, int i3, @NullableDecl com.google.common.cache.h<K, V> hVar) {
                return new w(segment.keyReferenceQueue, k3, i3, hVar);
            }
        },
        WEAK_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.6
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
                com.google.common.cache.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyAccessEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k3, int i3, @NullableDecl com.google.common.cache.h<K, V> hVar) {
                return new u(segment.keyReferenceQueue, k3, i3, hVar);
            }
        },
        WEAK_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.7
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
                com.google.common.cache.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyWriteEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k3, int i3, @NullableDecl com.google.common.cache.h<K, V> hVar) {
                return new y(segment.keyReferenceQueue, k3, i3, hVar);
            }
        },
        WEAK_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.8
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
                com.google.common.cache.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyAccessEntry(hVar, copyEntry);
                copyWriteEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k3, int i3, @NullableDecl com.google.common.cache.h<K, V> hVar) {
                return new v(segment.keyReferenceQueue, k3, i3, hVar);
            }
        };

        static final int ACCESS_MASK = 1;
        static final int WEAK_MASK = 4;
        static final int WRITE_MASK = 2;
        static final EntryFactory[] factories = {STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};

        static EntryFactory getFactory(Strength strength, boolean z16, boolean z17) {
            int i3;
            int i16 = 0;
            if (strength == Strength.WEAK) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            int i17 = i3 | (z16 ? 1 : 0);
            if (z17) {
                i16 = 2;
            }
            return factories[i17 | i16];
        }

        <K, V> void copyAccessEntry(com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
            hVar2.setAccessTime(hVar.getAccessTime());
            LocalCache.e(hVar.getPreviousInAccessQueue(), hVar2);
            LocalCache.e(hVar2, hVar.getNextInAccessQueue());
            LocalCache.z(hVar);
        }

        <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
            return newEntry(segment, hVar.getKey(), hVar.getHash(), hVar2);
        }

        <K, V> void copyWriteEntry(com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
            hVar2.setWriteTime(hVar.getWriteTime());
            LocalCache.f(hVar.getPreviousInWriteQueue(), hVar2);
            LocalCache.f(hVar2, hVar.getNextInWriteQueue());
            LocalCache.A(hVar);
        }

        abstract <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k3, int i3, @NullableDecl com.google.common.cache.h<K, V> hVar);

        /* synthetic */ EntryFactory(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements com.google.common.cache.f<K, V> {
        private static final long serialVersionUID = 1;

        @MonotonicNonNullDecl
        transient com.google.common.cache.f<K, V> autoDelegate;

        LoadingSerializationProxy(LocalCache<K, V> localCache) {
            super(localCache);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.autoDelegate = (com.google.common.cache.f<K, V>) recreateCacheBuilder().b(this.loader);
        }

        private Object readResolve() {
            return this.autoDelegate;
        }

        @Override // com.google.common.cache.f, com.google.common.base.d
        public final V apply(K k3) {
            return this.autoDelegate.apply(k3);
        }

        @Override // com.google.common.cache.f
        public V get(K k3) throws ExecutionException {
            return this.autoDelegate.get(k3);
        }

        @Override // com.google.common.cache.f
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.autoDelegate.getAll(iterable);
        }

        @Override // com.google.common.cache.f
        public V getUnchecked(K k3) {
            return this.autoDelegate.getUnchecked(k3);
        }

        @Override // com.google.common.cache.f
        public void refresh(K k3) {
            this.autoDelegate.refresh(k3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements com.google.common.cache.f<K, V> {
        private static final long serialVersionUID = 1;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super(new LocalCache(cacheBuilder, (CacheLoader) com.google.common.base.j.m(cacheLoader)), null);
        }

        @Override // com.google.common.cache.f, com.google.common.base.d
        public final V apply(K k3) {
            return getUnchecked(k3);
        }

        @Override // com.google.common.cache.f
        public V get(K k3) throws ExecutionException {
            return this.localCache.r(k3);
        }

        @Override // com.google.common.cache.f
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.localCache.n(iterable);
        }

        @Override // com.google.common.cache.f
        public V getUnchecked(K k3) {
            try {
                return get(k3);
            } catch (ExecutionException e16) {
                throw new UncheckedExecutionException(e16.getCause());
            }
        }

        @Override // com.google.common.cache.f
        public void refresh(K k3) {
            this.localCache.H(k3);
        }

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class LocalManualCache<K, V> implements com.google.common.cache.c<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> localCache;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a extends CacheLoader<Object, V> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Callable f34748d;

            a(Callable callable) {
                this.f34748d = callable;
            }

            @Override // com.google.common.cache.CacheLoader
            public V load(Object obj) throws Exception {
                return (V) this.f34748d.call();
            }
        }

        /* synthetic */ LocalManualCache(LocalCache localCache, a aVar) {
            this(localCache);
        }

        @Override // com.google.common.cache.c
        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        @Override // com.google.common.cache.c
        public void cleanUp() {
            this.localCache.d();
        }

        @Override // com.google.common.cache.c
        public V get(K k3, Callable<? extends V> callable) throws ExecutionException {
            com.google.common.base.j.m(callable);
            return this.localCache.m(k3, new a(callable));
        }

        @Override // com.google.common.cache.c
        public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
            return this.localCache.o(iterable);
        }

        @Override // com.google.common.cache.c
        @NullableDecl
        public V getIfPresent(Object obj) {
            return this.localCache.p(obj);
        }

        @Override // com.google.common.cache.c
        public void invalidate(Object obj) {
            com.google.common.base.j.m(obj);
            this.localCache.remove(obj);
        }

        @Override // com.google.common.cache.c
        public void invalidateAll(Iterable<?> iterable) {
            this.localCache.t(iterable);
        }

        @Override // com.google.common.cache.c
        public void put(K k3, V v3) {
            this.localCache.put(k3, v3);
        }

        @Override // com.google.common.cache.c
        public void putAll(Map<? extends K, ? extends V> map) {
            this.localCache.putAll(map);
        }

        @Override // com.google.common.cache.c
        public long size() {
            return this.localCache.w();
        }

        @Override // com.google.common.cache.c
        public com.google.common.cache.d stats() {
            com.google.common.cache.a aVar = new com.google.common.cache.a();
            aVar.g(this.localCache.N);
            for (Segment<K, V> segment : this.localCache.f34744f) {
                aVar.g(segment.statsCounter);
            }
            return aVar.e();
        }

        Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        @Override // com.google.common.cache.c
        public void invalidateAll() {
            this.localCache.clear();
        }

        LocalManualCache(LocalCache<K, V> localCache) {
            this.localCache = localCache;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class ManualSerializationProxy<K, V> extends com.google.common.cache.e<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        final int concurrencyLevel;

        @MonotonicNonNullDecl
        transient com.google.common.cache.c<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final CacheLoader<? super K, V> loader;
        final long maxWeight;
        final com.google.common.cache.i<? super K, ? super V> removalListener;

        @NullableDecl
        final com.google.common.base.q ticker;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;
        final com.google.common.cache.k<K, V> weigher;

        ManualSerializationProxy(LocalCache<K, V> localCache) {
            this(localCache.C, localCache.D, localCache.f34746i, localCache.f34747m, localCache.H, localCache.G, localCache.E, localCache.F, localCache.f34745h, localCache.K, localCache.L, localCache.P);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = (com.google.common.cache.c<K, V>) recreateCacheBuilder().a();
        }

        private Object readResolve() {
            return this.delegate;
        }

        CacheBuilder<K, V> recreateCacheBuilder() {
            CacheBuilder<K, V> cacheBuilder = (CacheBuilder<K, V>) CacheBuilder.y().A(this.keyStrength).B(this.valueStrength).v(this.keyEquivalence).D(this.valueEquivalence).e(this.concurrencyLevel).z(this.removalListener);
            cacheBuilder.f34721a = false;
            long j3 = this.expireAfterWriteNanos;
            if (j3 > 0) {
                cacheBuilder.g(j3, TimeUnit.NANOSECONDS);
            }
            long j16 = this.expireAfterAccessNanos;
            if (j16 > 0) {
                cacheBuilder.f(j16, TimeUnit.NANOSECONDS);
            }
            com.google.common.cache.k kVar = this.weigher;
            if (kVar != CacheBuilder.OneWeigher.INSTANCE) {
                cacheBuilder.E(kVar);
                long j17 = this.maxWeight;
                if (j17 != -1) {
                    cacheBuilder.x(j17);
                }
            } else {
                long j18 = this.maxWeight;
                if (j18 != -1) {
                    cacheBuilder.w(j18);
                }
            }
            com.google.common.base.q qVar = this.ticker;
            if (qVar != null) {
                cacheBuilder.C(qVar);
            }
            return cacheBuilder;
        }

        ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j3, long j16, long j17, com.google.common.cache.k<K, V> kVar, int i3, com.google.common.cache.i<? super K, ? super V> iVar, com.google.common.base.q qVar, CacheLoader<? super K, V> cacheLoader) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j3;
            this.expireAfterAccessNanos = j16;
            this.maxWeight = j17;
            this.weigher = kVar;
            this.concurrencyLevel = i3;
            this.removalListener = iVar;
            this.ticker = (qVar == com.google.common.base.q.b() || qVar == CacheBuilder.f34719t) ? null : qVar;
            this.loader = cacheLoader;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.cache.e, com.google.common.collect.o
        public com.google.common.cache.c<K, V> delegate() {
            return this.delegate;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.cache.LocalCache.Strength.1
            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, V v3, int i3) {
                if (i3 == 1) {
                    return new p(v3);
                }
                return new aa(v3, i3);
            }
        },
        SOFT { // from class: com.google.common.cache.LocalCache.Strength.2
            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, V v3, int i3) {
                if (i3 == 1) {
                    return new l(segment.valueReferenceQueue, v3, hVar);
                }
                return new z(segment.valueReferenceQueue, v3, hVar, i3);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.Strength.3
            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, V v3, int i3) {
                if (i3 == 1) {
                    return new x(segment.valueReferenceQueue, v3, hVar);
                }
                return new ab(segment.valueReferenceQueue, v3, hVar, i3);
            }
        };

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Equivalence<Object> defaultEquivalence();

        abstract <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, V v3, int i3);

        /* synthetic */ Strength(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class aa<K, V> extends p<K, V> {

        /* renamed from: e, reason: collision with root package name */
        final int f34754e;

        aa(V v3, int i3) {
            super(v3);
            this.f34754e = i3;
        }

        @Override // com.google.common.cache.LocalCache.p, com.google.common.cache.LocalCache.s
        public int c() {
            return this.f34754e;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class ab<K, V> extends x<K, V> {

        /* renamed from: e, reason: collision with root package name */
        final int f34755e;

        ab(ReferenceQueue<V> referenceQueue, V v3, com.google.common.cache.h<K, V> hVar, int i3) {
            super(referenceQueue, v3, hVar);
            this.f34755e = i3;
        }

        @Override // com.google.common.cache.LocalCache.x, com.google.common.cache.LocalCache.s
        public int c() {
            return this.f34755e;
        }

        @Override // com.google.common.cache.LocalCache.x, com.google.common.cache.LocalCache.s
        public s<K, V> e(ReferenceQueue<V> referenceQueue, V v3, com.google.common.cache.h<K, V> hVar) {
            return new ab(referenceQueue, v3, hVar, this.f34755e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public final class ad implements Map.Entry<K, V> {

        /* renamed from: d, reason: collision with root package name */
        final K f34761d;

        /* renamed from: e, reason: collision with root package name */
        V f34762e;

        ad(K k3, V v3) {
            this.f34761d = k3;
            this.f34762e = v3;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!this.f34761d.equals(entry.getKey()) || !this.f34762e.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f34761d;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f34762e;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f34761d.hashCode() ^ this.f34762e.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v3) {
            V v16 = (V) LocalCache.this.put(this.f34761d, v3);
            this.f34762e = v3;
            return v16;
        }

        public String toString() {
            return getKey() + ContainerUtils.KEY_VALUE_DELIMITER + getValue();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class b extends AbstractQueue<Object> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return ImmutableSet.of().iterator();
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    abstract class c<T> extends AbstractSet<T> {

        /* renamed from: d, reason: collision with root package name */
        @Weak
        final ConcurrentMap<?, ?> f34764d;

        c(ConcurrentMap<?, ?> concurrentMap) {
            this.f34764d = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f34764d.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f34764d.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f34764d.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return LocalCache.L(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.L(this).toArray(eArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static abstract class d<K, V> implements com.google.common.cache.h<K, V> {
        d() {
        }

        @Override // com.google.common.cache.h
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public s<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public void setAccessTime(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public void setNextInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public void setNextInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public void setPreviousInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public void setPreviousInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public void setValueReference(s<K, V> sVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public void setWriteTime(long j3) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    final class f extends LocalCache<K, V>.h<Map.Entry<K, V>> {
        f() {
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
    final class g extends LocalCache<K, V>.c<Map.Entry<K, V>> {
        g(ConcurrentMap<?, ?> concurrentMap) {
            super(concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (obj2 = LocalCache.this.get(key)) == null || !LocalCache.this.f34747m.equivalent(entry.getValue(), obj2)) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || !LocalCache.this.remove(key, entry.getValue())) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public abstract class h<T> implements Iterator<T> {

        @NullableDecl
        LocalCache<K, V>.ad C;

        /* renamed from: d, reason: collision with root package name */
        int f34772d;

        /* renamed from: e, reason: collision with root package name */
        int f34773e = -1;

        /* renamed from: f, reason: collision with root package name */
        @MonotonicNonNullDecl
        Segment<K, V> f34774f;

        /* renamed from: h, reason: collision with root package name */
        @MonotonicNonNullDecl
        AtomicReferenceArray<com.google.common.cache.h<K, V>> f34775h;

        /* renamed from: i, reason: collision with root package name */
        @NullableDecl
        com.google.common.cache.h<K, V> f34776i;

        /* renamed from: m, reason: collision with root package name */
        @NullableDecl
        LocalCache<K, V>.ad f34777m;

        h() {
            this.f34772d = LocalCache.this.f34744f.length - 1;
            a();
        }

        final void a() {
            this.f34777m = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i3 = this.f34772d;
                if (i3 >= 0) {
                    Segment<K, V>[] segmentArr = LocalCache.this.f34744f;
                    this.f34772d = i3 - 1;
                    Segment<K, V> segment = segmentArr[i3];
                    this.f34774f = segment;
                    if (segment.count != 0) {
                        this.f34775h = this.f34774f.table;
                        this.f34773e = r0.length() - 1;
                        if (e()) {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }

        boolean b(com.google.common.cache.h<K, V> hVar) {
            try {
                long a16 = LocalCache.this.L.a();
                K key = hVar.getKey();
                Object q16 = LocalCache.this.q(hVar, a16);
                if (q16 != null) {
                    this.f34777m = new ad(key, q16);
                    this.f34774f.postReadCleanup();
                    return true;
                }
                this.f34774f.postReadCleanup();
                return false;
            } catch (Throwable th5) {
                this.f34774f.postReadCleanup();
                throw th5;
            }
        }

        LocalCache<K, V>.ad c() {
            LocalCache<K, V>.ad adVar = this.f34777m;
            if (adVar != null) {
                this.C = adVar;
                a();
                return this.C;
            }
            throw new NoSuchElementException();
        }

        boolean d() {
            com.google.common.cache.h<K, V> hVar = this.f34776i;
            if (hVar == null) {
                return false;
            }
            while (true) {
                this.f34776i = hVar.getNext();
                com.google.common.cache.h<K, V> hVar2 = this.f34776i;
                if (hVar2 != null) {
                    if (b(hVar2)) {
                        return true;
                    }
                    hVar = this.f34776i;
                } else {
                    return false;
                }
            }
        }

        boolean e() {
            while (true) {
                int i3 = this.f34773e;
                if (i3 >= 0) {
                    AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.f34775h;
                    this.f34773e = i3 - 1;
                    com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(i3);
                    this.f34776i = hVar;
                    if (hVar != null && (b(hVar) || d())) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f34777m != null) {
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
            com.google.common.base.j.s(z16);
            LocalCache.this.remove(this.C.getKey());
            this.C = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    final class i extends LocalCache<K, V>.h<K> {
        i() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    final class j extends LocalCache<K, V>.c<K> {
        j(ConcurrentMap<?, ?> concurrentMap) {
            super(concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f34764d.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new i();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (this.f34764d.remove(obj) != null) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class k<K, V> implements s<K, V> {

        /* renamed from: d, reason: collision with root package name */
        volatile s<K, V> f34779d;

        /* renamed from: e, reason: collision with root package name */
        final com.google.common.util.concurrent.t<V> f34780e;

        /* renamed from: f, reason: collision with root package name */
        final com.google.common.base.m f34781f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public class a implements com.google.common.base.d<V, V> {
            a() {
            }

            @Override // com.google.common.base.d
            public V apply(V v3) {
                k.this.j(v3);
                return v3;
            }
        }

        public k() {
            this(LocalCache.M());
        }

        private com.google.common.util.concurrent.q<V> g(Throwable th5) {
            return Futures.b(th5);
        }

        @Override // com.google.common.cache.LocalCache.s
        public com.google.common.cache.h<K, V> a() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(@NullableDecl V v3) {
            if (v3 != null) {
                j(v3);
            } else {
                this.f34779d = LocalCache.M();
            }
        }

        @Override // com.google.common.cache.LocalCache.s
        public int c() {
            return this.f34779d.c();
        }

        @Override // com.google.common.cache.LocalCache.s
        public V d() throws ExecutionException {
            return (V) com.google.common.util.concurrent.v.a(this.f34780e);
        }

        public long f() {
            return this.f34781f.e(TimeUnit.NANOSECONDS);
        }

        @Override // com.google.common.cache.LocalCache.s
        public V get() {
            return this.f34779d.get();
        }

        public s<K, V> h() {
            return this.f34779d;
        }

        public com.google.common.util.concurrent.q<V> i(K k3, CacheLoader<? super K, V> cacheLoader) {
            com.google.common.util.concurrent.q<V> g16;
            try {
                this.f34781f.g();
                V v3 = this.f34779d.get();
                if (v3 == null) {
                    V load = cacheLoader.load(k3);
                    if (j(load)) {
                        return this.f34780e;
                    }
                    return Futures.c(load);
                }
                com.google.common.util.concurrent.q<V> reload = cacheLoader.reload(k3, v3);
                if (reload == null) {
                    return Futures.c(null);
                }
                return Futures.d(reload, new a(), MoreExecutors.a());
            } catch (Throwable th5) {
                if (k(th5)) {
                    g16 = this.f34780e;
                } else {
                    g16 = g(th5);
                }
                if (th5 instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return g16;
            }
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return this.f34779d.isActive();
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return true;
        }

        public boolean j(@NullableDecl V v3) {
            return this.f34780e.D(v3);
        }

        public boolean k(Throwable th5) {
            return this.f34780e.E(th5);
        }

        public k(s<K, V> sVar) {
            this.f34780e = com.google.common.util.concurrent.t.I();
            this.f34781f = com.google.common.base.m.d();
            this.f34779d = sVar;
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<K, V> e(ReferenceQueue<V> referenceQueue, @NullableDecl V v3, com.google.common.cache.h<K, V> hVar) {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class m<K, V> extends o<K, V> {
        com.google.common.cache.h<K, V> C;

        /* renamed from: i, reason: collision with root package name */
        volatile long f34784i;

        /* renamed from: m, reason: collision with root package name */
        com.google.common.cache.h<K, V> f34785m;

        m(K k3, int i3, @NullableDecl com.google.common.cache.h<K, V> hVar) {
            super(k3, i3, hVar);
            this.f34784i = Long.MAX_VALUE;
            this.f34785m = LocalCache.y();
            this.C = LocalCache.y();
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public long getAccessTime() {
            return this.f34784i;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInAccessQueue() {
            return this.f34785m;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInAccessQueue() {
            return this.C;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setAccessTime(long j3) {
            this.f34784i = j3;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setNextInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            this.f34785m = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setPreviousInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            this.C = hVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class n<K, V> extends o<K, V> {
        com.google.common.cache.h<K, V> C;
        volatile long D;
        com.google.common.cache.h<K, V> E;
        com.google.common.cache.h<K, V> F;

        /* renamed from: i, reason: collision with root package name */
        volatile long f34786i;

        /* renamed from: m, reason: collision with root package name */
        com.google.common.cache.h<K, V> f34787m;

        n(K k3, int i3, @NullableDecl com.google.common.cache.h<K, V> hVar) {
            super(k3, i3, hVar);
            this.f34786i = Long.MAX_VALUE;
            this.f34787m = LocalCache.y();
            this.C = LocalCache.y();
            this.D = Long.MAX_VALUE;
            this.E = LocalCache.y();
            this.F = LocalCache.y();
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public long getAccessTime() {
            return this.f34786i;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInAccessQueue() {
            return this.f34787m;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInWriteQueue() {
            return this.E;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInAccessQueue() {
            return this.C;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInWriteQueue() {
            return this.F;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public long getWriteTime() {
            return this.D;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setAccessTime(long j3) {
            this.f34786i = j3;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setNextInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            this.f34787m = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setNextInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            this.E = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setPreviousInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            this.C = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setPreviousInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            this.F = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setWriteTime(long j3) {
            this.D = j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class o<K, V> extends d<K, V> {

        /* renamed from: d, reason: collision with root package name */
        final K f34788d;

        /* renamed from: e, reason: collision with root package name */
        final int f34789e;

        /* renamed from: f, reason: collision with root package name */
        @NullableDecl
        final com.google.common.cache.h<K, V> f34790f;

        /* renamed from: h, reason: collision with root package name */
        volatile s<K, V> f34791h = LocalCache.M();

        o(K k3, int i3, @NullableDecl com.google.common.cache.h<K, V> hVar) {
            this.f34788d = k3;
            this.f34789e = i3;
            this.f34790f = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public int getHash() {
            return this.f34789e;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public K getKey() {
            return this.f34788d;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNext() {
            return this.f34790f;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public s<K, V> getValueReference() {
            return this.f34791h;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setValueReference(s<K, V> sVar) {
            this.f34791h = sVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class q<K, V> extends o<K, V> {
        com.google.common.cache.h<K, V> C;

        /* renamed from: i, reason: collision with root package name */
        volatile long f34793i;

        /* renamed from: m, reason: collision with root package name */
        com.google.common.cache.h<K, V> f34794m;

        q(K k3, int i3, @NullableDecl com.google.common.cache.h<K, V> hVar) {
            super(k3, i3, hVar);
            this.f34793i = Long.MAX_VALUE;
            this.f34794m = LocalCache.y();
            this.C = LocalCache.y();
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInWriteQueue() {
            return this.f34794m;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInWriteQueue() {
            return this.C;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public long getWriteTime() {
            return this.f34793i;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setNextInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            this.f34794m = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setPreviousInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            this.C = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setWriteTime(long j3) {
            this.f34793i = j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    final class r extends LocalCache<K, V>.h<V> {
        r() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface s<K, V> {
        @NullableDecl
        com.google.common.cache.h<K, V> a();

        void b(@NullableDecl V v3);

        int c();

        V d() throws ExecutionException;

        s<K, V> e(ReferenceQueue<V> referenceQueue, @NullableDecl V v3, com.google.common.cache.h<K, V> hVar);

        @NullableDecl
        V get();

        boolean isActive();

        boolean isLoading();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    final class t extends AbstractCollection<V> {

        /* renamed from: d, reason: collision with root package name */
        private final ConcurrentMap<?, ?> f34795d;

        t(ConcurrentMap<?, ?> concurrentMap) {
            this.f34795d = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f34795d.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f34795d.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f34795d.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new r();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f34795d.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return LocalCache.L(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.L(this).toArray(eArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class u<K, V> extends w<K, V> {

        /* renamed from: h, reason: collision with root package name */
        volatile long f34797h;

        /* renamed from: i, reason: collision with root package name */
        com.google.common.cache.h<K, V> f34798i;

        /* renamed from: m, reason: collision with root package name */
        com.google.common.cache.h<K, V> f34799m;

        u(ReferenceQueue<K> referenceQueue, K k3, int i3, @NullableDecl com.google.common.cache.h<K, V> hVar) {
            super(referenceQueue, k3, i3, hVar);
            this.f34797h = Long.MAX_VALUE;
            this.f34798i = LocalCache.y();
            this.f34799m = LocalCache.y();
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public long getAccessTime() {
            return this.f34797h;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInAccessQueue() {
            return this.f34798i;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInAccessQueue() {
            return this.f34799m;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setAccessTime(long j3) {
            this.f34797h = j3;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setNextInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            this.f34798i = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setPreviousInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            this.f34799m = hVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class v<K, V> extends w<K, V> {
        volatile long C;
        com.google.common.cache.h<K, V> D;
        com.google.common.cache.h<K, V> E;

        /* renamed from: h, reason: collision with root package name */
        volatile long f34800h;

        /* renamed from: i, reason: collision with root package name */
        com.google.common.cache.h<K, V> f34801i;

        /* renamed from: m, reason: collision with root package name */
        com.google.common.cache.h<K, V> f34802m;

        v(ReferenceQueue<K> referenceQueue, K k3, int i3, @NullableDecl com.google.common.cache.h<K, V> hVar) {
            super(referenceQueue, k3, i3, hVar);
            this.f34800h = Long.MAX_VALUE;
            this.f34801i = LocalCache.y();
            this.f34802m = LocalCache.y();
            this.C = Long.MAX_VALUE;
            this.D = LocalCache.y();
            this.E = LocalCache.y();
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public long getAccessTime() {
            return this.f34800h;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInAccessQueue() {
            return this.f34801i;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInWriteQueue() {
            return this.D;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInAccessQueue() {
            return this.f34802m;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInWriteQueue() {
            return this.E;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public long getWriteTime() {
            return this.C;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setAccessTime(long j3) {
            this.f34800h = j3;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setNextInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            this.f34801i = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setNextInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            this.D = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setPreviousInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            this.f34802m = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setPreviousInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            this.E = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setWriteTime(long j3) {
            this.C = j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class w<K, V> extends WeakReference<K> implements com.google.common.cache.h<K, V> {

        /* renamed from: d, reason: collision with root package name */
        final int f34803d;

        /* renamed from: e, reason: collision with root package name */
        @NullableDecl
        final com.google.common.cache.h<K, V> f34804e;

        /* renamed from: f, reason: collision with root package name */
        volatile s<K, V> f34805f;

        w(ReferenceQueue<K> referenceQueue, K k3, int i3, @NullableDecl com.google.common.cache.h<K, V> hVar) {
            super(k3, referenceQueue);
            this.f34805f = LocalCache.M();
            this.f34803d = i3;
            this.f34804e = hVar;
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public int getHash() {
            return this.f34803d;
        }

        @Override // com.google.common.cache.h
        public K getKey() {
            return get();
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNext() {
            return this.f34804e;
        }

        public com.google.common.cache.h<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public com.google.common.cache.h<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public com.google.common.cache.h<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public com.google.common.cache.h<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public s<K, V> getValueReference() {
            return this.f34805f;
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j3) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public void setValueReference(s<K, V> sVar) {
            this.f34805f = sVar;
        }

        public void setWriteTime(long j3) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class y<K, V> extends w<K, V> {

        /* renamed from: h, reason: collision with root package name */
        volatile long f34807h;

        /* renamed from: i, reason: collision with root package name */
        com.google.common.cache.h<K, V> f34808i;

        /* renamed from: m, reason: collision with root package name */
        com.google.common.cache.h<K, V> f34809m;

        y(ReferenceQueue<K> referenceQueue, K k3, int i3, @NullableDecl com.google.common.cache.h<K, V> hVar) {
            super(referenceQueue, k3, i3, hVar);
            this.f34807h = Long.MAX_VALUE;
            this.f34808i = LocalCache.y();
            this.f34809m = LocalCache.y();
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInWriteQueue() {
            return this.f34808i;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInWriteQueue() {
            return this.f34809m;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public long getWriteTime() {
            return this.f34807h;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setNextInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            this.f34808i = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setPreviousInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            this.f34809m = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setWriteTime(long j3) {
            this.f34807h = j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class z<K, V> extends l<K, V> {

        /* renamed from: e, reason: collision with root package name */
        final int f34810e;

        z(ReferenceQueue<V> referenceQueue, V v3, com.google.common.cache.h<K, V> hVar, int i3) {
            super(referenceQueue, v3, hVar);
            this.f34810e = i3;
        }

        @Override // com.google.common.cache.LocalCache.l, com.google.common.cache.LocalCache.s
        public int c() {
            return this.f34810e;
        }

        @Override // com.google.common.cache.LocalCache.l, com.google.common.cache.LocalCache.s
        public s<K, V> e(ReferenceQueue<V> referenceQueue, V v3, com.google.common.cache.h<K, V> hVar) {
            return new z(referenceQueue, v3, hVar, this.f34810e);
        }
    }

    LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, @NullableDecl CacheLoader<? super K, V> cacheLoader) {
        Queue<RemovalNotification<K, V>> concurrentLinkedQueue;
        this.f34745h = Math.min(cacheBuilder.h(), 65536);
        Strength m3 = cacheBuilder.m();
        this.C = m3;
        this.D = cacheBuilder.t();
        this.f34746i = cacheBuilder.l();
        this.f34747m = cacheBuilder.s();
        long n3 = cacheBuilder.n();
        this.E = n3;
        this.F = (com.google.common.cache.k<K, V>) cacheBuilder.u();
        this.G = cacheBuilder.i();
        this.H = cacheBuilder.j();
        this.I = cacheBuilder.o();
        CacheBuilder.NullListener nullListener = (com.google.common.cache.i<K, V>) cacheBuilder.p();
        this.K = nullListener;
        if (nullListener == CacheBuilder.NullListener.INSTANCE) {
            concurrentLinkedQueue = i();
        } else {
            concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        }
        this.J = concurrentLinkedQueue;
        this.L = cacheBuilder.r(F());
        this.M = EntryFactory.getFactory(m3, N(), R());
        this.N = cacheBuilder.q().get();
        this.P = cacheLoader;
        int min = Math.min(cacheBuilder.k(), 1073741824);
        if (j() && !h()) {
            min = (int) Math.min(min, n3);
        }
        int i3 = 0;
        int i16 = 1;
        int i17 = 0;
        int i18 = 1;
        while (i18 < this.f34745h && (!j() || i18 * 20 <= this.E)) {
            i17++;
            i18 <<= 1;
        }
        this.f34743e = 32 - i17;
        this.f34742d = i18 - 1;
        this.f34744f = x(i18);
        int i19 = min / i18;
        while (i16 < (i19 * i18 < min ? i19 + 1 : i19)) {
            i16 <<= 1;
        }
        if (j()) {
            long j3 = this.E;
            long j16 = i18;
            long j17 = (j3 / j16) + 1;
            long j18 = j3 % j16;
            while (true) {
                Segment<K, V>[] segmentArr = this.f34744f;
                if (i3 < segmentArr.length) {
                    if (i3 == j18) {
                        j17--;
                    }
                    segmentArr[i3] = g(i16, j17, cacheBuilder.q().get());
                    i3++;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                Segment<K, V>[] segmentArr2 = this.f34744f;
                if (i3 < segmentArr2.length) {
                    segmentArr2[i3] = g(i16, -1L, cacheBuilder.q().get());
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    static <K, V> void A(com.google.common.cache.h<K, V> hVar) {
        com.google.common.cache.h<K, V> y16 = y();
        hVar.setNextInWriteQueue(y16);
        hVar.setPreviousInWriteQueue(y16);
    }

    static int J(int i3) {
        int i16 = i3 + ((i3 << 15) ^ (-12931));
        int i17 = i16 ^ (i16 >>> 10);
        int i18 = i17 + (i17 << 3);
        int i19 = i18 ^ (i18 >>> 6);
        int i26 = i19 + (i19 << 2) + (i19 << 14);
        return i26 ^ (i26 >>> 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ArrayList<E> L(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        com.google.common.collect.r.a(arrayList, collection.iterator());
        return arrayList;
    }

    static <K, V> s<K, V> M() {
        return (s<K, V>) U;
    }

    static <K, V> void e(com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
        hVar.setNextInAccessQueue(hVar2);
        hVar2.setPreviousInAccessQueue(hVar);
    }

    static <K, V> void f(com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
        hVar.setNextInWriteQueue(hVar2);
        hVar2.setPreviousInWriteQueue(hVar);
    }

    static <E> Queue<E> i() {
        return (Queue<E>) V;
    }

    static <K, V> com.google.common.cache.h<K, V> y() {
        return NullEntry.INSTANCE;
    }

    static <K, V> void z(com.google.common.cache.h<K, V> hVar) {
        com.google.common.cache.h<K, V> y16 = y();
        hVar.setNextInAccessQueue(y16);
        hVar.setPreviousInAccessQueue(y16);
    }

    void B() {
        while (true) {
            RemovalNotification<K, V> poll = this.J.poll();
            if (poll != null) {
                try {
                    this.K.onRemoval(poll);
                } catch (Throwable th5) {
                    T.log(Level.WARNING, "Exception thrown by removal listener", th5);
                }
            } else {
                return;
            }
        }
    }

    void C(com.google.common.cache.h<K, V> hVar) {
        int hash = hVar.getHash();
        K(hash).reclaimKey(hVar, hash);
    }

    void D(s<K, V> sVar) {
        com.google.common.cache.h<K, V> a16 = sVar.a();
        int hash = a16.getHash();
        K(hash).reclaimValue(a16.getKey(), hash, sVar);
    }

    boolean E() {
        return k();
    }

    boolean F() {
        if (!G() && !E()) {
            return false;
        }
        return true;
    }

    boolean G() {
        if (!l() && !I()) {
            return false;
        }
        return true;
    }

    void H(K k3) {
        int s16 = s(com.google.common.base.j.m(k3));
        K(s16).refresh(k3, s16, this.P, false);
    }

    boolean I() {
        if (this.I > 0) {
            return true;
        }
        return false;
    }

    Segment<K, V> K(int i3) {
        return this.f34744f[(i3 >>> this.f34743e) & this.f34742d];
    }

    boolean N() {
        if (!O() && !E()) {
            return false;
        }
        return true;
    }

    boolean O() {
        if (!k() && !j()) {
            return false;
        }
        return true;
    }

    boolean P() {
        if (this.C != Strength.STRONG) {
            return true;
        }
        return false;
    }

    boolean Q() {
        if (this.D != Strength.STRONG) {
            return true;
        }
        return false;
    }

    boolean R() {
        if (!S() && !G()) {
            return false;
        }
        return true;
    }

    boolean S() {
        return l();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V> segment : this.f34744f) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        int s16 = s(obj);
        return K(s16).containsKey(obj, s16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        boolean z16 = false;
        if (obj == null) {
            return false;
        }
        long a16 = this.L.a();
        Segment<K, V>[] segmentArr = this.f34744f;
        long j3 = -1;
        int i3 = 0;
        while (i3 < 3) {
            int length = segmentArr.length;
            long j16 = 0;
            for (?? r122 = z16; r122 < length; r122++) {
                Segment<K, V> segment = segmentArr[r122];
                int i16 = segment.count;
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = segment.table;
                for (?? r152 = z16; r152 < atomicReferenceArray.length(); r152++) {
                    com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(r152);
                    while (hVar != null) {
                        Segment<K, V>[] segmentArr2 = segmentArr;
                        V liveValue = segment.getLiveValue(hVar, a16);
                        long j17 = a16;
                        if (liveValue != null && this.f34747m.equivalent(obj, liveValue)) {
                            return true;
                        }
                        hVar = hVar.getNext();
                        segmentArr = segmentArr2;
                        a16 = j17;
                    }
                }
                j16 += segment.modCount;
                a16 = a16;
                z16 = false;
            }
            long j18 = a16;
            Segment<K, V>[] segmentArr3 = segmentArr;
            if (j16 == j3) {
                return false;
            }
            i3++;
            j3 = j16;
            segmentArr = segmentArr3;
            a16 = j18;
            z16 = false;
        }
        return z16;
    }

    public void d() {
        for (Segment<K, V> segment : this.f34744f) {
            segment.cleanUp();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @GwtIncompatible
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.S;
        if (set == null) {
            g gVar = new g(this);
            this.S = gVar;
            return gVar;
        }
        return set;
    }

    Segment<K, V> g(int i3, long j3, com.google.common.cache.b bVar) {
        return new Segment<>(this, i3, j3, bVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int s16 = s(obj);
        return K(s16).get(obj, s16);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @NullableDecl
    public V getOrDefault(@NullableDecl Object obj, @NullableDecl V v3) {
        V v16 = get(obj);
        if (v16 != null) {
            return v16;
        }
        return v3;
    }

    boolean h() {
        if (this.F != CacheBuilder.OneWeigher.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.f34744f;
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

    boolean j() {
        if (this.E >= 0) {
            return true;
        }
        return false;
    }

    boolean k() {
        if (this.G > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.Q;
        if (set == null) {
            j jVar = new j(this);
            this.Q = jVar;
            return jVar;
        }
        return set;
    }

    boolean l() {
        if (this.H > 0) {
            return true;
        }
        return false;
    }

    V m(K k3, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        int s16 = s(com.google.common.base.j.m(k3));
        return K(s16).get(k3, s16, cacheLoader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    ImmutableMap<K, V> n(Iterable<? extends K> iterable) throws ExecutionException {
        LinkedHashMap k3 = Maps.k();
        LinkedHashSet g16 = com.google.common.collect.ab.g();
        int i3 = 0;
        int i16 = 0;
        for (K k16 : iterable) {
            Object obj = get(k16);
            if (!k3.containsKey(k16)) {
                k3.put(k16, obj);
                if (obj == null) {
                    i16++;
                    g16.add(k16);
                } else {
                    i3++;
                }
            }
        }
        try {
            if (!g16.isEmpty()) {
                try {
                    Map v3 = v(g16, this.P);
                    for (Object obj2 : g16) {
                        Object obj3 = v3.get(obj2);
                        if (obj3 != null) {
                            k3.put(obj2, obj3);
                        } else {
                            throw new CacheLoader.InvalidCacheLoadException("loadAll failed to return a value for " + obj2);
                        }
                    }
                } catch (CacheLoader.UnsupportedLoadingOperationException unused) {
                    for (Object obj4 : g16) {
                        i16--;
                        k3.put(obj4, m(obj4, this.P));
                    }
                }
            }
            return ImmutableMap.copyOf((Map) k3);
        } finally {
            this.N.a(i3);
            this.N.d(i16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    ImmutableMap<K, V> o(Iterable<?> iterable) {
        LinkedHashMap k3 = Maps.k();
        int i3 = 0;
        int i16 = 0;
        for (Object obj : iterable) {
            V v3 = get(obj);
            if (v3 == null) {
                i16++;
            } else {
                k3.put(obj, v3);
                i3++;
            }
        }
        this.N.a(i3);
        this.N.d(i16);
        return ImmutableMap.copyOf((Map) k3);
    }

    @NullableDecl
    public V p(Object obj) {
        int s16 = s(com.google.common.base.j.m(obj));
        V v3 = K(s16).get(obj, s16);
        if (v3 == null) {
            this.N.d(1);
        } else {
            this.N.a(1);
        }
        return v3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k3, V v3) {
        com.google.common.base.j.m(k3);
        com.google.common.base.j.m(v3);
        int s16 = s(k3);
        return K(s16).put(k3, s16, v3, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k3, V v3) {
        com.google.common.base.j.m(k3);
        com.google.common.base.j.m(v3);
        int s16 = s(k3);
        return K(s16).put(k3, s16, v3, true);
    }

    @NullableDecl
    V q(com.google.common.cache.h<K, V> hVar, long j3) {
        V v3;
        if (hVar.getKey() == null || (v3 = hVar.getValueReference().get()) == null || u(hVar, j3)) {
            return null;
        }
        return v3;
    }

    V r(K k3) throws ExecutionException {
        return m(k3, this.P);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int s16 = s(obj);
        return K(s16).remove(obj, s16);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k3, @NullableDecl V v3, V v16) {
        com.google.common.base.j.m(k3);
        com.google.common.base.j.m(v16);
        if (v3 == null) {
            return false;
        }
        int s16 = s(k3);
        return K(s16).replace(k3, s16, v3, v16);
    }

    int s(@NullableDecl Object obj) {
        return J(this.f34746i.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return s1.c.b(w());
    }

    void t(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    boolean u(com.google.common.cache.h<K, V> hVar, long j3) {
        com.google.common.base.j.m(hVar);
        if (k() && j3 - hVar.getAccessTime() >= this.G) {
            return true;
        }
        if (l() && j3 - hVar.getWriteTime() >= this.H) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00bb  */
    @NullableDecl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    Map<K, V> v(Set<? extends K> set, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        com.google.common.base.j.m(cacheLoader);
        com.google.common.base.j.m(set);
        com.google.common.base.m c16 = com.google.common.base.m.c();
        boolean z16 = true;
        boolean z17 = false;
        try {
            try {
                try {
                    try {
                        try {
                            Map<? super K, V> loadAll = cacheLoader.loadAll(set);
                            if (loadAll != null) {
                                c16.h();
                                for (Map.Entry<K, V> entry : loadAll.entrySet()) {
                                    K key = entry.getKey();
                                    V value = entry.getValue();
                                    if (key != null && value != null) {
                                        put(key, value);
                                    } else {
                                        z17 = true;
                                    }
                                }
                                if (!z17) {
                                    this.N.c(c16.e(TimeUnit.NANOSECONDS));
                                    return loadAll;
                                }
                                this.N.f(c16.e(TimeUnit.NANOSECONDS));
                                throw new CacheLoader.InvalidCacheLoadException(cacheLoader + " returned null keys or values from loadAll");
                            }
                            this.N.f(c16.e(TimeUnit.NANOSECONDS));
                            throw new CacheLoader.InvalidCacheLoadException(cacheLoader + " returned null map from loadAll");
                        } catch (CacheLoader.UnsupportedLoadingOperationException e16) {
                            try {
                                throw e16;
                            } catch (Throwable th5) {
                                th = th5;
                                if (!z16) {
                                }
                                throw th;
                            }
                        } catch (RuntimeException e17) {
                            throw new UncheckedExecutionException(e17);
                        }
                    } catch (Error e18) {
                        throw new ExecutionError(e18);
                    }
                } catch (InterruptedException e19) {
                    Thread.currentThread().interrupt();
                    throw new ExecutionException(e19);
                }
            } catch (Exception e26) {
                throw new ExecutionException(e26);
            }
        } catch (Throwable th6) {
            th = th6;
            z16 = false;
            if (!z16) {
                this.N.f(c16.e(TimeUnit.NANOSECONDS));
            }
            throw th;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.R;
        if (collection == null) {
            t tVar = new t(this);
            this.R = tVar;
            return tVar;
        }
        return collection;
    }

    long w() {
        long j3 = 0;
        for (int i3 = 0; i3 < this.f34744f.length; i3++) {
            j3 += Math.max(0, r0[i3].count);
        }
        return j3;
    }

    final Segment<K, V>[] x(int i3) {
        return new Segment[i3];
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int s16 = s(obj);
        return K(s16).remove(obj, s16, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k3, V v3) {
        com.google.common.base.j.m(k3);
        com.google.common.base.j.m(v3);
        int s16 = s(k3);
        return K(s16).replace(k3, s16, v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum NullEntry implements com.google.common.cache.h<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.h
        public long getAccessTime() {
            return 0L;
        }

        @Override // com.google.common.cache.h
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.cache.h
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.common.cache.h
        public s<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.google.common.cache.h
        public long getWriteTime() {
            return 0L;
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.h
        public void setAccessTime(long j3) {
        }

        @Override // com.google.common.cache.h
        public void setNextInAccessQueue(com.google.common.cache.h<Object, Object> hVar) {
        }

        @Override // com.google.common.cache.h
        public void setNextInWriteQueue(com.google.common.cache.h<Object, Object> hVar) {
        }

        @Override // com.google.common.cache.h
        public void setPreviousInAccessQueue(com.google.common.cache.h<Object, Object> hVar) {
        }

        @Override // com.google.common.cache.h
        public void setPreviousInWriteQueue(com.google.common.cache.h<Object, Object> hVar) {
        }

        @Override // com.google.common.cache.h
        public void setValueReference(s<Object, Object> sVar) {
        }

        @Override // com.google.common.cache.h
        public void setWriteTime(long j3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class ac<K, V> extends AbstractQueue<com.google.common.cache.h<K, V>> {

        /* renamed from: d, reason: collision with root package name */
        final com.google.common.cache.h<K, V> f34756d = new a();

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class b extends com.google.common.collect.e<com.google.common.cache.h<K, V>> {
            b(com.google.common.cache.h hVar) {
                super(hVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.e
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.common.cache.h<K, V> a(com.google.common.cache.h<K, V> hVar) {
                com.google.common.cache.h<K, V> nextInWriteQueue = hVar.getNextInWriteQueue();
                if (nextInWriteQueue == ac.this.f34756d) {
                    return null;
                }
                return nextInWriteQueue;
            }
        }

        ac() {
        }

        @Override // java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(com.google.common.cache.h<K, V> hVar) {
            LocalCache.f(hVar.getPreviousInWriteQueue(), hVar.getNextInWriteQueue());
            LocalCache.f(this.f34756d.getPreviousInWriteQueue(), hVar);
            LocalCache.f(hVar, this.f34756d);
            return true;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            com.google.common.cache.h<K, V> nextInWriteQueue = this.f34756d.getNextInWriteQueue();
            while (true) {
                com.google.common.cache.h<K, V> hVar = this.f34756d;
                if (nextInWriteQueue != hVar) {
                    com.google.common.cache.h<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    LocalCache.A(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                } else {
                    hVar.setNextInWriteQueue(hVar);
                    com.google.common.cache.h<K, V> hVar2 = this.f34756d;
                    hVar2.setPreviousInWriteQueue(hVar2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (((com.google.common.cache.h) obj).getNextInWriteQueue() != NullEntry.INSTANCE) {
                return true;
            }
            return false;
        }

        @Override // java.util.Queue
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.h<K, V> peek() {
            com.google.common.cache.h<K, V> nextInWriteQueue = this.f34756d.getNextInWriteQueue();
            if (nextInWriteQueue == this.f34756d) {
                return null;
            }
            return nextInWriteQueue;
        }

        @Override // java.util.Queue
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.h<K, V> poll() {
            com.google.common.cache.h<K, V> nextInWriteQueue = this.f34756d.getNextInWriteQueue();
            if (nextInWriteQueue == this.f34756d) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.f34756d.getNextInWriteQueue() == this.f34756d) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<com.google.common.cache.h<K, V>> iterator() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            com.google.common.cache.h hVar = (com.google.common.cache.h) obj;
            com.google.common.cache.h<K, V> previousInWriteQueue = hVar.getPreviousInWriteQueue();
            com.google.common.cache.h<K, V> nextInWriteQueue = hVar.getNextInWriteQueue();
            LocalCache.f(previousInWriteQueue, nextInWriteQueue);
            LocalCache.A(hVar);
            if (nextInWriteQueue != NullEntry.INSTANCE) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i3 = 0;
            for (com.google.common.cache.h<K, V> nextInWriteQueue = this.f34756d.getNextInWriteQueue(); nextInWriteQueue != this.f34756d; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i3++;
            }
            return i3;
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a extends d<K, V> {

            /* renamed from: d, reason: collision with root package name */
            com.google.common.cache.h<K, V> f34757d = this;

            /* renamed from: e, reason: collision with root package name */
            com.google.common.cache.h<K, V> f34758e = this;

            a() {
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public com.google.common.cache.h<K, V> getNextInWriteQueue() {
                return this.f34757d;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public com.google.common.cache.h<K, V> getPreviousInWriteQueue() {
                return this.f34758e;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public void setNextInWriteQueue(com.google.common.cache.h<K, V> hVar) {
                this.f34757d = hVar;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public void setPreviousInWriteQueue(com.google.common.cache.h<K, V> hVar) {
                this.f34758e = hVar;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public void setWriteTime(long j3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class e<K, V> extends AbstractQueue<com.google.common.cache.h<K, V>> {

        /* renamed from: d, reason: collision with root package name */
        final com.google.common.cache.h<K, V> f34766d = new a();

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class b extends com.google.common.collect.e<com.google.common.cache.h<K, V>> {
            b(com.google.common.cache.h hVar) {
                super(hVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.e
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.common.cache.h<K, V> a(com.google.common.cache.h<K, V> hVar) {
                com.google.common.cache.h<K, V> nextInAccessQueue = hVar.getNextInAccessQueue();
                if (nextInAccessQueue == e.this.f34766d) {
                    return null;
                }
                return nextInAccessQueue;
            }
        }

        e() {
        }

        @Override // java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(com.google.common.cache.h<K, V> hVar) {
            LocalCache.e(hVar.getPreviousInAccessQueue(), hVar.getNextInAccessQueue());
            LocalCache.e(this.f34766d.getPreviousInAccessQueue(), hVar);
            LocalCache.e(hVar, this.f34766d);
            return true;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            com.google.common.cache.h<K, V> nextInAccessQueue = this.f34766d.getNextInAccessQueue();
            while (true) {
                com.google.common.cache.h<K, V> hVar = this.f34766d;
                if (nextInAccessQueue != hVar) {
                    com.google.common.cache.h<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    LocalCache.z(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                } else {
                    hVar.setNextInAccessQueue(hVar);
                    com.google.common.cache.h<K, V> hVar2 = this.f34766d;
                    hVar2.setPreviousInAccessQueue(hVar2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (((com.google.common.cache.h) obj).getNextInAccessQueue() != NullEntry.INSTANCE) {
                return true;
            }
            return false;
        }

        @Override // java.util.Queue
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.h<K, V> peek() {
            com.google.common.cache.h<K, V> nextInAccessQueue = this.f34766d.getNextInAccessQueue();
            if (nextInAccessQueue == this.f34766d) {
                return null;
            }
            return nextInAccessQueue;
        }

        @Override // java.util.Queue
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.h<K, V> poll() {
            com.google.common.cache.h<K, V> nextInAccessQueue = this.f34766d.getNextInAccessQueue();
            if (nextInAccessQueue == this.f34766d) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.f34766d.getNextInAccessQueue() == this.f34766d) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<com.google.common.cache.h<K, V>> iterator() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            com.google.common.cache.h hVar = (com.google.common.cache.h) obj;
            com.google.common.cache.h<K, V> previousInAccessQueue = hVar.getPreviousInAccessQueue();
            com.google.common.cache.h<K, V> nextInAccessQueue = hVar.getNextInAccessQueue();
            LocalCache.e(previousInAccessQueue, nextInAccessQueue);
            LocalCache.z(hVar);
            if (nextInAccessQueue != NullEntry.INSTANCE) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i3 = 0;
            for (com.google.common.cache.h<K, V> nextInAccessQueue = this.f34766d.getNextInAccessQueue(); nextInAccessQueue != this.f34766d; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i3++;
            }
            return i3;
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a extends d<K, V> {

            /* renamed from: d, reason: collision with root package name */
            com.google.common.cache.h<K, V> f34767d = this;

            /* renamed from: e, reason: collision with root package name */
            com.google.common.cache.h<K, V> f34768e = this;

            a() {
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public com.google.common.cache.h<K, V> getNextInAccessQueue() {
                return this.f34767d;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public com.google.common.cache.h<K, V> getPreviousInAccessQueue() {
                return this.f34768e;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public void setNextInAccessQueue(com.google.common.cache.h<K, V> hVar) {
                this.f34767d = hVar;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public void setPreviousInAccessQueue(com.google.common.cache.h<K, V> hVar) {
                this.f34768e = hVar;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public void setAccessTime(long j3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class a implements s<Object, Object> {
        a() {
        }

        @Override // com.google.common.cache.LocalCache.s
        public com.google.common.cache.h<Object, Object> a() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public int c() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.s
        public Object d() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public Object get() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<Object, Object> e(ReferenceQueue<Object> referenceQueue, @NullableDecl Object obj, com.google.common.cache.h<Object, Object> hVar) {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class l<K, V> extends SoftReference<V> implements s<K, V> {

        /* renamed from: d, reason: collision with root package name */
        final com.google.common.cache.h<K, V> f34783d;

        l(ReferenceQueue<V> referenceQueue, V v3, com.google.common.cache.h<K, V> hVar) {
            super(v3, referenceQueue);
            this.f34783d = hVar;
        }

        @Override // com.google.common.cache.LocalCache.s
        public com.google.common.cache.h<K, V> a() {
            return this.f34783d;
        }

        @Override // com.google.common.cache.LocalCache.s
        public int c() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.s
        public V d() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<K, V> e(ReferenceQueue<V> referenceQueue, V v3, com.google.common.cache.h<K, V> hVar) {
            return new l(referenceQueue, v3, hVar);
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(V v3) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class p<K, V> implements s<K, V> {

        /* renamed from: d, reason: collision with root package name */
        final V f34792d;

        p(V v3) {
            this.f34792d = v3;
        }

        @Override // com.google.common.cache.LocalCache.s
        public com.google.common.cache.h<K, V> a() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public int c() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.s
        public V d() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.s
        public V get() {
            return this.f34792d;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(V v3) {
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<K, V> e(ReferenceQueue<V> referenceQueue, V v3, com.google.common.cache.h<K, V> hVar) {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class x<K, V> extends WeakReference<V> implements s<K, V> {

        /* renamed from: d, reason: collision with root package name */
        final com.google.common.cache.h<K, V> f34806d;

        x(ReferenceQueue<V> referenceQueue, V v3, com.google.common.cache.h<K, V> hVar) {
            super(v3, referenceQueue);
            this.f34806d = hVar;
        }

        @Override // com.google.common.cache.LocalCache.s
        public com.google.common.cache.h<K, V> a() {
            return this.f34806d;
        }

        public int c() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.s
        public V d() {
            return get();
        }

        public s<K, V> e(ReferenceQueue<V> referenceQueue, V v3, com.google.common.cache.h<K, V> hVar) {
            return new x(referenceQueue, v3, hVar);
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(V v3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Segment<K, V> extends ReentrantLock {

        @GuardedBy("this")
        final Queue<com.google.common.cache.h<K, V>> accessQueue;
        volatile int count;

        @NullableDecl
        final ReferenceQueue<K> keyReferenceQueue;

        @Weak
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<com.google.common.cache.h<K, V>> recencyQueue;
        final com.google.common.cache.b statsCounter;

        @MonotonicNonNullDecl
        volatile AtomicReferenceArray<com.google.common.cache.h<K, V>> table;
        int threshold;

        @GuardedBy("this")
        long totalWeight;

        @NullableDecl
        final ReferenceQueue<V> valueReferenceQueue;

        @GuardedBy("this")
        final Queue<com.google.common.cache.h<K, V>> writeQueue;

        Segment(LocalCache<K, V> localCache, int i3, long j3, com.google.common.cache.b bVar) {
            ReferenceQueue<K> referenceQueue;
            Queue<com.google.common.cache.h<K, V>> i16;
            Queue<com.google.common.cache.h<K, V>> i17;
            Queue<com.google.common.cache.h<K, V>> i18;
            this.map = localCache;
            this.maxSegmentWeight = j3;
            this.statsCounter = (com.google.common.cache.b) com.google.common.base.j.m(bVar);
            initTable(newEntryArray(i3));
            if (localCache.P()) {
                referenceQueue = new ReferenceQueue<>();
            } else {
                referenceQueue = null;
            }
            this.keyReferenceQueue = referenceQueue;
            this.valueReferenceQueue = localCache.Q() ? new ReferenceQueue<>() : null;
            if (localCache.O()) {
                i16 = new ConcurrentLinkedQueue<>();
            } else {
                i16 = LocalCache.i();
            }
            this.recencyQueue = i16;
            if (localCache.S()) {
                i17 = new ac<>();
            } else {
                i17 = LocalCache.i();
            }
            this.writeQueue = i17;
            if (localCache.O()) {
                i18 = new e<>();
            } else {
                i18 = LocalCache.i();
            }
            this.accessQueue = i18;
        }

        void cleanUp() {
            runLockedCleanup(this.map.L.a());
            runUnlockedCleanup();
        }

        void clear() {
            RemovalCause removalCause;
            if (this.count != 0) {
                lock();
                try {
                    preWriteCleanup(this.map.L.a());
                    AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                    for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                        for (com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(i3); hVar != null; hVar = hVar.getNext()) {
                            if (hVar.getValueReference().isActive()) {
                                K key = hVar.getKey();
                                V v3 = hVar.getValueReference().get();
                                if (key != null && v3 != null) {
                                    removalCause = RemovalCause.EXPLICIT;
                                    enqueueNotification(key, hVar.getHash(), v3, hVar.getValueReference().c(), removalCause);
                                }
                                removalCause = RemovalCause.COLLECTED;
                                enqueueNotification(key, hVar.getHash(), v3, hVar.getValueReference().c(), removalCause);
                            }
                        }
                    }
                    for (int i16 = 0; i16 < atomicReferenceArray.length(); i16++) {
                        atomicReferenceArray.set(i16, null);
                    }
                    clearReferenceQueues();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
        }

        void clearKeyReferenceQueue() {
            do {
            } while (this.keyReferenceQueue.poll() != null);
        }

        void clearReferenceQueues() {
            if (this.map.P()) {
                clearKeyReferenceQueue();
            }
            if (this.map.Q()) {
                clearValueReferenceQueue();
            }
        }

        void clearValueReferenceQueue() {
            do {
            } while (this.valueReferenceQueue.poll() != null);
        }

        boolean containsKey(Object obj, int i3) {
            try {
                boolean z16 = false;
                if (this.count == 0) {
                    return false;
                }
                com.google.common.cache.h<K, V> liveEntry = getLiveEntry(obj, i3, this.map.L.a());
                if (liveEntry == null) {
                    return false;
                }
                if (liveEntry.getValueReference().get() != null) {
                    z16 = true;
                }
                return z16;
            } finally {
                postReadCleanup();
            }
        }

        @VisibleForTesting
        boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    long a16 = this.map.L.a();
                    AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        for (com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(i3); hVar != null; hVar = hVar.getNext()) {
                            V liveValue = getLiveValue(hVar, a16);
                            if (liveValue != null && this.map.f34747m.equivalent(obj, liveValue)) {
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

        @GuardedBy("this")
        com.google.common.cache.h<K, V> copyEntry(com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
            if (hVar.getKey() == null) {
                return null;
            }
            s<K, V> valueReference = hVar.getValueReference();
            V v3 = valueReference.get();
            if (v3 == null && valueReference.isActive()) {
                return null;
            }
            com.google.common.cache.h<K, V> copyEntry = this.map.M.copyEntry(this, hVar, hVar2);
            copyEntry.setValueReference(valueReference.e(this.valueReferenceQueue, v3, copyEntry));
            return copyEntry;
        }

        @GuardedBy("this")
        void drainKeyReferenceQueue() {
            int i3 = 0;
            do {
                Reference<? extends K> poll = this.keyReferenceQueue.poll();
                if (poll != null) {
                    this.map.C((com.google.common.cache.h) poll);
                    i3++;
                } else {
                    return;
                }
            } while (i3 != 16);
        }

        @GuardedBy("this")
        void drainRecencyQueue() {
            while (true) {
                com.google.common.cache.h<K, V> poll = this.recencyQueue.poll();
                if (poll != null) {
                    if (this.accessQueue.contains(poll)) {
                        this.accessQueue.add(poll);
                    }
                } else {
                    return;
                }
            }
        }

        @GuardedBy("this")
        void drainReferenceQueues() {
            if (this.map.P()) {
                drainKeyReferenceQueue();
            }
            if (this.map.Q()) {
                drainValueReferenceQueue();
            }
        }

        @GuardedBy("this")
        void drainValueReferenceQueue() {
            int i3 = 0;
            do {
                Reference<? extends V> poll = this.valueReferenceQueue.poll();
                if (poll != null) {
                    this.map.D((s) poll);
                    i3++;
                } else {
                    return;
                }
            } while (i3 != 16);
        }

        @GuardedBy("this")
        void enqueueNotification(@NullableDecl K k3, int i3, @NullableDecl V v3, int i16, RemovalCause removalCause) {
            this.totalWeight -= i16;
            if (removalCause.wasEvicted()) {
                this.statsCounter.b();
            }
            if (this.map.J != LocalCache.V) {
                this.map.J.offer(RemovalNotification.create(k3, v3, removalCause));
            }
        }

        @GuardedBy("this")
        void evictEntries(com.google.common.cache.h<K, V> hVar) {
            if (!this.map.j()) {
                return;
            }
            drainRecencyQueue();
            if (hVar.getValueReference().c() > this.maxSegmentWeight && !removeEntry(hVar, hVar.getHash(), RemovalCause.SIZE)) {
                throw new AssertionError();
            }
            while (this.totalWeight > this.maxSegmentWeight) {
                com.google.common.cache.h<K, V> nextEvictable = getNextEvictable();
                if (!removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
            }
        }

        @GuardedBy("this")
        void expand() {
            AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i3 = this.count;
            AtomicReferenceArray<com.google.common.cache.h<K, V>> newEntryArray = newEntryArray(length << 1);
            this.threshold = (newEntryArray.length() * 3) / 4;
            int length2 = newEntryArray.length() - 1;
            for (int i16 = 0; i16 < length; i16++) {
                com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(i16);
                if (hVar != null) {
                    com.google.common.cache.h<K, V> next = hVar.getNext();
                    int hash = hVar.getHash() & length2;
                    if (next == null) {
                        newEntryArray.set(hash, hVar);
                    } else {
                        com.google.common.cache.h<K, V> hVar2 = hVar;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                hVar2 = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        newEntryArray.set(hash, hVar2);
                        while (hVar != hVar2) {
                            int hash3 = hVar.getHash() & length2;
                            com.google.common.cache.h<K, V> copyEntry = copyEntry(hVar, newEntryArray.get(hash3));
                            if (copyEntry != null) {
                                newEntryArray.set(hash3, copyEntry);
                            } else {
                                removeCollectedEntry(hVar);
                                i3--;
                            }
                            hVar = hVar.getNext();
                        }
                    }
                }
            }
            this.table = newEntryArray;
            this.count = i3;
        }

        @GuardedBy("this")
        void expireEntries(long j3) {
            com.google.common.cache.h<K, V> peek;
            com.google.common.cache.h<K, V> peek2;
            drainRecencyQueue();
            do {
                peek = this.writeQueue.peek();
                if (peek == null || !this.map.u(peek, j3)) {
                    do {
                        peek2 = this.accessQueue.peek();
                        if (peek2 == null || !this.map.u(peek2, j3)) {
                            return;
                        }
                    } while (removeEntry(peek2, peek2.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (removeEntry(peek, peek.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        V get(K k3, int i3, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            com.google.common.cache.h<K, V> entry;
            com.google.common.base.j.m(k3);
            com.google.common.base.j.m(cacheLoader);
            try {
                try {
                    if (this.count != 0 && (entry = getEntry(k3, i3)) != null) {
                        long a16 = this.map.L.a();
                        V liveValue = getLiveValue(entry, a16);
                        if (liveValue != null) {
                            recordRead(entry, a16);
                            this.statsCounter.a(1);
                            return scheduleRefresh(entry, k3, i3, liveValue, a16, cacheLoader);
                        }
                        s<K, V> valueReference = entry.getValueReference();
                        if (valueReference.isLoading()) {
                            return waitForLoadingValue(entry, k3, valueReference);
                        }
                    }
                    return lockedGetOrLoad(k3, i3, cacheLoader);
                } catch (ExecutionException e16) {
                    Throwable cause = e16.getCause();
                    if (!(cause instanceof Error)) {
                        if (cause instanceof RuntimeException) {
                            throw new UncheckedExecutionException(cause);
                        }
                        throw e16;
                    }
                    throw new ExecutionError((Error) cause);
                }
            } finally {
                postReadCleanup();
            }
        }

        V getAndRecordStats(K k3, int i3, k<K, V> kVar, com.google.common.util.concurrent.q<V> qVar) throws ExecutionException {
            V v3;
            try {
                v3 = (V) com.google.common.util.concurrent.v.a(qVar);
            } catch (Throwable th5) {
                th = th5;
                v3 = null;
            }
            try {
                if (v3 != null) {
                    this.statsCounter.c(kVar.f());
                    storeLoadedValue(k3, i3, kVar, v3);
                    return v3;
                }
                throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k3 + ".");
            } catch (Throwable th6) {
                th = th6;
                if (v3 == null) {
                    this.statsCounter.f(kVar.f());
                    removeLoadingValue(k3, i3, kVar);
                }
                throw th;
            }
        }

        @NullableDecl
        com.google.common.cache.h<K, V> getEntry(Object obj, int i3) {
            for (com.google.common.cache.h<K, V> first = getFirst(i3); first != null; first = first.getNext()) {
                if (first.getHash() == i3) {
                    K key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.f34746i.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        com.google.common.cache.h<K, V> getFirst(int i3) {
            return this.table.get(i3 & (r0.length() - 1));
        }

        @NullableDecl
        com.google.common.cache.h<K, V> getLiveEntry(Object obj, int i3, long j3) {
            com.google.common.cache.h<K, V> entry = getEntry(obj, i3);
            if (entry == null) {
                return null;
            }
            if (this.map.u(entry, j3)) {
                tryExpireEntries(j3);
                return null;
            }
            return entry;
        }

        V getLiveValue(com.google.common.cache.h<K, V> hVar, long j3) {
            if (hVar.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v3 = hVar.getValueReference().get();
            if (v3 == null) {
                tryDrainReferenceQueues();
                return null;
            }
            if (this.map.u(hVar, j3)) {
                tryExpireEntries(j3);
                return null;
            }
            return v3;
        }

        @GuardedBy("this")
        com.google.common.cache.h<K, V> getNextEvictable() {
            for (com.google.common.cache.h<K, V> hVar : this.accessQueue) {
                if (hVar.getValueReference().c() > 0) {
                    return hVar;
                }
            }
            throw new AssertionError();
        }

        void initTable(AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!this.map.h()) {
                int i3 = this.threshold;
                if (i3 == this.maxSegmentWeight) {
                    this.threshold = i3 + 1;
                }
            }
            this.table = atomicReferenceArray;
        }

        @NullableDecl
        k<K, V> insertLoadingValueReference(K k3, int i3, boolean z16) {
            lock();
            try {
                long a16 = this.map.L.a();
                preWriteCleanup(a16);
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i3;
                com.google.common.cache.h<K, V> hVar = (com.google.common.cache.h) atomicReferenceArray.get(length);
                for (com.google.common.cache.h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    Object key = hVar2.getKey();
                    if (hVar2.getHash() == i3 && key != null && this.map.f34746i.equivalent(k3, key)) {
                        s<K, V> valueReference = hVar2.getValueReference();
                        if (!valueReference.isLoading() && (!z16 || a16 - hVar2.getWriteTime() >= this.map.I)) {
                            this.modCount++;
                            k<K, V> kVar = new k<>(valueReference);
                            hVar2.setValueReference(kVar);
                            return kVar;
                        }
                        unlock();
                        postWriteCleanup();
                        return null;
                    }
                }
                this.modCount++;
                k<K, V> kVar2 = new k<>();
                com.google.common.cache.h<K, V> newEntry = newEntry(k3, i3, hVar);
                newEntry.setValueReference(kVar2);
                atomicReferenceArray.set(length, newEntry);
                return kVar2;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        com.google.common.util.concurrent.q<V> loadAsync(final K k3, final int i3, final k<K, V> kVar, CacheLoader<? super K, V> cacheLoader) {
            final com.google.common.util.concurrent.q<V> i16 = kVar.i(k3, cacheLoader);
            i16.c(new Runnable() { // from class: com.google.common.cache.LocalCache.Segment.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Segment.this.getAndRecordStats(k3, i3, kVar, i16);
                    } catch (Throwable th5) {
                        LocalCache.T.log(Level.WARNING, "Exception thrown during refresh", th5);
                        kVar.k(th5);
                    }
                }
            }, MoreExecutors.a());
            return i16;
        }

        V loadSync(K k3, int i3, k<K, V> kVar, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            return getAndRecordStats(k3, i3, kVar, kVar.i(k3, cacheLoader));
        }

        V lockedGetOrLoad(K k3, int i3, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            k<K, V> kVar;
            boolean z16;
            s<K, V> sVar;
            V loadSync;
            lock();
            try {
                long a16 = this.map.L.a();
                preWriteCleanup(a16);
                int i16 = this.count - 1;
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                int length = i3 & (atomicReferenceArray.length() - 1);
                com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(length);
                com.google.common.cache.h<K, V> hVar2 = hVar;
                while (true) {
                    kVar = null;
                    if (hVar2 != null) {
                        K key = hVar2.getKey();
                        if (hVar2.getHash() == i3 && key != null && this.map.f34746i.equivalent(k3, key)) {
                            s<K, V> valueReference = hVar2.getValueReference();
                            if (valueReference.isLoading()) {
                                z16 = false;
                            } else {
                                V v3 = valueReference.get();
                                if (v3 == null) {
                                    enqueueNotification(key, i3, v3, valueReference.c(), RemovalCause.COLLECTED);
                                } else if (this.map.u(hVar2, a16)) {
                                    enqueueNotification(key, i3, v3, valueReference.c(), RemovalCause.EXPIRED);
                                } else {
                                    recordLockedRead(hVar2, a16);
                                    this.statsCounter.a(1);
                                    return v3;
                                }
                                this.writeQueue.remove(hVar2);
                                this.accessQueue.remove(hVar2);
                                this.count = i16;
                                z16 = true;
                            }
                            sVar = valueReference;
                        } else {
                            hVar2 = hVar2.getNext();
                        }
                    } else {
                        z16 = true;
                        sVar = null;
                        break;
                    }
                }
                if (z16) {
                    kVar = new k<>();
                    if (hVar2 == null) {
                        hVar2 = newEntry(k3, i3, hVar);
                        hVar2.setValueReference(kVar);
                        atomicReferenceArray.set(length, hVar2);
                    } else {
                        hVar2.setValueReference(kVar);
                    }
                }
                if (z16) {
                    try {
                        synchronized (hVar2) {
                            loadSync = loadSync(k3, i3, kVar, cacheLoader);
                        }
                        return loadSync;
                    } finally {
                        this.statsCounter.d(1);
                    }
                }
                return waitForLoadingValue(hVar2, k3, sVar);
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        com.google.common.cache.h<K, V> newEntry(K k3, int i3, @NullableDecl com.google.common.cache.h<K, V> hVar) {
            return this.map.M.newEntry(this, com.google.common.base.j.m(k3), i3, hVar);
        }

        AtomicReferenceArray<com.google.common.cache.h<K, V>> newEntryArray(int i3) {
            return new AtomicReferenceArray<>(i3);
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        void postWriteCleanup() {
            runUnlockedCleanup();
        }

        @GuardedBy("this")
        void preWriteCleanup(long j3) {
            runLockedCleanup(j3);
        }

        @NullableDecl
        V put(K k3, int i3, V v3, boolean z16) {
            int i16;
            lock();
            try {
                long a16 = this.map.L.a();
                preWriteCleanup(a16);
                if (this.count + 1 > this.threshold) {
                    expand();
                }
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                int length = i3 & (atomicReferenceArray.length() - 1);
                com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(length);
                com.google.common.cache.h<K, V> hVar2 = hVar;
                while (true) {
                    if (hVar2 != null) {
                        K key = hVar2.getKey();
                        if (hVar2.getHash() == i3 && key != null && this.map.f34746i.equivalent(k3, key)) {
                            s<K, V> valueReference = hVar2.getValueReference();
                            V v16 = valueReference.get();
                            if (v16 == null) {
                                this.modCount++;
                                if (valueReference.isActive()) {
                                    enqueueNotification(k3, i3, v16, valueReference.c(), RemovalCause.COLLECTED);
                                    setValue(hVar2, k3, v3, a16);
                                    i16 = this.count;
                                } else {
                                    setValue(hVar2, k3, v3, a16);
                                    i16 = this.count + 1;
                                }
                                this.count = i16;
                                evictEntries(hVar2);
                            } else {
                                if (z16) {
                                    recordLockedRead(hVar2, a16);
                                } else {
                                    this.modCount++;
                                    enqueueNotification(k3, i3, v16, valueReference.c(), RemovalCause.REPLACED);
                                    setValue(hVar2, k3, v3, a16);
                                    evictEntries(hVar2);
                                }
                                return v16;
                            }
                        } else {
                            hVar2 = hVar2.getNext();
                        }
                    } else {
                        this.modCount++;
                        com.google.common.cache.h<K, V> newEntry = newEntry(k3, i3, hVar);
                        setValue(newEntry, k3, v3, a16);
                        atomicReferenceArray.set(length, newEntry);
                        this.count++;
                        evictEntries(newEntry);
                        break;
                    }
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        boolean reclaimKey(com.google.common.cache.h<K, V> hVar, int i3) {
            lock();
            try {
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i3;
                com.google.common.cache.h<K, V> hVar2 = atomicReferenceArray.get(length);
                for (com.google.common.cache.h<K, V> hVar3 = hVar2; hVar3 != null; hVar3 = hVar3.getNext()) {
                    if (hVar3 == hVar) {
                        this.modCount++;
                        com.google.common.cache.h<K, V> removeValueFromChain = removeValueFromChain(hVar2, hVar3, hVar3.getKey(), i3, hVar3.getValueReference().get(), hVar3.getValueReference(), RemovalCause.COLLECTED);
                        int i16 = this.count - 1;
                        atomicReferenceArray.set(length, removeValueFromChain);
                        this.count = i16;
                        return true;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        boolean reclaimValue(K k3, int i3, s<K, V> sVar) {
            lock();
            try {
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i3;
                com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(length);
                for (com.google.common.cache.h<K, V> hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    K key = hVar2.getKey();
                    if (hVar2.getHash() == i3 && key != null && this.map.f34746i.equivalent(k3, key)) {
                        if (hVar2.getValueReference() == sVar) {
                            this.modCount++;
                            com.google.common.cache.h<K, V> removeValueFromChain = removeValueFromChain(hVar, hVar2, key, i3, sVar.get(), sVar, RemovalCause.COLLECTED);
                            int i16 = this.count - 1;
                            atomicReferenceArray.set(length, removeValueFromChain);
                            this.count = i16;
                            return true;
                        }
                        unlock();
                        if (!isHeldByCurrentThread()) {
                            postWriteCleanup();
                        }
                        return false;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
            }
        }

        @GuardedBy("this")
        void recordLockedRead(com.google.common.cache.h<K, V> hVar, long j3) {
            if (this.map.E()) {
                hVar.setAccessTime(j3);
            }
            this.accessQueue.add(hVar);
        }

        void recordRead(com.google.common.cache.h<K, V> hVar, long j3) {
            if (this.map.E()) {
                hVar.setAccessTime(j3);
            }
            this.recencyQueue.add(hVar);
        }

        @GuardedBy("this")
        void recordWrite(com.google.common.cache.h<K, V> hVar, int i3, long j3) {
            drainRecencyQueue();
            this.totalWeight += i3;
            if (this.map.E()) {
                hVar.setAccessTime(j3);
            }
            if (this.map.G()) {
                hVar.setWriteTime(j3);
            }
            this.accessQueue.add(hVar);
            this.writeQueue.add(hVar);
        }

        @NullableDecl
        V refresh(K k3, int i3, CacheLoader<? super K, V> cacheLoader, boolean z16) {
            k<K, V> insertLoadingValueReference = insertLoadingValueReference(k3, i3, z16);
            if (insertLoadingValueReference == null) {
                return null;
            }
            com.google.common.util.concurrent.q<V> loadAsync = loadAsync(k3, i3, insertLoadingValueReference, cacheLoader);
            if (loadAsync.isDone()) {
                try {
                    return (V) com.google.common.util.concurrent.v.a(loadAsync);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        
            r9 = r5.getValueReference();
            r12 = r9.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        
            if (r12 == null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        
            r2 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
        
            r10 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        
            r11.modCount++;
            r13 = removeValueFromChain(r4, r5, r6, r13, r12, r9, r10);
            r2 = r11.count - 1;
            r0.set(r1, r13);
            r11.count = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x006b, code lost:
        
            return r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        
            if (r9.isActive() == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
        
            r2 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        @NullableDecl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        V remove(Object obj, int i3) {
            lock();
            try {
                preWriteCleanup(this.map.L.a());
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i3;
                com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(length);
                com.google.common.cache.h<K, V> hVar2 = hVar;
                while (true) {
                    if (hVar2 == null) {
                        break;
                    }
                    K key = hVar2.getKey();
                    if (hVar2.getHash() == i3 && key != null && this.map.f34746i.equivalent(obj, key)) {
                        break;
                    }
                    hVar2 = hVar2.getNext();
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        @GuardedBy("this")
        void removeCollectedEntry(com.google.common.cache.h<K, V> hVar) {
            enqueueNotification(hVar.getKey(), hVar.getHash(), hVar.getValueReference().get(), hVar.getValueReference().c(), RemovalCause.COLLECTED);
            this.writeQueue.remove(hVar);
            this.accessQueue.remove(hVar);
        }

        @VisibleForTesting
        @GuardedBy("this")
        boolean removeEntry(com.google.common.cache.h<K, V> hVar, int i3, RemovalCause removalCause) {
            AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i3;
            com.google.common.cache.h<K, V> hVar2 = atomicReferenceArray.get(length);
            for (com.google.common.cache.h<K, V> hVar3 = hVar2; hVar3 != null; hVar3 = hVar3.getNext()) {
                if (hVar3 == hVar) {
                    this.modCount++;
                    com.google.common.cache.h<K, V> removeValueFromChain = removeValueFromChain(hVar2, hVar3, hVar3.getKey(), i3, hVar3.getValueReference().get(), hVar3.getValueReference(), removalCause);
                    int i16 = this.count - 1;
                    atomicReferenceArray.set(length, removeValueFromChain);
                    this.count = i16;
                    return true;
                }
            }
            return false;
        }

        @NullableDecl
        @GuardedBy("this")
        com.google.common.cache.h<K, V> removeEntryFromChain(com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
            int i3 = this.count;
            com.google.common.cache.h<K, V> next = hVar2.getNext();
            while (hVar != hVar2) {
                com.google.common.cache.h<K, V> copyEntry = copyEntry(hVar, next);
                if (copyEntry != null) {
                    next = copyEntry;
                } else {
                    removeCollectedEntry(hVar);
                    i3--;
                }
                hVar = hVar.getNext();
            }
            this.count = i3;
            return next;
        }

        boolean removeLoadingValue(K k3, int i3, k<K, V> kVar) {
            lock();
            try {
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i3;
                com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(length);
                com.google.common.cache.h<K, V> hVar2 = hVar;
                while (true) {
                    if (hVar2 == null) {
                        break;
                    }
                    K key = hVar2.getKey();
                    if (hVar2.getHash() == i3 && key != null && this.map.f34746i.equivalent(k3, key)) {
                        if (hVar2.getValueReference() == kVar) {
                            if (kVar.isActive()) {
                                hVar2.setValueReference(kVar.h());
                            } else {
                                atomicReferenceArray.set(length, removeEntryFromChain(hVar, hVar2));
                            }
                            return true;
                        }
                    } else {
                        hVar2 = hVar2.getNext();
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        @NullableDecl
        @GuardedBy("this")
        com.google.common.cache.h<K, V> removeValueFromChain(com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2, @NullableDecl K k3, int i3, V v3, s<K, V> sVar, RemovalCause removalCause) {
            enqueueNotification(k3, i3, v3, sVar.c(), removalCause);
            this.writeQueue.remove(hVar2);
            this.accessQueue.remove(hVar2);
            if (sVar.isLoading()) {
                sVar.b(null);
                return hVar;
            }
            return removeEntryFromChain(hVar, hVar2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x006f, code lost:
        
            return false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        boolean replace(K k3, int i3, V v3, V v16) {
            lock();
            try {
                long a16 = this.map.L.a();
                preWriteCleanup(a16);
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                int length = i3 & (atomicReferenceArray.length() - 1);
                com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(length);
                com.google.common.cache.h<K, V> hVar2 = hVar;
                while (true) {
                    if (hVar2 == null) {
                        break;
                    }
                    K key = hVar2.getKey();
                    if (hVar2.getHash() == i3 && key != null) {
                        if (this.map.f34746i.equivalent(k3, key)) {
                            s<K, V> valueReference = hVar2.getValueReference();
                            V v17 = valueReference.get();
                            if (v17 == null) {
                                if (valueReference.isActive()) {
                                    this.modCount++;
                                    com.google.common.cache.h<K, V> removeValueFromChain = removeValueFromChain(hVar, hVar2, key, i3, v17, valueReference, RemovalCause.COLLECTED);
                                    int i16 = this.count - 1;
                                    atomicReferenceArray.set(length, removeValueFromChain);
                                    this.count = i16;
                                }
                            } else {
                                if (this.map.f34747m.equivalent(v3, v17)) {
                                    this.modCount++;
                                    enqueueNotification(k3, i3, v17, valueReference.c(), RemovalCause.REPLACED);
                                    setValue(hVar2, k3, v16, a16);
                                    evictEntries(hVar2);
                                    return true;
                                }
                                recordLockedRead(hVar2, a16);
                            }
                        }
                    }
                    hVar2 = hVar2.getNext();
                }
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        void runLockedCleanup(long j3) {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(j3);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        void runUnlockedCleanup() {
            if (!isHeldByCurrentThread()) {
                this.map.B();
            }
        }

        V scheduleRefresh(com.google.common.cache.h<K, V> hVar, K k3, int i3, V v3, long j3, CacheLoader<? super K, V> cacheLoader) {
            V refresh;
            if (this.map.I() && j3 - hVar.getWriteTime() > this.map.I && !hVar.getValueReference().isLoading() && (refresh = refresh(k3, i3, cacheLoader, true)) != null) {
                return refresh;
            }
            return v3;
        }

        @GuardedBy("this")
        void setValue(com.google.common.cache.h<K, V> hVar, K k3, V v3, long j3) {
            boolean z16;
            s<K, V> valueReference = hVar.getValueReference();
            int weigh = this.map.F.weigh(k3, v3);
            if (weigh >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.google.common.base.j.t(z16, "Weights must be non-negative");
            hVar.setValueReference(this.map.D.referenceValue(this, hVar, v3, weigh));
            recordWrite(hVar, weigh, j3);
            valueReference.b(v3);
        }

        boolean storeLoadedValue(K k3, int i3, k<K, V> kVar, V v3) {
            RemovalCause removalCause;
            lock();
            try {
                long a16 = this.map.L.a();
                preWriteCleanup(a16);
                int i16 = this.count + 1;
                if (i16 > this.threshold) {
                    expand();
                    i16 = this.count + 1;
                }
                int i17 = i16;
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                int length = i3 & (atomicReferenceArray.length() - 1);
                com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(length);
                com.google.common.cache.h<K, V> hVar2 = hVar;
                while (true) {
                    if (hVar2 != null) {
                        K key = hVar2.getKey();
                        if (hVar2.getHash() == i3 && key != null && this.map.f34746i.equivalent(k3, key)) {
                            s<K, V> valueReference = hVar2.getValueReference();
                            V v16 = valueReference.get();
                            if (kVar != valueReference && (v16 != null || valueReference == LocalCache.U)) {
                                enqueueNotification(k3, i3, v3, 0, RemovalCause.REPLACED);
                                unlock();
                                postWriteCleanup();
                                return false;
                            }
                            this.modCount++;
                            if (kVar.isActive()) {
                                if (v16 == null) {
                                    removalCause = RemovalCause.COLLECTED;
                                } else {
                                    removalCause = RemovalCause.REPLACED;
                                }
                                enqueueNotification(k3, i3, v16, kVar.c(), removalCause);
                                i17--;
                            }
                            setValue(hVar2, k3, v3, a16);
                            this.count = i17;
                            evictEntries(hVar2);
                        } else {
                            hVar2 = hVar2.getNext();
                        }
                    } else {
                        this.modCount++;
                        com.google.common.cache.h<K, V> newEntry = newEntry(k3, i3, hVar);
                        setValue(newEntry, k3, v3, a16);
                        atomicReferenceArray.set(length, newEntry);
                        this.count = i17;
                        evictEntries(newEntry);
                        break;
                    }
                }
                return true;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        void tryExpireEntries(long j3) {
            if (tryLock()) {
                try {
                    expireEntries(j3);
                } finally {
                    unlock();
                }
            }
        }

        V waitForLoadingValue(com.google.common.cache.h<K, V> hVar, K k3, s<K, V> sVar) throws ExecutionException {
            if (sVar.isLoading()) {
                com.google.common.base.j.w(!Thread.holdsLock(hVar), "Recursive load of: %s", k3);
                try {
                    V d16 = sVar.d();
                    if (d16 != null) {
                        recordRead(hVar, this.map.L.a());
                        return d16;
                    }
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k3 + ".");
                } finally {
                    this.statsCounter.d(1);
                }
            }
            throw new AssertionError();
        }

        @NullableDecl
        V get(Object obj, int i3) {
            try {
                if (this.count != 0) {
                    long a16 = this.map.L.a();
                    com.google.common.cache.h<K, V> liveEntry = getLiveEntry(obj, i3, a16);
                    if (liveEntry == null) {
                        return null;
                    }
                    V v3 = liveEntry.getValueReference().get();
                    if (v3 != null) {
                        recordRead(liveEntry, a16);
                        return scheduleRefresh(liveEntry, liveEntry.getKey(), i3, v3, a16, this.map.P);
                    }
                    tryDrainReferenceQueues();
                }
                return null;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        
            r10 = r6.getValueReference();
            r9 = r10.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
        
            if (r12.map.f34747m.equivalent(r15, r9) == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
        
            r13 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
        
            r12.modCount++;
            r14 = removeValueFromChain(r5, r6, r7, r14, r9, r10, r13);
            r15 = r12.count - 1;
            r0.set(r1, r14);
            r12.count = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006d, code lost:
        
            if (r13 != com.google.common.cache.RemovalCause.EXPLICIT) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0070, code lost:
        
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        
            if (r9 != null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        
            if (r10.isActive() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
        
            r13 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        boolean remove(Object obj, int i3, Object obj2) {
            lock();
            try {
                preWriteCleanup(this.map.L.a());
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                boolean z16 = true;
                int length = (atomicReferenceArray.length() - 1) & i3;
                com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(length);
                com.google.common.cache.h<K, V> hVar2 = hVar;
                while (true) {
                    if (hVar2 == null) {
                        break;
                    }
                    K key = hVar2.getKey();
                    if (hVar2.getHash() == i3 && key != null && this.map.f34746i.equivalent(obj, key)) {
                        break;
                    }
                    hVar2 = hVar2.getNext();
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0072, code lost:
        
            return null;
         */
        @NullableDecl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        V replace(K k3, int i3, V v3) {
            lock();
            try {
                long a16 = this.map.L.a();
                preWriteCleanup(a16);
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                int length = i3 & (atomicReferenceArray.length() - 1);
                com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(length);
                com.google.common.cache.h<K, V> hVar2 = hVar;
                while (true) {
                    if (hVar2 == null) {
                        break;
                    }
                    K key = hVar2.getKey();
                    if (hVar2.getHash() == i3 && key != null) {
                        if (this.map.f34746i.equivalent(k3, key)) {
                            s<K, V> valueReference = hVar2.getValueReference();
                            V v16 = valueReference.get();
                            if (v16 == null) {
                                if (valueReference.isActive()) {
                                    this.modCount++;
                                    com.google.common.cache.h<K, V> removeValueFromChain = removeValueFromChain(hVar, hVar2, key, i3, v16, valueReference, RemovalCause.COLLECTED);
                                    int i16 = this.count - 1;
                                    atomicReferenceArray.set(length, removeValueFromChain);
                                    this.count = i16;
                                }
                            } else {
                                this.modCount++;
                                enqueueNotification(k3, i3, v16, valueReference.c(), RemovalCause.REPLACED);
                                setValue(hVar2, k3, v3, a16);
                                evictEntries(hVar2);
                                return v16;
                            }
                        }
                    }
                    hVar2 = hVar2.getNext();
                }
            } finally {
                unlock();
                postWriteCleanup();
            }
        }
    }
}
