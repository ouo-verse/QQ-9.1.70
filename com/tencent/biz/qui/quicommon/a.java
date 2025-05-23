package com.tencent.biz.qui.quicommon;

import android.graphics.Color;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static int a(int i3, int i16) {
        float alpha = Color.alpha(i3) / 255.0f;
        float alpha2 = Color.alpha(i16) / 255.0f;
        if (alpha == 0.0f && alpha2 == 0.0f) {
            return i3;
        }
        if (alpha == 0.0f) {
            return i16;
        }
        if (alpha2 == 0.0f) {
            return i3;
        }
        float f16 = 1.0f - alpha2;
        float f17 = 1.0f - ((1.0f - alpha) * f16);
        return (((int) (f17 * 255.0f)) << 24) | (((int) ((((Color.red(i16) * 1.0f) * alpha2) + (((Color.red(i3) * 1.0f) * f16) * alpha)) / f17)) << 16) | (((int) ((((Color.green(i16) * 1.0f) * alpha2) + (((Color.green(i3) * 1.0f) * f16) * alpha)) / f17)) << 8) | ((int) (((alpha2 * (Color.blue(i16) * 1.0f)) + ((f16 * (Color.blue(i3) * 1.0f)) * alpha)) / f17));
    }

    public static boolean b(int i3) {
        float[] fArr = new float[3];
        Color.colorToHSV(i3, fArr);
        if (((int) (fArr[2] * 100.0f)) <= 50) {
            return true;
        }
        return false;
    }
}
