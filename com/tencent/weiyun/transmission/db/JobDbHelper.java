package com.tencent.weiyun.transmission.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.utils.IOUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes27.dex */
final class JobDbHelper extends SQLiteOpenHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String DB_NAME = "weiyunlite_db_job";
    private static final String TAG = "JobDbHelper";
    private static final int VERSION = 1;
    private static final int VERSION_1 = 1;
    private int mRefCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JobDbHelper(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mRefCount = 0;
        }
    }

    private void createDownloadTable(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.execSQL("drop table if exists download");
        sQLiteDatabase.execSQL("CREATE TABLE download (_id INTEGER PRIMARY KEY AUTOINCREMENT, uid TEXT, cmd_type INTEGER, file_name TEXT, p_dir_uid TEXT, p_dir_key TEXT, file_id TEXT, " + JobDbManager.COL_DOWN_CLOUD_SHA + " TEXT, file_size INTEGER, file_type INTEGER, file_version TEXT, " + JobDbManager.COL_DOWN_LOCAL_DIR + " TEXT, insert_time INTEGER, thumb_uri TEXT, group_root_dir_key TEXT, state INTEGER, error_code INTEGER, error_msg TEXT, total_size INTEGER, cur_size INTEGER, local_path TEXT, valid_flag INTEGER )");
        sQLiteDatabase.execSQL("create index if not exists index_download_insert on download(insert_time)");
    }

    private void createUploadTable(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.execSQL("drop table if exists upload");
        sQLiteDatabase.execSQL("CREATE TABLE " + JobDbManager.TBL_UPLOAD + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, uid TEXT, cmd_type INTEGER, local_path TEXT, " + JobDbManager.COL_UP_LOCAL_MODIFIED + " INTEGER, p_dir_uid TEXT, " + JobDbManager.COL_UP_P_DIR_NAME + " TEXT, p_dir_key TEXT, " + JobDbManager.COL_UP_PP_DIR_KEY + " TEXT, insert_time INTEGER, thumb_uri TEXT, file_name TEXT, file_size INTEGER, " + JobDbManager.COL_UP_LOCAL_SHA + " TEXT, " + JobDbManager.COL_UP_MIME_TYPE + " TEXT, longitude REAL, latitude REAL, " + JobDbManager.COL_UP_TAKEN_TIME + " INTEGER, width INTEGER, height INTEGER, duration REAL, album TEXT, " + JobDbManager.COL_UP_ARTIST + " TEXT, " + JobDbManager.COL_UP_COMPRESS_FLAG + " INTEGER, " + JobDbManager.COL_UP_COMPRESS_PATH + " TEXT, " + JobDbManager.COL_UP_COMPRESS_SHA + " TEXT, " + JobDbManager.COL_UP_COVER_FILE_ID + " TEXT, " + JobDbManager.COL_UP_COVER_FILE_VERSION + " TEXT, " + JobDbManager.COL_UP_AUTO_BACKUP_FLAG + " INTEGER, group_root_dir_key TEXT, " + JobDbManager.COL_UP_BATCH_ID + " TEXT, " + JobDbManager.COL_UP_BATCH_TOTAL + " INTEGER, " + JobDbManager.COL_UP_BATCH_INDEX + " INTEGER, " + JobDbManager.COL_UP_BATCH_DESC + " TEXT, state INTEGER, error_code INTEGER, error_msg TEXT, total_size INTEGER, cur_size INTEGER, file_id TEXT, file_version TEXT, valid_flag INTEGER )");
        sQLiteDatabase.execSQL("create index if not exists index_upload_insert on upload(insert_time)");
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
            IOUtils.copyFiles(context.getDatabasePath(DB_NAME), new File(file, "tencent/weiyunlite/db/weiyunlite_db_job"));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sQLiteDatabase);
        } else {
            createUploadTable(sQLiteDatabase);
            createDownloadTable(sQLiteDatabase);
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
            TsLog.e(TAG, "openDatabase failed", th5);
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase != null) {
            this.mRefCount++;
        }
        return sQLiteDatabase;
    }
}
