package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class PraiseJsPlugin extends VasWebviewJsPlugin {
    public static final String BUSINESS_NAME = "praise";
    public static final String TAG = "PraiseJsPlugin";
    public Bundle mReqBundle;

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "praise";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jsonFromJSBridge;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (str == null || !"praise".equals(str2) || str3 == null) {
            return false;
        }
        try {
            jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
        } catch (Throwable th5) {
            QLog.e(TAG, 2, th5.getMessage(), th5);
        }
        if (jsonFromJSBridge == null) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
        }
        String optString = jsonFromJSBridge.optString("callback");
        if (TextUtils.isEmpty(optString)) {
            QLog.e(TAG, 1, "callback id is null, so return");
            return true;
        }
        VasCommonReporter.getHistoryJsbFeature(getNameSpace()).setValue2(str3).report();
        if ("queryLocal".equals(str3)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "queryLocal " + jsonFromJSBridge.toString());
            }
            Bundle a16 = com.tencent.mobileqq.emosm.a.a("queryPraiseLocal", optString, this.mOnRemoteResp.key, new Bundle());
            try {
                if (jsonFromJSBridge.has("type")) {
                    a16.putString("type", jsonFromJSBridge.getString("type"));
                }
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, e16.getMessage());
                }
            }
            super.sendRemoteReq(a16, false, false);
        } else if (ColorRingJsPlugin.Method_SetUp.equals(str3)) {
            int i3 = jsonFromJSBridge.getInt("id");
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "setup " + jsonFromJSBridge.toString());
            }
            this.mReqBundle.clear();
            this.mReqBundle.putInt("id", i3);
            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("setupPraise", optString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        this.mReqBundle = new Bundle();
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        String str;
        JSONObject jSONObject;
        if (bundle == null || bundle.getInt("respkey", 0) != this.mOnRemoteResp.key) {
            return;
        }
        String string = bundle.getString("cmd");
        String string2 = bundle.getString("callbackid");
        Bundle bundle2 = bundle.getBundle("response");
        if (bundle2 != null) {
            bundle2.setClassLoader(this.mRuntime.a().getClassLoader());
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "response:" + string);
        }
        if (string != null) {
            if ("queryPraiseLocal".equals(string)) {
                if (bundle2 != null) {
                    int i3 = bundle2.getInt("id");
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("currentId", i3);
                        jSONObject2.put("data", jSONObject3);
                        jSONObject2.put("result", 0);
                        super.callJs(string2 + "(" + jSONObject2.toString() + ");");
                        return;
                    } catch (JSONException e16) {
                        QLog.e(TAG, 1, "onResponse: cmd=" + string + " failed.", e16);
                        return;
                    }
                }
                return;
            }
            if (!"setupPraise".equals(string)) {
                super.onResponse(bundle);
                return;
            }
            if (bundle2 != null) {
                int i16 = bundle2.getInt("id");
                int i17 = bundle2.getInt("code");
                String string3 = bundle2.getString("url");
                try {
                    jSONObject = new JSONObject();
                    str = TAG;
                } catch (JSONException e17) {
                    e = e17;
                    str = TAG;
                }
                try {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("currentId", i16);
                    jSONObject4.put("url", string3);
                    jSONObject.put("result", i17);
                    jSONObject.put("data", jSONObject4);
                    super.callJs(string2 + "(" + jSONObject.toString() + ");");
                } catch (JSONException e18) {
                    e = e18;
                    QLog.e(str, 1, "onResponse: cmd=" + string + " failed.", e);
                }
            }
        }
    }
}
