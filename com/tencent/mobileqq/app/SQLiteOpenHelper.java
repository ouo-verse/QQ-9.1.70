package com.tencent.mobileqq.app;

import com.tencent.mobileqq.imcore.proxy.basic.StatisticCollectorProxy;
import com.tencent.mobileqq.persistence.ISQLiteOpenHelper;
import com.tencent.mobileqq.persistence.TableNameCache;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class SQLiteOpenHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String REPORT_WAL_EXCEPTION = "actWALException";
    private static final String REPORT_WAL_READ_EXCEPTION_KEY = "ReadWALException";
    private static final String REPORT_WAL_WRITE_EXCEPTION_KEY = "WriteWALException";
    public static final String TAG = "SQLiteOpenHelper";
    public static boolean WAL_ENABLE;
    private static boolean sTryWalException;
    private SQLiteDatabase dbR;
    private SQLiteDatabase dbW;
    private ISQLiteOpenHelper helper;
    private TableNameCache tbnCache;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40938);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            WAL_ENABLE = true;
            sTryWalException = false;
        }
    }

    public SQLiteOpenHelper(ISQLiteOpenHelper iSQLiteOpenHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iSQLiteOpenHelper);
            return;
        }
        this.tbnCache = new TableNameCache();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " new SQLiteOpenHelper, db name = ", iSQLiteOpenHelper.getDatabaseName(), ", helper = ", iSQLiteOpenHelper, ", this = ", this);
        }
        this.helper = iSQLiteOpenHelper;
    }

    public synchronized void close() {
        Object obj;
        Object obj2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[8];
            objArr[0] = " close, dbR = : ";
            SQLiteDatabase sQLiteDatabase = this.dbR;
            if (sQLiteDatabase != null) {
                obj = Integer.valueOf(sQLiteDatabase.hashCode());
            } else {
                obj = "null";
            }
            objArr[1] = obj;
            objArr[2] = " dbW = ";
            SQLiteDatabase sQLiteDatabase2 = this.dbW;
            if (sQLiteDatabase2 != null) {
                obj2 = Integer.valueOf(sQLiteDatabase2.hashCode());
            } else {
                obj2 = "null";
            }
            objArr[3] = obj2;
            objArr[4] = " helper = ";
            objArr[5] = this.helper;
            objArr[6] = " this = ";
            objArr[7] = this;
            QLog.d(TAG, 2, objArr);
        }
        this.helper.close();
    }

    public synchronized SQLiteDatabase getReadableDatabase() {
        Object obj;
        Object obj2;
        Object obj3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        try {
            android.database.sqlite.SQLiteDatabase readableDatabase = this.helper.getReadableDatabase();
            if (WAL_ENABLE && readableDatabase != null && !sTryWalException) {
                try {
                    readableDatabase.enableWriteAheadLogging();
                } catch (IllegalStateException e16) {
                    QLog.e(TAG, 1, "try WAL enalbe exception ", e16, " helper = ", this.helper, " this = ", this);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 1, " try WAL enalbe exception, db name = ", this.helper.getDatabaseName());
                    }
                    sTryWalException = true;
                    HashMap hashMap = new HashMap();
                    hashMap.put(REPORT_WAL_READ_EXCEPTION_KEY, "1");
                    StatisticCollectorProxy.collectPerformance(null, REPORT_WAL_EXCEPTION, true, 0L, 0L, hashMap, null);
                }
            }
            if (readableDatabase == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 1, "rdbIsNull, ", Integer.valueOf(this.helper.hashCode()), new Exception(), " this =", this);
                } else {
                    QLog.e(TAG, 1, "rdbIsNull, ", Integer.valueOf(this.helper.hashCode()), " helper = ", this.helper, " this = ", this);
                }
            }
            SQLiteDatabase sQLiteDatabase = this.dbR;
            if (sQLiteDatabase == null || sQLiteDatabase.f195028db != readableDatabase) {
                Object[] objArr = new Object[4];
                objArr[0] = "check dbRIsNull: ";
                if (sQLiteDatabase != null) {
                    obj2 = Integer.valueOf(sQLiteDatabase.hashCode());
                } else {
                    obj2 = "null";
                }
                objArr[1] = obj2;
                objArr[2] = " dbIsNull: ";
                if (readableDatabase != null) {
                    obj3 = Integer.valueOf(readableDatabase.hashCode());
                } else {
                    obj3 = "null";
                }
                objArr[3] = obj3;
                QLog.d(TAG, 1, objArr);
                SQLiteDatabase sQLiteDatabase2 = new SQLiteDatabase(readableDatabase, this.tbnCache, this.helper.getDatabaseName());
                this.dbR = sQLiteDatabase2;
                QLog.d(TAG, 1, "new dbR = ", Integer.valueOf(sQLiteDatabase2.hashCode()), " helper = ", this.helper, " this = ", this);
            }
        } catch (Exception e17) {
            Object[] objArr2 = new Object[7];
            objArr2[0] = "getReadableDatabase error, ";
            objArr2[1] = "dbR = ";
            SQLiteDatabase sQLiteDatabase3 = this.dbR;
            if (sQLiteDatabase3 != null) {
                obj = Integer.valueOf(sQLiteDatabase3.hashCode());
            } else {
                obj = "null";
            }
            objArr2[2] = obj;
            objArr2[3] = " helper = ";
            objArr2[4] = this.helper;
            objArr2[5] = " this = ";
            objArr2[6] = this;
            QLog.e(TAG, 1, objArr2);
            QLog.e(TAG, 1, "getReadableDatabase", e17);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, " getReadableDatabase error, db name = ", this.helper.getDatabaseName());
            }
            throwDebugException(e17);
        }
        return this.dbR;
    }

    public synchronized SQLiteDatabase getWritableDatabase() {
        Object obj;
        Object obj2;
        Object obj3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = this.helper.getWritableDatabase();
            if (WAL_ENABLE && writableDatabase != null && !sTryWalException) {
                try {
                    writableDatabase.enableWriteAheadLogging();
                } catch (IllegalStateException e16) {
                    QLog.e(TAG, 1, "try WAL enalbe exception ", e16, " helper = ", this.helper, " this = ", this);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 1, " try WAL enalbe exception, db name = ", this.helper.getDatabaseName());
                    }
                    sTryWalException = true;
                    HashMap hashMap = new HashMap();
                    hashMap.put(REPORT_WAL_WRITE_EXCEPTION_KEY, "1");
                    StatisticCollectorProxy.collectPerformance(null, REPORT_WAL_EXCEPTION, true, 0L, 0L, hashMap, null);
                }
            }
            if (writableDatabase == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 1, "wdbIsNull, ", Integer.valueOf(this.helper.hashCode()), new Exception(), " helper = ", this.helper, " this = ", this);
                } else {
                    QLog.e(TAG, 1, "wdbIsNull, ", Integer.valueOf(this.helper.hashCode()), " helper = ", this.helper, " this = ", this);
                }
            }
            SQLiteDatabase sQLiteDatabase = this.dbW;
            if (sQLiteDatabase == null || sQLiteDatabase.f195028db != writableDatabase) {
                Object[] objArr = new Object[4];
                objArr[0] = "check dbWIsNull: ";
                if (sQLiteDatabase != null) {
                    obj2 = Integer.valueOf(sQLiteDatabase.hashCode());
                } else {
                    obj2 = "null";
                }
                objArr[1] = obj2;
                objArr[2] = " dbIsNull: ";
                if (writableDatabase != null) {
                    obj3 = Integer.valueOf(writableDatabase.hashCode());
                } else {
                    obj3 = "null";
                }
                objArr[3] = obj3;
                QLog.d(TAG, 1, objArr);
                SQLiteDatabase sQLiteDatabase2 = new SQLiteDatabase(writableDatabase, this.tbnCache, this.helper.getDatabaseName());
                this.dbW = sQLiteDatabase2;
                QLog.d(TAG, 1, "new dbW = ", Integer.valueOf(sQLiteDatabase2.hashCode()), " helper = ", this.helper, " this = ", this);
            }
        } catch (Exception e17) {
            Object[] objArr2 = new Object[7];
            objArr2[0] = "getWritableDatabase error, ";
            objArr2[1] = "dbW = ";
            SQLiteDatabase sQLiteDatabase3 = this.dbW;
            if (sQLiteDatabase3 != null) {
                obj = Integer.valueOf(sQLiteDatabase3.hashCode());
            } else {
                obj = "null";
            }
            objArr2[2] = obj;
            objArr2[3] = " helper = ";
            objArr2[4] = this.helper;
            objArr2[5] = " this = ";
            objArr2[6] = this;
            QLog.e(TAG, 1, objArr2);
            QLog.e(TAG, 1, "getWritableDatabase", e17);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, " getWritableDatabase error, db name = ", this.helper.getDatabaseName());
            }
            throwDebugException(e17);
        }
        return this.dbW;
    }

    public synchronized void stop() {
        Object obj;
        Object obj2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[8];
            objArr[0] = " stop, dbR = : ";
            SQLiteDatabase sQLiteDatabase = this.dbR;
            if (sQLiteDatabase != null) {
                obj = Integer.valueOf(sQLiteDatabase.hashCode());
            } else {
                obj = "null";
            }
            objArr[1] = obj;
            objArr[2] = " dbW = ";
            SQLiteDatabase sQLiteDatabase2 = this.dbW;
            if (sQLiteDatabase2 != null) {
                obj2 = Integer.valueOf(sQLiteDatabase2.hashCode());
            } else {
                obj2 = "null";
            }
            objArr[3] = obj2;
            objArr[4] = " helper = ";
            objArr[5] = this.helper;
            objArr[6] = " this = ";
            objArr[7] = this;
            QLog.d(TAG, 2, objArr);
        }
        this.helper = null;
    }

    public static final void throwDebugException(Exception exc) {
    }
}
