package com.tencent.mobileqq.forward;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class h implements Handler.Callback, com.tencent.mobileqq.activity.aio.helper.u {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQCustomDialog f211025d;

    private void a() {
        QQCustomDialog qQCustomDialog = this.f211025d;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) message)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.z
    public void onMoveToState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        if (i3 != 8) {
            if (i3 == 15) {
                a();
                if (QLog.isColorLevel()) {
                    QLog.d("ForwardIMByThirdPartyHelper", 2, "onMoveToState DESTROY =");
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardIMByThirdPartyHelper", 2, "onMoveToState SHOW_FIRST_BEGIN ");
        }
    }
}
