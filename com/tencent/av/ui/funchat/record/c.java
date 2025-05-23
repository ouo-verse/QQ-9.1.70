package com.tencent.av.ui.funchat.record;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {
    public static byte[] a(byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26) {
        if (i16 != i19) {
            bArr = b(bArr, i16, i19);
        }
        if (i17 != i26) {
            bArr = c(bArr, i17, i26, i19);
        }
        if (i3 != i18) {
            return e(bArr, i19, i3, i18);
        }
        return bArr;
    }

    private static byte[] b(byte[] bArr, int i3, int i16) {
        if (bArr != null && bArr.length != 0) {
            if (i3 == i16) {
                if (QLog.isColorLevel()) {
                    QLog.d("PCMConverter", 2, "converteBitCount, srcBitCount == targetBitCount");
                }
                return bArr;
            }
            if (i3 == 8 && i16 == 16) {
                byte[] bArr2 = new byte[bArr.length * 2];
                for (int i17 = 0; i17 < bArr.length; i17++) {
                    short s16 = (short) (bArr[i17] * 256);
                    int i18 = i17 * 2;
                    bArr2[i18 + 1] = (byte) (s16 & 255);
                    bArr2[i18] = (byte) (((short) (s16 >> 8)) & 255);
                }
                return bArr2;
            }
            if (i3 == 16 && i16 == 8) {
                byte[] bArr3 = new byte[bArr.length / 2];
                for (int i19 = 0; i19 < bArr.length / 2; i19++) {
                    int i26 = i19 * 2;
                    bArr3[i19] = (byte) (((short) ((bArr[i26] & 255) | ((short) (((short) ((bArr[i26 + 1] & 255) | 0)) << 8)))) / 256);
                }
                return bArr3;
            }
            return bArr;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PCMConverter", 2, "converteBitCount, srcData == null || srcData.length == 0");
        }
        return bArr;
    }

    private static byte[] c(byte[] bArr, int i3, int i16, int i17) {
        if (bArr != null && bArr.length != 0) {
            if (i3 == i16) {
                if (QLog.isColorLevel()) {
                    QLog.d("PCMConverter", 2, "convertChannelCount, srcChannelCount == targetChannelCount");
                }
                return bArr;
            }
            if (i17 != 8 && i17 != 16) {
                if (QLog.isColorLevel()) {
                    QLog.d("PCMConverter", 2, "convertChannelCount, only support bit8 and bit16");
                }
                return bArr;
            }
            int i18 = 0;
            if (i3 == 1 && i16 == 2) {
                byte[] bArr2 = new byte[bArr.length * 2];
                if (i17 == 8) {
                    while (i18 < bArr.length) {
                        int i19 = i18 * 2;
                        bArr2[i19] = bArr[i18];
                        bArr2[i19 + 1] = bArr[i18];
                        i18++;
                    }
                } else {
                    while (i18 < bArr.length / 2) {
                        int i26 = i18 * 4;
                        int i27 = i18 * 2;
                        bArr2[i26] = bArr[i27];
                        int i28 = i27 + 1;
                        bArr2[i26 + 1] = bArr[i28];
                        bArr2[i26 + 2] = bArr[i27];
                        bArr2[i26 + 3] = bArr[i28];
                        i18++;
                    }
                }
                return bArr2;
            }
            if (i3 == 2 && i16 == 1) {
                byte[] bArr3 = new byte[bArr.length / 2];
                if (i17 == 8) {
                    while (i18 < bArr.length / 2) {
                        int i29 = i18 * 2;
                        bArr3[i18] = (byte) (((short) (bArr[i29] + bArr[i29 + 1])) >> 1);
                        i18++;
                    }
                } else if (i17 == 16) {
                    for (int i36 = 0; i36 < bArr.length / 4; i36++) {
                        int i37 = i36 * 4;
                        short s16 = (short) ((((short) (((short) (((short) ((bArr[i37 + 1] & 255) | 0)) << 8)) | (bArr[i37] & 255))) / 2) + (((short) ((bArr[i37 + 2] & 255) | ((short) (((short) ((bArr[i37 + 3] & 255) | 0)) << 8)))) / 2));
                        int i38 = i36 * 2;
                        bArr3[i38] = (byte) (s16 & 255);
                        bArr3[i38 + 1] = (byte) (((short) (s16 >> 8)) & 255);
                    }
                }
                return bArr3;
            }
            return bArr;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PCMConverter", 2, "convertChannelCount, srcData == null || srcData.length == 0");
        }
        return bArr;
    }

    public static short[] d(int i3, int i16, short[] sArr) {
        if (i3 == i16) {
            return sArr;
        }
        int round = Math.round((sArr.length / i3) * i16);
        float length = round / sArr.length;
        short[] sArr2 = new short[round];
        for (int i17 = 0; i17 < round; i17++) {
            int i18 = (int) (i17 / length);
            int i19 = i18 + 1;
            if (i19 >= sArr.length) {
                i19 = sArr.length - 1;
            }
            short s16 = sArr[i19];
            short s17 = sArr[i18];
            sArr2[i17] = (short) (((s16 - s17) * (r2 - i18)) + s17);
        }
        return sArr2;
    }

    public static byte[] e(byte[] bArr, int i3, int i16, int i17) {
        byte[] bArr2;
        int i18 = i3 / 8;
        int length = bArr.length / i18;
        short[] sArr = new short[length];
        int i19 = 0;
        int i26 = 0;
        for (int i27 = 0; i27 < length; i27++) {
            int i28 = 0;
            short s16 = 0;
            while (i28 < i18) {
                s16 = (short) (((short) ((bArr[i26] & 255) << (i28 * 8))) | s16);
                i28++;
                i26++;
            }
            sArr[i27] = s16;
        }
        short[] d16 = d(i16, i17, sArr);
        int length2 = d16.length;
        if (i18 == 1) {
            bArr2 = new byte[length2];
            while (i19 < length2) {
                bArr2[i19] = (byte) d16[i19];
                i19++;
            }
        } else {
            bArr2 = new byte[length2 * 2];
            while (i19 < d16.length) {
                int i29 = i19 * 2;
                short s17 = d16[i19];
                bArr2[i29] = (byte) (s17 & 255);
                bArr2[i29 + 1] = (byte) ((s17 >> 8) & 255);
                i19++;
            }
        }
        return bArr2;
    }
}
