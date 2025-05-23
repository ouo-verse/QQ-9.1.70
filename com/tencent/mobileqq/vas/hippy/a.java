package com.tencent.mobileqq.vas.hippy;

import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private final n13.b f309478d = n13.b.f();

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void callJs(String str, String... strArr) {
        this.f309478d.e().onCallJs(strArr);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void callJs4OpenApi(JsBridgeListener jsBridgeListener, int i3, String str) {
        this.f309478d.e().onCallJs(str);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void callJs(String str) {
        this.f309478d.e().onCallJs(str);
    }
}
