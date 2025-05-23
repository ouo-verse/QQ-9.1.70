package com.tencent.gamecenter.wadl.sdk.downloader.task.g;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class a extends SQLiteOpenHelper {
    public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3) {
        super(context, str, cursorFactory, i3);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(a());
        } catch (SQLException e16) {
            throw e16;
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + c());
        } catch (SQLException e16) {
            e16.printStackTrace();
        }
    }

    protected abstract String a();

    protected abstract int b();

    protected abstract String c();

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        try {
            b(sQLiteDatabase);
            a(sQLiteDatabase);
        } catch (Exception e16) {
            e16.printStackTrace();
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
            if (version < b()) {
                onUpgrade(sQLiteDatabase, version, b());
            } else if (version > b()) {
                onDowngrade(sQLiteDatabase, version, b());
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        try {
            b(sQLiteDatabase);
            a(sQLiteDatabase);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
