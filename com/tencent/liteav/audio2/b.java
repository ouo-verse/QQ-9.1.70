package com.tencent.liteav.audio2;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final AndroidInterruptedStateListener f118850a;

    b(AndroidInterruptedStateListener androidInterruptedStateListener) {
        this.f118850a = androidInterruptedStateListener;
    }

    public static Runnable a(AndroidInterruptedStateListener androidInterruptedStateListener) {
        return new b(androidInterruptedStateListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        AndroidInterruptedStateListener.lambda$unregisterAudioRecordingCallback$1(this.f118850a);
    }
}
