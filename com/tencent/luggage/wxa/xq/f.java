package com.tencent.luggage.wxa.xq;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.webkit.WebViewDatabase;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.WebView;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f implements com.tencent.luggage.wxa.tq.e {

    /* renamed from: a, reason: collision with root package name */
    public WebViewDatabase f145403a;

    public f(Context context) {
        try {
            this.f145403a = WebViewDatabase.getInstance(context);
        } catch (Exception e16) {
            String stackTraceString = Log.getStackTraceString(e16);
            x0.f("SysWebViewDatabase", "Create sys data base failed." + stackTraceString);
            com.tencent.luggage.wxa.wq.f.a(4, stackTraceString, WebView.WebViewKind.WV_KIND_SYS.ordinal(), com.tencent.luggage.wxa.ar.g.b());
        }
    }

    @Override // com.tencent.luggage.wxa.tq.e
    public void clearFormData() {
        WebViewDatabase webViewDatabase = this.f145403a;
        if (webViewDatabase == null) {
            return;
        }
        webViewDatabase.clearFormData();
    }

    @Override // com.tencent.luggage.wxa.tq.e
    public void clearHttpAuthUsernamePassword() {
        WebViewDatabase webViewDatabase = this.f145403a;
        if (webViewDatabase == null) {
            return;
        }
        webViewDatabase.clearHttpAuthUsernamePassword();
    }

    @Override // com.tencent.luggage.wxa.tq.e
    public void clearUsernamePassword() {
        WebViewDatabase webViewDatabase = this.f145403a;
        if (webViewDatabase == null) {
            return;
        }
        webViewDatabase.clearUsernamePassword();
    }

    @Override // com.tencent.luggage.wxa.tq.e
    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        String[] httpAuthUsernamePassword;
        WebViewDatabase webViewDatabase = this.f145403a;
        if (webViewDatabase != null && Build.VERSION.SDK_INT >= 26) {
            httpAuthUsernamePassword = webViewDatabase.getHttpAuthUsernamePassword(str, str2);
            return httpAuthUsernamePassword;
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.tq.e
    public boolean hasFormData() {
        WebViewDatabase webViewDatabase = this.f145403a;
        if (webViewDatabase == null) {
            return false;
        }
        return webViewDatabase.hasFormData();
    }

    @Override // com.tencent.luggage.wxa.tq.e
    public boolean hasHttpAuthUsernamePassword() {
        WebViewDatabase webViewDatabase = this.f145403a;
        if (webViewDatabase == null) {
            return false;
        }
        return webViewDatabase.hasHttpAuthUsernamePassword();
    }

    @Override // com.tencent.luggage.wxa.tq.e
    public boolean hasUsernamePassword() {
        WebViewDatabase webViewDatabase = this.f145403a;
        if (webViewDatabase == null) {
            return false;
        }
        return webViewDatabase.hasUsernamePassword();
    }

    @Override // com.tencent.luggage.wxa.tq.e
    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        WebViewDatabase webViewDatabase = this.f145403a;
        if (webViewDatabase != null && Build.VERSION.SDK_INT >= 26) {
            webViewDatabase.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }
}
