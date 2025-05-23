package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class HippyJsPlugin extends VasWebviewJsPlugin {
    private static final String KEY_ERROR_MESSAGE = "errMsg";
    private static final String KEY_NEW_VERSION = "newVersion";
    private static final String KEY_RESULT_CODE = "retCode";
    private static final String MESSAGE_PARAMS_ERROR = "Parameters error";
    private static final String METHOD_OPEN_DEBUG_HIPPY = "openDebugHippy";
    private static final String METHOD_OPEN_HIPPY = "openHippy";
    private static final String METHOD_OPEN_SSR_HIPPY = "openSSRHippy";
    private static final String METHOD_PRELOAD_HIPPY = "preloadHippy";
    private static final String METHOD_REMOVE_PRELOAD = "removePreload";
    private static final String METHOD_UPDATE_JS_BUNDLE = "updateHippyBundle";
    private static final String NAME_SPACE = "hippy";
    private static final String TAG = "HippyJsPlugin";

    private void callbackResult(String str, int i3, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", i3);
            jSONObject.put("errMsg", str2);
            callJs(str, jSONObject.toString());
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "callbackResult error:", e16);
        }
    }

    private void openDebugHippy(JSONObject jSONObject, String str) {
        callbackResult(str, new OpenHippyInfo(jSONObject).enableOpenDebugHippy().openHippy(this.mRuntime.a()) ? 0 : -1, "");
    }

    private void preloadHippy(JSONObject jSONObject, String str) {
        OpenHippyInfo openHippyInfo = new OpenHippyInfo(jSONObject);
        if (openHippyInfo.preloadType != TabPreloadItem.PreloadType.NO_PRELOAD && openHippyInfo.checkData()) {
            ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).preloadHippyPage(openHippyInfo);
            callbackResult(str, 0, "");
        } else {
            callbackResult(str, -1, MESSAGE_PARAMS_ERROR);
        }
    }

    private void removeHippy(JSONObject jSONObject, String str) {
        OpenHippyInfo openHippyInfo = new OpenHippyInfo(jSONObject);
        openHippyInfo.from = "h5ApiRemove";
        if (!openHippyInfo.checkData()) {
            callbackResult(str, -1, MESSAGE_PARAMS_ERROR);
        } else {
            ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).destroyPreloadHippy(openHippyInfo);
            callbackResult(str, 0, "");
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "hippy";
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
        if (!"hippy".equals(str2)) {
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
        if (METHOD_UPDATE_JS_BUNDLE.equals(str3)) {
            updateHippyBundle(jsonFromJSBridge, optString);
        } else if (!METHOD_OPEN_HIPPY.equals(str3) && !METHOD_OPEN_SSR_HIPPY.equals(str3)) {
            if (METHOD_OPEN_DEBUG_HIPPY.equals(str3)) {
                openDebugHippy(jsonFromJSBridge, optString);
            } else if (METHOD_PRELOAD_HIPPY.equals(str3)) {
                preloadHippy(jsonFromJSBridge, optString);
            } else if (METHOD_REMOVE_PRELOAD.equals(str3)) {
                removeHippy(jsonFromJSBridge, optString);
            }
        } else {
            openHippy(jsonFromJSBridge, optString);
        }
        return true;
    }

    protected void onJsUpdateCompleted(String str, int i3, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", i3);
            if (i3 == 1) {
                jSONObject.put(KEY_NEW_VERSION, ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(str));
            } else if (i3 == -1) {
                jSONObject.put("errMsg", str2);
            }
            callJs(str3, jSONObject.toString());
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "onJsUpdateCompleted error:" + th5);
        }
    }

    protected void openHippy(JSONObject jSONObject, String str) {
        callbackResult(str, new OpenHippyInfo(jSONObject).openHippy(this.mRuntime.a()) ? 0 : -1, "");
    }

    protected void updateHippyBundle(JSONObject jSONObject, final String str) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("bundleName");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        QLog.i(TAG, 1, "#updateHippyBundle: bundleName=" + optString);
        ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).commonUpdateJsBundle(optString, "updateApiH5", new IUpdateListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.HippyJsPlugin.1
            @Override // com.tencent.hippy.qq.api.IUpdateListener
            public void onUpdateFailed(int i3, int i16, String str2, String str3, HashMap<String, String> hashMap) {
                QLog.i(HippyJsPlugin.TAG, 1, "#updateHippyBundle: failed, bundleName=" + str3 + ", retCode=" + i16 + ", errMsg=" + str2);
                if (i16 == 101) {
                    HippyJsPlugin.this.onJsUpdateCompleted(str3, 1, null, str);
                } else if (i16 == 1) {
                    HippyJsPlugin.this.onJsUpdateCompleted(str3, 0, null, str);
                } else {
                    HippyJsPlugin.this.onJsUpdateCompleted(str3, -1, str2, str);
                }
            }

            @Override // com.tencent.hippy.qq.api.IUpdateListener
            public void onUpdateSuccess(int i3, String str2, HashMap<String, String> hashMap) {
                QLog.i(HippyJsPlugin.TAG, 1, "#updateHippyBundle: success, bundleName=" + str2);
                HippyJsPlugin.this.onJsUpdateCompleted(str2, 1, null, str);
            }
        });
    }
}
