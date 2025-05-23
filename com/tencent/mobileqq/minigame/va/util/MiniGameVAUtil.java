package com.tencent.mobileqq.minigame.va.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.server.MiniAppSSOReqCallback;
import com.tencent.mobileqq.mini.server.MiniAppSSORequestClient;
import com.tencent.mobileqq.mini.server.MiniAppSSOResponse;
import com.tencent.mobileqq.mini.server.request.MiniGameWifiAutoDownloadRequest;
import com.tencent.mobileqq.mini.utils.MiniAppMMKVUtils;
import com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi;
import com.tencent.mobileqq.minigame.api.MiniGameVAInterceptCallback;
import com.tencent.mobileqq.minigame.api.impl.MiniGameAppLaunchHelper;
import com.tencent.mobileqq.minigame.api.impl.MiniGameAppLaunchResultCallback;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.leba.IMiniGameLebaController;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import com.tencent.mobileqq.minigame.va.MiniGameVAImpl;
import com.tencent.mobileqq.minigame.va.MiniGameVAMMKVKEY;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.YunGameProxyImpl;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.YunGameProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.util.AppSetting;
import com.tencent.util.URLUtil;
import com.tencent.util.pm.PackageUtil;
import com.tencent.xweb.FileReaderHelper;
import com.vivo.push.PushClientConstants;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J&\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0003J\b\u0010\u0019\u001a\u00020\u0012H\u0003J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0007J\u001a\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0004H\u0007J\b\u0010\"\u001a\u00020\u0012H\u0007J\u0014\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010%\u001a\u00020\u0012H\u0007J\u001c\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010'j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`(H\u0007J\u0019\u0010)\u001a\u0004\u0018\u00010\u00122\b\u0010*\u001a\u0004\u0018\u00010\u0004H\u0007\u00a2\u0006\u0002\u0010+J\u001c\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010'j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`(H\u0007J\u0018\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/2\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0010\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u0004H\u0007J\b\u00102\u001a\u00020\u0012H\u0007JD\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\f2\b\u0010=\u001a\u0004\u0018\u00010\u0004H\u0007J\u001e\u0010>\u001a\u0004\u0018\u00010\u00042\b\u00101\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010?\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0012\u0010@\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010\u0004H\u0007JH\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010C\u001a\u00020;2\u0006\u0010<\u001a\u00020\f2\b\u0010=\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010D\u001a\u00020\u0015H\u0007J\u0010\u0010E\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u0012H\u0007J\u0010\u0010G\u001a\u00020\u00152\u0006\u0010H\u001a\u00020\u0004H\u0007J\u0010\u0010I\u001a\u00020\u00152\u0006\u0010J\u001a\u00020KH\u0007J.\u0010L\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010\u00042\u0006\u0010M\u001a\u00020\u00122\b\b\u0002\u0010N\u001a\u00020\u00122\b\b\u0002\u0010O\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/util/MiniGameVAUtil;", "", "()V", "DEFAULT_META_DEEP_LINK", "", "GAME_DATA_EXTEND", "HIPPY_MQQ_SCHEMA_PREFIX", "KEY_ALLOW_WIFI_AUTO_DOWNLOAD_VA", "KEY_ALLOW_WIFI_AUTO_UPGRADE_VA", "KEY_META_MINI_GAME_ACTIVITY_ANIM_DURATION", "KEY_META_MINI_GAME_ACTIVITY_ANIM_START_TS", "META_MINI_GAME_ACTIVITY_DURATION", "", "META_MINI_GAME_APPID", "REPORT_EXT7_TYPE_YUN_GAME", "TAG", "URL_PARAM_KEY_GAME_DATA", "canRedirectMeta", "", "appId", "debugToast", "", "gameVersion", "ext7", "ext8", "enableRestartGameWithLebaRedInfo", "findGameDataFromHippySchema", QZoneDTLoginReporter.SCHEMA, "getCurrentUinFromAppRuntime", "getGameAppGameData", "launchParams", MiniGameVAUtil.URL_PARAM_KEY_GAME_DATA, "getGameAppVersionCode", "gameAppPkgName", "getLastEnterYunGame", "getRedirectMeta", "firstPage", "getUseWifiAndXGSwitch", "getWifiAutoDownloadVAAppIds", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getWifiAutoUpgradeVAFlag", VirtualAppProxy.KEY_GAME_ID, "(Ljava/lang/String;)Ljava/lang/Boolean;", "getWifiAutoUpgradeVAFlagAppIds", "handleInnerStorageDownloadFailed", "vaService", "Lcom/tencent/mobileqq/minigame/va/MiniGameVAImpl;", "hasVaApkInstall", PushClientConstants.TAG_PKG_NAME, "isPagReady", "launchGameApp", "context", "Landroid/content/Context;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/minigame/config/MiniGameVAInterceptConfig$VAInterceptConfig;", "callback", "Lcom/tencent/mobileqq/minigame/api/MiniGameVAInterceptCallback;", "startInterceptTime", "", "scene", "via", "matchGameDataForFirstPage", "needStopBackgroundGame", "recordWifiAutoDownloadVAFlag", "reportLaunch", "gameAppId", "launchTime", "setEnterYunGame", "setUseWifiAndXGSwitch", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "showDebugToast", "text", "showDownloadToastInDebug", "data", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;", "updateWifiAutoUpgradeVAFlag", "autoUpgrade", FileReaderHelper.OPEN_FILE_FROM_FORCE, "updateToBackend", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVAUtil {
    private static final String DEFAULT_META_DEEP_LINK = "%7B%22jumpType%22%3A5%2C%22jumpId%22%3A1%2C%22jumpParams%22%3A%7B%22JQCallInfo%22%3A%22%7B%5C%22CallType%5C%22%3A9%2C%5C%22GameType%5C%22%3A%5C%22666%5C%22%7D%22%7D%7D";
    private static final String GAME_DATA_EXTEND = "cd_extendInfo";
    private static final String HIPPY_MQQ_SCHEMA_PREFIX = "mqqapi://hippy/open?";
    public static final MiniGameVAUtil INSTANCE = new MiniGameVAUtil();
    public static final String KEY_ALLOW_WIFI_AUTO_DOWNLOAD_VA = "allow_wifi_auto_download_va";
    public static final String KEY_ALLOW_WIFI_AUTO_UPGRADE_VA = "allow_wifi_auto_upgrade_va";
    public static final String KEY_META_MINI_GAME_ACTIVITY_ANIM_DURATION = "meta_anim_duration";
    public static final String KEY_META_MINI_GAME_ACTIVITY_ANIM_START_TS = "meta_anim_start_ts";
    public static final int META_MINI_GAME_ACTIVITY_DURATION = 430;
    public static final String META_MINI_GAME_APPID = "1112288843";
    public static final String REPORT_EXT7_TYPE_YUN_GAME = "3";
    private static final String TAG = "MiniGameVAUtil";
    private static final String URL_PARAM_KEY_GAME_DATA = "gamedata";

    MiniGameVAUtil() {
    }

    @JvmStatic
    public static final boolean canRedirectMeta(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (AppSetting.isPublicVersion() || !Intrinsics.areEqual(META_MINI_GAME_APPID, appId)) {
            return false;
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(mqq.app.MobileQQ.\u2026QMMKVFile.FILE_MINI_GAME)");
        return !TextUtils.isEmpty(fromV2.decodeString(MiniGameVAMMKVKEY.MINIGAME_YUN_ID, ""));
    }

    @JvmStatic
    private static final void debugToast(final String gameVersion, final String ext7, final String ext8) {
        if (AppSetting.isPublicVersion()) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.util.f
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameVAUtil.debugToast$lambda$1(ext7, ext8, gameVersion);
            }
        });
    }

    @JvmStatic
    private static final boolean enableRestartGameWithLebaRedInfo() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105895", false);
    }

    private final String findGameDataFromHippySchema(String schema) {
        int indexOf$default;
        Map<String, String> argumentsFromURL;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) schema, HIPPY_MQQ_SCHEMA_PREFIX, 0, false, 6, (Object) null);
        if (indexOf$default < 0) {
            return null;
        }
        String substring = schema.substring(indexOf$default + 20 + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        Map<String, String> arguments = URLUtil.getArguments(URLUtil.decodeUrl(substring));
        String str = arguments != null ? arguments.get("url") : null;
        if (str == null || (argumentsFromURL = URLUtil.getArgumentsFromURL(URLUtil.decodeUrl(str))) == null) {
            return null;
        }
        return argumentsFromURL.get(URL_PARAM_KEY_GAME_DATA);
    }

    @JvmStatic
    public static final String getCurrentUinFromAppRuntime() {
        String account;
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            peekAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        }
        if (!TextUtils.isEmpty(peekAppRuntime.getCurrentUin())) {
            account = peekAppRuntime.getCurrentUin();
            str = "appRuntime.currentUin";
        } else {
            account = peekAppRuntime.getAccount();
            str = "appRuntime.account";
        }
        Intrinsics.checkNotNullExpressionValue(account, str);
        return account;
    }

    @JvmStatic
    public static final String getGameAppGameData(String launchParams, String gamedata) {
        Intrinsics.checkNotNullParameter(launchParams, "launchParams");
        if (gamedata == null || gamedata.length() == 0) {
            return launchParams;
        }
        try {
            String encodeUrl = URLUtil.encodeUrl(gamedata);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(launchParams, Arrays.copyOf(new Object[]{URLUtil.encodeUrl(encodeUrl)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "getGameAppGameData exception:", e16);
            return launchParams;
        }
    }

    @JvmStatic
    public static final int getGameAppVersionCode(String gameAppPkgName) {
        PackageInfo packageInfo;
        Intrinsics.checkNotNullParameter(gameAppPkgName, "gameAppPkgName");
        try {
            packageInfo = PackageUtil.getPackageInfo(MobileQQ.sMobileQQ.getApplicationContext(), gameAppPkgName);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getGameAppVersionCode getPackageInfo exception:", e16);
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    @JvmStatic
    public static final boolean getLastEnterYunGame() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026QMMKVFile.FILE_MINI_GAME)");
        return System.currentTimeMillis() - fromV2.decodeLong(MiniGameVAMMKVKEY.MINIGAME_LAUNCH_VA, 0L) < 172800000;
    }

    @JvmStatic
    public static final String getRedirectMeta(String firstPage) {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(mqq.app.MobileQQ.\u2026QMMKVFile.FILE_MINI_GAME)");
        String decodeString = fromV2.decodeString(MiniGameVAMMKVKEY.MINIGAME_YUN_ID, "");
        if (TextUtils.isEmpty(decodeString)) {
            return firstPage;
        }
        return firstPage + "&yungame_id=" + decodeString;
    }

    @JvmStatic
    public static final boolean getUseWifiAndXGSwitch() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026QMMKVFile.FILE_MINI_GAME)");
        return fromV2.decodeBool(MiniGameVAMMKVKEY.MINIGAME_USE_WIFI_AND_XG_SWITCH, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r2, new java.lang.String[]{";"}, false, 0, 6, (java.lang.Object) null);
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final HashSet<String> getWifiAutoDownloadVAAppIds() {
        List split$default;
        HashSet<String> hashSet;
        String string = MiniAppMMKVUtils.getString(KEY_ALLOW_WIFI_AUTO_DOWNLOAD_VA, null);
        if (string == null || split$default == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            String str = (String) obj;
            if (!(str == null || str.length() == 0)) {
                arrayList.add(obj);
            }
        }
        hashSet = CollectionsKt___CollectionsKt.toHashSet(arrayList);
        return hashSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r2, new java.lang.String[]{";"}, false, 0, 6, (java.lang.Object) null);
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final HashSet<String> getWifiAutoUpgradeVAFlagAppIds() {
        List split$default;
        HashSet<String> hashSet;
        String string = MiniAppMMKVUtils.getString(KEY_ALLOW_WIFI_AUTO_UPGRADE_VA, null);
        if (string == null || split$default == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            String str = (String) obj;
            if (!(str == null || str.length() == 0)) {
                arrayList.add(obj);
            }
        }
        hashSet = CollectionsKt___CollectionsKt.toHashSet(arrayList);
        return hashSet;
    }

    @JvmStatic
    public static final void handleInnerStorageDownloadFailed(final MiniGameVAImpl vaService, final String appId) {
        Intrinsics.checkNotNullParameter(vaService, "vaService");
        Intrinsics.checkNotNullParameter(appId, "appId");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.util.g
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameVAUtil.handleInnerStorageDownloadFailed$lambda$8(MiniGameVAImpl.this, appId);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleInnerStorageDownloadFailed$lambda$8(MiniGameVAImpl vaService, String appId) {
        Intrinsics.checkNotNullParameter(vaService, "$vaService");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        ((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).setInnerStorageDownloadFailed(true);
        DiffPatchHandler.resDownloadVa(vaService, appId);
    }

    @JvmStatic
    public static final boolean hasVaApkInstall(String pkgName) {
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        if (TextUtils.isEmpty(MiniBoxSDK.getDexVersion(BaseApplication.getContext()))) {
            return false;
        }
        return new File(MiniBoxSDK.getApkPath(BaseApplication.getContext(), pkgName)).exists();
    }

    @JvmStatic
    public static final boolean isPagReady() {
        boolean initPagSo = ((IVasTempApi) QRoute.api(IVasTempApi.class)).initPagSo();
        if (!initPagSo) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.util.e
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGameVAUtil.isPagReady$lambda$7();
                }
            }, 128, null, false);
        }
        return initPagSo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isPagReady$lambda$7() {
        ((IVasTempApi) QRoute.api(IVasTempApi.class)).requestPagDownload(new Function0<Unit>() { // from class: com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil$isPagReady$1$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QLog.i("MiniGameVAUtil", 1, "isPagReady requestPagDownload finish");
            }
        });
    }

    @JvmStatic
    public static final String matchGameDataForFirstPage(String pkgName, String firstPage) {
        boolean startsWith$default;
        boolean contains$default;
        boolean contains$default2;
        int indexOf$default;
        if (TextUtils.isEmpty(firstPage) || !Intrinsics.areEqual(pkgName, "com.tencent.letsgo")) {
            return null;
        }
        QLog.i(TAG, 1, "matchUriForFirstPage firstPage:" + firstPage);
        Intrinsics.checkNotNull(firstPage);
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(firstPage, "http", false, 2, null);
        if (!startsWith$default) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) firstPage, (CharSequence) "cd_extendInfo=", false, 2, (Object) null);
            if (contains$default) {
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) firstPage, GAME_DATA_EXTEND, 0, false, 6, (Object) null);
                firstPage = firstPage.substring(indexOf$default + 13 + 1);
                Intrinsics.checkNotNullExpressionValue(firstPage, "this as java.lang.String).substring(startIndex)");
            } else {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) firstPage, (CharSequence) HIPPY_MQQ_SCHEMA_PREFIX, false, 2, (Object) null);
                if (contains$default2) {
                    firstPage = INSTANCE.findGameDataFromHippySchema(firstPage);
                }
            }
        } else {
            Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(firstPage);
            firstPage = argumentsFromURL.get(URL_PARAM_KEY_GAME_DATA);
            if (firstPage == null) {
                firstPage = argumentsFromURL.get(GAME_DATA_EXTEND);
            }
            if (TextUtils.isEmpty(firstPage)) {
                return null;
            }
        }
        if (firstPage == null) {
            return null;
        }
        return URLUtil.decodeUrl(firstPage);
    }

    @JvmStatic
    public static final boolean needStopBackgroundGame(int scene, String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (scene == 2079 && Intrinsics.areEqual(META_MINI_GAME_APPID, appId)) {
            if (!enableRestartGameWithLebaRedInfo()) {
                QLog.i(TAG, 1, "needStopBackgroundGame: enableRestartGameWithLebaRedInfo false.");
                return false;
            }
            if (((IMiniGameLebaController) QRoute.api(IMiniGameLebaController.class)).hasRedInfo()) {
                QLog.i(TAG, 1, "needStopBackgroundGame: hasRedInfo return true, appId=" + appId);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportLaunch$lambda$0(String gameAppId) {
        Intrinsics.checkNotNullParameter(gameAppId, "$gameAppId");
        YunGameProxy yunGameProxy = (YunGameProxy) ProxyManager.get(YunGameProxy.class);
        if (yunGameProxy instanceof YunGameProxyImpl) {
            ((YunGameProxyImpl) yunGameProxy).r(gameAppId);
        }
    }

    @JvmStatic
    public static final void setEnterYunGame() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026QMMKVFile.FILE_MINI_GAME)");
        fromV2.encodeLong(MiniGameVAMMKVKEY.MINIGAME_LAUNCH_VA, System.currentTimeMillis());
    }

    @JvmStatic
    public static final void setUseWifiAndXGSwitch(boolean r26) {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026QMMKVFile.FILE_MINI_GAME)");
        fromV2.encodeBool(MiniGameVAMMKVKEY.MINIGAME_USE_WIFI_AND_XG_SWITCH, r26);
    }

    @JvmStatic
    public static final void showDebugToast(final String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (AppSetting.isPublicVersion()) {
            return;
        }
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            QQToast.makeText(BaseApplication.getContext(), text, 1).show();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.util.d
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGameVAUtil.showDebugToast$lambda$9(text);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDebugToast$lambda$9(String text) {
        Intrinsics.checkNotNullParameter(text, "$text");
        QQToast.makeText(BaseApplication.getContext(), text, 1).show();
    }

    @JvmStatic
    public static final void showDownloadToastInDebug(MiniGameDownloadDataWrapper data) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getData().getDiffPatchInfo() != null) {
            str = "\u4e0b\u8f7d\u589e\u91cf\u5305";
        } else {
            str = "\u4e0b\u8f7d\u5b8c\u6574\u5b89\u88c5\u5305";
        }
        showDebugToast(str + data.getData().getVersionCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void debugToast$lambda$1(String str, String str2, String str3) {
        String str4;
        try {
            String dexVersion = MiniBoxSDK.getDexVersion(BaseApplication.getContext());
            if (Intrinsics.areEqual(str, "2")) {
                str4 = "VA";
            } else {
                str4 = "\u4e91\u6e38\u620f";
            }
            QQToast.makeText(BaseApplication.getContext(), -1, str4 + ",\u6761\u4ef6:" + str2 + ",d:" + dexVersion + ",g:" + str3, 1).show();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "debugToast exception:", e16);
        }
    }

    @JvmStatic
    public static final void recordWifiAutoDownloadVAFlag(String gameId) {
        List split$default;
        HashSet hashSet;
        boolean contains;
        String string = MiniAppMMKVUtils.getString(KEY_ALLOW_WIFI_AUTO_DOWNLOAD_VA, null);
        QLog.i(TAG, 2, "recordWifiAutoDownloadVAFlag gameId:" + gameId + ", oldConfig:" + string);
        if (!(string == null || string.length() == 0)) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) string, new String[]{";"}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            for (Object obj : split$default) {
                String str = (String) obj;
                if (!(str == null || str.length() == 0)) {
                    arrayList.add(obj);
                }
            }
            hashSet = CollectionsKt___CollectionsKt.toHashSet(arrayList);
            contains = CollectionsKt___CollectionsKt.contains(hashSet, gameId);
            if (contains) {
                return;
            }
            MiniAppMMKVUtils.putString(KEY_ALLOW_WIFI_AUTO_DOWNLOAD_VA, string + ";" + gameId);
            return;
        }
        MiniAppMMKVUtils.putString(KEY_ALLOW_WIFI_AUTO_DOWNLOAD_VA, gameId);
    }

    @JvmStatic
    public static final void launchGameApp(Context context, final MiniGameVAInterceptConfig.VAInterceptConfig config, String gamedata, final MiniGameVAInterceptCallback callback, final long startInterceptTime, final int scene, final String via) {
        String str = gamedata;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d(TAG, 1, "launchGameApp gamedata:" + str);
        if (str == null || gamedata.length() == 0) {
            try {
                str = URLUtil.decodeUrl(config.getGameAppDefaultDeepLink());
                QLog.d(TAG, 1, "launchGameApp gamedata from config:" + str);
            } catch (Exception e16) {
                QLog.d(TAG, 1, "launchGameApp decode gameAppDefaultDeepLink exception:", e16);
            }
        }
        if ((str == null || str.length() == 0) && Intrinsics.areEqual(META_MINI_GAME_APPID, config.getMiniGameId())) {
            try {
                str = URLUtil.decodeUrl(DEFAULT_META_DEEP_LINK);
                QLog.d(TAG, 1, "launchGameApp gamedata from hardcode:" + str);
            } catch (Exception e17) {
                QLog.d(TAG, 1, "launchGameApp decode DEFAULT_META_DEEP_LINK exception:", e17);
            }
        }
        MiniGameAppLaunchHelper.getInstance().launchApp(context, config.getGameAppId(), config.getGameAppPkgName(), config.getGameAppLaunchFlags(), getGameAppGameData(config.getGameAppLaunchParams(), str), new MiniGameAppLaunchResultCallback() { // from class: com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil$launchGameApp$1
            @Override // com.tencent.mobileqq.minigame.api.impl.MiniGameAppLaunchResultCallback
            public void onResult(boolean isSuccess) {
                QLog.d("MiniGameVAUtil", 1, "launchGameApp isSuccess:" + isSuccess);
                if (isSuccess) {
                    MiniGameVAInterceptCallback.DefaultImpls.onInterceptResult$default(MiniGameVAInterceptCallback.this, true, false, 2, null);
                    MiniGameVAUtil.reportLaunch(config.getGameAppId(), "1", "", String.valueOf(MiniGameVAUtil.getGameAppVersionCode(config.getGameAppPkgName())), System.currentTimeMillis() - startInterceptTime, scene, via);
                } else {
                    MiniGameVAInterceptCallback.this.onInterceptResult(false, Intrinsics.areEqual(MiniGameVAUtil.META_MINI_GAME_APPID, config.getMiniGameId()));
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        r2 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r4, new java.lang.String[]{";"}, false, 0, 6, (java.lang.Object) null);
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Boolean getWifiAutoUpgradeVAFlag(String gameId) {
        HashSet hashSet;
        List split$default;
        if (gameId == null || gameId.length() == 0) {
            QLog.e(TAG, 1, "getWifiAutoUpgradeVAFlag but gameId invalid");
            return Boolean.FALSE;
        }
        String string = MiniAppMMKVUtils.getString(KEY_ALLOW_WIFI_AUTO_UPGRADE_VA, null);
        if (string == null || split$default == null) {
            hashSet = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj : split$default) {
                String str = (String) obj;
                if (!(str == null || str.length() == 0)) {
                    arrayList.add(obj);
                }
            }
            hashSet = CollectionsKt___CollectionsKt.toHashSet(arrayList);
        }
        if (hashSet != null) {
            return Boolean.valueOf(hashSet.contains(gameId));
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        r6 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r12, new java.lang.String[]{";"}, false, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void updateWifiAutoUpgradeVAFlag(String gameId, boolean autoUpgrade, boolean force, boolean updateToBackend) {
        String joinToString$default;
        List split$default;
        boolean z16 = false;
        boolean z17 = true;
        if (gameId == null || gameId.length() == 0) {
            QLog.e(TAG, 1, "updateWifiAutoUpgradeVAFlag but gameId invalid");
            return;
        }
        HashSet hashSet = null;
        String string = MiniAppMMKVUtils.getString(KEY_ALLOW_WIFI_AUTO_UPGRADE_VA, null);
        QLog.i(TAG, 2, "updateWifiAutoUpgradeVAFlag gameId:" + gameId + ", oldConfig:" + string);
        if ((string == null || string.length() == 0) && autoUpgrade) {
            MiniAppMMKVUtils.putString(KEY_ALLOW_WIFI_AUTO_UPGRADE_VA, gameId);
        } else {
            if (string != null && split$default != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : split$default) {
                    String str = (String) obj;
                    if (!(str == null || str.length() == 0)) {
                        arrayList.add(obj);
                    }
                }
                hashSet = CollectionsKt___CollectionsKt.toHashSet(arrayList);
            }
            if (hashSet != null && hashSet.contains(gameId)) {
                z16 = true;
            }
            if (z16) {
                if (!autoUpgrade && force) {
                    hashSet.remove(gameId);
                    joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(hashSet, ";", null, null, 0, null, null, 62, null);
                    QLog.i(TAG, 2, "updateWifiAutoUpgradeVAFlag gameId:" + gameId + ", newConfig:" + joinToString$default);
                    MiniAppMMKVUtils.putString(KEY_ALLOW_WIFI_AUTO_UPGRADE_VA, joinToString$default);
                }
                if (updateToBackend) {
                    return;
                }
                MiniAppSSORequestClient.INSTANCE.sendReq(new MiniGameWifiAutoDownloadRequest(gameId, z17), new MiniAppSSOReqCallback() { // from class: com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil$updateWifiAutoUpgradeVAFlag$1
                    @Override // com.tencent.mobileqq.mini.server.MiniAppSSOReqCallback
                    public void onResponse(MiniAppSSOResponse response) {
                        QLog.d("MiniGameVAUtil", 1, "wifi auth download response retCode:" + (response != null ? Integer.valueOf(response.getRetCode()) : null));
                    }
                });
                return;
            }
            if (autoUpgrade) {
                MiniAppMMKVUtils.putString(KEY_ALLOW_WIFI_AUTO_UPGRADE_VA, string + ";" + gameId);
            }
        }
        z17 = autoUpgrade;
        if (updateToBackend) {
        }
    }

    @JvmStatic
    public static final void reportLaunch(final String gameAppId, String ext7, String ext8, String gameVersion, long launchTime, int scene, String via) {
        Intrinsics.checkNotNullParameter(gameAppId, "gameAppId");
        HashMap hashMap = new HashMap();
        boolean z16 = true;
        if (!(gameVersion == null || gameVersion.length() == 0)) {
            hashMap.put("ext6", gameVersion);
        }
        if (!(ext7 == null || ext7.length() == 0)) {
            hashMap.put("ext7", ext7);
        }
        if (!(ext8 == null || ext8.length() == 0)) {
            hashMap.put("ext8", ext8);
        }
        hashMap.put("ext16", String.valueOf(scene));
        hashMap.put("ext46", String.valueOf(launchTime));
        if (via != null && via.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            hashMap.put("ext17", via);
        }
        MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "929204", "20", gameAppId, hashMap);
        debugToast(gameVersion, ext7, ext8);
        if (Intrinsics.areEqual(ext7, "3")) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.util.c
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGameVAUtil.reportLaunch$lambda$0(gameAppId);
                }
            }, 128, null, false);
        }
        setEnterYunGame();
    }

    public static /* synthetic */ void updateWifiAutoUpgradeVAFlag$default(String str, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        if ((i3 & 8) != 0) {
            z18 = true;
        }
        updateWifiAutoUpgradeVAFlag(str, z16, z17, z18);
    }
}
