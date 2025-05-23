package com.tencent.luggage.wxa.k;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static byte[] f131368a;

    public static byte[] a(byte[] bArr, int i3, int i16, int i17) {
        byte[] c16;
        try {
            if (i17 == 90) {
                c16 = c(bArr, i3, i16);
            } else if (i17 == 180) {
                c16 = a(bArr, i3, i16);
            } else {
                if (i17 != 270) {
                    return bArr;
                }
                c16 = b(bArr, i3, i16);
            }
            return c16;
        } catch (OutOfMemoryError unused) {
            f.d("YUV420Helper", "rotate frame data fail because of OOM");
            return null;
        }
    }

    public static byte[] b(byte[] bArr, int i3, int i16) {
        byte[] bArr2 = f131368a;
        if (bArr2 == null) {
            f131368a = new byte[((i3 * i16) * 3) >> 1];
        } else {
            int i17 = ((i3 * i16) * 3) >> 1;
            if (bArr2.length != i17) {
                f131368a = new byte[i17];
            }
        }
        int i18 = i3 - 1;
        int i19 = 0;
        for (int i26 = i18; i26 >= 0; i26--) {
            int i27 = 0;
            while (i27 < i16) {
                f131368a[i19] = bArr[(i27 * i3) + i26];
                i27++;
                i19++;
            }
        }
        int i28 = i3 * i16;
        int i29 = i28;
        while (i18 > 0) {
            for (int i36 = 0; i36 < (i16 >> 1); i36++) {
                byte[] bArr3 = f131368a;
                int i37 = i29 + 1;
                int i38 = (i36 * i3) + i28;
                bArr3[i29] = bArr[(i18 - 1) + i38];
                i29 = i37 + 1;
                bArr3[i37] = bArr[i38 + i18];
            }
            i18 -= 2;
        }
        return f131368a;
    }

    public static byte[] c(byte[] bArr, int i3, int i16) {
        byte[] bArr2 = f131368a;
        if (bArr2 == null) {
            f131368a = new byte[((i3 * i16) * 3) >> 1];
        } else {
            int i17 = ((i3 * i16) * 3) >> 1;
            if (bArr2.length != i17) {
                f131368a = new byte[i17];
            }
        }
        int i18 = 0;
        for (int i19 = 0; i19 < i3; i19++) {
            int i26 = i16 - 1;
            while (i26 >= 0) {
                f131368a[i18] = bArr[(i26 * i3) + i19];
                i26--;
                i18++;
            }
        }
        int i27 = i3 * i16;
        int i28 = ((i27 * 3) >> 1) - 1;
        for (int i29 = i3 - 1; i29 > 0; i29 -= 2) {
            for (int i36 = 0; i36 < (i16 >> 1); i36++) {
                byte[] bArr3 = f131368a;
                int i37 = i28 - 1;
                int i38 = (i36 * i3) + i27;
                bArr3[i28] = bArr[i38 + i29];
                i28 = i37 - 1;
                bArr3[i37] = bArr[i38 + (i29 - 1)];
            }
        }
        return f131368a;
    }

    public static byte[] a(byte[] bArr, int i3, int i16) {
        byte[] bArr2 = f131368a;
        if (bArr2 == null) {
            f131368a = new byte[((i3 * i16) * 3) >> 1];
        } else {
            int i17 = ((i3 * i16) * 3) >> 1;
            if (bArr2.length != i17) {
                f131368a = new byte[i17];
            }
        }
        int i18 = i3 * i16;
        int i19 = i18 - 1;
        int i26 = 0;
        while (i19 >= 0) {
            f131368a[i26] = bArr[i19];
            i19--;
            i26++;
        }
        for (int i27 = ((i18 * 3) >> 1) - 1; i27 >= i18; i27 -= 2) {
            byte[] bArr3 = f131368a;
            int i28 = i26 + 1;
            bArr3[i26] = bArr[i27 - 1];
            i26 = i28 + 1;
            bArr3[i28] = bArr[i27];
        }
        return f131368a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ff, code lost:
    
        r12 = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[] bArr, int i3, int i16, int i17, int i18) {
        float f16;
        int i19;
        int i26 = i16;
        int i27 = i17;
        int i28 = i3 * i26;
        float f17 = (i27 * 1.0f) / i3;
        int i29 = i27 * i18 * 4;
        byte[] bArr2 = new byte[i29];
        int i36 = 0;
        float f18 = 0.0f;
        int i37 = 0;
        while (i36 < i26) {
            float f19 = f18 + f17;
            double d16 = f19;
            if (Math.floor(d16) == i18) {
                break;
            }
            if (Math.floor(f19 - f17) != Math.floor(d16) || (i36 == i26 - 1 && Math.floor(d16) < i26)) {
                int i38 = 0;
                float f26 = 0.0f;
                while (true) {
                    if (i38 >= i3) {
                        f16 = f19;
                        i19 = i37;
                        break;
                    }
                    f26 += f17;
                    double d17 = f26;
                    f16 = f19;
                    int i39 = i37;
                    double d18 = i27;
                    if (Math.floor(d17) == d18) {
                        i19 = i39;
                        break;
                    }
                    if (Math.floor(f26 - f17) != Math.floor(d17) || (i38 == i3 - 1 && Math.floor(d17) < d18)) {
                        int i46 = 255;
                        int i47 = ((i38 / 2) * 2) + i28;
                        int i48 = (i36 / 2) * i3;
                        float f27 = (bArr[i47 + i48] & 255) - 128.0f;
                        float f28 = (bArr[(i47 + 1) + i48] & 255) - 128.0f;
                        float f29 = ((bArr[(i36 * i3) + i38] & 255) * 1.164f) - 16.0f;
                        int i49 = (int) ((1.596f * f27) + f29);
                        int i56 = (int) ((f29 - (f27 * 0.813f)) - (0.391f * f28));
                        int i57 = (int) (f29 + (f28 * 2.018f));
                        if (i49 < 0) {
                            i49 = 0;
                        } else if (i49 > 255) {
                            i49 = 255;
                        }
                        if (i56 < 0) {
                            i56 = 0;
                        } else if (i56 > 255) {
                            i56 = 255;
                        }
                        if (i57 < 0) {
                            i46 = 0;
                        } else if (i57 <= 255) {
                            i46 = i57;
                        }
                        if (i39 > i29 - 5) {
                            return bArr2;
                        }
                        int i58 = i39 + 1;
                        bArr2[i39] = (byte) i49;
                        int i59 = i58 + 1;
                        bArr2[i58] = (byte) i56;
                        int i65 = i59 + 1;
                        bArr2[i59] = (byte) i46;
                        i37 = i65 + 1;
                        bArr2[i65] = -1;
                    } else {
                        i37 = i39;
                    }
                    i38++;
                    i27 = i17;
                    f19 = f16;
                }
            } else {
                f16 = f19;
            }
            i36++;
            i26 = i16;
            i27 = i17;
            f18 = f16;
        }
        return bArr2;
    }
}
