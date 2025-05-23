package com.tencent.mobileqq.reportlog.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.reportlog.api.IReportLogWithLoginApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/reportlog/api/impl/ReportLogWithLoginApiImpl;", "Lcom/tencent/mobileqq/reportlog/api/IReportLogWithLoginApi;", "()V", "fetchLogReportConfig", "", "report_log_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class ReportLogWithLoginApiImpl implements IReportLogWithLoginApi {
    static IPatchRedirector $redirector_;

    public ReportLogWithLoginApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchLogReportConfig$lambda$0() {
        a.f281242a.b();
    }

    @Override // com.tencent.mobileqq.reportlog.api.IReportLogWithLoginApi
    public void fetchLogReportConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.reportlog.api.impl.d
                @Override // java.lang.Runnable
                public final void run() {
                    ReportLogWithLoginApiImpl.fetchLogReportConfig$lambda$0();
                }
            }, 128, null, true);
        } catch (Throwable th5) {
            QLog.e("ReportLogWithLoginApiImpl", 1, "fetchLogReportConfig error", th5);
        }
    }
}
