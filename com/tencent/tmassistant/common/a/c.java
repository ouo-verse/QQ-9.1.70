package com.tencent.tmassistant.common.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.tencent.tmassistantbase.util.r;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class c extends SQLiteOpenHelper {
    public c(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3) {
        super(context, str, cursorFactory, i3);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        for (Class<?> cls : b()) {
            try {
                String createTableSQL = ((b) cls.newInstance()).createTableSQL();
                if (createTableSQL != null && createTableSQL.length() > 0) {
                    sQLiteDatabase.execSQL(createTableSQL);
                }
            } catch (IllegalAccessException e16) {
                r.a("SqliteHelper", "exception: ", e16);
                e16.printStackTrace();
            } catch (InstantiationException e17) {
                r.a("SqliteHelper", "exception: ", e17);
                e17.printStackTrace();
            }
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        for (Class<?> cls : b()) {
            try {
                sQLiteDatabase.delete(((b) cls.newInstance()).tableName(), null, null);
            } catch (IllegalAccessException e16) {
                r.a("SqliteHelper", "exception: ", e16);
                e16.printStackTrace();
            } catch (InstantiationException e17) {
                r.a("SqliteHelper", "exception: ", e17);
                e17.printStackTrace();
            }
        }
    }

    public abstract int a();

    public abstract Class<?>[] b();

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = super.getReadableDatabase();
            while (true) {
                try {
                    if (!sQLiteDatabase.isDbLockedByCurrentThread() && !sQLiteDatabase.isDbLockedByOtherThreads()) {
                        break;
                    }
                    SystemClock.sleep(10L);
                } catch (Exception e16) {
                    e = e16;
                    r.a("SqliteHelper", "exception: ", e);
                    e.printStackTrace();
                    return sQLiteDatabase;
                }
            }
        } catch (Exception e17) {
            e = e17;
            sQLiteDatabase = null;
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = super.getWritableDatabase();
            while (true) {
                try {
                    if (!sQLiteDatabase.isDbLockedByCurrentThread() && !sQLiteDatabase.isDbLockedByOtherThreads()) {
                        break;
                    }
                    SystemClock.sleep(10L);
                } catch (Exception e16) {
                    e = e16;
                    r.a("SqliteHelper", "exception: ", e);
                    e.printStackTrace();
                    return sQLiteDatabase;
                }
            }
        } catch (Exception e17) {
            e = e17;
            sQLiteDatabase = null;
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        b(sQLiteDatabase);
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        int version = sQLiteDatabase.getVersion();
        if (version != 0) {
            if (version < a()) {
                onUpgrade(sQLiteDatabase, version, a());
            } else if (version > a()) {
                onDowngrade(sQLiteDatabase, version, a());
            } else {
                a(sQLiteDatabase);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        while (i3 < i16) {
            for (Class<?> cls : b()) {
                try {
                    String[] alterSQL = ((b) cls.newInstance()).getAlterSQL(i3, i3 + 1);
                    if (alterSQL != null) {
                        for (String str : alterSQL) {
                            sQLiteDatabase.execSQL(str);
                        }
                    }
                } catch (Exception e16) {
                    r.a("SqliteHelper", "exception: ", e16);
                    e16.printStackTrace();
                }
            }
            i3++;
        }
    }
}
