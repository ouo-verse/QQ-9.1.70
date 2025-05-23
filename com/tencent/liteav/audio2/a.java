package com.tencent.liteav.audio2;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final AndroidInterruptedStateListener f118849a;

    a(AndroidInterruptedStateListener androidInterruptedStateListener) {
        this.f118849a = androidInterruptedStateListener;
    }

    public static Runnable a(AndroidInterruptedStateListener androidInterruptedStateListener) {
        return new a(androidInterruptedStateListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        AndroidInterruptedStateListener.lambda$registerAudioRecordingCallback$0(this.f118849a);
    }
}
