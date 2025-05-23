package com.tencent.gamecenter.wadl.sdk.common.d.k.a.c;

import android.os.SystemClock;
import com.tencent.gamecenter.wadl.sdk.common.d.i;
import com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.b;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c implements e {

    /* renamed from: g, reason: collision with root package name */
    private static final c f107153g = new c();

    /* renamed from: h, reason: collision with root package name */
    protected static volatile int f107154h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static final Object f107155i = new Object();

    /* renamed from: a, reason: collision with root package name */
    private BlockingQueue<com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.a> f107156a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.b f107157b;

    /* renamed from: c, reason: collision with root package name */
    private long f107158c = -1;

    /* renamed from: e, reason: collision with root package name */
    private final b.a f107160e = new a();

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.gamecenter.wadl.sdk.common.b.d f107161f = new b(this);

    /* renamed from: d, reason: collision with root package name */
    private AtomicInteger f107159d = new AtomicInteger();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements b.a {
        a() {
        }

        @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.b.a
        public void a() {
            synchronized (c.f107155i) {
                c.this.f107157b = null;
                c.this.f107156a = null;
                com.tencent.gamecenter.wadl.sdk.common.b.c.d("Wadl-cloud-DetectorImpl");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b implements com.tencent.gamecenter.wadl.sdk.common.b.d {
        b(c cVar) {
        }

        @Override // com.tencent.gamecenter.wadl.sdk.common.b.d
        public void onNetworkSwitch(int i3, String str) {
            c.f107154h = com.tencent.gamecenter.wadl.sdk.common.b.c.f().intValue();
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-DetectorImpl", "refresh opType:" + i3 + " apn:" + str + " sOpType:" + c.f107154h);
        }
    }

    c() {
    }

    public static c b() {
        return f107153g;
    }

    private boolean b(List<com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.a> list) {
        com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-DetectorImpl", "beforeQueue and remainingQueueCapacity is:" + this.f107159d.get());
        if (this.f107158c != -1) {
            if (SystemClock.elapsedRealtime() - this.f107158c < com.tencent.gamecenter.wadl.sdk.common.b.g.a("detect_received_interval", 1, 3600, 5) * 1000) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    list.get(i3).a(list.get(i3).b());
                }
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-cloud-DetectorImpl", "receive data too fast, abandon data..");
                return false;
            }
        }
        if (this.f107159d.get() < 0) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-cloud-DetectorImpl", "queue is full and remainingQueue:" + this.f107159d.get() + ", and abandon data..");
            for (int i16 = 0; i16 < list.size(); i16++) {
                list.get(i16).a(list.get(i16).b());
            }
            return false;
        }
        if (com.tencent.gamecenter.wadl.sdk.common.b.c.i()) {
            int a16 = i.a("total_traffic", 0, false);
            int a17 = com.tencent.gamecenter.wadl.sdk.common.b.g.a("detect_total_traffic_limit", 4, 32768, 1024) << 10;
            long a18 = i.a("next_clear_total_traffic_time", 0L, false);
            if (a18 != 0 && System.currentTimeMillis() > a18) {
                i.b("next_clear_total_traffic_time", System.currentTimeMillis() + (com.tencent.gamecenter.wadl.sdk.common.b.g.a("detect_traffic_clear_interval", 1, 672, 24) * 60 * 60 * 1000), false);
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-DetectorImpl", "clear total traffic reset nextClearTotalTraffic time.");
                i.b("total_traffic", 0, false);
                a16 = 0;
            } else if (a18 == 0) {
                i.b("next_clear_total_traffic_time", System.currentTimeMillis() + (com.tencent.gamecenter.wadl.sdk.common.b.g.a("detect_traffic_clear_interval", 1, 672, 24) * 60 * 60 * 1000), false);
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-DetectorImpl", "init nextClearTotalTrafficTime.");
            }
            if (a16 > a17) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-cloud-DetectorImpl", "total traffic overflow, abandon detect task.And total traffic:" + a16);
                for (int i17 = 0; i17 < list.size(); i17++) {
                    list.get(i17).a(list.get(i17).b());
                }
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.e
    public boolean a(List<com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.a> list) {
        try {
            if (b(list)) {
                this.f107158c = SystemClock.elapsedRealtime();
                synchronized (f107155i) {
                    if (this.f107156a == null || this.f107157b == null) {
                        this.f107159d.set(com.tencent.gamecenter.wadl.sdk.common.b.g.a("detect_num_limit", 1, 1000, 100));
                        this.f107156a = new LinkedBlockingQueue();
                        this.f107157b = new com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.b(this.f107156a, this.f107160e, this.f107159d);
                        com.tencent.gamecenter.wadl.sdk.common.b.c.a("Wadl-cloud-DetectorImpl", this.f107161f);
                        com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-DetectorImpl", "DetectThread init..");
                    }
                    f107154h = com.tencent.gamecenter.wadl.sdk.common.b.c.f().intValue();
                    int d16 = com.tencent.gamecenter.wadl.sdk.common.b.c.d();
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        list.get(i3).a(d16, f107154h);
                        this.f107156a.offer(list.get(i3));
                        this.f107159d.getAndAdd(-list.get(i3).b());
                    }
                    if (!this.f107157b.C) {
                        this.f107157b.start();
                    }
                }
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-DetectorImpl", "insert into detect queue..remaining capacity:" + this.f107159d.get());
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
