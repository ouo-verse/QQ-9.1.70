package com.tencent.mobileqq.statistics.provider.report;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.login.LoginConstants;
import com.tencent.mobileqq.login.LoginReportConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportControllerImpl;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements Provider<z91.b> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private z91.b f290066a;

    /* renamed from: b, reason: collision with root package name */
    private ReportController f290067b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.statistics.provider.report.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public class C8617a implements z91.b {
        static IPatchRedirector $redirector_;

        C8617a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // z91.b
        public List<String> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return com.tencent.mobileqq.qqsec.api.a.f274416a;
        }

        @Override // z91.b
        public boolean d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
            }
            return false;
        }

        @Override // z91.b
        public String e(AppRuntime appRuntime, ServerConfigManager.ConfigType configType, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, this, appRuntime, configType, str);
            }
            if (appRuntime instanceof QQAppInterface) {
                ((QQAppInterface) appRuntime).getServerConfigValue(configType, str);
                return null;
            }
            return null;
        }

        @Override // z91.b
        public List<String> f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (List) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(LoginConstants.f241790a);
            arrayList.addAll(LoginReportConstants.f241795e);
            return arrayList;
        }

        @Override // z91.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public ReportController b(AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ReportController) iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime);
            }
            if (a.this.f290067b == null) {
                synchronized (this) {
                    if (a.this.f290067b == null) {
                        a.this.f290067b = ReportControllerImpl.F(appRuntime);
                    }
                }
            }
            return a.this.f290067b;
        }

        @Override // z91.b
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public ReportController.b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (ReportController.b) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return null;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private z91.b c() {
        return new C8617a();
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Provider
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public z91.b get() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (z91.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f290066a == null) {
            synchronized (this) {
                if (this.f290066a == null) {
                    this.f290066a = c();
                }
            }
        }
        return this.f290066a;
    }
}
