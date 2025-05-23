package com.tencent.luggage.wxa.iq;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.luggage.wxa.iq.a;
import com.tencent.luggage.wxa.jq.h;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.iq.a implements Handler.Callback {

    /* renamed from: b, reason: collision with root package name */
    public final a f130746b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f130747c = com.tencent.luggage.wxa.eq.d.a("HotPoolLeader", this);

    public c(int i3) {
        this.f130746b = new a(i3);
    }

    @Override // com.tencent.luggage.wxa.iq.d
    public void b(h hVar) {
        this.f130747c.removeCallbacksAndMessages(hVar);
        this.f130746b.remove(hVar);
    }

    @Override // com.tencent.luggage.wxa.iq.d
    public String getName() {
        return "HotPool";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj = message.obj;
        if (obj instanceof h) {
            this.f130746b.execute((h) obj);
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.iq.a
    public a.InterfaceC6319a a() {
        return this.f130746b;
    }

    public boolean b() {
        return this.f130746b.getQueue().size() > 0;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends BaseThreadPoolExecutor implements a.InterfaceC6319a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.iq.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class ThreadFactoryC6322a implements ThreadFactory {

            /* renamed from: a, reason: collision with root package name */
            public AtomicInteger f130749a = new AtomicInteger(0);

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f130750b;

            public ThreadFactoryC6322a(c cVar) {
                this.f130750b = cVar;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return com.tencent.luggage.wxa.cq.c.a(this.f130750b.getName() + "#" + this.f130749a.getAndIncrement(), runnable, 7);
            }
        }

        public a(int i3) {
            super(i3, i3, TTL.MAX_VALUE, TimeUnit.HOURS, new LinkedBlockingQueue(), new ThreadFactoryC6322a(c.this), new b(c.this));
        }

        @Override // com.tencent.luggage.wxa.iq.a.InterfaceC6319a
        public void a(h hVar) {
            long delay = hVar.getDelay(TimeUnit.MILLISECONDS);
            if (delay <= 0) {
                execute(hVar);
            } else {
                c.this.f130747c.sendMessageAtTime(c.this.f130747c.obtainMessage(0, hVar), SystemClock.uptimeMillis() + delay);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements RejectedExecutionHandler {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f130751a;

            public b(c cVar) {
                this.f130751a = cVar;
            }

            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        }
    }
}
