package com.hihonor.push.sdk;

/* compiled from: P */
/* loaded from: classes2.dex */
public class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f36389a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f36390b;

    public h(l lVar, HonorPushCallback honorPushCallback) {
        this.f36390b = lVar;
        this.f36389a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.f36390b.f36406d;
        sVar.a(new o(sVar), this.f36389a);
    }
}
