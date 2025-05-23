package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.webview.swift.WebViewProvider;

/* loaded from: classes35.dex */
public class ColorRingUIPlugin extends VasWebviewUiPlugin {
    private static final String TAG = "ColorRingUIPlugin";

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public void OnActivityCreate() {
        super.OnActivityCreate();
        WebViewProvider f16 = this.mRuntime.f();
        if (f16 != null) {
            f16.setCurUrl(super.decodeUrl(f16.getCurrentUrl()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 4194304L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 3L;
    }
}
