package com.huawei.hms.support.log.common;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.text.EmotcationConstants;
import cooperation.qzone.QZoneHelper;
import org.apache.commons.fileupload.MultipartStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Base64 {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f37631a = {EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/', '='};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f37632b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, MultipartStream.DASH, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    Base64() {
    }

    private static int a(String str) {
        int length = str.length();
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt > '\u00ff' || f37632b[charAt] < 0) {
                length--;
            }
        }
        return length;
    }

    public static byte[] decode(String str) {
        byte b16;
        int a16 = a(str);
        int i3 = (a16 / 4) * 3;
        int i16 = a16 % 4;
        if (i16 == 3) {
            i3 += 2;
        }
        if (i16 == 2) {
            i3++;
        }
        byte[] bArr = new byte[i3];
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        for (int i26 = 0; i26 < str.length(); i26++) {
            char charAt = str.charAt(i26);
            if (charAt > '\u00ff') {
                b16 = -1;
            } else {
                b16 = f37632b[charAt];
            }
            if (b16 >= 0) {
                i19 += 6;
                i18 = (i18 << 6) | b16;
                if (i19 >= 8) {
                    i19 -= 8;
                    bArr[i17] = (byte) (255 & (i18 >> i19));
                    i17++;
                }
            }
        }
        if (i17 != i3) {
            return new byte[0];
        }
        return bArr;
    }

    public static String encode(byte[] bArr) {
        return encode(bArr, bArr.length);
    }

    public static String encode(byte[] bArr, int i3) {
        boolean z16;
        char[] cArr = new char[((i3 + 2) / 3) * 4];
        int i16 = 0;
        int i17 = 0;
        while (i16 < i3) {
            int i18 = (bArr[i16] & 255) << 8;
            int i19 = i16 + 1;
            boolean z17 = true;
            if (i19 < i3) {
                i18 |= bArr[i19] & 255;
                z16 = true;
            } else {
                z16 = false;
            }
            int i26 = i18 << 8;
            int i27 = i16 + 2;
            if (i27 < i3) {
                i26 |= bArr[i27] & 255;
            } else {
                z17 = false;
            }
            int i28 = i17 + 3;
            char[] cArr2 = f37631a;
            int i29 = 64;
            cArr[i28] = cArr2[z17 ? i26 & 63 : 64];
            int i36 = i26 >> 6;
            int i37 = i17 + 2;
            if (z16) {
                i29 = i36 & 63;
            }
            cArr[i37] = cArr2[i29];
            int i38 = i36 >> 6;
            cArr[i17 + 1] = cArr2[i38 & 63];
            cArr[i17 + 0] = cArr2[(i38 >> 6) & 63];
            i16 += 3;
            i17 += 4;
        }
        return new String(cArr);
    }
}
