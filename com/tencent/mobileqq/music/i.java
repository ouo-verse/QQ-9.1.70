package com.tencent.mobileqq.music;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppService;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final List<d> f251883a;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f251883a = new ArrayList();
        }
    }

    private Object[] a() {
        Object[] objArr;
        synchronized (this.f251883a) {
            if (this.f251883a.size() > 0) {
                objArr = this.f251883a.toArray();
            } else {
                objArr = null;
            }
        }
        return objArr;
    }

    public void b(AppService appService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appService);
            return;
        }
        Object[] a16 = a();
        if (a16 != null) {
            for (Object obj : a16) {
                ((d) obj).a(appService);
            }
        }
    }

    public void c(AppService appService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appService);
            return;
        }
        Object[] a16 = a();
        if (a16 != null) {
            for (Object obj : a16) {
                ((d) obj).b(appService);
            }
        }
    }

    public void d(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
            return;
        }
        synchronized (this.f251883a) {
            this.f251883a.add(dVar);
        }
    }
}
