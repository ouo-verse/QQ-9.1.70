package com.tencent.halley.downloader.f.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a extends PriorityBlockingQueue<Runnable> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public b f113748a;

    /* renamed from: b, reason: collision with root package name */
    private Integer f113749b;

    public a() {
        super(64);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f113748a = null;
            this.f113749b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Runnable poll(long j3, TimeUnit timeUnit) {
        b bVar;
        Runnable runnable = (Runnable) super.poll(j3, timeUnit);
        if (runnable == null && (bVar = this.f113748a) != null) {
            bVar.a();
        }
        return runnable;
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    public final /* synthetic */ boolean offer(Object obj) {
        Runnable runnable = (Runnable) obj;
        b bVar = this.f113748a;
        if (bVar != null && bVar.getPoolSize() != this.f113748a.getMaximumPoolSize() && this.f113748a.f113751a.get() >= this.f113748a.getPoolSize() && this.f113748a.getPoolSize() < this.f113748a.getMaximumPoolSize()) {
            return false;
        }
        return super.offer(runnable);
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public final int remainingCapacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        Integer num = this.f113749b;
        if (num != null) {
            return num.intValue();
        }
        return super.remainingCapacity();
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public final /* synthetic */ Object take() {
        b bVar = this.f113748a;
        if (bVar != null && bVar.b()) {
            b bVar2 = this.f113748a;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return poll(bVar2.getKeepAliveTime(timeUnit), timeUnit);
        }
        return (Runnable) super.take();
    }

    public final boolean a(Runnable runnable, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable, (Object) timeUnit)).booleanValue();
        }
        if (this.f113748a.isShutdown()) {
            throw new RejectedExecutionException("Executor not running, can't force a command into the queue");
        }
        return super.offer(runnable, 0L, timeUnit);
    }
}
