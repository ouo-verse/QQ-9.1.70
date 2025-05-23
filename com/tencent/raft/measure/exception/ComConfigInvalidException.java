package com.tencent.raft.measure.exception;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.measure.config.RAFTComConfig;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ComConfigInvalidException extends IllegalArgumentException {
    static IPatchRedirector $redirector_;

    public ComConfigInvalidException(RAFTComConfig rAFTComConfig) {
        super("SLIComConfig \u7f3a\u5931\u4fe1\u606f, \u8bf7\u68c0\u67e5" + rAFTComConfig.toString());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) rAFTComConfig);
        }
    }
}
