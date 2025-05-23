package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.minigame.manager.JsApiUpdateManager;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter;
import com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(lazyLoad = false)
/* loaded from: classes23.dex */
public class UpdateManagerJsPlugin extends BaseJsPlugin {
    public static final String NATIVE_EVENT_NAME_GET_UPDATE_MANAGER = "getUpdateManager";
    public static final String NATIVE_EVENT_NAME_ON_UPDATE_CHECK_RESULT = "onUpdateCheckResult";
    public static final String NATIVE_EVENT_NAME_ON_UPDATE_DOWNLOAD_RESULT = "onUpdateDownloadResult";
    public static final String NATIVE_EVENT_NAME_UPDATE_APP = "updateApp";
    private static final String TAG = "UpdateManagerJsPlugin";
    private IJsService mJsService;
    private AppRuntimeEventCenter.RuntimeStateObserver mObserver;
    private Boolean mHasUpdateCache = null;
    private Boolean mUpdateResultCache = null;

    private void registerUpdateObserver() {
        BaseRuntimeLoader queryAppRunTimeLoader = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(this.mMiniAppInfo);
        if (queryAppRunTimeLoader == null) {
            return;
        }
        AppRuntimeEventCenter.RuntimeStateObserver runtimeStateObserver = new AppRuntimeEventCenter.RuntimeStateObserver() { // from class: com.tencent.qqmini.minigame.plugins.UpdateManagerJsPlugin.1
            @Override // com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.RuntimeStateObserver
            public void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage miniAppStateMessage) {
                String str;
                int i3 = miniAppStateMessage.what;
                try {
                    if (i3 != 2054) {
                        if (i3 == 2055) {
                            Boolean bool = (Boolean) miniAppStateMessage.obj;
                            QMLog.i(UpdateManagerJsPlugin.TAG, "downloadResult success:" + bool + ", currentAppInfo:" + ((BaseJsPlugin) UpdateManagerJsPlugin.this).mMiniAppInfo);
                            if (UpdateManagerJsPlugin.this.mJsService == null) {
                                UpdateManagerJsPlugin.this.mUpdateResultCache = bool;
                                return;
                            }
                            JSONObject jSONObject = new JSONObject();
                            if (bool.booleanValue()) {
                                str = "success";
                            } else {
                                str = "failed";
                            }
                            jSONObject.put("updateResult", str);
                            UpdateManagerJsPlugin.this.mJsService.evaluateSubscribeJS(UpdateManagerJsPlugin.NATIVE_EVENT_NAME_ON_UPDATE_DOWNLOAD_RESULT, jSONObject.toString(), -1);
                        }
                    } else {
                        Boolean bool2 = (Boolean) miniAppStateMessage.obj;
                        QMLog.i(UpdateManagerJsPlugin.TAG, "checkResult hasUpdate:" + bool2 + ", currentAppInfo:" + ((BaseJsPlugin) UpdateManagerJsPlugin.this).mMiniAppInfo);
                        if (UpdateManagerJsPlugin.this.mJsService == null) {
                            UpdateManagerJsPlugin.this.mHasUpdateCache = bool2;
                        } else {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("hasUpdate", bool2);
                            UpdateManagerJsPlugin.this.mJsService.evaluateSubscribeJS(UpdateManagerJsPlugin.NATIVE_EVENT_NAME_ON_UPDATE_CHECK_RESULT, jSONObject2.toString(), -1);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        };
        this.mObserver = runtimeStateObserver;
        queryAppRunTimeLoader.addRuntimeStateObserver(runtimeStateObserver);
        QMLog.d(TAG, "addAppEventObserver " + this.mObserver);
    }

    @JsEvent({NATIVE_EVENT_NAME_GET_UPDATE_MANAGER})
    public void getUpdateManager(RequestEvent requestEvent) {
        boolean z16;
        boolean z17;
        QMLog.d(TAG, "handleNativeRequest for " + requestEvent.event);
        this.mJsService = requestEvent.jsService;
        requestEvent.ok();
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleUpdateCheckResult() called with:  hasUpdate = [");
            Boolean bool = this.mHasUpdateCache;
            if (bool != null) {
                z16 = bool.booleanValue();
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append("]");
            QMLog.d(TAG, sb5.toString());
            JSONObject jSONObject = new JSONObject();
            Boolean bool2 = this.mHasUpdateCache;
            if (bool2 != null) {
                z17 = bool2.booleanValue();
            } else {
                z17 = false;
            }
            jSONObject.put("hasUpdate", z17);
            requestEvent.jsService.evaluateSubscribeJS(NATIVE_EVENT_NAME_ON_UPDATE_CHECK_RESULT, jSONObject.toString(), 0);
        } catch (JSONException e16) {
            QMLog.e(TAG, "handleNativeRequest", e16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
        registerUpdateObserver();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        AppRuntimeEventCenter.RuntimeStateObserver runtimeStateObserver;
        super.onDestroy();
        BaseRuntimeLoader queryAppRunTimeLoader = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(this.mMiniAppInfo);
        if (queryAppRunTimeLoader != null && (runtimeStateObserver = this.mObserver) != null) {
            queryAppRunTimeLoader.removeRuntimeStateObserver(runtimeStateObserver);
        }
    }

    @JsEvent({NATIVE_EVENT_NAME_ON_UPDATE_CHECK_RESULT})
    public void onUpdateCheckResult(RequestEvent requestEvent) {
        QMLog.w(TAG, "handleNativeRequest " + requestEvent.event + " should not send from JS");
    }

    @JsEvent({NATIVE_EVENT_NAME_ON_UPDATE_DOWNLOAD_RESULT})
    public void onUpdateDownloadResult(RequestEvent requestEvent) {
        QMLog.w(TAG, "handleNativeRequest " + requestEvent.event + " should not send from JS");
    }

    @JsEvent({"updateApp"})
    public void updateApp(RequestEvent requestEvent) {
        JsApiUpdateManager.handleUpdateApp();
        QMLog.d(TAG, "handleNativeRequest " + requestEvent.event);
    }
}
