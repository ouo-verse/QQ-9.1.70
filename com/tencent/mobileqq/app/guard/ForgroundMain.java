package com.tencent.mobileqq.app.guard;

import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.cq;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ForgroundMain extends GuardState {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "GuardManager.ForgroundMain";
    protected long mClearTickQzone;
    protected long mClearTickTool;
    private String mProcess;

    public ForgroundMain() {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "ForgroundMain: onBackground proc: ", str);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    protected void onEnter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        super.onEnter(str);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "ForgroundMain: onEnter proc: ", str);
        }
        this.mClearTickQzone = 0L;
        this.mClearTickTool = 0L;
        CoreService.startCoreService(GuardConfig.instance().disableForeground);
        this.mManager.startTimer();
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    protected void onForground(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "ForgroundMain: onForground proc: ", str);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    protected void onResume(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.mProcess = str;
        }
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    protected void onTick() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onTick();
        boolean z18 = true;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "ForgroundMain: onTick mClearTick: ", Long.valueOf(this.mClearTick), " m");
        }
        this.mClearTickQzone++;
        this.mClearTickTool++;
        if (this.mClearTick >= 3) {
            if (this.mManager.mFgProcess != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            cq.a(z17, "com.tencent.mobileqq:tool", "com.tencent.mobileqq:qzone", "com.tencent.mobileqq:plugins", GuardState.PROCESS_NAME_MINIAPP, "com.tencent.mobileqq:zplan", this.mProcess);
            this.mClearTick = 0L;
            GuardStateScheduler.getInstance().updateStateOnStateTickEvent(2, this.mProcess, 0);
        }
        if (this.mClearTickQzone >= 15 && !GuardManager.sInstance.injector.d()) {
            if (this.mManager.mFgProcess != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            cq.b(z16, "com.tencent.mobileqq:qzone");
            GuardManager.sInstance.injector.g();
            this.mClearTickQzone = 0L;
        }
        if (this.mClearTickTool >= GuardManager.sTickToolBgFgKill) {
            if (this.mManager.mFgProcess == null) {
                z18 = false;
            }
            cq.b(z18, "com.tencent.mobileqq:tool");
            cq.b(z18, "com.tencent.mobileqq:plugins");
            this.mClearTickTool = 0L;
        }
    }
}
