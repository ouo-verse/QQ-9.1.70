package com.tencent.mobileqq.app.automator.step;

import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.GetRichSig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.ce;
import com.tencent.mobileqq.app.cr;
import com.tencent.mobileqq.app.cs;
import com.tencent.mobileqq.app.ct;
import com.tencent.mobileqq.profile.ProfileCardCheckUpdate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.profile.GetSimpleInfoCheckUpdateItem;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.webview.api.IWebManagerService;
import qx.a;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GetCheckUpdate extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    a f195344d;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class a extends AutomatorObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GetCheckUpdate.this);
            }
        }

        @Override // com.tencent.mobileqq.app.AutomatorObserver
        protected void onGetCheckUpdateFin(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
            } else {
                GetCheckUpdate.this.setResult(7);
            }
        }
    }

    public GetCheckUpdate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        FriendListHandler friendListHandler = (FriendListHandler) ((Automator) this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (this.mStepId == 21) {
            i3 = 1;
        } else {
            i3 = 4;
        }
        friendListHandler.getCheckUpdate(true, i3);
        return 7;
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onCreate();
        QQAppInterface qQAppInterface = ((Automator) this.mAutomator).E;
        if (this.mStepId == 21) {
            IPublicAccountHandler iPublicAccountHandler = (IPublicAccountHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
            if (iPublicAccountHandler.isNeedUpdate()) {
                ((Automator) this.mAutomator).L2(102, (com.tencent.mobileqq.service.profile.a) iPublicAccountHandler.newPublicAccountCheckUpdateItem());
            }
            T t16 = this.mAutomator;
            ((Automator) t16).L2(106, new QQSettingUtil.b(((Automator) t16).E));
            T t17 = this.mAutomator;
            ((Automator) t17).L2(118, new a.C11100a(((Automator) t17).E));
            IWebManagerService iWebManagerService = (IWebManagerService) qQAppInterface.getRuntimeService(IWebManagerService.class, "");
            if (iWebManagerService != null) {
                ((Automator) this.mAutomator).L2(127, iWebManagerService.getOfflineCheckUpdateItemInterface());
            }
            ((Automator) this.mAutomator).L2(117, new cr(qQAppInterface));
            ((Automator) this.mAutomator).L2(113, new GetSimpleInfoCheckUpdateItem(qQAppInterface));
            ((Automator) this.mAutomator).L2(116, new com.tencent.mobileqq.service.message.d(qQAppInterface));
            ((Automator) this.mAutomator).L2(114, new ct(qQAppInterface));
            ((Automator) this.mAutomator).L2(115, new cs(qQAppInterface));
            ((Automator) this.mAutomator).L2(122, new ProfileCardCheckUpdate(qQAppInterface));
            ((Automator) this.mAutomator).L2(119, new GetRichSig(qQAppInterface));
            T t18 = this.mAutomator;
            ((Automator) t18).L2(123, new ce(((Automator) t18).E));
            ((Automator) this.mAutomator).L2(126, new com.tencent.mobileqq.log.c(qQAppInterface));
        }
        if (this.f195344d == null) {
            a aVar = new a();
            this.f195344d = aVar;
            qQAppInterface.addObserver(aVar);
        }
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        a aVar = this.f195344d;
        if (aVar != null) {
            ((Automator) this.mAutomator).E.removeObserver(aVar);
            this.f195344d = null;
        }
    }
}
