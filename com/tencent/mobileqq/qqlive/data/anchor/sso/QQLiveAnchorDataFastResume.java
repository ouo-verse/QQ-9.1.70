package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorDataFastResume extends QQLiveAnchorDataBase {
    static IPatchRedirector $redirector_;

    public QQLiveAnchorDataFastResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public QQLiveAnchorDataFastResume(boolean z16, QQLiveErrorMsg qQLiveErrorMsg) {
        super(z16, qQLiveErrorMsg);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), qQLiveErrorMsg);
    }

    public QQLiveAnchorDataFastResume(QQLiveAnchorDataBase qQLiveAnchorDataBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveAnchorDataBase);
        } else {
            if (qQLiveAnchorDataBase == null) {
                return;
            }
            this.isSuccess = qQLiveAnchorDataBase.isSuccess;
            this.errorMsg = new QQLiveErrorMsg(qQLiveAnchorDataBase.errorMsg);
        }
    }
}
