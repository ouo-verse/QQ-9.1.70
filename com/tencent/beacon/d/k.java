package com.tencent.beacon.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.module.ModuleName;
import com.tencent.beacon.module.StrategyModule;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static String f77873a;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a extends SQLiteOpenHelper {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a(@Nullable Context context, @Nullable String str) {
            super(context, r4, (SQLiteDatabase.CursorFactory) null, 30);
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "beacon_db";
            } else {
                str2 = "beacon_db_" + str;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s int unique , %s int , %s blob)", "t_strategy", "_id", "_key", "_ut", "_datas"));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
            com.tencent.beacon.base.util.c.a("[db] Upgrade a db  [%s] from v %d to v %d , deleted all tables!", "beacon_db", Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public static String a() {
        if (!TextUtils.isEmpty(f77873a)) {
            return f77873a;
        }
        com.tencent.beacon.a.d.a a16 = com.tencent.beacon.a.d.a.a();
        f77873a = a16.getString("initsdkdate", "");
        if (!com.tencent.beacon.base.util.b.d().equals(f77873a)) {
            a.SharedPreferencesEditorC0784a edit = a16.edit();
            if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                edit.putString("initsdkdate", com.tencent.beacon.base.util.b.d());
            }
        }
        return f77873a;
    }

    public static boolean b() {
        int i3;
        com.tencent.beacon.a.d.a a16 = com.tencent.beacon.a.d.a.a();
        if (com.tencent.beacon.base.util.b.d().equals(a())) {
            i3 = a16.getInt("QUERY_TIMES_KEY", 0);
        } else {
            i3 = 0;
        }
        if (i3 <= com.tencent.beacon.d.a.a().c()) {
            int i16 = i3 + 1;
            a.SharedPreferencesEditorC0784a edit = a16.edit();
            if (!com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                return false;
            }
            edit.putInt("QUERY_TIMES_KEY", i16);
            return false;
        }
        com.tencent.beacon.base.util.c.d("[strategy] sdk init max times", new Object[0]);
        return true;
    }

    public static boolean c() {
        b b16 = ((StrategyModule) com.tencent.beacon.a.c.c.c().a(ModuleName.STRATEGY)).b();
        if (b16.n()) {
            com.tencent.beacon.a.d.a a16 = com.tencent.beacon.a.d.a.a();
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = ((currentTimeMillis / 60000) + 480) % 1440;
            if (j3 >= 0 && j3 <= 30 && currentTimeMillis - a16.getLong("last_success_strategy_query_time", 0L) <= 90000000) {
                return true;
            }
            if (com.tencent.beacon.base.util.b.d().equals(a())) {
                if (a16.getInt("today_success_strategy_query_times", 0) < b16.e()) {
                    return false;
                }
                return true;
            }
            a.SharedPreferencesEditorC0784a edit = a16.edit();
            if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                edit.putInt("today_success_strategy_query_times", 0);
            }
        }
        return false;
    }

    public static void d() {
        b b16 = ((StrategyModule) com.tencent.beacon.a.c.c.c().a(ModuleName.STRATEGY)).b();
        if (b16 != null && b16.n()) {
            com.tencent.beacon.a.d.a a16 = com.tencent.beacon.a.d.a.a();
            int i3 = a16.getInt("today_success_strategy_query_times", 0) + 1;
            a.SharedPreferencesEditorC0784a edit = a16.edit();
            if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                edit.putInt("today_success_strategy_query_times", i3).putLong("last_success_strategy_query_time", System.currentTimeMillis());
            }
        }
    }

    public static synchronized j a(Context context, int i3) {
        SQLiteDatabase sQLiteDatabase;
        j jVar;
        synchronized (k.class) {
            Cursor cursor = null;
            r3 = null;
            j jVar2 = null;
            r3 = null;
            Cursor cursor2 = null;
            cursor = null;
            if (context == null) {
                com.tencent.beacon.base.util.c.e("[db] context is null", new Object[0]);
                return null;
            }
            try {
                try {
                    sQLiteDatabase = new a(context, com.tencent.beacon.a.c.c.c().e()).getWritableDatabase();
                    try {
                    } catch (Exception e16) {
                        e = e16;
                        jVar = null;
                    }
                } catch (Exception e17) {
                    e = e17;
                    jVar = null;
                    sQLiteDatabase = null;
                } catch (Throwable th5) {
                    th = th5;
                    sQLiteDatabase = null;
                }
                if (sQLiteDatabase == null) {
                    com.tencent.beacon.base.util.c.e("[db] getWritableDatabase fail!", new Object[0]);
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                    return null;
                }
                Locale locale = Locale.US;
                Object[] objArr = new Object[2];
                objArr[0] = "_key";
                objArr[1] = Integer.valueOf(i3);
                Cursor query = sQLiteDatabase.query("t_strategy", null, String.format(locale, " %s = %d ", objArr), null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToNext() && (jVar2 = a(query)) != null) {
                            com.tencent.beacon.base.util.c.a("[db] read strategy key: %d", Integer.valueOf(jVar2.f77871b));
                        }
                    } catch (Exception e18) {
                        e = e18;
                        jVar = null;
                        cursor2 = query;
                        com.tencent.beacon.a.b.i.e().a("605", "[db] TB: t_strategy query fail!");
                        com.tencent.beacon.base.util.c.a(e);
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                        jVar2 = jVar;
                        return jVar2;
                    } catch (Throwable th6) {
                        th = th6;
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
                if (sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                return jVar2;
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    private static j a(Cursor cursor) {
        if (cursor == null || cursor.isBeforeFirst() || cursor.isAfterLast()) {
            return null;
        }
        com.tencent.beacon.base.util.c.a("[db] parse bean.", new Object[0]);
        j jVar = new j();
        jVar.f77870a = cursor.getLong(cursor.getColumnIndex("_id"));
        jVar.f77871b = cursor.getInt(cursor.getColumnIndex("_key"));
        jVar.f77872c = cursor.getBlob(cursor.getColumnIndex("_datas"));
        return jVar;
    }
}
