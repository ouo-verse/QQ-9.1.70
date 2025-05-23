package com.tencent.qqmusic.mediaplayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes23.dex */
public interface PlayerCallback {
    void playThreadStart(CorePlayer corePlayer);

    void playerEnded(CorePlayer corePlayer);

    void playerException(CorePlayer corePlayer, int i3, int i16, int i17);

    void playerPaused(CorePlayer corePlayer);

    void playerPrepared(CorePlayer corePlayer);

    void playerSeekCompletion(CorePlayer corePlayer, int i3);

    void playerStarted(CorePlayer corePlayer);

    void playerStopped(CorePlayer corePlayer);
}
