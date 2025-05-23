package com.tencent.mobileqq.vaswebviewplugin;

/* loaded from: classes35.dex */
public class IndividuationUIPlugin extends VasWebviewUiPlugin {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 1048576L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 3L;
    }
}
