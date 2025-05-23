package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class MagicTip {
    static IPatchRedirector $redirector_;
    public String leftText;
    public String linkText;
    public String type;

    public MagicTip() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
