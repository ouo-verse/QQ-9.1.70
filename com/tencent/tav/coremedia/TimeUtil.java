package com.tencent.tav.coremedia;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimeUtil {
    private static final long DEVIATION = 10000;
    public static final long SECOND_TO_US = 1000000;
    public static final String YYYY2MM2DD_HH1MM1SS = "yyyy-MM-dd HH:mm:ss";

    public static boolean equals(long j3, long j16) {
        if (Math.abs(j3 - j16) < 10000) {
            return true;
        }
        return false;
    }

    public static long getAudioDuration(long j3, int i3, int i16) {
        return (j3 * 1000000) / ((i3 * 2) * i16);
    }

    public static String long2str(long j3, String str) {
        if (str == null) {
            str = "yyyy-M-d  HH:mm";
        }
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j3));
    }

    public static float milli2Second(long j3) {
        return (((float) j3) * 1.0f) / 1000.0f;
    }

    public static long milli2Us(long j3) {
        return j3 * 1000;
    }

    public static String milliToSecond(long j3) {
        return String.format(Locale.CHINA, "%1$.1f", Float.valueOf(Math.round(milli2Second(j3) * 10.0f) / 10.0f));
    }

    public static long second2Ms(float f16) {
        return f16 * 1000.0f;
    }

    public static String second2String(int i3) {
        StringBuilder sb5 = new StringBuilder();
        int i16 = i3 / 60;
        if (i16 > 0) {
            sb5.append(i16 + "'");
        }
        int i17 = i3 % 60;
        if (i17 >= 10) {
            sb5.append(i17 + "\"");
        } else if (i17 >= 0) {
            sb5.append("0" + i17 + "\"");
        }
        return sb5.toString();
    }

    public static long second2Us(float f16) {
        return f16 * 1000000.0f;
    }

    public static CMTime us2CMTime(long j3) {
        return new CMTime(us2Second(j3) * 600.0f);
    }

    public static long us2Milli(long j3) {
        return j3 / 1000;
    }

    public static float us2Second(long j3) {
        return (((float) j3) * 1.0f) / 1000000.0f;
    }

    public static String usToSecond(long j3) {
        return String.format(Locale.CHINA, "%1$.1f", Float.valueOf(Math.round(us2Second(j3) * 10.0f) / 10.0f));
    }
}
