package com.tencent.mobileqq.videocodec.mediacodec.decoder;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface d {
    void a(long j3) throws InterruptedException;

    void onDecodeCancel();

    void onDecodeError(int i3, Throwable th5);

    void onDecodeFinish();

    void onDecodeRepeat();

    void onDecodeSeekTo(long j3);

    void onDecodeStart();
}
