package com.tencent.mobileqq.microapp.appbrand;

import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class b implements a.InterfaceC8030a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f245943a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f245944b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str) {
        this.f245944b = aVar;
        this.f245943a = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.a.InterfaceC8030a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f245944b.f245902g.launch(this.f245943a, "reLaunch");
        }
    }
}
