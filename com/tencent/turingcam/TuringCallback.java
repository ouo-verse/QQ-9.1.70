package com.tencent.turingcam;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface TuringCallback {
    void onException(Throwable th5);

    void onFinish(long j3, byte[] bArr);

    void onFinishFrameCheck(long j3, byte[] bArr);

    void onPreviewAvailable();

    void onPreviewDestroyed();
}
