package com.tencent.ams.dsdk.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DBHelper extends SQLiteOpenHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String COL_FOLDER = "folder";
    public static final String COL_ID = "_id";
    public static final String COL_MD5 = "md5";
    public static final String COL_MODIFY_DATE = "modify_date";
    public static final String COL_NAME = "file_name";
    public static final String COL_PROGRESS = "progress";
    public static final String COL_TOTAL = "total";
    public static final String COL_URL = "url";
    private static final String DB_NAME = "dynamic_sdk.db";
    private static DBHelper INSTANCE = null;
    private static final String SQL_CREATE_TABLE_IF_NOT_EXISTS = "CREATE TABLE IF NOT EXISTS download (_id integer primary key autoincrement, url varchar(256), md5 varchar(32), folder varchar(256), file_name varchar(256), total long, progress long, modify_date long)";
    private static final String TABLE_NAME = "download";
    private static final String TAG = "DBHelper";
    private static final int VERSION = 1;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18936);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = null;
        }
    }

    DBHelper(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    public static DBHelper getInstance() throws IllegalArgumentException {
        if (INSTANCE == null) {
            synchronized (DBHelper.class) {
                if (INSTANCE == null) {
                    if (DKEngine.getApplicationContext() != null) {
                        INSTANCE = new DBHelper(DKEngine.getApplicationContext());
                    } else {
                        throw new IllegalArgumentException("DKEngine's context is null");
                    }
                }
            }
        }
        return INSTANCE;
    }

    public int delete(String str, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) strArr)).intValue();
        }
        try {
            return getWritableDatabase().delete("download", str, strArr);
        } catch (Throwable th5) {
            DLog.e(TAG, "delete error.", th5);
            return -1;
        }
    }

    public long insert(ContentValues contentValues) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, (Object) contentValues)).longValue();
        }
        try {
            return getWritableDatabase().insert("download", null, contentValues);
        } catch (Throwable th5) {
            DLog.e(TAG, "insert error.", th5);
            return -1L;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) sQLiteDatabase);
            return;
        }
        DLog.d(TAG, "onCreate");
        try {
            try {
                sQLiteDatabase.execSQL(SQL_CREATE_TABLE_IF_NOT_EXISTS);
            } catch (Throwable unused) {
                sQLiteDatabase.execSQL(SQL_CREATE_TABLE_IF_NOT_EXISTS);
            }
        } catch (Throwable th5) {
            DLog.e(TAG, "create table error.", th5);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        DLog.d(TAG, "onUpgrade, oldVersion: " + i3 + ", newVersion: " + i16);
        try {
            sQLiteDatabase.execSQL("DROP TABLE download");
            DLog.d(TAG, "onUpgrade, drop old table, tableName: download");
            sQLiteDatabase.execSQL(SQL_CREATE_TABLE_IF_NOT_EXISTS);
            DLog.d(TAG, "onUpgrade, create new table. tableName: download");
        } catch (Throwable th5) {
            DLog.e(TAG, "onUpgrade error.", th5);
        }
    }

    public Cursor query(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Cursor) iPatchRedirector.redirect((short) 2, this, strArr, str, strArr2, str2, str3, str4);
        }
        try {
            return getReadableDatabase().query("download", strArr, str, strArr2, str2, str3, str4);
        } catch (Throwable th5) {
            DLog.e(TAG, "query error.", th5);
            return null;
        }
    }

    public int update(ContentValues contentValues, String str, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, contentValues, str, strArr)).intValue();
        }
        try {
            return getWritableDatabase().update("download", contentValues, str, strArr);
        } catch (Throwable th5) {
            DLog.e(TAG, "update error.", th5);
            return -1;
        }
    }
}
