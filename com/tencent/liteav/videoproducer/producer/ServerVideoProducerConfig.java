package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;

@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class ServerVideoProducerConfig {
    private k gsensorRotationCorrection;
    private Boolean hardwareEncoderBitrateModeCBRSupported;
    private final String mTAG = "ServerVideoProducerConfig_" + hashCode();
    private int hardwareEncodeType = 2;
    private boolean hardwareEncoderHighProfileEnable = true;
    private boolean hardwareEncoderHighProfileSupport = true;
    private int camera2SupportMinApiLevel = Integer.MAX_VALUE;
    private int cameraRotationCorrection = 0;
    private boolean mEnableCameraFpsCorrectionLogic = true;

    private k cameraCloudConfigEnumToRotation(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return null;
                    }
                    return k.ROTATION_270;
                }
                return k.ROTATION_180;
            }
            return k.ROTATION_90;
        }
        return k.NORMAL;
    }

    public static boolean isHWHevcEncodeAllowed() {
        return nativeIsHardwareHevcEncodeAllowed();
    }

    private static native boolean nativeIsHardwareHevcEncodeAllowed();

    public int getCamera2SupportMinApiLevel() {
        return this.camera2SupportMinApiLevel;
    }

    public String getCameraRotationCorrectionInfo() {
        return "[CameraV1Front:" + getCameraV1FrontRotationCorrection() + ", CameraV1Back:" + getCameraV1BackRotationCorrection() + ", CameraV2Front:" + getCameraV2FrontRotationCorrection() + ", CameraV2Back:" + getCameraV2BackRotationCorrection() + "]";
    }

    public k getCameraV1BackRotationCorrection() {
        return cameraCloudConfigEnumToRotation((this.cameraRotationCorrection >> 8) & 255);
    }

    public k getCameraV1FrontRotationCorrection() {
        return cameraCloudConfigEnumToRotation(this.cameraRotationCorrection & 255);
    }

    public k getCameraV2BackRotationCorrection() {
        return cameraCloudConfigEnumToRotation((this.cameraRotationCorrection >> 24) & 255);
    }

    public k getCameraV2FrontRotationCorrection() {
        return cameraCloudConfigEnumToRotation((this.cameraRotationCorrection >> 16) & 255);
    }

    public k getGsensorRotationCorrection() {
        return this.gsensorRotationCorrection;
    }

    public boolean isCameraFpsCorrectionLogicEnabled() {
        return this.mEnableCameraFpsCorrectionLogic;
    }

    public boolean isHardwareEncoderAllowed() {
        if (this.hardwareEncodeType != 0) {
            return true;
        }
        return false;
    }

    public Boolean isHardwareEncoderBitrateModeCBRSupported() {
        return this.hardwareEncoderBitrateModeCBRSupported;
    }

    public boolean isHardwareEncoderHighProfileAllowed() {
        if (this.hardwareEncodeType == 2 && this.hardwareEncoderHighProfileEnable && this.hardwareEncoderHighProfileSupport) {
            return true;
        }
        return false;
    }

    public void setCamera2SupportMinApiLevel(int i3) {
        this.camera2SupportMinApiLevel = i3;
    }

    public void setCameraFpsCorrectionLogicEnabled(boolean z16) {
        this.mEnableCameraFpsCorrectionLogic = z16;
        LiteavLog.i(this.mTAG, "set camera fps correction logic enabled value is ".concat(String.valueOf(z16)));
    }

    public void setCameraRotationCorrection(int i3) {
        this.cameraRotationCorrection = i3;
        LiteavLog.i(this.mTAG, "set camera rotation correction raw value is %#x.", Integer.valueOf(i3));
    }

    public void setGSensorRotationCorrection(int i3) {
        if (i3 >= 0 && i3 <= 3) {
            this.gsensorRotationCorrection = k.a(i3 * 90);
        }
    }

    public void setHardwareEncodeType(int i3) {
        this.hardwareEncodeType = i3;
    }

    public void setHardwareEncoderBitrateModeCBRSupported(boolean z16) {
        this.hardwareEncoderBitrateModeCBRSupported = Boolean.valueOf(z16);
    }

    public void setHardwareEncoderHighProfileEnable(boolean z16) {
        this.hardwareEncoderHighProfileEnable = z16;
    }

    public void setHardwareEncoderHighProfileSupport(boolean z16) {
        this.hardwareEncoderHighProfileSupport = z16;
    }

    public String toString() {
        return "hardwareEncodeType: " + this.hardwareEncodeType + ", hardwareEncoderHighProfileEnable: " + this.hardwareEncoderHighProfileEnable + ", hardwareEncoderHighProfileSupport: " + this.hardwareEncoderHighProfileSupport + ", camera2SupportMinApiLevel: " + this.camera2SupportMinApiLevel + ", hardwareEncoderBitrateModeCBRSupported: " + this.hardwareEncoderBitrateModeCBRSupported + ", gsensorRotationCorrection: " + this.gsensorRotationCorrection + ", cameraRotationCorrection: " + getCameraRotationCorrectionInfo();
    }
}
