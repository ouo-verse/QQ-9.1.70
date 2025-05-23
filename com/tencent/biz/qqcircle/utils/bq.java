package com.tencent.biz.qqcircle.utils;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes5.dex */
public class bq {
    private static long a(int i3, int i16, int i17, int i18, int i19, int i26) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        if (i3 != 0 || i16 != 0 || i17 != 0) {
            calendar.set(1, i3);
            calendar.set(2, i16);
            calendar.set(5, i17);
        }
        calendar.set(11, i18);
        calendar.set(12, i19);
        calendar.set(13, i26);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private static long b() {
        return (System.currentTimeMillis() - a(1970, 0, 1, 0, 0, 0)) / 86400000;
    }

    private static String c(String str) {
        return "QFSFrequencyControlUtil_today_" + str;
    }

    public static boolean d(String str, String str2, long j3, int i3) {
        boolean z16;
        boolean z17;
        long f16 = uq3.k.a().f(str, 0L);
        int e16 = uq3.k.a().e(str2, 0);
        long currentTimeMillis = System.currentTimeMillis() - f16;
        if (currentTimeMillis <= 86400000 * j3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (e16 >= i3) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.d("QFSFrequencyControlUtil", 4, "[isArriveNDayMTimes] duringTimeInterval: ", Boolean.valueOf(z16), ", arriveCountLimit: ", Boolean.valueOf(z17), ", interval: ", Long.valueOf(currentTimeMillis), ", maxInterval: ", Long.valueOf(j3), ", count: ", Integer.valueOf(e16), ", maxCount: ", Integer.valueOf(i3));
        if (!z16 || !z17) {
            return false;
        }
        return true;
    }

    public static boolean e(String str, int i3) {
        long b16 = b();
        if (b16 != uq3.k.a().f(c(str), 0L)) {
            uq3.k.a().n(c(str), b16);
            uq3.k.a().m(str, 0);
            return false;
        }
        int e16 = uq3.k.a().e(str, 0);
        QLog.d("QFSFrequencyControlUtil", 4, "isExceedLimitInToday today:", Long.valueOf(b16), "  current:", Integer.valueOf(e16));
        if (e16 < i3) {
            return false;
        }
        return true;
    }

    public static boolean f(String str, int i3, int i16) {
        int i17 = -(i16 + 1);
        int e16 = uq3.k.a().e(str, i17);
        if (i3 > e16) {
            i17 = e16;
        }
        QLog.d("QFSFrequencyControlUtil", 1, "[isGapPermit] lastExposePos: " + i17 + ", currPos: " + i3 + ", gapValue: " + i16);
        if (i3 - i17 > i16) {
            return true;
        }
        return false;
    }

    public static void g(String str) {
        long b16 = b();
        if (b16 != uq3.k.a().f(c(str), 0L)) {
            uq3.k.a().n(c(str), b16);
            uq3.k.a().m(str, 1);
        } else {
            uq3.k.a().m(str, uq3.k.a().e(str, 0) + 1);
        }
    }

    public static void h(String str, String str2, int i3) {
        uq3.k.a().n(str, System.currentTimeMillis());
        int e16 = uq3.k.a().e(str2, 0);
        int i16 = 1;
        QLog.d("QFSFrequencyControlUtil", 4, "[updateExposeParams] count:", Integer.valueOf(e16), ", maxCount: ", Integer.valueOf(i3));
        uq3.k a16 = uq3.k.a();
        if (e16 < i3) {
            i16 = 1 + e16;
        }
        a16.m(str2, i16);
    }

    public static void i(String str, int i3, int i16) {
        if (i3 == uq3.k.a().e(str, i16)) {
            return;
        }
        uq3.k.a().m(str, i3);
    }
}
