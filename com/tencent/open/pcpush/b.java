package com.tencent.open.pcpush;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.qq.e.comm.constants.TangramAppConstants;
import com.tencent.open.base.f;
import com.tencent.open.pcpush.c;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends SQLiteOpenHelper {

    /* renamed from: d, reason: collision with root package name */
    public static final Uri f341696d = Uri.parse("content://open.pcpush/pcpush_package_info");

    /* renamed from: e, reason: collision with root package name */
    public static final Uri f341697e = Uri.parse("content://open.pcpush/pcpush_package_info/");

    /* renamed from: f, reason: collision with root package name */
    public static final Uri f341698f = Uri.parse("content://open.pcpush/pcpush_package_info//#");

    public b() {
        super(com.tencent.open.adapter.a.f().e(), "pcdb", (SQLiteDatabase.CursorFactory) null, 2);
    }

    public void a(c.b bVar) {
        f.e("PCPushDBHelper", "addPkgEntry>>>insert entry = " + bVar.toString());
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("key", bVar.f341705a);
                contentValues.put("appid", bVar.f341706b);
                contentValues.put("appname", bVar.f341710f);
                contentValues.put("appsize", bVar.f341713i);
                contentValues.put("appurl", bVar.f341711g);
                contentValues.put("downloadtype", Integer.valueOf(bVar.f341718n));
                contentValues.put("filetype", Integer.valueOf(bVar.f341714j));
                contentValues.put(TangramAppConstants.ICON_URL, bVar.f341712h);
                contentValues.put("pkgname", bVar.f341708d);
                contentValues.put("source", bVar.f341715k);
                contentValues.put("srciconurl", bVar.f341716l);
                contentValues.put("versioncode", Integer.valueOf(bVar.f341709e));
                contentValues.put("via", bVar.f341707c);
                contentValues.put("key", bVar.f341705a);
                contentValues.put("installstate", Integer.valueOf(bVar.f341717m));
                contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                int update = sQLiteDatabase.update("pcpush_package_info", contentValues, "key = ?", new String[]{bVar.f341705a});
                f.h("PCPushDBHelper", "addPkgEntry>>>update affected rowNum=" + update);
                if (update == 0) {
                    f.h("PCPushDBHelper", "addPkgEntry>>>insert rowID = " + sQLiteDatabase.insert("pcpush_package_info", "pkgname", contentValues));
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e16) {
                f.d("PCPushDBHelper", "addPkgEntry error", e16);
                if (sQLiteDatabase == null) {
                    return;
                }
            }
            sQLiteDatabase.endTransaction();
            sQLiteDatabase.close();
        } catch (Throwable th5) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
                sQLiteDatabase.close();
            }
            throw th5;
        }
    }

    public void b(String str) {
        f.h("PCPushDBHelper", "--> delete key = " + str);
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.delete("pcpush_package_info", "key = ?", new String[]{str});
            writableDatabase.close();
        } catch (Exception e16) {
            f.d("PCPushDBHelper", "deletePkgEntry error", e16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(ConcurrentHashMap<String, c.b> concurrentHashMap) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        try {
            sQLiteDatabase = getReadableDatabase();
        } catch (Exception e16) {
            e = e16;
            sQLiteDatabase = null;
        } catch (Throwable th5) {
            th = th5;
            sQLiteDatabase = null;
            if (cursor != null) {
            }
            if (sQLiteDatabase != null) {
            }
            throw th;
        }
        try {
            try {
                cursor = sQLiteDatabase.query("pcpush_package_info", null, null, null, null, null, null);
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    do {
                        c.b bVar = new c.b();
                        bVar.f341706b = cursor.getString(cursor.getColumnIndex("appid"));
                        bVar.f341710f = cursor.getString(cursor.getColumnIndex("appname"));
                        bVar.f341713i = cursor.getString(cursor.getColumnIndex("appsize"));
                        bVar.f341711g = cursor.getString(cursor.getColumnIndex("appurl"));
                        bVar.f341714j = cursor.getInt(cursor.getColumnIndex("filetype"));
                        bVar.f341712h = cursor.getString(cursor.getColumnIndex(TangramAppConstants.ICON_URL));
                        bVar.f341708d = cursor.getString(cursor.getColumnIndex("pkgname"));
                        bVar.f341715k = cursor.getString(cursor.getColumnIndex("source"));
                        bVar.f341716l = cursor.getString(cursor.getColumnIndex("srciconurl"));
                        bVar.f341709e = cursor.getInt(cursor.getColumnIndex("versioncode"));
                        bVar.f341707c = cursor.getString(cursor.getColumnIndex("via"));
                        bVar.f341718n = cursor.getInt(cursor.getColumnIndex("downloadtype"));
                        bVar.f341705a = cursor.getString(cursor.getColumnIndex("key"));
                        bVar.f341717m = cursor.getInt(cursor.getColumnIndex("installstate"));
                        concurrentHashMap.put(bVar.f341705a, bVar);
                    } while (cursor.moveToNext());
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th6) {
                th = th6;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        } catch (Exception e17) {
            e = e17;
            f.d("PCPushDBHelper", "loadAllPkgEntries error", e);
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.close();
        }
        sQLiteDatabase.close();
    }

    protected void d(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        if (i3 != i16) {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS pcpush_package_info;");
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        f.h("PCPushDBHelper", "--> start--DatabaseHelper onCreate<<<<");
        sQLiteDatabase.execSQL("CREATE TABLE pcpush_package_info (key TEXT PRIMARY KEY,appid TEXT,via TEXT,pkgname TEXT,versioncode INTEGER,appname TEXT,appurl TEXT,iconurl TEXT,appsize TEXT,filetype TEXT,source TEXT,srciconurl TEXT,timestamp INTEGER,installstate INTEGER,downloadtype INTEGER);");
        f.h("PCPushDBHelper", "--> end--DatabaseHelper onCreate<<<<");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        f.a("PCPushDBHelper", "onDowngrade oldVersion=" + i3 + " newVersion=" + i16);
        d(sQLiteDatabase, i3, i16);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        f.a("PCPushDBHelper", "onUpgrade oldVersion=" + i3 + " newVersion=" + i16);
        d(sQLiteDatabase, i3, i16);
    }
}
