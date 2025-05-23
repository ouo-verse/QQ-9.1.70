package com.tencent.upload.network.session.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.upload.utils.UploadLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SessionDbHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String CREATE_TABLE = "CREATE TABLE session (_id INTEGER PRIMARY KEY AUTOINCREMENT,uin INTEGER,path TEXT,session TEXT,modified INTEGER,  UNIQUE (uin,path) ON CONFLICT REPLACE );";
    public static final String DATABASE_NAME = "upload_session";
    private static final int DATABASE_VERSION = 2;
    public static final String FILE_PATH = "path";
    public static final String MODIFIED_DATE = "modified";
    public static final String SESSION_ID = "session";
    private static final String SESSION_TABLE_NAME = "session";
    private static final String TAG = "SessionDbHelper";
    public static final String UIN = "uin";
    static String[] columns;
    private Context mContext;
    private DatabaseHelper mOpenHelper;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class DatabaseHelper extends SQLiteOpenHelper {
        static IPatchRedirector $redirector_;

        DatabaseHelper(Context context) {
            super(context, SessionDbHelper.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 2);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(SessionDbHelper.CREATE_TABLE);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS session");
                onCreate(sQLiteDatabase);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11872);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            columns = new String[]{"_id", "uin", "path", "session", MODIFIED_DATE};
        }
    }

    public SessionDbHelper(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mContext = context;
            open();
        }
    }

    private void open() throws SQLException {
        this.mOpenHelper = new DatabaseHelper(this.mContext);
    }

    public void clearUserData(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
            return;
        }
        String[] strArr = {Long.toString(j3)};
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.mOpenHelper.getWritableDatabase();
                sQLiteDatabase.delete("session", "uin = ? ", strArr);
                if (!sQLiteDatabase.isOpen()) {
                    return;
                }
            } catch (Exception e16) {
                UploadLog.e(TAG, "clearUserData failed. " + e16.toString());
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    return;
                }
            }
            sQLiteDatabase.close();
        } catch (Throwable th5) {
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
            throw th5;
        }
    }

    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mOpenHelper.close();
        }
    }

    public void delete(long j3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), str, str2);
            return;
        }
        String[] strArr = {Long.toString(j3), str};
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.mOpenHelper.getWritableDatabase();
                sQLiteDatabase.delete("session", "uin = ? AND path = ?", strArr);
                if (!sQLiteDatabase.isOpen()) {
                    return;
                }
            } catch (Exception e16) {
                UploadLog.e(TAG, "delete failed path=" + str + " session=" + str2 + e16.toString());
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    return;
                }
            }
            sQLiteDatabase.close();
        } catch (Throwable th5) {
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
            throw th5;
        }
    }

    public void insert(long j3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), str, str2);
            return;
        }
        ContentValues contentValues = new ContentValues();
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        contentValues.put("uin", Long.valueOf(j3));
        contentValues.put("path", str);
        contentValues.put("session", str2);
        contentValues.put(MODIFIED_DATE, valueOf);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
                try {
                    writableDatabase.insert("session", null, contentValues);
                    if (writableDatabase.isOpen()) {
                        writableDatabase.close();
                    }
                } catch (Exception unused) {
                    sQLiteDatabase = writableDatabase;
                    UploadLog.e(TAG, "insert failed path=" + str + " session=" + str2);
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    sQLiteDatabase = writableDatabase;
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
    
        if (r12.isClosed() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ae, code lost:
    
        if (r12.isClosed() == false) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String query(long j3, String str) {
        Throwable th5;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), str);
        }
        String[] strArr = {Long.toString(j3), str};
        String str2 = null;
        try {
            try {
                sQLiteDatabase = this.mOpenHelper.getWritableDatabase();
            } catch (Exception e16) {
                e = e16;
                sQLiteDatabase = null;
                cursor = null;
            } catch (Throwable th6) {
                str = 0;
                th5 = th6;
                sQLiteDatabase = null;
            }
            try {
                cursor = sQLiteDatabase.query("session", columns, "uin = ? AND path = ?", strArr, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            str2 = cursor.getString(cursor.getColumnIndex("session"));
                        }
                    } catch (Exception e17) {
                        e = e17;
                        UploadLog.e(TAG, "query error, " + e.toString());
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                        if (cursor != null) {
                        }
                        return str2;
                    }
                }
                if (sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                if (cursor != null) {
                }
            } catch (Exception e18) {
                e = e18;
                cursor = null;
            } catch (Throwable th7) {
                str = 0;
                th5 = th7;
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                if (str != 0 && !str.isClosed()) {
                    str.close();
                }
                throw th5;
            }
            return str2;
        } catch (Throwable th8) {
            th5 = th8;
        }
    }
}
