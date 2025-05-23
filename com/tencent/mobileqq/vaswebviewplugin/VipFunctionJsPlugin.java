package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class VipFunctionJsPlugin extends VasWebviewJsPlugin {
    public static final String BusinessName = "QQVIPFunction";
    private static final int MAX_REDIRECT = 5;
    public static final String Method_openPreview = "reportToClientTo644";
    public static final String Method_report643 = "reportToClientTo643";
    public static final String TAG = "QQVIPFunctionJsPlugin";
    private volatile String mCurrentURL;
    private Set<String> mUrlFilter;
    private volatile String mUserAgent;

    private void reportToClientTo643(String str, String str2, String str3, String str4, String str5, int i3, int i16, String[] strArr) {
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString("mainAction", str2);
        bundle.putString("toUin", str3);
        bundle.putString("subAction", str4);
        bundle.putString("actionName", str5);
        bundle.putInt("fromeType", i3);
        bundle.putInt("result", i16);
        bundle.putStringArray("reserves", strArr);
        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("QQVIPFunctionReport643", "callback", this.mOnRemoteResp.key, bundle), false, false);
    }

    private void reportToClientTo644(String str, String str2, String str3, int i3, int i16, String[] strArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        ff.T(null, str, str2, str3, i3, i16, strArr);
    }

    public void callPJs(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "method:" + str + ", json:" + str2);
        }
        callJs(str, str2);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return BusinessName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        super.onWebViewCreated(customWebView);
        if (customWebView != null) {
            this.mUserAgent = customWebView.getSettings().getUserAgentString();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest, url=" + str);
        }
        if (!BusinessName.equals(str2) || str == null || str3 == null) {
            return false;
        }
        try {
            JSONObject jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
            if (jsonFromJSBridge == null) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
            }
            jsonFromJSBridge.optString("callback");
            jsonFromJSBridge.optInt("id");
            jsonFromJSBridge.optInt("status");
            String str18 = "";
            if (Method_openPreview.equals(str3)) {
                if (!jsonFromJSBridge.has("businessFlag")) {
                    str12 = "";
                } else {
                    str12 = jsonFromJSBridge.getString("businessFlag");
                }
                if (!jsonFromJSBridge.has("actionType")) {
                    str13 = "";
                } else {
                    str13 = jsonFromJSBridge.getString("actionType");
                }
                if (!jsonFromJSBridge.has("actionName")) {
                    str14 = "";
                } else {
                    str14 = jsonFromJSBridge.getString("actionName");
                }
                int i3 = jsonFromJSBridge.has("entry") ? jsonFromJSBridge.getInt("entry") : -1;
                int i16 = jsonFromJSBridge.has("result") ? jsonFromJSBridge.getInt("result") : -1;
                String[] strArr2 = new String[4];
                if (!jsonFromJSBridge.has("reserves1")) {
                    str15 = "";
                } else {
                    str15 = jsonFromJSBridge.getString("reserves1");
                }
                strArr2[0] = str15;
                if (!jsonFromJSBridge.has("reserves2")) {
                    str16 = "";
                } else {
                    str16 = jsonFromJSBridge.getString("reserves2");
                }
                strArr2[1] = str16;
                if (!jsonFromJSBridge.has("reserves3")) {
                    str17 = "";
                } else {
                    str17 = jsonFromJSBridge.getString("reserves3");
                }
                strArr2[2] = str17;
                if (jsonFromJSBridge.has("reserves4")) {
                    str18 = jsonFromJSBridge.getString("reserves4");
                }
                strArr2[3] = str18;
                reportToClientTo644(str12, str13, str14, i3, i16, strArr2);
                return true;
            }
            if (Method_report643.equals(str3)) {
                if (jsonFromJSBridge.has("tag")) {
                    str4 = jsonFromJSBridge.getString("tag");
                } else {
                    str4 = "CliOper";
                }
                String str19 = str4;
                if (!jsonFromJSBridge.has("mainAction")) {
                    str5 = "";
                } else {
                    str5 = jsonFromJSBridge.getString("mainAction");
                }
                if (!jsonFromJSBridge.has("toUin")) {
                    str6 = "";
                } else {
                    str6 = jsonFromJSBridge.getString("toUin");
                }
                if (!jsonFromJSBridge.has("actionType")) {
                    str7 = "";
                } else {
                    str7 = jsonFromJSBridge.getString("actionType");
                }
                if (!jsonFromJSBridge.has("actionName")) {
                    str8 = "";
                } else {
                    str8 = jsonFromJSBridge.getString("actionName");
                }
                int i17 = jsonFromJSBridge.has("entry") ? jsonFromJSBridge.getInt("entry") : -1;
                int i18 = jsonFromJSBridge.has("result") ? jsonFromJSBridge.getInt("result") : -1;
                String[] strArr3 = new String[4];
                if (!jsonFromJSBridge.has("reserves1")) {
                    str9 = "";
                } else {
                    str9 = jsonFromJSBridge.getString("reserves1");
                }
                strArr3[0] = str9;
                if (!jsonFromJSBridge.has("reserves2")) {
                    str10 = "";
                } else {
                    str10 = jsonFromJSBridge.getString("reserves2");
                }
                strArr3[1] = str10;
                if (!jsonFromJSBridge.has("reserves3")) {
                    str11 = "";
                } else {
                    str11 = jsonFromJSBridge.getString("reserves3");
                }
                strArr3[2] = str11;
                if (jsonFromJSBridge.has("reserves4")) {
                    str18 = jsonFromJSBridge.getString("reserves4");
                }
                strArr3[3] = str18;
                reportToClientTo643(str19, str5, str6, str7, str8, i17, i18, strArr3);
                return true;
            }
            throw new Exception("No Such Method:" + str3);
        } catch (Exception e16) {
            e16.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public boolean excuteEvent(String str, long j3, Map<String, Object> map) {
        if (j3 == 8589934593L) {
            this.mCurrentURL = str;
            CustomWebView e16 = this.mRuntime.e();
            if (e16 != null) {
                this.mUserAgent = e16.getSettings().getUserAgentString();
            }
        }
        return super.excuteEvent(str, j3, map);
    }
}
