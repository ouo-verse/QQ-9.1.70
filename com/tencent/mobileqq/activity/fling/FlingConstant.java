package com.tencent.mobileqq.activity.fling;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FlingConstant {
    static IPatchRedirector $redirector_ = null;
    public static final int FLING_ACTION_DEFAULT = 0;
    public static final int FLING_ACTION_GESTURE = 2;
    public static final String FLING_ACTION_KEY = "fling_action_key";
    public static final int FLING_ACTION_SNAP = 1;
    public static final String FLING_CODE_KEY = "fling_code_key";

    public FlingConstant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
