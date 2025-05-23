package com.tencent.autotemplate.extra;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class PreDetect {
    static IPatchRedirector $redirector_ = null;
    public static final String FACE_DETECT = "face";
    public static final String FRAME_DETECT = "smartFrame";

    public PreDetect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
