package com.tencent.gamecenter.wadl.sdk.common.d.k.a.c;

import com.tencent.gamecenter.wadl.sdk.common.d.i;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes6.dex */
class b extends BaseThread {
    protected volatile boolean C;
    private BlockingQueue<com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.a> D;
    private a E;
    private AtomicInteger F;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(BlockingQueue<com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.a> blockingQueue, a aVar, AtomicInteger atomicInteger) {
        this.D = blockingQueue;
        this.E = aVar;
        this.F = atomicInteger;
    }

    private void a(int i3) {
        int a16 = i.a("total_traffic", 0, false) + i3;
        i.b("total_traffic", a16, false);
        com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-DetectThread", "calculate total traffic:" + a16);
    }

    private void b(int i3) {
        if (com.tencent.gamecenter.wadl.sdk.common.b.c.i() || i3 > 0) {
            a(i3);
        }
        this.C = false;
        this.D = null;
        this.E.a();
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        this.C = true;
        int i3 = 0;
        while (true) {
            try {
                com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.a poll = this.D.poll();
                if (poll == null) {
                    break;
                }
                poll.a();
                this.F.getAndAdd(poll.b());
                if (com.tencent.gamecenter.wadl.sdk.common.b.c.i()) {
                    i3 += poll.h();
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-DetectThread", "queue is empty, ready to exit thread");
    }
}
