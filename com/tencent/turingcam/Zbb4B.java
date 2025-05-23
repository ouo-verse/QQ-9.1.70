package com.tencent.turingcam;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Zbb4B {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr2 == null) {
            try {
                bArr2 = "DFG#$%^#%$RGHR(&*M<><".getBytes("UTF-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
                bArr2 = null;
            }
        }
        if (bArr2 == null || bArr2.length <= 16) {
            bArr3 = bArr2;
        } else {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                messageDigest.update(bArr2);
                bArr3 = messageDigest.digest();
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        if (bArr3 == null || bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length % 4 == 0 ? (bArr.length >>> 2) + 1 : (bArr.length >>> 2) + 2;
        int[] iArr = new int[length];
        a(bArr, iArr);
        int i3 = length - 1;
        iArr[i3] = bArr.length;
        int length2 = bArr3.length % 4 == 0 ? bArr3.length >>> 2 : (bArr3.length >>> 2) + 1;
        int i16 = length2 >= 4 ? length2 : 4;
        int[] iArr2 = new int[i16];
        int i17 = 0;
        for (int i18 = 0; i18 < i16; i18++) {
            iArr2[i18] = 0;
        }
        a(bArr3, iArr2);
        int i19 = iArr[i3];
        int i26 = iArr[0];
        int i27 = (52 / (i3 + 1)) + 6;
        int i28 = 0;
        while (true) {
            int i29 = i27 - 1;
            if (i27 <= 0) {
                break;
            }
            i28 -= 1640531527;
            int i36 = (i28 >>> 2) & 3;
            int i37 = 0;
            while (i37 < i3) {
                int i38 = i37 + 1;
                int i39 = iArr[i38];
                i19 = ((((i19 >>> 5) ^ (i39 << 2)) + ((i39 >>> 3) ^ (i19 << 4))) ^ ((i39 ^ i28) + (i19 ^ iArr2[(i37 & 3) ^ i36]))) + iArr[i37];
                iArr[i37] = i19;
                i37 = i38;
            }
            int i46 = iArr[0];
            i19 = ((((i19 >>> 5) ^ (i46 << 2)) + ((i46 >>> 3) ^ (i19 << 4))) ^ ((i46 ^ i28) + (i19 ^ iArr2[i36 ^ (i37 & 3)]))) + iArr[i3];
            iArr[i3] = i19;
            i27 = i29;
        }
        int i47 = length << 2;
        byte[] bArr4 = new byte[i47];
        int i48 = i47 >> 2;
        if (i48 > length) {
            i48 = length;
        }
        int i49 = 0;
        while (i17 < i48) {
            int i56 = i49 + 1;
            int i57 = iArr[i17];
            bArr4[i49] = (byte) (i57 & 255);
            int i58 = i56 + 1;
            bArr4[i56] = (byte) ((i57 >>> 8) & 255);
            int i59 = i58 + 1;
            bArr4[i58] = (byte) ((i57 >>> 16) & 255);
            i49 = i59 + 1;
            bArr4[i59] = (byte) ((i57 >>> 24) & 255);
            i17++;
        }
        if (length > i48 && i49 < i47) {
            bArr4[i49] = (byte) (iArr[i17] & 255);
            int i65 = 8;
            for (int i66 = i49 + 1; i65 <= 24 && i66 < i47; i66++) {
                bArr4[i66] = (byte) ((iArr[i17] >>> i65) & 255);
                i65 += 8;
            }
        }
        return bArr4;
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
}
