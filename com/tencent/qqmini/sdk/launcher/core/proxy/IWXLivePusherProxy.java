package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.content.Context;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public interface IWXLivePusherProxy {
    public static final String CLASS_NAME_TX_CLOUD_VIDEO_VIEW = "com.tencent.rtmp.ui.TXCloudVideoView";

    void enableAGC(boolean z16);

    void enableANS(boolean z16);

    void enableAudioEarMonitoring(boolean z16);

    void enablePureAudioPush(boolean z16);

    void initInstance(Context context);

    void initLivePusher(Object obj, Bundle bundle);

    boolean isPushing();

    Object newITXLivePushListener(TXLivePushListenerReflect.ITXLivePushListener iTXLivePushListener);

    Object newITXSnapshotListener(TXLivePushListenerReflect.ITXSnapshotListener iTXSnapshotListener);

    Object newOnBGMNotify(TXLivePushListenerReflect.OnBGMNotify onBGMNotify);

    boolean pauseBGM();

    void pausePusher();

    boolean playBGM(String str);

    boolean resumeBGM();

    void resumePusher();

    boolean sendMessageEx(byte[] bArr);

    void setAudioSampleRate(int i3);

    void setBGMNofify(Object obj);

    void setBGMPosition(int i3);

    boolean setBGMVolume(float f16);

    void setBeautyFilter(int i3, int i16, int i17, int i18);

    void setConfig();

    void setEnableCamera(JSONObject jSONObject, Object obj);

    void setEnableZoom(boolean z16);

    void setFrontCamera(boolean z16);

    void setHomeOrientation(int i3);

    void setLocalVideoMirrorType(int i3);

    void setMaxVideoBitrate(int i3);

    void setMicVolume(float f16);

    void setMinVideoBitrate(int i3);

    void setMirror(boolean z16);

    void setMode(JSONObject jSONObject);

    void setMuted(boolean z16);

    void setPauseFlag(int i3);

    void setPauseImg(String str);

    void setPushListener(Object obj);

    void setPusherUrl(String str);

    void setRenderRotation(int i3);

    void setReverb(int i3);

    void setSurface(Surface surface);

    void setSurfaceSize(int i3, int i16);

    void setTouchFocus(boolean z16);

    void setVideoEncodeGop(int i3);

    void setVideoQuality(int i3, boolean z16, boolean z17);

    void setVideoResolution(int i3);

    void setVideoResolution(int i3, int i16);

    void setVolumeType(int i3);

    void setWatermark(String str, float f16, float f17, float f18);

    void showDebugLog(boolean z16);

    void snapshot(Object obj);

    void startAudioRecord();

    void startCameraPreview(Object obj);

    int startDumpAudioData(String str);

    boolean startPusher(String str);

    void stopAudioRecord();

    boolean stopBGM();

    void stopCameraPreview(boolean z16);

    void stopDumpAudioData();

    void stopPusher();

    void switchCamera();

    void toggleTorch(Object obj);

    boolean turnOnFlashLight(boolean z16);

    void txCloudVideoView_disableLog(Boolean bool, Object obj);

    void txLivePlayer_setVisibility(int i3, Object obj);

    void updateLivePusher(Bundle bundle);
}
