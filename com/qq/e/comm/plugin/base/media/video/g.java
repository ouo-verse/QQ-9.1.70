package com.qq.e.comm.plugin.base.media.video;

import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.stat.StatTracer;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<GDTVideoView> f39275b;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<f> f39278e;

    /* renamed from: k, reason: collision with root package name */
    private int f39284k;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f39276c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f39277d = com.qq.e.comm.plugin.j.c.a("playingWithDownloadStuckCheckDuration", 1000);

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f39279f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f39280g = false;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicInteger f39281h = new AtomicInteger(0);

    /* renamed from: i, reason: collision with root package name */
    private final AtomicInteger f39282i = new AtomicInteger(0);

    /* renamed from: j, reason: collision with root package name */
    private final AtomicInteger f39283j = new AtomicInteger(0);

    /* renamed from: a, reason: collision with root package name */
    Runnable f39274a = new Runnable() { // from class: com.qq.e.comm.plugin.base.media.video.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.f39275b != null && g.this.f39275b.get() != null) {
                GDTVideoView gDTVideoView = (GDTVideoView) g.this.f39275b.get();
                int f16 = gDTVideoView.f();
                if ((f16 == 0 && !gDTVideoView.c()) || (g.this.f39276c == f16 && gDTVideoView.c())) {
                    if (g.this.f39278e != null && g.this.f39278e.get() != null) {
                        ((f) g.this.f39278e.get()).a();
                    }
                    if (!g.this.f39280g) {
                        g.this.f39282i.incrementAndGet();
                    }
                    g.this.f39280g = true;
                    g.this.f39281h.addAndGet(1000);
                } else {
                    if (g.this.f39278e != null && g.this.f39278e.get() != null) {
                        ((f) g.this.f39278e.get()).b();
                    }
                    g.this.f39280g = false;
                    g.this.f39283j.addAndGet(1000);
                }
                g.this.f39276c = f16;
                if ((gDTVideoView.e() != 0 && gDTVideoView.e() - gDTVideoView.f() < 10) || g.this.f39279f) {
                    g.this.c();
                    aa.b(g.this.f39274a);
                } else {
                    aa.a(g.this.f39274a, r0.f39277d);
                }
            }
        }
    };

    public g(GDTVideoView gDTVideoView, WeakReference<f> weakReference) {
        this.f39275b = new WeakReference<>(gDTVideoView);
        this.f39278e = weakReference;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("stuckDuration", Integer.valueOf(this.f39281h.get()));
        cVar.a("stuckTimes", Integer.valueOf(this.f39282i.get()));
        cVar.a("playingDuration", Integer.valueOf(this.f39283j.get()));
        cVar.a("code", Integer.valueOf(this.f39284k));
        StatTracer.trackEvent(1600053, new JSONObject(), cVar.a());
    }

    public void b() {
        this.f39279f = true;
        this.f39275b = null;
        this.f39278e = null;
        aa.b(this.f39274a);
    }

    public void a() {
        WeakReference<GDTVideoView> weakReference = this.f39275b;
        if (weakReference == null || weakReference.get() == null || !this.f39275b.get().o()) {
            return;
        }
        GdtSDKThreadManager.getInstance().runOnThread(3, this.f39274a);
    }

    public void a(int i3) {
        this.f39284k = i3;
    }
}
