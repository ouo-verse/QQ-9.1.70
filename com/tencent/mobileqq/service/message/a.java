package com.tencent.mobileqq.service.message;

import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends u {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public long f286148c;

    /* renamed from: d, reason: collision with root package name */
    public long f286149d;

    /* renamed from: e, reason: collision with root package name */
    public long f286150e;

    /* renamed from: f, reason: collision with root package name */
    public long f286151f;

    /* renamed from: g, reason: collision with root package name */
    public int f286152g;

    /* renamed from: h, reason: collision with root package name */
    public int f286153h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f286154i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f286155j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f286156k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f286157l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f286158m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f286159n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f286160o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f286161p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f286162q;

    /* renamed from: r, reason: collision with root package name */
    public int f286163r;

    /* renamed from: s, reason: collision with root package name */
    public int f286164s;

    /* renamed from: t, reason: collision with root package name */
    public long f286165t;

    /* renamed from: u, reason: collision with root package name */
    public long f286166u;

    /* renamed from: v, reason: collision with root package name */
    public String f286167v;

    /* renamed from: w, reason: collision with root package name */
    public int f286168w;

    /* renamed from: x, reason: collision with root package name */
    public long f286169x;

    /* renamed from: y, reason: collision with root package name */
    private SparseArray<Object> f286170y;

    public a(long j3, long j16, boolean z16, boolean z17, boolean z18, boolean z19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19));
            return;
        }
        this.f286158m = false;
        this.f286159n = false;
        this.f286160o = true;
        this.f286161p = false;
        this.f286162q = false;
        this.f286165t = -1L;
        this.f286166u = -1L;
        this.f286168w = 0;
        this.f286148c = j3;
        this.f286338a = j16;
        this.f286154i = z16;
        this.f286155j = z17;
        this.f286156k = z18;
        this.f286157l = z19;
    }

    public Object a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        SparseArray<Object> sparseArray = this.f286170y;
        if (sparseArray != null) {
            return sparseArray.get(i3);
        }
        return null;
    }

    public void b(int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, obj);
            return;
        }
        if (this.f286170y == null) {
            this.f286170y = new SparseArray<>();
        }
        this.f286170y.put(i3, obj);
    }
}
