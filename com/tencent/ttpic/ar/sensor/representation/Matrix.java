package com.tencent.ttpic.ar.sensor.representation;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Matrix {
    private static final float[] TEMP_MATRIX_ARRAY = new float[32];

    public static void frustumM(float[] fArr, int i3, float f16, float f17, float f18, float f19, float f26, float f27) {
        if (f16 != f17) {
            if (f19 != f18) {
                if (f26 != f27) {
                    if (f26 > 0.0f) {
                        if (f27 > 0.0f) {
                            float f28 = 1.0f / (f17 - f16);
                            float f29 = 1.0f / (f19 - f18);
                            float f36 = 1.0f / (f26 - f27);
                            float f37 = (f17 + f16) * f28 * 2.0f;
                            float f38 = (f19 + f18) * f29;
                            fArr[i3 + 0] = f26 * f28 * 2.0f;
                            fArr[i3 + 5] = f26 * f29 * 2.0f;
                            fArr[i3 + 8] = f37;
                            fArr[i3 + 9] = f38;
                            fArr[i3 + 10] = (f27 + f26) * f36;
                            fArr[i3 + 14] = f27 * f26 * f36 * 2.0f;
                            fArr[i3 + 11] = -1.0f;
                            fArr[i3 + 1] = 0.0f;
                            fArr[i3 + 2] = 0.0f;
                            fArr[i3 + 3] = 0.0f;
                            fArr[i3 + 4] = 0.0f;
                            fArr[i3 + 6] = 0.0f;
                            fArr[i3 + 7] = 0.0f;
                            fArr[i3 + 12] = 0.0f;
                            fArr[i3 + 13] = 0.0f;
                            fArr[i3 + 15] = 0.0f;
                            return;
                        }
                        throw new IllegalArgumentException("far <= 0.0f");
                    }
                    throw new IllegalArgumentException("near <= 0.0f");
                }
                throw new IllegalArgumentException("near == far");
            }
            throw new IllegalArgumentException("top == bottom");
        }
        throw new IllegalArgumentException("left == right");
    }

    public static boolean invertM(float[] fArr, int i3, float[] fArr2, int i16) {
        float f16 = fArr2[i16 + 0];
        float f17 = fArr2[i16 + 1];
        float f18 = fArr2[i16 + 2];
        float f19 = fArr2[i16 + 3];
        float f26 = fArr2[i16 + 4];
        float f27 = fArr2[i16 + 5];
        float f28 = fArr2[i16 + 6];
        float f29 = fArr2[i16 + 7];
        float f36 = fArr2[i16 + 8];
        float f37 = fArr2[i16 + 9];
        float f38 = fArr2[i16 + 10];
        float f39 = fArr2[i16 + 11];
        float f46 = fArr2[i16 + 12];
        float f47 = fArr2[i16 + 13];
        float f48 = fArr2[i16 + 14];
        float f49 = fArr2[i16 + 15];
        float f56 = f38 * f49;
        float f57 = f48 * f39;
        float f58 = f28 * f49;
        float f59 = f48 * f29;
        float f65 = f28 * f39;
        float f66 = f38 * f29;
        float f67 = f18 * f49;
        float f68 = f48 * f19;
        float f69 = f18 * f39;
        float f75 = f38 * f19;
        float f76 = f18 * f29;
        float f77 = f28 * f19;
        float f78 = (((f56 * f27) + (f59 * f37)) + (f65 * f47)) - (((f57 * f27) + (f58 * f37)) + (f66 * f47));
        float f79 = (((f57 * f17) + (f67 * f37)) + (f75 * f47)) - (((f56 * f17) + (f68 * f37)) + (f69 * f47));
        float f85 = (((f58 * f17) + (f68 * f27)) + (f76 * f47)) - (((f59 * f17) + (f67 * f27)) + (f77 * f47));
        float f86 = (((f66 * f17) + (f69 * f27)) + (f77 * f37)) - (((f65 * f17) + (f75 * f27)) + (f76 * f37));
        float f87 = (((f57 * f26) + (f58 * f36)) + (f66 * f46)) - (((f56 * f26) + (f59 * f36)) + (f65 * f46));
        float f88 = (((f56 * f16) + (f68 * f36)) + (f69 * f46)) - (((f57 * f16) + (f67 * f36)) + (f75 * f46));
        float f89 = (((f59 * f16) + (f67 * f26)) + (f77 * f46)) - (((f58 * f16) + (f68 * f26)) + (f76 * f46));
        float f95 = (((f65 * f16) + (f75 * f26)) + (f76 * f36)) - (((f66 * f16) + (f69 * f26)) + (f77 * f36));
        float f96 = f36 * f47;
        float f97 = f46 * f37;
        float f98 = f26 * f47;
        float f99 = f46 * f27;
        float f100 = f26 * f37;
        float f101 = f36 * f27;
        float f102 = f47 * f16;
        float f103 = f46 * f17;
        float f104 = f37 * f16;
        float f105 = f36 * f17;
        float f106 = f27 * f16;
        float f107 = f17 * f26;
        float f108 = (((f96 * f29) + (f99 * f39)) + (f100 * f49)) - (((f97 * f29) + (f98 * f39)) + (f101 * f49));
        float f109 = (((f97 * f19) + (f102 * f39)) + (f105 * f49)) - (((f96 * f19) + (f103 * f39)) + (f104 * f49));
        float f110 = (((f98 * f19) + (f103 * f29)) + (f106 * f49)) - (((f99 * f19) + (f102 * f29)) + (f49 * f107));
        float f111 = (((f101 * f19) + (f104 * f29)) + (f107 * f39)) - (((f19 * f100) + (f29 * f105)) + (f39 * f106));
        float f112 = (((f98 * f38) + (f101 * f48)) + (f97 * f28)) - (((f100 * f48) + (f96 * f28)) + (f99 * f38));
        float f113 = (((f104 * f48) + (f96 * f18)) + (f103 * f38)) - (((f102 * f38) + (f105 * f48)) + (f97 * f18));
        float f114 = (((f102 * f28) + (f107 * f48)) + (f99 * f18)) - (((f48 * f106) + (f98 * f18)) + (f103 * f28));
        float f115 = (((f106 * f38) + (f100 * f18)) + (f105 * f28)) - (((f104 * f28) + (f107 * f38)) + (f101 * f18));
        float f116 = (f16 * f78) + (f26 * f79) + (f36 * f85) + (f46 * f86);
        if (f116 == 0.0f) {
            return false;
        }
        float f117 = 1.0f / f116;
        fArr[i3] = f78 * f117;
        fArr[i3 + 1] = f79 * f117;
        fArr[i3 + 2] = f85 * f117;
        fArr[i3 + 3] = f86 * f117;
        fArr[i3 + 4] = f87 * f117;
        fArr[i3 + 5] = f88 * f117;
        fArr[i3 + 6] = f89 * f117;
        fArr[i3 + 7] = f95 * f117;
        fArr[i3 + 8] = f108 * f117;
        fArr[i3 + 9] = f109 * f117;
        fArr[i3 + 10] = f110 * f117;
        fArr[i3 + 11] = f111 * f117;
        fArr[i3 + 12] = f112 * f117;
        fArr[i3 + 13] = f113 * f117;
        fArr[i3 + 14] = f114 * f117;
        fArr[i3 + 15] = f115 * f117;
        return true;
    }

    public static float length(float f16, float f17, float f18) {
        return (float) Math.sqrt((f16 * f16) + (f17 * f17) + (f18 * f18));
    }

    public static void multiplyMM(float[] fArr, int i3, float[] fArr2, int i16, float[] fArr3, int i17) {
        int i18 = i16 + 0;
        int i19 = i17 + 0;
        int i26 = i16 + 4;
        int i27 = i17 + 1;
        int i28 = i16 + 8;
        int i29 = i17 + 2;
        int i36 = i16 + 12;
        int i37 = i17 + 3;
        fArr[i3 + 0] = (fArr2[i18] * fArr3[i19]) + (fArr2[i26] * fArr3[i27]) + (fArr2[i28] * fArr3[i29]) + (fArr2[i36] * fArr3[i37]);
        int i38 = i16 + 1;
        int i39 = i16 + 5;
        int i46 = i16 + 9;
        int i47 = i16 + 13;
        fArr[i3 + 1] = (fArr2[i38] * fArr3[i19]) + (fArr2[i39] * fArr3[i27]) + (fArr2[i46] * fArr3[i29]) + (fArr2[i47] * fArr3[i37]);
        int i48 = i16 + 2;
        int i49 = i16 + 6;
        int i56 = i16 + 10;
        int i57 = i16 + 14;
        fArr[i3 + 2] = (fArr2[i48] * fArr3[i19]) + (fArr2[i49] * fArr3[i27]) + (fArr2[i56] * fArr3[i29]) + (fArr2[i57] * fArr3[i37]);
        int i58 = i16 + 3;
        float f16 = fArr2[i58] * fArr3[i19];
        int i59 = i16 + 7;
        float f17 = f16 + (fArr2[i59] * fArr3[i27]);
        int i65 = i16 + 11;
        float f18 = f17 + (fArr2[i65] * fArr3[i29]);
        int i66 = i16 + 15;
        fArr[i3 + 3] = f18 + (fArr2[i66] * fArr3[i37]);
        int i67 = i17 + 4;
        int i68 = i17 + 5;
        int i69 = i17 + 6;
        int i75 = i17 + 7;
        fArr[i3 + 4] = (fArr2[i18] * fArr3[i67]) + (fArr2[i26] * fArr3[i68]) + (fArr2[i28] * fArr3[i69]) + (fArr2[i36] * fArr3[i75]);
        fArr[i3 + 5] = (fArr2[i38] * fArr3[i67]) + (fArr2[i39] * fArr3[i68]) + (fArr2[i46] * fArr3[i69]) + (fArr2[i47] * fArr3[i75]);
        fArr[i3 + 6] = (fArr2[i48] * fArr3[i67]) + (fArr2[i49] * fArr3[i68]) + (fArr2[i56] * fArr3[i69]) + (fArr2[i57] * fArr3[i75]);
        fArr[i3 + 7] = (fArr2[i58] * fArr3[i67]) + (fArr2[i59] * fArr3[i68]) + (fArr2[i65] * fArr3[i69]) + (fArr2[i66] * fArr3[i75]);
        int i76 = i17 + 8;
        int i77 = i17 + 9;
        int i78 = i17 + 10;
        int i79 = i17 + 11;
        fArr[i3 + 8] = (fArr2[i18] * fArr3[i76]) + (fArr2[i26] * fArr3[i77]) + (fArr2[i28] * fArr3[i78]) + (fArr2[i36] * fArr3[i79]);
        fArr[i3 + 9] = (fArr2[i38] * fArr3[i76]) + (fArr2[i39] * fArr3[i77]) + (fArr2[i46] * fArr3[i78]) + (fArr2[i47] * fArr3[i79]);
        fArr[i3 + 10] = (fArr2[i48] * fArr3[i76]) + (fArr2[i49] * fArr3[i77]) + (fArr2[i56] * fArr3[i78]) + (fArr2[i57] * fArr3[i79]);
        fArr[i3 + 11] = (fArr2[i58] * fArr3[i76]) + (fArr2[i59] * fArr3[i77]) + (fArr2[i65] * fArr3[i78]) + (fArr2[i66] * fArr3[i79]);
        int i85 = i17 + 12;
        int i86 = i17 + 13;
        float f19 = (fArr2[i18] * fArr3[i85]) + (fArr2[i26] * fArr3[i86]);
        float f26 = fArr2[i28];
        int i87 = i17 + 14;
        float f27 = f19 + (f26 * fArr3[i87]);
        float f28 = fArr2[i36];
        int i88 = i17 + 15;
        fArr[i3 + 12] = f27 + (f28 * fArr3[i88]);
        fArr[i3 + 13] = (fArr2[i38] * fArr3[i85]) + (fArr2[i39] * fArr3[i86]) + (fArr2[i46] * fArr3[i87]) + (fArr2[i47] * fArr3[i88]);
        fArr[i3 + 14] = (fArr2[i48] * fArr3[i85]) + (fArr2[i49] * fArr3[i86]) + (fArr2[i56] * fArr3[i87]) + (fArr2[i57] * fArr3[i88]);
        fArr[i3 + 15] = (fArr2[i58] * fArr3[i85]) + (fArr2[i59] * fArr3[i86]) + (fArr2[i65] * fArr3[i87]) + (fArr2[i66] * fArr3[i88]);
    }

    public static void multiplyMV(float[] fArr, int i3, float[] fArr2, int i16, float[] fArr3, int i17) {
        int i18 = i17 + 0;
        int i19 = i17 + 1;
        int i26 = i17 + 2;
        int i27 = i17 + 3;
        fArr[i3 + 0] = (fArr2[i16 + 0] * fArr3[i18]) + (fArr2[i16 + 4] * fArr3[i19]) + (fArr2[i16 + 8] * fArr3[i26]) + (fArr2[i16 + 12] * fArr3[i27]);
        fArr[i3 + 1] = (fArr2[i16 + 1] * fArr3[i18]) + (fArr2[i16 + 5] * fArr3[i19]) + (fArr2[i16 + 9] * fArr3[i26]) + (fArr2[i16 + 13] * fArr3[i27]);
        fArr[i3 + 2] = (fArr2[i16 + 2] * fArr3[i18]) + (fArr2[i16 + 6] * fArr3[i19]) + (fArr2[i16 + 10] * fArr3[i26]) + (fArr2[i16 + 14] * fArr3[i27]);
        fArr[i3 + 3] = (fArr2[i16 + 3] * fArr3[i18]) + (fArr2[i16 + 7] * fArr3[i19]) + (fArr2[i16 + 11] * fArr3[i26]) + (fArr2[i16 + 15] * fArr3[i27]);
    }

    public static void multiplyMV3(float[] fArr, float[] fArr2, float[] fArr3, float f16) {
        float f17 = fArr2[0] * fArr3[0];
        float f18 = fArr2[4];
        float f19 = fArr3[1];
        float f26 = f17 + (f18 * f19);
        float f27 = fArr2[8];
        float f28 = fArr3[2];
        fArr[0] = f26 + (f27 * f28) + (fArr2[12] * f16);
        float f29 = fArr2[1];
        float f36 = fArr3[0];
        fArr[1] = (f29 * f36) + (fArr2[5] * f19) + (fArr2[9] * f28) + (fArr2[13] * f16);
        fArr[2] = (fArr2[2] * f36) + (fArr2[6] * fArr3[1]) + (fArr2[10] * f28) + (fArr2[14] * f16);
    }

    public static void orthoM(float[] fArr, int i3, float f16, float f17, float f18, float f19, float f26, float f27) {
        if (f16 != f17) {
            if (f18 != f19) {
                if (f26 != f27) {
                    float f28 = 1.0f / (f17 - f16);
                    float f29 = 1.0f / (f19 - f18);
                    float f36 = 1.0f / (f27 - f26);
                    float f37 = (-(f17 + f16)) * f28;
                    float f38 = (-(f19 + f18)) * f29;
                    fArr[i3 + 0] = f28 * 2.0f;
                    fArr[i3 + 5] = 2.0f * f29;
                    fArr[i3 + 10] = (-2.0f) * f36;
                    fArr[i3 + 12] = f37;
                    fArr[i3 + 13] = f38;
                    fArr[i3 + 14] = (-(f27 + f26)) * f36;
                    fArr[i3 + 15] = 1.0f;
                    fArr[i3 + 1] = 0.0f;
                    fArr[i3 + 2] = 0.0f;
                    fArr[i3 + 3] = 0.0f;
                    fArr[i3 + 4] = 0.0f;
                    fArr[i3 + 6] = 0.0f;
                    fArr[i3 + 7] = 0.0f;
                    fArr[i3 + 8] = 0.0f;
                    fArr[i3 + 9] = 0.0f;
                    fArr[i3 + 11] = 0.0f;
                    return;
                }
                throw new IllegalArgumentException("near == far");
            }
            throw new IllegalArgumentException("bottom == top");
        }
        throw new IllegalArgumentException("left == right");
    }

    public static void perspectiveM(float[] fArr, int i3, float f16, float f17, float f18, float f19) {
        float tan = 1.0f / ((float) Math.tan(f16 * 0.008726646259971648d));
        float f26 = 1.0f / (f18 - f19);
        fArr[i3 + 0] = tan / f17;
        fArr[i3 + 1] = 0.0f;
        fArr[i3 + 2] = 0.0f;
        fArr[i3 + 3] = 0.0f;
        fArr[i3 + 4] = 0.0f;
        fArr[i3 + 5] = tan;
        fArr[i3 + 6] = 0.0f;
        fArr[i3 + 7] = 0.0f;
        fArr[i3 + 8] = 0.0f;
        fArr[i3 + 9] = 0.0f;
        fArr[i3 + 10] = (f19 + f18) * f26;
        fArr[i3 + 11] = -1.0f;
        fArr[i3 + 12] = 0.0f;
        fArr[i3 + 13] = 0.0f;
        fArr[i3 + 14] = f19 * 2.0f * f18 * f26;
        fArr[i3 + 15] = 0.0f;
    }

    public static void rotateM(float[] fArr, int i3, float[] fArr2, int i16, float f16, float f17, float f18, float f19) {
        float[] fArr3 = TEMP_MATRIX_ARRAY;
        synchronized (fArr3) {
            setRotateM(fArr3, 0, f16, f17, f18, f19);
            multiplyMM(fArr, i3, fArr2, i16, fArr3, 0);
        }
    }

    public static void scaleM(float[] fArr, int i3, float[] fArr2, int i16, float f16, float f17, float f18) {
        for (int i17 = 0; i17 < 4; i17++) {
            int i18 = i3 + i17;
            int i19 = i16 + i17;
            fArr[i18] = fArr2[i19] * f16;
            fArr[i18 + 4] = fArr2[i19 + 4] * f17;
            fArr[i18 + 8] = fArr2[i19 + 8] * f18;
            fArr[i18 + 12] = fArr2[i19 + 12];
        }
    }

    public static void setIdentityM(float[] fArr, int i3) {
        for (int i16 = 0; i16 < 16; i16++) {
            fArr[i3 + i16] = 0.0f;
        }
        for (int i17 = 0; i17 < 16; i17 += 5) {
            fArr[i3 + i17] = 1.0f;
        }
    }

    public static void setLookAtM(float[] fArr, int i3, float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, float f36) {
        float f37 = f19 - f16;
        float f38 = f26 - f17;
        float f39 = f27 - f18;
        float length = 1.0f / length(f37, f38, f39);
        float f46 = f37 * length;
        float f47 = f38 * length;
        float f48 = f39 * length;
        float f49 = (f47 * f36) - (f48 * f29);
        float f56 = (f48 * f28) - (f36 * f46);
        float f57 = (f29 * f46) - (f28 * f47);
        float length2 = 1.0f / length(f49, f56, f57);
        float f58 = f49 * length2;
        float f59 = f56 * length2;
        float f65 = f57 * length2;
        fArr[i3 + 0] = f58;
        fArr[i3 + 1] = (f59 * f48) - (f65 * f47);
        fArr[i3 + 2] = -f46;
        fArr[i3 + 3] = 0.0f;
        fArr[i3 + 4] = f59;
        fArr[i3 + 5] = (f65 * f46) - (f58 * f48);
        fArr[i3 + 6] = -f47;
        fArr[i3 + 7] = 0.0f;
        fArr[i3 + 8] = f65;
        fArr[i3 + 9] = (f58 * f47) - (f59 * f46);
        fArr[i3 + 10] = -f48;
        fArr[i3 + 11] = 0.0f;
        fArr[i3 + 12] = 0.0f;
        fArr[i3 + 13] = 0.0f;
        fArr[i3 + 14] = 0.0f;
        fArr[i3 + 15] = 1.0f;
        translateM(fArr, i3, -f16, -f17, -f18);
    }

    public static void setRotateEulerM(float[] fArr, int i3, float f16, float f17, float f18) {
        double d16 = f16 * 0.017453292f;
        float cos = (float) Math.cos(d16);
        float sin = (float) Math.sin(d16);
        double d17 = f17 * 0.017453292f;
        float cos2 = (float) Math.cos(d17);
        float sin2 = (float) Math.sin(d17);
        double d18 = f18 * 0.017453292f;
        float cos3 = (float) Math.cos(d18);
        float sin3 = (float) Math.sin(d18);
        float f19 = cos * sin2;
        float f26 = sin * sin2;
        fArr[i3 + 0] = cos2 * cos3;
        fArr[i3 + 1] = (-cos2) * sin3;
        fArr[i3 + 2] = sin2;
        fArr[i3 + 3] = 0.0f;
        fArr[i3 + 4] = (f19 * cos3) + (cos * sin3);
        fArr[i3 + 5] = ((-f19) * sin3) + (cos * cos3);
        fArr[i3 + 6] = (-sin) * cos2;
        fArr[i3 + 7] = 0.0f;
        fArr[i3 + 8] = ((-f26) * cos3) + (sin * sin3);
        fArr[i3 + 9] = (f26 * sin3) + (sin * cos3);
        fArr[i3 + 10] = cos * cos2;
        fArr[i3 + 11] = 0.0f;
        fArr[i3 + 12] = 0.0f;
        fArr[i3 + 13] = 0.0f;
        fArr[i3 + 14] = 0.0f;
        fArr[i3 + 15] = 1.0f;
    }

    public static void setRotateM(float[] fArr, int i3, float f16, float f17, float f18, float f19) {
        fArr[i3 + 3] = 0.0f;
        fArr[i3 + 7] = 0.0f;
        fArr[i3 + 11] = 0.0f;
        fArr[i3 + 12] = 0.0f;
        fArr[i3 + 13] = 0.0f;
        fArr[i3 + 14] = 0.0f;
        fArr[i3 + 15] = 1.0f;
        double d16 = f16 * 0.017453292f;
        float sin = (float) Math.sin(d16);
        float cos = (float) Math.cos(d16);
        if (1.0f == f17 && 0.0f == f18 && 0.0f == f19) {
            fArr[i3 + 5] = cos;
            fArr[i3 + 10] = cos;
            fArr[i3 + 6] = sin;
            fArr[i3 + 9] = -sin;
            fArr[i3 + 1] = 0.0f;
            fArr[i3 + 2] = 0.0f;
            fArr[i3 + 4] = 0.0f;
            fArr[i3 + 8] = 0.0f;
            fArr[i3 + 0] = 1.0f;
            return;
        }
        if (0.0f == f17 && 1.0f == f18 && 0.0f == f19) {
            fArr[i3 + 0] = cos;
            fArr[i3 + 10] = cos;
            fArr[i3 + 8] = sin;
            fArr[i3 + 2] = -sin;
            fArr[i3 + 1] = 0.0f;
            fArr[i3 + 4] = 0.0f;
            fArr[i3 + 6] = 0.0f;
            fArr[i3 + 9] = 0.0f;
            fArr[i3 + 5] = 1.0f;
            return;
        }
        if (0.0f == f17 && 0.0f == f18 && 1.0f == f19) {
            fArr[i3 + 0] = cos;
            fArr[i3 + 5] = cos;
            fArr[i3 + 1] = sin;
            fArr[i3 + 4] = -sin;
            fArr[i3 + 2] = 0.0f;
            fArr[i3 + 6] = 0.0f;
            fArr[i3 + 8] = 0.0f;
            fArr[i3 + 9] = 0.0f;
            fArr[i3 + 10] = 1.0f;
            return;
        }
        float length = length(f17, f18, f19);
        if (1.0f != length) {
            float f26 = 1.0f / length;
            f17 *= f26;
            f18 *= f26;
            f19 *= f26;
        }
        float f27 = 1.0f - cos;
        float f28 = f17 * sin;
        float f29 = f18 * sin;
        float f36 = sin * f19;
        fArr[i3 + 0] = (f17 * f17 * f27) + cos;
        float f37 = f17 * f18 * f27;
        fArr[i3 + 4] = f37 - f36;
        float f38 = f19 * f17 * f27;
        fArr[i3 + 8] = f38 + f29;
        fArr[i3 + 1] = f37 + f36;
        fArr[i3 + 5] = (f18 * f18 * f27) + cos;
        float f39 = f18 * f19 * f27;
        fArr[i3 + 9] = f39 - f28;
        fArr[i3 + 2] = f38 - f29;
        fArr[i3 + 6] = f39 + f28;
        fArr[i3 + 10] = (f19 * f19 * f27) + cos;
    }

    public static void translateM(float[] fArr, int i3, float[] fArr2, int i16, float f16, float f17, float f18) {
        for (int i17 = 0; i17 < 12; i17++) {
            fArr[i3 + i17] = fArr2[i16 + i17];
        }
        for (int i18 = 0; i18 < 4; i18++) {
            int i19 = i16 + i18;
            fArr[i3 + i18 + 12] = (fArr2[i19] * f16) + (fArr2[i19 + 4] * f17) + (fArr2[i19 + 8] * f18) + fArr2[i19 + 12];
        }
    }

    public static void transposeM(float[] fArr, int i3, float[] fArr2, int i16) {
        for (int i17 = 0; i17 < 4; i17++) {
            int i18 = (i17 * 4) + i16;
            fArr[i17 + i3] = fArr2[i18];
            fArr[i17 + 4 + i3] = fArr2[i18 + 1];
            fArr[i17 + 8 + i3] = fArr2[i18 + 2];
            fArr[i17 + 12 + i3] = fArr2[i18 + 3];
        }
    }

    public static void translateM(float[] fArr, int i3, float f16, float f17, float f18) {
        for (int i16 = 0; i16 < 4; i16++) {
            int i17 = i3 + i16;
            int i18 = i17 + 12;
            fArr[i18] = fArr[i18] + (fArr[i17] * f16) + (fArr[i17 + 4] * f17) + (fArr[i17 + 8] * f18);
        }
    }

    public static void multiplyMV(float[] fArr, float[] fArr2, float[] fArr3) {
        float f16 = fArr2[0] * fArr3[0];
        float f17 = fArr2[4];
        float f18 = fArr3[1];
        float f19 = f16 + (f17 * f18);
        float f26 = fArr2[8];
        float f27 = fArr3[2];
        float f28 = f19 + (f26 * f27);
        float f29 = fArr2[12];
        float f36 = fArr3[3];
        fArr[0] = f28 + (f29 * f36);
        float f37 = fArr2[1];
        float f38 = fArr3[0];
        fArr[1] = (f37 * f38) + (fArr2[5] * f18) + (fArr2[9] * f27) + (fArr2[13] * f36);
        float f39 = fArr2[2] * f38;
        float f46 = fArr2[6];
        float f47 = fArr3[1];
        fArr[2] = f39 + (f46 * f47) + (fArr2[10] * f27) + (fArr2[14] * f36);
        fArr[3] = (fArr2[3] * f38) + (fArr2[7] * f47) + (fArr2[11] * fArr3[2]) + (fArr2[15] * f36);
    }

    public static void rotateM(float[] fArr, int i3, float f16, float f17, float f18, float f19) {
        float[] fArr2 = TEMP_MATRIX_ARRAY;
        synchronized (fArr2) {
            setRotateM(fArr2, 0, f16, f17, f18, f19);
            multiplyMM(fArr2, 16, fArr, i3, fArr2, 0);
            System.arraycopy(fArr2, 16, fArr, i3, 16);
        }
    }

    public static void scaleM(float[] fArr, int i3, float f16, float f17, float f18) {
        for (int i16 = 0; i16 < 4; i16++) {
            int i17 = i3 + i16;
            fArr[i17] = fArr[i17] * f16;
            int i18 = i17 + 4;
            fArr[i18] = fArr[i18] * f17;
            int i19 = i17 + 8;
            fArr[i19] = fArr[i19] * f18;
        }
    }

    public static void multiplyMM(float[] fArr, float[] fArr2, float[] fArr3) {
        float f16 = fArr2[0] * fArr3[0];
        float f17 = fArr2[4];
        float f18 = fArr3[1];
        float f19 = fArr2[8];
        float f26 = fArr3[2];
        float f27 = fArr2[12];
        float f28 = fArr3[3];
        fArr[0] = f16 + (f17 * f18) + (f19 * f26) + (f27 * f28);
        float f29 = fArr2[1];
        float f36 = fArr3[0];
        float f37 = fArr2[5];
        float f38 = fArr2[9];
        float f39 = fArr2[13];
        fArr[1] = (f29 * f36) + (f18 * f37) + (f38 * f26) + (f39 * f28);
        float f46 = fArr2[2] * f36;
        float f47 = fArr2[6];
        float f48 = fArr3[1];
        float f49 = fArr2[10];
        float f56 = fArr2[14];
        fArr[2] = f46 + (f47 * f48) + (f26 * f49) + (f56 * f28);
        float f57 = fArr2[3] * f36;
        float f58 = fArr2[7];
        float f59 = fArr2[11];
        float f65 = f57 + (f48 * f58) + (fArr3[2] * f59);
        float f66 = fArr2[15];
        fArr[3] = f65 + (f28 * f66);
        if (fArr3.length > 4) {
            float f67 = fArr2[0];
            float f68 = fArr3[4] * f67;
            float f69 = fArr3[5];
            float f75 = f68 + (f17 * f69);
            float f76 = fArr3[6];
            float f77 = fArr3[7];
            fArr[4] = f75 + (f19 * f76) + (f27 * f77);
            float f78 = fArr2[1];
            float f79 = fArr3[4];
            fArr[5] = (f78 * f79) + (f37 * f69) + (f38 * f76) + (f39 * f77);
            float f85 = fArr2[2];
            float f86 = fArr3[5];
            fArr[6] = (f85 * f79) + (f47 * f86) + (f76 * f49) + (f56 * f77);
            float f87 = fArr2[3];
            fArr[7] = (f79 * f87) + (f58 * f86) + (fArr3[6] * f59) + (f77 * f66);
            if (fArr3.length > 8) {
                float f88 = fArr3[8] * f67;
                float f89 = fArr2[4];
                float f95 = fArr3[9];
                float f96 = f88 + (f89 * f95);
                float f97 = fArr3[10];
                float f98 = f96 + (f19 * f97);
                float f99 = fArr3[11];
                fArr[8] = f98 + (f27 * f99);
                float f100 = fArr3[8];
                fArr[9] = (f78 * f100) + (fArr2[5] * f95) + (f38 * f97) + (f39 * f99);
                float f101 = fArr2[6];
                float f102 = fArr3[9];
                fArr[10] = (f85 * f100) + (f101 * f102) + (f49 * f97) + (f56 * f99);
                fArr[11] = (f100 * f87) + (fArr2[7] * f102) + (f59 * fArr3[10]) + (f99 * f66);
            }
            if (fArr3.length > 12) {
                float f103 = f67 * fArr3[12];
                float f104 = fArr2[4];
                float f105 = fArr3[13];
                float f106 = f103 + (f104 * f105);
                float f107 = fArr2[8];
                float f108 = fArr3[14];
                float f109 = f106 + (f107 * f108);
                float f110 = fArr3[15];
                fArr[12] = f109 + (f27 * f110);
                float f111 = fArr3[12];
                fArr[13] = (f78 * f111) + (fArr2[5] * f105) + (fArr2[9] * f108) + (f39 * f110);
                float f112 = fArr2[6];
                float f113 = fArr3[13];
                fArr[14] = (f85 * f111) + (f112 * f113) + (fArr2[10] * f108) + (f56 * f110);
                fArr[15] = (f87 * f111) + (fArr2[7] * f113) + (fArr2[11] * fArr3[14]) + (f66 * f110);
            }
        }
    }
}
