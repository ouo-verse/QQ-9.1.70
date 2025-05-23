package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GetRedpointStep extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public GetRedpointStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i("GetRedpointStep", 2, "GetRedpointStep");
        }
        if (QBaseActivity.mAppForground) {
            ((IRedTouchServer) ((Automator) this.mAutomator).E.getRuntimeService(IRedTouchServer.class, "")).sendRedpointReq(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tianshu_login_first_clear_push", true), false, 1);
        }
        ((MedalWallMng) ((Automator) this.mAutomator).E.getManager(QQManagerFactory.MEDAL_WALL_MNG)).c();
        return 7;
    }
}
