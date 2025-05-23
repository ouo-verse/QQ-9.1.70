package com.tencent.mobileqq.mini.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.guild.robot.api.model.GuildChannel;
import com.tencent.mobileqq.guild.temp.api.IGuildChatPieUtilsApi;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.DangerousPersonToastUtils;
import com.tencent.mobileqq.mini.mainpage.MainPageFragment;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.mini.utils.MiniAppMMKVUtils;
import com.tencent.mobileqq.minigame.config.MiniGameCenterLaunchConfig;
import com.tencent.mobileqq.minigame.config.WxMiniGameCenterLaunchConfig;
import com.tencent.mobileqq.minigame.minigamecenter.hippy.MiniGameCenterHippyFragment;
import com.tencent.mobileqq.minigame.utils.EntryConstants;
import com.tencent.mobileqq.minigame.utils.FeatureSwitchUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.FileMaterialInfo;
import com.tencent.util.URLUtil;
import common.config.service.QzoneConfig;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppLauncher {
    private static final String CONFIG_SPLIT = ",";
    private static final String KEY_FROM_PLACEHOLDER = "{from}";
    private static final String KEY_MINI_APP_LAST_USE_TIME = "key_mini_app_last_use_time";
    private static final String KEY_SCENE = "referer";
    private static final String KEY_TOGGLE_SCENE = "minigame_read_scene_from_schema";
    private static final String Q_STR_KEY = "_q";
    private static final String SIG_STR_KEY = "_sig=";
    private static final String SPK_TASK_KEY = "spk_taskkey";
    private static final String TAG = "MiniAppLauncher";
    private static final String URL_PATTERN_OF_AD_SCHEME = "mqqapi://miniapp/adopen(/[0-9]+)?\\?";
    private static final String URL_PREFIX_HTTP_MINIAPP_AD_REAL_HEAD_SCHEME_V3 = "mqqapi://miniapp/adopen";
    private static final String URL_PREFIX_HTTP_MINIAPP_BIND_WX_SCHEME = "mqqapi://miniapp/bindwx?";
    private static final String URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_SCHEME_V1 = "mqqapi://microapp/open?";
    private static final String URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_SCHEME_V2 = "mqqapi://miniapp/open?";
    private static final String URL_PREFIX_HTTP_MINIAPP_VIRTUAL_MANAGE = "mqqapi://miniapp/virtualmanage?";
    private static final String URL_PREFIX_MINIAPP_URL = "https://m.q.qq.com/a/";
    private static final String URL_PREFIX_MINIAPP_URL_HTTP = "https://m.q.qq.com/a/";
    private static ArrayList<String> arkSceneWhiteList;
    private static String mArkSceneWhiteListConfig;
    static long mLastGameTime;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface MiniAppLaunchListener {
        void onLaunchResult(boolean z16, Bundle bundle);
    }

    private static String buildGuildExtData(t02.b bVar) {
        new GuildChannel();
        throw null;
    }

    public static boolean decodeScheme(String str, HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return false;
        }
        try {
            String[] split = str.split("\\?");
            if (split.length >= 2 && split[0].length() != 0) {
                String[] split2 = str.substring(split[0].length() + 1).split(ContainerUtils.FIELD_DELIMITER);
                if (split2 != null) {
                    for (String str2 : split2) {
                        String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (split3 != null && split3.length == 2) {
                            hashMap.put(split3[0], split3[1]);
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "startMiniApp open microapp key=" + split3[0] + ", value=" + split3[1]);
                            }
                        }
                    }
                }
                return true;
            }
            QLog.e(TAG, 1, "startMiniApp parameter error:" + str);
            return false;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "launchMiniApp SchemeV1 parameter error:", th5);
            return false;
        }
    }

    public static long getLastMiniAppUsedTime() {
        return MiniAppMMKVUtils.getLong(KEY_MINI_APP_LAST_USE_TIME, 0L);
    }

    private static LaunchParam getLaunchParam(Context context, String str, int i3, EntryModel entryModel) {
        LaunchParam launchParam = new LaunchParam();
        launchParam.scene = i3;
        QMLog.d(TAG, "getLaunchParam" + launchParam.scene);
        launchParam.fakeUrl = str;
        launchParam.spkTaskKey = parseSpkTaskKey(str);
        if (entryModel != null) {
            launchParam.entryModel = entryModel;
            launchParam.reportData = entryModel.reportData;
        }
        tryGetGuildChatContext(context);
        launchParam.extendData = getExtendDataFromEntryMode(entryModel);
        return launchParam;
    }

    public static OpenHippyInfo getMiniGameCenterHippyInfo(String str, boolean z16) {
        TabPreloadItem.PreloadType preloadType;
        OpenHippyInfo openHippyInfo = new OpenHippyInfo();
        openHippyInfo.bundleName = HippyQQConstants.ModuleName.QQ_MINI_GAME_CENTER;
        openHippyInfo.domain = "qzone.qq.com";
        openHippyInfo.url = "";
        openHippyInfo.processName = "main";
        openHippyInfo.isAnimated = true;
        openHippyInfo.isPreloadWhenClosed = z16;
        if (z16) {
            preloadType = TabPreloadItem.PreloadType.PRE_DRAW;
        } else {
            preloadType = TabPreloadItem.PreloadType.NO_PRELOAD;
        }
        openHippyInfo.preloadType = preloadType;
        openHippyInfo.isPredrawWhenClosed = z16;
        if (EntryConstants.DropdownEntry.DROPDOWN_ENTRY_LIST.contains(str)) {
            openHippyInfo.preloadTabName = TabPreloadItem.TAB_NAME_MESSAGE;
        }
        openHippyInfo.fragmentClass = MiniGameCenterHippyFragment.class;
        openHippyInfo.from = str;
        return openHippyInfo;
    }

    public static boolean isFakeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("https://m.q.qq.com/a/") || str.startsWith("https://m.q.qq.com/a/");
    }

    private static boolean isMiniAppADSchemeV3(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(URL_PREFIX_HTTP_MINIAPP_AD_REAL_HEAD_SCHEME_V3);
    }

    public static boolean isMiniAppDetailUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^(http|https)://m.q.qq.com/a/d/.*");
    }

    public static boolean isMiniAppScheme(String str) {
        return isMiniAppSchemeV1(str) || isMiniAppSchemeV2(str) || isMiniAppADSchemeV3(str);
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
        return isFakeUrl(str) || isMiniAppScheme(str);
    }

    private static boolean isVirtualAppManageScheme(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(URL_PREFIX_HTTP_MINIAPP_VIRTUAL_MANAGE);
    }

    private static void jumpToDetailPage(final String str) {
        MiniAppCmdUtil.getInstance().getAppInfoByLink(str, 0, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.sdk.MiniAppLauncher.1
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, final JSONObject jSONObject) {
                if (z16) {
                    MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("appInfo");
                    if (miniAppInfo != null) {
                        String optString = jSONObject.optString("shareTicket", "");
                        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
                        LaunchParam launchParam = new LaunchParam();
                        miniAppConfig.launchParam = launchParam;
                        launchParam.miniAppId = miniAppInfo.appId;
                        launchParam.shareTicket = optString;
                        MainPageFragment.launch(BaseActivity.sTopActivity, miniAppConfig, miniAppInfo.verType);
                        return;
                    }
                    return;
                }
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.sdk.MiniAppLauncher.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        JSONObject jSONObject2 = jSONObject;
                        if (jSONObject2 != null) {
                            DangerousPersonToastUtils.shareErrorToast(BaseApplication.getContext(), jSONObject2.optInt("retCode"), jSONObject.optString("errMsg"), 0);
                            return;
                        }
                        QQToast.makeText(BaseApplication.getContext(), 1, R.string.f171176cx2, 0).show();
                    }
                });
                QLog.e(MiniAppLauncher.TAG, 1, "jumpToDetailPage: launch failed with url " + str);
            }
        });
    }

    public static void launchAppByAppConfig(Activity activity, MiniAppConfig miniAppConfig, ResultReceiver resultReceiver) {
        MiniAppController.startApp(activity, miniAppConfig, resultReceiver);
    }

    public static void launchAppByAppInfo(Activity activity, MiniAppInfo miniAppInfo, int i3) throws MiniAppException {
        LaunchParam launchParam = new LaunchParam();
        launchParam.scene = i3;
        MiniAppController.launchMiniAppByAppInfo(activity, miniAppInfo, launchParam, null, null);
    }

    public static void launchAppByMiniCode(Context context, String str, int i3, MiniAppLaunchListener miniAppLaunchListener) {
        LaunchParam launchParam = new LaunchParam();
        launchParam.scene = i3;
        launchParam.fakeUrl = str;
        MiniAppController.startAppByLink(context, str, 1, launchParam, miniAppLaunchListener);
    }

    public static void launchMiniAppById(Context context, String str, String str2, String str3, String str4, String str5, int i3, MiniAppLaunchListener miniAppLaunchListener) {
        LaunchParam launchParam = new LaunchParam();
        launchParam.miniAppId = str;
        launchParam.scene = i3;
        launchParam.envVersion = str4;
        launchParam.entryPath = str2;
        launchParam.navigateExtData = str3;
        launchParam.reportData = str5;
        MiniAppController.startAppByAppid(context, str, str2, str4, launchParam, miniAppLaunchListener);
    }

    public static void launchMiniAppByIdWithFile(Context context, String str, String str2, String str3, int i3, List<FileMaterialInfo> list) {
        LaunchParam launchParam = new LaunchParam();
        launchParam.miniAppId = str;
        launchParam.scene = i3;
        launchParam.envVersion = str3;
        launchParam.entryPath = str2;
        launchParam.fileMaterialInfoList = list;
        MiniAppController.startAppByAppid(context, str, str2, str3, launchParam, null);
    }

    public static boolean launchMiniAppByScheme(Context context, HashMap<String, String> hashMap, LaunchParam launchParam, MiniAppLaunchListener miniAppLaunchListener) {
        if (hashMap == null || context == null) {
            return false;
        }
        launchParam.fakeUrl = null;
        if (!TextUtils.isEmpty(hashMap.get("url"))) {
            try {
                launchParam.fakeUrl = URLDecoder.decode(hashMap.get("url"), "UTF-8");
            } catch (Exception e16) {
                QLog.e(TAG, 1, "launchMiniAppByScheme, " + Log.getStackTraceString(e16));
            }
        } else if (!TextUtils.isEmpty(hashMap.get("fakeUrl"))) {
            launchParam.fakeUrl = hashMap.get("fakeUrl");
        } else if (!TextUtils.isEmpty(hashMap.get("appid"))) {
            launchParam.miniAppId = hashMap.get("appid");
            String str = hashMap.get("path");
            String str2 = hashMap.get(WadlProxyConsts.EXTRA_DATA);
            String str3 = hashMap.get("envVersion");
            final String str4 = launchParam.miniAppId;
            try {
                if (!TextUtils.isEmpty(str)) {
                    launchParam.entryPath = URLDecoder.decode(str, "UTF-8");
                }
                if (!TextUtils.isEmpty(str2)) {
                    launchParam.extendData = URLDecoder.decode(str2, "UTF-8");
                }
                if (!TextUtils.isEmpty(str3)) {
                    launchParam.envVersion = URLDecoder.decode(str3, "UTF-8");
                }
            } catch (UnsupportedEncodingException e17) {
                QLog.e(TAG, 1, "launchMiniAppByScheme, " + Log.getStackTraceString(e17));
            }
            if (!verifyAppid(str4)) {
                QLog.e(TAG, 1, "Appid is forbidden\uff1a " + str4);
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.sdk.MiniAppLauncher.4
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.o7j) + str4, 1).show();
                    }
                });
                return false;
            }
        }
        String str5 = hashMap.get("appid");
        if (TextUtils.isEmpty(str5)) {
            str5 = hashMap.get(PreloadingFragment.KEY_APPID);
        }
        QLog.i(TAG, 1, "launchMiniAppByScheme appid:" + str5 + ", param:" + launchParam);
        if (!verifyAppid_Scence_Fakeurl_Model(str5, launchParam.scene, launchParam.fakeUrl)) {
            QLog.e(TAG, 1, "Appid is\uff1a " + str5 + ",scence:" + launchParam.scene + ",fakeurl:" + launchParam.fakeUrl + " is forbidden!!!");
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.sdk.MiniAppLauncher.5
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.o7j), 1).show();
                }
            });
            return false;
        }
        return openMiniApp(context, launchParam, miniAppLaunchListener);
    }

    public static void launchMiniGameCenter(Context context, String str) {
        launchMiniGameCenter(context, str, null);
    }

    private static void launchVirtualAppManagePage(final Context context, final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.sdk.MiniAppLauncher.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = URLUtil.getArgumentsFromURL(str).get("_data");
                        try {
                            str2 = URLDecoder.decode(str2, "UTF-8");
                        } catch (Exception e16) {
                            QLog.e(MiniAppLauncher.TAG, 1, "[launchVirtualAppManagePage]", e16);
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).startMiniBoxManagerPage(context, str2, null);
                        } else {
                            QLog.e(MiniAppLauncher.TAG, 1, "[launchVirtualAppManagePage] parameter error");
                        }
                        QLog.i(MiniAppLauncher.TAG, 2, "[launchVirtualAppManagePage] cost:" + (System.currentTimeMillis() - currentTimeMillis));
                    } else {
                        QLog.e(MiniAppLauncher.TAG, 1, "[launchVirtualAppManagePage] url isEmpty");
                    }
                }
            }
        }, 16, null, true);
    }

    public static void launchWxMiniGameCenter(Context context) {
        String str;
        WxMiniGameCenterLaunchConfig wxMiniGameCenterLaunchConfig = (WxMiniGameCenterLaunchConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(WxMiniGameCenterLaunchConfig.CONFIG_ID);
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (wxMiniGameCenterLaunchConfig != null && !TextUtils.isEmpty(wxMiniGameCenterLaunchConfig.getScheme())) {
            str = wxMiniGameCenterLaunchConfig.getScheme();
        } else {
            str = WxMiniGameCenterLaunchConfig.DEFAULT_SCHEME;
        }
        try {
            ax c16 = bi.c(qQAppInterface, context, str);
            if (c16 == null || !c16.b()) {
                return;
            }
            QLog.i(TAG, 1, "launchWxMiniGameCenter: start by action.");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "launchWxMiniGameCenter: failed, exception=", e16);
        }
    }

    public static void markMiniAppUsed(long j3) {
        MiniAppMMKVUtils.putLong(KEY_MINI_APP_LAST_USE_TIME, j3);
    }

    private static boolean openMiniApp(Context context, LaunchParam launchParam, MiniAppLaunchListener miniAppLaunchListener) {
        QLog.i(TAG, 2, "launchMiniApp openMiniApp :" + launchParam);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - mLastGameTime <= 1000) {
            return false;
        }
        mLastGameTime = currentTimeMillis;
        launchParam.standardize();
        int i3 = launchParam.scene;
        if (i3 == 1047 || i3 == 1048 || i3 == 1049) {
            launchAppByMiniCode(context, launchParam.fakeUrl, launchParam, miniAppLaunchListener);
        } else if (!TextUtils.isEmpty(launchParam.fakeUrl)) {
            launchAppByFakeLink(context, launchParam.fakeUrl, launchParam, miniAppLaunchListener);
        } else {
            MiniAppController.startAppByAppid(context, launchParam.miniAppId, launchParam.entryPath, launchParam.envVersion, launchParam, miniAppLaunchListener);
        }
        return true;
    }

    private static String parseSpkTaskKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(SPK_TASK_KEY);
        int indexOf2 = str.indexOf(SIG_STR_KEY);
        if (indexOf != -1 && (indexOf2 <= 0 || indexOf2 >= indexOf)) {
            String str2 = URLUtil.getArgumentsFromURL(str).get(Q_STR_KEY);
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            try {
                return URLUtil.getArguments(URLDecoder.decode(str2, "UTF-8")).get(SPK_TASK_KEY);
            } catch (UnsupportedEncodingException e16) {
                QLog.e(TAG, 1, "parseSpkTaskKey: qStr=" + str2 + ";format failed.", e16);
            }
        }
        return null;
    }

    private static int replaceSceneByReferer(String str, int i3) {
        int parseInt;
        if (TextUtils.isEmpty(str)) {
            return i3;
        }
        JSONObject toggleJson = FeatureSwitchUtils.INSTANCE.getToggleJson(KEY_TOGGLE_SCENE, "");
        if (toggleJson == null) {
            QLog.i(TAG, 1, "replaceSceneByReferer: toggle json is null.");
            return i3;
        }
        try {
            parseInt = Integer.parseInt(str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "replaceSceneByReferer: failed referer=" + str, e16);
        }
        if (parseInt == i3) {
            return i3;
        }
        JSONArray optJSONArray = toggleJson.optJSONArray("list");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                if (optJSONArray.getInt(i16) == parseInt) {
                    return parseInt;
                }
            }
            return i3;
        }
        QLog.i(TAG, 1, "replaceSceneByReferer: jsonArray is null.");
        return i3;
    }

    public static boolean startMiniApp(Context context, String str, int i3, MiniAppLaunchListener miniAppLaunchListener) {
        return startMiniApp(context, str, i3, null, miniAppLaunchListener);
    }

    private static t02.b tryGetGuildChatContext(Context context) {
        if (!(context instanceof BaseActivity)) {
            return null;
        }
        BaseActivity baseActivity = (BaseActivity) context;
        if (baseActivity.getChatFragment() == null) {
            return null;
        }
        ((IGuildChatPieUtilsApi) QRoute.api(IGuildChatPieUtilsApi.class)).wrapWith(baseActivity.getChatFragment().qh().e());
        return null;
    }

    private static boolean verifyAppid(String str) {
        try {
            for (String str2 : QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_SCHEME_APPID_WHITE_LIST, MiniAppGlobal.DEFAULT_APPID_WHITE_LIST).split(",")) {
                if (str2.equals(str)) {
                    return true;
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "verify Appid failed: " + e16);
        }
        return false;
    }

    private static boolean verifyAppid_Scence_Fakeurl_Model(String str, int i3, String str2) {
        String g16 = MiniAppConfProcessor.g(QzoneConfig.MINI_APP_SCHEME_OUTSITE_BLACK_LIST, "");
        QLog.i(TAG, 1, "verifyAppid_Scence_Fakeurl_Model appid:" + str + ", scene:" + i3 + ", fakeUrl:" + str2 + ", blackList:" + g16);
        try {
            String str3 = Build.BRAND;
            for (String str4 : g16.split(",")) {
                String[] split = str4.split("\\|");
                if (split.length >= 3) {
                    String str5 = split[0];
                    String str6 = split[1];
                    String str7 = split.length > 3 ? split[3] : null;
                    if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6) && str5.equals(str) && Integer.valueOf(split[1]).intValue() == i3 && (TextUtils.isEmpty(str7) || (!TextUtils.isEmpty(str7) && str7.equals(str2)))) {
                        return false;
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "verify appidWhiteList failed: " + e16);
        }
        return true;
    }

    public static boolean verifyArkScene(int i3) {
        ArrayList<String> arrayList = arkSceneWhiteList;
        if (arrayList == null) {
            String g16 = MiniAppConfProcessor.g(QzoneConfig.MINI_APP_ARK_SCENE_WHITE_LIST, QzoneConfig.DEFAULT_ARK_SCENE_WHITE_LIST);
            if (g16 == null || g16.equals(mArkSceneWhiteListConfig)) {
                return false;
            }
            arkSceneWhiteList = new ArrayList<>();
            try {
                String[] split = g16.split(",");
                if (split != null) {
                    for (String str : split) {
                        if (!TextUtils.isEmpty(str)) {
                            arkSceneWhiteList.add(str);
                        }
                    }
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "verifyArkScene failed  ", th5);
            }
            mArkSceneWhiteListConfig = g16;
            return arkSceneWhiteList.contains(String.valueOf(i3));
        }
        return arrayList.contains(String.valueOf(i3));
    }

    private static void LaunchMiniAppBySchemeRequest(Context context, String str, LaunchParam launchParam, MiniAppLaunchListener miniAppLaunchListener) {
        MiniAppController.startAppByLink(context, str, 2, launchParam, miniAppLaunchListener);
    }

    public static String getExtendDataFromEntryMode(EntryModel entryModel) {
        Bundle bundle;
        if (entryModel != null && (bundle = entryModel.mArguments) != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (String str : bundle.keySet()) {
                    jSONObject.put(str, bundle.get(str));
                }
            } catch (JSONException e16) {
                QLog.d(TAG, 1, "getExtendDataFromEntryMode exception:" + e16);
            }
            String jSONObject2 = jSONObject.toString();
            QLog.d(TAG, 2, "getExtendDataFromEntryMode extendData = " + jSONObject2);
            return jSONObject2;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getExtendDataFromEntryMode, params is empty. EntryModel is null: ");
        sb5.append(entryModel == null);
        QLog.d(TAG, 1, sb5.toString());
        return "";
    }

    private static void launchAppByFakeLink(Context context, String str, LaunchParam launchParam, MiniAppLaunchListener miniAppLaunchListener) {
        MiniAppController.startAppByLink(context, str, 0, launchParam, miniAppLaunchListener);
    }

    private static void launchHippyMiniGameCenter(Context context, String str) {
        ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).openHippyPage(context, getMiniGameCenterHippyInfo(str, false));
    }

    public static void launchMiniGameCenter(Context context, String str, String str2) {
        MiniGameCenterLaunchConfig miniGameCenterLaunchConfig = (MiniGameCenterLaunchConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameCenterLaunchConfig.CONFIG_ID);
        if (miniGameCenterLaunchConfig != null && miniGameCenterLaunchConfig.getIsEnable()) {
            String scheme = miniGameCenterLaunchConfig.getScheme();
            QLog.i(TAG, 1, "launchMiniGameCenter: scheme=" + scheme);
            if (TextUtils.isEmpty(scheme)) {
                launchHippyMiniGameCenter(context, str);
                return;
            }
            try {
                String replace = scheme.replace(KEY_FROM_PLACEHOLDER, str);
                if (!TextUtils.isEmpty(str2)) {
                    replace = URLUtil.addParameter(replace, QAdVrReportParams.ParamKey.EXPERIMENT_ID, str2);
                }
                ax c16 = bi.c((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), context, replace);
                if (c16 != null && c16.b()) {
                    QLog.i(TAG, 1, "launchMiniGameCenter: start by action.");
                    return;
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "launchMiniGameCenter: failed, exception=", e16);
            }
            launchHippyMiniGameCenter(context, str);
            return;
        }
        launchHippyMiniGameCenter(context, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean startMiniApp(Context context, String str, int i3, EntryModel entryModel, MiniAppLaunchListener miniAppLaunchListener) {
        Matcher matcher;
        int i16;
        String str2;
        QLog.i(TAG, 1, "startMiniApp scene:" + i3 + " url:" + str);
        if (BaseActivity.sTopActivity != null) {
            QLog.d(TAG, 1, "cur Activity:" + BaseActivity.sTopActivity.getActivityName() + "  class :" + BaseActivity.sTopActivity.getLocalClassName());
        }
        LaunchParam launchParam = getLaunchParam(context, str, i3, entryModel);
        if (isFakeUrl(str)) {
            if (isMiniAppDetailUrl(str)) {
                jumpToDetailPage(str);
                return true;
            }
            launchAppByFakeLink(context, str, launchParam, miniAppLaunchListener);
            return true;
        }
        if (isMiniAppSchemeV1(str)) {
            HashMap hashMap = new HashMap();
            if (decodeScheme(str, hashMap)) {
                return launchMiniAppByScheme(context, hashMap, launchParam, miniAppLaunchListener);
            }
            return false;
        }
        if (isMiniAppSchemeV2(str)) {
            HashMap hashMap2 = new HashMap();
            try {
                if (decodeScheme(str, hashMap2)) {
                    if (!TextUtils.isEmpty((CharSequence) hashMap2.get("url"))) {
                        str2 = URLDecoder.decode(str, "UTF-8");
                    } else {
                        str2 = !TextUtils.isEmpty((CharSequence) hashMap2.get("fakeUrl")) ? (String) hashMap2.get("fakeUrl") : null;
                    }
                    String str3 = (String) hashMap2.get("appid");
                    if (TextUtils.isEmpty(str3)) {
                        str3 = (String) hashMap2.get(PreloadingFragment.KEY_APPID);
                    } else if (TextUtils.isEmpty(str3)) {
                        str3 = (String) hashMap2.get("_mappid");
                    }
                    if (!verifyAppid_Scence_Fakeurl_Model(str3, i3, str2)) {
                        QLog.e(TAG, 1, "Appid is\uff1a " + str3 + ",scence:" + launchParam.scene + ",fakeurl:" + launchParam.fakeUrl + " is forbidden!!!");
                        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.sdk.MiniAppLauncher.2
                            @Override // java.lang.Runnable
                            public void run() {
                                QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.o7j), 1).show();
                            }
                        });
                        return false;
                    }
                }
            } catch (Throwable unused) {
            }
            launchParam.scene = replaceSceneByReferer((String) hashMap2.get("referer"), launchParam.scene);
            LaunchMiniAppBySchemeRequest(context, str, launchParam, miniAppLaunchListener);
            return true;
        }
        if (isMiniAppADSchemeV3(str)) {
            int i17 = 2054;
            try {
                matcher = Pattern.compile(URL_PATTERN_OF_AD_SCHEME).matcher(str);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "launchMiniApp decode ad scheme scene error url:", str, th5);
            }
            if (matcher.find()) {
                String group = matcher.group();
                if (!TextUtils.isEmpty(group)) {
                    Matcher matcher2 = Pattern.compile("(\\d+)").matcher(group);
                    if (matcher2.find()) {
                        i16 = Integer.parseInt(matcher2.group());
                        if (i16 > 0) {
                            i17 = i16;
                        }
                        launchParam.scene = i17;
                        LaunchMiniAppBySchemeRequest(context, str, launchParam, miniAppLaunchListener);
                        return true;
                    }
                }
            }
            i16 = 2054;
            if (i16 > 0) {
            }
            launchParam.scene = i17;
            LaunchMiniAppBySchemeRequest(context, str, launchParam, miniAppLaunchListener);
            return true;
        }
        if (isVirtualAppManageScheme(str)) {
            launchVirtualAppManagePage(context, str);
            return true;
        }
        QLog.e(TAG, 1, "launchMiniApp parameter error, url=" + str);
        return false;
    }

    public static void launchAppByAppInfo(Activity activity, MiniAppInfo miniAppInfo, int i3, int i16) throws MiniAppException {
        LaunchParam launchParam = new LaunchParam();
        launchParam.scene = i3;
        launchParam.slotId = i16 != 0 ? String.valueOf(i16) : "";
        MiniAppController.launchMiniAppByAppInfo(activity, miniAppInfo, launchParam, null, null);
    }

    private static void launchAppByMiniCode(Context context, String str, LaunchParam launchParam, MiniAppLaunchListener miniAppLaunchListener) {
        MiniAppController.startAppByLink(context, str, 1, launchParam, miniAppLaunchListener);
    }

    public static void launchAppByAppInfo(Activity activity, MiniAppInfo miniAppInfo, LaunchParam launchParam, ResultReceiver resultReceiver) {
        try {
            MiniAppController.launchMiniAppByAppInfo(activity, miniAppInfo, launchParam, null, resultReceiver);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "launchAppByAppInfo: exception=", e16);
        }
    }

    public static void launchMiniAppById(Context context, LaunchParam launchParam, MiniAppLaunchListener miniAppLaunchListener) {
        MiniAppController.startAppByAppid(context, launchParam.miniAppId, launchParam.entryPath, launchParam.envVersion, launchParam, miniAppLaunchListener);
    }

    public static void launchAppByAppInfo(Activity activity, MiniAppInfo miniAppInfo, LaunchParam launchParam, String str, ResultReceiver resultReceiver) {
        try {
            MiniAppController.launchMiniAppByAppInfo(activity, miniAppInfo, launchParam, str, resultReceiver);
        } catch (MiniAppException e16) {
            QLog.e(TAG, 1, "launchAppByAppInfo: exception=", e16);
        }
    }
}
