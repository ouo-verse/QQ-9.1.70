package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorDataAuth extends QQLiveAnchorDataBase {
    static IPatchRedirector $redirector_;

    public QQLiveAnchorDataAuth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public QQLiveAnchorDataAuth(boolean z16, QQLiveErrorMsg qQLiveErrorMsg) {
        super(z16, qQLiveErrorMsg);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), qQLiveErrorMsg);
    }

    public QQLiveAnchorDataAuth(QQLiveAnchorDataAuth qQLiveAnchorDataAuth) {
        super(qQLiveAnchorDataAuth);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveAnchorDataAuth);
    }
}
