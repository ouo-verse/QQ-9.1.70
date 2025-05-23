package com.tencent.biz.qqstory.utils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {
    public static long a(String str, long j3) {
        try {
            return Long.valueOf(str).longValue();
        } catch (NumberFormatException unused) {
            hd0.c.t("NumberUtils", "Invalid num string " + str + ", return default number " + j3);
            return j3;
        }
    }
}
