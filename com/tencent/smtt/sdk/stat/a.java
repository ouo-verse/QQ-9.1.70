package com.tencent.smtt.sdk.stat;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import java.lang.reflect.Array;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f369506f = {58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7};

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f369507g = {40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25};

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f369508h = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4};

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f369509i = {14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32};

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f369510j = {32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1};

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f369511k = {16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25};

    /* renamed from: l, reason: collision with root package name */
    private static final int[][][] f369512l = {new int[][]{new int[]{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7}, new int[]{0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8}, new int[]{4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0}, new int[]{15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}}, new int[][]{new int[]{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10}, new int[]{3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5}, new int[]{0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15}, new int[]{13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}}, new int[][]{new int[]{10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8}, new int[]{13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1}, new int[]{13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7}, new int[]{1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}}, new int[][]{new int[]{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15}, new int[]{13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9}, new int[]{10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4}, new int[]{3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}}, new int[][]{new int[]{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9}, new int[]{14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6}, new int[]{4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14}, new int[]{11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}}, new int[][]{new int[]{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11}, new int[]{10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8}, new int[]{9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6}, new int[]{4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}}, new int[][]{new int[]{4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1}, new int[]{13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6}, new int[]{1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2}, new int[]{6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}}, new int[][]{new int[]{13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7}, new int[]{1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2}, new int[]{7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8}, new int[]{2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}}};

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f369513m = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f369501a = {Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, -24, 57, -84, -115, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, 55, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f369502b = {-25, -101, -115, 1, 47, 7, -27, -59, RegisterType.REFERENCE, Byte.MIN_VALUE, 123, 79, -44, 37, 46, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM};

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f369503c = {37, -110, 60, Byte.MAX_VALUE, 42, -27, -17, -110};

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f369504d = {-122, -8, -23, -84, -125, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, 84, 99};

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f369505e = "AL!#$AC9Ahg@KLJ1".getBytes();

    private static void a(int[] iArr, int[][] iArr2) {
        int[] iArr3 = new int[56];
        for (int i3 = 0; i3 < 56; i3++) {
            iArr3[i3] = iArr[f369508h[i3] - 1];
        }
        for (int i16 = 0; i16 < 16; i16++) {
            a(iArr3, f369513m[i16]);
            for (int i17 = 0; i17 < 48; i17++) {
                iArr2[i16][i17] = iArr3[f369509i[i17] - 1];
            }
        }
    }

    private static byte[] b(byte[] bArr, byte[] bArr2, int i3) {
        if (bArr.length == 8 && bArr2.length == 8 && (i3 == 1 || i3 == 0)) {
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 16, 48);
            int[] a16 = a(bArr);
            int[] a17 = a(bArr2);
            a(a16, iArr);
            return a(a17, i3, iArr);
        }
        throw new RuntimeException("Data Format Error !");
    }

    private static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        for (int i3 = 0; i3 < 8; i3++) {
            bArr2[i3] = 0;
        }
        if (bArr.length > 8) {
            System.arraycopy(bArr, 0, bArr2, 0, 8);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        return bArr2;
    }

    private static byte[] a(int[] iArr, int i3, int[][] iArr2) {
        byte[] bArr = new byte[8];
        int[] iArr3 = new int[64];
        int[] iArr4 = new int[64];
        for (int i16 = 0; i16 < 64; i16++) {
            iArr3[i16] = iArr[f369506f[i16] - 1];
        }
        if (i3 == 1) {
            for (int i17 = 0; i17 < 16; i17++) {
                a(iArr3, i17, i3, iArr2);
            }
        } else if (i3 == 0) {
            for (int i18 = 15; i18 > -1; i18--) {
                a(iArr3, i18, i3, iArr2);
            }
        }
        for (int i19 = 0; i19 < 64; i19++) {
            iArr4[i19] = iArr3[f369507g[i19] - 1];
        }
        a(iArr4, bArr);
        return bArr;
    }

    private static byte[] b(byte[] bArr) {
        int length = bArr.length;
        int i3 = 8 - (length % 8);
        int i16 = length + i3;
        byte[] bArr2 = new byte[i16];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        while (length < i16) {
            bArr2[length] = (byte) i3;
            length++;
        }
        return bArr2;
    }

    private static int[] a(byte[] bArr) {
        int[] iArr = new int[8];
        for (int i3 = 0; i3 < 8; i3++) {
            byte b16 = bArr[i3];
            iArr[i3] = b16;
            if (b16 < 0) {
                int i16 = b16 + 256;
                iArr[i3] = i16;
                iArr[i3] = i16 % 256;
            }
        }
        int[] iArr2 = new int[64];
        for (int i17 = 0; i17 < 8; i17++) {
            for (int i18 = 0; i18 < 8; i18++) {
                iArr2[((i17 * 8) + 7) - i18] = iArr[i17] % 2;
                iArr[i17] = iArr[i17] / 2;
            }
        }
        return iArr2;
    }

    private static void a(int[] iArr, int i3) {
        int[] iArr2 = new int[28];
        int[] iArr3 = new int[28];
        int[] iArr4 = new int[28];
        int[] iArr5 = new int[28];
        for (int i16 = 0; i16 < 28; i16++) {
            iArr2[i16] = iArr[i16];
            iArr3[i16] = iArr[i16 + 28];
        }
        if (i3 == 1) {
            int i17 = 0;
            while (i17 < 27) {
                int i18 = i17 + 1;
                iArr4[i17] = iArr2[i18];
                iArr5[i17] = iArr3[i18];
                i17 = i18;
            }
            iArr4[27] = iArr2[0];
            iArr5[27] = iArr3[0];
        } else if (i3 == 2) {
            for (int i19 = 0; i19 < 26; i19++) {
                int i26 = i19 + 2;
                iArr4[i19] = iArr2[i26];
                iArr5[i19] = iArr3[i26];
            }
            iArr4[26] = iArr2[0];
            iArr5[26] = iArr3[0];
            iArr4[27] = iArr2[1];
            iArr5[27] = iArr3[1];
        }
        for (int i27 = 0; i27 < 28; i27++) {
            iArr[i27] = iArr4[i27];
            iArr[i27 + 28] = iArr5[i27];
        }
    }

    private static void a(int[] iArr, int i3, int i16, int[][] iArr2) {
        int[] iArr3 = new int[32];
        int[] iArr4 = new int[32];
        int[] iArr5 = new int[32];
        int[] iArr6 = new int[32];
        int[] iArr7 = new int[48];
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 8, 6);
        int[] iArr9 = new int[8];
        int[] iArr10 = new int[32];
        int[] iArr11 = new int[32];
        int i17 = 0;
        for (int i18 = 0; i18 < 32; i18++) {
            iArr3[i18] = iArr[i18];
            iArr4[i18] = iArr[i18 + 32];
        }
        for (int i19 = 0; i19 < 48; i19++) {
            int i26 = iArr4[f369510j[i19] - 1];
            iArr7[i19] = i26;
            int i27 = i26 + iArr2[i3][i19];
            iArr7[i19] = i27;
            if (i27 == 2) {
                iArr7[i19] = 0;
            }
        }
        int i28 = 0;
        int i29 = 8;
        while (i28 < i29) {
            for (int i36 = i17; i36 < 6; i36++) {
                iArr8[i28][i36] = iArr7[(i28 * 6) + i36];
            }
            int[][] iArr12 = f369512l[i28];
            int[] iArr13 = iArr8[i28];
            iArr9[i28] = iArr12[(iArr13[i17] << 1) + iArr13[5]][(iArr13[1] << 3) + (iArr13[2] << 2) + (iArr13[3] << 1) + iArr13[4]];
            for (int i37 = 0; i37 < 4; i37++) {
                iArr10[((i28 * 4) + 3) - i37] = iArr9[i28] % 2;
                iArr9[i28] = iArr9[i28] / 2;
            }
            i28++;
            i29 = 8;
            i17 = 0;
        }
        for (int i38 = 0; i38 < 32; i38++) {
            iArr11[i38] = iArr10[f369511k[i38] - 1];
            iArr5[i38] = iArr4[i38];
            int i39 = iArr3[i38] + iArr11[i38];
            iArr6[i38] = i39;
            if (i39 == 2) {
                iArr6[i38] = 0;
            }
            if ((i16 == 0 && i3 == 0) || (i16 == 1 && i3 == 15)) {
                iArr[i38] = iArr6[i38];
                iArr[i38 + 32] = iArr5[i38];
            } else {
                iArr[i38] = iArr5[i38];
                iArr[i38 + 32] = iArr6[i38];
            }
        }
    }

    private static void a(int[] iArr, byte[] bArr) {
        for (int i3 = 0; i3 < 8; i3++) {
            for (int i16 = 0; i16 < 8; i16++) {
                bArr[i3] = (byte) (bArr[i3] + (iArr[(i3 << 3) + i16] << (7 - i16)));
            }
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, int i3) {
        boolean z16;
        if (bArr2 != null && bArr != null) {
            try {
                byte[] c16 = c(bArr);
                byte[] b16 = b(bArr2);
                int length = b16.length;
                int i16 = length / 8;
                byte[] bArr3 = new byte[length];
                for (int i17 = 0; i17 < i16; i17++) {
                    byte[] bArr4 = new byte[8];
                    byte[] bArr5 = new byte[8];
                    System.arraycopy(c16, 0, bArr4, 0, 8);
                    int i18 = i17 * 8;
                    System.arraycopy(b16, i18, bArr5, 0, 8);
                    System.arraycopy(b(bArr4, bArr5, i3), 0, bArr3, i18, 8);
                }
                if (i3 != 0) {
                    return bArr3;
                }
                int length2 = bArr2.length;
                byte[] bArr6 = new byte[length2];
                System.arraycopy(bArr3, 0, bArr6, 0, length2);
                int i19 = length2 - 1;
                int i26 = bArr6[i19];
                if (i26 <= 0 || i26 > 8) {
                    return bArr3;
                }
                int i27 = 0;
                while (true) {
                    if (i27 >= i26) {
                        z16 = true;
                        break;
                    }
                    if (i26 != bArr6[i19 - i27]) {
                        z16 = false;
                        break;
                    }
                    i27++;
                }
                if (!z16) {
                    return bArr3;
                }
                int i28 = length2 - i26;
                byte[] bArr7 = new byte[i28];
                System.arraycopy(bArr6, 0, bArr7, 0, i28);
                return bArr7;
            } catch (Exception unused) {
            }
        }
        return bArr2;
    }
}
