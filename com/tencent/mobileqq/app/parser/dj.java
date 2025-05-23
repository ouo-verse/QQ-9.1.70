package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;

/* compiled from: P */
/* loaded from: classes11.dex */
public class dj extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public dj(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean F() {
        if (this.f307437b == null) {
            return false;
        }
        ((IQzoneMsgApi) QRoute.api(IQzoneMsgApi.class)).openContentBox(this.f307437b);
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
            QLog.e("QzonePublicAccountAction", 1, "doAction error: " + e16.getMessage());
            i("QzonePublicAccountAction");
            return false;
        }
    }
}
