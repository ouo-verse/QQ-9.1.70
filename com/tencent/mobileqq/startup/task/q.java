package com.tencent.mobileqq.startup.task;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.startup.task.NtTask;
import com.tencent.qqperf.crashdefend.CrashDefendManager;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeHelper;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class q extends NtTask {
    static IPatchRedirector $redirector_;

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.startup.task.NtTask
    public boolean blockUntilFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NonNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else if (MobileQQ.sProcessId == 1) {
            SafeModeHelper.b(context);
            CrashDefendManager.i().f();
        }
    }

    @Override // com.tencent.qqnt.startup.task.NtTask
    public boolean runOnMainThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }
}
