package com.tencent.mobileqq.qrscan.api.impl;

import com.tencent.mobileqq.imgproc.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qrscan.api.IImgProcessApi;

/* loaded from: classes17.dex */
public class ImgProcessApiImpl implements IImgProcessApi {
    static IPatchRedirector $redirector_;

    public ImgProcessApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IImgProcessApi
    public int ArrayConvert(int i3, byte[] bArr, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), bArr, iArr)).intValue();
        }
        return a.a(i3, bArr, iArr);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IImgProcessApi
    public int CropGray2(byte[] bArr, byte[] bArr2, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, bArr, bArr2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).intValue();
        }
        return a.b(bArr, bArr2, i3, i16, i17);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IImgProcessApi
    public int TransBytes(int[] iArr, byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, iArr, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return a.c(iArr, bArr, i3, i16);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IImgProcessApi
    public int TransPixels(int[] iArr, byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, iArr, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return a.d(iArr, bArr, i3, i16);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IImgProcessApi
    public int YUVrotate(byte[] bArr, byte[] bArr2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, bArr, bArr2, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return a.e(bArr, bArr2, i3, i16);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IImgProcessApi
    public int YUVrotateLessMemCost(byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return a.f(bArr, i3, i16);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IImgProcessApi
    public int YuvToCropIntArray(byte[] bArr, int[] iArr, int i3, int i16, int i17, int i18, int i19, int i26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, bArr, iArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26))).intValue();
        }
        return a.g(bArr, iArr, i3, i16, i17, i18, i19, i26);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IImgProcessApi
    public int gray_rotate_crop_sub(byte[] bArr, int[] iArr, byte[] bArr2, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, bArr, iArr, bArr2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28))).intValue();
        }
        return a.h(bArr, iArr, bArr2, i3, i16, i17, i18, i19, i26, i27, i28);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IImgProcessApi
    public int gray_rotate_sub(byte[] bArr, int[] iArr, byte[] bArr2, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, bArr, iArr, bArr2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18))).intValue();
        }
        return a.i(bArr, iArr, bArr2, i3, i16, i17, i18);
    }
}
