package com.tencent.mobileqq.webview.swift;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProSourceInfoBid;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes20.dex */
public class JsBridgeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    WeakReference<WebView> f314006a;

    /* renamed from: b, reason: collision with root package name */
    public long f314007b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f314008c;

    public JsBridgeListener(WebView webView, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, webView, Long.valueOf(j3), str);
            return;
        }
        this.f314008c = false;
        this.f314006a = new WeakReference<>(webView);
        this.f314007b = j3;
    }

    public static String a(int i3, Object obj, String str) {
        String obj2;
        if (i3 != 0) {
            return String.format("{'r':%d,'result':'%s'}", Integer.valueOf(i3), str);
        }
        if (obj == null) {
            return String.format("{'r':%d,'result':'%s'}", Integer.valueOf(i3), str);
        }
        if (!(obj instanceof Number) && !(obj instanceof Boolean)) {
            obj2 = "'" + obj.toString().replace("\\", "\\\\").replace("'", "\\'") + "'";
        } else {
            obj2 = obj.toString();
        }
        return String.format("{'r':0,'result':%s}", obj2);
    }

    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.f314007b;
    }

    @Deprecated
    public void c(Object obj) {
        WebView webView;
        String obj2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj);
            return;
        }
        if (this.f314007b == -1 || (webView = this.f314006a.get()) == null) {
            return;
        }
        if (obj == null) {
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f314007b + ",{'r':0});");
            return;
        }
        if (!(obj instanceof Number) && !(obj instanceof Boolean)) {
            obj2 = "'" + obj.toString().replace("\\", "\\\\").replace("'", "\\'") + "'";
        } else {
            obj2 = obj.toString();
        }
        webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f314007b + ",{'r':0,'result':" + obj2 + "});");
    }

    public void d(JSONObject jSONObject) {
        WebView webView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) jSONObject);
            return;
        }
        if (this.f314007b == -1 || (webView = this.f314006a.get()) == null) {
            return;
        }
        if (jSONObject == null) {
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f314007b + ",{'r':0});");
            return;
        }
        webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f314007b + ",{'r':0,'result':" + jSONObject.toString() + "});");
    }

    public void e(String str) {
        WebView webView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(GGProSourceInfoBid.JB, 4, "onNoMatchMethod");
        }
        if (this.f314007b == -1 || (webView = this.f314006a.get()) == null) {
            return;
        }
        webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f314007b + ",{'r':1,'result':'" + str + "'})");
    }

    public void f() {
        WebView webView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(GGProSourceInfoBid.JB, 4, "onPermissionDenied");
        }
        if (this.f314007b != -1 && (webView = this.f314006a.get()) != null) {
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f314007b + ",{'r':2,'result':'Permission denied'})");
        }
    }

    public JsBridgeListener(WebView webView, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, webView, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        this.f314008c = false;
        this.f314006a = new WeakReference<>(webView);
        this.f314007b = j3;
        this.f314008c = z16;
    }
}
