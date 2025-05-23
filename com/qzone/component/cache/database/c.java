package com.qzone.component.cache.database;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import n7.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    public static int f46667e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static int f46668f = 1;

    /* renamed from: g, reason: collision with root package name */
    public static int f46669g = 2;

    /* renamed from: h, reason: collision with root package name */
    private static c f46670h;

    /* renamed from: a, reason: collision with root package name */
    private final Context f46671a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, DbCacheManager> f46672b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private int f46673c = -1;

    /* renamed from: d, reason: collision with root package name */
    private final a.InterfaceC10828a f46674d = new a();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements a.InterfaceC10828a {
        a() {
        }

        @Override // n7.a.InterfaceC10828a
        public void onClosed(n7.a aVar) {
            synchronized (c.this.f46672b) {
                if (aVar instanceof DbCacheManager) {
                    c.this.f46672b.remove(((DbCacheManager) aVar).J());
                }
            }
        }
    }

    c(Context context) {
        this.f46671a = context.getApplicationContext();
    }

    public static c g() {
        c cVar;
        c cVar2 = f46670h;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (c.class) {
            if (f46670h == null) {
                f46670h = new c(BaseApplication.getContext());
                DbCacheExceptionHandler.b().a(BaseApplication.getContext());
            }
            cVar = f46670h;
        }
        return cVar;
    }

    public void b() {
        try {
            synchronized (this.f46672b) {
                for (DbCacheManager dbCacheManager : this.f46672b.values()) {
                    if (dbCacheManager != null) {
                        dbCacheManager.n0(this.f46674d);
                        dbCacheManager.close();
                    }
                }
                this.f46672b.clear();
            }
        } catch (Exception e16) {
            QZLog.e("DbCacheDatabase.DbCacheService", 1, e16, new Object[0]);
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            synchronized (this.f46672b) {
                Iterator<Map.Entry<String, DbCacheManager>> it = this.f46672b.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, DbCacheManager> next = it.next();
                    if (next != null) {
                        DbCacheManager value = next.getValue();
                        if (value != null) {
                            if (str.equals(value.s())) {
                                value.n0(this.f46674d);
                                value.close();
                                it.remove();
                            }
                        } else {
                            it.remove();
                        }
                    } else {
                        it.remove();
                    }
                }
            }
        } catch (Exception e16) {
            QZLog.e("DbCacheDatabase.DbCacheService", 1, e16, new Object[0]);
        }
    }

    public int f() {
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DB_OPTIMIZE_SYNC, 1);
        QZLog.w("DbCacheDatabase.DbCacheService", "dbOptiSync=" + config);
        return config;
    }

    public DbCacheManager h(Class<? extends IDBCacheDataWrapper> cls, long j3, String str) {
        return d(cls, j3, f46669g, 9898, str);
    }

    public DbCacheManager i(Class<? extends IDBCacheDataWrapper> cls, String str) {
        return d(cls, -1L, f46668f, 1, str);
    }

    public DbCacheManager d(Class<? extends IDBCacheDataWrapper> cls, long j3, int i3, int i16, String str) {
        DbCacheManager dbCacheManager;
        if (this.f46671a == null) {
            throw new RuntimeException("call initiate(Context context) before this");
        }
        if (str != null) {
            synchronized (this.f46672b) {
                dbCacheManager = this.f46672b.get(AbstractDbCacheManager.K(j3, i3, str));
                if (dbCacheManager == null) {
                    if (this.f46673c == -1) {
                        this.f46673c = f();
                    }
                    DbCacheManager dbCacheManager2 = new DbCacheManager(this.f46671a, cls, j3, i3, i16, str, this.f46673c);
                    dbCacheManager2.U(this.f46674d);
                    this.f46672b.put(dbCacheManager2.J(), dbCacheManager2);
                    dbCacheManager = dbCacheManager2;
                }
                String k3 = AbstractDbCacheManager.k(j3, i3);
                if (e.j(k3, str)) {
                    int i17 = e.i() ? 1 : 0;
                    String str2 = "dbencrypt_" + k3 + str;
                    int h16 = u5.c.h(str2, -1);
                    if (h16 == -1) {
                        u5.c.D(str2, i17);
                        h16 = i17;
                    }
                    if (i17 != h16) {
                        dbCacheManager.W();
                        QZLog.e("DbCacheDatabase.DbCacheService", 1, "detele table:", str, " Encrypt config:", Integer.valueOf(i17), " sp:", Integer.valueOf(h16));
                        u5.c.D(str2, i17);
                    } else if (QZLog.isColorLevel()) {
                        QZLog.e("DbCacheDatabase.DbCacheService", 1, "not detele table:", str, " Encrypt config:", Integer.valueOf(i17), " sp:", Integer.valueOf(h16));
                    }
                }
            }
            return dbCacheManager;
        }
        throw new RuntimeException("invalid table name");
    }

    public DbCacheManager e(Class<? extends IDBCacheDataWrapper> cls, long j3, String str) {
        if (j3 == -1) {
            return i(cls, str);
        }
        return d(cls, j3, f46667e, 9898, str);
    }
}
