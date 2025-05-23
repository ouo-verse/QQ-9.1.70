package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.dtreport.audio.AudioPlayerListenerImpl;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.AudioListeners;

/* loaded from: classes22.dex */
class BaseAudioPlayerProxy implements IAudioPlayerProxy {

    @NonNull
    private IAudioPlayListener mAudioPlayListener;

    @NonNull
    IAudioPlayer mAudioPlayer;

    @Nullable
    private AudioListeners.OnPlayCompletionListener mBizCompletionListener;

    @Nullable
    private AudioListeners.OnPlayErrorListener mBizErrorListener;

    @Nullable
    private AudioListeners.OnPlayInfoListener mBizInfoListener;

    @Nullable
    private AudioListeners.OnPlayPreparedListener mBizPreparedListener;
    private int mState = -1;

    @NonNull
    private AudioProgressTimer mTimer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseAudioPlayerProxy(@NonNull IAudioPlayer iAudioPlayer) {
        this.mAudioPlayer = iAudioPlayer;
        this.mAudioPlayListener = new AudioPlayerListenerImpl(iAudioPlayer);
        this.mTimer = new AudioProgressTimer(iAudioPlayer, this);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.IAudioPlayerProxy
    public boolean isPaused() {
        if (this.mState == 3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.IAudioPlayerProxy
    public void onAudioCompletion(IAudioPlayer iAudioPlayer) {
        this.mAudioPlayListener.onAudioComplete(this.mAudioPlayer);
        this.mTimer.stop();
        AudioListeners.OnPlayCompletionListener onPlayCompletionListener = this.mBizCompletionListener;
        if (onPlayCompletionListener != null) {
            onPlayCompletionListener.onAudioPlayComplete(this.mAudioPlayer);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.IAudioPlayerProxy
    public boolean onAudioError(IAudioPlayer iAudioPlayer, int i3, int i16) {
        this.mState = 5;
        this.mAudioPlayListener.onAudioError(this.mAudioPlayer, i3, i16);
        this.mTimer.stop();
        AudioListeners.OnPlayErrorListener onPlayErrorListener = this.mBizErrorListener;
        if (onPlayErrorListener != null) {
            return onPlayErrorListener.onAudioError(this.mAudioPlayer, i3, i16);
        }
        return false;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.IAudioPlayerProxy
    public boolean onAudioInfo(IAudioPlayer iAudioPlayer, int i3, int i16) {
        if (i3 == 701) {
            this.mAudioPlayListener.onBufferingStart(this.mAudioPlayer);
        } else if (i3 == 702) {
            this.mAudioPlayListener.onBufferingEnd(this.mAudioPlayer);
        }
        AudioListeners.OnPlayInfoListener onPlayInfoListener = this.mBizInfoListener;
        if (onPlayInfoListener != null) {
            return onPlayInfoListener.onAudioInfo(this.mAudioPlayer, i3, i16);
        }
        return false;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.IAudioPlayerProxy
    public void onAudioPrepared(IAudioPlayer iAudioPlayer) {
        if (this.mAudioPlayer.isAudioPlayer__()) {
            this.mState = 1;
        }
        AudioListeners.OnPlayPreparedListener onPlayPreparedListener = this.mBizPreparedListener;
        if (onPlayPreparedListener != null) {
            onPlayPreparedListener.onAudioPlayPrepared(this.mAudioPlayer);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.IAudioPlayerProxy
    public void pause() {
        if (this.mState != -1) {
            this.mAudioPlayListener.onAudioPause(this.mAudioPlayer);
            this.mState = 3;
            this.mTimer.stop();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.IAudioPlayerProxy
    public void prepare() {
        this.mState = -1;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.IAudioPlayerProxy
    public void reset() {
        if (this.mState != -1) {
            this.mAudioPlayListener.onAudioStop(this.mAudioPlayer);
            this.mState = -1;
            this.mTimer.stop();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.IAudioPlayerProxy
    public void setOnCompletionListener(AudioListeners.OnPlayCompletionListener onPlayCompletionListener) {
        this.mBizCompletionListener = onPlayCompletionListener;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.IAudioPlayerProxy
    public void setOnErrorListener(AudioListeners.OnPlayErrorListener onPlayErrorListener) {
        this.mBizErrorListener = onPlayErrorListener;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.IAudioPlayerProxy
    public void setOnInfoListener(AudioListeners.OnPlayInfoListener onPlayInfoListener) {
        this.mBizInfoListener = onPlayInfoListener;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.IAudioPlayerProxy
    public void setOnPreparedListener(AudioListeners.OnPlayPreparedListener onPlayPreparedListener) {
        this.mBizPreparedListener = onPlayPreparedListener;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.IAudioPlayerProxy
    public void start() {
        if (this.mState == 1) {
            this.mState = 2;
            this.mAudioPlayListener.onAudioStart(true, this.mAudioPlayer);
            this.mTimer.start();
        }
        if (this.mState == 3) {
            this.mState = 2;
            this.mAudioPlayListener.onAudioStart(false, this.mAudioPlayer);
            this.mTimer.start();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.IAudioPlayerProxy
    public void stop() {
        if (this.mState != -1) {
            this.mAudioPlayListener.onAudioStop(this.mAudioPlayer);
            this.mState = 4;
            this.mTimer.stop();
        }
    }
}
