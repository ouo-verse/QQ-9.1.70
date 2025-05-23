package com.tencent.mobileqq.matchfriend.voicechat;

import java.util.Locale;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b {
    public static String a(long j3) {
        long j16 = j3 / 1000;
        long j17 = j16 / 3600;
        long j18 = (j16 % 3600) / 60;
        long j19 = j16 % 60;
        if (j17 == 0) {
            return String.format(Locale.CHINA, "%02d:%02d", Long.valueOf(j18), Long.valueOf(j19));
        }
        return String.format(Locale.CHINA, "%02d:%02d:%02d", Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19));
    }
}
