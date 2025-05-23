package com.tencent.qimei.t;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final int f343377d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f343378e;

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f343379b;

    /* renamed from: c, reason: collision with root package name */
    public final d f343380c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19067);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f343377d = availableProcessors;
        f343378e = Math.max(2, availableProcessors);
        new AtomicInteger(0);
    }

    public c(ScheduledExecutorService scheduledExecutorService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) scheduledExecutorService);
            return;
        }
        d dVar = new d();
        this.f343380c = dVar;
        this.f343379b = ProxyExecutors.newScheduledThreadPool(f343378e, dVar);
        new SparseArray();
        new SparseArray();
    }

    @Override // com.tencent.qimei.t.a
    public synchronized void a(long j3, @NonNull Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), runnable);
            return;
        }
        b bVar = new b(this, runnable);
        if (j3 <= 0) {
            j3 = 0;
        }
        this.f343379b.schedule(bVar, j3, TimeUnit.MILLISECONDS);
    }

    @Override // com.tencent.qimei.t.a
    public synchronized void a(@NonNull Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
        } else {
            try {
                this.f343379b.execute(new b(this, runnable));
            } catch (Throwable unused) {
            }
        }
    }
}
