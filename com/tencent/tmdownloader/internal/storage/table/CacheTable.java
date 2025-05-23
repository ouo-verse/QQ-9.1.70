package com.tencent.tmdownloader.internal.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tmassistantbase.util.r;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CacheTable implements com.tencent.tmassistant.common.a.b {
    static IPatchRedirector $redirector_ = null;
    protected static final String[] COLS_SIZE;
    protected static final String COL_BLOB = "blob";
    protected static final String COL_KEY = "key";
    public static final String COL_KEY_CACHE = "cache";
    public static final String COL_KEY_REPORT = "report";
    protected static final String COL_TYPE = "type";
    public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS reportInfo( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);";
    protected static final int REPORT_MAX_DB_SIZE = 20;
    public static final String TABLE_NAME = "reportInfo";
    protected static final String TAG = "ReportTable";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14809);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            COLS_SIZE = new String[]{"key"};
        }
    }

    public CacheTable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.tmassistant.common.a.b
    public String createTableSQL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return CREATE_TABLE_SQL;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
    
        if (r6 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0067, code lost:
    
        r7.setTransactionSuccessful();
        r7.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0064, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        if (r6 == null) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dataMovement(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
        Exception e16;
        Cursor cursor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) sQLiteDatabase, (Object) sQLiteDatabase2);
            return;
        }
        if (sQLiteDatabase2 != null && sQLiteDatabase != null) {
            sQLiteDatabase2.beginTransaction();
            Cursor cursor2 = null;
            try {
                cursor = sQLiteDatabase.rawQuery("select * from reportInfo", null);
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                r.b(TABLE_NAME, "start move data!");
                                do {
                                    ContentValues contentValues = new ContentValues();
                                    com.tencent.tmdownloader.internal.downloadservice.c.a(contentValues, com.tencent.tmdownloader.internal.downloadservice.c.b(cursor));
                                    sQLiteDatabase2.insert(TABLE_NAME, null, contentValues);
                                } while (cursor.moveToNext());
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } catch (Exception e17) {
                        e16 = e17;
                        r.a(TAG, "exception: ", e16);
                        e16.printStackTrace();
                        r.b(TABLE_NAME, "move data exception!");
                    }
                }
            } catch (Exception e18) {
                e16 = e18;
                cursor = null;
            } catch (Throwable th6) {
                th = th6;
                if (cursor2 != null) {
                }
                throw th;
            }
        }
    }

    @Override // com.tencent.tmassistant.common.a.b
    public String[] getAlterSQL(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String[]) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return null;
    }

    public com.tencent.tmassistant.common.a.c getHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.tmassistant.common.a.c) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return com.tencent.tmdownloader.f.b.d.a.c();
    }

    @Override // com.tencent.tmassistant.common.a.b
    public String tableName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TABLE_NAME;
    }
}
