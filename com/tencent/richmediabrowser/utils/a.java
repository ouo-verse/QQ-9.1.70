package com.tencent.richmediabrowser.utils;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    public static int a(int i3) {
        if (i3 != 3) {
            if (i3 != 6) {
                if (i3 != 8) {
                    return 0;
                }
                return 270;
            }
            return 90;
        }
        return 180;
    }

    public static String b(long j3) {
        int i3 = ((int) j3) / 1000;
        int i16 = i3 % 60;
        int i17 = (i3 / 60) % 60;
        int i18 = i3 / 3600;
        if (i18 > 0) {
            return String.format("%d:%02d:%02d", Integer.valueOf(i18), Integer.valueOf(i17), Integer.valueOf(i16)).toString();
        }
        return String.format("%02d:%02d", Integer.valueOf(i17), Integer.valueOf(i16)).toString();
    }
}
