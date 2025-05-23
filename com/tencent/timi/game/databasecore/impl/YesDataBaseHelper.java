package com.tencent.timi.game.databasecore.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiGameEntity;
import com.tencent.timi.game.utils.l;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import rg4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class YesDataBaseHelper {

    /* renamed from: d, reason: collision with root package name */
    private static volatile YesDataBaseHelper f376782d;

    /* renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<Class, b> f376783e = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private a f376784a;

    /* renamed from: b, reason: collision with root package name */
    private EntityManager f376785b;

    /* renamed from: c, reason: collision with root package name */
    private Object f376786c = new Object();

    public static void b() {
        l.e("YesDataBaseHelper", "destroy");
        synchronized (YesDataBaseHelper.class) {
            if (f376782d != null) {
                f376782d.c();
                f376782d = null;
            }
        }
    }

    public static ConcurrentHashMap<Class, b> d() {
        return f376783e;
    }

    private EntityManagerFactory e(String str) {
        if (!TextUtils.isEmpty(str)) {
            a aVar = this.f376784a;
            if (aVar != null && this.f376785b != null) {
                return aVar;
            }
            synchronized (this.f376786c) {
                if (this.f376784a == null || this.f376785b == null) {
                    a aVar2 = new a(str);
                    this.f376784a = aVar2;
                    this.f376785b = aVar2.createEntityManager();
                    l.i("YesDataBaseHelper", "mEntityManager:" + this.f376785b);
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.timi.game.databasecore.impl.YesDataBaseHelper.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (!YesDataBaseHelper.this.f376784a.verifyAuthentication()) {
                                    l.e("YesDataBaseHelper", "getEntityManagerFactory verify fail! ");
                                }
                            } catch (Exception e16) {
                                l.f("YesDataBaseHelper", "getEntityManagerFactory verify error.", e16);
                            }
                        }
                    }, 32, null, true);
                }
            }
            return this.f376784a;
        }
        throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }

    public static YesDataBaseHelper f() {
        if (f376782d == null) {
            synchronized (YesDataBaseHelper.class) {
                if (f376782d == null) {
                    f376782d = new YesDataBaseHelper();
                }
            }
        }
        return f376782d;
    }

    public static synchronized void l(BaseTimiGameEntity baseTimiGameEntity, rg4.a aVar) {
        synchronized (YesDataBaseHelper.class) {
            f376783e.put(baseTimiGameEntity.getClass(), new b(baseTimiGameEntity, aVar));
        }
    }

    public void c() {
        l.e("YesDataBaseHelper", "destroyInternal");
        EntityManager entityManager = this.f376785b;
        if (entityManager != null) {
            entityManager.close();
            this.f376785b = null;
        }
        a aVar = this.f376784a;
        if (aVar != null) {
            aVar.close();
            this.f376784a = null;
        }
    }

    public void g(String str) {
        l.i("YesDataBaseHelper", "init with uin - " + this.f376784a + " - " + this.f376785b);
        e(str);
    }

    public synchronized boolean h(Entity entity) {
        boolean z16 = false;
        if (this.f376785b == null) {
            l.e("YesDataBaseHelper", "has not inited! insertOrUpdateEntity");
            return false;
        }
        if (entity.getStatus() == 1000) {
            this.f376785b.persistOrReplace(entity);
            if (entity.getStatus() == 1001) {
                z16 = true;
            }
            return z16;
        }
        if (entity.getStatus() != 1001 && entity.getStatus() != 1002) {
            return false;
        }
        return this.f376785b.update(entity);
    }

    public synchronized boolean i(List<Entity> list) {
        if (this.f376785b == null) {
            l.e("YesDataBaseHelper", "has not inited! insertOrUpdateEntity list");
            return false;
        }
        while (true) {
            boolean z16 = true;
            for (Entity entity : list) {
                if (entity.getStatus() == 1000) {
                    this.f376785b.persistOrReplace(entity);
                    if (z16 && entity.getStatus() == 1001) {
                        break;
                    }
                    z16 = false;
                } else if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                    if (z16 && this.f376785b.update(entity)) {
                        break;
                    }
                    z16 = false;
                }
            }
            return z16;
        }
    }

    public synchronized List<? extends Entity> j(Class<? extends Entity> cls) {
        return k(cls, false, "", null, null, null, null, null);
    }

    public synchronized List<? extends Entity> k(Class<? extends Entity> cls, boolean z16, String str, String[] strArr, String str2, String str3, String str4, String str5) {
        EntityManager entityManager = this.f376785b;
        if (entityManager == null) {
            l.e("YesDataBaseHelper", "has not inited! queryEntity");
            return null;
        }
        return entityManager.query(cls, z16, str, strArr, str2, str3, str4, str5);
    }

    public synchronized boolean m(Entity entity) {
        EntityManager entityManager = this.f376785b;
        if (entityManager == null) {
            l.e("YesDataBaseHelper", "has not inited! removeEntity");
            return false;
        }
        if (entity == null) {
            return false;
        }
        return entityManager.remove(entity);
    }

    public synchronized boolean n(Entity entity, String str, String[] strArr) {
        EntityManager entityManager = this.f376785b;
        if (entityManager == null) {
            l.e("YesDataBaseHelper", "has not inited! removeEntity");
            return false;
        }
        if (entity == null) {
            return false;
        }
        return entityManager.remove(entity, str, strArr);
    }
}
