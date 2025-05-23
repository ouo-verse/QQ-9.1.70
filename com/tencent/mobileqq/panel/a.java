package com.tencent.mobileqq.panel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a implements yc2.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private a61.c f257159a;

    public a(a61.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
        } else {
            this.f257159a = cVar;
        }
    }
}
