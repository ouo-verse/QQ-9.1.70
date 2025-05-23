package com.tencent.qimei.av;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.tencent.qimei.webview.QmWebview;

/* compiled from: P */
/* loaded from: classes22.dex */
public class m {

    /* renamed from: b, reason: collision with root package name */
    public Context f343183b;

    /* renamed from: a, reason: collision with root package name */
    public WebView f343182a = null;

    /* renamed from: c, reason: collision with root package name */
    public final h f343184c = new h(NotificationCompat.CATEGORY_SYSTEM);

    public m(Context context) {
        this.f343183b = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(m mVar) {
        if (mVar.f343182a == null) {
            try {
                mVar.f343182a = new QmWebview(mVar.f343183b);
                mVar.removeJavascriptInterface("searchBoxJavaBridge_");
                mVar.f343182a.removeJavascriptInterface("accessibility");
                mVar.f343182a.removeJavascriptInterface("accessibilityTraversal");
                WebSettings settings = mVar.f343182a.getSettings();
                settings.setAllowFileAccessFromFileURLs(false);
                settings.setAllowUniversalAccessFromFileURLs(false);
                settings.setSavePassword(false);
                settings.setJavaScriptEnabled(true);
                settings.setAllowFileAccess(true);
                settings.setCacheMode(-1);
                mVar.f343182a.addJavascriptInterface(mVar.f343184c, "JSInterface");
                mVar.f343182a.setWebViewClient(new k(mVar));
            } catch (RuntimeException e16) {
                com.tencent.qimei.ad.c.a(e16);
            }
        }
        mVar.f343182a.loadUrl(com.tencent.qimei.f.a.b(mVar.f343183b));
    }
}
