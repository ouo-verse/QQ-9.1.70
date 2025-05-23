package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public class GroupLiveTRTCAudioFrame {
    static IPatchRedirector $redirector_;
    public int channel;
    public byte[] data;
    public byte[] extraData;
    public int sampleRate;
    public long timestamp;

    public GroupLiveTRTCAudioFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
