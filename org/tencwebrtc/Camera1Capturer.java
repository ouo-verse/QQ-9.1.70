package org.tencwebrtc;

import android.content.Context;
import android.support.annotation.Nullable;
import org.tencwebrtc.CameraSession;
import org.tencwebrtc.CameraVideoCapturer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Camera1Capturer extends CameraCapturer {
    private final boolean captureToTexture;

    public Camera1Capturer(String str, CameraVideoCapturer.CameraEventsHandler cameraEventsHandler, boolean z16) {
        super(str, cameraEventsHandler, new Camera1Enumerator(z16));
        this.captureToTexture = z16;
    }

    @Override // org.tencwebrtc.CameraCapturer, org.tencwebrtc.VideoCapturer
    public /* bridge */ /* synthetic */ void changeCaptureFormat(int i3, int i16, int i17) {
        super.changeCaptureFormat(i3, i16, i17);
    }

    @Override // org.tencwebrtc.CameraCapturer
    protected void createCameraSession(CameraSession.CreateSessionCallback createSessionCallback, CameraSession.Events events, Context context, SurfaceTextureHelper surfaceTextureHelper, String str, int i3, int i16, int i17) {
        Camera1Session.create(createSessionCallback, events, this.captureToTexture, context, surfaceTextureHelper, Camera1Enumerator.getCameraIndex(str), i3, i16, i17);
    }

    @Override // org.tencwebrtc.CameraCapturer, org.tencwebrtc.VideoCapturer
    public /* bridge */ /* synthetic */ void dispose() {
        super.dispose();
    }

    @Override // org.tencwebrtc.CameraCapturer, org.tencwebrtc.VideoCapturer
    public /* bridge */ /* synthetic */ void initialize(@Nullable SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        super.initialize(surfaceTextureHelper, context, capturerObserver);
    }

    @Override // org.tencwebrtc.CameraCapturer, org.tencwebrtc.VideoCapturer
    public /* bridge */ /* synthetic */ boolean isScreencast() {
        return super.isScreencast();
    }

    @Override // org.tencwebrtc.CameraCapturer
    public /* bridge */ /* synthetic */ void printStackTrace() {
        super.printStackTrace();
    }

    @Override // org.tencwebrtc.CameraCapturer, org.tencwebrtc.VideoCapturer
    public /* bridge */ /* synthetic */ void startCapture(int i3, int i16, int i17) {
        super.startCapture(i3, i16, i17);
    }

    @Override // org.tencwebrtc.CameraCapturer, org.tencwebrtc.VideoCapturer
    public /* bridge */ /* synthetic */ void stopCapture() {
        super.stopCapture();
    }

    @Override // org.tencwebrtc.CameraCapturer, org.tencwebrtc.CameraVideoCapturer
    public /* bridge */ /* synthetic */ void switchCamera(CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler) {
        super.switchCamera(cameraSwitchHandler);
    }
}
