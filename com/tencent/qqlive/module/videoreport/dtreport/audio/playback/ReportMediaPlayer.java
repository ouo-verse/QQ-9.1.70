package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

import android.media.MediaPlayer;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.AudioListeners;
import java.io.IOException;

/* loaded from: classes22.dex */
public class ReportMediaPlayer extends MediaPlayer implements IAudioPlayer {
    private MediaPlayerProxy mAudioProxy;

    public ReportMediaPlayer() {
        MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy(this);
        this.mAudioProxy = mediaPlayerProxy;
        super.setOnPreparedListener(mediaPlayerProxy);
        super.setOnCompletionListener(this.mAudioProxy);
        super.setOnErrorListener(this.mAudioProxy);
        super.setOnInfoListener(this.mAudioProxy);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer
    public final int getCurrentPosition__() {
        return getCurrentPosition();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer
    public final int getDuration__() {
        return getDuration();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer
    public final String getPlayerId__() {
        return "MediaPlayer_" + hashCode();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer
    public final int getPlayerType__() {
        return 100;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer
    public final boolean isAudioPlayer__() {
        return true;
    }

    @Override // android.media.MediaPlayer
    public void pause() throws IllegalStateException {
        super.pause();
        this.mAudioProxy.pause();
    }

    @Override // android.media.MediaPlayer
    public void prepare() throws IOException, IllegalStateException {
        this.mAudioProxy.prepare();
        super.prepare();
    }

    @Override // android.media.MediaPlayer
    public void prepareAsync() throws IllegalStateException {
        this.mAudioProxy.prepare();
        super.prepareAsync();
    }

    @Override // android.media.MediaPlayer
    public void reset() {
        super.reset();
        this.mAudioProxy.reset();
    }

    @Override // android.media.MediaPlayer
    public void setOnCompletionListener(final MediaPlayer.OnCompletionListener onCompletionListener) {
        this.mAudioProxy.setOnCompletionListener(new AudioListeners.OnPlayCompletionListener() { // from class: com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer.2
            @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.AudioListeners.OnPlayCompletionListener
            public void onAudioPlayComplete(IAudioPlayer iAudioPlayer) {
                MediaPlayer.OnCompletionListener onCompletionListener2 = onCompletionListener;
                if (onCompletionListener2 != null) {
                    onCompletionListener2.onCompletion(ReportMediaPlayer.this);
                }
            }
        });
    }

    @Override // android.media.MediaPlayer
    public void setOnErrorListener(final MediaPlayer.OnErrorListener onErrorListener) {
        this.mAudioProxy.setOnErrorListener(new AudioListeners.OnPlayErrorListener() { // from class: com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer.3
            @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.AudioListeners.OnPlayErrorListener
            public boolean onAudioError(IAudioPlayer iAudioPlayer, int i3, int i16) {
                MediaPlayer.OnErrorListener onErrorListener2 = onErrorListener;
                if (onErrorListener2 != null && onErrorListener2.onError(ReportMediaPlayer.this, i3, i16)) {
                    return true;
                }
                return false;
            }
        });
    }

    @Override // android.media.MediaPlayer
    public void setOnInfoListener(final MediaPlayer.OnInfoListener onInfoListener) {
        this.mAudioProxy.setOnInfoListener(new AudioListeners.OnPlayInfoListener() { // from class: com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer.4
            @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.AudioListeners.OnPlayInfoListener
            public boolean onAudioInfo(IAudioPlayer iAudioPlayer, int i3, int i16) {
                MediaPlayer.OnInfoListener onInfoListener2 = onInfoListener;
                if (onInfoListener2 != null && onInfoListener2.onInfo(ReportMediaPlayer.this, i3, i16)) {
                    return true;
                }
                return false;
            }
        });
    }

    @Override // android.media.MediaPlayer
    public void setOnPreparedListener(final MediaPlayer.OnPreparedListener onPreparedListener) {
        this.mAudioProxy.setOnPreparedListener(new AudioListeners.OnPlayPreparedListener() { // from class: com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer.1
            @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.AudioListeners.OnPlayPreparedListener
            public void onAudioPlayPrepared(IAudioPlayer iAudioPlayer) {
                MediaPlayer.OnPreparedListener onPreparedListener2 = onPreparedListener;
                if (onPreparedListener2 != null) {
                    onPreparedListener2.onPrepared(ReportMediaPlayer.this);
                }
            }
        });
    }

    @Override // android.media.MediaPlayer
    public void start() throws IllegalStateException {
        super.start();
        this.mAudioProxy.start();
    }

    @Override // android.media.MediaPlayer
    public void stop() throws IllegalStateException {
        this.mAudioProxy.stop();
        super.stop();
    }
}
