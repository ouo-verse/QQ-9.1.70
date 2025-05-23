package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.soload.api.ISoLoaderCrashService;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SoLoaderCrashServiceImpl implements ISoLoaderCrashService {
    static IPatchRedirector $redirector_;

    public SoLoaderCrashServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderCrashService
    public void handleCrash(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            com.tencent.mobileqq.soload.util.d.c(str, str2);
        }
    }
}
