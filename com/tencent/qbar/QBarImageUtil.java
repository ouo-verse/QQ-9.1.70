package com.tencent.qbar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QBarImageUtil {
    static IPatchRedirector $redirector_;

    public QBarImageUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int ArrayConvert(int i3, byte[] bArr, int[] iArr) {
        if (bArr != null && iArr != null) {
            return QbarNative.nativeArrayConvert(i3, bArr.length, bArr, iArr);
        }
        return -1;
    }

    public static int CropGray2(byte[] bArr, byte[] bArr2, int i3, int i16, int i17) {
        if (bArr != null && bArr2 != null) {
            return QbarNative.nativeCropGray2(bArr, bArr2, i3, i16, i17);
        }
        return -1;
    }

    public static int TransBytes(int[] iArr, byte[] bArr, int i3, int i16) {
        if (iArr != null && bArr != null) {
            return QbarNative.nativeTransBytes(iArr, bArr, i3, i16);
        }
        return -1;
    }

    public static int TransPixels(int[] iArr, byte[] bArr, int i3, int i16) {
        if (iArr != null && bArr != null) {
            return QbarNative.nativeTransPixels(iArr, bArr, i3, i16);
        }
        return -1;
    }

    public static int YUVrotate(byte[] bArr, byte[] bArr2, int i3, int i16) {
        if (bArr != null && bArr2 != null) {
            return QbarNative.nativeYUVrotate(bArr, bArr2, i3, i16);
        }
        return -1;
    }

    public static int YUVrotateLessMemCost(byte[] bArr, int i3, int i16) {
        if (bArr == null) {
            return -1;
        }
        return QbarNative.nativeYUVrotateLess(bArr, i3, i16);
    }

    public static int YuvToCropIntArray(byte[] bArr, int[] iArr, int i3, int i16, int i17, int i18, int i19, int i26) {
        if (bArr != null && iArr != null) {
            return QbarNative.nativeYuvToCropIntArray(bArr, iArr, i3, i16, i17, i18, i19, i26);
        }
        return -1;
    }

    public static int gray_rotate_crop_sub(byte[] bArr, int[] iArr, byte[] bArr2, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        if (bArr != null && bArr2 != null) {
            return QbarNative.nativeGrayRotateCropSub(bArr2, i3, i16, i17, i18, i19, i26, bArr, iArr, i27, i28);
        }
        return -1;
    }

    public static int gray_rotate_sub(byte[] bArr, int[] iArr, byte[] bArr2, int i3, int i16, int i17, int i18) {
        if (bArr != null && bArr2 != null) {
            return QbarNative.nativeGrayRotateCropSub(bArr2, i3, i16, 0, 0, i3, i16, bArr, iArr, i17, i18);
        }
        return -1;
    }
}
