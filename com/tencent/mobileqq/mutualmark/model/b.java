package com.tencent.mobileqq.mutualmark.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f252173a;

    /* renamed from: b, reason: collision with root package name */
    public String f252174b;

    /* renamed from: c, reason: collision with root package name */
    public String f252175c;

    /* renamed from: d, reason: collision with root package name */
    public String f252176d;

    /* renamed from: e, reason: collision with root package name */
    public String f252177e;

    /* renamed from: f, reason: collision with root package name */
    public String f252178f;

    /* renamed from: g, reason: collision with root package name */
    public a f252179g;

    /* renamed from: h, reason: collision with root package name */
    public a f252180h;

    /* renamed from: i, reason: collision with root package name */
    public a f252181i;

    /* renamed from: j, reason: collision with root package name */
    public a f252182j;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f252183a;

        /* renamed from: b, reason: collision with root package name */
        public String f252184b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f252179g = new a();
        this.f252180h = new a();
        this.f252181i = new a();
        this.f252182j = new a();
    }
}
