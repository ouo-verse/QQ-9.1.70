package com.tencent.mobileqq.intervideo.audioroom.player;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;

/* loaded from: classes15.dex */
public class QQVoiceRtmpPlayer implements IQQVoiceRtmpPlayer, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnVideoPreparedListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ISuperPlayer f238121d;

    /* renamed from: e, reason: collision with root package name */
    private IQQVoiceAudioListener f238122e;

    /* renamed from: f, reason: collision with root package name */
    private String f238123f;

    public QQVoiceRtmpPlayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String str = this.f238123f;
        if (str != null) {
            play(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplication.getContext(), 118, null);
        this.f238121d = createMediaPlayer;
        createMediaPlayer.setOnCompletionListener(this);
        this.f238121d.setOnInfoListener(this);
        this.f238121d.setOnErrorListener(this);
        this.f238121d.setOnVideoPreparedListener(this);
    }

    @Override // com.tencent.mobileqq.intervideo.audioroom.player.IQQVoiceRtmpPlayer
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (isPlayerReady()) {
            d();
        } else {
            QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), new SDKInitListener() { // from class: com.tencent.mobileqq.intervideo.audioroom.player.QQVoiceRtmpPlayer.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQVoiceRtmpPlayer.this);
                    }
                }

                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public void onSDKInited(boolean z16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                        return;
                    }
                    if (z16) {
                        QQVoiceRtmpPlayer.this.d();
                        QQVoiceRtmpPlayer.this.c();
                        return;
                    }
                    QLog.w("QQVoiceRtmpPlayer", 1, "initSDKAsync fail: " + QQVideoPlaySDKManager.isSoLoadSucess() + ", " + QQVideoPlaySDKManager.isSDKReady());
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.intervideo.audioroom.player.IQQVoiceRtmpPlayer
    public boolean isDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.f238121d == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.intervideo.audioroom.player.IQQVoiceRtmpPlayer
    public boolean isPlayerReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (QQVideoPlaySDKManager.isSoLoadSucess() && QQVideoPlaySDKManager.isSDKReady()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.intervideo.audioroom.player.IQQVoiceRtmpPlayer
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        ISuperPlayer iSuperPlayer = this.f238121d;
        if (iSuperPlayer != null && iSuperPlayer.isPlaying()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(ISuperPlayer iSuperPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) iSuperPlayer);
            return;
        }
        IQQVoiceAudioListener iQQVoiceAudioListener = this.f238122e;
        if (iQQVoiceAudioListener != null) {
            iQQVoiceAudioListener.onCompletion();
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, iSuperPlayer, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str)).booleanValue();
        }
        IQQVoiceAudioListener iQQVoiceAudioListener = this.f238122e;
        if (iQQVoiceAudioListener == null) {
            return false;
        }
        return iQQVoiceAudioListener.onError(i3, i16, i17, str);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, iSuperPlayer, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), obj)).booleanValue();
        }
        IQQVoiceAudioListener iQQVoiceAudioListener = this.f238122e;
        if (iQQVoiceAudioListener == null) {
            return false;
        }
        return iQQVoiceAudioListener.onInfo(i3, j3, j16, obj);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) iSuperPlayer);
            return;
        }
        ISuperPlayer iSuperPlayer2 = this.f238121d;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.start();
            IQQVoiceAudioListener iQQVoiceAudioListener = this.f238122e;
            if (iQQVoiceAudioListener != null) {
                iQQVoiceAudioListener.onAudioFirstFrame();
            }
        }
    }

    @Override // com.tencent.mobileqq.intervideo.audioroom.player.IQQVoiceRtmpPlayer
    public void play(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            if (this.f238121d == null) {
                this.f238123f = str;
                return;
            }
            this.f238123f = null;
            this.f238121d.openMediaPlayer(BaseApplication.getContext(), SuperPlayerFactory.createVideoInfoForUrl(str, 103, (String) null), 0L);
        }
    }

    @Override // com.tencent.mobileqq.intervideo.audioroom.player.IQQVoiceRtmpPlayer
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ISuperPlayer iSuperPlayer = this.f238121d;
        if (iSuperPlayer == null) {
            return;
        }
        this.f238123f = null;
        iSuperPlayer.stop();
        this.f238121d.release();
        this.f238121d = null;
    }

    @Override // com.tencent.mobileqq.intervideo.audioroom.player.IQQVoiceRtmpPlayer
    public void setPlayAudioListener(IQQVoiceAudioListener iQQVoiceAudioListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iQQVoiceAudioListener);
        } else {
            this.f238122e = iQQVoiceAudioListener;
        }
    }
}
