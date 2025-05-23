package com.tencent.mobileqq.app.guard;

import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ForgroundOther extends GuardState {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "GuardManager.ForgroundOther";
    private String mProcess;

    public ForgroundOther() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mProcess = null;
        }
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    protected void onBackground(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "ForgroundOther: onBackground proc: ", str);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    protected void onEnter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        super.onEnter(str);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "ForgroundOther: onEnter proc: ", str);
        }
        this.mProcess = str;
        CoreService.startCoreService(GuardConfig.instance().disableForeground);
        this.mManager.cancelTimer();
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    protected void onForground(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.mProcess = str;
        }
    }
}
