package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;

/* compiled from: P */
/* loaded from: classes11.dex */
public class dc extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public dc(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean F() {
        if (this.f307436a == null) {
            return false;
        }
        Intent intent = new Intent();
        QzonePluginProxyActivity.setActivityNameToIntent(intent, QZoneHelper.PAGE_DIALOG);
        intent.addFlags(805306368);
        QZoneHelper.launchQZone((Activity) this.f307437b, this.f307436a.getCurrentAccountUin(), intent, -1);
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
            QLog.e("QzoneDialogAction", 1, "doAction error: " + e16.getMessage());
            i("QzoneDialogAction");
            return false;
        }
    }
}
