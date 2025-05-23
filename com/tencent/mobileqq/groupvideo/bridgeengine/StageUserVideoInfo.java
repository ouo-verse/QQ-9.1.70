package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public class StageUserVideoInfo {
    static IPatchRedirector $redirector_;
    public boolean isBig;
    public long uin;
    public int videoSrcType;

    public StageUserVideoInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.videoSrcType = 0;
            this.isBig = false;
        }
    }
}
