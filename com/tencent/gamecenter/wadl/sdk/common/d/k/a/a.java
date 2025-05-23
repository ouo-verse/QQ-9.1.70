package com.tencent.gamecenter.wadl.sdk.common.d.k.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.sdk.common.b.g;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private C1127a f107140a;

    /* compiled from: P */
    /* renamed from: com.tencent.gamecenter.wadl.sdk.common.d.k.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C1127a extends SQLiteOpenHelper {
        public C1127a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3) {
            super(context, str, cursorFactory, i3);
        }

        private void a() {
            int count;
            try {
                ArrayList<String> arrayList = new ArrayList();
                int a16 = g.a("apn_cache_num", 1, 100, 8);
                com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-cloud-AbsScheduleStorager", "removeRecordIfNeeded...maxApnNum:" + a16);
                SQLiteDatabase writableDatabase = getWritableDatabase();
                Cursor cursor = null;
                try {
                    cursor = writableDatabase.query("wadl_schedule_tbl", new String[]{"apn"}, null, null, null, null, "key");
                    if (cursor != null && (count = cursor.getCount() - a16) > 0 && cursor.moveToFirst()) {
                        while (true) {
                            String string = cursor.getString(cursor.getColumnIndex("apn"));
                            if (!TextUtils.isEmpty(string) && !arrayList.contains(string)) {
                                arrayList.add(string);
                                com.tencent.gamecenter.wadl.sdk.common.e.b.d("Wadl-cloud-AbsScheduleStorager", "removeRecordIfNeeded...found apnName in db:" + string);
                            }
                            if (!cursor.moveToNext()) {
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
                    com.tencent.gamecenter.wadl.sdk.common.e.b.d("Wadl-cloud-AbsScheduleStorager", "found apnNames size:" + arrayList.size());
                    if (arrayList.size() > 0) {
                        com.tencent.gamecenter.wadl.sdk.common.e.b.d("Wadl-cloud-AbsScheduleStorager", "trying to delete apn num:" + arrayList.size());
                        for (String str : arrayList) {
                            com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-cloud-AbsScheduleStorager", "removeRecordIfNeeded...delete apn:" + str + ", ret:" + writableDatabase.delete("wadl_schedule_tbl", "apn=?", new String[]{str}));
                        }
                    }
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } catch (Exception e16) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-AbsScheduleStorager", "removeRecordIfNeeded failed.", e16);
            }
        }

        private void b(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS wadl_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-AbsScheduleStorager", "db created.");
            } catch (SQLException e16) {
                throw e16;
            }
        }

        private void e(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS wadl_schedule_tbl");
            } catch (SQLException e16) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-AbsScheduleStorager", "dropTable failed.", e16);
            }
        }

        public synchronized void c(String str, byte[] bArr) {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                int delete = writableDatabase.delete("wadl_schedule_tbl", "apn=?", new String[]{str});
                ContentValues contentValues = new ContentValues();
                contentValues.put("apn", str);
                contentValues.put("result", bArr);
                contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                long insert = writableDatabase.insert("wadl_schedule_tbl", null, contentValues);
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-AbsScheduleStorager", "insert record...ret:" + insert + ",apnName:" + str);
                if (-1 != insert && delete <= 0) {
                    a();
                }
            } catch (Throwable th5) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-AbsScheduleStorager", "getResult failed.", th5);
            }
        }

        public synchronized byte[] d(String str) {
            Cursor cursor;
            try {
            } catch (Throwable th5) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-AbsScheduleStorager", "getResult failed.", th5);
            }
            try {
                cursor = getReadableDatabase().query("wadl_schedule_tbl", null, "apn=?", new String[]{str}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            byte[] blob = cursor.getBlob(cursor.getColumnIndex("result"));
                            if (!com.tencent.gamecenter.wadl.sdk.common.e.g.a(blob)) {
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

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS wadl_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-AbsScheduleStorager", "db created.");
            } catch (Exception e16) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-AbsScheduleStorager", "db create failed.", e16);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
            try {
                e(sQLiteDatabase);
                b(sQLiteDatabase);
            } catch (Exception e16) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-AbsScheduleStorager", "onDowngrade failed.", e16);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            super.onOpen(sQLiteDatabase);
            try {
                int version = sQLiteDatabase.getVersion();
                if (version == 0) {
                    return;
                }
                if (version < a.this.a()) {
                    onUpgrade(sQLiteDatabase, version, a.this.a());
                } else if (version > a.this.a()) {
                    onDowngrade(sQLiteDatabase, version, a.this.a());
                }
            } catch (Exception e16) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-AbsScheduleStorager", "onOpen failed.", e16);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
            try {
                e(sQLiteDatabase);
                b(sQLiteDatabase);
            } catch (Exception e16) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-AbsScheduleStorager", "onUpgrade failed.", e16);
            }
        }
    }

    public a(String str) {
        String str2;
        if (!com.tencent.gamecenter.wadl.sdk.common.a.i()) {
            str2 = "_";
        } else {
            str2 = "_test_";
        }
        this.f107140a = new C1127a(com.tencent.gamecenter.wadl.sdk.common.a.b(), "wadl_schedule_" + com.tencent.gamecenter.wadl.sdk.common.a.c() + str2 + com.tencent.gamecenter.wadl.sdk.common.a.f() + "_" + str + DBBackupServiceImpl.DB_FILE_SUFFIX, null, a());
    }

    public abstract int a();

    public synchronized void a(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null) {
            this.f107140a.c(str, bArr);
        }
    }

    public synchronized byte[] a(String str) {
        return this.f107140a.d(str);
    }
}
