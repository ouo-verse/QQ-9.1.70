package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ag extends WebViewPlugin {
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NonNull
    public String getNameSpace() {
        return "userVerify";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        Activity a16;
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_SECURITY_VERIFY, 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", str, str2, str3, strArr));
        }
        if ("userVerify".equals(str2) && (a16 = this.mRuntime.a()) != null && "setTicket".equals(str3)) {
            try {
                String optString = new JSONObject(strArr[0]).optString("ticket");
                int intExtra = a16.getIntent().getIntExtra("verify_type", -1);
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_SECURITY_VERIFY, 2, String.format("verifyTicket: %s, verifyType: %s", optString, Integer.valueOf(intExtra)));
                }
                Intent intent = new Intent();
                intent.putExtra("ticket", optString);
                a16.setResult(-1, intent);
                a16.finish();
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.d(LogTag.TAG_SECURITY_VERIFY, 1, "handleJsRequest", e16);
                return true;
            }
        }
        return false;
    }
}
