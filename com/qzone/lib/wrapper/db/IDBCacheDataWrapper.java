package com.qzone.lib.wrapper.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface IDBCacheDataWrapper {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a<T extends IDBCacheDataWrapper> {
        T createFromCursor(Cursor cursor);

        String sortOrder();

        c[] structure();

        int version();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b<T extends IDBCacheDataWrapper> extends a<T> {
        int delRawSql(SQLiteDatabase sQLiteDatabase, String str, String str2);

        String indexRawSql(String str);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f48306a;

        /* renamed from: b, reason: collision with root package name */
        public String f48307b;

        public c(String str, String str2) {
            this.f48306a = str;
            this.f48307b = str2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface d<T extends IDBCacheDataWrapper> extends b<T> {
        boolean needEncrypt(int i3, int i16);

        String[] onUpdate(int i3, int i16);
    }

    void readFrom(ContentValues contentValues);

    void writeTo(ContentValues contentValues);
}
