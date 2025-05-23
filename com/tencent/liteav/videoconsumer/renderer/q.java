package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.videoconsumer.renderer.j;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final j.AnonymousClass1 f119566a;

    q(j.AnonymousClass1 anonymousClass1) {
        this.f119566a = anonymousClass1;
    }

    public static Runnable a(j.AnonymousClass1 anonymousClass1) {
        return new q(anonymousClass1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j.n(j.this);
    }
}
