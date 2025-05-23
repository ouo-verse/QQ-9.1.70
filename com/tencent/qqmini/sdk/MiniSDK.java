package com.tencent.qqmini.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.MiniSDKImpl;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher;
import java.util.HashMap;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class MiniSDK {
    public static final String LAUNCH_SERVICE = "LAUNCH_SERVICE";
    public static final int LINKTYPE_FAKEURL = 0;
    public static final int LINKTYPE_MINICODE = 1;
    public static final int LINKTYPE_SCHEMA = 2;
    public static final String OPEN_LINK_URL_PREFIX = "{@schema}://minisdk/open?link=";
    public static final int START_APP_TYPE_APP_ID = 2;
    public static final int START_APP_TYPE_APP_INFO = 1;
    public static final int START_APP_TYPE_APP_LINK = 3;
    public static final int STATE_CREATE = 0;
    public static final int STATE_SHOW = 1;
    public static final String TAG = "minisdk-start_MiniSDK";
    private static MiniSDKImpl sMiniSDKImpl = new MiniSDKImpl();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class LoginType {
        public static final int LOGIN_FROM_ANONYMOUS = 0;
        public static final int LOGIN_FROM_QQ = 2;
        public static final int LOGIN_FROM_QQ_WT_LOGIN = 3;
        public static final int LOGIN_FROM_WX = 1;
    }

    public static void init(Context context) {
        sMiniSDKImpl.init(context);
    }

    public static void notifyPeriodicCacheUpdate(Context context, MiniAppInfo miniAppInfo) {
        QMLog.i(TAG, "notifyPeriodicCacheUpdate, MiniAppInfo = " + miniAppInfo);
        sMiniSDKImpl.init(context);
        sMiniSDKImpl.notifyPeriodicCacheUpdate(miniAppInfo);
    }

    public static void notifyShareResult(Context context, MiniAppInfo miniAppInfo, Bundle bundle) {
        notifyShareResult(context, miniAppInfo, bundle, null);
    }

    public static void onHostAppBackground(Context context) {
        sMiniSDKImpl.init(context);
        sMiniSDKImpl.onHostAppBackground();
    }

    public static void preDownloadPkg(Context context, MiniAppInfo miniAppInfo, ResultReceiver resultReceiver) {
        sMiniSDKImpl.init(context);
        sMiniSDKImpl.preDownloadPkg(miniAppInfo, resultReceiver);
    }

    public static void preloadMiniApp(Context context) {
        QMLog.i(TAG, "preloadMiniApp");
        preloadMiniApp(context, new Bundle());
    }

    private static void reportStartEvent(int i3, Bundle bundle, String str, int i16) {
        boolean z16;
        if (bundle != null) {
            z16 = bundle.getBoolean("isReported");
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        Context context = AppLoaderFactory.g().getContext();
        IProxyManager proxyManager = AppLoaderFactory.g().getProxyManager();
        MiniAppProxy miniAppProxy = (MiniAppProxy) proxyManager.get(MiniAppProxy.class);
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put(TagName.ENGINE_TYPE, String.valueOf(i16));
        hashMap.put("launchType", String.valueOf(i3));
        hashMap.put("QUA", miniAppProxy.getPlatformQUA());
        hashMap.put("QQUin", miniAppProxy.getAccount());
        hashMap.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, miniAppProxy.getPlatformId());
        hashMap.put(DKEngine.GlobalKey.NET_WORK_TYPE, NetworkUtil.getNetWorkTypeByStr(context).toLowerCase());
        ((ChannelProxy) proxyManager.get(ChannelProxy.class)).reportBeacon(ChannelProxy.BeaconReportCategory.MINI_GAME, "minigame_entry_launch_start_andriod", hashMap, true, false);
    }

    public static String scanMiniCode(Context context, byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        sMiniSDKImpl.init(context);
        return sMiniSDKImpl.scanMiniCode(bArr, i3, i16, i17, i18, i19, i26, i27);
    }

    public static void setAudioMute(Context context, boolean z16) {
        QMLog.i(TAG, "setAudioMute, isMute:" + z16);
        sMiniSDKImpl.init(context);
        sMiniSDKImpl.setAudioMute(context, z16);
    }

    public static void startMiniApp(Activity activity, MiniAppInfo miniAppInfo) {
        startMiniApp(activity, miniAppInfo, (Bundle) null, (ResultReceiver) null);
    }

    public static void stopAllMiniApp(Context context) {
        QMLog.i(TAG, "stopAllMiniApp");
        sMiniSDKImpl.init(context);
        sMiniSDKImpl.stopAllMiniApp();
    }

    public static void stopMiniApp(Context context, MiniAppInfo miniAppInfo) {
        QMLog.i(TAG, "stopMiniApp " + miniAppInfo);
        sMiniSDKImpl.init(context);
        sMiniSDKImpl.stopMiniApp(miniAppInfo);
    }

    public static void notifyShareResult(Context context, MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver) {
        QMLog.i(TAG, "notifyShareResult, MiniAppInfo = " + miniAppInfo);
        sMiniSDKImpl.init(context);
        sMiniSDKImpl.notifyShareResult(miniAppInfo, bundle, resultReceiver);
    }

    public static void startMiniApp(Activity activity, MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver) {
        QMLog.i(TAG, "startMiniApp miniappInfo:" + miniAppInfo);
        sMiniSDKImpl.init(activity != null ? activity.getApplicationContext() : null);
        sMiniSDKImpl.startMiniApp(activity, miniAppInfo, bundle, resultReceiver);
        reportStartEvent(1, bundle, miniAppInfo != null ? miniAppInfo.appId : "", miniAppInfo != null ? miniAppInfo.engineType : -1);
    }

    public static void preloadMiniApp(Context context, Bundle bundle) {
        QMLog.i(TAG, "preloadMiniApp");
        sMiniSDKImpl.init(context);
        sMiniSDKImpl.preloadMiniApp(context, bundle);
    }

    public static void startMiniApp(Activity activity, String str, int i3) {
        startMiniApp(activity, str, i3, (ResultReceiver) null);
    }

    public static void startMiniApp(Activity activity, String str) {
        startMiniApp(activity, str, 1001, (ResultReceiver) null);
    }

    public static void startMiniApp(Activity activity, String str, int i3, ResultReceiver resultReceiver) {
        startMiniApp(activity, str, i3, new LaunchParam(), resultReceiver);
    }

    public static void startMiniApp(Activity activity, String str, int i3, LaunchParam launchParam, ResultReceiver resultReceiver) {
        startMiniApp(activity, str, i3, null, null, launchParam, resultReceiver);
    }

    public static void startMiniApp(Activity activity, String str, int i3, String str2, String str3, LaunchParam launchParam, ResultReceiver resultReceiver) {
        QMLog.i(TAG, "startMiniApp appId:" + str);
        sMiniSDKImpl.init(activity != null ? activity.getApplicationContext() : null);
        Intent intent = new Intent();
        intent.putExtra("key_appid", str);
        launchParam.scene = i3;
        intent.putExtra("mini_entryPath", str2);
        intent.putExtra("mini_envVersion", str3);
        intent.putExtra("mini_launch_param", launchParam);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("mini_receiver", resultReceiver);
        MiniFragmentLauncher.startTranslucent(activity, intent, MiniFragmentLauncher.FragmentType.FRAGMENT_APPINFO_LOADING);
        activity.overridePendingTransition(0, 0);
        reportStartEvent(2, null, str, -1);
    }

    public static void startMiniApp(Activity activity, String str, int i3, int i16) {
        startMiniApp(activity, str, i3, i16, (String) null);
    }

    public static void startMiniApp(Activity activity, String str, int i3, int i16, String str2) {
        startMiniApp(activity, str, i3, i16, str2, null);
    }

    public static void startMiniApp(Activity activity, String str, int i3, int i16, String str2, ResultReceiver resultReceiver) {
        QMLog.i(TAG, "startMiniApp link: " + str + ", linkType: " + i3);
        sMiniSDKImpl.init(activity != null ? activity.getApplicationContext() : null);
        Intent intent = new Intent();
        intent.putExtra("mini_link", str);
        intent.putExtra("mini_link_type", i3);
        intent.putExtra(IPCConst.KEY_CUSTOM_INFO, str2);
        LaunchParam launchParam = new LaunchParam();
        launchParam.scene = i16;
        intent.putExtra("mini_launch_param", launchParam);
        intent.putExtra("mini_receiver", resultReceiver);
        intent.putExtra("public_fragment_window_feature", 1);
        MiniFragmentLauncher.startTranslucent(activity, intent, MiniFragmentLauncher.FragmentType.FRAGMENT_APPINFO_LOADING);
        activity.overridePendingTransition(0, 0);
        reportStartEvent(2, null, "", -1);
    }
}
