package com.tencent.mobileqq.vas.avatar;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class p extends VasWebviewJsPlugin {
    private void p() {
        VasUtil.getService().getVipDataProxy().requestAndUpdateData(this.mRuntime.b().getAccount());
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return PreDetect.FACE_DETECT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jsonFromJSBridge;
        if (QLog.isColorLevel()) {
            QLog.d("VasFaceJsPlugin", 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (str == null || !PreDetect.FACE_DETECT.equals(str2) || str3 == null) {
            return false;
        }
        try {
            jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("VasFaceJsPlugin", 2, th5.getMessage());
            }
        }
        if (jsonFromJSBridge == null) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VasFaceJsPlugin", 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
        }
        String optString = jsonFromJSBridge.optString("callback");
        if (TextUtils.isEmpty(optString)) {
            QLog.e("VasFaceJsPlugin", 1, "callback id is null, so return");
            return true;
        }
        VasCommonReporter.getHistoryJsbFeature(getNameSpace()).setValue2(str3).report();
        if (ColorRingJsPlugin.Method_SetUp.equals(str3)) {
            setup(jsonFromJSBridge, optString);
            return true;
        }
        throw new Exception(" unsupport method name " + str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        if (bundle == null || bundle.getInt("respkey", 0) != this.mOnRemoteResp.key) {
            return;
        }
        String string = bundle.getString("cmd");
        String string2 = bundle.getString("callbackid");
        if (QLog.isColorLevel()) {
            QLog.i("VasFaceJsPlugin", 2, "response:" + string);
        }
        if ("face_setup".equals(string)) {
            try {
                p();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", bundle.getInt("result"));
                jSONObject.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                if (QLog.isColorLevel()) {
                    QLog.i("VasFaceJsPlugin", 2, "setup result: " + jSONObject.toString());
                }
                super.callJs(string2 + "(" + jSONObject.toString() + ");");
            } catch (JSONException e16) {
                QLog.e("VasFaceJsPlugin", 1, "", e16);
            }
        }
    }

    public void setup(JSONObject jSONObject, String str) throws JSONException {
        int i3 = jSONObject.getInt("faceId");
        if (QLog.isColorLevel()) {
            QLog.i("VasFaceJsPlugin", 2, "setup " + jSONObject.toString());
        }
        Bundle bundle = new Bundle();
        bundle.clear();
        bundle.putInt("id", i3);
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("face_setup", str, this.mOnRemoteResp.key, bundle), false, true);
    }
}
