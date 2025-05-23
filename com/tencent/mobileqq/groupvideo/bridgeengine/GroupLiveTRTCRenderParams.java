package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@Keep
/* loaded from: classes12.dex */
public class GroupLiveTRTCRenderParams {
    static IPatchRedirector $redirector_;
    public int fillMode;
    public int mirrorType;
    public int rotation;

    public GroupLiveTRTCRenderParams(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.rotation = i3;
        this.fillMode = i16;
        this.mirrorType = i17;
    }
}
