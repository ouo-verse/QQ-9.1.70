package com.tencent.mobileqq.zplan.web.api.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.zootopia.webview.g;
import com.tencent.mobileqq.zplan.web.ApolloUrlInterceptor;
import com.tencent.mobileqq.zplan.web.api.IZPlanJsPlugin;
import com.tencent.mobileqq.zplan.web.c;
import com.tencent.mobileqq.zplan.web.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.zplan.meme.action.MODE;
import dl3.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import t74.e;

/* loaded from: classes34.dex */
public class ZPlanJsPluginImpl extends VasWebviewJsPlugin implements IZPlanJsPlugin {
    private static final String TAG = "[zplan]ApolloJsPlugin";
    protected ApolloUrlInterceptor mInterceptor;
    private String mInterceptorUrl;
    private boolean mNeedCreateInterceptor;
    private g zootopiaWebViewPlugin = new g(this);
    private e<com.tencent.mobileqq.zplan.web.e> mDispatcher = new e<>();
    private dl3.a avatarEditJsModule = new dl3.a(this);
    private b avatarRecordJsMode = new b(this);

    public ZPlanJsPluginImpl() {
        this.mDispatcher.d(this.avatarEditJsModule);
        this.mDispatcher.d(this.avatarRecordJsMode);
    }

    private void callbackError(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", 1);
            jSONObject.put("msg", str2);
            super.callJs(str + "&&" + str + "(" + jSONObject.toString() + ");");
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getMessage());
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "callbackId->" + str + " errorMsg: " + str2);
        }
    }

    private Object getResponseApolloAvatar(String str) {
        return null;
    }

    private Object getResponseRecordAvatar(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("https://zplan.qq.com/qq_zplan_record_avatar/")) {
            String replace = str.replace("https://zplan.qq.com/qq_zplan_record_avatar/", "");
            int lastIndexOf = replace.lastIndexOf("/");
            int i3 = lastIndexOf + 1;
            if (i3 >= replace.length()) {
                QLog.e(TAG, 1, "invalid mode path:" + replace);
                return null;
            }
            String substring = replace.substring(i3);
            c cVar = c.f336037a;
            MODE b16 = cVar.b(substring);
            String substring2 = replace.substring(0, lastIndexOf);
            QLog.d(TAG, 1, "getResponseRecordAvatar handleEvent path:" + substring2 + " modeStr:" + substring);
            File file = new File(substring2);
            if (!file.exists()) {
                QLog.e(TAG, 1, "path is not exist. path:" + substring2);
                return null;
            }
            try {
                WebResourceResponse webResourceResponse = new WebResourceResponse(cVar.a(b16), "utf-8", new FileInputStream(file));
                f.a(webResourceResponse);
                return webResourceResponse;
            } catch (FileNotFoundException e16) {
                QLog.e(TAG, 1, "getResponseRecordAvatar exception ", e16);
            }
        }
        return null;
    }

    public void createInterceptor() {
        String str = this.mInterceptorUrl;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mInterceptor = ApolloUrlInterceptor.k(true, str);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "apollo_client onApolloJsCreate ApolloWebDataHandler.isInstanceCreated():true");
        }
    }

    public String getAbsoluteUrl() {
        CustomWebView e16;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (e16 = bVar.e()) != null) {
            return e16.getUrl();
        }
        return "";
    }

    public Activity getActivity() {
        Activity a16 = this.mRuntime.a();
        if (a16 == null || a16.isFinishing() || this.isDestroy) {
            return null;
        }
        return a16;
    }

    public ApolloUrlInterceptor getInterceptor() {
        return this.mInterceptor;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "zplan";
    }

    @Override // com.tencent.mobileqq.zplan.web.api.IZPlanJsPlugin
    public JSONObject getThunderJson(boolean z16) {
        JSONObject jSONObject;
        ApolloUrlInterceptor interceptor = getInterceptor();
        JSONObject jSONObject2 = null;
        if (interceptor == null || interceptor.o() == null) {
            return null;
        }
        if (z16 && !interceptor.B()) {
            QLog.d(TAG, 2, "apollo_client_apolloWebStatistics checkRunSuccess fail");
            return null;
        }
        com.tencent.mobileqq.zplan.web.b o16 = interceptor.o();
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e16) {
            e = e16;
        }
        try {
            jSONObject.put("thunderCacheType", o16.f336033i);
            jSONObject.put("webViewReadyTime", o16.f336034j);
            jSONObject.put("sessionStartTime", o16.f336031g);
            jSONObject.put("sessionEndTime", o16.f336032h);
            jSONObject.put("SSOStartTime", o16.f336025a);
            jSONObject.put("SSOEndTime", o16.f336026b);
            jSONObject.put("SSOCallJSTime", o16.f336028d);
            jSONObject.put("loadUrlTime", o16.f336035k);
            jSONObject.put("SSORequestTime", o16.f336027c);
            jSONObject.put("readLocalFileCost", o16.f336029e);
            jSONObject.put("verifyLocalFileCost", o16.f336030f);
            jSONObject.put("cgiStatistics", o16.f336036l);
            return jSONObject;
        } catch (JSONException e17) {
            e = e17;
            jSONObject2 = jSONObject;
            QLog.e(TAG, 1, "apollo_client_apolloWebStatistics getThunderJson error:", e);
            return jSONObject2;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 40L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (32 == j3) {
            if (this.mNeedCreateInterceptor && this.mInterceptor == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "apollo_client handleEvent reinited ApolloUrlInterceptor,url:" + str);
                }
                this.mInterceptor = ApolloUrlInterceptor.k(true, str);
                this.mNeedCreateInterceptor = false;
            }
            ApolloUrlInterceptor apolloUrlInterceptor = this.mInterceptor;
            if (apolloUrlInterceptor != null) {
                apolloUrlInterceptor.G(this.mRuntime.e());
                return this.mInterceptor.C(str);
            }
        }
        return super.handleEvent(str, j3, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jsonFromJSBridge;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (str == null || !"zplan".equals(str2) || str3 == null) {
            return false;
        }
        if (this.zootopiaWebViewPlugin.o(jsBridgeListener, str, str2, str3, strArr) || (jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str)) == null) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
        }
        String optString = jsonFromJSBridge.optString("callback");
        if (optString == null) {
            callbackError(optString, "need callbackId");
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "json:" + jsonFromJSBridge);
        }
        Activity activity = getActivity();
        if (activity != null && !this.isDestroy && !activity.isFinishing()) {
            com.tencent.mobileqq.zplan.web.e eVar = new com.tencent.mobileqq.zplan.web.e();
            eVar.f336045a = jsonFromJSBridge;
            eVar.f336046b = optString;
            eVar.f336047c = activity;
            eVar.f336048d = str3;
            eVar.f336049e = getAbsoluteUrl();
            this.mDispatcher.a(str3, eVar);
            return true;
        }
        callbackError(optString, HardCodeUtil.qqStr(R.string.jiu));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityReady() {
        super.onActivityReady();
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.a() == null) {
            return;
        }
        this.mInterceptorUrl = WebViewPluginEngine.o(this.mRuntime.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "apollo_client onApolloJsCreate");
        }
        createInterceptor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        ApolloUrlInterceptor apolloUrlInterceptor = this.mInterceptor;
        if (apolloUrlInterceptor != null) {
            apolloUrlInterceptor.l();
            this.mInterceptor = null;
        }
        g gVar = this.zootopiaWebViewPlugin;
        if (gVar != null) {
            gVar.onDestroy();
        }
    }

    public void sendEventToZPlanJs(String str, String str2) {
        this.zootopiaWebViewPlugin.J(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public Object handleEvent(String str, long j3) {
        if (j3 == 8) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, " handleEvent url:" + str);
                }
                Object obj = null;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                if (str.startsWith("https://cmshow.qq.com/qq_cms_ueavatar/")) {
                    obj = getResponseApolloAvatar(str);
                } else if (str.startsWith("https://zplan.qq.com/qq_zplan_record_avatar/")) {
                    obj = getResponseRecordAvatar(str);
                }
                if (obj != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 1, "handleEvent response, url:" + str);
                    }
                    return obj;
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "handleEvent intercept by apolloClient error -> " + e16.getMessage());
            }
        }
        return super.handleEvent(str, j3);
    }
}
