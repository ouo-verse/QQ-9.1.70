package com.tencent.turingface.sdk.mfa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingface.sdk.mfa.c;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class k implements c.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f382535a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f382536b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f382537c;

    public k(AtomicBoolean atomicBoolean, AtomicReference atomicReference, Object obj) {
        this.f382535a = atomicBoolean;
        this.f382536b = atomicReference;
        this.f382537c = obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, atomicBoolean, atomicReference, obj);
        }
    }

    public void a(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jVar);
        } else {
            if (this.f382535a.get()) {
                return;
            }
            this.f382536b.set(jVar);
            synchronized (this.f382537c) {
                this.f382537c.notify();
            }
        }
    }
}
