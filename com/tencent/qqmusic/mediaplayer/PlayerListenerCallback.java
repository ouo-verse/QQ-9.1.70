package com.tencent.qqmusic.mediaplayer;

/* loaded from: classes23.dex */
public interface PlayerListenerCallback {
    void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i3);

    void onCompletion(BaseMediaPlayer baseMediaPlayer);

    void onError(BaseMediaPlayer baseMediaPlayer, int i3, int i16, int i17);

    void onPrepared(BaseMediaPlayer baseMediaPlayer);

    void onSeekComplete(BaseMediaPlayer baseMediaPlayer, int i3);

    void onStarted(BaseMediaPlayer baseMediaPlayer);

    void onStateChanged(BaseMediaPlayer baseMediaPlayer, int i3);
}
