package com.tencent.mobileqq.voicechange.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.voicechange.IVoiceChangeHelper;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VoiceChangeHelperImpl implements IVoiceChangeHelper {
    static IPatchRedirector $redirector_;

    public VoiceChangeHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
