package com.tencent.liteav.videoconsumer.renderer;

import android.view.Surface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final a f119519a;

    /* renamed from: b, reason: collision with root package name */
    private final Surface f119520b;

    b(a aVar, Surface surface) {
        this.f119519a = aVar;
        this.f119520b = surface;
    }

    public static Runnable a(a aVar, Surface surface) {
        return new b(aVar, surface);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f119519a, this.f119520b);
    }
}
