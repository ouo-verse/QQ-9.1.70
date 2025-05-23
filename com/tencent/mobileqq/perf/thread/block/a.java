package com.tencent.mobileqq.perf.thread.block;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Runnable f258098a;

    /* renamed from: b, reason: collision with root package name */
    public Thread f258099b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.mobileqq.perf.thread.config.a f258100c;

    /* renamed from: d, reason: collision with root package name */
    public int f258101d;

    /* renamed from: e, reason: collision with root package name */
    public long f258102e;

    /* renamed from: f, reason: collision with root package name */
    public long f258103f;

    /* renamed from: g, reason: collision with root package name */
    public long f258104g;

    /* renamed from: h, reason: collision with root package name */
    public long f258105h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Thread thread, com.tencent.mobileqq.perf.thread.config.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) thread, (Object) aVar);
            return;
        }
        this.f258102e = 0L;
        this.f258103f = 0L;
        this.f258104g = 0L;
        this.f258105h = 0L;
        this.f258099b = thread;
        this.f258100c = aVar;
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f258099b.getName();
    }
}
