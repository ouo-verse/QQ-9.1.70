package com.tencent.liteav.videoproducer2;

import com.tencent.liteav.base.annotations.JNINamespace;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class HWEncoderServerConfig {
    private Boolean hardwareEncoderBitrateModeCBRSupported;
    private int mHardwareEncodeType = 2;
    private boolean mHardwareEncoderHighProfileEnable = true;
    private boolean mHardwareEncoderHighProfileSupport = true;

    public static boolean isHWHevcEncodeAllowed() {
        return nativeIsHardwareHevcEncodeAllowed();
    }

    private static native boolean nativeIsHardwareHevcEncodeAllowed();

    public int getHardwareEncodeType() {
        return this.mHardwareEncodeType;
    }

    public boolean getHardwareEncoderHighProfileEnable() {
        return this.mHardwareEncoderHighProfileEnable;
    }

    public boolean getHardwareEncoderHighProfileSupport() {
        return this.mHardwareEncoderHighProfileSupport;
    }

    public boolean isHardwareEncoderAllowed() {
        if (this.mHardwareEncodeType != 0) {
            return true;
        }
        return false;
    }

    public Boolean isHardwareEncoderBitrateModeCBRSupported() {
        return this.hardwareEncoderBitrateModeCBRSupported;
    }

    public boolean isHardwareEncoderHighProfileAllowed() {
        if (this.mHardwareEncodeType == 2 && this.mHardwareEncoderHighProfileEnable && this.mHardwareEncoderHighProfileSupport) {
            return true;
        }
        return false;
    }

    public void setHardwareEncodeType(int i3) {
        this.mHardwareEncodeType = i3;
    }

    public void setHardwareEncoderBitrateModeCBRSupported(boolean z16) {
        this.hardwareEncoderBitrateModeCBRSupported = Boolean.valueOf(z16);
    }

    public void setHardwareEncoderHighProfileEnable(boolean z16) {
        this.mHardwareEncoderHighProfileEnable = z16;
    }

    public void setHardwareEncoderHighProfileSupport(boolean z16) {
        this.mHardwareEncoderHighProfileSupport = z16;
    }
}
