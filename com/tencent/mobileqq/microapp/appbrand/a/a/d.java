package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
final class d implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseAppBrandWebview f245915a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f245916b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f245917c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ b f245918d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, BaseAppBrandWebview baseAppBrandWebview, String str, int i3) {
        this.f245918d = bVar;
        this.f245915a = baseAppBrandWebview;
        this.f245916b = str;
        this.f245917c = i3;
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
            com.tencent.mobileqq.microapp.widget.input.a.a().b(this.f245918d.f245908a, this.f245915a, this.f245916b, this.f245917c);
        }
    }
}
