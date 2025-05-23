package com.tencent.mobileqq.wink.editor.music;

import android.support.annotation.NonNull;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final DateFormat f320709a = new SimpleDateFormat("mm:ss", Locale.CHINA);

    public static long a(long j3) {
        return Math.max(j3, 0L);
    }

    public static String b(@NonNull DateFormat dateFormat, long j3) {
        return dateFormat.format(Long.valueOf(a(j3)));
    }

    public static String c(long j3) {
        String str;
        String str2;
        String str3;
        long a16 = a(j3);
        long j16 = a16 % 3600000;
        int round = Math.round(((float) (j16 % 60000)) / 1000.0f);
        int i3 = ((int) j16) / 60000;
        int i16 = (int) (a16 / 3600000);
        int i17 = 0;
        if (round == 60) {
            i3++;
            round = 0;
        }
        if (i3 == 60) {
            i16++;
        } else {
            i17 = i3;
        }
        String str4 = "";
        if (round < 10) {
            str = "0" + round;
        } else {
            str = "" + round;
        }
        if (i17 < 10) {
            str2 = "0" + i17;
        } else {
            str2 = "" + i17;
        }
        if (i16 < 10) {
            str3 = "0" + i16;
        } else {
            str3 = "" + i16;
        }
        if (i16 > 0) {
            str4 = str3 + ":";
        }
        return str4 + str2 + ":" + str;
    }

    public static String d(long j3) {
        return c(j3 / 1000);
    }
}
