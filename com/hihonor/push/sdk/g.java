package com.hihonor.push.sdk;

/* compiled from: P */
/* loaded from: classes2.dex */
public class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f36384a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f36385b;

    public g(l lVar, HonorPushCallback honorPushCallback) {
        this.f36385b = lVar;
        this.f36384a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.f36385b.f36406d;
        sVar.a(new n(sVar), this.f36384a);
    }
}
