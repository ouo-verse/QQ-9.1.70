package com.tencent.mobileqq.msgforward;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b extends WebViewPlugin {
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "msgForward";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin.b bVar;
        String str4;
        if (str2 == null || !"msgForward".equalsIgnoreCase(str2) || str3 == null || (bVar = this.mRuntime) == null || bVar.a() == null || !"showForwardToWXMsg".equalsIgnoreCase(str3) || strArr == null) {
            return false;
        }
        if (strArr.length > 0) {
            for (String str5 : strArr) {
                QLog.d("MsgforwardWXWebViewPlugin", 1, str5);
            }
        }
        try {
            str4 = new JSONObject(strArr[0]).optString("rId");
        } catch (Exception unused) {
            QLog.e("MsgforwardWXWebViewPlugin", 1, "MsgforwardWXWebViewPlugin get resid exception!");
            str4 = "0";
        }
        Activity a16 = this.mRuntime.a();
        long hashCode = str4.hashCode();
        Intent intent = new Intent(a16, (Class<?>) MultiForwardActivity.class);
        intent.putExtra("chat_subType", 3);
        intent.putExtra("uin", "0");
        intent.putExtra("uintype", 1040);
        intent.putExtra("multi_url", str4);
        intent.putExtra("multi_uniseq", hashCode);
        a16.startActivity(intent);
        a16.finish();
        return true;
    }
}
