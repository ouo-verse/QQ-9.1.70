package com.tencent.ttpic.openapi.model;

import android.graphics.PointF;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.view.RendererUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes27.dex */
public class CosFunParam {
    public int mHeight;
    public List<PointF> mUserFacePointsList;
    public int mWidth;
    public float[][] userAllColor;
    public float[][] userFaceColor;
    public int mFaceTexture = -1;
    public UniformParam userColor1 = new UniformParam.Float3fParam("userColor1", 0.0f, 0.0f, 0.0f);
    public UniformParam userColor2 = new UniformParam.Float3fParam("userColor2", 0.0f, 0.0f, 0.0f);
    public UniformParam modelColor1 = new UniformParam.Float3fParam("modelColor1", 0.0f, 0.0f, 0.0f);
    public UniformParam modelColor2 = new UniformParam.Float3fParam("modelColor2", 0.0f, 0.0f, 0.0f);

    public CosFunParam() {
        Class cls = Float.TYPE;
        this.userFaceColor = (float[][]) Array.newInstance((Class<?>) cls, 3, 256);
        this.userAllColor = (float[][]) Array.newInstance((Class<?>) cls, 3, 256);
    }

    private boolean isSkinColor(int i3, int i16, int i17) {
        if (i3 <= 80 && i16 <= 80 && i17 <= 80) {
            return false;
        }
        if ((i3 < 230 && i16 < 230 && i17 < 230 && (i17 >= i16 || i16 >= i3)) || i3 + i16 > 400) {
            return false;
        }
        float f16 = i3 / 255.0f;
        float f17 = i16 / 255.0f;
        float f18 = i17 / 255.0f;
        float f19 = ((128.0f - (81.085f * f16)) + (f17 * 112.0f)) - (30.915f * f18);
        float f26 = (((f16 * 112.0f) + 128.0f) - (f17 * 93.786f)) - (f18 * 18.214f);
        if (f19 < 85.0f || f19 > 135.0f || f26 < 260.0f - f19 || f26 > 280.0f - f19) {
            return false;
        }
        return true;
    }

    private boolean isSkinColorV2(int i3, int i16, int i17) {
        if (i3 <= 80 && i16 <= 80 && i17 <= 80) {
            return false;
        }
        if (i3 < 230 && i16 < 230 && i17 < 230 && (i17 >= i16 || i16 >= i3)) {
            return false;
        }
        float f16 = i3 / 255.0f;
        float f17 = i16 / 255.0f;
        float f18 = i17 / 255.0f;
        float f19 = ((128.0f - (81.085f * f16)) + (f17 * 112.0f)) - (30.915f * f18);
        float f26 = (((f16 * 112.0f) + 128.0f) - (f17 * 93.786f)) - (f18 * 18.214f);
        if (f19 < 85.0f || f19 > 135.0f || f26 < 255.0f - f19 || f26 > 280.0f - f19) {
            return false;
        }
        return true;
    }

    private List<Integer> updateColorRange(List<Double> list, boolean z16) {
        char c16;
        char c17;
        ArrayList arrayList = new ArrayList();
        if (list.size() < 2) {
            return arrayList;
        }
        int i3 = 0;
        double doubleValue = list.get(0).doubleValue();
        double doubleValue2 = list.get(1).doubleValue();
        int i16 = 3;
        int[] iArr = new int[3];
        int[] iArr2 = new int[3];
        int[] iArr3 = new int[3];
        int[] iArr4 = new int[3];
        int i17 = 0;
        while (i17 < i16) {
            iArr2[i17] = -1;
            iArr[i17] = -1;
            iArr4[i17] = -1;
            iArr3[i17] = -1;
            float f16 = 0.0f;
            int i18 = i3;
            float f17 = 0.0f;
            while (i18 < 256) {
                f16 += this.userFaceColor[i17][i18];
                float f18 = f17 + this.userAllColor[i17][i18];
                double d16 = doubleValue2;
                if (iArr[i17] < 0 && f16 > doubleValue) {
                    iArr[i17] = i18;
                }
                if (iArr2[i17] < 0 && f16 >= d16) {
                    iArr2[i17] = i18 - 1;
                }
                if (iArr3[i17] < 0 && f18 > doubleValue) {
                    iArr3[i17] = i18;
                }
                if (iArr4[i17] < 0 && f18 >= d16) {
                    iArr4[i17] = i18 - 1;
                }
                i18++;
                f17 = f18;
                doubleValue2 = d16;
            }
            double d17 = doubleValue2;
            int i19 = iArr[i17];
            if (i19 >= iArr2[i17]) {
                iArr2[i17] = i19 + 1;
            }
            int i26 = iArr3[i17];
            if (i26 >= iArr4[i17]) {
                iArr4[i17] = i26 + 1;
            }
            i17++;
            doubleValue2 = d17;
            i16 = 3;
            i3 = 0;
        }
        if (!z16) {
            iArr[2] = -1;
            c16 = 1;
            iArr[1] = -1;
            c17 = 0;
            iArr[0] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
        } else {
            c16 = 1;
            c17 = 0;
        }
        arrayList.add(Integer.valueOf(iArr[c17]));
        arrayList.add(Integer.valueOf(iArr[c16]));
        arrayList.add(Integer.valueOf(iArr[2]));
        arrayList.add(Integer.valueOf(iArr2[c17]));
        arrayList.add(Integer.valueOf(iArr2[c16]));
        arrayList.add(Integer.valueOf(iArr2[2]));
        arrayList.add(Integer.valueOf(iArr3[c17]));
        arrayList.add(Integer.valueOf(iArr3[c16]));
        arrayList.add(Integer.valueOf(iArr3[2]));
        arrayList.add(Integer.valueOf(iArr4[c17]));
        arrayList.add(Integer.valueOf(iArr4[c16]));
        arrayList.add(Integer.valueOf(iArr4[2]));
        return arrayList;
    }

    private List<Integer> updateSkinData(Frame frame, List<Double> list) {
        byte[] bArr = new byte[frame.width * frame.height * 4];
        RendererUtils.saveTextureToRgbBuffer(frame.getTextureId(), frame.width, frame.height, bArr, frame.getFBO());
        Class cls = Integer.TYPE;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) cls, 3, 256);
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) cls, 3, 256);
        int i3 = frame.width * frame.height;
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            if ((bArr[i16 + 3] & 255) < 128) {
                i16 += 4;
            } else {
                int i18 = bArr[i16] & 255;
                int i19 = bArr[i16 + 1] & 255;
                int i26 = bArr[i16 + 2] & 255;
                i16 += 4;
                if (isSkinColorV2(i18, i19, i26)) {
                    int[] iArr3 = iArr[0];
                    iArr3[i18] = iArr3[i18] + 1;
                    int[] iArr4 = iArr[1];
                    iArr4[i19] = iArr4[i19] + 1;
                    int[] iArr5 = iArr[2];
                    iArr5[i26] = iArr5[i26] + 1;
                }
                int[] iArr6 = iArr2[0];
                iArr6[i18] = iArr6[i18] + 1;
                int[] iArr7 = iArr2[1];
                iArr7[i19] = iArr7[i19] + 1;
                int[] iArr8 = iArr2[2];
                iArr8[i26] = iArr8[i26] + 1;
            }
        }
        return updateColorRange(list, updateUserSkinColor(iArr, iArr2));
    }

    public void calSkinParams(Frame frame, List<Double> list) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        float f27;
        double d16;
        double d17;
        double d18;
        float f28;
        float f29;
        float f36;
        float f37;
        float f38;
        int i3 = 0;
        if (list.size() >= 6) {
            f16 = list.get(0).floatValue();
            f18 = list.get(1).floatValue();
            f19 = list.get(2).floatValue();
            f26 = list.get(3).floatValue();
            f27 = list.get(4).floatValue();
            f17 = list.get(5).floatValue();
        } else {
            f16 = -1.0f;
            f17 = -1.0f;
            f18 = -1.0f;
            f19 = -1.0f;
            f26 = -1.0f;
            f27 = -1.0f;
        }
        int i16 = frame.width * frame.height;
        byte[] bArr = new byte[i16 * 4];
        RendererUtils.saveTextureToRgbBuffer(frame.getTextureId(), frame.width, frame.height, bArr, frame.getFBO());
        int i17 = 0;
        double d19 = 0.0d;
        double d26 = 0.0d;
        double d27 = 0.0d;
        double d28 = 0.0d;
        double d29 = 0.0d;
        double d36 = 0.0d;
        while (i3 < i16) {
            int i18 = i3 * 4;
            int i19 = bArr[i18] & 255;
            int i26 = bArr[i18 + 1] & 255;
            int i27 = bArr[i18 + 2] & 255;
            boolean isSkinColor = isSkinColor(i19, i26, i27);
            float f39 = i19 / 255.0f;
            float f46 = i26 / 255.0f;
            float f47 = i27 / 255.0f;
            if (isSkinColor) {
                f37 = f16;
                f38 = f18;
                d19 += f39;
                d26 += f46;
                d27 += f47;
                i17++;
            } else {
                f37 = f16;
                f38 = f18;
            }
            d28 += f39;
            d29 += f46;
            d36 += f47;
            i3++;
            f16 = f37;
            f18 = f38;
        }
        float f48 = f16;
        float f49 = f18;
        if (i17 < i16 / 100 || (f26 <= 0.01f && f27 <= 0.01f && f17 <= 0.01f)) {
            d16 = 0.0d;
            d17 = 0.0d;
            d18 = 0.0d;
        } else {
            double d37 = i17;
            d18 = d19 / d37;
            double d38 = d27 / d37;
            d16 = d26 / d37;
            d17 = d38;
        }
        double d39 = i16;
        float f56 = f17;
        float f57 = (float) (d28 / d39);
        float f58 = (float) (d29 / d39);
        float f59 = (float) (d36 / d39);
        if (d18 > 0.0d) {
            f57 = (float) d18;
            f58 = (float) d16;
            f28 = (float) d17;
            f36 = f27;
            f29 = f56;
        } else {
            f28 = f59;
            f29 = f19;
            f26 = f48;
            f36 = f49;
        }
        if (f26 <= 0.0f && f36 <= 0.0f && f29 <= 0.0f) {
            f36 = f58;
            f29 = f28;
            f26 = f57;
        }
        this.userColor1 = new UniformParam.Float3fParam("userColor1", f57, f58, f28);
        this.modelColor1 = new UniformParam.Float3fParam("modelColor1", f26, f36, f29);
    }

    public boolean updateUserSkinColor(int[][] iArr, int[][] iArr2) {
        boolean z16;
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < 256; i17++) {
            i16 += iArr2[0][i17];
            i3 += iArr[0][i17];
        }
        if (i3 * 5 > i16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i16 <= 0) {
            i16 = 1;
        }
        float f16 = 1.0f / i16;
        if (i3 <= 0) {
            i3 = 1;
        }
        float f17 = 1.0f / i3;
        for (int i18 = 0; i18 < 3; i18++) {
            for (int i19 = 0; i19 < 256; i19++) {
                this.userAllColor[i18][i19] = iArr2[i18][i19] * f16;
                this.userFaceColor[i18][i19] = iArr[i18][i19] * f17;
            }
        }
        return z16;
    }

    public void calSkinParams(Frame frame, List<Double> list, List<Double> list2) {
        float[] fArr;
        if (updateSkinData(frame, list2).size() < 12) {
            return;
        }
        float[] fArr2 = new float[12];
        float[] fArr3 = new float[12];
        for (int i3 = 0; i3 < 12; i3++) {
            fArr2[i3] = r1.get(i3).intValue() / 255.0f;
            fArr3[i3] = (float) (list.get(i3).doubleValue() / 255.0d);
        }
        if (fArr2[0] >= 0.0f && fArr2[1] >= 0.0f && fArr2[2] >= 0.0f && fArr3[0] >= 0.0f && fArr3[1] >= 0.0f && fArr3[2] >= 0.0f) {
            int i16 = 0;
            for (int i17 = 3; i16 < i17; i17 = 3) {
                int i18 = i16 + 3;
                float f16 = fArr3[i18];
                int i19 = i16 + 0;
                float f17 = (f16 - fArr3[i19]) - (fArr2[i18] - fArr2[i19]);
                if (f17 > 0.0f) {
                    fArr = fArr2;
                    double d16 = f16;
                    double d17 = f17 * 0.5d;
                    fArr3[i18] = (float) (d16 - d17);
                    fArr3[i19] = (float) (fArr3[i19] + d17);
                } else {
                    fArr = fArr2;
                }
                i16++;
                fArr2 = fArr;
            }
            float[] fArr4 = fArr2;
            this.userColor1 = new UniformParam.Float3fParam("userColor1", fArr4[0], fArr4[1], fArr4[2]);
            this.userColor2 = new UniformParam.Float3fParam("userColor2", fArr4[3], fArr4[4], fArr4[5]);
            this.modelColor1 = new UniformParam.Float3fParam("modelColor1", fArr3[0], fArr3[1], fArr3[2]);
            this.modelColor2 = new UniformParam.Float3fParam("modelColor2", fArr3[3], fArr3[4], fArr3[5]);
            return;
        }
        for (int i26 = 0; i26 < 3; i26++) {
            int i27 = i26 + 9;
            float f18 = fArr3[i27];
            int i28 = i26 + 6;
            float f19 = (f18 - fArr3[i28]) - (fArr2[i27] - fArr2[i28]);
            if (f19 > 0.0f) {
                double d18 = f19 * 0.5d;
                fArr3[i27] = (float) (f18 - d18);
                fArr3[i28] = (float) (fArr3[i28] + d18);
            }
        }
        this.userColor1 = new UniformParam.Float3fParam("userColor1", fArr2[6], fArr2[7], fArr2[8]);
        this.userColor2 = new UniformParam.Float3fParam("userColor2", fArr2[9], fArr2[10], fArr2[11]);
        this.modelColor1 = new UniformParam.Float3fParam("modelColor1", fArr3[6], fArr3[7], fArr3[8]);
        this.modelColor2 = new UniformParam.Float3fParam("modelColor2", fArr3[9], fArr3[10], fArr3[11]);
    }
}
