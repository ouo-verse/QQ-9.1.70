package com.tencent.mobileqq.app.fms;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f195623a;

    /* renamed from: b, reason: collision with root package name */
    public int f195624b;

    /* renamed from: c, reason: collision with root package name */
    public int f195625c;

    /* renamed from: d, reason: collision with root package name */
    public int f195626d;

    /* renamed from: e, reason: collision with root package name */
    public long f195627e;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f195623a = 0;
        this.f195624b = 0;
        this.f195625c = 0;
        this.f195626d = 0;
        this.f195627e = 0L;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "M_size=" + this.f195623a + ",C_size=" + this.f195624b + ",R_size=" + this.f195625c + ",K_len=" + this.f195626d + ",time=" + this.f195627e;
    }
}
