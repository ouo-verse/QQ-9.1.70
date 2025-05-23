package com.tencent.mobileqq.msf.core.i0.c.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f248508a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f248509b;

    /* renamed from: c, reason: collision with root package name */
    public long f248510c;

    /* renamed from: d, reason: collision with root package name */
    public long f248511d;

    /* renamed from: e, reason: collision with root package name */
    public long f248512e;

    /* renamed from: f, reason: collision with root package name */
    public long f248513f;

    /* renamed from: g, reason: collision with root package name */
    public long f248514g;

    /* renamed from: h, reason: collision with root package name */
    public long f248515h;

    /* renamed from: i, reason: collision with root package name */
    public long f248516i;

    /* renamed from: j, reason: collision with root package name */
    public long f248517j;

    /* renamed from: k, reason: collision with root package name */
    public long f248518k;

    /* renamed from: l, reason: collision with root package name */
    public long f248519l;

    /* renamed from: m, reason: collision with root package name */
    public short f248520m;

    /* renamed from: n, reason: collision with root package name */
    public short f248521n;

    /* renamed from: o, reason: collision with root package name */
    public long f248522o;

    /* renamed from: p, reason: collision with root package name */
    public long f248523p;

    /* renamed from: q, reason: collision with root package name */
    public long f248524q;

    /* renamed from: r, reason: collision with root package name */
    public long f248525r;

    /* renamed from: s, reason: collision with root package name */
    public String f248526s;

    /* renamed from: t, reason: collision with root package name */
    public long f248527t;

    /* renamed from: u, reason: collision with root package name */
    public long f248528u;

    /* renamed from: v, reason: collision with root package name */
    public long f248529v;

    /* renamed from: w, reason: collision with root package name */
    public String f248530w;

    /* renamed from: x, reason: collision with root package name */
    public long f248531x;

    /* renamed from: y, reason: collision with root package name */
    public int f248532y;

    /* renamed from: z, reason: collision with root package name */
    private final AtomicInteger f248533z;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248528u = 0L;
        this.f248529v = 0L;
        this.f248532y = -1;
        this.f248533z = new AtomicInteger(0);
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f248508a = false;
        this.f248509b = false;
        this.f248512e = 0L;
        this.f248511d = 0L;
        this.f248510c = 0L;
        this.f248513f = 0L;
        this.f248514g = 0L;
        this.f248515h = 0L;
        this.f248516i = 0L;
        this.f248517j = 0L;
        this.f248518k = 0L;
        this.f248521n = (short) 0;
        this.f248520m = (short) 0;
        this.f248523p = 0L;
        this.f248522o = 0L;
        this.f248519l = 0L;
        this.f248527t = 0L;
        this.f248529v = 0L;
        this.f248528u = 0L;
        this.f248526s = null;
        this.f248530w = null;
        this.f248531x = 0L;
    }

    public synchronized int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f248533z.get();
    }

    public synchronized void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f248533z.set(0);
        }
    }

    public synchronized void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f248533z.set(i3);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
    }
}
