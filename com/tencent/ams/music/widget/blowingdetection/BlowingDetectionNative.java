package com.tencent.ams.music.widget.blowingdetection;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BlowingDetectionNative {
    static IPatchRedirector $redirector_;

    public BlowingDetectionNative() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native int blowingDetection(long j3, byte[] bArr, int i3);

    public static native long init(float f16, float f17, int i3);

    public static native void release(long j3);
}
