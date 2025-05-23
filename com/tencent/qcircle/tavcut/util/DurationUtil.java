package com.tencent.qcircle.tavcut.util;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DurationUtil {
    private static final String TAG = "DurationUtil";
    public static boolean enableLog = false;
    private static Map<String, Long> timeMap = new HashMap();

    public static void end(String str) {
        if (enableLog && timeMap.containsKey(str)) {
            Logger.i(TAG, String.format("** %s end ** duration = %d", str, Long.valueOf(System.currentTimeMillis() - timeMap.get(str).longValue())));
        }
    }

    public static void start(String str) {
        if (enableLog) {
            timeMap.put(str, Long.valueOf(System.currentTimeMillis()));
            Logger.i(TAG, String.format("** %s start **", str));
        }
    }
}
