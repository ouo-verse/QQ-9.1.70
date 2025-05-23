package com.tencent.mobileqq.qcircle.api.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface IDBCacheDataWrapper {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface DbCreator<T extends IDBCacheDataWrapper> {
        T createFromCursor(Cursor cursor);

        String sortOrder();

        Structure[] structure();

        int version();
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface PrePareDbCreator<T extends IDBCacheDataWrapper> extends DbCreator<T> {
        Pair<String, String[]> rawSql(String str, String str2, String str3, String str4);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface RawDbCreator<T extends IDBCacheDataWrapper> extends DbCreator<T> {
        int delRawSql(SQLiteDatabase sQLiteDatabase, String str, String str2);

        String indexRawSql(String str);

        String queryRawSql(String str, String str2, String str3, String str4);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class SaveStrategy {
        public static final int APPEND = 1;
        public static final int CLEAR = 2;
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class Structure {
        public String mName;
        public String mType;

        public Structure(String str, String str2) {
            this.mName = str;
            this.mType = str2;
        }

        public String getName() {
            return this.mName;
        }

        public String getType() {
            return this.mType;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface UpdateDbCreator<T extends IDBCacheDataWrapper> extends RawDbCreator<T> {
        boolean needEncrypt(int i3, int i16);

        String[] onUpdate(int i3, int i16);
    }

    void readFrom(ContentValues contentValues);

    void writeTo(ContentValues contentValues);
}
