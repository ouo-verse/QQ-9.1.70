package com.tencent.xweb;

import android.content.Context;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.tq.e;
import com.tencent.luggage.wxa.tq.g;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebViewDatabase implements e {

    /* renamed from: b, reason: collision with root package name */
    public static WebViewDatabase f385017b;

    /* renamed from: a, reason: collision with root package name */
    public final e f385018a;

    public WebViewDatabase(Context context) {
        e webViewDatabase = g.b(WebView.getCurrentModuleWebCoreType()).getWebViewDatabase(context);
        this.f385018a = webViewDatabase;
        if (webViewDatabase == null) {
            x0.c("WebViewDatabase", "create WebViewDatabase failed, webview type:" + WebView.getCurrentModuleWebCoreType());
        }
    }

    public static synchronized e getInstance(Context context) {
        WebViewDatabase webViewDatabase;
        synchronized (WebViewDatabase.class) {
            if (f385017b == null) {
                f385017b = new WebViewDatabase(context);
            }
            webViewDatabase = f385017b;
        }
        return webViewDatabase;
    }

    @Override // com.tencent.luggage.wxa.tq.e
    @Deprecated
    public void clearFormData() {
        this.f385018a.clearFormData();
    }

    @Override // com.tencent.luggage.wxa.tq.e
    public void clearHttpAuthUsernamePassword() {
        this.f385018a.clearHttpAuthUsernamePassword();
    }

    @Override // com.tencent.luggage.wxa.tq.e
    @Deprecated
    public void clearUsernamePassword() {
        this.f385018a.clearUsernamePassword();
    }

    @Override // com.tencent.luggage.wxa.tq.e
    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return this.f385018a.getHttpAuthUsernamePassword(str, str2);
    }

    @Override // com.tencent.luggage.wxa.tq.e
    @Deprecated
    public boolean hasFormData() {
        return this.f385018a.hasFormData();
    }

    @Override // com.tencent.luggage.wxa.tq.e
    public boolean hasHttpAuthUsernamePassword() {
        return this.f385018a.hasHttpAuthUsernamePassword();
    }

    @Override // com.tencent.luggage.wxa.tq.e
    @Deprecated
    public boolean hasUsernamePassword() {
        return this.f385018a.hasUsernamePassword();
    }

    @Override // com.tencent.luggage.wxa.tq.e
    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        this.f385018a.setHttpAuthUsernamePassword(str, str2, str3, str4);
    }
}
