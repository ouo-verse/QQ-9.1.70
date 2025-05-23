package com.tencent.liteav.videoproducer2.capture;

import android.graphics.SurfaceTexture;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final NativeCameraCaptureListener f119731a;

    /* renamed from: b, reason: collision with root package name */
    private final SurfaceTexture f119732b;

    c(NativeCameraCaptureListener nativeCameraCaptureListener, SurfaceTexture surfaceTexture) {
        this.f119731a = nativeCameraCaptureListener;
        this.f119732b = surfaceTexture;
    }

    public static Runnable a(NativeCameraCaptureListener nativeCameraCaptureListener, SurfaceTexture surfaceTexture) {
        return new c(nativeCameraCaptureListener, surfaceTexture);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0.runInNative(d.a(this.f119731a, this.f119732b));
    }
}
