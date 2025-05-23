package com.tencent.mobileqq.tritonaudio.inneraudio;

/* compiled from: P */
/* loaded from: classes19.dex */
public interface IAudioStateChangeListener {
    void onCanPlay();

    void onEnded();

    void onError(int i3);

    void onPause();

    void onPlay();

    void onSeeked();

    void onSeeking();

    void onStop();

    void onTimeUpdate();

    void onWaiting();
}
