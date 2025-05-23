package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.liteav.base.util.SoLoader;
import com.tencent.liteav.live.TXLivePlayerJni;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;

/* loaded from: classes25.dex */
public class TXLivePlayer {
    static IPatchRedirector $redirector_ = null;
    public static final int PLAY_TYPE_LIVE_FLV = 1;
    public static final int PLAY_TYPE_LIVE_HLS = 7;
    public static final int PLAY_TYPE_LIVE_RTMP = 0;
    public static final int PLAY_TYPE_LIVE_RTMP_ACC = 5;
    public static final String TAG = "TXLivePlayer";
    private a mImpl;

    /* loaded from: classes25.dex */
    public interface ITXAudioRawDataListener {
        void onAudioInfoChanged(int i3, int i16, int i17);

        void onPcmDataAvailable(byte[] bArr, long j3);
    }

    /* loaded from: classes25.dex */
    public interface ITXAudioVolumeEvaluationListener {
        void onAudioVolumeEvaluationNotify(int i3);
    }

    /* loaded from: classes25.dex */
    public interface ITXLivePlayVideoRenderListener {
        void onRenderVideoFrame(TXLiteAVTexture tXLiteAVTexture);
    }

    /* loaded from: classes25.dex */
    public interface ITXSnapshotListener {
        void onSnapshot(Bitmap bitmap);
    }

    /* loaded from: classes25.dex */
    public interface ITXVideoRawDataListener {
        void onVideoRawDataAvailable(byte[] bArr, int i3, int i16, int i17);
    }

    /* loaded from: classes25.dex */
    public static class TXLiteAVTexture {
        static IPatchRedirector $redirector_;
        public Object eglContext;
        public int height;
        public int textureId;
        public int width;

        public TXLiteAVTexture() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22582);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
        } else {
            SoLoader.loadAllLibraries();
        }
    }

    public TXLivePlayer(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mImpl = new TXLivePlayerJni(context);
        }
    }

    public void callExperimentalAPI(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        } else {
            this.mImpl.callExperimentalAPI(str);
        }
    }

    public void enableAudioVolumeEvaluation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.mImpl.enableAudioVolumeEvaluation(i3);
        }
    }

    public boolean enableHardwareDecode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, z16)).booleanValue();
        }
        return this.mImpl.enableHardwareDecode(z16);
    }

    public long getCurrentRenderPts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.mImpl.getCurrentRenderPts();
    }

    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.mImpl.isPlaying();
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.mImpl.pause();
        }
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.mImpl.resume();
        }
    }

    public void setAudioRawDataListener(ITXAudioRawDataListener iTXAudioRawDataListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) iTXAudioRawDataListener);
        } else {
            this.mImpl.setAudioRawDataListener(iTXAudioRawDataListener);
        }
    }

    public void setAudioRoute(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.mImpl.setAudioRoute(i3);
        }
    }

    public void setAudioVolumeEvaluationListener(ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) iTXAudioVolumeEvaluationListener);
        } else {
            this.mImpl.setAudioVolumeEvaluationListener(iTXAudioVolumeEvaluationListener);
        }
    }

    public void setConfig(TXLivePlayConfig tXLivePlayConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tXLivePlayConfig);
        } else {
            this.mImpl.setConfig(tXLivePlayConfig);
        }
    }

    public void setMute(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.mImpl.setMute(z16);
        }
    }

    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iTXLivePlayListener);
        } else {
            this.mImpl.setPlayListener(iTXLivePlayListener);
        }
    }

    public void setPlayerView(TXCloudVideoView tXCloudVideoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) tXCloudVideoView);
        } else {
            this.mImpl.setPlayerView(tXCloudVideoView);
        }
    }

    public void setRenderMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.mImpl.setRenderMode(i3);
        }
    }

    public void setRenderRotation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.mImpl.setRenderRotation(i3);
        }
    }

    public void setSurface(Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) surface);
        } else {
            this.mImpl.setSurface(surface);
        }
    }

    public void setSurfaceSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mImpl.setSurfaceSize(i3, i16);
        }
    }

    public void setVideoRawDataListener(ITXVideoRawDataListener iTXVideoRawDataListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) iTXVideoRawDataListener);
        } else {
            this.mImpl.setVideoRawDataListener(iTXVideoRawDataListener);
        }
    }

    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) iTXVideoRecordListener);
        } else {
            this.mImpl.setVideoRecordListener(iTXVideoRecordListener);
        }
    }

    public int setVideoRenderListener(ITXLivePlayVideoRenderListener iTXLivePlayVideoRenderListener, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this, (Object) iTXLivePlayVideoRenderListener, obj)).intValue();
        }
        return this.mImpl.setVideoRenderListener(iTXLivePlayVideoRenderListener, obj);
    }

    public void setVolume(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.mImpl.setVolume(i3);
        }
    }

    public void showDebugView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.mImpl.showDebugView(z16);
        }
    }

    public void snapshot(ITXSnapshotListener iTXSnapshotListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) iTXSnapshotListener);
        } else {
            this.mImpl.snapshot(iTXSnapshotListener);
        }
    }

    public int startLivePlay(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3)).intValue();
        }
        return this.mImpl.startLivePlay(str, i3);
    }

    public int startRecord(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this, i3)).intValue();
        }
        return this.mImpl.startRecord(i3);
    }

    public int stopPlay(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, z16)).intValue();
        }
        return this.mImpl.stopPlay(z16);
    }

    public int stopRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return this.mImpl.stopRecord();
    }

    public int switchStream(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str)).intValue();
        }
        return this.mImpl.switchStream(str);
    }
}
