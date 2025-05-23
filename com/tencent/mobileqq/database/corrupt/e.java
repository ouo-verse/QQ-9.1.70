package com.tencent.mobileqq.database.corrupt;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.dbfix.DBCheckResult;
import com.tencent.dbfix.DBCheckResultItem;
import com.tencent.dbfix.DBFix;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes10.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final DBCheckResult f203286a;

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<String, String> f203287b;

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<String, String> f203288c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71416);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f203286a = new DBCheckResult();
        f203287b = new HashMap<>();
        f203288c = new HashMap<>();
    }

    private static void a(File file, String str) {
        long length = file.length() / 1048576;
        HashMap<String, String> hashMap = f203287b;
        hashMap.put("dbSize" + str, String.valueOf(length));
        String str2 = file + "-wal";
        File file2 = new File(str2);
        QLog.d("DBFixReportHelper", 1, "appendDBSizeInfo wal file path: ", str2);
        if (file2.exists()) {
            hashMap.put("walSize" + str, String.valueOf(file2.length()));
        }
        String str3 = file + "-shm";
        File file3 = new File(str3);
        QLog.d("DBFixReportHelper", 1, "appendDBSizeInfo shm file path: ", str3);
        if (file3.exists()) {
            hashMap.put("shmSize" + str, String.valueOf(file3.length()));
        }
    }

    private static void b() {
        HashMap<String, String> hashMap = f203287b;
        hashMap.put("deviceVersion", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("deviceBrand", Build.BRAND);
        hashMap.put("deviceModel", DeviceInfoMonitor.getModel());
    }

    static void c(File file) {
        String str = file + "-mbu";
        File file2 = new File(str);
        QLog.d("DBFixReportHelper", 1, "appendMasterSizeInfo master file path: ", str);
        if (file2.exists()) {
            f203287b.put("masterSize", String.valueOf(file2.length()));
        }
    }

    private static void d(String str) {
        float f16;
        long c16 = m.c() / 1048576;
        long X = ah.X() / 1048576;
        Debug.MemoryInfo[] processMemoryInfo = SystemMethodProxy.getProcessMemoryInfo((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY), new int[]{Process.myPid()});
        if (processMemoryInfo != null && processMemoryInfo.length > 0) {
            f16 = processMemoryInfo[0].getTotalPss() / 1024.0f;
        } else {
            f16 = -1.0f;
        }
        float freeMemory = ((float) Runtime.getRuntime().freeMemory()) / 1048576.0f;
        float f17 = ((float) Runtime.getRuntime().totalMemory()) / 1048576.0f;
        float maxMemory = ((float) Runtime.getRuntime().maxMemory()) / 1048576.0f;
        HashMap<String, String> hashMap = f203287b;
        hashMap.put("ramTotal" + str, String.valueOf(c16));
        hashMap.put("ramAvailable" + str, String.valueOf(X));
        hashMap.put("ramPssUsed" + str, String.valueOf(f16));
        hashMap.put("ramFree" + str, String.valueOf(freeMemory));
        hashMap.put("ramAppTotal" + str, String.valueOf(f17));
        hashMap.put("ramAppMax" + str, String.valueOf(maxMemory));
    }

    private static void e(String str) {
        long[] T = ah.T();
        long j3 = T[0];
        long j16 = T[1];
        HashMap<String, String> hashMap = f203287b;
        hashMap.put("romTotal" + str, String.valueOf(j3));
        hashMap.put("romAvailable" + str, String.valueOf(j16));
    }

    private static void f(boolean z16, int i3) {
        String str;
        int i16 = 1;
        QLog.d("DBFixReportHelper", 1, "doIntegrityCheck isFixDone -> ", Boolean.valueOf(z16), ", fixType -> ", Integer.valueOf(i3));
        if (z16) {
            str = "_";
        } else {
            str = "";
        }
        DBCheckResult dBCheckResult = f203286a;
        long j3 = dBCheckResult.checkStartTime;
        long j16 = dBCheckResult.checkCompleteTime;
        dBCheckResult.clear();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        File databasePath = runtime.getApplication().getDatabasePath(runtime.getAccount() + DBBackupServiceImpl.DB_FILE_SUFFIX);
        dBCheckResult.checkStartTime = System.currentTimeMillis();
        ArrayList<DBCheckResultItem> doIntegrityCheck = DBFix.getInstance().doIntegrityCheck(databasePath.getAbsolutePath());
        QLog.d("DBFixReportHelper", 1, "doIntegrityCheck checkResult -> ", doIntegrityCheck);
        dBCheckResult.setResult(doIntegrityCheck);
        long currentTimeMillis = System.currentTimeMillis();
        dBCheckResult.checkCompleteTime = currentTimeMillis;
        long j17 = currentTimeMillis - dBCheckResult.checkStartTime;
        HashMap<String, String> hashMap = f203288c;
        hashMap.put("integrityCheckTime" + str, String.valueOf(j17));
        if (z16 && j16 > 0) {
            hashMap.put("fixTime", String.valueOf(dBCheckResult.checkStartTime - j16));
            if (databasePath.length() == 0) {
                i16 = 2;
            }
            hashMap.put("fixStatus", String.valueOf(i16));
            hashMap.put("totalTime", String.valueOf(dBCheckResult.checkCompleteTime - j3));
        }
        hashMap.put("fixType" + str, String.valueOf(i3));
        hashMap.put("corruptReasonCode" + str, String.valueOf(dBCheckResult.getCorruptReasonCode()));
        hashMap.put("corruptReasonDesc" + str, String.valueOf(dBCheckResult.buildDescription()));
    }

    private static void g(AppRuntime appRuntime) {
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
        HashMap<String, String> hashMap = f203287b;
        statisticCollector.collectPerformance(currentAccountUin, StatisticCollector.DBFIX_DEVICE_INFO_REPORT, true, 0L, 0L, hashMap, "");
        QLog.d("DBFixReportHelper", 1, "onDBFixConfirmDialogShow report info -> ", hashMap);
    }

    private static boolean h(File file) {
        if (!file.exists()) {
            return false;
        }
        long length = file.length() / 1048576;
        QLog.d("DBFixReportHelper", 1, "needIntegrityCheck dbLength -> ", Long.valueOf(length));
        if (length > 512) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i() {
        try {
            f203287b.put("fixStatus", String.valueOf(0));
            g(BaseApplicationImpl.getApplication().getRuntime());
        } catch (Throwable th5) {
            QLog.d("DBFixReportHelper", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j() {
        int i3;
        try {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            File databasePath = runtime.getApplication().getDatabasePath(runtime.getAccount() + DBBackupServiceImpl.DB_FILE_SUFFIX);
            if (!databasePath.exists()) {
                return;
            }
            if (databasePath.length() == 0) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            f203287b.put("fixStatus", String.valueOf(i3));
            a(databasePath, "_");
            e("_");
            d("_");
            g(runtime);
        } catch (Throwable th5) {
            QLog.d("DBFixReportHelper", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k() {
        try {
            f203287b.clear();
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            File databasePath = runtime.getApplication().getDatabasePath(runtime.getAccount() + DBBackupServiceImpl.DB_FILE_SUFFIX);
            if (!databasePath.exists()) {
                return;
            }
            a(databasePath, "");
            e("");
            d("");
            b();
            c(databasePath);
        } catch (Throwable th5) {
            QLog.d("DBFixReportHelper", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(int i3, int i16) {
        try {
            if (f203286a.checkStartTime <= 0) {
                return;
            }
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (!runtime.getApplication().getDatabasePath(runtime.getAccount() + DBBackupServiceImpl.DB_FILE_SUFFIX).exists()) {
                return;
            }
            f(true, i3);
            HashMap<String, String> hashMap = f203288c;
            hashMap.put("masterCorrupted", String.valueOf(i16));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(runtime.getCurrentAccountUin(), StatisticCollector.DBFIX_INTEGRITY_CHECK_INFO_REPORT, true, 0L, 0L, hashMap, "");
            QLog.d("DBFixReportHelper", 1, "doReportIntegrityCheckInfo report info -> ", hashMap);
        } catch (Throwable th5) {
            QLog.d("DBFixReportHelper", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void m(int i3) {
        try {
            f203286a.clear();
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            File databasePath = runtime.getApplication().getDatabasePath(runtime.getAccount() + DBBackupServiceImpl.DB_FILE_SUFFIX);
            if (!databasePath.exists()) {
                return;
            }
            boolean h16 = h(databasePath);
            QLog.d("DBFixReportHelper", 1, "onDBFixStart needIntegrityCheck -> ", Boolean.valueOf(h16));
            if (!h16) {
                return;
            }
            f(false, i3);
        } catch (Throwable th5) {
            QLog.d("DBFixReportHelper", 1, th5, new Object[0]);
        }
    }
}
