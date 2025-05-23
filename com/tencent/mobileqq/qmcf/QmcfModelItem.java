package com.tencent.mobileqq.qmcf;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QmcfModelItem {
    static IPatchRedirector $redirector_;
    public String modelDeployString;
    public String modelDlcPath;
    public int modelEncrypt;
    public String modelParamPath;

    public QmcfModelItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
