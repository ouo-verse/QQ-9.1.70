package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.data.EqqConfig;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class z implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private EntityManager f196692d;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, EqqDetail> f196693e;

    /* renamed from: f, reason: collision with root package name */
    private EqqConfig f196694f;

    public z(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f196694f = null;
            this.f196692d = qQAppInterface.getEntityManagerFactory().createEntityManager();
        }
    }

    public void a(EqqDetail eqqDetail) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) eqqDetail);
            return;
        }
        if (eqqDetail == null) {
            return;
        }
        this.f196692d.remove(eqqDetail);
        this.f196692d.close();
        ConcurrentHashMap<String, EqqDetail> concurrentHashMap = this.f196693e;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(eqqDetail.uin);
        }
    }

    public EqqDetail b(String str) {
        ConcurrentHashMap<String, EqqDetail> concurrentHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EqqDetail) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f196693e) == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        EqqConfig eqqConfig = this.f196694f;
        if (eqqConfig == null) {
            List<? extends Entity> query = this.f196692d.query(EqqConfig.class);
            if (query != null && query.size() >= 1) {
                EqqConfig eqqConfig2 = (EqqConfig) query.get(0);
                this.f196694f = eqqConfig2;
                return eqqConfig2.getData();
            }
            return "";
        }
        return eqqConfig.getData();
    }

    public void d(EqqDetail eqqDetail) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) eqqDetail);
            return;
        }
        if (eqqDetail == null) {
            return;
        }
        f(eqqDetail);
        if (this.f196693e == null) {
            this.f196693e = new ConcurrentHashMap<>();
        }
        if (eqqDetail.followType == 0) {
            this.f196693e.put(eqqDetail.uin, eqqDetail);
        }
    }

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        if (this.f196694f == null) {
            this.f196694f = new EqqConfig(str);
        }
        f(this.f196694f);
    }

    protected boolean f(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) entity)).booleanValue();
        }
        if (entity.getStatus() == 1000) {
            this.f196692d.persistOrReplace(entity);
            if (entity.getStatus() != 1001) {
                return false;
            }
            return true;
        }
        if (entity.getStatus() != 1001 && entity.getStatus() != 1002) {
            return false;
        }
        return this.f196692d.update(entity);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        EntityManager entityManager = this.f196692d;
        if (entityManager != null) {
            entityManager.close();
        }
    }
}
