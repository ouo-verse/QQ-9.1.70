package com.tencent.mobileqq.jsp;

import android.content.IntentFilter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

/* compiled from: P */
/* loaded from: classes33.dex */
public class y extends WebViewPlugin {
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "story";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        "story".equals(str2);
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityReady() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.action.dispatch_event_do_like");
        intentFilter.addAction("com.tencent.mobileqq.action.dispatch_event_comment");
        intentFilter.addAction("com.tencent.mobileqq.action.dispatch_event_subscribe");
    }
}
