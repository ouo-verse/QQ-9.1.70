package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.action.RepeatRequestEvent;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class NativeFeatureJsPlugin extends BaseJsPlugin {
    private static final String TAG = "NativeFeatureJsPlugin";

    @JsEvent({"invokeNativePlugin"})
    public void invokeNativePlugin(RequestEvent requestEvent) {
        try {
            this.mMiniAppContext.performAction(RepeatRequestEvent.obtain(requestEvent, new JSONObject(requestEvent.jsonParams).optString("api_name", null)));
        } catch (Throwable th5) {
            QMLog.e(TAG, "invokeNativePlugin err", th5);
        }
    }

    @JsEvent({"canIUseApi"})
    public void nativeApiCanIUse(RequestEvent requestEvent) {
        try {
            String optString = new JSONObject(requestEvent.jsonParams).optString("api_name", null);
            JSONObject jSONObject = new JSONObject();
            IMiniAppContext iMiniAppContext = this.mMiniAppContext;
            boolean z16 = false;
            if (iMiniAppContext instanceof BaseRuntime) {
                IJsPluginEngine jsPluginEngine = ((BaseRuntime) iMiniAppContext).getJsPluginEngine();
                if (jsPluginEngine instanceof JsPluginEngine) {
                    z16 = ((JsPluginEngine) jsPluginEngine).checkJsPluginExists(optString);
                } else {
                    QMLog.e(TAG, "engine is not JsPluginEngine");
                }
            } else {
                QMLog.e(TAG, "miniapp context is not base runtime");
            }
            jSONObject.put("can_use", z16);
            requestEvent.ok(jSONObject);
        } catch (Throwable th5) {
            QMLog.e(TAG, "canIUseApi err", th5);
            requestEvent.fail("parameter invalidate," + th5.getMessage());
        }
    }
}
