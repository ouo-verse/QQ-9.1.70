package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GetTroopAssisMsg extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private bs f195352d;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class a extends bs {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GetTroopAssisMsg.this);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onGetAllProxyTroopMsgFin(boolean z16, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("IAutomator", 2, "onGetAllProxyMsgFin:" + z16 + ", timeoutFlag=" + j3 + ", type=" + j16);
            }
            if (j16 == 1) {
                if (!z16 || j3 == 8 || j3 == 4) {
                    z17 = false;
                }
                if (!z17) {
                    GetTroopAssisMsg.this.setResult(6);
                } else {
                    GetTroopAssisMsg.this.setResult(7);
                }
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onGetTroopMsgFin(boolean z16, String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), strArr);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("IAutomator", 2, "on GetTroopMsg Fin:" + z16);
            }
            MsgAutoMonitorUtil.getInstance().markGrpFinishCost();
            GetTroopAssisMsg.this.setResult(7);
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onRegisterProxyFin(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("IAutomator", 2, "on RegisterProxy Fin:" + z16);
            }
            if (!z16) {
                GetTroopAssisMsg.this.setResult(6);
            }
        }
    }

    public GetTroopAssisMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        ((Automator) this.mAutomator).E.getMsgHandler().f5(3, true);
        return 2;
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onCreate();
        if (this.f195352d == null) {
            a aVar = new a();
            this.f195352d = aVar;
            ((Automator) this.mAutomator).E.addDefaultObservers(aVar);
        }
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        bs bsVar = this.f195352d;
        if (bsVar != null) {
            ((Automator) this.mAutomator).E.removeObserver(bsVar);
            this.f195352d = null;
        }
    }
}
