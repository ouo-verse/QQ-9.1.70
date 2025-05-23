package com.tencent.xweb;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.tq.b;
import com.tencent.luggage.wxa.tq.g;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebStorage implements b {

    /* renamed from: b, reason: collision with root package name */
    public static WebStorage f384995b;

    /* renamed from: a, reason: collision with root package name */
    public final b f384996a;

    public WebStorage() {
        b webviewStorage = g.b(WebView.getCurrentModuleWebCoreType()).getWebviewStorage();
        this.f384996a = webviewStorage;
        if (webviewStorage == null) {
            x0.c("WebStorage", "create WebStorage failed, webview type:" + WebView.getCurrentModuleWebCoreType());
        }
    }

    public static synchronized WebStorage getInstance() {
        WebStorage webStorage;
        synchronized (WebStorage.class) {
            if (f384995b == null) {
                f384995b = new WebStorage();
            }
            webStorage = f384995b;
        }
        return webStorage;
    }

    @Override // com.tencent.luggage.wxa.tq.b
    public void deleteOrigin(String str) {
        b bVar = this.f384996a;
        if (bVar != null) {
            bVar.deleteOrigin(str);
        }
    }

    public void deleteAllData() {
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
    }

    @Deprecated
    public void setQuotaForOrigin(String str, long j3) {
    }
}
