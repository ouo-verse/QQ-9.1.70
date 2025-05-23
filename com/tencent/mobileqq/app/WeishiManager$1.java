package com.tencent.mobileqq.app;

import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
class WeishiManager$1 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ dv this$0;

    @Override // java.lang.Runnable
    public void run() {
        QQAppInterface qQAppInterface;
        QQAppInterface qQAppInterface2;
        QQAppInterface qQAppInterface3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            qQAppInterface = this.this$0.f195512d;
            if (qQAppInterface == null) {
                return;
            }
            SessionInfo sessionInfo = new SessionInfo();
            String str = AppConstants.WEISHI_UIN;
            sessionInfo.f179557e = str;
            sessionInfo.f179555d = 1008;
            qQAppInterface2 = this.this$0.f195512d;
            ChatActivityFacade.Q0(qQAppInterface2, sessionInfo);
            qQAppInterface3 = this.this$0.f195512d;
            qQAppInterface3.getMessageFacade().R0(str, 1008, true, true);
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
