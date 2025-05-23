package com.tencent.mobileqq.intervideo.od;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.intervideo.huayang.impl.HuayangJsPluginImpl;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class ODAppJSPlugin extends HuayangJsPluginImpl implements ITroopMemberApiClientApi.a {
    public static final String NAMESPACE = "odapp";
    private String mJsCallback;

    @Override // com.tencent.mobileqq.intervideo.huayang.impl.HuayangJsPluginImpl, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return NAMESPACE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.intervideo.huayang.impl.HuayangJsPluginImpl, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jSONObject;
        String str4;
        String str5;
        int i3;
        int i16;
        if (!NAMESPACE.equals(str2)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("XProxy|ODAppJSPlugin", 2, "handleJsRequest: url = " + str + ", pkgName = " + str2 + ", method = " + str3 + ", args = " + strArr);
        }
        if (!TextUtils.equals(str3, "open") && !TextUtils.equals(str3, "cancelPage")) {
            try {
                jSONObject = new JSONObject(strArr[0]);
            } catch (JSONException unused) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                String optString = jSONObject.optString("callback");
                i3 = jSONObject.optInt("roomid");
                String optString2 = jSONObject.optString("vasname");
                String optString3 = jSONObject.optString("userdata");
                int optInt = jSONObject.optInt("fromid");
                this.mJsCallback = optString;
                i16 = optInt;
                str4 = optString2;
                str5 = optString3;
            } else {
                str4 = "";
                str5 = str4;
                i3 = 0;
                i16 = 0;
            }
            if ("odOpenRoom".equals(str3) && strArr.length == 1) {
                this.mClient.d0(0, i3, str4, str5, i16);
                return true;
            }
        } else {
            super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
    public void callback(Bundle bundle) {
        if (bundle == null || !"onOpenRoomResult".equals(bundle.getString("method")) || this.mJsCallback == null) {
            return;
        }
        int i3 = bundle.getInt("code", 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i3);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        callJs(this.mJsCallback, jSONObject.toString());
    }
}
