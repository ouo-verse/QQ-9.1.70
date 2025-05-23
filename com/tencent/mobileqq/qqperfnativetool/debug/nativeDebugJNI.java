package com.tencent.mobileqq.qqperfnativetool.debug;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class nativeDebugJNI {
    static IPatchRedirector $redirector_;

    public nativeDebugJNI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native void throwNativeNullPointExp();
}
