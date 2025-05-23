package com.tencent.mobileqq.app.guard;

import android.os.Process;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.MemoryUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class LiteGuard extends GuardState {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "GuardManager.LiteGuard";

    public LiteGuard() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.guard.GuardState
    public void onEnter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        super.onEnter(str);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "LiteGuard: onEnter proc: ", str);
        }
        CoreService.startCoreService(GuardConfig.instance().disableForeground);
        this.mManager.startTimer();
        GuardManager.sInstance.injector.b(3, 0L, 0L);
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    protected void onForground(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "LiteGuard: onForground proc: ", str);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    protected void onMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        long j3 = this.mGuardTick;
        if (j3 > 2) {
            this.mGuardTick = j3 - 2;
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
        GuardManagerCallbackDispatcher.dispatchLiteTimeTick(this.mClearTick);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "LiteGuard: onTick mClearTime: ", Long.valueOf(this.mClearTick), " mGuardTick: ", Long.valueOf(this.mGuardTick));
        }
        long j3 = this.mGuardTick;
        GuardConfig instance = GuardConfig.instance();
        GuardManager guardManager = this.mManager;
        if (j3 >= instance.getTimeout(guardManager.mCountEvents, guardManager.mLastIndex, guardManager.mLastMinute, MemoryUtils.d(Process.myPid(), true)) / 12000) {
            GuardStateScheduler.getInstance().updateStateOnStateTickEvent(6, null, 0);
        }
    }
}
