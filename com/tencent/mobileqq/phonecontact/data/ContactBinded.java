package com.tencent.mobileqq.phonecontact.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ContactBinded extends Entity {
    static IPatchRedirector $redirector_;
    public boolean isReaded;
    public long timestamp;

    public ContactBinded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
