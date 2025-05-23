package com.tencent.rtmp;

import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface b {
    void callExperimentalAPI(String str);

    void enableAudioVolumeEvaluation(int i3);

    TXAudioEffectManager getAudioEffectManager();

    TXBeautyManager getBeautyManager();

    TXLivePushConfig getConfig();

    int getMaxZoom();

    @Deprecated
    int getMusicDuration(String str);

    boolean isPushing();

    void onLogRecord(String str);

    @Deprecated
    boolean pauseBGM();

    void pausePusher();

    @Deprecated
    boolean playBGM(String str);

    void release();

    @Deprecated
    boolean resumeBGM();

    void resumePusher();

    void sendCustomPCMData(byte[] bArr);

    int sendCustomVideoData(byte[] bArr, int i3, int i16, int i17);

    int sendCustomVideoTexture(int i3, int i16, int i17);

    @Deprecated
    void sendMessage(byte[] bArr);

    boolean sendMessageEx(byte[] bArr);

    void setAudioProcessListener(TXLivePusher.AudioCustomProcessListener audioCustomProcessListener);

    void setAudioVolumeEvaluationListener(TXLivePusher.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener);

    @Deprecated
    void setBGMNofify(TXLivePusher.OnBGMNotify onBGMNotify);

    @Deprecated
    void setBGMPitch(float f16);

    @Deprecated
    boolean setBGMPosition(int i3);

    @Deprecated
    boolean setBGMVolume(float f16);

    boolean setBeautyFilter(int i3, int i16, int i17, int i18);

    @Deprecated
    void setChinLevel(int i3);

    void setConfig(TXLivePushConfig tXLivePushConfig);

    void setExposureCompensation(float f16);

    @Deprecated
    void setEyeScaleLevel(int i3);

    @Deprecated
    void setFaceShortLevel(int i3);

    @Deprecated
    void setFaceSlimLevel(int i3);

    @Deprecated
    void setFaceVLevel(int i3);

    @Deprecated
    void setFilter(Bitmap bitmap);

    void setFocusPosition(float f16, float f17);

    @Deprecated
    boolean setGreenScreenFile(String str);

    @Deprecated
    boolean setMicVolume(float f16);

    boolean setMirror(boolean z16);

    @Deprecated
    void setMotionMute(boolean z16);

    @Deprecated
    void setMotionTmpl(String str);

    void setMute(boolean z16);

    @Deprecated
    void setNoseSlimLevel(int i3);

    void setPushListener(ITXLivePushListener iTXLivePushListener);

    void setRenderRotation(int i3);

    @Deprecated
    void setReverb(int i3);

    @Deprecated
    void setSpecialRatio(float f16);

    void setSurface(Surface surface);

    @Deprecated
    void setSurfaceSize(int i3, int i16);

    void setVideoProcessListener(TXLivePusher.VideoCustomProcessListener videoCustomProcessListener);

    void setVideoQuality(int i3, boolean z16, boolean z17);

    void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener);

    @Deprecated
    void setVoiceChangerType(int i3);

    boolean setZoom(int i3);

    void snapshot(TXLivePusher.ITXSnapshotListener iTXSnapshotListener);

    void startCameraPreview(TXCloudVideoView tXCloudVideoView);

    int startPusher(String str);

    int startRecord(String str);

    void startScreenCapture();

    @Deprecated
    boolean stopBGM();

    void stopCameraPreview(boolean z16);

    void stopPusher();

    void stopRecord();

    void stopScreenCapture();

    void switchCamera();

    boolean turnOnFlashLight(boolean z16);
}
