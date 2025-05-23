package org.tencwebrtc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public interface CameraSession {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface CreateSessionCallback {
        void onDone(CameraSession cameraSession);

        void onFailure(FailureType failureType, String str);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface Events {
        void onCameraClosed(CameraSession cameraSession);

        void onCameraDisconnected(CameraSession cameraSession);

        void onCameraError(CameraSession cameraSession, String str);

        void onCameraOpening();

        void onFrameCaptured(CameraSession cameraSession, VideoFrame videoFrame);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum FailureType {
        ERROR,
        DISCONNECTED
    }

    void stop();
}
