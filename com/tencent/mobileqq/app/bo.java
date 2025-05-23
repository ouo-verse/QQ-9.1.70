package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bo extends BaseMessageObserver {
    static IPatchRedirector $redirector_;

    public bo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void richSendNotifyMsg(boolean z16, Object[] objArr, StatictisInfo statictisInfo) {
        long j3;
        if (objArr != null && objArr.length >= 2) {
            j3 = ((Long) objArr[0]).longValue();
            statictisInfo = (StatictisInfo) objArr[1];
        } else {
            j3 = 0;
        }
        onNotifyResultAfterSendRich(z16, j3, statictisInfo);
    }

    public void onNotifyResultAfterSendRich(boolean z16, long j3, StatictisInfo statictisInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Long.valueOf(j3), statictisInfo);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        Object[] objArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (obj instanceof Object[]) {
            objArr = (Object[]) obj;
        } else {
            objArr = null;
        }
        if (i3 == 5006) {
            richSendNotifyMsg(z16, objArr, null);
        }
    }
}
