package com.tencent.qimei.ar;

import com.tencent.qimei.ai.i;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    public static final Map<String, c> f343096d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    public static final Object f343097e = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final String f343098a;

    /* renamed from: b, reason: collision with root package name */
    public e f343099b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f343100c = false;

    public c(String str) {
        this.f343098a = str;
        this.f343099b = new e(this, str);
    }

    public final synchronized void a() {
        if (!com.tencent.qimei.u.a.f()) {
            return;
        }
        if (!com.tencent.qimei.ab.d.a(com.tencent.qimei.aa.f.b(this.f343098a).c("s_s_t"), 24L)) {
            f fVar = this.f343099b.f343105d;
            if (fVar != null) {
                com.tencent.qimei.ai.e eVar = (com.tencent.qimei.ai.e) fVar;
                eVar.getQimei(new i(eVar));
            }
            return;
        }
        com.tencent.qimei.ad.c.b("SDK_INIT \uff5c STRATEGY", "more than 24 hours since the last Strategy request", new Object[0]);
        if (!this.f343099b.f343103b.get()) {
            com.tencent.qimei.t.a.a().a(this.f343099b);
        }
    }
}
