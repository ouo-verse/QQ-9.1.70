package com.tencent.liteav.videoproducer2.capture;

import android.graphics.SurfaceTexture;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final NativeCameraCaptureListener f119733a;

    /* renamed from: b, reason: collision with root package name */
    private final SurfaceTexture f119734b;

    d(NativeCameraCaptureListener nativeCameraCaptureListener, SurfaceTexture surfaceTexture) {
        this.f119733a = nativeCameraCaptureListener;
        this.f119734b = surfaceTexture;
    }

    public static Runnable a(NativeCameraCaptureListener nativeCameraCaptureListener, SurfaceTexture surfaceTexture) {
        return new d(nativeCameraCaptureListener, surfaceTexture);
    }

    @Override // java.lang.Runnable
    public final void run() {
        NativeCameraCaptureListener.nativeOnFrameAvailable(this.f119733a.mNativeHandle, this.f119734b);
    }
}
