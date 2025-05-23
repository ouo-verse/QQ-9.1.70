package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public class fy {

    /* renamed from: a, reason: collision with root package name */
    private final hn f388932a;

    /* renamed from: b, reason: collision with root package name */
    private final hx f388933b;

    public fy(ic icVar) {
        hx hxVar = new hx();
        this.f388933b = hxVar;
        this.f388932a = icVar.a(hxVar);
    }

    public void a(hq hqVar, byte[] bArr) {
        try {
            this.f388933b.h(bArr);
            hqVar.a(this.f388932a);
        } finally {
            this.f388932a.I();
        }
    }
}
