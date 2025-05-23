package com.tencent.mobileqq.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.Ability;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class EntityManagerFactory {
    protected static final String CLOSE_EXCEPTION_MSG = "The EntityManagerFactory has been already closed";
    protected static final int FLAG_CHECK_AUTHENTICATION = -1;
    public static long corruptedTime = -1;
    protected boolean closed;
    protected SQLiteOpenHelper dbHelper;
    protected int mDBVersion;
    protected ISQLiteOpenHelper mInnerDbHelper;
    protected String mName;
    public String name;
    protected String tag;

    public EntityManagerFactory(String str) {
        this.tag = "EntityManagerFactory";
        this.mDBVersion = 0;
        this.dbHelper = build(str);
        this.mName = str;
        this.name = str;
    }

    public static String getSqliteLibraryVersion() {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        try {
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(":memory:", (SQLiteDatabase.CursorFactory) null);
        } catch (Throwable th5) {
            th = th5;
            sQLiteDatabase = null;
        }
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select sqlite_version() AS sqlite_version", null);
            String str = "";
            while (rawQuery.moveToNext()) {
                str = str + rawQuery.getString(0);
            }
            rawQuery.close();
            sQLiteDatabase.close();
            return str;
        } catch (Throwable th6) {
            th = th6;
            try {
                QLog.e(QZoneAppCtrlUploadFileLogic.DB_PATH, 1, "getSqliteLibraryVersion exception", th);
                return "0";
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
    }

    public abstract SQLiteOpenHelper build(String str);

    public void close() {
        if (!this.closed) {
            this.closed = true;
            this.dbHelper.close();
            return;
        }
        throw new IllegalStateException(CLOSE_EXCEPTION_MSG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void createDatabase(SQLiteDatabase sQLiteDatabase);

    public EntityManager createEntityManager() {
        if (!this.closed) {
            OGEntityManager oGEntityManager = new OGEntityManager(this.dbHelper, this.mName);
            this.closed = false;
            return oGEntityManager;
        }
        throw new IllegalStateException(CLOSE_EXCEPTION_MSG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String getPackageName();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedEncrypt() {
        return true;
    }

    public boolean isOpen() {
        return !this.closed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void upgradeDatabase(SQLiteDatabase sQLiteDatabase, int i3, int i16);

    public boolean verifyAuthentication() {
        if (!this.name.matches("^[0-9]*$")) {
            return true;
        }
        EntityManager createEntityManager = createEntityManager();
        Ability ability = (Ability) DBMethodProxy.find(createEntityManager, Ability.class, "flags=?", new String[]{String.valueOf(-1)});
        if (ability == null) {
            Ability ability2 = new Ability();
            ability2.flags = -1;
            ability2.uin = this.name;
            createEntityManager.persistOrReplace(ability2);
            return true;
        }
        String str = ability.uin;
        if (str != null && str.equals(this.name)) {
            return true;
        }
        this.mInnerDbHelper.dropAllTable();
        Ability ability3 = new Ability();
        ability3.flags = -1;
        ability3.uin = this.name;
        createEntityManager.persistOrReplace(ability3);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public EntityManagerFactory(String str, int i3) {
        this.tag = "EntityManagerFactory";
        this.mName = str;
        this.name = str;
        this.mDBVersion = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cleanOverDueCorruptDatabase() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doAfterUpgradeDatabase(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkTableColumnChange(String str, SQLiteDatabase sQLiteDatabase, int i3, int i16) {
    }
}
