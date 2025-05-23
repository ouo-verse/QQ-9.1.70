package com.tencent.util;

import com.tencent.mobileqq.config.aq;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AudioHelperUtil {
    static IPatchRedirector $redirector_;
    static long s_debugSeq;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42343);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            s_debugSeq = 0L;
        }
    }

    public AudioHelperUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized long genDebugSeq() {
        long j3;
        synchronized (AudioHelperUtil.class) {
            j3 = s_debugSeq;
            s_debugSeq = 1 + j3;
        }
        return j3;
    }

    public static boolean isDev() {
        if (!aq.f202315c && aq.f202318f) {
            return true;
        }
        return false;
    }

    public static boolean isLogColorOrGary() {
        if (QLog.isColorLevel() || aq.f202317e || aq.f202316d) {
            return true;
        }
        return false;
    }
}
