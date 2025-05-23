package com.tencent.rmonitor.sla;

import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.k;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private boolean f365873b = false;

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.rmonitor.sla.a f365872a = new com.tencent.rmonitor.sla.a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final e f365874a = new e();
    }

    protected e() {
    }

    public static e b() {
        return a.f365874a;
    }

    public void a() {
        if (com.tencent.rmonitor.common.util.g.a() && !this.f365873b) {
            k h16 = ConfigProxy.INSTANCE.getConfig().h(k.ATTA_CONFIG_KEY);
            if (h16 instanceof com.tencent.rmonitor.sla.a) {
                d((com.tencent.rmonitor.sla.a) h16);
            }
        }
    }

    public boolean c(String str) {
        a();
        if (Math.random() < this.f365872a.b(str)) {
            return true;
        }
        return false;
    }

    public void d(com.tencent.rmonitor.sla.a aVar) {
        this.f365872a.c(aVar);
        this.f365873b = true;
    }
}
