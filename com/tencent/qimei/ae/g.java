package com.tencent.qimei.ae;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class g implements m {
    static IPatchRedirector $redirector_;

    public g(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.qimei.ae.m
    public String a() {
        com.tencent.qimei.u.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        synchronized (com.tencent.qimei.u.c.class) {
            cVar = com.tencent.qimei.u.c.f343390p;
        }
        cVar.getClass();
        return "";
    }
}
