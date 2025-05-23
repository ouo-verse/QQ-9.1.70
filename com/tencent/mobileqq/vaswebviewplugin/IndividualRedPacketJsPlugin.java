package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class IndividualRedPacketJsPlugin extends VasWebviewJsPlugin {
    public static final String BUSINESS_NAME = "individualRedPacket";
    private static final String TAG = "IndividualRedPacketJsPlugin";
    private BrowserAppInterface browserApp;
    private Bundle mReqBundle;

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return BUSINESS_NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 2281701376L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (str == null || !BUSINESS_NAME.equals(str2) || str3 == null) {
            return false;
        }
        JSONObject jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
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
        if ("getBitmap".equals(str3)) {
            this.mReqBundle.clear();
            try {
                this.mReqBundle.putString("templateId", jsonFromJSBridge.getString("templateId"));
                this.mReqBundle.putString("content", jsonFromJSBridge.getString("content"));
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "Failed to getBitmap:" + e16.getMessage());
                }
            }
            str4 = "rpWebGetBitmap";
        } else if ("setFlag".equals(str3)) {
            this.mReqBundle.clear();
            try {
                if (jsonFromJSBridge.has("switchFlag")) {
                    this.mReqBundle.putInt("iRedDisable", jsonFromJSBridge.getInt("switchFlag"));
                }
                if (jsonFromJSBridge.has("vipRedpacketFlag")) {
                    this.mReqBundle.putInt("iCanUseRed", jsonFromJSBridge.getInt("vipRedpacketFlag"));
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", 0);
                super.callJs(optString, jSONObject.toString());
            } catch (JSONException e17) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "Failed to setFlag:" + e17.getMessage());
                }
            }
            str4 = "rpWebSetFlags";
        } else if ("setRedPacketInfo".equals(str3)) {
            this.mReqBundle.clear();
            try {
                int optInt = jsonFromJSBridge.optInt("redPacketId", -1);
                String optString2 = jsonFromJSBridge.optString("redPacketText", null);
                this.mReqBundle.putInt("iRedPacketId", optInt);
                this.mReqBundle.putString("sRedPackRemard", optString2);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "setRedPacketInfo iRedPacketId = " + optInt + ";sRedPackRemard = " + optString2);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", 0);
                super.callJs(optString, jSONObject2.toString());
            } catch (Exception e18) {
                QLog.e(TAG, 2, "Failed to setRedPacketInfo:" + e18.getMessage());
            }
            str4 = "rpWebSetRedpacketInfo";
        } else {
            boolean equals = "initTemplate".equals(str3);
            String str5 = "";
            if (!equals) {
                str4 = "";
            } else {
                this.mReqBundle.clear();
                try {
                    Bundle bundle = this.mReqBundle;
                    if (jsonFromJSBridge.has("templateId")) {
                        str5 = jsonFromJSBridge.getString("templateId");
                    }
                    bundle.putString("templateId", str5);
                } catch (Exception e19) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "Failed to initTemplate:" + e19.getMessage());
                    }
                }
                str4 = "rpWebInitTemplate";
            }
        }
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a(str4, optString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.mReqBundle = new Bundle();
        AppInterface b16 = this.mRuntime.b();
        if (b16 instanceof BrowserAppInterface) {
            this.browserApp = (BrowserAppInterface) b16;
        } else if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "ERROR!!! IndividualRedPacket market is not running in web process!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        if (bundle != null && bundle.getInt("respkey", 0) == this.mOnRemoteResp.key) {
            String string = bundle.getString("cmd");
            try {
                String string2 = bundle.getString("callbackid");
                Bundle bundle2 = bundle.getBundle("response");
                JSONObject jSONObject = new JSONObject();
                if ("rpWebGetBitmap".equals(string)) {
                    jSONObject.put("code", bundle2.getInt("result"));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("templateId", bundle2.getString("templateId"));
                    jSONObject2.put("content", bundle2.getString("content"));
                    jSONObject2.put(MimeHelper.IMAGE_SUBTYPE_BITMAP, bundle2.getString(MimeHelper.IMAGE_SUBTYPE_BITMAP));
                    jSONObject.put("data", jSONObject2);
                    super.callJs(string2, jSONObject.toString());
                    return;
                }
                if ("rpWebInitTemplate".equals(string)) {
                    jSONObject.put("code", bundle2.getInt("result"));
                    super.callJs(string2, jSONObject.toString());
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "Failed to handle cmd " + string + ", exception: " + e16.getMessage());
                }
            }
        }
    }
}
