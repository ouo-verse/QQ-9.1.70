package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes19.dex */
public class q extends Observable implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f302197d;

    /* renamed from: e, reason: collision with root package name */
    protected EntityManager f302198e;

    /* renamed from: f, reason: collision with root package name */
    protected ConcurrentHashMap<String, TroopAioTopADInfo> f302199f;

    public q(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f302197d = qQAppInterface;
        this.f302198e = qQAppInterface.getEntityManagerFactory().createEntityManager();
        if (this.f302199f == null) {
            synchronized (this) {
                if (this.f302199f == null) {
                    this.f302199f = new ConcurrentHashMap<>();
                }
            }
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        EntityManager entityManager = this.f302198e;
        if (entityManager != null && entityManager.isOpen()) {
            this.f302198e.close();
        }
        ConcurrentHashMap<String, TroopAioTopADInfo> concurrentHashMap = this.f302199f;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }
}
