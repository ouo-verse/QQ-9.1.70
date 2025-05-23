package com.tencent.mobileqq.app;

import MQQ.VipUserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class dt implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public dt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void a(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        int i16;
        VipUserInfo vipUserInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VipInfoObserver", 2, "onUpdate-isSuccess:" + z16);
        }
        if (i3 == 1) {
            if (z16 && (vipUserInfo = (VipUserInfo) obj) != null && vipUserInfo.bUpdate == 1) {
                i16 = vipUserInfo.iGrowthValue;
            } else {
                i16 = -1;
            }
            a(z16, i16);
        }
    }
}
