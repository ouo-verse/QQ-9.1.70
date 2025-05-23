package com.tencent.liteav.device;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface TXDeviceManager {

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum TXAudioRoute {
        TXAudioRouteSpeakerphone,
        TXAudioRouteEarpiece
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum TXCameraCaptureMode {
        TXCameraResolutionStrategyAuto,
        TXCameraResolutionStrategyPerformance,
        TXCameraResolutionStrategyHighQuality,
        TXCameraCaptureManual
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class TXCameraCaptureParam {
        public int height;
        public TXCameraCaptureMode mode;
        public int width;
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum TXSystemVolumeType {
        TXSystemVolumeTypeAuto,
        TXSystemVolumeTypeMedia,
        TXSystemVolumeTypeVOIP
    }

    int enableCameraAutoFocus(boolean z16);

    boolean enableCameraTorch(boolean z16);

    float getCameraZoomMaxRatio();

    boolean isAutoFocusEnabled();

    boolean isFrontCamera();

    int setAudioRoute(TXAudioRoute tXAudioRoute);

    void setCameraCapturerParam(TXCameraCaptureParam tXCameraCaptureParam);

    int setCameraFocusPosition(int i3, int i16);

    int setCameraZoomRatio(float f16);

    int setExposureCompensation(float f16);

    int setSystemVolumeType(TXSystemVolumeType tXSystemVolumeType);

    int switchCamera(boolean z16);
}
