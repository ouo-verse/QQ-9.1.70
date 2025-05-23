package com.hihonor.push.sdk;

/* compiled from: P */
/* loaded from: classes2.dex */
public class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f36400a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f36401b;

    public k(l lVar, HonorPushCallback honorPushCallback) {
        this.f36401b = lVar;
        this.f36400a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.f36401b.f36406d;
        HonorPushCallback honorPushCallback = this.f36400a;
        sVar.getClass();
        if (honorPushCallback != null) {
            a1 a16 = b.a(new p0(sVar.f36427a));
            C11727r c11727r = new C11727r(sVar, honorPushCallback);
            a16.getClass();
            a16.a(new t0(o0.f36415c.f36416a, c11727r));
        }
    }
}
