package com.tencent.mobileqq.troop.troopapps;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService;
import com.tencent.mobileqq.troop.troopapps.data.GrayGroupAppEntity;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class GrayGroupAppsDbHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final AppRuntime f299315a;

    public GrayGroupAppsDbHelper(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        } else {
            this.f299315a = appRuntime;
        }
    }

    private void d(boolean z16) {
        EntityManager createEntityManager = this.f299315a.getEntityManagerFactory().createEntityManager();
        ITroopAioAppService iTroopAioAppService = (ITroopAioAppService) this.f299315a.getRuntimeService(ITroopAioAppService.class, "");
        List<? extends Entity> query = createEntityManager.query(GrayGroupAppEntity.class);
        if (!g.d(query)) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                GrayGroupAppEntity grayGroupAppEntity = (GrayGroupAppEntity) it.next();
                if (z16) {
                    grayGroupAppEntity.updatedTimestamp = 0L;
                    f(grayGroupAppEntity);
                }
                ConcurrentHashMap<Long, GrayGroupAppEntity> grayAppInfoMap = iTroopAioAppService.getGrayAppInfoMap();
                if (grayAppInfoMap != null) {
                    grayAppInfoMap.put(Long.valueOf(grayGroupAppEntity.groupUin), grayGroupAppEntity);
                }
            }
        }
        createEntityManager.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(GrayGroupAppEntity grayGroupAppEntity) {
        EntityManager createEntityManager = this.f299315a.getEntityManagerFactory().createEntityManager();
        grayGroupAppEntity.setStatus(1000);
        createEntityManager.persistOrReplace(grayGroupAppEntity);
        createEntityManager.close();
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            d(false);
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            d(true);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f299315a.getEntityManagerFactory().createEntityManager().delete(GrayGroupAppEntity.class.getSimpleName(), null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(GrayGroupAppEntity grayGroupAppEntity) {
        ThreadManagerV2.excute(new Runnable(grayGroupAppEntity) { // from class: com.tencent.mobileqq.troop.troopapps.GrayGroupAppsDbHelper.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ GrayGroupAppEntity f299316d;

            {
                this.f299316d = grayGroupAppEntity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GrayGroupAppsDbHelper.this, (Object) grayGroupAppEntity);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    GrayGroupAppsDbHelper.this.f(this.f299316d);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 32, null, false);
    }
}
