package com.tencent.mobileqq.minicode;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes15.dex */
public class RecogProxy {
    static IPatchRedirector $redirector_;

    public RecogProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native void QCodeDestroy(long j3);

    public static native long QCodeInit(int i3, int i16, int i17, String str, String str2, String str3, String str4, float f16);

    public static native String QCodeProcess(long j3, int i3, int i16);

    public static native int getBox(long j3, int i3, float[] fArr);

    public static native int getBoxCnt(long j3);

    public static native int getBoxType(long j3, int i3);
}
