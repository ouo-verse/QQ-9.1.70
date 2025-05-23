package com.tencent.mobileqq.activity.recent.msgbox.search;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends ax {
    static IPatchRedirector $redirector_;

    public a(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            Intent intent = new Intent();
            intent.setFlags(67108864);
            PublicFragmentActivity.start(this.f307437b, intent, TempMsgBoxFragment.class);
            return true;
        } catch (RuntimeException e16) {
            QLog.e("TempMsgBoxJumpAction", 1, e16, new Object[0]);
            return false;
        }
    }
}
