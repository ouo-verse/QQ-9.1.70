package com.tencent.mobileqq.uftransfer.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a implements com.tencent.mobileqq.uftransfer.api.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f304906a;

    /* renamed from: b, reason: collision with root package name */
    private long f304907b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f304908c;

    /* renamed from: d, reason: collision with root package name */
    private Object f304909d;

    public a(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.f304906a = 0;
        this.f304907b = 0L;
        this.f304908c = false;
        h(i3);
        g((((int) (System.currentTimeMillis() / 1000)) << 32) | Math.abs(new Random().nextInt()));
        e(z16);
    }

    @Override // com.tencent.mobileqq.uftransfer.api.a
    public Object a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f304909d;
    }

    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.f304907b;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f304906a;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f304908c;
    }

    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.f304908c = z16;
        }
    }

    public void f(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, obj);
        } else {
            this.f304909d = obj;
        }
    }

    public void g(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            this.f304907b = j3;
        }
    }

    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f304906a = i3;
        }
    }
}
