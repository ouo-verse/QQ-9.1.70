package com.hihonor.push.sdk;

/* compiled from: P */
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f36398a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f36399b;

    public j(l lVar, HonorPushCallback honorPushCallback) {
        this.f36399b = lVar;
        this.f36398a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.f36399b.f36406d;
        sVar.a(new q(sVar), this.f36398a);
    }
}
