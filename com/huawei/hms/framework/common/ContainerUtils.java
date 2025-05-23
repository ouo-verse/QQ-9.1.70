package com.huawei.hms.framework.common;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ContainerUtils {
    public static final String FIELD_DELIMITER = "&";
    public static final String KEY_VALUE_DELIMITER = "=";

    public static <K, V> boolean equals(Map<K, V> map, Map<K, V> map2) {
        if (map == map2) {
            return true;
        }
        boolean z16 = false;
        if (map == null || map2 == null || map.size() != map2.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<K, V> next = it.next();
            if (map2.get(next.getKey()) != next.getValue()) {
                z16 = true;
                break;
            }
        }
        return !z16;
    }

    public static <K, V> int hashCode(Map<K, V> map) {
        return toString(map).hashCode();
    }

    public static <K, V> String toString(Map<K, V> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            int i16 = i3 + 1;
            if (i3 > 0) {
                sb5.append(FIELD_DELIMITER);
            }
            sb5.append(entry.getKey().toString());
            sb5.append(KEY_VALUE_DELIMITER);
            sb5.append(entry.getValue().toString());
            i3 = i16;
        }
        return sb5.toString();
    }

    public static <K> String toString(Set<K> set) {
        if (set == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        for (K k3 : set) {
            int i16 = i3 + 1;
            if (i3 > 0) {
                sb5.append(FIELD_DELIMITER);
            }
            sb5.append(k3.toString());
            i3 = i16;
        }
        return sb5.toString();
    }

    public static <K> String toString(List<K> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        for (K k3 : list) {
            int i16 = i3 + 1;
            if (i3 > 0) {
                sb5.append(FIELD_DELIMITER);
            }
            sb5.append(k3.toString());
            i3 = i16;
        }
        return sb5.toString();
    }
}
