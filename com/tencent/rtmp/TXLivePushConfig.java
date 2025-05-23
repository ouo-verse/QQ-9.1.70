package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes25.dex */
public class TXLivePushConfig implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_MAX_VIDEO_BITRATE = 1200;
    public static final int DEFAULT_MIN_VIDEO_BITRATE = 800;
    public int mAudioBitrate;
    public int mAudioChannels;
    public String mAudioPreProcessFuncName;
    public String mAudioPreProcessLibrary;
    public int mAudioSample;
    public boolean mAutoAdjustBitrate;
    public int mAutoAdjustStrategy;
    public int mBeautyLevel;
    public int mConnectRetryCount;
    public int mConnectRetryInterval;
    public int mCustomModeType;
    public boolean mEnableAec;
    public boolean mEnableAgc;
    public boolean mEnableAns;
    public boolean mEnableAudioPreview;
    public boolean mEnableHighResolutionCapture;
    public boolean mEnableNearestIP;
    public boolean mEnablePureAudioPush;
    public boolean mEnableScreenCaptureAutoRotate;
    public boolean mEnableVideoHardEncoderMainProfile;
    public boolean mEnableZoom;
    public int mEyeScaleLevel;
    public int mFaceSlimLevel;
    public boolean mFrontCamera;
    public int mHardwareAccel;
    public int mHomeOrientation;
    public int mLocalVideoMirrorType;
    public int mMaxVideoBitrate;
    public HashMap<String, String> mMetaData;
    public int mMinVideoBitrate;
    public int mPauseFlag;
    public int mPauseFps;
    public Bitmap mPauseImg;
    public int mPauseTime;
    public int mRtmpChannelType;
    public int mRuddyLevel;
    public boolean mTouchFocus;
    public int mVideoBitrate;
    public int mVideoEncodeGop;
    public boolean mVideoEncoderXMirror;
    public int mVideoFPS;
    public String mVideoPreProcessFuncName;
    public String mVideoPreProcessLibrary;
    public TXVideoResolution mVideoResolution;
    public int mVolumeType;
    public Bitmap mWatermark;
    public float mWatermarkWidth;
    public int mWatermarkX;
    public float mWatermarkXF;
    public int mWatermarkY;
    public float mWatermarkYF;
    public int mWhiteningLevel;

    public TXLivePushConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mCustomModeType = 0;
        this.mAudioSample = 48000;
        this.mAudioChannels = 1;
        this.mVideoFPS = 20;
        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_540_960;
        this.mVideoBitrate = 1200;
        this.mMaxVideoBitrate = 1500;
        this.mMinVideoBitrate = 800;
        this.mBeautyLevel = 0;
        this.mWhiteningLevel = 0;
        this.mRuddyLevel = 0;
        this.mEyeScaleLevel = 0;
        this.mFaceSlimLevel = 0;
        this.mConnectRetryCount = 3;
        this.mConnectRetryInterval = 3;
        this.mWatermarkX = 0;
        this.mWatermarkY = 0;
        this.mWatermarkXF = 0.0f;
        this.mWatermarkYF = 0.0f;
        this.mWatermarkWidth = -1.0f;
        this.mVideoEncodeGop = 3;
        this.mVideoEncoderXMirror = false;
        this.mEnableHighResolutionCapture = false;
        this.mEnableVideoHardEncoderMainProfile = true;
        this.mFrontCamera = true;
        this.mAutoAdjustBitrate = false;
        this.mAutoAdjustStrategy = 0;
        this.mHardwareAccel = 2;
        this.mTouchFocus = true;
        this.mEnableZoom = false;
        this.mHomeOrientation = 1;
        this.mPauseImg = null;
        this.mPauseTime = 300;
        this.mPauseFps = 5;
        this.mPauseFlag = 1;
        this.mEnableAec = false;
        this.mEnableAgc = false;
        this.mEnableAns = false;
        this.mEnableAudioPreview = false;
        this.mEnableScreenCaptureAutoRotate = false;
        this.mEnablePureAudioPush = false;
        this.mEnableNearestIP = true;
        this.mVolumeType = 0;
        this.mLocalVideoMirrorType = 0;
        this.mRtmpChannelType = 0;
    }

    @Deprecated
    public void enableAEC(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, z16);
        } else {
            this.mEnableAec = z16;
        }
    }

    @Deprecated
    public void enableAGC(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, z16);
        } else {
            this.mEnableAgc = z16;
        }
    }

    public void enableANS(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.mEnableAns = z16;
        }
    }

    public void enableAudioEarMonitoring(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        } else {
            this.mEnableAudioPreview = z16;
        }
    }

    @Deprecated
    public void enableHighResolutionCaptureMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, z16);
        } else {
            this.mEnableHighResolutionCapture = z16;
        }
    }

    @Deprecated
    public void enableNearestIP(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, z16);
        } else {
            this.mEnableNearestIP = z16;
        }
    }

    public void enablePureAudioPush(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.mEnablePureAudioPush = z16;
        }
    }

    public void enableScreenCaptureAutoRotate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            this.mEnableScreenCaptureAutoRotate = z16;
        }
    }

    public void enableVideoHardEncoderMainProfile(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        } else {
            this.mEnableVideoHardEncoderMainProfile = z16;
        }
    }

    public void setAudioChannels(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.mAudioChannels = i3;
        }
    }

    public void setAudioSampleRate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.mAudioSample = i3;
        }
    }

    public void setAutoAdjustBitrate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.mAutoAdjustBitrate = z16;
        }
    }

    public void setAutoAdjustStrategy(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.mAutoAdjustStrategy = i3;
        }
    }

    @Deprecated
    public void setBeautyFilter(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.mBeautyLevel = i3;
        this.mWhiteningLevel = i16;
        this.mRuddyLevel = i17;
    }

    public void setConnectRetryCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        } else {
            this.mConnectRetryCount = i3;
        }
    }

    public void setConnectRetryInterval(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        } else {
            this.mConnectRetryInterval = i3;
        }
    }

    public void setCustomModeType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
        } else {
            this.mCustomModeType = i3;
        }
    }

    public void setEnableZoom(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.mEnableZoom = z16;
        }
    }

    @Deprecated
    public void setEyeScaleLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, i3);
        } else {
            this.mEyeScaleLevel = i3;
        }
    }

    @Deprecated
    public void setFaceSlimLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, i3);
        } else {
            this.mFaceSlimLevel = i3;
        }
    }

    @Deprecated
    public void setFrontCamera(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, z16);
        } else {
            this.mFrontCamera = z16;
        }
    }

    public void setHardwareAcceleration(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
            return;
        }
        int i16 = 2;
        if (i3 < 0) {
            i3 = 2;
        }
        if (i3 <= 2) {
            i16 = i3;
        }
        this.mHardwareAccel = i16;
    }

    public void setHomeOrientation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.mHomeOrientation = i3;
        }
    }

    public void setLocalVideoMirrorType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mLocalVideoMirrorType = i3;
        }
    }

    public void setMaxVideoBitrate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.mMaxVideoBitrate = i3;
        }
    }

    public void setMetaData(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) hashMap);
        } else {
            this.mMetaData = hashMap;
        }
    }

    public void setMinVideoBitrate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.mMinVideoBitrate = i3;
        }
    }

    public void setPauseFlag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.mPauseFlag = i3;
        }
    }

    public void setPauseImg(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.mPauseImg = bitmap;
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bitmap);
        }
    }

    @Deprecated
    public void setRtmpChannelType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, i3);
        } else {
            this.mRtmpChannelType = i3;
        }
    }

    public void setTouchFocus(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.mTouchFocus = z16;
        }
    }

    public void setVideoBitrate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.mVideoBitrate = i3;
        }
    }

    public void setVideoEncodeGop(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.mVideoEncodeGop = i3;
        }
    }

    public void setVideoEncoderXMirror(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        } else {
            this.mVideoEncoderXMirror = z16;
        }
    }

    public void setVideoFPS(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.mVideoFPS = i3;
        }
    }

    public void setVideoResolution(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        if (i3 != 30) {
            if (i3 != 31) {
                switch (i3) {
                    case 0:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_360_640;
                        return;
                    case 1:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_540_960;
                        return;
                    case 2:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_720_1280;
                        return;
                    case 3:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_640_360;
                        return;
                    case 4:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_960_540;
                        return;
                    case 5:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_1280_720;
                        return;
                    case 6:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_320_480;
                        return;
                    case 7:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_180_320;
                        return;
                    case 8:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_270_480;
                        return;
                    case 9:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_320_180;
                        return;
                    case 10:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_480_270;
                        return;
                    case 11:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_240_320;
                        return;
                    case 12:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_360_480;
                        return;
                    case 13:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_480_640;
                        return;
                    case 14:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_320_240;
                        return;
                    case 15:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_480_360;
                        return;
                    case 16:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_640_480;
                        return;
                    case 17:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_480_480;
                        return;
                    case 18:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_270_270;
                        return;
                    case 19:
                        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_160_160;
                        return;
                    default:
                        return;
                }
            }
            this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_1920_1080;
            return;
        }
        this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_1080_1920;
    }

    public void setVolumeType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
        } else {
            this.mVolumeType = i3;
        }
    }

    public void setWatermark(Bitmap bitmap, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, bitmap, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mWatermark = bitmap;
        this.mWatermarkX = i3;
        this.mWatermarkY = i16;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return "[resolution:" + this.mVideoResolution + "][fps:" + this.mVideoFPS + "][gop:" + this.mVideoEncodeGop + "][bitrate:" + this.mVideoBitrate + "][maxBitrate:" + this.mMaxVideoBitrate + "][minBitrate:" + this.mMinVideoBitrate + "][highCapture:" + this.mEnableHighResolutionCapture + "][hwAcc:" + this.mHardwareAccel + "][homeOrientation:" + this.mHomeOrientation + "][volumeType:" + this.mVolumeType + "][earMonitor:" + this.mEnableAudioPreview + "][agc:" + this.mEnableAgc + "][ans:" + this.mEnableAns + "][aec:" + this.mEnableAec + "][sample:" + this.mAudioSample + "][pureAudioPush:" + this.mEnablePureAudioPush + "]";
    }

    @Deprecated
    public void setPauseImg(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mPauseTime = i3;
            this.mPauseFps = i16;
        }
    }

    public void setWatermark(Bitmap bitmap, float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, bitmap, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        this.mWatermark = bitmap;
        this.mWatermarkXF = f16;
        this.mWatermarkYF = f17;
        this.mWatermarkWidth = f18;
    }
}
