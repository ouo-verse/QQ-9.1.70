package com.tencent.mobileqq.data.nativemonitor;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.JobReporter;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.ThreadManagerInitialler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper;
import com.tencent.mobileqq.nativememorymonitor.library.ExternalProvider;
import com.tencent.mobileqq.nativememorymonitor.library.NativeMemoryMonitor;
import com.tencent.mobileqq.nativememorymonitor.library.trafficmonitor.INativeHookMonitor;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qqsomonitor.f;
import com.tencent.mobileqq.qqsomonitor.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class NativeMonitorConfigHelper {
    private static final int DEFAULT_LIMITED = -3;

    /* renamed from: GROUP, reason: collision with root package name */
    public static final String f203157GROUP = "100458";
    private static final boolean IS_ONLY_HOOK_JNI = true;
    public static final String KEY_EVENT_CODE_ALL_SO_LOAD = "native_monitor_all_so_load";
    public static final String KEY_EVENT_CODE_NATIVE_HOOK = "native_monitor_native_hook";
    public static final String KEY_EVENT_CODE_SO_LOAD = "native_monitor_so_load";
    private static final String LOAD_LIBRARY_STACK = "java.lang.System.loadLibrary";
    private static final String NATIVE_LIB_PREFIX = "/NativeLib";
    private static final int SO_LOAD_DEFAULT_DD_REPORT_RATE = 1;
    private static final int SO_LOAD_DEFAULT_ILLEGAL_REPORT_RATE = 1;
    private static final int SO_LOAD_DEFAULT_REPORT_RATE = 10;
    private static final int STACK_DEPTH = 20;
    private static final int STACK_START = 7;
    public static final String SUB_KEY_BACKTRACE = "backtrace";
    public static final String SUB_KEY_COST = "time_cost";
    public static final String SUB_KEY_FLAG = "so_flag";
    public static final String SUB_KEY_IS_64_BIT = "is_64_bit";
    public static final String SUB_KEY_IS_DOT_DOT_PATH = "is_dot_dot_path";
    public static final String SUB_KEY_LEGAL = "is_legal";
    public static final String SUB_KEY_LEGAL_DETAIL = "legal_detail";
    public static final String SUB_KEY_NATIVE_HOOK_RES = "native_hook_res";
    public static final String SUB_KEY_PROCESS = "process";
    public static final String SUB_KEY_REGISTERED = "is_registered";
    public static final String SUB_KEY_SO_LENGTH = "so_length";
    public static final String SUB_KEY_SO_MD5 = "so_md5";
    public static final String SUB_KEY_SO_PATH = "so_path";
    public static final String SUB_KEY_SYMBOL = "so_name";
    public static final String TAG = "NativeMonitorConfig";
    private static String sDataDir;
    private static String sLibraryDir;
    private static String sProcessName;
    private static String sUserDir;
    private static NativeMonitorConfig sConfig = new NativeMonitorConfig();
    private static String configUin = "";
    private static boolean configInited = false;
    private static boolean isHooked = false;
    private static boolean isHookedNativeThreadCreated = false;
    private static boolean isHookedSoLoad = false;
    private static boolean isSoLoadReportRateInited = false;
    private static int soLoadReportRate = 10;
    private static int soLoadDDReportRate = 1;
    private static int soLoadIllegalReportRate = 1;
    private static int allSoLoadReportRate = 0;
    private static boolean isBanIllegalSoLoad = false;
    private static boolean isBanDotDotSoLoad = false;
    private static List<String> soMonitorBlacklist = null;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements INativeHookMonitor {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(String str, String str2, int i3) {
            String currentUin;
            HashMap hashMap = new HashMap();
            hashMap.put(NativeMonitorConfigHelper.SUB_KEY_SYMBOL, str);
            hashMap.put(NativeMonitorConfigHelper.SUB_KEY_SO_PATH, NativeMonitorConfigHelper.setPath(str2));
            hashMap.put(NativeMonitorConfigHelper.SUB_KEY_NATIVE_HOOK_RES, String.valueOf(i3));
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                currentUin = "0";
            } else {
                currentUin = peekAppRuntime.getCurrentUin();
            }
            QLog.d(NativeMonitorConfigHelper.TAG, 1, "onNativeHook reportBeacon, param: " + hashMap);
            QQBeaconReport.report(currentUin, NativeMonitorConfigHelper.KEY_EVENT_CODE_NATIVE_HOOK, hashMap);
        }

        @Override // com.tencent.mobileqq.nativememorymonitor.library.trafficmonitor.INativeHookMonitor
        public void onNativeHook(final String str, final String str2, final int i3) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.data.nativemonitor.a
                @Override // java.lang.Runnable
                public final void run() {
                    NativeMonitorConfigHelper.a.b(str, str2, i3);
                }
            }, 16, null, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements ExternalProvider {
        b() {
        }

        @Override // com.tencent.mobileqq.nativememorymonitor.library.ExternalProvider
        public void onSoLoad(String str, String str2) {
            NativeMonitorConfigHelper.reportSoLoadEvent(str, str2);
        }
    }

    static {
        NativeMemoryMonitor.setSoLoader(c.a());
    }

    static /* bridge */ /* synthetic */ String c() {
        return getProcessName();
    }

    private static void convertOldMmkvData() {
        f.c(BaseApplicationImpl.getApplication());
    }

    private static NativeMonitorConfig getConfig() {
        return (NativeMonitorConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(f203157GROUP);
    }

    @Nullable
    private static Long getHookFlag(NativeMonitorConfig nativeMonitorConfig) {
        long switchFlag = nativeMonitorConfig.getSwitchFlag();
        if (isInProcessBlackList(nativeMonitorConfig)) {
            QLog.i(TAG, 1, "process id:" + MobileQQ.sProcessId + "  is in black list");
            return null;
        }
        QLog.i(TAG, 1, "process id:" + MobileQQ.sProcessId + "  not in black list");
        return Long.valueOf(switchFlag & (-5) & (-65) & (-4294967297L) & (-2147483649L) & (-3));
    }

    @NonNull
    private static String getProcessName() {
        String str = sProcessName;
        if (str != null) {
            return str;
        }
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        String qQProcessName = application.getQQProcessName();
        String packageName = application.getPackageName();
        if (qQProcessName.equals(packageName)) {
            sProcessName = "main";
        } else if (qQProcessName.startsWith(packageName)) {
            sProcessName = qQProcessName.substring(packageName.length());
        }
        return sProcessName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getSoLegalDetailString(int i3) {
        switch (i3) {
            case -2:
                return "error";
            case -1:
                return "no_info";
            case 0:
                return "legal";
            case 1:
                return "name_illegal";
            case 2:
                return "path_illegal";
            case 3:
                return "length_illegal";
            case 4:
                return "lastModified_illegal";
            default:
                return "unknown";
        }
    }

    private static long getSwitchFlag() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "flag:51startTohook");
        }
        return 51L;
    }

    private static void initSoLoadConfig() {
        boolean z16;
        NativeMonitorConfig nativeMonitorConfig = (NativeMonitorConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(f203157GROUP);
        if (!isSoLoadReportRateInited && nativeMonitorConfig != null) {
            soLoadReportRate = nativeMonitorConfig.soLoadReportRate;
            soLoadDDReportRate = nativeMonitorConfig.soLoadDDReportRate;
            soLoadIllegalReportRate = nativeMonitorConfig.soLoadIllegalReportRate;
            allSoLoadReportRate = nativeMonitorConfig.allSoLoadReportRate;
            boolean z17 = false;
            if (nativeMonitorConfig.isBanIllegalSoLoad == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            isBanIllegalSoLoad = z16;
            if (nativeMonitorConfig.isBanDotDotSoLoad == 1) {
                z17 = true;
            }
            isBanDotDotSoLoad = z17;
            QLog.d(TAG, 1, "initSoLoadReportRate, soLoadReportRate: " + soLoadReportRate + ", soLoadDDReportRate: " + soLoadDDReportRate + ", isBanIllegalSoLoad:" + isBanIllegalSoLoad + ", soLoadIllegalReportRate: " + soLoadIllegalReportRate + ", isBanDotDotSoLoad: " + isBanDotDotSoLoad + ", allSoLoadReportRate: " + allSoLoadReportRate);
            isSoLoadReportRateInited = true;
        }
    }

    private static boolean isInProcessBlackList(@NonNull NativeMonitorConfig nativeMonitorConfig) {
        String[] split;
        String processBlackList = nativeMonitorConfig.getProcessBlackList();
        if (TextUtils.isEmpty(processBlackList)) {
            split = null;
        } else {
            split = processBlackList.split("\\|");
        }
        if (split == null) {
            return false;
        }
        for (String str : split) {
            try {
            } catch (NumberFormatException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, e16, new Object[0]);
                }
            }
            if (Integer.valueOf(str).intValue() == MobileQQ.sProcessId) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isNeedCheck(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !str.contains(LOAD_LIBRARY_STACK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isNeedReport(boolean z16, boolean z17, boolean z18) {
        initSoLoadConfig();
        Random random = new Random();
        if (g.g(z16, z17)) {
            if (random.nextInt(soLoadIllegalReportRate) >= 1) {
                return false;
            }
            return true;
        }
        if (z18) {
            if (random.nextInt(soLoadDDReportRate) >= 1) {
                return false;
            }
            return true;
        }
        if (random.nextInt(soLoadReportRate) >= 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized boolean isSoFileInBlackList(String str) {
        synchronized (NativeMonitorConfigHelper.class) {
            if (soMonitorBlacklist == null) {
                NativeMonitorConfig nativeMonitorConfig = (NativeMonitorConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(f203157GROUP);
                if (nativeMonitorConfig != null) {
                    soMonitorBlacklist = nativeMonitorConfig.soMonitorBlacklist;
                }
                QLog.d(TAG, 1, "[isSoFileInBlackList] soMonitorBlacklist: " + soMonitorBlacklist);
            }
            if (soMonitorBlacklist != null && !TextUtils.isEmpty(str)) {
                Iterator<String> it = soMonitorBlacklist.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next(), str)) {
                        QLog.d(TAG, 1, "[isSoFileInBlackList] so: " + str + " is in blacklist");
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportAllSoLoad(String str) {
        boolean z16;
        String currentUin;
        initSoLoadConfig();
        if (allSoLoadReportRate <= 0) {
            return;
        }
        if (new Random().nextInt(allSoLoadReportRate) < 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        String name = new File(str).getName();
        String path = setPath(str);
        HashMap hashMap = new HashMap();
        hashMap.put(SUB_KEY_SYMBOL, name);
        hashMap.put(SUB_KEY_SO_PATH, path);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            currentUin = "0";
        } else {
            currentUin = peekAppRuntime.getCurrentUin();
        }
        QLog.d(TAG, 1, "reportAllSoLoad: name = " + name + ", path = " + path);
        QQBeaconReport.report(currentUin, KEY_EVENT_CODE_ALL_SO_LOAD, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportSoLoadEvent(final String str, final String str2) {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper.3
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                boolean z17;
                String str3;
                boolean equals;
                File file;
                boolean z18;
                String currentUin;
                NativeMonitorConfigHelper.reportAllSoLoad(str);
                String str4 = str2;
                StackTraceElement[] stackTraceElementArr = stackTrace;
                if (stackTraceElementArr != null) {
                    try {
                        str4 = StackUtil.c(stackTraceElementArr, 7, 20);
                    } catch (Exception e16) {
                        QLog.e(NativeMonitorConfigHelper.TAG, 1, "StackUtil ClassNotFoundException.", e16);
                        return;
                    }
                }
                if (!NativeMonitorConfigHelper.isNeedCheck(str4)) {
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                File file2 = new File(str);
                String c16 = g.c(file2);
                long length = file2.length();
                String name = file2.getName();
                String c17 = NativeMonitorConfigHelper.c();
                String path = NativeMonitorConfigHelper.setPath(str);
                BaseApplicationImpl application = BaseApplicationImpl.getApplication();
                boolean isSoFileRegistered = ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).isSoFileRegistered(application, file2);
                int isSoFileLegalDetail = ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).isSoFileLegalDetail(application, file2);
                String soLegalDetailString = NativeMonitorConfigHelper.getSoLegalDetailString(isSoFileLegalDetail);
                String str5 = str4;
                int soFileFlag = ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).getSoFileFlag(application, file2);
                if (!g.f(str) && !com.tencent.mobileqq.qqsomonitor.a.a(soFileFlag)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (isSoFileLegalDetail == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                long lastModified = file2.lastModified();
                String soFileMd5 = ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).getSoFileMd5(application, file2);
                if (TextUtils.isEmpty(soFileMd5)) {
                    str3 = NativeMonitorConfigHelper.TAG;
                    QLog.d(str3, 1, "soFileInfoMd5 is null or empty for  " + name);
                    z18 = z16;
                    equals = z17;
                    file = file2;
                } else {
                    str3 = NativeMonitorConfigHelper.TAG;
                    equals = TextUtils.equals(c16, soFileMd5);
                    file = file2;
                    StringBuilder sb5 = new StringBuilder();
                    z18 = z16;
                    sb5.append("soFileInfoMd5 check result = ");
                    sb5.append(equals);
                    sb5.append(", soFileInfoMd5 = ");
                    sb5.append(soFileMd5);
                    sb5.append(", md5 = ");
                    sb5.append(c16);
                    QLog.d(str3, 1, sb5.toString());
                }
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("soPath: ");
                sb6.append(str);
                sb6.append(", soName: ");
                sb6.append(name);
                sb6.append(", md5: ");
                sb6.append(c16);
                sb6.append(", len: ");
                sb6.append(length);
                sb6.append(", lastModified: ");
                sb6.append(lastModified);
                sb6.append(", proc: ");
                sb6.append(c17);
                sb6.append(", isRegistered: ");
                sb6.append(isSoFileRegistered);
                sb6.append(", isLegal: ");
                sb6.append(equals);
                sb6.append(", soIllegalReason: ");
                sb6.append(soLegalDetailString);
                sb6.append(", cost: ");
                sb6.append(uptimeMillis2);
                sb6.append(", soFileFlag: ");
                sb6.append(soFileFlag);
                sb6.append(", isDotDotPath: ");
                boolean z19 = z18;
                sb6.append(z19);
                sb6.append(", backtrace:\n");
                sb6.append(str5);
                QLog.d(str3, 1, sb6.toString());
                if (NativeMonitorConfigHelper.isSoFileInBlackList(name)) {
                    return;
                }
                if (PrivacyPolicyHelper.isUserAllow() && NativeMonitorConfigHelper.isNeedReport(isSoFileRegistered, equals, z19)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(NativeMonitorConfigHelper.SUB_KEY_SYMBOL, file.getName());
                    hashMap.put(NativeMonitorConfigHelper.SUB_KEY_SO_PATH, path);
                    hashMap.put(NativeMonitorConfigHelper.SUB_KEY_SO_MD5, c16);
                    hashMap.put(NativeMonitorConfigHelper.SUB_KEY_SO_LENGTH, String.valueOf(length));
                    hashMap.put("process", c17);
                    hashMap.put(NativeMonitorConfigHelper.SUB_KEY_BACKTRACE, StackUtil.a(str5, 0, 20));
                    hashMap.put(NativeMonitorConfigHelper.SUB_KEY_IS_64_BIT, "true");
                    hashMap.put(NativeMonitorConfigHelper.SUB_KEY_REGISTERED, String.valueOf(isSoFileRegistered));
                    hashMap.put(NativeMonitorConfigHelper.SUB_KEY_LEGAL, String.valueOf(equals));
                    hashMap.put(NativeMonitorConfigHelper.SUB_KEY_LEGAL_DETAIL, soLegalDetailString);
                    hashMap.put("time_cost", String.valueOf(uptimeMillis2));
                    hashMap.put(NativeMonitorConfigHelper.SUB_KEY_FLAG, String.valueOf(soFileFlag));
                    hashMap.put(NativeMonitorConfigHelper.SUB_KEY_IS_DOT_DOT_PATH, String.valueOf(z19));
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime == null) {
                        currentUin = "0";
                    } else {
                        currentUin = peekAppRuntime.getCurrentUin();
                    }
                    QQBeaconReport.report(currentUin, NativeMonitorConfigHelper.KEY_EVENT_CODE_SO_LOAD, hashMap);
                }
                if (isSoFileRegistered && !equals && NativeMonitorConfigHelper.isBanIllegalSoLoad) {
                    com.tencent.qqperf.monitor.crash.catchedexception.a.b(new RuntimeException(file.getName() + " so is illegal: " + soLegalDetailString));
                }
                if (z19 && NativeMonitorConfigHelper.isBanDotDotSoLoad) {
                    throw new RuntimeException(file.getName() + " has dotdot path");
                }
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static String setPath(String str) {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (sLibraryDir == null) {
            sLibraryDir = AECameraConstants.WIDGETINFO_SEPARATE + application.getApplicationInfo().nativeLibraryDir;
        }
        if (sDataDir == null) {
            sDataDir = "^/data/data/" + application.getPackageName();
        }
        if (sUserDir == null) {
            sUserDir = "^/data/user/[0-9]+/" + application.getPackageName();
        }
        String replaceFirst = str.replaceFirst(sLibraryDir, NATIVE_LIB_PREFIX);
        if (!replaceFirst.equals(str)) {
            return replaceFirst;
        }
        String replaceFirst2 = str.replaceFirst(sDataDir, "");
        if (!replaceFirst2.equals(str)) {
            return replaceFirst2;
        }
        return str.replaceFirst(sUserDir, "");
    }

    public static synchronized void setupSoLoadHook() {
        synchronized (NativeMonitorConfigHelper.class) {
            if (!isHookedSoLoad && Build.VERSION.SDK_INT >= 24) {
                isHookedSoLoad = true;
                QLog.i(TAG, 1, "setupSoLoadHook");
                NativeMemoryMonitor.getInstance().setNativeHookMonitor(new a());
                NativeMemoryMonitor.getInstance().setupSoLoadHook(BaseApplication.getContext(), new b(), true);
                if (MobileQQ.sProcessId == 1) {
                    convertOldMmkvData();
                }
            }
        }
    }

    public static synchronized void startHook(Context context, long j3, String[] strArr, long j16, long j17, long j18) {
        synchronized (NativeMonitorConfigHelper.class) {
            if (isHooked) {
                return;
            }
            isHooked = true;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "start hook native after config ready");
            }
            NativeMemoryMonitor.getInstance().init(j3, strArr, j16, j17, j18);
        }
    }

    public static synchronized void startHookThreadCreate() {
        synchronized (NativeMonitorConfigHelper.class) {
            if (!isHookedNativeThreadCreated) {
                isHookedNativeThreadCreated = true;
                QLog.d(TAG, 1, "startHookThreadCreate");
                NativeMemoryMonitor.getInstance().initThreadHook(JobReporter.ThreadOnCreatedCallBack);
                JobReporter.setReportThread();
                JobReporter.sInitThreadMonitorTime = SystemClock.uptimeMillis();
            }
        }
    }

    public static void startToHookAfterConfigGet(boolean z16) {
        Long hookFlag;
        if (AppSetting.C) {
            NativeMemoryMonitor.getInstance().setupASanCallback();
            return;
        }
        boolean b16 = com.tencent.mobileqq.statistics.cpu.a.b();
        if (b16 && Build.VERSION.SDK_INT <= 27 && !AppSetting.C) {
            NativeMonitorConfig config = getConfig(BaseApplicationImpl.getApplication().getRuntime());
            if (config != null && config.getOpenBacktrace64() != 1) {
                return;
            }
            if (config != null) {
                BaseApplicationImpl.sNativeMonitorEscapedMsg = "open: " + config.getNativeMonitorOpened() + ", flag: " + config.getSwitchFlag();
                ThreadManagerInitialler.initShotChanceForPublicVersion(sConfig.getTmChance());
            }
            if (config == null || config.getNativeMonitorOpened() != 1 || (hookFlag = getHookFlag(config)) == null) {
                return;
            }
            startHook(BaseApplication.getContext(), hookFlag.longValue(), null, config.getTimeLimited(), config.getCountLimted(), config.getMemoryLimited());
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "arm: " + b16 + ", useASan: " + AppSetting.C);
        }
    }

    public static void updateConfig(NativeMonitorConfig nativeMonitorConfig) {
        configInited = true;
        sConfig.update(nativeMonitorConfig);
    }

    public static NativeMonitorConfig getConfig(AppRuntime appRuntime) {
        if (appRuntime == null) {
            configInited = true;
            return sConfig;
        }
        String account = appRuntime.getAccount();
        if (!configInited || !TextUtils.equals(configUin, account)) {
            NativeMonitorConfig config = getConfig();
            if (config != null) {
                updateConfig(config);
            }
            configUin = account;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "NativeMonitorConfig:" + sConfig.toString());
        }
        configInited = true;
        return sConfig;
    }
}
