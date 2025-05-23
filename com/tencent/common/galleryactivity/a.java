package com.tencent.common.galleryactivity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a implements h {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<h> f99856d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f99857e;

    /* renamed from: f, reason: collision with root package name */
    protected long f99858f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f99859h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f99860i;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f99856d = new ArrayList<>();
        this.f99858f = 350L;
        this.f99859h = true;
    }

    public void a(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) hVar);
        } else if (!this.f99856d.contains(hVar)) {
            this.f99856d.add(hVar);
        }
    }

    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.f99858f;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f99857e;
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f99858f = 350L;
        }
    }

    public abstract boolean e();

    public abstract boolean f();
}
