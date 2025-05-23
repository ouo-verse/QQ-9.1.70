package com.tencent.mobileqq.msf.sdk.report;

import com.tencent.mobileqq.msf.sdk.handler.IMsfLifeCallbacker;
import com.tencent.mobileqq.msf.sdk.report.StatReportManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c implements IMsfLifeCallbacker {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    public static final String f250710b = "StatManager";

    /* renamed from: a, reason: collision with root package name */
    private boolean f250711a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final c f250712a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25467);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f250712a = new c(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ c(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    public static c a() {
        return b.f250712a;
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfLifeCallbacker
    public void onBindEnd(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        if (this.f250711a) {
            try {
                StatReportManager.e.c().a(z16);
            } catch (Exception e16) {
                QLog.w(f250710b, 1, "", e16);
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfLifeCallbacker
    public void onBindStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f250711a) {
            try {
                StatReportManager.b.c().b();
                StatReportManager.e.c().b();
            } catch (Exception e16) {
                QLog.w(f250710b, 1, "", e16);
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfLifeCallbacker
    public void onReceiveResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfLifeCallbacker
    public void onRecvServicePushResp(FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) fromServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfLifeCallbacker
    public void onReqServiceConn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f250711a) {
            try {
                StatReportManager.b.c().b(System.currentTimeMillis());
            } catch (Exception e16) {
                QLog.w(f250710b, 1, "", e16);
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfLifeCallbacker
    public void onRespToApp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfLifeCallbacker
    public void onSendMsg(ToServiceMsg toServiceMsg, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, toServiceMsg, Boolean.valueOf(z16));
        } else {
            if (toServiceMsg == null) {
                return;
            }
            StatReportManager.sAccount = toServiceMsg.getUin();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfLifeCallbacker
    public void onSendToService(ToServiceMsg toServiceMsg, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) toServiceMsg, i3);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfLifeCallbacker
    public void onServiceConnected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f250711a) {
            try {
                StatReportManager.b.c().a(true);
                StatReportManager.e.c().d();
            } catch (Exception e16) {
                QLog.w(f250710b, 1, "", e16);
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfLifeCallbacker
    public void onServiceDisconnected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f250711a) {
            try {
                StatReportManager.e.c().e();
            } catch (Exception e16) {
                QLog.w(f250710b, 1, "", e16);
                e16.printStackTrace();
            }
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f250711a = true;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
