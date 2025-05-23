package com.tencent.xweb;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface VideoControl {
    boolean supportSetRequestedOrientationCallback();

    void videoChangeStatus();

    void videoExitFullscreen();

    void videoMute(boolean z16);

    void videoPause();

    void videoPlay();

    void videoPlaybackRate(double d16);

    void videoSeek(double d16);
}
