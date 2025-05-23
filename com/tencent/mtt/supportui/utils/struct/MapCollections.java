package com.tencent.mtt.supportui.utils.struct;

import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class MapCollections<K, V> {

    /* renamed from: b, reason: collision with root package name */
    MapCollections<K, V>.EntrySet f337714b;

    /* renamed from: c, reason: collision with root package name */
    MapCollections<K, V>.KeySet f337715c;

    /* renamed from: d, reason: collision with root package name */
    MapCollections<K, V>.ValuesCollection f337716d;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    final class ArrayIterator<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        final int f337717a;

        /* renamed from: b, reason: collision with root package name */
        int f337718b;

        /* renamed from: c, reason: collision with root package name */
        int f337719c;

        /* renamed from: d, reason: collision with root package name */
        boolean f337720d = false;

        ArrayIterator(int i3) {
            this.f337717a = i3;
            this.f337718b = MapCollections.this.colGetSize();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f337719c < this.f337718b) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            T t16 = (T) MapCollections.this.colGetEntry(this.f337719c, this.f337717a);
            this.f337719c++;
            this.f337720d = true;
            return t16;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f337720d) {
                int i3 = this.f337719c - 1;
                this.f337719c = i3;
                this.f337718b--;
                this.f337720d = false;
                MapCollections.this.colRemoveAt(i3);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    final class EntrySet implements Set<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int colGetSize = MapCollections.this.colGetSize();
            for (Map.Entry<K, V> entry : collection) {
                MapCollections.this.colPut(entry.getKey(), entry.getValue());
            }
            if (colGetSize != MapCollections.this.colGetSize()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            MapCollections.this.colClear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int colIndexOfKey = MapCollections.this.colIndexOfKey(entry.getKey());
            if (colIndexOfKey < 0) {
                return false;
            }
            return ContainerHelpers.equal(MapCollections.this.colGetEntry(colIndexOfKey, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return MapCollections.equalsSetHelper(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int hashCode;
            int hashCode2;
            int i3 = 0;
            for (int colGetSize = MapCollections.this.colGetSize() - 1; colGetSize >= 0; colGetSize--) {
                Object colGetEntry = MapCollections.this.colGetEntry(colGetSize, 0);
                Object colGetEntry2 = MapCollections.this.colGetEntry(colGetSize, 1);
                if (colGetEntry == null) {
                    hashCode = 0;
                } else {
                    hashCode = colGetEntry.hashCode();
                }
                if (colGetEntry2 == null) {
                    hashCode2 = 0;
                } else {
                    hashCode2 = colGetEntry2.hashCode();
                }
                i3 += hashCode ^ hashCode2;
            }
            return i3;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            if (MapCollections.this.colGetSize() == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new MapIterator();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return MapCollections.this.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    final class KeySet implements Set<K> {
        KeySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k3) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            MapCollections.this.colClear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (MapCollections.this.colIndexOfKey(obj) >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return MapCollections.containsAllHelper(MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return MapCollections.equalsSetHelper(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int hashCode;
            int i3 = 0;
            for (int colGetSize = MapCollections.this.colGetSize() - 1; colGetSize >= 0; colGetSize--) {
                Object colGetEntry = MapCollections.this.colGetEntry(colGetSize, 0);
                if (colGetEntry == null) {
                    hashCode = 0;
                } else {
                    hashCode = colGetEntry.hashCode();
                }
                i3 += hashCode;
            }
            return i3;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            if (MapCollections.this.colGetSize() == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new ArrayIterator(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int colIndexOfKey = MapCollections.this.colIndexOfKey(obj);
            if (colIndexOfKey >= 0) {
                MapCollections.this.colRemoveAt(colIndexOfKey);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return MapCollections.removeAllHelper(MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return MapCollections.retainAllHelper(MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return MapCollections.this.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return MapCollections.this.toArrayHelper(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.toArrayHelper(tArr, 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        int f337724a;

        /* renamed from: c, reason: collision with root package name */
        boolean f337726c = false;

        /* renamed from: b, reason: collision with root package name */
        int f337725b = -1;

        MapIterator() {
            this.f337724a = MapCollections.this.colGetSize() - 1;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (this.f337726c) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!ContainerHelpers.equal(entry.getKey(), MapCollections.this.colGetEntry(this.f337725b, 0)) || !ContainerHelpers.equal(entry.getValue(), MapCollections.this.colGetEntry(this.f337725b, 1))) {
                    return false;
                }
                return true;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f337726c) {
                return (K) MapCollections.this.colGetEntry(this.f337725b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f337726c) {
                return (V) MapCollections.this.colGetEntry(this.f337725b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f337725b < this.f337724a) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            int hashCode;
            if (this.f337726c) {
                int i3 = 0;
                Object colGetEntry = MapCollections.this.colGetEntry(this.f337725b, 0);
                Object colGetEntry2 = MapCollections.this.colGetEntry(this.f337725b, 1);
                if (colGetEntry == null) {
                    hashCode = 0;
                } else {
                    hashCode = colGetEntry.hashCode();
                }
                if (colGetEntry2 != null) {
                    i3 = colGetEntry2.hashCode();
                }
                return hashCode ^ i3;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f337726c) {
                MapCollections.this.colRemoveAt(this.f337725b);
                this.f337725b--;
                this.f337724a--;
                this.f337726c = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v3) {
            if (this.f337726c) {
                return (V) MapCollections.this.colSetValue(this.f337725b, v3);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + ContainerUtils.KEY_VALUE_DELIMITER + getValue();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.f337725b++;
            this.f337726c = true;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    final class ValuesCollection implements Collection<V> {
        ValuesCollection() {
        }

        @Override // java.util.Collection
        public boolean add(V v3) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            MapCollections.this.colClear();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            if (MapCollections.this.colIndexOfValue(obj) >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            if (MapCollections.this.colGetSize() == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ArrayIterator(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int colIndexOfValue = MapCollections.this.colIndexOfValue(obj);
            if (colIndexOfValue >= 0) {
                MapCollections.this.colRemoveAt(colIndexOfValue);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int colGetSize = MapCollections.this.colGetSize();
            int i3 = 0;
            boolean z16 = false;
            while (i3 < colGetSize) {
                if (collection.contains(MapCollections.this.colGetEntry(i3, 1))) {
                    MapCollections.this.colRemoveAt(i3);
                    i3--;
                    colGetSize--;
                    z16 = true;
                }
                i3++;
            }
            return z16;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int colGetSize = MapCollections.this.colGetSize();
            int i3 = 0;
            boolean z16 = false;
            while (i3 < colGetSize) {
                if (!collection.contains(MapCollections.this.colGetEntry(i3, 1))) {
                    MapCollections.this.colRemoveAt(i3);
                    i3--;
                    colGetSize--;
                    z16 = true;
                }
                i3++;
            }
            return z16;
        }

        @Override // java.util.Collection
        public int size() {
            return MapCollections.this.colGetSize();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return MapCollections.this.toArrayHelper(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.toArrayHelper(tArr, 1);
        }
    }

    public static <K, V> boolean containsAllHelper(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean equalsSetHelper(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean removeAllHelper(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    public static <K, V> boolean retainAllHelper(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    protected abstract void colClear();

    protected abstract Object colGetEntry(int i3, int i16);

    protected abstract Map<K, V> colGetMap();

    protected abstract int colGetSize();

    protected abstract int colIndexOfKey(Object obj);

    protected abstract int colIndexOfValue(Object obj);

    protected abstract void colPut(K k3, V v3);

    protected abstract void colRemoveAt(int i3);

    protected abstract V colSetValue(int i3, V v3);

    public Set<Map.Entry<K, V>> getEntrySet() {
        if (this.f337714b == null) {
            this.f337714b = new EntrySet();
        }
        return this.f337714b;
    }

    public Set<K> getKeySet() {
        if (this.f337715c == null) {
            this.f337715c = new KeySet();
        }
        return this.f337715c;
    }

    public Collection<V> getValues() {
        if (this.f337716d == null) {
            this.f337716d = new ValuesCollection();
        }
        return this.f337716d;
    }

    public Object[] toArrayHelper(int i3) {
        int colGetSize = colGetSize();
        Object[] objArr = new Object[colGetSize];
        for (int i16 = 0; i16 < colGetSize; i16++) {
            objArr[i16] = colGetEntry(i16, i3);
        }
        return objArr;
    }

    public <T> T[] toArrayHelper(T[] tArr, int i3) {
        int colGetSize = colGetSize();
        if (tArr.length < colGetSize) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), colGetSize));
        }
        for (int i16 = 0; i16 < colGetSize; i16++) {
            tArr[i16] = colGetEntry(i16, i3);
        }
        if (tArr.length > colGetSize) {
            tArr[colGetSize] = null;
        }
        return tArr;
    }
}
