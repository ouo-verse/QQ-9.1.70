package com.tencent.oskplayer.player;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.ext.mediaplayer.AudioLevelSupport;
import com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.util.PlayerUtils;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

/* loaded from: classes22.dex */
public class OskExoMediaPlayer implements IMediaPlayer, AudioLevelSupport {
    public static final String LOG_TAG = "OskExoMediaPlayer";
    ExoMediaPlayer mPlayer = new ExoMediaPlayer(PlayerConfig.g().getAppContext());

    @Override // com.google.android.exoplayer2.ext.mediaplayer.AudioLevelSupport
    public double getAudioDuration() {
        return this.mPlayer.getAudioDuration();
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.AudioLevelSupport
    public double getAudioEnergy() {
        return this.mPlayer.getAudioEnergy();
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.AudioLevelSupport
    public double getAudioLevel() {
        return this.mPlayer.getAudioLevel();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getAudioSessionId() {
        return this.mPlayer.getAudioSessionId();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getCurrentPosition() {
        return this.mPlayer.getCurrentPosition();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String getDataSource() {
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getDuration() {
        return this.mPlayer.getDuration();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getScore() {
        PlayerUtils.log(5, LOG_TAG, "getScore is not supported");
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        PlayerUtils.log(5, LOG_TAG, "getTrackInfo is not supported");
        return new ITrackInfo[0];
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.mPlayer.getVideoHeight();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        PlayerUtils.log(5, LOG_TAG, "getVideoSarDen is not supported");
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        PlayerUtils.log(5, LOG_TAG, "getVideoSarNum is not supported");
        return 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.mPlayer.getVideoWidth();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return this.mPlayer.isLooping();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlaying() {
        return this.mPlayer.isPlaying();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() throws IllegalStateException, IMediaPlayer.InternalOperationException {
        this.mPlayer.pause();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        this.mPlayer.prepareAsync();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        this.mPlayer.release();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        this.mPlayer.reset();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void seekTo(long j3) throws IllegalStateException {
        this.mPlayer.seekTo(j3);
    }

    public void setAudioEventListener(final IMediaPlayer.AudioEventListener audioEventListener) {
        if (audioEventListener != null) {
            this.mPlayer.setAudioEventListener(new MediaPlayerInterface.AudioEventListener() { // from class: com.tencent.oskplayer.player.OskExoMediaPlayer.9
                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.AudioEventListener
                public void onRenderAudioData(byte[] bArr, Format format) {
                    audioEventListener.onRenderAudioData(bArr, format);
                }
            });
        } else {
            this.mPlayer.setAudioEventListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i3) {
        PlayerUtils.log(5, LOG_TAG, "setAudioStreamType is not supported");
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.AudioLevelSupport
    public void setCalculateAudioLevel(boolean z16) {
        this.mPlayer.setCalculateAudioLevel(z16);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        this.mPlayer.setDataSource(context, uri);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mPlayer.setDisplay(surfaceHolder);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z16) {
        PlayerUtils.log(5, LOG_TAG, "setKeepInBackground is not supported");
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z16) {
        this.mPlayer.setLooping(z16);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setNextMediaPlayer(IMediaPlayer iMediaPlayer) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("setNextMediaPlayer(IMediaPlayer nextMediaPlayer) is not supported");
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnBufferingUpdateListener(final IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        if (onBufferingUpdateListener != null) {
            this.mPlayer.setOnBufferingUpdateListener(new MediaPlayerInterface.OnBufferingUpdateListener() { // from class: com.tencent.oskplayer.player.OskExoMediaPlayer.4
                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnBufferingUpdateListener
                public void onBufferingUpdate(MediaPlayerInterface mediaPlayerInterface, int i3) {
                    onBufferingUpdateListener.onBufferingUpdate(OskExoMediaPlayer.this, i3);
                }
            });
        } else {
            this.mPlayer.setOnBufferingUpdateListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnCompletionListener(final IMediaPlayer.OnCompletionListener onCompletionListener) {
        if (onCompletionListener != null) {
            this.mPlayer.setOnCompletionListener(new MediaPlayerInterface.OnCompletionListener() { // from class: com.tencent.oskplayer.player.OskExoMediaPlayer.3
                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnCompletionListener
                public void onCompletion(MediaPlayerInterface mediaPlayerInterface) {
                    onCompletionListener.onCompletion(OskExoMediaPlayer.this);
                }
            });
        } else {
            this.mPlayer.setOnCompletionListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnErrorListener(final IMediaPlayer.OnErrorListener onErrorListener) {
        if (onErrorListener != null) {
            this.mPlayer.setOnErrorListener(new MediaPlayerInterface.OnErrorListener() { // from class: com.tencent.oskplayer.player.OskExoMediaPlayer.7
                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnErrorListener
                public boolean onError(MediaPlayerInterface mediaPlayerInterface, int i3, int i16) {
                    return onErrorListener.onError(OskExoMediaPlayer.this, i3, i16);
                }
            });
        } else {
            this.mPlayer.setOnErrorListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnInfoListener(final IMediaPlayer.OnInfoListener onInfoListener) {
        if (onInfoListener != null) {
            this.mPlayer.setOnInfoListener(new MediaPlayerInterface.OnInfoListener() { // from class: com.tencent.oskplayer.player.OskExoMediaPlayer.8
                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnInfoListener
                public boolean onInfo(MediaPlayerInterface mediaPlayerInterface, int i3, int i16) {
                    return onInfoListener.onInfo(OskExoMediaPlayer.this, i3, i16);
                }
            });
        } else {
            this.mPlayer.setOnInfoListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnLoopStartListener(final IMediaPlayer.OnLoopStartListener onLoopStartListener) {
        if (onLoopStartListener != null) {
            this.mPlayer.setOnLoopStartListener(new MediaPlayerInterface.OnLoopStartListener() { // from class: com.tencent.oskplayer.player.OskExoMediaPlayer.2
                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnLoopStartListener
                public void onLoopStart(MediaPlayerInterface mediaPlayerInterface) {
                    onLoopStartListener.onLoopStart(OskExoMediaPlayer.this);
                }
            });
        } else {
            this.mPlayer.setOnLoopStartListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnPreparedListener(final IMediaPlayer.OnPreparedListener onPreparedListener) {
        if (onPreparedListener != null) {
            this.mPlayer.setOnPreparedListener(new MediaPlayerInterface.OnPreparedListener() { // from class: com.tencent.oskplayer.player.OskExoMediaPlayer.1
                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnPreparedListener
                public void onPrepared(MediaPlayerInterface mediaPlayerInterface) {
                    onPreparedListener.onPrepared(OskExoMediaPlayer.this);
                }
            });
        } else {
            this.mPlayer.setOnPreparedListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnSeekCompleteListener(final IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        if (onSeekCompleteListener != null) {
            this.mPlayer.setOnSeekCompleteListener(new MediaPlayerInterface.OnSeekCompleteListener() { // from class: com.tencent.oskplayer.player.OskExoMediaPlayer.5
                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnSeekCompleteListener
                public void onSeekComplete(MediaPlayerInterface mediaPlayerInterface) {
                    onSeekCompleteListener.onSeekComplete(OskExoMediaPlayer.this);
                }
            });
        } else {
            this.mPlayer.setOnSeekCompleteListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        PlayerUtils.log(5, LOG_TAG, "setOnTimedTextListener is not supported");
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnVideoSizeChangedListener(final IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener != null) {
            this.mPlayer.setOnVideoSizeChangedListener(new MediaPlayerInterface.OnVideoSizeChangedListener() { // from class: com.tencent.oskplayer.player.OskExoMediaPlayer.6
                @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnVideoSizeChangedListener
                public void onVideoSizeChanged(MediaPlayerInterface mediaPlayerInterface, int i3, int i16) {
                    onVideoSizeChangedListener.onVideoSizeChanged(OskExoMediaPlayer.this, i3, i16);
                }
            });
        } else {
            this.mPlayer.setOnVideoSizeChangedListener(null);
        }
    }

    public void setRate(float f16) {
        this.mPlayer.setRate(f16);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z16) {
        this.mPlayer.setScreenOnWhilePlaying(z16);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSeekParameters(SeekParameters seekParameters) {
        this.mPlayer.setSeekParameters(seekParameters);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        this.mPlayer.setSurface(surface);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setVolume(float f16, float f17) {
        this.mPlayer.setVolume(f16, f17);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setWakeMode(Context context, int i3) {
        this.mPlayer.setWakeMode(context, i3);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() throws IllegalStateException, IMediaPlayer.InternalOperationException {
        this.mPlayer.start();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() throws IllegalStateException {
        this.mPlayer.stop();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        this.mPlayer.setDataSource(context, uri, map);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException, UnsupportedOperationException {
        throw new UnsupportedOperationException("setDataSource(FileDescriptor fd) is not supported");
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException {
        this.mPlayer.setDataSource(str);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("setDataSource(IMediaDataSource mediaDataSource) is not supported");
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z16) {
    }
}
