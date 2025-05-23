package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneLoginInitOperateApi;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GetQZoneFeedCount extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public GetQZoneFeedCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        com.tencent.mobileqq.model.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        QLog.d("GetQZoneFeedCount", 2, "doStep");
        T t16 = this.mAutomator;
        if (t16 != 0 && ((Automator) t16).E != null && (cVar = (com.tencent.mobileqq.model.c) ((Automator) t16).E.getManager(QQManagerFactory.QZONE_MANAGER)) != null) {
            if (QLog.isColorLevel()) {
                QLog.d("GetQZoneFeedCount", 2, "GetQZoneFeedCount isFirstGetUnread:" + cVar.N1() + ",isBackground_Pause:" + ((Automator) this.mAutomator).E.isBackgroundPause);
            }
            if (cVar.N1()) {
                cVar.r4(((Automator) this.mAutomator).E.getAccount(), null);
            } else if (((Automator) this.mAutomator).E.isBackgroundPause) {
                cVar.b1(6);
            } else {
                cVar.Z(5);
            }
        }
        ((IQzoneLoginInitOperateApi) QRoute.api(IQzoneLoginInitOperateApi.class)).onInit();
        return 7;
    }
}
