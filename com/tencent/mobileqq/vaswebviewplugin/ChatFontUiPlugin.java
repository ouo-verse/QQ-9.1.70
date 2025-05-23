package com.tencent.mobileqq.vaswebviewplugin;

import java.util.Map;

/* loaded from: classes35.dex */
public class ChatFontUiPlugin extends VasWebviewUiPlugin {
    private static final String TAG = "ChatFontUiPlugin";
    private boolean mIsDpcWriteUser;

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    protected boolean excuteEvent(String str, long j3, Map<String, Object> map) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 4096L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 3L;
    }
}
