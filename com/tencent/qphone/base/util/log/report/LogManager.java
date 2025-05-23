package com.tencent.qphone.base.util.log.report;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mm.vfs.QuotaFileSystem;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c0.e;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.core.x.b;
import com.tencent.mobileqq.msf.core.y.a;
import com.tencent.mobileqq.msf.core.y.d;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import wns_proxy.HttpRsp;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LogManager {
    private static final String ANR_LOG_PATH = "/data/anr/traces.txt";
    public static final int BUFLAG_B1 = 16;
    public static final String CORRUPT_DATABASE_PATH = "/tencent/msflogs/corruptInfo";
    static String LOG_MANAGER_SP = "log_manager_sp";
    private static final int MSG_COMPRESS_LOG = 10000;
    public static final String PRIVATE_LOG_PREFIX = "private-";
    public static int REPORTLOGMAXPACKAGECOUNT = 10;
    public static long REPORT_LOG_ONCE_MAX_SIZE = 20971520;
    public static int REPORT_LOG_WIFI_MAX_PACKAGE_COUNT = 25;
    public static boolean isScreenOn = true;
    static boolean netFlowhasGet = false;
    static long preNetflowTime = 0;
    private static long sLastCheckLogTime = 0;
    static int screenOffCount = 0;
    static String tag = "MSF.C.LogManager";

    @SuppressLint({"SimpleDateFormat"})
    private static final SimpleDateFormat qqxlogTimeFormatter = new SimpleDateFormat("yy_MM_dd_HH_mm_ss");
    private static Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.qphone.base.util.log.report.LogManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 10000) {
                if (LogManager.sLastCheckLogTime <= 0 || SystemClock.elapsedRealtime() - LogManager.sLastCheckLogTime >= b.P()) {
                    long unused = LogManager.sLastCheckLogTime = SystemClock.elapsedRealtime();
                    QLog.d(LogManager.tag, 1, "clean and compress log");
                    LogManager.compressLog();
                }
            }
        }
    };
    private static final d screenEvent = new d() { // from class: com.tencent.qphone.base.util.log.report.LogManager.2
        @Override // com.tencent.mobileqq.msf.core.y.d
        public void onScreenOff() {
            LogManager.isScreenOn = false;
            t.f250071c0 = -1;
            t.f250072d0.set(false);
            if (b.g0()) {
                LogManager.mHandler.removeMessages(10000);
                LogManager.mHandler.sendEmptyMessageDelayed(10000, b.y());
                return;
            }
            int i3 = LogManager.screenOffCount + 1;
            LogManager.screenOffCount = i3;
            if (i3 == BaseConstants.checkExpiresLogScreenOffCount) {
                LogManager.delExpiresLog();
            }
        }

        @Override // com.tencent.mobileqq.msf.core.y.d
        public void onScreenOn() {
            LogManager.isScreenOn = true;
            LogManager.mHandler.removeMessages(10000);
        }
    };
    static boolean isInited = false;
    static String targetURL = "https://qqlog.qq.com/log/passive/upload.jsp";
    static String targetURLSelf = "https://qqlog.qq.com/log/active/creport.jsp";
    static String targetURLReportInfo = "https://qqlog.qq.com/log/passive/report.jsp";
    private static final String WTLOGIN_LOG_PATH = "/tencent/wtlogin/" + BaseApplication.getContext().getPackageName() + "/";
    public static int OP_SET_LOGLEVEL_PERMANENT = 1;
    public static int OP_SET_LOGLEVEL_TEMPORARY = 2;
    public static int OP_DEL_LOGLEVEL = 3;

    static /* synthetic */ String access$400() {
        return getNowLogTimeSufix();
    }

    public static void addDataCorruptInfo(ArrayList<QLog.LogFile> arrayList) {
        if (isNet4GOrWifi() && b.g1()) {
            String str = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/corruptInfo";
            File file = new File(str);
            if (file.exists() && file.length() < VasBusiness.CHAT_FONT_SWITCH) {
                arrayList.add(new QLog.LogFile(str));
            }
        }
    }

    public static void addWtloginLog(ArrayList<QLog.LogFile> arrayList, int i3, int i16, int i17, int i18, int i19, int i26) {
        File[] listFiles;
        Calendar calendar = Calendar.getInstance();
        calendar.set(i3, i16 - 1, i17, 0, 0, 0);
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(i18, i19 - 1, i26, 23, 59, 59);
        long timeInMillis2 = calendar2.getTimeInMillis();
        long currentTimeMillis = System.currentTimeMillis();
        if (timeInMillis2 >= currentTimeMillis) {
            calendar2.setTimeInMillis(currentTimeMillis);
            timeInMillis2 = currentTimeMillis;
        }
        File file = new File(BaseApplication.getContext().getExternalCacheDir().getAbsolutePath() + WTLOGIN_LOG_PATH);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                long lastModified = file2.lastModified();
                if (lastModified >= timeInMillis && lastModified <= timeInMillis2) {
                    arrayList.add(new QLog.LogFile(file2.getPath()));
                }
            }
        }
    }

    public static void checkAndReportLogInfo() {
        File[] listFiles;
        long j3;
        try {
            int i3 = 0;
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(LOG_MANAGER_SP, 0);
            long j16 = 0;
            long j17 = sharedPreferences.getLong("lastReportTime", 0L);
            boolean z16 = sharedPreferences.getBoolean("opened", false);
            long currentTimeMillis = System.currentTimeMillis();
            if (j17 == 0 || currentTimeMillis - j17 > 86400000) {
                sharedPreferences.edit().putLong("lastReportTime", currentTimeMillis).commit();
                File file = new File(QLog.getLogPath());
                if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                    int length = listFiles.length;
                    int i16 = 0;
                    long j18 = 0;
                    long j19 = 0;
                    String str = "";
                    String str2 = str;
                    String str3 = str2;
                    while (i3 < length) {
                        File file2 = listFiles[i3];
                        File[] fileArr = listFiles;
                        String name = file2.getName();
                        int i17 = length;
                        boolean z17 = z16;
                        if (name.endsWith(".log") || name.endsWith(".qlog") || name.endsWith(".log.zip")) {
                            int i18 = i16 + 1;
                            long length2 = file2.length();
                            j19 += file2.length();
                            if (j16 < length2) {
                                str3 = file2.getName();
                                j16 = length2;
                            }
                            if (name.startsWith(QLog.getPackageName())) {
                                try {
                                    int length3 = name.length();
                                    if (name.endsWith(".log")) {
                                        length3 = name.indexOf(".log");
                                    } else if (name.endsWith(".qlog")) {
                                        length3 = name.indexOf(".qlog");
                                    } else if (name.endsWith(".log.zip")) {
                                        length3 = name.indexOf(".log.zip");
                                    }
                                    String substring = name.substring(name.indexOf(".", name.indexOf(MimeHelper.MIME_TYPE_MOBILEQQ)) + 1, length3);
                                    if (str2.equals("") || substring.compareTo(str2) < 0) {
                                        str2 = substring;
                                    }
                                    if (str.equals("") || substring.compareTo(str) > 0) {
                                        str = substring;
                                    }
                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy.MM.dd.HH");
                                    j3 = ((simpleDateFormat.parse(str).getTime() - simpleDateFormat.parse(str2).getTime()) / 3600000) + 1;
                                } catch (ParseException e16) {
                                    e16.printStackTrace();
                                    j3 = -1;
                                }
                                j18 = j3;
                            }
                            i16 = i18;
                        }
                        i3++;
                        listFiles = fileArr;
                        length = i17;
                        z16 = z17;
                    }
                    boolean z18 = z16;
                    HashMap hashMap = new HashMap();
                    hashMap.put(QuotaFileSystem.STAT_FILE_COUNT, "" + i16);
                    hashMap.put("sizeTotal", "" + j19);
                    hashMap.put("sizeMax", "" + j16);
                    hashMap.put("maxSizeName", "" + str3);
                    hashMap.put("startLogTime", "" + str2);
                    hashMap.put("endLogTime", "" + str);
                    hashMap.put("logHours", "" + j18);
                    hashMap.put("sdcardsize", "" + getSdCardSize());
                    hashMap.put("freesize", "" + getSdCardFreeSize());
                    hashMap.put("compressed", "" + b.g0());
                    hashMap.put("logLevel", "" + QLog.getUIN_REPORTLOG_LEVEL());
                    hashMap.put("account", "" + MsfService.getCore().getAccountCenter().e());
                    hashMap.put("logTestOpened", "" + z18);
                    if (MsfService.getCore().getStatReporter() != null) {
                        MsfService.getCore().getStatReporter().a("msflogInfo2", z18, j18, j19, (Map<String, String>) hashMap, false, false);
                        return;
                    }
                    return;
                }
                if (MsfService.getCore().getStatReporter() != null) {
                    MsfService.getCore().getStatReporter().a("msflogInfoEmpty", !QLog.isColorLevel(), 0L, 0L, (Map<String, String>) null, false, false);
                }
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    public static void checkManualLogLevel(int i3, int i16) {
        QLog.d(tag, 1, "checkManualLogLevel, opType: ", Integer.valueOf(i3), " logLevel: ", Integer.valueOf(i16));
        if (i3 == OP_SET_LOGLEVEL_PERMANENT) {
            setManualLogLevel(i16);
            return;
        }
        if (i3 == OP_DEL_LOGLEVEL) {
            QLog.setUIN_REPORTLOG_LEVEL(i16);
            MsfStore.getNativeConfigStore().setConfig(QLog.logLevelHead, String.valueOf(i16));
            MsfStore.getNativeConfigStore().setConfig(QLog.logLevelTime, String.valueOf(System.currentTimeMillis()));
            MsfCore.initAppProMsg("*", BaseApplication.getContext().getAppId());
            return;
        }
        if (i3 == OP_SET_LOGLEVEL_TEMPORARY) {
            File file = new File(QLog.getManualLogLevelPath());
            if (file.exists()) {
                file.delete();
            }
            QLog.setUIN_REPORTLOG_LEVEL(i16);
            MsfStore.getNativeConfigStore().setConfig(QLog.logLevelHead, String.valueOf(i16));
            MsfStore.getNativeConfigStore().setConfig(QLog.logLevelTime, String.valueOf(System.currentTimeMillis()));
            MsfCore.initAppProMsg("*", BaseApplication.getContext().getAppId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void compressLog() {
        BaseThread baseThread = new BaseThread() { // from class: com.tencent.qphone.base.util.log.report.LogManager.3
            /* JADX WARN: Removed duplicated region for block: B:24:0x0074  */
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                int i3;
                String R;
                if (TextUtils.isEmpty(QLog.getLogPath())) {
                    QLog.e(LogManager.tag, 1, "compressLog, QLog.getLogPath() is null !!!", new Exception());
                    return;
                }
                File file = new File(QLog.getLogPath());
                if (file.exists()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.tencent.qphone.base.util.log.report.LogManager.3.1
                            @Override // java.util.Comparator
                            public int compare(File file2, File file3) {
                                return file2.lastModified() > file3.lastModified() ? 1 : 0;
                            }
                        });
                        Calendar calendar = Calendar.getInstance();
                        int i16 = 3;
                        try {
                            R = b.R();
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                        if (R != null && R.length() > 0) {
                            i3 = Integer.parseInt(R);
                            if (i3 >= 1 && i3 <= 14) {
                                i16 = i3;
                            }
                            calendar.add(6, i16 - (i16 * 2));
                            long timeInMillis = calendar.getTimeInMillis();
                            String access$400 = LogManager.access$400();
                            for (File file2 : listFiles) {
                                if (timeInMillis <= file2.lastModified() && file2.lastModified() <= System.currentTimeMillis() + 3600000) {
                                    if (!TextUtils.isEmpty(file2.getName()) && file2.getName().endsWith(".log") && (file2.lastModified() < System.currentTimeMillis() - 3600000 || file2.getName().contains(access$400))) {
                                        if (LogManager.zipLogFile(file2)) {
                                            file2.delete();
                                            QLog.d(LogManager.tag, 1, "compress log " + file2.getName());
                                        } else {
                                            QLog.d(LogManager.tag, 1, "compress log fail " + file2.getName());
                                        }
                                    }
                                } else {
                                    file2.delete();
                                    if (QLog.isColorLevel()) {
                                        QLog.d(LogManager.tag, 2, "del expires log " + file2.getName());
                                    }
                                }
                            }
                        }
                        i3 = 3;
                        if (i3 >= 1) {
                            i16 = i3;
                        }
                        calendar.add(6, i16 - (i16 * 2));
                        long timeInMillis2 = calendar.getTimeInMillis();
                        String access$4002 = LogManager.access$400();
                        while (r10 < r9) {
                        }
                    } else {
                        return;
                    }
                }
                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(6, calendar2.get(6) - 7);
                calendar2.set(11, 0);
                calendar2.set(12, 0);
                calendar2.set(13, 0);
                calendar2.set(14, 0);
                e.a(calendar2.getTimeInMillis());
            }
        };
        baseThread.setName("delLogThread");
        baseThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void delExpiresLog() {
        BaseThread baseThread = new BaseThread() { // from class: com.tencent.qphone.base.util.log.report.LogManager.4
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(QLog.getLogPath())) {
                    QLog.e(LogManager.tag, 1, "delExpiresLog, QLog.getLogPath() is null !!!", new Exception());
                    return;
                }
                File file = new File(QLog.getLogPath());
                try {
                    LogManager.delPrivateExpiresLogIfNeed();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    QLog.e(LogManager.tag, 1, "run: failed. ", th5);
                }
                try {
                    if (LogManager.delExpiresLogInFolder(file)) {
                        return;
                    }
                } catch (Throwable th6) {
                    th6.printStackTrace();
                    QLog.e(LogManager.tag, 1, "run: failed. ", th6);
                }
                Calendar calendar = Calendar.getInstance();
                calendar.set(6, calendar.get(6) - 7);
                calendar.set(11, 0);
                calendar.set(12, 0);
                calendar.set(13, 0);
                calendar.set(14, 0);
                e.a(calendar.getTimeInMillis());
            }
        };
        baseThread.setName("delLogThread");
        baseThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean delExpiresLogInFolder(File file) {
        int i3;
        String R;
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return true;
            }
            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.tencent.qphone.base.util.log.report.LogManager.5
                @Override // java.util.Comparator
                public int compare(File file2, File file3) {
                    return file2.lastModified() > file3.lastModified() ? 1 : 0;
                }
            });
            Calendar calendar = Calendar.getInstance();
            int i16 = 3;
            try {
                R = b.R();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (R != null && R.length() > 0) {
                i3 = Integer.parseInt(R);
                if (i3 >= 1 && i3 <= 14) {
                    i16 = i3;
                }
                calendar.add(6, i16 - (i16 * 2));
                long timeInMillis = calendar.getTimeInMillis();
                for (File file2 : listFiles) {
                    if (QLog.isColorLevel()) {
                        QLog.d(tag, 2, "found log file " + file2.getName());
                    }
                    if (timeInMillis > file2.lastModified()) {
                        file2.delete();
                        if (QLog.isColorLevel()) {
                            QLog.d(tag, 2, "del expires log " + file2.getName());
                        }
                    }
                }
            }
            i3 = 3;
            if (i3 >= 1) {
                i16 = i3;
            }
            calendar.add(6, i16 - (i16 * 2));
            long timeInMillis2 = calendar.getTimeInMillis();
            while (r4 < r0) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void delPrivateExpiresLogIfNeed() {
        if (QLog.isHasStoragePermission(BaseApplication.context)) {
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "delPrivateExpiresLogIfNeed: invoked. ");
            }
            delExpiresLogInFolder(new File(BaseApplication.context.getExternalFilesDir(null) + "/tencent/msflogs/com/tencent/mobileqq/"));
        }
    }

    private static void doReportErrorMsg(int i3, String str, String str2, int i16, int i17, DataOutputStream dataOutputStream, String str3) throws IOException {
        StringBuilder sb5 = new StringBuilder();
        setUrlConnBaseInfo(sb5, str, i3, i16, i17, str3);
        sb5.append("--");
        sb5.append(str);
        sb5.append("\r\n");
        sb5.append("Content-Disposition: form-data; name=errormsg\r\n\r\n");
        sb5.append(str2);
        sb5.append("\r\n");
        sb5.append("--");
        sb5.append(str);
        sb5.append("\r\n");
        sb5.append("Content-Disposition: form-data; name=fileKey\r\n\r\n");
        sb5.append("");
        sb5.append("\r\n");
        sb5.append("--" + str + "--\r\n");
        dataOutputStream.write(sb5.toString().getBytes("UTF-8"));
        dataOutputStream.flush();
        dataOutputStream.close();
    }

    public static void doReportLogSelf(int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, HashMap<String, String> hashMap) {
        long length;
        int i16;
        HashMap<String, String> hashMap2;
        long j3;
        if (str != null && str.length() != 0) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    if (REPORT_LOG_ONCE_MAX_SIZE < 1024) {
                        REPORT_LOG_ONCE_MAX_SIZE = 1024L;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(tag, 2, "want send size " + file.length());
                    }
                    if (file.length() % REPORT_LOG_ONCE_MAX_SIZE > 0) {
                        length = (file.length() / REPORT_LOG_ONCE_MAX_SIZE) + 1;
                    } else {
                        length = file.length() / REPORT_LOG_ONCE_MAX_SIZE;
                    }
                    int i17 = (int) length;
                    if (NetConnInfoCenter.isWifiConn()) {
                        i16 = REPORT_LOG_WIFI_MAX_PACKAGE_COUNT;
                    } else {
                        i16 = REPORTLOGMAXPACKAGECOUNT;
                    }
                    if (i17 > i16) {
                        reportErrorMsg(i3, getRandomBoundary(), "report size is too big " + file.length(), MsfSdkUtils.insertMtype("reportLog", targetURLSelf), 1, i17, null, str4, str5, str6, str7);
                        return;
                    }
                    if (hashMap == null) {
                        hashMap2 = new HashMap<>();
                    } else {
                        hashMap2 = hashMap;
                    }
                    hashMap2.put(com.tencent.mobileqq.msf.core.auth.e.f247444d, str2);
                    hashMap2.put("opinfo", str3);
                    int i18 = 1;
                    long j16 = 0;
                    while (j16 < file.length()) {
                        long length2 = file.length() - j16;
                        long j17 = REPORT_LOG_ONCE_MAX_SIZE;
                        if (length2 > j17) {
                            j3 = j17;
                        } else {
                            j3 = length2;
                        }
                        HashMap<String, String> hashMap3 = hashMap2;
                        uploadFile(i3, getRandomBoundary(), file, targetURLSelf, i18, i17, j16, j3, 0L, str4, str5, str6, str7, hashMap3);
                        j16 += j3;
                        i18++;
                        hashMap2 = hashMap3;
                    }
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(tag, 2, "report log error " + e16, e16);
                        return;
                    }
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "logName is not existed.");
            }
        }
    }

    private static String getNowLogTimeSufix() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis() - 3600000);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    private static String getRandomBoundary() {
        Random random = new Random(System.currentTimeMillis());
        String str = "---------";
        for (int i3 = 0; i3 < 12; i3++) {
            str = str + String.valueOf(random.nextInt(10));
        }
        return str;
    }

    private static long getSdCardFreeSize() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return 0L;
        }
    }

    private static long getSdCardSize() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return 0L;
        }
    }

    public static Pair<Long, Long> getTimePeriod(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i3, i16 - 1, i17, i18, i19, 0);
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(i26, i27 - 1, i28, i29, i36, 0);
        long timeInMillis2 = calendar2.getTimeInMillis();
        long currentTimeMillis = System.currentTimeMillis();
        if (timeInMillis2 >= currentTimeMillis) {
            calendar2.setTimeInMillis(currentTimeMillis);
            timeInMillis2 = currentTimeMillis;
        }
        return new Pair<>(Long.valueOf(timeInMillis), Long.valueOf(timeInMillis2));
    }

    private static String getZipLogFilePath(File file) {
        String str = QLog.getLogPath() + file.getName();
        if (str.endsWith(".log")) {
            str = str.substring(0, str.indexOf(".log"));
        }
        return str + ".qlog";
    }

    public static synchronized void init() {
        synchronized (LogManager.class) {
            if (!isInited) {
                a.h().a(screenEvent);
                if (QLog.isColorLevel()) {
                    QLog.d(tag, 2, "LogManager inited.");
                }
                isInited = true;
            }
        }
    }

    public static boolean initLogLevel(Context context, boolean z16) {
        try {
            if (MsfStore.getNativeConfigStore() == null) {
                try {
                    if (!new MsfStore().init(context)) {
                        QLog.e(tag, 1, "initLogLevel, MsfStore init fail");
                        return false;
                    }
                } catch (Exception e16) {
                    QLog.e(tag, 1, "initLogLevel, MsfStore init error " + e16);
                    return false;
                }
            }
            String config = MsfStore.getNativeConfigStore().getConfig(QLog.logLevelHead);
            if (config != null && config.length() > 0) {
                String config2 = MsfStore.getNativeConfigStore().getConfig(QLog.logLevelTime);
                if (config2 != null && config2.length() > 0) {
                    if (System.currentTimeMillis() - Long.parseLong(config2) > 259200000 && z16) {
                        BaseThread baseThread = new BaseThread() { // from class: com.tencent.qphone.base.util.log.report.LogManager.6
                            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                            public void run() {
                                try {
                                    LockMethodProxy.sleep(180000L);
                                } catch (InterruptedException e17) {
                                    e17.printStackTrace();
                                }
                                MsfStore.getNativeConfigStore().removeConfig(QLog.logLevelHead);
                                MsfStore.getNativeConfigStore().removeConfig(QLog.logLevelTime);
                                QLog.d(LogManager.tag, 1, "LogLevel and time has removed");
                            }
                        };
                        baseThread.setName("resetLogLevelThread");
                        baseThread.start();
                    } else {
                        QLog.setUIN_REPORTLOG_LEVEL(Integer.parseInt(config));
                    }
                } else {
                    if (z16) {
                        MsfStore.getNativeConfigStore().setConfig(QLog.logLevelTime, String.valueOf(System.currentTimeMillis()));
                    }
                    QLog.setUIN_REPORTLOG_LEVEL(Integer.parseInt(config));
                }
            }
            QLog.d(tag, 1, "initLogLevel succ ,value =", config);
            return true;
        } catch (Exception e17) {
            QLog.d(tag, 1, "initLogLevel error " + e17);
            return false;
        }
    }

    public static boolean isNet4GOrWifi() {
        if (NetConnInfoCenter.isWifiConn() || NetConnInfoCenter.isMobileConn()) {
            return true;
        }
        return false;
    }

    @Deprecated
    private static boolean isTestNewStrategy() {
        try {
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (b.i0()) {
            return false;
        }
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(LOG_MANAGER_SP, 0);
        if (sharedPreferences.getBoolean("opened", false)) {
            return true;
        }
        long parseLong = Long.parseLong(MsfService.getCore().getAccountCenter().e());
        if (b.h0() && parseLong % 2 == 0) {
            sharedPreferences.edit().putBoolean("opened", true).commit();
            return true;
        }
        return false;
    }

    private static void readServerResp(HttpURLConnection httpURLConnection) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        QLog.d(tag, 1, "readServerResp " + responseCode);
        if (responseCode == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    if (QLog.isColorLevel()) {
                        QLog.d(tag, 2, "read " + new String(bArr, 0, read));
                    }
                } else {
                    return;
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private static void reportErrorMsg(int i3, String str, String str2, String str3, int i16, int i17, ReportLogInfoContext reportLogInfoContext, String str4, String str5, String str6, String str7) throws Exception {
        HttpURLConnection httpURLConnection;
        long j3;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(HttpHeader.RSP.CHARSET, "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + str);
            if (reportLogInfoContext != null) {
                j3 = reportLogInfoContext.reqSeq;
            } else {
                j3 = 0;
            }
            setUrlConnCookie(httpURLConnection, j3, str4, str5, str6, str7);
            doReportErrorMsg(i3, str, str2, i16, i17, new DataOutputStream(httpURLConnection.getOutputStream()), str4);
            readServerResp(httpURLConnection);
            httpURLConnection.disconnect();
            TrafficStats.clearThreadStatsTag();
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            TrafficStats.clearThreadStatsTag();
            throw th;
        }
    }

    public static void reportLog(int i3, File file, ReportLogInfoContext reportLogInfoContext) throws Exception {
        long j3;
        int i16;
        if (REPORT_LOG_ONCE_MAX_SIZE < 1024) {
            REPORT_LOG_ONCE_MAX_SIZE = 1024L;
        }
        int i17 = 1;
        long length = file.length();
        reportLogInfoContext.isReport = true;
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "want send size ", Long.valueOf(length));
        }
        long j16 = REPORT_LOG_ONCE_MAX_SIZE;
        long j17 = 0;
        if (length % j16 > 0) {
            j3 = (length / j16) + 1;
        } else {
            j3 = length / j16;
        }
        int i18 = (int) j3;
        if (NetConnInfoCenter.isWifiConn()) {
            i16 = REPORT_LOG_WIFI_MAX_PACKAGE_COUNT;
        } else {
            i16 = REPORTLOGMAXPACKAGECOUNT;
        }
        if (i18 > i16) {
            reportErrorMsg(i3, getRandomBoundary(), "report size is too big " + length, MsfSdkUtils.insertMtype("reportLog", targetURL), 1, i18, reportLogInfoContext, null, null, null, null);
            reportLogInfoContext.onStateChange(41);
            return;
        }
        while (j17 < length) {
            long j18 = length - j17;
            long j19 = REPORT_LOG_ONCE_MAX_SIZE;
            if (j18 > j19) {
                j18 = j19;
            }
            uploadFile(i3, getRandomBoundary(), file, MsfSdkUtils.insertMtype("reportLog", targetURL), i17, i18, j17, j18, reportLogInfoContext.reqSeq, null, null, null, null, null);
            j17 += j18;
            i17++;
        }
        LogPushManager.storePushSeqInfo(reportLogInfoContext, reportLogInfoContext.reqSeq);
        reportLogInfoContext.onStateChange(40);
    }

    public static void reportLogInfo(ReportLogInfoContext reportLogInfoContext) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        DataOutputStream dataOutputStream;
        StringBuilder sb5;
        String logStatStr = LogEventReporter.getLogStatStr(reportLogInfoContext.stat);
        QLog.d(LogEventReporter.TAG, 1, reportLogInfoContext.toString());
        int appId = BaseApplication.getContext().getAppId();
        String randomBoundary = getRandomBoundary();
        HttpURLConnection httpURLConnection3 = null;
        try {
            try {
                HttpURLConnection httpURLConnection4 = (HttpURLConnection) new URL(targetURLReportInfo).openConnection();
                try {
                    httpURLConnection4.setDoInput(true);
                    httpURLConnection4.setDoOutput(true);
                    httpURLConnection4.setUseCaches(false);
                    httpURLConnection4.setRequestMethod("POST");
                    httpURLConnection4.setRequestProperty(HttpHeader.RSP.CHARSET, "UTF-8");
                    httpURLConnection4.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + randomBoundary);
                    setUrlConnCookie(httpURLConnection4, reportLogInfoContext.reqSeq, null, null, null, null);
                    dataOutputStream = new DataOutputStream(httpURLConnection4.getOutputStream());
                    sb5 = new StringBuilder();
                    httpURLConnection2 = httpURLConnection4;
                } catch (Exception e16) {
                    e = e16;
                    httpURLConnection2 = httpURLConnection4;
                } catch (Throwable th5) {
                    th = th5;
                    httpURLConnection2 = httpURLConnection4;
                }
                try {
                    setUrlConnBaseInfo(sb5, randomBoundary, appId, 0, 0, null);
                    sb5.append("--");
                    sb5.append(randomBoundary);
                    sb5.append("\r\n");
                    sb5.append("Content-Disposition: form-data; name=QQVersion\r\n\r\n");
                    sb5.append(MsfSdkUtils.getAppVersion());
                    sb5.append("\r\n");
                    sb5.append("--");
                    sb5.append(randomBoundary);
                    sb5.append("\r\n");
                    sb5.append("Content-Disposition: form-data; name=netType\r\n\r\n");
                    sb5.append(NetConnInfoCenter.getSystemNetStateString());
                    sb5.append("\r\n");
                    sb5.append("--");
                    sb5.append(randomBoundary);
                    sb5.append("\r\n");
                    sb5.append("Content-Disposition: form-data; name=seq\r\n\r\n");
                    sb5.append(reportLogInfoContext.reqSeq);
                    sb5.append("\r\n");
                    sb5.append("--");
                    sb5.append(randomBoundary);
                    sb5.append("\r\n");
                    sb5.append("Content-Disposition: form-data; name=importantInfo\r\n\r\n");
                    sb5.append(logStatStr);
                    sb5.append("\r\n");
                    sb5.append("--");
                    sb5.append(randomBoundary);
                    sb5.append("\r\n");
                    sb5.append("Content-Disposition: form-data; name=logSize\r\n\r\n");
                    sb5.append(reportLogInfoContext.logSize);
                    sb5.append("\r\n");
                    sb5.append("--");
                    sb5.append(randomBoundary);
                    sb5.append("\r\n");
                    sb5.append("Content-Disposition: form-data; name=zipLogSize\r\n\r\n");
                    sb5.append(reportLogInfoContext.zipLogSize);
                    sb5.append("\r\n");
                    sb5.append("--");
                    sb5.append(randomBoundary);
                    sb5.append("\r\n");
                    sb5.append("Content-Disposition: form-data; name=failCode\r\n\r\n");
                    sb5.append(reportLogInfoContext.failCode);
                    sb5.append("\r\n");
                    sb5.append("--");
                    sb5.append(randomBoundary);
                    sb5.append("\r\n");
                    sb5.append("Content-Disposition: form-data; name=useBackgroudTrans\r\n\r\n");
                    sb5.append(-1);
                    sb5.append("\r\n");
                    sb5.append("--" + randomBoundary + "--\r\n");
                    dataOutputStream.write(sb5.toString().getBytes("UTF-8"));
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    readServerResp(httpURLConnection2);
                    httpURLConnection = httpURLConnection2;
                } catch (Exception e17) {
                    e = e17;
                    httpURLConnection3 = httpURLConnection2;
                    QLog.e(tag, 1, "reportLogInfo error, ", e);
                    if (httpURLConnection3 != null) {
                        httpURLConnection = httpURLConnection3;
                        httpURLConnection.disconnect();
                    }
                    TrafficStats.clearThreadStatsTag();
                } catch (Throwable th6) {
                    th = th6;
                    httpURLConnection3 = httpURLConnection2;
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                    TrafficStats.clearThreadStatsTag();
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Exception e18) {
            e = e18;
        }
        httpURLConnection.disconnect();
        TrafficStats.clearThreadStatsTag();
    }

    public static void setManualLogLevel(int i3) {
        if (i3 >= 1 && i3 <= 4) {
            QLog.setManualLogLevel(i3);
            if (QLog.isExistSDCard()) {
                BufferedWriter bufferedWriter = null;
                try {
                    try {
                        File file = new File(QLog.getManualLogLevelPath());
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        if (file.exists() && file.isFile()) {
                            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(QLog.getManualLogLevelPath()));
                            try {
                                bufferedWriter2.write(String.valueOf(i3));
                                bufferedWriter2.flush();
                                bufferedWriter = bufferedWriter2;
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedWriter = bufferedWriter2;
                                try {
                                    QLog.e(tag, 1, "setManualLogLevel fail. ", th);
                                    if (bufferedWriter != null) {
                                        bufferedWriter.close();
                                    }
                                    MsfCore.initAppProMsg("*", BaseApplication.getContext().getAppId());
                                } catch (Throwable th6) {
                                    if (bufferedWriter != null) {
                                        try {
                                            bufferedWriter.close();
                                        } catch (IOException e16) {
                                            e16.printStackTrace();
                                        }
                                    }
                                    throw th6;
                                }
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                    }
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
            }
            MsfCore.initAppProMsg("*", BaseApplication.getContext().getAppId());
        }
    }

    private static void setUrlConnBaseInfo(StringBuilder sb5, String str, int i3, int i16, int i17, String str2) {
        String str3;
        o.p();
        List<SimpleAccount> loginedAccountList = MsfSdkUtils.getLoginedAccountList();
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = str2 + ",";
        }
        for (SimpleAccount simpleAccount : loginedAccountList) {
            if (!simpleAccount.getUin().equals(str2)) {
                str3 = str3 + simpleAccount.getUin() + ",";
            }
        }
        sb5.append("--");
        sb5.append(str);
        sb5.append("\r\n");
        sb5.append("Content-Disposition: form-data; name=appid\r\n\r\n");
        sb5.append(i3);
        sb5.append("\r\n");
        sb5.append("--");
        sb5.append(str);
        sb5.append("\r\n");
        sb5.append("Content-Disposition: form-data; name=os\r\n\r\n");
        sb5.append("Android");
        sb5.append("\r\n");
        sb5.append("--");
        sb5.append(str);
        sb5.append("\r\n");
        sb5.append("Content-Disposition: form-data; name=model\r\n\r\n");
        sb5.append(DeviceInfoMonitor.getModel() + "|" + Build.VERSION.RELEASE);
        sb5.append("\r\n");
        sb5.append("--");
        sb5.append(str);
        sb5.append("\r\n");
        sb5.append("Content-Disposition: form-data; name=imei\r\n\r\n");
        sb5.append(o.e());
        sb5.append("\r\n");
        if (i16 != 0) {
            sb5.append("--");
            sb5.append(str);
            sb5.append("\r\n");
            sb5.append("Content-Disposition: form-data; name=fileSeq\r\n\r\n");
            sb5.append(i16);
            sb5.append("\r\n");
        }
        if (i17 != 0) {
            sb5.append("--");
            sb5.append(str);
            sb5.append("\r\n");
            sb5.append("Content-Disposition: form-data; name=fileMaxSeq\r\n\r\n");
            sb5.append(i17);
            sb5.append("\r\n");
        }
        sb5.append("--");
        sb5.append(str);
        sb5.append("\r\n");
        sb5.append("Content-Disposition: form-data; name=clientuins\r\n\r\n");
        sb5.append(str3);
        sb5.append("\r\n");
    }

    private static void setUrlConnCookie(HttpURLConnection httpURLConnection, long j3, String str, String str2, String str3, String str4) {
        boolean z16;
        if (str == null) {
            try {
                str = MsfService.getCore().getAccountCenter().e();
            } catch (Exception e16) {
                QLog.e(tag, 1, "setUrlConnCookie error, ", e16);
                return;
            }
        }
        String str5 = "uin=o" + str;
        if (j3 != 0) {
            str5 = str5.concat("; seq=" + j3);
        }
        if (str2 == null) {
            QLog.i(tag, 1, "setUrlConnCookie skey is null");
        } else {
            str5 = str5.concat("; skey=" + str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            str5 = str5.concat("; p_skey=" + str3);
        }
        if (str4 != null) {
            str5 = str5.concat("; scene=" + str4);
        }
        QLog.d(tag, 1, "setUrlConnCookie=" + str5);
        if (TextUtils.equals("config_report_log", str4)) {
            str5 = "skey=" + str2 + "; scene=" + str4;
            QLog.d(tag, 1, "config_report_log.cookie=" + str5);
        }
        httpURLConnection.setRequestProperty("Cookie", str5);
        String str6 = tag;
        Object[] objArr = new Object[6];
        boolean z17 = false;
        objArr[0] = "setUrlConnCookie, uinIsNull:";
        if (str == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        objArr[1] = Boolean.valueOf(z16);
        objArr[2] = " skeyIsNull:";
        if (str2 == null) {
            z17 = true;
        }
        objArr[3] = Boolean.valueOf(z17);
        objArr[4] = " scene:";
        objArr[5] = str4;
        QLog.d(str6, 1, objArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0167, code lost:
    
        r6 = r28 - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x016a, code lost:
    
        r13.write(r3, 0, (int) r6);
        r4 = r4 + r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0172, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0174, code lost:
    
        com.tencent.qphone.base.util.QLog.d(com.tencent.qphone.base.util.log.report.LogManager.tag, 2, "send " + r4);
     */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void uploadFile(int i3, String str, File file, String str2, int i16, int i17, long j3, long j16, long j17, String str3, String str4, String str5, String str6, HashMap<String, String> hashMap) throws Exception {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        StringBuilder sb5;
        HttpURLConnection httpURLConnection2 = null;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str2).openConnection();
            try {
                httpURLConnection3.setDoInput(true);
                httpURLConnection3.setDoOutput(true);
                httpURLConnection3.setUseCaches(false);
                httpURLConnection3.setRequestMethod("POST");
                httpURLConnection3.setRequestProperty(HttpHeader.RSP.CHARSET, "UTF-8");
                httpURLConnection3.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + str);
                setUrlConnCookie(httpURLConnection3, j17, str3, str4, str5, str6);
                dataOutputStream = new DataOutputStream(httpURLConnection3.getOutputStream());
                sb5 = new StringBuilder();
                httpURLConnection = httpURLConnection3;
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = httpURLConnection3;
            }
        } catch (Throwable th6) {
            th = th6;
        }
        try {
            setUrlConnBaseInfo(sb5, str, i3, i16, i17, str3);
            sb5.append("--");
            sb5.append(str);
            sb5.append("\r\n");
            sb5.append("Content-Disposition: form-data; name=fileKey\r\n\r\n");
            sb5.append(file.getName());
            sb5.append("\r\n");
            sb5.append("--");
            sb5.append(str);
            sb5.append("\r\n");
            sb5.append("Content-Disposition: form-data; name=gzip\r\n\r\n");
            sb5.append("true");
            sb5.append("\r\n");
            sb5.append("--");
            sb5.append(str);
            sb5.append("\r\n");
            sb5.append("Content-Disposition: form-data; name=seq\r\n\r\n");
            sb5.append(j17);
            sb5.append("\r\n");
            if (hashMap != null) {
                for (String str7 : hashMap.keySet()) {
                    if (!TextUtils.isEmpty(str7)) {
                        sb5.append("--");
                        sb5.append(str);
                        sb5.append("\r\n");
                        sb5.append("Content-Disposition: form-data; name=");
                        sb5.append(str7);
                        sb5.append(HttpRsp.HTTP_HEADER_END);
                        sb5.append(hashMap.get(str7));
                        sb5.append("\r\n");
                    }
                }
            }
            sb5.append("--");
            sb5.append(str);
            sb5.append("\r\n");
            sb5.append("Content-Disposition:form-data;name=logFile;filename=\"" + file.getName() + "\"\r\n");
            sb5.append("Content-Type: application/x-zip-compressed\r\n\r\n");
            dataOutputStream.write(sb5.toString().getBytes("UTF-8"));
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[20480];
                long j18 = 0;
                if (j3 > 0) {
                    fileInputStream.skip(j3);
                }
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 20480);
                    if (read == -1) {
                        break;
                    }
                    long j19 = read + j18;
                    if (j19 > j16) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, read);
                    if (QLog.isColorLevel()) {
                        QLog.d(tag, 2, "send " + j19);
                    }
                    j18 = j19;
                }
                fileInputStream.close();
                dataOutputStream.write("\r\n".getBytes());
                dataOutputStream.write(("--" + str + "--\r\n").getBytes());
                dataOutputStream.flush();
                dataOutputStream.close();
                readServerResp(httpURLConnection);
                httpURLConnection.disconnect();
                TrafficStats.clearThreadStatsTag();
            } catch (Throwable th7) {
                fileInputStream.close();
                throw th7;
            }
        } catch (Throwable th8) {
            th = th8;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            TrafficStats.clearThreadStatsTag();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r15v5, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    public static void zipFiles(ArrayList<QLog.LogFile> arrayList, String str) {
        String str2;
        try {
            try {
                str = new BufferedOutputStream(new FileOutputStream(new File((String) str)));
                ZipOutputStream zipOutputStream = new ZipOutputStream(str);
                try {
                    Iterator<QLog.LogFile> it = arrayList.iterator();
                    boolean z16 = false;
                    while (it.hasNext()) {
                        QLog.LogFile next = it.next();
                        if (next.exists()) {
                            zipOutputStream.putNextEntry(new ZipEntry(next.getName() + next.stuffix));
                            zipOutputStream.setLevel(9);
                            long length = next.length();
                            FileInputStream fileInputStream = new FileInputStream(next);
                            try {
                                byte[] bArr = new byte[20480];
                                long j3 = 0;
                                while (true) {
                                    int read = fileInputStream.read(bArr, 0, 20480);
                                    if (read == -1) {
                                        break;
                                    }
                                    zipOutputStream.write(bArr, 0, read);
                                    j3 += read;
                                    if (j3 >= length) {
                                        z16 = true;
                                        break;
                                    }
                                    z16 = true;
                                }
                                fileInputStream.close();
                                zipOutputStream.flush();
                                zipOutputStream.closeEntry();
                            } catch (Throwable th5) {
                                fileInputStream.close();
                                zipOutputStream.flush();
                                zipOutputStream.closeEntry();
                                throw th5;
                            }
                        }
                    }
                    if (z16) {
                        zipOutputStream.close();
                    }
                    File file = new File(QLog.getLogPath(), "com.tencent.mobileqq_NETFLOW.log");
                    if (file.exists()) {
                        boolean delete = file.delete();
                        if (QLog.isColorLevel()) {
                            QLog.d(tag, 2, "netflow file has been deleted: " + delete);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(tag, 2, " zip stream close.");
                    }
                    str.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.i(tag, 2, " zip file error " + e16, e16);
                    }
                    str.close();
                    if (QLog.isColorLevel()) {
                        str2 = tag;
                    }
                }
                if (QLog.isColorLevel()) {
                    str2 = tag;
                    QLog.d(str2, 2, " file out stream close.");
                }
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            if (QLog.isColorLevel()) {
                QLog.i(tag, 2, "zip file finish");
            }
        } catch (Throwable th6) {
            str.close();
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, " file out stream close.");
            }
            throw th6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0449  */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String zipLog(ReportLogInfoContext reportLogInfoContext) {
        String deleteExpireLogRecordFilePath;
        long timeInMillis;
        String str;
        int i3;
        String str2;
        File[] listFiles;
        HashSet hashSet;
        File[] fileArr;
        long j3;
        long j16;
        int i16;
        File[] listFiles2;
        long j17;
        int i17;
        if (QLog.isColorLevel()) {
            QLog.i(tag, 2, "zip file start");
        }
        Pair<Long, Long> timePeriod = reportLogInfoContext.getTimePeriod();
        long longValue = ((Long) timePeriod.first).longValue();
        long longValue2 = ((Long) timePeriod.first).longValue();
        long longValue3 = ((Long) timePeriod.second).longValue();
        long longValue4 = ((Long) timePeriod.second).longValue();
        long longValue5 = ((Long) timePeriod.first).longValue();
        long longValue6 = ((Long) timePeriod.second).longValue();
        QLog.d(tag, 1, "zipLog startTime=" + longValue + ", endTime=" + longValue3);
        HashSet hashSet2 = new HashSet();
        long j18 = longValue;
        int i18 = 0;
        long j19 = longValue2;
        while (true) {
            String format = QLog.getLogFileFormatter().format(Long.valueOf(j18));
            hashSet2.add(format);
            if (i18 == 0) {
                i18 = format.length();
            }
            j18 += 3600000;
            if (j18 > longValue3) {
                break;
            }
            longValue = longValue;
            j19 = j19;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy.MM.dd.HH");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        long j26 = j19;
        while (true) {
            hashSet2.add(simpleDateFormat.format(Long.valueOf(longValue5)));
            longValue5 += 3600000;
            if (longValue5 > longValue6) {
                break;
            }
            longValue = longValue;
            j26 = j26;
        }
        ArrayList arrayList = new ArrayList();
        File file = new File(QLog.getLogPath());
        int i19 = 4;
        if (file.exists()) {
            File[] listFiles3 = file.listFiles();
            if (listFiles3 != null) {
                int length = listFiles3.length;
                int i26 = 0;
                while (i26 < length) {
                    File file2 = listFiles3[i26];
                    String name = file2.getName();
                    if (name.endsWith(".log")) {
                        name = name.substring(0, name.length() - i19);
                    } else if (name.endsWith(".log.zip")) {
                        name = name.substring(0, name.length() - 8);
                    } else if (name.endsWith(".qlog")) {
                        name = name.substring(0, name.length() - 5);
                    }
                    if ((name.startsWith(QLog.getPackageName()) || name.startsWith(PRIVATE_LOG_PREFIX)) && hashSet2.contains(name.substring(name.length() - i18))) {
                        QLog.LogFile logFile = new QLog.LogFile(file2.getPath());
                        arrayList.add(logFile);
                        reportLogInfoContext.logSize += logFile.length();
                        reportLogInfoContext.failCode = 0L;
                    }
                    i26++;
                    i19 = 4;
                }
            }
        } else {
            file.mkdirs();
        }
        if (file.exists() && (listFiles2 = file.listFiles()) != null) {
            int length2 = listFiles2.length;
            int i27 = 0;
            while (i27 < length2) {
                File file3 = listFiles2[i27];
                File[] fileArr2 = listFiles2;
                String name2 = file3.getName();
                if (name2.endsWith(".qqxlog") && name2.startsWith("extractXLog_") && file3.exists()) {
                    i17 = length2;
                    j17 = longValue;
                    QLog.d(tag, 1, "useless extractXLog_ file exist, delete it\uff1a" + name2);
                    QLog.d(tag, 1, "useless extractXLog_ file delete result\uff1a" + file3.delete());
                } else {
                    j17 = longValue;
                    i17 = length2;
                }
                i27++;
                listFiles2 = fileArr2;
                length2 = i17;
                longValue = j17;
            }
        }
        long j27 = longValue;
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            int length3 = listFiles.length;
            int i28 = 0;
            j26 = j26;
            while (i28 < length3) {
                File file4 = listFiles[i28];
                String name3 = file4.getName();
                if (name3.endsWith(".qqxlog")) {
                    fileArr = listFiles;
                    if (name3.startsWith("QQXlog_")) {
                        i16 = length3;
                        String substring = name3.substring(0, name3.length() - 7);
                        if (hashSet2.contains(substring.substring(substring.length() - i18))) {
                            Date date = new Date(j26);
                            Date date2 = new Date(longValue4);
                            hashSet = hashSet2;
                            j3 = j26;
                            String substring2 = substring.substring(0, substring.lastIndexOf("_"));
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("extractXLog_");
                            sb5.append(substring2);
                            sb5.append("_");
                            SimpleDateFormat simpleDateFormat2 = qqxlogTimeFormatter;
                            sb5.append(simpleDateFormat2.format(date));
                            sb5.append("-");
                            sb5.append(simpleDateFormat2.format(date2));
                            sb5.append(".qqxlog");
                            String sb6 = sb5.toString();
                            StringBuilder sb7 = new StringBuilder();
                            j16 = longValue4;
                            sb7.append(QLog.getLogPath());
                            sb7.append(sb6);
                            if (new File(sb7.toString()).exists()) {
                                QLog.d(tag, 1, "qqxlogFile exist, skip it\uff1a" + sb6);
                            } else {
                                int androidExtractLog = QLog.androidExtractLog(date, date2, substring2, sb6);
                                QLog.d(tag, 1, "qqxlog extractLog Result=" + androidExtractLog + ", file:" + sb6);
                                if (androidExtractLog == 0) {
                                    QLog.LogFile logFile2 = new QLog.LogFile(QLog.getLogPath() + sb6);
                                    arrayList.add(logFile2);
                                    reportLogInfoContext.logSize = reportLogInfoContext.logSize + logFile2.length();
                                    reportLogInfoContext.failCode = 0L;
                                }
                                if (!QLog.isUseXlog()) {
                                    QLog.LogFile logFile3 = new QLog.LogFile(QLog.getLogPath() + file4.getName());
                                    arrayList.add(logFile3);
                                    reportLogInfoContext.logSize = reportLogInfoContext.logSize + logFile3.length();
                                    reportLogInfoContext.failCode = 0L;
                                }
                            }
                        } else {
                            hashSet = hashSet2;
                            j3 = j26;
                            j16 = longValue4;
                        }
                        i28++;
                        listFiles = fileArr;
                        length3 = i16;
                        hashSet2 = hashSet;
                        j26 = j3;
                        longValue4 = j16;
                    } else {
                        hashSet = hashSet2;
                    }
                } else {
                    hashSet = hashSet2;
                    fileArr = listFiles;
                }
                j3 = j26;
                j16 = longValue4;
                i16 = length3;
                i28++;
                listFiles = fileArr;
                length3 = i16;
                hashSet2 = hashSet;
                j26 = j3;
                longValue4 = j16;
            }
        }
        QLog.LogFile logFile4 = new QLog.LogFile(ANR_LOG_PATH);
        ?? r56 = j26;
        if (logFile4.exists()) {
            r56 = 0;
            r56 = 0;
            if (logFile4.length() > 0) {
                arrayList.add(logFile4);
            }
        }
        QLog.LogFile logFile5 = null;
        try {
            try {
                if (file.exists()) {
                    QLog.LogFile logFile6 = new QLog.LogFile(file, "FileList.log");
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(logFile6)));
                    File[] listFiles4 = file.listFiles();
                    if (listFiles4 != null) {
                        for (File file5 : listFiles4) {
                            bufferedWriter.write(file5.getName() + "\n");
                        }
                    }
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    r56 = logFile6;
                } else {
                    file.mkdir();
                    QLog.LogFile logFile7 = new QLog.LogFile(file, "FileList.log");
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(logFile7)));
                    bufferedWriter2.write("no log file in old and new path.");
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    r56 = logFile7;
                }
            } catch (Exception e16) {
                e = e16;
                QLog.d(tag, 1, "read Log file list error. " + e, e);
                if (r56 != 0) {
                }
                deleteExpireLogRecordFilePath = QLog.getDeleteExpireLogRecordFilePath();
                if (!TextUtils.isEmpty(deleteExpireLogRecordFilePath)) {
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(j27);
                calendar.set(11, 0);
                calendar.set(12, 0);
                calendar.set(13, 0);
                calendar.set(14, 0);
                timeInMillis = calendar.getTimeInMillis();
                if (netFlowhasGet) {
                }
                logFile5 = e.a(timeInMillis, 86400000 + timeInMillis);
                if (QLog.isColorLevel()) {
                }
                if (logFile5 != null) {
                }
                addDataCorruptInfo(arrayList);
                addWtloginLog(arrayList, reportLogInfoContext.getYear(true), reportLogInfoContext.getMonth(true), reportLogInfoContext.getDay(true), reportLogInfoContext.getYear(false), reportLogInfoContext.getMonth(false), reportLogInfoContext.getDay(false));
                if (reportLogInfoContext.logSize == 0) {
                }
                reportLogInfoContext.onStateChange(20);
                str = QLog.getLogPath() + String.format("%d_%d_%d_%d--%d_%d_%d_%d", Integer.valueOf(reportLogInfoContext.getYear(true)), Integer.valueOf(reportLogInfoContext.getMonth(true)), Integer.valueOf(reportLogInfoContext.getDay(true)), Integer.valueOf(reportLogInfoContext.getHour(true)), Integer.valueOf(reportLogInfoContext.getYear(false)), Integer.valueOf(reportLogInfoContext.getMonth(false)), Integer.valueOf(reportLogInfoContext.getDay(false)), Integer.valueOf(reportLogInfoContext.getHour(false)));
                i3 = -1;
                do {
                    i3++;
                    if (i3 == 0) {
                    }
                } while (new File(str2).exists());
                zipFiles(arrayList, str2);
                reportLogInfoContext.zipLogSize = new File(str2).length();
                reportLogInfoContext.onStateChange(30);
                return str2;
            }
        } catch (Exception e17) {
            e = e17;
            r56 = 0;
        }
        if (r56 != 0) {
            arrayList.add(r56);
        }
        deleteExpireLogRecordFilePath = QLog.getDeleteExpireLogRecordFilePath();
        if (!TextUtils.isEmpty(deleteExpireLogRecordFilePath)) {
            QLog.LogFile logFile8 = new QLog.LogFile(deleteExpireLogRecordFilePath);
            if (logFile8.exists()) {
                arrayList.add(logFile8);
            } else if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "!deleteRecordFile.exists()");
            }
        }
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j27);
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        timeInMillis = calendar2.getTimeInMillis();
        if (netFlowhasGet || preNetflowTime != timeInMillis) {
            logFile5 = e.a(timeInMillis, 86400000 + timeInMillis);
            if (QLog.isColorLevel()) {
                String str3 = tag;
                StringBuilder sb8 = new StringBuilder();
                sb8.append("get user 24h netflow ");
                sb8.append(logFile5 != null);
                QLog.d(str3, 2, sb8.toString());
            }
        }
        if (logFile5 != null) {
            netFlowhasGet = true;
            preNetflowTime = timeInMillis;
            arrayList.add(logFile5);
        }
        addDataCorruptInfo(arrayList);
        addWtloginLog(arrayList, reportLogInfoContext.getYear(true), reportLogInfoContext.getMonth(true), reportLogInfoContext.getDay(true), reportLogInfoContext.getYear(false), reportLogInfoContext.getMonth(false), reportLogInfoContext.getDay(false));
        if (reportLogInfoContext.logSize == 0) {
            reportLogInfoContext.failCode = 1L;
        }
        reportLogInfoContext.onStateChange(20);
        str = QLog.getLogPath() + String.format("%d_%d_%d_%d--%d_%d_%d_%d", Integer.valueOf(reportLogInfoContext.getYear(true)), Integer.valueOf(reportLogInfoContext.getMonth(true)), Integer.valueOf(reportLogInfoContext.getDay(true)), Integer.valueOf(reportLogInfoContext.getHour(true)), Integer.valueOf(reportLogInfoContext.getYear(false)), Integer.valueOf(reportLogInfoContext.getMonth(false)), Integer.valueOf(reportLogInfoContext.getDay(false)), Integer.valueOf(reportLogInfoContext.getHour(false)));
        i3 = -1;
        do {
            i3++;
            str2 = i3 == 0 ? str + "_" + i3 + ".zip" : str + ".zip";
        } while (new File(str2).exists());
        zipFiles(arrayList, str2);
        reportLogInfoContext.zipLogSize = new File(str2).length();
        reportLogInfoContext.onStateChange(30);
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zipLogFile(File file) {
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(new File(getZipLogFilePath(file)))));
            zipOutputStream.setLevel(b.Q());
            byte[] bArr = new byte[8192];
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zipEntry.setSize(file.length());
            zipEntry.setTime(file.lastModified());
            zipOutputStream.putNextEntry(zipEntry);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 8192);
                if (read != -1) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    bufferedInputStream.close();
                    zipOutputStream.close();
                    return true;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }
}
