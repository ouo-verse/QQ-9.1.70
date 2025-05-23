package com.tencent.ams.fusion.widget.animatorplayer.physics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes3.dex */
public class PhysicsAnimatorConfig {
    static IPatchRedirector $redirector_;
    private static boolean sEnablePhysicsHardware;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34368);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sEnablePhysicsHardware = false;
        }
    }

    public PhysicsAnimatorConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isEnablePhysicsHardware() {
        return sEnablePhysicsHardware;
    }

    public static void setEnablePhysicsHardware(boolean z16) {
        sEnablePhysicsHardware = z16;
    }
}
