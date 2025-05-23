package com.tencent.mobileqq.intervideo.audioroom.player;

import android.support.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@Keep
/* loaded from: classes15.dex */
public class QQVoiceAudioPlayerProxy {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private QQVoiceRtmpPlayer f238120a;

    public QQVoiceAudioPlayerProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QQVoiceRtmpPlayer qQVoiceRtmpPlayer = new QQVoiceRtmpPlayer();
        this.f238120a = qQVoiceRtmpPlayer;
        qQVoiceRtmpPlayer.init();
    }

    public boolean isDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        QQVoiceRtmpPlayer qQVoiceRtmpPlayer = this.f238120a;
        if (qQVoiceRtmpPlayer != null && !qQVoiceRtmpPlayer.isDestroy()) {
            return false;
        }
        return true;
    }

    public boolean isPlayerReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        QQVoiceRtmpPlayer qQVoiceRtmpPlayer = this.f238120a;
        if (qQVoiceRtmpPlayer == null) {
            return false;
        }
        return qQVoiceRtmpPlayer.isPlayerReady();
    }

    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        QQVoiceRtmpPlayer qQVoiceRtmpPlayer = this.f238120a;
        if (qQVoiceRtmpPlayer == null) {
            return false;
        }
        return qQVoiceRtmpPlayer.isPlaying();
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QQVoiceRtmpPlayer qQVoiceRtmpPlayer = this.f238120a;
        if (qQVoiceRtmpPlayer == null) {
            return;
        }
        qQVoiceRtmpPlayer.release();
        this.f238120a = null;
    }

    public void startPlay(String str, IQQVoiceAudioListener iQQVoiceAudioListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) iQQVoiceAudioListener);
            return;
        }
        QQVoiceRtmpPlayer qQVoiceRtmpPlayer = this.f238120a;
        if (qQVoiceRtmpPlayer == null) {
            return;
        }
        qQVoiceRtmpPlayer.setPlayAudioListener(iQQVoiceAudioListener);
        this.f238120a.play(str);
    }
}
