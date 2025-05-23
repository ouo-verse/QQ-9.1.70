package org.tencwebrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.support.annotation.Nullable;
import org.tencwebrtc.CameraSession;
import org.tencwebrtc.CameraVideoCapturer;

/* compiled from: P */
@TargetApi(21)
/* loaded from: classes29.dex */
public class Camera2Capturer extends CameraCapturer {

    @Nullable
    private final CameraManager cameraManager;
    private final Context context;

    public Camera2Capturer(Context context, String str, CameraVideoCapturer.CameraEventsHandler cameraEventsHandler) {
        super(str, cameraEventsHandler, new Camera2Enumerator(context));
        this.context = context;
        this.cameraManager = (CameraManager) context.getSystemService("camera");
    }

    @Override // org.tencwebrtc.CameraCapturer, org.tencwebrtc.VideoCapturer
    public /* bridge */ /* synthetic */ void changeCaptureFormat(int i3, int i16, int i17) {
        super.changeCaptureFormat(i3, i16, i17);
    }

    @Override // org.tencwebrtc.CameraCapturer
    protected void createCameraSession(CameraSession.CreateSessionCallback createSessionCallback, CameraSession.Events events, Context context, SurfaceTextureHelper surfaceTextureHelper, String str, int i3, int i16, int i17) {
        Camera2Session.create(createSessionCallback, events, context, this.cameraManager, surfaceTextureHelper, str, i3, i16, i17);
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
