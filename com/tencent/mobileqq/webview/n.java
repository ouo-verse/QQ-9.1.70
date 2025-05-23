package com.tencent.mobileqq.webview;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class n {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static n f313999b;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, WebViewTitleStyle> f314000a;

    n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        try {
            this.f314000a = new HashMap();
            if (((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).i()) {
                WebViewTitleStyle webViewTitleStyle = new WebViewTitleStyle();
                webViewTitleStyle.f313797d = -16777216;
                webViewTitleStyle.f313798e = -1;
                webViewTitleStyle.f313799f = -16777216;
                webViewTitleStyle.f313800h = -16777216;
                this.f314000a.put("m.vip.qq.com", webViewTitleStyle);
                this.f314000a.put("youxi.vip.qq.com", webViewTitleStyle);
                this.f314000a.put("haoma.qq.com", webViewTitleStyle);
                this.f314000a.put("h5.vip.qq.com", webViewTitleStyle);
            }
        } catch (Exception e16) {
            QLog.e("WebViewTitleStyleHelper", 1, "WebViewTitleStyleHelper exception", e16);
        }
    }

    public static n a() {
        if (f313999b == null) {
            synchronized (n.class) {
                if (f313999b == null) {
                    f313999b = new n();
                }
            }
        }
        return f313999b;
    }
}
