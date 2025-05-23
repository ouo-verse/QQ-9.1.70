package com.tencent.liteav.videoproducer2.capture;

import android.graphics.SurfaceTexture;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final NativeScreenCaptureListener f119737a;

    /* renamed from: b, reason: collision with root package name */
    private final SurfaceTexture f119738b;

    f(NativeScreenCaptureListener nativeScreenCaptureListener, SurfaceTexture surfaceTexture) {
        this.f119737a = nativeScreenCaptureListener;
        this.f119738b = surfaceTexture;
    }

    public static Runnable a(NativeScreenCaptureListener nativeScreenCaptureListener, SurfaceTexture surfaceTexture) {
        return new f(nativeScreenCaptureListener, surfaceTexture);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f119737a.notifyFrameAvailable(this.f119738b);
    }
}
