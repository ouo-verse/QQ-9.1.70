package com.tencent.mobileqq.location.window.event;

import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static final LocationRoom.b f241734b;

    /* renamed from: a, reason: collision with root package name */
    private LocationRoom.b f241735a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31047);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f241734b = new LocationRoom.b(-1, "-1");
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f241735a = f241734b;
        }
    }

    public LocationRoom.b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LocationRoom.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f241735a;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f241735a = f241734b;
        }
    }

    public void c(LocationRoom.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.f241735a = bVar;
        }
    }
}
