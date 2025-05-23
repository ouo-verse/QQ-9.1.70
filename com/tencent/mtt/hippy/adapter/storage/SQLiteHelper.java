package com.tencent.mtt.hippy.adapter.storage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mtt.hippy.utils.LogUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SQLiteHelper extends SQLiteOpenHelper implements IHippySQLiteHelper {
    private static final String DATABASE_NAME = "HippyStorage";
    private static final int DATABASE_VERSION = 1;
    private static final int SLEEP_TIME_MS = 30;
    private static final String STATEMENT_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS hippy_engine_storage (key TEXT PRIMARY KEY,value TEXT NOT NULL)";
    private static final String TABLE_STORAGE = "hippy_engine_storage";
    private final Context mContext;
    private SQLiteDatabase mDb;

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        this.mContext = context;
    }

    private synchronized void closeDatabase() {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            this.mDb.close();
            this.mDb = null;
        }
    }

    private void createTableIfNotExists(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = 'hippy_engine_storage'", null);
            } catch (Exception e16) {
                e16.printStackTrace();
                if (cursor == null) {
                    return;
                }
            }
            if (cursor != null && cursor.getCount() > 0) {
                cursor.close();
                return;
            }
            sQLiteDatabase.execSQL(STATEMENT_CREATE_TABLE);
            if (cursor == null) {
                return;
            }
            cursor.close();
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }

    private synchronized boolean deleteDatabase() {
        closeDatabase();
        return this.mContext.deleteDatabase(DATABASE_NAME);
    }

    synchronized void ensureDatabase() {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            return;
        }
        SQLiteException e16 = null;
        for (int i3 = 0; i3 < 2; i3++) {
            if (i3 > 0) {
                try {
                    LogUtils.d("SQLiteHelper", "ensureDatabase: deleteDatabase ret=" + deleteDatabase());
                } catch (SQLiteException e17) {
                    e16 = e17;
                    try {
                        LockMethodProxy.sleep(30L);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            this.mDb = getWritableDatabase();
        }
        SQLiteDatabase sQLiteDatabase2 = this.mDb;
        if (sQLiteDatabase2 == null && e16 != null) {
            throw e16;
        }
        createTableIfNotExists(sQLiteDatabase2);
        this.mDb.setMaximumSize(IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE);
    }

    @Override // com.tencent.mtt.hippy.adapter.storage.IHippySQLiteHelper
    public synchronized SQLiteDatabase getDatabase() {
        ensureDatabase();
        return this.mDb;
    }

    @Override // com.tencent.mtt.hippy.adapter.storage.IHippySQLiteHelper
    public String getTableName() {
        return TABLE_STORAGE;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(STATEMENT_CREATE_TABLE);
    }

    @Override // com.tencent.mtt.hippy.adapter.storage.IHippySQLiteHelper
    public void onDestroy() {
        closeDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        if (i3 != i16) {
            LogUtils.d("SQLiteHelper", "onUpgrade: deleteDatabase ret=" + deleteDatabase());
            onCreate(sQLiteDatabase);
        }
    }
}
