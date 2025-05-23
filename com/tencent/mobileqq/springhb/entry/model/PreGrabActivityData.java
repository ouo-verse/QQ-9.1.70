package com.tencent.mobileqq.springhb.entry.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes18.dex */
public class PreGrabActivityData extends BaseActivityData {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SpringHb_PreGrabActivityData";

    public PreGrabActivityData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
