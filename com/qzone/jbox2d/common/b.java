package com.qzone.jbox2d.common;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends c {

    /* renamed from: a, reason: collision with root package name */
    public static final float[] f48132a = new float[d.f48139g];

    static {
        for (int i3 = 0; i3 < d.f48139g; i3++) {
            f48132a[i3] = (float) Math.sin(i3 * 1.1E-4f);
        }
    }

    public static float a(float f16) {
        if (d.f48133a) {
            return f16 > 0.0f ? f16 : -f16;
        }
        return StrictMath.abs(f16);
    }

    public static float b(float f16, float f17) {
        if (d.f48136d) {
            return g(f16, f17);
        }
        return (float) StrictMath.atan2(f16, f17);
    }

    public static float c(float f16, float f17, float f18) {
        return j(f17, l(f16, f18));
    }

    public static float d(float f16) {
        if (d.f48138f) {
            return o(1.5707964f - f16);
        }
        return (float) StrictMath.cos(f16);
    }

    public static float e(Vec2 vec2, Vec2 vec22) {
        return p(f(vec2, vec22));
    }

    public static float f(Vec2 vec2, Vec2 vec22) {
        float f16 = vec2.f48119x - vec22.f48119x;
        float f17 = vec2.f48120y - vec22.f48120y;
        return (f16 * f16) + (f17 * f17);
    }

    public static int h(float f16) {
        int i3 = (int) f16;
        if (f16 < i3) {
            return i3 - 1;
        }
        return i3;
    }

    public static int i(float f16) {
        if (d.f48134b) {
            return h(f16);
        }
        return (int) StrictMath.floor(f16);
    }

    public static float j(float f16, float f17) {
        if (f16 <= f17) {
            return f17;
        }
        return f16;
    }

    public static int k(int i3, int i16) {
        if (i3 <= i16) {
            return i16;
        }
        return i3;
    }

    public static float l(float f16, float f17) {
        if (f16 >= f17) {
            return f17;
        }
        return f16;
    }

    public static int m(float f16) {
        if (d.f48135c) {
            return i(f16 + 0.5f);
        }
        return StrictMath.round(f16);
    }

    public static float n(float f16) {
        if (d.f48138f) {
            return o(f16);
        }
        return (float) StrictMath.sin(f16);
    }

    public static float p(float f16) {
        return (float) StrictMath.sqrt(f16);
    }

    public static float o(float f16) {
        float f17;
        float f18;
        float f19 = f16 % 6.2831855f;
        if (f19 < 0.0f) {
            f19 += 6.2831855f;
        }
        if (d.f48140h) {
            float f26 = f19 / 1.1E-4f;
            int i3 = (int) f26;
            if (i3 != 0) {
                f26 %= i3;
            }
            if (i3 == d.f48139g - 1) {
                float[] fArr = f48132a;
                f17 = (1.0f - f26) * fArr[i3];
                f18 = fArr[0];
            } else {
                float[] fArr2 = f48132a;
                f17 = (1.0f - f26) * fArr2[i3];
                f18 = fArr2[i3 + 1];
            }
            return f17 + (f26 * f18);
        }
        return f48132a[m(f19 / 1.1E-4f) % d.f48139g];
    }

    public static float g(float f16, float f17) {
        if (f17 == 0.0f) {
            if (f16 > 0.0f) {
                return 1.5707964f;
            }
            return f16 == 0.0f ? 0.0f : -1.5707964f;
        }
        float f18 = f16 / f17;
        if (a(f18) < 1.0f) {
            float f19 = f18 / (((0.28f * f18) * f18) + 1.0f);
            return f17 < 0.0f ? f16 < 0.0f ? f19 - 3.1415927f : f19 + 3.1415927f : f19;
        }
        float f26 = 1.5707964f - (f18 / ((f18 * f18) + 0.28f));
        return f16 < 0.0f ? f26 - 3.1415927f : f26;
    }
}
