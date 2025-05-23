package com.tencent.mobileqq.paiyipai;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PaiYiPaiObserver", 2, "onUpdate() called with: type = [" + i3 + "], isSuccess = [" + z16 + "], data = [" + obj + "]");
        }
        if (i3 != 1001) {
            if (i3 != 1002) {
                if (i3 != 1006) {
                    if (i3 != 1007) {
                        if (i3 != 9998) {
                            if (i3 == 9999) {
                                b(z16);
                                return;
                            }
                            return;
                        }
                        a(z16, ((Integer) obj).intValue());
                        return;
                    }
                    QQToast.makeText(BaseApplication.getContext(), 0, R.string.f173122sa, 0).show();
                    return;
                }
                QQToast.makeText(BaseApplication.getContext(), 0, R.string.f173202si, 0).show();
                return;
            }
            QQToast.makeText(BaseApplication.getContext(), 0, R.string.f173182sg, 0).show();
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), 0, R.string.f173232sl, 0).show();
    }
}
