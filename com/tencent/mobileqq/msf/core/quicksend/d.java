package com.tencent.mobileqq.msf.core.quicksend;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f249901a;

    /* renamed from: b, reason: collision with root package name */
    public long f249902b;

    /* renamed from: c, reason: collision with root package name */
    public String f249903c;

    /* renamed from: d, reason: collision with root package name */
    public String f249904d;

    /* renamed from: e, reason: collision with root package name */
    public int f249905e;

    /* renamed from: f, reason: collision with root package name */
    public int f249906f;

    /* renamed from: g, reason: collision with root package name */
    public long f249907g;

    /* renamed from: h, reason: collision with root package name */
    public String f249908h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f249909i;

    /* renamed from: j, reason: collision with root package name */
    public long f249910j;

    /* renamed from: k, reason: collision with root package name */
    public int f249911k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f249912l;

    /* renamed from: m, reason: collision with root package name */
    public String f249913m;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f249903c = "0";
        this.f249904d = "";
        this.f249908h = "";
        this.f249913m = "";
    }
}
