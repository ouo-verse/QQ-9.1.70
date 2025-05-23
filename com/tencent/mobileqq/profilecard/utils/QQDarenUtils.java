package com.tencent.mobileqq.profilecard.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQDarenUtils {
    static IPatchRedirector $redirector_ = null;
    public static final int QQ_DAREN_SHOW_DAYS_DEFAULT = 30;
    public static long sQQDarenLoginDays;

    public QQDarenUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
