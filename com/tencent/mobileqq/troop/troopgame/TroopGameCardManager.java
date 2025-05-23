package com.tencent.mobileqq.troop.troopgame;

import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopGameCardManager implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private AppRuntime f300244d;

    /* renamed from: e, reason: collision with root package name */
    private EntityManager f300245e;

    /* renamed from: f, reason: collision with root package name */
    private LruCache<String, MemberGradeLevelInfo> f300246f;

    public TroopGameCardManager(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        this.f300246f = new LruCache<>(1000);
        this.f300244d = appRuntime;
        this.f300245e = appRuntime.getEntityManagerFactory().createEntityManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MemberGradeLevelInfo d(String str) {
        String memberGradeLevelInfo;
        if (TextUtils.isEmpty(str)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("TroopGameCardManager", 2, "getMemberGradeLevelInfo arg is invalid");
                return null;
            }
            return null;
        }
        MemberGradeLevelInfo memberGradeLevelInfo2 = this.f300246f.get(str);
        if (memberGradeLevelInfo2 == null) {
            memberGradeLevelInfo2 = (MemberGradeLevelInfo) DBMethodProxy.find(this.f300245e, (Class<? extends Entity>) MemberGradeLevelInfo.class, str);
            h(memberGradeLevelInfo2);
        }
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(" getMemberGradeLevelInfo info = ");
            if (memberGradeLevelInfo2 == null) {
                memberGradeLevelInfo = "null";
            } else {
                memberGradeLevelInfo = memberGradeLevelInfo2.toString();
            }
            sb5.append(memberGradeLevelInfo);
            QLog.d("TroopGameCardManager", 2, sb5.toString());
        }
        return memberGradeLevelInfo2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(ITroopGameCardService.a aVar, String str) {
        aVar.onResult(d(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(Entity entity) {
        if (this.f300245e.isOpen()) {
            if (entity.getStatus() == 1000) {
                this.f300245e.persistOrReplace(entity);
                if (entity.getStatus() != 1001) {
                    return false;
                }
                return true;
            }
            if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                return this.f300245e.update(entity);
            }
        }
        return false;
    }

    public void e(String str, ITroopGameCardService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) aVar);
        } else if (!TextUtils.isEmpty(str) && aVar != null) {
            ThreadManagerV2.excute(new Runnable(str, aVar) { // from class: com.tencent.mobileqq.troop.troopgame.TroopGameCardManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f300247d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ ITroopGameCardService.a f300248e;

                {
                    this.f300247d = str;
                    this.f300248e = aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopGameCardManager.this, str, aVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        ThreadManager.getUIHandler().post(new Runnable(TroopGameCardManager.this.d(this.f300247d)) { // from class: com.tencent.mobileqq.troop.troopgame.TroopGameCardManager.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ MemberGradeLevelInfo f300249d;

                            {
                                this.f300249d = r5;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) r5);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    AnonymousClass1.this.f300248e.onResult(this.f300249d);
                                }
                            }
                        });
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 32, null, true);
        }
    }

    protected void g(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) entity);
        } else {
            ThreadManagerV2.excute(new Runnable(entity) { // from class: com.tencent.mobileqq.troop.troopgame.TroopGameCardManager.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Entity f300251d;

                {
                    this.f300251d = entity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopGameCardManager.this, (Object) entity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    TroopGameCardManager.this.j(this.f300251d);
                    if (QLog.isDevelopLevel()) {
                        QLog.i("TroopGameCardManager", 2, "updateEntity costTime" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            }, 32, null, true);
        }
    }

    public void h(MemberGradeLevelInfo memberGradeLevelInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) memberGradeLevelInfo);
            return;
        }
        if (memberGradeLevelInfo != null && !TextUtils.isEmpty(memberGradeLevelInfo.memberuin)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("TroopGameCardManager", 2, "saveMemberGradeLevelInfo memberuin = " + memberGradeLevelInfo.memberuin + ", level = " + memberGradeLevelInfo.gradeLevel);
            }
            if (this.f300246f == null) {
                this.f300246f = new LruCache<>(1000);
            }
            MemberGradeLevelInfo memberGradeLevelInfo2 = this.f300246f.get(memberGradeLevelInfo.memberuin);
            if (memberGradeLevelInfo2 != null && memberGradeLevelInfo2.equals(memberGradeLevelInfo)) {
                return;
            }
            this.f300246f.put(memberGradeLevelInfo.memberuin, memberGradeLevelInfo);
            g(memberGradeLevelInfo);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("TroopGameCardManager", 2, "saveMemberGradeLevelInfo arg is null");
        }
    }

    public MemberGradeLevelInfo i(final String str, final ITroopGameCardService.a aVar) {
        MemberGradeLevelInfo memberGradeLevelInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MemberGradeLevelInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) aVar);
        }
        if (TextUtils.isEmpty(str) || aVar == null) {
            return null;
        }
        LruCache<String, MemberGradeLevelInfo> lruCache = this.f300246f;
        if (lruCache != null) {
            memberGradeLevelInfo = lruCache.get(str);
        } else {
            memberGradeLevelInfo = null;
        }
        if (memberGradeLevelInfo == null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.troopgame.b
                @Override // java.lang.Runnable
                public final void run() {
                    TroopGameCardManager.this.f(aVar, str);
                }
            }, 32, null, true);
        }
        return memberGradeLevelInfo;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f300244d = null;
        EntityManager entityManager = this.f300245e;
        if (entityManager != null) {
            entityManager.close();
        }
    }
}
