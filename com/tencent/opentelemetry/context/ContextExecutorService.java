package com.tencent.opentelemetry.context;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: P */
/* loaded from: classes22.dex */
class ContextExecutorService extends ForwardingExecutorService {
    static IPatchRedirector $redirector_;
    private final Context context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContextExecutorService(Context context, ExecutorService executorService) {
        super(executorService);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) executorService);
        } else {
            this.context = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context context() {
        return this.context;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) runnable);
        } else {
            delegate().execute(this.context.wrap(runnable));
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? delegate().invokeAll(ForwardingExecutorService.wrap(this.context, collection)) : (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? (T) delegate().invokeAny(ForwardingExecutorService.wrap(this.context, collection)) : (T) iPatchRedirector.redirect((short) 7, (Object) this, (Object) collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? delegate().submit(this.context.wrap(callable)) : (Future) iPatchRedirector.redirect((short) 2, (Object) this, (Object) callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j3, TimeUnit timeUnit) throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? delegate().invokeAll(ForwardingExecutorService.wrap(this.context, collection), j3, timeUnit) : (List) iPatchRedirector.redirect((short) 6, this, collection, Long.valueOf(j3), timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j3, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? (T) delegate().invokeAny(ForwardingExecutorService.wrap(this.context, collection), j3, timeUnit) : (T) iPatchRedirector.redirect((short) 8, this, collection, Long.valueOf(j3), timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? delegate().submit(this.context.wrap(runnable), t16) : (Future) iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable, (Object) t16);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? delegate().submit(this.context.wrap(runnable)) : (Future) iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable);
    }
}
