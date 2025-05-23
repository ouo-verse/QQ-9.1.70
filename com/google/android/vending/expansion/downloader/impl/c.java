package com.google.android.vending.expansion.downloader.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.provider.BaseColumns;
import android.util.Log;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: h, reason: collision with root package name */
    private static c f34597h;

    /* renamed from: i, reason: collision with root package name */
    private static final String[] f34598i = {"FN", "URI", "ETAG", "TOTALBYTES", "CURRENTBYTES", "LASTMOD", CommonConstant.RETKEY.STATUS, QAdPlayStrategyDefine$PlayStrategyKey.CONTROL, "FAILCOUNT", "RETRYAFTER", "REDIRECTCOUNT", "FILEIDX"};

    /* renamed from: a, reason: collision with root package name */
    final SQLiteOpenHelper f34599a;

    /* renamed from: b, reason: collision with root package name */
    SQLiteStatement f34600b;

    /* renamed from: c, reason: collision with root package name */
    SQLiteStatement f34601c;

    /* renamed from: d, reason: collision with root package name */
    long f34602d;

    /* renamed from: e, reason: collision with root package name */
    int f34603e;

    /* renamed from: f, reason: collision with root package name */
    int f34604f;

    /* renamed from: g, reason: collision with root package name */
    int f34605g;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements BaseColumns {

        /* renamed from: d, reason: collision with root package name */
        public static final String[][] f34606d = {new String[]{"_id", "INTEGER PRIMARY KEY"}, new String[]{"FILEIDX", "INTEGER UNIQUE"}, new String[]{"URI", "TEXT"}, new String[]{"FN", "TEXT UNIQUE"}, new String[]{"ETAG", "TEXT"}, new String[]{"TOTALBYTES", "INTEGER"}, new String[]{"CURRENTBYTES", "INTEGER"}, new String[]{"LASTMOD", "INTEGER"}, new String[]{CommonConstant.RETKEY.STATUS, "INTEGER"}, new String[]{QAdPlayStrategyDefine$PlayStrategyKey.CONTROL, "INTEGER"}, new String[]{"FAILCOUNT", "INTEGER"}, new String[]{"RETRYAFTER", "INTEGER"}, new String[]{"REDIRECTCOUNT", "INTEGER"}};
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    protected static class b extends SQLiteOpenHelper {

        /* renamed from: d, reason: collision with root package name */
        private static final String[][][] f34607d = {a.f34606d, C0241c.f34609d};

        /* renamed from: e, reason: collision with root package name */
        private static final String[] f34608e = {"DownloadColumns", "MetadataColumns"};

        b(Context context) {
            super(context, "DownloadsDB", (SQLiteDatabase.CursorFactory) null, 7);
        }

        private String a(String str, String[][] strArr) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("CREATE TABLE ");
            sb5.append(str);
            sb5.append(" (");
            for (String[] strArr2 : strArr) {
                sb5.append(TokenParser.SP);
                sb5.append(strArr2[0]);
                sb5.append(TokenParser.SP);
                sb5.append(strArr2[1]);
                sb5.append(',');
            }
            sb5.setLength(sb5.length() - 1);
            sb5.append(");");
            return sb5.toString();
        }

        private void b(SQLiteDatabase sQLiteDatabase) {
            for (String str : f34608e) {
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            int length = f34607d.length;
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    sQLiteDatabase.execSQL(a(f34608e[i3], f34607d[i3]));
                } catch (Exception e16) {
                    while (true) {
                        e16.printStackTrace();
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
            Log.w(b.class.getName(), "Upgrading database from version " + i3 + " to " + i16 + ", which will destroy all old data");
            b(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    /* compiled from: P */
    /* renamed from: com.google.android.vending.expansion.downloader.impl.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0241c implements BaseColumns {

        /* renamed from: d, reason: collision with root package name */
        public static final String[][] f34609d = {new String[]{"_id", "INTEGER PRIMARY KEY"}, new String[]{"APKVERSION", "INTEGER"}, new String[]{"DOWNLOADSTATUS", "INTEGER"}, new String[]{"DOWNLOADFLAGS", "INTEGER"}};
    }

    c(Context context) {
        this.f34602d = -1L;
        this.f34603e = -1;
        this.f34604f = -1;
        b bVar = new b(context);
        this.f34599a = bVar;
        Cursor rawQuery = bVar.getReadableDatabase().rawQuery("SELECT APKVERSION,_id,DOWNLOADSTATUS,DOWNLOADFLAGS FROM MetadataColumns LIMIT 1", null);
        if (rawQuery != null && rawQuery.moveToFirst()) {
            this.f34603e = rawQuery.getInt(0);
            this.f34602d = rawQuery.getLong(1);
            this.f34604f = rawQuery.getInt(2);
            this.f34605g = rawQuery.getInt(3);
            rawQuery.close();
        }
        f34597h = this;
    }

    public static synchronized c a(Context context) {
        synchronized (c.class) {
            c cVar = f34597h;
            if (cVar == null) {
                return new c(context);
            }
            return cVar;
        }
    }

    private SQLiteStatement b() {
        if (this.f34600b == null) {
            this.f34600b = this.f34599a.getReadableDatabase().compileStatement("SELECT _id FROM DownloadColumns WHERE FILEIDX = ?");
        }
        return this.f34600b;
    }

    private SQLiteStatement h() {
        if (this.f34601c == null) {
            this.f34601c = this.f34599a.getReadableDatabase().compileStatement("UPDATE DownloadColumns SET CURRENTBYTES = ? WHERE FILEIDX = ?");
        }
        return this.f34601c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.google.android.vending.expansion.downloader.impl.a c(String str) {
        Throwable th5;
        Cursor cursor;
        try {
            cursor = this.f34599a.getReadableDatabase().query("DownloadColumns", f34598i, "FN = ?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        com.google.android.vending.expansion.downloader.impl.a d16 = d(cursor);
                        cursor.close();
                        return d16;
                    }
                } catch (Throwable th6) {
                    th5 = th6;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th5;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th7) {
            th5 = th7;
            cursor = null;
        }
    }

    public com.google.android.vending.expansion.downloader.impl.a d(Cursor cursor) {
        com.google.android.vending.expansion.downloader.impl.a aVar = new com.google.android.vending.expansion.downloader.impl.a(cursor.getInt(11), cursor.getString(0), getClass().getPackage().getName());
        i(aVar, cursor);
        return aVar;
    }

    public com.google.android.vending.expansion.downloader.impl.a[] e() {
        Cursor cursor;
        Throwable th5;
        try {
            cursor = this.f34599a.getReadableDatabase().query("DownloadColumns", f34598i, null, null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        com.google.android.vending.expansion.downloader.impl.a[] aVarArr = new com.google.android.vending.expansion.downloader.impl.a[cursor.getCount()];
                        int i3 = 0;
                        while (true) {
                            int i16 = i3 + 1;
                            aVarArr[i3] = d(cursor);
                            if (!cursor.moveToNext()) {
                                cursor.close();
                                return aVarArr;
                            }
                            i3 = i16;
                        }
                    }
                } catch (Throwable th6) {
                    th5 = th6;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th5;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th7) {
            cursor = null;
            th5 = th7;
        }
    }

    public long f(int i3) {
        SQLiteStatement b16 = b();
        b16.clearBindings();
        b16.bindLong(1, i3);
        try {
            return b16.simpleQueryForLong();
        } catch (SQLiteDoneException unused) {
            return -1L;
        }
    }

    public long g(com.google.android.vending.expansion.downloader.impl.a aVar) {
        return f(aVar.f34572b);
    }

    public void i(com.google.android.vending.expansion.downloader.impl.a aVar, Cursor cursor) {
        aVar.f34571a = cursor.getString(1);
        aVar.f34574d = cursor.getString(2);
        aVar.f34575e = cursor.getLong(3);
        aVar.f34576f = cursor.getLong(4);
        aVar.f34577g = cursor.getLong(5);
        aVar.f34578h = cursor.getInt(6);
        aVar.f34579i = cursor.getInt(7);
        aVar.f34580j = cursor.getInt(8);
        aVar.f34581k = cursor.getInt(9);
        aVar.f34582l = cursor.getInt(10);
    }

    public boolean j(com.google.android.vending.expansion.downloader.impl.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("FILEIDX", Integer.valueOf(aVar.f34572b));
        contentValues.put("FN", aVar.f34573c);
        contentValues.put("URI", aVar.f34571a);
        contentValues.put("ETAG", aVar.f34574d);
        contentValues.put("TOTALBYTES", Long.valueOf(aVar.f34575e));
        contentValues.put("CURRENTBYTES", Long.valueOf(aVar.f34576f));
        contentValues.put("LASTMOD", Long.valueOf(aVar.f34577g));
        contentValues.put(CommonConstant.RETKEY.STATUS, Integer.valueOf(aVar.f34578h));
        contentValues.put(QAdPlayStrategyDefine$PlayStrategyKey.CONTROL, Integer.valueOf(aVar.f34579i));
        contentValues.put("FAILCOUNT", Integer.valueOf(aVar.f34580j));
        contentValues.put("RETRYAFTER", Integer.valueOf(aVar.f34581k));
        contentValues.put("REDIRECTCOUNT", Integer.valueOf(aVar.f34582l));
        return k(aVar, contentValues);
    }

    public boolean k(com.google.android.vending.expansion.downloader.impl.a aVar, ContentValues contentValues) {
        long g16;
        if (aVar == null) {
            g16 = -1;
        } else {
            g16 = g(aVar);
        }
        try {
            SQLiteDatabase writableDatabase = this.f34599a.getWritableDatabase();
            if (g16 != -1) {
                writableDatabase.update("DownloadColumns", contentValues, "DownloadColumns._id = " + g16, null);
                return false;
            }
            if (-1 == writableDatabase.insert("DownloadColumns", "URI", contentValues)) {
                return false;
            }
            return true;
        } catch (SQLiteException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public void l(com.google.android.vending.expansion.downloader.impl.a aVar) {
        SQLiteStatement h16 = h();
        h16.clearBindings();
        h16.bindLong(1, aVar.f34576f);
        h16.bindLong(2, aVar.f34572b);
        h16.execute();
    }

    public boolean m(int i3) {
        if (this.f34605g == i3) {
            return true;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("DOWNLOADFLAGS", Integer.valueOf(i3));
        if (p(contentValues)) {
            this.f34605g = i3;
            return true;
        }
        return false;
    }

    public boolean n(com.google.android.vending.expansion.downloader.impl.a aVar) {
        Cursor cursor = null;
        try {
            cursor = this.f34599a.getReadableDatabase().query("DownloadColumns", f34598i, "FN= ?", new String[]{aVar.f34573c}, null, null, null);
            if (cursor == null || !cursor.moveToFirst()) {
                return false;
            }
            i(aVar, cursor);
            cursor.close();
            return true;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public boolean o(int i3, int i16) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("APKVERSION", Integer.valueOf(i3));
        contentValues.put("DOWNLOADSTATUS", Integer.valueOf(i16));
        if (p(contentValues)) {
            this.f34603e = i3;
            this.f34604f = i16;
            return true;
        }
        return false;
    }

    public boolean p(ContentValues contentValues) {
        SQLiteDatabase writableDatabase = this.f34599a.getWritableDatabase();
        if (-1 == this.f34602d) {
            long insert = writableDatabase.insert("MetadataColumns", "APKVERSION", contentValues);
            if (-1 == insert) {
                return false;
            }
            this.f34602d = insert;
            return true;
        }
        if (writableDatabase.update("MetadataColumns", contentValues, "_id = " + this.f34602d, null) == 0) {
            return false;
        }
        return true;
    }

    public boolean q(int i3) {
        if (this.f34604f == i3) {
            return true;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("DOWNLOADSTATUS", Integer.valueOf(i3));
        if (p(contentValues)) {
            this.f34604f = i3;
            return true;
        }
        return false;
    }
}
