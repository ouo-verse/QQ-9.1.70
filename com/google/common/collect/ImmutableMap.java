package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];

    /* renamed from: d, reason: collision with root package name */
    @LazyInit
    private transient ImmutableSet<Map.Entry<K, V>> f34875d;

    /* renamed from: e, reason: collision with root package name */
    @RetainedWith
    @LazyInit
    private transient ImmutableSet<K> f34876e;

    /* renamed from: f, reason: collision with root package name */
    @RetainedWith
    @LazyInit
    private transient ImmutableCollection<V> f34877f;

    /* renamed from: h, reason: collision with root package name */
    @LazyInit
    private transient ImmutableSetMultimap<K, V> f34878h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        IteratorBasedImmutableMap() {
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new ImmutableMapEntrySet<K, V>() { // from class: com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.1EntrySetImpl
                @Override // com.google.common.collect.ImmutableMapEntrySet
                ImmutableMap<K, V> map() {
                    return IteratorBasedImmutableMap.this;
                }

                @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                public ai<Map.Entry<K, V>> iterator() {
                    return IteratorBasedImmutableMap.this.entryIterator();
                }
            };
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<K> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableCollection<V> createValues() {
            return new ImmutableMapValues(this);
        }

        abstract ai<Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a extends ai<Map.Entry<K, ImmutableSet<V>>> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Iterator f34879d;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            /* renamed from: com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$a$a, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0246a extends com.google.common.collect.b<K, ImmutableSet<V>> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Map.Entry f34881d;

                C0246a(Map.Entry entry) {
                    this.f34881d = entry;
                }

                @Override // com.google.common.collect.b, java.util.Map.Entry
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public ImmutableSet<V> getValue() {
                    return ImmutableSet.of(this.f34881d.getValue());
                }

                @Override // com.google.common.collect.b, java.util.Map.Entry
                public K getKey() {
                    return (K) this.f34881d.getKey();
                }
            }

            a(Iterator it) {
                this.f34879d = it;
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, ImmutableSet<V>> next() {
                return new C0246a((Map.Entry) this.f34879d.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f34879d.hasNext();
            }
        }

        MapViewOfValuesAsSingletonSets() {
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return ImmutableMap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        ImmutableSet<K> createKeySet() {
            return ImmutableMap.this.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        ai<Map.Entry<K, ImmutableSet<V>>> entryIterator() {
            return new a(ImmutableMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return ImmutableMap.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean isHashCodeFast() {
            return ImmutableMap.this.isHashCodeFast();
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean isPartialView() {
            return ImmutableMap.this.isPartialView();
        }

        @Override // java.util.Map
        public int size() {
            return ImmutableMap.this.size();
        }

        /* synthetic */ MapViewOfValuesAsSingletonSets(ImmutableMap immutableMap, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public ImmutableSet<V> get(@NullableDecl Object obj) {
            Object obj2 = ImmutableMap.this.get(obj);
            if (obj2 == null) {
                return null;
            }
            return ImmutableSet.of(obj2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] keys;
        private final Object[] values;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SerializedForm(ImmutableMap<?, ?> immutableMap) {
            this.keys = new Object[immutableMap.size()];
            this.values = new Object[immutableMap.size()];
            ai<Map.Entry<?, ?>> it = immutableMap.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                this.keys[i3] = next.getKey();
                this.values[i3] = next.getValue();
                i3++;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Object createMap(b<Object, Object> bVar) {
            int i3 = 0;
            while (true) {
                Object[] objArr = this.keys;
                if (i3 < objArr.length) {
                    bVar.c(objArr[i3], this.values[i3]);
                    i3++;
                } else {
                    return bVar.a();
                }
            }
        }

        Object readResolve() {
            return createMap(new b<>(this.keys.length));
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends ai<K> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ai f34883d;

        a(ai aiVar) {
            this.f34883d = aiVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f34883d.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) ((Map.Entry) this.f34883d.next()).getKey();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b<K, V> {

        /* renamed from: a, reason: collision with root package name */
        @MonotonicNonNullDecl
        Comparator<? super V> f34885a;

        /* renamed from: b, reason: collision with root package name */
        Object[] f34886b;

        /* renamed from: c, reason: collision with root package name */
        int f34887c;

        /* renamed from: d, reason: collision with root package name */
        boolean f34888d;

        public b() {
            this(4);
        }

        private void b(int i3) {
            int i16 = i3 * 2;
            Object[] objArr = this.f34886b;
            if (i16 > objArr.length) {
                this.f34886b = Arrays.copyOf(objArr, ImmutableCollection.b.e(objArr.length, i16));
                this.f34888d = false;
            }
        }

        public ImmutableMap<K, V> a() {
            f();
            this.f34888d = true;
            return RegularImmutableMap.create(this.f34887c, this.f34886b);
        }

        @CanIgnoreReturnValue
        public b<K, V> c(K k3, V v3) {
            b(this.f34887c + 1);
            h.a(k3, v3);
            Object[] objArr = this.f34886b;
            int i3 = this.f34887c;
            objArr[i3 * 2] = k3;
            objArr[(i3 * 2) + 1] = v3;
            this.f34887c = i3 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public b<K, V> d(Map.Entry<? extends K, ? extends V> entry) {
            return c(entry.getKey(), entry.getValue());
        }

        @CanIgnoreReturnValue
        @Beta
        public b<K, V> e(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                b(this.f34887c + ((Collection) iterable).size());
            }
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void f() {
            int i3;
            if (this.f34885a != null) {
                if (this.f34888d) {
                    this.f34886b = Arrays.copyOf(this.f34886b, this.f34887c * 2);
                }
                Map.Entry[] entryArr = new Map.Entry[this.f34887c];
                int i16 = 0;
                while (true) {
                    i3 = this.f34887c;
                    if (i16 >= i3) {
                        break;
                    }
                    Object[] objArr = this.f34886b;
                    int i17 = i16 * 2;
                    entryArr[i16] = new AbstractMap.SimpleImmutableEntry(objArr[i17], objArr[i17 + 1]);
                    i16++;
                }
                Arrays.sort(entryArr, 0, i3, Ordering.from(this.f34885a).onResultOf(Maps.o()));
                for (int i18 = 0; i18 < this.f34887c; i18++) {
                    int i19 = i18 * 2;
                    this.f34886b[i19] = entryArr[i18].getKey();
                    this.f34886b[i19 + 1] = entryArr[i18].getValue();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i3) {
            this.f34886b = new Object[i3 * 2];
            this.f34887c = 0;
            this.f34888d = false;
        }
    }

    public static <K, V> b<K, V> builder() {
        return new b<>();
    }

    @Beta
    public static <K, V> b<K, V> builderWithExpectedSize(int i3) {
        h.b(i3, "expectedSize");
        return new b<>(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkNoConflict(boolean z16, String str, Map.Entry<?, ?> entry, Map.Entry<?, ?> entry2) {
        if (z16) {
        } else {
            throw conflictException(str, entry, entry2);
        }
    }

    static IllegalArgumentException conflictException(String str, Object obj, Object obj2) {
        return new IllegalArgumentException("Multiple entries with same " + str + MsgSummary.STR_COLON + obj + " and " + obj2);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        }
        return copyOf(map.entrySet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map.Entry<K, V> entryOf(K k3, V v3) {
        h.a(k3, v3);
        return new AbstractMap.SimpleImmutableEntry(k3, v3);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.EMPTY;
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return ImmutableSetMultimap.of();
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.f34878h;
        if (immutableSetMultimap == null) {
            ImmutableSetMultimap<K, V> immutableSetMultimap2 = new ImmutableSetMultimap<>(new MapViewOfValuesAsSingletonSets(this, null), size(), null);
            this.f34878h = immutableSetMultimap2;
            return immutableSetMultimap2;
        }
        return immutableSetMultimap;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return values().contains(obj);
    }

    abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    abstract ImmutableSet<K> createKeySet();

    abstract ImmutableCollection<V> createValues();

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        return Maps.c(this, obj);
    }

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v3) {
        V v16 = get(obj);
        if (v16 != null) {
            return v16;
        }
        return v3;
    }

    @Override // java.util.Map
    public int hashCode() {
        return ab.b(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isHashCodeFast() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isPartialView();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai<K> keyIterator() {
        return new a(entrySet().iterator());
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V put(K k3, V v3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.n(this);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableMap<K, V> of(K k3, V v3) {
        h.a(k3, v3);
        return RegularImmutableMap.create(1, new Object[]{k3, v3});
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.f34875d;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.f34875d = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.f34876e;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> createKeySet = createKeySet();
        this.f34876e = createKeySet;
        return createKeySet;
    }

    @Override // java.util.Map
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.f34877f;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection<V> createValues = createValues();
        this.f34877f = createValues;
        return createValues;
    }

    public static <K, V> ImmutableMap<K, V> of(K k3, V v3, K k16, V v16) {
        h.a(k3, v3);
        h.a(k16, v16);
        return RegularImmutableMap.create(2, new Object[]{k3, v3, k16, v16});
    }

    @Beta
    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        b bVar = new b(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        bVar.e(iterable);
        return bVar.a();
    }

    public static <K, V> ImmutableMap<K, V> of(K k3, V v3, K k16, V v16, K k17, V v17) {
        h.a(k3, v3);
        h.a(k16, v16);
        h.a(k17, v17);
        return RegularImmutableMap.create(3, new Object[]{k3, v3, k16, v16, k17, v17});
    }

    public static <K, V> ImmutableMap<K, V> of(K k3, V v3, K k16, V v16, K k17, V v17, K k18, V v18) {
        h.a(k3, v3);
        h.a(k16, v16);
        h.a(k17, v17);
        h.a(k18, v18);
        return RegularImmutableMap.create(4, new Object[]{k3, v3, k16, v16, k17, v17, k18, v18});
    }

    public static <K, V> ImmutableMap<K, V> of(K k3, V v3, K k16, V v16, K k17, V v17, K k18, V v18, K k19, V v19) {
        h.a(k3, v3);
        h.a(k16, v16);
        h.a(k17, v17);
        h.a(k18, v18);
        h.a(k19, v19);
        return RegularImmutableMap.create(5, new Object[]{k3, v3, k16, v16, k17, v17, k18, v18, k19, v19});
    }
}
