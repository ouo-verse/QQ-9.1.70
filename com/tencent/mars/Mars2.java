package com.tencent.mars;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.mars.app.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes9.dex */
public class Mars2 {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MicroMsg.Mars2";
    public static Context ctx;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58826);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public Mars2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Context getContext() {
        if (ctx == null) {
            synchronized (Mars2.class) {
                ctx = new Context("default");
            }
        }
        return ctx;
    }

    public static void release() {
        w.d(TAG, "mars2 release.");
        Context context = ctx;
        if (context != null) {
            context.onDestroy();
        }
        ctx = null;
    }
}
