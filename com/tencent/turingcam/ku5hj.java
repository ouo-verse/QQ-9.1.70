package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ku5hj implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f382299a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f382300b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f382301c;

    public ku5hj(AtomicBoolean atomicBoolean, AtomicReference atomicReference, Object obj) {
        this.f382299a = atomicBoolean;
        this.f382300b = atomicReference;
        this.f382301c = obj;
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
        if (this.f382299a.get()) {
            return;
        }
        try {
            throw new Exception("");
        } catch (Exception e16) {
            String a16 = LwgsO.a(LwgsO.G0);
            for (StackTraceElement stackTraceElement : e16.getStackTrace()) {
                if (a16.equals(stackTraceElement.getClassName() + "_" + stackTraceElement.getMethodName())) {
                    this.f382300b.set(Boolean.TRUE);
                }
            }
            synchronized (this.f382301c) {
                this.f382301c.notify();
            }
        }
    }
}
