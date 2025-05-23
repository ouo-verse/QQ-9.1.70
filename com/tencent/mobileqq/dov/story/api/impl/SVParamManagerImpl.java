package com.tencent.mobileqq.dov.story.api.impl;

import com.tencent.mobileqq.dov.story.api.ISVParamManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import gm2.e;

/* loaded from: classes10.dex */
public class SVParamManagerImpl implements ISVParamManager {
    static IPatchRedirector $redirector_;

    public SVParamManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.dov.story.api.ISVParamManager
    public int getBitRate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
        }
        return e.b().a(i3);
    }
}
