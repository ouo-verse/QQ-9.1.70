package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {
    private static final Comparator<Comparable> D = Ordering.natural();
    private static final ImmutableSortedMap<Comparable, Object> E = new ImmutableSortedMap<>(ImmutableSortedSet.emptySet(Ordering.natural()), ImmutableList.of());
    private static final long serialVersionUID = 0;
    private transient ImmutableSortedMap<K, V> C;

    /* renamed from: i, reason: collision with root package name */
    private final transient RegularImmutableSortedSet<K> f34923i;

    /* renamed from: m, reason: collision with root package name */
    private final transient ImmutableList<V> f34924m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class SerializedForm extends ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0;
        private final Comparator<Object> comparator;

        SerializedForm(ImmutableSortedMap<?, ?> immutableSortedMap) {
            super(immutableSortedMap);
            this.comparator = immutableSortedMap.comparator();
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        Object readResolve() {
            return createMap(new b(this.comparator));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements Comparator<Map.Entry<K, V>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f34925d;

        a(Comparator comparator) {
            this.f34925d = comparator;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<K, V> entry, Map.Entry<K, V> entry2) {
            return this.f34925d.compare(entry.getKey(), entry2.getKey());
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b<K, V> extends ImmutableMap.b<K, V> {

        /* renamed from: e, reason: collision with root package name */
        private transient Object[] f34926e;

        /* renamed from: f, reason: collision with root package name */
        private transient Object[] f34927f;

        /* renamed from: g, reason: collision with root package name */
        private final Comparator<? super K> f34928g;

        public b(Comparator<? super K> comparator) {
            this(comparator, 4);
        }

        private void b(int i3) {
            Object[] objArr = this.f34926e;
            if (i3 > objArr.length) {
                int e16 = ImmutableCollection.b.e(objArr.length, i3);
                this.f34926e = Arrays.copyOf(this.f34926e, e16);
                this.f34927f = Arrays.copyOf(this.f34927f, e16);
            }
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedMap<K, V> a() {
            int i3 = this.f34887c;
            if (i3 != 0) {
                if (i3 == 1) {
                    return ImmutableSortedMap.g(this.f34928g, this.f34926e[0], this.f34927f[0]);
                }
                Object[] copyOf = Arrays.copyOf(this.f34926e, i3);
                Arrays.sort(copyOf, this.f34928g);
                Object[] objArr = new Object[this.f34887c];
                for (int i16 = 0; i16 < this.f34887c; i16++) {
                    if (i16 > 0) {
                        int i17 = i16 - 1;
                        if (this.f34928g.compare(copyOf[i17], copyOf[i16]) == 0) {
                            throw new IllegalArgumentException("keys required to be distinct but compared as equal: " + copyOf[i17] + " and " + copyOf[i16]);
                        }
                    }
                    objArr[Arrays.binarySearch(copyOf, this.f34926e[i16], this.f34928g)] = this.f34927f[i16];
                }
                return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.asImmutableList(copyOf), this.f34928g), ImmutableList.asImmutableList(objArr));
            }
            return ImmutableSortedMap.emptyMap(this.f34928g);
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public b<K, V> c(K k3, V v3) {
            b(this.f34887c + 1);
            h.a(k3, v3);
            Object[] objArr = this.f34926e;
            int i3 = this.f34887c;
            objArr[i3] = k3;
            this.f34927f[i3] = v3;
            this.f34887c = i3 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public b<K, V> d(Map.Entry<? extends K, ? extends V> entry) {
            super.d(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @CanIgnoreReturnValue
        @Beta
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public b<K, V> e(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.e(iterable);
            return this;
        }

        b(Comparator<? super K> comparator, int i3) {
            this.f34928g = (Comparator) com.google.common.base.j.m(comparator);
            this.f34926e = new Object[i3];
            this.f34927f = new Object[i3];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList) {
        this(regularImmutableSortedSet, immutableList, null);
    }

    private static <K, V> ImmutableSortedMap<K, V> c(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        boolean equals;
        boolean z16 = false;
        if (map instanceof SortedMap) {
            Comparator<? super K> comparator2 = ((SortedMap) map).comparator();
            if (comparator2 == null) {
                if (comparator == D) {
                    equals = true;
                }
            } else {
                equals = comparator.equals(comparator2);
            }
            z16 = equals;
        }
        if (z16 && (map instanceof ImmutableSortedMap)) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) map;
            if (!immutableSortedMap.isPartialView()) {
                return immutableSortedMap;
            }
        }
        return d(comparator, z16, map.entrySet());
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        return c(map, (Ordering) D);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> sortedMap) {
        Comparator<? super K> comparator = sortedMap.comparator();
        if (comparator == null) {
            comparator = D;
        }
        if (sortedMap instanceof ImmutableSortedMap) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) sortedMap;
            if (!immutableSortedMap.isPartialView()) {
                return immutableSortedMap;
            }
        }
        return d(comparator, true, sortedMap.entrySet());
    }

    private static <K, V> ImmutableSortedMap<K, V> d(Comparator<? super K> comparator, boolean z16, Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) q.l(iterable, ImmutableMap.EMPTY_ENTRY_ARRAY);
        return e(comparator, z16, entryArr, entryArr.length);
    }

    private static <K, V> ImmutableSortedMap<K, V> e(Comparator<? super K> comparator, boolean z16, Map.Entry<K, V>[] entryArr, int i3) {
        boolean z17;
        if (i3 != 0) {
            if (i3 != 1) {
                Object[] objArr = new Object[i3];
                Object[] objArr2 = new Object[i3];
                if (z16) {
                    for (int i16 = 0; i16 < i3; i16++) {
                        K key = entryArr[i16].getKey();
                        V value = entryArr[i16].getValue();
                        h.a(key, value);
                        objArr[i16] = key;
                        objArr2[i16] = value;
                    }
                } else {
                    Arrays.sort(entryArr, 0, i3, new a(comparator));
                    Object key2 = entryArr[0].getKey();
                    objArr[0] = key2;
                    V value2 = entryArr[0].getValue();
                    objArr2[0] = value2;
                    h.a(objArr[0], value2);
                    int i17 = 1;
                    while (i17 < i3) {
                        Object key3 = entryArr[i17].getKey();
                        V value3 = entryArr[i17].getValue();
                        h.a(key3, value3);
                        objArr[i17] = key3;
                        objArr2[i17] = value3;
                        if (comparator.compare(key2, key3) != 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        ImmutableMap.checkNoConflict(z17, "key", entryArr[i17 - 1], entryArr[i17]);
                        i17++;
                        key2 = key3;
                    }
                }
                return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.asImmutableList(objArr), comparator), ImmutableList.asImmutableList(objArr2));
            }
            return g(comparator, entryArr[0].getKey(), entryArr[0].getValue());
        }
        return emptyMap(comparator);
    }

    static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return of();
        }
        return new ImmutableSortedMap<>(ImmutableSortedSet.emptySet(comparator), ImmutableList.of());
    }

    private ImmutableSortedMap<K, V> f(int i3, int i16) {
        if (i3 == 0 && i16 == size()) {
            return this;
        }
        if (i3 == i16) {
            return emptyMap(comparator());
        }
        return new ImmutableSortedMap<>(this.f34923i.getSubSet(i3, i16), this.f34924m.subList(i3, i16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> ImmutableSortedMap<K, V> g(Comparator<? super K> comparator, K k3, V v3) {
        return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.of(k3), (Comparator) com.google.common.base.j.m(comparator)), ImmutableList.of(v3));
    }

    private static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> h(Map.Entry<K, V>... entryArr) {
        return e(Ordering.natural(), false, entryArr, entryArr.length);
    }

    public static <K extends Comparable<?>, V> b<K, V> naturalOrder() {
        return new b<>(Ordering.natural());
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return (ImmutableSortedMap<K, V>) E;
    }

    public static <K, V> b<K, V> orderedBy(Comparator<K> comparator) {
        return new b<>(comparator);
    }

    public static <K extends Comparable<?>, V> b<K, V> reverseOrder() {
        return new b<>(Ordering.natural().reverse());
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k3) {
        return tailMap((ImmutableSortedMap<K, V>) k3, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k3) {
        return (K) Maps.h(ceilingEntry(k3));
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        if (isEmpty()) {
            return ImmutableSet.of();
        }
        return new ImmutableMapEntrySet<K, V>() { // from class: com.google.common.collect.ImmutableSortedMap.1EntrySet
            @Override // com.google.common.collect.ImmutableSet
            ImmutableList<Map.Entry<K, V>> createAsList() {
                return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.ImmutableSortedMap.1EntrySet.1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Override // com.google.common.collect.ImmutableCollection
                    public boolean isPartialView() {
                        return true;
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                    public int size() {
                        return ImmutableSortedMap.this.size();
                    }

                    @Override // java.util.List
                    public Map.Entry<K, V> get(int i3) {
                        return new AbstractMap.SimpleImmutableEntry(ImmutableSortedMap.this.f34923i.asList().get(i3), ImmutableSortedMap.this.f34924m.get(i3));
                    }
                };
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet
            ImmutableMap<K, V> map() {
                return ImmutableSortedMap.this;
            }

            @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public ai<Map.Entry<K, V>> iterator() {
                return asList().iterator();
            }
        };
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(0);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k3) {
        return headMap((ImmutableSortedMap<K, V>) k3, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k3) {
        return (K) Maps.h(floorEntry(k3));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        int indexOf = this.f34923i.indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        return this.f34924m.get(indexOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap headMap(Object obj, boolean z16) {
        return headMap((ImmutableSortedMap<K, V>) obj, z16);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k3) {
        return tailMap((ImmutableSortedMap<K, V>) k3, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k3) {
        return (K) Maps.h(higherEntry(k3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        if (!this.f34923i.isPartialView() && !this.f34924m.isPartialView()) {
            return false;
        }
        return true;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(size() - 1);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k3) {
        return headMap((ImmutableSortedMap<K, V>) k3, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k3) {
        return (K) Maps.h(lowerEntry(k3));
    }

    @Override // java.util.NavigableMap
    @CanIgnoreReturnValue
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @CanIgnoreReturnValue
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this.f34924m.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap subMap(Object obj, boolean z16, Object obj2, boolean z17) {
        return subMap((boolean) obj, z16, (boolean) obj2, z17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap tailMap(Object obj, boolean z16) {
        return tailMap((ImmutableSortedMap<K, V>) obj, z16);
    }

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new SerializedForm(this);
    }

    ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList, ImmutableSortedMap<K, V> immutableSortedMap) {
        this.f34923i = regularImmutableSortedSet;
        this.f34924m = immutableList;
        this.C = immutableSortedMap;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj) {
        return g(Ordering.natural(), comparable, obj);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> descendingKeySet() {
        return this.f34923i.descendingSet();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> immutableSortedMap = this.C;
        if (immutableSortedMap != null) {
            return immutableSortedMap;
        }
        if (isEmpty()) {
            return emptyMap(Ordering.from(comparator()).reverse());
        }
        return new ImmutableSortedMap<>((RegularImmutableSortedSet) this.f34923i.descendingSet(), this.f34924m.reverse(), this);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
        return headMap((ImmutableSortedMap<K, V>) obj);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> navigableKeySet() {
        return this.f34923i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap((ImmutableSortedMap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableCollection<V> values() {
        return this.f34924m;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        return c(map, (Comparator) com.google.common.base.j.m(comparator));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2) {
        return h(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> headMap(K k3) {
        return headMap((ImmutableSortedMap<K, V>) k3, false);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSortedSet<K> keySet() {
        return this.f34923i;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> subMap(K k3, K k16) {
        return subMap((boolean) k3, true, (boolean) k16, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> tailMap(K k3) {
        return tailMap((ImmutableSortedMap<K, V>) k3, true);
    }

    @Beta
    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return copyOf(iterable, (Ordering) D);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3) {
        return h(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3));
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> headMap(K k3, boolean z16) {
        return f(0, this.f34923i.headIndex(com.google.common.base.j.m(k3), z16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> subMap(K k3, boolean z16, K k16, boolean z17) {
        com.google.common.base.j.m(k3);
        com.google.common.base.j.m(k16);
        com.google.common.base.j.j(comparator().compare(k3, k16) <= 0, "expected fromKey <= toKey but %s > %s", k3, k16);
        return headMap((ImmutableSortedMap<K, V>) k16, z17).tailMap((ImmutableSortedMap<K, V>) k3, z16);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> tailMap(K k3, boolean z16) {
        return f(this.f34923i.tailIndex(com.google.common.base.j.m(k3), z16), size());
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4) {
        return h(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3), ImmutableMap.entryOf(comparable4, obj4));
    }

    @Beta
    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable, Comparator<? super K> comparator) {
        return d((Comparator) com.google.common.base.j.m(comparator), false, iterable);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5) {
        return h(ImmutableMap.entryOf(comparable, obj), ImmutableMap.entryOf(comparable2, obj2), ImmutableMap.entryOf(comparable3, obj3), ImmutableMap.entryOf(comparable4, obj4), ImmutableMap.entryOf(comparable5, obj5));
    }
}
