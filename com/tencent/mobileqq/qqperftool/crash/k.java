package com.tencent.mobileqq.qqperftool.crash;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqperfnativetool.signalTool.SignalCatcherJNI;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes17.dex */
public class k implements com.tencent.mobileqq.qqperfnativetool.signalTool.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private AtomicBoolean f274276a;

    /* renamed from: b, reason: collision with root package name */
    private d f274277b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f274278c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f274279d;

    public k(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.f274276a = new AtomicBoolean(false);
        this.f274277b = null;
        this.f274278c = false;
        this.f274279d = false;
        this.f274278c = z16;
        this.f274279d = z17;
        if (z16 || z17) {
            com.tencent.mobileqq.qqperfnativetool.a.a().c();
        }
    }

    @Override // com.tencent.mobileqq.qqperfnativetool.signalTool.a
    public void a(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.f274277b.b(new j(i3, i16, i17, "msg"));
        }
    }

    public synchronized boolean b(boolean z16) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, z16)).booleanValue();
        }
        if (this.f274276a.compareAndSet(false, true)) {
            if (this.f274278c) {
                i3 = SignalCatcherJNI.initNativeCrashSignalCatcher(z16);
            } else {
                i3 = 0;
            }
            if (this.f274279d) {
                i16 = SignalCatcherJNI.initANRSignalCatcher(z16);
            } else {
                i16 = 0;
            }
            if (i3 == 0 && i16 == 0) {
                com.tencent.mobileqq.qqperftool.common.e.d("SignalCrashCatcher", "registerToSystem SUCCESS! nativeCrashResult = " + i3 + " | ANRResult = " + i16);
                com.tencent.mobileqq.qqperfnativetool.a.a().d(this);
            } else {
                com.tencent.mobileqq.qqperftool.common.e.b("SignalCrashCatcher", "registerToSystem failed! nativeCrashResult = " + i3 + " | ANRResult = " + i16);
                this.f274276a.set(false);
                if (this.f274278c) {
                    SignalCatcherJNI.unInitNativeCrashSignalCatcher();
                }
                if (this.f274279d) {
                    SignalCatcherJNI.unInitANRSignalCatcher();
                }
            }
        }
        return this.f274276a.get();
    }

    public void c(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar);
        } else {
            this.f274277b = dVar;
        }
    }

    public synchronized boolean d() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        boolean z16 = true;
        if (this.f274276a.compareAndSet(true, false)) {
            if (this.f274278c) {
                i3 = SignalCatcherJNI.unInitNativeCrashSignalCatcher();
            } else {
                i3 = 0;
            }
            if (this.f274279d) {
                i16 = SignalCatcherJNI.unInitANRSignalCatcher();
            } else {
                i16 = 0;
            }
            if (i3 != 0 || i16 != 0) {
                z16 = false;
            }
            if (!z16) {
                com.tencent.mobileqq.qqperftool.common.e.b("SignalCrashCatcher", "unRegisterFromSystem failed! nativeCrashResult = " + i3 + " | ANRResult = " + i16);
            }
        }
        return this.f274276a.get();
    }

    @Override // com.tencent.mobileqq.qqperfnativetool.signalTool.a
    public void onANR(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.f274277b.b(new a());
        }
    }
}
