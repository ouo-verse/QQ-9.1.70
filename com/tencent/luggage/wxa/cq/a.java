package com.tencent.luggage.wxa.cq;

import android.os.HandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static ConcurrentLinkedQueue f123841a = new ConcurrentLinkedQueue();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.cq.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class RunnableC6120a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f123842a;

        public RunnableC6120a(Runnable runnable) {
            this.f123842a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f123842a.run();
            com.tencent.luggage.wxa.zp.d.f146813b.b(Thread.currentThread(), Thread.currentThread().getName(), Thread.currentThread().getId());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends BaseThread {
        public b(Runnable runnable, String str) {
            super(runnable, str);
        }

        @Override // java.lang.Thread
        public void interrupt() {
            super.interrupt();
            a.f123841a.remove(Long.valueOf(getId()));
            com.tencent.luggage.wxa.zp.d.f146813b.a(this, getName(), getId());
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread
        public synchronized void start() {
            super.start();
            if (!a.f123841a.contains(Long.valueOf(getId()))) {
                a.f123841a.add(Long.valueOf(getId()));
            }
            com.tencent.luggage.wxa.zp.d.f146813b.c(this, getName(), getId());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c extends BaseHandlerThread {
        public c(String str) {
            super(str);
        }

        @Override // java.lang.Thread
        public void interrupt() {
            super.interrupt();
            com.tencent.luggage.wxa.zp.d.f146813b.a(this, getName(), getId());
        }

        @Override // android.os.HandlerThread
        public boolean quit() {
            com.tencent.luggage.wxa.zp.d.f146813b.a(this, getName(), getId());
            return super.quit();
        }

        @Override // android.os.HandlerThread
        public boolean quitSafely() {
            com.tencent.luggage.wxa.zp.d.f146813b.a(this, getName(), getId());
            return super.quitSafely();
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread, java.lang.Thread
        public synchronized void start() {
            super.start();
            com.tencent.luggage.wxa.zp.d.f146813b.c(this, getName(), getId());
        }
    }

    public static int a(int i3, int i16, int i17) {
        return i3 < i16 ? i16 : i3 > i17 ? i17 : i3;
    }

    public static Thread a(String str, Runnable runnable) {
        return new b(new RunnableC6120a(runnable), "[GT]" + str);
    }

    public static HandlerThread a(String str) {
        return a(str, 5);
    }

    public static HandlerThread a(String str, int i3) {
        c cVar = new c("[GT]" + str);
        cVar.setPriority(a(i3, 1, 10));
        return cVar;
    }
}
