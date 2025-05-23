package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@Keep
/* loaded from: classes12.dex */
public class GroupLiveTRTCNetworkQosParam {
    static IPatchRedirector $redirector_;
    public int controlMode;
    public int preference;

    public GroupLiveTRTCNetworkQosParam(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.preference = i3;
            this.controlMode = i16;
        }
    }
}
