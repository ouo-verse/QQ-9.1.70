package com.tencent.maxvideo.activity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class CoverNative {
    static IPatchRedirector $redirector_;

    public CoverNative() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native void closeFile(long j3);

    public static native boolean getFrameYuv(long j3, String str, int i3, byte[] bArr, int i16, int i17);

    public static native int getVfFrameCount(long j3);

    public static native long openFile(String str);

    public static native int[] testTran();
}
