package com.tencent.mobileqq.qzoneplayer.video;

/* compiled from: P */
/* loaded from: classes35.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    public static d f279978c;

    /* renamed from: a, reason: collision with root package name */
    int f279979a = 0;

    /* renamed from: b, reason: collision with root package name */
    BaseVideo f279980b;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f279978c == null) {
                d dVar2 = new d();
                f279978c = dVar2;
                dVar2.f279979a = 1;
            }
            dVar = f279978c;
        }
        return dVar;
    }

    public static d b(BaseVideo baseVideo) {
        d dVar = new d();
        dVar.f279979a = 2;
        dVar.f279980b = baseVideo;
        return dVar;
    }

    public boolean c() {
        return this.f279979a == 1;
    }
}
