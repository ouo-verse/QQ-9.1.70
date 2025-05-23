package com.tencent.mobileqq.qroute.remote;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f276474a;

    /* renamed from: b, reason: collision with root package name */
    public Bundle f276475b;

    /* renamed from: c, reason: collision with root package name */
    public Throwable f276476c;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f276474a = -100;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public c(int i3, Bundle bundle, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bundle, th5);
            return;
        }
        this.f276474a = i3;
        this.f276475b = bundle;
        this.f276476c = th5;
    }

    public c(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bundle);
        } else {
            this.f276474a = i3;
            this.f276475b = bundle;
        }
    }
}
