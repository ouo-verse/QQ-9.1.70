package com.tencent.luggage.wxa.h9;

import com.tencent.luggage.wxa.g9.j;
import com.tencent.luggage.wxa.g9.l;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {

    /* renamed from: f, reason: collision with root package name */
    public static d f126942f;

    /* renamed from: b, reason: collision with root package name */
    public ThreadPoolExecutor f126944b;

    /* renamed from: e, reason: collision with root package name */
    public int f126947e;

    /* renamed from: a, reason: collision with root package name */
    public Object f126943a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public PriorityBlockingQueue f126945c = new PriorityBlockingQueue(9);

    /* renamed from: d, reason: collision with root package name */
    public LinkedList f126946d = new LinkedList();

    public d() {
        int b16 = b();
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(b16, 8, 120L, TimeUnit.SECONDS, this.f126945c, new j("AUDIO_DOWNLOAD_THREAD_POOL_GROUP", "audio_download_thread#"));
        this.f126944b = baseThreadPoolExecutor;
        baseThreadPoolExecutor.setMaximumPoolSize(8);
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDownloadThreadPool", "new AudioThreadPool poolSize:%d", Integer.valueOf(b16));
    }

    public static d a() {
        if (f126942f == null) {
            synchronized (d.class) {
                if (f126942f == null) {
                    f126942f = new d();
                }
            }
        }
        return f126942f;
    }

    public static void d(l lVar) {
        a().c(lVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
    
        if (r0 < 4) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int b() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDownloadThreadPool", "getNormalCorePoolSize cpuCount:%d", Integer.valueOf(availableProcessors));
        int i3 = (availableProcessors * 2) + 2;
        int i16 = i3 <= 8 ? 4 : 8;
        i3 = i16;
        this.f126947e = i3;
        return i3;
    }

    public final void c(l lVar) {
        synchronized (this.f126943a) {
            this.f126946d.remove(lVar);
            if (this.f126946d.size() <= 4) {
                this.f126947e = 4;
                a(4);
            }
        }
        this.f126944b.remove(lVar);
    }

    public static void b(l lVar) {
        a().a(lVar);
    }

    public void a(int i3) {
        if (i3 > 8) {
            this.f126947e = 8;
        } else if (i3 < 4) {
            this.f126947e = 4;
        } else {
            this.f126947e = i3;
        }
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDownloadThreadPool", "setCorePoolSize poolSize:%d", Integer.valueOf(i3));
        this.f126944b.setCorePoolSize(i3);
    }

    public final void a(l lVar) {
        synchronized (this.f126943a) {
            lVar.a();
            this.f126946d.add(lVar);
            int i3 = this.f126947e;
            if (this.f126946d.size() > i3) {
                a(i3 + 2);
            }
        }
        this.f126944b.execute(lVar);
    }
}
