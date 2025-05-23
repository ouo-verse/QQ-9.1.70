package com.qq.e.comm.plugin.stat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.qq.e.comm.plugin.stat.m;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes3.dex */
class q<DataType extends m> {

    /* renamed from: a, reason: collision with root package name */
    private final String f39746a;

    /* renamed from: b, reason: collision with root package name */
    private final String f39747b;

    /* renamed from: c, reason: collision with root package name */
    private final String f39748c;

    /* renamed from: d, reason: collision with root package name */
    private int f39749d = 0;

    /* renamed from: e, reason: collision with root package name */
    private g f39750e;

    /* renamed from: f, reason: collision with root package name */
    private a<DataType> f39751f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a<DataType> {
        DataType b(int i3, String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(String str, a<DataType> aVar) {
        this.f39746a = str;
        this.f39747b = "create table " + str + "(id integer primary key autoincrement,content text not null,ts long not null)";
        this.f39748c = "id not in (select id from " + str + " order by ts desc limit 1000)";
        this.f39751f = aVar;
    }

    public void a(g gVar) {
        this.f39750e = gVar;
        this.f39749d = a().size();
        GDTLogger.d("Stat db init: total " + this.f39746a + " count=" + this.f39749d);
    }

    public long b() {
        return this.f39749d;
    }

    public void b(SQLiteDatabase sQLiteDatabase) throws Throwable {
        sQLiteDatabase.execSQL("drop table if exists " + this.f39746a);
        this.f39749d = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<DataType> list) {
        g gVar;
        SQLiteDatabase writableDatabase;
        if (list == null || list.size() <= 0 || (gVar = this.f39750e) == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        int i3 = 0;
        try {
            writableDatabase = gVar.getWritableDatabase();
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            writableDatabase.beginTransaction();
            StringBuilder sb5 = new StringBuilder("insert into ");
            sb5.append(this.f39746a);
            sb5.append(" (");
            sb5.append("content");
            sb5.append(", ");
            sb5.append("ts");
            sb5.append(") ");
            DataType datatype = list.get(0);
            sb5.append("select '");
            sb5.append(datatype.c());
            sb5.append("', ");
            sb5.append(datatype.d());
            int size = list.size();
            for (int i16 = 1; i16 < size; i16++) {
                DataType datatype2 = list.get(i16);
                sb5.append(" union all select '");
                sb5.append(datatype2.c());
                sb5.append("', ");
                sb5.append(datatype2.d());
            }
            writableDatabase.execSQL(sb5.toString());
            int delete = writableDatabase.delete(this.f39746a, this.f39748c, null);
            i3 = list.size() - delete;
            GDTLogger.d("Insert stat:" + list.size() + ", delete stat: " + delete + " from table: " + this.f39746a);
            writableDatabase.setTransactionSuccessful();
            try {
                writableDatabase.endTransaction();
            } finally {
                try {
                } finally {
                }
            }
        } catch (Throwable th6) {
            th = th6;
            sQLiteDatabase = writableDatabase;
            try {
                GDTLogger.e("STatTAbleHelper Insert stat db failed", th);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
                this.f39749d += i3;
            } catch (Throwable th7) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } finally {
                        try {
                            GDTLogger.e("error when endTransaction", th);
                            throw th7;
                        } finally {
                        }
                    }
                }
                throw th7;
            }
        }
        this.f39749d += i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Set<Integer> set) {
        Throwable th5;
        int i3;
        int i16;
        int i17;
        SQLiteDatabase writableDatabase;
        if (set == null || set.size() == 0 || this.f39750e == null) {
            return;
        }
        Iterator<Integer> it = set.iterator();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("(");
        if (it.hasNext()) {
            sb5.append(it.next());
        }
        while (it.hasNext()) {
            sb5.append(",");
            sb5.append(it.next());
        }
        sb5.append(")");
        SQLiteDatabase sQLiteDatabase = null;
        try {
            writableDatabase = this.f39750e.getWritableDatabase();
        } catch (Throwable th6) {
            th = th6;
        }
        try {
            i16 = writableDatabase.delete(this.f39746a, "id in " + sb5.toString(), null);
            try {
                GDTLogger.d("Delete stat count: " + i16 + " from table: " + this.f39746a);
                writableDatabase.close();
            } catch (Throwable th7) {
                i3 = i16;
                sQLiteDatabase = writableDatabase;
                th5 = th7;
                try {
                    GDTLogger.e("StatTableHelper Delete stat db failed", th5);
                    i16 = i3;
                    i17 = this.f39749d - i16;
                    this.f39749d = i17;
                    if (i17 < 0) {
                    }
                } finally {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                }
            }
        } catch (Throwable th8) {
            th = th8;
            sQLiteDatabase = writableDatabase;
            th5 = th;
            i3 = 0;
            GDTLogger.e("StatTableHelper Delete stat db failed", th5);
            i16 = i3;
            i17 = this.f39749d - i16;
            this.f39749d = i17;
            if (i17 < 0) {
            }
        }
        i17 = this.f39749d - i16;
        this.f39749d = i17;
        if (i17 < 0) {
            this.f39749d = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        r4.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<DataType> a() {
        SQLiteDatabase sQLiteDatabase;
        ArrayList arrayList = new ArrayList();
        g gVar = this.f39750e;
        if (gVar == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            sQLiteDatabase = gVar.getReadableDatabase();
        } catch (Throwable th5) {
            th = th5;
            sQLiteDatabase = null;
        }
        try {
            cursor = sQLiteDatabase.query(this.f39746a, new String[]{"id", "content"}, null, null, null, null, "ts");
            if (cursor != null && cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    DataType b16 = this.f39751f.b(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("content")));
                    if (b16 != null) {
                        arrayList.add(b16);
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            try {
                GDTLogger.e("StatTableHelper Read stat db failed", th);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
        return arrayList;
    }

    public void a(SQLiteDatabase sQLiteDatabase) throws Throwable {
        sQLiteDatabase.execSQL(this.f39747b);
        this.f39749d = 0;
    }
}
