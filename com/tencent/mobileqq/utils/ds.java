package com.tencent.mobileqq.utils;

import java.util.Random;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ds {

    /* renamed from: a, reason: collision with root package name */
    private static final Random f307685a = new Random();

    public static double a(double d16, double d17) {
        if (d16 == d17) {
            return d16;
        }
        return d16 + ((d17 - d16) * f307685a.nextDouble());
    }

    public static float b(float f16, float f17) {
        if (f16 == f17) {
            return f16;
        }
        return f16 + ((f17 - f16) * f307685a.nextFloat());
    }

    public static int c() {
        return d(0, Integer.MAX_VALUE);
    }

    public static int d(int i3, int i16) {
        if (i3 == i16) {
            return i3;
        }
        return i3 + f307685a.nextInt(i16 - i3);
    }

    public static long e() {
        return f(0L, Long.MAX_VALUE);
    }

    public static long f(long j3, long j16) {
        if (j3 == j16) {
            return j3;
        }
        return (long) a(j3, j16);
    }
}
