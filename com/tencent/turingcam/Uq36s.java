package com.tencent.turingcam;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Uq36s {
    private static void a(byte[] bArr, int[] iArr) {
        int length = bArr.length >> 2;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            int i17 = i16 + 1;
            int i18 = bArr[i16] & 255;
            iArr[i3] = i18;
            int i19 = i17 + 1;
            int i26 = i18 | ((bArr[i17] & 255) << 8);
            iArr[i3] = i26;
            int i27 = i19 + 1;
            int i28 = i26 | ((bArr[i19] & 255) << 16);
            iArr[i3] = i28;
            iArr[i3] = i28 | ((bArr[i27] & 255) << 24);
            i3++;
            i16 = i27 + 1;
        }
        if (i16 < bArr.length) {
            int i29 = i16 + 1;
            iArr[i3] = bArr[i16] & 255;
            int i36 = 8;
            while (i29 < bArr.length) {
                iArr[i3] = iArr[i3] | ((bArr[i29] & 255) << i36);
                i29++;
                i36 += 8;
            }
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr2.length > 16) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                messageDigest.update(bArr2);
                bArr2 = messageDigest.digest();
            } catch (NoSuchAlgorithmException unused) {
                bArr2 = null;
            }
        }
        if (bArr == null || bArr2 == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr.length % 4 == 0) {
            int i3 = 8;
            if (bArr.length >= 8) {
                int length = bArr.length >>> 2;
                int[] iArr = new int[length];
                a(bArr, iArr);
                int length2 = bArr2.length % 4 == 0 ? bArr2.length >>> 2 : (bArr2.length >>> 2) + 1;
                int i16 = length2 >= 4 ? length2 : 4;
                int[] iArr2 = new int[i16];
                int i17 = 0;
                for (int i18 = 0; i18 < i16; i18++) {
                    iArr2[i18] = 0;
                }
                a(bArr2, iArr2);
                int i19 = length - 1;
                int i26 = iArr[i19];
                int i27 = iArr[0];
                for (int i28 = ((52 / (i19 + 1)) + 6) * (-1640531527); i28 != 0; i28 -= -1640531527) {
                    int i29 = (i28 >>> 2) & 3;
                    int i36 = i19;
                    while (i36 > 0) {
                        int i37 = iArr[i36 - 1];
                        i27 = iArr[i36] - (((i27 ^ i28) + (i37 ^ iArr2[(i36 & 3) ^ i29])) ^ (((i37 >>> 5) ^ (i27 << 2)) + ((i27 >>> 3) ^ (i37 << 4))));
                        iArr[i36] = i27;
                        i36--;
                    }
                    int i38 = iArr[i19];
                    i27 = iArr[0] - (((i27 ^ i28) + (iArr2[i29 ^ (i36 & 3)] ^ i38)) ^ (((i38 >>> 5) ^ (i27 << 2)) + ((i27 >>> 3) ^ (i38 << 4))));
                    iArr[0] = i27;
                }
                int i39 = iArr[i19];
                if (i39 >= 0 && i39 <= (i19 << 2)) {
                    byte[] bArr3 = new byte[i39];
                    int i46 = i39 >> 2;
                    if (i46 > i19) {
                        i46 = i19;
                    }
                    int i47 = 0;
                    while (i17 < i46) {
                        int i48 = i47 + 1;
                        int i49 = iArr[i17];
                        bArr3[i47] = (byte) (i49 & 255);
                        int i56 = i48 + 1;
                        bArr3[i48] = (byte) ((i49 >>> 8) & 255);
                        int i57 = i56 + 1;
                        bArr3[i56] = (byte) ((i49 >>> 16) & 255);
                        i47 = i57 + 1;
                        bArr3[i57] = (byte) ((i49 >>> 24) & 255);
                        i17++;
                    }
                    if (i19 > i46 && i47 < i39) {
                        bArr3[i47] = (byte) (iArr[i17] & 255);
                        for (int i58 = i47 + 1; i3 <= 24 && i58 < i39; i58++) {
                            bArr3[i58] = (byte) ((iArr[i17] >>> i3) & 255);
                            i3 += 8;
                        }
                    }
                    return bArr3;
                }
            }
        }
        return null;
    }
}
