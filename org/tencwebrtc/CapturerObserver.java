package org.tencwebrtc;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface CapturerObserver {
    void onCapturerStarted(boolean z16);

    void onCapturerStopped();

    void onFrameCaptured(VideoFrame videoFrame);
}
