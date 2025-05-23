package com.tencent.qqnt.emotion.db;

import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    EntityManager f356228a;

    public a(EntityManager entityManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) entityManager);
        } else {
            this.f356228a = entityManager;
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        EntityManager entityManager = this.f356228a;
        if (entityManager != null) {
            entityManager.close();
        }
    }

    public int b(String str, String str2, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, str, str2, strArr)).intValue();
        }
        EntityManager entityManager = this.f356228a;
        if (entityManager != null) {
            entityManager.delete(str, str2, strArr);
            return -1;
        }
        return -1;
    }

    public boolean c(List<BaseTransaction> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) list)).booleanValue();
        }
        EntityManager entityManager = this.f356228a;
        if (entityManager != null) {
            return entityManager.doMultiDBOperateByTransaction(list);
        }
        return false;
    }

    public Entity d(Class<? extends Entity> cls, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Entity) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls, (Object) str);
        }
        EntityManager entityManager = this.f356228a;
        if (entityManager != null) {
            return DBMethodProxy.find(entityManager, cls, str);
        }
        return null;
    }

    public Entity e(Class<? extends Entity> cls, String str, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Entity) iPatchRedirector.redirect((short) 3, this, cls, str, strArr);
        }
        EntityManager entityManager = this.f356228a;
        if (entityManager != null) {
            return DBMethodProxy.find(entityManager, cls, str, strArr);
        }
        return null;
    }

    public EntityTransaction f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (EntityTransaction) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        EntityManager entityManager = this.f356228a;
        if (entityManager != null) {
            entityManager.getTransaction();
            return null;
        }
        return null;
    }

    public void g(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) entity);
            return;
        }
        EntityManager entityManager = this.f356228a;
        if (entityManager != null) {
            entityManager.persistOrReplace(entity);
        }
    }

    public List<? extends Entity> h(Class<? extends Entity> cls, String str, boolean z16, String str2, String[] strArr, String str3, String str4, String str5, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, this, cls, str, Boolean.valueOf(z16), str2, strArr, str3, str4, str5, str6);
        }
        EntityManager entityManager = this.f356228a;
        if (entityManager != null) {
            return entityManager.query(cls, str, z16, str2, strArr, str3, str4, str5, str6);
        }
        return null;
    }

    public List<? extends Entity> i(Class<? extends Entity> cls, boolean z16, String str, String[] strArr, String str2, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, cls, Boolean.valueOf(z16), str, strArr, str2, str3, str4, str5);
        }
        EntityManager entityManager = this.f356228a;
        if (entityManager != null) {
            return entityManager.query(cls, z16, str, strArr, str2, str3, str4, str5);
        }
        return null;
    }

    public boolean j(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) entity)).booleanValue();
        }
        EntityManager entityManager = this.f356228a;
        if (entityManager != null) {
            entityManager.update(entity);
            return false;
        }
        return false;
    }
}
