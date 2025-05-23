package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BaseCacheManager implements Manager {
    static IPatchRedirector $redirector_ = null;
    private static final int COUNT_MANAGER = 4;
    public static final int RECENT_USER_CACHE = 1;
    public static final int ROAM_DATA_CACHE = 2;
    private static final String TAG = "Q.db.Cache";
    public static final int TROOP_STATISTICS_CACHE = 3;
    private AppRuntime app;
    int[] baseCache;
    private BaseCache[] cacheArray;
    protected DBDelayManager dbDelayManager;
    private boolean isInit;
    private boolean isLazyInit;
    int[] lazyBaseCache;

    public BaseCacheManager(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        this.isInit = false;
        this.isLazyInit = false;
        this.cacheArray = new BaseCache[4];
        this.baseCache = new int[0];
        this.lazyBaseCache = new int[0];
        this.app = appRuntime;
        this.dbDelayManager = new DBDelayManager(appRuntime);
    }

    private void initCaches(int[] iArr) {
        for (int i3 : iArr) {
            long currentTimeMillis = System.currentTimeMillis();
            BaseCache cache = getCache(i3);
            if (cache != null) {
                cache.init();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "cacheManager init cache:" + cache.getClass().getName() + " cost=" + (System.currentTimeMillis() - currentTimeMillis));
                }
                cache.notifyObserver(0);
            }
        }
    }

    protected BaseCache createCacheByName(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (BaseCache) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        return null;
    }

    public BaseCache getCache(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BaseCache) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        BaseCache[] baseCacheArr = this.cacheArray;
        BaseCache baseCache = baseCacheArr[i3];
        if (baseCache == null) {
            synchronized (baseCacheArr) {
                BaseCache baseCache2 = this.cacheArray[i3];
                if (baseCache2 != null) {
                    return baseCache2;
                }
                long currentTimeMillis = System.currentTimeMillis();
                BaseCache createCacheByName = createCacheByName(i3);
                if (createCacheByName != null) {
                    BaseCache[] baseCacheArr2 = this.cacheArray;
                    if (baseCacheArr2[i3] == null) {
                        baseCacheArr2[i3] = createCacheByName;
                    }
                }
                if (QLog.isColorLevel() && createCacheByName != null) {
                    QLog.d(TAG, 2, "get cache instance:" + createCacheByName.getClass().getName() + " cost time =[" + (System.currentTimeMillis() - currentTimeMillis) + "]");
                }
                return createCacheByName;
            }
        }
        return baseCache;
    }

    public DBDelayManager getDBDelayManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (DBDelayManager) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.dbDelayManager;
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            if (this.isInit) {
                return;
            }
            initCaches(this.baseCache);
            this.dbDelayManager.start();
            this.isInit = true;
        }
    }

    public void initLazy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            if (this.isLazyInit) {
                return;
            }
            initCaches(this.lazyBaseCache);
            this.isLazyInit = true;
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        synchronized (this.cacheArray) {
            for (BaseCache baseCache : this.cacheArray) {
                if (baseCache != null) {
                    baseCache.destroy();
                }
            }
        }
        this.dbDelayManager.onDestroy();
    }
}
