package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class o extends WebViewPlugin {
    private int p(byte b16) {
        com.tencent.mobileqq.webview.swift.af afVar;
        WebViewPlugin.b bVar = this.mRuntime;
        com.tencent.mobileqq.webview.swift.y d16 = bVar.d(bVar.a());
        ComponentCallbacks2 a16 = this.mRuntime.a();
        if (d16 instanceof com.tencent.mobileqq.webview.swift.af) {
            afVar = (com.tencent.mobileqq.webview.swift.af) d16;
        } else {
            afVar = a16 instanceof com.tencent.mobileqq.webview.swift.af ? (com.tencent.mobileqq.webview.swift.af) a16 : null;
        }
        return afVar != null ? afVar.switchRequestCode(this, b16) : b16;
    }

    private Activity q() {
        Activity a16 = this.mRuntime.a();
        while (a16 instanceof BasePluginActivity) {
            a16 = ((BasePluginActivity) a16).getOutActivity();
        }
        return a16;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "login";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        super.onActivityResult(intent, b16, i3);
        QLog.d("LoginPlugin", 1, "onActivityResult");
        Activity q16 = q();
        if (q16 != null) {
            q16.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if ("login".equals(str2) && "openSmsPage".equals(str3)) {
            try {
                addOpenApiListenerIfNeeded(str3, jsBridgeListener);
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString("countryCode");
                String optString2 = jSONObject.optString("uin");
                String optString3 = jSONObject.optString("phone");
                int optInt = jSONObject.optInt("mentrance");
                int parseInt = Integer.parseInt(jSONObject.optString("verifySeq"));
                Intent intent = new Intent();
                intent.putExtra(AuthDevOpenUgActivity.KEY_PHONE_NUM, optString3);
                intent.putExtra("country_code", optString);
                intent.putExtra("mobile_type", 0);
                intent.putExtra(AuthDevOpenUgActivity.KEY_IS_FROM_LOGIN, true);
                intent.putExtra("uin", optString2);
                intent.putExtra("seq", parseInt);
                RouteUtils.startActivityForResult(q(), intent, "/base/login/authDevVerifyCode", p((byte) 12));
                String str4 = "";
                if (optInt == 1) {
                    str4 = "1";
                } else if (optInt == 2) {
                    str4 = "2";
                }
                ReportController.r(null, "dc00898", "", "", "0X800ADE1", "0X800ADE1", 0, 0, str4, "", "", "");
                return true;
            } catch (Exception e16) {
                QLog.e("LoginPlugin", 1, "deal login jsbridge error : ", e16.getMessage());
            }
        }
        return false;
    }
}
