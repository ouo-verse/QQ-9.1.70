package com.tencent.qimei.ai;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class g implements com.tencent.qimei.u.d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f343036a;

    public g(e eVar) {
        this.f343036a = eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
        }
    }

    @Override // com.tencent.qimei.u.d
    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        com.tencent.qimei.ad.c.b("SDK_INIT", "OD initialization finished (appKey: %s)\uff0cresult:%s", this.f343036a.f343025d, Integer.valueOf(i3));
        e eVar = this.f343036a;
        eVar.getClass();
        if (com.tencent.qimei.u.a.f()) {
            k.b(eVar.f343025d).a();
        }
        eVar.k();
    }
}
