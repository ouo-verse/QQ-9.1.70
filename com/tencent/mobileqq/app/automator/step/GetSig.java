package com.tencent.mobileqq.app.automator.step;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ShieldListHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QlinkReliableReport;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GetSig extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private bs f195350d;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class a extends bs {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GetSig.this);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onUpdateSendGetSig(boolean z16) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            GetSig getSig = GetSig.this;
            if (z16) {
                i3 = 7;
            } else {
                i3 = 6;
            }
            getSig.setResult(i3);
        }
    }

    public GetSig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void g() {
        ToServiceMsg createToServiceMsg = ((Automator) this.mAutomator).createToServiceMsg("TransService.ReqGetSign");
        createToServiceMsg.extraData.putInt("ssover", 1);
        createToServiceMsg.extraData.putInt("app_id", AppSetting.f());
        createToServiceMsg.extraData.putByte("a2type", (byte) 4);
        createToServiceMsg.extraData.putByteArray("enkey", ((Automator) this.mAutomator).E.getUinSign());
        ((Automator) this.mAutomator).send(createToServiceMsg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (this.f195350d == null) {
            a aVar = new a();
            this.f195350d = aVar;
            ((Automator) this.mAutomator).E.addDefaultObservers(aVar);
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101532", false)) {
            QLog.e("IAutomator", 1, "sendGetSig");
            g();
            return 2;
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ((ShieldListHandler) ((Automator) this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.SHIELD_LIST_HANDLER)).Y2();
        ReportController.B(((Automator) this.mAutomator).E, true);
        QlinkReliableReport.l();
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        bs bsVar = this.f195350d;
        if (bsVar != null) {
            ((Automator) this.mAutomator).E.removeObserver(bsVar);
            this.f195350d = null;
        }
    }
}
