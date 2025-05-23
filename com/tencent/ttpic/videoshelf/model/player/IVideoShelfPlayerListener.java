package com.tencent.ttpic.videoshelf.model.player;

/* loaded from: classes27.dex */
public interface IVideoShelfPlayerListener {
    void onChangVideoSize(int i3, int i16);

    void onCompletion();

    boolean onError(int i3, String str, Object obj);

    void onPrepared(IVideoShelfPlayer iVideoShelfPlayer);

    void onUpdateRate(long j3);
}
