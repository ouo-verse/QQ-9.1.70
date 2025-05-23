package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class af extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public static String f97974a = "bugly_db";

    /* renamed from: b, reason: collision with root package name */
    public static int f97975b = 29;

    /* renamed from: c, reason: collision with root package name */
    protected Context f97976c;

    /* renamed from: d, reason: collision with root package name */
    private List<o> f97977d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(Context context, List<o> list) {
        super(context, f97974a + "_", (SQLiteDatabase.CursorFactory) null, f97975b);
        ai.a(context).getClass();
        this.f97976c = context;
        this.f97977d = list;
    }

    private synchronized boolean a(SQLiteDatabase sQLiteDatabase) {
        try {
            String[] strArr = {"t_lr", "t_ui", "t_pf"};
            for (int i3 = 0; i3 < 3; i3++) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(strArr[i3])), new String[0]);
            }
        } catch (Throwable th5) {
            if (!av.b(th5)) {
                th5.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i3 = 0;
        while (sQLiteDatabase == null && i3 < 5) {
            i3++;
            try {
                sQLiteDatabase = super.getReadableDatabase();
            } catch (Throwable unused) {
                av.d("[Database] Try to get db(count: %d).", Integer.valueOf(i3));
                if (i3 == 5) {
                    av.e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    LockMethodProxy.sleep(200L);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i3 = 0;
        while (sQLiteDatabase == null && i3 < 5) {
            i3++;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (Throwable unused) {
                av.d("[Database] Try to get db(count: %d).", Integer.valueOf(i3));
                if (i3 == 5) {
                    av.e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    LockMethodProxy.sleep(200L);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
        }
        if (sQLiteDatabase == null) {
            av.d("[Database] db error delay error record 1min.", new Object[0]);
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.setLength(0);
            sb5.append(" CREATE TABLE IF NOT EXISTS t_ui ( _id INTEGER PRIMARY KEY , _tm int , _ut int , _tp int , _dt blob , _pc text ) ");
            av.c(sb5.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb5.toString(), new String[0]);
            sb5.setLength(0);
            sb5.append(" CREATE TABLE IF NOT EXISTS t_lr ( _id INTEGER PRIMARY KEY , _tp int , _tm int , _pc text , _th text , _dt blob ) ");
            av.c(sb5.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb5.toString(), new String[0]);
            sb5.setLength(0);
            sb5.append(" CREATE TABLE IF NOT EXISTS t_pf ( _id integer , _tp text , _tm int , _dt blob,primary key(_id,_tp )) ");
            av.c(sb5.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb5.toString(), new String[0]);
            sb5.setLength(0);
            sb5.append(" CREATE TABLE IF NOT EXISTS t_cr ( _id INTEGER PRIMARY KEY , _tm int , _s1 text , _up int , _me int , _uc int , _dt blob ) ");
            av.c(sb5.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb5.toString(), new String[0]);
            sb5.setLength(0);
            sb5.append(" CREATE TABLE IF NOT EXISTS dl_1002 (_id integer primary key autoincrement, _dUrl varchar(100), _sFile varchar(100), _sLen INTEGER, _tLen INTEGER, _MD5 varchar(100), _DLTIME INTEGER)");
            av.c(sb5.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb5.toString(), new String[0]);
            sb5.setLength(0);
            sb5.append("CREATE TABLE IF NOT EXISTS ge_1002 (_id integer primary key autoincrement, _time INTEGER, _datas blob)");
            av.c(sb5.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb5.toString(), new String[0]);
            sb5.setLength(0);
            sb5.append(" CREATE TABLE IF NOT EXISTS st_1002 ( _id integer , _tp text , _tm int , _dt blob,primary key(_id,_tp )) ");
            av.c(sb5.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb5.toString(), new String[0]);
            sb5.setLength(0);
            sb5.append(" CREATE TABLE IF NOT EXISTS t_sla ( _id TEXT NOT NULL , _tm INTEGER NOT NULL , _dt TEXT NOT NULL , PRIMARY KEY(_id) ) ");
            String sb6 = sb5.toString();
            av.c(sb6, new Object[0]);
            sQLiteDatabase.execSQL(sb6, new String[0]);
            sb5.setLength(0);
            sb5.append(" CREATE TABLE IF NOT EXISTS t_p_ctx ( _process_launch_id TEXT NOT NULL , _key TEXT NOT NULL , _value TEXT , _tm INTEGER NOT NULL , PRIMARY KEY (_process_launch_id,_key) ) ");
            String sb7 = sb5.toString();
            av.c(sb7, new Object[0]);
            sQLiteDatabase.execSQL(sb7, new String[0]);
        } catch (Throwable th5) {
            if (!av.b(th5)) {
                th5.printStackTrace();
            }
        }
        List<o> list = this.f97977d;
        if (list == null) {
            return;
        }
        Iterator<o> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().onDbCreate(sQLiteDatabase);
            } catch (Throwable th6) {
                if (!av.b(th6)) {
                    th6.printStackTrace();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @TargetApi(11)
    public final synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        if (aj.c() >= 11) {
            av.d("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i3), Integer.valueOf(i16));
            List<o> list = this.f97977d;
            if (list != null) {
                Iterator<o> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onDbDowngrade(sQLiteDatabase, i3, i16);
                    } catch (Throwable th5) {
                        if (!av.b(th5)) {
                            th5.printStackTrace();
                        }
                    }
                }
            }
            if (a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
                return;
            }
            av.d("[Database] Failed to drop, delete db.", new Object[0]);
            File databasePath = this.f97976c.getDatabasePath(f97974a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        av.d("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i3), Integer.valueOf(i16));
        List<o> list = this.f97977d;
        if (list != null) {
            Iterator<o> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onDbUpgrade(sQLiteDatabase, i3, i16);
                } catch (Throwable th5) {
                    if (!av.b(th5)) {
                        th5.printStackTrace();
                    }
                }
            }
        }
        if (a(sQLiteDatabase)) {
            onCreate(sQLiteDatabase);
            return;
        }
        av.d("[Database] Failed to drop, delete db.", new Object[0]);
        File databasePath = this.f97976c.getDatabasePath(f97974a);
        if (databasePath != null && databasePath.canWrite()) {
            databasePath.delete();
        }
    }
}
