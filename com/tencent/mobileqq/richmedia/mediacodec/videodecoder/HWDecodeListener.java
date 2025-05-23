package com.tencent.mobileqq.richmedia.mediacodec.videodecoder;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface HWDecodeListener {
    public static final int DECODE_CONFIG_ERROR = 1;
    public static final int DECODE_FRAME_ERROR = 3;
    public static final int DECODE_START_ERROR = 2;

    void onDecodeCancel();

    void onDecodeError(int i3, Throwable th5);

    void onDecodeFinish();

    void onDecodeFrame(long j3, long j16) throws InterruptedException;

    void onDecodeRepeat();

    void onDecodeSeekTo(long j3);

    void onDecodeStart();
}
