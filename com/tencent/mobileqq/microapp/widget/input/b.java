package com.tencent.mobileqq.microapp.widget.input;

import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
final class b implements PageWebview.OnWebviewScrollListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PageWebview f246161a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, PageWebview pageWebview) {
        this.f246161a = pageWebview;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) pageWebview);
        }
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.PageWebview.OnWebviewScrollListener
    public void onVerticalScroll(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.f246161a.scrollY = i3;
        }
    }
}
