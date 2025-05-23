package com.tencent.beacon.a.d;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.beacon.a.b.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private String f77686a;

    public c(String str) {
        super(com.tencent.beacon.a.c.c.c().b(), "beacon_db_" + str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f77686a = "";
        com.tencent.beacon.base.util.c.a("[DB]", 0, "DBOpenHelper construc.", new Object[0]);
        this.f77686a = "beacon_db_" + str;
    }

    private boolean a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        try {
            ArrayList<String> arrayList = new ArrayList();
            cursor = sQLiteDatabase.query("sqlite_master", new String[]{"name"}, "type = 'table'", null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        arrayList.add(cursor.getString(0));
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            i.e().a("608", "[db] drop all tables error! ", th);
                            com.tencent.beacon.base.util.c.a(th);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return false;
                        } finally {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                for (String str : arrayList) {
                    if (!str.equals("sqlite_sequence") && !str.equals("android_metadata")) {
                        sQLiteDatabase.execSQL("drop table if exists " + str);
                        com.tencent.beacon.base.util.c.a("[DB]", 1, "[db] drop %s", str);
                    }
                }
            }
            return true;
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        if (a(sQLiteDatabase)) {
            com.tencent.beacon.base.util.c.a("[DB]", 0, "[db] drop all success recreate!", new Object[0]);
            onCreate(sQLiteDatabase);
            return;
        }
        com.tencent.beacon.base.util.c.e("[db] drop all fail try deleted file,may next time will success!", new Object[0]);
        File databasePath = com.tencent.beacon.a.c.c.c().b().getDatabasePath(this.f77686a);
        if (databasePath != null && databasePath.canWrite()) {
            databasePath.delete();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        super.onConfigure(sQLiteDatabase);
        sQLiteDatabase.setPageSize(4096L);
        sQLiteDatabase.enableWriteAheadLogging();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        com.tencent.beacon.base.util.c.a("[DB]", 0, "DBOpenHelper onCreate.", new Object[0]);
        try {
            Iterator<String> it = b.f77685a.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(it.next());
            }
        } catch (SQLException e16) {
            i.e().a("601", "error msg: " + e16.getMessage(), e16);
            com.tencent.beacon.base.util.c.b("[DB] crate db table error!", new Object[0]);
            com.tencent.beacon.base.util.c.a(e16);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        com.tencent.beacon.base.util.c.a("[DB]", 0, "[db] Downgrade a db  [%s] from v %d to  v%d , deleted all tables!", this.f77686a, Integer.valueOf(i3), Integer.valueOf(i16));
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        com.tencent.beacon.base.util.c.a("[DB]", 0, "[db] Upgrade a db  [%s] from v %d to v %d , deleted all tables!", this.f77686a, Integer.valueOf(i3), Integer.valueOf(i16));
        b(sQLiteDatabase);
    }
}
