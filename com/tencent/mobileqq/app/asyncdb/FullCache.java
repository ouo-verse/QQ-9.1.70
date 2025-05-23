package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class FullCache extends BaseCache {
    static IPatchRedirector $redirector_;
    protected AppRuntime app;

    public FullCache(AppRuntime appRuntime, DBDelayManager dBDelayManager, Class<? extends Entity> cls) {
        super(dBDelayManager, cls);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, dBDelayManager, cls);
        } else {
            this.app = appRuntime;
        }
    }

    @Override // com.tencent.mobileqq.app.asyncdb.BaseCache
    public void addCache(Entity entity, int i3, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, entity, Integer.valueOf(i3), proxyListener);
            return;
        }
        this.cacheMap.put(getKey(entity), entity);
        if (entity.getStatus() == 1000) {
            this.proxyManager.addQueue(entity, 0, i3, proxyListener);
        } else {
            this.proxyManager.addQueue(entity, 1, i3, proxyListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.asyncdb.BaseCache
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        List<? extends Entity> query = createEntityManager.query(this.clazz, false, null, null, null, null, null, null);
        if (query != null) {
            for (Entity entity : query) {
                this.cacheMap.put(getKey(entity), entity);
            }
        }
        createEntityManager.close();
    }
}
