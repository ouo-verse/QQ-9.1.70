package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.f;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
class d extends SQLiteOpenHelper {

    /* renamed from: d, reason: collision with root package name */
    private static volatile d f303773d;

    d() {
        super(qv2.b.a(), "qad_download_app_info", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null && sQLiteDatabase.inTransaction()) {
            sQLiteDatabase.endTransaction();
        }
    }

    private <T> T c(String str, Class<T> cls) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (T) new Gson().fromJson(str, (Class) cls);
    }

    public static d d() {
        if (f303773d == null) {
            synchronized (d.class) {
                if (f303773d == null) {
                    f303773d = new d();
                }
            }
        }
        return f303773d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0041, code lost:
    
        if (r6.getCount() > 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean e(SQLiteDatabase sQLiteDatabase, String str) {
        boolean z16 = true;
        String[] strArr = {str};
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.rawQuery("select package from qad_download_info where package= ?", strArr);
                if (cursor != null) {
                }
                z16 = false;
                if (cursor != null) {
                    cursor.close();
                }
                return z16;
            } catch (Exception e16) {
                n.d("QADDownloadInfoDBHelper", e16, "isInfoExist   error!!");
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }

    private void g(SQLiteDatabase sQLiteDatabase, b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("package", bVar.f303770a.f303811b);
        contentValues.put(j.T0, i(bVar.f303770a));
        contentValues.put("apk_size", Long.valueOf(bVar.f303771b));
        sQLiteDatabase.insert("qad_download_info", null, contentValues);
    }

    private String i(Object obj) {
        if (obj == null) {
            return "";
        }
        return new Gson().toJson(obj);
    }

    private void j(SQLiteDatabase sQLiteDatabase, b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("package", bVar.f303770a.f303811b);
        contentValues.put(j.T0, i(bVar.f303770a));
        contentValues.put("apk_size", Long.valueOf(bVar.f303771b));
        sQLiteDatabase.update("qad_download_info", contentValues, "package=?", new String[]{bVar.f303770a.f303811b});
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            f303773d.getWritableDatabase().delete("qad_download_info", "package=?", new String[]{str});
        } catch (Exception e16) {
            n.d("QADDownloadInfoDBHelper", e16, "deleteDownloadInfo  error!!");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a8, code lost:
    
        if (r0 == null) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.d] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b f(String str) {
        Throwable th5;
        b bVar;
        Exception e16;
        Cursor cursor;
        ?? r06 = "select * from qad_download_info where package = ?";
        ?? r26 = 0;
        String[] strArr = {str};
        try {
            try {
                r26 = f303773d.getWritableDatabase();
                try {
                    r26.beginTransaction();
                    cursor = r26.rawQuery(r06, strArr);
                    try {
                        r26.setTransactionSuccessful();
                    } catch (Exception e17) {
                        bVar = null;
                        e16 = e17;
                    }
                } catch (Exception e18) {
                    bVar = null;
                    e16 = e18;
                    cursor = null;
                } catch (Throwable th6) {
                    r06 = 0;
                    th5 = th6;
                    b(r26);
                    if (r06 != 0) {
                        r06.close();
                    }
                    throw th5;
                }
            } catch (Exception e19) {
                bVar = null;
                r26 = 0;
                e16 = e19;
                cursor = null;
            } catch (Throwable th7) {
                r26 = 0;
                th5 = th7;
                r06 = 0;
            }
            if (cursor == null) {
                b(r26);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            bVar = new b();
            try {
                if (cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndex(j.T0);
                    int columnIndex2 = cursor.getColumnIndex("apk_size");
                    if (columnIndex >= 0) {
                        bVar.f303770a = (f) c(cursor.getString(columnIndex), f.class);
                    }
                    if (columnIndex2 >= 0) {
                        bVar.f303771b = cursor.getLong(columnIndex2);
                    }
                }
                b(r26);
            } catch (Exception e26) {
                e16 = e26;
                n.d("QADDownloadInfoDBHelper", e16, "queryDownloadInfo tab  error!!");
                b(r26);
            }
            cursor.close();
            return bVar;
        } catch (Throwable th8) {
            th5 = th8;
        }
    }

    public void h(b bVar) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = f303773d.getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                if (e(sQLiteDatabase, bVar.f303770a.f303811b)) {
                    j(sQLiteDatabase, bVar);
                } else {
                    g(sQLiteDatabase, bVar);
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e16) {
                n.d("QADDownloadInfoDBHelper", e16, "saveOrUpdateDownloadInfo   error!!");
            }
        } finally {
            b(sQLiteDatabase);
        }
    }

    public void k(b bVar) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = f303773d.getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                j(sQLiteDatabase, bVar);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e16) {
                n.d("QADDownloadInfoDBHelper", e16, "saveOrUpdateDownloadInfo   error!!");
            }
        } finally {
            b(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CREATE TABLE IF NOT EXISTS ");
        stringBuffer.append("qad_download_info");
        stringBuffer.append(" (");
        stringBuffer.append("_id");
        stringBuffer.append(" integer primary key autoincrement, ");
        stringBuffer.append("package");
        stringBuffer.append(" text NOT NULL UNIQUE,");
        stringBuffer.append(j.T0);
        stringBuffer.append(" text,");
        stringBuffer.append("apk_size");
        stringBuffer.append(" integer default 0");
        stringBuffer.append(")");
        try {
            sQLiteDatabase.execSQL(stringBuffer.toString());
        } catch (SQLException e16) {
            n.d("QADDownloadInfoDBHelper", e16, "onCreate tab qad_download_info error!!");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
    }
}
