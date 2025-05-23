package com.tencent.mobileqq.microapp.appbrand.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.search.util.aw;

/* compiled from: P */
/* loaded from: classes15.dex */
final class a implements aw.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppBrandUI f246016a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppBrandUI appBrandUI) {
        this.f246016a = appBrandUI;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appBrandUI);
        }
    }

    @Override // com.tencent.mobileqq.search.util.aw.a
    public void onSoftKeyboardClosed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            com.tencent.mobileqq.microapp.app.b.a().a("hideInput");
        }
    }

    @Override // com.tencent.mobileqq.search.util.aw.a
    public void onSoftKeyboardOpened(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            com.tencent.mobileqq.microapp.app.b.a().a(Integer.valueOf((int) (i3 / this.f246016a.getResources().getDisplayMetrics().density)));
        }
    }
}
