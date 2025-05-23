package com.tencent.mobileqq.videoplatform;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SDKState {
    static IPatchRedirector $redirector_ = null;
    public static final int STATE_INITED_DONE = 2;
    public static final int STATE_INITING = 1;
    public static final int STATE_NEVER_INITED = 0;

    public SDKState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getStateStr(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return "STATE_UNKNOW";
                }
                return "STATE_INITED_DONE";
            }
            return "STATE_INITING";
        }
        return "STATE_NEVER_INITED";
    }
}
