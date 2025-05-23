package com.tencent.mobileqq.antiphing;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f194359a;

    /* renamed from: b, reason: collision with root package name */
    public String f194360b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f194361c;

    /* renamed from: d, reason: collision with root package name */
    public String f194362d;

    /* renamed from: e, reason: collision with root package name */
    public int f194363e;

    /* renamed from: f, reason: collision with root package name */
    public int f194364f;

    /* renamed from: g, reason: collision with root package name */
    public int f194365g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f194366h;

    /* renamed from: i, reason: collision with root package name */
    public int f194367i;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f194359a = "";
        this.f194360b = "";
        this.f194362d = "";
        this.f194363e = 0;
        this.f194364f = 0;
        this.f194365g = 0;
        this.f194361c = null;
        this.f194366h = false;
        this.f194367i = -1;
    }
}
