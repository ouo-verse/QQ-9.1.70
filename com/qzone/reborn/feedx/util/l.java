package com.qzone.reborn.feedx.util;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, Long> f55763a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static Pair<String, Long> f55764b = null;

    public static boolean a(String str) {
        Pair<String, Long> pair = f55764b;
        Long l3 = (pair == null || !TextUtils.equals(str, (CharSequence) pair.first)) ? null : (Long) f55764b.second;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (l3 != null && elapsedRealtime - l3.longValue() < 500) {
            QLog.d("QZoneFastClickUtils", 4, "fast click ,tag  = " + str + ", intervalTime = " + (elapsedRealtime - l3.longValue()));
            return true;
        }
        f55764b = new Pair<>(str, Long.valueOf(elapsedRealtime));
        return false;
    }

    public static boolean b(String str, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (f55763a == null) {
            f55763a = new HashMap<>();
        }
        Long l3 = f55763a.get(str);
        if (l3 != null) {
            if (f55763a.size() > 10) {
                f55763a.clear();
            }
            f55763a.put(str, Long.valueOf(elapsedRealtime));
            QLog.d("QZoneFastClickUtils", 4, "fast click ,tag  = " + str + ", currentTime = " + elapsedRealtime + " lastTime = " + l3 + " intervalTime = " + (elapsedRealtime - l3.longValue()));
            boolean z16 = elapsedRealtime - l3.longValue() < j3;
            if (z16) {
                QLog.d("QZoneFastClickUtils", 1, "fast double click: " + str);
            }
            return z16;
        }
        f55763a.put(str, Long.valueOf(elapsedRealtime));
        return false;
    }
}
