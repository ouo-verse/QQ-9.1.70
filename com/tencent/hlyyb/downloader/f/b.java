package com.tencent.hlyyb.downloader.f;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b extends PriorityBlockingQueue<Runnable> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public c f114648a;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f114648a = null;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Runnable poll(long j3, TimeUnit timeUnit) {
        c cVar;
        Runnable runnable = (Runnable) super.poll(j3, timeUnit);
        if (runnable == null && (cVar = this.f114648a) != null) {
            cVar.a();
        }
        return runnable;
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    public final /* synthetic */ boolean offer(Object obj) {
        Runnable runnable = (Runnable) obj;
        c cVar = this.f114648a;
        if (cVar != null && cVar.getPoolSize() != this.f114648a.getMaximumPoolSize() && this.f114648a.e() >= this.f114648a.getPoolSize() && this.f114648a.getPoolSize() < this.f114648a.getMaximumPoolSize()) {
            return false;
        }
        return super.offer(runnable);
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public final int remainingCapacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return super.remainingCapacity();
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public final /* synthetic */ Object take() {
        c cVar = this.f114648a;
        if (cVar != null && cVar.b()) {
            c cVar2 = this.f114648a;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return poll(cVar2.getKeepAliveTime(timeUnit), timeUnit);
        }
        return (Runnable) super.take();
    }

    public b(int i3) {
        super(64);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f114648a = null;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }

    public final void a(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f114648a = cVar;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        }
    }

    public final boolean a(Runnable runnable, long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, runnable, Long.valueOf(j3), timeUnit)).booleanValue();
        }
        if (this.f114648a.isShutdown()) {
            throw new RejectedExecutionException("Executor not running, can't force a command into the queue");
        }
        return super.offer(runnable, j3, timeUnit);
    }
}
