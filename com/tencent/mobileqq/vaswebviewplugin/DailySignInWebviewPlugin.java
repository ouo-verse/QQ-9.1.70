package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class DailySignInWebviewPlugin extends VasWebviewJsPlugin {
    public static final String ACTION_SIGN_IN = "action.userSignInForSettingMe";
    private static final String PLUGIN_METHOD_NAME = "signedCallback";
    public static final String PLUGIN_NAMESPACE = "signIn";
    public static final String TAG = "DailySignIn";

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: callActionSignIn, reason: merged with bridge method [inline-methods] */
    public void lambda$handleJsRequest$0(String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            int optInt = jSONObject.optInt("type");
            int optInt2 = jSONObject.optInt("result");
            int optInt3 = jSONObject.optInt("day");
            Bundle bundle = new Bundle();
            bundle.putInt("type", optInt);
            bundle.putInt("result", optInt2);
            bundle.putInt("day", optInt3);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "handleJsRequest type=" + optInt + " result=" + optInt2 + " day=" + optInt3);
            }
            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "SignInModule", ACTION_SIGN_IN, bundle);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "error:" + e16);
        }
    }

    public void callPJs(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "method:" + str + ", json:" + str2);
        }
        callJs(str, str2);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return PLUGIN_NAMESPACE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, final String... strArr) {
        if (str2 == null || !str2.equalsIgnoreCase(PLUGIN_NAMESPACE)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "handleJsRequest url=" + str + " pkg=" + str2 + " method=" + str3);
        }
        if (str2.equals(PLUGIN_NAMESPACE)) {
            VasCommonReporter.getHistoryJsbFeature(getNameSpace()).setValue2(str3).report();
            if (str3.equals(PLUGIN_METHOD_NAME)) {
                if (strArr.length >= 1) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            DailySignInWebviewPlugin.this.lambda$handleJsRequest$0(strArr);
                        }
                    }, 16, null, false);
                } else if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "get bad result from web");
                }
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "DailySignInWebviewPlugin onActivityResult,requestCode = " + ((int) b16) + ", resultCode = " + i3 + ", data = " + intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        super.onResponse(bundle);
    }
}
