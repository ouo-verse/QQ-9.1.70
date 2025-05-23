package com.tencent.qimei.codez.jni;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class X {
    static IPatchRedirector $redirector_;

    public X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static native boolean i(Context context, String[] strArr, String str, int i3);

    private static native int r(String str, int i3);

    private static native void v();
}
