package com.tencent.liteav.videoproducer2.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final NativeScreenCaptureListener f119742a;

    h(NativeScreenCaptureListener nativeScreenCaptureListener) {
        this.f119742a = nativeScreenCaptureListener;
    }

    public static Runnable a(NativeScreenCaptureListener nativeScreenCaptureListener) {
        return new h(nativeScreenCaptureListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f119742a.notifyCaptureError();
    }
}
