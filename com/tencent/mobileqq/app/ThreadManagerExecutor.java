package com.tencent.mobileqq.app;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ThreadManagerExecutor extends AbstractExecutorService {
    static IPatchRedirector $redirector_;
    private final int type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadManagerExecutor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.type = i3;
        }
    }

    public static ExecutorService getExecutorService(int i3) {
        return new ThreadManagerExecutor(i3);
    }

    public static ExecutorService getSingleThreadExecutorService(int i3) {
        return new SingleThreadExecutor(i3);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j3, @NonNull TimeUnit timeUnit) throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), timeUnit)).booleanValue();
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) runnable);
        } else {
            ThreadManagerV2.excute(runnable, this.type, null, false);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        throw new UnsupportedOperationException();
    }
}
