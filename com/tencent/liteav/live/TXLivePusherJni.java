package com.tencent.liteav.live;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.i;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.TXBeautyManagerImpl;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.b;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

@JNINamespace("liteav")
/* loaded from: classes7.dex */
public class TXLivePusherJni implements ITXLivePushListener, TXLivePusher.AudioCustomProcessListener, TXLivePusher.ITXAudioVolumeEvaluationListener, TXLivePusher.ITXSnapshotListener, TXLivePusher.OnBGMNotify, TXLivePusher.VideoCustomProcessListener, b, TXCloudVideoView.b {
    private TXLivePusher.AudioCustomProcessListener mAudioCustomProcessListener;
    private TXAudioEffectManager mAudioEffectManager;
    private TXBeautyManagerImpl mBeautyManager;
    private TXLivePushConfig mConfig;
    private TXLivePusher.ITXAudioVolumeEvaluationListener mITXAudioVolumeEvaluationListener;
    private ITXLivePushListener mITXLivePushListener;
    private TXLivePusher.ITXSnapshotListener mITXSnapshotListener;
    private TXRecordCommon.ITXVideoRecordListener mITXVideoRecordListener;
    private long mNativeTXLivePusherJni;
    private TXLivePusher.OnBGMNotify mOnBGMNotify;
    private TXLivePusher.VideoCustomProcessListener mVideoCustomProcessListener;
    private int mVideoQuality = -1;

    public TXLivePusherJni(Context context) {
        this.mNativeTXLivePusherJni = 0L;
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        this.mConfig = new TXLivePushConfig();
        long nativeCreate = nativeCreate(new WeakReference(this));
        this.mNativeTXLivePusherJni = nativeCreate;
        this.mAudioEffectManager = new TXAudioEffectManagerImpl(nativeCreateAudioEffectManager(nativeCreate));
        this.mBeautyManager = new TXBeautyManagerImpl(nativeCreateBeautyManager(this.mNativeTXLivePusherJni));
        if (context instanceof Activity) {
            i.a().a((Activity) context);
        }
    }

    public static String[] getMapKeys(HashMap<String, String> hashMap) {
        String[] strArr = new String[hashMap.size()];
        Iterator<String> it = hashMap.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            strArr[i3] = it.next();
            i3++;
        }
        return strArr;
    }

    public static String[] getMapValues(HashMap<String, String> hashMap, String[] strArr) {
        String[] strArr2 = new String[hashMap.size()];
        int length = strArr.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            strArr2[i16] = hashMap.get(strArr[i3]);
            i3++;
            i16++;
        }
        return strArr2;
    }

    public static boolean isMapValid(HashMap<String, String> hashMap) {
        for (String str : hashMap.keySet()) {
            if (str == null || hashMap.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    private static native void nativeCallExperimentalAPI(long j3, String str);

    private static native long nativeCreate(WeakReference<TXLivePusherJni> weakReference);

    private static native long nativeCreateAudioEffectManager(long j3);

    private static native long nativeCreateBeautyManager(long j3);

    private static native void nativeDestroy(long j3);

    private static native void nativeEnableAudioVolumeEvaluation(long j3, int i3);

    private static native int nativeGetMaxZoom(long j3);

    private static native int nativeGetMusicDuration(long j3, String str);

    private static native boolean nativeIsPushing(long j3);

    private static native void nativeOnLogRecord(long j3, String str);

    private static native boolean nativePauseBGM(long j3);

    private static native void nativePausePusher(long j3);

    private static native boolean nativePlayBGM(long j3, String str);

    private static native boolean nativeResumeBGM(long j3);

    private static native void nativeResumePusher(long j3);

    private static native void nativeSendCustomPCMData(long j3, byte[] bArr);

    private static native void nativeSendCustomVideoFrame(long j3, int i3, int i16, int i17, int i18, int i19, Object obj, byte[] bArr);

    private static native void nativeSendMessage(long j3, byte[] bArr);

    private static native boolean nativeSendMessageEx(long j3, byte[] bArr);

    private static native void nativeSetAudioConfig(long j3, int i3, int i16, int i17, boolean z16, boolean z17);

    private static native void nativeSetBGMPitch(long j3, float f16);

    private static native boolean nativeSetBGMPosition(long j3, int i3);

    private static native boolean nativeSetBGMVolume(long j3, float f16);

    private static native boolean nativeSetBeautyFilter(long j3, int i3, int i16, int i17, int i18);

    private static native void nativeSetCaptureConfig(long j3, int i3, int i16, Bitmap bitmap, int i17, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i18);

    private static native void nativeSetEncoderConfig(long j3, int i3, int i16, boolean z16, int i17, int i18, int i19, int i26, int i27, boolean z17, int i28, boolean z18);

    private static native void nativeSetExposureCompensation(long j3, float f16);

    private static native void nativeSetFilter(long j3, Bitmap bitmap);

    private static native void nativeSetFocusPosition(long j3, float f16, float f17);

    private static native boolean nativeSetMicVolume(long j3, float f16);

    private static native boolean nativeSetMirror(long j3, boolean z16);

    private static native void nativeSetMute(long j3, boolean z16);

    private static native void nativeSetNetworkConfig(long j3, int i3, boolean z16, int i16, int i17, int i18, HashMap hashMap);

    private static native void nativeSetRenderRotation(long j3, int i3);

    private static native void nativeSetReverb(long j3, int i3);

    private static native void nativeSetSpecialRatio(long j3, float f16);

    private static native void nativeSetView(long j3, DisplayTarget displayTarget);

    private static native void nativeSetVoiceChangerType(long j3, int i3);

    private static native void nativeSetWaterMark(long j3, Bitmap bitmap, float f16, float f17, float f18);

    private static native boolean nativeSetZoom(long j3, int i3);

    private static native void nativeShowDebugView(long j3, boolean z16);

    private static native void nativeSnapshot(long j3);

    private static native void nativeStartCamera(long j3);

    private static native int nativeStartPusher(long j3, String str);

    private static native int nativeStartRecord(long j3, String str);

    private static native void nativeStartScreenCapture(long j3);

    private static native boolean nativeStopBGM(long j3);

    private static native void nativeStopCameraPreview(long j3, boolean z16);

    private static native void nativeStopPusher(long j3);

    private static native void nativeStopRecord(long j3);

    private static native void nativeStopScreenCapture(long j3);

    private static native void nativeSwitchCamera(long j3);

    private static native boolean nativeTurnOnFlashLight(long j3, boolean z16);

    public static TXLivePusherJni weakToStrongReference(WeakReference<TXLivePusherJni> weakReference) {
        return weakReference.get();
    }

    @Override // com.tencent.rtmp.b
    public void callExperimentalAPI(String str) {
        nativeCallExperimentalAPI(this.mNativeTXLivePusherJni, str);
    }

    @Override // com.tencent.rtmp.b
    public void enableAudioVolumeEvaluation(int i3) {
        nativeEnableAudioVolumeEvaluation(this.mNativeTXLivePusherJni, i3);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        release();
    }

    @Override // com.tencent.rtmp.b
    public TXAudioEffectManager getAudioEffectManager() {
        return this.mAudioEffectManager;
    }

    @Override // com.tencent.rtmp.b
    public TXBeautyManager getBeautyManager() {
        return this.mBeautyManager;
    }

    @Override // com.tencent.rtmp.b
    public TXLivePushConfig getConfig() {
        return this.mConfig;
    }

    @Override // com.tencent.rtmp.b
    public int getMaxZoom() {
        return nativeGetMaxZoom(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public int getMusicDuration(String str) {
        return nativeGetMusicDuration(this.mNativeTXLivePusherJni, str);
    }

    @Override // com.tencent.rtmp.b
    public boolean isPushing() {
        return nativeIsPushing(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener
    public void onAudioVolumeEvaluationNotify(int i3) {
        TXLivePusher.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener = this.mITXAudioVolumeEvaluationListener;
        if (iTXAudioVolumeEvaluationListener != null) {
            iTXAudioVolumeEvaluationListener.onAudioVolumeEvaluationNotify(i3);
        }
    }

    @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
    public void onBGMComplete(int i3) {
        TXLivePusher.OnBGMNotify onBGMNotify = this.mOnBGMNotify;
        if (onBGMNotify != null) {
            onBGMNotify.onBGMComplete(i3);
        }
    }

    @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
    public void onBGMProgress(long j3, long j16) {
        TXLivePusher.OnBGMNotify onBGMNotify = this.mOnBGMNotify;
        if (onBGMNotify != null) {
            onBGMNotify.onBGMProgress(j3, j16);
        }
    }

    @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
    public void onBGMStart() {
        TXLivePusher.OnBGMNotify onBGMNotify = this.mOnBGMNotify;
        if (onBGMNotify != null) {
            onBGMNotify.onBGMStart();
        }
    }

    public int onCustomPreprocessFrame(int i3, int i16, int i17) {
        return onTextureCustomProcess(i3, i16, i17);
    }

    @Override // com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
    public void onDetectFacePoints(float[] fArr) {
        TXLivePusher.VideoCustomProcessListener videoCustomProcessListener = this.mVideoCustomProcessListener;
        if (videoCustomProcessListener != null) {
            videoCustomProcessListener.onDetectFacePoints(fArr);
        }
    }

    @Override // com.tencent.rtmp.b
    public void onLogRecord(String str) {
        nativeOnLogRecord(this.mNativeTXLivePusherJni, str);
    }

    public byte[] onNativeRecordPcmData(byte[] bArr, long j3, int i3, int i16, int i17) {
        onRecordPcmData(bArr, j3, i3, i16, i17);
        return bArr;
    }

    public byte[] onNativeRecordRawPcmData(byte[] bArr, long j3, int i3, int i16, int i17, boolean z16) {
        onRecordRawPcmData(bArr, j3, i3, i16, i17, z16);
        return bArr;
    }

    @Override // com.tencent.rtmp.ITXLivePushListener
    public void onNetStatus(Bundle bundle) {
        ITXLivePushListener iTXLivePushListener = this.mITXLivePushListener;
        if (iTXLivePushListener != null) {
            iTXLivePushListener.onNetStatus(bundle);
        }
    }

    @Override // com.tencent.rtmp.ITXLivePushListener
    public void onPushEvent(int i3, Bundle bundle) {
        ITXLivePushListener iTXLivePushListener = this.mITXLivePushListener;
        if (iTXLivePushListener != null) {
            iTXLivePushListener.onPushEvent(i3, bundle);
        }
    }

    public void onRecordComplete(int i3, String str, String str2, String str3) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mITXVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            TXRecordCommon.TXRecordResult tXRecordResult = new TXRecordCommon.TXRecordResult();
            if (i3 == 0) {
                tXRecordResult.retCode = 0;
            } else {
                tXRecordResult.retCode = -1;
            }
            tXRecordResult.descMsg = str;
            tXRecordResult.videoPath = str2;
            tXRecordResult.coverPath = str3;
            iTXVideoRecordListener.onRecordComplete(tXRecordResult);
        }
    }

    public void onRecordEvent(int i3, Bundle bundle) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mITXVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            iTXVideoRecordListener.onRecordEvent(i3, bundle);
        }
    }

    @Override // com.tencent.rtmp.TXLivePusher.AudioCustomProcessListener
    public void onRecordPcmData(byte[] bArr, long j3, int i3, int i16, int i17) {
        TXLivePusher.AudioCustomProcessListener audioCustomProcessListener = this.mAudioCustomProcessListener;
        if (audioCustomProcessListener != null) {
            audioCustomProcessListener.onRecordPcmData(bArr, j3, i3, i16, i17);
        }
    }

    public void onRecordProgress(long j3) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mITXVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            iTXVideoRecordListener.onRecordProgress(j3);
        }
    }

    @Override // com.tencent.rtmp.TXLivePusher.AudioCustomProcessListener
    public void onRecordRawPcmData(byte[] bArr, long j3, int i3, int i16, int i17, boolean z16) {
        TXLivePusher.AudioCustomProcessListener audioCustomProcessListener = this.mAudioCustomProcessListener;
        if (audioCustomProcessListener != null) {
            audioCustomProcessListener.onRecordRawPcmData(bArr, j3, i3, i16, i17, z16);
        }
    }

    @Override // com.tencent.rtmp.ui.TXCloudVideoView.b
    public void onShowLog(boolean z16) {
        nativeShowDebugView(this.mNativeTXLivePusherJni, z16);
    }

    @Override // com.tencent.rtmp.TXLivePusher.ITXSnapshotListener
    public void onSnapshot(Bitmap bitmap) {
        TXLivePusher.ITXSnapshotListener iTXSnapshotListener = this.mITXSnapshotListener;
        if (iTXSnapshotListener != null) {
            iTXSnapshotListener.onSnapshot(bitmap);
        }
    }

    @Override // com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
    public int onTextureCustomProcess(int i3, int i16, int i17) {
        TXLivePusher.VideoCustomProcessListener videoCustomProcessListener = this.mVideoCustomProcessListener;
        if (videoCustomProcessListener != null) {
            return videoCustomProcessListener.onTextureCustomProcess(i3, i16, i17);
        }
        return -1;
    }

    @Override // com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
    public void onTextureDestoryed() {
        TXLivePusher.VideoCustomProcessListener videoCustomProcessListener = this.mVideoCustomProcessListener;
        if (videoCustomProcessListener != null) {
            videoCustomProcessListener.onTextureDestoryed();
        }
    }

    @Override // com.tencent.rtmp.b
    public boolean pauseBGM() {
        return nativePauseBGM(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public void pausePusher() {
        nativePausePusher(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public boolean playBGM(String str) {
        return nativePlayBGM(this.mNativeTXLivePusherJni, str);
    }

    @Override // com.tencent.rtmp.b
    public void release() {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManager;
        if (tXBeautyManagerImpl != null) {
            tXBeautyManagerImpl.clear();
        }
        long j3 = this.mNativeTXLivePusherJni;
        if (j3 != 0) {
            nativeDestroy(j3);
            this.mNativeTXLivePusherJni = 0L;
        }
    }

    @Override // com.tencent.rtmp.b
    public boolean resumeBGM() {
        return nativeResumeBGM(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public void resumePusher() {
        nativeResumePusher(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public void sendCustomPCMData(byte[] bArr) {
        nativeSendCustomPCMData(this.mNativeTXLivePusherJni, bArr);
    }

    @Override // com.tencent.rtmp.b
    public int sendCustomVideoData(byte[] bArr, int i3, int i16, int i17) {
        GLConstants.PixelFormatType pixelFormatType;
        if (i3 != 3) {
            if (i3 != 5) {
                return -3;
            }
            pixelFormatType = GLConstants.PixelFormatType.RGBA;
        } else {
            pixelFormatType = GLConstants.PixelFormatType.I420;
        }
        nativeSendCustomVideoFrame(this.mNativeTXLivePusherJni, i16, i17, GLConstants.a.BYTE_ARRAY.mValue, pixelFormatType.getValue(), -1, null, bArr);
        return 0;
    }

    @Override // com.tencent.rtmp.b
    public int sendCustomVideoTexture(int i3, int i16, int i17) {
        EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
        if (eglGetCurrentContext == null) {
            return -1;
        }
        nativeSendCustomVideoFrame(this.mNativeTXLivePusherJni, i16, i17, GLConstants.a.TEXTURE_2D.mValue, GLConstants.PixelFormatType.RGBA.getValue(), i3, eglGetCurrentContext, null);
        return 0;
    }

    @Override // com.tencent.rtmp.b
    public void sendMessage(byte[] bArr) {
        nativeSendMessage(this.mNativeTXLivePusherJni, bArr);
    }

    @Override // com.tencent.rtmp.b
    public boolean sendMessageEx(byte[] bArr) {
        return nativeSendMessageEx(this.mNativeTXLivePusherJni, bArr);
    }

    @Override // com.tencent.rtmp.b
    public void setAudioProcessListener(TXLivePusher.AudioCustomProcessListener audioCustomProcessListener) {
        this.mAudioCustomProcessListener = audioCustomProcessListener;
    }

    @Override // com.tencent.rtmp.b
    public void setAudioVolumeEvaluationListener(TXLivePusher.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        this.mITXAudioVolumeEvaluationListener = iTXAudioVolumeEvaluationListener;
    }

    @Override // com.tencent.rtmp.b
    public void setBGMNofify(TXLivePusher.OnBGMNotify onBGMNotify) {
        this.mOnBGMNotify = onBGMNotify;
    }

    @Override // com.tencent.rtmp.b
    public void setBGMPitch(float f16) {
        nativeSetBGMPitch(this.mNativeTXLivePusherJni, f16);
    }

    @Override // com.tencent.rtmp.b
    public boolean setBGMPosition(int i3) {
        return nativeSetBGMPosition(this.mNativeTXLivePusherJni, i3);
    }

    @Override // com.tencent.rtmp.b
    public boolean setBGMVolume(float f16) {
        return nativeSetBGMVolume(this.mNativeTXLivePusherJni, f16);
    }

    @Override // com.tencent.rtmp.b
    public boolean setBeautyFilter(int i3, int i16, int i17, int i18) {
        return nativeSetBeautyFilter(this.mNativeTXLivePusherJni, i3, i16, i17, i18);
    }

    @Override // com.tencent.rtmp.b
    public void setChinLevel(int i3) {
        this.mBeautyManager.setChinLevel(i3);
    }

    @Override // com.tencent.rtmp.b
    public void setConfig(TXLivePushConfig tXLivePushConfig) {
        if (tXLivePushConfig == null) {
            return;
        }
        this.mConfig = tXLivePushConfig;
        nativeSetCaptureConfig(this.mNativeTXLivePusherJni, tXLivePushConfig.mCustomModeType, tXLivePushConfig.mLocalVideoMirrorType, tXLivePushConfig.mPauseImg, tXLivePushConfig.mPauseFps, tXLivePushConfig.mFrontCamera, tXLivePushConfig.mTouchFocus, tXLivePushConfig.mEnableZoom, tXLivePushConfig.mEnableScreenCaptureAutoRotate, tXLivePushConfig.mEnableHighResolutionCapture, tXLivePushConfig.mPauseFlag);
        long j3 = this.mNativeTXLivePusherJni;
        TXLivePushConfig tXLivePushConfig2 = this.mConfig;
        int i3 = tXLivePushConfig2.mHomeOrientation;
        int ordinal = tXLivePushConfig2.mVideoResolution.ordinal();
        TXLivePushConfig tXLivePushConfig3 = this.mConfig;
        nativeSetEncoderConfig(j3, i3, ordinal, tXLivePushConfig3.mAutoAdjustBitrate, tXLivePushConfig3.mVideoBitrate, tXLivePushConfig3.mMaxVideoBitrate, tXLivePushConfig3.mMinVideoBitrate, tXLivePushConfig3.mVideoEncodeGop, tXLivePushConfig3.mVideoFPS, tXLivePushConfig3.mVideoEncoderXMirror, tXLivePushConfig3.mHardwareAccel, tXLivePushConfig3.mEnableVideoHardEncoderMainProfile);
        long j16 = this.mNativeTXLivePusherJni;
        TXLivePushConfig tXLivePushConfig4 = this.mConfig;
        nativeSetWaterMark(j16, tXLivePushConfig4.mWatermark, tXLivePushConfig4.mWatermarkXF, tXLivePushConfig4.mWatermarkYF, tXLivePushConfig4.mWatermarkWidth);
        long j17 = this.mNativeTXLivePusherJni;
        TXLivePushConfig tXLivePushConfig5 = this.mConfig;
        nativeSetAudioConfig(j17, tXLivePushConfig5.mAudioChannels, tXLivePushConfig5.mAudioSample, tXLivePushConfig5.mVolumeType, tXLivePushConfig5.mEnableAudioPreview, tXLivePushConfig5.mEnableAns);
        long j18 = this.mNativeTXLivePusherJni;
        TXLivePushConfig tXLivePushConfig6 = this.mConfig;
        nativeSetNetworkConfig(j18, tXLivePushConfig6.mAutoAdjustStrategy, tXLivePushConfig6.mEnablePureAudioPush, tXLivePushConfig6.mConnectRetryCount, tXLivePushConfig6.mConnectRetryInterval, tXLivePushConfig6.mRtmpChannelType, tXLivePushConfig6.mMetaData);
    }

    @Override // com.tencent.rtmp.b
    public void setExposureCompensation(float f16) {
        nativeSetExposureCompensation(this.mNativeTXLivePusherJni, f16);
    }

    @Override // com.tencent.rtmp.b
    public void setEyeScaleLevel(int i3) {
        this.mBeautyManager.setEyeScaleLevel(i3);
    }

    @Override // com.tencent.rtmp.b
    public void setFaceShortLevel(int i3) {
        this.mBeautyManager.setFaceShortLevel(i3);
    }

    @Override // com.tencent.rtmp.b
    public void setFaceSlimLevel(int i3) {
        this.mBeautyManager.setFaceSlimLevel(i3);
    }

    @Override // com.tencent.rtmp.b
    public void setFaceVLevel(int i3) {
        this.mBeautyManager.setFaceVLevel(i3);
    }

    @Override // com.tencent.rtmp.b
    public void setFilter(Bitmap bitmap) {
        nativeSetFilter(this.mNativeTXLivePusherJni, bitmap);
    }

    @Override // com.tencent.rtmp.b
    public void setFocusPosition(float f16, float f17) {
        nativeSetFocusPosition(this.mNativeTXLivePusherJni, f16, f17);
    }

    @Override // com.tencent.rtmp.b
    public boolean setGreenScreenFile(String str) {
        if (this.mBeautyManager.setGreenScreenFile(str) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.rtmp.b
    public boolean setMicVolume(float f16) {
        return nativeSetMicVolume(this.mNativeTXLivePusherJni, f16);
    }

    @Override // com.tencent.rtmp.b
    public boolean setMirror(boolean z16) {
        return nativeSetMirror(this.mNativeTXLivePusherJni, z16);
    }

    @Override // com.tencent.rtmp.b
    public void setMotionMute(boolean z16) {
        this.mBeautyManager.setMotionMute(z16);
    }

    @Override // com.tencent.rtmp.b
    public void setMotionTmpl(String str) {
        this.mBeautyManager.setMotionTmpl(str);
    }

    @Override // com.tencent.rtmp.b
    public void setMute(boolean z16) {
        nativeSetMute(this.mNativeTXLivePusherJni, z16);
    }

    @Override // com.tencent.rtmp.b
    public void setNoseSlimLevel(int i3) {
        this.mBeautyManager.setNoseSlimLevel(i3);
    }

    @Override // com.tencent.rtmp.b
    public void setPushListener(ITXLivePushListener iTXLivePushListener) {
        this.mITXLivePushListener = iTXLivePushListener;
    }

    @Override // com.tencent.rtmp.b
    public void setRenderRotation(int i3) {
        nativeSetRenderRotation(this.mNativeTXLivePusherJni, i3);
    }

    @Override // com.tencent.rtmp.b
    public void setReverb(int i3) {
        nativeSetReverb(this.mNativeTXLivePusherJni, i3);
    }

    @Override // com.tencent.rtmp.b
    public void setSpecialRatio(float f16) {
        nativeSetSpecialRatio(this.mNativeTXLivePusherJni, f16);
    }

    @Override // com.tencent.rtmp.b
    public void setSurface(Surface surface) {
        nativeSetView(this.mNativeTXLivePusherJni, new DisplayTarget(surface));
    }

    @Override // com.tencent.rtmp.b
    public void setVideoProcessListener(TXLivePusher.VideoCustomProcessListener videoCustomProcessListener) {
        this.mVideoCustomProcessListener = videoCustomProcessListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.rtmp.b
    public void setVideoQuality(int i3, boolean z16, boolean z17) {
        byte b16;
        if (z16 && z17) {
            b16 = true;
        } else {
            b16 = false;
        }
        this.mConfig.setHardwareAcceleration(1);
        this.mConfig.setAutoAdjustBitrate(z16);
        switch (i3) {
            case 1:
                this.mConfig.setVideoResolution(0);
                this.mConfig.setAutoAdjustStrategy(z17 ? 1 : 0);
                this.mConfig.setVideoEncodeGop(3);
                if (b16 != false) {
                    this.mConfig.setMinVideoBitrate(301);
                } else {
                    this.mConfig.setMinVideoBitrate(500);
                }
                this.mConfig.setVideoBitrate(800);
                this.mConfig.setMaxVideoBitrate(900);
                break;
            case 2:
                this.mConfig.setVideoResolution(1);
                this.mConfig.setAutoAdjustStrategy(z17 ? 1 : 0);
                this.mConfig.setVideoEncodeGop(3);
                if (b16 != false) {
                    this.mConfig.setMinVideoBitrate(600);
                } else {
                    this.mConfig.setMinVideoBitrate(800);
                }
                this.mConfig.setVideoBitrate(1200);
                this.mConfig.setMaxVideoBitrate(1500);
                break;
            case 3:
                this.mConfig.setVideoResolution(2);
                this.mConfig.setAutoAdjustStrategy(z17 ? 1 : 0);
                this.mConfig.setVideoEncodeGop(3);
                if (b16 != false) {
                    this.mConfig.setMinVideoBitrate(600);
                } else {
                    this.mConfig.setMinVideoBitrate(1000);
                }
                this.mConfig.setVideoBitrate(TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC);
                this.mConfig.setMaxVideoBitrate(TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC);
                break;
            case 4:
                int i16 = this.mVideoQuality;
                if (i16 == 1) {
                    this.mConfig.setVideoResolution(0);
                    this.mConfig.setMinVideoBitrate(500);
                    this.mConfig.setVideoBitrate(800);
                    this.mConfig.setMaxVideoBitrate(900);
                } else if (i16 == 3) {
                    this.mConfig.setVideoResolution(2);
                    this.mConfig.setMinVideoBitrate(1000);
                    this.mConfig.setVideoBitrate(TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC);
                    this.mConfig.setMaxVideoBitrate(TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC);
                } else if (i16 == 7) {
                    this.mConfig.setVideoResolution(30);
                    this.mConfig.setMinVideoBitrate(2000);
                    this.mConfig.setVideoBitrate(3000);
                    this.mConfig.setMaxVideoBitrate(3000);
                } else {
                    this.mConfig.setVideoResolution(1);
                    this.mConfig.setMinVideoBitrate(800);
                    this.mConfig.setVideoBitrate(1200);
                    this.mConfig.setMaxVideoBitrate(1500);
                }
                this.mConfig.setAutoAdjustStrategy(4);
                this.mConfig.setVideoEncodeGop(1);
                break;
            case 5:
                this.mConfig.setVideoResolution(6);
                this.mConfig.setMinVideoBitrate(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID);
                this.mConfig.setVideoBitrate(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID);
                this.mConfig.setMaxVideoBitrate(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID);
                this.mConfig.setAutoAdjustStrategy(4);
                this.mConfig.setVideoEncodeGop(1);
                break;
            case 6:
                this.mConfig.setVideoResolution(0);
                this.mConfig.setAutoAdjustStrategy(5);
                this.mConfig.setVideoEncodeGop(1);
                this.mConfig.setMinVideoBitrate(190);
                this.mConfig.setVideoBitrate(400);
                this.mConfig.setMaxVideoBitrate(810);
                break;
            case 7:
                this.mConfig.setVideoResolution(30);
                this.mConfig.setAutoAdjustStrategy(z17 ? 1 : 0);
                this.mConfig.setVideoEncodeGop(3);
                if (b16 != false) {
                    this.mConfig.setMinVideoBitrate(600);
                } else {
                    this.mConfig.setMinVideoBitrate(2500);
                }
                this.mConfig.setVideoBitrate(3000);
                this.mConfig.setMaxVideoBitrate(3000);
                break;
            default:
                return;
        }
        this.mVideoQuality = i3;
        setConfig(this.mConfig);
    }

    @Override // com.tencent.rtmp.b
    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.mITXVideoRecordListener = iTXVideoRecordListener;
    }

    @Override // com.tencent.rtmp.b
    public void setVoiceChangerType(int i3) {
        nativeSetVoiceChangerType(this.mNativeTXLivePusherJni, i3);
    }

    @Override // com.tencent.rtmp.b
    public boolean setZoom(int i3) {
        return nativeSetZoom(this.mNativeTXLivePusherJni, i3);
    }

    @Override // com.tencent.rtmp.b
    public void snapshot(TXLivePusher.ITXSnapshotListener iTXSnapshotListener) {
        this.mITXSnapshotListener = iTXSnapshotListener;
        nativeSnapshot(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public void startCameraPreview(TXCloudVideoView tXCloudVideoView) {
        if (tXCloudVideoView != null) {
            a.a(tXCloudVideoView, new WeakReference(this));
            nativeShowDebugView(this.mNativeTXLivePusherJni, a.a(tXCloudVideoView));
        }
        nativeSetView(this.mNativeTXLivePusherJni, new DisplayTarget(tXCloudVideoView));
        nativeStartCamera(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public int startPusher(String str) {
        return nativeStartPusher(this.mNativeTXLivePusherJni, str);
    }

    @Override // com.tencent.rtmp.b
    public int startRecord(String str) {
        return nativeStartRecord(this.mNativeTXLivePusherJni, str);
    }

    @Override // com.tencent.rtmp.b
    public void startScreenCapture() {
        nativeStartScreenCapture(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public boolean stopBGM() {
        return nativeStopBGM(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public void stopCameraPreview(boolean z16) {
        nativeStopCameraPreview(this.mNativeTXLivePusherJni, z16);
    }

    @Override // com.tencent.rtmp.b
    public void stopPusher() {
        nativeStopPusher(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public void stopRecord() {
        nativeStopRecord(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public void stopScreenCapture() {
        nativeStopScreenCapture(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public void switchCamera() {
        this.mConfig.setFrontCamera(!r0.mFrontCamera);
        nativeSwitchCamera(this.mNativeTXLivePusherJni);
    }

    @Override // com.tencent.rtmp.b
    public boolean turnOnFlashLight(boolean z16) {
        return nativeTurnOnFlashLight(this.mNativeTXLivePusherJni, z16);
    }

    @Override // com.tencent.rtmp.b
    public void setSurfaceSize(int i3, int i16) {
    }
}
