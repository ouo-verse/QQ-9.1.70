package com.tencent.live2.impl;

import android.content.Context;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.base.util.SoLoader;
import com.tencent.liteav.live.V2TXLivePlayerJni;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class V2TXLivePlayerImpl extends V2TXLivePlayer {
    static IPatchRedirector $redirector_;
    private V2TXLivePlayer mImpl;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16476);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            SoLoader.loadAllLibraries();
        }
    }

    public V2TXLivePlayerImpl(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mImpl = new V2TXLivePlayerJni(context, this);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableObserveAudioFrame(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this, z16)).intValue();
        }
        return this.mImpl.enableObserveAudioFrame(z16);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableObserveVideoFrame(boolean z16, V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType v2TXLiveBufferType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), v2TXLivePixelFormat, v2TXLiveBufferType)).intValue();
        }
        return this.mImpl.enableObserveVideoFrame(z16, v2TXLivePixelFormat, v2TXLiveBufferType);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableReceiveSeiMessage(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, this, Boolean.valueOf(z16), Integer.valueOf(i3))).intValue();
        }
        return this.mImpl.enableReceiveSeiMessage(z16, i3);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableVolumeEvaluation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, i3)).intValue();
        }
        return this.mImpl.enableVolumeEvaluation(i3);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public ArrayList<V2TXLiveDef.V2TXLiveStreamInfo> getStreamList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ArrayList) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.mImpl.getStreamList();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.mImpl.isPlaying();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int pauseAudio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.mImpl.pauseAudio();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int pauseVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.mImpl.pauseVideo();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int resumeAudio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.mImpl.resumeAudio();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int resumeVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.mImpl.resumeVideo();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setCacheParams(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16), Float.valueOf(f17))).intValue();
        }
        return this.mImpl.setCacheParams(f16, f17);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public void setObserver(V2TXLivePlayerObserver v2TXLivePlayerObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) v2TXLivePlayerObserver);
        } else {
            this.mImpl.setObserver(v2TXLivePlayerObserver);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setPlayoutVolume(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, i3)).intValue();
        }
        return this.mImpl.setPlayoutVolume(i3);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setProperty(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this, (Object) str, obj)).intValue();
        }
        return this.mImpl.setProperty(str, obj);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode v2TXLiveFillMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) v2TXLiveFillMode)).intValue();
        }
        return this.mImpl.setRenderFillMode(v2TXLiveFillMode);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation v2TXLiveRotation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) v2TXLiveRotation)).intValue();
        }
        return this.mImpl.setRenderRotation(v2TXLiveRotation);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderView(TXCloudVideoView tXCloudVideoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.mImpl.setRenderView(tXCloudVideoView) : ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) tXCloudVideoView)).intValue();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public void showDebugView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
        } else {
            this.mImpl.showDebugView(z16);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int snapshot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.mImpl.snapshot();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int startLivePlay(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).intValue();
        }
        return this.mImpl.startLivePlay(str);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int startLocalRecording(V2TXLiveDef.V2TXLiveLocalRecordingParams v2TXLiveLocalRecordingParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this, (Object) v2TXLiveLocalRecordingParams)).intValue();
        }
        return this.mImpl.startLocalRecording(v2TXLiveLocalRecordingParams);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public void stopLocalRecording() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            this.mImpl.stopLocalRecording();
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int stopPlay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.mImpl.stopPlay();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int switchStream(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str)).intValue();
        }
        return this.mImpl.switchStream(str);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderView(TextureView textureView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.mImpl.setRenderView(textureView) : ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) textureView)).intValue();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderView(SurfaceView surfaceView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.mImpl.setRenderView(surfaceView) : ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) surfaceView)).intValue();
    }
}
