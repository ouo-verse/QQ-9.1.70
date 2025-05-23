package com.tencent.mobileqq.leba.impl;

import com.tencent.mobileqq.leba.ILebaHandler;
import com.tencent.mobileqq.leba.core.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LebaHandlerImpl implements ILebaHandler {
    static IPatchRedirector $redirector_;

    public LebaHandlerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.leba.ILebaHandler
    public String getCommPluginHandlerClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.mobileqq.leba.core.a.f240363a;
    }

    @Override // com.tencent.mobileqq.leba.ILebaHandler
    public String getLebaSettingHandlerClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return d.f240371a;
    }
}
