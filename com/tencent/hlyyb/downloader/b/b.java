package com.tencent.hlyyb.downloader.b;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f114400a;

    /* renamed from: b, reason: collision with root package name */
    public long f114401b;

    /* renamed from: c, reason: collision with root package name */
    public long f114402c;

    /* renamed from: d, reason: collision with root package name */
    public int f114403d;

    /* renamed from: e, reason: collision with root package name */
    public long f114404e;

    /* renamed from: f, reason: collision with root package name */
    public String f114405f;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f114400a = 0;
        this.f114401b = 0L;
        this.f114402c = -1L;
        this.f114403d = -1;
        this.f114404e = -1L;
        this.f114405f = "";
    }
}
