package com.tencent.autotemplate.transition;

import com.tencent.autotemplate.extra.ExtraData;
import com.tencent.autotemplate.model.rhythm.TAVRhythmEffects;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class RhythmTransitionParams {
    static IPatchRedirector $redirector_;
    public ExtraData extraData;
    public TAVRhythmEffects rhythmEffects;
    public String templateDir;
    public long transThreshold;
    public int transitionApplyType;

    public RhythmTransitionParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
