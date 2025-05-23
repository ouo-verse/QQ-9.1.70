package com.tencent.qimei.ae;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.uin.U;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c implements m {
    static IPatchRedirector $redirector_;

    public c(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.qimei.ae.m
    public String a() {
        com.tencent.qimei.u.c cVar;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        synchronized (com.tencent.qimei.u.c.class) {
            cVar = com.tencent.qimei.u.c.f343390p;
        }
        synchronized (cVar) {
            if (cVar.f343403m == null) {
                cVar.f343403m = U.d();
            }
            str = cVar.f343403m;
        }
        return str;
    }
}
