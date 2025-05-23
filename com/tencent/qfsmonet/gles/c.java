package com.tencent.qfsmonet.gles;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@TargetApi(17)
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private b f342493a;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            com.tencent.qfsmonet.utils.a.c("MonetEglEnvironment", "create MonetEGL14Environment!");
        }
    }

    @Nullable
    public synchronized b a(EGLContext eGLContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) eGLContext);
        }
        if (this.f342493a == null) {
            this.f342493a = d.f(eGLContext);
        }
        return this.f342493a;
    }

    public synchronized void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        b bVar = this.f342493a;
        if (bVar == null) {
            com.tencent.qfsmonet.utils.a.h("MonetEglEnvironment", "no need to release, no init!");
        } else {
            d.i(bVar);
            this.f342493a = null;
        }
    }
}
