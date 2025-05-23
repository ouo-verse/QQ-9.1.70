package com.tencent.jalpha.videoplayer.interfaces;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IVideoFileDecoder {
    int createDecoder(String str, Object obj);

    void decode();

    long getCurPresentationTimeUs();

    IVideoFileDecodeListener getDecodeListener();

    void release();

    void setDecodeListener(IVideoFileDecodeListener iVideoFileDecodeListener);

    void setLoopState(boolean z16);

    void stop();
}
