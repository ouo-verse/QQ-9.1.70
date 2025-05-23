package com.tencent.mtt.supportui.utils.struct;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {

    /* renamed from: a, reason: collision with root package name */
    MapCollections<K, V> f337709a;

    public ArrayMap() {
    }

    public ArrayMap(int i3) {
        super(i3);
    }

    private MapCollections<K, V> b() {
        if (this.f337709a == null) {
            this.f337709a = new MapCollections<K, V>() { // from class: com.tencent.mtt.supportui.utils.struct.ArrayMap.1
                @Override // com.tencent.mtt.supportui.utils.struct.MapCollections
                protected void colClear() {
                    ArrayMap.this.clear();
                }

                @Override // com.tencent.mtt.supportui.utils.struct.MapCollections
                protected Object colGetEntry(int i3, int i16) {
                    return ArrayMap.this.f337737g[(i3 << 1) + i16];
                }

                @Override // com.tencent.mtt.supportui.utils.struct.MapCollections
                protected Map<K, V> colGetMap() {
                    return ArrayMap.this;
                }

                @Override // com.tencent.mtt.supportui.utils.struct.MapCollections
                protected int colGetSize() {
                    return ArrayMap.this.f337738h;
                }

                @Override // com.tencent.mtt.supportui.utils.struct.MapCollections
                protected int colIndexOfKey(Object obj) {
                    if (obj == null) {
                        return ArrayMap.this.a();
                    }
                    return ArrayMap.this.a(obj, obj.hashCode());
                }

                @Override // com.tencent.mtt.supportui.utils.struct.MapCollections
                protected int colIndexOfValue(Object obj) {
                    return ArrayMap.this.a(obj);
                }

                @Override // com.tencent.mtt.supportui.utils.struct.MapCollections
                protected void colPut(K k3, V v3) {
                    ArrayMap.this.put(k3, v3);
                }

                @Override // com.tencent.mtt.supportui.utils.struct.MapCollections
                protected void colRemoveAt(int i3) {
                    ArrayMap.this.removeAt(i3);
                }

                @Override // com.tencent.mtt.supportui.utils.struct.MapCollections
                protected V colSetValue(int i3, V v3) {
                    return ArrayMap.this.setValueAt(i3, v3);
                }
            };
        }
        return this.f337709a;
    }

    public boolean containsAll(Collection<?> collection) {
        return MapCollections.containsAllHelper(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return b().getEntrySet();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return b().getKeySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.f337738h + map.size());
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
        return b().getValues();
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
}
