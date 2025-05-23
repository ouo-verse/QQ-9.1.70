package android.support.v4.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes.dex */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
    MapCollections<K, V> mCollections;

    public ArrayMap() {
    }

    private MapCollections<K, V> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new MapCollections<K, V>() { // from class: android.support.v4.util.ArrayMap.1
                @Override // android.support.v4.util.MapCollections
                protected void colClear() {
                    ArrayMap.this.clear();
                }

                @Override // android.support.v4.util.MapCollections
                protected Object colGetEntry(int i3, int i16) {
                    return ArrayMap.this.mArray[(i3 << 1) + i16];
                }

                @Override // android.support.v4.util.MapCollections
                protected Map<K, V> colGetMap() {
                    return ArrayMap.this;
                }

                @Override // android.support.v4.util.MapCollections
                protected int colGetSize() {
                    return ArrayMap.this.mSize;
                }

                @Override // android.support.v4.util.MapCollections
                protected int colIndexOfKey(Object obj) {
                    return ArrayMap.this.indexOfKey(obj);
                }

                @Override // android.support.v4.util.MapCollections
                protected int colIndexOfValue(Object obj) {
                    return ArrayMap.this.indexOfValue(obj);
                }

                @Override // android.support.v4.util.MapCollections
                protected void colPut(K k3, V v3) {
                    ArrayMap.this.put(k3, v3);
                }

                @Override // android.support.v4.util.MapCollections
                protected void colRemoveAt(int i3) {
                    ArrayMap.this.removeAt(i3);
                }

                @Override // android.support.v4.util.MapCollections
                protected V colSetValue(int i3, V v3) {
                    return ArrayMap.this.setValueAt(i3, v3);
                }
            };
        }
        return this.mCollections;
    }

    public boolean containsAll(Collection<?> collection) {
        return MapCollections.containsAllHelper(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return getCollection().getEntrySet();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return getCollection().getKeySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean removeAll(Collection<?> collection) {
        return MapCollections.removeAllHelper(this, collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return MapCollections.retainAllHelper(this, collection);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return getCollection().getValues();
    }

    public ArrayMap(int i3) {
        super(i3);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
}
