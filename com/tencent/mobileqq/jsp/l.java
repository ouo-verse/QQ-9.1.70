package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

/* compiled from: P */
/* loaded from: classes33.dex */
public class l extends WebViewPlugin {
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "kdSearchResult";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if ("nvPopToRoot".equals(str3) && strArr.length > 0) {
            Activity a16 = this.mRuntime.a();
            Intent aliasIntent = SplashActivity.getAliasIntent(a16);
            aliasIntent.setFlags(67108864);
            a16.startActivity(aliasIntent);
            return false;
        }
        return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
    }
}
