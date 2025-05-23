package com.tencent.biz.richframework.part.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class FastClickUtils {
    public static HashMap<String, Long> sClickTimeMap = new HashMap<>();
    private static Pair<String, Long> sClickTimeCache = null;

    public static boolean isFastDoubleClick(@NonNull String str, long j3) {
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
            RFWLog.d("FastClickUtils", RFWLog.DEV, "fast click ,tag  = " + str + ", currentTime = " + elapsedRealtime + " lastTime" + l3 + " intervalTime = " + (elapsedRealtime - l3.longValue()));
            return elapsedRealtime - l3.longValue() < j3;
        }
        sClickTimeMap.put(str, Long.valueOf(elapsedRealtime));
        return false;
    }

    public static boolean isFastDoubleClick(@NonNull String str) {
        Pair<String, Long> pair = sClickTimeCache;
        Long l3 = (pair == null || !TextUtils.equals(str, (CharSequence) pair.first)) ? null : (Long) sClickTimeCache.second;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (l3 != null && elapsedRealtime - l3.longValue() < 1000) {
            RFWLog.d("FastClickUtils", RFWLog.DEV, "fast click ,tag  = " + str + ", intervalTime = " + (elapsedRealtime - l3.longValue()));
            return true;
        }
        sClickTimeCache = new Pair<>(str, Long.valueOf(elapsedRealtime));
        return false;
    }
}
