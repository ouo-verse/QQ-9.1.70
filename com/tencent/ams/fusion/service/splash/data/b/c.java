package com.tencent.ams.fusion.service.splash.data.b;

import com.tencent.ams.fusion.service.splash.data.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c implements g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f70523a;

    /* renamed from: b, reason: collision with root package name */
    public rt.b f70524b;

    /* renamed from: c, reason: collision with root package name */
    public int f70525c;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.fusion.service.splash.data.g
    public rt.b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (rt.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f70524b;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f70525c;
    }
}
