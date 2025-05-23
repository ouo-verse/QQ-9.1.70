package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class ColorScreenJsPlugin extends VasWebviewJsPlugin {
    public static final String BUSINESS_NAME = "colorScreen";
    public static final String TAG = "ColorScreenJsPlugin";

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return BUSINESS_NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jsonFromJSBridge;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (str == null || !BUSINESS_NAME.equals(str2) || str3 == null) {
            return false;
        }
        try {
            jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, th5.getMessage());
            }
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
            queryLocal(jsonFromJSBridge, optString);
        } else if (ColorRingJsPlugin.Method_SetUp.equals(str3)) {
            setup(jsonFromJSBridge, optString);
        } else {
            throw new Exception(" unsupport method name " + str3);
        }
        return true;
    }

    public void queryLocal(JSONObject jSONObject, String str) {
        Bundle a16 = com.tencent.mobileqq.emosm.a.a("colorScreen_queryLocal", str, this.mOnRemoteResp.key, new Bundle());
        if (jSONObject != null) {
            try {
                if (jSONObject.has("type")) {
                    a16.putString("type", jSONObject.getString("type"));
                }
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, e16.getMessage());
                }
            }
        }
        super.sendRemoteReq(a16, false, false);
    }

    public void setup(JSONObject jSONObject, String str) throws JSONException {
        int i3 = jSONObject.getInt("id");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "setup " + jSONObject.toString());
        }
        Bundle bundle = new Bundle();
        bundle.clear();
        bundle.putInt("id", i3);
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("colorScreen_setup", str, this.mOnRemoteResp.key, bundle), false, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        if (bundle == null || bundle.getInt("respkey", 0) != this.mOnRemoteResp.key) {
            return;
        }
        String string = bundle.getString("cmd");
        String string2 = bundle.getString("callbackid");
        Bundle bundle2 = bundle.getBundle("response");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "response:" + string);
        }
        if (!"colorScreen_queryLocal".equals(string)) {
            if ("colorScreen_setup".equals(string)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("result", bundle.getInt("result"));
                    jSONObject.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "setup result: " + jSONObject.toString());
                    }
                    super.callJs(string2 + "(" + jSONObject.toString() + ");");
                    return;
                } catch (JSONException e16) {
                    QLog.e(TAG, 1, "", e16);
                    return;
                }
            }
            return;
        }
        if (bundle2 != null) {
            int i3 = bundle2.getInt("id");
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("currentId", i3);
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "query local colorScreen data: " + jSONObject3.toString());
                }
                jSONObject2.put("data", jSONObject3);
                jSONObject2.put("result", 0);
                super.callJs(string2 + "(" + jSONObject2.toString() + ");");
            } catch (JSONException e17) {
                QLog.e(TAG, 1, "", e17);
            }
        }
    }
}
