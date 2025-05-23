package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Haw implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f375637a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f375638b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f375639c;

    public Haw(AtomicBoolean atomicBoolean, AtomicReference atomicReference, Object obj) {
        this.f375637a = atomicBoolean;
        this.f375638b = atomicReference;
        this.f375639c = obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, atomicBoolean, atomicReference, obj);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f375637a.get()) {
            return;
        }
        try {
            throw new Exception("");
        } catch (Exception e16) {
            String a16 = Cswitch.a(Cswitch.F0);
            for (StackTraceElement stackTraceElement : e16.getStackTrace()) {
                if (a16.equals(stackTraceElement.getClassName() + "_" + stackTraceElement.getMethodName())) {
                    this.f375638b.set(Boolean.TRUE);
                }
            }
            synchronized (this.f375639c) {
                this.f375639c.notify();
            }
        }
    }
}
