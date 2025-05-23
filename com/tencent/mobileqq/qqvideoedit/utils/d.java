package com.tencent.mobileqq.qqvideoedit.utils;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class d {
    public static float a(float f16, float f17, float f18, float f19) {
        float f26;
        float f27 = f16 / (f19 / 2.0f);
        float f28 = f18 / 2.0f;
        if (f27 < 1.0f) {
            f26 = f28 * f27 * f27 * f27;
        } else {
            float f29 = f27 - 2.0f;
            f26 = f28 * ((f29 * f29 * f29) + 2.0f);
        }
        return f26 + f17;
    }

    public static float b(float f16, float f17, float f18, float f19) {
        float f26 = (f16 / f19) - 1.0f;
        return (f18 * ((f26 * f26 * f26) + 1.0f)) + f17;
    }
}
