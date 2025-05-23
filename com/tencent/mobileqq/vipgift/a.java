package com.tencent.mobileqq.vipgift;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f313116a;

    /* renamed from: b, reason: collision with root package name */
    public String f313117b;

    /* renamed from: c, reason: collision with root package name */
    public long f313118c;

    /* renamed from: d, reason: collision with root package name */
    public long f313119d;

    /* renamed from: e, reason: collision with root package name */
    public long f313120e;

    /* renamed from: f, reason: collision with root package name */
    public long f313121f;

    /* renamed from: g, reason: collision with root package name */
    public String f313122g;

    /* renamed from: h, reason: collision with root package name */
    public String f313123h;

    /* renamed from: i, reason: collision with root package name */
    public long f313124i;

    /* renamed from: j, reason: collision with root package name */
    public long f313125j;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f313116a = "";
        this.f313117b = "";
        this.f313118c = 0L;
        this.f313119d = 0L;
        this.f313120e = 0L;
        this.f313121f = 999L;
        this.f313122g = "";
        this.f313123h = "";
        this.f313124i = 0L;
        this.f313125j = 0L;
    }
}
