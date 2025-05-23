package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@Keep
/* loaded from: classes12.dex */
public class GroupLiveTRTCVideoEncParam {
    static IPatchRedirector $redirector_;
    public boolean enableAdjustRes;
    public int minVideoBitrate;
    public int videoBitrate;
    public int videoFps;
    public int videoResolution;
    public int videoResolutionMode;

    public GroupLiveTRTCVideoEncParam(int i3, int i16, int i17, int i18, int i19, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Boolean.valueOf(z16));
            return;
        }
        this.videoResolution = i3;
        this.videoResolutionMode = i16;
        this.videoFps = i17;
        this.videoBitrate = i18;
        this.minVideoBitrate = i19;
        this.enableAdjustRes = z16;
    }
}
