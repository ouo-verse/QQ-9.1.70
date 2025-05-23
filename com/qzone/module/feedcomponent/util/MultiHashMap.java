package com.qzone.module.feedcomponent.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class MultiHashMap<K, V> implements Map<K, Set<V>> {
    private Map<K, Set<V>> mMap = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface Matcher<V> {
        boolean match(V v3, V v16);
    }

    @Override // java.util.Map
    public void clear() {
        this.mMap.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.mMap.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.mMap.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, Set<V>>> entrySet() {
        return this.mMap.entrySet();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.mMap.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return this.mMap.keySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((MultiHashMap<K, V>) obj, (Set) obj2);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends Set<V>> map) {
        this.mMap.putAll(map);
    }

    @Override // java.util.Map
    public int size() {
        return this.mMap.size();
    }

    public int sizeOf(K k3) {
        Set<V> set = get((Object) k3);
        if (set == null) {
            return 0;
        }
        return set.size();
    }

    @Override // java.util.Map
    public Collection<Set<V>> values() {
        return this.mMap.values();
    }

    @Override // java.util.Map
    public Set<V> get(Object obj) {
        return this.mMap.get(obj);
    }

    public Set<V> put(K k3, Set<V> set) {
        return this.mMap.put(k3, set);
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        if (obj2 == null) {
            return remove(obj) != null;
        }
        Set<V> set = get(obj);
        boolean z16 = set != null && set.remove(obj2);
        if (set != null && set.isEmpty()) {
            remove(obj);
        }
        return z16;
    }

    public final synchronized Collection<K> get(K k3, Matcher<K> matcher) {
        if (k3 == null) {
            throw new NullPointerException("key == null");
        }
        if (matcher != null) {
            Set<K> keySet = keySet();
            if (keySet == null || keySet.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (K k16 : keySet) {
                if (matcher.match(k3, k16)) {
                    arrayList.add(k16);
                }
            }
            return arrayList;
        }
        throw new NullPointerException("keyMatcher == null");
    }

    public boolean add(K k3, V v3) {
        if (v3 == null) {
            return false;
        }
        Set<V> set = get((Object) k3);
        if (set == null) {
            set = Collections.newSetFromMap(new ConcurrentHashMap());
            put((MultiHashMap<K, V>) k3, (Set) set);
        }
        return set.add(v3);
    }

    public boolean contains(K k3, V v3) {
        Set<V> set;
        return (v3 == null || (set = get((Object) k3)) == null || !set.contains(v3)) ? false : true;
    }

    @Override // java.util.Map
    public Set<V> remove(Object obj) {
        return this.mMap.remove(obj);
    }
}
