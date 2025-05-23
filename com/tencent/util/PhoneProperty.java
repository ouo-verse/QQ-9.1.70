package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.ttpic.baseutils.device.DeviceInstance;

/* loaded from: classes27.dex */
public class PhoneProperty {
    static IPatchRedirector $redirector_ = null;
    public static final String DEVICE;
    public static final String MANUFACTURER;
    public static final String MODEL;
    private static final String TAG = "PhoneProperty";
    private static PhoneProperty phoneProperty;
    private boolean cannotReuseFrameBuffer;
    private boolean delayDisplayGSLView;
    private int delayFrameCount;
    private String deviceType;
    private int faceBeautyType;
    private boolean gpuProcessNeedBackTexture;
    private boolean gpuWorkaroundFor544MP;
    private boolean gpuWorkaroundForTU880;
    private boolean hdrFilterProcessLargePic;
    private boolean isAdaptive;
    private boolean nightModuleUseNightFilter;
    private boolean notUseSurfaceTexture;
    private boolean partMatch;
    private boolean restrictPreviewData;
    private boolean showLog;
    private boolean smallPicture;
    private boolean useCPUDecodeYUV;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30269);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
            return;
        }
        phoneProperty = null;
        MODEL = DeviceInstance.PHONE_MODEL.toLowerCase();
        DEVICE = DeviceInstance.getPhoneDevice().toLowerCase();
        MANUFACTURER = DeviceInstance.getPhoneManufacturer().toLowerCase();
    }

    @Deprecated
    PhoneProperty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.showLog = false;
        this.deviceType = null;
        this.isAdaptive = false;
        this.partMatch = false;
        this.restrictPreviewData = false;
        this.delayFrameCount = 0;
        this.useCPUDecodeYUV = false;
        this.delayDisplayGSLView = false;
        this.cannotReuseFrameBuffer = false;
        this.smallPicture = false;
        this.gpuWorkaroundForTU880 = false;
        this.gpuWorkaroundFor544MP = false;
        this.gpuProcessNeedBackTexture = false;
        this.faceBeautyType = 0;
        this.hdrFilterProcessLargePic = false;
        this.nightModuleUseNightFilter = true;
        this.notUseSurfaceTexture = false;
    }

    public static PhoneProperty instance() {
        if (phoneProperty == null) {
            phoneProperty = new PhoneProperty();
        }
        return phoneProperty;
    }

    public int getDelayFrameCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.delayFrameCount;
    }

    public int getFaceBeautyType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.faceBeautyType;
    }

    public String getPhonePropertyMethod(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return "set" + str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public boolean hasFaceDetection() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return false;
    }

    public boolean isAdaptive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!this.isAdaptive && !this.partMatch) {
            return false;
        }
        return true;
    }

    public boolean isCannotReuseFrameBuffer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.cannotReuseFrameBuffer;
    }

    public boolean isDelayDisplayGSLView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.delayDisplayGSLView;
    }

    public boolean isGpuProcessNeedBackTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.gpuProcessNeedBackTexture;
    }

    public boolean isGpuWorkaroundForTU880() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.gpuWorkaroundForTU880;
    }

    public boolean isHdrFilterProcessLargePic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.hdrFilterProcessLargePic;
    }

    public boolean isNightModuleUseNightFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.nightModuleUseNightFilter;
    }

    public boolean isNotUseSurfaceTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.notUseSurfaceTexture;
    }

    public boolean isRestrictPreviewData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.restrictPreviewData;
    }

    public boolean isUseCPUDecodeYUV() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.useCPUDecodeYUV;
    }

    public boolean isUseSmallPicture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.smallPicture;
    }

    public void setCannotReuseFrameBuffer(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.cannotReuseFrameBuffer = z16;
        }
    }

    public void setDelayDisplayGSLView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.delayDisplayGSLView = z16;
        }
    }

    public void setDelayFrameCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.delayFrameCount = i3;
        }
    }

    public void setFaceBeautyType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.faceBeautyType = i3;
        }
    }

    public void setGpuProcessNeedBackTexture(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        } else {
            this.gpuProcessNeedBackTexture = z16;
        }
    }

    public void setGpuWorkaroundForTU880(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.gpuWorkaroundForTU880 = z16;
        }
    }

    public void setHasFaceDetection(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
        }
    }

    public void setHdrFilterProcessLargePic(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        } else {
            this.hdrFilterProcessLargePic = z16;
        }
    }

    public void setNightModuleUseNightFilter(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
        } else {
            this.nightModuleUseNightFilter = z16;
        }
    }

    public void setNotUseSurfaceTexture(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.notUseSurfaceTexture = z16;
        }
    }

    public void setRestrictPreviewData(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.restrictPreviewData = z16;
        }
    }

    public void setSmallPicture(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.smallPicture = z16;
        }
    }

    public void setUseCPUDecodeYUV(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.useCPUDecodeYUV = z16;
        }
    }
}
