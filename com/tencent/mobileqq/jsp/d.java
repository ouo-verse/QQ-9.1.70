package com.tencent.mobileqq.jsp;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.report.UploadQualityReportBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class d extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    com.tencent.biz.troop.b f238860d;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements ITroopMemberApiClientApi.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f238861d;

        a(String str) {
            this.f238861d = str;
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            if (d.this.isDestroy) {
                return;
            }
            String format = String.format("{\"result\":%d, \"errMsg\":\"%s\", \"uin\":\"%s\"}", Integer.valueOf(bundle.getInt("result", -1)), bundle.getString("errMsg"), bundle.getString("retUin"));
            d.this.callJs(this.f238861d, format);
            if (QLog.isColorLevel()) {
                QLog.e("ConnectApiPlugin", 2, "handleJsRequest callback:", format);
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return UploadQualityReportBuilder.STATE_CONNECT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!UploadQualityReportBuilder.STATE_CONNECT.equals(str2) || !"exchangeID".equals(str3) || strArr.length <= 0) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            String optString = jSONObject.optString("appid");
            String optString2 = jSONObject.optString("openid");
            String optString3 = jSONObject.optString("troopuin");
            String optString4 = jSONObject.optString("callback");
            if (this.f238860d == null) {
                com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
                this.f238860d = A;
                A.p();
            }
            this.f238860d.M(optString, optString2, optString3, new a(optString4));
            return true;
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ConnectApiPlugin", 2, "handleJsRequest JSONException:" + e16);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        com.tencent.biz.troop.b bVar = this.f238860d;
        if (bVar != null) {
            bVar.q();
        }
    }
}
