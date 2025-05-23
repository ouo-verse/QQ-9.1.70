package com.tencent.liteav.videoproducer2.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final NativeCameraCaptureListener f119735a;

    /* renamed from: b, reason: collision with root package name */
    private final int f119736b;

    e(NativeCameraCaptureListener nativeCameraCaptureListener, int i3) {
        this.f119735a = nativeCameraCaptureListener;
        this.f119736b = i3;
    }

    public static Runnable a(NativeCameraCaptureListener nativeCameraCaptureListener, int i3) {
        return new e(nativeCameraCaptureListener, i3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        NativeCameraCaptureListener.nativeOnCameraError(this.f119735a.mNativeHandle, this.f119736b);
    }
}
