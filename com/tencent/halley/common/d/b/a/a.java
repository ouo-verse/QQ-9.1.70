package com.tencent.halley.common.d.b.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.halley.common.a.h;
import com.tencent.halley.common.utils.d;
import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private C1241a f113418a;

    /* compiled from: P */
    /* renamed from: com.tencent.halley.common.d.b.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C1241a extends SQLiteOpenHelper {
        static IPatchRedirector $redirector_;

        public C1241a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, context, str);
            }
        }

        private void a() {
            try {
                ArrayList<String> arrayList = new ArrayList();
                int a16 = h.a("apn_cache_num", 1, 100, 8);
                d.d("halley-cloud-AbsScheduleStorager", "removeRecordIfNeeded...maxApnNum:".concat(String.valueOf(a16)));
                SQLiteDatabase writableDatabase = getWritableDatabase();
                Cursor cursor = null;
                try {
                    Cursor query = writableDatabase.query("halley_schedule_tbl", new String[]{"apn"}, null, null, null, null, "key");
                    if (query == null) {
                        if (query != null) {
                            query.close();
                            return;
                        }
                        return;
                    }
                    int count = query.getCount() - a16;
                    if (count > 0 && query.moveToFirst()) {
                        while (true) {
                            String string = query.getString(query.getColumnIndex("apn"));
                            if (!TextUtils.isEmpty(string) && !arrayList.contains(string)) {
                                arrayList.add(string);
                                d.a("halley-cloud-AbsScheduleStorager", "removeRecordIfNeeded...found apnName in db:".concat(String.valueOf(string)));
                            }
                            if (!query.moveToNext()) {
                                break;
                            }
                            int i3 = count - 1;
                            if (count <= 0) {
                                break;
                            } else {
                                count = i3;
                            }
                        }
                    }
                    query.close();
                    d.a("halley-cloud-AbsScheduleStorager", "found apnNames size:" + arrayList.size());
                    if (arrayList.size() > 0) {
                        d.a("halley-cloud-AbsScheduleStorager", "trying to delete apn num:" + arrayList.size());
                        for (String str : arrayList) {
                            d.d("halley-cloud-AbsScheduleStorager", "removeRecordIfNeeded...delete apn:" + str + ", ret:" + writableDatabase.delete("halley_schedule_tbl", "apn=?", new String[]{str}));
                        }
                    }
                } catch (Throwable th5) {
                    if (0 != 0) {
                        cursor.close();
                    }
                    throw th5;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        private static void b(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
                d.c("halley-cloud-AbsScheduleStorager", "db created.");
            } catch (SQLException e16) {
                throw e16;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) sQLiteDatabase);
                return;
            }
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
                d.c("halley-cloud-AbsScheduleStorager", "db created.");
            } catch (Exception e16) {
                e16.printStackTrace();
                d.b("halley-cloud-AbsScheduleStorager", "db create failed.", e16);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            try {
                a(sQLiteDatabase);
                b(sQLiteDatabase);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onOpen(SQLiteDatabase sQLiteDatabase) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) sQLiteDatabase);
                return;
            }
            super.onOpen(sQLiteDatabase);
            try {
                int version = sQLiteDatabase.getVersion();
                if (version <= 0) {
                    onUpgrade(sQLiteDatabase, version, 1);
                } else if (version > 1) {
                    onDowngrade(sQLiteDatabase, version, 1);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            try {
                a(sQLiteDatabase);
                b(sQLiteDatabase);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        private static void a(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_schedule_tbl");
            } catch (SQLException e16) {
                e16.printStackTrace();
            }
        }

        public final synchronized void a(String str, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bArr);
                return;
            }
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                int delete = writableDatabase.delete("halley_schedule_tbl", "apn=?", new String[]{str});
                ContentValues contentValues = new ContentValues();
                contentValues.put("apn", str);
                contentValues.put("result", bArr);
                contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                long insert = writableDatabase.insert("halley_schedule_tbl", null, contentValues);
                d.c("halley-cloud-AbsScheduleStorager", "insert record...ret:" + insert + ",apnName:" + str);
                if (-1 != insert && delete <= 0) {
                    a();
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }

        public final synchronized byte[] a(String str) {
            Cursor cursor;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            try {
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            try {
                cursor = getReadableDatabase().query("halley_schedule_tbl", null, "apn=?", new String[]{str}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            byte[] blob = cursor.getBlob(cursor.getColumnIndex("result"));
                            if (!j.a(blob)) {
                                cursor.close();
                                return blob;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th7) {
                th = th7;
                cursor = null;
            }
        }
    }

    public a(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        if (!com.tencent.halley.common.a.b()) {
            str2 = "_";
        } else {
            str2 = "_test_";
        }
        this.f113418a = new C1241a(com.tencent.halley.common.a.a(), "halley_schedule_" + com.tencent.halley.common.a.c() + str2 + com.tencent.halley.common.a.g() + "_" + str + DBBackupServiceImpl.DB_FILE_SUFFIX);
    }

    public final synchronized void a(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        if (!TextUtils.isEmpty(str) && bArr != null) {
            this.f113418a.a(str, bArr);
        }
    }

    public final synchronized byte[] a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return this.f113418a.a(str);
        }
        return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
    }
}
