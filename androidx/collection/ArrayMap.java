package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes.dex */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {

    @Nullable
    MapCollections<K, V> mCollections;

    public ArrayMap() {
    }

    private MapCollections<K, V> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new MapCollections<K, V>() { // from class: androidx.collection.ArrayMap.1
                @Override // androidx.collection.MapCollections
                protected void colClear() {
                    ArrayMap.this.clear();
                }

                @Override // androidx.collection.MapCollections
                protected Object colGetEntry(int i3, int i16) {
                    return ArrayMap.this.mArray[(i3 << 1) + i16];
                }

                @Override // androidx.collection.MapCollections
                protected Map<K, V> colGetMap() {
                    return ArrayMap.this;
                }

                @Override // androidx.collection.MapCollections
                protected int colGetSize() {
                    return ArrayMap.this.mSize;
                }

                @Override // androidx.collection.MapCollections
                protected int colIndexOfKey(Object obj) {
                    return ArrayMap.this.indexOfKey(obj);
                }

                @Override // androidx.collection.MapCollections
                protected int colIndexOfValue(Object obj) {
                    return ArrayMap.this.indexOfValue(obj);
                }

                @Override // androidx.collection.MapCollections
                protected void colPut(K k3, V v3) {
                    ArrayMap.this.put(k3, v3);
                }

                @Override // androidx.collection.MapCollections
                protected void colRemoveAt(int i3) {
                    ArrayMap.this.removeAt(i3);
                }

                @Override // androidx.collection.MapCollections
                protected V colSetValue(int i3, V v3) {
                    return ArrayMap.this.setValueAt(i3, v3);
                }
            };
        }
        return this.mCollections;
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
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

    public boolean removeAll(@NonNull Collection<?> collection) {
        return MapCollections.removeAllHelper(this, collection);
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
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
