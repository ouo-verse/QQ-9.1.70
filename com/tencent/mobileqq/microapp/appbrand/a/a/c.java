package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
final class c implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseAppBrandWebview f245911a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f245912b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f245913c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ b f245914d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, BaseAppBrandWebview baseAppBrandWebview, String str, int i3) {
        this.f245914d = bVar;
        this.f245911a = baseAppBrandWebview;
        this.f245912b = str;
        this.f245913c = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, baseAppBrandWebview, str, Integer.valueOf(i3));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            com.tencent.mobileqq.microapp.widget.input.a.a().a(this.f245914d.f245908a, this.f245911a, this.f245912b, this.f245913c);
        }
    }
}
