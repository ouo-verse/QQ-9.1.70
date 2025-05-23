package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.IOException;

/* loaded from: classes23.dex */
public class DefaultMediaPlayer implements IMediaPlayer {
    public static final String LOG_TAG = "DefaultMediaPlayer";
    MediaPlayer mMediaPlayer = new ReportMediaPlayer();

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public int getBufferPercent() {
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public long getCurrentPosition() {
        return this.mMediaPlayer.getCurrentPosition();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public long getDuration() {
        return this.mMediaPlayer.getDuration();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public int getVideoHeight() {
        return this.mMediaPlayer.getVideoHeight();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public int getVideoWidth() {
        return this.mMediaPlayer.getVideoWidth();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public boolean isLooping() {
        return this.mMediaPlayer.isLooping();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public boolean isPlaying() {
        return this.mMediaPlayer.isPlaying();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public boolean isSuperPlayer() {
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void pause() throws IllegalStateException {
        this.mMediaPlayer.pause();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        this.mMediaPlayer.prepareAsync();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void release() {
        this.mMediaPlayer.release();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void reset() {
        this.mMediaPlayer.reset();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void seekTo(long j3) throws IllegalStateException {
        this.mMediaPlayer.seekTo((int) j3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mMediaPlayer.setDataSource(str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mMediaPlayer.setDisplay(surfaceHolder);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setDrmDataSource(String str, String str2, String str3) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        this.mMediaPlayer.setDataSource(str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setLooping(boolean z16) {
        this.mMediaPlayer.setLooping(z16);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnBufferingUpdateListener(final IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mMediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.tencent.qqmini.sdk.core.proxy.service.DefaultMediaPlayer.3
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i3) {
                onBufferingUpdateListener.onBufferingUpdate(DefaultMediaPlayer.this, i3);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnCompletionListener(final IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.tencent.qqmini.sdk.core.proxy.service.DefaultMediaPlayer.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                onCompletionListener.onCompletion(DefaultMediaPlayer.this);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnErrorListener(final IMediaPlayer.OnErrorListener onErrorListener) {
        this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.tencent.qqmini.sdk.core.proxy.service.DefaultMediaPlayer.6
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
                return onErrorListener.onError(DefaultMediaPlayer.this, i3, i16);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnInfoListener(final IMediaPlayer.OnInfoListener onInfoListener) {
        this.mMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.tencent.qqmini.sdk.core.proxy.service.DefaultMediaPlayer.7
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i3, int i16) {
                return onInfoListener.onInfo(DefaultMediaPlayer.this, i3, i16);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnLoopStartListener(IMediaPlayer.OnLoopStartListener onLoopStartListener) {
        QMLog.w(LOG_TAG, "setOnLoopStartListener is not supported!");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnPreparedListener(final IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.qqmini.sdk.core.proxy.service.DefaultMediaPlayer.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                onPreparedListener.onPrepared(DefaultMediaPlayer.this);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnSeekCompleteListener(final IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mMediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.tencent.qqmini.sdk.core.proxy.service.DefaultMediaPlayer.4
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                onSeekCompleteListener.onSeekComplete(DefaultMediaPlayer.this);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setOnVideoSizeChangedListener(final IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mMediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.tencent.qqmini.sdk.core.proxy.service.DefaultMediaPlayer.5
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i3, int i16) {
                onVideoSizeChangedListener.onVideoSizeChanged(DefaultMediaPlayer.this, i3, i16);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setRate(float f16) {
        QMLog.w(LOG_TAG, "setRate:" + f16 + " is not supported");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z16) {
        this.mMediaPlayer.setScreenOnWhilePlaying(z16);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void setVolume(float f16, float f17) {
        this.mMediaPlayer.setVolume(f16, f17);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void start() throws IllegalStateException {
        this.mMediaPlayer.start();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer
    public void stop() throws IllegalStateException {
        this.mMediaPlayer.stop();
    }
}
