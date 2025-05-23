package com.tencent.liteav.videoconsumer.renderer;

import android.view.SurfaceView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final e f119535a;

    /* renamed from: b, reason: collision with root package name */
    private final SurfaceView f119536b;

    f(e eVar, SurfaceView surfaceView) {
        this.f119535a = eVar;
        this.f119536b = surfaceView;
    }

    public static Runnable a(e eVar, SurfaceView surfaceView) {
        return new f(eVar, surfaceView);
    }

    @Override // java.lang.Runnable
    public final void run() {
        e.a(this.f119535a, this.f119536b);
    }
}
