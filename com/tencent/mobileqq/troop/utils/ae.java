package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ae {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static Map<Long, ae> f302003c;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, TroopFileData> f302004a;

    /* renamed from: b, reason: collision with root package name */
    public long f302005b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76716);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f302003c = new HashMap();
        }
    }

    public ae(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
        } else {
            this.f302004a = new HashMap();
            this.f302005b = j3;
        }
    }

    public static ae b(long j3) {
        ae aeVar;
        synchronized (ae.class) {
            aeVar = f302003c.get(Long.valueOf(j3));
            if (aeVar == null) {
                aeVar = new ae(j3);
                f302003c.put(Long.valueOf(j3), aeVar);
            }
        }
        return aeVar;
    }

    public synchronized TroopFileData a(QQAppInterface qQAppInterface, String str) {
        TroopFileData troopFileData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TroopFileData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) str);
        }
        Map<String, TroopFileData> map = this.f302004a;
        if (map != null) {
            troopFileData = map.get(str);
        } else {
            troopFileData = null;
        }
        if (troopFileData == null) {
            EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
            troopFileData = (TroopFileData) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) TroopFileData.class, str);
            createEntityManager.close();
        }
        return troopFileData;
    }

    public synchronized void c(QQAppInterface qQAppInterface, String str, TroopFileData troopFileData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qQAppInterface, str, troopFileData);
            return;
        }
        Map<String, TroopFileData> map = this.f302004a;
        if (map != null) {
            map.put(troopFileData.fileUrl, troopFileData);
        }
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        createEntityManager.persist(troopFileData);
        createEntityManager.close();
    }
}
