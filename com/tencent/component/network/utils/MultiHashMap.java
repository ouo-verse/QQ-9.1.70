package com.tencent.component.network.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MultiHashMap<K, V> extends HashMap<K, HashSet<V>> {
    public boolean add(K k3, V v3) {
        if (v3 == null) {
            return false;
        }
        HashSet hashSet = (HashSet) get(k3);
        if (hashSet == null) {
            hashSet = new HashSet();
            put(k3, hashSet);
        }
        return hashSet.add(v3);
    }

    public boolean removeItem(K k3, V v3) {
        boolean z16 = true;
        if (v3 == null) {
            if (remove(k3) != null) {
                return true;
            }
            return false;
        }
        Collection collection = (Collection) get(k3);
        if (collection == null || !collection.remove(v3)) {
            z16 = false;
        }
        if (collection != null && collection.isEmpty()) {
            remove(k3);
        }
        return z16;
    }

    public int sizeOf(K k3) {
        Collection collection = (Collection) get(k3);
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }
}
