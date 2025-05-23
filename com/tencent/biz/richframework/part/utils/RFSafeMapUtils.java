package com.tencent.biz.richframework.part.utils;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFSafeMapUtils {
    public static <K, V> void clear(Map<K, V> map) {
        if (map == null) {
            RFWLog.d("RFSafeMapUtils", RFWLog.USR, "[clear] map should not be null.");
        } else {
            map.clear();
        }
    }

    public static <K, V> V getVal(Map<K, V> map, K k3) {
        if (map == null) {
            RFWLog.d("RFSafeMapUtils", RFWLog.USR, "[getVal] map should not be null.");
            return null;
        }
        if (k3 == null) {
            RFWLog.d("RFSafeMapUtils", RFWLog.USR, "[getVal] map key not is null.");
            return null;
        }
        return map.get(k3);
    }

    public static <K, V> boolean isEmpty(Map<K, V> map) {
        if (map != null && !map.isEmpty()) {
            return false;
        }
        return true;
    }

    public static <K, V> void put(Map<K, V> map, K k3, V v3) {
        if (map == null) {
            RFWLog.d("RFSafeMapUtils", RFWLog.USR, "[put] map should not be null.");
            return;
        }
        if (k3 == null) {
            RFWLog.d("RFSafeMapUtils", RFWLog.USR, "[put] map key not is null.");
        } else if (v3 == null) {
            RFWLog.d("RFSafeMapUtils", RFWLog.USR, "[put] map val not is null.");
        } else {
            map.put(k3, v3);
        }
    }
}
