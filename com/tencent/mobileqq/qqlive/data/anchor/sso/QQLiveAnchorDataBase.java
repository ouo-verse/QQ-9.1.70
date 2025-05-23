package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class QQLiveAnchorDataBase {
    static IPatchRedirector $redirector_;
    public QQLiveErrorMsg errorMsg;
    public boolean isSuccess;

    public QQLiveAnchorDataBase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public QQLiveAnchorDataBase(QQLiveAnchorDataBase qQLiveAnchorDataBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataBase);
        } else {
            if (qQLiveAnchorDataBase == null) {
                return;
            }
            this.isSuccess = qQLiveAnchorDataBase.isSuccess;
            this.errorMsg = new QQLiveErrorMsg(qQLiveAnchorDataBase.errorMsg);
        }
    }

    public QQLiveAnchorDataBase(boolean z16, QQLiveErrorMsg qQLiveErrorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), qQLiveErrorMsg);
        } else {
            this.isSuccess = z16;
            this.errorMsg = qQLiveErrorMsg;
        }
    }
}
