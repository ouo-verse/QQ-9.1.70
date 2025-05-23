package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class t {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile t f183139b;

    /* renamed from: a, reason: collision with root package name */
    private final List<aj> f183140a;

    t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f183140a = new ArrayList();
        }
    }

    public static t c() {
        if (f183139b == null) {
            synchronized (t.class) {
                if (f183139b == null) {
                    f183139b = new t();
                }
            }
        }
        return f183139b;
    }

    public List<aj> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f183140a;
    }

    public synchronized void b(aj ajVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) ajVar);
        } else {
            if (ajVar == null) {
                return;
            }
            if (this.f183140a.contains(ajVar)) {
                return;
            }
            this.f183140a.add(ajVar);
        }
    }

    public synchronized void d(aj ajVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) ajVar);
        } else {
            if (ajVar == null) {
                return;
            }
            if (!this.f183140a.contains(ajVar)) {
                return;
            }
            this.f183140a.remove(ajVar);
        }
    }
}
