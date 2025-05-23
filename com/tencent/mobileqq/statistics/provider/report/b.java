package com.tencent.mobileqq.statistics.provider.report;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.soso.LbsInfoReportManager;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.search.report.ReportModel;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b implements Provider<z91.c> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private z91.c f290069a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements z91.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // z91.c
        public void a(Intent intent, AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) appRuntime);
                return;
            }
            if (!(appRuntime instanceof QQAppInterface)) {
                return;
            }
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
            try {
                int intExtra = intent.getIntExtra("is_runtime", -1);
                if (intExtra == 1001) {
                    LbsInfoReportManager lbsInfoReportManager = (LbsInfoReportManager) qQAppInterface.getManager(QQManagerFactory.LBS_REPORT_MANAGER);
                    if (lbsInfoReportManager != null) {
                        lbsInfoReportManager.u(intent);
                    }
                } else {
                    String stringExtra = intent.getStringExtra("reporting_tag");
                    String stringExtra2 = intent.getStringExtra("reporting_detail");
                    try {
                        if ("dc02528".equals(stringExtra)) {
                            if (intExtra == 1) {
                                com.tencent.mobileqq.search.report.b.g(stringExtra, qQAppInterface, (ReportModel) intent.getSerializableExtra("reporting_detail"));
                            }
                        } else if ("dc02181".equals(stringExtra)) {
                            if (intExtra == 0) {
                                com.tencent.mobileqq.statistics.c.b(stringExtra, qQAppInterface, stringExtra2);
                            } else if (intExtra == 1) {
                                com.tencent.mobileqq.statistics.c.c(stringExtra, qQAppInterface, stringExtra2);
                            }
                        }
                    } catch (OutOfMemoryError unused) {
                    }
                }
            } catch (Exception e16) {
                QLog.d("ReportServiceImpl", 1, e16, new Object[0]);
            }
        }

        @Override // z91.c
        public void b(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3);
            }
        }

        @Override // z91.c
        public AppRuntime c(AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (AppRuntime) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
            }
            if (appRuntime == null && MobileQQ.sProcessId == 1) {
                AppRuntime peekAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
                if (peekAppRuntime instanceof QQAppInterface) {
                    return peekAppRuntime;
                }
            }
            return appRuntime;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private z91.c a() {
        return new a();
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public z91.c get() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (z91.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f290069a == null) {
            synchronized (this) {
                if (this.f290069a == null) {
                    this.f290069a = a();
                }
            }
        }
        return this.f290069a;
    }
}
