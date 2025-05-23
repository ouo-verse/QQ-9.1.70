package com.tencent.mobileqq.ad.report.api.impl;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.ad.report.SsoPushReportRequest;
import com.tencent.mobileqq.ad.report.api.ISsoPushReportApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.report;

/* loaded from: classes10.dex */
public class SsoPushReportApiImpl implements ISsoPushReportApi {
    static IPatchRedirector $redirector_ = null;
    private static final int RET_CODE_SUCCESS = 0;
    private static final String TAG = "SsoPushReportApiImpl";

    public SsoPushReportApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void debugReportData(com.tencent.mobileqq.ad.report.a aVar) {
        QLog.d(TAG, 2, "debugReportData:", aVar.a());
    }

    @Override // com.tencent.mobileqq.ad.report.api.ISsoPushReportApi
    public void report(com.tencent.mobileqq.ad.report.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        QLog.d(TAG, 1, "report");
        debugReportData(aVar);
        ThreadManagerV2.excute(new Runnable(aVar) { // from class: com.tencent.mobileqq.ad.report.api.impl.SsoPushReportApiImpl.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.ad.report.a f186931d;

            /* renamed from: com.tencent.mobileqq.ad.report.api.impl.SsoPushReportApiImpl$1$a */
            /* loaded from: classes10.dex */
            class a implements VSDispatchObserver.OnVSRspCallBack<report.SsoPushReportRsp> {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, report.SsoPushReportRsp ssoPushReportRsp) {
                    boolean z17;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, baseRequest, Boolean.valueOf(z16), Long.valueOf(j3), str, ssoPushReportRsp);
                        return;
                    }
                    if (z16 && j3 == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17 && ssoPushReportRsp != null) {
                        QLog.d(SsoPushReportApiImpl.TAG, 1, "report success, retCode:", Integer.valueOf(ssoPushReportRsp.ret_msg.ret_code.get()), ", errMsg:", ssoPushReportRsp.ret_msg.err_msg.get());
                    } else {
                        QLog.e(SsoPushReportApiImpl.TAG, 1, "onReceive error result:", Boolean.valueOf(z17));
                    }
                }
            }

            {
                this.f186931d = aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SsoPushReportApiImpl.this, (Object) aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    VSNetworkHelper.getInstance().sendRequest(new SsoPushReportRequest(this.f186931d), new a());
                }
            }
        }, 128, null, false);
    }
}
