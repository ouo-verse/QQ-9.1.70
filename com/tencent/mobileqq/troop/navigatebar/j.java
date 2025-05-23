package com.tencent.mobileqq.troop.navigatebar;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes19.dex */
public class j implements d {
    static IPatchRedirector $redirector_;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.d
    public void a() {
        MqqHandler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof AppInterface) || (handler = ((AppInterface) waitAppRuntime).getHandler(Conversation.class)) == null) {
            return;
        }
        handler.sendEmptyMessage(1009);
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.d
    public TroopAioNavigateBarManager b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TroopAioNavigateBarManager) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (TroopAioNavigateBarManager) MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
    }
}
