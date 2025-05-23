package com.tencent.qimei.t;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class d implements ThreadFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f343381a;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f343381a = new AtomicInteger(1);
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@NonNull Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
        }
        try {
            return new BaseThread(runnable, "qm-thread-" + this.f343381a.getAndIncrement());
        } catch (Exception e16) {
            com.tencent.qimei.ad.c.a(e16);
            return null;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }
}
