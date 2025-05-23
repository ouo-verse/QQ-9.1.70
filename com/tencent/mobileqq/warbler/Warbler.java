package com.tencent.mobileqq.warbler;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class Warbler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f313224a;

    public Warbler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void a() {
        if (f313224a) {
            return;
        }
        System.loadLibrary("warbler");
        f313224a = true;
    }

    public static boolean b() {
        a();
        return nativeMakeArtDebuggable();
    }

    private static native boolean nativeMakeArtDebuggable();
}
