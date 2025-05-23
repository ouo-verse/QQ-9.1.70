package com.tencent.biz.webviewplugin;

import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ab extends WebViewPlugin {
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "qztodayinhistory";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d("QZoneTihSettingWebPlugin", 2, "handleJsRequest url: " + str + "pkgName:" + str2 + "method:" + str3);
        }
        if (!str2.equals("qztodayinhistory") || !str3.equals("settihnome")) {
            return false;
        }
        Intent intent = new Intent("aciton_switch_tih_setting");
        if (QLog.isColorLevel()) {
            QLog.d("QZoneTihSettingWebPlugin", 2, "actionString: " + intent.getAction());
        }
        BaseApplication.getContext().sendBroadcast(intent);
        return true;
    }
}
