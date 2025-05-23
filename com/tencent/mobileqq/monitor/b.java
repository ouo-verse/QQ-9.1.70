package com.tencent.mobileqq.monitor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    volatile boolean f247273a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f247274b;

    /* renamed from: c, reason: collision with root package name */
    public int f247275c;

    /* renamed from: d, reason: collision with root package name */
    long f247276d;

    /* renamed from: e, reason: collision with root package name */
    long f247277e;

    /* renamed from: f, reason: collision with root package name */
    int f247278f;

    /* renamed from: g, reason: collision with root package name */
    int f247279g;

    /* renamed from: h, reason: collision with root package name */
    int[] f247280h;

    /* renamed from: i, reason: collision with root package name */
    int[] f247281i;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f247273a = false;
            this.f247274b = new long[4];
        }
    }

    public boolean a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, i3)).booleanValue();
        }
        if (System.currentTimeMillis() - this.f247276d >= i3) {
            return true;
        }
        return false;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        int i3 = 0;
        this.f247278f = 0;
        this.f247279g = 0;
        while (true) {
            long[] jArr = this.f247274b;
            if (i3 < jArr.length) {
                jArr[i3] = 0;
                i3++;
            } else {
                return;
            }
        }
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f247273a;
    }

    public void d(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Long.valueOf(j3));
        } else if (this.f247273a) {
            long[] jArr = this.f247274b;
            if (jArr[i3] == 0) {
                jArr[i3] = j3;
            }
        }
    }

    public void e(Integer... numArr) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) numArr);
            return;
        }
        if (numArr != null && (i3 = this.f247278f) < 400) {
            if (numArr.length == 1) {
                if (this.f247280h == null) {
                    this.f247280h = new int[400];
                }
                this.f247280h[i3] = numArr[0].intValue();
            } else if (numArr.length == 2) {
                if (this.f247280h == null) {
                    this.f247280h = new int[400];
                }
                if (this.f247281i == null) {
                    this.f247281i = new int[400];
                }
                this.f247280h[i3] = numArr[0].intValue();
                this.f247281i[this.f247278f] = numArr[1].intValue();
            }
            this.f247278f++;
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            if (this.f247273a) {
                return;
            }
            this.f247273a = true;
            this.f247276d = System.currentTimeMillis();
            b();
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.f247273a = false;
        this.f247277e = System.currentTimeMillis();
        b();
    }

    public b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        this.f247273a = false;
        this.f247274b = new long[4];
        this.f247274b = new long[i3];
    }
}
