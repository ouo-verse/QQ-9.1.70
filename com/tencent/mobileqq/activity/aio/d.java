package com.tencent.mobileqq.activity.aio;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    private static d f178344c;

    /* renamed from: a, reason: collision with root package name */
    public int f178345a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f178346b = -1;

    d() {
    }

    public static synchronized d b() {
        d dVar;
        synchronized (d.class) {
            d dVar2 = f178344c;
            if (dVar2 == null) {
                f178344c = new d();
            } else {
                dVar2.f178345a = 1;
            }
            dVar = f178344c;
        }
        return dVar;
    }

    public int a() {
        if (-1 == this.f178346b) {
            if ((com.tencent.mobileqq.utils.m.c() >>> 20) > 1390 && com.tencent.mobileqq.utils.ah.n() > 3 && com.tencent.mobileqq.utils.ah.l() > 1433) {
                this.f178346b = 1;
            } else if ((com.tencent.mobileqq.utils.m.c() >>> 20) > 926 && com.tencent.mobileqq.utils.ah.n() > 1 && com.tencent.mobileqq.utils.ah.l() > 961) {
                this.f178346b = 2;
            } else {
                this.f178346b = 3;
            }
        }
        return this.f178346b;
    }
}
