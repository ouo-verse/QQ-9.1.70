package com.tencent.mobileqq.microapp.webview;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class a implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f246035a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f246036b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f246037c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ BaseAppBrandWebview f246038d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaseAppBrandWebview baseAppBrandWebview, String str, String str2, int i3) {
        this.f246038d = baseAppBrandWebview;
        this.f246035a = str;
        this.f246036b = str2;
        this.f246037c = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, baseAppBrandWebview, str, str2, Integer.valueOf(i3));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String str2 = "WeixinJSBridge.subscribeHandler(\"" + this.f246035a + "\"," + this.f246036b + "," + this.f246037c + ",0)";
        if (QLog.isColorLevel()) {
            str = BaseAppBrandWebview.TAG;
            QLog.d(str, 2, "evaluateSubcribeJS: " + str2);
        }
        this.f246038d.evaluateJavascript(str2, null);
    }
}
