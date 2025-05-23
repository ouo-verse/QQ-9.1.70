package com.tencent.could.huiyansdk.entity;

import android.content.Context;
import com.tencent.could.aicamare.enums.CameraZoom;
import com.tencent.could.huiyansdk.enums.HuiYanAction;
import com.tencent.could.huiyansdk.enums.HuiYanEncryptMode;
import com.tencent.could.huiyansdk.enums.HuiYanLiveMode;
import com.tencent.could.huiyansdk.enums.PageColorStyle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HuiYanSdkConfig {
    static IPatchRedirector $redirector_;
    private HuiYanAction[] actions;
    private String authLicense;
    private long authTimeOutMs;
    private int bestImageContinuousFrameNum;
    private float bestImagePitch;
    private float bestImageRoll;
    private float bestImageYaw;
    private long checkEnvRiskTimeout;
    private WeakReference<Context> contextWeakReference;
    private long cutVideoDuration;
    private boolean disableSystemRecordScreen;
    private HuiYanEncryptMode encryptMode;
    private HuiYanLiveMode huiYanLiveMode;
    private boolean isAutoScreenBrightness;
    private boolean isBackgroundStopAuth;
    private boolean isCloseEncrypt;
    private boolean isCutRecordVideo;
    private boolean isDeleteVideoCache;
    private boolean isLandMode;
    private boolean isOpenAngleDetect;
    private boolean isOpenLightReflectAnim;
    private boolean isOpenLog;
    private boolean isRecordVideo;
    private boolean isShowActionTimeout;
    private boolean isShowPrepareTimeout;
    private boolean isUseBackCamera;
    private boolean isUseBestFaceImage;
    private boolean justCheckRawCamera;
    private float landCloseRatio;
    private String languageCode;
    private LanguageStyle languageStyle;
    private boolean mustDiffMinAndMaxFps;
    private boolean openFullLog;
    private PageColorStyle pageColorStyle;
    private float portraitCloseRatio;
    private long prepareFaceTimeOutMs;
    private boolean showDebugView;
    private String useCustomerModelPath;
    private boolean waitingUserCompare;
    private CameraZoom zoomLevel;

    public HuiYanSdkConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isDeleteVideoCache = true;
        this.authLicense = "";
        this.useCustomerModelPath = "";
        this.pageColorStyle = PageColorStyle.Light;
        this.prepareFaceTimeOutMs = 30000L;
        this.authTimeOutMs = 30000L;
        this.isCloseEncrypt = false;
        this.languageStyle = LanguageStyle.AUTO;
        this.languageCode = "";
        this.isRecordVideo = true;
        this.isCutRecordVideo = true;
        this.cutVideoDuration = 2000L;
        this.isBackgroundStopAuth = true;
        this.waitingUserCompare = false;
        this.disableSystemRecordScreen = false;
        this.isUseBackCamera = false;
        this.bestImageRoll = 30.0f;
        this.bestImageYaw = 30.0f;
        this.bestImagePitch = 40.0f;
        this.bestImageContinuousFrameNum = 1;
        this.huiYanLiveMode = HuiYanLiveMode.ACTION_REFLECT_MODE;
        this.encryptMode = HuiYanEncryptMode.AES;
        this.isOpenLog = true;
        this.zoomLevel = CameraZoom.ZOOM_1X;
        this.mustDiffMinAndMaxFps = false;
        this.isOpenAngleDetect = false;
        this.isAutoScreenBrightness = true;
        this.isUseBestFaceImage = false;
        this.isLandMode = false;
        this.landCloseRatio = 0.35f;
        this.portraitCloseRatio = 0.5f;
        this.isShowPrepareTimeout = true;
        this.isShowActionTimeout = true;
        this.openFullLog = false;
        this.isOpenLightReflectAnim = false;
        this.showDebugView = false;
        this.justCheckRawCamera = false;
        this.checkEnvRiskTimeout = 3000L;
    }

    public HuiYanAction[] getActions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (HuiYanAction[]) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.actions;
    }

    public String getAuthLicense() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.authLicense;
    }

    public long getAuthTimeOutMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.authTimeOutMs;
    }

    public int getBestImageContinuousFrameNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Integer) iPatchRedirector.redirect((short) 45, (Object) this)).intValue();
        }
        return this.bestImageContinuousFrameNum;
    }

    public float getBestImagePitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Float) iPatchRedirector.redirect((short) 43, (Object) this)).floatValue();
        }
        return this.bestImagePitch;
    }

    public float getBestImageRoll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Float) iPatchRedirector.redirect((short) 41, (Object) this)).floatValue();
        }
        return this.bestImageRoll;
    }

    public float getBestImageYaw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Float) iPatchRedirector.redirect((short) 39, (Object) this)).floatValue();
        }
        return this.bestImageYaw;
    }

    public long getCheckEnvRiskTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            return ((Long) iPatchRedirector.redirect((short) 76, (Object) this)).longValue();
        }
        return this.checkEnvRiskTimeout;
    }

    public long getCutVideoDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            return ((Long) iPatchRedirector.redirect((short) 75, (Object) this)).longValue();
        }
        return this.cutVideoDuration;
    }

    public HuiYanEncryptMode getEncryptMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (HuiYanEncryptMode) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this.encryptMode;
    }

    public HuiYanLiveMode getHuiYanLiveMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (HuiYanLiveMode) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.huiYanLiveMode;
    }

    public float getLandCloseRatio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Float) iPatchRedirector.redirect((short) 58, (Object) this)).floatValue();
        }
        return this.landCloseRatio;
    }

    public String getLanguageCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.languageCode;
    }

    public LanguageStyle getLanguageStyle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (LanguageStyle) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.languageStyle;
    }

    public PageColorStyle getPageColorStyle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (PageColorStyle) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.pageColorStyle;
    }

    public float getPortraitCloseRatio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return ((Float) iPatchRedirector.redirect((short) 60, (Object) this)).floatValue();
        }
        return this.portraitCloseRatio;
    }

    public long getPrepareFaceTimeOutMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return this.prepareFaceTimeOutMs;
    }

    public Context getStartActivityContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return (Context) iPatchRedirector.redirect((short) 79, (Object) this);
        }
        WeakReference<Context> weakReference = this.contextWeakReference;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getUseCustomerModelPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.useCustomerModelPath;
    }

    public CameraZoom getZoomLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (CameraZoom) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        return this.zoomLevel;
    }

    public boolean isAutoScreenBrightness() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this)).booleanValue();
        }
        return this.isAutoScreenBrightness;
    }

    public boolean isBackgroundStopAuth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.isBackgroundStopAuth;
    }

    public boolean isCloseEncrypt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.isCloseEncrypt;
    }

    public boolean isCutRecordVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        return this.isCutRecordVideo;
    }

    public boolean isDeleteVideoCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isDeleteVideoCache;
    }

    public boolean isDisableSystemRecordScreen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        return this.disableSystemRecordScreen;
    }

    public boolean isJustCheckRawCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return ((Boolean) iPatchRedirector.redirect((short) 72, (Object) this)).booleanValue();
        }
        return this.justCheckRawCamera;
    }

    public boolean isLandMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Boolean) iPatchRedirector.redirect((short) 56, (Object) this)).booleanValue();
        }
        return this.isLandMode;
    }

    public boolean isMustDiffMinAndMaxFps() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Boolean) iPatchRedirector.redirect((short) 66, (Object) this)).booleanValue();
        }
        return this.mustDiffMinAndMaxFps;
    }

    public boolean isOpenAngleDetect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this)).booleanValue();
        }
        return this.isOpenAngleDetect;
    }

    public boolean isOpenFullLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return ((Boolean) iPatchRedirector.redirect((short) 68, (Object) this)).booleanValue();
        }
        return this.openFullLog;
    }

    public boolean isOpenLightReflectAnim() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            return ((Boolean) iPatchRedirector.redirect((short) 80, (Object) this)).booleanValue();
        }
        return this.isOpenLightReflectAnim;
    }

    public boolean isOpenLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this)).booleanValue();
        }
        return this.isOpenLog;
    }

    public boolean isRecordVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.isRecordVideo;
    }

    public boolean isShowActionTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return ((Boolean) iPatchRedirector.redirect((short) 64, (Object) this)).booleanValue();
        }
        return this.isShowActionTimeout;
    }

    public boolean isShowDebugView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return ((Boolean) iPatchRedirector.redirect((short) 70, (Object) this)).booleanValue();
        }
        return this.showDebugView;
    }

    public boolean isShowPrepareTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return ((Boolean) iPatchRedirector.redirect((short) 62, (Object) this)).booleanValue();
        }
        return this.isShowPrepareTimeout;
    }

    public boolean isUseBackCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this)).booleanValue();
        }
        return this.isUseBackCamera;
    }

    public boolean isUseBestFaceImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Boolean) iPatchRedirector.redirect((short) 54, (Object) this)).booleanValue();
        }
        return this.isUseBestFaceImage;
    }

    public boolean isWaitingUserCompare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return this.waitingUserCompare;
    }

    public void setActions(HuiYanAction[] huiYanActionArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) huiYanActionArr);
        } else {
            this.actions = huiYanActionArr;
        }
    }

    public void setAuthLicense(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.authLicense = str;
        }
    }

    public void setAuthTimeOutMs(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, j3);
        } else {
            this.authTimeOutMs = j3;
        }
    }

    public void setAutoScreenBrightness(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, z16);
        } else {
            this.isAutoScreenBrightness = z16;
        }
    }

    public void setBackgroundStopAuth(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        } else {
            this.isBackgroundStopAuth = z16;
        }
    }

    public void setBestImageContinuousFrameNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, i3);
            return;
        }
        if (i3 < 1) {
            this.bestImageContinuousFrameNum = 1;
        } else if (i3 > 30) {
            this.bestImageContinuousFrameNum = 30;
        } else {
            this.bestImageContinuousFrameNum = i3;
        }
    }

    public void setBestImagePitch(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, Float.valueOf(f16));
            return;
        }
        if (f16 < 2.0f) {
            this.bestImagePitch = 2.0f;
        } else if (f16 > 40.0f) {
            this.bestImagePitch = 40.0f;
        } else {
            this.bestImagePitch = f16;
        }
    }

    public void setBestImageRoll(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, Float.valueOf(f16));
            return;
        }
        if (f16 < 2.0f) {
            this.bestImageRoll = 2.0f;
        } else if (f16 > 30.0f) {
            this.bestImageRoll = 30.0f;
        } else {
            this.bestImageRoll = f16;
        }
    }

    public void setBestImageYaw(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Float.valueOf(f16));
            return;
        }
        if (f16 < 2.0f) {
            this.bestImageYaw = 2.0f;
        } else if (f16 > 30.0f) {
            this.bestImageYaw = 30.0f;
        } else {
            this.bestImageYaw = f16;
        }
    }

    public void setCheckEnvRiskTimeout(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this, j3);
        } else {
            this.checkEnvRiskTimeout = j3;
        }
    }

    public void setCloseEncrypt(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.isCloseEncrypt = z16;
        }
    }

    public void setCutRecordVideo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, z16);
        } else {
            this.isCutRecordVideo = z16;
        }
    }

    public void setCutVideoDuration(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this, j3);
            return;
        }
        if (j3 < 2000) {
            this.cutVideoDuration = 2000L;
        } else if (j3 > 6000) {
            this.cutVideoDuration = 6000L;
        } else {
            this.cutVideoDuration = j3;
        }
    }

    public void setDeleteVideoCache(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.isDeleteVideoCache = z16;
        }
    }

    public void setDisableSystemRecordScreen(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, z16);
        } else {
            this.disableSystemRecordScreen = z16;
        }
    }

    public void setEncryptMode(HuiYanEncryptMode huiYanEncryptMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) huiYanEncryptMode);
        } else {
            this.encryptMode = huiYanEncryptMode;
        }
    }

    public void setHuiYanLiveMode(HuiYanLiveMode huiYanLiveMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) huiYanLiveMode);
        } else {
            this.huiYanLiveMode = huiYanLiveMode;
        }
    }

    public void setJustCheckRawCamera(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this, z16);
        } else {
            this.justCheckRawCamera = z16;
        }
    }

    public void setLandCloseRatio(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, this, Float.valueOf(f16));
        } else {
            this.landCloseRatio = f16;
        }
    }

    public void setLandMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, z16);
        } else {
            this.isLandMode = z16;
        }
    }

    public void setLanguageCode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            this.languageCode = str;
        }
    }

    public void setLanguageStyle(LanguageStyle languageStyle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) languageStyle);
        } else {
            this.languageStyle = languageStyle;
        }
    }

    public void setMustDiffMinAndMaxFps(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, z16);
        } else {
            this.mustDiffMinAndMaxFps = z16;
        }
    }

    public void setOpenAngleDetect(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, z16);
        } else {
            this.isOpenAngleDetect = z16;
        }
    }

    public void setOpenFullLog(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, z16);
        } else {
            this.openFullLog = z16;
        }
    }

    public void setOpenLightReflectAnim(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, z16);
        } else {
            this.isOpenLightReflectAnim = z16;
        }
    }

    public void setOpenLog(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, z16);
        } else {
            this.isOpenLog = z16;
        }
    }

    public void setPageColorStyle(PageColorStyle pageColorStyle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) pageColorStyle);
        } else {
            this.pageColorStyle = pageColorStyle;
        }
    }

    public void setPortraitCloseRatio(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, this, Float.valueOf(f16));
        } else {
            this.portraitCloseRatio = f16;
        }
    }

    public void setPrepareFaceTimeOutMs(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
        } else {
            this.prepareFaceTimeOutMs = j3;
        }
    }

    public void setRecordVideo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        } else {
            this.isRecordVideo = z16;
        }
    }

    public void setShowActionTimeout(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, z16);
        } else {
            this.isShowActionTimeout = z16;
        }
    }

    public void setShowDebugView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, (Object) this, z16);
        } else {
            this.showDebugView = z16;
        }
    }

    public void setShowPrepareTimeout(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, z16);
        } else {
            this.isShowPrepareTimeout = z16;
        }
    }

    public void setStartActivityContext(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this, (Object) context);
        } else {
            this.contextWeakReference = new WeakReference<>(context);
        }
    }

    public void setUseBackCamera(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, z16);
        } else {
            this.isUseBackCamera = z16;
        }
    }

    public void setUseBestFaceImage(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, z16);
        } else {
            this.isUseBestFaceImage = z16;
        }
    }

    public void setUseCustomerModelPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        } else {
            this.useCustomerModelPath = str;
        }
    }

    public void setWaitingUserCompare(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            this.waitingUserCompare = z16;
        }
    }

    public void setZoomLevel(CameraZoom cameraZoom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) cameraZoom);
        } else {
            this.zoomLevel = cameraZoom;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            return (String) iPatchRedirector.redirect((short) 82, (Object) this);
        }
        return "HuiYanSdkConfig{isDeleteVideoCache=" + this.isDeleteVideoCache + ", authLicense='" + this.authLicense + "', useCustomerModelPath='" + this.useCustomerModelPath + "', pageColorStyle=" + this.pageColorStyle + ", prepareFaceTimeOutMs=" + this.prepareFaceTimeOutMs + ", authTimeOutMs=" + this.authTimeOutMs + ", isCloseEncrypt=" + this.isCloseEncrypt + ", languageStyle=" + this.languageStyle + ", languageCode='" + this.languageCode + "', isRecordVideo=" + this.isRecordVideo + ", isCutRecordVideo=" + this.isCutRecordVideo + ", isBackgroundStopAuth=" + this.isBackgroundStopAuth + ", waitingUserCompare=" + this.waitingUserCompare + ", disableSystemRecordScreen=" + this.disableSystemRecordScreen + ", isUseBackCamera=" + this.isUseBackCamera + ", bestImageRoll=" + this.bestImageRoll + ", bestImageYaw=" + this.bestImageYaw + ", bestImagePitch=" + this.bestImagePitch + ", bestImageContinuousFrameNum=" + this.bestImageContinuousFrameNum + ", huiYanLiveMode=" + this.huiYanLiveMode + ", encryptMode=" + this.encryptMode + ", isOpenAngleDetect=" + this.isOpenAngleDetect + ", isAutoScreenBrightness=" + this.isAutoScreenBrightness + ", actions=" + Arrays.toString(this.actions) + '}';
    }
}
