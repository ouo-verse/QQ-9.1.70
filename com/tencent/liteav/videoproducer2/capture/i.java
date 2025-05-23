package com.tencent.liteav.videoproducer2.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final NativeScreenCaptureListener f119743a;

    i(NativeScreenCaptureListener nativeScreenCaptureListener) {
        this.f119743a = nativeScreenCaptureListener;
    }

    public static Runnable a(NativeScreenCaptureListener nativeScreenCaptureListener) {
        return new i(nativeScreenCaptureListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f119743a.notifyClassNotFound();
    }
}
