package com.tencent.biz.qqcircle.utils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g {
    public static String a(long j3) {
        String str;
        String str2;
        int i3 = (int) (j3 / 1000);
        int i16 = i3 % 60;
        int i17 = i3 / 60;
        if (i16 > 9) {
            str = String.valueOf(i16);
        } else {
            str = "0" + String.valueOf(i16);
        }
        if (i17 > 9) {
            str2 = String.valueOf(i17);
        } else {
            str2 = "0" + String.valueOf(i17);
        }
        return str2 + ":" + str;
    }
}
