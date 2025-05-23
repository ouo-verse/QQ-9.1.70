package com.tencent.luggage.wxa.bq;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.luggage.wxa.bq.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends SQLiteOpenHelper implements d {

    /* renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f123116a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends CursorWrapper {
        public a(Cursor cursor) {
            super(cursor);
        }

        public a.b a() {
            return new a.b(getString(0), (float) getDouble(1), (long) getDouble(2));
        }
    }

    public b(Context context) {
        super(context, "Scheduler.db", (SQLiteDatabase.CursorFactory) null, 1);
        try {
            this.f123116a = getWritableDatabase();
        } catch (Exception e16) {
            com.tencent.luggage.wxa.zp.d.f146814c.e("ExperienceStorage", "%s", e16.toString());
        }
    }

    public static ContentValues a(a.c cVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("taskName", cVar.f123110a);
        contentValues.put("threadTime", Long.valueOf(cVar.f123111b));
        contentValues.put("time", Long.valueOf(cVar.f123112c));
        contentValues.put("timestamp", Long.valueOf(cVar.f123114e));
        contentValues.put("rate", Float.valueOf(cVar.f123115f));
        contentValues.put("scheduler", cVar.f123113d);
        return contentValues;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS DisposedTask(_ID INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL, taskName TEXT NOT NULL, threadTime LONG NOT NULL, time LONG NOT NULL, rate REAL NOT NULL, timestamp LONG NOT NULL, scheduler TEXT NOT NULL )");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS timestampIndex ON DisposedTask(timestamp)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS taskNameIndex ON DisposedTask(taskName)");
    }

    @Override // com.tencent.luggage.wxa.bq.d
    public void a(Collection collection) {
        if (this.f123116a != null) {
            try {
                if (collection.size() <= 0) {
                    return;
                }
                this.f123116a.beginTransaction();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    a.b bVar = (a.b) it.next();
                    a.c cVar = new a.c(bVar.a(), bVar.f123103d, bVar.f123104e, "");
                    cVar.f123114e = System.currentTimeMillis();
                    this.f123116a.insert("DisposedTask", null, a(cVar));
                }
            } catch (Exception e16) {
                com.tencent.luggage.wxa.zp.d.f146814c.e("ExperienceStorage", "%s", e16.toString());
            } finally {
                this.f123116a.setTransactionSuccessful();
                this.f123116a.endTransaction();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.bq.d
    public void a(long j3) {
        long currentTimeMillis;
        if (this.f123116a == null) {
            return;
        }
        if (j3 <= 0) {
            currentTimeMillis = System.currentTimeMillis();
        } else {
            currentTimeMillis = j3 + System.currentTimeMillis();
        }
        try {
            this.f123116a.delete("DisposedTask", "timestamp<?", new String[]{currentTimeMillis + ""});
        } catch (Exception e16) {
            com.tencent.luggage.wxa.zp.d.f146814c.e("ExperienceStorage", "%s", e16.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0074, code lost:
    
        if (r12 == null) goto L17;
     */
    @Override // com.tencent.luggage.wxa.bq.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map a() {
        HashMap hashMap = new HashMap();
        SQLiteDatabase sQLiteDatabase = this.f123116a;
        if (sQLiteDatabase == null) {
            return hashMap;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.query("DisposedTask", new String[]{"taskName", String.format("avg(%s)", "rate"), String.format("avg(%s)", "threadTime")}, null, null, "taskName", null, null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    a.b a16 = new a(cursor).a();
                    hashMap.put(a16.a(), a16);
                    cursor.moveToNext();
                }
            } catch (Exception e16) {
                com.tencent.luggage.wxa.zp.d.f146814c.e("ExperienceStorage", "%s", e16.toString());
            }
            cursor.close();
            return hashMap;
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
    }
}
