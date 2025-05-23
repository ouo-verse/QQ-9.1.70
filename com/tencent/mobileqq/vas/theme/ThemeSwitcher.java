package com.tencent.mobileqq.vas.theme;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasSafeUnzip;
import com.tencent.mobileqq.vas.VasTraceLog;
import com.tencent.mobileqq.vas.VasTraceLogProxy;
import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateCallback;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.theme.api.INormalNightModeHandler;
import com.tencent.mobileqq.vas.theme.api.ISimpleUIHandler;
import com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.NormalNightModeUtil;
import com.tencent.mobileqq.vas.util.VasMonitorDT;
import com.tencent.mobileqq.vas.util.VasTextUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.theme.SkinEngine;
import com.tencent.util.QUITokenResUtil;
import com.tencent.util.StringBuilderUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeSwitcher implements QueryItemCallback, Handler.Callback {
    private static final int BEGIN_SWITCH = 1000;
    public static final String DOWNLOAD_TIMEOUT = "download_timeout";
    private static final int DO_SWITCH = 1001;
    public static final String ENGINE_TIMEOUT = "engine_timeout";
    public static final int FAIL = 1;
    public static final HashSet<String> INIT_SET;
    public static final String NEED_MOVE = "need_move";
    public static final int NOT_FINISH = 3;
    public static final String QUERY_TIMEOUT = "query_timeout";
    private static final int RETRY = 1003;
    private static final int RETRY_SWITCH = 1002;
    public static final int SUCCESS = 0;
    public static final String TAG = "ThemeSwitcher";
    public static final String THEME_BG_RECORD_FOR_NIGHT_MODE = "theme_bg_record_for_night_mode";
    public static final int TIMEOUT = 2;
    public static final int TIMEOUT_CANCELED = -202;
    public static final int TIMEOUT_DELAY_TASK = -9001;
    public static final int TIMEOUT_NOT_SUPPORT = -201;
    public static final String UNZIP_FAIL = "unzip_fail";
    public static final String UPDATE_TIMEOUT = "update_timeout";
    public static final String WRONG_APP = "wrong_app";
    public static final String WRONG_ID = "wrong_id";
    private static AtomicBoolean sIsSwitching;
    private static ThemeSwitcher sRetry;
    public static ThemeSwitcher sSwitcher;
    private IThemeSwitchCallback callback;
    public DownloadListenser downloadListenser;
    private String from;
    private long retryDeadLine;
    private long startTime;
    private String startTimeStr;
    private AtomicBoolean done = new AtomicBoolean(false);
    private ThemeLocator themeLocator = new ThemeLocator();
    private Handler handler = new Handler(Looper.getMainLooper(), null);

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class DownloadListenser implements Runnable {
        private final long addOnProgress;
        private volatile long deadLine;
        private AtomicBoolean done = new AtomicBoolean(false);
        private String reportKey;

        public DownloadListenser(boolean z16) {
            long j3;
            String str;
            if (z16) {
                j3 = 5000;
            } else {
                j3 = 180000;
            }
            this.addOnProgress = j3;
            if (z16) {
                str = ThemeSwitcher.UPDATE_TIMEOUT;
            } else {
                str = ThemeSwitcher.DOWNLOAD_TIMEOUT;
            }
            this.reportKey = str;
            this.deadLine = SystemClock.uptimeMillis() + j3;
            meetDeadLine();
        }

        private boolean meetDeadLine() {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis > this.deadLine) {
                return true;
            }
            ThreadManager.getSubThreadHandler().postDelayed(this, (this.deadLine + 10) - uptimeMillis);
            return false;
        }

        private void onDone(AppRuntime appRuntime, String str, String str2, int i3) {
            if (i3 != 2) {
                ThreadManager.getSubThreadHandler().removeCallbacks(this);
            }
            if (this.done.compareAndSet(false, true)) {
                ThemeSwitcher.this.downloadListenser = null;
                if (TextUtils.isEmpty(str2)) {
                    if (TextUtils.isEmpty(ThemeSwitcher.this.themeLocator.getUnzipPath())) {
                        ThemeSwitcher.this.onEndSwitch(i3, false, true);
                        return;
                    } else {
                        QLog.e(ThemeSwitcher.TAG, 1, "download err, but local exists");
                        ThemeSwitcher.this.doSwitch();
                        return;
                    }
                }
                ThemeSwitcher.this.themeLocator.init(appRuntime.getApp(), str, str2);
                ThemeSwitcher.this.doSwitch();
            }
        }

        public void onComplete(String str, String str2, int i3) {
            AppRuntime check = ThemeSwitcher.this.check();
            if (check == null) {
                return;
            }
            String iDFromSCID = ThemeUtil.getIDFromSCID(str);
            if (ThemeSwitcher.this.themeLocator.getThemeId().equals(iDFromSCID)) {
                this.deadLine = SystemClock.uptimeMillis() + this.addOnProgress;
                VasLogReporter.getTheme().report("theme_download[themeId=" + iDFromSCID + ",errorCode=" + i3 + "]");
                if (i3 != 0) {
                    VasTraceLog.Theme.THEME_SWITCH.report("down_load_fail");
                    onDone(check, null, null, 1);
                } else if (str.startsWith(ThemeUpdateCallback.SCID_THEME_ZIP_PREFIX)) {
                    VasTraceLog.Theme.THEME_SWITCH.report("down_load_success");
                    onDone(check, str, str2, 0);
                    ThemeReporter.reportTheme(null, ThemeReporter.SUBACTION_THEME, ThemeSwitcher.this.from, 153, 1, 35, iDFromSCID, "20000000", ThemeReporter.PATH_DOWNLOAD, "");
                }
            }
        }

        public void onProgress(String str, long j3, long j16) {
            if (ThemeSwitcher.this.check() == null) {
                return;
            }
            if (ThemeSwitcher.this.themeLocator.getThemeId().equals(ThemeUtil.getIDFromSCID(str))) {
                this.deadLine = SystemClock.uptimeMillis() + this.addOnProgress;
                if (str.startsWith(ThemeUpdateCallback.SCID_THEME_ZIP_PREFIX) && ThemeSwitcher.this.callback != null) {
                    ThemeSwitcher.this.callback.onProgress(j3, j16);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            AppRuntime check;
            if (!meetDeadLine() || (check = ThemeSwitcher.this.check()) == null) {
                return;
            }
            QLog.e(ThemeSwitcher.TAG, 1, "downloadTheme timeout");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, this.reportKey);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "individual_v2_theme_download_fail", false, 0L, -1L, hashMap, "", true);
            onDone(check, null, null, 2);
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(ThemeReporter.FROM_AUTH);
        hashSet.add(ThemeReporter.FROM_WEEKLOOP);
        hashSet.add(ThemeReporter.FROM_INIT_THEME);
        hashSet.add(ThemeReporter.FROM_SIMPLE_INIT);
        INIT_SET = hashSet;
        sIsSwitching = new AtomicBoolean(false);
    }

    public ThemeSwitcher() {
    }

    private boolean beforeSwitch(AppRuntime appRuntime, String str, String str2) {
        QLog.e(TAG, 1, "beforeSwitch: " + str + "=>" + str2);
        VasLogReporter.getTheme().report("theme_beforeSwitch[themeId=" + str2 + MttLoader.QQBROWSER_PARAMS_FROME + str + "]");
        QQTheme.storeLastThemeId(str);
        SharedPreferences sharedPreferences = ThemeBackground.getSharedPreferences(appRuntime.getApplication(), appRuntime.getAccount(), 0);
        if (!TextUtils.isEmpty(str2) && !str2.equals(str)) {
            if (!INIT_SET.contains(this.from) && !"200".equals(this.from) && "1103".equals(str) && "null".equals(ChatBackgroundUtil.getChatBackgroundPath(BaseApplication.getContext(), appRuntime.getAccount(), null)) && sharedPreferences.contains(THEME_BG_RECORD_FOR_NIGHT_MODE)) {
                ChatBackgroundUtil.setChatBackground(BaseApplication.getContext(), appRuntime.getAccount(), null, sharedPreferences.getString(THEME_BG_RECORD_FOR_NIGHT_MODE, "null"), -1);
                sharedPreferences.edit().remove(THEME_BG_RECORD_FOR_NIGHT_MODE).apply();
            }
            if (!ThemeUtil.isFixTheme(str2)) {
                ThemeSwitchUtil.setPreviousThemeIdVersion(appRuntime, str2, "20000000");
            } else if (!ThemeUtil.isFixTheme(str) && !ThemeReporter.FROM_INIT_THEME.equals(this.from) && !str.equals("1000")) {
                ThemeSwitchUtil.setPreviousThemeIdVersion(appRuntime, str, "20000000");
            }
            ThemeUtil.parseSuperTheme(this.themeLocator.getUnzipPath());
        }
        IThemeSwitchCallback iThemeSwitchCallback = this.callback;
        if (iThemeSwitchCallback == null) {
            return false;
        }
        return iThemeSwitchCallback.beforeSwitch(this.themeLocator);
    }

    private void copyDiyTheme() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.ThemeSwitcher.1
            @Override // java.lang.Runnable
            public void run() {
                AppRuntime check = ThemeSwitcher.this.check();
                if (check == null) {
                    return;
                }
                ThemeSwitcher.this.themeLocator.getDIYLocator();
                ThemeUtil.ThemeInfo themeInfo = new ThemeUtil.ThemeInfo();
                themeInfo.status = "5";
                themeInfo.fileNum = 10;
                themeInfo.themeId = "999";
                themeInfo.zipVer = ThemeConstants.ZIP_VERSION;
                themeInfo.version = "20000000";
                ThemeUtil.setThemeInfo(check.getApp(), themeInfo);
                QLog.e(ThemeSwitcher.TAG, 1, "copyDiyTheme use empty DIY:" + ThemeSwitcher.this.themeLocator.getUnzipPath());
                ThemeSwitcher.this.doSwitch();
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSwitch() {
        QLog.e(TAG, 1, "doSwitch themeId=" + this.themeLocator.getThemeId() + ", from=" + this.from);
        Handler handler = this.handler;
        handler.sendMessage(handler.obtainMessage(1001));
    }

    private void doThemeSwitch(AppRuntime appRuntime) {
        boolean z16;
        boolean realDoSwitchTheme;
        boolean z17;
        boolean z18;
        String currentThemeId = ThemeUtil.getCurrentThemeId();
        String themeId = this.themeLocator.getThemeId();
        String unzipPath = this.themeLocator.getUnzipPath();
        ThemeBackground.needUpdateThemeForBg = false;
        if (!beforeSwitch(appRuntime, currentThemeId, themeId)) {
            if (!needSwitch() && !QQTheme.isThemeSimpleUI(themeId)) {
                z17 = false;
                z18 = false;
                realDoSwitchTheme = true;
            } else {
                if (SkinEngine.getInstances().mResources == null) {
                    realDoSwitchTheme = true;
                    z17 = true;
                } else {
                    realDoSwitchTheme = realDoSwitchTheme(appRuntime.getApp(), themeId, unzipPath);
                    z17 = false;
                }
                z18 = true;
            }
            QLog.e(TAG, 1, "needRetry: " + z17 + " switchSuccess: " + realDoSwitchTheme);
            VasLogReporter.getTheme().report("theme_skin_engine[themeId=" + themeId + ",switchSuccess=" + realDoSwitchTheme + ",needRetry=" + z17 + "]");
            if (realDoSwitchTheme) {
                ThemeUtil.setCurrentThemeIdVersion(appRuntime, this.themeLocator.getThemeId(), "20000000");
                SimpleUIUtil.updateSimpleUIData();
                onEndSwitch(0, false, z18);
            } else {
                QLog.e(TAG, 1, "engine is doing a switch, retry later");
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1002, 0, 0), 1000L);
            }
            z16 = z17;
        } else {
            onEndSwitch(0, true, false);
            z16 = false;
        }
        ThemeReporter.reportTheme(null, ThemeReporter.SUBACTION_THEME, this.from, 155, NetworkUtil.getSystemNetwork(null), 23, themeId, "20000000", currentThemeId, "");
        QLog.e(TAG, 1, "needRetry: " + z16 + " sIsSwitching: " + sIsSwitching.get());
        if (z16) {
            QLog.e(TAG, 1, "engine not ready, start retry: " + this);
            this.retryDeadLine = SystemClock.uptimeMillis() + 60000;
            sRetry = this;
            Handler handler = this.handler;
            handler.sendMessageDelayed(handler.obtainMessage(1003), 2000L);
            this.callback = null;
        }
    }

    public static boolean isSwitching() {
        boolean z16 = sIsSwitching.get();
        QLog.e(TAG, 1, "isSwitching: " + z16 + "," + sSwitcher);
        return z16;
    }

    private static boolean isUnzipValid(Context context, ThemeLocator themeLocator) {
        File file = new File(themeLocator.getUnzipPath());
        if (ThemeUtil.getThemeInfo(context, themeLocator.getThemeId()) != null && file.exists()) {
            return true;
        }
        return false;
    }

    private static boolean moveThemeDir(Context context, File file) {
        boolean z16 = false;
        File parentFile = context.getDir(QQTheme.INTERNAL_THEME_DIR_810, 0).getParentFile();
        while (!z16 && !file.equals(parentFile)) {
            File file2 = new File(file.getParent(), ThemeCleaner.MOVE_PREFIX + Long.toString(System.currentTimeMillis()));
            z16 = file.renameTo(file2);
            QLog.e(TAG, 1, "unzipTheme rename " + file + " success: " + z16 + ", dest=" + file2);
            file = file.getParentFile();
        }
        return z16;
    }

    private boolean needSwitch() {
        if (INIT_SET.contains(this.from)) {
            String skinRootPath = SkinEngine.getInstances().getSkinRootPath();
            String unzipPath = this.themeLocator.getUnzipPath();
            if (TextUtils.isEmpty(unzipPath) && TextUtils.isEmpty(skinRootPath)) {
                QLog.e(TAG, 1, "needSwitch: normal not changed");
                return false;
            }
            if (!TextUtils.isEmpty(unzipPath) && unzipPath.equals(skinRootPath)) {
                if (ThemeReporter.FROM_AUTH.equals(this.from) && ThemeUtil.needRefreshWhenInit() && VasNormalToggle.VAS_THEME_INIT_REFRESH.isEnable(true)) {
                    QLog.e(TAG, 1, "init theme add notify to refresh ui");
                    return true;
                }
                QLog.e(TAG, 1, "needSwitch: " + this.themeLocator.getThemeId() + " not changed");
                return false;
            }
        }
        if (ThemeReporter.FROM_NIGHT_ROAMING.equals(this.from) && "1000".equals(this.themeLocator.getThemeId()) && QQTheme.isDefaultTheme() && switchOn()) {
            return false;
        }
        return true;
    }

    public static void onComplete(String str, int i3) {
        String str2;
        DownloadListenser downloadListenser;
        QLog.e(TAG, 1, "onComplete: " + str + "," + i3);
        if (i3 == 0 && str.startsWith(ThemeUpdateCallback.SCID_THEME_ZIP_PREFIX)) {
            str2 = unzipTheme(str, false);
            if (TextUtils.isEmpty(str2)) {
                VasMonitorDT.reportErrCode("individual_v2_theme_setup_err", UNZIP_FAIL);
            }
        } else {
            str2 = null;
        }
        if (isSwitching()) {
            ThemeSwitcher themeSwitcher = sSwitcher;
            if (themeSwitcher != null && (downloadListenser = themeSwitcher.downloadListenser) != null) {
                downloadListenser.onComplete(str, str2, i3);
                return;
            }
            return;
        }
        if (i3 == 0 && str.startsWith(ThemeUpdateCallback.SCID_THEME_ZIP_PREFIX)) {
            String iDFromSCID = ThemeUtil.getIDFromSCID(str);
            String currentThemeId = ThemeUtil.getCurrentThemeId();
            QLog.e(TAG, 1, "theme update: " + iDFromSCID + " engineId: " + currentThemeId);
            if (!TextUtils.isEmpty(iDFromSCID) && iDFromSCID.equals(currentThemeId)) {
                startSwitch(iDFromSCID, ThemeReporter.FROM_UPDATE, null);
            }
            ThemeReporter.reportTheme(null, ThemeReporter.SUBACTION_THEME, ThemeReporter.FROM_UPDATE, 153, 1, 35, iDFromSCID, "20000000", ThemeReporter.PATH_DOWNLOAD, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEndSwitch(int i3, boolean z16, boolean z17) {
        boolean z18;
        IThemeSwitchCallback iThemeSwitchCallback;
        boolean z19 = false;
        boolean z26 = true;
        if (this.done.compareAndSet(false, true)) {
            QLog.e(TAG, 1, "onEndSwitch: " + i3 + "," + z16 + " " + this);
            String themeId = this.themeLocator.getThemeId();
            VasLogReporter.getTheme().report("theme_finish[themeId=" + themeId + ",errorCode=" + i3 + MttLoader.QQBROWSER_PARAMS_FROME + this.from + "]");
            ReportInfo value2 = VasCommonReporter.getTheme().setValue1(String.valueOf(i3)).setValue2(themeId);
            if (i3 == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            value2.report(z18);
            VasCommonReporter.getTheme().setValue3("succeedCode").setValue4(themeId).setValue5(this.from).setNum1(i3).report();
            VasCommonReporter.getTheme().setValue3("speed").setValue4(themeId).setValue5(this.from).setNum1(SystemClock.uptimeMillis() - this.startTime).report();
            VasTraceLogProxy vasTraceLogProxy = VasTraceLog.Theme.THEME_SWITCH;
            if (i3 != 0) {
                z26 = false;
            }
            vasTraceLogProxy.end(z26);
            synchronized (sIsSwitching) {
                if (sSwitcher == this) {
                    sSwitcher = null;
                    sIsSwitching.set(false);
                }
            }
            if (!z16 && (iThemeSwitchCallback = this.callback) != null) {
                z19 = iThemeSwitchCallback.postSwitch(i3);
            }
            if (!z19 && ((ThemeReporter.FROM_SIMPLE.equals(this.from) || ThemeReporter.FROM_SIMPLE_INIT.equals(this.from) || ThemeReporter.FROM_NIGHT.equals(this.from)) && z17)) {
                reqSetSimpleUISwitch(i3);
            }
            if (NormalNightModeUtil.getNormalNightModeFeatureSwitch()) {
                reqSetNormalNightModeSwitch(this.from, this.themeLocator);
            }
        }
    }

    public static void onProgress(String str, long j3, long j16) {
        DownloadListenser downloadListenser;
        ThemeSwitcher themeSwitcher = sSwitcher;
        if (themeSwitcher == null) {
            downloadListenser = null;
        } else {
            downloadListenser = themeSwitcher.downloadListenser;
        }
        DownloadListenser downloadListenser2 = downloadListenser;
        if (downloadListenser2 != null) {
            downloadListenser2.onProgress(str, j3, j16);
        }
    }

    private void queryThemeVersion(AppRuntime appRuntime) {
        ((IVasQuickUpdateService) appRuntime.getRuntimeService(IVasQuickUpdateService.class, "")).queryItemVersion(3, this.themeLocator.getCfgScid(), true, true, 0L, this);
    }

    private void reqSetSimpleUISwitch(int i3) {
        String themeId = this.themeLocator.getThemeId();
        int prefByThemeId = SimpleUIUtil.getPrefByThemeId(themeId);
        if (i3 == 0 && ThemeUtil.getCreateAppRuntime() != null && SimpleUIUtil.isValidSimplePref(prefByThemeId)) {
            boolean isNowSimpleMode = SimpleUIUtil.isNowSimpleMode();
            ISimpleUIHandler iSimpleUIHandler = (ISimpleUIHandler) QRoute.api(ISimpleUIHandler.class);
            iSimpleUIHandler.setReqTs(iSimpleUIHandler.sendSwitchAndSetSimpleUI(isNowSimpleMode, prefByThemeId, false));
            if (QLog.isColorLevel()) {
                QLog.d("SimpleUIHandler", 2, "NightModeLogic.postSwitch, bSwitch = " + isNowSimpleMode + "; bPref = " + prefByThemeId + "; themeId = " + themeId);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SimpleUIHandler", 2, "NightModeLogic.postSwitch error, mBPref = " + prefByThemeId + "; themeId = " + themeId + "; code = " + i3);
        }
    }

    public static boolean startSwitch(String str, String str2, IThemeSwitchCallback iThemeSwitchCallback) {
        return startSwitch(ThemeUtil.getCreateAppRuntime(), str, str2, iThemeSwitchCallback);
    }

    private boolean switchOn() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d(TAG, 1, "appRuntime is null");
            return true;
        }
        boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("shield_default_theme_change");
        QLog.d(TAG, 1, "switch result : ", Boolean.valueOf(isFeatureSwitchEnable));
        return isFeatureSwitchEnable;
    }

    public static boolean unVideoZipTheme(String str, String str2) {
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            QLog.e(TAG, 1, "unzipTheme: context == null");
            return false;
        }
        if (!new ThemeLocator().setThemeId(ThemeUtil.getIDFromSCID(str)).init(context, str, "").isZipExist()) {
            QLog.e(TAG, 1, "unzipTheme: zip file missing");
            return false;
        }
        return !TextUtils.isEmpty(VasSafeUnzip.safeUnZipFile(new File(r6.getZipPath()), str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String unzipTheme(String str, boolean z16) {
        boolean z17;
        int i3;
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            QLog.e(TAG, 1, "unzipTheme: context == null");
            return null;
        }
        String iDFromSCID = ThemeUtil.getIDFromSCID(str);
        ThemeLocator init = new ThemeLocator().setThemeId(iDFromSCID).init(context, str, "");
        if (!init.isZipExist()) {
            QLog.e(TAG, 1, "unzipTheme: zip file missing");
            return null;
        }
        String zipPath = init.getZipPath();
        String encryptFile = FileUtils.encryptFile(zipPath, KeyPropertiesCompact.DIGEST_MD5);
        if (TextUtils.isEmpty(encryptFile)) {
            QLog.e(TAG, 1, "unzipTheme: fail to get md5");
            return null;
        }
        init.init(context, str, encryptFile);
        String unzipPath = init.getUnzipPath();
        QLog.e(TAG, 1, "unzipTheme to " + unzipPath);
        File file = new File(unzipPath);
        if (!z16 && file.exists()) {
            if (isUnzipValid(context, init)) {
                QLog.e(TAG, 1, "unzipTheme unzipDir exists");
                return encryptFile;
            }
            z17 = !VasUpdateUtil.safeDeleteFile(file, ThemeCleaner.MOVE_PREFIX);
            QLog.e(TAG, 1, "unzipTheme remove oldUnzip needMove: " + z17 + " unzip exists: " + file.exists());
        } else {
            z17 = z16;
        }
        if (z17) {
            moveThemeDir(context, file);
            VasMonitorDT.reportErrCode("individual_v2_theme_setup_err", NEED_MOVE);
        }
        try {
            FileUtils.uncompressZip(zipPath, unzipPath, false);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "unzipTheme failed", e16);
        }
        if (file.exists()) {
            i3 = ThemeUtil.getFileNumInFile(file);
            if (i3 != 0) {
                if (z16) {
                    QLog.e(TAG, 1, "unzipTheme unzip failed twice");
                    return null;
                }
                return unzipTheme(str, true);
            }
            ThemeUtil.ThemeInfo themeInfo = ThemeUtil.getThemeInfo(context, iDFromSCID);
            if (themeInfo == null) {
                QLog.e(TAG, 1, "unzipTheme no ThemeInfo " + iDFromSCID);
                themeInfo = new ThemeUtil.ThemeInfo();
                themeInfo.themeId = iDFromSCID;
                themeInfo.version = "20000000";
                themeInfo.zipVer = ThemeConstants.ZIP_VERSION;
                themeInfo.isVoiceTheme = false;
            }
            themeInfo.status = "5";
            themeInfo.fileNum = i3;
            long length = new File(zipPath).length();
            themeInfo.size = length;
            themeInfo.downsize = length;
            ThemeUtil.setThemeInfo(context, themeInfo);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "unzipTheme success: " + themeInfo);
            }
            return encryptFile;
        }
        i3 = 0;
        if (i3 != 0) {
        }
    }

    AppRuntime check() {
        AppRuntime createAppRuntime = ThemeUtil.getCreateAppRuntime();
        if (createAppRuntime != null && createAppRuntime.isLogin()) {
            if (sSwitcher != this) {
                QLog.e(TAG, 1, "newSwitcher: " + sSwitcher + " old is:" + this);
                return null;
            }
            return createAppRuntime;
        }
        QLog.e(TAG, 1, "app is destroy: " + createAppRuntime + " switcher: " + this);
        onEndSwitch(2, true, true);
        return null;
    }

    protected void downloadTheme(AppRuntime appRuntime, boolean z16) {
        this.downloadListenser = new DownloadListenser(z16);
        ThemeUpdateCallback.sInstance.download(this.themeLocator.getCfgScid());
        VasLogReporter.getTheme().report("theme_start_download[themeId=" + this.themeLocator.getThemeId() + "]");
        VasTraceLog.Theme.THEME_SWITCH.report("start_download");
        ThemeReporter.reportTheme(appRuntime, ThemeReporter.SUBACTION_THEME, this.from, 153, -1, 7, this.themeLocator.getThemeId(), "20000000", ThemeReporter.PATH_DOWNLOAD, "");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        AppRuntime check = check();
        boolean z16 = false;
        if (check != null && check.getApp() != null) {
            int i3 = message.what;
            if (i3 == 1000) {
                IThemeSwitchCallback iThemeSwitchCallback = this.callback;
                if (iThemeSwitchCallback != null) {
                    iThemeSwitchCallback.beginSwitch();
                }
            } else if (i3 == 1001) {
                doThemeSwitch(check);
            } else if (i3 == 1002) {
                int i16 = message.arg1;
                if (i16 < 10) {
                    if (!realDoSwitchTheme(check.getApp(), this.themeLocator.getThemeId(), this.themeLocator.getUnzipPath())) {
                        this.handler.sendMessageDelayed(this.handler.obtainMessage(1002, i16 + 1, 0), 1000L);
                        return true;
                    }
                    QLog.e(TAG, 1, "retry switchSuccess: " + this);
                }
                QLog.e(TAG, 1, "retryCount: " + i16);
                onEndSwitch(0, false, true);
            } else if (i3 == 1003) {
                if (sRetry != this) {
                    QLog.e(TAG, 1, "sRetry reset, stop retry: " + this);
                    z16 = true;
                }
                if (SystemClock.uptimeMillis() > this.retryDeadLine) {
                    QLog.e(TAG, 1, "meet deadLine, stop retry " + this);
                    VasMonitorDT.reportErrCode("individual_v2_theme_setup_err", ENGINE_TIMEOUT);
                    z16 = true;
                }
                if (z16) {
                    sRetry = null;
                } else if (SkinEngine.getInstances().mResources == null) {
                    Handler handler = this.handler;
                    handler.sendMessageDelayed(handler.obtainMessage(1003), 2000L);
                } else {
                    QLog.e(TAG, 1, "engine ready, retry: " + this);
                    sRetry = null;
                    startSwitch(check, this.themeLocator.getThemeId(), this.from, null);
                }
            }
            return true;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "app null or app.getApp is null when handleMessage: ";
        objArr[1] = Integer.valueOf(message.what);
        objArr[2] = " [app null] : ";
        if (check == null) {
            z16 = true;
        }
        objArr[3] = Boolean.valueOf(z16);
        QLog.e(TAG, 1, objArr);
        return true;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback
    public void onQueryItemVer(int i3, String str, String str2) {
        QLog.e(TAG, 1, "onQueryItemVer: " + i3 + "," + str + "," + str2);
        AppRuntime check = check();
        if (check == null) {
            return;
        }
        if (i3 == 2) {
            onEndSwitch(-201, false, true);
            StringBuilder obtain = StringBuilderUtils.obtain();
            obtain.append("os.arch: " + System.getProperty("os.arch"));
            obtain.append(" DeviceInfoUtil#getCpuType: " + ah.o());
            obtain.append(" Build.CPU_ABI: " + Build.CPU_ABI);
            obtain.append(" Build.CPU_ABI2: " + Build.CPU_ABI2);
            obtain.append(" Build.SUPPORTED_ABIS: " + Arrays.toString(Build.SUPPORTED_ABIS));
            VasMonitorDT.reportErrCode("individual_v2_theme_setup_err", QUERY_TIMEOUT);
            return;
        }
        if (i3 == 1) {
            downloadTheme(check, false);
            return;
        }
        this.themeLocator.init(check.getApp(), str, str2);
        if (isUnzipValid(check.getApp(), this.themeLocator)) {
            String currentThemeId = ThemeUtil.getCurrentThemeId();
            if (!INIT_SET.contains(this.from) && !this.themeLocator.getThemeId().equals(currentThemeId)) {
                downloadTheme(check, true);
                return;
            } else {
                doSwitch();
                return;
            }
        }
        VasLogReporter.getTheme().report("unZip dir not exist, download again", VasLogReportProxy.LEVEL.HIGHEST);
        this.themeLocator.reset();
        downloadTheme(check, false);
    }

    protected boolean realDoSwitchTheme(Context context, String str, String str2) {
        boolean skinRootPath;
        String str3;
        QLog.e(TAG, 1, "setSkinRoot: " + str2);
        QUITokenResUtil.setCurrentDebugThemeId("0");
        String newSimpleThemeId = QQTheme.getNewSimpleThemeId();
        if (QQTheme.isThemeSimpleUI(str)) {
            SimpleTintManager instance = SimpleTintManager.instance();
            instance.setThemeId(str);
            SkinEngine.getInstances().setSkinTint(instance);
            skinRootPath = SimpleUIManager.initLocalSimpleSkin(context);
            QQTheme.setNewSimpleThemeId(str);
        } else {
            QQTheme.setNewSimpleThemeId("");
            SkinEngine.getInstances().setSkinTint(BusinessTintManager.instance());
            skinRootPath = SkinEngine.getInstances().setSkinRootPath(context, str2);
        }
        if (skinRootPath) {
            QQTheme.setCurThemeId(null);
            QUIResourcesTransform.getInstance().onThemeUpdate(str, str2);
            return true;
        }
        if (newSimpleThemeId == null) {
            str3 = "";
        } else {
            str3 = newSimpleThemeId;
        }
        QQTheme.setNewSimpleThemeId(str3);
        if (newSimpleThemeId == null) {
            newSimpleThemeId = "";
        }
        if (QQTheme.isThemeSimpleUI(newSimpleThemeId)) {
            SkinEngine.getInstances().setSkinTint(SimpleTintManager.instance());
            return false;
        }
        SkinEngine.getInstances().setSkinTint(BusinessTintManager.instance());
        return false;
    }

    protected void realStartSwitch(AppRuntime appRuntime) {
        String currentThemeId;
        this.startTime = SystemClock.uptimeMillis();
        String themeId = this.themeLocator.getThemeId();
        QLog.e(TAG, 1, VasTextUtil.hideUinInShowString(appRuntime.getAccount(), 2) + " startSwitch: " + themeId + ", " + this.from);
        VasLogReporter.getTheme().report("theme_startSwitch[themeId=" + themeId + MttLoader.QQBROWSER_PARAMS_FROME + this.from + "]");
        if (VasTraceLog.isHit() && ((currentThemeId = ThemeUtil.getCurrentThemeId()) == null || !currentThemeId.equals(themeId))) {
            VasTraceLog.Theme.THEME_SWITCH.start();
        }
        this.handler.sendEmptyMessage(1000);
        if ("1000".equals(themeId)) {
            doSwitch();
            return;
        }
        if ("999".equals(themeId)) {
            copyDiyTheme();
            return;
        }
        if ("900".equals(themeId)) {
            this.themeLocator.initLocalTheme();
            doSwitch();
        } else if (QQTheme.isThemeSimpleUI(themeId)) {
            doSwitch();
        } else {
            queryThemeVersion(appRuntime);
        }
    }

    void reqSetNormalNightModeSwitch(String str, ThemeLocator themeLocator) {
        if (!ThemeReporter.FROM_INIT_THEME.equals(str) && !ThemeReporter.FROM_SIMPLE_INIT.equals(str) && !ThemeReporter.FROM_AUTH.equals(str)) {
            ((INormalNightModeHandler) QRoute.api(INormalNightModeHandler.class)).reqSetNormalNightModeSwitch(ThemeUtil.getCreateAppRuntime(), "1103".equals(themeLocator.getThemeId()));
        }
    }

    public String toString() {
        return this.themeLocator.getThemeId() + " start " + this.startTimeStr + " ," + this.from;
    }

    public static boolean isSwitching(String str) {
        ThemeSwitcher themeSwitcher = sSwitcher;
        return themeSwitcher != null && themeSwitcher.themeLocator.getThemeId().equals(str);
    }

    public static boolean startSwitch(AppRuntime appRuntime, String str, String str2, IThemeSwitchCallback iThemeSwitchCallback) {
        ThemeLocator themeLocator;
        if (!TextUtils.isEmpty(str) && VasTextUtil.isNumeral(str)) {
            if (!sIsSwitching.compareAndSet(false, true)) {
                QLog.e(TAG, 1, "set " + str + " when NOT_FINISH " + sSwitcher);
                ThemeSwitcher themeSwitcher = sSwitcher;
                if (themeSwitcher != null && (themeLocator = themeSwitcher.themeLocator) != null && str.equals(themeLocator.getThemeId())) {
                    if (iThemeSwitchCallback != null) {
                        iThemeSwitchCallback.postSwitch(0);
                    }
                    QLog.e(TAG, 1, "already setting same theme, no need to reset:" + str + "," + str2);
                    return true;
                }
            }
            sRetry = null;
            ThemeSwitcher themeSwitcher2 = new ThemeSwitcher(appRuntime, iThemeSwitchCallback, str, str2);
            synchronized (sIsSwitching) {
                ThemeSwitcher themeSwitcher3 = sSwitcher;
                sSwitcher = themeSwitcher2;
                if (themeSwitcher3 != null) {
                    themeSwitcher3.onEndSwitch(-202, false, true);
                }
            }
            themeSwitcher2.realStartSwitch(appRuntime);
            return true;
        }
        QLog.e(TAG, 1, "error themeId: " + str);
        if (iThemeSwitchCallback != null) {
            iThemeSwitchCallback.postSwitch(1);
        }
        VasMonitorDT.reportErrCode("individual_v2_theme_setup_err", WRONG_ID);
        return false;
    }

    ThemeSwitcher(AppRuntime appRuntime, IThemeSwitchCallback iThemeSwitchCallback, String str, String str2) {
        this.callback = iThemeSwitchCallback;
        this.from = str2;
        this.themeLocator.setThemeId(str);
        this.startTimeStr = new SimpleDateFormat("MM-dd HH:mm:ss").format(new Date());
    }
}
