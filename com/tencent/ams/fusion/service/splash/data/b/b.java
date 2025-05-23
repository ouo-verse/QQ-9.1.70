package com.tencent.ams.fusion.service.splash.data.b;

import com.tencent.ams.fusion.service.splash.data.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public List f70521a;

    /* renamed from: b, reason: collision with root package name */
    public int f70522b;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.fusion.service.splash.data.e
    public List a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f70521a;
    }
}
