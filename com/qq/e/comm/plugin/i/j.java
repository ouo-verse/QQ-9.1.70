package com.qq.e.comm.plugin.i;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class j {

    /* renamed from: b, reason: collision with root package name */
    private static final Object f39583b = new Object();

    /* renamed from: a, reason: collision with root package name */
    private com.qq.e.comm.plugin.i.b.b f39584a;

    public j(Context context) {
        this.f39584a = new com.qq.e.comm.plugin.i.b.b(context);
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        synchronized (f39583b) {
            try {
                sQLiteDatabase.execSQL("create table downloadThreadInfoDao(_id integer primary key autoincrement, id integer, tag text, uri text, start long, end long, finished long)");
            } finally {
            }
        }
    }

    private SQLiteDatabase b() {
        return this.f39584a.getWritableDatabase();
    }

    private SQLiteDatabase c() {
        try {
            return this.f39584a.getReadableDatabase();
        } catch (Throwable th5) {
            GDTLogger.e("getReadableDatabase error: " + th5);
            return null;
        }
    }

    public static void b(SQLiteDatabase sQLiteDatabase) {
        synchronized (f39583b) {
            sQLiteDatabase.execSQL("drop table if exists downloadThreadInfoDao");
        }
    }

    public void a(i iVar) {
        synchronized (f39583b) {
            try {
                b().execSQL("insert into downloadThreadInfoDao(id, tag, uri, start, end, finished) values(?, ?, ?, ?, ?, ?)", new Object[]{Integer.valueOf(iVar.c()), iVar.e(), iVar.f(), Long.valueOf(iVar.d()), Long.valueOf(iVar.a()), Long.valueOf(iVar.b())});
            } finally {
            }
        }
    }

    public List<i> b(String str) {
        synchronized (f39583b) {
            ArrayList arrayList = new ArrayList();
            SQLiteDatabase c16 = c();
            if (c16 == null) {
                return arrayList;
            }
            try {
                Cursor rawQuery = c16.rawQuery("select * from downloadThreadInfoDao where tag = ?", new String[]{str});
                while (rawQuery.moveToNext()) {
                    i iVar = new i();
                    iVar.a(rawQuery.getInt(rawQuery.getColumnIndex("id")));
                    iVar.a(rawQuery.getString(rawQuery.getColumnIndex("tag")));
                    iVar.b(rawQuery.getString(rawQuery.getColumnIndex(LayoutAttrDefine.CLICK_URI)));
                    iVar.a(rawQuery.getLong(rawQuery.getColumnIndex("end")));
                    iVar.c(rawQuery.getLong(rawQuery.getColumnIndex("start")));
                    iVar.b(rawQuery.getLong(rawQuery.getColumnIndex(IXWebBroadcastListener.STAGE_FINISHED)));
                    arrayList.add(iVar);
                }
                rawQuery.close();
            } catch (Throwable th5) {
                GDTLogger.e("get download thread info error", th5);
            }
            return arrayList;
        }
    }

    public void a(String str) {
        synchronized (f39583b) {
            try {
                b().execSQL("delete from downloadThreadInfoDao where tag = ?", new Object[]{str});
            } finally {
            }
        }
    }

    public void a(String str, int i3, long j3) {
        synchronized (f39583b) {
            try {
                b().execSQL("update downloadThreadInfoDao set finished = ? where tag = ? and id = ? ", new Object[]{Long.valueOf(j3), str, Integer.valueOf(i3)});
            } finally {
            }
        }
    }

    public boolean a(String str, int i3) {
        synchronized (f39583b) {
            SQLiteDatabase c16 = c();
            if (c16 == null) {
                return false;
            }
            try {
                Cursor rawQuery = c16.rawQuery("select * from downloadThreadInfoDao where tag = ? and id = ?", new String[]{str, i3 + ""});
                boolean moveToNext = rawQuery.moveToNext();
                rawQuery.close();
                return moveToNext;
            } catch (Throwable th5) {
                GDTLogger.e("exists error", th5);
                return false;
            }
        }
    }

    public void a() {
        synchronized (f39583b) {
            this.f39584a.close();
        }
    }
}
