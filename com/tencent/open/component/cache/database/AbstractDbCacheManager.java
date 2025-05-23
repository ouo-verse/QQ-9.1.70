package com.tencent.open.component.cache.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.AndroidRuntimeException;
import com.tencent.open.component.cache.database.a;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class AbstractDbCacheManager {

    /* renamed from: a, reason: collision with root package name */
    protected a.InterfaceC9275a f341122a;

    /* renamed from: b, reason: collision with root package name */
    protected long f341123b;

    /* renamed from: c, reason: collision with root package name */
    protected String f341124c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f341125d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f341126e = false;

    /* renamed from: f, reason: collision with root package name */
    protected ArrayList<a.b> f341127f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    protected sp3.a f341128g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class BadCacheDataException extends AndroidRuntimeException {
        public BadCacheDataException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDbCacheManager(Context context, Class<? extends a> cls, long j3, String str) {
        sp3.a e16 = sp3.a.e(context.getApplicationContext(), j3);
        this.f341128g = e16;
        e16.a(hashCode());
        this.f341123b = j3;
        this.f341124c = str;
        k(cls);
        a();
        b(j());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String s(long j3, String str) {
        return String.valueOf(j3) + "_" + str;
    }

    protected void a() {
        SQLiteDatabase j3;
        int version = this.f341122a.version();
        int a16 = tp3.a.a(this.f341124c + "_cache_db_version", -1, this.f341123b);
        if ((a16 == -1 || a16 != version) && (j3 = j()) != null) {
            try {
                e(j3);
            } catch (SQLException e16) {
                e16.printStackTrace();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
        tp3.a.d(this.f341124c + "_cache_db_version", version, this.f341123b);
    }

    protected void b(SQLiteDatabase sQLiteDatabase) {
        if (!this.f341125d) {
            try {
                sQLiteDatabase.execSQL(f());
                this.f341125d = true;
            } catch (SQLException e16) {
                e16.printStackTrace();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.delete(this.f341124c, str, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str) {
        SQLiteDatabase j3;
        if (m() || (j3 = j()) == null) {
            return;
        }
        try {
            c(j3, str);
        } catch (SQLException e16) {
            e16.printStackTrace();
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        n();
    }

    protected void e(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(g());
        this.f341125d = false;
    }

    protected String f() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CREATE TABLE IF NOT EXISTS " + this.f341124c + " (");
        sb5.append("_id INTEGER PRIMARY KEY");
        Iterator<a.b> it = this.f341127f.iterator();
        while (it.hasNext()) {
            a.b next = it.next();
            sb5.append(',');
            sb5.append(next.a());
            sb5.append(TokenParser.SP);
            sb5.append(next.b());
        }
        sb5.append(')');
        return sb5.toString();
    }

    protected String g() {
        return "DROP TABLE IF EXISTS " + this.f341124c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a h(Cursor cursor, int i3) {
        if (cursor != null && !cursor.isClosed() && i3 >= 0 && i3 < cursor.getCount()) {
            try {
                if (!cursor.moveToPosition(i3)) {
                    return null;
                }
                return this.f341122a.createFromCursor(cursor);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Cursor i(String str, String str2) {
        SQLiteDatabase j3;
        if (m() || (j3 = j()) == null) {
            return null;
        }
        try {
            return p(j3, str, str2);
        } catch (SQLException e16) {
            e16.printStackTrace();
            return null;
        } catch (Exception e17) {
            e17.printStackTrace();
            return null;
        }
    }

    protected SQLiteDatabase j() {
        if (m()) {
            return null;
        }
        return this.f341128g.getWritableDatabase();
    }

    protected void k(Class<? extends a> cls) {
        String name = cls.getName();
        try {
            a.InterfaceC9275a interfaceC9275a = (a.InterfaceC9275a) cls.getField("DB_CREATOR").get(null);
            if (interfaceC9275a != null) {
                this.f341122a = interfaceC9275a;
                a.b[] structure = interfaceC9275a.structure();
                if (structure != null) {
                    for (a.b bVar : structure) {
                        if (bVar != null) {
                            this.f341127f.add(bVar);
                        }
                    }
                }
                if (this.f341127f.size() != 0) {
                    return;
                }
                throw new BadCacheDataException("CacheData protocol requires a valid CacheData.Structure from CacheData.Creator object called  CREATOR on class " + name);
            }
            throw new BadCacheDataException("CacheData protocol requires a CacheData.Creator object called  CREATOR on class " + name);
        } catch (ClassCastException unused) {
            throw new BadCacheDataException("CacheData protocol requires a CacheData.Creator object called  CREATOR on class " + name);
        } catch (IllegalAccessException unused2) {
            throw new BadCacheDataException("IllegalAccessException when access: " + name);
        } catch (NoSuchFieldException unused3) {
            throw new BadCacheDataException("CacheData protocol requires a CacheData.Creator object called  CacheData on class " + name);
        }
    }

    final void l(SQLiteDatabase sQLiteDatabase, a aVar) {
        ContentValues contentValues = new ContentValues();
        aVar.a(contentValues);
        sQLiteDatabase.replaceOrThrow(this.f341124c, null, contentValues);
    }

    public final boolean m() {
        return this.f341126e;
    }

    protected abstract void n();

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(SQLiteDatabase sQLiteDatabase, int i3) {
        if (i3 == 2) {
            c(sQLiteDatabase, null);
        }
    }

    final Cursor p(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        if (str2 == null) {
            str2 = this.f341122a.sortOrder();
        }
        return sQLiteDatabase.query(this.f341124c, null, str, null, null, null, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(int i3, a... aVarArr) {
        if (m() || aVarArr == null) {
            return;
        }
        SQLiteDatabase j3 = j();
        try {
            try {
            } catch (Throwable th5) {
                try {
                    j3.endTransaction();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                throw th5;
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        if (j3 == null) {
            return;
        }
        try {
            j3.beginTransaction();
            o(j3, i3);
            for (a aVar : aVarArr) {
                l(j3, aVar);
            }
            j3.setTransactionSuccessful();
            j3.endTransaction();
        } catch (SQLException e18) {
            e18.printStackTrace();
            j3.endTransaction();
        } catch (Exception e19) {
            e19.printStackTrace();
            j3.endTransaction();
        }
        n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String r() {
        return s(this.f341123b, this.f341124c);
    }

    final int t(SQLiteDatabase sQLiteDatabase, a aVar, String str) {
        ContentValues contentValues = new ContentValues();
        aVar.a(contentValues);
        return sQLiteDatabase.update(this.f341124c, contentValues, str, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(a aVar, String str) {
        SQLiteDatabase j3;
        if (m() || aVar == null || (j3 = j()) == null) {
            return;
        }
        boolean z16 = false;
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        try {
            try {
                j3.beginTransaction();
                if (t(j3, aVar, str) > 0) {
                    z16 = true;
                }
                j3.setTransactionSuccessful();
                j3.endTransaction();
            } catch (SQLException e17) {
                e17.printStackTrace();
                j3.endTransaction();
            } catch (Exception e18) {
                e18.printStackTrace();
                j3.endTransaction();
            }
            if (z16) {
                n();
            }
        } catch (Throwable th5) {
            try {
                j3.endTransaction();
            } catch (Exception e19) {
                e19.printStackTrace();
            }
            throw th5;
        }
    }
}
