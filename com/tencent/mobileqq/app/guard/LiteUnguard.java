package com.tencent.mobileqq.app.guard;

import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class LiteUnguard extends GuardState {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "GuardManager.LiteUnguard";

    public LiteUnguard() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    public void onEnter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onForground onEnter: ", str);
        }
        super.onEnter(str);
        this.mManager.cancelTimer();
        this.mManager.updateActiveStatistic(0);
        GuardManager.sInstance.injector.b(4, GuardConfig.instance().minLiteInterval, 0L);
        CoreService.stopCoreService();
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    protected void onForground(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onForground process: ", str);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    protected void onMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            GuardStateScheduler.getInstance().updateStateOnMessageRecEvent(7, "fake_p_msg");
        }
    }
}
