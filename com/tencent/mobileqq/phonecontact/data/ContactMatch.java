package com.tencent.mobileqq.phonecontact.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ContactMatch extends Entity {
    static IPatchRedirector $redirector_;
    public short age;
    public int commonFriend;
    public short gender;
    public boolean isReaded;

    @unique
    public String mobileNo;
    public String name;
    public long timestamp;
    public String unifiedCode;

    public ContactMatch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.gender = (short) 255;
        }
    }
}
