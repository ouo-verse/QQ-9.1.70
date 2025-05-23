package com.tencent.mobileqq.app.guard;

import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes11.dex */
public class PrestartGuard extends GuardState {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "GuardManager.PrestartGuard";

    public PrestartGuard() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.guard.GuardState
    public void onEnter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        super.onEnter(str);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "PrestartGuard: onEnter proc", str);
        }
        this.mManager.startTimer();
        CoreService.startTempService();
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    protected void onForground(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "PrestartGuard: onForground proc: ", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.guard.GuardState
    public void onTick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onTick();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "PrestartGuard ontick: clearTime: ", Long.valueOf(this.mClearTick), " guardTime: ", Long.valueOf(this.mGuardTick));
        }
        if (this.mClearTick >= GuardConfig.instance().minLiteInterval / 12000) {
            CoreService.stopTempService();
            this.mManager.cancelTimer();
            this.mClearTick = 0L;
        }
    }
}
