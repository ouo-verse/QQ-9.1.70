package com.tencent.mobileqq.hitrate.api.impl;

import com.tencent.mobileqq.hitrate.a;
import com.tencent.mobileqq.hitrate.api.IPreloadProcHitMgrApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes9.dex */
public class PreloadProcHitMgrApiImpl implements IPreloadProcHitMgrApi {
    static IPatchRedirector $redirector_;

    public PreloadProcHitMgrApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.hitrate.api.IPreloadProcHitMgrApi
    public void exitProcess(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            a.c(str);
        }
    }
}
