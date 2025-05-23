package com.tencent.halley.common.a.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b extends LinkedBlockingQueue<Runnable> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public d f113204a;

    /* renamed from: b, reason: collision with root package name */
    private Integer f113205b;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f113204a = null;
            this.f113205b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Runnable poll(long j3, TimeUnit timeUnit) {
        d dVar;
        Runnable runnable = (Runnable) super.poll(j3, timeUnit);
        if (runnable == null && (dVar = this.f113204a) != null) {
            dVar.a();
        }
        return runnable;
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    public final /* synthetic */ boolean offer(Object obj) {
        Runnable runnable = (Runnable) obj;
        d dVar = this.f113204a;
        if (dVar != null && dVar.getPoolSize() != this.f113204a.getMaximumPoolSize() && this.f113204a.f113207a.get() >= this.f113204a.getPoolSize() && this.f113204a.getPoolSize() < this.f113204a.getMaximumPoolSize()) {
            return false;
        }
        return super.offer(runnable);
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
    public final int remainingCapacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        Integer num = this.f113205b;
        if (num != null) {
            return num.intValue();
        }
        return super.remainingCapacity();
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
    public final /* synthetic */ Object take() {
        d dVar = this.f113204a;
        if (dVar != null && dVar.b()) {
            d dVar2 = this.f113204a;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return poll(dVar2.getKeepAliveTime(timeUnit), timeUnit);
        }
        return (Runnable) super.take();
    }

    public b(byte b16) {
        super(16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Byte.valueOf(b16));
        } else {
            this.f113204a = null;
            this.f113205b = null;
        }
    }

    public final boolean a(Runnable runnable, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable, (Object) timeUnit)).booleanValue();
        }
        if (this.f113204a.isShutdown()) {
            throw new RejectedExecutionException("Executor not running, can't force a command into the queue");
        }
        return super.offer(runnable, 0L, timeUnit);
    }
}
