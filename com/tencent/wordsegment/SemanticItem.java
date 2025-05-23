package com.tencent.wordsegment;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SemanticItem {
    static IPatchRedirector $redirector_;
    public boolean isUnkownWord;
    public String key;
    public String value;

    public SemanticItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
