package com.tencent.mobileqq.minicode;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes15.dex */
public class DecodeProxy {
    static IPatchRedirector $redirector_;

    public DecodeProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native boolean checkQRExist(byte[] bArr, int i3, int i16, int i17);

    public static native String getVersion();

    public static native String nativeDecode(byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26, int i27);

    public static native String nativeWxDecode(byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26, int i27);

    public static native void setLogSwitch(boolean z16);
}
