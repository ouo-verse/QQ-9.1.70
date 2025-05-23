package com.tencent.mobileqq.vaswebviewplugin;

/* loaded from: classes35.dex */
public class EmojiSubPageUiPlugin extends EmojiUiPlugin {
    @Override // com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin, com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public void OnActivityPause() {
        super.OnActivityPause();
        this.mRuntime.e().loadUrl("javascript:var webviewEvent = document.createEvent('Events');webviewEvent.initEvent('webviewobserve');webviewEvent.name = 'stopAudio';document.dispatchEvent(webviewEvent);");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 8L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 3L;
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin, com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public void OnActivityCreate() {
        this.mActivityType = 2;
        super.OnActivityCreate();
    }
}
