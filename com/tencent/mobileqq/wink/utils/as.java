package com.tencent.mobileqq.wink.utils;

import android.os.Build;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes21.dex */
public class as {

    /* renamed from: a, reason: collision with root package name */
    public static final double f326686a = Math.pow(10.0d, 12.0d);

    public static int a(long j3) {
        LocalDate now;
        if (j3 <= 0) {
            return 0;
        }
        long j16 = j3 * 1000;
        if (Build.VERSION.SDK_INT >= 26) {
            now = LocalDate.now();
            now.atTime(0, 0, 0);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j16);
        return calendar.get(1);
    }

    public static String b(Calendar calendar) {
        switch (calendar.get(7)) {
            case 1:
                return "\u661f\u671f\u65e5";
            case 2:
                return "\u661f\u671f\u4e00";
            case 3:
                return "\u661f\u671f\u4e8c";
            case 4:
                return "\u661f\u671f\u4e09";
            case 5:
                return "\u661f\u671f\u56db";
            case 6:
                return "\u661f\u671f\u4e94";
            case 7:
                return "\u661f\u671f\u516d";
            default:
                return "";
        }
    }

    public static String c(long j3, boolean z16) {
        LocalDate now;
        String str;
        String str2;
        if (j3 <= f326686a) {
            j3 *= 1000;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        int i3 = (int) (serverTimeMillis / 86400000);
        int i16 = (int) (j3 / 86400000);
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                now = LocalDate.now();
                now.atTime(0, 0, 0);
            } catch (Throwable th5) {
                w53.b.e("WinkMediaTimeUtil", th5);
            }
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(serverTimeMillis);
        if (i3 == i16) {
            return "\u4eca\u5929";
        }
        if (i3 == i16 + 1) {
            return "\u6628\u5929";
        }
        if (i3 >= i16 + 2 && i3 < i16 + 9) {
            return b(calendar);
        }
        if (calendar.get(1) == calendar2.get(1)) {
            if (z16) {
                str2 = "M\u6708d\u65e5";
            } else {
                str2 = "MM-dd";
            }
            return new SimpleDateFormat(str2).format(calendar.getTime());
        }
        if (z16) {
            str = "yyyy\u5e74M\u6708d\u65e5";
        } else {
            str = TuxDateStringUtils.TUX_COMMON_DATE_FORMAT;
        }
        return new SimpleDateFormat(str).format(calendar.getTime());
    }
}
