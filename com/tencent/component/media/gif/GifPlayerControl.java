package com.tencent.component.media.gif;

/* loaded from: classes5.dex */
public interface GifPlayerControl {
    boolean canPause();

    boolean canSeekBackward();

    boolean canSeekForward();

    int getBufferPercentage();

    int getCurrentPosition();

    int getDuration();

    boolean isPlaying();

    void pause();

    void seekTo(int i3);

    void start();
}
