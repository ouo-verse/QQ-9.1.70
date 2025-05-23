package com.tencent.mobileqq.microapp.apkg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class UsedAppListManager implements Manager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "UsedAppListManager";

    public UsedAppListManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "UsedAppListManager init");
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
