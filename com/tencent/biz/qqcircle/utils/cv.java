package com.tencent.biz.qqcircle.utils;

import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes5.dex */
public class cv {
    public static String a(int i3) {
        String str;
        String str2;
        if (i3 == 0) {
            return "";
        }
        int i16 = i3 % 60;
        int i17 = i3 / 60;
        if (i16 > 9) {
            str = String.valueOf(i16);
        } else {
            str = "0" + i16;
        }
        if (i17 > 9) {
            str2 = String.valueOf(i17);
        } else {
            str2 = "0" + i17;
        }
        return str2 + ":" + str;
    }

    public static String b(int i3) {
        String str;
        String str2;
        String str3;
        if (i3 == 0) {
            return "";
        }
        int i16 = i3 / 1000;
        int i17 = i16 % 60;
        int i18 = i16 / 60;
        int i19 = i18 % 60;
        int i26 = i18 / 60;
        if (i17 > 9) {
            str = String.valueOf(i17);
        } else {
            str = "0" + i17;
        }
        if (i19 > 9) {
            str2 = String.valueOf(i19);
        } else {
            str2 = "0" + i19;
        }
        if (i26 > 9) {
            str3 = String.valueOf(i26);
        } else {
            str3 = "0" + i26;
        }
        return str3 + ":" + str2 + ":" + str;
    }

    public static String c(int i3) {
        String valueOf;
        int i16 = i3 / 1000;
        int i17 = i16 / 60;
        int i18 = i16 % 60;
        if (i17 < 10) {
            valueOf = "0" + i17;
        } else {
            valueOf = String.valueOf(i17);
        }
        if (i18 < 10) {
            return String.format("%s:0%s", valueOf, Integer.valueOf(i18));
        }
        return String.format("%s:%s", valueOf, Integer.valueOf(i18));
    }

    public static long d(int i3) {
        return i3 * 60 * 60 * 1000;
    }

    public static boolean e(long j3, long j16) {
        Date date = new Date(j3);
        Date date2 = new Date(j16);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        return simpleDateFormat.format(date).equals(simpleDateFormat.format(date2));
    }

    public static String f(long j3, String str) {
        return new SimpleDateFormat(String.format("yyyy%sMM%sdd", str, str), Locale.getDefault()).format(Long.valueOf(j3));
    }
}
