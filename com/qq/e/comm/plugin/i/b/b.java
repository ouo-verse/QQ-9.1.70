package com.qq.e.comm.plugin.i.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.qq.e.comm.plugin.i.j;
import com.qq.e.comm.plugin.j.c;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends SQLiteOpenHelper {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(Context context) {
        super(r0, r4, (SQLiteDatabase.CursorFactory) null, 1);
        String str;
        com.qq.e.comm.plugin.stat.a.a aVar = new com.qq.e.comm.plugin.stat.a.a(context, "gdt_database");
        if (c.e()) {
            str = "gdt_tg_download.db";
        } else {
            str = "gdt_download.db";
        }
    }

    void a(SQLiteDatabase sQLiteDatabase) {
        j.a(sQLiteDatabase);
    }

    void b(SQLiteDatabase sQLiteDatabase) {
        j.b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        b(sQLiteDatabase);
        a(sQLiteDatabase);
    }
}
