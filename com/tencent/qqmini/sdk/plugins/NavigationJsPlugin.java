package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.NavigationProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.MiniAppLauncher;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class NavigationJsPlugin extends BaseJsPlugin {
    private static final String TAG = "NavigationJsPlugin";
    private static final int navigateBackByAPPInfo = WnsConfig.getConfig("qqminiapp", "mini_app_navigate_back_by_appinfo", 1);
    private NavigationProxy navigationProxy = (NavigationProxy) ProxyManager.get(NavigationProxy.class);

    private static void navigateBackMiniApp(Activity activity, String str, LaunchParam launchParam, ResultReceiver resultReceiver) {
        Intent intent = new Intent();
        intent.putExtra("key_appid", str);
        if (launchParam != null) {
            launchParam.fromBackToMiniApp = 1;
            intent.putExtra("mini_launch_param", launchParam);
        }
        intent.putExtra("mini_receiver", resultReceiver);
        intent.putExtra("public_fragment_window_feature", 1);
        MiniFragmentLauncher.startTranslucent(activity, intent, MiniFragmentLauncher.FragmentType.FRAGMENT_APPINFO_LOADING);
        activity.overridePendingTransition(0, 0);
    }

    private void navigateToMiniProgramByAppid(final RequestEvent requestEvent, JSONObject jSONObject, String str) {
        String str2;
        int optInt = jSONObject.optInt("openType");
        String optString = jSONObject.optString("appId");
        int i3 = 2001;
        if (optInt == 0) {
            String optString2 = jSONObject.optString("path");
            JSONObject optJSONObject = jSONObject.optJSONObject(WadlProxyConsts.EXTRA_DATA);
            LaunchParam launchParam = new LaunchParam();
            if (!this.mMiniAppInfo.isAppStoreMiniApp()) {
                i3 = 1037;
            }
            launchParam.scene = i3;
            launchParam.entryPath = optString2;
            if (optJSONObject != null) {
                str2 = optJSONObject.toString();
            } else {
                str2 = "";
            }
            launchParam.navigateExtData = str2;
            LaunchParam launchParam2 = this.mMiniAppInfo.launchParam;
            launchParam.fromMiniAppId = launchParam2.miniAppId;
            launchParam.entryModel = launchParam2.entryModel;
            launchParam.envVersion = jSONObject.optString("envVersion");
            if (!this.mMiniAppInfo.isSpecialMiniApp() && navigateBackByAPPInfo == 1) {
                launchParam.fromEnvVersion = this.mMiniAppInfo.getVerTypeStr();
                launchParam.fromMiniAppInfo = MiniAppInfo.copy(this.mMiniAppInfo);
            }
            launchParam.reportData = str;
            MiniAppLauncher.launchMiniApp(this.mMiniAppContext.getAttachActivity(), optString, launchParam, new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.tencent.qqmini.sdk.plugins.NavigationJsPlugin.1
                @Override // android.os.ResultReceiver
                protected void onReceiveResult(int i16, Bundle bundle) {
                    QMLog.d(NavigationJsPlugin.TAG, "onReceiveResult resultCode : " + i16);
                    if (i16 != 0) {
                        requestEvent.fail();
                    }
                }
            });
            requestEvent.ok();
            return;
        }
        LaunchParam launchParam3 = new LaunchParam();
        if (!this.mMiniAppInfo.isAppStoreMiniApp()) {
            i3 = 1037;
        }
        launchParam3.scene = i3;
        if (this.navigationProxy.launchByAppType(optInt, this.mMiniAppContext.getAttachActivity(), optString, launchParam3.scene, jSONObject, new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.tencent.qqmini.sdk.plugins.NavigationJsPlugin.2
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i16, Bundle bundle) {
                if (i16 != 0) {
                    requestEvent.fail();
                }
            }
        })) {
            requestEvent.ok();
        } else {
            requestEvent.fail();
        }
    }

    public static void recordAppLaunchTime(String str, int i3) {
        MiniReportManager.getLaunchState(str).eventTime.put(Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
    }

    @JsEvent({"exitMiniProgram"})
    public void exitMiniProgram(RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.NavigationJsPlugin.5
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.qqmini.sdk.utils.a.b(((BaseJsPlugin) NavigationJsPlugin.this).mMiniAppContext, MiniAppConst.RuntimeCloseType.EXIT_MINI_PROGRAM);
            }
        });
        requestEvent.ok();
    }

    @JsEvent({com.tencent.luggage.wxa.jf.f.NAME})
    public void navigateBackMiniProgram(final RequestEvent requestEvent) {
        JSONObject jSONObject;
        new JSONObject();
        try {
            jSONObject = new JSONObject(requestEvent.jsonParams);
        } catch (Throwable th5) {
            QMLog.e(TAG, th5.getMessage(), th5);
            jSONObject = null;
        }
        int i3 = navigateBackByAPPInfo;
        if (i3 == 0) {
            if (jSONObject != null) {
                String optString = jSONObject.optString(WadlProxyConsts.EXTRA_DATA);
                String optString2 = jSONObject.optString("privateExtraData");
                String str = this.mMiniAppInfo.launchParam.fromMiniAppId;
                if (!TextUtils.isEmpty(str) && navigateBackMiniApp(str, optString, optString2)) {
                    requestEvent.ok();
                    return;
                } else {
                    requestEvent.fail();
                    return;
                }
            }
            return;
        }
        if (i3 == 1 && jSONObject != null) {
            String optString3 = jSONObject.optString(WadlProxyConsts.EXTRA_DATA);
            String optString4 = jSONObject.optString("privateExtraData");
            MiniAppInfo miniAppInfo = this.mMiniAppInfo.launchParam.fromMiniAppInfo;
            if (miniAppInfo != null) {
                navigateBackMiniApp(miniAppInfo, optString3, optString4, new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.tencent.qqmini.sdk.plugins.NavigationJsPlugin.3
                    @Override // android.os.ResultReceiver
                    protected void onReceiveResult(int i16, Bundle bundle) {
                        if (i16 == 0) {
                            requestEvent.ok();
                            if (((BaseJsPlugin) NavigationJsPlugin.this).mMiniAppContext != null && ((BaseJsPlugin) NavigationJsPlugin.this).mMiniAppContext.getAttachActivity() != null && !((BaseJsPlugin) NavigationJsPlugin.this).mMiniAppContext.getAttachActivity().isFinishing()) {
                                com.tencent.qqmini.sdk.utils.a.b(((BaseJsPlugin) NavigationJsPlugin.this).mMiniAppContext, MiniAppConst.RuntimeCloseType.NAVIGATE_BACK_MINI_PROGRAM);
                                return;
                            }
                            return;
                        }
                        requestEvent.fail();
                    }
                });
            }
        }
    }

    @JsEvent({"navigateToMiniProgram"})
    public void navigateToMiniProgram(RequestEvent requestEvent) {
        JSONObject jSONObject;
        int i3;
        String str = "";
        try {
            jSONObject = new JSONObject(requestEvent.jsonParams);
        } catch (Throwable th5) {
            QMLog.e(TAG, "", th5);
            jSONObject = null;
        }
        recordAppLaunchTime(this.mMiniAppInfo.appId, 46);
        this.navigationProxy.onBeforeNavigateToMiniProgram();
        if (jSONObject != null) {
            String optString = jSONObject.optString("reportData");
            MiniAppInfo createMiniAppInfo = MiniAppInfo.createMiniAppInfo(jSONObject.optJSONObject("appInfo"));
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            EntryModel entryModel = miniAppInfo.launchParam.entryModel;
            if (createMiniAppInfo != null && miniAppInfo.appMode.useAppInfoWhenNavigate) {
                try {
                    if (WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_KEY_MINI_APP_SEARCH_APPID, WnsConfig.DefaultValue.DEFAULT_MINI_APP_SEARCH_APPID).equals(this.mMiniAppInfo.appId)) {
                        i3 = 2077;
                    } else if (this.mMiniAppInfo.isAppStoreMiniApp()) {
                        i3 = 2001;
                    } else {
                        i3 = 1037;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject(WadlProxyConsts.EXTRA_DATA);
                    if (optJSONObject != null) {
                        str = optJSONObject.toString();
                    }
                    LaunchParam launchParam = new LaunchParam();
                    launchParam.scene = i3;
                    launchParam.fromMiniAppId = this.mMiniAppInfo.launchParam.miniAppId;
                    launchParam.navigateExtData = str;
                    if (entryModel != null) {
                        launchParam.entryModel = entryModel;
                    }
                    createMiniAppInfo.launchParam.clone(launchParam);
                    MiniAppLauncher.launchMiniApp(this.mMiniAppContext.getAttachActivity(), createMiniAppInfo, (Bundle) null, (ResultReceiver) null);
                    requestEvent.ok();
                    QMLog.d(TAG, "navigateToMiniProgram, open miniApp from appInfo, appInfo: " + createMiniAppInfo.toString());
                    if (createMiniAppInfo.verType == 3) {
                        this.navigationProxy.onAfterLaunchByAppInfo(optJSONObject);
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    QMLog.e(TAG, "navigateToMiniProgram, " + e16.getMessage(), e16);
                }
            }
            navigateToMiniProgramByAppid(requestEvent, jSONObject, optString);
        }
    }

    private boolean navigateBackMiniApp(String str, String str2, String str3) {
        LaunchParam launchParam = new LaunchParam();
        launchParam.miniAppId = str;
        launchParam.scene = 1038;
        launchParam.navigateExtData = str2;
        launchParam.privateExtraData = str3;
        launchParam.fromMiniAppId = this.mMiniAppInfo.launchParam.miniAppId;
        navigateBackMiniApp(this.mMiniAppContext.getAttachActivity(), str, launchParam, new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.tencent.qqmini.sdk.plugins.NavigationJsPlugin.4
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle) {
                super.onReceiveResult(i3, bundle);
                if (i3 == 0) {
                    if (((BaseJsPlugin) NavigationJsPlugin.this).mMiniAppContext != null && ((BaseJsPlugin) NavigationJsPlugin.this).mMiniAppContext.getAttachActivity() != null && !((BaseJsPlugin) NavigationJsPlugin.this).mMiniAppContext.getAttachActivity().isFinishing()) {
                        com.tencent.qqmini.sdk.utils.a.b(((BaseJsPlugin) NavigationJsPlugin.this).mMiniAppContext, MiniAppConst.RuntimeCloseType.NAVIGATE_BACK_MINI_PROGRAM);
                        return;
                    }
                    return;
                }
                QMLog.e(NavigationJsPlugin.TAG, "navigateBackMiniApp failed");
            }
        });
        return true;
    }

    private void navigateBackMiniApp(MiniAppInfo miniAppInfo, String str, String str2, ResultReceiver resultReceiver) {
        MiniAppInfo copy = MiniAppInfo.copy(miniAppInfo);
        LaunchParam launchParam = copy.launchParam;
        launchParam.miniAppId = miniAppInfo.appId;
        launchParam.scene = 1038;
        launchParam.navigateExtData = str;
        launchParam.privateExtraData = str2;
        launchParam.fromBackToMiniApp = 1;
        launchParam.fromMiniAppId = this.mMiniAppInfo.launchParam.miniAppId;
        MiniAppLauncher.launchMiniApp(this.mMiniAppContext.getAttachActivity(), copy, new Bundle(), resultReceiver);
    }
}
