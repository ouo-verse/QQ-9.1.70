package com.tencent.icgame.game.databasecore.impl;

import android.text.TextUtils;
import com.tencent.icgame.game.databasecore.impl.base.BaseTimiGameEntity;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import ou0.b;

/* compiled from: P */
/* loaded from: classes7.dex */
public class YesDataBaseHelper {

    /* renamed from: d, reason: collision with root package name */
    private static volatile YesDataBaseHelper f115002d;

    /* renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<Class, b> f115003e = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private a f115004a;

    /* renamed from: b, reason: collision with root package name */
    private EntityManager f115005b;

    /* renamed from: c, reason: collision with root package name */
    private Object f115006c = new Object();

    public static void b() {
        g.d("ICGameYesDataBaseHelper", "destroy");
        synchronized (YesDataBaseHelper.class) {
            if (f115002d != null) {
                f115002d.c();
                f115002d = null;
            }
        }
    }

    public static ConcurrentHashMap<Class, b> d() {
        return f115003e;
    }

    private EntityManagerFactory e(String str) {
        if (!TextUtils.isEmpty(str)) {
            a aVar = this.f115004a;
            if (aVar != null && this.f115005b != null) {
                return aVar;
            }
            synchronized (this.f115006c) {
                if (this.f115004a == null || this.f115005b == null) {
                    a aVar2 = new a(str);
                    this.f115004a = aVar2;
                    this.f115005b = aVar2.createEntityManager();
                    g.h("ICGameYesDataBaseHelper", "mEntityManager:" + this.f115005b);
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.icgame.game.databasecore.impl.YesDataBaseHelper.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (!YesDataBaseHelper.this.f115004a.verifyAuthentication()) {
                                    g.d("ICGameYesDataBaseHelper", "getEntityManagerFactory verify fail! ");
                                }
                            } catch (Exception e16) {
                                g.e("ICGameYesDataBaseHelper", "getEntityManagerFactory verify error.", e16);
                            }
                        }
                    }, 32, null, true);
                }
            }
            return this.f115004a;
        }
        throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }

    public static YesDataBaseHelper f() {
        if (f115002d == null) {
            synchronized (YesDataBaseHelper.class) {
                if (f115002d == null) {
                    f115002d = new YesDataBaseHelper();
                }
            }
        }
        return f115002d;
    }

    public static synchronized void j(BaseTimiGameEntity baseTimiGameEntity, ou0.a aVar) {
        synchronized (YesDataBaseHelper.class) {
            f115003e.put(baseTimiGameEntity.getClass(), new b(baseTimiGameEntity, aVar));
        }
    }

    public void c() {
        g.d("ICGameYesDataBaseHelper", "destroyInternal");
        EntityManager entityManager = this.f115005b;
        if (entityManager != null) {
            entityManager.close();
            this.f115005b = null;
        }
        a aVar = this.f115004a;
        if (aVar != null) {
            aVar.close();
            this.f115004a = null;
        }
    }

    public void g(String str) {
        g.h("ICGameYesDataBaseHelper", "init with uin - " + this.f115004a + " - " + this.f115005b);
        e(str);
    }

    public synchronized boolean h(Entity entity) {
        boolean z16 = false;
        if (this.f115005b == null) {
            g.d("ICGameYesDataBaseHelper", "has not inited! insertOrUpdateEntity");
            return false;
        }
        if (entity.getStatus() == 1000) {
            this.f115005b.persistOrReplace(entity);
            if (entity.getStatus() == 1001) {
                z16 = true;
            }
            return z16;
        }
        if (entity.getStatus() != 1001 && entity.getStatus() != 1002) {
            return false;
        }
        return this.f115005b.update(entity);
    }

    public synchronized List<? extends Entity> i(Class<? extends Entity> cls, boolean z16, String str, String[] strArr, String str2, String str3, String str4, String str5) {
        EntityManager entityManager = this.f115005b;
        if (entityManager == null) {
            g.d("ICGameYesDataBaseHelper", "has not inited! queryEntity");
            return null;
        }
        return entityManager.query(cls, z16, str, strArr, str2, str3, str4, str5);
    }

    public synchronized boolean k(Entity entity, String str, String[] strArr) {
        EntityManager entityManager = this.f115005b;
        if (entityManager == null) {
            g.d("ICGameYesDataBaseHelper", "has not inited! removeEntity");
            return false;
        }
        if (entity == null) {
            return false;
        }
        return entityManager.remove(entity, str, strArr);
    }
}
