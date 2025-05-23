package com.tencent.turingcam;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VBlVU {
    public static byte[] a() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            String a16 = LwgsO.a(LwgsO.D0);
            int[] iArr = {-36, -46, -45, -77, -22, -10, 47, -77, -72, -69, -32, 25, 21, -21, -6, -75, -71, 31, -39, -49, -49};
            for (int i3 = 0; i3 < a16.length(); i3++) {
                stringBuffer.append((char) (a16.charAt(i3) + iArr[i3]));
            }
            return stringBuffer.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        int length;
        int length2;
        byte[] a16 = a(bArr2);
        if (bArr != null && a16 != null && bArr.length != 0) {
            int i3 = 4;
            if (bArr.length % 4 == 0) {
                length = (bArr.length >>> 2) + 1;
            } else {
                length = (bArr.length >>> 2) + 2;
            }
            int[] iArr = new int[length];
            a(bArr, iArr);
            int i16 = length - 1;
            iArr[i16] = bArr.length;
            if (a16.length % 4 == 0) {
                length2 = a16.length >>> 2;
            } else {
                length2 = (a16.length >>> 2) + 1;
            }
            if (length2 >= 4) {
                i3 = length2;
            }
            int[] iArr2 = new int[i3];
            for (int i17 = 0; i17 < i3; i17++) {
                iArr2[i17] = 0;
            }
            a(a16, iArr2);
            int i18 = iArr[i16];
            int i19 = iArr[0];
            int i26 = (52 / (i16 + 1)) + 6;
            int i27 = 0;
            while (true) {
                int i28 = i26 - 1;
                if (i26 > 0) {
                    i27 -= 1640531527;
                    int i29 = (i27 >>> 2) & 3;
                    int i36 = 0;
                    while (i36 < i16) {
                        int i37 = i36 + 1;
                        int i38 = iArr[i37];
                        i18 = ((((i18 >>> 5) ^ (i38 << 2)) + ((i38 >>> 3) ^ (i18 << 4))) ^ ((i38 ^ i27) + (i18 ^ iArr2[(i36 & 3) ^ i29]))) + iArr[i36];
                        iArr[i36] = i18;
                        i36 = i37;
                    }
                    int i39 = iArr[0];
                    i18 = ((((i18 >>> 5) ^ (i39 << 2)) + ((i39 >>> 3) ^ (i18 << 4))) ^ ((i39 ^ i27) + (i18 ^ iArr2[i29 ^ (i36 & 3)]))) + iArr[i16];
                    iArr[i16] = i18;
                    i26 = i28;
                } else {
                    byte[] bArr3 = new byte[length << 2];
                    a(iArr, length, bArr3);
                    return bArr3;
                }
            }
        } else {
            return bArr;
        }
    }

    public static void a(byte[] bArr, int[] iArr) {
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

    public static void a(int[] iArr, int i3, byte[] bArr) {
        int length = bArr.length >> 2;
        if (length > i3) {
            length = i3;
        }
        int i16 = 0;
        int i17 = 0;
        while (i16 < length) {
            int i18 = i17 + 1;
            int i19 = iArr[i16];
            bArr[i17] = (byte) (i19 & 255);
            int i26 = i18 + 1;
            bArr[i18] = (byte) ((i19 >>> 8) & 255);
            int i27 = i26 + 1;
            bArr[i26] = (byte) ((i19 >>> 16) & 255);
            i17 = i27 + 1;
            bArr[i27] = (byte) ((i19 >>> 24) & 255);
            i16++;
        }
        if (i3 <= length || i17 >= bArr.length) {
            return;
        }
        bArr[i17] = (byte) (iArr[i16] & 255);
        int i28 = 8;
        for (int i29 = i17 + 1; i28 <= 24 && i29 < bArr.length; i29++) {
            bArr[i29] = (byte) ((iArr[i16] >>> i28) & 255);
            i28 += 8;
        }
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length <= 16) {
            return bArr;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] a16 = a(bArr2);
        if (bArr == null || a16 == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr.length % 4 == 0 && bArr.length >= 8) {
            int length = bArr.length >>> 2;
            int[] iArr = new int[length];
            a(bArr, iArr);
            int length2 = a16.length % 4 == 0 ? a16.length >>> 2 : (a16.length >>> 2) + 1;
            int i3 = length2 >= 4 ? length2 : 4;
            int[] iArr2 = new int[i3];
            for (int i16 = 0; i16 < i3; i16++) {
                iArr2[i16] = 0;
            }
            a(a16, iArr2);
            int i17 = length - 1;
            int i18 = iArr[i17];
            int i19 = iArr[0];
            for (int i26 = ((52 / (i17 + 1)) + 6) * (-1640531527); i26 != 0; i26 -= -1640531527) {
                int i27 = (i26 >>> 2) & 3;
                int i28 = i17;
                while (i28 > 0) {
                    int i29 = iArr[i28 - 1];
                    i19 = iArr[i28] - (((i19 ^ i26) + (i29 ^ iArr2[(i28 & 3) ^ i27])) ^ (((i29 >>> 5) ^ (i19 << 2)) + ((i19 >>> 3) ^ (i29 << 4))));
                    iArr[i28] = i19;
                    i28--;
                }
                int i36 = iArr[i17];
                i19 = iArr[0] - (((i19 ^ i26) + (iArr2[i27 ^ (i28 & 3)] ^ i36)) ^ (((i36 >>> 5) ^ (i19 << 2)) + ((i19 >>> 3) ^ (i36 << 4))));
                iArr[0] = i19;
            }
            int i37 = iArr[i17];
            if (i37 >= 0 && i37 <= (i17 << 2)) {
                byte[] bArr3 = new byte[i37];
                a(iArr, i17, bArr3);
                return bArr3;
            }
        }
        return null;
    }
}
