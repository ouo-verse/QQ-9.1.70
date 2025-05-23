package com.tencent.mobileqq.persistence;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface ISQLiteOpenHelper {
    void close();

    void dropAllTable();

    String getDatabaseName();

    SQLiteDatabase getReadableDatabase();

    SQLiteDatabase getReadableDatabaseInner();

    SQLiteDatabase getWritableDatabase();

    SQLiteDatabase getWritableDatabaseInner();

    void onCreate(SQLiteDatabase sQLiteDatabase);

    void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16);

    void onOpen(SQLiteDatabase sQLiteDatabase);

    void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16);
}
