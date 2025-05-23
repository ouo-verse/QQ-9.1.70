package com.tencent.mobileqq.qqperftool.crash;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f implements Thread.UncaughtExceptionHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f274258d;

    /* renamed from: e, reason: collision with root package name */
    private g f274259e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.qqperftool.crashdefend.e f274260f;

    /* renamed from: h, reason: collision with root package name */
    private AtomicBoolean f274261h;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f274258d = null;
        this.f274261h = new AtomicBoolean(false);
        g gVar = new g();
        this.f274259e = gVar;
        this.f274260f = new com.tencent.mobileqq.qqperftool.crashdefend.e(gVar);
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f274261h.get();
    }

    public synchronized void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f274261h.compareAndSet(false, true)) {
            this.f274258d = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void c(com.tencent.mobileqq.qqperftool.crashdefend.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar);
        } else {
            this.f274259e.c(dVar);
        }
    }

    public void d(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dVar);
        } else {
            this.f274259e.d(dVar);
        }
    }

    public synchronized void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f274261h.compareAndSet(true, false)) {
            Thread.setDefaultUncaughtExceptionHandler(this.f274258d);
            this.f274258d = null;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) thread, (Object) th5);
            return;
        }
        h hVar = new h(thread, th5);
        com.tencent.mobileqq.qqperftool.common.e.c("JavaCrashHandler", "catch a Java Crash " + hVar.a(), th5);
        boolean a16 = this.f274259e.a(thread, hVar);
        com.tencent.mobileqq.qqperftool.common.b.a("JavaCrashHandler", "uncaughtException isCrashHold is " + a16);
        if (a16) {
            this.f274260f.a(thread, hVar);
            return;
        }
        com.tencent.mobileqq.qqperftool.common.e.c("JavaCrashHandler", "no defender hold Java Crash " + hVar.a(), th5);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f274258d;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th5);
        }
    }
}
