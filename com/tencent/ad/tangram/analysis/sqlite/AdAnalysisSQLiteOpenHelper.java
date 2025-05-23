package com.tencent.ad.tangram.analysis.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.process.AdProcessManager;

/* compiled from: P */
/* loaded from: classes3.dex */
final class AdAnalysisSQLiteOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "gdt_analysis";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = "AdAnalysisSQLiteHelper";
    private static volatile AdAnalysisSQLiteOpenHelper instance;

    AdAnalysisSQLiteOpenHelper(Context context) {
        super(context, getFilename(context), (SQLiteDatabase.CursorFactory) null, 1);
        initialize();
    }

    private static String getCreateTableSQL() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (%s %s, %s %s, %s %s, %s %s, %s %s)", AdAnalysisSQLiteColumns.TABLE_NAME, "_id", "INTEGER PRIMARY KEY AUTOINCREMENT", "uuid", "TEXT NOT NULL UNIQUE", AdAnalysisSQLiteColumns.COLUMN_NAME_TIME_MILLIS, "INTEGER NOT NULL", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "INTEGER NOT NULL", "event", "TEXT NOT NULL");
    }

    private static String getDropTableSQL(String str) {
        return String.format("DROP TABLE IF EXISTS %s", str);
    }

    private static String getFilename(Context context) {
        String replaceAll;
        String currentProcessName = AdProcessManager.getInstance().getCurrentProcessName(context);
        if (TextUtils.isEmpty(currentProcessName)) {
            replaceAll = "";
        } else {
            replaceAll = currentProcessName.replaceAll("(\\.|:)", "_");
        }
        if (!TextUtils.isEmpty(replaceAll)) {
            return String.format("%s_%s.db", DATABASE_NAME, replaceAll);
        }
        return String.format("%s.db", DATABASE_NAME);
    }

    public static AdAnalysisSQLiteOpenHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (AdAnalysisSQLiteOpenHelper.class) {
                if (instance == null) {
                    instance = new AdAnalysisSQLiteOpenHelper(context);
                }
            }
        }
        return instance;
    }

    private void initialize() {
        AdLog.i(TAG, "initialize");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            AdLog.e(TAG, "initialize error");
            return;
        }
        try {
            for (String str : AdAnalysisSQLiteColumns.OLD_TABLE_NAMES) {
                writableDatabase.execSQL(getDropTableSQL(str));
            }
            writableDatabase.execSQL(getCreateTableSQL());
        } catch (Throwable th5) {
            AdLog.e(TAG, "throwable", th5);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        AdLog.i(TAG, "onCreate");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        AdLog.i(TAG, "onUpgrade");
    }
}
