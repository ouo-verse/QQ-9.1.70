package com.tencent.av.opengl.ui;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static float f74168a = (float) (Math.log(0.75d) / Math.log(0.9d));

    /* renamed from: b, reason: collision with root package name */
    private static float f74169b = 800.0f;

    /* renamed from: c, reason: collision with root package name */
    private static float f74170c = 0.4f;

    /* renamed from: d, reason: collision with root package name */
    private static float f74171d = 1.0f - 0.4f;

    /* renamed from: e, reason: collision with root package name */
    private static final float[] f74172e = new float[101];

    /* renamed from: f, reason: collision with root package name */
    private static float f74173f;

    /* renamed from: g, reason: collision with root package name */
    private static float f74174g;

    static {
        float f16;
        float f17;
        float f18 = 0.0f;
        for (int i3 = 0; i3 <= 100; i3++) {
            float f19 = i3 / 100.0f;
            float f26 = 1.0f;
            while (true) {
                float f27 = ((f26 - f18) / 2.0f) + f18;
                float f28 = 1.0f - f27;
                f16 = 3.0f * f27 * f28;
                f17 = f27 * f27 * f27;
                float f29 = (((f28 * f74170c) + (f74171d * f27)) * f16) + f17;
                if (Math.abs(f29 - f19) < 1.0E-5d) {
                    break;
                } else if (f29 > f19) {
                    f26 = f27;
                } else {
                    f18 = f27;
                }
            }
            f74172e[i3] = f16 + f17;
        }
        f74172e[100] = 1.0f;
        f74173f = 8.0f;
        f74174g = 1.0f;
        f74174g = 1.0f / a(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(float f16) {
        float exp;
        float f17 = f16 * f74173f;
        if (f17 < 1.0f) {
            exp = f17 - (1.0f - ((float) Math.exp(-f17)));
        } else {
            exp = 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f17))) * 0.63212055f);
        }
        return exp * f74174g;
    }
}
