package com.tencent.mobileqq.richstatus.comment.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f282320a;

    /* renamed from: b, reason: collision with root package name */
    public b f282321b;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f282320a = 0L;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public a(long j3, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), bVar);
        } else {
            this.f282320a = j3;
            this.f282321b = bVar;
        }
    }
}
