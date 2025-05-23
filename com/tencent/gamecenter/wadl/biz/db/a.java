package com.tencent.gamecenter.wadl.biz.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class a extends SQLiteOpenHelper {
    private static final String TAG = "Wadl_QQGameBaseDBHelper";
    protected String tableName;

    public a(Context context, String str) {
        this(context, str, 36);
    }

    private void createTable() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            QLog.w(TAG, 1, "onCreate dbWriter is null");
            return;
        }
        String str = "CREATE TABLE IF NOT EXISTS " + this.tableName + " (" + getCreateTableFields() + " PRIMARY KEY(" + getTableKey() + "));";
        QLog.i(TAG, 1, "createTable " + this.tableName);
        try {
            writableDatabase.execSQL(str);
        } finally {
            try {
            } finally {
            }
        }
    }

    public int execDelSQL(String str, String[] strArr) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        int i3 = -1;
        if (writableDatabase == null) {
            QLog.w(TAG, 1, "execDelSQL dbWriter is null");
            return -1;
        }
        try {
            i3 = writableDatabase.delete(this.tableName, str, strArr);
            QLog.d(TAG, 1, "execDelSQL " + this.tableName + " whereValue=" + Arrays.toString(strArr) + ",ret=" + i3);
        } finally {
            try {
                return i3;
            } finally {
            }
        }
        return i3;
    }

    public long execInsertSQL(ContentValues contentValues) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        long j3 = -1;
        if (writableDatabase == null) {
            QLog.w(TAG, 1, "execInsertSQL dbWriter is null");
            return -1L;
        }
        try {
            j3 = writableDatabase.insert(this.tableName, null, contentValues);
            QLog.d(TAG, 1, "execInsertSQL " + this.tableName + " row=" + j3 + ",cv=" + contentValues);
        } finally {
            try {
                return j3;
            } finally {
            }
        }
        return j3;
    }

    public long execReplaceSQL(ContentValues contentValues) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        long j3 = -1;
        if (writableDatabase == null) {
            QLog.w(TAG, 1, "execReplaceSQL dbWriter is null");
            return -1L;
        }
        try {
            j3 = writableDatabase.replace(this.tableName, null, contentValues);
            QLog.d(TAG, 1, "execReplaceSQL " + this.tableName + " version=" + writableDatabase.getVersion() + " row=" + j3 + ",cv=" + contentValues);
        } finally {
            try {
                return j3;
            } finally {
            }
        }
        return j3;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int execUpdSQL(String str, String[] strArr, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        int i3 = -1;
        if (writableDatabase != null && contentValues != null) {
            try {
                i3 = writableDatabase.update(this.tableName, contentValues, str, strArr);
            } finally {
                try {
                    if (i3 <= 0) {
                    }
                    return i3;
                } finally {
                }
            }
            if (i3 <= 0) {
                QLog.w(TAG, 1, "execUpdSQL " + this.tableName + " error whereValue=" + Arrays.toString(strArr) + ",cv=" + contentValues);
            }
            return i3;
        }
        QLog.w(TAG, 1, "execUpdSQL dbWriter is null");
        return -1;
    }

    public boolean exists(String str, String[] strArr, String str2) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        boolean z16 = false;
        if (readableDatabase == null) {
            QLog.w(TAG, 1, "exists dbReader is null");
            return false;
        }
        Cursor cursor = null;
        try {
            cursor = readableDatabase.query(this.tableName, new String[]{str2}, str, strArr, null, null, null);
            if (cursor != null) {
                if (cursor.moveToNext()) {
                    z16 = true;
                }
            }
        } finally {
            try {
                return z16;
            } finally {
            }
        }
        return z16;
    }

    public abstract String getCreateTableFields();

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        try {
            return super.getReadableDatabase();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getReadableDatabase exception", e16);
            GameCenterUtil.closeIO(null);
            return null;
        }
    }

    public abstract String getTableKey();

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getWritableDatabase exception", e16);
            GameCenterUtil.closeIO(null);
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        QLog.i(TAG, 1, "onCreate " + this.tableName);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        QLog.i(TAG, 1, "onUpgrade oldVersion=" + i3 + ",newVersion=" + i16);
    }

    public a(Context context, String str, int i3) {
        super(context, WadlProxyConsts.DB_NAME, (SQLiteDatabase.CursorFactory) null, i3);
        this.tableName = str;
        QLog.i(TAG, 1, "new instance tableName=" + str + ",dbVersion=" + i3);
        createTable();
    }
}
