package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.app.db.DBThreadMonitor;
import com.tencent.mobileqq.imcore.proxy.basic.StatisticCollectorProxy;
import com.tencent.mobileqq.imcore.proxy.db.SQLiteFTSUtilsProxy;
import com.tencent.mobileqq.imcore.proxy.msg.AIOUtilsProxy;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.TableNameCache;
import com.tencent.mobileqq.persistence.monitor.DBMonitorReportHelper;
import com.tencent.mobileqq.persistence.service.IDBMonitorService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.utils.dy;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.inject.MqqInjectorManager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class SQLiteDatabase {
    static IPatchRedirector $redirector_ = null;
    private static final String DBTRANSLOG = "SQLiteDatabase";
    private static final long DB_ERROR_CHECK_INTERNAL = 240000;
    private static final int DB_ERROR_THRESHOLD_COUNT = 10;
    private static final long DB_ERROR_TOAST_INTERNAL = 21600000;
    private static final int LOG_ABNORMAL_OPERATE_THRESHOLD = 10000;
    private static final long LOG_CHECK_TIME = 1000;
    private static final boolean OPEN_DB_LOG = false;
    public static final String OPERATE_TYPE_DELETE = "delete";
    public static final String OPERATE_TYPE_EXEC_SQL = "execSQL";
    public static final String OPERATE_TYPE_INSERT = "insert";
    public static final String OPERATE_TYPE_QUERY = "query";
    public static final String OPERATE_TYPE_RAW_QUERY = "rawQuery";
    public static final String OPERATE_TYPE_REPLACE = "replace";
    public static final String OPERATE_TYPE_UPDATE = "update";
    private static final String REPORT_TAG_OP_TABLE_NAME = "OpTableName";
    private static final String REPORT_TAG_OP_TYPE = "OpType";
    private static final int SAMPLE_SIZE = 500;
    private static final int SAMPLE_SIZE_FOR_INSERT = 100;
    static final String SQL_GET_TABLE_ATTR = "select sql from sqlite_master where type=? and name=?";
    private static final String TAG = "db";
    private static final String TAG_SQLITE_DB = "SQLiteDataBaseLog";
    public static final String TOAST_DB_CORRUPTION = "DB\u8bfb\u5199\u5f02\u5e38";
    public static final String TOAST_PROCESS = "\u8fdb\u7a0b\uff1a";
    private static final String UIN_SAMPLE_SUFFIX = "59.db";
    private static final long VALID_LOG_COUNT = 20;
    private static int dbError_count;
    private static long dbError_lastCheckTime;
    private static long dbError_lastToastTime;
    private static boolean dbError_toastTimeInited;
    public static boolean sIsLogcatDBOperation;
    private static long sLogCount;
    private static long sTimeBegin;

    /* renamed from: db, reason: collision with root package name */
    final android.database.sqlite.SQLiteDatabase f195028db;
    private DBThreadMonitor mDBThreadMonitor;
    private final String mName;
    private long mOpCount;
    private boolean mUinNeedReport;
    private final Map<String, ArrayList<String>> queryCacheMap;
    private final Map<String, ArrayList<String>> tableMap;
    private TableNameCache tableNameCache;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class DbHistory {
        static IPatchRedirector $redirector_;
        public WeakReference<Cursor> cursor;
        public StackTraceElement[] history;
        public String sql;

        public DbHistory() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SQLiteDatabase.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40925);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
            return;
        }
        sIsLogcatDBOperation = false;
        sLogCount = 0L;
        sTimeBegin = 0L;
        dbError_count = 0;
        dbError_toastTimeInited = false;
        dbError_lastToastTime = 0L;
        dbError_lastCheckTime = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteDatabase(android.database.sqlite.SQLiteDatabase sQLiteDatabase, TableNameCache tableNameCache, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sQLiteDatabase, tableNameCache, str);
            return;
        }
        this.tableMap = new ConcurrentHashMap(32);
        this.queryCacheMap = new ConcurrentHashMap(32);
        this.tableNameCache = null;
        this.mDBThreadMonitor = new DBThreadMonitor(TAG_SQLITE_DB);
        this.mOpCount = 0L;
        this.mUinNeedReport = false;
        this.f195028db = sQLiteDatabase;
        this.tableNameCache = tableNameCache;
        if (MqqInjectorManager.instance().isDebugVersion()) {
            loadIsLogcatDBOperation();
        }
        this.mName = str;
        if (!TextUtils.isEmpty(str) && !str.endsWith(UIN_SAMPLE_SUFFIX)) {
            z16 = false;
        }
        this.mUinNeedReport = z16;
    }

    private ArrayList<String> analyseRawQueryWhere(String str) {
        if (this.queryCacheMap.containsKey(str)) {
            return this.queryCacheMap.get(str);
        }
        Matcher matcher = Pattern.compile("\\s*\\w+\\s*(>|<|=|>=|<=|!=|=!|<>)\\s*\\?\\s*").matcher(str);
        ArrayList<String> arrayList = new ArrayList<>();
        while (matcher.find()) {
            Matcher matcher2 = Pattern.compile("\\w+").matcher(matcher.group().trim());
            matcher2.find();
            arrayList.add(matcher2.group());
        }
        this.queryCacheMap.put(str, arrayList);
        return arrayList;
    }

    private ArrayList<String> analyseTableField(String str, String[] strArr) {
        if (QLog.isColorLevel()) {
            QLog.d("db", 2, "analyseTableField: " + str);
        }
        try {
            String[] split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str2 : strArr) {
                String lowerCase = str2.toLowerCase();
                for (String str3 : split) {
                    String[] split2 = str3.trim().split(" ");
                    if (split2.length > 1 && lowerCase.equals(split2[1].toLowerCase())) {
                        arrayList.add(split2[0]);
                    }
                }
            }
            return arrayList;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("db", 2, "analyseTableField exception: ", e16);
            }
            return new ArrayList<>();
        }
    }

    public static void beginTransactionLog() {
        MqqInjectorManager.instance().isDebugVersion();
    }

    private void buildTableNameCache() {
        if (!this.tableNameCache.isInit) {
            try {
                this.tableNameCache.initTableCache(getAllTableNameFromDB());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("db", 2, "buildTableNameCache exception", e16);
                }
            }
        }
    }

    private byte[] convertBlob(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return SecurityUtile.encode(bArr);
        }
        return bArr;
    }

    private ContentValues convertContentValues(String str, ContentValues contentValues) {
        if (contentValues != null && contentValues.size() > 0) {
            ContentValues contentValues2 = new ContentValues(contentValues);
            ArrayList<String> tableInfo = getTableInfo(str);
            if (tableInfo != null) {
                Iterator<String> it = tableInfo.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (contentValues.containsKey(next)) {
                        Object obj = contentValues.get(next);
                        if (obj instanceof String) {
                            String str2 = (String) contentValues.get(next);
                            if (str2 != null && str2.length() > 0) {
                                contentValues2.put(next, convertStr(str2));
                            }
                        } else if (obj instanceof byte[]) {
                            contentValues2.put(next, convertBlob((byte[]) obj));
                        }
                    }
                }
            }
            return contentValues2;
        }
        return contentValues;
    }

    private String convertStr(Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        if (obj2.length() > 0) {
            return SecurityUtile.encode(obj2);
        }
        return obj2;
    }

    private void convertWhereValues(String str, String str2, String[] strArr) {
        ArrayList<String> tableInfo;
        if (str2 != null && strArr != null && (tableInfo = getTableInfo(str)) != null) {
            ArrayList<String> analyseRawQueryWhere = analyseRawQueryWhere(str2);
            for (int i3 = 0; i3 < analyseRawQueryWhere.size(); i3++) {
                if (tableInfo.contains(analyseRawQueryWhere.get(i3))) {
                    String str3 = strArr[i3];
                    if (str3 instanceof String) {
                        strArr[i3] = convertStr(str3);
                    }
                }
            }
        }
    }

    private static int countDuplicates(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        int length = stackTraceElementArr2.length;
        int length2 = stackTraceElementArr.length;
        int i3 = 0;
        while (true) {
            length2--;
            if (length2 < 0 || length - 1 < 0 || !stackTraceElementArr2[length].equals(stackTraceElementArr[length2])) {
                break;
            }
            i3++;
        }
        return i3;
    }

    private void detectIllegalMsgDelete(String str, String str2) {
        if (!MqqInjectorManager.instance().isPublicVersion()) {
            boolean z16 = true;
            if (SQLiteFTSUtilsProxy.getFTSNotifyFlag() == 1) {
                if (str == null && str2 == null) {
                    return;
                }
                if ((str != null && str.startsWith("mr_") && str.endsWith("_New")) || (str2 != null && str2.trim().toLowerCase().startsWith("delete") && str2.contains("mr_") && str2.contains("_New"))) {
                    StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= stackTrace.length) {
                            break;
                        }
                        if (stackTrace[i3].getClassName().endsWith("ProxyManager")) {
                            z16 = false;
                            break;
                        }
                        i3++;
                    }
                    if (z16) {
                        QLog.w("db", 2, "detect illegal message delete\uff0cplease use MsgProxy.delete()");
                        new Handler(BaseApplication.getContext().getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.app.SQLiteDatabase.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SQLiteDatabase.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                } else {
                                    Toast.makeText(BaseApplication.getContext(), "detect illegal message delete", 1).show();
                                    ((Vibrator) BaseApplication.getContext().getSystemService("vibrator")).vibrate(new long[]{100, 400, 100, 400}, -1);
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private void doHandleDBErr(Throwable th5, String str) {
        if (th5.getMessage() != null && !th5.getMessage().contains("no such table")) {
            QLog.e(DBTRANSLOG, 1, th5.getMessage());
            StringBuilder sb5 = new StringBuilder();
            try {
                printDBErrStackTrace(th5, sb5, "", null, 0);
            } catch (Exception unused) {
            }
            QLog.e(DBTRANSLOG, 1, sb5);
        }
        printDBErrForBusiness(th5, str);
        if (MqqInjectorManager.instance().isDebugVersion() && th5.getMessage() != null && !th5.getMessage().contains("no such table")) {
            if (!dbError_toastTimeInited) {
                dbError_lastToastTime = BaseApplication.getContext().getSharedPreferences("dbError", 0).getLong("lastToastTime", 0L);
                dbError_toastTimeInited = true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - dbError_lastCheckTime > DB_ERROR_CHECK_INTERNAL) {
                dbError_count = 0;
            } else {
                dbError_count++;
            }
            dbError_lastCheckTime = currentTimeMillis;
            if (dbError_count > 10) {
                dbError_count = 0;
                QLog.e("db", 1, "handleDBErr, find multi db error");
                if (currentTimeMillis - dbError_lastToastTime > 21600000) {
                    dbError_lastToastTime = currentTimeMillis;
                    BaseApplication.getContext().getSharedPreferences("dbError", 0).edit().putLong("lastToastTime", dbError_lastToastTime).apply();
                    if (QLog.isColorLevel()) {
                        QLog.e(DBTRANSLOG, 2, "show db error toast");
                    }
                    new Handler(BaseApplication.getContext().getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.app.SQLiteDatabase.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SQLiteDatabase.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            Toast.makeText(BaseApplication.getContext(), SQLiteDatabase.TOAST_PROCESS + BaseApplication.processName + SQLiteDatabase.TOAST_DB_CORRUPTION, 1).show();
                        }
                    });
                }
            }
        }
    }

    public static void endTransactionLog() {
        MqqInjectorManager.instance().isDebugVersion();
    }

    public static Map<String, DbHistory> getCursorTrace() {
        return null;
    }

    private ArrayList<String> getTableInfo(String str) {
        Cursor rawQuery;
        if (!this.tableMap.containsKey(str) && (rawQuery = rawQuery(SQL_GET_TABLE_ATTR, new String[]{"table", str})) != null) {
            if (rawQuery.moveToFirst()) {
                this.tableMap.put(str, analyseTableField(SecurityUtile.decode(rawQuery.getString(0)), new String[]{"TEXT", "BLOB"}));
            }
            rawQuery.close();
        }
        return this.tableMap.get(str);
    }

    private void handleDBErr(Throwable th5, String str) {
        boolean z16;
        if (System.currentTimeMillis() - EntityManagerFactory.corruptedTime < 100) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((th5 instanceof SQLiteDatabaseCorruptException) || z16) {
            QLog.e(DBTRANSLOG, 1, str + " " + z16);
            EntityManagerFactory.corruptedTime = -1L;
        }
        doHandleDBErr(th5, str);
    }

    public static void loadIsLogcatDBOperation() {
        sIsLogcatDBOperation = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("isLogcatDBOperation", false);
    }

    private void logAbnormalDBOperate(String str, String str2, long j3, int i3) {
        Throwable th5 = new Throwable();
        if (TextUtils.isEmpty(str)) {
            QLog.e(DBTRANSLOG, 1, "abnormal dbOperate sql: " + str2 + ", cost: " + j3 + "ms, count: " + i3 + ", ", th5);
            return;
        }
        ThreadManagerV2.excute(new Runnable(str, j3, i3, th5) { // from class: com.tencent.mobileqq.app.SQLiteDatabase.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f195029d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f195030e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f195031f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ Throwable f195032h;

            {
                this.f195029d = str;
                this.f195030e = j3;
                this.f195031f = i3;
                this.f195032h = th5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SQLiteDatabase.this, str, Long.valueOf(j3), Integer.valueOf(i3), th5);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    QLog.e(SQLiteDatabase.DBTRANSLOG, 1, "abnormal dbOperate table: " + this.f195029d + ", dataCnt: " + SQLiteDatabase.this.getCount(this.f195029d) + ", cost: " + this.f195030e + "ms, count: " + this.f195031f + ", ", this.f195032h);
                } catch (Exception unused) {
                    QLog.e(SQLiteDatabase.DBTRANSLOG, 1, "abnormal dbOperate table: " + this.f195029d + ", cost: " + this.f195030e + "ms, count: " + this.f195031f + ", ", this.f195032h);
                }
            }
        }, 32, null, true);
    }

    private static void logcatSQLiteProfiler(String str, String str2, String str3, Object[] objArr, long j3) {
        boolean z16;
        if (validToLog() && QLog.isColorLevel()) {
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            if (currentThread == Looper.getMainLooper().getThread()) {
                z16 = true;
            } else {
                z16 = false;
            }
            StringBuilder sb5 = new StringBuilder(512);
            sb5.append("TableName:");
            sb5.append(str2);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append("ExecuteType:");
            sb5.append(str);
            sb5.append("|");
            sb5.append("CurrentThreadName:");
            sb5.append(name);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append("IsMainThread:");
            sb5.append(z16);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append("Cost:");
            sb5.append(j3);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append("CMD:");
            sb5.append(str3);
            if (objArr != null) {
                for (Object obj : objArr) {
                    if (obj == null) {
                        sb5.append("null,");
                    } else {
                        sb5.append(obj.toString());
                        sb5.append(',');
                    }
                }
            }
            String sb6 = sb5.toString();
            RuntimeException runtimeException = new RuntimeException("table change ");
            runtimeException.fillInStackTrace();
            if (z16) {
                if (sIsLogcatDBOperation) {
                    QLog.d(TAG_SQLITE_DB, 1, "isMainThread = true, " + sb6 + ", StackTrace = ", runtimeException);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG_SQLITE_DB, 2, "isMainThread = true, " + sb6, runtimeException);
                    return;
                }
                return;
            }
            if (sIsLogcatDBOperation) {
                QLog.d(TAG_SQLITE_DB, 1, sb6 + ", StackTrace = ", runtimeException);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG_SQLITE_DB, 2, sb6);
            }
        }
    }

    private void printDBErrForBusiness(Throwable th5, String str) {
        if (!TextUtils.isEmpty(str) && str.contains("GuildTaskProgressState")) {
            try {
                QLog.e(DBTRANSLOG, 1, str);
                QLog.e(DBTRANSLOG, 1, QLog.getStackTraceString(th5));
            } catch (Exception e16) {
                QLog.e(DBTRANSLOG, 1, "printDBErrForBusiness: " + str + ", exception: " + e16.getMessage());
            }
        }
    }

    private void printDBErrStackTrace(Throwable th5, StringBuilder sb5, String str, StackTraceElement[] stackTraceElementArr, int i3) throws IOException {
        int i16;
        if (sb5 == null) {
            sb5 = new StringBuilder();
        }
        StringBuilder sb6 = sb5;
        sb6.append(th5.toString());
        sb6.append("\n");
        StackTraceElement[] stackTrace = th5.getStackTrace();
        if (stackTrace != null) {
            if (stackTraceElementArr != null) {
                i16 = countDuplicates(stackTrace, stackTraceElementArr);
            } else {
                i16 = 0;
            }
            for (int i17 = 0; i17 < stackTrace.length - i16; i17++) {
                if (i17 < 3) {
                    sb6.append(str);
                    sb6.append("\tat ");
                    sb6.append(stackTrace[i17].toString());
                    sb6.append("\n");
                } else if (i17 == (stackTrace.length - i16) - 1) {
                    sb6.append(str);
                    sb6.append("\t...at ");
                    sb6.append(stackTrace[i17].toString());
                    sb6.append("\n");
                }
            }
            if (i16 > 0) {
                sb6.append(str);
                sb6.append("\t... ");
                sb6.append(Integer.toString(i16));
                sb6.append(" more\n");
            }
        }
        if (th5.getCause() != null && i3 < 5) {
            sb6.append(str);
            sb6.append("Caused by: ");
            printDBErrStackTrace(th5, sb6, str, stackTrace, i3 + 1);
        }
    }

    /* JADX WARN: Finally extract failed */
    private Cursor query(boolean z16, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        String str7;
        String str8;
        String str9;
        Cursor cursor;
        Cursor cursor2;
        long uptimeMillis = SystemClock.uptimeMillis();
        Cursor cursor3 = null;
        try {
            String buildQueryString = SQLiteQueryBuilder.buildQueryString(false, str, strArr, str2, str3, str4, str5, str6);
            convertWhereValues(str, str2, strArr2);
            this.mDBThreadMonitor.addCompetitionThread();
            Cursor query = this.f195028db.query(false, str, strArr, str2, strArr2, str3, str4, str5, str6);
            try {
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                this.mDBThreadMonitor.finishThread();
                int count = query.getCount();
                str7 = "query";
                cursor2 = query;
                str8 = str2;
                str9 = str;
                try {
                    reportAbnormalDBOperateCost(str, buildQueryString, uptimeMillis2, count, "query");
                    if (sIsLogcatDBOperation || AIOUtilsProxy.getLogcatDBOperation()) {
                        StringBuilder sb5 = new StringBuilder(32);
                        sb5.append(strArr);
                        sb5.append(";");
                        sb5.append(str8);
                        sb5.append(";");
                        if (strArr2 != null) {
                            for (String str10 : strArr2) {
                                sb5.append(str10);
                            }
                        }
                        sb5.append(";");
                        sb5.append(str3);
                        sb5.append(";");
                        sb5.append(str4);
                        sb5.append(";");
                        sb5.append(str5);
                        sb5.append(";");
                        sb5.append(str6);
                        logcatSQLiteProfiler("query", str, sb5.toString(), null, uptimeMillis2);
                    }
                    reportDbOperatorResult(str7, str9, 0);
                    this.mDBThreadMonitor.finishThread();
                    cursor = cursor2;
                } catch (Throwable th5) {
                    th = th5;
                    cursor3 = cursor2;
                    try {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("SELECT * FROM ");
                        sb6.append(str9);
                        if (!TextUtils.isEmpty(str2)) {
                            sb6.append(" WHERE ");
                            sb6.append(str8);
                        }
                        reportDbOperatorResult(str7, str9, 1);
                        handleDBErr(th, sb6.toString());
                        this.mDBThreadMonitor.finishThread();
                        cursor = cursor3;
                        MsgAutoMonitorUtil.getInstance().addDbIoTime(SystemClock.uptimeMillis() - uptimeMillis);
                        return cursor;
                    } catch (Throwable th6) {
                        this.mDBThreadMonitor.finishThread();
                        throw th6;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                str7 = "query";
                str9 = str;
                cursor2 = query;
                str8 = str2;
            }
        } catch (Throwable th8) {
            th = th8;
            str7 = "query";
            str8 = str2;
            str9 = str;
        }
        MsgAutoMonitorUtil.getInstance().addDbIoTime(SystemClock.uptimeMillis() - uptimeMillis);
        return cursor;
    }

    private void reportAbnormalDBOperateCost(String str, String str2, long j3, int i3, String str3) {
        if (j3 > 10000) {
            logAbnormalDBOperate(str, str2, j3, i3);
        }
        DBMonitorReportHelper.reportMarketDBCost(j3, i3, str3, this.mName);
        if (j3 <= ((IDBMonitorService) QRoute.api(IDBMonitorService.class)).getOperateCostReportedThreshold()) {
            return;
        }
        DBMonitorReportHelper.reportDBOperateCost(str, str2, j3, i3, str3, this.mName);
    }

    private void reportDbOperatorResult(String str, String str2, int i3) {
        boolean z16;
        if (!this.mUinNeedReport) {
            return;
        }
        this.mOpCount++;
        if ("insert".equals(str)) {
            if (this.mOpCount % 100 != 0) {
                return;
            }
        } else if (this.mOpCount % 500 != 0) {
            return;
        }
        HashMap hashMap = new HashMap(4);
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        hashMap.put(REPORT_TAG_OP_TYPE, str);
        hashMap.put(REPORT_TAG_OP_TABLE_NAME, str2);
        hashMap.put("param_FailCode", Integer.toString(i3));
        String str3 = "DatabaseOperatorResult_" + str;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        StatisticCollectorProxy.collectPerformance("", str3, z16, 0L, 0L, hashMap, null);
    }

    public static void saveIsLogcatDBOperation(boolean z16) {
        if (sIsLogcatDBOperation ^ z16) {
            sIsLogcatDBOperation = z16;
            SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit();
            edit.putBoolean("isLogcatDBOperation", z16);
            edit.commit();
        }
    }

    private static boolean validToLog() {
        if (SystemClock.uptimeMillis() - sTimeBegin > 1000) {
            sLogCount = 0L;
            sTimeBegin = SystemClock.uptimeMillis();
        }
        long j3 = sLogCount;
        if (j3 >= 20) {
            return false;
        }
        sLogCount = j3 + 1;
        return true;
    }

    public void addToTableCache(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        } else {
            this.tableNameCache.addToTableNameCache(str);
        }
    }

    public void beginTransaction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            beginTransactionLog();
            this.f195028db.beginTransaction();
        } catch (Throwable th5) {
            handleDBErr(th5, "beginTransaction");
        }
        MsgAutoMonitorUtil.getInstance().addDbIoTime(SystemClock.uptimeMillis() - uptimeMillis);
        MsgAutoMonitorUtil.getInstance().addDbIoTransaction(1L);
    }

    @TargetApi(11)
    public void beginTransactionNonExclusive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            beginTransactionLog();
            this.f195028db.beginTransactionNonExclusive();
        } catch (Throwable th5) {
            handleDBErr(th5, "beginTransactionNonExclusive");
        }
        MsgAutoMonitorUtil.getInstance().addDbIoTime(SystemClock.uptimeMillis() - uptimeMillis);
        MsgAutoMonitorUtil.getInstance().addDbIoTransaction(1L);
    }

    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            QLog.e("db", 1, "SQLiteDatabase close");
            this.f195028db.close();
        } catch (Throwable th5) {
            handleDBErr(th5, "close");
        }
        MsgAutoMonitorUtil.getInstance().addDbIoTime(SystemClock.uptimeMillis() - uptimeMillis);
    }

    public boolean containsTable(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) str)).booleanValue();
        }
        buildTableNameCache();
        return this.tableNameCache.isContainsTableInCache(str);
    }

    public int count(String str, String str2, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, this, str, str2, strArr)).intValue();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        String str3 = "select count(*) from " + str;
        if (str2 != null && strArr != null) {
            convertWhereValues(str, str2, strArr);
            str3 = str3 + " where " + str2;
        }
        Cursor rawQuery = rawQuery(str3, strArr);
        int i3 = 0;
        if (rawQuery != null) {
            rawQuery.moveToFirst();
            i3 = rawQuery.getInt(0);
            rawQuery.close();
        }
        MsgAutoMonitorUtil.getInstance().addDbIoTime(SystemClock.uptimeMillis() - uptimeMillis);
        return i3;
    }

    public int delete(String str, String str2, String[] strArr) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, str, str2, strArr)).intValue();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            String a16 = dy.a(str, str2, strArr);
            detectIllegalMsgDelete(str, null);
            convertWhereValues(str, str2, strArr);
            this.mDBThreadMonitor.addCompetitionThread();
            int delete = this.f195028db.delete(str, str2, strArr);
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            this.mDBThreadMonitor.finishThread();
            reportAbnormalDBOperateCost(str, a16, uptimeMillis2, delete, "delete");
            if (sIsLogcatDBOperation || AIOUtilsProxy.getLogcatDBOperation()) {
                logcatSQLiteProfiler("delete", str, str2 + ";", strArr, uptimeMillis2);
            }
            MsgAutoMonitorUtil.getInstance().addDbIoTime(uptimeMillis2);
            reportDbOperatorResult("delete", str, 0);
            return delete;
        } catch (Throwable th5) {
            try {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("DELETE FROM ");
                sb5.append(str);
                if (!TextUtils.isEmpty(str2)) {
                    str3 = " WHERE " + str2;
                } else {
                    str3 = "";
                }
                sb5.append(str3);
                handleDBErr(th5, sb5.toString());
                reportDbOperatorResult("delete", str, 1);
                this.mDBThreadMonitor.finishThread();
                MsgAutoMonitorUtil.getInstance().addDbIoTime(SystemClock.uptimeMillis() - uptimeMillis);
                return -1;
            } finally {
                this.mDBThreadMonitor.finishThread();
            }
        }
    }

    public void endTransaction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            this.f195028db.endTransaction();
            endTransactionLog();
        } catch (Throwable th5) {
            handleDBErr(th5, "endTransaction");
        }
        MsgAutoMonitorUtil.getInstance().addDbIoTime(SystemClock.uptimeMillis() - uptimeMillis);
    }

    /* JADX WARN: Finally extract failed */
    public boolean execSQL(String str, Object[] objArr) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) objArr)).booleanValue();
        }
        int i3 = 0;
        while (true) {
            try {
                if (i3 >= objArr.length) {
                    str2 = null;
                    break;
                }
                Object obj = objArr[i3];
                if (obj instanceof String) {
                    str2 = (String) obj;
                    if (str2.startsWith("mr_") && str2.endsWith("_New")) {
                        break;
                    }
                }
                i3++;
            } catch (Throwable th5) {
                try {
                    handleDBErr(th5, str);
                    this.mDBThreadMonitor.finishThread();
                    return false;
                } catch (Throwable th6) {
                    this.mDBThreadMonitor.finishThread();
                    throw th6;
                }
            }
        }
        detectIllegalMsgDelete(str2, str);
        this.mDBThreadMonitor.addCompetitionThread();
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f195028db.execSQL(str, objArr);
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        this.mDBThreadMonitor.finishThread();
        reportAbnormalDBOperateCost("", str + " bindArgs " + Arrays.toString(objArr), uptimeMillis2, 0, OPERATE_TYPE_EXEC_SQL);
        if (sIsLogcatDBOperation || AIOUtilsProxy.getLogcatDBOperation()) {
            logcatSQLiteProfiler(OPERATE_TYPE_EXEC_SQL, "", str, objArr, uptimeMillis2);
        }
        MsgAutoMonitorUtil.getInstance().addDbIoTime(uptimeMillis2);
        this.mDBThreadMonitor.finishThread();
        return true;
    }

    public String[] getAllTableNameFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String[]) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        buildTableNameCache();
        return this.tableNameCache.getAllTableNames();
    }

    public String[] getAllTableNameFromDB() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String[]) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            String[] strArr = null;
            if (this.f195028db != null) {
                this.mDBThreadMonitor.addCompetitionThread();
                Cursor rawQuery = this.f195028db.rawQuery("select distinct tbl_name from Sqlite_master", null);
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                if (rawQuery != null) {
                    i3 = rawQuery.getCount();
                } else {
                    i3 = 0;
                }
                reportAbnormalDBOperateCost("", "select distinct tbl_name from Sqlite_master", uptimeMillis2, i3, OPERATE_TYPE_RAW_QUERY);
                this.mDBThreadMonitor.finishThread();
                if (rawQuery != null && rawQuery.moveToFirst()) {
                    String[] strArr2 = new String[rawQuery.getCount()];
                    int i16 = 0;
                    while (true) {
                        int i17 = i16 + 1;
                        strArr2[i16] = SecurityUtile.decode(rawQuery.getString(0));
                        if (!rawQuery.moveToNext()) {
                            break;
                        }
                        i16 = i17;
                    }
                    strArr = strArr2;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                MsgAutoMonitorUtil.getInstance().addDbIoTime(SystemClock.uptimeMillis() - uptimeMillis);
            }
            return strArr;
        } finally {
            this.mDBThreadMonitor.finishThread();
        }
    }

    public int getCount(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str)).intValue();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        Cursor rawQuery = rawQuery("select count() from " + str, null);
        int i3 = 0;
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToFirst()) {
                    i3 = rawQuery.getInt(0);
                }
            } catch (Throwable th5) {
                handleDBErr(th5, "select count() from " + str);
            }
            rawQuery.close();
        }
        MsgAutoMonitorUtil.getInstance().addDbIoTime(SystemClock.uptimeMillis() - uptimeMillis);
        return i3;
    }

    public long insert(String str, String str2, ContentValues contentValues) {
        ContentValues contentValues2;
        int size;
        String b16;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, this, str, str2, contentValues)).longValue();
        }
        try {
            b16 = dy.b(str, contentValues);
            contentValues2 = convertContentValues(str, contentValues);
        } catch (Throwable th5) {
            th = th5;
            contentValues2 = contentValues;
        }
        try {
            this.mDBThreadMonitor.addCompetitionThread();
            long uptimeMillis = SystemClock.uptimeMillis();
            long insert = this.f195028db.insert(str, str2, contentValues2);
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            this.mDBThreadMonitor.finishThread();
            if (insert > -1) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            reportAbnormalDBOperateCost(str, b16, uptimeMillis2, i3, "insert");
            if (sIsLogcatDBOperation || AIOUtilsProxy.getLogcatDBOperation()) {
                logcatSQLiteProfiler("insert", str, str2 + ";" + contentValues2, null, uptimeMillis2);
            }
            MsgAutoMonitorUtil.getInstance().addDbIoTime(uptimeMillis2);
            if (insert > -1) {
                i16 = 0;
            } else {
                i16 = 1;
            }
            reportDbOperatorResult("insert", str, i16);
            this.mDBThreadMonitor.finishThread();
            return insert;
        } catch (Throwable th6) {
            th = th6;
            if (contentValues2 != null) {
                try {
                    if (contentValues2.size() > 0) {
                        size = contentValues2.size();
                        handleDBErr(th, String.format("INSERT INTO %s, %d", str, Integer.valueOf(size)));
                        reportDbOperatorResult("insert", str, 1);
                        this.mDBThreadMonitor.finishThread();
                        return -1L;
                    }
                } catch (Throwable th7) {
                    this.mDBThreadMonitor.finishThread();
                    throw th7;
                }
            }
            size = 0;
            handleDBErr(th, String.format("INSERT INTO %s, %d", str, Integer.valueOf(size)));
            reportDbOperatorResult("insert", str, 1);
            this.mDBThreadMonitor.finishThread();
            return -1L;
        }
    }

    public Cursor rawQuery(String str, String str2, String str3, String[] strArr) {
        Cursor cursor;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Cursor) iPatchRedirector.redirect((short) 11, this, str, str2, str3, strArr);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        Cursor cursor2 = null;
        try {
            str4 = str + " selectionArgs " + Arrays.toString(strArr);
            convertWhereValues(str2, str3, strArr);
            this.mDBThreadMonitor.addCompetitionThread();
            cursor = this.f195028db.rawQuery(str, strArr);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            this.mDBThreadMonitor.finishThread();
            reportAbnormalDBOperateCost(str2, str4, uptimeMillis2, cursor.getCount(), OPERATE_TYPE_RAW_QUERY);
            if (sIsLogcatDBOperation || AIOUtilsProxy.getLogcatDBOperation()) {
                logcatSQLiteProfiler(OPERATE_TYPE_RAW_QUERY, str2, str + ";" + str3, strArr, uptimeMillis2);
            }
        } catch (Throwable th6) {
            th = th6;
            cursor2 = cursor;
            try {
                handleDBErr(th, str);
                this.mDBThreadMonitor.finishThread();
                cursor = cursor2;
                MsgAutoMonitorUtil.getInstance().addDbIoTime(SystemClock.uptimeMillis() - uptimeMillis);
                return cursor;
            } finally {
                this.mDBThreadMonitor.finishThread();
            }
        }
        MsgAutoMonitorUtil.getInstance().addDbIoTime(SystemClock.uptimeMillis() - uptimeMillis);
        return cursor;
    }

    public void removeFromTableCache(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        } else {
            this.tableNameCache.deleteFromTableCache(str);
        }
    }

    public long replace(String str, String str2, ContentValues contentValues) {
        ContentValues contentValues2;
        int size;
        String c16;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, this, str, str2, contentValues)).longValue();
        }
        try {
            c16 = dy.c(str, contentValues, str2);
            contentValues2 = convertContentValues(str, contentValues);
        } catch (Throwable th5) {
            th = th5;
            contentValues2 = contentValues;
        }
        try {
            this.mDBThreadMonitor.addCompetitionThread();
            long uptimeMillis = SystemClock.uptimeMillis();
            long replace = this.f195028db.replace(str, str2, contentValues2);
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            this.mDBThreadMonitor.finishThread();
            if (replace > -1) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            reportAbnormalDBOperateCost(str, c16, uptimeMillis2, i3, OPERATE_TYPE_REPLACE);
            if (sIsLogcatDBOperation || AIOUtilsProxy.getLogcatDBOperation()) {
                logcatSQLiteProfiler(OPERATE_TYPE_REPLACE, str, str2 + ";" + contentValues2, null, uptimeMillis2);
            }
            MsgAutoMonitorUtil.getInstance().addDbIoTime(uptimeMillis2);
            if (replace > -1) {
                i16 = 0;
            } else {
                i16 = 1;
            }
            reportDbOperatorResult(OPERATE_TYPE_REPLACE, str, i16);
            this.mDBThreadMonitor.finishThread();
            return replace;
        } catch (Throwable th6) {
            th = th6;
            if (contentValues2 != null) {
                try {
                    if (contentValues2.size() > 0) {
                        size = contentValues2.size();
                        handleDBErr(th, String.format("replace, INSERT INTO %s, %d", str, Integer.valueOf(size)));
                        reportDbOperatorResult(OPERATE_TYPE_REPLACE, str, 1);
                        this.mDBThreadMonitor.finishThread();
                        return -1L;
                    }
                } catch (Throwable th7) {
                    this.mDBThreadMonitor.finishThread();
                    throw th7;
                }
            }
            size = 0;
            handleDBErr(th, String.format("replace, INSERT INTO %s, %d", str, Integer.valueOf(size)));
            reportDbOperatorResult(OPERATE_TYPE_REPLACE, str, 1);
            this.mDBThreadMonitor.finishThread();
            return -1L;
        }
    }

    public void setLockingEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f195028db.setLockingEnabled(z16);
        } catch (Throwable th5) {
            handleDBErr(th5, "setLockingEnabled");
        }
        MsgAutoMonitorUtil.getInstance().addDbIoTime(System.currentTimeMillis() - currentTimeMillis);
    }

    public void setTransactionSuccessful() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            this.f195028db.setTransactionSuccessful();
        } catch (Throwable th5) {
            handleDBErr(th5, "setTransactionSuccessful");
        }
        MsgAutoMonitorUtil.getInstance().addDbIoTime(SystemClock.uptimeMillis() - uptimeMillis);
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        ContentValues contentValues2;
        int size;
        String d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, this, str, contentValues, str2, strArr)).intValue();
        }
        try {
            d16 = dy.d(str, contentValues, strArr, str2);
            contentValues2 = convertContentValues(str, contentValues);
        } catch (Throwable th5) {
            th = th5;
            contentValues2 = contentValues;
        }
        try {
            convertWhereValues(str, str2, strArr);
            this.mDBThreadMonitor.addCompetitionThread();
            long uptimeMillis = SystemClock.uptimeMillis();
            int update = this.f195028db.update(str, contentValues2, str2, strArr);
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            this.mDBThreadMonitor.finishThread();
            reportAbnormalDBOperateCost(str, d16, uptimeMillis2, update, "update");
            if (sIsLogcatDBOperation || AIOUtilsProxy.getLogcatDBOperation()) {
                logcatSQLiteProfiler("update", str, contentValues2 + ";" + str2, strArr, uptimeMillis2);
            }
            MsgAutoMonitorUtil.getInstance().addDbIoTime(uptimeMillis2);
            this.mDBThreadMonitor.finishThread();
            return update;
        } catch (Throwable th6) {
            th = th6;
            if (contentValues2 != null) {
                try {
                    if (contentValues2.size() > 0) {
                        size = contentValues2.size();
                        handleDBErr(th, String.format("UPDATE %s, %d", str, Integer.valueOf(size)));
                        this.mDBThreadMonitor.finishThread();
                        return -1;
                    }
                } catch (Throwable th7) {
                    this.mDBThreadMonitor.finishThread();
                    throw th7;
                }
            }
            size = 0;
            handleDBErr(th, String.format("UPDATE %s, %d", str, Integer.valueOf(size)));
            this.mDBThreadMonitor.finishThread();
            return -1;
        }
    }

    public int getCount(String str, long j3, long j16, int i3, int i16) {
        int i17;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, this, str, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        String str3 = "select count() from " + str;
        if (j3 >= 0) {
            str2 = String.format(" where time >= %d and time <= %d ", Long.valueOf(j3), Long.valueOf(j16));
            i17 = i16;
        } else {
            i17 = i16;
            str2 = null;
        }
        if (i3 == i17) {
            if (str2 != null) {
                str2 = str2 + " and msgtype = " + i3;
            } else {
                str2 = " where msgtype = " + i3;
            }
        }
        if (str2 != null) {
            str3 = str3 + str2;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("msgbackup_sqliteDB", 4, " getCount sql = " + str3);
        }
        Cursor rawQuery = rawQuery(str3, null);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToFirst()) {
                    i18 = rawQuery.getInt(0);
                }
            } catch (Throwable th5) {
                handleDBErr(th5, "select count() from " + str);
            }
            rawQuery.close();
        }
        MsgAutoMonitorUtil.getInstance().addDbIoTime(SystemClock.uptimeMillis() - uptimeMillis);
        return i18;
    }

    @Deprecated
    public Cursor rawQuery(String str, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Cursor) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) strArr);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        Cursor cursor = null;
        try {
            this.mDBThreadMonitor.addCompetitionThread();
            cursor = this.f195028db.rawQuery(str, strArr);
            reportAbnormalDBOperateCost("", str + " selectionArgs " + Arrays.toString(strArr), SystemClock.uptimeMillis() - uptimeMillis, cursor.getCount(), OPERATE_TYPE_RAW_QUERY);
            this.mDBThreadMonitor.finishThread();
        } finally {
            try {
                return cursor;
            } finally {
            }
        }
        return cursor;
    }

    /* JADX WARN: Finally extract failed */
    public boolean execSQL(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        try {
            detectIllegalMsgDelete(null, str);
            this.mDBThreadMonitor.addCompetitionThread();
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f195028db.execSQL(str);
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            this.mDBThreadMonitor.finishThread();
            reportAbnormalDBOperateCost("", str, uptimeMillis2, 0, OPERATE_TYPE_EXEC_SQL);
            if (sIsLogcatDBOperation || AIOUtilsProxy.getLogcatDBOperation()) {
                logcatSQLiteProfiler(OPERATE_TYPE_EXEC_SQL, "", str, null, uptimeMillis2);
            }
            MsgAutoMonitorUtil.getInstance().addDbIoTime(uptimeMillis2);
            this.mDBThreadMonitor.finishThread();
            return true;
        } catch (Throwable th5) {
            try {
                handleDBErr(th5, str);
                this.mDBThreadMonitor.finishThread();
                return false;
            } catch (Throwable th6) {
                this.mDBThreadMonitor.finishThread();
                throw th6;
            }
        }
    }

    public Cursor query(String str, String str2, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? query(false, str, null, str2, strArr, null, null, null, null) : (Cursor) iPatchRedirector.redirect((short) 9, this, str, str2, strArr);
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? query(false, str, strArr, str2, strArr2, null, null, str3, str4) : (Cursor) iPatchRedirector.redirect((short) 10, this, str, strArr, str2, strArr2, str3, str4);
    }
}
