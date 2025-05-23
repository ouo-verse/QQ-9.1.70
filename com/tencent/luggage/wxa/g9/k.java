package com.tencent.luggage.wxa.g9;

import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k {

    /* renamed from: f, reason: collision with root package name */
    public static k f126653f;

    /* renamed from: b, reason: collision with root package name */
    public ThreadPoolExecutor f126655b;

    /* renamed from: e, reason: collision with root package name */
    public int f126658e;

    /* renamed from: a, reason: collision with root package name */
    public Object f126654a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public PriorityBlockingQueue f126656c = new PriorityBlockingQueue(33);

    /* renamed from: d, reason: collision with root package name */
    public LinkedList f126657d = new LinkedList();

    public k() {
        int b16 = b();
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(b16, 32, 120L, TimeUnit.SECONDS, this.f126656c, new j());
        this.f126655b = baseThreadPoolExecutor;
        baseThreadPoolExecutor.setMaximumPoolSize(32);
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioThreadPool", "new AudioThreadPool poolSize:%d", Integer.valueOf(b16));
    }

    public static k a() {
        if (f126653f == null) {
            synchronized (k.class) {
                if (f126653f == null) {
                    f126653f = new k();
                }
            }
        }
        return f126653f;
    }

    public static void d(l lVar) {
        a().c(lVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0027, code lost:
    
        if (r0 < 8) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int b() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioThreadPool", "getNormalCorePoolSize cpuCount:%d", Integer.valueOf(availableProcessors));
        int i3 = (availableProcessors * 2) + 2;
        int i16 = i3 <= 32 ? 8 : 32;
        i3 = i16;
        this.f126658e = i3;
        return i3;
    }

    public final void c(l lVar) {
        synchronized (this.f126654a) {
            this.f126657d.remove(lVar);
            if (this.f126657d.size() <= 4) {
                this.f126658e = 4;
                a(4);
            }
        }
        this.f126655b.remove(lVar);
    }

    public static void b(l lVar) {
        a().a(lVar);
    }

    public void a(int i3) {
        if (i3 > 32) {
            this.f126658e = 32;
        } else if (i3 < 4) {
            this.f126658e = 4;
        } else {
            this.f126658e = i3;
        }
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioThreadPool", "setCorePoolSize poolSize:%d", Integer.valueOf(i3));
        this.f126655b.setCorePoolSize(i3);
    }

    public final void a(l lVar) {
        synchronized (this.f126654a) {
            lVar.a();
            this.f126657d.add(lVar);
            int i3 = this.f126658e;
            if (this.f126657d.size() > i3) {
                a(i3 + 2);
            }
        }
        this.f126655b.execute(lVar);
    }
}
