package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
final class e implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f245919a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseAppBrandWebview f245920b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f245921c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f245922d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ b f245923e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, String str, BaseAppBrandWebview baseAppBrandWebview, String str2, int i3) {
        this.f245923e = bVar;
        this.f245919a = str;
        this.f245920b = baseAppBrandWebview;
        this.f245921c = str2;
        this.f245922d = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, str, baseAppBrandWebview, str2, Integer.valueOf(i3));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (com.tencent.mobileqq.microapp.widget.input.a.a().a(this.f245923e.f245908a, this.f245919a)) {
            this.f245923e.f245908a.a(this.f245920b, this.f245921c, (JSONObject) null, this.f245922d);
        } else {
            this.f245923e.f245908a.b(this.f245920b, this.f245921c, (JSONObject) null, this.f245922d);
        }
    }
}
