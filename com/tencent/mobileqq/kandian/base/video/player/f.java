package com.tencent.mobileqq.kandian.base.video.player;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface f {
    void beforeVideoStart();

    void onBufferEnd();

    void onBufferStart();

    void onCompletion();

    void onFirstFrameRendered();

    void onProgressChanged(long j3);

    void onVideoEnd(int i3);

    void onVideoError(int i3, int i16, String str);

    void onVideoOpen();

    void onVideoPause();

    void onVideoPrepared();

    void onVideoRestart();

    void onVideoStart();

    void onVideoStop();
}
