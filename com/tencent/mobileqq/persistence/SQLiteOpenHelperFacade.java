package com.tencent.mobileqq.persistence;

import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy;
import com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class SQLiteOpenHelperFacade {
    private final String databaseName;
    private SQLiteDatabase dbR;
    private SQLiteDatabase dbW;
    private final ISQLiteOpenHelper mActualHelper;
    private final EntityManagerFactory mEmf;
    private SQLiteDatabase mInnerDb;
    private final String tag;

    public SQLiteOpenHelperFacade(ISQLiteOpenHelper iSQLiteOpenHelper, String str, EntityManagerFactory entityManagerFactory, String str2) {
        this.mActualHelper = iSQLiteOpenHelper;
        this.databaseName = str;
        this.mEmf = entityManagerFactory;
        this.tag = str2;
    }

    private String[] getAllTableName(SQLiteDatabase sQLiteDatabase) {
        String[] strArr;
        Cursor cursor = null;
        r1 = null;
        r1 = null;
        String[] strArr2 = null;
        cursor = null;
        try {
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
                if (rawQuery != null) {
                    try {
                        if (rawQuery.moveToFirst()) {
                            strArr2 = new String[rawQuery.getCount()];
                            int i3 = 0;
                            while (true) {
                                int i16 = i3 + 1;
                                strArr2[i3] = SecurityUtile.decode(rawQuery.getString(0));
                                if (!rawQuery.moveToNext()) {
                                    break;
                                }
                                i3 = i16;
                            }
                        }
                    } catch (Exception e16) {
                        e = e16;
                        String[] strArr3 = strArr2;
                        cursor = rawQuery;
                        strArr = strArr3;
                        QLog.e(this.tag, 1, "getAllTableName", e);
                        SQLiteOpenHelper.throwDebugException(e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return strArr;
                    } catch (Throwable th5) {
                        th = th5;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                    return strArr2;
                }
                return strArr2;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
            strArr = null;
        }
    }

    public static ISQLiteOpenHelper getHelper(EntityManagerFactory entityManagerFactory, String str, int i3) {
        return getHelper(entityManagerFactory, str, i3, null);
    }

    private static boolean isLocalized() {
        return ((ICommonFunctionPublishConfigService) QRoute.api(ICommonFunctionPublishConfigService.class)).isLocalized();
    }

    private void reportDBOpenLocaleError(Exception exc) {
        if (exc instanceof SQLiteException) {
            String message = exc.getMessage();
            if (!TextUtils.isEmpty(message) && message.startsWith("Failed to change locale for db")) {
                CaughtExceptionReportProxy.e(exc, "DB open fail for different locale");
            }
        }
    }

    public void close() {
        QLog.e(this.tag, 1, "SQLiteOpenHelperImpl close");
        try {
            SQLiteDatabase sQLiteDatabase = this.dbR;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                this.dbR.close();
                this.dbR = null;
            }
            SQLiteDatabase sQLiteDatabase2 = this.dbW;
            if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                this.dbW.close();
                this.dbW = null;
            }
        } catch (Exception e16) {
            QLog.e(this.tag, 1, "close", e16);
        }
    }

    public void dropAllTable() {
        dropAllTable(this.mInnerDb);
    }

    public synchronized SQLiteDatabase getReadableDatabase() {
        try {
            this.dbR = this.mActualHelper.getReadableDatabaseInner();
        } catch (Exception e16) {
            QLog.e(this.tag, 1, "getReadableDatabase", e16);
            SQLiteOpenHelper.throwDebugException(e16);
            reportDBOpenLocaleError(e16);
        }
        return this.dbR;
    }

    public synchronized SQLiteDatabase getWritableDatabase() {
        try {
            SQLiteDatabase writableDatabaseInner = this.mActualHelper.getWritableDatabaseInner();
            this.dbW = writableDatabaseInner;
            writableDatabaseInner.setLockingEnabled(false);
        } catch (Exception e16) {
            QLog.e(this.tag, 1, "getWritableDatabase", e16);
            SQLiteOpenHelper.throwDebugException(e16);
            reportDBOpenLocaleError(e16);
        }
        return this.dbW;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        QLog.i(this.tag, 1, "[DB]" + this.databaseName + " onCreate");
        this.mEmf.createDatabase(sQLiteDatabase);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (QLog.isColorLevel()) {
            QLog.i(this.tag, 2, "[DB]" + this.databaseName + " onOpen");
        }
        this.mInnerDb = sQLiteDatabase;
        try {
            sQLiteDatabase.setMaxSqlCacheSize(100);
        } catch (Throwable th5) {
            QLog.d(this.tag, 1, th5.getMessage(), th5);
        }
        this.mEmf.cleanOverDueCorruptDatabase();
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.i(this.tag, 2, "[DB]" + this.databaseName + " onUpgrade oldVersion: " + i3 + " newVersion: " + i16);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mEmf.upgradeDatabase(sQLiteDatabase, i3, i16);
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        long uptimeMillis3 = SystemClock.uptimeMillis();
        EntityManagerFactory entityManagerFactory = this.mEmf;
        entityManagerFactory.checkTableColumnChange(entityManagerFactory.getPackageName(), sQLiteDatabase, i3, i16);
        long uptimeMillis4 = SystemClock.uptimeMillis() - uptimeMillis3;
        long uptimeMillis5 = SystemClock.uptimeMillis();
        this.mEmf.doAfterUpgradeDatabase(sQLiteDatabase, i3, i16);
        long uptimeMillis6 = SystemClock.uptimeMillis() - uptimeMillis5;
        QLog.d(this.tag, 1, "[DB] onUpgrade upgradeCost: " + uptimeMillis2 + ", checkTableColumnChangeCost: " + uptimeMillis4 + ", doAfterUpgradeDatabaseCost: " + uptimeMillis6);
        if (QLog.isColorLevel()) {
            QLog.i(this.tag, 2, "[DB] onUpgrade end");
        }
    }

    private void dropAllTable(SQLiteDatabase sQLiteDatabase) {
        String[] allTableName = getAllTableName(sQLiteDatabase);
        if (allTableName != null) {
            for (String str : allTableName) {
                if (!"android_metadata".equals(str) && !"sqlite_sequence".equals(str)) {
                    try {
                        sQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(str));
                    } catch (SQLiteException e16) {
                        QLog.e(this.tag, 1, "[DB] dropAllTable " + str, e16);
                        SQLiteOpenHelper.throwDebugException(e16);
                    }
                }
            }
        }
        onCreate(sQLiteDatabase);
    }

    public static ISQLiteOpenHelper getHelper(EntityManagerFactory entityManagerFactory, String str, int i3, DatabaseErrorHandler databaseErrorHandler) {
        boolean isLocalized = isLocalized();
        if (QLog.isColorLevel()) {
            QLog.d("SQLiteOpenHelperFacade", 2, "getHelper isLocalized: ", Boolean.valueOf(isLocalized));
        }
        if (isLocalized) {
            return new com.tencent.mobileqq.localizeddb.b(entityManagerFactory, str, entityManagerFactory.tag, i3, databaseErrorHandler);
        }
        return new SQLiteOpenHelperImpl(entityManagerFactory, str, entityManagerFactory.tag, i3, databaseErrorHandler);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
    }
}
