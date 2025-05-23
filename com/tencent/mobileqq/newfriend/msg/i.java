package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f254035a;

    /* renamed from: b, reason: collision with root package name */
    public long f254036b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f254037c;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f254037c = false;
        }
    }

    public String a(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        }
        return this.f254035a;
    }

    public abstract boolean b();

    public boolean c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime)).booleanValue();
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "NewFriendMessage{message='" + this.f254035a + "', msgCreateTime=" + this.f254036b + ", mSuspicious=" + this.f254037c + '}';
    }
}
