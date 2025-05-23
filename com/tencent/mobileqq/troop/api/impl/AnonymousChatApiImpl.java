package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.IAnonymousChatApi;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AnonymousChatApiImpl implements IAnonymousChatApi {
    static IPatchRedirector $redirector_;

    public AnonymousChatApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IAnonymousChatApi
    public boolean getAioAnonymousStatus(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        return com.tencent.biz.anonymous.a.h().d(str);
    }
}
