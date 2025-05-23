package com.eclipsesource.mmv8.utils;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
class V8PropertyMap<V> implements Map<String, V> {
    private Hashtable<String, V> map = new Hashtable<>();
    private Set<String> nulls = new HashSet();

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
        this.nulls.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (!this.map.containsKey(obj) && !this.nulls.contains(obj)) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null && !this.nulls.isEmpty()) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return this.map.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, V>> entrySet() {
        HashSet hashSet = new HashSet(this.map.entrySet());
        Iterator<String> it = this.nulls.iterator();
        while (it.hasNext()) {
            hashSet.add(new AbstractMap.SimpleEntry(it.next(), null));
        }
        return hashSet;
    }

    @Override // java.util.Map
    public V get(Object obj) {
        if (this.nulls.contains(obj)) {
            return null;
        }
        return this.map.get(obj);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (this.map.isEmpty() && this.nulls.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        HashSet hashSet = new HashSet(this.map.keySet());
        hashSet.addAll(this.nulls);
        return hashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(String str, Object obj) {
        return put2(str, (String) obj);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends V> map) {
        for (Map.Entry<? extends String, ? extends V> entry : map.entrySet()) {
            put2(entry.getKey(), (String) entry.getValue());
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        if (this.nulls.contains(obj)) {
            this.nulls.remove(obj);
            return null;
        }
        return this.map.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size() + this.nulls.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        ArrayList arrayList = new ArrayList(this.map.values());
        for (int i3 = 0; i3 < this.nulls.size(); i3++) {
            arrayList.add(null);
        }
        return arrayList;
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public V put2(String str, V v3) {
        if (v3 == null) {
            if (this.map.containsKey(str)) {
                this.map.remove(str);
            }
            this.nulls.add(str);
            return null;
        }
        if (this.nulls.contains(str)) {
            this.nulls.remove(str);
        }
        return this.map.put(str, v3);
    }
}
