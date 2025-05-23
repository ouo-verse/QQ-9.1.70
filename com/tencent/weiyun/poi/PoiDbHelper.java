package com.tencent.weiyun.poi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.utils.IOUtils;
import com.tencent.weiyun.utils.WyLog;
import java.io.File;

/* loaded from: classes27.dex */
final class PoiDbHelper extends SQLiteOpenHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String DB_NAME = "weiyunlite_db_poi";
    private static final String TAG = "PoiDbHelper";
    private static final int VERSION = 1;
    private static final int VERSION_1 = 1;
    private int mRefCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoiDbHelper(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mRefCount = 0;
        }
    }

    private void createPoiTable(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.execSQL("drop table if exists poi");
        sQLiteDatabase.execSQL("CREATE TABLE " + PoiDbManager.TBL_POI + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, longitude REAL, latitude REAL, " + PoiDbManager.COL_POI_NATION_TYPE + " INTEGER, " + PoiDbManager.COL_POI_NATION_NAME + " TEXT, " + PoiDbManager.COL_POI_CITY_ID + " INTEGER, city_name TEXT, " + PoiDbManager.COL_POI_POI_ID + " TEXT, poi_name TEXT, address TEXT,  UNIQUE(longitude, latitude) ON CONFLICT IGNORE)");
        sQLiteDatabase.execSQL("create index if not exists index_poi_longitude_latitude on poi(longitude,latitude)");
    }

    public synchronized void closeDatabase(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) sQLiteDatabase);
        } else {
            if (sQLiteDatabase == null) {
                return;
            }
            this.mRefCount--;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dumpDb(Context context, File file) {
        if (context != null && file != null) {
            IOUtils.copyFiles(context.getDatabasePath(DB_NAME), new File(file, "tencent/weiyunlite/db/weiyunlite_db_poi"));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sQLiteDatabase);
        } else {
            createPoiTable(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public synchronized SQLiteDatabase openDatabase(boolean z16) {
        SQLiteDatabase sQLiteDatabase;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
        try {
            if (z16) {
                sQLiteDatabase = getWritableDatabase();
            } else {
                sQLiteDatabase = getReadableDatabase();
            }
        } catch (Throwable th5) {
            WyLog.e(TAG, "openDatabase failed", th5);
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase != null) {
            this.mRefCount++;
        }
        return sQLiteDatabase;
    }
}
