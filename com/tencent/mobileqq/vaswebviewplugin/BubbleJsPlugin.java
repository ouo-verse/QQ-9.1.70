package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.updatesystem.business.BubbleBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.webview.plugin.VasTransformUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class BubbleJsPlugin extends VasWebviewJsPlugin {
    public static final String BUSINESS_NAME = "bubble";
    private static final String OBJECT_NAME = "bubble";
    public static final String TAG = "BubbleJsPlugin";
    private Bundle mReqBundle;

    public void diySetup(JSONObject jSONObject, String str) throws JSONException {
        int i3 = jSONObject.getInt("id");
        int i16 = jSONObject.getInt("textId");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "diySetup " + jSONObject.toString());
        }
        this.mReqBundle.clear();
        this.mReqBundle.putInt("id", i3);
        this.mReqBundle.putInt("textId", i16);
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("diy_setup", str, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        startDownload(jSONObject, "");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, jSONObject.toString());
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "bubble";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 2147483712L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jsonFromJSBridge;
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (str == null || !"bubble".equals(str2) || str3 == null) {
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
        int i3 = jsonFromJSBridge.has("id") ? jsonFromJSBridge.getInt("id") : 0;
        VasCommonReporter.getHistoryJsbFeature(getNameSpace()).setValue2(str3).report();
        if (GameCenterAPIJavaScript.QUERY_INFO.equals(str3)) {
            queryInfo(jsonFromJSBridge, optString);
        } else if ("queryLocal".equals(str3)) {
            queryLocal(jsonFromJSBridge, optString);
        } else if (ColorRingJsPlugin.Method_SetUp.equals(str3)) {
            VasLogReporter.getBubble().reportHighest("web set - bubbleId:" + i3);
            if (this.proxy != null) {
                int optInt = jsonFromJSBridge.optInt("id", -1);
                if (optInt != -1) {
                    z16 = false;
                } else {
                    optInt = jsonFromJSBridge.optInt("voiceprintId", -1);
                    if (optInt == -1) {
                        QLog.e(TAG, 1, "invalid error id");
                    }
                    z16 = true;
                }
                this.proxy.bubbleSetUp(jsonFromJSBridge.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY), optInt, z16);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", 0);
                jSONObject.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                super.callJs(optString + "(" + jSONObject.toString() + ");");
            } else {
                setup(jsonFromJSBridge, optString);
            }
        } else if ("startDownload".equals(str3)) {
            VasLogReporter.getBubble().reportHighest("web requestDownload - bubbleId:" + i3);
            startDownload(jsonFromJSBridge, optString);
        } else if ("diySetup".equalsIgnoreCase(str3)) {
            diySetup(jsonFromJSBridge, optString);
        } else {
            throw new Exception(" unsupport method name " + str3);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        this.mReqBundle = new Bundle();
        super.onCreate();
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onPushMsg(Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onPushMsg=" + bundle);
        }
        int i3 = bundle.getInt("srcType");
        if (i3 == 0 || i3 != 3) {
            return;
        }
        int i16 = bundle.getInt("id");
        int i17 = bundle.getInt("result");
        String string = bundle.getString("callbackId");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", i16);
            jSONObject.put("result", i17);
        } catch (JSONException unused) {
        }
        super.callJs(string + "(" + jSONObject.toString() + ");");
    }

    public void queryInfo(JSONObject jSONObject, String str) throws JSONException {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "queryInfo " + jSONObject.toString());
        }
        int i3 = jSONObject.getInt("id");
        if (i3 == 0) {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("status", 3);
            jSONObject3.put("progress", 100);
            jSONObject2.put("result", 0);
            jSONObject2.put("message", HardCodeUtil.qqStr(R.string.k3v));
            super.callJs(str + "(" + jSONObject2.toString() + ");");
            return;
        }
        if (this.proxy != null) {
            super.callJs(VasTransformUtils.INSTANCE.transformBubble(str, i3, this.proxy.queryInfo(jSONObject.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY), i3, QQVasUpdateBusiness.getBusiness(BubbleBusiness.class))));
        } else {
            this.mReqBundle.clear();
            this.mReqBundle.putInt("id", i3);
            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("queryBubbleInfo", str, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        }
    }

    public void queryLocal(JSONObject jSONObject, String str) {
        String str2;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("queryLocal ");
            if (jSONObject != null) {
                str2 = jSONObject.toString();
            } else {
                str2 = "null";
            }
            sb5.append(str2);
            QLog.i(TAG, 2, sb5.toString());
        }
        Bundle a16 = com.tencent.mobileqq.emosm.a.a("queryLocal", str, this.mOnRemoteResp.key, new Bundle());
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
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "setup " + jSONObject.toString());
        }
        this.mReqBundle.clear();
        if (jSONObject.has("id")) {
            this.mReqBundle.putInt("id", jSONObject.getInt("id"));
        }
        if (jSONObject.has("voiceprintId")) {
            this.mReqBundle.putInt("voiceprintId", jSONObject.optInt("voiceprintId", 0));
        }
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a(ColorRingJsPlugin.Method_SetUp, str, this.mOnRemoteResp.key, this.mReqBundle), false, true);
    }

    public void startDownload(JSONObject jSONObject, String str) throws JSONException {
        int i3 = jSONObject.getInt("id");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "startDownload " + jSONObject.toString());
        }
        this.mReqBundle.clear();
        this.mReqBundle.putInt("id", i3);
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("bubble_startDownLoad", str, this.mOnRemoteResp.key, this.mReqBundle), false, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        if (bundle != null && bundle.getInt("respkey", 0) == this.mOnRemoteResp.key) {
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
                if (ColorRingJsPlugin.Method_SetUp.equals(string)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("result", 0);
                        jSONObject.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                        super.callJs(string2 + "(" + jSONObject.toString() + ");");
                        return;
                    } catch (JSONException unused) {
                        return;
                    }
                }
                if ("diy_setup".equals(string)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", 0);
                        jSONObject2.put("msg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                        super.callJs(string2 + "(" + jSONObject2.toString() + ");");
                        return;
                    } catch (JSONException unused2) {
                        return;
                    }
                }
                if (!"queryLocal".equals(string)) {
                    if (!"queryBubbleInfo".equals(string)) {
                        super.onResponse(bundle);
                        return;
                    }
                    if (bundle2 != null) {
                        String string3 = bundle2.getString("result");
                        if (TextUtils.isEmpty(string3)) {
                            return;
                        }
                        try {
                            super.callJs(string2 + "(" + new JSONObject(string3).toString() + ");");
                            return;
                        } catch (JSONException unused3) {
                            return;
                        }
                    }
                    return;
                }
                if (bundle2 == null) {
                    return;
                }
                int i3 = bundle2.getInt("id");
                String string4 = bundle2.getString("diyText");
                boolean containsKey = bundle2.containsKey("isDiy");
                int i16 = bundle2.getInt("voiceprintId", 0);
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("currentId", i3);
                    jSONObject4.put("diyText", string4);
                    jSONObject4.put("voiceprintId", i16);
                    if (containsKey) {
                        jSONObject4.put("isDiy", 1);
                        String string5 = bundle2.getString("tl");
                        if (!TextUtils.isEmpty(string5)) {
                            jSONObject4.put("tl", string5);
                        }
                        String string6 = bundle2.getString(ReportConstant.COSTREPORT_TRANS);
                        if (!TextUtils.isEmpty(string6)) {
                            jSONObject4.put(ReportConstant.COSTREPORT_TRANS, string6);
                        }
                        String string7 = bundle2.getString("bl");
                        if (!TextUtils.isEmpty(string7)) {
                            jSONObject4.put("bl", string7);
                        }
                        String string8 = bundle2.getString(TtmlNode.TAG_BR);
                        if (!TextUtils.isEmpty(string8)) {
                            jSONObject4.put(TtmlNode.TAG_BR, string8);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "query local bubble data: " + jSONObject4.toString());
                    }
                    jSONObject3.put("data", jSONObject4);
                    jSONObject3.put("result", 0);
                    try {
                        super.callJs(string2 + "(" + jSONObject3.toString() + ");");
                    } catch (JSONException e16) {
                        e = e16;
                        QLog.e(TAG, 1, "", e);
                    }
                } catch (JSONException e17) {
                    e = e17;
                }
            }
        }
    }
}
