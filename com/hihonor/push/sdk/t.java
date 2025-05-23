package com.hihonor.push.sdk;

/* compiled from: P */
/* loaded from: classes2.dex */
public class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f36434a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f36435b;

    public t(s sVar, HonorPushCallback honorPushCallback, Object obj) {
        this.f36434a = honorPushCallback;
        this.f36435b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        HonorPushCallback honorPushCallback = this.f36434a;
        if (honorPushCallback != null) {
            honorPushCallback.onSuccess(this.f36435b);
        }
    }
}
