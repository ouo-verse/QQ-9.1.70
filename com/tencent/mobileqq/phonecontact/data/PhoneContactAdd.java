package com.tencent.mobileqq.phonecontact.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class PhoneContactAdd extends Entity {
    static IPatchRedirector $redirector_;

    @unique
    public String mobileNo;
    public String name;
    public String remindInfo;
    public long timestamp;
    public String unifiedCode;

    public PhoneContactAdd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
