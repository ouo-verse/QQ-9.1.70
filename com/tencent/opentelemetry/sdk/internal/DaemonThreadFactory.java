package com.tencent.opentelemetry.sdk.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class DaemonThreadFactory implements ThreadFactory {
    static IPatchRedirector $redirector_;
    private final AtomicInteger counter;
    private final String namePrefix;

    public DaemonThreadFactory(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.counter = new AtomicInteger();
            this.namePrefix = str;
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
        }
        Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
        try {
            newThread.setDaemon(true);
            newThread.setName(this.namePrefix + "-" + this.counter.incrementAndGet());
        } catch (SecurityException unused) {
        }
        return newThread;
    }
}
