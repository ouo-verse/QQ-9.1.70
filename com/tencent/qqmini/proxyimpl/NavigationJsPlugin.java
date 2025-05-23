package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Iterator;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes34.dex */
public class NavigationJsPlugin extends BaseJsPlugin {

    /* renamed from: i, reason: collision with root package name */
    private static final int f347477i = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_navigate_back_by_appinfo", 1);

    /* renamed from: e, reason: collision with root package name */
    private boolean f347479e;

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, String> f347478d = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private WnsConfigProxy f347480f = (WnsConfigProxy) AppLoaderFactory.g().getProxyManager().get(WnsConfigProxy.class);

    /* renamed from: h, reason: collision with root package name */
    private final BroadcastReceiver f347481h = new b();

    /* loaded from: classes34.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("runningProcessName");
            if (QLog.isColorLevel()) {
                QLog.d("NavigationJsPlugin", 2, "onReceive action: " + action + "  process_name:" + stringExtra);
            }
            if (NavigationJsPlugin.this.n(action, stringExtra)) {
                try {
                    MiniAppLauncher.launchAppByAppInfo(((BaseJsPlugin) NavigationJsPlugin.this).mMiniAppContext.getAttachActivity(), MiniSdkLauncher.convert(((BaseJsPlugin) NavigationJsPlugin.this).mMiniAppInfo), ((BaseJsPlugin) NavigationJsPlugin.this).mMiniAppInfo.launchParam.scene);
                    BaseApplication.getContext().unregisterReceiver(NavigationJsPlugin.this.f347481h);
                    NavigationJsPlugin.this.f347479e = false;
                } catch (MiniAppException e16) {
                    throw new RuntimeException(e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes34.dex */
    public static class d implements MiniAppLauncher.MiniAppLaunchListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<Activity> f347496a;

        public d(Activity activity) {
            this.f347496a = new WeakReference<>(activity);
        }

        @Override // com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener
        public void onLaunchResult(boolean z16, Bundle bundle) {
            Activity activity = this.f347496a.get();
            if (activity == null || activity.isFinishing()) {
                QLog.e("NavigationJsPlugin", 1, "activity is null or finish!");
            } else if (!z16) {
                QLog.e("NavigationJsPlugin", 1, "navigateBackMiniApp failed!");
            } else {
                QLog.d("NavigationJsPlugin", 1, "navigateBackMiniApp ok, finish current.");
                activity.finish();
            }
        }
    }

    private int m(String str, int i3) {
        JSONObject jsonString;
        if (((WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class)) == null || str == null || (jsonString = VasToggle.MINI_GAME_CHANGE_SCENE.getJsonString()) == null) {
            return i3;
        }
        Iterator keys = jsonString.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            if (str.equals(str2)) {
                return jsonString.optInt(str2);
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(String str, String str2) {
        return "com.tencent.process.stopping".equals(str) && ("com.tencent.mobileqq:wxa_container0".equals(str2) || "com.tencent.mobileqq:wxa_container1".equals(str2));
    }

    private boolean navigateBackMiniApp(String str, String str2, String str3) {
        LaunchParam launchParam = new LaunchParam();
        launchParam.miniAppId = str;
        launchParam.scene = 1038;
        launchParam.navigateExtData = str2;
        launchParam.privateExtraData = str3;
        launchParam.fromMiniAppId = this.mApkgInfo.appId;
        Activity attachActivity = this.mMiniAppContext.getAttachActivity();
        MiniAppController.navigateBackMiniApp(attachActivity, str, launchParam, new d(attachActivity));
        return true;
    }

    private void o(MiniAppInfo miniAppInfo, String str, String str2, final MiniAppLauncher.MiniAppLaunchListener miniAppLaunchListener) {
        LaunchParam launchParam = new LaunchParam();
        launchParam.miniAppId = miniAppInfo.appId;
        launchParam.scene = 1038;
        launchParam.navigateExtData = str;
        launchParam.privateExtraData = str2;
        launchParam.fromBackToMiniApp = 1;
        launchParam.fromMiniAppId = this.mApkgInfo.appId;
        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
        miniAppConfig.launchParam = launchParam;
        MiniAppLauncher.launchAppByAppConfig(this.mMiniAppContext.getAttachActivity(), miniAppConfig, new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.tencent.qqmini.proxyimpl.NavigationJsPlugin.6
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle) {
                super.onReceiveResult(i3, bundle);
                if (i3 == 0) {
                    MiniAppLauncher.MiniAppLaunchListener miniAppLaunchListener2 = miniAppLaunchListener;
                    if (miniAppLaunchListener2 != null) {
                        miniAppLaunchListener2.onLaunchResult(true, null);
                    }
                    if (((BaseJsPlugin) NavigationJsPlugin.this).mMiniAppContext.getAttachActivity() == null || ((BaseJsPlugin) NavigationJsPlugin.this).mMiniAppContext.getAttachActivity().isFinishing()) {
                        return;
                    }
                    QLog.d("NavigationJsPlugin", 1, "navigateBackMiniApp ok, finish current.");
                    ((BaseJsPlugin) NavigationJsPlugin.this).mMiniAppContext.getAttachActivity().finish();
                    return;
                }
                QLog.e("NavigationJsPlugin", 1, "navigateBackMiniApp failed");
                MiniAppLauncher.MiniAppLaunchListener miniAppLaunchListener3 = miniAppLaunchListener;
                if (miniAppLaunchListener3 != null) {
                    miniAppLaunchListener3.onLaunchResult(false, null);
                }
            }
        });
    }

    private void p() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.process.stopping");
            BaseApplication.getContext().registerReceiver(this.f347481h, intentFilter);
        } catch (Exception e16) {
            QMLog.e("NavigationJsPlugin", "registerReceiver, " + e16.getMessage(), e16);
        }
    }

    private void q(String str) {
        SimpleMiniAppConfig.SimpleMiniAppInfo simpleMiniAppInfo = new SimpleMiniAppConfig.SimpleMiniAppInfo();
        simpleMiniAppInfo.appId = str;
        SimpleMiniAppConfig simpleMiniAppConfig = new SimpleMiniAppConfig(simpleMiniAppInfo);
        simpleMiniAppConfig.launchParam.scene = 1037;
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async(simpleMiniAppConfig, "navigateToMiniProgram", "click", null, null);
    }

    private void r(final MiniAppInfo miniAppInfo) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.NavigationJsPlugin.5
            @Override // java.lang.Runnable
            public void run() {
                MiniAppInfo.saveMiniAppShowInfoEntity(miniAppInfo);
            }
        }, 32, null, true);
    }

    @JsEvent({"exitMiniProgram"})
    public void exitMiniProgram(RequestEvent requestEvent) {
        final Activity attachActivity = this.mMiniAppContext.getAttachActivity();
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.NavigationJsPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (((BaseJsPlugin) NavigationJsPlugin.this).mIsMiniGame) {
                        attachActivity.finishAndRemoveTask();
                        if (aq.i(((BaseJsPlugin) NavigationJsPlugin.this).mMiniAppInfo)) {
                            attachActivity.overridePendingTransition(0, R.anim.f154458a7);
                        }
                    } else if (!attachActivity.moveTaskToBack(true)) {
                        QLog.d("NavigationJsPlugin", 1, "moveTaskToBack failed, finish the activity.");
                        attachActivity.finish();
                    }
                } catch (Throwable unused) {
                    QLog.e("NavigationJsPlugin", 1, "Failed to moveTaskBack");
                }
            }
        });
        requestEvent.ok();
    }

    @JsEvent({"navigateToWeMiniProgram"})
    public void navigateToWeMiniProgram(RequestEvent requestEvent) {
        int i3;
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            JSONObject optJSONObject = jSONObject.optJSONObject("appInfo");
            String optString = jSONObject.optString("appId");
            String optString2 = jSONObject.optString("path");
            s(jSONObject.optBoolean("closeSelf", false));
            com.tencent.qqmini.sdk.launcher.model.MiniAppInfo createMiniAppInfo = com.tencent.qqmini.sdk.launcher.model.MiniAppInfo.createMiniAppInfo(optJSONObject);
            if (createMiniAppInfo != null && this.mMiniAppInfo.appMode.useAppInfoWhenNavigate) {
                try {
                    if (TextUtils.equals(WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_KEY_MINI_APP_SEARCH_APPID, WnsConfig.DefaultValue.DEFAULT_MINI_APP_SEARCH_APPID), this.mMiniAppInfo.appId)) {
                        i3 = 2077;
                    } else {
                        if (!this.mMiniAppInfo.isAppStoreMiniApp()) {
                            r5 = 1037;
                        }
                        i3 = r5;
                    }
                    ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(this.mMiniAppContext.getAttachActivity(), createMiniAppInfo.appId, createMiniAppInfo.launchParam.entryPath, i3);
                    QMLog.d("NavigationJsPlugin", "navigateToMiniProgram, open miniApp from appInfo, appInfo: " + createMiniAppInfo);
                    q(createMiniAppInfo.appId);
                } catch (Exception e16) {
                    QMLog.e("NavigationJsPlugin", "navigateToMiniProgram, " + e16.getMessage(), e16);
                }
            } else {
                ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(this.mMiniAppContext.getAttachActivity(), optString, optString2, this.mMiniAppInfo.isAppStoreMiniApp() ? 2001 : 1037);
                q(optString);
            }
            requestEvent.ok();
        } catch (JSONException e17) {
            QMLog.e("NavigationJsPlugin", "navigateToWeMiniProgram failed!", e17);
            requestEvent.fail(e17.getMessage());
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        if (this.f347479e) {
            BaseApplication.getContext().unregisterReceiver(this.f347481h);
        }
    }

    /* loaded from: classes34.dex */
    class a implements MiniAppLauncher.MiniAppLaunchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f347490a;

        a(RequestEvent requestEvent) {
            this.f347490a = requestEvent;
        }

        @Override // com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener
        public void onLaunchResult(boolean z16, Bundle bundle) {
            if (z16) {
                this.f347490a.ok();
            } else {
                this.f347490a.fail();
            }
        }
    }

    /* loaded from: classes34.dex */
    private static class c implements MiniAppLauncher.MiniAppLaunchListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<Activity> f347493a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f347494b;

        /* renamed from: c, reason: collision with root package name */
        private RequestEvent f347495c;

        public c(Activity activity, boolean z16, RequestEvent requestEvent) {
            this.f347493a = new WeakReference<>(activity);
            this.f347494b = z16;
            this.f347495c = requestEvent;
        }

        @Override // com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener
        public void onLaunchResult(boolean z16, Bundle bundle) {
            if (z16 && this.f347493a.get() != null) {
                if (this.f347494b) {
                    this.f347493a.get().finishAndRemoveTask();
                    return;
                }
                return;
            }
            this.f347495c.fail();
        }
    }

    @JsEvent({com.tencent.luggage.wxa.jf.f.NAME})
    public void navigateBackMiniProgram(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            int i3 = f347477i;
            if (i3 == 0) {
                String optString = jSONObject.optString(WadlProxyConsts.EXTRA_DATA);
                String optString2 = jSONObject.optString("privateExtraData");
                String str = this.mMiniAppInfo.launchParam.fromMiniAppId;
                if (!TextUtils.isEmpty(str) && navigateBackMiniApp(str, optString, optString2)) {
                    requestEvent.ok();
                } else {
                    requestEvent.fail();
                }
            } else if (i3 == 1) {
                String optString3 = jSONObject.optString(WadlProxyConsts.EXTRA_DATA);
                String optString4 = jSONObject.optString("privateExtraData");
                MiniAppInfo convert = MiniSdkLauncher.convert(this.mMiniAppInfo.launchParam.fromMiniAppInfo);
                if (convert != null) {
                    o(convert, optString3, optString4, new a(requestEvent));
                }
            }
        } catch (Throwable th5) {
            QLog.e("NavigationJsPlugin", 1, "navigateBackMiniProgram error, ", th5);
        }
    }

    private void s(boolean z16) {
        if (z16 || this.f347479e) {
            return;
        }
        p();
        this.f347479e = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    @JsEvent({"navigateToMiniProgram"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void navigateToMiniProgram(final RequestEvent requestEvent) {
        JSONObject jSONObject;
        String str;
        EntryModel entryModel;
        com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo;
        boolean z16;
        boolean z17;
        boolean z18;
        String str2;
        String str3;
        int optInt;
        String str4;
        int i3;
        String str5;
        String str6;
        try {
            jSONObject = new JSONObject(requestEvent.jsonParams);
        } catch (Throwable th5) {
            QLog.e("NavigationJsPlugin", 1, th5.getMessage(), th5);
            jSONObject = null;
        }
        JSONObject jSONObject2 = jSONObject;
        final Activity attachActivity = this.mMiniAppContext.getAttachActivity();
        if (jSONObject2 == null || attachActivity == null) {
            return;
        }
        final boolean optBoolean = jSONObject2.optBoolean("isKillSelf", false);
        boolean optBoolean2 = jSONObject2.optBoolean("isForceReload", false);
        boolean optBoolean3 = jSONObject2.optBoolean("skipHotReload", false);
        String optString = jSONObject2.optString("reportData");
        MiniAppInfo createMiniAppInfo = MiniAppInfo.createMiniAppInfo(jSONObject2);
        com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo2 = this.mMiniAppContext.getMiniAppInfo();
        EntryModel entryModel2 = miniAppInfo2.launchParam.entryModel;
        String str7 = "";
        if (createMiniAppInfo == null || !miniAppInfo2.appMode.useAppInfoWhenNavigate) {
            str = "privateExtraData";
            entryModel = entryModel2;
            miniAppInfo = miniAppInfo2;
            z16 = optBoolean;
            z17 = optBoolean2;
            z18 = optBoolean3;
            str2 = WadlProxyConsts.EXTRA_DATA;
            str3 = optString;
        } else {
            try {
                try {
                    String config = this.f347480f.getConfig("qqminiapp", WnsConfig.SECONDARY_KEY_MINI_APP_SEARCH_APPID);
                    if (StringUtil.isEmpty(config)) {
                        config = WnsConfig.DefaultValue.DEFAULT_MINI_APP_SEARCH_APPID;
                    }
                    if (this.mMiniAppContext.getMiniAppInfo() == null || !config.equals(this.mMiniAppContext.getMiniAppInfo().appId)) {
                        i3 = miniAppInfo2.isAppStoreMiniApp() ? 2001 : 1037;
                    } else {
                        i3 = 2077;
                    }
                    int m3 = m(this.mMiniAppInfo.appId, i3);
                    JSONObject optJSONObject = jSONObject2.optJSONObject(WadlProxyConsts.EXTRA_DATA);
                    if (optJSONObject == null) {
                        str5 = "";
                    } else {
                        str5 = optJSONObject.toString();
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("privateExtraData");
                    if (optJSONObject2 == null) {
                        str6 = "";
                    } else {
                        str6 = optJSONObject2.toString();
                    }
                    LaunchParam launchParam = new LaunchParam();
                    launchParam.scene = m3;
                    launchParam.fromMiniAppId = miniAppInfo2.launchParam.miniAppId;
                    launchParam.navigateExtData = str5;
                    launchParam.privateExtraData = str6;
                    launchParam.skipHotReload = optBoolean3;
                    if (entryModel2 != null) {
                        launchParam.entryModel = aq.g(entryModel2);
                    }
                    if (optBoolean2) {
                        launchParam.forceReload = 2;
                    }
                    MiniAppInfo createMiniAppInfo2 = MiniAppInfo.createMiniAppInfo(jSONObject2);
                    Handler handler = new Handler();
                    z17 = optBoolean2;
                    str2 = WadlProxyConsts.EXTRA_DATA;
                    str = "privateExtraData";
                    entryModel = entryModel2;
                    miniAppInfo = miniAppInfo2;
                    z16 = optBoolean;
                    str3 = optString;
                    z18 = optBoolean3;
                    try {
                        MiniAppLauncher.launchAppByAppInfo(attachActivity, createMiniAppInfo2, launchParam, new ResultReceiver(handler) { // from class: com.tencent.qqmini.proxyimpl.NavigationJsPlugin.4
                            @Override // android.os.ResultReceiver
                            protected void onReceiveResult(int i16, Bundle bundle) {
                                if (i16 == 0) {
                                    if (optBoolean) {
                                        attachActivity.finishAndRemoveTask();
                                        return;
                                    }
                                    return;
                                }
                                requestEvent.fail();
                            }
                        });
                        requestEvent.ok();
                        QLog.d("NavigationJsPlugin", 1, "navigateToMiniProgram, open miniApp from appInfo, appInfo: " + createMiniAppInfo.toString());
                        if (createMiniAppInfo.verType == 3) {
                            r(createMiniAppInfo2);
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        e = e16;
                        QLog.e("NavigationJsPlugin", 1, "navigateToMiniProgram, " + Log.getStackTraceString(e));
                        optInt = jSONObject2.optInt("openType");
                        String optString2 = jSONObject2.optString("appId");
                        if (optInt == 0) {
                        }
                        if (optInt != 1) {
                        }
                    }
                } catch (Exception e17) {
                    e = e17;
                    str = "privateExtraData";
                    entryModel = entryModel2;
                    miniAppInfo = miniAppInfo2;
                    z16 = optBoolean;
                    z17 = optBoolean2;
                    str3 = optString;
                    str2 = WadlProxyConsts.EXTRA_DATA;
                    z18 = optBoolean3;
                }
            } catch (Exception e18) {
                e = e18;
                str = "privateExtraData";
                entryModel = entryModel2;
                miniAppInfo = miniAppInfo2;
                z16 = optBoolean;
                z17 = optBoolean2;
                z18 = optBoolean3;
                str2 = WadlProxyConsts.EXTRA_DATA;
                str3 = optString;
            }
        }
        optInt = jSONObject2.optInt("openType");
        String optString22 = jSONObject2.optString("appId");
        if (optInt == 0 || this.mMiniAppInfo == null) {
            if (optInt != 1) {
                requestEvent.fail();
                return;
            }
            return;
        }
        String optString3 = jSONObject2.optString("path");
        String optString4 = jSONObject2.optString("envVersion");
        JSONObject optJSONObject3 = jSONObject2.optJSONObject(str2);
        if (optJSONObject3 == null) {
            str4 = "";
        } else {
            str4 = optJSONObject3.toString();
        }
        if ("release".equals(this.mMiniAppInfo.getVerTypeStr())) {
            optString4 = "release";
        }
        LaunchParam launchParam2 = new LaunchParam();
        launchParam2.miniAppId = optString22;
        int i16 = miniAppInfo.isAppStoreMiniApp() ? 2001 : 1037;
        launchParam2.scene = i16;
        launchParam2.scene = m(this.mMiniAppInfo.appId, i16);
        launchParam2.entryPath = optString3;
        launchParam2.navigateExtData = str4;
        com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo3 = miniAppInfo;
        launchParam2.fromMiniAppId = miniAppInfo3.launchParam.miniAppId;
        launchParam2.entryModel = aq.g(entryModel);
        launchParam2.envVersion = optString4;
        launchParam2.reportData = str3;
        launchParam2.skipHotReload = z18;
        JSONObject optJSONObject4 = jSONObject2.optJSONObject(str);
        if (optJSONObject4 != null) {
            str7 = optJSONObject4.toString();
        }
        launchParam2.privateExtraData = str7;
        if (!miniAppInfo3.isSpecialMiniApp() && f347477i == 1) {
            launchParam2.fromEnvVersion = miniAppInfo3.getVerTypeStr();
            launchParam2.fromMiniAppInfo = MiniSdkLauncher.convert(miniAppInfo3);
        }
        if (z17) {
            launchParam2.forceReload = 2;
        }
        MiniAppLauncher.launchMiniAppById(attachActivity, launchParam2, new c(attachActivity, z16, requestEvent));
        requestEvent.ok();
    }
}
