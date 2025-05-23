package com.tencent.liteav.videoproducer2.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final NativeScreenCaptureListener f119739a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f119740b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f119741c;

    g(NativeScreenCaptureListener nativeScreenCaptureListener, boolean z16, boolean z17) {
        this.f119739a = nativeScreenCaptureListener;
        this.f119740b = z16;
        this.f119741c = z17;
    }

    public static Runnable a(NativeScreenCaptureListener nativeScreenCaptureListener, boolean z16, boolean z17) {
        return new g(nativeScreenCaptureListener, z16, z17);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f119739a.notifyStartFinish(this.f119740b, this.f119741c);
    }
}
