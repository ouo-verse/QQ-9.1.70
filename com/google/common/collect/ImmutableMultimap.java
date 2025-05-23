package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.aa;
import com.google.common.collect.u;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public abstract class ImmutableMultimap<K, V> extends f<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;

        @Weak
        final ImmutableMultimap<K, V> multimap;

        EntryCollection(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.multimap.containsEntry(entry.getKey(), entry.getValue());
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public ai<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class Keys extends ImmutableMultiset<K> {
        Keys() {
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.u
        public int count(@NullableDecl Object obj) {
            ImmutableCollection<V> immutableCollection = ImmutableMultimap.this.map.get(obj);
            if (immutableCollection == null) {
                return 0;
            }
            return immutableCollection.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset
        u.a<K> getEntry(int i3) {
            Map.Entry<K, ? extends ImmutableCollection<V>> entry = ImmutableMultimap.this.map.entrySet().asList().get(i3);
            return Multisets.f(entry.getKey(), entry.getValue().size());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.u
        public int size() {
            return ImmutableMultimap.this.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        Object writeReplace() {
            return new KeysSerializedForm(ImmutableMultimap.this);
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.u
        public ImmutableSet<K> elementSet() {
            return ImmutableMultimap.this.keySet();
        }
    }

    /* compiled from: P */
    @GwtIncompatible
    /* loaded from: classes2.dex */
    private static final class KeysSerializedForm implements Serializable {
        final ImmutableMultimap<?, ?> multimap;

        KeysSerializedForm(ImmutableMultimap<?, ?> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        Object readResolve() {
            return this.multimap.keys();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Values<K, V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;

        /* renamed from: e, reason: collision with root package name */
        @Weak
        private final transient ImmutableMultimap<K, V> f34891e;

        Values(ImmutableMultimap<K, V> immutableMultimap) {
            this.f34891e = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            return this.f34891e.containsValue(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        public int copyIntoArray(Object[] objArr, int i3) {
            ai<? extends ImmutableCollection<V>> it = this.f34891e.map.values().iterator();
            while (it.hasNext()) {
                i3 = it.next().copyIntoArray(objArr, i3);
            }
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f34891e.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public ai<V> iterator() {
            return this.f34891e.valueIterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends ai<Map.Entry<K, V>> {

        /* renamed from: d, reason: collision with root package name */
        final Iterator<? extends Map.Entry<K, ? extends ImmutableCollection<V>>> f34892d;

        /* renamed from: e, reason: collision with root package name */
        K f34893e = null;

        /* renamed from: f, reason: collision with root package name */
        Iterator<V> f34894f = r.j();

        a() {
            this.f34892d = ImmutableMultimap.this.map.entrySet().iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!this.f34894f.hasNext()) {
                Map.Entry<K, ? extends ImmutableCollection<V>> next = this.f34892d.next();
                this.f34893e = next.getKey();
                this.f34894f = next.getValue().iterator();
            }
            return Maps.d(this.f34893e, this.f34894f.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f34894f.hasNext() && !this.f34892d.hasNext()) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b extends ai<V> {

        /* renamed from: d, reason: collision with root package name */
        Iterator<? extends ImmutableCollection<V>> f34896d;

        /* renamed from: e, reason: collision with root package name */
        Iterator<V> f34897e = r.j();

        b() {
            this.f34896d = ImmutableMultimap.this.map.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f34897e.hasNext() && !this.f34896d.hasNext()) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public V next() {
            if (!this.f34897e.hasNext()) {
                this.f34897e = this.f34896d.next().iterator();
            }
            return this.f34897e.next();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c<K, V> {

        /* renamed from: a, reason: collision with root package name */
        Map<K, Collection<V>> f34899a = y.d();

        /* renamed from: b, reason: collision with root package name */
        @MonotonicNonNullDecl
        Comparator<? super K> f34900b;

        /* renamed from: c, reason: collision with root package name */
        @MonotonicNonNullDecl
        Comparator<? super V> f34901c;

        public ImmutableMultimap<K, V> a() {
            Collection entrySet = this.f34899a.entrySet();
            Comparator<? super K> comparator = this.f34900b;
            if (comparator != null) {
                entrySet = Ordering.from(comparator).onKeys().immutableSortedCopy(entrySet);
            }
            return ImmutableListMultimap.fromMapEntries(entrySet, this.f34901c);
        }

        Collection<V> b() {
            return new ArrayList();
        }

        @CanIgnoreReturnValue
        public c<K, V> c(K k3, V v3) {
            h.a(k3, v3);
            Collection<V> collection = this.f34899a.get(k3);
            if (collection == null) {
                Map<K, Collection<V>> map = this.f34899a;
                Collection<V> b16 = b();
                map.put(k3, b16);
                collection = b16;
            }
            collection.add(v3);
            return this;
        }

        @CanIgnoreReturnValue
        public c<K, V> d(Map.Entry<? extends K, ? extends V> entry) {
            return c(entry.getKey(), entry.getValue());
        }

        @CanIgnoreReturnValue
        @Beta
        public c<K, V> e(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
            return this;
        }
    }

    /* compiled from: P */
    @GwtIncompatible
    /* loaded from: classes2.dex */
    static class d {

        /* renamed from: a, reason: collision with root package name */
        static final aa.b<ImmutableMultimap> f34902a = aa.a(ImmutableMultimap.class, "map");

        /* renamed from: b, reason: collision with root package name */
        static final aa.b<ImmutableMultimap> f34903b = aa.a(ImmutableMultimap.class, "size");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i3) {
        this.map = immutableMap;
        this.size = i3;
    }

    public static <K, V> c<K, V> builder() {
        return new c<>();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(s<? extends K, ? extends V> sVar) {
        if (sVar instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) sVar;
            if (!immutableMultimap.isPartialView()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf((s) sVar);
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.c
    public boolean containsValue(@NullableDecl Object obj) {
        if (obj != null && super.containsValue(obj)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.c
    Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.c
    Set<K> createKeySet() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.s
    public abstract ImmutableCollection<V> get(K k3);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.s
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((ImmutableMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract ImmutableMultimap<V, K> inverse();

    @Override // com.google.common.collect.c, com.google.common.collect.s
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // com.google.common.collect.c
    @CanIgnoreReturnValue
    @Deprecated
    public boolean put(K k3, V v3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c
    @CanIgnoreReturnValue
    @Deprecated
    public boolean putAll(K k3, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c
    @CanIgnoreReturnValue
    @Deprecated
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.s
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k3, V v3) {
        return ImmutableListMultimap.of((Object) k3, (Object) v3);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.s
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    public ImmutableCollection<Map.Entry<K, V>> createEntries() {
        return new EntryCollection(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    public ImmutableMultiset<K> createKeys() {
        return new Keys();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    public ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.s
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    public ai<Map.Entry<K, V>> entryIterator() {
        return new a();
    }

    @Override // com.google.common.collect.c
    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.c
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @Override // com.google.common.collect.c
    @CanIgnoreReturnValue
    @Deprecated
    public boolean putAll(s<? extends K, ? extends V> sVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.s
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableCollection<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableCollection<V> replaceValues(K k3, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    public ai<V> valueIterator() {
        return new b();
    }

    @Override // com.google.common.collect.c
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k3, V v3, K k16, V v16) {
        return ImmutableListMultimap.of((Object) k3, (Object) v3, (Object) k16, (Object) v16);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k3, V v3, K k16, V v16, K k17, V v17) {
        return ImmutableListMultimap.of((Object) k3, (Object) v3, (Object) k16, (Object) v16, (Object) k17, (Object) v17);
    }

    @Beta
    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return ImmutableListMultimap.copyOf((Iterable) iterable);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k3, V v3, K k16, V v16, K k17, V v17, K k18, V v18) {
        return ImmutableListMultimap.of((Object) k3, (Object) v3, (Object) k16, (Object) v16, (Object) k17, (Object) v17, (Object) k18, (Object) v18);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k3, V v3, K k16, V v16, K k17, V v17, K k18, V v18, K k19, V v19) {
        return ImmutableListMultimap.of((Object) k3, (Object) v3, (Object) k16, (Object) v16, (Object) k17, (Object) v17, (Object) k18, (Object) v18, (Object) k19, (Object) v19);
    }
}
