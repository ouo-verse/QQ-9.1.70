package com.tencent.soter.wrapper.wrap_task;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessResultBase;
import com.tencent.soter.wrapper.wrap_core.SoterDataCenter;

/* loaded from: classes25.dex */
abstract class BaseSoterPrepareKeyTask extends BaseSoterTask {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Soter.BaseSoterPrepareKeyTask";

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseSoterPrepareKeyTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void markKeyStatus(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            return;
        }
        SLogger.d(TAG, "soter: marking preference. key: %s, status: %d", str, Integer.valueOf(i3));
        synchronized (SoterDataCenter.class) {
            if (SoterDataCenter.getInstance().getStatusSharedPreference() != null) {
                SoterDataCenter.getInstance().getStatusSharedPreference().edit().putInt(str, i3).commit();
            }
        }
    }

    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    void onExecuteCallback(SoterProcessResultBase soterProcessResultBase) {
    }
}
