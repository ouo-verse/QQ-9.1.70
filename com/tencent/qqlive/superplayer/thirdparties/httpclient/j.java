package com.tencent.qqlive.superplayer.thirdparties.httpclient;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f345458a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<Request> f345459b;

    /* renamed from: c, reason: collision with root package name */
    private final PriorityBlockingQueue<Request> f345460c;

    /* renamed from: d, reason: collision with root package name */
    private final h f345461d;

    /* renamed from: e, reason: collision with root package name */
    private final l f345462e;

    /* renamed from: f, reason: collision with root package name */
    private final NetworkDispatcher[] f345463f;

    /* renamed from: g, reason: collision with root package name */
    private final List<a> f345464g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f345465h;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void a(Request request);
    }

    public j(h hVar, int i3, l lVar) {
        this.f345458a = new AtomicInteger();
        this.f345459b = new HashSet();
        this.f345460c = new PriorityBlockingQueue<>();
        this.f345464g = new ArrayList();
        this.f345465h = false;
        this.f345461d = hVar;
        this.f345463f = new NetworkDispatcher[i3];
        this.f345462e = lVar;
    }

    public Request a(Request request) {
        request.p(this);
        synchronized (this.f345459b) {
            this.f345459b.add(request);
        }
        request.q(c());
        this.f345460c.add(request);
        return request;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> void b(Request request) {
        synchronized (this.f345459b) {
            this.f345459b.remove(request);
        }
        synchronized (this.f345464g) {
            Iterator<a> it = this.f345464g.iterator();
            while (it.hasNext()) {
                it.next().a(request);
            }
        }
    }

    public int c() {
        return this.f345458a.incrementAndGet();
    }

    public void d() {
        if (this.f345465h) {
            return;
        }
        this.f345465h = true;
        for (int i3 = 0; i3 < this.f345463f.length; i3++) {
            NetworkDispatcher networkDispatcher = new NetworkDispatcher(this.f345460c, this.f345461d, this.f345462e);
            this.f345463f[i3] = networkDispatcher;
            networkDispatcher.start();
        }
    }

    public void e() {
        if (!this.f345465h) {
            return;
        }
        this.f345465h = false;
        for (NetworkDispatcher networkDispatcher : this.f345463f) {
            if (networkDispatcher != null) {
                networkDispatcher.quit();
            }
        }
    }

    public int f() {
        return this.f345459b.size();
    }

    public void g() {
        h();
        this.f345465h = true;
        for (int i3 = 0; i3 < this.f345463f.length; i3++) {
            NetworkDispatcher networkDispatcher = new NetworkDispatcher(this.f345460c, this.f345461d, this.f345462e);
            this.f345463f[i3] = networkDispatcher;
            networkDispatcher.start();
        }
    }

    public void h() {
        this.f345465h = false;
        for (NetworkDispatcher networkDispatcher : this.f345463f) {
            if (networkDispatcher != null) {
                networkDispatcher.quit();
            }
        }
    }

    public j(h hVar, int i3) {
        this(hVar, i3, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }
}
