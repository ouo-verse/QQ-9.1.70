package com.tencent.sqshow.zootopia.database;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.sqshow.zootopia.database.base.BaseZplanEntity;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.LogUtil;
import t84.b;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ZplanDataBaseHelper {

    /* renamed from: d, reason: collision with root package name */
    private static volatile ZplanDataBaseHelper f370476d;

    /* renamed from: e, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, b> f370477e = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private a f370478a;

    /* renamed from: b, reason: collision with root package name */
    private EntityManager f370479b;

    /* renamed from: c, reason: collision with root package name */
    private Object f370480c = new Object();

    private EntityManagerFactory b(String str) {
        if (!TextUtils.isEmpty(str)) {
            a aVar = this.f370478a;
            if (aVar != null && this.f370479b != null) {
                return aVar;
            }
            synchronized (this.f370480c) {
                if (this.f370478a == null || this.f370479b == null) {
                    a aVar2 = new a(str);
                    this.f370478a = aVar2;
                    this.f370479b = aVar2.createEntityManager();
                    v84.a.e("ZplanDataBaseHelper", "mEntityManager:" + this.f370479b);
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.sqshow.zootopia.database.ZplanDataBaseHelper.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (ZplanDataBaseHelper.this.f370478a.verifyAuthentication()) {
                                    return;
                                }
                                v84.a.c("ZplanDataBaseHelper", "getEntityManagerFactory verify fail! ");
                            } catch (Exception e16) {
                                v84.a.d("ZplanDataBaseHelper", "getEntityManagerFactory verify error.", e16);
                            }
                        }
                    }, 32, null, true);
                }
            }
            return this.f370478a;
        }
        throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }

    public static void d() {
        v84.a.c("ZplanDataBaseHelper", "destroy");
        synchronized (ZplanDataBaseHelper.class) {
            if (f370476d != null) {
                f370476d.e();
                f370476d = null;
            }
        }
    }

    private void f() {
        long currentTimeMillis = System.currentTimeMillis();
        u84.a.c();
        if (this.f370478a == null || this.f370479b == null) {
            String b16 = v84.a.b();
            v84.a.e("ZplanDataBaseHelper", "ensureInitDb - " + LogUtil.wrapLogUin(b16) + " - " + this.f370478a + " - " + this.f370479b);
            if (!TextUtils.isEmpty(b16)) {
                b(b16);
                v84.a.e("ZplanDataBaseHelper", "ensureInitDb finish, costTime = " + (System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            v84.a.c("ZplanDataBaseHelper", "ensureInit uin empty");
        }
    }

    public static ConcurrentHashMap<Class, b> g() {
        return f370477e;
    }

    public static ZplanDataBaseHelper h() {
        if (f370476d == null) {
            synchronized (ZplanDataBaseHelper.class) {
                if (f370476d == null) {
                    f370476d = new ZplanDataBaseHelper();
                }
            }
        }
        f370476d.f();
        return f370476d;
    }

    public static synchronized void m(BaseZplanEntity baseZplanEntity, t84.a aVar) {
        synchronized (ZplanDataBaseHelper.class) {
            f370477e.put(baseZplanEntity.getClass(), new b(baseZplanEntity, aVar));
        }
    }

    public synchronized boolean c(String str) {
        EntityManager entityManager = this.f370479b;
        if (entityManager == null) {
            v84.a.c("ZplanDataBaseHelper", "has not inited! clearEntityTable");
            return false;
        }
        return DBMethodProxy.execSQL(entityManager, "DELETE FROM " + str);
    }

    public void e() {
        v84.a.c("ZplanDataBaseHelper", "destroyInternal");
        EntityManager entityManager = this.f370479b;
        if (entityManager != null) {
            entityManager.close();
            this.f370479b = null;
        }
        a aVar = this.f370478a;
        if (aVar != null) {
            aVar.close();
            this.f370478a = null;
        }
    }

    public synchronized boolean i(Entity entity) {
        if (this.f370479b == null) {
            v84.a.c("ZplanDataBaseHelper", "has not inited! insertOrUpdateEntity");
            return false;
        }
        if (entity.getStatus() == 1000) {
            this.f370479b.persistOrReplace(entity);
            return entity.getStatus() == 1001;
        }
        if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
            return this.f370479b.update(entity);
        }
        return false;
    }

    public synchronized boolean j(List<Entity> list) {
        if (this.f370479b == null) {
            v84.a.c("ZplanDataBaseHelper", "has not inited! insertOrUpdateEntity list");
            return false;
        }
        while (true) {
            boolean z16 = true;
            for (Entity entity : list) {
                if (entity.getStatus() == 1000) {
                    this.f370479b.persistOrReplace(entity);
                    if (z16 && entity.getStatus() == 1001) {
                        break;
                    }
                    z16 = false;
                } else if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                    if (z16 && this.f370479b.update(entity)) {
                        break;
                    }
                    z16 = false;
                }
            }
            return z16;
        }
    }

    public synchronized List<? extends Entity> k(Class<? extends Entity> cls) {
        return l(cls, false, "", null, null, null, null, null);
    }

    public synchronized boolean n(Entity entity) {
        EntityManager entityManager = this.f370479b;
        if (entityManager == null) {
            v84.a.c("ZplanDataBaseHelper", "has not inited! removeEntity");
            return false;
        }
        if (entity == null) {
            return false;
        }
        return entityManager.remove(entity);
    }

    public synchronized List<? extends Entity> l(Class<? extends Entity> cls, boolean z16, String str, String[] strArr, String str2, String str3, String str4, String str5) {
        EntityManager entityManager = this.f370479b;
        if (entityManager == null) {
            v84.a.c("ZplanDataBaseHelper", "has not inited! queryEntity");
            return null;
        }
        return entityManager.query(cls, z16, str, strArr, str2, str3, str4, str5);
    }
}
