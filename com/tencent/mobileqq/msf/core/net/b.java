package com.tencent.mobileqq.msf.core.net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f248718a;

    /* renamed from: b, reason: collision with root package name */
    public String f248719b;

    /* renamed from: c, reason: collision with root package name */
    public String f248720c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f248721d;

    /* renamed from: e, reason: collision with root package name */
    public q f248722e;

    /* renamed from: f, reason: collision with root package name */
    public String f248723f;

    /* renamed from: g, reason: collision with root package name */
    public int f248724g;

    /* renamed from: h, reason: collision with root package name */
    public int f248725h;

    /* renamed from: i, reason: collision with root package name */
    public long f248726i;

    /* renamed from: j, reason: collision with root package name */
    public int f248727j;

    /* renamed from: k, reason: collision with root package name */
    public int f248728k;

    /* renamed from: l, reason: collision with root package name */
    public int f248729l;

    /* renamed from: m, reason: collision with root package name */
    public int f248730m;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "" + this.f248726i + "-" + this.f248719b + "-" + this.f248727j + ":" + this.f248728k + "-" + (this.f248721d ? 1 : 0) + ":" + this.f248729l + ":" + this.f248730m + ":" + this.f248722e;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "s:" + this.f248719b + ",l:" + this.f248720c + ",r:" + this.f248721d + ",f:" + this.f248722e + ",d:" + this.f248723f + ",t:" + this.f248718a + ",y:" + this.f248724g + ",i:" + this.f248725h;
    }
}
