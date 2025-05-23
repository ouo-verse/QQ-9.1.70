package com.tencent.ams.xsad.rewarded;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
class RewardedAd$1$1 implements Runnable {
    static IPatchRedirector $redirector_;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            throw null;
        } catch (Throwable th5) {
            com.tencent.ams.xsad.rewarded.utils.c.b("RewardedAd", "remove fragment error.", th5);
        }
    }
}
