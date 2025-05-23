package com.tencent.mobileqq.music;

import com.tencent.mobileqq.music.api.IQQPlayer;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f implements d {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.music.d
    public void a(AppService appService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appService);
            return;
        }
        IQQPlayer iQQPlayer = (IQQPlayer) QRoute.api(IQQPlayer.class);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineMusicStatusPlayer", 2, "[onCreate]");
        }
        com.tencent.mobileqq.onlinestatus.manager.e eVar = (com.tencent.mobileqq.onlinestatus.manager.e) ((IOnlineStatusManagerService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.e.class);
        if (eVar != null) {
            iQQPlayer.addCallback(eVar.getCallback());
        }
    }

    @Override // com.tencent.mobileqq.music.d
    public void b(AppService appService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appService);
            return;
        }
        IQQPlayer iQQPlayer = (IQQPlayer) QRoute.api(IQQPlayer.class);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineMusicStatusPlayer", 2, "[onDestroy]");
        }
        com.tencent.mobileqq.onlinestatus.manager.e eVar = (com.tencent.mobileqq.onlinestatus.manager.e) ((IOnlineStatusManagerService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.e.class);
        if (eVar != null) {
            iQQPlayer.removeCallback(eVar.getCallback());
        }
    }
}
