package com.tencent.mobileqq.addfriend.helper;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.thirdsig.api.IThirdSigService;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static b f187352b;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, OpenID> f187353a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements com.tencent.mobileqq.thirdsig.api.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f187354a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppRuntime f187355b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ yc1.a f187356c;

        a(String str, AppRuntime appRuntime, yc1.a aVar) {
            this.f187354a = str;
            this.f187355b = appRuntime;
            this.f187356c = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, str, appRuntime, aVar);
            }
        }

        @Override // com.tencent.mobileqq.thirdsig.api.b
        public void onFail(int i3, @NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            QLog.w("openid", 1, "result = " + i3 + " errMsg = " + str);
            ReportCenter.f().n(this.f187355b.getAccount(), "", this.f187354a, "41", "19", "1", "", "", "4", false);
        }

        @Override // com.tencent.mobileqq.thirdsig.api.b
        public void onSuccess(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            OpenID openID = new OpenID();
            openID.appID = this.f187354a;
            openID.openID = str;
            this.f187355b.getEntityManagerFactory().createEntityManager().persistOrReplace(openID);
            b.this.a(this.f187354a, openID);
            this.f187356c.a(true, openID);
            ReportCenter.f().n(this.f187355b.getAccount(), "", this.f187354a, "41", "19", "0", "", "", "4", false);
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f187353a = new ConcurrentHashMap<>();
        }
    }

    public static synchronized b b() {
        b bVar;
        synchronized (b.class) {
            if (f187352b == null) {
                synchronized (b.class) {
                    if (f187352b == null) {
                        f187352b = new b();
                    }
                }
            }
            bVar = f187352b;
        }
        return bVar;
    }

    private void e(String str, yc1.a aVar, AppRuntime appRuntime) {
        ((IThirdSigService) appRuntime.getRuntimeService(IThirdSigService.class, "all")).getOpenId(appRuntime.getLongAccountUin(), Integer.parseInt(str), "", new a(str, appRuntime, aVar));
    }

    public void a(String str, OpenID openID) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) openID);
            return;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.f187353a.put(str + waitAppRuntime.getCurrentAccountUin(), openID);
        if (QLog.isColorLevel()) {
            QLog.d("openid", 2, "add openid to cache = " + openID);
        }
    }

    public void c(String str, yc1.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        if (d(str) != null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("openid", 2, "get openid key = " + str);
        }
        e(str, aVar, MobileQQ.sMobileQQ.waitAppRuntime(null));
    }

    public OpenID d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (OpenID) iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!this.f187353a.containsKey(str + waitAppRuntime.getCurrentAccountUin())) {
            EntityManager createEntityManager = waitAppRuntime.getEntityManagerFactory().createEntityManager();
            OpenID openID = (OpenID) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) OpenID.class, str);
            if (openID != null) {
                a(str, openID);
                if (QLog.isColorLevel()) {
                    QLog.d("openid", 2, "Add cache from db appid = " + str);
                }
            }
            createEntityManager.close();
        } else if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Already in cache appid = ");
            sb5.append(str);
            sb5.append(",openid=");
            sb5.append(this.f187353a.get(str + waitAppRuntime.getCurrentAccountUin()));
            QLog.d("openid", 2, sb5.toString());
        }
        return this.f187353a.get(str + waitAppRuntime.getCurrentAccountUin());
    }
}
