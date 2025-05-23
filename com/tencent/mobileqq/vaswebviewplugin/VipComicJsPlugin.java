package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class VipComicJsPlugin extends VasWebviewJsPlugin {
    public static final String NAMESPACE = "ppreloader";
    public static final String TAG = "Plugin Preloader";

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return NAMESPACE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest, url=" + str);
        }
        if (NAMESPACE.equals(str2) && str != null && str3 != null) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString("callback", "");
                if ("preloadProcess".equals(str3)) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("processId", jSONObject.optString("processId"));
                        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_preload_plugin_process", optString, this.mOnRemoteResp.key, bundle), false, false);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("code", -1);
                            jSONObject2.put("message", "feature not support.");
                            callJs(optString, jSONObject2.toString());
                        } catch (Exception e17) {
                            e17.printStackTrace();
                        }
                    }
                    return true;
                }
            } catch (Exception e18) {
                e18.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        if (bundle != null && bundle.getInt("respkey", 0) == this.mOnRemoteResp.key) {
            String string = bundle.getString("cmd");
            String string2 = bundle.getString("callbackid");
            Bundle bundle2 = bundle.getBundle("response");
            if ("ipc_preload_plugin_process".equals(string)) {
                int i3 = bundle2.getInt("code", -1);
                String string3 = bundle2.getString("message");
                if (string3 == null) {
                    string3 = "feature not support";
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", i3);
                    jSONObject.put("message", string3);
                    callJs(string2, jSONObject.toString());
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }
}
