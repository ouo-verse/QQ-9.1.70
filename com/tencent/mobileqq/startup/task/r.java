package com.tencent.mobileqq.startup.task;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.startup.task.NtTask;
import com.tencent.qqperf.crashdefend.CrashDefendManager;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class r extends NtTask {
    static IPatchRedirector $redirector_;

    public r() {
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
            return;
        }
        if (MobileQQ.sProcessId == 1) {
            CrashDefendManager.i().n(context);
            if (CrashDefendManager.i().c()) {
                CrashDefendManager.i().j(com.tencent.qqperf.crashdefend.d.e(), context);
                com.tencent.qqperf.crashdefend.d.e().f(context);
                CrashDefendManager.i().m();
                Log.i("CrashDefendManager", "CrashDefendManager init Revision is " + AppSetting.l() + " VersionCode is " + AppSetting.j(context));
            } else {
                Log.e("CrashDefendManager", "CrashDefendManager init failed checkIsNeedStartStepCrashDefender is false");
            }
            com.tencent.qqperf.crashdefend.report.b.e(context);
            return;
        }
        Log.i("CrashDefendManager", "CrashDefendManager init jump other process:" + MobileQQ.sProcessId);
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
