package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.phonecontact.data.ContactMatch;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends i {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public ContactMatch f254021d;

    public b(ContactMatch contactMatch) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) contactMatch);
        } else {
            this.f254021d = contactMatch;
            this.f254036b = contactMatch.timestamp;
        }
    }

    @Override // com.tencent.mobileqq.newfriend.msg.i
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f254021d.isReaded;
    }
}
