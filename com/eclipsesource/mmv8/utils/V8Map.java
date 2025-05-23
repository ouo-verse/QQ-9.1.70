package com.eclipsesource.mmv8.utils;

import com.eclipsesource.mmv8.Releasable;
import com.eclipsesource.mmv8.V8Value;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8Map<V> implements Map<V8Value, V>, Releasable {
    private Map<V8Value, V> map = new HashMap();
    private Map<V8Value, V8Value> twinMap = new HashMap();

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
        Iterator<V8Value> it = this.twinMap.keySet().iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.twinMap.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<V8Value, V>> entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return this.map.get(obj);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public Set<V8Value> keySet() {
        return this.map.keySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(V8Value v8Value, Object obj) {
        return put2(v8Value, (V8Value) obj);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends V8Value, ? extends V> map) {
        for (Map.Entry<? extends V8Value, ? extends V> entry : map.entrySet()) {
            put2(entry.getKey(), (V8Value) entry.getValue());
        }
    }

    @Override // com.eclipsesource.mmv8.Releasable
    public void release() {
        clear();
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        V remove = this.map.remove(obj);
        V8Value remove2 = this.twinMap.remove(obj);
        if (remove2 != null) {
            remove2.release();
        }
        return remove;
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return this.map.values();
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public V put2(V8Value v8Value, V v3) {
        remove(v8Value);
        V8Value twin = v8Value.twin();
        this.twinMap.put(twin, twin);
        return this.map.put(twin, v3);
    }
}
