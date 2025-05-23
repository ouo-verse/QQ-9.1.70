package com.tencent.mobileqq.pic;

import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
final class JpegError {
    static IPatchRedirector $redirector_ = null;
    public static final int EBITMAP_NATIVE_ERR = 1;
    public static final int EFILEOPEN = 6;
    public static final int EINVALIDPARAM = 4;
    public static final int EJPEGINNER = 7;
    public static final int ENOTSUPPORT = 3;
    public static final int EOK = 0;
    public static final int ESIZEERR = 51;
    public static final int ESOLINKERR = 52;
    public static final int ESOLOADERR = 50;
    public static final int ESTATUS_ERR = 2;
    public static final int EUNKNOWNCOLORSPACE = 5;
    private static final SparseArray<String> map;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14905);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SparseArray<String> sparseArray = new SparseArray<>(5);
        map = sparseArray;
        sparseArray.put(1, "EBITMAP_NATIVE_ERR");
        sparseArray.put(2, "ESTATUS_ERR:Close has been called,when you compress Bitmap.");
        sparseArray.put(3, "ENOTSUPPORT");
        sparseArray.put(4, "EINVALIDPARAM:Invalid Parameters.");
        sparseArray.put(5, "EUNKNOWNCOLORSPACE:unknown color space.");
        sparseArray.put(6, "EFILEOPEN:Open file failed.");
        sparseArray.put(7, "EJPEGINNER:JPEG library inner error.");
        sparseArray.put(50, "ESOLOADERR:So load error.");
        sparseArray.put(51, "ESIZEERR:Size error.");
        sparseArray.put(52, "ESOLINKERR:So Link error.");
    }

    JpegError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void throwException(int i3) {
        int i16 = i3 >>> 16;
        int i17 = i3 & 65535;
        throw new RuntimeException("JpegError: errcode=" + i17 + " Subcode=" + i16 + " Msg=" + map.get(i17));
    }
}
