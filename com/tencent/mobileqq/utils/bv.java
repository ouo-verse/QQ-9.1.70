package com.tencent.mobileqq.utils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bv {
    public static long a(String str) {
        return b(str, -1L);
    }

    public static long b(String str, long j3) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j3;
        }
    }
}
