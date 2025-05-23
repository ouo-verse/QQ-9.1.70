package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

/* loaded from: classes17.dex */
public class QQLiveAnchorDataThirdPushCheck extends QQLiveAnchorDataBase {
    static IPatchRedirector $redirector_;

    public QQLiveAnchorDataThirdPushCheck() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public QQLiveAnchorDataThirdPushCheck(boolean z16, QQLiveErrorMsg qQLiveErrorMsg) {
        super(z16, qQLiveErrorMsg);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), qQLiveErrorMsg);
    }

    public QQLiveAnchorDataThirdPushCheck(QQLiveAnchorDataThirdPushCheck qQLiveAnchorDataThirdPushCheck) {
        super(qQLiveAnchorDataThirdPushCheck);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveAnchorDataThirdPushCheck);
    }
}
