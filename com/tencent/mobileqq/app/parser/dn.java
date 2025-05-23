package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneShareManager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class dn extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public dn(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean F() {
        QZoneShareManager.shareToQZoneForRedPocket(this.f307437b, this.f307436a.getCurrentUin(), null, 0, this.f307436a.getCurrentNickname(), QUA.getQUA3());
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            return F();
        } catch (Exception e16) {
            QLog.e("QzoneRedpocketShareAction", 1, "doAction error: " + e16.getMessage());
            i("QzoneRedpocketShareAction");
            return false;
        }
    }
}
