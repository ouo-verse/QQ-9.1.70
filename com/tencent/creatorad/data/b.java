package com.tencent.creatorad.data;

import com.tencent.creatorad.pb.CreatorReader$ShareAD;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public CreatorReader$ShareAD f100370a;

    /* renamed from: b, reason: collision with root package name */
    public Long f100371b;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f100371b = 0L;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public b(Long l3, CreatorReader$ShareAD creatorReader$ShareAD) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) l3, (Object) creatorReader$ShareAD);
        } else {
            this.f100371b = l3;
            this.f100370a = creatorReader$ShareAD;
        }
    }
}
