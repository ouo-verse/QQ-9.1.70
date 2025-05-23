package com.tencent.hydevteam.common.progress;

import com.tencent.hydevteam.common.annotation.API;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@API
/* loaded from: classes7.dex */
public class ProgressFutureImpl<T> implements ProgressFuture<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Future<T> f114739a;

    /* renamed from: b, reason: collision with root package name */
    private Progress f114740b;

    public ProgressFutureImpl(Future<T> future, Progress progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) future, (Object) progress);
        } else {
            this.f114739a = future;
            this.f114740b = progress;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, z16)).booleanValue();
        }
        return this.f114739a.cancel(z16);
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.f114739a.get() : (T) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.hydevteam.common.progress.Progress
    public double getProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Double) iPatchRedirector.redirect((short) 2, (Object) this)).doubleValue();
        }
        Progress progress = this.f114740b;
        if (progress == null) {
            return 0.0d;
        }
        return progress.getProgress();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f114739a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f114739a.isDone();
    }

    @Override // java.util.concurrent.Future
    public T get(long j3, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? this.f114739a.get(j3, timeUnit) : (T) iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), timeUnit);
    }
}
