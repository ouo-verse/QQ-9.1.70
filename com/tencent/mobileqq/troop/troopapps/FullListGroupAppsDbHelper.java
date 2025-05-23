package com.tencent.mobileqq.troop.troopapps;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService;
import com.tencent.mobileqq.troop.troopapps.data.FullListGroupAppEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class FullListGroupAppsDbHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final AppRuntime f299313a;

    public FullListGroupAppsDbHelper(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        } else {
            this.f299313a = appRuntime;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(FullListGroupAppEntity fullListGroupAppEntity) {
        if (fullListGroupAppEntity != null && !g.d(fullListGroupAppEntity.troopAIOAppInfos)) {
            EntityManager createEntityManager = this.f299313a.getEntityManagerFactory().createEntityManager();
            fullListGroupAppEntity.setStatus(1000);
            createEntityManager.delete(FullListGroupAppEntity.class.getSimpleName(), null, null);
            createEntityManager.persistOrReplace(fullListGroupAppEntity);
            createEntityManager.close();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FullListGroupAppsDbHelper", 2, "saveToDb: invoked. empty full list, no need to persist");
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        EntityManager createEntityManager = this.f299313a.getEntityManagerFactory().createEntityManager();
        ITroopAioAppService iTroopAioAppService = (ITroopAioAppService) this.f299313a.getRuntimeService(ITroopAioAppService.class, "");
        List<? extends Entity> query = createEntityManager.query(FullListGroupAppEntity.class);
        if (!g.d(query)) {
            Iterator<? extends Entity> it = query.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                FullListGroupAppEntity fullListGroupAppEntity = (FullListGroupAppEntity) it.next();
                if (!g.d(fullListGroupAppEntity.troopAIOAppInfos)) {
                    iTroopAioAppService.setFullAppsListInfos(fullListGroupAppEntity.troopAIOAppInfos);
                    QLog.i("FullListGroupAppsDbHelper", 1, "buildFullListFromDb: invoked. " + iTroopAioAppService.getFullAppsListInfos());
                    break;
                }
            }
        }
        createEntityManager.close();
        List<TroopAIOAppInfo> fullAppsListInfos = iTroopAioAppService.getFullAppsListInfos();
        if (fullAppsListInfos == null || fullAppsListInfos.isEmpty()) {
            iTroopAioAppService.setFullAppListHash("");
            iTroopAioAppService.saveFullAppListHashInSp();
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f299313a.getEntityManagerFactory().createEntityManager().delete(FullListGroupAppEntity.class.getSimpleName(), null, null);
        }
    }

    public void e(FullListGroupAppEntity fullListGroupAppEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fullListGroupAppEntity);
        } else {
            ThreadManagerV2.excute(new Runnable(fullListGroupAppEntity) { // from class: com.tencent.mobileqq.troop.troopapps.FullListGroupAppsDbHelper.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FullListGroupAppEntity f299314d;

                {
                    this.f299314d = fullListGroupAppEntity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FullListGroupAppsDbHelper.this, (Object) fullListGroupAppEntity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        FullListGroupAppsDbHelper.this.d(this.f299314d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 32, null, false);
        }
    }
}
