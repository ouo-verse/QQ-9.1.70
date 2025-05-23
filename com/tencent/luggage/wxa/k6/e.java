package com.tencent.luggage.wxa.k6;

import android.webkit.ValueCallback;
import com.tencent.xweb.WebView;
import java.net.URL;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements com.tencent.luggage.wxa.ei.j, com.tencent.luggage.wxa.mj.f {

    /* renamed from: a, reason: collision with root package name */
    public final WebView f131669a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f131670b;

    public e(WebView webview) {
        Intrinsics.checkNotNullParameter(webview, "webview");
        this.f131669a = webview;
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public com.tencent.luggage.wxa.ei.k a(Class cls) {
        if (Intrinsics.areEqual(com.tencent.luggage.wxa.mj.f.class, cls) && this.f131669a.supportFeature(1040)) {
            return this;
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void addJavascriptInterface(Object obj, String str) {
        boolean z16;
        if (obj == null) {
            return;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this.f131669a.addJavascriptInterface(obj, str);
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void destroy() {
        this.f131669a.destroy();
    }

    @Override // com.tencent.luggage.wxa.ei.p
    public void evaluateJavascript(String str, ValueCallback valueCallback) {
        this.f131669a.evaluateJavascript(str, valueCallback);
    }

    @Override // com.tencent.luggage.wxa.mj.f
    public void t() {
        Boolean bool = this.f131670b;
        Boolean bool2 = Boolean.TRUE;
        if (!Intrinsics.areEqual(bool, bool2)) {
            this.f131669a.onShow();
            this.f131670b = bool2;
        }
    }

    @Override // com.tencent.luggage.wxa.mj.f
    public void v() {
        Boolean bool = this.f131670b;
        Boolean bool2 = Boolean.FALSE;
        if (!Intrinsics.areEqual(bool, bool2)) {
            this.f131669a.onHide();
            this.f131670b = bool2;
        }
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void a(URL url, String str, ValueCallback valueCallback) {
        evaluateJavascript(str, valueCallback);
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void a(URL url, String str, String str2, int i3, String str3, ValueCallback valueCallback) {
        evaluateJavascript(str3, valueCallback);
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void setJsExceptionHandler(com.tencent.luggage.wxa.ei.i iVar) {
    }
}
