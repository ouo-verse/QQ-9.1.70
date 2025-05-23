package com.tencent.halley.downloader.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.halley.downloader.d.a f113692a;

    /* renamed from: b, reason: collision with root package name */
    private int f113693b;

    /* renamed from: c, reason: collision with root package name */
    private int f113694c;

    public e(com.tencent.halley.downloader.d.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f113693b = -1;
        this.f113694c = -1;
        this.f113692a = aVar;
    }
}
