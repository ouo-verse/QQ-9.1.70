package com.hihonor.push.sdk;

/* compiled from: P */
/* loaded from: classes2.dex */
public class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f36394a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f36395b;

    public i(l lVar, HonorPushCallback honorPushCallback) {
        this.f36395b = lVar;
        this.f36394a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.f36395b.f36406d;
        sVar.a(new p(sVar), this.f36394a);
    }
}
