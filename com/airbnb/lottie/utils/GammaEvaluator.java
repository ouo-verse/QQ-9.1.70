package com.airbnb.lottie.utils;

/* compiled from: P */
/* loaded from: classes.dex */
public class GammaEvaluator {
    private static float EOCF_sRGB(float f16) {
        if (f16 <= 0.04045f) {
            return f16 / 12.92f;
        }
        return (float) Math.pow((f16 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private static float OECF_sRGB(float f16) {
        if (f16 <= 0.0031308f) {
            return f16 * 12.92f;
        }
        return (float) ((Math.pow(f16, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int evaluate(float f16, int i3, int i16) {
        if (i3 == i16) {
            return i3;
        }
        float f17 = ((i3 >> 24) & 255) / 255.0f;
        float EOCF_sRGB = EOCF_sRGB(((i3 >> 16) & 255) / 255.0f);
        float EOCF_sRGB2 = EOCF_sRGB(((i3 >> 8) & 255) / 255.0f);
        float EOCF_sRGB3 = EOCF_sRGB((i3 & 255) / 255.0f);
        float EOCF_sRGB4 = EOCF_sRGB(((i16 >> 16) & 255) / 255.0f);
        float f18 = f17 + (((((i16 >> 24) & 255) / 255.0f) - f17) * f16);
        float EOCF_sRGB5 = EOCF_sRGB2 + ((EOCF_sRGB(((i16 >> 8) & 255) / 255.0f) - EOCF_sRGB2) * f16);
        float EOCF_sRGB6 = EOCF_sRGB3 + (f16 * (EOCF_sRGB((i16 & 255) / 255.0f) - EOCF_sRGB3));
        return (Math.round(OECF_sRGB(EOCF_sRGB + ((EOCF_sRGB4 - EOCF_sRGB) * f16)) * 255.0f) << 16) | (Math.round(f18 * 255.0f) << 24) | (Math.round(OECF_sRGB(EOCF_sRGB5) * 255.0f) << 8) | Math.round(OECF_sRGB(EOCF_sRGB6) * 255.0f);
    }
}
