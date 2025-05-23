package com.tencent.qimei.b;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static final int f343205c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f343206d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f343207e;

    /* renamed from: a, reason: collision with root package name */
    public final ThreadFactory f343208a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f343209b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16325);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f343205c = availableProcessors;
        f343206d = Math.max(2, availableProcessors);
        f343207e = new d();
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        b bVar = new b();
        this.f343208a = bVar;
        this.f343209b = ProxyExecutors.newFixedThreadPool(f343206d, bVar);
    }

    public void a(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
            return;
        }
        c cVar = new c(this, runnable);
        ExecutorService executorService = this.f343209b;
        if (executorService != null) {
            try {
                executorService.execute(cVar);
            } catch (Throwable unused) {
            }
        }
    }
}
