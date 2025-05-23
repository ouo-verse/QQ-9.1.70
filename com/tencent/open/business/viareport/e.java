package com.tencent.open.business.viareport;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    protected static e f341116a;

    protected e() {
    }

    public static synchronized e e() {
        e eVar;
        synchronized (e.class) {
            if (f341116a == null) {
                f341116a = new e();
            }
            eVar = f341116a;
        }
        return eVar;
    }

    private synchronized long j(SQLiteDatabase sQLiteDatabase, String str, b bVar) {
        long j3;
        ContentValues contentValues = new ContentValues();
        contentValues.put("actiontype", bVar.f341105c);
        contentValues.put("appid", bVar.f341103a);
        contentValues.put("qua", bVar.f341107e);
        contentValues.put("uin", bVar.f341106d);
        contentValues.put("via", bVar.f341104b);
        contentValues.put("network", bVar.a());
        contentValues.put("timestamp", bVar.f341109g);
        contentValues.put("expand1", bVar.f341110h);
        contentValues.put("expand2", bVar.f341111i);
        contentValues.put("expand3", bVar.f341112j);
        contentValues.put("expand4", bVar.f341113k);
        contentValues.put("expand5", bVar.f341114l);
        try {
            j3 = sQLiteDatabase.insertOrThrow(str, "_id", contentValues);
        } catch (SQLException e16) {
            e16.printStackTrace();
            com.tencent.open.base.f.c("BusinessReport", e16.getLocalizedMessage());
            j3 = -1;
        }
        return j3;
    }

    public synchronized int a(ArrayList<b> arrayList) {
        return l("table_old_data", arrayList);
    }

    public synchronized int b(String str, String str2) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase d16 = d();
                try {
                    if (TextUtils.isEmpty(str2)) {
                        int delete = d16.delete(str, null, null);
                        d16.close();
                        return delete;
                    }
                    int delete2 = d16.delete(str, "uin=?", new String[]{str2});
                    d16.close();
                    return delete2;
                } catch (Exception e16) {
                    e = e16;
                    sQLiteDatabase = d16;
                    e.printStackTrace();
                    com.tencent.open.base.f.c("BusinessReport", e.getLocalizedMessage());
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return -1;
                } catch (Throwable th5) {
                    th = th5;
                    sQLiteDatabase = d16;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public synchronized int c(String str) {
        int f16;
        int f17 = f("table_new_data", str) + 0;
        com.tencent.open.base.f.e("Jie", "new_table>>count=" + f17);
        f16 = f17 + f("table_old_data", str);
        com.tencent.open.base.f.e("Jie", "all_table>>>count=" + f16);
        return f16;
    }

    protected SQLiteDatabase d() {
        try {
            return f.a(com.tencent.open.adapter.a.f().e()).getWritableDatabase();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0062 A[Catch: all -> 0x006b, TRY_ENTER, TryCatch #2 {, blocks: (B:3:0x0001, B:6:0x000e, B:14:0x002f, B:33:0x0062, B:35:0x0067, B:36:0x006a, B:24:0x0052, B:26:0x0057, B:43:0x0017), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067 A[Catch: all -> 0x006b, TryCatch #2 {, blocks: (B:3:0x0001, B:6:0x000e, B:14:0x002f, B:33:0x0062, B:35:0x0067, B:36:0x006a, B:24:0x0052, B:26:0x0057, B:43:0x0017), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int f(String str, String str2) {
        String str3;
        String[] strArr;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Cursor cursor2 = null;
        cursor2 = null;
        cursor2 = null;
        SQLiteDatabase sQLiteDatabase2 = null;
        if (TextUtils.isEmpty(str2)) {
            str3 = null;
        } else {
            str3 = "uin=?";
        }
        if (TextUtils.isEmpty(str2)) {
            strArr = null;
        } else {
            strArr = new String[]{str2};
        }
        try {
            sQLiteDatabase = d();
        } catch (Exception e16) {
            e = e16;
            cursor = null;
        } catch (Throwable th5) {
            th = th5;
            sQLiteDatabase = null;
        }
        try {
            cursor2 = sQLiteDatabase.query(str, null, str3, strArr, null, null, null);
            int count = cursor2.getCount();
            cursor2.close();
            sQLiteDatabase.close();
            return count;
        } catch (Exception e17) {
            e = e17;
            Cursor cursor3 = cursor2;
            sQLiteDatabase2 = sQLiteDatabase;
            cursor = cursor3;
            try {
                e.printStackTrace();
                com.tencent.open.base.f.c("BusinessReport", e.getLocalizedMessage());
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                return 0;
            } catch (Throwable th6) {
                th = th6;
                SQLiteDatabase sQLiteDatabase3 = sQLiteDatabase2;
                cursor2 = cursor;
                sQLiteDatabase = sQLiteDatabase3;
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            if (cursor2 != null) {
            }
            if (sQLiteDatabase != null) {
            }
            throw th;
        }
    }

    public synchronized ArrayList<b> g(String str) {
        return i("table_new_data", str);
    }

    public synchronized ArrayList<b> h(String str) {
        return i("table_old_data", str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0104, code lost:
    
        if (r13 != null) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010b A[Catch: all -> 0x0114, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:6:0x0013, B:18:0x00e2, B:19:0x00e5, B:32:0x010b, B:34:0x0110, B:35:0x0113, B:27:0x0101, B:41:0x001b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0110 A[Catch: all -> 0x0114, TryCatch #1 {, blocks: (B:3:0x0001, B:6:0x0013, B:18:0x00e2, B:19:0x00e5, B:32:0x010b, B:34:0x0110, B:35:0x0113, B:27:0x0101, B:41:0x001b), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized ArrayList<b> i(String str, String str2) {
        ArrayList<b> arrayList;
        String str3;
        String[] strArr;
        SQLiteDatabase sQLiteDatabase;
        arrayList = new ArrayList<>();
        Cursor cursor = null;
        if (TextUtils.isEmpty(str2)) {
            str3 = null;
        } else {
            str3 = "uin=?";
        }
        if (TextUtils.isEmpty(str2)) {
            strArr = null;
        } else {
            strArr = new String[]{str2};
        }
        try {
            sQLiteDatabase = d();
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
                cursor = sQLiteDatabase.query(str, null, str3, strArr, null, null, null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    b bVar = new b();
                    bVar.f341105c = cursor.getString(cursor.getColumnIndex("actiontype"));
                    bVar.f341103a = cursor.getString(cursor.getColumnIndex("appid"));
                    bVar.f341107e = cursor.getString(cursor.getColumnIndex("qua"));
                    bVar.f341106d = cursor.getString(cursor.getColumnIndex("uin"));
                    bVar.f341104b = cursor.getString(cursor.getColumnIndex("via"));
                    bVar.f341108f = cursor.getString(cursor.getColumnIndex("network"));
                    bVar.f341109g = cursor.getString(cursor.getColumnIndex("timestamp"));
                    bVar.f341110h = cursor.getString(cursor.getColumnIndex("expand1"));
                    bVar.f341111i = cursor.getString(cursor.getColumnIndex("expand2"));
                    bVar.f341112j = cursor.getString(cursor.getColumnIndex("expand3"));
                    bVar.f341113k = cursor.getString(cursor.getColumnIndex("expand4"));
                    bVar.f341114l = cursor.getString(cursor.getColumnIndex("expand5"));
                    arrayList.add(bVar);
                    cursor.moveToNext();
                }
                cursor.close();
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
            e.printStackTrace();
            com.tencent.open.base.f.c("BusinessReport", e.getLocalizedMessage());
            if (cursor != null) {
                cursor.close();
            }
        }
        sQLiteDatabase.close();
        return arrayList;
    }

    public synchronized long k(String str, b bVar) {
        long j3;
        SQLiteDatabase d16 = d();
        if (d16 != null) {
            try {
                try {
                    j3 = j(d16, str, bVar);
                } finally {
                    d16.close();
                }
            } catch (Exception e16) {
                com.tencent.open.base.f.d("BusinessReport", "saveReportInfo err:", e16);
                d16.close();
            }
        }
        j3 = -1;
        return j3;
    }

    public synchronized int l(String str, ArrayList<b> arrayList) {
        com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
        SQLiteDatabase d16 = d();
        int i3 = 0;
        if (d16 == null) {
            return 0;
        }
        d16.beginTransaction();
        try {
            try {
                Iterator<b> it = arrayList.iterator();
                while (it.hasNext()) {
                    j(d16, str, it.next());
                    i3++;
                }
                d16.setTransactionSuccessful();
                try {
                    d16.endTransaction();
                } catch (Exception e16) {
                    com.tencent.open.base.f.d("BusinessReport", "saveReportInfoList endTransaction err", e16);
                }
                try {
                    d16.close();
                } catch (Exception e17) {
                    com.tencent.open.base.f.d("BusinessReport", "saveReportInfoList close err", e17);
                }
            } catch (Throwable th5) {
                try {
                    d16.endTransaction();
                } catch (Exception e18) {
                    com.tencent.open.base.f.d("BusinessReport", "saveReportInfoList endTransaction err", e18);
                }
                try {
                    d16.close();
                } catch (Exception e19) {
                    com.tencent.open.base.f.d("BusinessReport", "saveReportInfoList close err", e19);
                }
                com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
                throw th5;
            }
        } catch (Exception e26) {
            com.tencent.open.base.f.d("BusinessReport", "saveReportInfoList err:", e26);
            try {
                d16.endTransaction();
            } catch (Exception e27) {
                com.tencent.open.base.f.d("BusinessReport", "saveReportInfoList endTransaction err", e27);
            }
            try {
                d16.close();
            } catch (Exception e28) {
                com.tencent.open.base.f.d("BusinessReport", "saveReportInfoList close err", e28);
            }
        }
        com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
        return i3;
    }
}
