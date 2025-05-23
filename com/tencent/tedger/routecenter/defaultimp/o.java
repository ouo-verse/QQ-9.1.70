package com.tencent.tedger.routecenter.defaultimp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class o extends c<Object> implements ue4.a {
    static IPatchRedirector $redirector_;

    public o(com.tencent.tedger.routecenter.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }
}
