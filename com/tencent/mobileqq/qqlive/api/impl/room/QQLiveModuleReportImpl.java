package com.tencent.mobileqq.qqlive.api.impl.room;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.impl.IQQLiveBaseModule;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveModuleReport;
import com.tencent.mobileqq.qqlive.callback.supervision.ReportCallback;
import com.tencent.mobileqq.qqlive.sso.g;
import com.tencent.mobileqq.qqlive.sso.h;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveModuleReportImpl extends IQQLiveBaseModule implements IQQLiveModuleReport {
    static IPatchRedirector $redirector_ = null;
    private static final String REPORT_METHOD = "Report";
    private static final String SERVICE_CMD = "trpc.qlive.qlive_report.Report";

    public QQLiveModuleReportImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.supervision.IQQLiveModuleReport
    public void report(long j3, long j16, long j17, String str, ReportCallback reportCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), str, reportCallback);
            return;
        }
        pq3.a aVar = new pq3.a();
        aVar.f426998a = j16;
        aVar.f427000c = j17;
        aVar.f427002e = j3;
        aVar.f427003f = j3;
        aVar.f427004g = this.sdkImpl.getConfigModule().getConfigData().getLiveClientType();
        aVar.f427005h = str;
        ((com.tencent.mobileqq.qqlive.sso.c) this.sdkImpl.getExtModule("sso_module")).f(SERVICE_CMD, "Report", MessageNano.toByteArray(aVar), new g(new com.tencent.mobileqq.qqlive.sso.a(reportCallback) { // from class: com.tencent.mobileqq.qqlive.api.impl.room.QQLiveModuleReportImpl.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ReportCallback val$callback;

            {
                this.val$callback = reportCallback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveModuleReportImpl.this, (Object) reportCallback);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.sso.a
            public void onBusinessFailed(int i3, String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, i3, (Object) str2);
                } else {
                    super.onBusinessFailed(i3, str2);
                    this.val$callback.onFailed(i3, str2);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.sso.a
            public void onProxyRequestSuccess(int i3, h hVar) throws InvalidProtocolBufferNanoException {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3, (Object) hVar);
                    return;
                }
                pq3.b c16 = pq3.b.c(hVar.e());
                int i16 = c16.f427009a;
                if (i16 == 0) {
                    this.val$callback.onSuccess();
                } else {
                    this.val$callback.onFailed(i16, c16.f427010b);
                }
            }
        }));
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
