package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MapField<K, V> implements ba {

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f35574a;

    /* renamed from: b, reason: collision with root package name */
    private volatile StorageMode f35575b;

    /* renamed from: c, reason: collision with root package name */
    private c<K, V> f35576c;

    /* renamed from: d, reason: collision with root package name */
    private List<ar> f35577d;

    /* renamed from: e, reason: collision with root package name */
    private final a<K, V> f35578e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum StorageMode {
        MAP,
        LIST,
        BOTH
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a<K, V> {
        void a(ar arVar, Map<K, V> map);

        ar b();

        ar c(K k3, V v3);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class b<K, V> implements a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private final al<K, V> f35579a;

        public b(al<K, V> alVar) {
            this.f35579a = alVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.MapField.a
        public void a(ar arVar, Map<K, V> map) {
            al alVar = (al) arVar;
            map.put(alVar.q(), alVar.s());
        }

        @Override // com.google.protobuf.MapField.a
        public ar b() {
            return this.f35579a;
        }

        @Override // com.google.protobuf.MapField.a
        public ar c(K k3, V v3) {
            return this.f35579a.newBuilderForType().n(k3).p(v3).buildPartial();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c<K, V> implements Map<K, V> {

        /* renamed from: d, reason: collision with root package name */
        private final ba f35580d;

        /* renamed from: e, reason: collision with root package name */
        private final Map<K, V> f35581e;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private static class a<E> implements Collection<E> {

            /* renamed from: d, reason: collision with root package name */
            private final ba f35582d;

            /* renamed from: e, reason: collision with root package name */
            private final Collection<E> f35583e;

            a(ba baVar, Collection<E> collection) {
                this.f35582d = baVar;
                this.f35583e = collection;
            }

            @Override // java.util.Collection
            public boolean add(E e16) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public void clear() {
                this.f35582d.a();
                this.f35583e.clear();
            }

            @Override // java.util.Collection
            public boolean contains(Object obj) {
                return this.f35583e.contains(obj);
            }

            @Override // java.util.Collection
            public boolean containsAll(Collection<?> collection) {
                return this.f35583e.containsAll(collection);
            }

            @Override // java.util.Collection
            public boolean equals(Object obj) {
                return this.f35583e.equals(obj);
            }

            @Override // java.util.Collection
            public int hashCode() {
                return this.f35583e.hashCode();
            }

            @Override // java.util.Collection
            public boolean isEmpty() {
                return this.f35583e.isEmpty();
            }

            @Override // java.util.Collection, java.lang.Iterable
            public Iterator<E> iterator() {
                return new b(this.f35582d, this.f35583e.iterator());
            }

            @Override // java.util.Collection
            public boolean remove(Object obj) {
                this.f35582d.a();
                return this.f35583e.remove(obj);
            }

            @Override // java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                this.f35582d.a();
                return this.f35583e.removeAll(collection);
            }

            @Override // java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                this.f35582d.a();
                return this.f35583e.retainAll(collection);
            }

            @Override // java.util.Collection
            public int size() {
                return this.f35583e.size();
            }

            @Override // java.util.Collection
            public Object[] toArray() {
                return this.f35583e.toArray();
            }

            public String toString() {
                return this.f35583e.toString();
            }

            @Override // java.util.Collection
            public <T> T[] toArray(T[] tArr) {
                return (T[]) this.f35583e.toArray(tArr);
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private static class b<E> implements Iterator<E> {

            /* renamed from: d, reason: collision with root package name */
            private final ba f35584d;

            /* renamed from: e, reason: collision with root package name */
            private final Iterator<E> f35585e;

            b(ba baVar, Iterator<E> it) {
                this.f35584d = baVar;
                this.f35585e = it;
            }

            public boolean equals(Object obj) {
                return this.f35585e.equals(obj);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f35585e.hasNext();
            }

            public int hashCode() {
                return this.f35585e.hashCode();
            }

            @Override // java.util.Iterator
            public E next() {
                return this.f35585e.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f35584d.a();
                this.f35585e.remove();
            }

            public String toString() {
                return this.f35585e.toString();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.google.protobuf.MapField$c$c, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0251c<E> implements Set<E> {

            /* renamed from: d, reason: collision with root package name */
            private final ba f35586d;

            /* renamed from: e, reason: collision with root package name */
            private final Set<E> f35587e;

            C0251c(ba baVar, Set<E> set) {
                this.f35586d = baVar;
                this.f35587e = set;
            }

            @Override // java.util.Set, java.util.Collection
            public boolean add(E e16) {
                this.f35586d.a();
                return this.f35587e.add(e16);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean addAll(Collection<? extends E> collection) {
                this.f35586d.a();
                return this.f35587e.addAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public void clear() {
                this.f35586d.a();
                this.f35587e.clear();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean contains(Object obj) {
                return this.f35587e.contains(obj);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean containsAll(Collection<?> collection) {
                return this.f35587e.containsAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean equals(Object obj) {
                return this.f35587e.equals(obj);
            }

            @Override // java.util.Set, java.util.Collection
            public int hashCode() {
                return this.f35587e.hashCode();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean isEmpty() {
                return this.f35587e.isEmpty();
            }

            @Override // java.util.Set, java.util.Collection, java.lang.Iterable
            public Iterator<E> iterator() {
                return new b(this.f35586d, this.f35587e.iterator());
            }

            @Override // java.util.Set, java.util.Collection
            public boolean remove(Object obj) {
                this.f35586d.a();
                return this.f35587e.remove(obj);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                this.f35586d.a();
                return this.f35587e.removeAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                this.f35586d.a();
                return this.f35587e.retainAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public int size() {
                return this.f35587e.size();
            }

            @Override // java.util.Set, java.util.Collection
            public Object[] toArray() {
                return this.f35587e.toArray();
            }

            public String toString() {
                return this.f35587e.toString();
            }

            @Override // java.util.Set, java.util.Collection
            public <T> T[] toArray(T[] tArr) {
                return (T[]) this.f35587e.toArray(tArr);
            }
        }

        c(ba baVar, Map<K, V> map) {
            this.f35580d = baVar;
            this.f35581e = map;
        }

        @Override // java.util.Map
        public void clear() {
            this.f35580d.a();
            this.f35581e.clear();
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return this.f35581e.containsKey(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.f35581e.containsValue(obj);
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new C0251c(this.f35580d, this.f35581e.entrySet());
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            return this.f35581e.equals(obj);
        }

        @Override // java.util.Map
        public V get(Object obj) {
            return this.f35581e.get(obj);
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.f35581e.hashCode();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.f35581e.isEmpty();
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            return new C0251c(this.f35580d, this.f35581e.keySet());
        }

        @Override // java.util.Map
        public V put(K k3, V v3) {
            this.f35580d.a();
            ad.a(k3);
            ad.a(v3);
            return this.f35581e.put(k3, v3);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            this.f35580d.a();
            for (K k3 : map.keySet()) {
                ad.a(k3);
                ad.a(map.get(k3));
            }
            this.f35581e.putAll(map);
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            this.f35580d.a();
            return this.f35581e.remove(obj);
        }

        @Override // java.util.Map
        public int size() {
            return this.f35581e.size();
        }

        public String toString() {
            return this.f35581e.toString();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            return new a(this.f35580d, this.f35581e.values());
        }
    }

    MapField(a<K, V> aVar, StorageMode storageMode, Map<K, V> map) {
        this.f35578e = aVar;
        this.f35574a = true;
        this.f35575b = storageMode;
        this.f35576c = new c<>(this, map);
        this.f35577d = null;
    }

    private ar c(K k3, V v3) {
        return this.f35578e.c(k3, v3);
    }

    private c<K, V> d(List<ar> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<ar> it = list.iterator();
        while (it.hasNext()) {
            f(it.next(), linkedHashMap);
        }
        return new c<>(this, linkedHashMap);
    }

    private List<ar> e(c<K, V> cVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<K, V> entry : cVar.entrySet()) {
            arrayList.add(c(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    private void f(ar arVar, Map<K, V> map) {
        this.f35578e.a(arVar, map);
    }

    public static <K, V> MapField<K, V> h(al<K, V> alVar) {
        return new MapField<>(alVar, StorageMode.MAP, Collections.emptyMap());
    }

    public static <K, V> MapField<K, V> q(al<K, V> alVar) {
        return new MapField<>(alVar, StorageMode.MAP, new LinkedHashMap());
    }

    @Override // com.google.protobuf.ba
    public void a() {
        if (n()) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void b() {
        this.f35576c = new c<>(this, new LinkedHashMap());
        this.f35575b = StorageMode.MAP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MapField)) {
            return false;
        }
        return MapFieldLite.equals(j(), ((MapField) obj).j());
    }

    public MapField<K, V> g() {
        return new MapField<>(this.f35578e, StorageMode.MAP, MapFieldLite.copy(j()));
    }

    public int hashCode() {
        return MapFieldLite.calculateHashCodeForMap(j());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ar> i() {
        StorageMode storageMode = this.f35575b;
        StorageMode storageMode2 = StorageMode.MAP;
        if (storageMode == storageMode2) {
            synchronized (this) {
                if (this.f35575b == storageMode2) {
                    this.f35577d = e(this.f35576c);
                    this.f35575b = StorageMode.BOTH;
                }
            }
        }
        return Collections.unmodifiableList(this.f35577d);
    }

    public Map<K, V> j() {
        StorageMode storageMode = this.f35575b;
        StorageMode storageMode2 = StorageMode.LIST;
        if (storageMode == storageMode2) {
            synchronized (this) {
                if (this.f35575b == storageMode2) {
                    this.f35576c = d(this.f35577d);
                    this.f35575b = StorageMode.BOTH;
                }
            }
        }
        return Collections.unmodifiableMap(this.f35576c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar k() {
        return this.f35578e.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ar> l() {
        StorageMode storageMode = this.f35575b;
        StorageMode storageMode2 = StorageMode.LIST;
        if (storageMode != storageMode2) {
            if (this.f35575b == StorageMode.MAP) {
                this.f35577d = e(this.f35576c);
            }
            this.f35576c = null;
            this.f35575b = storageMode2;
        }
        return this.f35577d;
    }

    public Map<K, V> m() {
        StorageMode storageMode = this.f35575b;
        StorageMode storageMode2 = StorageMode.MAP;
        if (storageMode != storageMode2) {
            if (this.f35575b == StorageMode.LIST) {
                this.f35576c = d(this.f35577d);
            }
            this.f35577d = null;
            this.f35575b = storageMode2;
        }
        return this.f35576c;
    }

    public boolean n() {
        return this.f35574a;
    }

    public void o() {
        this.f35574a = false;
    }

    public void p(MapField<K, V> mapField) {
        m().putAll(MapFieldLite.copy(mapField.j()));
    }

    MapField(al<K, V> alVar, StorageMode storageMode, Map<K, V> map) {
        this(new b(alVar), storageMode, map);
    }
}
