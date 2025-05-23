package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j extends i {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.mobileqq.newfriend.data.a f254038d;

    public j(com.tencent.mobileqq.newfriend.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f254038d = aVar;
        }
    }

    @Override // com.tencent.mobileqq.newfriend.msg.i
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }
}
