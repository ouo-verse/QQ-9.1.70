package com.tencent.qqmini.sdk.launcher.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class FastClickUtils {
    public static final long CLICK_TIME_INTERVAL = 1000;
    public static final int MAX_TAG_COUNT = 10;
    private static final String TAG = "FastClickUtils";
    public static HashMap<String, Long> sClickTimeMap = new HashMap<>();
    private static Pair<String, Long> sClickTimeCache = null;

    FastClickUtils() {
    }

    public static boolean isFastDoubleClick(String str, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (sClickTimeMap == null) {
            sClickTimeMap = new HashMap<>();
        }
        Long l3 = sClickTimeMap.get(str);
        if (l3 != null) {
            if (sClickTimeMap.size() > 10) {
                sClickTimeMap.clear();
            }
            sClickTimeMap.put(str, Long.valueOf(elapsedRealtime));
            return elapsedRealtime - l3.longValue() < j3;
        }
        sClickTimeMap.put(str, Long.valueOf(elapsedRealtime));
        return false;
    }

    public static boolean isFastDoubleClick(String str) {
        Pair<String, Long> pair = sClickTimeCache;
        Long l3 = (pair == null || !TextUtils.equals(str, (CharSequence) pair.first)) ? null : (Long) sClickTimeCache.second;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (l3 != null && elapsedRealtime - l3.longValue() < 1000) {
            return true;
        }
        sClickTimeCache = new Pair<>(str, Long.valueOf(elapsedRealtime));
        return false;
    }
}
