package com.tencent.av.doodle;

import java.util.Random;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    private static final float f73627b;

    /* renamed from: a, reason: collision with root package name */
    static final int f73626a = (int) Math.sqrt(16384.0d);

    /* renamed from: c, reason: collision with root package name */
    public static Random f73628c = new Random();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static final float[] f73629a = new float[16384];

        static {
            for (int i3 = 0; i3 < 16384; i3++) {
                f73629a[i3] = (float) Math.sin(((i3 + 0.5f) / 16384.0f) * 6.2831855f);
            }
            for (int i16 = 0; i16 < 360; i16 += 90) {
                f73629a[((int) (45.511112f * i16)) & 16383] = (float) Math.sin(r2 * 0.017453292f);
            }
        }
    }

    static {
        f73627b = 1.0f / (r0 - 1);
    }

    public static int a(float f16) {
        return ((int) (f16 + 16384.999999999996d)) - 16384;
    }

    public static float b(float f16, float f17, float f18) {
        if (f16 < f17) {
            return f17;
        }
        if (f16 > f18) {
            return f18;
        }
        return f16;
    }

    public static int c(int i3, int i16, int i17) {
        if (i3 < i16) {
            return i16;
        }
        if (i3 > i17) {
            return i17;
        }
        return i3;
    }

    public static final float d(float f16) {
        return a.f73629a[((int) ((f16 + 90.0f) * 45.511112f)) & 16383];
    }

    public static final float e() {
        return f73628c.nextFloat();
    }

    public static final float f(float f16) {
        return f73628c.nextFloat() * f16;
    }

    public static final int g(int i3) {
        return f73628c.nextInt(i3 + 1);
    }

    public static final float h(float f16) {
        return a.f73629a[((int) (f16 * 45.511112f)) & 16383];
    }
}
