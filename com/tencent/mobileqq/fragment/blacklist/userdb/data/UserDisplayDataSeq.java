package com.tencent.mobileqq.fragment.blacklist.userdb.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class UserDisplayDataSeq extends Entity {
    static IPatchRedirector $redirector_;

    @unique
    public String seq;

    public UserDisplayDataSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.seq = "-1";
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void copyProperties(UserDisplayDataSeq userDisplayDataSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) userDisplayDataSeq);
        } else {
            this.seq = userDisplayDataSeq.seq;
        }
    }

    public UserDisplayDataSeq(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.seq = String.valueOf(l3);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) l3);
        }
    }

    public UserDisplayDataSeq(UserDisplayDataSeq userDisplayDataSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            copyProperties(userDisplayDataSeq);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) userDisplayDataSeq);
        }
    }
}
