package com.tencent.mobileqq.logic;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class a implements BusinessObserver {
    static IPatchRedirector $redirector_;
    private final String TAG;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "TabDataObserver";
        }
    }

    public abstract void onReceive(int i3, boolean z16, Object obj);

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TabDataObserver", 2, "onUpdate, type=", Integer.valueOf(i3), ", isSuccess=", Boolean.valueOf(z16));
        }
        if (i3 == 0) {
            onReceive(i3, z16, obj);
        }
    }
}
