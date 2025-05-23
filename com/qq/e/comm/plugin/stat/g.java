package com.qq.e.comm.plugin.stat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.qq.e.comm.plugin.stat.q;
import com.qq.e.comm.util.GDTLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public class g extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private static volatile g f39713a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, q> f39714b;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    g(Context context) {
        super(r0, r4, (SQLiteDatabase.CursorFactory) null, 2);
        String str;
        com.qq.e.comm.plugin.stat.a.a aVar = new com.qq.e.comm.plugin.stat.a.a(context, "gdt_database");
        if (com.qq.e.comm.plugin.j.c.e()) {
            str = "gdt_tg_stat.db";
        } else {
            str = "gdt_stat.db";
        }
        this.f39714b = new ConcurrentHashMap(5);
        c();
    }

    public static g a(Context context) {
        if (f39713a == null) {
            synchronized (g.class) {
                if (f39713a == null) {
                    f39713a = new g(context);
                }
            }
        }
        if (f39713a.f39714b.isEmpty()) {
            f39713a.c();
        }
        return f39713a;
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            GDTLogger.d("No stat db!");
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            Iterator<q> it = this.f39714b.values().iterator();
            while (it.hasNext()) {
                it.next().a(sQLiteDatabase);
            }
            sQLiteDatabase.setTransactionSuccessful();
            GDTLogger.d("Create stat db success");
        } finally {
            try {
            } finally {
            }
        }
    }

    private void c() {
        this.f39714b.put("event", new q("event", new q.a<i>() { // from class: com.qq.e.comm.plugin.stat.g.1
            @Override // com.qq.e.comm.plugin.stat.q.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i b(int i3, String str) {
                return e.a(i3, str);
            }
        }));
        this.f39714b.put("log", new q("log", new q.a<n>() { // from class: com.qq.e.comm.plugin.stat.g.2
            @Override // com.qq.e.comm.plugin.stat.q.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public n b(int i3, String str) {
                return e.b(i3, str);
            }
        }));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        a(sQLiteDatabase);
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        a(sQLiteDatabase);
        b(sQLiteDatabase);
    }

    public void a() {
        Iterator<q> it = this.f39714b.values().iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q b() {
        return this.f39714b.get("event");
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            GDTLogger.d("No stat db!");
            return;
        }
        try {
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<q> it = this.f39714b.values().iterator();
                while (it.hasNext()) {
                    it.next().b(sQLiteDatabase);
                }
                sQLiteDatabase.setTransactionSuccessful();
                GDTLogger.d("Drop stat db success");
            } finally {
                sQLiteDatabase.endTransaction();
            }
        } catch (Throwable unused) {
            GDTLogger.d("Drop stat table failed!");
        }
    }
}
