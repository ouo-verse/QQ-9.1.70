package com.qq.e.comm.plugin.base.ad.clickcomponent;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.plugin.k.ac;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d implements com.qq.e.comm.plugin.base.ad.clickcomponent.b.a {

    /* renamed from: a, reason: collision with root package name */
    private final b f38563a;

    /* renamed from: b, reason: collision with root package name */
    private final ClickInfo f38564b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f38565c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private com.qq.e.comm.plugin.base.ad.clickcomponent.b.b f38567b;

        a(com.qq.e.comm.plugin.base.ad.clickcomponent.b.b bVar) {
            this.f38567b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String n3;
            long currentTimeMillis = System.currentTimeMillis();
            if (!com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.a() && !com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.b(d.this.f38564b)) {
                com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(sdk_event_log.SdkEventDimension.EVENT_CLICK, d.this.f38564b, -1, -1);
            }
            if (d.this.f38564b != null) {
                d.this.f38564b.a(currentTimeMillis);
            }
            ClickResult b16 = d.this.b();
            if (this.f38567b != null) {
                if (b16 != null && b16.a() != 2) {
                    this.f38567b.a(d.this, b16);
                } else {
                    this.f38567b.a(d.this, new IllegalStateException("Canceled"));
                }
            }
            com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(133004, d.this.f38564b, System.currentTimeMillis() - currentTimeMillis);
            if (d.this.f38564b != null && d.this.f38564b.b() != null) {
                d.this.f38564b.b().c();
            }
            if (d.this.f38564b == null) {
                n3 = null;
            } else {
                n3 = d.this.f38564b.n();
            }
            StatTracer.instantReport(n3);
        }
    }

    d(b bVar, ClickInfo clickInfo) {
        this.f38563a = bVar;
        this.f38564b = clickInfo;
    }

    private void c() {
        ClickInfo clickInfo = this.f38564b;
        if (clickInfo != null && clickInfo.b() != null && this.f38564b.b().b() != null) {
            if (GDTADManager.getInstance().getDeviceStatus().getNetworkType().getPermValue() > 0 && ac.a(this.f38564b.b().b())) {
                com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(133015, this.f38564b);
                return;
            } else {
                com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(133014, this.f38564b);
                return;
            }
        }
        com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(this.f38564b, -5, "unknown", -5001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ClickResult b() {
        ArrayList arrayList = new ArrayList();
        c();
        if (this.f38563a.b() != null && this.f38563a.b().size() > 0) {
            com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(133002, this.f38564b);
            arrayList.addAll(this.f38563a.b());
        } else {
            com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(133003, this.f38564b);
            arrayList.addAll(com.qq.e.comm.plugin.base.ad.clickcomponent.a.a(this.f38564b));
        }
        return new com.qq.e.comm.plugin.base.ad.clickcomponent.chain.a(arrayList, 0, this.f38564b, 0).a(this.f38564b);
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.b.a
    public void a(com.qq.e.comm.plugin.base.ad.clickcomponent.b.b bVar) {
        synchronized (this) {
            if (!this.f38565c) {
                this.f38565c = true;
            } else {
                throw new IllegalStateException("Current click case already executed");
            }
        }
        GdtSDKThreadManager.getInstance().runOnThread(3, new a(bVar));
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.b.a
    public void a() {
        a((com.qq.e.comm.plugin.base.ad.clickcomponent.b.b) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a(b bVar, ClickInfo clickInfo) {
        return new d(bVar, clickInfo);
    }
}
