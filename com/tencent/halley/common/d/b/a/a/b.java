package com.tencent.halley.common.d.b.a.a;

import com.tencent.halley.common.d.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class b extends BaseThread {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected volatile boolean f113434a;

    /* renamed from: b, reason: collision with root package name */
    private BlockingQueue<com.tencent.halley.common.d.b.a.a.a> f113435b;

    /* renamed from: c, reason: collision with root package name */
    private a f113436c;

    /* renamed from: d, reason: collision with root package name */
    private AtomicInteger f113437d;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(BlockingQueue<com.tencent.halley.common.d.b.a.a.a> blockingQueue, a aVar, AtomicInteger atomicInteger) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, blockingQueue, aVar, atomicInteger);
            return;
        }
        this.f113435b = blockingQueue;
        this.f113436c = aVar;
        this.f113437d = atomicInteger;
    }

    private void a(int i3) {
        if (com.tencent.halley.common.a.c.g() || i3 > 0) {
            b(i3);
        }
        this.f113434a = false;
        this.f113435b = null;
        this.f113436c.a();
    }

    private static void b(int i3) {
        int c16 = i.c("total_traffic") + i3;
        i.a("total_traffic", c16);
        com.tencent.halley.common.utils.d.b("halley-cloud-DetectThread", "calculate total traffic:".concat(String.valueOf(c16)));
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public final void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f113434a = true;
        int i3 = 0;
        while (true) {
            try {
                com.tencent.halley.common.d.b.a.a.a poll = this.f113435b.poll();
                if (poll == null) {
                    com.tencent.halley.common.utils.d.b("halley-cloud-DetectThread", "queue is empty, ready to exit thread");
                    return;
                }
                poll.a();
                this.f113437d.getAndAdd(poll.f113427h);
                if (com.tencent.halley.common.a.c.g()) {
                    i3 += poll.b();
                }
            } catch (Throwable th5) {
                try {
                    th5.printStackTrace();
                    return;
                } finally {
                    a(i3);
                }
            }
        }
    }
}
