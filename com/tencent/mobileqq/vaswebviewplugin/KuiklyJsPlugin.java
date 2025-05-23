package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.ResError;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class KuiklyJsPlugin extends VasWebviewJsPlugin {
    private static final String METHOD_UPDATE_KUIKLY_BUNDLE = "updateKuiklyBundle";
    private static final String NAME_SPACE = "kuikly";
    private static final String TAG = "KuiklyJsPlugin";

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return NAME_SPACE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest pkgName=" + str2 + " method=" + str3);
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (!NAME_SPACE.equals(str2)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "can not handle objectname:" + str2);
            }
            return false;
        }
        JSONObject jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
        if (jsonFromJSBridge == null) {
            QLog.e(TAG, 1, "handleJsRequest JSONObject is null");
            return false;
        }
        String optString = jsonFromJSBridge.optString("callback");
        if (TextUtils.isEmpty(optString)) {
            QLog.e(TAG, 1, "callback id is null");
        }
        if (METHOD_UPDATE_KUIKLY_BUNDLE.equals(str3)) {
            updateKuiklyBundle(jsonFromJSBridge, optString);
        }
        return true;
    }

    private void updateKuiklyBundle(JSONObject jSONObject, final String str) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("bundleName");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        QLog.i(TAG, 1, "#updateKuiklyBundle: bundleName=" + optString);
        ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).updateDexRes(optString, new Function1<ResError, Unit>() { // from class: com.tencent.mobileqq.vaswebviewplugin.KuiklyJsPlugin.1
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(ResError resError) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("errCode", resError.getCode());
                    jSONObject2.put("errMsg", resError.getMessage());
                    KuiklyJsPlugin.this.callJs(str, jSONObject2.toString());
                    return null;
                } catch (JSONException e16) {
                    QLog.e(KuiklyJsPlugin.TAG, 1, "updateKuiklyBundle error:" + e16);
                    return null;
                }
            }
        });
    }
}
