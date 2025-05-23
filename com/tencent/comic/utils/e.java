package com.tencent.comic.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e<K, V> implements Map<K, V> {

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<K, V> f99484d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<V, K> f99485e = new HashMap<>();

    public K c(Object obj) {
        return this.f99485e.get(obj);
    }

    @Override // java.util.Map
    public void clear() {
        this.f99484d.clear();
        this.f99485e.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f99484d.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f99485e.containsKey(obj);
    }

    public K d(Object obj) {
        K remove = this.f99485e.remove(obj);
        if (remove != null) {
            this.f99484d.remove(remove);
        }
        return remove;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return this.f99484d.entrySet();
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return this.f99484d.get(obj);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f99484d.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return this.f99484d.keySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (key != null && value != null) {
                put(key, value);
            }
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        V remove = this.f99484d.remove(obj);
        if (remove != null) {
            this.f99485e.remove(remove);
        }
        return remove;
    }

    @Override // java.util.Map
    public int size() {
        return this.f99484d.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return this.f99484d.values();
    }

    @Override // java.util.Map
    public V put(K k3, V v3) {
        if (k3 == null || v3 == null) {
            return null;
        }
        V remove = remove(k3);
        d(v3);
        this.f99484d.put(k3, v3);
        this.f99485e.put(v3, k3);
        return remove;
    }
}
