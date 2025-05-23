package com.tencent.aekit.plugin.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class PTGYHandAttr extends PTHandAttr {
    static IPatchRedirector $redirector_ = null;
    public static final int HAND_LABEL_FOUR = 216;
    public static final int HAND_LABEL_OTHERS = 213;
    public static final int HAND_LABEL_THREE = 215;
    public static final int HAND_LABEL_UNKOWN = 214;
    public static final int NO_HAND_DETECT = -1;

    public PTGYHandAttr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.aekit.plugin.core.PTHandAttr
    public void setHandType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.handType = i3 + 201;
        }
    }
}
