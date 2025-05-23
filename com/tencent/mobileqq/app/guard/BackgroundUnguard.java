package com.tencent.mobileqq.app.guard;

import android.os.Process;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.MemoryUtils;
import com.tencent.mobileqq.utils.cq;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BackgroundUnguard extends GuardState {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "GuardManager.BackgroundUnguard";

    public BackgroundUnguard() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    protected void onEnter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        super.onEnter(str);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "BackgroundUnGuard onEnter: proc: ", str);
        }
        this.mManager.updateActiveStatistic(0);
        if (!"trick_p_msg".equals(str)) {
            cq.a(false, str);
        }
        if (GuardConfig.instance().getMemoryLevel(MemoryUtils.c(Process.myPid())) != 2) {
            this.mManager.cancelTimer();
        }
        GuardManager.sInstance.injector.b(2, GuardConfig.instance().minLiteInterval, 0L);
        CoreService.stopCoreService();
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    protected void onForground(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "BackgroundUnguard OnForeground: proc: ", str);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    protected void onMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            GuardStateScheduler.getInstance().updateStateOnMessageRecEvent(5, "fake_p_msg");
        }
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    protected void onTick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onTick();
        GuardManagerCallbackDispatcher.dispatchBackgroundUnguardTimeTick(this.mClearTick);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "BackgroundUnguard onTick: mClearTick: ", Long.valueOf(this.mClearTick), " mGuardTick: ", Long.valueOf(this.mGuardTick));
        }
        long j3 = this.mClearTick;
        int i3 = GuardManager.SUICIDE_FACTOR;
        if (j3 != (i3 * 50) - 1) {
            if ((j3 == i3 * 50 || j3 == (i3 * 50) + 1) && this.mManager.mFgProcess == null) {
                System.exit(-1);
            }
        }
    }
}
