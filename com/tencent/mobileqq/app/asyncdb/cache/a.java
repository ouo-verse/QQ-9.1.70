package com.tencent.mobileqq.app.asyncdb.cache;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a extends FullCache {
    static IPatchRedirector $redirector_;

    public a(QQAppInterface qQAppInterface, DBDelayManager dBDelayManager) {
        super(qQAppInterface, dBDelayManager, AppletsAccountInfo.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) dBDelayManager);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.cacheMap.clear();
        }
    }

    public void b() {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        List<? extends Entity> query = createEntityManager.query(AppletsAccountInfo.class);
        createEntityManager.close();
        if (query != null) {
            a();
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                AppletsAccountInfo appletsAccountInfo = (AppletsAccountInfo) it.next();
                this.cacheMap.put(String.valueOf(appletsAccountInfo.uin), appletsAccountInfo);
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
            QLog.d("AppletAccountCache", 2, sb5.toString());
        }
    }

    public AppletsAccountInfo c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AppletsAccountInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        return (AppletsAccountInfo) findCache(str);
    }

    public void d(AppletsAccountInfo appletsAccountInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appletsAccountInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppletAccountCache", 2, "saveAppletsAccount AppletsAccount = " + appletsAccountInfo);
        }
        addCache(appletsAccountInfo);
        this.proxyManager.transSaveToDatabase();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.asyncdb.BaseCache
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.asyncdb.BaseCache
    public String getKey(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) entity);
        }
        return ((AppletsAccountInfo) entity).uin;
    }
}
