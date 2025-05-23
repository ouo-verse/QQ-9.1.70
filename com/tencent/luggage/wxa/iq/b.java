package com.tencent.luggage.wxa.iq;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.luggage.wxa.iq.a;
import com.tencent.luggage.wxa.jq.h;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.iq.a implements Handler.Callback {

    /* renamed from: b, reason: collision with root package name */
    public final a f130737b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f130738c = com.tencent.luggage.wxa.eq.d.a("ColdPoolLeader", this);

    public b(int i3, int i16) {
        this.f130737b = new a(i3, i16);
    }

    @Override // com.tencent.luggage.wxa.iq.d
    public void b(h hVar) {
        this.f130738c.removeCallbacksAndMessages(hVar);
        this.f130737b.remove(hVar);
    }

    @Override // com.tencent.luggage.wxa.iq.d
    public String getName() {
        return "ColdPool";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj = message.obj;
        if (obj instanceof h) {
            this.f130737b.execute((h) obj);
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.iq.a
    public a.InterfaceC6319a a() {
        return this.f130737b;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends BaseThreadPoolExecutor implements a.InterfaceC6319a {

        /* renamed from: a, reason: collision with root package name */
        public int f130739a;

        /* renamed from: b, reason: collision with root package name */
        public int f130740b;

        /* renamed from: c, reason: collision with root package name */
        public int f130741c;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.iq.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class ThreadFactoryC6320a implements ThreadFactory {

            /* renamed from: a, reason: collision with root package name */
            public AtomicInteger f130743a = new AtomicInteger(0);

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f130744b;

            public ThreadFactoryC6320a(b bVar) {
                this.f130744b = bVar;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return com.tencent.luggage.wxa.cq.c.a(this.f130744b.getName() + "#" + this.f130743a.getAndIncrement(), runnable, 5);
            }
        }

        public a(int i3, int i16) {
            super(i3, i16, 10L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new ThreadFactoryC6320a(b.this), new RejectedExecutionHandlerC6321b(b.this));
            this.f130741c = 1;
            this.f130739a = i3;
            this.f130740b = i16;
        }

        @Override // com.tencent.luggage.wxa.iq.a.InterfaceC6319a
        public void a(h hVar) {
            long delay = hVar.getDelay(TimeUnit.MILLISECONDS);
            if (delay <= 0) {
                execute(hVar);
            } else {
                b.this.f130738c.sendMessageAtTime(b.this.f130738c.obtainMessage(0, hVar), SystemClock.uptimeMillis() + delay);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th5) {
            super.afterExecute(runnable, th5);
            if (getQueue().isEmpty()) {
                int corePoolSize = getCorePoolSize();
                int i3 = this.f130739a;
                if (corePoolSize > i3) {
                    setCorePoolSize(i3);
                    this.f130741c = 1;
                    com.tencent.luggage.wxa.zp.d.f146814c.w("ColdPool", "reset to corePoolSize(%s)", Integer.valueOf(this.f130739a));
                }
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            int i3;
            int corePoolSize = getCorePoolSize();
            if (getQueue().size() >= this.f130741c * 10 && (i3 = corePoolSize + 1) <= this.f130740b) {
                setCorePoolSize(i3);
                com.tencent.luggage.wxa.zp.d.f146814c.w("ColdPool", "increment to expand cold pool; queue size=%s currentCoreSize=%s bufferSizeFactor=%s", Integer.valueOf(getQueue().size()), Integer.valueOf(corePoolSize), Integer.valueOf(this.f130741c));
                this.f130741c++;
            }
            super.execute(runnable);
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.iq.b$a$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RejectedExecutionHandlerC6321b implements RejectedExecutionHandler {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f130745a;

            public RejectedExecutionHandlerC6321b(b bVar) {
                this.f130745a = bVar;
            }

            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        }
    }
}
