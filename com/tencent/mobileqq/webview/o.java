package com.tencent.mobileqq.webview;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class o implements com.tencent.mobileqq.webview.swift.j {
    static IPatchRedirector $redirector_;

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, String str2, String str3, String str4) {
        try {
            com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
            A.p();
            Bundle r16 = SwiftBrowserStatistics.r(str2);
            r16.putString("uin", str4);
            if (!TextUtils.isEmpty(str3)) {
                r16.putString("title", str3);
            }
            A.o0(2, str2, str, r16);
        } catch (Throwable th5) {
            QLog.e("WebViewWrapperInjector", 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.j
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (!str.startsWith(IPublicAccountH5AbilityPlugin.LOCALID_HEAD) && !((IGdtAPI) QRoute.api(IGdtAPI.class)).isClickCgiUrlForTool(str)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.j
    public void b(Bundle bundle, WebView webView, String str) {
        StringBuilder sb5;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bundle, webView, str);
            return;
        }
        try {
            ArrayList arrayList = (ArrayList) bundle.get("recognised-text");
            boolean z16 = bundle.getBoolean("virtual-keyboard", false);
            String string = bundle.getString("normal-input-value-change");
            boolean z17 = bundle.getBoolean("password-start-input", false);
            boolean z18 = bundle.getBoolean("password-input-show", false);
            StringBuilder sb6 = new StringBuilder(128);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sb6.append((String) it.next());
                    sb6.append(",");
                }
            }
            String str4 = "";
            if (webView != null) {
                String originalUrl = webView.getOriginalUrl();
                String url = webView.getUrl();
                sb5 = sb6;
                SwiftBrowserStatistics.k0(originalUrl, url, sb6.toString(), string, z17, z18, z16);
                str2 = originalUrl;
                str3 = url;
            } else {
                sb5 = sb6;
                str2 = "";
                str3 = str2;
            }
            if ((arrayList != null && arrayList.size() > 0) || z16 || !TextUtils.isEmpty(string)) {
                if (webView != null) {
                    str4 = webView.getTitle();
                }
                d(str2, str3, str4, str);
            }
            sb5.append(" hasVirtualKB:");
            sb5.append(z16);
            sb5.append(" inputText:");
            sb5.append(string);
            sb5.append(" passwdTyped:");
            sb5.append(z17);
            sb5.append(" showPasswdInput:");
            sb5.append(z18);
            if (QLog.isColorLevel()) {
                QLog.d("WebViewWrapperInjector", 2, "onFakeLoginRecognised ", sb5.toString());
            }
        } catch (Throwable th5) {
            QLog.e("WebViewWrapperInjector", 2, "onFakeLoginRecognised ", th5);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.j
    public WebResourceResponse c(WebView webView, String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (WebResourceResponse) iPatchRedirector.redirect((short) 3, this, webView, str, str2, Boolean.valueOf(z16));
        }
        if (str.startsWith(IPublicAccountH5AbilityPlugin.LOCALID_HEAD)) {
            return (WebResourceResponse) ((IPublicAccountH5AbilityPlugin) QRoute.api(IPublicAccountH5AbilityPlugin.class)).getWebResponse(str);
        }
        if (((IGdtAPI) QRoute.api(IGdtAPI.class)).isClickCgiUrlForTool(str)) {
            WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
            if (pluginEngine == null) {
                return null;
            }
            if (z16) {
                pluginEngine.s(str, 8589934593L, null);
            }
            try {
                Object r16 = pluginEngine.r(str, 8L);
                if (!(r16 instanceof WebResourceResponse)) {
                    return null;
                }
                return (WebResourceResponse) r16;
            } catch (Exception e16) {
                QLog.e("WebViewWrapperInjector", 1, "shouldInterceptRequest error:" + e16.getMessage());
                return null;
            }
        }
        return com.tencent.mobileqq.springhb.js.a.c(str);
    }
}
