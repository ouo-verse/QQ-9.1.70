package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtIncompatible
/* loaded from: classes2.dex */
public class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final float DEFAULT_LOAD_FACTOR = 1.0f;
    static final int DEFAULT_SIZE = 3;
    static final int UNSET = -1;

    /* renamed from: d, reason: collision with root package name */
    @MonotonicNonNullDecl
    private transient int[] f34837d;

    /* renamed from: e, reason: collision with root package name */
    private transient int f34838e;

    @VisibleForTesting
    @MonotonicNonNullDecl
    transient long[] entries;

    /* renamed from: f, reason: collision with root package name */
    private transient int f34839f;

    /* renamed from: h, reason: collision with root package name */
    @MonotonicNonNullDecl
    private transient Set<K> f34840h;

    /* renamed from: i, reason: collision with root package name */
    @MonotonicNonNullDecl
    private transient Set<Map.Entry<K, V>> f34841i;

    @VisibleForTesting
    @MonotonicNonNullDecl
    transient Object[] keys;
    transient float loadFactor;

    /* renamed from: m, reason: collision with root package name */
    @MonotonicNonNullDecl
    private transient Collection<V> f34842m;
    transient int modCount;

    @VisibleForTesting
    @MonotonicNonNullDecl
    transient Object[] values;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends CompactHashMap<K, V>.e<K> {
        a() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        K b(int i3) {
            return (K) CompactHashMap.this.keys[i3];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b extends CompactHashMap<K, V>.e<Map.Entry<K, V>> {
        b() {
            super(CompactHashMap.this, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.CompactHashMap.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> b(int i3) {
            return new g(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c extends CompactHashMap<K, V>.e<V> {
        c() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        V b(int i3) {
            return (V) CompactHashMap.this.values[i3];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int f16 = CompactHashMap.this.f(entry.getKey());
            if (f16 == -1 || !com.google.common.base.g.a(CompactHashMap.this.values[f16], entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int f16 = CompactHashMap.this.f(entry.getKey());
                if (f16 != -1 && com.google.common.base.g.a(CompactHashMap.this.values[f16], entry.getValue())) {
                    CompactHashMap.this.j(f16);
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.f34839f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class f extends AbstractSet<K> {
        f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            int f16 = CompactHashMap.this.f(obj);
            if (f16 != -1) {
                CompactHashMap.this.j(f16);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.f34839f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public final class g extends com.google.common.collect.b<K, V> {

        /* renamed from: d, reason: collision with root package name */
        @NullableDecl
        private final K f34852d;

        /* renamed from: e, reason: collision with root package name */
        private int f34853e;

        g(int i3) {
            this.f34852d = (K) CompactHashMap.this.keys[i3];
            this.f34853e = i3;
        }

        private void a() {
            int i3 = this.f34853e;
            if (i3 == -1 || i3 >= CompactHashMap.this.size() || !com.google.common.base.g.a(this.f34852d, CompactHashMap.this.keys[this.f34853e])) {
                this.f34853e = CompactHashMap.this.f(this.f34852d);
            }
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return this.f34852d;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getValue() {
            a();
            int i3 = this.f34853e;
            if (i3 == -1) {
                return null;
            }
            return (V) CompactHashMap.this.values[i3];
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V setValue(V v3) {
            a();
            int i3 = this.f34853e;
            if (i3 == -1) {
                CompactHashMap.this.put(this.f34852d, v3);
                return null;
            }
            Object[] objArr = CompactHashMap.this.values;
            V v16 = (V) objArr[i3];
            objArr[i3] = v3;
            return v16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class h extends AbstractCollection<V> {
        h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.this.f34839f;
        }
    }

    CompactHashMap() {
        init(3, 1.0f);
    }

    private static int c(long j3) {
        return (int) (j3 >>> 32);
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i3) {
        return new CompactHashMap<>(i3);
    }

    private static int d(long j3) {
        return (int) j3;
    }

    private int e() {
        return this.f34837d.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(@NullableDecl Object obj) {
        int c16 = p.c(obj);
        int i3 = this.f34837d[e() & c16];
        while (i3 != -1) {
            long j3 = this.entries[i3];
            if (c(j3) == c16 && com.google.common.base.g.a(obj, this.keys[i3])) {
                return i3;
            }
            i3 = d(j3);
        }
        return -1;
    }

    private static long[] g(int i3) {
        long[] jArr = new long[i3];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] h(int i3) {
        int[] iArr = new int[i3];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    @NullableDecl
    private V i(@NullableDecl Object obj, int i3) {
        int e16 = e() & i3;
        int i16 = this.f34837d[e16];
        if (i16 == -1) {
            return null;
        }
        int i17 = -1;
        while (true) {
            if (c(this.entries[i16]) == i3 && com.google.common.base.g.a(obj, this.keys[i16])) {
                V v3 = (V) this.values[i16];
                if (i17 == -1) {
                    this.f34837d[e16] = d(this.entries[i16]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i17] = m(jArr[i17], d(jArr[i16]));
                }
                moveLastEntry(i16);
                this.f34839f--;
                this.modCount++;
                return v3;
            }
            int d16 = d(this.entries[i16]);
            if (d16 == -1) {
                return null;
            }
            i17 = i16;
            i16 = d16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public V j(int i3) {
        return i(this.keys[i3], c(this.entries[i3]));
    }

    private void k(int i3) {
        int length = this.entries.length;
        if (i3 > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                resizeEntries(max);
            }
        }
    }

    private void l(int i3) {
        if (this.f34837d.length >= 1073741824) {
            this.f34838e = Integer.MAX_VALUE;
            return;
        }
        int i16 = ((int) (i3 * this.loadFactor)) + 1;
        int[] h16 = h(i3);
        long[] jArr = this.entries;
        int length = h16.length - 1;
        for (int i17 = 0; i17 < this.f34839f; i17++) {
            int c16 = c(jArr[i17]);
            int i18 = c16 & length;
            int i19 = h16[i18];
            h16[i18] = i17;
            jArr[i17] = (c16 << 32) | (i19 & 4294967295L);
        }
        this.f34838e = i16;
        this.f34837d = h16;
    }

    private static long m(long j3, int i3) {
        return (j3 & (-4294967296L)) | (4294967295L & i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(3, 1.0f);
        int readInt = objectInputStream.readInt();
        while (true) {
            readInt--;
            if (readInt >= 0) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            } else {
                return;
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f34839f);
        for (int i3 = 0; i3 < this.f34839f; i3++) {
            objectOutputStream.writeObject(this.keys[i3]);
            objectOutputStream.writeObject(this.values[i3]);
        }
    }

    int adjustAfterRemove(int i3, int i16) {
        return i3 - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        Arrays.fill(this.keys, 0, this.f34839f, (Object) null);
        Arrays.fill(this.values, 0, this.f34839f, (Object) null);
        Arrays.fill(this.f34837d, -1);
        Arrays.fill(this.entries, -1L);
        this.f34839f = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        if (f(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        for (int i3 = 0; i3 < this.f34839f; i3++) {
            if (com.google.common.base.g.a(obj, this.values[i3])) {
                return true;
            }
        }
        return false;
    }

    Set<Map.Entry<K, V>> createEntrySet() {
        return new d();
    }

    Set<K> createKeySet() {
        return new f();
    }

    Collection<V> createValues() {
        return new h();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f34841i;
        if (set == null) {
            Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
            this.f34841i = createEntrySet;
            return createEntrySet;
        }
        return set;
    }

    Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new b();
    }

    int firstEntryIndex() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        int f16 = f(obj);
        accessEntry(f16);
        if (f16 == -1) {
            return null;
        }
        return (V) this.values[f16];
    }

    int getSuccessor(int i3) {
        int i16 = i3 + 1;
        if (i16 >= this.f34839f) {
            return -1;
        }
        return i16;
    }

    void init(int i3, float f16) {
        boolean z16;
        boolean z17 = false;
        if (i3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.e(z16, "Initial capacity must be non-negative");
        if (f16 > 0.0f) {
            z17 = true;
        }
        com.google.common.base.j.e(z17, "Illegal load factor");
        int a16 = p.a(i3, f16);
        this.f34837d = h(a16);
        this.loadFactor = f16;
        this.keys = new Object[i3];
        this.values = new Object[i3];
        this.entries = g(i3);
        this.f34838e = Math.max(1, (int) (a16 * f16));
    }

    void insertEntry(int i3, @NullableDecl K k3, @NullableDecl V v3, int i16) {
        this.entries[i3] = (i16 << 32) | 4294967295L;
        this.keys[i3] = k3;
        this.values[i3] = v3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        if (this.f34839f == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f34840h;
        if (set == null) {
            Set<K> createKeySet = createKeySet();
            this.f34840h = createKeySet;
            return createKeySet;
        }
        return set;
    }

    Iterator<K> keySetIterator() {
        return new a();
    }

    void moveLastEntry(int i3) {
        int size = size() - 1;
        if (i3 < size) {
            Object[] objArr = this.keys;
            objArr[i3] = objArr[size];
            Object[] objArr2 = this.values;
            objArr2[i3] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            long[] jArr = this.entries;
            long j3 = jArr[size];
            jArr[i3] = j3;
            jArr[size] = -1;
            int c16 = c(j3) & e();
            int[] iArr = this.f34837d;
            int i16 = iArr[c16];
            if (i16 == size) {
                iArr[c16] = i3;
                return;
            }
            while (true) {
                long j16 = this.entries[i16];
                int d16 = d(j16);
                if (d16 == size) {
                    this.entries[i16] = m(j16, i3);
                    return;
                }
                i16 = d16;
            }
        } else {
            this.keys[i3] = null;
            this.values[i3] = null;
            this.entries[i3] = -1;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V put(@NullableDecl K k3, @NullableDecl V v3) {
        long[] jArr = this.entries;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        int c16 = p.c(k3);
        int e16 = e() & c16;
        int i3 = this.f34839f;
        int[] iArr = this.f34837d;
        int i16 = iArr[e16];
        if (i16 == -1) {
            iArr[e16] = i3;
        } else {
            while (true) {
                long j3 = jArr[i16];
                if (c(j3) == c16 && com.google.common.base.g.a(k3, objArr[i16])) {
                    V v16 = (V) objArr2[i16];
                    objArr2[i16] = v3;
                    accessEntry(i16);
                    return v16;
                }
                int d16 = d(j3);
                if (d16 == -1) {
                    jArr[i16] = m(j3, i3);
                    break;
                }
                i16 = d16;
            }
        }
        if (i3 != Integer.MAX_VALUE) {
            int i17 = i3 + 1;
            k(i17);
            insertEntry(i3, k3, v3, c16);
            this.f34839f = i17;
            if (i3 >= this.f34838e) {
                l(this.f34837d.length * 2);
            }
            this.modCount++;
            return null;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V remove(@NullableDecl Object obj) {
        return i(obj, p.c(obj));
    }

    void resizeEntries(int i3) {
        this.keys = Arrays.copyOf(this.keys, i3);
        this.values = Arrays.copyOf(this.values, i3);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i3);
        if (i3 > length) {
            Arrays.fill(copyOf, length, i3, -1L);
        }
        this.entries = copyOf;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f34839f;
    }

    public void trimToSize() {
        int i3 = this.f34839f;
        if (i3 < this.entries.length) {
            resizeEntries(i3);
        }
        int max = Math.max(1, Integer.highestOneBit((int) (i3 / this.loadFactor)));
        if (max < 1073741824 && i3 / max > this.loadFactor) {
            max <<= 1;
        }
        if (max < this.f34837d.length) {
            l(max);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f34842m;
        if (collection == null) {
            Collection<V> createValues = createValues();
            this.f34842m = createValues;
            return createValues;
        }
        return collection;
    }

    Iterator<V> valuesIterator() {
        return new c();
    }

    CompactHashMap(int i3) {
        this(i3, 1.0f);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private abstract class e<T> implements Iterator<T> {

        /* renamed from: d, reason: collision with root package name */
        int f34847d;

        /* renamed from: e, reason: collision with root package name */
        int f34848e;

        /* renamed from: f, reason: collision with root package name */
        int f34849f;

        e() {
            this.f34847d = CompactHashMap.this.modCount;
            this.f34848e = CompactHashMap.this.firstEntryIndex();
            this.f34849f = -1;
        }

        private void a() {
            if (CompactHashMap.this.modCount == this.f34847d) {
            } else {
                throw new ConcurrentModificationException();
            }
        }

        abstract T b(int i3);

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f34848e >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (hasNext()) {
                int i3 = this.f34848e;
                this.f34849f = i3;
                T b16 = b(i3);
                this.f34848e = CompactHashMap.this.getSuccessor(this.f34848e);
                return b16;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z16;
            a();
            if (this.f34849f >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.google.common.collect.h.d(z16);
            this.f34847d++;
            CompactHashMap.this.j(this.f34849f);
            this.f34848e = CompactHashMap.this.adjustAfterRemove(this.f34848e, this.f34849f);
            this.f34849f = -1;
        }

        /* synthetic */ e(CompactHashMap compactHashMap, a aVar) {
            this();
        }
    }

    CompactHashMap(int i3, float f16) {
        init(i3, f16);
    }

    void accessEntry(int i3) {
    }
}
