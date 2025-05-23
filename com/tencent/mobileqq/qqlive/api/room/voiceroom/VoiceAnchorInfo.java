package com.tencent.mobileqq.qqlive.api.room.voiceroom;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class VoiceAnchorInfo {
    static IPatchRedirector $redirector_;
    public long anchorId;

    public VoiceAnchorInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
