package org.tencwebrtc;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface VideoCapturer {
    void changeCaptureFormat(int i3, int i16, int i17);

    void dispose();

    void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver);

    boolean isScreencast();

    void startCapture(int i3, int i16, int i17);

    void stopCapture() throws InterruptedException;
}
