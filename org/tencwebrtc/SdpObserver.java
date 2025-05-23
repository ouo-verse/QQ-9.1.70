package org.tencwebrtc;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface SdpObserver {
    @CalledByNative
    void onCreateFailure(String str);

    @CalledByNative
    void onCreateSuccess(SessionDescription sessionDescription);

    @CalledByNative
    void onSetFailure(String str);

    @CalledByNative
    void onSetSuccess();
}
