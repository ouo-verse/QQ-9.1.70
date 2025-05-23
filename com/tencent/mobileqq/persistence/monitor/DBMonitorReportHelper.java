package com.tencent.mobileqq.persistence.monitor;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.service.IDBMonitorService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.dy;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class DBMonitorReportHelper {
    private static final String DB_FILE_SUFFIX = ".db";
    private static final String DB_OPERATE_COST_REPORT_EVENT = "db_operate_cost_report_event";
    private static final String DB_SIZE_REPORT_EVENT = "db_size_report_event";
    private static final String KEY_COMMON_DB_SIZE = "commonDBSize";
    private static final String KEY_CURRENT_STACK = "currentStack";
    private static final String KEY_DB_NAME = "dbName";
    private static final String KEY_DB_OPERATE_COST = "dbOperateCost";
    private static final String KEY_DB_OPERATE_COUNT = "dbOperateCount";
    private static final String KEY_DB_OPERATE_THREAD = "dbOperateThread";
    private static final String KEY_DB_OPERATE_TYPE = "dbOperateType";
    private static final String KEY_DB_SIZE = "dbSize";
    private static final String KEY_IS_MAIN_DB = "isMainDB";
    private static final String KEY_OPERATE_SQL = "operateSQL";
    private static final String KEY_TABLE_COUNT = "tableCount";
    private static final String KEY_TABLE_NAME = "tableName";
    private static final String KEY_USER_UIN = "userUin";
    private static final String MARKET_DB_COST_REPORT_EVENT = "market_db_cost_report_event";
    private static final Random RANDOM = new Random();
    private static final String TAG = "DBMonitorReportHelper";
    private static final int UNIT_M = 1048576;

    @Nullable
    private static StackTraceElement[] getCurrentStackTrace() {
        try {
            return Thread.currentThread().getStackTrace();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getStackTrace error: ", e16);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void reportDBOperateCost(String str, String str2, long j3, int i3, String str3, String str4) {
        final String str5;
        boolean z16;
        long j16;
        if (!((IDBMonitorService) QRoute.api(IDBMonitorService.class)).isOperateCostReported()) {
            return;
        }
        if (RANDOM.nextInt(((IDBMonitorService) QRoute.api(IDBMonitorService.class)).getOperateCostReportedSampling()) > 0) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str5 = peekAppRuntime.getAccount();
        } else {
            str5 = "";
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("tableName", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(KEY_OPERATE_SQL, str2);
            if (TextUtils.isEmpty(str)) {
                hashMap.put("tableName", dy.e(str2));
            }
        }
        hashMap.put(KEY_DB_OPERATE_COST, String.valueOf(j3));
        hashMap.put(KEY_DB_OPERATE_COUNT, String.valueOf(i3));
        hashMap.put(KEY_DB_OPERATE_TYPE, str3);
        hashMap.put(KEY_DB_OPERATE_THREAD, Thread.currentThread().getName());
        if (str4 != null) {
            if (str4.equals(str5 + ".db")) {
                z16 = true;
                hashMap.put(KEY_IS_MAIN_DB, String.valueOf(z16));
                hashMap.put(KEY_DB_NAME, str4);
                File databasePath = MobileQQ.sMobileQQ.getDatabasePath(str5 + ".db");
                if (!z16) {
                    j16 = databasePath.length() / 1048576;
                } else {
                    j16 = 0;
                }
                hashMap.put(KEY_DB_SIZE, String.valueOf(j16));
                hashMap.put(KEY_COMMON_DB_SIZE, String.valueOf(MobileQQ.sMobileQQ.getDatabasePath(str4).length()));
                hashMap.put(KEY_USER_UIN, str5);
                final StackTraceElement[] currentStackTrace = getCurrentStackTrace();
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.persistence.monitor.DBMonitorReportHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        StackTraceElement[] stackTraceElementArr = currentStackTrace;
                        if (stackTraceElementArr != null) {
                            hashMap.put(DBMonitorReportHelper.KEY_CURRENT_STACK, Arrays.toString(stackTraceElementArr));
                        }
                        ((IDBMonitorService) QRoute.api(IDBMonitorService.class)).reportDBEventByBeacon(str5, DBMonitorReportHelper.DB_OPERATE_COST_REPORT_EVENT, hashMap);
                    }
                }, 16, null, true);
            }
        }
        z16 = false;
        hashMap.put(KEY_IS_MAIN_DB, String.valueOf(z16));
        hashMap.put(KEY_DB_NAME, str4);
        File databasePath2 = MobileQQ.sMobileQQ.getDatabasePath(str5 + ".db");
        if (!z16) {
        }
        hashMap.put(KEY_DB_SIZE, String.valueOf(j16));
        hashMap.put(KEY_COMMON_DB_SIZE, String.valueOf(MobileQQ.sMobileQQ.getDatabasePath(str4).length()));
        hashMap.put(KEY_USER_UIN, str5);
        final StackTraceElement[] currentStackTrace2 = getCurrentStackTrace();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.persistence.monitor.DBMonitorReportHelper.1
            @Override // java.lang.Runnable
            public void run() {
                StackTraceElement[] stackTraceElementArr = currentStackTrace2;
                if (stackTraceElementArr != null) {
                    hashMap.put(DBMonitorReportHelper.KEY_CURRENT_STACK, Arrays.toString(stackTraceElementArr));
                }
                ((IDBMonitorService) QRoute.api(IDBMonitorService.class)).reportDBEventByBeacon(str5, DBMonitorReportHelper.DB_OPERATE_COST_REPORT_EVENT, hashMap);
            }
        }, 16, null, true);
    }

    public static void reportDBSize(AppRuntime appRuntime) {
        if (!((IDBMonitorService) QRoute.api(IDBMonitorService.class)).isDBSizeReported()) {
            return;
        }
        if (RANDOM.nextInt(((IDBMonitorService) QRoute.api(IDBMonitorService.class)).getDBSizeReportedSampling()) > 0) {
            return;
        }
        File databasePath = appRuntime.getApplication().getDatabasePath(appRuntime.getAccount() + ".db");
        if (!databasePath.exists()) {
            QLog.e(TAG, 1, "reportDBSize: db not exist!");
            return;
        }
        long length = databasePath.length() / 1048576;
        SQLiteDatabase writableDatabase = appRuntime.getWritableDatabase();
        if (writableDatabase == null) {
            QLog.e(TAG, 1, "reportDBSize: getWritableDatabase return null!");
            return;
        }
        int length2 = writableDatabase.getAllTableNameFromCache().length;
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_DB_SIZE, String.valueOf(length));
        hashMap.put(KEY_TABLE_COUNT, String.valueOf(length2));
        hashMap.put(KEY_USER_UIN, appRuntime.getAccount());
        ((IDBMonitorService) QRoute.api(IDBMonitorService.class)).reportDBEventByBeacon(appRuntime.getAccount(), DB_SIZE_REPORT_EVENT, hashMap);
    }

    public static void reportMarketDBCost(long j3, int i3, String str, String str2) {
        final String str3;
        boolean z16;
        if (!((IDBMonitorService) QRoute.api(IDBMonitorService.class)).isMarketDBCostReported()) {
            return;
        }
        if (RANDOM.nextInt(((IDBMonitorService) QRoute.api(IDBMonitorService.class)).getMarketDBCostReportedSampling(str)) > 0) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str3 = peekAppRuntime.getAccount();
        } else {
            str3 = "";
        }
        final HashMap hashMap = new HashMap();
        hashMap.put(KEY_DB_OPERATE_COST, String.valueOf(j3));
        hashMap.put(KEY_DB_OPERATE_COUNT, String.valueOf(i3));
        hashMap.put(KEY_DB_OPERATE_TYPE, str);
        hashMap.put(KEY_DB_OPERATE_THREAD, Thread.currentThread().getName());
        if (str2 != null) {
            if (str2.equals(str3 + ".db")) {
                z16 = true;
                hashMap.put(KEY_IS_MAIN_DB, String.valueOf(z16));
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.persistence.monitor.DBMonitorReportHelper.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((IDBMonitorService) QRoute.api(IDBMonitorService.class)).reportDBEventByBeacon(str3, DBMonitorReportHelper.MARKET_DB_COST_REPORT_EVENT, hashMap);
                    }
                }, 32, null, true);
            }
        }
        z16 = false;
        hashMap.put(KEY_IS_MAIN_DB, String.valueOf(z16));
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.persistence.monitor.DBMonitorReportHelper.2
            @Override // java.lang.Runnable
            public void run() {
                ((IDBMonitorService) QRoute.api(IDBMonitorService.class)).reportDBEventByBeacon(str3, DBMonitorReportHelper.MARKET_DB_COST_REPORT_EVENT, hashMap);
            }
        }, 32, null, true);
    }
}
