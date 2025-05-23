package com.tencent.ttpic.util;

import android.graphics.PointF;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CosFunUtil {
    public static void getExtFaceFeature(float[][] fArr) {
        float[] fArr2 = fArr[54];
        float f16 = fArr2[0];
        float[] fArr3 = fArr[44];
        PointF pointF = new PointF(f16 - fArr3[0], fArr2[1] - fArr3[1]);
        float[] fArr4 = fArr[54];
        float f17 = fArr4[0];
        float[] fArr5 = fArr[44];
        PointF pointF2 = new PointF((f17 + fArr5[0]) * 0.5f, (fArr4[1] + fArr5[1]) * 0.5f);
        if (pointF.x < 0.01d && pointF.y < 0.01d) {
            return;
        }
        float f18 = 99999.0f;
        for (int i3 = 24; i3 < 27; i3++) {
            float[] fArr6 = fArr[i3];
            float f19 = pointWithW(pointF, pointF2, new PointF(fArr6[0], fArr6[1])).y;
            if (f19 < f18) {
                f18 = f19;
            }
        }
        for (int i16 = 32; i16 < 35; i16++) {
            float[] fArr7 = fArr[i16];
            float f26 = pointWithW(pointF, pointF2, new PointF(fArr7[0], fArr7[1])).y;
            if (f26 < f18) {
                f18 = f26;
            }
        }
        for (int i17 = 90; i17 < 97; i17++) {
            float[] fArr8 = fArr[i17];
            float f27 = pointWithW(pointF, pointF2, new PointF(fArr8[0], fArr8[1])).y;
            if (f27 < f18) {
                f18 = f27;
            }
        }
        float[] fArr9 = fArr[0];
        float f28 = pointWithW(pointF, pointF2, new PointF(fArr9[0], fArr9[1])).x;
        float[] fArr10 = fArr[18];
        float f29 = pointWithW(pointF, pointF2, new PointF(fArr10[0], fArr10[1])).x;
        float[] fArr11 = fArr[9];
        float f36 = pointWithW(pointF, pointF2, new PointF(fArr11[0], fArr11[1])).y;
        PointF w_pointWithW = w_pointWithW(pointF, pointF2, new PointF((f28 + f29) * 0.5f, (f18 + f36) * 0.5f));
        PointF w_pointWithW2 = w_pointWithW(pointF, pointF2, new PointF((f29 - f28) * 0.6f, 0.0f));
        PointF pointF3 = new PointF(w_pointWithW2.x - pointF2.x, w_pointWithW2.y - pointF2.y);
        PointF w_pointWithW3 = w_pointWithW(pointF, pointF2, new PointF(0.0f, (f36 - f18) * 0.55f));
        PointF pointF4 = new PointF(w_pointWithW3.x - pointF2.x, w_pointWithW3.y - pointF2.y);
        PointF pointF5 = new PointF(w_pointWithW.x, w_pointWithW.y);
        PointF pointF6 = new PointF(pointF3.x, pointF3.y);
        PointF pointF7 = new PointF(pointF4.x, pointF4.y);
        float[] fArr12 = fArr[99];
        float f37 = pointF5.x;
        float f38 = pointF6.x;
        float f39 = pointF7.x;
        fArr12[0] = (f37 - f38) - f39;
        float f46 = pointF5.y;
        float f47 = pointF6.y;
        float f48 = pointF7.y;
        fArr12[1] = (f46 - f47) - f48;
        float[] fArr13 = fArr[100];
        fArr13[0] = f37 - f38;
        fArr13[1] = f46 - f47;
        float[] fArr14 = fArr[101];
        fArr14[0] = (f37 - f38) + f39;
        fArr14[1] = (f46 - f47) + f48;
        float[] fArr15 = fArr[102];
        fArr15[0] = f37 + f39;
        fArr15[1] = f46 + f48;
        float[] fArr16 = fArr[103];
        fArr16[0] = f37 + f38 + f39;
        fArr16[1] = f46 + f47 + f48;
        float[] fArr17 = fArr[104];
        fArr17[0] = f37 + f38;
        fArr17[1] = f46 + f47;
        float[] fArr18 = fArr[105];
        fArr18[0] = (f38 + f37) - f39;
        fArr18[1] = (f47 + f46) - f48;
        float[] fArr19 = fArr[106];
        fArr19[0] = f37 - f39;
        fArr19[1] = f46 - f48;
    }

    private static PointF pointWithW(PointF pointF, PointF pointF2, PointF pointF3) {
        float f16 = pointF.x;
        float f17 = pointF3.x;
        float f18 = pointF.y;
        float f19 = pointF3.y;
        float f26 = (f16 * f17) + (f18 * f19);
        float f27 = pointF2.x;
        float f28 = pointF2.y;
        return new PointF(((f26 - (f16 * f27)) - (f18 * f28)) / ((f16 * f16) + (f18 * f18)), ((((f19 * f16) - (f17 * f18)) - (f28 * f16)) + (f27 * f18)) / ((f16 * f16) + (f18 * f18)));
    }

    public static void scale(List<PointF> list, double d16) {
        if (list == null) {
            return;
        }
        for (PointF pointF : list) {
            pointF.x = (float) (pointF.x * d16);
            pointF.y = (float) (pointF.y * d16);
        }
    }

    private static PointF w_pointWithW(PointF pointF, PointF pointF2, PointF pointF3) {
        float f16 = pointF2.x;
        float f17 = pointF3.x;
        float f18 = pointF.x;
        float f19 = pointF3.y;
        float f26 = pointF.y;
        return new PointF((f16 + (f17 * f18)) - (f19 * f26), pointF2.y + (f17 * f26) + (f19 * f18));
    }
}
