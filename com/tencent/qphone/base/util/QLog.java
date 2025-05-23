package com.tencent.qphone.base.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.mars.xlog.Xlog;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qphone.base.util.log.builder.QLogConfig;
import com.tencent.qphone.base.util.report.QLogReportManager;
import com.tencent.qphone.base.util.report.firebase.QLogFirebaseReportManager;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QLog {
    public static final String ANDROID_LOG_LEVEL_D = "D";
    public static final byte ANDROID_LOG_LEVEL_D_BYTE = 1;
    public static final String ANDROID_LOG_LEVEL_E = "E";
    public static final byte ANDROID_LOG_LEVEL_E_BYTE = 4;
    public static final String ANDROID_LOG_LEVEL_I = "I";
    public static final byte ANDROID_LOG_LEVEL_I_BYTE = 2;
    public static final String ANDROID_LOG_LEVEL_W = "W";
    public static final byte ANDROID_LOG_LEVEL_W_BYTE = 3;
    public static final int CLR = 2;
    public static final int DEV = 4;
    private static final String LOG_HOOK_PREFIX_TAG = "log_hook_pre_";
    private static final String LOG_TRUNCATED_NOTE = " \u65e5\u5fd7\u8d851024\u4e2a\u5b57\u7b26\uff0c\u540e\u9762\u4e0d\u6253\u5370\u4e86\uff01\uff01\uff01";
    private static final int MAX_LOG_LENGTH = 1024;
    public static final String MSF_IS_COLOR_LEVEL = "QLogConfig_B";
    public static final String TAG_REPORTLEVEL_COLORUSER = "W";
    public static final String TAG_REPORTLEVEL_DEVELOPER = "D";
    public static final String TAG_REPORTLEVEL_USER = "E";
    public static final int USR = 1;
    public static final String logLevelHead = "LOGLEVEL_";
    public static final String logLevelTime = "LOGLEVELTIME";
    private static Context sAppContext = null;
    private static boolean sHasStoragePermission = false;
    private static QLogItemManager sLogManager = null;
    private static OnPrintlnCallback sOnPrintlnCallback = null;
    private static final String tag = "QLog";
    private static final String manualLogLevelPath = Environment.getExternalStorageDirectory() + "/mqqLogLevel";
    private static final Charset logCharset = Charset.forName("UTF-8");
    public static int _DEFAULT_REPORTLOG_LEVEL = 4;
    private static int UIN_REPORTLOG_LEVEL = 4;
    private static boolean isDebug = false;
    private static boolean isGray = false;
    private static boolean isPublish = false;
    private static byte forceCallbackAndroidLogLevel = Byte.MAX_VALUE;
    public static boolean sLogcatHooked = false;
    private static String processName = "";
    private static String packageName = "";
    static final Set<String> colorTags = new HashSet();
    static long colorLogTime = 0;
    private static CopyOnWriteArrayList<ColorLevelChangeListener> colorLevelChangeListenerList = new CopyOnWriteArrayList<>();
    private static final CopyOnWriteArrayList<ILogCallback> sLogCallbackList = new CopyOnWriteArrayList<>();
    private static final CopyOnWriteArrayList<IAddLogCallback> sAddLogCallbackList = new CopyOnWriteArrayList<>();
    private static final String[] PERMS = {QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, DeviceInfoUtil.PERMISSION_READ_PHONE};
    private static boolean useNewQLog = false;
    private static boolean useXlog = false;
    private static long mainThreadId = -1;
    private static Xlog xlog = null;
    private static ThreadFactory asyncThreadFactory = null;
    private static ExecutorService asyncSingleThreadExecutor = null;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface ColorLevelChangeListener {
        void colorLevelChange(boolean z16, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface IAddLogCallback {
        String onAddLog(int i3, String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface ILogCallback {
        void onWriteLog(String str, String str2);

        void onWriteLog(String str, byte[] bArr);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface OnPrintlnCallback {
        void onPrintln(int i3, String str, String str2);

        void onPrintln(int i3, String str, String str2, Throwable th5);
    }

    private static void addLogItem(byte b16, String str, int i3, String str2, Throwable th5) {
        long currentTimeMillis = System.currentTimeMillis();
        clearColorTags(currentTimeMillis);
        if (!isPublish || b16 >= forceCallbackAndroidLogLevel) {
            Iterator<IAddLogCallback> it = sAddLogCallbackList.iterator();
            while (it.hasNext()) {
                str2 = it.next().onAddLog(b16, str, str2);
            }
        }
        String str3 = str2;
        if (useXlog) {
            printByXlog(b16, str, str3, th5);
            return;
        }
        QLogItemManager qLogItemManager = sLogManager;
        if (qLogItemManager != null) {
            qLogItemManager.addLog(b16, currentTimeMillis, i3, str, str3, th5);
        }
    }

    public static int androidExtractLog(Date date, Date date2, String str, String str2) {
        Xlog xlog2 = xlog;
        if (xlog2 != null) {
            return xlog2.androidExtractLog(0L, date, date2, str, str2);
        }
        return -1;
    }

    public static String byteLevel2StringLevel(Byte b16) {
        byte byteValue = b16.byteValue();
        if (byteValue != 2) {
            if (byteValue != 3) {
                if (byteValue != 4) {
                    return "D";
                }
                return "E";
            }
            return "W";
        }
        return "I";
    }

    private static void clearColorTags(long j3) {
        long j16 = colorLogTime;
        if (j16 != 0 && j3 - j16 > 1800000) {
            colorLogTime = 0L;
            colorTags.clear();
        }
    }

    private static String concatLogMessages(Object[] objArr, int i3) {
        if (objArr != null && objArr.length != 0) {
            if (i3 <= 0) {
                i3 = 1024;
            }
            StringBuilder sb5 = new StringBuilder(Math.min(objArr.length * 30, i3));
            int length = objArr.length;
            int i16 = 0;
            while (true) {
                if (i16 >= length) {
                    break;
                }
                Object obj = objArr[i16];
                if (obj != null) {
                    String obj2 = obj.toString();
                    int length2 = obj2.length();
                    if (length2 > i3) {
                        sb5.append((CharSequence) obj2, 0, i3);
                        break;
                    }
                    sb5.append(obj2);
                    i3 -= length2;
                    if (i3 <= 0) {
                        break;
                    }
                }
                i16++;
            }
            return sb5.toString();
        }
        return "";
    }

    public static void d(String str, int i3, String str2) {
        d(str, i3, str2, (Throwable) null);
    }

    public static void dAsync(final String str, final int i3, final String str2) {
        ExecutorService executorService = asyncSingleThreadExecutor;
        if (executorService != null) {
            executorService.submit(new Runnable() { // from class: com.tencent.qphone.base.util.i
                @Override // java.lang.Runnable
                public final void run() {
                    QLog.d(str, i3, str2, (Throwable) null);
                }
            });
        }
    }

    public static void deleteExpireLogFileActively() {
        QLogItemManager qLogItemManager = sLogManager;
        if (qLogItemManager != null) {
            qLogItemManager.deleteExpireLogFile();
        }
    }

    public static void e(String str, int i3, String str2) {
        e(str, i3, str2, (Throwable) null);
    }

    public static void eAsync(final String str, final int i3, final String str2) {
        ExecutorService executorService = asyncSingleThreadExecutor;
        if (executorService != null) {
            executorService.submit(new Runnable() { // from class: com.tencent.qphone.base.util.j
                @Override // java.lang.Runnable
                public final void run() {
                    QLog.e(str, i3, str2, (Throwable) null);
                }
            });
        }
    }

    public static void flushLog() {
        QLogItemManager qLogItemManager = sLogManager;
        if (qLogItemManager != null) {
            qLogItemManager.flushLog();
        }
    }

    public static String getDeleteExpireLogRecordFilePath() {
        QLogItemManager qLogItemManager = sLogManager;
        if (qLogItemManager != null) {
            return qLogItemManager.getDeleteExpireLogRecordFilePath();
        }
        return "";
    }

    public static String getLogExternalPath(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return externalFilesDir.getPath();
        }
        return Environment.getExternalStorageDirectory().getPath();
    }

    @SuppressLint({"SimpleDateFormat"})
    public static SimpleDateFormat getLogFileFormatter() {
        QLogItemManager qLogItemManager = sLogManager;
        if (qLogItemManager != null) {
            return qLogItemManager.getLogFileFormatter();
        }
        return new SimpleDateFormat("yy.MM.dd.HH");
    }

    public static String getLogPath() {
        QLogItemManager qLogItemManager = sLogManager;
        if (qLogItemManager != null) {
            String logPath = qLogItemManager.getLogPath();
            if (!TextUtils.isEmpty(logPath)) {
                return logPath;
            }
        }
        return getLogExternalPath(sAppContext) + LogWriterManager.QLOG_PARENT_DIRECTORY + packageName.replace(".", "/") + "/";
    }

    public static String getManualLogLevelPath() {
        return manualLogLevelPath;
    }

    public static List<File> getOutOfCurHourLogs() {
        try {
            return QLogHelper.getOutOfCurHourLogs();
        } catch (Exception e16) {
            e("QLog.getOutOfCurHourLogs", 1, "getOutOfCurHourLogs error", e16);
            return new ArrayList();
        }
    }

    public static String getPackageName() {
        return packageName;
    }

    public static String getProcessName() {
        return processName;
    }

    public static String getReportLevel(int i3) {
        if (i3 == 2) {
            return "W";
        }
        if (i3 == 4) {
            return "D";
        }
        return "E";
    }

    public static String getStackTraceString(Throwable th5) {
        return Log.getStackTraceString(th5);
    }

    private static String getTag(String str) {
        if (sLogcatHooked) {
            return LOG_HOOK_PREFIX_TAG + str;
        }
        return str;
    }

    public static int getUIN_REPORTLOG_LEVEL() {
        return UIN_REPORTLOG_LEVEL;
    }

    private static void handleAndroidRoomLogPrint(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (str2.length() <= 1024) {
            printAndroidLog(str, str2, str3);
            return;
        }
        if (isPublish) {
            printAndroidLog(str, str2.substring(0, 1024), str3);
            RuntimeException runtimeException = new RuntimeException("logTagOverLengthException");
            runtimeException.fillInStackTrace();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("androidLogLevel", str);
            hashMap.put("logTag", str2);
            hashMap.put("logMsg", str3);
            hashMap.put("stack", getStackTraceString(runtimeException));
            QLogReportManager.getInstance().sendToBeacon(QLogReportManager.LOG_TAG_OVER_LENGTH_1024, hashMap);
            return;
        }
        throw new IllegalArgumentException("Business log tag, over 1024 !!!");
    }

    public static void i(String str, int i3, String str2) {
        i(str, i3, str2, null);
    }

    public static void iAsync(final String str, final int i3, final String str2) {
        ExecutorService executorService = asyncSingleThreadExecutor;
        if (executorService != null) {
            executorService.submit(new Runnable() { // from class: com.tencent.qphone.base.util.m
                @Override // java.lang.Runnable
                public final void run() {
                    QLog.i(str, i3, str2, null);
                }
            });
        }
    }

    public static void init(String str, String str2, String str3, long j3) {
        init(str, str2, str3, j3, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void initQlog(QLogConfig qLogConfig) {
        boolean z16;
        boolean isDebug2;
        sAppContext = qLogConfig.getAppContext();
        processName = qLogConfig.getProcessName();
        packageName = qLogConfig.getPackageName();
        useNewQLog = qLogConfig.isUseNewQLog();
        useXlog = qLogConfig.isUseXlog();
        if (!TextUtils.isEmpty(qLogConfig.getLogPath())) {
            LogWriterManager.QLOG_PARENT_DIRECTORY = qLogConfig.getLogPath();
        }
        QLogItemManager qLogItemManager = new QLogItemManager(sAppContext, qLogConfig.getPackageName(), qLogConfig.getProcessName(), qLogConfig.getBuildNumber(), qLogConfig.isIs64Bit());
        sLogManager = qLogItemManager;
        qLogItemManager.init(qLogConfig.getDelayInit());
        if (!new File(getLogPath() + MSF_IS_COLOR_LEVEL).exists()) {
            if (!new File(getLogPath() + qLogConfig.getQLogConfigBeanSwitchKey()).exists() && qLogConfig.isGray()) {
                z16 = true;
                setFullEncryptedLogMode(z16);
                isDebug2 = qLogConfig.isDebug();
                isDebug = isDebug2;
                if (!isDebug2) {
                    _DEFAULT_REPORTLOG_LEVEL = 4;
                } else if (!qLogConfig.isPublish()) {
                    _DEFAULT_REPORTLOG_LEVEL = 2;
                } else {
                    _DEFAULT_REPORTLOG_LEVEL = 1;
                }
                int i3 = _DEFAULT_REPORTLOG_LEVEL;
                UIN_REPORTLOG_LEVEL = i3;
                d(tag, 1, "[init] setDebugMode call. ", " UIN_REPORTLOG_LEVEL: ", Integer.valueOf(i3), " _DEFAULT_REPORTLOG_LEVEL: ", Integer.valueOf(_DEFAULT_REPORTLOG_LEVEL), " debug: ", Boolean.valueOf(isDebug));
                isPublish = qLogConfig.isPublish();
                forceCallbackAndroidLogLevel = qLogConfig.getForceCallbackAndroidLogLevel();
                d(tag, 1, "[init] setPublishMode call. isPublish=" + isPublish + ", qLogConfig=" + qLogConfig.toString());
                QLogReportManager.getInstance().setQLogReport(qLogConfig.getQLogReport());
                QLogFirebaseReportManager.getInstance().setFirebaseLogReport(qLogConfig.getFirebaseLogReport());
            }
        }
        z16 = false;
        setFullEncryptedLogMode(z16);
        isDebug2 = qLogConfig.isDebug();
        isDebug = isDebug2;
        if (!isDebug2) {
        }
        int i36 = _DEFAULT_REPORTLOG_LEVEL;
        UIN_REPORTLOG_LEVEL = i36;
        d(tag, 1, "[init] setDebugMode call. ", " UIN_REPORTLOG_LEVEL: ", Integer.valueOf(i36), " _DEFAULT_REPORTLOG_LEVEL: ", Integer.valueOf(_DEFAULT_REPORTLOG_LEVEL), " debug: ", Boolean.valueOf(isDebug));
        isPublish = qLogConfig.isPublish();
        forceCallbackAndroidLogLevel = qLogConfig.getForceCallbackAndroidLogLevel();
        d(tag, 1, "[init] setPublishMode call. isPublish=" + isPublish + ", qLogConfig=" + qLogConfig.toString());
        QLogReportManager.getInstance().setQLogReport(qLogConfig.getQLogReport());
        QLogFirebaseReportManager.getInstance().setFirebaseLogReport(qLogConfig.getFirebaseLogReport());
    }

    private static void initXlog(QLogConfig qLogConfig) {
        initXlogParams(qLogConfig);
        if (useXlog) {
            System.loadLibrary("c++_shared");
            System.loadLibrary("marsxlog");
            Xlog xlog2 = new Xlog();
            xlog = xlog2;
            xlog2.setMaxAliveTime(0L, JoinTimeType.SEVEN_DAY);
            xlog.setConsoleLogOpen(0L, true);
            xlog.appenderOpen(0, 0, "", getLogPath(), "QQXlog_" + processName.replace(":", "_"), 0);
            mainThreadId = Looper.getMainLooper().getThread().getId();
        }
        d(tag, 1, "[init] setDebugMode call. ", " UIN_REPORTLOG_LEVEL: ", Integer.valueOf(UIN_REPORTLOG_LEVEL), " _DEFAULT_REPORTLOG_LEVEL: ", Integer.valueOf(_DEFAULT_REPORTLOG_LEVEL), " debug: ", Boolean.valueOf(isDebug));
        d(tag, 1, "[init] setPublishMode call. isPublish=" + isPublish + ", qLogConfig=" + qLogConfig.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0092, code lost:
    
        if (r5.isGray() != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void initXlogParams(QLogConfig qLogConfig) {
        sAppContext = qLogConfig.getAppContext();
        processName = qLogConfig.getProcessName();
        packageName = qLogConfig.getPackageName();
        useNewQLog = qLogConfig.isUseNewQLog();
        useXlog = qLogConfig.isUseXlog();
        if (!TextUtils.isEmpty(qLogConfig.getLogPath())) {
            LogWriterManager.QLOG_PARENT_DIRECTORY = qLogConfig.getLogPath();
        }
        boolean isDebug2 = qLogConfig.isDebug();
        isDebug = isDebug2;
        if (isDebug2) {
            _DEFAULT_REPORTLOG_LEVEL = 4;
        } else if (!qLogConfig.isPublish()) {
            _DEFAULT_REPORTLOG_LEVEL = 2;
        } else {
            boolean z16 = true;
            if (qLogConfig.isGray()) {
                if (!new File(getLogPath() + MSF_IS_COLOR_LEVEL).exists()) {
                    if (!new File(getLogPath() + qLogConfig.getQLogConfigBeanSwitchKey()).exists()) {
                    }
                }
                z16 = false;
                if (z16) {
                    _DEFAULT_REPORTLOG_LEVEL = 2;
                }
            } else {
                _DEFAULT_REPORTLOG_LEVEL = 1;
            }
        }
        UIN_REPORTLOG_LEVEL = _DEFAULT_REPORTLOG_LEVEL;
        isPublish = qLogConfig.isPublish();
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.tencent.qphone.base.util.QLog.1
            private AtomicInteger threadNumber = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new BaseThread(runnable, "QLog_async_single_thread_pool_" + this.threadNumber.getAndIncrement());
            }
        };
        asyncThreadFactory = threadFactory;
        asyncSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor(threadFactory);
        QLogReportManager.getInstance().setQLogReport(qLogConfig.getQLogReport());
        QLogFirebaseReportManager.getInstance().setFirebaseLogReport(qLogConfig.getFirebaseLogReport());
    }

    public static boolean isColorLevel() {
        if (UIN_REPORTLOG_LEVEL > 1 || isEncrypted()) {
            return true;
        }
        return false;
    }

    public static boolean isDebugVersion() {
        return isDebug;
    }

    public static boolean isDevelopLevel() {
        if (UIN_REPORTLOG_LEVEL >= 4) {
            return true;
        }
        return false;
    }

    private static boolean isEncrypted() {
        QLogItemManager qLogItemManager = sLogManager;
        if (qLogItemManager != null && qLogItemManager.isEncrypted()) {
            return true;
        }
        return false;
    }

    public static boolean isExistSDCard() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isHasStoragePermission(Context context) {
        if (sHasStoragePermission) {
            return true;
        }
        if (context == null || context.checkSelfPermission(PERMS[0]) != 0) {
            return false;
        }
        sHasStoragePermission = true;
        return true;
    }

    private static boolean isThreadLocalRandomOneTenthRate() {
        if (ThreadLocalRandom.current().nextInt(10) == 0) {
            return true;
        }
        return false;
    }

    public static boolean isUseNewQLog() {
        return useNewQLog;
    }

    public static boolean isUseXlog() {
        return useXlog;
    }

    private static void onPrintln(String str, String str2) {
        OnPrintlnCallback onPrintlnCallback = sOnPrintlnCallback;
        if (onPrintlnCallback != null) {
            onPrintlnCallback.onPrintln(3, str, str2);
        }
    }

    public static void p(String str, String str2) {
        Log.d(getTag(str), "[s]" + str2);
    }

    private static void printAndroidLog(String str, String str2, String str3) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case 68:
                if (str.equals("D")) {
                    c16 = 0;
                    break;
                }
                break;
            case 69:
                if (str.equals("E")) {
                    c16 = 1;
                    break;
                }
                break;
            case 73:
                if (str.equals("I")) {
                    c16 = 2;
                    break;
                }
                break;
            case 87:
                if (str.equals("W")) {
                    c16 = 3;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                Log.d(str2, str3);
                return;
            case 1:
                Log.e(str2, str3);
                return;
            case 2:
                Log.i(str2, str3);
                return;
            case 3:
                Log.w(str2, str3);
                return;
            default:
                Log.d(str2, str3);
                return;
        }
    }

    private static void printByXlog(byte b16, String str, String str2, Throwable th5) {
        String str3;
        if (xlog != null) {
            if (str2.length() > 1024 && b16 < 4) {
                str3 = str2.substring(0, 1024) + LOG_TRUNCATED_NOTE;
            } else {
                str3 = str2;
            }
            int myPid = Process.myPid();
            int myTid = Process.myTid();
            long id5 = Thread.currentThread().getId();
            if (b16 != 2) {
                if (b16 != 3) {
                    if (b16 != 4) {
                        long j3 = myTid;
                        xlog.logD(str, myPid, j3, id5, str3);
                        if (th5 != null) {
                            xlog.logD(str, myPid, j3, id5, Log.getStackTraceString(th5));
                        }
                    } else {
                        long j16 = myTid;
                        xlog.logE(str, myPid, j16, id5, str3);
                        if (th5 != null) {
                            xlog.logE(str, myPid, j16, id5, Log.getStackTraceString(th5));
                        }
                    }
                } else {
                    long j17 = myTid;
                    xlog.logW(str, myPid, j17, id5, str3);
                    if (th5 != null) {
                        xlog.logW(str, myPid, j17, id5, Log.getStackTraceString(th5));
                    }
                }
            } else {
                long j18 = myTid;
                xlog.logI(str, myPid, j18, id5, str3);
                if (th5 != null) {
                    xlog.logI(str, myPid, j18, id5, Log.getStackTraceString(th5));
                }
            }
            QLogHelper.reportToGoogleFirebase(0L, b16, str, str3, th5);
        }
    }

    public static void removeAddLogCallback(IAddLogCallback iAddLogCallback) {
        sAddLogCallbackList.remove(iAddLogCallback);
    }

    @Deprecated
    public static void removeLogCallback(ILogCallback iLogCallback) {
        sLogCallbackList.remove(iLogCallback);
    }

    public static void setAddLogCallback(IAddLogCallback iAddLogCallback) {
        CopyOnWriteArrayList<IAddLogCallback> copyOnWriteArrayList = sAddLogCallbackList;
        if (!copyOnWriteArrayList.contains(iAddLogCallback)) {
            copyOnWriteArrayList.add(iAddLogCallback);
        }
    }

    public static void setColorLevelChangeListener(ColorLevelChangeListener colorLevelChangeListener) {
        if (!colorLevelChangeListenerList.contains(colorLevelChangeListener)) {
            colorLevelChangeListenerList.add(colorLevelChangeListener);
        }
    }

    public static void setFullEncryptedLogMode(boolean z16) {
        QLogItemManager qLogItemManager = sLogManager;
        if (qLogItemManager != null) {
            qLogItemManager.setFullEncryptedLogMode(z16);
        }
    }

    @Deprecated
    public static void setLogCallback(ILogCallback iLogCallback) {
        CopyOnWriteArrayList<ILogCallback> copyOnWriteArrayList = sLogCallbackList;
        if (!copyOnWriteArrayList.contains(iLogCallback)) {
            copyOnWriteArrayList.add(iLogCallback);
        }
    }

    public static void setManualLogLevel(int i3) {
        if (i3 >= 1 && i3 <= 4 && UIN_REPORTLOG_LEVEL != i3) {
            UIN_REPORTLOG_LEVEL = i3;
            d(tag, 1, Thread.currentThread().getName() + "[level]  set log level manual, " + UIN_REPORTLOG_LEVEL, new RuntimeException());
        }
    }

    public static void setOnPrintlnCallback(OnPrintlnCallback onPrintlnCallback) {
        sOnPrintlnCallback = onPrintlnCallback;
    }

    private static void setReportLogLevel(int i3) {
        if (i3 >= 1 && i3 <= 4 && UIN_REPORTLOG_LEVEL != i3) {
            UIN_REPORTLOG_LEVEL = i3;
            d(tag, 1, Thread.currentThread().getName() + " set log level " + i3, new RuntimeException());
            try {
                if (!processName.contains(":") && Looper.getMainLooper() != Looper.myLooper()) {
                    File file = new File(getLogPath() + MSF_IS_COLOR_LEVEL);
                    if (i3 >= 2 && !file.exists()) {
                        file.createNewFile();
                        return;
                    } else {
                        if (i3 < 2 && file.exists()) {
                            file.delete();
                            return;
                        }
                        return;
                    }
                }
                return;
            } catch (Throwable th5) {
                d(tag, 1, "create file fail, ", th5);
                return;
            }
        }
        if (isColorLevel()) {
            d(tag, 2, "setReportLogLevel illegal, logLevel=", Integer.valueOf(i3));
        }
    }

    private static boolean setReportLogLevelByFile() {
        BufferedReader bufferedReader;
        Throwable th5;
        if (!isExistSDCard()) {
            return false;
        }
        try {
            String str = manualLogLevelPath;
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                bufferedReader = new BufferedReader(new FileReader(str));
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                        return false;
                    }
                    int parseInt = Integer.parseInt(readLine);
                    if (parseInt >= 1 && parseInt <= 4) {
                        UIN_REPORTLOG_LEVEL = parseInt;
                        d(tag, 1, Thread.currentThread().getName() + "[level] set log level manual, " + parseInt);
                        try {
                            bufferedReader.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                        return true;
                    }
                    if (isColorLevel()) {
                        d(tag, 2, "setReportLogLevel illegal, logLevel=", Integer.valueOf(parseInt));
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                    return false;
                } catch (Throwable th6) {
                    th5 = th6;
                    try {
                        e(tag, 1, "[level] set log, manual log level read fail. ", th5);
                        return false;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th7) {
            bufferedReader = null;
            th5 = th7;
        }
    }

    public static void setUIN_REPORTLOG_LEVEL(int i3) {
        if (setReportLogLevelByFile()) {
            return;
        }
        setReportLogLevel(i3);
        if (colorLevelChangeListenerList.size() > 0) {
            Iterator<ColorLevelChangeListener> it = colorLevelChangeListenerList.iterator();
            while (it.hasNext()) {
                ColorLevelChangeListener next = it.next();
                boolean z16 = true;
                if (i3 <= 1) {
                    z16 = false;
                }
                next.colorLevelChange(z16, i3);
            }
        }
    }

    public static void useNewQLog() {
        useNewQLog = true;
    }

    public static void useOldQLog() {
        useNewQLog = false;
    }

    public static void w(String str, int i3, String str2) {
        w(str, i3, str2, null);
    }

    public static void wAsync(final String str, final int i3, final String str2) {
        ExecutorService executorService = asyncSingleThreadExecutor;
        if (executorService != null) {
            executorService.submit(new Runnable() { // from class: com.tencent.qphone.base.util.o
                @Override // java.lang.Runnable
                public final void run() {
                    QLog.w(str, i3, str2, null);
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class LogFile extends File {
        public String stuffix;

        public LogFile(File file, String str) {
            super(file, str);
            this.stuffix = "";
        }

        public LogFile(String str) {
            super(str);
            this.stuffix = "";
        }
    }

    public static void d(String str, int i3, Throwable th5, Object... objArr) {
        if ((UIN_REPORTLOG_LEVEL >= i3 || colorTags.contains(str)) || isEncrypted()) {
            d(str, i3, concatLogMessages(objArr, 1025), th5);
        }
    }

    public static void e(String str, int i3, Throwable th5, Object... objArr) {
        boolean z16 = UIN_REPORTLOG_LEVEL >= i3 || colorTags.contains(str);
        if (z16 || isEncrypted()) {
            String concatLogMessages = concatLogMessages(objArr, 1025);
            if (!useXlog && z16) {
                handleAndroidRoomLogPrint("E", getTag(str), concatLogMessages + getStackTraceString(th5));
            }
            addLogItem((byte) 4, str, i3, concatLogMessages, th5);
        }
    }

    public static void i(String str, int i3, String str2, Throwable th5) {
        boolean z16 = UIN_REPORTLOG_LEVEL >= i3 || colorTags.contains(str);
        if (z16 || isEncrypted()) {
            if (str2 == null) {
                str2 = "";
            }
            if (!useXlog && z16) {
                handleAndroidRoomLogPrint("I", getTag(str), str2 + getStackTraceString(th5));
            }
            addLogItem((byte) 2, str, i3, str2, th5);
        }
    }

    public static void init(String str, String str2, String str3, long j3, boolean z16) {
        useNewQLog = z16;
        processName = str2;
        packageName = str;
        QLogItemManager qLogItemManager = new QLogItemManager(sAppContext, str, str2, str3, true);
        sLogManager = qLogItemManager;
        qLogItemManager.init(j3);
    }

    public static void w(String str, int i3, String str2, Throwable th5) {
        boolean z16 = UIN_REPORTLOG_LEVEL >= i3 || colorTags.contains(str);
        if (z16 || isEncrypted()) {
            if (str2 == null) {
                str2 = "";
            }
            if (!useXlog && z16) {
                handleAndroidRoomLogPrint("W", getTag(str), str2 + getStackTraceString(th5));
            }
            addLogItem((byte) 3, str, i3, str2, th5);
        }
    }

    public static void dAsync(final String str, final int i3, final String str2, final Throwable th5) {
        ExecutorService executorService = asyncSingleThreadExecutor;
        if (executorService != null) {
            executorService.submit(new Runnable() { // from class: com.tencent.qphone.base.util.n
                @Override // java.lang.Runnable
                public final void run() {
                    QLog.d(str, i3, str2, th5);
                }
            });
        }
    }

    public static void eAsync(final String str, final int i3, final String str2, final Throwable th5) {
        ExecutorService executorService = asyncSingleThreadExecutor;
        if (executorService != null) {
            executorService.submit(new Runnable() { // from class: com.tencent.qphone.base.util.l
                @Override // java.lang.Runnable
                public final void run() {
                    QLog.e(str, i3, str2, th5);
                }
            });
        }
    }

    public static void flushLog(boolean z16) {
        QLogItemManager qLogItemManager = sLogManager;
        if (qLogItemManager != null) {
            qLogItemManager.flushLog(z16);
        }
    }

    public static void iAsync(final String str, final int i3, final String str2, final Throwable th5) {
        ExecutorService executorService = asyncSingleThreadExecutor;
        if (executorService != null) {
            executorService.submit(new Runnable() { // from class: com.tencent.qphone.base.util.k
                @Override // java.lang.Runnable
                public final void run() {
                    QLog.i(str, i3, str2, th5);
                }
            });
        }
    }

    private static void onPrintln(String str, String str2, Throwable th5) {
        OnPrintlnCallback onPrintlnCallback = sOnPrintlnCallback;
        if (onPrintlnCallback != null) {
            onPrintlnCallback.onPrintln(3, str, str2, th5);
        }
    }

    public static void wAsync(final String str, final int i3, final String str2, final Throwable th5) {
        ExecutorService executorService = asyncSingleThreadExecutor;
        if (executorService != null) {
            executorService.submit(new Runnable() { // from class: com.tencent.qphone.base.util.p
                @Override // java.lang.Runnable
                public final void run() {
                    QLog.w(str, i3, str2, th5);
                }
            });
        }
    }

    public static void d(String str, int i3, Object... objArr) {
        d(str, i3, (Throwable) null, objArr);
    }

    public static void d(String str, int i3, String str2, Throwable th5) {
        boolean z16 = UIN_REPORTLOG_LEVEL >= i3 || colorTags.contains(str);
        if (z16 || isEncrypted()) {
            if (str2 == null) {
                str2 = "";
            }
            if (!useXlog && z16) {
                String tag2 = getTag(str);
                handleAndroidRoomLogPrint("D", tag2, str2 + getStackTraceString(th5));
                if (th5 == null) {
                    onPrintln(tag2, str2);
                } else {
                    onPrintln(tag2, str2, th5);
                }
            }
            addLogItem((byte) 1, str, i3, str2, th5);
        }
    }

    public static void init(QLogConfig qLogConfig) {
        if (qLogConfig.isUseXlog()) {
            initXlog(qLogConfig);
        } else {
            initQlog(qLogConfig);
        }
    }

    public static void e(String str, int i3, Object... objArr) {
        e(str, i3, (Throwable) null, objArr);
    }

    public static void e(String str, int i3, String str2, Throwable th5) {
        boolean z16 = UIN_REPORTLOG_LEVEL >= i3 || colorTags.contains(str);
        if (z16 || isEncrypted()) {
            if (str2 == null) {
                str2 = "";
            }
            if (!useXlog && z16) {
                handleAndroidRoomLogPrint("E", getTag(str), str2 + getStackTraceString(th5));
            }
            addLogItem((byte) 4, str, i3, str2, th5);
        }
    }

    public static void d(String str, int i3, byte[] bArr, Throwable th5) {
        d(str, i3, new String(bArr, logCharset), th5);
    }
}
