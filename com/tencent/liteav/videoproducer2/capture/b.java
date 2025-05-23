package com.tencent.liteav.videoproducer2.capture;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final NativeCameraCaptureListener f119729a;

    /* renamed from: b, reason: collision with root package name */
    private final int f119730b;

    b(NativeCameraCaptureListener nativeCameraCaptureListener, int i3) {
        this.f119729a = nativeCameraCaptureListener;
        this.f119730b = i3;
    }

    public static Runnable a(NativeCameraCaptureListener nativeCameraCaptureListener, int i3) {
        return new b(nativeCameraCaptureListener, i3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0.runInNative(e.a(this.f119729a, this.f119730b));
    }
}
