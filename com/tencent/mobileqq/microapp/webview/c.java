package com.tencent.mobileqq.microapp.webview;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.smtt.sdk.ValueCallback;

/* compiled from: P */
/* loaded from: classes15.dex */
final class c implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f246043a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ValueCallback f246044b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ BaseAppBrandWebview f246045c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BaseAppBrandWebview baseAppBrandWebview, String str, ValueCallback valueCallback) {
        this.f246045c = baseAppBrandWebview;
        this.f246043a = str;
        this.f246044b = valueCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, baseAppBrandWebview, str, valueCallback);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f246045c.evaluateJavascript(this.f246043a, this.f246044b);
        }
    }
}
