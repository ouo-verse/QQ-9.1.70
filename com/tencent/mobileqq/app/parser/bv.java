package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bv extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public bv(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    protected boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication())) {
            return true;
        }
        QQToast.makeText(BaseApplicationImpl.getApplication(), 1, R.string.ci5, 1).show();
        return false;
    }

    protected boolean G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication())) {
            return true;
        }
        QQToast.makeText(BaseApplicationImpl.getApplication(), 1, R.string.ci5, 1).show();
        return false;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        try {
            if ("openInvitationRoom".equals(this.f307440e)) {
                return G();
            }
            if (!"enterGameRoom".equals(this.f307440e)) {
                return false;
            }
            return F();
        } catch (Exception e16) {
            QLog.e("OpenWereWolfAction", 1, "doAction error: " + e16.getMessage());
            i("OpenWereWolfAction");
            return false;
        }
    }
}
