package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class o extends i {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public String f254041d;

    @Override // com.tencent.mobileqq.newfriend.msg.i
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }
}
