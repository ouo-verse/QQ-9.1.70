package com.tencent.opentelemetry.context;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
abstract class ForwardingExecutorService implements ExecutorService {
    static IPatchRedirector $redirector_;
    private final ExecutorService delegate;

    /* JADX INFO: Access modifiers changed from: protected */
    public ForwardingExecutorService(ExecutorService executorService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) executorService);
        } else {
            this.delegate = executorService;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> Collection<? extends Callable<T>> wrap(Context context, Collection<? extends Callable<T>> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Callable<T>> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(context.wrap(it.next()));
        }
        return arrayList;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j3, TimeUnit timeUnit) throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), timeUnit)).booleanValue();
        }
        return this.delegate.awaitTermination(j3, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExecutorService delegate() {
        return this.delegate;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.delegate.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.delegate.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.delegate.shutdown();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.delegate.shutdownNow();
    }
}
