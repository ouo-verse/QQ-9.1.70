package com.tencent.mobileqq.microapp.webview;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class b implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f246039a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f246040b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f246041c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ BaseAppBrandWebview f246042d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BaseAppBrandWebview baseAppBrandWebview, String str, String str2, int i3) {
        this.f246042d = baseAppBrandWebview;
        this.f246039a = str;
        this.f246040b = str2;
        this.f246041c = i3;
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
        String str2 = "WeixinJSBridge.subscribeHandler(\"" + this.f246039a + "\"," + this.f246040b + ",0,\"" + this.f246041c + "\")";
        if (QLog.isColorLevel()) {
            str = BaseAppBrandWebview.TAG;
            QLog.d(str, 2, "evaluateSubcribeJSInService: " + str2);
        }
        this.f246042d.evaluateJavascript(str2, null);
    }
}
