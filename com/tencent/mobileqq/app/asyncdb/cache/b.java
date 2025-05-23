package com.tencent.mobileqq.app.asyncdb.cache;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.data.TroopStatisticsInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pic.w;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b extends FullCache {
    static IPatchRedirector $redirector_;

    public b(AppInterface appInterface, DBDelayManager dBDelayManager) {
        super(appInterface, dBDelayManager, TroopStatisticsInfo.class);
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) dBDelayManager);
            return;
        }
        EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (currentTimeMillis - com.tencent.mobileqq.pic.a.b(w.f258844e0, 0L) > 604800000) {
                    com.tencent.mobileqq.pic.a.e(w.f258844e0, currentTimeMillis);
                    createEntityManager.drop(TroopStatisticsInfo.class);
                    this.cacheMap.clear();
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.db.Cache.TroopStatisticsCache", 2, "doInit record time over 7 days, drop table");
                    }
                } else {
                    List<? extends Entity> query = createEntityManager.query(TroopStatisticsInfo.class);
                    if (query != null) {
                        this.cacheMap.clear();
                        Iterator<? extends Entity> it = query.iterator();
                        while (it.hasNext()) {
                            TroopStatisticsInfo troopStatisticsInfo = (TroopStatisticsInfo) it.next();
                            this.cacheMap.put(getKey(troopStatisticsInfo), troopStatisticsInfo);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("doInit size = ");
                        if (query == null) {
                            size = 0;
                        } else {
                            size = query.size();
                        }
                        sb5.append(size);
                        QLog.d("Q.db.Cache.TroopStatisticsCache", 2, sb5.toString());
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.db.Cache.TroopStatisticsCache", 2, e16.getMessage());
                }
            }
            createEntityManager.close();
        } catch (Throwable th5) {
            createEntityManager.close();
            throw th5;
        }
    }

    public TroopStatisticsInfo a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopStatisticsInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        ConcurrentHashMap<String, Entity> concurrentHashMap = this.cacheMap;
        if (concurrentHashMap != null && str != null) {
            return (TroopStatisticsInfo) concurrentHashMap.get(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.asyncdb.BaseCache
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.asyncdb.BaseCache
    public String getKey(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) entity);
        }
        return ((TroopStatisticsInfo) entity).troopUin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.asyncdb.FullCache, com.tencent.mobileqq.app.asyncdb.BaseCache
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
