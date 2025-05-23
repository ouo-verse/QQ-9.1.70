package com.tencent.mobileqq.vas.hippy;

import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends JsBridgeListener {

    /* renamed from: d, reason: collision with root package name */
    private final n13.b f309488d;

    public b(WebView webView, long j3, boolean z16) {
        super(webView, j3, z16);
        this.f309488d = n13.b.f();
    }

    @Override // com.tencent.mobileqq.webview.swift.JsBridgeListener
    public void c(Object obj) {
        this.f309488d.e().onCallJs(obj);
    }

    @Override // com.tencent.mobileqq.webview.swift.JsBridgeListener
    public void d(JSONObject jSONObject) {
        this.f309488d.e().onCallJs(jSONObject);
    }

    @Override // com.tencent.mobileqq.webview.swift.JsBridgeListener
    public void e(String str) {
        this.f309488d.e().onCallError(str);
    }

    @Override // com.tencent.mobileqq.webview.swift.JsBridgeListener
    public void f() {
        this.f309488d.e().onCallError("PermissionDenied");
    }
}
