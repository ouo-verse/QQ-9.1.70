package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MtmV0 {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final long f381951a;

    /* renamed from: b, reason: collision with root package name */
    public int f381952b;

    /* renamed from: c, reason: collision with root package name */
    public int f381953c;

    /* renamed from: d, reason: collision with root package name */
    public int f381954d;

    /* renamed from: e, reason: collision with root package name */
    public long f381955e;

    /* renamed from: f, reason: collision with root package name */
    public long f381956f;

    public MtmV0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f381952b = -1;
        this.f381953c = -1;
        this.f381954d = 0;
        this.f381955e = -1L;
        this.f381956f = -1L;
        this.f381951a = System.currentTimeMillis();
    }
}
