package com.tencent.liteav.trtc;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.e;
import com.tencent.liteav.base.util.i;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.TXBeautyManagerImpl;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.device.TXDeviceManagerImpl;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TRTCCloudImpl extends TRTCCloud implements TXAudioEffectManager.TXMusicPlayObserver {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f119146a = false;

    /* renamed from: b, reason: collision with root package name */
    private static TRTCCloudImpl f119147b;

    /* renamed from: c, reason: collision with root package name */
    private Context f119148c;

    /* renamed from: d, reason: collision with root package name */
    private TRTCCloudListener f119149d;

    /* renamed from: e, reason: collision with root package name */
    private TrtcCloudJni f119150e;

    /* renamed from: f, reason: collision with root package name */
    private TRTCCloud.BGMNotify f119151f;

    /* renamed from: g, reason: collision with root package name */
    private TXAudioEffectManagerImpl f119152g;

    /* renamed from: h, reason: collision with root package name */
    private TXDeviceManagerImpl f119153h;

    /* renamed from: i, reason: collision with root package name */
    private TXBeautyManagerImpl f119154i;

    /* renamed from: j, reason: collision with root package name */
    private int f119155j;

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<TRTCCloudImpl> f119156k = new ArrayList<>();

    TRTCCloudImpl(Context context, boolean z16) {
        b(context);
        this.f119148c = context;
        a(context, 0L, z16);
    }

    private static void b(Context context) {
        synchronized (TRTCCloudImpl.class) {
            if (!f119146a) {
                ContextUtils.initApplicationContext(context.getApplicationContext());
                ContextUtils.setDataDirectorySuffix("liteav");
                TrtcCloudJni.init(0);
                f119146a = true;
            }
            if (context instanceof Activity) {
                i.a().a((Activity) context);
            }
        }
    }

    private String c() {
        return this.f119148c.getCacheDir() + File.separator + "liteav_effect";
    }

    public static TRTCCloud createInstance(Context context) {
        return new TRTCCloudImpl(context, false);
    }

    public static void destroyInstance(TRTCCloud tRTCCloud) {
        if (tRTCCloud instanceof TRTCCloudImpl) {
            ((TRTCCloudImpl) tRTCCloud).b();
        } else {
            LiteavLog.w("TRTCCloudImpl", "destroyInstance trtcCloud=".concat(String.valueOf(tRTCCloud)));
        }
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void ConnectOtherRoom(String str) {
        this.f119150e.connectOtherRoom(str);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void DisconnectOtherRoom() {
        this.f119150e.disconnectOtherRoom();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void addListener(TRTCCloudListener tRTCCloudListener) {
        this.f119150e.addListener(tRTCCloudListener);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public String callExperimentalAPI(String str) {
        return this.f119150e.callExperimentalAPI(str);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public int checkAudioCapabilitySupport(int i3) {
        if (i3 != 2 || !this.f119153h.isLowLatencyEarMonitorSupported()) {
            return 0;
        }
        return 1;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public TRTCCloud createSubCloud() {
        TRTCCloudImpl tRTCCloudImpl;
        synchronized (TRTCCloudImpl.class) {
            tRTCCloudImpl = new TRTCCloudImpl(ContextUtils.getApplicationContext(), this.f119150e.getTrtcCloudJni());
            this.f119156k.add(tRTCCloudImpl);
        }
        return tRTCCloudImpl;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void destroySubCloud(TRTCCloud tRTCCloud) {
        synchronized (TRTCCloudImpl.class) {
            if (tRTCCloud instanceof TRTCCloudImpl) {
                LiteavLog.i("TRTCCloudImpl", "destructor destroySubCloud");
                ((TRTCCloudImpl) tRTCCloud).b();
                this.f119156k.remove(tRTCCloud);
            }
        }
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enable3DSpatialAudioEffect(boolean z16) {
        this.f119150e.enable3DSpatialAudioEffect(z16);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void enableAudioEarMonitoring(boolean z16) {
        this.f119152g.enableVoiceEarMonitor(z16);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableAudioVolumeEvaluation(boolean z16, TRTCCloudDef.TRTCAudioVolumeEvaluateParams tRTCAudioVolumeEvaluateParams) {
        this.f119150e.enableAudioVolumeEvaluation(z16, tRTCAudioVolumeEvaluateParams);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableCustomAudioCapture(boolean z16) {
        this.f119150e.enableCustomAudioCapture(z16);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableCustomAudioRendering(boolean z16) {
        this.f119150e.enableCustomAudioRendering(z16);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableCustomVideoCapture(int i3, boolean z16) {
        this.f119150e.enableCustomVideoCapture(i3, z16);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int enableEncSmallVideoStream(boolean z16, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        return this.f119150e.enableEncSmallVideoStream(z16, tRTCVideoEncParam);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableMixExternalAudioFrame(boolean z16, boolean z17) {
        this.f119150e.enableMixExternalAudioFrame(z16, z17);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int enablePayloadPrivateEncryption(boolean z16, TRTCCloudDef.TRTCPayloadPrivateEncryptionConfig tRTCPayloadPrivateEncryptionConfig) {
        return this.f119150e.enablePayloadPrivateEncryption(z16, tRTCPayloadPrivateEncryptionConfig);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean enableTorch(boolean z16) {
        return this.f119153h.enableCameraTorch(z16);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enterRoom(TRTCCloudDef.TRTCParams tRTCParams, int i3) {
        this.f119150e.enterRoom(tRTCParams, i3);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void exitRoom() {
        this.f119150e.exitRoom();
        try {
            File file = new File(c());
            if (file.exists() && file.isDirectory() && e.a(file, 5) > IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (Exception e16) {
            LiteavLog.w("TRTCCloudImpl", "clearCache error " + e16.toString());
        }
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int getAudioCaptureVolume() {
        return this.f119150e.getAudioCaptureVolume();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public TXAudioEffectManager getAudioEffectManager() {
        return this.f119152g;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int getAudioPlayoutVolume() {
        return this.f119150e.getAudioPlayoutVolume();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public int getBGMDuration(String str) {
        return (int) this.f119152g.getMusicDurationInMS(str);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public TXBeautyManager getBeautyManager() {
        return this.f119154i;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void getCustomAudioRenderingFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        if (tRTCAudioFrame == null) {
            return;
        }
        this.f119150e.getCustomAudioRenderingFrame(tRTCAudioFrame);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public TXDeviceManager getDeviceManager() {
        return this.f119153h;
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean isCameraAutoFocusFaceModeSupported() {
        return this.f119153h.isCameraAutoFocusFaceModeSupported();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean isCameraFocusPositionInPreviewSupported() {
        return this.f119153h.isCameraFocusPositionInPreviewSupported();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean isCameraTorchSupported() {
        return this.f119153h.isCameraTorchSupported();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean isCameraZoomSupported() {
        return this.f119153h.isCameraZoomSupported();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int mixExternalAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        if (tRTCAudioFrame == null) {
            return -1;
        }
        return this.f119150e.mixExternalAudioFrame(tRTCAudioFrame);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteAllRemoteAudio(boolean z16) {
        this.f119150e.muteAllRemoteAudio(z16);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteAllRemoteVideoStreams(boolean z16) {
        this.f119150e.muteAllRemoteVideoStreams(z16);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteLocalAudio(boolean z16) {
        this.f119150e.muteLocalAudio(z16);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteLocalVideo(int i3, boolean z16) {
        this.f119150e.muteLocalVideo(i3, z16);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteRemoteAudio(String str, boolean z16) {
        this.f119150e.muteRemoteAudio(str, z16);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteRemoteVideoStream(String str, int i3, boolean z16) {
        this.f119150e.muteRemoteVideoStream(str, i3, z16);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onComplete(int i3, int i16) {
        TRTCCloud.BGMNotify bGMNotify = this.f119151f;
        if (bGMNotify != null) {
            bGMNotify.onBGMComplete(i16);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onPlayProgress(int i3, long j3, long j16) {
        TRTCCloud.BGMNotify bGMNotify = this.f119151f;
        if (bGMNotify != null) {
            bGMNotify.onBGMProgress(j3, j16);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onStart(int i3, int i16) {
        TRTCCloud.BGMNotify bGMNotify = this.f119151f;
        if (bGMNotify != null) {
            bGMNotify.onBGMStart(i16);
        }
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void pauseAudioEffect(int i3) {
        this.f119152g.pauseAudioEffect(i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void pauseBGM() {
        this.f119152g.pausePlayMusic(Integer.MAX_VALUE);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void pauseScreenCapture() {
        this.f119150e.pauseScreenCapture(this.f119155j);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void playAudioEffect(TRTCCloudDef.TRTCAudioEffectParam tRTCAudioEffectParam) {
        if (tRTCAudioEffectParam == null) {
            return;
        }
        final int i3 = tRTCAudioEffectParam.effectId;
        TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(i3, b(tRTCAudioEffectParam.path));
        audioMusicParam.publish = tRTCAudioEffectParam.publish;
        audioMusicParam.loopCount = tRTCAudioEffectParam.loopCount;
        audioMusicParam.isShortFile = true;
        this.f119152g.playAudioEffect(audioMusicParam);
        this.f119152g.setEffectObserver(i3, new TXAudioEffectManager.TXMusicPlayObserver() { // from class: com.tencent.liteav.trtc.TRTCCloudImpl.1
            @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
            public final void onComplete(int i16, int i17) {
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.f119149d;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onAudioEffectFinished(i3, i17);
                }
            }

            @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
            public final void onStart(int i16, int i17) {
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.f119149d;
                if (tRTCCloudListener != null && i17 < 0) {
                    tRTCCloudListener.onAudioEffectFinished(i3, i17);
                }
            }

            @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
            public final void onPlayProgress(int i16, long j3, long j16) {
            }
        });
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void playBGM(String str, TRTCCloud.BGMNotify bGMNotify) {
        this.f119151f = bGMNotify;
        TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(Integer.MAX_VALUE, str);
        audioMusicParam.publish = true;
        audioMusicParam.loopCount = 0;
        this.f119152g.setMusicObserver(Integer.MAX_VALUE, this);
        this.f119152g.startPlayMusic(audioMusicParam);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void removeListener(TRTCCloudListener tRTCCloudListener) {
        this.f119150e.removeListener(tRTCCloudListener);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void resumeAudioEffect(int i3) {
        this.f119152g.resumeAudioEffect(i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void resumeBGM() {
        this.f119152g.resumePlayMusic(Integer.MAX_VALUE);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void resumeScreenCapture() {
        this.f119150e.resumeScreenCapture(this.f119155j);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void selectMotionTmpl(String str) {
        this.f119154i.setMotionTmpl(str);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        if (tRTCAudioFrame == null) {
            return;
        }
        this.f119150e.sendCustomAudioData(tRTCAudioFrame);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public boolean sendCustomCmdMsg(int i3, byte[] bArr, boolean z16, boolean z17) {
        if (bArr == null) {
            LiteavLog.w("TRTCCloudImpl", "custom msg data is null.");
            return false;
        }
        return this.f119150e.sendCustomCmdMsg(i3, bArr, z16, z17);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void sendCustomVideoData(int i3, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        if (tRTCVideoFrame == null) {
            LiteavLog.w("TRTCCloudImpl", "sendCustomVideoData frame is null");
            return;
        }
        if (tRTCVideoFrame.bufferType == 3) {
            GLES20.glFinish();
        }
        this.f119150e.sendCustomVideoData(i3, tRTCVideoFrame);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public boolean sendSEIMsg(byte[] bArr, int i3) {
        if (bArr != null && i3 != 0) {
            return this.f119150e.sendSEIMsg(bArr, i3);
        }
        LiteavLog.w("TRTCCloudImpl", "sei msg data is null or repeatCount is zero.");
        return false;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void set3DSpatialReceivingRange(String str, int i3) {
        this.f119150e.set3DSpatialReceivingRange(str, i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setAllAudioEffectsVolume(int i3) {
        this.f119152g.setAllAudioEffectsVolume(i3);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAudioCaptureVolume(int i3) {
        this.f119150e.setAudioCaptureVolume(i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setAudioEffectVolume(int i3, int i16) {
        this.f119152g.setAudioEffectVolume(i3, i16);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener) {
        this.f119150e.setAudioFrameListener(tRTCAudioFrameListener);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAudioPlayoutVolume(int i3) {
        this.f119150e.setAudioPlayoutVolume(i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setAudioQuality(int i3) {
        this.f119150e.setAudioQuality(i3);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAudioRoute(int i3) {
        this.f119153h.setAudioRoute(TXDeviceManagerImpl.audioRouteFromInt(i3));
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setBGMPlayoutVolume(int i3) {
        this.f119152g.setMusicPlayoutVolume(Integer.MAX_VALUE, i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public int setBGMPosition(int i3) {
        this.f119152g.seekMusicToPosInMS(Integer.MAX_VALUE, i3);
        return 0;
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setBGMPublishVolume(int i3) {
        this.f119152g.setMusicPublishVolume(Integer.MAX_VALUE, i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setBGMVolume(int i3) {
        this.f119152g.setMusicPlayoutVolume(Integer.MAX_VALUE, i3);
        this.f119152g.setMusicPublishVolume(Integer.MAX_VALUE, i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setBeautyStyle(int i3, int i16, int i17, int i18) {
        this.f119154i.setBeautyStyle(i3);
        this.f119154i.setBeautyLevel(i16);
        this.f119154i.setWhitenessLevel(i17);
        this.f119154i.setRuddyLevel(i18);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setCapturedAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat) {
        if (tRTCAudioFrameCallbackFormat == null) {
            return -1;
        }
        return this.f119150e.setCapturedAudioFrameCallbackFormat(tRTCAudioFrameCallbackFormat.sampleRate, tRTCAudioFrameCallbackFormat.channel, tRTCAudioFrameCallbackFormat.samplesPerCall, tRTCAudioFrameCallbackFormat.mode);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setChinLevel(int i3) {
        this.f119154i.setChinLevel(i3);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setDefaultStreamRecvMode(boolean z16, boolean z17) {
        this.f119150e.setDefaultStreamRecvMode(z16, z17);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setEyeScaleLevel(int i3) {
        this.f119154i.setEyeScaleLevel(i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setFaceShortLevel(int i3) {
        this.f119154i.setFaceShortLevel(i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setFaceSlimLevel(int i3) {
        this.f119154i.setFaceSlimLevel(i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setFaceVLevel(int i3) {
        this.f119154i.setFaceVLevel(i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setFilter(Bitmap bitmap) {
        this.f119154i.setFilter(bitmap);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setFilterConcentration(float f16) {
        this.f119154i.setFilterStrength(f16);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setFocusPosition(int i3, int i16) {
        this.f119153h.setCameraFocusPosition(i3, i16);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setGSensorMode(int i3) {
        this.f119150e.setGSensorMode(0, i3);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setGravitySensorAdaptiveMode(int i3) {
        this.f119150e.setGravitySensorAdaptiveMode(i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean setGreenScreenFile(String str) {
        return false;
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setListener(TRTCCloudListener tRTCCloudListener) {
        Log.d("TRTCCloudImpl", "setListener ".concat(String.valueOf(tRTCCloudListener)), new Object[0]);
        this.f119149d = tRTCCloudListener;
        this.f119150e.setListener(tRTCCloudListener);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setListenerHandler(Handler handler) {
        this.f119150e.setListenerHandler(handler);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setLocalProcessedAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat) {
        if (tRTCAudioFrameCallbackFormat == null) {
            return -1;
        }
        return this.f119150e.setLocalProcessedAudioFrameCallbackFormat(tRTCAudioFrameCallbackFormat.sampleRate, tRTCAudioFrameCallbackFormat.channel, tRTCAudioFrameCallbackFormat.samplesPerCall, tRTCAudioFrameCallbackFormat.mode);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setLocalRenderParams(TRTCCloudDef.TRTCRenderParams tRTCRenderParams) {
        setLocalViewFillMode(tRTCRenderParams.fillMode);
        setLocalViewRotation(tRTCRenderParams.rotation);
        setLocalViewMirror(tRTCRenderParams.mirrorType);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setLocalVideoProcessListener(int i3, int i16, TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener) {
        return this.f119150e.setLocalVideoProcessListener(0, i3, i16, tRTCVideoFrameListener);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setLocalVideoRenderListener(int i3, int i16, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        return this.f119150e.setLocalVideoRenderListener(i3, i16, tRTCVideoRenderListener);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setLocalViewFillMode(int i3) {
        this.f119150e.setLocalViewFillMode(i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setLocalViewMirror(int i3) {
        this.f119150e.setLocalViewMirror(i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setLocalViewRotation(int i3) {
        this.f119150e.setLocalViewRotation(b(i3));
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setMicVolumeOnMixing(int i3) {
        this.f119152g.setVoiceCaptureVolume(i3);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setMixExternalAudioVolume(int i3, int i16) {
        this.f119150e.setMixExternalAudioVolume(i3, i16);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
        this.f119150e.setMixTranscodingConfig(tRTCTranscodingConfig);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setMixedPlayAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat) {
        if (tRTCAudioFrameCallbackFormat == null) {
            return -1;
        }
        return this.f119150e.setMixedPlayAudioFrameCallbackFormat(tRTCAudioFrameCallbackFormat.sampleRate, tRTCAudioFrameCallbackFormat.channel, tRTCAudioFrameCallbackFormat.samplesPerCall, tRTCAudioFrameCallbackFormat.mode);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setMotionMute(boolean z16) {
        this.f119154i.setMotionMute(z16);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam) {
        this.f119150e.setNetworkQosParam(tRTCNetworkQosParam);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setNoseSlimLevel(int i3) {
        this.f119154i.setNoseSlimLevel(i3);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setPerspectiveCorrectionPoints(String str, PointF[] pointFArr, PointF[] pointFArr2) {
        this.f119150e.setPerspectiveCorrectionPoints(str, pointFArr, pointFArr2);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public int setPriorRemoteVideoStreamType(int i3) {
        return this.f119150e.setPriorRemoteVideoStreamType(i3);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setRemoteAudioParallelParams(TRTCCloudDef.TRTCAudioParallelParams tRTCAudioParallelParams) {
        this.f119150e.setRemoteAudioParallelParams(tRTCAudioParallelParams);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setRemoteAudioVolume(String str, int i3) {
        this.f119150e.setRemoteAudioVolume(str, i3);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setRemoteRenderParams(String str, int i3, TRTCCloudDef.TRTCRenderParams tRTCRenderParams) {
        this.f119150e.setRemoteViewFillMode(str, i3, tRTCRenderParams.fillMode);
        this.f119150e.setRemoteViewRotation(str, i3, b(tRTCRenderParams.rotation));
        this.f119150e.setRemoteViewMirror(str, i3, tRTCRenderParams.mirrorType);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setRemoteSubStreamViewFillMode(String str, int i3) {
        this.f119150e.setRemoteViewFillMode(str, 2, i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setRemoteSubStreamViewRotation(String str, int i3) {
        this.f119150e.setRemoteViewRotation(str, 2, b(i3));
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setRemoteVideoRenderListener(String str, int i3, int i16, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        return this.f119150e.setRemoteVideoRenderListener(str, i3, i16, tRTCVideoRenderListener);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setRemoteVideoStreamType(String str, int i3) {
        return this.f119150e.setRemoteVideoStreamType(str, i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setRemoteViewFillMode(String str, int i3) {
        this.f119150e.setRemoteViewFillMode(str, 0, i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setRemoteViewRotation(String str, int i3) {
        this.f119150e.setRemoteViewRotation(str, 0, b(i3));
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setReverbType(int i3) {
        this.f119152g.setVoiceReverbType(TXAudioEffectManagerImpl.voiceReverbTypeFromInt(i3));
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setSubStreamEncoderParam(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        this.f119150e.setVideoEncoderParams(2, tRTCVideoEncParam);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setSystemVolumeType(int i3) {
        this.f119153h.setSystemVolumeType(TXDeviceManagerImpl.systemVolumeTypefromInt(i3));
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setVideoEncoderMirror(boolean z16) {
        this.f119150e.setVideoEncoderMirror(z16);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setVideoEncoderParam(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        if (tRTCVideoEncParam == null) {
            return;
        }
        this.f119150e.setVideoEncoderParams(0, tRTCVideoEncParam);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setVideoEncoderRotation(int i3) {
        this.f119150e.setVideoEncoderRotation(b(i3));
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setVideoMuteImage(Bitmap bitmap, int i3) {
        this.f119150e.setVideoMuteImage(bitmap, i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean setVoiceChangerType(int i3) {
        this.f119152g.setVoiceChangerType(TXAudioEffectManagerImpl.voiceChangerTypeFromInt(i3));
        return true;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setWatermark(Bitmap bitmap, int i3, float f16, float f17, float f18) {
        this.f119150e.setWatermark(bitmap, i3, f16, f17, f18);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setZoom(int i3) {
        this.f119153h.setCameraZoomRatio(i3);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void showDebugView(int i3) {
        this.f119150e.showDashboardManager(i3);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void snapshotVideo(String str, int i3, int i16, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener) {
        this.f119150e.snapshotVideo(str, i3, i16, tRTCSnapshotListener);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams) {
        return this.f119150e.startAudioRecording(tRTCAudioRecordingParams);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startLocalAudio(int i3) {
        this.f119150e.startLocalAudio(i3);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startLocalPreview(boolean z16, TXCloudVideoView tXCloudVideoView) {
        this.f119150e.startLocalPreview(z16, tXCloudVideoView);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startLocalRecording(TRTCCloudDef.TRTCLocalRecordingParams tRTCLocalRecordingParams) {
        this.f119150e.startLocalRecording(tRTCLocalRecordingParams);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
        this.f119150e.startPublishCDNStream(tRTCPublishCDNParam);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startPublishMediaStream(TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
        this.f119150e.startPublishMediaStream(tRTCPublishTarget, tRTCStreamEncoderParam, tRTCStreamMixingConfig);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void startPublishing(String str, int i3) {
        this.f119150e.startPublishing(str, i3);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void startRemoteSubStreamView(String str, TXCloudVideoView tXCloudVideoView) {
        startRemoteView(str, 2, tXCloudVideoView);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startRemoteView(String str, int i3, TXCloudVideoView tXCloudVideoView) {
        this.f119150e.startRemoteView(str, i3, tXCloudVideoView);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startScreenCapture(int i3, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
        this.f119155j = i3;
        this.f119150e.startScreenCapture(i3, tRTCVideoEncParam, tRTCScreenShareParams);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int startSpeedTest(TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams) {
        this.f119150e.startSpeedTest(tRTCSpeedTestParams);
        return 0;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startSystemAudioLoopback() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 29) {
            LiteavLog.e("TRTCCloudImpl", "current system don't support system audio loopback");
        } else {
            this.f119150e.startSystemAudioLoopback();
        }
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void stopAllAudioEffects() {
        this.f119152g.stopAllAudioEffects();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopAllRemoteView() {
        this.f119150e.stopAllRemoteView();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void stopAudioEffect(int i3) {
        this.f119152g.stopAudioEffect(i3);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopAudioRecording() {
        this.f119150e.stopAudioRecording();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void stopBGM() {
        this.f119152g.stopPlayMusic(Integer.MAX_VALUE);
        this.f119152g.setMusicObserver(Integer.MAX_VALUE, null);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopLocalAudio() {
        this.f119150e.stopLocalAudio();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopLocalPreview() {
        this.f119150e.stopLocalPreview();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopLocalRecording() {
        this.f119150e.stopLocalRecording();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void stopPublishCDNStream() {
        this.f119150e.stopPublishCDNStream();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopPublishMediaStream(String str) {
        this.f119150e.stopPublishMediaStream(str);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void stopPublishing() {
        this.f119150e.stopPublishing();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void stopRemoteSubStreamView(String str) {
        stopRemoteView(str, 2);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopRemoteView(String str, int i3) {
        this.f119150e.stopRemoteView(str, i3);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopScreenCapture() {
        this.f119150e.stopScreenCapture(this.f119155j);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopSpeedTest() {
        this.f119150e.stopSpeedTest();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopSystemAudioLoopback() {
        this.f119150e.stopSystemAudioLoopback();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void switchCamera() {
        this.f119153h.switchCamera(!this.f119153h.isFrontCamera());
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void switchRole(int i3) {
        this.f119150e.switchRole(i3);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void switchRoom(TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig) {
        this.f119150e.switchRoom(tRTCSwitchRoomConfig);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void updateLocalView(TXCloudVideoView tXCloudVideoView) {
        this.f119150e.updateLocalView(tXCloudVideoView);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void updateOtherRoomForwardMode(String str) {
        this.f119150e.updateOtherRoomForwardMode(str);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void updatePublishMediaStream(String str, TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
        this.f119150e.updatePublishMediaStream(str, tRTCPublishTarget, tRTCStreamEncoderParam, tRTCStreamMixingConfig);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void updateRemote3DSpatialPosition(String str, int[] iArr) {
        this.f119150e.updateRemote3DSpatialPosition(str, iArr);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void updateRemoteView(String str, int i3, TXCloudVideoView tXCloudVideoView) {
        this.f119150e.updateRemoteView(str, i3, tXCloudVideoView);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void updateSelf3DSpatialPosition(int[] iArr, float[] fArr, float[] fArr2, float[] fArr3) {
        this.f119150e.updateSelf3DSpatialPosition(iArr, fArr, fArr2, fArr3);
    }

    public static TRTCCloud a(Context context) {
        TRTCCloudImpl tRTCCloudImpl;
        synchronized (TRTCCloudImpl.class) {
            if (f119147b == null) {
                f119147b = new TRTCCloudImpl(context, true);
            }
            tRTCCloudImpl = f119147b;
        }
        return tRTCCloudImpl;
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void enableAudioVolumeEvaluation(int i3, boolean z16) {
        TRTCCloudDef.TRTCAudioVolumeEvaluateParams tRTCAudioVolumeEvaluateParams = new TRTCCloudDef.TRTCAudioVolumeEvaluateParams();
        tRTCAudioVolumeEvaluateParams.interval = i3;
        tRTCAudioVolumeEvaluateParams.enableVadDetection = z16;
        tRTCAudioVolumeEvaluateParams.enablePitchCalculation = false;
        tRTCAudioVolumeEvaluateParams.enableSpectrumCalculation = false;
        enableAudioVolumeEvaluation(true, tRTCAudioVolumeEvaluateParams);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void enableCustomVideoCapture(boolean z16) {
        enableCustomVideoCapture(0, z16);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void muteLocalVideo(boolean z16) {
        this.f119150e.muteLocalVideo(0, z16);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void muteRemoteVideoStream(String str, boolean z16) {
        muteRemoteVideoStream(str, 0, z16);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void snapshotVideo(String str, int i3, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener) {
        this.f119150e.snapshotVideo(str, i3, 1, tRTCSnapshotListener);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void startLocalAudio() {
        this.f119150e.startLocalAudio();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void startRemoteView(String str, TXCloudVideoView tXCloudVideoView) {
        this.f119150e.startRemoteView(str, tXCloudVideoView);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void startSpeedTest(int i3, String str, String str2) {
        this.f119150e.startSpeedTest(i3, str, str2);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void stopRemoteView(String str) {
        this.f119150e.stopRemoteView(str);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void switchRole(int i3, String str) {
        this.f119150e.switchRole(i3, str);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void startScreenCapture(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
        this.f119155j = 0;
        startScreenCapture(0, tRTCVideoEncParam, tRTCScreenShareParams);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void sendCustomVideoData(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        sendCustomVideoData(0, tRTCVideoFrame);
    }

    TRTCCloudImpl(Context context, long j3) {
        b(context);
        this.f119148c = context;
        a(context, j3, false);
    }

    public static void a() {
        synchronized (TRTCCloudImpl.class) {
            if (f119147b != null) {
                LiteavLog.i("TRTCCloudImpl", "destructor destroySharedInstance");
                Iterator<TRTCCloudImpl> it = f119147b.f119156k.iterator();
                while (it.hasNext()) {
                    it.next().b();
                }
                f119147b.b();
                f119147b = null;
            }
        }
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void enableAudioVolumeEvaluation(int i3) {
        enableAudioVolumeEvaluation(i3, false);
    }

    private void b() {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.f119154i;
        if (tXBeautyManagerImpl != null) {
            tXBeautyManagerImpl.clear();
        }
        this.f119150e.destroy();
    }

    public static void b(boolean z16) {
        TrtcCloudJni.setLogCompressEnabled(z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c3 A[Catch: Exception -> 0x0114, TRY_LEAVE, TryCatch #8 {Exception -> 0x0114, blocks: (B:11:0x0042, B:13:0x0051, B:14:0x0061, B:17:0x006e, B:18:0x00a8, B:20:0x00ae, B:22:0x00b9, B:26:0x00c3, B:35:0x00d6, B:36:0x00d9, B:37:0x00dc, B:42:0x00fe, B:44:0x0103, B:50:0x0108, B:55:0x010d, B:52:0x0113, B:67:0x008e, B:68:0x0055, B:70:0x005b, B:73:0x002a, B:10:0x001a), top: B:9:0x001a, inners: #4 }] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v24, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(String str) {
        long j3;
        Throwable th5;
        FileOutputStream fileOutputStream;
        IOException e16;
        if (TextUtils.isEmpty(str) || !str.startsWith("/assets/")) {
            return str;
        }
        ?? substring = str.substring(8);
        try {
            try {
                j3 = this.f119148c.getAssets().openFd(substring).getLength();
            } catch (Exception e17) {
                LiteavLog.e("TRTCCloudImpl", "playAudioEffect error " + e17.toString());
            }
        } catch (Exception e18) {
            LiteavLog.e("TRTCCloudImpl", "playAudioEffect openFd error " + e18.toString());
            j3 = 0;
        }
        String c16 = c();
        File file = new File(c16);
        if (!file.exists()) {
            file.mkdirs();
        } else if (file.isFile()) {
            file.delete();
            file.mkdirs();
        }
        int lastIndexOf = substring.lastIndexOf(File.separatorChar);
        boolean z16 = true;
        if (lastIndexOf != -1) {
            str = c16 + File.separator + j3 + "_" + substring.substring(lastIndexOf + 1);
        } else {
            str = c16 + File.separator + j3 + "_" + substring;
        }
        if (!TextUtils.isEmpty(str)) {
            File file2 = new File(str);
            if (file2.exists() && file2.isFile()) {
                if (!z16) {
                    ?? assets = this.f119148c.getAssets();
                    try {
                        try {
                            try {
                                substring = assets.open(substring);
                            } catch (IOException e19) {
                                fileOutputStream = null;
                                e16 = e19;
                                substring = 0;
                            } catch (Throwable th6) {
                                assets = 0;
                                th5 = th6;
                                substring = 0;
                            }
                            try {
                                fileOutputStream = new FileOutputStream(str);
                            } catch (IOException e26) {
                                e16 = e26;
                                fileOutputStream = null;
                            } catch (Throwable th7) {
                                th5 = th7;
                                assets = 0;
                                e.a(substring);
                                if (assets != 0) {
                                    try {
                                        assets.flush();
                                        assets.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                throw th5;
                            }
                            try {
                                e.a((InputStream) substring, fileOutputStream);
                                e.a(substring);
                                fileOutputStream.flush();
                                substring = substring;
                                assets = fileOutputStream;
                            } catch (IOException e27) {
                                e16 = e27;
                                LiteavLog.e("FileUtil", "copy asset file failed.", e16);
                                e.a(substring);
                                if (fileOutputStream != null) {
                                    fileOutputStream.flush();
                                    substring = substring;
                                    assets = fileOutputStream;
                                    assets.close();
                                }
                                return str;
                            }
                            assets.close();
                        } catch (Throwable th8) {
                            th5 = th8;
                        }
                    } catch (IOException unused2) {
                    }
                }
                return str;
            }
        }
        z16 = false;
        if (!z16) {
        }
        return str;
    }

    private void a(Context context, long j3, boolean z16) {
        this.f119148c = context.getApplicationContext();
        if (j3 == 0) {
            this.f119150e = new TrtcCloudJni(z16);
        } else {
            this.f119150e = new TrtcCloudJni(j3, z16);
        }
        this.f119153h = new TXDeviceManagerImpl(this.f119150e.createDeviceManager());
        this.f119152g = new TXAudioEffectManagerImpl(this.f119150e.createAudioEffectManager());
        this.f119154i = new TXBeautyManagerImpl(this.f119150e.createBeautyManager());
    }

    public static void a(int i3) {
        TrtcCloudJni.setLogLevel(i3);
    }

    public static void a(boolean z16) {
        TrtcCloudJni.setConsoleEnabled(z16);
    }

    public static void a(String str) {
        TrtcCloudJni.setLogDirPath(str);
    }

    private static int b(int i3) {
        if (i3 < 0) {
            return 0;
        }
        return i3 > 3 ? (i3 / 90) % 4 : i3;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setDebugViewMargin(String str, TRTCCloud.TRTCViewMargin tRTCViewMargin) {
    }
}
