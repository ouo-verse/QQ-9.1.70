package com.tencent.qqmini.sdk.utils;

import android.app.Activity;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StartupReportUtil;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class MiniAppLauncher {
    private static final String TAG = "MiniAppLauncher";
    private static final String URL_PATTERN_OF_AD_SCHEME = "mqqapi://miniapp/adopen(/[0-9]+)?\\?";
    private static final String URL_PREFIX_HTTP_MINIAPP_AD_REAL_HEAD_SCHEME_V3 = "mqqapi://miniapp/adopen";
    private static final String URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_SCHEME_V1 = "mqqapi://microapp/open?";
    private static final String URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_SCHEME_V2 = "mqqapi://miniapp/open?";
    private static final String URL_PREFIX_MINIAPP_HTTP = "http://imgcache.qq.com/channel/mini_app/upgrade.html";
    private static final String URL_PREFIX_MINIAPP_HTTPS = "https://imgcache.qq.com/channel/mini_app/upgrade.html";
    private static final String URL_PREFIX_MINIAPP_URL = "https://m.q.qq.com/a/";
    private static final String URL_PREFIX_MINIAPP_URL_HTTP = "http://m.q.qq.com/a/";
    private static final String URL_PREFIX_WX_MINIAPP_HTTPS = "https://mp.weixin.qq.com/a/";

    public static boolean isFakeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith(URL_PREFIX_MINIAPP_URL) && !str.startsWith(URL_PREFIX_MINIAPP_URL_HTTP)) {
            return false;
        }
        return true;
    }

    private static boolean isMiniAppADSchemeV3(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(URL_PREFIX_HTTP_MINIAPP_AD_REAL_HEAD_SCHEME_V3);
    }

    public static boolean isMiniAppScheme(String str) {
        if (!isMiniAppSchemeV1(str) && !isMiniAppSchemeV2(str) && !isMiniAppADSchemeV3(str)) {
            return false;
        }
        return true;
    }

    private static boolean isMiniAppSchemeV1(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_SCHEME_V1);
    }

    public static boolean isMiniAppSchemeV2(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_SCHEME_V2);
    }

    public static boolean isMiniAppUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!isFakeUrl(str) && !isMiniAppScheme(str)) {
            return false;
        }
        return true;
    }

    public static void launchMiniApp(Activity activity, MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver) {
        LaunchParam launchParam = miniAppInfo.launchParam;
        launchParam.startupReportData = StartupReportUtil.reportBegin(miniAppInfo.appId, launchParam.scene, 0);
        MiniSDK.startMiniApp(activity, miniAppInfo, bundle, resultReceiver);
    }

    public static void launchMiniApp(Activity activity, String str, LaunchParam launchParam, ResultReceiver resultReceiver) {
        if (launchParam == null) {
            launchParam = new LaunchParam();
            launchParam.scene = 1001;
        }
        launchParam.startupReportData = StartupReportUtil.reportBegin(str, launchParam.scene, 1);
        MiniSDK.startMiniApp(activity, str, launchParam.scene, launchParam, resultReceiver);
    }
}
