package com.qzone.reborn.util;

import com.tencent.image.SafeBitmapFactory;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a {
    public static String a(long j3) {
        if (Math.abs(j3) < 10000) {
            return j3 + "";
        }
        if (Math.abs(j3) < 10000000) {
            return ((int) Math.round(j3 / 10000.0d)) + "\u4e07";
        }
        if (Math.abs(j3) < SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            return ((int) Math.round(j3 / 1.0E7d)) + "\u5343\u4e07";
        }
        return ((int) Math.round(j3 / 1.0E8d)) + "\u4ebf";
    }

    public static long b(int i3) {
        return i3 & 4294967295L;
    }
}
