package com.tencent.mobileqq.qqlive;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import dt3.g;

@Keep
/* loaded from: classes17.dex */
public class QQLiveOriginalPkgNameUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQLiveOriginalPkgNameUtil";

    public QQLiveOriginalPkgNameUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getName() {
        return g.a(TAG, QQLiveOriginalPkgNameUtil.class);
    }
}
