package com.tencent.liteav.device;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.device.TXDeviceManager;

/* compiled from: P */
@JNINamespace("liteav::manager")
/* loaded from: classes7.dex */
public class TXDeviceManagerImpl implements TXDeviceManager {
    private long mNativeDeviceMgr;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class CameraCaptureParam {
        private TXDeviceManager.TXCameraCaptureParam mParams;

        public CameraCaptureParam(TXDeviceManager.TXCameraCaptureParam tXCameraCaptureParam) {
            this.mParams = tXCameraCaptureParam;
        }

        public int getHeight() {
            return this.mParams.height;
        }

        public int getMode() {
            return TXDeviceManagerImpl.cameraCaptureModeAsInt(this.mParams.mode);
        }

        public int getWidth() {
            return this.mParams.width;
        }
    }

    public TXDeviceManagerImpl(long j3) {
        this.mNativeDeviceMgr = j3;
    }

    public static int audioRouteAsInt(TXDeviceManager.TXAudioRoute tXAudioRoute) {
        if (tXAudioRoute == TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone || tXAudioRoute != TXDeviceManager.TXAudioRoute.TXAudioRouteEarpiece) {
            return 0;
        }
        return 1;
    }

    public static TXDeviceManager.TXAudioRoute audioRouteFromInt(int i3) {
        if (i3 == 0) {
            return TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone;
        }
        if (i3 == 1) {
            return TXDeviceManager.TXAudioRoute.TXAudioRouteEarpiece;
        }
        return TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone;
    }

    public static int cameraCaptureModeAsInt(TXDeviceManager.TXCameraCaptureMode tXCameraCaptureMode) {
        if (tXCameraCaptureMode == TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyAuto) {
            return 0;
        }
        if (tXCameraCaptureMode == TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyPerformance) {
            return 1;
        }
        if (tXCameraCaptureMode == TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyHighQuality) {
            return 2;
        }
        if (tXCameraCaptureMode != TXDeviceManager.TXCameraCaptureMode.TXCameraCaptureManual) {
            return 0;
        }
        return 3;
    }

    public static TXDeviceManager.TXCameraCaptureMode cameraCaptureModeFromInt(int i3) {
        if (i3 == 0) {
            return TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyAuto;
        }
        if (i3 == 1) {
            return TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyPerformance;
        }
        if (i3 == 2) {
            return TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyHighQuality;
        }
        if (i3 == 3) {
            return TXDeviceManager.TXCameraCaptureMode.TXCameraCaptureManual;
        }
        return TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyAuto;
    }

    private static native void nativeDestroy(long j3);

    private static native int nativeEnableCameraAutoFocus(long j3, boolean z16);

    private static native boolean nativeEnableCameraTorch(long j3, boolean z16);

    private static native float nativeGetCameraZoomMaxRatio(long j3);

    private static native boolean nativeIsAutoFocusEnabled(long j3);

    private static native boolean nativeIsCameraAutoFocusFaceModeSupported(long j3);

    private static native boolean nativeIsCameraFocusPositionInPreviewSupported(long j3);

    private static native boolean nativeIsCameraTorchSupported(long j3);

    private static native boolean nativeIsCameraZoomSupported(long j3);

    private static native boolean nativeIsFrontCamera(long j3);

    private static native boolean nativeIsLowLatencyEarMonitorSupported(long j3);

    private static native int nativeSetAudioRoute(long j3, int i3);

    private static native void nativeSetCameraCapturerParam(long j3, CameraCaptureParam cameraCaptureParam);

    private static native int nativeSetCameraFocusPosition(long j3, int i3, int i16);

    private static native int nativeSetCameraZoomRatio(long j3, float f16);

    private static native int nativeSetExposureCompensation(long j3, float f16);

    private static native int nativeSetSystemVolumeType(long j3, int i3);

    private static native int nativeSwitchCamera(long j3, boolean z16);

    public static int systemVolumeTypeAsInt(TXDeviceManager.TXSystemVolumeType tXSystemVolumeType) {
        if (tXSystemVolumeType == TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto) {
            return 0;
        }
        if (tXSystemVolumeType == TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeMedia) {
            return 1;
        }
        if (tXSystemVolumeType != TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeVOIP) {
            return 0;
        }
        return 2;
    }

    public static TXDeviceManager.TXSystemVolumeType systemVolumeTypefromInt(int i3) {
        if (i3 == 0) {
            return TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto;
        }
        if (i3 == 1) {
            return TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeMedia;
        }
        if (i3 == 2) {
            return TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeVOIP;
        }
        return TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int enableCameraAutoFocus(boolean z16) {
        long j3 = this.mNativeDeviceMgr;
        if (j3 != 0) {
            return nativeEnableCameraAutoFocus(j3, z16);
        }
        return 0;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public boolean enableCameraTorch(boolean z16) {
        long j3 = this.mNativeDeviceMgr;
        if (j3 != 0) {
            return nativeEnableCameraTorch(j3, z16);
        }
        return false;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        long j3 = this.mNativeDeviceMgr;
        if (j3 != 0) {
            nativeDestroy(j3);
            this.mNativeDeviceMgr = 0L;
        }
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public float getCameraZoomMaxRatio() {
        long j3 = this.mNativeDeviceMgr;
        if (j3 != 0) {
            return nativeGetCameraZoomMaxRatio(j3);
        }
        return 0.0f;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public boolean isAutoFocusEnabled() {
        long j3 = this.mNativeDeviceMgr;
        if (j3 != 0) {
            return nativeIsAutoFocusEnabled(j3);
        }
        return false;
    }

    public boolean isCameraAutoFocusFaceModeSupported() {
        long j3 = this.mNativeDeviceMgr;
        if (j3 == 0) {
            return false;
        }
        return nativeIsCameraAutoFocusFaceModeSupported(j3);
    }

    public boolean isCameraFocusPositionInPreviewSupported() {
        long j3 = this.mNativeDeviceMgr;
        if (j3 == 0) {
            return false;
        }
        return nativeIsCameraFocusPositionInPreviewSupported(j3);
    }

    public boolean isCameraTorchSupported() {
        long j3 = this.mNativeDeviceMgr;
        if (j3 == 0) {
            return false;
        }
        return nativeIsCameraTorchSupported(j3);
    }

    public boolean isCameraZoomSupported() {
        long j3 = this.mNativeDeviceMgr;
        if (j3 != 0) {
            return nativeIsCameraZoomSupported(j3);
        }
        return false;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public boolean isFrontCamera() {
        long j3 = this.mNativeDeviceMgr;
        if (j3 != 0) {
            return nativeIsFrontCamera(j3);
        }
        return false;
    }

    public boolean isLowLatencyEarMonitorSupported() {
        long j3 = this.mNativeDeviceMgr;
        if (j3 != 0) {
            return nativeIsLowLatencyEarMonitorSupported(j3);
        }
        return false;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int setAudioRoute(TXDeviceManager.TXAudioRoute tXAudioRoute) {
        long j3 = this.mNativeDeviceMgr;
        if (j3 != 0) {
            return nativeSetAudioRoute(j3, audioRouteAsInt(tXAudioRoute));
        }
        return 0;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public void setCameraCapturerParam(TXDeviceManager.TXCameraCaptureParam tXCameraCaptureParam) {
        long j3 = this.mNativeDeviceMgr;
        if (j3 != 0 && tXCameraCaptureParam != null) {
            nativeSetCameraCapturerParam(j3, new CameraCaptureParam(tXCameraCaptureParam));
        }
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int setCameraFocusPosition(int i3, int i16) {
        long j3 = this.mNativeDeviceMgr;
        if (j3 != 0) {
            return nativeSetCameraFocusPosition(j3, i3, i16);
        }
        return 0;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int setCameraZoomRatio(float f16) {
        long j3 = this.mNativeDeviceMgr;
        if (j3 != 0) {
            return nativeSetCameraZoomRatio(j3, f16);
        }
        return 0;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int setExposureCompensation(float f16) {
        long j3 = this.mNativeDeviceMgr;
        if (j3 != 0) {
            return nativeSetExposureCompensation(j3, f16);
        }
        return 0;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int setSystemVolumeType(TXDeviceManager.TXSystemVolumeType tXSystemVolumeType) {
        long j3 = this.mNativeDeviceMgr;
        if (j3 != 0) {
            return nativeSetSystemVolumeType(j3, systemVolumeTypeAsInt(tXSystemVolumeType));
        }
        return 0;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int switchCamera(boolean z16) {
        long j3 = this.mNativeDeviceMgr;
        if (j3 != 0) {
            return nativeSwitchCamera(j3, z16);
        }
        return 0;
    }
}
