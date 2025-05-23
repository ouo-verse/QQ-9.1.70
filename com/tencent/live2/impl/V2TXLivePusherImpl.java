package com.tencent.live2.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.SoLoader;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.live.V2TXLivePusherJni;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePusher;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rtmp.ui.TXCloudVideoView;

/* loaded from: classes7.dex */
public class V2TXLivePusherImpl extends V2TXLivePusher {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "V2TXLivePusherImpl";

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f119784a = 0;
    private V2TXLivePusherJni mImpl;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16474);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 50)) {
            redirector.redirect((short) 50);
        } else {
            SoLoader.loadAllLibraries();
        }
    }

    public V2TXLivePusherImpl(Context context, V2TXLiveDef.V2TXLiveMode v2TXLiveMode) {
        this(context, v2TXLiveMode.ordinal());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) v2TXLiveMode);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public int enableAudioProcessObserver(boolean z16, V2TXLiveDef.V2TXLiveAudioFrameObserverFormat v2TXLiveAudioFrameObserverFormat) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, this, Boolean.valueOf(z16), v2TXLiveAudioFrameObserverFormat)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.enableAudioProcessObserver(z16, v2TXLiveAudioFrameObserverFormat);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int enableCustomAudioCapture(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this, z16)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.enableCustomAudioCapture(z16);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int enableCustomVideoCapture(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, (Object) this, z16)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.enableCustomVideoCapture(z16);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int enableCustomVideoProcess(boolean z16, V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType v2TXLiveBufferType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, this, Boolean.valueOf(z16), v2TXLivePixelFormat, v2TXLiveBufferType)).intValue();
        }
        return this.mImpl.enableCustomVideoProcess(z16, v2TXLivePixelFormat, v2TXLiveBufferType);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized void enableVoiceActivityDetection(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, z16);
            return;
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return;
        }
        v2TXLivePusherJni.enableVoiceActivityDetection(z16);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int enableVolumeEvaluation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this, i3)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.enableVolumeEvaluation(i3);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized TXAudioEffectManager getAudioEffectManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (TXAudioEffectManager) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return null;
        }
        return v2TXLivePusherJni.getAudioEffectManager();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized TXBeautyManager getBeautyManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (TXBeautyManager) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return null;
        }
        return v2TXLivePusherJni.getBeautyManager();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized TXDeviceManager getDeviceManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (TXDeviceManager) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return null;
        }
        return v2TXLivePusherJni.getDeviceManager();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int isPushing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.isPushing();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int pauseAudio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.pauseAudio();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int pauseVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.pauseVideo();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return;
        }
        v2TXLivePusherJni.release();
        LiteavLog.i(TAG, "Release instance:" + this.mImpl.toString());
        this.mImpl = null;
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int resumeAudio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.resumeAudio();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int resumeVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.resumeVideo();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int sendCustomAudioFrame(V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this, (Object) v2TXLiveAudioFrame)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.sendCustomAudioFrame(v2TXLiveAudioFrame);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int sendCustomVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this, (Object) v2TXLiveVideoFrame)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.sendCustomVideoFrame(v2TXLiveVideoFrame);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int sendSeiMessage(int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this, i3, (Object) bArr)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.sendSeiMessage(i3, bArr);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int setAudioQuality(V2TXLiveDef.V2TXLiveAudioQuality v2TXLiveAudioQuality) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this, (Object) v2TXLiveAudioQuality)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setAudioQuality(v2TXLiveAudioQuality);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int setEncoderMirror(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, z16)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setEncoderMirror(z16);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int setMixTranscodingConfig(V2TXLiveDef.V2TXLiveTranscodingConfig v2TXLiveTranscodingConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Integer) iPatchRedirector.redirect((short) 44, (Object) this, (Object) v2TXLiveTranscodingConfig)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setMixTranscodingConfig(v2TXLiveTranscodingConfig);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized void setObserver(V2TXLivePusherObserver v2TXLivePusherObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v2TXLivePusherObserver);
            return;
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return;
        }
        v2TXLivePusherJni.setObserver(v2TXLivePusherObserver);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int setProperty(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Integer) iPatchRedirector.redirect((short) 43, (Object) this, (Object) str, obj)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setProperty(str, obj);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode v2TXLiveFillMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) v2TXLiveFillMode)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setRenderFillMode(v2TXLiveFillMode);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int setRenderMirror(V2TXLiveDef.V2TXLiveMirrorType v2TXLiveMirrorType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) v2TXLiveMirrorType)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setRenderMirror(v2TXLiveMirrorType);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int setRenderRotation(V2TXLiveDef.V2TXLiveRotation v2TXLiveRotation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) v2TXLiveRotation)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setRenderRotation(v2TXLiveRotation);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int setRenderView(TXCloudVideoView tXCloudVideoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) tXCloudVideoView)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setRenderView(tXCloudVideoView);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int setVideoQuality(V2TXLiveDef.V2TXLiveVideoEncoderParam v2TXLiveVideoEncoderParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this, (Object) v2TXLiveVideoEncoderParam)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setVideoQuality(v2TXLiveVideoEncoderParam);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int setWatermark(Bitmap bitmap, float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, this, bitmap, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18))).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setWatermark(bitmap, f16, f17, f18);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized void showDebugView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, z16);
            return;
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return;
        }
        v2TXLivePusherJni.showDebugView(z16);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int snapshot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.snapshot();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int startCamera(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, z16)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.startCamera(z16);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int startLocalRecording(V2TXLiveDef.V2TXLiveLocalRecordingParams v2TXLiveLocalRecordingParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Integer) iPatchRedirector.redirect((short) 47, (Object) this, (Object) v2TXLiveLocalRecordingParams)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.startLocalRecording(v2TXLiveLocalRecordingParams);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int startMicrophone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.startMicrophone();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int startPush(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this, (Object) str)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.startPush(str);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int startScreenCapture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.startScreenCapture();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int startSystemAudioLoopback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Integer) iPatchRedirector.redirect((short) 45, (Object) this)).intValue();
        }
        if (this.mImpl == null) {
            return -3;
        }
        if (LiteavSystemInfo.getSystemOSVersionInt() < 29) {
            LiteavLog.e(TAG, "current system don't support system audio loopback");
            return -4;
        }
        return this.mImpl.startSystemAudioLoopback();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int startVirtualCamera(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, (Object) bitmap)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.startVirtualCamera(bitmap);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int stopCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.stopCamera();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized void stopLocalRecording() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this);
            return;
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return;
        }
        v2TXLivePusherJni.stopLocalRecording();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int stopMicrophone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.stopMicrophone();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int stopPush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.stopPush();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int stopScreenCapture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.stopScreenCapture();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int stopSystemAudioLoopback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Integer) iPatchRedirector.redirect((short) 46, (Object) this)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.stopSystemAudioLoopback();
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int stopVirtualCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.stopVirtualCamera();
    }

    V2TXLivePusherImpl(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
            return;
        }
        this.mImpl = new V2TXLivePusherJni(context, i3);
        LiteavLog.i(TAG, "Create instance:" + this.mImpl.toString());
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int setRenderView(TextureView textureView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) textureView)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setRenderView(textureView);
    }

    @Override // com.tencent.live2.V2TXLivePusher
    public synchronized int setRenderView(SurfaceView surfaceView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) surfaceView)).intValue();
        }
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setRenderView(surfaceView);
    }
}
