package com.tencent.mobileqq.hotpic;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class s {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    int f237038a;

    /* renamed from: b, reason: collision with root package name */
    int f237039b;

    /* renamed from: c, reason: collision with root package name */
    long f237040c;

    /* renamed from: d, reason: collision with root package name */
    boolean f237041d;

    /* renamed from: e, reason: collision with root package name */
    a f237042e;

    /* renamed from: f, reason: collision with root package name */
    int f237043f;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a(boolean z16);
    }

    public s(int i3, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) aVar);
            return;
        }
        this.f237041d = false;
        this.f237043f = 100;
        this.f237038a = i3;
        this.f237042e = aVar;
    }

    public void a(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        if (!this.f237041d) {
            return;
        }
        this.f237039b += i3;
        if (this.f237040c == 0) {
            this.f237040c = SystemClock.uptimeMillis();
            return;
        }
        if (SystemClock.uptimeMillis() - this.f237040c > this.f237043f) {
            a aVar = this.f237042e;
            if (this.f237039b > this.f237038a) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.a(z16);
            this.f237040c = 0L;
            this.f237039b = 0;
        }
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f237041d = z16;
        }
    }
}
