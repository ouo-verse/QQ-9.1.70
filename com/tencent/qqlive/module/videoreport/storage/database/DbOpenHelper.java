package com.tencent.qqlive.module.videoreport.storage.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: P */
/* loaded from: classes22.dex */
class DbOpenHelper extends SQLiteOpenHelper {
    public DbOpenHelper(Context context) {
        super(context.getApplicationContext(), "datong_storage", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(DbConst.CREATE_TABLE_COMMAND);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        sQLiteDatabase.execSQL(DbConst.DELETE_TABLE_COMMAND);
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        sQLiteDatabase.execSQL(DbConst.DELETE_TABLE_COMMAND);
        onCreate(sQLiteDatabase);
    }
}
