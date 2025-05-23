package com.tencent.mobileqq.shortvideo.mtveffects;

/* loaded from: classes18.dex */
public class MTV1ShapePoints {
    public static float[] getOneRectPoints(float f16, float f17, float f18) {
        float f19 = f16 - 1.0f;
        float f26 = (f17 - 1.0f) + f18;
        float f27 = 1.0f - f16;
        float f28 = 1.0f - f17;
        return new float[]{f19, f26, f27, f26, f27, f28, f19, f28};
    }

    public static float[] getTwoStaggerRectPoints(float f16, float f17, float f18, float f19, float f26) {
        float[] fArr = new float[20];
        fArr[0] = 0.0f;
        fArr[1] = f18;
        if (f26 < 0.0f) {
            float f27 = f16 - 1.0f;
            fArr[2] = f27;
            float f28 = f17 - 1.0f;
            float f29 = f28 + f19 + f18;
            fArr[3] = f29;
            fArr[4] = 0.0f;
            fArr[5] = f29;
            fArr[6] = 0.0f;
            float f36 = f28 + f18;
            fArr[7] = f36;
            float f37 = 1.0f - f16;
            fArr[8] = f37;
            fArr[9] = f36;
            fArr[10] = f37;
            float f38 = 1.0f - f17;
            float f39 = f38 - f19;
            fArr[11] = f39;
            fArr[12] = 0.0f;
            fArr[13] = f39;
            fArr[14] = 0.0f;
            fArr[15] = f38;
            fArr[16] = f27;
            fArr[17] = f38;
        } else {
            float f46 = f16 - 1.0f;
            fArr[2] = f46;
            float f47 = (f17 - 1.0f) + f18;
            fArr[3] = f47;
            fArr[4] = 0.0f;
            fArr[5] = f47;
            float f48 = 1.0f - f16;
            fArr[10] = f48;
            float f49 = 1.0f - f17;
            fArr[11] = f49;
            fArr[12] = 0.0f;
            fArr[13] = f49;
            fArr[6] = 0.0f;
            float f56 = f49 - f26;
            fArr[7] = f56;
            fArr[8] = f48;
            fArr[9] = f56;
            fArr[14] = 0.0f;
            float f57 = f47 + f26;
            fArr[15] = f57;
            fArr[16] = f46;
            fArr[17] = f57;
        }
        fArr[18] = fArr[2];
        fArr[19] = fArr[3];
        return fArr;
    }
}
