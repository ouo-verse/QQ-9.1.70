package com.tencent.mobileqq.tritonaudio.inneraudio;

/* loaded from: classes19.dex */
public interface IAudioPlayer {
    int getAudioId();

    String getAudioPath();

    boolean getAutoPlay();

    double getBufferedTime();

    int getCurrentPosition();

    int getDuration();

    boolean getLoop();

    float getStartTime();

    IAudioStateChangeListener getStateChangeListener();

    float getVolume();

    boolean isNeedResume();

    boolean isPaused();

    boolean isPlaying();

    void onAudioTimeUpdateRegister();

    void pause();

    void play();

    void release();

    void resume();

    void seekTo(float f16);

    void setAudioId(int i3);

    void setAudioPath(String str);

    void setAutoPlay(boolean z16);

    void setLoop(boolean z16);

    void setNeedResume(boolean z16);

    void setStartTime(float f16);

    void setStateChangeListener(IAudioStateChangeListener iAudioStateChangeListener);

    void setVolume(float f16);

    void stop();
}
