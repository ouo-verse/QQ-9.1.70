package com.tencent.mobileqq.pluginsdk.exception;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class PackageInfoGetExcetpion extends Exception {
    static IPatchRedirector $redirector_;

    public PackageInfoGetExcetpion(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }
}
