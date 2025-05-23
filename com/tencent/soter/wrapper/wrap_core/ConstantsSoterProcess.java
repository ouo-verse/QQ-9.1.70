package com.tencent.soter.wrapper.wrap_core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes25.dex */
public class ConstantsSoterProcess {
    static IPatchRedirector $redirector_;

    /* loaded from: classes25.dex */
    public interface KeyStatus {
        public static final int KEY_STATUS_GENERATED_BUT_NOT_UPLOADED = 2;
        public static final int KEY_STATUS_GENERATING = 1;
        public static final int KEY_STATUS_NORMAL = 0;
        public static final int KEY_STATUS_UNDEFINED = -1;
    }

    public ConstantsSoterProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
