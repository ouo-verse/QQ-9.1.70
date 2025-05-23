package com.tencent.mobileqq.app.automator.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.subaccount.api.ISubAccountProtocService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GetSubAccount extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public GetSubAccount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void g() {
        com.tencent.mobileqq.vfs.b i3 = com.tencent.mobileqq.vfs.b.i();
        BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
        com.tencent.mobileqq.vfs.a a16 = com.tencent.mobileqq.vfs.a.a();
        boolean z16 = true;
        if (MobileQQ.sProcessId != 1) {
            z16 = false;
        }
        i3.l(baseApplicationImpl, a16, z16, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        ISubAccountProtocService iSubAccountProtocService = (ISubAccountProtocService) ((Automator) this.mAutomator).E.getRuntimeService(ISubAccountProtocService.class, "");
        if (iSubAccountProtocService != null) {
            iSubAccountProtocService.getBindAccount();
        }
        if (QLog.isColorLevel()) {
            QLog.d("IAutomator", 2, "subaccount onGetSubAccountBind start int QQInitHandler...");
        }
        g();
        return 7;
    }
}
