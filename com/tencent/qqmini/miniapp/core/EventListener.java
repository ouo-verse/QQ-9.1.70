package com.tencent.qqmini.miniapp.core;

import android.app.Activity;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.miniapp.core.page.PageEventListener;
import com.tencent.qqmini.miniapp.core.service.AppBrandRemoteService;
import com.tencent.qqmini.miniapp.core.service.IAppBrandService;
import com.tencent.qqmini.miniapp.core.service.ServiceEventListener;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.MiniAppLauncher;
import com.tencent.qqmini.sdk.utils.MiniLog;
import com.tencent.qqmini.sdk.widget.MiniToast;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class EventListener implements PageEventListener, ServiceEventListener {
    public static final String APPLAUNCH = "appLaunch";
    public static final String EXIT_MINIPROGRAM = "exitMiniProgram";
    public static final String FLUTTER_LAUNCH = "flutter_launch";
    public static final String GET_GUILD_ROLES = "getGuildRoles";
    public static final String KEY_APPID = "appId";
    public static final String KEY_DELTA = "delta";
    public static final String KEY_SCENE = "scene";
    public static final String KEY_URL = "url";
    public static final String NAVIGATE_BACK = "navigateBack";
    public static final String NAVIGATE_TO = "navigateTo";
    public static final String ON_UPDATE_STATUS_CHANGE = "onUpdateStatusChange";
    public static final String REDIRECT_TO = "redirectTo";
    public static final String RELAUNCH = "reLaunch";
    public static final String SWITCH_TAB = "switchTab";
    private static final String TAG = "EventListener";
    public static final String UPDATE_APP = "updateApp";
    public static final long VERSION_NOT_EXIST = -101300004;
    public static final long VERSION_NOT_FOUND = -101600008;
    protected BaseAppBrandRuntime mRuntime;
    private MiniAppInfo newVersionMiniAppInfo;
    protected boolean mWeixinJSBridgeFinished = false;
    private boolean isFirstDomReady = false;
    private boolean isForbiddenShowing = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements MiniAppProxy.GetUserRoleGroupListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f346219a;

        a(RequestEvent requestEvent) {
            this.f346219a = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.GetUserRoleGroupListener
        public void onResult(boolean z16, JSONObject jSONObject) {
            if (z16) {
                this.f346219a.ok(jSONObject);
            } else {
                this.f346219a.fail(jSONObject, "fail");
            }
        }
    }

    public EventListener(BaseAppBrandRuntime baseAppBrandRuntime) {
        this.mRuntime = baseAppBrandRuntime;
    }

    private void checkForbiddenStatus() {
        MiniAppInfo miniAppInfo;
        BaseAppBrandRuntime baseAppBrandRuntime = this.mRuntime;
        if (baseAppBrandRuntime != null) {
            miniAppInfo = baseAppBrandRuntime.getMiniAppInfo();
        } else {
            miniAppInfo = null;
        }
        if (miniAppInfo == null) {
            QMLog.i(TAG, "checkUpdate -- miniapp is null, return.");
        } else if (miniAppInfo.isForbidden()) {
            showForbiddenToast();
        }
    }

    private void checkUpdate() {
        final MiniAppInfo miniAppInfo;
        BaseAppBrandRuntime baseAppBrandRuntime = this.mRuntime;
        if (baseAppBrandRuntime != null) {
            miniAppInfo = baseAppBrandRuntime.getMiniAppInfo();
        } else {
            miniAppInfo = null;
        }
        if (miniAppInfo == null) {
            QMLog.i(TAG, "checkUpdate -- miniapp is null, return.");
            return;
        }
        if (miniAppInfo.verType != 3) {
            QMLog.i(TAG, "checkUpdate -- miniapp is not online, return.");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("state", "noUpdate");
                this.mRuntime.appBrandService.evaluateSubscribeJS(ON_UPDATE_STATUS_CHANGE, jSONObject.toString(), 0);
                return;
            } catch (Exception e16) {
                QMLog.e(TAG, "updateJSONObject error." + e16);
                return;
            }
        }
        ThreadManager.executeOnNetworkIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.EventListener.1
            @Override // java.lang.Runnable
            public void run() {
                EventListener.this.doUpdateMiniAppInfo(miniAppInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDownloadNewVersion(final MiniAppInfo miniAppInfo) {
        ApkgManager.getInstance().getApkgInfoByConfig(miniAppInfo, false, new ApkgManager.OnInitApkgListener() { // from class: com.tencent.qqmini.miniapp.core.EventListener.3
            @Override // com.tencent.qqmini.sdk.manager.ApkgManager.OnInitApkgListener
            public void onInitApkgInfo(int i3, ApkgInfo apkgInfo, String str) {
                QMLog.i(EventListener.TAG, "getApkgInfoByConfig end. result=" + i3 + "; msg : " + str);
                if (i3 == 0 && apkgInfo != null) {
                    ((MiniAppFileManager) EventListener.this.mRuntime.getManager(MiniAppFileManager.class)).initFileManager(apkgInfo, false);
                    QMLog.i(EventListener.TAG, "initApkgByConfig appid=" + apkgInfo.appId + " appName=" + apkgInfo.apkgName);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("state", "updateready");
                        EventListener.this.mRuntime.appBrandService.evaluateSubscribeJS(EventListener.ON_UPDATE_STATUS_CHANGE, jSONObject.toString(), 0);
                    } catch (Throwable th5) {
                        QMLog.e(EventListener.TAG, "updateJSONObject error." + th5);
                    }
                    EventListener.this.newVersionMiniAppInfo = miniAppInfo;
                    EventListener.this.newVersionMiniAppInfo.launchParam.forceReload = 2;
                    EventListener.this.newVersionMiniAppInfo.launchParam.tempState = 0;
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("state", "updatefailed");
                    EventListener.this.mRuntime.appBrandService.evaluateSubscribeJS(EventListener.ON_UPDATE_STATUS_CHANGE, jSONObject2.toString(), 0);
                } catch (Throwable th6) {
                    QMLog.e(EventListener.TAG, "updateJSONObject error." + th6);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUpdateMiniAppInfo(final MiniAppInfo miniAppInfo) {
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getAppInfoById(miniAppInfo.appId, "", "", new AsyncResult() { // from class: com.tencent.qqmini.miniapp.core.EventListener.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                MiniAppInfo miniAppInfo2;
                boolean z17;
                QMLog.i(EventListener.TAG, "getAppInfoById onCmdListener() called with: isSuc = [" + z16 + "], ret = [" + jSONObject + "]");
                if (jSONObject != null && z16) {
                    miniAppInfo2 = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
                } else {
                    miniAppInfo2 = null;
                }
                if (miniAppInfo2 != null) {
                    z17 = AppBrandUtil.needUpdate(miniAppInfo, miniAppInfo2);
                } else {
                    QMLog.e(EventListener.TAG, "onCmdListener newMiniAppInfo = null");
                    z17 = false;
                }
                try {
                    QMLog.i(EventListener.TAG, "checkUpdate  needUpdate=" + z17);
                    JSONObject jSONObject2 = new JSONObject();
                    if (z17) {
                        jSONObject2.put("state", IXWebBroadcastListener.STAGE_PROGRESSED);
                    } else {
                        jSONObject2.put("state", "noUpdate");
                    }
                    EventListener.this.mRuntime.appBrandService.evaluateSubscribeJS(EventListener.ON_UPDATE_STATUS_CHANGE, jSONObject2.toString(), 0);
                } catch (Exception e16) {
                    QMLog.e(EventListener.TAG, "updateJSONObject error." + e16);
                }
                if (z17) {
                    EventListener.this.doDownloadNewVersion(miniAppInfo2);
                }
                if (!z16 && jSONObject != null) {
                    long optLong = jSONObject.optLong("retCode");
                    QMLog.i(EventListener.TAG, "doUpdateMiniAppInfo not success retCode: " + optLong);
                    if (optLong == EventListener.VERSION_NOT_EXIST || optLong == EventListener.VERSION_NOT_FOUND) {
                        EventListener.this.showForbiddenToast();
                    }
                }
            }
        });
    }

    private MiniReportManager.MiniAppLaunchState getState() {
        return MiniReportManager.getLaunchState(this.mRuntime.getMiniAppInfo().appId);
    }

    private String handleGertGuildRoles(String str, String str2, RequestEvent requestEvent) throws JSONException {
        String optString = new JSONObject(str2).optString("guildOpenID", "");
        if (!TextUtils.isEmpty(optString)) {
            ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getRoleGroupInfoList(optString, new a(requestEvent));
        }
        return ApiUtil.wrapCallbackOk(str, null).toString();
    }

    private String handleNavigateBack(String str, String str2, final IAppBrandPageContainer iAppBrandPageContainer, final RequestEvent requestEvent) throws JSONException {
        final int optInt = new JSONObject(str2).optInt(KEY_DELTA, 0);
        if (optInt > 0) {
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.EventListener.9
                @Override // java.lang.Runnable
                public void run() {
                    iAppBrandPageContainer.navigateBack(optInt, requestEvent.callbackId);
                    EventListener.this.recordEndEventTime(32);
                    requestEvent.ok();
                }
            });
        }
        return ApiUtil.wrapCallbackOk(str, null).toString();
    }

    private String handleNavigateTo(String str, String str2, final IAppBrandPageContainer iAppBrandPageContainer, ApkgInfo apkgInfo, final RequestEvent requestEvent) throws JSONException {
        boolean z16;
        final String optString = new JSONObject(str2).optString("url", "");
        if (!TextUtils.isEmpty(optString)) {
            if (apkgInfo != null && apkgInfo.isTabBarPage(optString)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return ApiUtil.wrapCallbackFail(str, null).toString();
            }
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.EventListener.10
                @Override // java.lang.Runnable
                public void run() {
                    iAppBrandPageContainer.navigateTo(optString, requestEvent.callbackId);
                    EventListener.this.recordEndEventTime(31);
                    requestEvent.ok();
                }
            });
        }
        return ApiUtil.wrapCallbackOk(str, null).toString();
    }

    private String handleRedirectTo(String str, String str2, final IAppBrandPageContainer iAppBrandPageContainer, ApkgInfo apkgInfo, final RequestEvent requestEvent) throws JSONException {
        boolean z16;
        final String optString = new JSONObject(str2).optString("url", "");
        if (!TextUtils.isEmpty(optString)) {
            if (apkgInfo != null && apkgInfo.isTabBarPage(optString)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return requestEvent.fail();
            }
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.EventListener.11
                @Override // java.lang.Runnable
                public void run() {
                    iAppBrandPageContainer.redirectTo(optString, requestEvent.callbackId);
                    EventListener.this.recordEndEventTime(30);
                    requestEvent.ok();
                }
            });
        }
        return ApiUtil.wrapCallbackOk(str, null).toString();
    }

    private String handleRelaunch(String str, String str2, final RequestEvent requestEvent) throws JSONException {
        final String optString = new JSONObject(str2).optString("url", "");
        if (!TextUtils.isEmpty(optString)) {
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.EventListener.7
                @Override // java.lang.Runnable
                public void run() {
                    EventListener.this.reload(optString);
                    EventListener.this.recordEndEventTime(34);
                    requestEvent.ok();
                }
            });
        }
        return ApiUtil.wrapCallbackOk(str, null).toString();
    }

    private String handleSwitchTab(String str, String str2, final IAppBrandPageContainer iAppBrandPageContainer, final RequestEvent requestEvent) throws JSONException {
        final String optString = new JSONObject(str2).optString("url", "");
        if (!TextUtils.isEmpty(optString)) {
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.EventListener.8
                @Override // java.lang.Runnable
                public void run() {
                    iAppBrandPageContainer.switchTab(optString);
                    EventListener.this.recordEndEventTime(33);
                    requestEvent.ok();
                }
            });
        }
        return ApiUtil.wrapCallbackOk(str, null).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showForbiddenToast$0() {
        Activity attachActivity = this.mRuntime.getAttachActivity();
        if (attachActivity != null && !attachActivity.isFinishing()) {
            MiniToast.makeText(attachActivity, 0, R.string.mini_sdk_dangrous_person_tip, 1).show();
            attachActivity.finish();
        }
    }

    public static void recordAppLaunchTime(String str, int i3) {
        MiniReportManager.getLaunchState(str).eventTime.put(Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordEndEventTime(int i3) {
        MiniReportManager.MiniAppLaunchState state = getState();
        if (state != null) {
            state.eventTime.put(Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
        }
    }

    private void recordEventTime(String str) {
        MiniReportManager.MiniAppLaunchState state = getState();
        if (state != null) {
            if ("redirectTo".equals(str)) {
                state.eventTime.put(41, Long.valueOf(System.currentTimeMillis()));
                return;
            }
            if ("navigateTo".equals(str)) {
                state.eventTime.put(42, Long.valueOf(System.currentTimeMillis()));
                return;
            }
            if ("navigateBack".equals(str)) {
                state.eventTime.put(43, Long.valueOf(System.currentTimeMillis()));
            } else if ("switchTab".equals(str)) {
                state.eventTime.put(44, Long.valueOf(System.currentTimeMillis()));
            } else if ("reLaunch".equals(str)) {
                state.eventTime.put(45, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showForbiddenToast() {
        if (this.isForbiddenShowing) {
            return;
        }
        this.isForbiddenShowing = true;
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.b
            @Override // java.lang.Runnable
            public final void run() {
                EventListener.this.lambda$showForbiddenToast$0();
            }
        });
    }

    public String interruptOnServiceNativeRequest(String str, String str2, int i3) {
        return null;
    }

    public boolean isFirstDomReady() {
        return this.isFirstDomReady;
    }

    public void moveAppBrandToBack() {
        if (this.mRuntime.getAttachActivity() != null) {
            QMLog.d(TAG, "moveAppBrandToBack. | " + this);
            if (!this.mRuntime.getAttachActivity().moveTaskToBack(false)) {
                QMLog.e(TAG, "moveTaskToBack failed, finish the activity.");
                this.mRuntime.getAttachActivity().finish();
            }
        }
    }

    @Override // com.tencent.qqmini.miniapp.core.page.PageEventListener
    public void onAppRoute(String str, String str2, int i3) {
        this.mRuntime.appBrandService.evaluateSubscribeJS("onAppRoute", AppBrandUtil.getPageLoadInfo(str2, str, this.mRuntime.getMiniAppInfo()).toString(), i3);
    }

    @Override // com.tencent.qqmini.miniapp.core.page.PageEventListener
    public void onAppRouteDone(String str, String str2, int i3) {
        this.mRuntime.appBrandService.evaluateSubscribeJS("onAppRouteDone", AppBrandUtil.getPageLoadInfo(str2, str, this.mRuntime.getMiniAppInfo()).toString(), i3);
    }

    @Override // com.tencent.qqmini.miniapp.core.service.ServiceEventListener
    public void onServiceEvent(String str, String str2, int[] iArr) {
        if ("custom_event_onAppRouteDone".equals(str)) {
            this.mRuntime.performAction(AppStateEvent.obtain(10));
        }
        IAppBrandPageContainer iAppBrandPageContainer = this.mRuntime.pageContainer;
        if (iAppBrandPageContainer != null) {
            iAppBrandPageContainer.dispatchEventToWebView(str, str2, iArr);
        }
    }

    @Override // com.tencent.qqmini.miniapp.core.service.ServiceEventListener
    public String onServiceNativeRequest(final String str, final String str2, int i3) {
        try {
            recordEventTime(str);
        } catch (Exception e16) {
            QMLog.e(TAG, "onServiceNativeRequest recordEventTime Error." + e16.getMessage());
        }
        try {
            if ("initWeixinJSBridgeFinish".equals(str)) {
                this.mWeixinJSBridgeFinished = true;
                QMLog.i(TAG, "WeixinJSBridge finished.");
                return ApiUtil.wrapCallbackOk(str, null).toString();
            }
        } catch (NoSuchMethodError e17) {
            QMLog.e(TAG, "onServiceNativeRequest Error." + e17.getMessage());
        } catch (Throwable th5) {
            QMLog.e(TAG, "onServiceNativeRequest Error." + th5.getMessage());
        }
        BaseAppBrandRuntime baseAppBrandRuntime = this.mRuntime;
        IAppBrandService iAppBrandService = baseAppBrandRuntime.appBrandService;
        final IAppBrandPageContainer iAppBrandPageContainer = baseAppBrandRuntime.pageContainer;
        JsPluginEngine jsPluginEngine = baseAppBrandRuntime.jsPluginEngine;
        ApkgInfo apkgInfo = baseAppBrandRuntime.mApkgInfo;
        final RequestEvent build = new RequestEvent.Builder().setEvent(str).setJsonParams(str2).setCallbackId(i3).setJsService(iAppBrandService).build();
        String interruptOnServiceNativeRequest = interruptOnServiceNativeRequest(str, str2, i3);
        if (interruptOnServiceNativeRequest != null) {
            return interruptOnServiceNativeRequest;
        }
        try {
            if ("redirectTo".equals(str)) {
                return handleRedirectTo(str, str2, iAppBrandPageContainer, apkgInfo, build);
            }
            if ("navigateTo".equals(str)) {
                return handleNavigateTo(str, str2, iAppBrandPageContainer, apkgInfo, build);
            }
            if ("navigateBack".equals(str)) {
                return handleNavigateBack(str, str2, iAppBrandPageContainer, build);
            }
            if ("switchTab".equals(str)) {
                return handleSwitchTab(str, str2, iAppBrandPageContainer, build);
            }
            if ("reLaunch".equals(str)) {
                return handleRelaunch(str, str2, build);
            }
            if ("exitMiniProgram".equals(str)) {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.EventListener.4
                    @Override // java.lang.Runnable
                    public void run() {
                        EventListener.this.moveAppBrandToBack();
                    }
                });
            } else if ("updateApp".equals(str)) {
                if (this.newVersionMiniAppInfo != null) {
                    AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.EventListener.5
                        @Override // java.lang.Runnable
                        public void run() {
                            EventListener.recordAppLaunchTime(EventListener.this.newVersionMiniAppInfo.appId, 46);
                            MiniAppLauncher.launchMiniApp(EventListener.this.mRuntime.getAttachActivity(), EventListener.this.newVersionMiniAppInfo, (Bundle) null, (ResultReceiver) null);
                        }
                    });
                }
            } else if (FLUTTER_LAUNCH.equals(str)) {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.EventListener.6
                    @Override // java.lang.Runnable
                    public void run() {
                        iAppBrandPageContainer.dispatchEventToWebView(str, str2, null);
                        build.ok();
                    }
                });
            } else if (GET_GUILD_ROLES.equals(str)) {
                handleGertGuildRoles(str, str2, build);
            }
            if (jsPluginEngine == null) {
                return "";
            }
            return jsPluginEngine.handleNativeRequest(str, str2, iAppBrandService, i3, 0);
        } catch (Throwable th6) {
            QMLog.e(TAG, "", th6);
            return "";
        }
    }

    @Override // com.tencent.qqmini.miniapp.core.page.PageEventListener
    public void onWebViewEvent(String str, String str2, int i3) {
        if (this.mRuntime.appBrandService == null) {
            return;
        }
        if (QMLog.isColorLevel() && !MiniLog.isHighFrequencyEventLog(str)) {
            QMLog.d(TAG, "EventListener onWebViewEvent eventName=" + str + ",pageWebviewId=" + i3);
        }
        if (!this.isFirstDomReady) {
            checkUpdate();
        }
        this.isFirstDomReady = true;
        this.mRuntime.appBrandService.evaluateSubscribeJS(str, str2, i3);
    }

    @Override // com.tencent.qqmini.miniapp.core.page.PageEventListener
    public String onWebViewNativeRequest(String str, String str2, IJsService iJsService, int i3, int i16) {
        if ("initWeixinJSBridgeFinish".equals(str)) {
            QMLog.d(TAG, "onWebViewNativeRequest eventName=" + str + ",callbackId=" + i3);
            return "";
        }
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "EventListener onWebViewNativeRequest eventName=" + str + ",callbackId=" + i3 + "  (" + iJsService + ")");
        }
        if (str.equals(com.tencent.luggage.wxa.id.b.NAME)) {
            IAppBrandService iAppBrandService = this.mRuntime.appBrandService;
            if (iAppBrandService instanceof AppBrandRemoteService) {
                ((AppBrandRemoteService) iAppBrandService).sendDomEvent(str2, i3);
                return "";
            }
        }
        JsPluginEngine jsPluginEngine = this.mRuntime.jsPluginEngine;
        if (jsPluginEngine == null) {
            return "";
        }
        return jsPluginEngine.handleNativeRequest(str, str2, iJsService, i3, i16);
    }

    @Override // com.tencent.qqmini.miniapp.core.page.PageEventListener
    public void onWebViewReady(String str, String str2, int i3) {
        MiniReportManager.reportEventType(this.mRuntime.getMiniAppInfo(), 120, str2, null, null, 0);
        onAppRoute(str, str2, i3);
        onAppRouteDone(str, str2, i3);
    }

    public final void reload(String str) {
        IAppBrandPageContainer iAppBrandPageContainer = this.mRuntime.pageContainer;
        if (iAppBrandPageContainer != null) {
            iAppBrandPageContainer.cleanup(false);
        }
        BaseAppBrandRuntime baseAppBrandRuntime = this.mRuntime;
        baseAppBrandRuntime.onLoadMiniAppInfo(baseAppBrandRuntime.getMiniAppInfo(), true, str);
    }
}
