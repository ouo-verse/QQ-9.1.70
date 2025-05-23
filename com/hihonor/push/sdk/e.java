package com.hihonor.push.sdk;

import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f36368a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f36369b;

    public e(l lVar, v vVar) {
        this.f36369b = lVar;
        this.f36368a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f36369b.f36404b) {
            this.f36369b.f36404b = true;
            this.f36369b.getClass();
            this.f36369b.f36403a = new WeakReference<>(this.f36368a.f36444a);
            this.f36369b.f36405c = this.f36368a.f36445b;
            this.f36369b.f36406d = new s(this.f36368a.f36444a);
            if (this.f36369b.f36405c) {
                l lVar = this.f36369b;
                lVar.a(new f(lVar, null, true), (HonorPushCallback<?>) null);
            }
        }
    }
}
