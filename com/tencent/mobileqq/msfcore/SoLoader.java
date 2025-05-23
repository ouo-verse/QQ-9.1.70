package com.tencent.mobileqq.msfcore;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class SoLoader {
    static IPatchRedirector $redirector_;
    private static ISoLoader loader;

    public SoLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean load(String str) {
        ISoLoader iSoLoader = loader;
        if (iSoLoader != null) {
            return iSoLoader.load(str);
        }
        System.loadLibrary(str);
        return true;
    }

    public static void reportLoadSoError(String str, boolean z16, String str2) {
        ISoLoader iSoLoader = loader;
        if (iSoLoader == null) {
            return;
        }
        iSoLoader.reportLoadSoError(str, z16, str2);
    }

    public static void setLoader(ISoLoader iSoLoader) {
        loader = iSoLoader;
    }
}
