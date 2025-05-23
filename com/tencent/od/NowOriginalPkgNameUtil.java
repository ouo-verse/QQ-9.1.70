package com.tencent.od;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import dt3.g;

@Keep
/* loaded from: classes22.dex */
public class NowOriginalPkgNameUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "NowPostProguardPkgNameUtil";

    public NowOriginalPkgNameUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getName() {
        return g.a(TAG, NowOriginalPkgNameUtil.class);
    }
}
