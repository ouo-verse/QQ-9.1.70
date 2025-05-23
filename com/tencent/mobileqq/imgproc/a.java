package com.tencent.mobileqq.imgproc;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qbar.QBarImageUtil;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static int a(int i3, byte[] bArr, int[] iArr) {
        return QBarImageUtil.ArrayConvert(i3, bArr, iArr);
    }

    public static int b(byte[] bArr, byte[] bArr2, int i3, int i16, int i17) {
        return QBarImageUtil.CropGray2(bArr, bArr2, i3, i16, i17);
    }

    public static int c(int[] iArr, byte[] bArr, int i3, int i16) {
        return QBarImageUtil.TransBytes(iArr, bArr, i3, i16);
    }

    public static int d(int[] iArr, byte[] bArr, int i3, int i16) {
        return QBarImageUtil.TransPixels(iArr, bArr, i3, i16);
    }

    public static int e(byte[] bArr, byte[] bArr2, int i3, int i16) {
        return QBarImageUtil.YUVrotate(bArr, bArr2, i3, i16);
    }

    public static int f(byte[] bArr, int i3, int i16) {
        return QBarImageUtil.YUVrotateLessMemCost(bArr, i3, i16);
    }

    public static int g(byte[] bArr, int[] iArr, int i3, int i16, int i17, int i18, int i19, int i26) {
        return QBarImageUtil.YuvToCropIntArray(bArr, iArr, i3, i16, i17, i18, i19, i26);
    }

    public static int h(byte[] bArr, int[] iArr, byte[] bArr2, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        return QBarImageUtil.gray_rotate_crop_sub(bArr, iArr, bArr2, i3, i16, i17, i18, i19, i26, i27, i28);
    }

    public static int i(byte[] bArr, int[] iArr, byte[] bArr2, int i3, int i16, int i17, int i18) {
        return QBarImageUtil.gray_rotate_sub(bArr, iArr, bArr2, i3, i16, i17, i18);
    }
}
