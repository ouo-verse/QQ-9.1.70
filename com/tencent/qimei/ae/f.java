package com.tencent.qimei.ae;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f implements com.tencent.qimei.u.d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.tencent.qimei.u.d f342952a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f342953b;

    public f(a aVar, com.tencent.qimei.u.d dVar) {
        this.f342953b = aVar;
        this.f342952a = dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) dVar);
        }
    }

    @Override // com.tencent.qimei.u.d
    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        if (this.f342952a != null) {
            synchronized (this.f342953b.f342946b) {
                if (!this.f342953b.f342947c) {
                    this.f342952a.a(i3);
                    this.f342953b.f342947c = true;
                }
            }
        }
    }
}
