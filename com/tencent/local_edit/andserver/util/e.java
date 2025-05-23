package com.tencent.local_edit.andserver.util;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e<K, V> implements f<K, V>, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private final Map<K, List<V>> f119880d;

    public e() {
        this.f119880d = new LinkedHashMap();
    }

    @Override // com.tencent.local_edit.andserver.util.f
    public void a(K k3, V v3) {
        List<V> list = this.f119880d.get(k3);
        if (list == null) {
            list = new LinkedList<>();
            this.f119880d.put(k3, list);
        }
        list.add(v3);
    }

    @Override // com.tencent.local_edit.andserver.util.f
    public V b(K k3) {
        List<V> list = this.f119880d.get(k3);
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e<K, V> clone() {
        return new e<>(this);
    }

    @Override // java.util.Map
    public void clear() {
        this.f119880d.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f119880d.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f119880d.containsValue(obj);
    }

    @Override // java.util.Map
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public List<V> get(Object obj) {
        return this.f119880d.get(obj);
    }

    @Override // java.util.Map
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public List<V> put(K k3, List<V> list) {
        return this.f119880d.put(k3, list);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, List<V>>> entrySet() {
        return this.f119880d.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.f119880d.equals(obj);
    }

    @Override // java.util.Map
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public List<V> remove(Object obj) {
        return this.f119880d.remove(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.f119880d.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f119880d.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return this.f119880d.keySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends List<V>> map) {
        this.f119880d.putAll(map);
    }

    @Override // java.util.Map
    public int size() {
        return this.f119880d.size();
    }

    public String toString() {
        return this.f119880d.toString();
    }

    @Override // java.util.Map
    public Collection<List<V>> values() {
        return this.f119880d.values();
    }

    public e(Map<K, List<V>> map) {
        this.f119880d = new LinkedHashMap(map);
    }
}
