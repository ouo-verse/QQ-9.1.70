package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorDataConfigInfo {
    static IPatchRedirector $redirector_;
    public String commonConfig;
    public String currentAnchorConfig;
    public String gameAnchorConfig;
    public String normalAnchorConfig;

    public QQLiveAnchorDataConfigInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
