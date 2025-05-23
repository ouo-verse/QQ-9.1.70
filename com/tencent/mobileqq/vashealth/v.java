package com.tencent.mobileqq.vashealth;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes20.dex */
public class v {
    public static Pair<Integer, Integer> a(long j3, int i3, long j16, int i16) {
        long d16;
        long d17;
        int b16 = b(j16);
        QLog.d("TimeStampCheckUtils", 1, "getDataMethodResult:", Integer.valueOf(b16), ", lastReportTime:", Long.valueOf(j3), ", lastSensorValue:", Integer.valueOf(i3));
        int i17 = -1;
        if (j3 == 0) {
            QLog.d("TimeStampCheckUtils", 1, "lastReportTime is 0");
            return new Pair<>(-1, Integer.valueOf(i16));
        }
        int i18 = i16 - i3;
        if (b16 != 0) {
            if (b16 != 1) {
                if (b16 != 2) {
                    if (b16 != 3) {
                        if (b16 != 4) {
                            if (b16 != 5) {
                                i16 = -1;
                            } else {
                                d16 = d(0, 0, 29, 59) - j3;
                                d17 = d(0, 3, 59, 59);
                            }
                        } else {
                            d16 = d(0, 4, 0, 0) - j3;
                            d17 = d(0, 23, 59, 59);
                        }
                        int i19 = (int) (((float) (i18 * d16)) / ((float) (d17 - j3)));
                        i16 = i18 - i19;
                        i17 = i3 + i19;
                    } else {
                        i16 = i18;
                    }
                } else {
                    i17 = i3 + i18;
                }
            }
            i16 = 0;
        }
        return new Pair<>(Integer.valueOf(i17), Integer.valueOf(i16));
    }

    public static int b(long j3) {
        long g16 = com.tencent.mobileqq.vashealth.step.k.f312340a.g();
        if (e(g16, j3)) {
            return 0;
        }
        if (g16 < d(1, 0, 0, 0)) {
            return 1;
        }
        if (g16 < d(1, 23, 30, 0)) {
            if (j3 > d(0, 0, 0, 0) && j3 <= d(0, 3, 59, 59)) {
                return 2;
            }
            return 4;
        }
        if (j3 > d(0, 0, 0, 0) && j3 <= d(0, 0, 29, 59)) {
            return 2;
        }
        if (j3 <= d(0, 0, 29, 59) || j3 > d(0, 3, 59, 59)) {
            return 3;
        }
        return 5;
    }

    public static long c(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTimeInMillis();
    }

    public static long d(int i3, int i16, int i17, int i18) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        if (i3 != 0) {
            calendar.set(5, calendar.get(5) - i3);
        }
        calendar.set(11, i16);
        calendar.set(12, i17);
        calendar.set(13, i18);
        return calendar.getTimeInMillis();
    }

    public static boolean e(long j3, long j16) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j16);
        if (calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1)) {
            return true;
        }
        return false;
    }
}
