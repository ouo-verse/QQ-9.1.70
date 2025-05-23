package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class BaseCache {
    static IPatchRedirector $redirector_;
    protected ConcurrentHashMap<String, Entity> cacheMap;
    protected ArrayList<CacheObserver> cacheObserver;
    protected Class<? extends Entity> clazz;
    protected DBDelayManager proxyManager;

    public BaseCache(DBDelayManager dBDelayManager, Class<? extends Entity> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dBDelayManager, (Object) cls);
            return;
        }
        this.proxyManager = dBDelayManager;
        this.clazz = cls;
        this.cacheMap = new ConcurrentHashMap<>();
        this.cacheObserver = new ArrayList<>();
    }

    public void addCache(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) entity);
        } else {
            addCache(entity, 0, null);
        }
    }

    public abstract void addCache(Entity entity, int i3, ProxyListener proxyListener);

    public void addObserver(CacheObserver cacheObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) cacheObserver);
        } else if (!this.cacheObserver.contains(cacheObserver)) {
            this.cacheObserver.add(cacheObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void destroy();

    public Entity findCache(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Entity) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return this.cacheMap.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getKey(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) entity);
        }
        return Long.toString(entity.getId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void init();

    public void notifyObserver(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        Iterator<CacheObserver> it = this.cacheObserver.iterator();
        while (it.hasNext()) {
            it.next().notifyEvent(i3);
        }
    }

    public void removeCache(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            removeCache(entity, 0, null);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) entity);
        }
    }

    public void removeObserver(CacheObserver cacheObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) cacheObserver);
        } else if (this.cacheObserver.contains(cacheObserver)) {
            this.cacheObserver.remove(cacheObserver);
        }
    }

    public void updateCache(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            updateCache(entity, 0, null);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) entity);
        }
    }

    public void removeCache(Entity entity, int i3, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, entity, Integer.valueOf(i3), proxyListener);
            return;
        }
        String key = getKey(entity);
        if (this.cacheMap.containsKey(key)) {
            this.cacheMap.remove(key);
        }
        this.proxyManager.addQueue(entity, 2, i3, proxyListener);
    }

    public void updateCache(Entity entity, int i3, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, entity, Integer.valueOf(i3), proxyListener);
            return;
        }
        this.cacheMap.put(getKey(entity), entity);
        if (entity.getStatus() == 1000) {
            this.proxyManager.addQueue(entity, 0, i3, proxyListener);
        } else {
            this.proxyManager.addQueue(entity, 1, i3, proxyListener);
        }
    }
}
