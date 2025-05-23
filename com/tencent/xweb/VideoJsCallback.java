package com.tencent.xweb;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface VideoJsCallback {
    boolean onSetRequestedOrientation(int i3);

    void onVideoEmptied();

    void onVideoEnded();

    void onVideoEnterFullscreen(boolean z16, long j3, double d16, double d17, boolean z17, boolean z18, double d18, double d19, double[] dArr);

    void onVideoError(int i3, String str);

    void onVideoExitFullscreen();

    void onVideoPause();

    void onVideoPlay();

    void onVideoPlaying();

    void onVideoRateChange(double d16);

    void onVideoSeeked();

    void onVideoSeeking();

    void onVideoSizeUpdate(double d16, double d17);

    void onVideoTimeUpdate(double d16, double d17, double[] dArr);

    void onVideoVolumeChange(boolean z16);

    void onVideoWaiting();
}
