package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f261556d;

    /* renamed from: e, reason: collision with root package name */
    private ProxyManager f261557e;

    /* renamed from: f, reason: collision with root package name */
    private EntityManager f261558f;

    /* renamed from: h, reason: collision with root package name */
    private Object f261559h;

    /* renamed from: i, reason: collision with root package name */
    private ConcurrentHashMap<String, QCallCardInfo> f261560i;

    public c(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f261559h = new Object();
        this.f261560i = new ConcurrentHashMap<>();
        this.f261556d = qQAppInterface;
        this.f261557e = qQAppInterface.getProxyManager();
    }

    private void a() {
        EntityManager entityManager = this.f261558f;
        if (entityManager != null && entityManager.isOpen()) {
            this.f261558f.close();
        }
    }

    private EntityManager b() {
        EntityManager entityManager = this.f261558f;
        if (entityManager == null || !entityManager.isOpen()) {
            synchronized (this.f261559h) {
                EntityManager entityManager2 = this.f261558f;
                if (entityManager2 == null || !entityManager2.isOpen()) {
                    this.f261558f = this.f261556d.getEntityManagerFactory().createEntityManager();
                }
            }
        }
        return this.f261558f;
    }

    public QCallCardInfo c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QCallCardInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (this.f261560i.containsKey(str)) {
            return this.f261560i.get(str);
        }
        List<? extends Entity> query = b().query(QCallCardInfo.class, false, "uin = ?", new String[]{str}, null, null, null, null);
        if (query != null) {
            return (QCallCardInfo) query.get(0);
        }
        return null;
    }

    public void d(QCallCardInfo qCallCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qCallCardInfo);
            return;
        }
        if (qCallCardInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QCallCardManager", 2, "saveQcallCard null ");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("QCallCardManager", 2, "CardManager saveQcallCard");
            }
            e(qCallCardInfo);
            this.f261557e.addMsgQueueAndNotify(qCallCardInfo.uin, 0, qCallCardInfo.getTableName(), qCallCardInfo, 3, null);
        }
    }

    public synchronized void e(QCallCardInfo qCallCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qCallCardInfo);
        } else {
            if (qCallCardInfo == null) {
                return;
            }
            if (this.f261560i.containsKey(qCallCardInfo.uin)) {
                this.f261560i.replace(qCallCardInfo.uin, qCallCardInfo);
            } else {
                this.f261560i.put(qCallCardInfo.uin, qCallCardInfo);
            }
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            a();
            this.f261560i.clear();
        }
    }
}
