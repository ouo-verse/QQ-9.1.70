package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.SoLoader;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.live.TXLivePusherJni;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;

/* loaded from: classes25.dex */
public class TXLivePusher implements b {
    static IPatchRedirector $redirector_ = null;
    public static final int RGB_BGRA = 4;
    public static final int RGB_RGBA = 5;
    private static final String TAG = "TXLivePusher";
    public static final int YUV_420P = 3;
    public static final int YUV_420SP = 1;
    public static final int YUV_420YpCbCr = 2;
    private b mImpl;

    /* loaded from: classes25.dex */
    public interface AudioCustomProcessListener {
        void onRecordPcmData(byte[] bArr, long j3, int i3, int i16, int i17);

        void onRecordRawPcmData(byte[] bArr, long j3, int i3, int i16, int i17, boolean z16);
    }

    /* loaded from: classes25.dex */
    public interface ITXAudioVolumeEvaluationListener {
        void onAudioVolumeEvaluationNotify(int i3);
    }

    /* loaded from: classes25.dex */
    public interface ITXSnapshotListener {
        void onSnapshot(Bitmap bitmap);
    }

    @Deprecated
    /* loaded from: classes25.dex */
    public interface OnBGMNotify {
        void onBGMComplete(int i3);

        void onBGMProgress(long j3, long j16);

        void onBGMStart();
    }

    /* loaded from: classes25.dex */
    public interface VideoCustomProcessListener {
        void onDetectFacePoints(float[] fArr);

        int onTextureCustomProcess(int i3, int i16, int i17);

        void onTextureDestoryed();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22505);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 68)) {
            redirector.redirect((short) 68);
        } else {
            SoLoader.loadAllLibraries();
        }
    }

    public TXLivePusher(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mImpl = new TXLivePusherJni(context);
        LiteavLog.i(TAG, "Create instance:" + this.mImpl.toString());
    }

    @Override // com.tencent.rtmp.b
    public synchronized void callExperimentalAPI(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) str);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.callExperimentalAPI(str);
    }

    @Override // com.tencent.rtmp.b
    public synchronized void enableAudioVolumeEvaluation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, i3);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.enableAudioVolumeEvaluation(i3);
    }

    @Override // com.tencent.rtmp.b
    public synchronized TXAudioEffectManager getAudioEffectManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (TXAudioEffectManager) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return null;
        }
        return bVar.getAudioEffectManager();
    }

    @Override // com.tencent.rtmp.b
    public synchronized TXBeautyManager getBeautyManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (TXBeautyManager) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return null;
        }
        return bVar.getBeautyManager();
    }

    @Override // com.tencent.rtmp.b
    public synchronized TXLivePushConfig getConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TXLivePushConfig) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return new TXLivePushConfig();
        }
        return bVar.getConfig();
    }

    @Override // com.tencent.rtmp.b
    public synchronized int getMaxZoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return 0;
        }
        return bVar.getMaxZoom();
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized int getMusicDuration(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return ((Integer) iPatchRedirector.redirect((short) 60, (Object) this, (Object) str)).intValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return 0;
        }
        return bVar.getMusicDuration(str);
    }

    @Override // com.tencent.rtmp.b
    public synchronized boolean isPushing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.isPushing();
    }

    @Override // com.tencent.rtmp.b
    public synchronized void onLogRecord(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) str);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.onLogRecord(str);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized boolean pauseBGM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Boolean) iPatchRedirector.redirect((short) 58, (Object) this)).booleanValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.pauseBGM();
    }

    @Override // com.tencent.rtmp.b
    public synchronized void pausePusher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.pausePusher();
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized boolean playBGM(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Boolean) iPatchRedirector.redirect((short) 56, (Object) this, (Object) str)).booleanValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.playBGM(str);
    }

    @Override // com.tencent.rtmp.b
    public synchronized void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.release();
        LiteavLog.i(TAG, "Release instance:" + this.mImpl.toString());
        this.mImpl = null;
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized boolean resumeBGM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Boolean) iPatchRedirector.redirect((short) 59, (Object) this)).booleanValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.resumeBGM();
    }

    @Override // com.tencent.rtmp.b
    public synchronized void resumePusher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.resumePusher();
    }

    @Override // com.tencent.rtmp.b
    public synchronized void sendCustomPCMData(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) bArr);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.sendCustomPCMData(bArr);
    }

    @Override // com.tencent.rtmp.b
    public synchronized int sendCustomVideoData(byte[] bArr, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Integer) iPatchRedirector.redirect((short) 45, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).intValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return -1;
        }
        return bVar.sendCustomVideoData(bArr, i3, i16, i17);
    }

    @Override // com.tencent.rtmp.b
    public synchronized int sendCustomVideoTexture(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Integer) iPatchRedirector.redirect((short) 44, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).intValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return -1;
        }
        return bVar.sendCustomVideoTexture(i3, i16, i17);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized void sendMessage(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) bArr);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.sendMessage(bArr);
    }

    @Override // com.tencent.rtmp.b
    public synchronized boolean sendMessageEx(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Boolean) iPatchRedirector.redirect((short) 51, (Object) this, (Object) bArr)).booleanValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.sendMessageEx(bArr);
    }

    @Override // com.tencent.rtmp.b
    public synchronized void setAudioProcessListener(AudioCustomProcessListener audioCustomProcessListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) audioCustomProcessListener);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setAudioProcessListener(audioCustomProcessListener);
    }

    @Override // com.tencent.rtmp.b
    public synchronized void setAudioVolumeEvaluationListener(ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) iTXAudioVolumeEvaluationListener);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setAudioVolumeEvaluationListener(iTXAudioVolumeEvaluationListener);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized void setBGMNofify(OnBGMNotify onBGMNotify) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) onBGMNotify);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setBGMNofify(onBGMNotify);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized void setBGMPitch(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, this, Float.valueOf(f16));
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setBGMPitch(f16);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized boolean setBGMPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Boolean) iPatchRedirector.redirect((short) 66, (Object) this, i3)).booleanValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.setBGMPosition(i3);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized boolean setBGMVolume(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return ((Boolean) iPatchRedirector.redirect((short) 61, this, Float.valueOf(f16))).booleanValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.setBGMVolume(f16);
    }

    @Override // com.tencent.rtmp.b
    public synchronized boolean setBeautyFilter(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18))).booleanValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.setBeautyFilter(i3, i16, i17, i18);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized void setChinLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setChinLevel(i3);
    }

    @Override // com.tencent.rtmp.b
    public synchronized void setConfig(TXLivePushConfig tXLivePushConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tXLivePushConfig);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setConfig(tXLivePushConfig);
    }

    @Override // com.tencent.rtmp.b
    public synchronized void setExposureCompensation(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Float.valueOf(f16));
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setExposureCompensation(f16);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized void setEyeScaleLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setEyeScaleLevel(i3);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized void setFaceShortLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setFaceShortLevel(i3);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized void setFaceSlimLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setFaceSlimLevel(i3);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized void setFaceVLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setFaceVLevel(i3);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized void setFilter(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) bitmap);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setFilter(bitmap);
    }

    @Override // com.tencent.rtmp.b
    public synchronized void setFocusPosition(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setFocusPosition(f16, f17);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized boolean setGreenScreenFile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, (Object) str)).booleanValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.setGreenScreenFile(str);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized boolean setMicVolume(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return ((Boolean) iPatchRedirector.redirect((short) 62, this, Float.valueOf(f16))).booleanValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.setMicVolume(f16);
    }

    @Override // com.tencent.rtmp.b
    public synchronized boolean setMirror(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, z16)).booleanValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.setMirror(z16);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized void setMotionMute(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, z16);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setMotionMute(z16);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized void setMotionTmpl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) str);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setMotionTmpl(str);
    }

    @Override // com.tencent.rtmp.b
    public synchronized void setMute(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, z16);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setMute(z16);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized void setNoseSlimLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setNoseSlimLevel(i3);
    }

    @Override // com.tencent.rtmp.b
    public synchronized void setPushListener(ITXLivePushListener iTXLivePushListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iTXLivePushListener);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setPushListener(iTXLivePushListener);
    }

    @Override // com.tencent.rtmp.b
    public synchronized void setRenderRotation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setRenderRotation(i3);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized void setReverb(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, i3);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setReverb(i3);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized void setSpecialRatio(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Float.valueOf(f16));
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setSpecialRatio(f16);
    }

    @Override // com.tencent.rtmp.b
    public synchronized void setSurface(Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) surface);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setSurface(surface);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized void setSurfaceSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setSurfaceSize(i3, i16);
    }

    @Override // com.tencent.rtmp.b
    public synchronized void setVideoProcessListener(VideoCustomProcessListener videoCustomProcessListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) videoCustomProcessListener);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setVideoProcessListener(videoCustomProcessListener);
    }

    @Override // com.tencent.rtmp.b
    public synchronized void setVideoQuality(int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setVideoQuality(i3, z16, z17);
    }

    @Override // com.tencent.rtmp.b
    public synchronized void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) iTXVideoRecordListener);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setVideoRecordListener(iTXVideoRecordListener);
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized void setVoiceChangerType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, i3);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.setVoiceChangerType(i3);
    }

    @Override // com.tencent.rtmp.b
    public synchronized boolean setZoom(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, i3)).booleanValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.setZoom(i3);
    }

    @Override // com.tencent.rtmp.b
    public synchronized void snapshot(ITXSnapshotListener iTXSnapshotListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) iTXSnapshotListener);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.snapshot(iTXSnapshotListener);
    }

    @Override // com.tencent.rtmp.b
    public synchronized void startCameraPreview(TXCloudVideoView tXCloudVideoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) tXCloudVideoView);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.startCameraPreview(tXCloudVideoView);
    }

    @Override // com.tencent.rtmp.b
    public synchronized int startPusher(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).intValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return -1;
        }
        return bVar.startPusher(str);
    }

    @Override // com.tencent.rtmp.b
    public synchronized int startRecord(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this, (Object) str)).intValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return -3;
        }
        return bVar.startRecord(str);
    }

    @Override // com.tencent.rtmp.b
    public synchronized void startScreenCapture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.startScreenCapture();
    }

    @Override // com.tencent.rtmp.b
    @Deprecated
    public synchronized boolean stopBGM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this)).booleanValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.stopBGM();
    }

    @Override // com.tencent.rtmp.b
    public synchronized void stopCameraPreview(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.stopCameraPreview(z16);
    }

    @Override // com.tencent.rtmp.b
    public synchronized void stopPusher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.stopPusher();
    }

    @Override // com.tencent.rtmp.b
    public synchronized void stopRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.stopRecord();
    }

    @Override // com.tencent.rtmp.b
    public synchronized void stopScreenCapture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.stopScreenCapture();
    }

    @Override // com.tencent.rtmp.b
    public synchronized void switchCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return;
        }
        bVar.switchCamera();
    }

    @Override // com.tencent.rtmp.b
    public synchronized boolean turnOnFlashLight(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, z16)).booleanValue();
        }
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.turnOnFlashLight(z16);
    }
}
