package com.tencent.mobileqq.troop.redpoint.troopsettingredpoint;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.troopguild.api.ITroopUpgradeUtilsApi;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes19.dex */
public class CenterProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f298271a;

    /* renamed from: b, reason: collision with root package name */
    private QQAppInterface f298272b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<Integer, a> f298273c;

    public CenterProcessor(QQAppInterface qQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) str);
            return;
        }
        this.f298273c = new ConcurrentHashMap<>();
        this.f298272b = qQAppInterface;
        this.f298271a = str;
        e();
    }

    private void e() {
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f298273c;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(1, new RobotProcessor(this.f298272b, this.f298271a));
            this.f298273c.put(3, new b(this.f298272b, this.f298271a));
            this.f298273c.put(5, new c(this.f298272b, this.f298271a));
            f();
        }
    }

    private void f() {
        Object createTroopSettingUpgradeRedDotProcessor = ((ITroopUpgradeUtilsApi) QRoute.api(ITroopUpgradeUtilsApi.class)).createTroopSettingUpgradeRedDotProcessor(this.f298272b, this.f298271a);
        if (createTroopSettingUpgradeRedDotProcessor instanceof a) {
            this.f298273c.put(6, (a) createTroopSettingUpgradeRedDotProcessor);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f298273c;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.CenterProcessor.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CenterProcessor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Iterator it = CenterProcessor.this.f298273c.entrySet().iterator();
                    while (it.hasNext()) {
                        a aVar = (a) ((Map.Entry) it.next()).getValue();
                        if (aVar != null) {
                            if (QLog.isColorLevel()) {
                                QLog.d(aVar.c(), 2, "cleanTroopSettingRedPointInfo()");
                            }
                            aVar.a();
                        }
                    }
                }
            });
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f298273c;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.CenterProcessor.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CenterProcessor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Iterator it = CenterProcessor.this.f298273c.entrySet().iterator();
                    while (it.hasNext()) {
                        a aVar = (a) ((Map.Entry) it.next()).getValue();
                        if (aVar != null) {
                            if (QLog.isColorLevel()) {
                                QLog.d(aVar.c(), 2, "destroy()");
                            }
                            aVar.b();
                        }
                    }
                    CenterProcessor.this.f298273c.clear();
                }
            });
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f298273c;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.CenterProcessor.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CenterProcessor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Iterator it = CenterProcessor.this.f298273c.entrySet().iterator();
                    while (it.hasNext()) {
                        a aVar = (a) ((Map.Entry) it.next()).getValue();
                        if (aVar != null) {
                            if (QLog.isColorLevel()) {
                                QLog.d(aVar.c(), 2, "initTroopsettingRedPointInfo()");
                            }
                            aVar.d();
                        }
                    }
                }
            });
        }
    }
}
