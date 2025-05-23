package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class ColorRingJsPlugin extends VasWebviewJsPlugin {
    public static final String BusinessName = "colorRing";
    public static final String Method_ChangeTab = "changeTab";
    public static final String Method_GetCurrentId = "getCurrentId";
    public static final String Method_Play = "play";
    public static final String Method_SetUp = "setup";
    public static final String TAG = "ColorRingJsPlugin";
    public Activity mActivity;
    public BrowserAppInterface mBrowserApp;

    void changeTab(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, Method_ChangeTab);
        }
        SwiftBrowserMiscHandler swiftBrowserMiscHandler = (SwiftBrowserMiscHandler) super.getBrowserComponent(32);
        if (swiftBrowserMiscHandler != null) {
            Bundle bundle = new Bundle();
            bundle.putString("callbackId", str);
            swiftBrowserMiscHandler.C.dispatchMessage(swiftBrowserMiscHandler.C.obtainMessage(5, bundle));
        }
    }

    void getCurrentId(final String str, final String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, Method_GetCurrentId);
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final JSONObject jSONObject = new JSONObject();
                    BrowserAppInterface browserAppInterface = ColorRingJsPlugin.this.mBrowserApp;
                    if (browserAppInterface != null) {
                        EntityManager createEntityManager = browserAppInterface.getEntityManagerFactory(null).createEntityManager();
                        ExtensionInfo extensionInfo = (ExtensionInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) ExtensionInfo.class, ColorRingJsPlugin.this.mBrowserApp.getAccount());
                        createEntityManager.close();
                        jSONObject.put("result", 0);
                        JSONObject jSONObject2 = new JSONObject();
                        if (extensionInfo == null) {
                            jSONObject2.put("currentId", 0);
                        } else if (str.equals("colorring")) {
                            jSONObject2.put("currentId", extensionInfo.colorRingId);
                        } else if (str.equals("comering")) {
                            jSONObject2.put("currentId", extensionInfo.commingRingId);
                        }
                        jSONObject.put("data", jSONObject2);
                    }
                    ColorRingJsPlugin.this.mActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            ColorRingJsPlugin.this.callJs(str2, jSONObject.toString());
                        }
                    });
                } catch (JSONException e16) {
                    final String message = e16.getMessage();
                    ColorRingJsPlugin.this.mActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            ColorRingJsPlugin.this.callJsOnError(str2, message);
                        }
                    });
                }
            }
        }, 5, null, true);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return BusinessName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 2151677952L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jsonFromJSBridge;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest, url=" + str);
        }
        if (!BusinessName.equals(str2) || str == null || str3 == null) {
            return false;
        }
        try {
            jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (jsonFromJSBridge == null) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
        }
        String optString = jsonFromJSBridge.optString("callback");
        long optLong = jsonFromJSBridge.optLong("id");
        int optInt = jsonFromJSBridge.optInt("status");
        String optString2 = jsonFromJSBridge.optString("type", "comering");
        VasCommonReporter.getHistoryJsbFeature(getNameSpace()).setValue2(str3).report();
        if (Method_GetCurrentId.equals(str3)) {
            getCurrentId(optString2, optString);
        } else if ("play".equals(str3)) {
            play(optLong, optString2, optString);
        } else if (Method_SetUp.equals(str3)) {
            setup(optLong, optInt, optString2, optString);
        } else if (Method_ChangeTab.equals(str3)) {
            changeTab(optString);
        } else {
            throw new Exception("No Such Method:" + str3);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.mActivity = this.mRuntime.a();
        this.mBrowserApp = (BrowserAppInterface) this.mRuntime.b();
    }

    void play(long j3, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "play, id=" + j3);
        }
        SwiftBrowserMiscHandler swiftBrowserMiscHandler = (SwiftBrowserMiscHandler) super.getBrowserComponent(32);
        if (swiftBrowserMiscHandler != null) {
            Bundle bundle = new Bundle();
            bundle.putLong("id", j3);
            bundle.putString("callbackId", str2);
            bundle.putString("type", str);
            swiftBrowserMiscHandler.C.dispatchMessage(swiftBrowserMiscHandler.C.obtainMessage(3, bundle));
        }
    }

    void setup(long j3, int i3, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setup, id=" + j3);
        }
        SwiftBrowserMiscHandler swiftBrowserMiscHandler = (SwiftBrowserMiscHandler) super.getBrowserComponent(32);
        if (swiftBrowserMiscHandler != null) {
            Bundle bundle = new Bundle();
            bundle.putLong("id", j3);
            bundle.putInt("status", i3);
            bundle.putString("type", str);
            bundle.putString("callbackId", str2);
            swiftBrowserMiscHandler.C.dispatchMessage(swiftBrowserMiscHandler.C.obtainMessage(4, bundle));
        }
    }
}
