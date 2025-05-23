package com.tencent.hlyyb.downloader.g.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f114660a;

    /* renamed from: b, reason: collision with root package name */
    public int f114661b;

    /* renamed from: c, reason: collision with root package name */
    public String f114662c;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f114661b = -1;
        }
    }
}
