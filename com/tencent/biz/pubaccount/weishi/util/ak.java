package com.tencent.biz.pubaccount.weishi.util;

import com.tencent.image.SafeBitmapFactory;
import java.text.DecimalFormat;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ak {

    /* renamed from: a, reason: collision with root package name */
    public static final DecimalFormat f81703a = new DecimalFormat("0.0");

    public static String a(int i3) {
        return c(i3, "w");
    }

    public static String b(int i3) {
        return c(i3, "\u4e07");
    }

    private static String c(long j3, String str) {
        if (j3 <= 0) {
            return Integer.toString(0);
        }
        if (j3 < 10000) {
            return Long.toString(j3);
        }
        if (j3 < 99999500) {
            return f81703a.format(((float) j3) / 10000.0f) + str;
        }
        if (j3 < SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            return "1.0\u4ebf";
        }
        return f81703a.format(((float) j3) / 1.0E8f) + "\u4ebf";
    }
}
