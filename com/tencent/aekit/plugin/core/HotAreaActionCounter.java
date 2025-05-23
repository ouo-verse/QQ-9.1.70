package com.tencent.aekit.plugin.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class HotAreaActionCounter {
    static IPatchRedirector $redirector_;
    private static int sCount;
    private static boolean sLockUpdate;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12161);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sCount = 0;
            sLockUpdate = false;
        }
    }

    public HotAreaActionCounter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void clear() {
        sCount = 0;
    }

    public static int getCount() {
        return sCount;
    }

    public static void lockUpdate() {
        sLockUpdate = true;
    }

    public static void reset() {
        sCount = 0;
        sLockUpdate = false;
    }

    public static void updateCount() {
        if (sLockUpdate) {
            return;
        }
        sCount++;
    }
}
