package com.tencent.mobileqq.microapp.appbrand.ui;

import com.tencent.mobileqq.microapp.app.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
final class d extends b.C8029b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppBrandUI f246022a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AppBrandUI appBrandUI) {
        this.f246022a = appBrandUI;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appBrandUI);
        }
    }

    @Override // com.tencent.mobileqq.microapp.app.b.C8029b
    public void a(b.c cVar) {
        com.tencent.mobileqq.microapp.appbrand.a a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
        } else {
            if (cVar == null || (a16 = this.f246022a.f246008a.a(cVar.f245891a, cVar.f245892b)) == null) {
                return;
            }
            a16.a(cVar.f245893c, cVar.f245894d, cVar.f245895e);
        }
    }

    @Override // com.tencent.mobileqq.microapp.app.b.C8029b
    public void a(b.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            super.a(aVar);
            this.f246022a.runOnUiThread(new e(this, aVar));
        }
    }
}
