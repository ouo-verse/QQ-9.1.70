package com.tencent.mobileqq.qcircle.api.db;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    public static int f261648e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static int f261649f = 1;

    /* renamed from: g, reason: collision with root package name */
    public static int f261650g = 2;

    /* renamed from: h, reason: collision with root package name */
    private static volatile b f261651h;

    /* renamed from: a, reason: collision with root package name */
    private Context f261652a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, DbCacheManager> f261653b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private int f261654c = -1;

    /* renamed from: d, reason: collision with root package name */
    private IDBManagerWrapper.OnCloseListener f261655d = new a();

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements IDBManagerWrapper.OnCloseListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper.OnCloseListener
        public void onClosed(IDBManagerWrapper iDBManagerWrapper) {
            synchronized (b.this.f261653b) {
                if (iDBManagerWrapper instanceof DbCacheManager) {
                    b.this.f261653b.remove(((DbCacheManager) iDBManagerWrapper).L());
                }
            }
        }
    }

    b(Context context) {
        this.f261652a = context.getApplicationContext();
    }

    public static b g() {
        b bVar;
        if (f261651h != null) {
            return f261651h;
        }
        synchronized (b.class) {
            if (f261651h == null) {
                f261651h = new b(RFWApplication.getApplication());
                DbCacheExceptionHandler.b().a(RFWApplication.getApplication());
            }
            bVar = f261651h;
        }
        return bVar;
    }

    public void b() {
        try {
            synchronized (this.f261653b) {
                for (DbCacheManager dbCacheManager : this.f261653b.values()) {
                    if (dbCacheManager != null) {
                        dbCacheManager.e0(this.f261655d);
                        dbCacheManager.close();
                    }
                }
                this.f261653b.clear();
            }
        } catch (Exception e16) {
            QLog.e("QCircleDbCacheDatabase.DbCacheService", 1, e16, new Object[0]);
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            synchronized (this.f261653b) {
                Iterator<Map.Entry<String, DbCacheManager>> it = this.f261653b.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, DbCacheManager> next = it.next();
                    if (next != null) {
                        DbCacheManager value = next.getValue();
                        if (value != null) {
                            if (str.equals(value.r())) {
                                value.e0(this.f261655d);
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
            QLog.e("QCircleDbCacheDatabase.DbCacheService", 1, e16, new Object[0]);
        }
    }

    public DbCacheManager d(Class<? extends IDBCacheDataWrapper> cls, long j3, int i3, int i16, String str) {
        DbCacheManager dbCacheManager;
        int i17;
        if (this.f261652a != null) {
            if (str != null) {
                synchronized (this.f261653b) {
                    dbCacheManager = this.f261653b.get(AbstractDbCacheManager.M(j3, i3, str));
                    if (dbCacheManager == null) {
                        if (this.f261654c == -1) {
                            this.f261654c = f();
                        }
                        DbCacheManager dbCacheManager2 = new DbCacheManager(this.f261652a, cls, j3, i3, i16, str, this.f261654c);
                        dbCacheManager2.addCloseListener(this.f261655d);
                        this.f261653b.put(dbCacheManager2.L(), dbCacheManager2);
                        dbCacheManager = dbCacheManager2;
                    }
                    String j16 = AbstractDbCacheManager.j(j3, i3);
                    if (wd2.a.j(j16, str)) {
                        if (wd2.a.i()) {
                            i17 = 1;
                        } else {
                            i17 = 0;
                        }
                        String str2 = "dbencrypt_" + j16 + str;
                        int int4Uin = LocalMultiProcConfig.getInt4Uin(str2, -1, j3);
                        if (int4Uin == -1) {
                            LocalMultiProcConfig.getInt4Uin(str2, i17, j3);
                            int4Uin = i17;
                        }
                        if (i17 != int4Uin) {
                            dbCacheManager.W();
                            QLog.e("QCircleDbCacheDatabase.DbCacheService", 1, "detele table:", str, " Encrypt config:", Integer.valueOf(i17), " sp:", Integer.valueOf(int4Uin));
                            LocalMultiProcConfig.getInt4Uin(str2, i17, j3);
                        } else if (QLog.isColorLevel()) {
                            QLog.e("QCircleDbCacheDatabase.DbCacheService", 1, "not detele table:", str, " Encrypt config:", Integer.valueOf(i17), " sp:", Integer.valueOf(int4Uin));
                        }
                    }
                }
                return dbCacheManager;
            }
            throw new RuntimeException("invalid table name");
        }
        throw new RuntimeException("call initiate(Context context) before this");
    }

    public DbCacheManager e(Class<? extends IDBCacheDataWrapper> cls, long j3, String str) {
        if (j3 == -1) {
            return h(cls, str);
        }
        return d(cls, j3, f261648e, 118, str);
    }

    public int f() {
        int intValue = uq3.c.X0("QZoneSetting", QzoneConfig.SECONDARY_DB_OPTIMIZE_SYNC, 1).intValue();
        QLog.w("QCircleDbCacheDatabase.DbCacheService", 1, "dbOptiSync=" + intValue);
        return intValue;
    }

    public DbCacheManager h(Class<? extends IDBCacheDataWrapper> cls, String str) {
        return d(cls, -1L, f261649f, 1, str);
    }
}
