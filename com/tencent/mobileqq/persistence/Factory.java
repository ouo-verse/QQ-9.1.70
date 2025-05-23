package com.tencent.mobileqq.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import com.tencent.mobileqq.utils.SecurityUtile;

/* compiled from: P */
/* loaded from: classes16.dex */
public class Factory implements SQLiteDatabase.CursorFactory {
    private final EntityManagerFactory mEmf;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends SQLiteCursor {
        a(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            super(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
        }

        @Override // android.database.AbstractWindowedCursor, android.database.AbstractCursor, android.database.Cursor
        public byte[] getBlob(int i3) {
            byte[] blob = super.getBlob(i3);
            if (Factory.this.mEmf.isNeedEncrypt()) {
                return SecurityUtile.encode(blob);
            }
            return blob;
        }

        @Override // android.database.AbstractWindowedCursor, android.database.AbstractCursor, android.database.Cursor
        public String getString(int i3) {
            String string = super.getString(i3);
            if (Factory.this.mEmf.isNeedEncrypt()) {
                try {
                    return SecurityUtile.decode(string);
                } catch (Exception unused) {
                    return string;
                }
            }
            return string;
        }
    }

    public Factory(EntityManagerFactory entityManagerFactory) {
        this.mEmf = entityManagerFactory;
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        return new a(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }
}
