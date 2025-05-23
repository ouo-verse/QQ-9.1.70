package com.tencent.mobileqq.mini.entry;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE$StCacheController;
import NS_MINI_INTERFACE.INTERFACE$StGetDropdownAppListRsp;
import NS_MINI_INTERFACE.INTERFACE$StGetUserAppListRsp;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import androidx.core.content.res.ResourcesCompat;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.ark.ark;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.AppMode;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.PreCacheInfo;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartHost;
import com.tencent.mobileqq.mini.entry.newdesktop.RecentStartMiniAppListener;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.launch.MiniAppMainServiceApiManager;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.MiniAppWnsConfig;
import com.tencent.mobileqq.minigame.manager.GameCloseManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.webso.c;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.richframework.argus.business.performance.report.ArgusReportHelper;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.vip.tianshu.TianShuManager;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppUtils {
    private static final String CONTENT_TYPE_FORM_URLENCODED = "application/x-www-form-urlencoded";
    private static final String CONTENT_TYPE_JSON = "application/json";
    public static final int EXPERIMENT_B_MAX_COUNTS = 64;
    public static final String GAME_CENTER_APP_ID = "1108291530";
    public static final String GDT_COOKIE = "gdt_cookie";
    public static final String KEY_MINI_APP_CONFIG = "key_record_mini_app_config";
    public static final String KEY_MINI_GAME_PAY_ENV = "keyMiniGamePayEnv";
    public static final String KEY_MINI_GAME_PAY_ENV_APPID_VERTYPE = "keyMiniGamePayEnvAppidVertype";
    public static final String MINI_APP_DESKTOP_GDT_COOKIE_PRE = "mini_app_desktop_gdt_cookie";
    private static final String MINI_APP_STORE_URL = "mqqapi://miniapp/open?_ext=&_mappid=1108291530&_mvid=&_nq=&_path=&_q=&_sig=0178f7ca2545b9ef6f736f01247642f6e53ef6467005aa21274c4166f0ff5a3b";
    private static final Set<Integer> PULL_DOWN_REFER;
    public static final int RESULT_WNS_REQUEST_FAIL = 20001;
    private static final String TAG = "MiniAppUtils";
    public static final String TIAN_SHU_APPID = "tianshu.78";
    public static final String TIAN_SHU_PAGE_ID = "tianshu.78";
    public static final int TYPE_ATTACHED_TO_WINDOW = 3;
    public static final int TYPE_AUTO_PULL_DOWN_MINI_APP = 105;
    public static final int TYPE_DB_INIT_COMPLETE = 8;
    public static final int TYPE_DELETED = 4;
    public static final int TYPE_DESKTOP_SETTINGS_SWITCH_CHANGE = 102;
    public static final int TYPE_ENTER_BACKGROUND = 7;
    public static final int TYPE_ENTER_FOREGROUND = 6;
    public static final int TYPE_HIDE_PULL_DOWN_ENTRY = 100;
    public static final int TYPE_HONGBAO_UPDATE_DESKTOP_RES = 103;
    public static final int TYPE_MINI_APP_CLICK_UPDATE_FAILED = 11;
    public static final int TYPE_MINI_APP_SERVER_REQUEST_FAILED = 10;
    public static final int TYPE_MINI_APP_START_ANIMATION = 12;
    public static final int TYPE_MINI_APP_STOP_ANIMATION = 13;
    public static final int TYPE_MSF_REQUEST_FAILED = 2;
    public static final int TYPE_OPEN_DESKTOP_MINI_APP = 104;
    public static final int TYPE_QUERY_DB_COMPLETE = 9;
    public static final int TYPE_RED_DOT = 101;
    public static final int TYPE_REQUEST_SUCCESS = 1;
    public static final int TYPE_SET_TOP = 5;
    private static final int USE_APPID_LAUNCHER_MINI_APP_DEFAULT = 0;
    private static final int WX_APP_TYPE_DEV = 1;
    private static final int WX_APP_TYPE_EXPERIENCE = 2;
    private static final int WX_APP_TYPE_RELEASE = 0;
    public static RecentStartMiniAppListener mRecentStartMiniAppListener;

    static {
        HashSet hashSet = new HashSet();
        PULL_DOWN_REFER = hashSet;
        hashSet.add(3001);
        hashSet.add(3020);
        hashSet.add(3002);
        hashSet.add(3003);
        hashSet.add(3021);
        hashSet.add(3004);
        hashSet.add(3005);
        hashSet.add(3006);
        hashSet.add(3007);
        hashSet.add(3008);
        hashSet.add(3009);
        hashSet.add(3010);
        hashSet.add(3011);
        hashSet.add(3012);
        hashSet.add(3013);
        hashSet.add(3016);
        hashSet.add(1001);
        hashSet.add(1022);
    }

    MiniAppUtils() {
    }

    private static void appendCookieStr(StringBuilder sb5, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            insertSemicolon(sb5);
            sb5.append(str2);
            sb5.append(str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, str2 + "is empty");
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        insertSemicolon(sb5);
        sb5.append(str2);
        sb5.append(str3);
    }

    public static void asyncMiniAppDesktopInitReport(final Long l3) {
        final long currentTimeMillis = System.currentTimeMillis();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.a
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppUtils.lambda$asyncMiniAppDesktopInitReport$0(currentTimeMillis, l3);
            }
        }, 16, null, true);
    }

    public static void asyncMiniAppDesktopOpenCostReport(Long l3) {
        final long currentTimeMillis = System.currentTimeMillis() - l3.longValue();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.b
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppUtils.lambda$asyncMiniAppDesktopOpenCostReport$1(currentTimeMillis);
            }
        }, 16, null, true);
    }

    public static void checkSendUserAppListRequest() {
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            QLog.e(TAG, 1, "checkSendUserAppListRequest, app is null.");
            return;
        }
        SharedPreferences preferences = appInterface.getPreferences();
        long j3 = preferences.getLong(AppConstants.Preferences.KEY_UPDATE_MINIAPP_TIME, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j3 > (MiniAppConfProcessor.j() != null ? r7.b() : 60) * 60 * 1000) {
            ((MiniAppUserAppInfoListManager) appInterface.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER)).sendUserAppListRequest(Long.valueOf(appInterface.getCurrentAccountUin()).longValue(), 64L);
            preferences.edit().putLong(AppConstants.Preferences.KEY_UPDATE_MINIAPP_TIME, currentTimeMillis).apply();
        }
    }

    public static void fetchWnsCgiPreCacheData(Context context, String str, final String str2, final String str3) {
        QLog.d(TAG, 1, "--- prefetch cache data appid:" + str + "  requestUrl" + str2 + "  path:" + str3);
        c.a aVar = new c.a();
        aVar.f315003a = str2;
        aVar.f315004b = "GET";
        aVar.f315009g = false;
        aVar.f315010h = 0;
        aVar.f315007e = "application/x-www-form-urlencoded";
        c.c().h(aVar, new Handler(ThreadManagerV2.getSubThreadLooper()) { // from class: com.tencent.mobileqq.mini.entry.MiniAppUtils.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                Object obj = message.obj;
                if (obj instanceof c.b) {
                    final c.b bVar = (c.b) obj;
                    if (bVar.f315020i == 0) {
                        QLog.d(MiniAppUtils.TAG, 2, "handleMessage() called with: msg = [" + message + "]");
                        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUtils.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    String str4 = str3 + "__temp";
                                    FileUtils.writeFile(str4, bVar.f315015d);
                                    FileUtils.moveFile(str4, str3);
                                    QLog.d(MiniAppUtils.TAG, 1, "--- prefetch cache data finished :" + str2);
                                } catch (Exception e16) {
                                    QLog.e(MiniAppUtils.TAG, 1, "saveToMiniAppStorage ", e16);
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    public static AppInterface getAppInterface() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            AppRuntime runtime = application.getRuntime();
            if (runtime instanceof QQAppInterface) {
                return (QQAppInterface) runtime;
            }
        }
        return null;
    }

    public static String getCookie(String str) {
        String r16 = SwiftBrowserCookieMonster.r(str);
        String e16 = com.tencent.mobileqq.webview.swift.cookie.b.e(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        String str2 = ".*p_uin=" + e16 + ";.*";
        try {
            if (TextUtils.isEmpty(r16) || !r16.contains(";") || !r16.contains("uin=") || !r16.contains(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN) || r16.matches(str2)) {
                return r16;
            }
            String replaceAll = r16.replaceAll(" ", "");
            StringBuilder sb5 = new StringBuilder();
            for (String str3 : replaceAll.split(";")) {
                if (str3.startsWith("uin=")) {
                    String substring = str3.substring(4);
                    if (TextUtils.isEmpty(substring) || !substring.equals(e16)) {
                        appendCookieStr(sb5, e16, "uin=", str3);
                    }
                } else if (str3.startsWith("p_uin=")) {
                    String substring2 = str3.substring(6);
                    if (TextUtils.isEmpty(substring2) || !substring2.equals(e16)) {
                        appendCookieStr(sb5, e16, "p_uin=", str3);
                    }
                } else {
                    insertSemicolon(sb5);
                    sb5.append(str3);
                }
            }
            return sb5.toString();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getCookie error.", th5);
            return r16;
        }
    }

    private static int getCurrentTab() {
        QBaseFragment qBaseFragment;
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        int currentTab = (baseActivity == null || (qBaseFragment = (QBaseFragment) baseActivity.getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName())) == null) ? -1 : ((MainFragment) qBaseFragment).getCurrentTab();
        QLog.d(TAG, 2, "getCurrentTab, tab: " + currentTab);
        return currentTab;
    }

    public static Drawable getDrawable(String str, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        URLDrawable uRLDrawable;
        try {
            uRLDrawable = URLDrawable.getDrawable(str, uRLDrawableOptions);
        } catch (Exception e16) {
            e = e16;
            uRLDrawable = null;
        }
        try {
            if (uRLDrawable.getStatus() == 2) {
                uRLDrawable.restartDownload();
            }
        } catch (Exception e17) {
            e = e17;
            QLog.e(TAG, 1, "getDrawable: " + str, e);
            return uRLDrawable;
        }
        return uRLDrawable;
    }

    public static int getGTK(String str) {
        int i3 = 5381;
        if (TextUtils.isEmpty(str)) {
            return 5381;
        }
        int length = str.length();
        for (int i16 = 0; i16 < length; i16++) {
            i3 += (i3 << 5) + str.charAt(i16);
        }
        return Integer.MAX_VALUE & i3;
    }

    public static Drawable getIcon(Context context, String str, boolean z16, int i3) {
        URLDrawable uRLDrawable;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = false;
        int dpToPx = ViewUtils.dpToPx(48.0f);
        obtain.mRequestHeight = dpToPx;
        obtain.mRequestWidth = dpToPx;
        if (z16) {
            obtain.mFailedDrawable = getResourceDrawable(context, R.drawable.f161062ch3);
            obtain.mLoadingDrawable = getResourceDrawable(context, R.drawable.f161062ch3);
        }
        try {
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
            try {
                uRLDrawable.setTag(com.tencent.mobileqq.urldrawable.a.c(dpToPx, dpToPx, ViewUtils.dpToPx(i3)));
                uRLDrawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
                if (uRLDrawable.getStatus() == 2) {
                    uRLDrawable.restartDownload();
                }
            } catch (Exception e16) {
                e = e16;
                QLog.e(TAG, 1, "getIcon url: " + str, e);
                return uRLDrawable;
            }
        } catch (Exception e17) {
            e = e17;
            uRLDrawable = null;
        }
        return uRLDrawable;
    }

    public static Drawable getRecommendIconDrawable(Context context, String str) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = false;
        try {
            return URLDrawable.getDrawable(str, obtain);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getRecommendIconDrawable, failed.", e16);
            return null;
        }
    }

    public static String getSpDesktopGdtCookie() {
        return StorageUtil.getPreference().getString("mini_app_desktop_gdt_cookie_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), "");
    }

    public static void handleMiniAppMoreClick(Activity activity) {
        int i3 = 0;
        try {
            i3 = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_OPEN_STORE_USE_APPID, 0);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "get config MINI_APP_OPEN_STORE_USE_APPID exception!", th5);
        }
        if (i3 != 0) {
            MiniAppLauncher.startMiniApp(activity, MINI_APP_STORE_URL, 1001, null);
            return;
        }
        AppInterface appInterface = getAppInterface();
        if (appInterface != null) {
            MiniAppUserAppInfoListManager miniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager) appInterface.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
            MiniAppInfo findTopMiniApp = miniAppUserAppInfoListManager != null ? miniAppUserAppInfoListManager.findTopMiniApp("1108291530") : null;
            if (findTopMiniApp != null) {
                try {
                    QLog.d(TAG, 2, "handleMiniAppMoreClick, launch app store by appInfo");
                    MiniAppLauncher.launchAppByAppInfo(activity, findTopMiniApp, 1001);
                    return;
                } catch (MiniAppException e16) {
                    QLog.e(TAG, 1, "handleMiniAppMoreClick, launchMiniAppByAppInfo exception.", e16);
                    MiniAppLauncher.startMiniApp(activity, MINI_APP_STORE_URL, 1001, null);
                    return;
                }
            }
            MiniAppLauncher.startMiniApp(activity, MINI_APP_STORE_URL, 1001, null);
        }
    }

    public static void handlePullDownEntryListData(Bundle bundle, CmdCallback cmdCallback) {
        bundle.setClassLoader(MiniAppUtils.class.getClassLoader());
        MiniAppConfig miniAppConfig = (MiniAppConfig) bundle.getParcelable(KEY_MINI_APP_CONFIG);
        if (miniAppConfig != null && miniAppConfig.config != null) {
            updatePullDownEntryListData(miniAppConfig);
            if (cmdCallback != null) {
                try {
                    cmdCallback.onCmdResult(true, new Bundle());
                    return;
                } catch (RemoteException e16) {
                    QLog.e(TAG, 1, "handlePullDownEntryListData, " + Log.getStackTraceString(e16));
                    return;
                }
            }
            return;
        }
        QLog.e(TAG, 1, "handlePullDownEntryListData, miniAppConfig is null");
    }

    public static boolean isConversationTab() {
        return getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183038a;
    }

    public static boolean isDebugMiniApp(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String string = BaseApplicationImpl.getApplication().getSharedPreferences("keyMiniGamePayEnv", 4).getString("keyMiniGamePayEnvAppidVertype", "");
            if (!TextUtils.isEmpty(string) && string.equals(MD5Utils.encodeHexStr(str))) {
                String[] split = str.split("_");
                if (split.length > 1) {
                    return Integer.parseInt(split[1]) != 3;
                }
                return false;
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "isDebugMiniApp appidVerTypeStr", str, th5);
        }
        return false;
    }

    public static boolean isNightMode() {
        return "1103".equals(ThemeUtil.getCurrentThemeId()) || "2920".equals(ThemeUtil.getCurrentThemeId());
    }

    public static boolean isTeenagerMode() {
        return StudyModeManager.t() && !MiniAppWnsConfig.isMiniDesktopTeenModelClosed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$asyncMiniAppDesktopInitReport$0(long j3, Long l3) {
        try {
            if (new Random().nextInt(100000) <= 1) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", "MiniAppDesktopExpPartHost_init");
                long longValue = j3 - l3.longValue();
                hashMap.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(longValue));
                ArgusReportHelper.INSTANCE.report(hashMap);
                QLog.i(TAG, 1, "initMiniAppView_cost:" + longValue);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "ArgusReportHelper error", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$asyncMiniAppDesktopOpenCostReport$1(long j3) {
        try {
            if (new Random().nextInt(10000) <= 1) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", "MiniAppDesktopExpPartHost_open");
                hashMap.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(j3));
                ArgusReportHelper.INSTANCE.report(hashMap);
                QLog.d(TAG, 1, "MiniAppDesktopNewPartHost_open\uff0conTwoLevelRelease\uff0copenMiniAppView_cost:" + j3);
            }
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "ArgusReportHelper error", th5);
        }
    }

    public static void miniAppTianShuReport(String str, String str2, String str3, int i3) {
        String str4;
        TianShuReportData tianShuReportData = new TianShuReportData();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            str4 = runtime.getAccount();
        } else {
            str4 = "";
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mTraceId = str4 + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = str;
        tianShuReportData.mPageId = str2;
        tianShuReportData.mItemId = str3;
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mOperTime = serverTimeMillis;
        TianShuManager.getInstance().report(tianShuReportData);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "tianShuReport, report itemId: " + str3);
        }
    }

    private static boolean needUpdateCache(String str, long j3) {
        File file = new File(str);
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            QLog.d(TAG, 2, "needUpdateCache: precache : lastModified:" + file.lastModified() + "  curTime:" + currentTimeMillis + "  expire:" + j3);
            return file.lastModified() + (j3 * 1000) <= currentTimeMillis;
        }
        QLog.e(TAG, 1, "needUpdateCache precache:  file not exist:" + str);
        return true;
    }

    public static void notityPullDownEntryInMainProcess(MiniAppConfig miniAppConfig) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_MINI_APP_CONFIG, miniAppConfig);
        MiniAppMainServiceApiManager.INSTANCE.sendCmd("cmd_update_pull_down_entry_list", bundle, new CmdCallback.Stub() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUtils.4
            @Override // com.tencent.mobileqq.mini.launch.CmdCallback
            public void onCmdResult(boolean z16, Bundle bundle2) throws RemoteException {
                QLog.d(MiniAppUtils.TAG, 2, "onCmdResult() called with: succ = " + z16);
            }
        });
    }

    public static boolean performWnsCgiRequest(JSONObject jSONObject, final AsyncResult asyncResult) {
        final c.a aVar;
        String jSONObject2;
        final boolean equalsIgnoreCase;
        if (jSONObject == null) {
            asyncResult.onReceiveResult(false, null);
            return false;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            aVar = new c.a();
            aVar.f315003a = jSONObject.optString("url");
            if (optJSONObject == null) {
                jSONObject2 = "{}";
            } else {
                jSONObject2 = optJSONObject.toString();
            }
            aVar.f315005c = jSONObject2;
            aVar.f315010h = 60000;
            aVar.f315007e = "application/x-www-form-urlencoded";
            aVar.f315004b = jSONObject.optString("method", "GET");
            aVar.f315009g = jSONObject.optString("responseType").equals("base64");
            aVar.f315006d = null;
            equalsIgnoreCase = jSONObject.optString("dataType").equalsIgnoreCase(ark.ARKMETADATA_JSON);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "performWnsCgiRequest ", e16);
            asyncResult.onReceiveResult(false, null);
        }
        if (TextUtils.isEmpty(aVar.f315003a)) {
            asyncResult.onReceiveResult(false, null);
            return false;
        }
        if (jSONObject.has("data") && !"GET".equalsIgnoreCase(aVar.f315004b)) {
            Object obj = jSONObject.get("data");
            if (obj instanceof String) {
                aVar.f315006d = (String) obj;
            } else {
                aVar.f315006d = obj.toString();
            }
        }
        if (TextUtils.isEmpty(aVar.f315004b)) {
            asyncResult.onReceiveResult(false, null);
            return false;
        }
        if (!"get".equalsIgnoreCase(aVar.f315004b) && !Method.POST.equalsIgnoreCase(aVar.f315004b)) {
            asyncResult.onReceiveResult(false, null);
            return false;
        }
        String upperCase = aVar.f315004b.toUpperCase();
        aVar.f315004b = upperCase;
        if (Method.POST.equalsIgnoreCase(upperCase)) {
            aVar.f315007e = "application/json";
        }
        final String j06 = AuthorizeConfig.y().j0(com.tencent.mobileqq.webview.swift.cookie.b.f(aVar.f315003a));
        ((IPskeyManager) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IPskeyManager.class, "")).getPskey(new String[]{j06}, new sd2.a() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUtils.2
            @Override // sd2.a
            public void onSuccess(Map<String, String> map) {
                try {
                    MiniAppUtils.setPskeyEvent(map.get(j06), aVar, equalsIgnoreCase, asyncResult);
                } catch (Throwable th5) {
                    QLog.e(MiniAppUtils.TAG, 1, "getPskey onSuccess fail.", th5);
                }
            }

            @Override // sd2.a
            public void onFail(String str) {
                QLog.e(MiniAppUtils.TAG, 1, "getPskey fail\uff01", str);
            }
        });
        return false;
    }

    public static void preFetchAppCacheData(Context context, MiniAppInfo miniAppInfo) {
        QLog.d(TAG, 1, "preFetchAppCacheData ");
        ArrayList<PreCacheInfo> arrayList = miniAppInfo.preCacheList;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<PreCacheInfo> it = miniAppInfo.preCacheList.iterator();
            while (it.hasNext()) {
                PreCacheInfo next = it.next();
                if (next.cacheType == 0) {
                    String preCacheFilePath = MiniAppFileManager.getPreCacheFilePath(miniAppInfo.appId, next.preCacheKey);
                    if (!TextUtils.isEmpty(preCacheFilePath) && needUpdateCache(preCacheFilePath, next.expireTime)) {
                        fetchWnsCgiPreCacheData(context, miniAppInfo.appId, next.getDataUrl, preCacheFilePath);
                    }
                }
            }
            return;
        }
        QLog.e(TAG, 1, "preFetchAppCacheData, preeCacheList size = 0");
    }

    public static void putSpDesktopGdtCookie(String str) {
        StorageUtil.getPreference().edit().putString("mini_app_desktop_gdt_cookie_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), str).apply();
        QLog.d(TAG, 1, "putSpDesktopGdtCookie, gdt_cookie: " + str);
    }

    public static void reportMiniAppAd(final String str) {
        QLog.d(TAG, 1, "reportMiniAppAd reportUrl = " + str);
        if (TextUtils.isEmpty(str) || !URLUtil.isNetworkUrl(str)) {
            return;
        }
        ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUtils.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.connect();
                    QLog.i(MiniAppUtils.TAG, 1, "reportBannerAd rspCode" + httpURLConnection.getResponseCode());
                } catch (Throwable th5) {
                    QLog.e(MiniAppUtils.TAG, 1, "reportBannerAd error, url = " + str, th5);
                }
            }
        });
    }

    public static void reportMiniGameCenterDC00087(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        reportToDC00087Async(str, str2, str3, str4, str5, str6, str7, "1");
    }

    public static void reportToDC00087Async(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUtils.10
            @Override // java.lang.Runnable
            public void run() {
                WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
                wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setBussinessId(str).setPageId(str2).setOperModule(str3).setModuleType(str4).setOperId(str5).setOperType(str6).setGameCenterSrc(str7).setExt(2, str8);
                wadlReportBuilder.report();
            }
        });
    }

    public static void resetUserAppListRequestRefreshTime() {
        AppInterface appInterface = getAppInterface();
        if (appInterface != null) {
            appInterface.getPreferences().edit().putLong(AppConstants.Preferences.KEY_UPDATE_MINIAPP_TIME, 0L).apply();
            QLog.e(TAG, 2, "[MiniAppUserAppInfoListManager].sendUserAppListRequest, reset refresh time");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setPskeyEvent(String str, c.a aVar, final boolean z16, final AsyncResult asyncResult) {
        if (TextUtils.isEmpty(str)) {
            String r16 = SwiftBrowserCookieMonster.r(aVar.f315003a);
            if (!TextUtils.isEmpty(r16) && r16.contains("p_skey")) {
                for (String str2 : r16.split(";")) {
                    if (!TextUtils.isEmpty(str2) && str2.contains("p_skey")) {
                        String substring = str2.substring(str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1, str2.length());
                        if (!TextUtils.isEmpty(substring)) {
                            getGTK(substring);
                        }
                    }
                }
            }
        } else {
            int gtk = getGTK(str);
            if (aVar.f315003a.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                aVar.f315003a += "&g_tk=" + gtk;
            } else {
                aVar.f315003a += "?g_tk=" + gtk;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "url : " + aVar.f315003a);
            }
        }
        if (c.c().i(aVar, new Handler(ThreadManagerV2.getQQCommonThreadLooper()) { // from class: com.tencent.mobileqq.mini.entry.MiniAppUtils.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String str3;
                super.handleMessage(message);
                Object obj = message.obj;
                if (obj instanceof c.b) {
                    c.b bVar = (c.b) obj;
                    QLog.d(MiniAppUtils.TAG, 1, "handleMessage ", bVar);
                    if (bVar.f315020i == 0) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (bVar.f315015d != null) {
                                if (z16) {
                                    jSONObject.put("data", new JSONObject(bVar.f315015d));
                                } else {
                                    if (bVar.f315018g) {
                                        str3 = PluginBaseInfoHelper.Base64Helper.encodeToString(bVar.f315015d.getBytes(), 0);
                                    } else {
                                        str3 = bVar.f315015d;
                                    }
                                    jSONObject.put("data", str3);
                                }
                            } else {
                                jSONObject.put("data", "");
                            }
                            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, bVar.f315017f);
                            jSONObject.put("wnsCode", bVar.f315020i);
                            jSONObject.put("header", bVar.f315014c);
                            asyncResult.onReceiveResult(true, jSONObject);
                            return;
                        } catch (JSONException e16) {
                            QLog.e(MiniAppUtils.TAG, 1, "handleMessage wnsCgiRequest exception ", e16);
                            asyncResult.onReceiveResult(false, null);
                            return;
                        }
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("wnsCode", bVar.f315020i);
                    } catch (Exception unused) {
                    }
                    asyncResult.onReceiveResult(false, jSONObject2);
                    return;
                }
                QLog.e(MiniAppUtils.TAG, 1, "handleMessage wnsCgiRequest ", " invalid msg.obj");
                asyncResult.onReceiveResult(false, null);
            }
        }, getCookie(aVar.f315003a))) {
            QLog.d(TAG, 2, "performWnsCgiRequest  success");
            return;
        }
        QLog.d(TAG, 2, "performWnsCgiRequest  fail");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wnsCode", 20001);
        } catch (Exception unused) {
        }
        asyncResult.onReceiveResult(false, jSONObject);
    }

    public static void setRecentStartMiniAppListener(RecentStartMiniAppListener recentStartMiniAppListener) {
        mRecentStartMiniAppListener = recentStartMiniAppListener;
    }

    public static void updateMiniAppList(int i3) {
        updateMiniAppList(i3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateMiniAppMemoryCache(final MiniAppConfig miniAppConfig) {
        MiniAppInfo miniAppInfo = miniAppConfig.config;
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
            if (miniAppConfig.config.verType != 3) {
                QLog.d(TAG, 1, "updateMiniAppMemoryCache, verType: " + miniAppConfig.config.verType);
                MiniAppInfo copy = MiniAppInfo.copy(miniAppConfig.config);
                copy.debugInfo = null;
                recordMiniAppInfoToCacheListAndUpdateDB(copy);
                return;
            }
            MiniAppCmdUtil miniAppCmdUtil = MiniAppCmdUtil.getInstance();
            String str = miniAppConfig.config.appId;
            LaunchParam launchParam = miniAppConfig.launchParam;
            miniAppCmdUtil.getAppInfoById(null, str, launchParam.entryPath, launchParam.envVersion, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUtils.8
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public void onCmdListener(boolean z16, JSONObject jSONObject) {
                    if (!z16) {
                        MiniAppUtils.recordMiniAppInfoToCacheListAndUpdateDB(MiniAppConfig.this.config);
                        MiniAppUtils.updateMiniAppList(11);
                        QLog.e(MiniAppUtils.TAG, 1, "updateMiniAppMemoryCache, request fail. appInfo: " + MiniAppConfig.this.config);
                        return;
                    }
                    QLog.d(MiniAppUtils.TAG, 1, "updateMiniAppMemoryCache, getAppInfoById retCode = " + jSONObject.optLong("retCode") + ",errMsg = " + jSONObject.optString("errMsg"));
                    MiniAppInfo miniAppInfo2 = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
                    if (miniAppInfo2 != null) {
                        miniAppInfo2.mergeData(MiniAppConfig.this.config);
                        MiniAppUtils.recordMiniAppInfoToCacheListAndUpdateDB(miniAppInfo2);
                    }
                }
            });
            return;
        }
        QLog.e(TAG, 1, "updateMiniAppMemoryCache, appInfo: " + miniAppConfig.config);
    }

    public static void updatePullDownEntryWeixinApp(String str, final int i3, int i16) {
        QLog.i(TAG, 1, "updatePullDownEntryWeixinApp, appid = " + str + ",scene = " + i3);
        MiniAppCmdUtil.getInstance().getAppInfoById(null, str, "", resetWxMiniAppVtToQQMiniAppVt(i16), new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUtils.5
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                String str2;
                if (z16) {
                    QLog.i(MiniAppUtils.TAG, 1, "getAppInfoById, retCode = " + jSONObject.optLong("retCode") + ",errMsg = " + jSONObject.optString("errMsg"));
                    MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
                    if (miniAppInfo != null) {
                        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
                        miniAppConfig.launchParam.scene = i3;
                        MiniAppUtils.updatePullDownEntryListData(miniAppConfig);
                        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUtils.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MiniAppUtils.updateMiniAppList(6);
                            }
                        }, 16, null, true, 600L);
                        return;
                    }
                    QLog.e(MiniAppUtils.TAG, 1, "updatePullDownEntryWeixinApp getAppInfoById appInfo is null");
                    return;
                }
                long optLong = jSONObject != null ? jSONObject.optLong("retCode") : 0L;
                if (jSONObject != null) {
                    str2 = jSONObject.optString("errMsg");
                } else {
                    str2 = "";
                }
                QLog.e(MiniAppUtils.TAG, 1, "updatePullDownEntryWeixinApp getAppInfoById failed retCode:" + optLong + " errMsg:" + str2);
            }
        });
    }

    private static Drawable getResourceDrawable(Context context, int i3) {
        if (context != null && context.getResources() != null) {
            try {
                return ResourcesCompat.getDrawable(context.getResources(), i3, null);
            } catch (Resources.NotFoundException e16) {
                QLog.e(TAG, 1, "drawable not found error.", e16);
                return null;
            } catch (Exception e17) {
                QLog.e(TAG, 1, e17, new Object[0]);
                return null;
            }
        }
        QLog.e(TAG, 1, "context or getResources null error.");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void recordMiniAppInfoToCacheListAndUpdateDB(MiniAppInfo miniAppInfo) {
        miniAppInfo.recommend = 0;
        miniAppInfo.extendData = null;
        if (MiniAppConfProcessor.m()) {
            RecentStartMiniAppListener recentStartMiniAppListener = mRecentStartMiniAppListener;
            if (recentStartMiniAppListener != null) {
                recentStartMiniAppListener.recentStartMiniApp(miniAppInfo);
            }
        } else {
            MiniAppUserAppInfoListManager.recordMiniAppStart(miniAppInfo);
        }
        QLog.w(TAG, 1, "recordMiniAppInfoToCacheListAndUpdateDB, appInfo = " + miniAppInfo);
        MiniAppLocalSearchManager miniAppLocalSearchManager = (MiniAppLocalSearchManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MINI_APP_LOCAL_SEARCH);
        if (miniAppLocalSearchManager != null) {
            miniAppLocalSearchManager.updateDataToDB(miniAppInfo);
        }
    }

    public static void reportMiniGameCenterDC00087(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final Map<String, String> map) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUtils.12
            @Override // java.lang.Runnable
            public void run() {
                WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
                wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setBussinessId(str).setPageId(str2).setOperModule(str3).setModuleType(str4).setOperId(str5).setOperType(str6).setGameAppId(str7);
                Map map2 = map;
                if (map2 != null) {
                    for (Map.Entry entry : map2.entrySet()) {
                        String str8 = (String) entry.getKey();
                        if (str8.startsWith("ext")) {
                            try {
                                wadlReportBuilder.setExt(Integer.parseInt(str8.substring(3)), (String) entry.getValue());
                            } catch (NumberFormatException e16) {
                                QLog.e(MiniAppUtils.TAG, 1, "reportMiniGameCenterDC00087 e:", e16);
                            }
                        }
                    }
                }
                wadlReportBuilder.report();
            }
        });
    }

    public static void reportToDC00087Async(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUtils.11
            @Override // java.lang.Runnable
            public void run() {
                WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
                wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setBussinessId(str).setPageId(str2).setOperModule(str3).setModuleType(str4).setOperId(str5).setOperType(str6).setGameCenterSrc(str7).setExt(2, str8).setTianjiReportStr(str9);
                wadlReportBuilder.report();
            }
        });
    }

    public static void updateMiniAppList(int i3, Bundle bundle) {
        QLog.d(TAG, 1, "[MiniAppUserAppInfoListManager]. updateMiniAppList, type = " + i3);
        BaseApplicationImpl.getApplication().getRuntime().notifyObservers(MiniAppExpDesktopPartHost.class, i3, true, bundle);
    }

    private static void insertSemicolon(StringBuilder sb5) {
        if (sb5 == null || sb5.length() <= 0) {
            return;
        }
        if (sb5.toString().endsWith(";")) {
            sb5.append(" ");
        } else {
            if (sb5.toString().endsWith("; ")) {
                return;
            }
            sb5.append("; ");
        }
    }

    public static boolean isFromPullDownEntry(MiniAppConfig miniAppConfig) {
        LaunchParam launchParam;
        return (miniAppConfig == null || (launchParam = miniAppConfig.launchParam) == null || !PULL_DOWN_REFER.contains(Integer.valueOf(launchParam.scene))) ? false : true;
    }

    public static void saveGdtCookie(COMM.StCommonExt stCommonExt) {
        if (stCommonExt == null || stCommonExt.mapInfo == null) {
            return;
        }
        for (int i3 = 0; i3 < stCommonExt.mapInfo.size(); i3++) {
            COMM.Entry entry = stCommonExt.mapInfo.get(i3);
            if ("gdt_cookie".equals(entry.key.get())) {
                putSpDesktopGdtCookie(entry.value.get());
                return;
            }
        }
    }

    public static void updatePullDownEntryListData(final MiniAppConfig miniAppConfig) {
        AppMode appMode;
        if (miniAppConfig == null || !miniAppConfig.isShortcutFakeApp()) {
            if (miniAppConfig == null || (appMode = miniAppConfig.config.appMode) == null || !appMode.keepOffPullList) {
                if (!TextUtils.isEmpty(MiniAppSecurityUtil.getLoginMiniAppForbidToken(BaseApplicationImpl.getApplication(), MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication())))) {
                    QLog.d(TAG, 1, "updatePullDownEntryListData, has forbidToken");
                } else {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUtils.6
                        @Override // java.lang.Runnable
                        public void run() {
                            MiniAppConfig miniAppConfig2 = MiniAppConfig.this;
                            if (miniAppConfig2 != null) {
                                if (MiniAppUtils.isFromPullDownEntry(miniAppConfig2)) {
                                    MiniAppUtils.updateMiniAppMemoryCache(MiniAppConfig.this);
                                    if (QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_BACK_AUTO_HIDE, 0) == 2) {
                                        MiniAppUtils.updateMiniAppList(100);
                                        return;
                                    }
                                    return;
                                }
                                MiniAppInfo miniAppInfo = MiniAppConfig.this.config;
                                if (miniAppInfo == null || miniAppInfo.isAppStoreMiniApp()) {
                                    return;
                                }
                                MiniAppInfo copy = MiniAppInfo.copy(MiniAppConfig.this.config);
                                copy.debugInfo = null;
                                MiniAppUtils.recordMiniAppInfoToCacheListAndUpdateDB(copy);
                            }
                        }
                    }, 16, null, true);
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUtils.7
                        @Override // java.lang.Runnable
                        public void run() {
                            final String str;
                            MiniAppConfig miniAppConfig2 = MiniAppConfig.this;
                            if (miniAppConfig2 == null || miniAppConfig2.config == null) {
                                return;
                            }
                            final boolean isFromPullDownEntry = MiniAppUtils.isFromPullDownEntry(miniAppConfig2);
                            LaunchParam launchParam = MiniAppConfig.this.launchParam;
                            if (launchParam == null) {
                                str = "";
                            } else {
                                str = String.valueOf(launchParam.scene);
                            }
                            String str2 = MiniAppConfig.this.config.via;
                            final String str3 = str2 != null ? str2 : "";
                            MiniAppCmdUtil miniAppCmdUtil = MiniAppCmdUtil.getInstance();
                            MiniAppInfo miniAppInfo = MiniAppConfig.this.config;
                            miniAppCmdUtil.useUserApp(miniAppInfo.appId, miniAppInfo.verType, isFromPullDownEntry ? 1 : 0, str, str3, null, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUtils.7.1
                                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                                public void onCmdListener(boolean z16, JSONObject jSONObject) {
                                    MiniAppUserAppInfoListManager miniAppUserAppInfoListManager;
                                    AppletsHandler appletsHandler;
                                    if (QLog.isColorLevel()) {
                                        QLog.w(MiniAppUtils.TAG, 1, "doStartMiniApp, useUserApp request is " + z16);
                                    }
                                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                                    if (z16) {
                                        GameCloseManager.saveRetainInfoCache(jSONObject.toString(), MiniAppConfig.this.config.appId, runtime.getAccount(), str, str3);
                                    }
                                    if (isFromPullDownEntry && (runtime instanceof QQAppInterface)) {
                                        boolean h16 = MiniAppConfProcessor.h();
                                        if (QLog.isColorLevel()) {
                                            QLog.d(MiniAppUtils.TAG, 2, "updatePullDownEntryListData, check needClearPublicAccountRedDot: " + h16);
                                        }
                                        if (h16 && (appletsHandler = (AppletsHandler) ((QQAppInterface) runtime).getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER)) != null) {
                                            appletsHandler.S2(MiniAppConfig.this.config.appId);
                                        }
                                        if (MiniAppConfProcessor.m() || (miniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager) runtime.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER)) == null) {
                                            return;
                                        }
                                        miniAppUserAppInfoListManager.removeRedDotData(MiniAppConfig.this.config.appId);
                                    }
                                }
                            });
                        }
                    }, 128, null, true);
                }
            }
        }
    }

    public static void handlePreloadAppData(Context context, INTERFACE$StGetUserAppListRsp iNTERFACE$StGetUserAppListRsp) {
        if (iNTERFACE$StGetUserAppListRsp == null || context == null) {
            return;
        }
        Iterator<INTERFACE$StCacheController> it = iNTERFACE$StGetUserAppListRsp.cacheLst.get().iterator();
        while (it.hasNext()) {
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = it.next().appInfo;
            if (iNTERFACE$StApiAppInfo != null) {
                preFetchAppCacheData(context, MiniAppInfo.from(iNTERFACE$StApiAppInfo));
            }
        }
    }

    public static void handlePreloadAppDataV2(Context context, INTERFACE$StGetDropdownAppListRsp iNTERFACE$StGetDropdownAppListRsp) {
        MiniAppInfo from;
        if (iNTERFACE$StGetDropdownAppListRsp == null || context == null) {
            return;
        }
        Iterator<INTERFACE$StCacheController> it = iNTERFACE$StGetDropdownAppListRsp.cacheLst.get().iterator();
        while (it.hasNext()) {
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = it.next().appInfo;
            if (iNTERFACE$StApiAppInfo != null && (from = MiniAppInfo.from(iNTERFACE$StApiAppInfo)) != null) {
                preFetchAppCacheData(context, from);
            }
        }
    }

    public static String resetWxMiniAppVtToQQMiniAppVt(int i3) {
        if (i3 == 1) {
            return "develop";
        }
        if (i3 != 2) {
            return "release";
        }
        return "trial";
    }

    public static Drawable getIcon(Context context, String str, boolean z16) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = false;
        int dpToPx = ViewUtils.dpToPx(48.0f);
        obtain.mRequestHeight = dpToPx;
        obtain.mRequestWidth = dpToPx;
        if (z16) {
            obtain.mFailedDrawable = getResourceDrawable(context, R.drawable.f161062ch3);
            obtain.mLoadingDrawable = getResourceDrawable(context, R.drawable.f161062ch3);
        }
        URLDrawable uRLDrawable = null;
        try {
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
            uRLDrawable.setTag(com.tencent.mobileqq.urldrawable.a.c(dpToPx, dpToPx, ViewUtils.dpToPx(9.0f)));
            uRLDrawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
            if (uRLDrawable.getStatus() == 2) {
                uRLDrawable.restartDownload();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getIcon url: " + str, e16);
        } catch (OutOfMemoryError e17) {
            QLog.e(TAG, 1, "getIcon url OOM: " + str, e17);
        }
        return uRLDrawable;
    }

    public static Drawable getIcon(Context context, String str, boolean z16, int i3, int i16) {
        URLDrawable uRLDrawable;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = false;
        int dpToPx = ViewUtils.dpToPx(i16);
        obtain.mRequestHeight = dpToPx;
        obtain.mRequestWidth = dpToPx;
        if (z16) {
            obtain.mFailedDrawable = getResourceDrawable(context, i3);
            obtain.mLoadingDrawable = getResourceDrawable(context, i3);
        }
        try {
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
            try {
                uRLDrawable.setTag(com.tencent.mobileqq.urldrawable.a.c(dpToPx, dpToPx, ViewUtils.dpToPx(9.0f)));
                uRLDrawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
            } catch (Exception e16) {
                e = e16;
                QLog.e(TAG, 1, "getIcon url: " + str, e);
                return uRLDrawable;
            }
        } catch (Exception e17) {
            e = e17;
            uRLDrawable = null;
        }
        return uRLDrawable;
    }

    public static Drawable getIcon(Context context, String str, boolean z16, int i3, int i16, int i17) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = false;
        obtain.mRequestHeight = ViewUtils.dpToPx(i17);
        obtain.mRequestWidth = ViewUtils.dpToPx(i16);
        if (z16) {
            obtain.mFailedDrawable = getResourceDrawable(context, i3);
            obtain.mLoadingDrawable = getResourceDrawable(context, i3);
        }
        try {
            return URLDrawable.getDrawable(str, obtain);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getIcon url: " + str, e16);
            return null;
        }
    }
}
