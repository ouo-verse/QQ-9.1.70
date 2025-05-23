package com.tencent.trtc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Handler;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.trtc.TRTCCloudImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class TRTCCloud extends DeprecatedTRTCCloud {
    static IPatchRedirector $redirector_;
    private static a mTXLogListener;
    static WeakReference<TRTCCloud> sInstance;

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes27.dex */
    public interface BGMNotify {
        void onBGMComplete(int i3);

        void onBGMProgress(long j3, long j16);

        void onBGMStart(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCViewMargin {
        static IPatchRedirector $redirector_;
        public float bottomMargin;
        public float leftMargin;
        public float rightMargin;
        public float topMargin;

        public TRTCViewMargin(float f16, float f17, float f18, float f19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
                return;
            }
            this.leftMargin = f16;
            this.topMargin = f18;
            this.rightMargin = f17;
            this.bottomMargin = f19;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    static class a implements LiteavLog.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        TRTCCloudListener.TRTCLogListener f381673a;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f381673a = null;
            }
        }

        @Override // com.tencent.liteav.base.util.LiteavLog.a
        public final void a(int i3, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
                return;
            }
            TRTCCloudListener.TRTCLogListener tRTCLogListener = this.f381673a;
            if (tRTCLogListener != null) {
                tRTCLogListener.onLog(str2, i3, str);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15188);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sInstance = null;
            mTXLogListener = null;
        }
    }

    public TRTCCloud() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void destroySharedInstance() {
        TRTCCloudImpl.a();
    }

    public static long generateCustomPTS() {
        return TimeUtil.a();
    }

    public static String getSDKVersion() {
        return CommonUtil.getSDKVersionStr();
    }

    public static void setConsoleEnabled(boolean z16) {
        TRTCCloudImpl.a(z16);
    }

    public static void setLogCompressEnabled(boolean z16) {
        TRTCCloudImpl.b(z16);
    }

    public static void setLogDirPath(String str) {
        TRTCCloudImpl.a(str);
    }

    public static void setLogLevel(int i3) {
        TRTCCloudImpl.a(i3);
    }

    public static void setLogListener(TRTCCloudListener.TRTCLogListener tRTCLogListener) {
        boolean z16;
        a aVar = mTXLogListener;
        if (aVar != null) {
            aVar.f381673a = null;
        }
        if (tRTCLogListener != null) {
            a aVar2 = new a();
            mTXLogListener = aVar2;
            aVar2.f381673a = tRTCLogListener;
        } else {
            mTXLogListener = null;
        }
        LiteavLog.setCallback(mTXLogListener);
        if (mTXLogListener != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        LiteavLog.nativeSetLogCallbackEnabled(z16);
    }

    public static TRTCCloud sharedInstance(Context context) {
        return TRTCCloudImpl.a(context);
    }

    public abstract void ConnectOtherRoom(String str);

    public abstract void DisconnectOtherRoom();

    public abstract void addListener(TRTCCloudListener tRTCCloudListener);

    public abstract String callExperimentalAPI(String str);

    public abstract TRTCCloud createSubCloud();

    public abstract void destroySubCloud(TRTCCloud tRTCCloud);

    public abstract void enable3DSpatialAudioEffect(boolean z16);

    public abstract void enableAudioVolumeEvaluation(boolean z16, TRTCCloudDef.TRTCAudioVolumeEvaluateParams tRTCAudioVolumeEvaluateParams);

    public abstract void enableCustomAudioCapture(boolean z16);

    public abstract void enableCustomAudioRendering(boolean z16);

    public abstract void enableCustomVideoCapture(int i3, boolean z16);

    public abstract int enableEncSmallVideoStream(boolean z16, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam);

    public abstract void enableMixExternalAudioFrame(boolean z16, boolean z17);

    public abstract int enablePayloadPrivateEncryption(boolean z16, TRTCCloudDef.TRTCPayloadPrivateEncryptionConfig tRTCPayloadPrivateEncryptionConfig);

    public abstract void enterRoom(TRTCCloudDef.TRTCParams tRTCParams, int i3);

    public abstract void exitRoom();

    public abstract int getAudioCaptureVolume();

    public abstract TXAudioEffectManager getAudioEffectManager();

    public abstract int getAudioPlayoutVolume();

    public abstract TXBeautyManager getBeautyManager();

    public abstract void getCustomAudioRenderingFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame);

    public abstract TXDeviceManager getDeviceManager();

    public abstract int mixExternalAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame);

    public abstract void muteAllRemoteAudio(boolean z16);

    public abstract void muteAllRemoteVideoStreams(boolean z16);

    public abstract void muteLocalAudio(boolean z16);

    public abstract void muteLocalVideo(int i3, boolean z16);

    public abstract void muteRemoteAudio(String str, boolean z16);

    public abstract void muteRemoteVideoStream(String str, int i3, boolean z16);

    public abstract void pauseScreenCapture();

    public abstract void removeListener(TRTCCloudListener tRTCCloudListener);

    public abstract void resumeScreenCapture();

    public abstract void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame);

    public abstract boolean sendCustomCmdMsg(int i3, byte[] bArr, boolean z16, boolean z17);

    public abstract void sendCustomVideoData(int i3, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame);

    public abstract boolean sendSEIMsg(byte[] bArr, int i3);

    public abstract void set3DSpatialReceivingRange(String str, int i3);

    public abstract void setAudioCaptureVolume(int i3);

    public abstract void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener);

    public abstract void setAudioPlayoutVolume(int i3);

    public abstract void setAudioRoute(int i3);

    public abstract int setCapturedAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat);

    public abstract void setDebugViewMargin(String str, TRTCViewMargin tRTCViewMargin);

    public abstract void setDefaultStreamRecvMode(boolean z16, boolean z17);

    public abstract void setGravitySensorAdaptiveMode(int i3);

    public abstract void setListenerHandler(Handler handler);

    public abstract int setLocalProcessedAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat);

    public abstract void setLocalRenderParams(TRTCCloudDef.TRTCRenderParams tRTCRenderParams);

    public abstract int setLocalVideoProcessListener(int i3, int i16, TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener);

    public abstract int setLocalVideoRenderListener(int i3, int i16, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener);

    public abstract void setMixExternalAudioVolume(int i3, int i16);

    public abstract int setMixedPlayAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat);

    public abstract void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam);

    public abstract void setPerspectiveCorrectionPoints(String str, PointF[] pointFArr, PointF[] pointFArr2);

    public abstract void setRemoteAudioParallelParams(TRTCCloudDef.TRTCAudioParallelParams tRTCAudioParallelParams);

    public abstract void setRemoteAudioVolume(String str, int i3);

    public abstract void setRemoteRenderParams(String str, int i3, TRTCCloudDef.TRTCRenderParams tRTCRenderParams);

    public abstract int setRemoteVideoRenderListener(String str, int i3, int i16, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener);

    public abstract int setRemoteVideoStreamType(String str, int i3);

    public abstract void setSubStreamEncoderParam(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam);

    public abstract void setVideoEncoderParam(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam);

    public abstract void setVideoMuteImage(Bitmap bitmap, int i3);

    public abstract void setWatermark(Bitmap bitmap, int i3, float f16, float f17, float f18);

    public abstract void showDebugView(int i3);

    public abstract void snapshotVideo(String str, int i3, int i16, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener);

    public abstract int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams);

    public abstract void startLocalAudio(int i3);

    public abstract void startLocalPreview(boolean z16, TXCloudVideoView tXCloudVideoView);

    public abstract void startLocalRecording(TRTCCloudDef.TRTCLocalRecordingParams tRTCLocalRecordingParams);

    public abstract void startPublishMediaStream(TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig);

    public abstract void startRemoteView(String str, int i3, TXCloudVideoView tXCloudVideoView);

    public abstract void startScreenCapture(int i3, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams);

    public abstract int startSpeedTest(TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams);

    public abstract void startSystemAudioLoopback();

    public abstract void stopAllRemoteView();

    public abstract void stopAudioRecording();

    public abstract void stopLocalAudio();

    public abstract void stopLocalPreview();

    public abstract void stopLocalRecording();

    public abstract void stopPublishMediaStream(String str);

    public abstract void stopRemoteView(String str, int i3);

    public abstract void stopScreenCapture();

    public abstract void stopSpeedTest();

    public abstract void stopSystemAudioLoopback();

    public abstract void switchRole(int i3);

    public abstract void switchRole(int i3, String str);

    public abstract void switchRoom(TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig);

    public abstract void updateLocalView(TXCloudVideoView tXCloudVideoView);

    public abstract void updateOtherRoomForwardMode(String str);

    public abstract void updatePublishMediaStream(String str, TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig);

    public abstract void updateRemote3DSpatialPosition(String str, int[] iArr);

    public abstract void updateRemoteView(String str, int i3, TXCloudVideoView tXCloudVideoView);

    public abstract void updateSelf3DSpatialPosition(int[] iArr, float[] fArr, float[] fArr2, float[] fArr3);
}
