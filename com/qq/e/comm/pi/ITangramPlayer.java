package com.qq.e.comm.pi;

import com.qq.e.tg.splash.ITangramPlayerListener;

/* loaded from: classes3.dex */
public interface ITangramPlayer {
    void free();

    int getCurrentPosition();

    int getDuration();

    boolean isPlaying();

    void pause();

    void play();

    void setDataSource(String str);

    void setVideoPlayerListener(ITangramPlayerListener iTangramPlayerListener);

    void setVolume(float f16);

    void setVolumeOff();

    void setVolumeOn();

    void stop();
}
