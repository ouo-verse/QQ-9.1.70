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
public class BackgroundGuard extends GuardState {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "GuardManager.BackgroundGuard";
    private String mProcess;

    public BackgroundGuard() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mProcess = null;
        }
    }

    private void tickExitQzoneProcess() {
        long j3 = this.mClearTick;
        if (j3 == GuardManager.sTickQZoneBgKill || j3 == r2 + 1) {
            if (!"com.tencent.mobileqq:qzone".equals(this.mProcess)) {
                cq.b(false, "com.tencent.mobileqq:qzone");
            }
            cq.f(false);
        }
    }

    private void tickExitToolProcess() {
        long j3 = this.mClearTick;
        if (j3 == GuardManager.sTickToolBgFgKill || j3 == r2 + 1) {
            if (!"com.tencent.mobileqq:tool".equals(this.mProcess)) {
                cq.b(false, "com.tencent.mobileqq:tool");
            }
            if (!"com.tencent.mobileqq:plugins".equals(this.mProcess)) {
                cq.b(false, "com.tencent.mobileqq:plugins");
            }
        }
    }

    public String getProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mProcess;
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
            QLog.d(TAG, 2, "BackgroundGuard enter: process: ", str);
        }
        this.mProcess = str;
        if ("fake_p_msg".equals(str)) {
            GuardConfig instance = GuardConfig.instance();
            GuardManager guardManager = this.mManager;
            this.mGuardTick = (instance.getTimeout(guardManager.mCountEvents, guardManager.mLastIndex, guardManager.mLastMinute, MemoryUtils.c(Process.myPid())) / 12000) - 2;
        }
        CoreService.startCoreService(GuardConfig.instance().disableForeground);
        this.mManager.startTimer();
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    protected void onForground(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "BackgroundGuard onForground: process", str);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.GuardState
    protected void onMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        long j3 = this.mGuardTick;
        if (j3 > 2) {
            this.mGuardTick = j3 - 2;
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
        GuardManagerCallbackDispatcher.dispatchBackgroundTimeTick(this.mClearTick);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "BackgroundGuard onTick: mClearTick: ", Long.valueOf(this.mClearTick), " mGuardTick: ", Long.valueOf(this.mGuardTick));
        }
        int memoryLevel = GuardConfig.instance().getMemoryLevel(MemoryUtils.d(Process.myPid(), true));
        GuardConfig instance = GuardConfig.instance();
        GuardManager guardManager = this.mManager;
        if (this.mGuardTick >= GuardConfig.instance().timeouts[memoryLevel + instance.getActiveLevel(guardManager.mCountEvents, guardManager.mLastIndex, guardManager.mLastMinute)] / 12000) {
            GuardStateScheduler.getInstance().updateStateOnStateTickEvent(4, this.mProcess, 0);
        } else {
            long j3 = this.mClearTick;
            if (j3 == 3 || j3 == 4) {
                cq.a(false, "com.tencent.mobileqq:qzone", GuardState.PROCESS_NAME_MINIAPP, "com.tencent.mobileqq:tool", "com.tencent.mobileqq:plugins", "com.tencent.mobileqq:zplan", this.mProcess);
            }
        }
        long j16 = this.mClearTick;
        if (j16 != 50 && j16 != 51) {
            tickExitQzoneProcess();
            tickExitToolProcess();
        } else {
            cq.f(true);
            cq.a(false, new String[0]);
        }
    }
}
