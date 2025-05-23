package com.tencent.open.business.viareport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f extends SQLiteOpenHelper {

    /* renamed from: i, reason: collision with root package name */
    protected static f f341117i;

    /* renamed from: d, reason: collision with root package name */
    protected String f341118d;

    /* renamed from: e, reason: collision with root package name */
    protected String f341119e;

    /* renamed from: f, reason: collision with root package name */
    protected String f341120f;

    /* renamed from: h, reason: collision with root package name */
    protected String f341121h;

    protected f(Context context) {
        super(context, "open_report.db", (SQLiteDatabase.CursorFactory) null, 3);
        this.f341118d = "CREATE TABLE IF NOT EXISTS table_new_data( _id INTEGER PRIMARY KEY,actiontype varchar,appid varchar,qua varchar,uin varchar,via varchar,network varchar,timestamp varchar,expand1 varchar,expand2 varchar,expand3 varchar,expand4 varchar,expand5 varchar);";
        this.f341119e = "CREATE TABLE IF NOT EXISTS table_old_data( _id INTEGER PRIMARY KEY,actiontype varchar,appid varchar,qua varchar,uin varchar,via varchar,network varchar,timestamp varchar,expand1 varchar,expand2 varchar,expand3 varchar,expand4 varchar,expand5 varchar);";
        this.f341120f = "CREATE TABLE IF NOT EXISTS table_appcircle_setting(_id INTEGER PRIMARY KEY AUTOINCREMENT,uin TEXT,key TEXT,value TEXT,data BLOB);";
        this.f341121h = "CREATE TABLE IF NOT EXISTS table_appcircle_report( _id INTEGER PRIMARY KEY,actiontype varchar,appid varchar,qua varchar,uin varchar,via varchar,network varchar,timestamp varchar,expand1 varchar,expand2 varchar,expand3 varchar,expand4 varchar,expand5 varchar);";
    }

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            if (f341117i == null) {
                f341117i = new f(context);
            }
            fVar = f341117i;
        }
        return fVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        com.tencent.open.base.f.e("opensdk", "sql1:" + this.f341118d);
        com.tencent.open.base.f.e("opensdk", "sql2:" + this.f341119e);
        sQLiteDatabase.execSQL(this.f341118d);
        sQLiteDatabase.execSQL(this.f341119e);
        Log.i("ReportSqliteHelper", "circleTest create table:" + this.f341120f);
        sQLiteDatabase.execSQL(this.f341120f);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_new_data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_old_data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_appcircle_setting");
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_new_data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_old_data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_appcircle_setting");
        onCreate(sQLiteDatabase);
    }
}
