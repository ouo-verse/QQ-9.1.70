package com.tencent.youtu.ytagreflectlivecheck;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YTAGReflectSettings {
    static IPatchRedirector $redirector_;
    public boolean isActionReflect;
    public boolean isEncodeReflectData;
    public int safetylevel;

    public YTAGReflectSettings() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.safetylevel = 0;
        this.isEncodeReflectData = false;
        this.isActionReflect = false;
    }
}
