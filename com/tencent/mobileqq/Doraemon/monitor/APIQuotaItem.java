package com.tencent.mobileqq.Doraemon.monitor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* loaded from: classes9.dex */
public class APIQuotaItem implements Serializable {
    static IPatchRedirector $redirector_;
    public long expireTimeMillis;
    public long remainTimes;

    public APIQuotaItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
