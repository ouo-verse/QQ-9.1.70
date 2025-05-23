package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class r implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f383428a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f383429b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f383430c;

    public r(AtomicBoolean atomicBoolean, AtomicReference atomicReference, Object obj) {
        this.f383428a = atomicBoolean;
        this.f383429b = atomicReference;
        this.f383430c = obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, atomicBoolean, atomicReference, obj);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f383428a.get()) {
            return;
        }
        try {
            throw new Exception("");
        } catch (Exception e16) {
            String a16 = Ccontinue.a(Ccontinue.G0);
            for (StackTraceElement stackTraceElement : e16.getStackTrace()) {
                if (a16.equals(stackTraceElement.getClassName() + "_" + stackTraceElement.getMethodName())) {
                    this.f383429b.set(Boolean.TRUE);
                }
            }
            synchronized (this.f383430c) {
                this.f383430c.notify();
            }
        }
    }
}
