package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.open.appcommon.AppClient;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;

/* compiled from: P */
/* loaded from: classes32.dex */
public class w extends WebViewPlugin {
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "openToAppDetail";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if ("openToAppDetail".equals(str2) && "openAppDetailPage".equals(str3)) {
            if (strArr.length == 2) {
                p(strArr[0], strArr[1]);
                return true;
            }
            if (strArr.length == 3) {
                q(strArr[0], strArr[1], strArr[2]);
                return true;
            }
        }
        return false;
    }

    public void q(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("uin", this.mRuntime.b().getCurrentAccountUin());
        bundle.putString("sid", this.mRuntime.a().getIntent().getStringExtra("vkey"));
        bundle.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ");
        if (str2 != null && str2.equals("true")) {
            bundle.putBoolean(VirtualAppProxy.KEY_AUTO_DOWNLOAD, true);
        }
        if (str3 != null) {
            bundle.putString("packageName", str3);
        }
        AppClient.j(this.mRuntime.a(), str, 2470, bundle);
    }

    public void p(String str, String str2) {
        q(str, str2, null);
    }
}
