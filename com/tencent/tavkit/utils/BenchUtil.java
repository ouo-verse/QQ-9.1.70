package com.tencent.tavkit.utils;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class BenchUtil {
    private static final String TAG = "BenchUtil";
    private static Map<String, Long> startTimeMap = new HashMap();
    private static Map<String, Long> endTimeMap = new HashMap();
    public static boolean ENABLE_DEBUG = false;

    public static long benchEnd(String str) {
        Map<String, Long> map;
        Long l3;
        if (!ENABLE_DEBUG || TextUtils.isEmpty(str) || (map = startTimeMap) == null || (l3 = map.get(str)) == null) {
            return 0L;
        }
        long currentTimeMillis = System.currentTimeMillis() - l3.longValue();
        Log.d(TAG, str + ", cost time: " + currentTimeMillis);
        return currentTimeMillis;
    }

    public static void benchStart(String str) {
        if (ENABLE_DEBUG && !TextUtils.isEmpty(str)) {
            startTimeMap.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static void clear() {
        startTimeMap.clear();
        endTimeMap.clear();
    }

    public static void setEnableDebugLog(boolean z16) {
        ENABLE_DEBUG = z16;
    }
}
