package com.hihonor.push.sdk;

/* compiled from: P */
/* loaded from: classes2.dex */
public class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f36439a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f36440b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f36441c;

    public u(s sVar, HonorPushCallback honorPushCallback, int i3, String str) {
        this.f36439a = honorPushCallback;
        this.f36440b = i3;
        this.f36441c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        HonorPushCallback honorPushCallback = this.f36439a;
        if (honorPushCallback != null) {
            honorPushCallback.onFailure(this.f36440b, this.f36441c);
        }
    }
}
