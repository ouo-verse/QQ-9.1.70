package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ai extends WebViewPlugin {
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "troop_member_level_JS_API";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!"troop_member_level_JS_API".equals(str2) || !"setTitleBar".equals(str3) || strArr.length != 3) {
            return false;
        }
        com.tencent.mobileqq.webview.swift.component.v vVar = (com.tencent.mobileqq.webview.swift.component.v) super.getBrowserComponent(2);
        if (vVar != null) {
            String str4 = strArr[0];
            if ("RETURN".equals(str4)) {
                str4 = this.mRuntime.a().getIntent().getStringExtra(AppConstants.LeftViewText.LEFTVIEWTEXT);
            }
            vVar.C.P(str4, strArr[1], strArr[2]);
        }
        return true;
    }
}
