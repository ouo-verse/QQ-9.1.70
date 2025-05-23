package com.hihonor.push.sdk;

/* compiled from: P */
/* loaded from: classes2.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f36371a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f36372b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f36373c;

    public f(l lVar, HonorPushCallback honorPushCallback, boolean z16) {
        this.f36373c = lVar;
        this.f36371a = honorPushCallback;
        this.f36372b = z16;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.f36373c.f36406d;
        sVar.a(new m(sVar, this.f36372b), this.f36371a);
    }
}
