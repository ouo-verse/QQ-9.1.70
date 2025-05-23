package com.tencent.qimei.av;

import android.content.Context;
import com.tencent.qimei.webview.QmX5Webview;
import com.tencent.qqmini.miniapp.task.ServiceCreateTask;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes22.dex */
public class p {

    /* renamed from: b, reason: collision with root package name */
    public Context f343188b;

    /* renamed from: a, reason: collision with root package name */
    public WebView f343187a = null;

    /* renamed from: c, reason: collision with root package name */
    public final h f343189c = new h(ServiceCreateTask.SERVICE_TYPE_X5);

    public p(Context context) {
        this.f343188b = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(p pVar) {
        if (pVar.f343187a == null) {
            pVar.f343187a = new QmX5Webview(pVar.f343188b);
            if (pVar.getX5WebViewExtension() == null) {
                pVar.f343189c.f343172b = "x5_sys";
            }
            pVar.f343187a.removeJavascriptInterface("searchBoxJavaBridge_");
            pVar.f343187a.removeJavascriptInterface("accessibility");
            pVar.f343187a.removeJavascriptInterface("accessibilityTraversal");
            WebSettings settings = pVar.f343187a.getSettings();
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
            settings.setSavePassword(false);
            settings.setAllowFileAccess(true);
            settings.setJavaScriptEnabled(true);
            settings.setCacheMode(-1);
            pVar.f343187a.addJavascriptInterface(pVar.f343189c, "JSInterface");
            pVar.f343187a.setWebViewClient(new n(pVar));
        }
        pVar.f343187a.loadUrl(com.tencent.qimei.f.a.b(pVar.f343188b));
    }
}
