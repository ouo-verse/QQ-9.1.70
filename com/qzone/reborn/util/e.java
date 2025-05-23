package com.qzone.reborn.util;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, Long> f59542a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static Pair<String, Long> f59543b = null;

    public static boolean a(String str) {
        Pair<String, Long> pair = f59543b;
        Long l3 = (pair == null || !TextUtils.equals(str, (CharSequence) pair.first)) ? null : (Long) f59543b.second;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (l3 != null && elapsedRealtime - l3.longValue() < 1000) {
            QLog.d("QZMFastClickUtils", 4, "fast click ,tag  = " + str + ", intervalTime = " + (elapsedRealtime - l3.longValue()));
            return true;
        }
        f59543b = new Pair<>(str, Long.valueOf(elapsedRealtime));
        return false;
    }

    public static boolean b(String str, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (f59542a == null) {
            f59542a = new HashMap<>();
        }
        Long l3 = f59542a.get(str);
        if (l3 != null) {
            if (f59542a.size() > 10) {
                f59542a.clear();
            }
            f59542a.put(str, Long.valueOf(elapsedRealtime));
            QLog.d("QZMFastClickUtils", 4, "fast click ,tag  = " + str + ", currentTime = " + elapsedRealtime + " lastTime = " + l3 + " intervalTime = " + (elapsedRealtime - l3.longValue()));
            return elapsedRealtime - l3.longValue() < j3;
        }
        f59542a.put(str, Long.valueOf(elapsedRealtime));
        return false;
    }

    public static boolean c(String str, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (f59542a == null) {
            f59542a = new HashMap<>();
        }
        Long l3 = f59542a.get(str);
        if (l3 != null) {
            if (f59542a.size() > 10) {
                f59542a.clear();
            }
            boolean z16 = elapsedRealtime - l3.longValue() < j3;
            if (!z16) {
                f59542a.put(str, Long.valueOf(elapsedRealtime));
            }
            QLog.d("QZMFastClickUtils", 4, "fast click ,tag  = " + str + ", currentTime = " + elapsedRealtime + " lastTime = " + l3 + " intervalTime = " + (elapsedRealtime - l3.longValue()) + " is fast click = " + z16);
            return z16;
        }
        f59542a.put(str, Long.valueOf(elapsedRealtime));
        return false;
    }
}
