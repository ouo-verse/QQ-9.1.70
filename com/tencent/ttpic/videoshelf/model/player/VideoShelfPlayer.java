package com.tencent.ttpic.videoshelf.model.player;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import com.tencent.ttpic.videoshelf.utils.TTPTLogger;
import java.io.IOException;

/* loaded from: classes27.dex */
public class VideoShelfPlayer implements IVideoShelfPlayer {
    private MediaPlayerListener mMediaPlayerListener;
    private IVideoShelfPlayerListener mVideoShelfPlayerListener;
    private final String TAG = "VideoShelfPlayer";
    int mVideoWidth = 0;
    int mVideoHeight = 0;
    MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.tencent.ttpic.videoshelf.model.player.VideoShelfPlayer.1
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i3, int i16) {
            VideoShelfPlayer.this.mVideoWidth = mediaPlayer.getVideoWidth();
            VideoShelfPlayer.this.mVideoHeight = mediaPlayer.getVideoHeight();
            TTPTLogger.i("VideoShelfPlayer", "mVideoWidth:" + VideoShelfPlayer.this.mVideoWidth + ",mVideoHeight:" + VideoShelfPlayer.this.mVideoHeight);
            if (VideoShelfPlayer.this.mVideoShelfPlayerListener != null) {
                IVideoShelfPlayerListener iVideoShelfPlayerListener = VideoShelfPlayer.this.mVideoShelfPlayerListener;
                VideoShelfPlayer videoShelfPlayer = VideoShelfPlayer.this;
                iVideoShelfPlayerListener.onChangVideoSize(videoShelfPlayer.mVideoWidth, videoShelfPlayer.mVideoHeight);
            }
        }
    };
    private MediaPlayer mMediaPlayer = new ReportMediaPlayer();

    /* loaded from: classes27.dex */
    class MediaPlayerListener implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
        MediaPlayerListener() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (VideoShelfPlayer.this.mVideoShelfPlayerListener != null) {
                VideoShelfPlayer.this.mVideoShelfPlayerListener.onCompletion();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            if (VideoShelfPlayer.this.mVideoShelfPlayerListener != null) {
                VideoShelfPlayer.this.mVideoShelfPlayerListener.onError(i3, "Mediaplayer\u64ad\u653e\u5931\u8d25\u3002", mediaPlayer);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (VideoShelfPlayer.this.mVideoShelfPlayerListener != null) {
                VideoShelfPlayer.this.mVideoShelfPlayerListener.onPrepared(VideoShelfPlayer.this);
            }
        }
    }

    public VideoShelfPlayer() {
        MediaPlayerListener mediaPlayerListener = new MediaPlayerListener();
        this.mMediaPlayerListener = mediaPlayerListener;
        this.mMediaPlayer.setOnErrorListener(mediaPlayerListener);
        this.mMediaPlayer.setOnCompletionListener(this.mMediaPlayerListener);
        this.mMediaPlayer.setOnPreparedListener(this.mMediaPlayerListener);
        this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void flush() {
        Log.i("VideoShelfPlayView", "VideoshelfPlayer-flush");
        seekTo(getCurrentPosition());
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public long getDuration() {
        if (this.mMediaPlayer != null) {
            return r0.getDuration();
        }
        return 0L;
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void pause() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void prepare() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.prepare();
            } catch (IOException | IllegalStateException e16) {
                e16.printStackTrace();
                ReportUtil.report("[" + VideoShelfPlayer.class.getSimpleName() + "]mVideoPlayer.prepare, error msg = " + e16.toString());
            }
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void reset() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void seekTo(int i3) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.seekTo(i3);
            } catch (IllegalStateException e16) {
                e16.printStackTrace();
                ReportUtil.report("[" + VideoShelfPlayer.class.getSimpleName() + "]mVideoPlayer.seekTo, error msg = " + e16.toString());
            }
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void setDataSource(String str) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || str == null) {
            return;
        }
        try {
            mediaPlayer.setDataSource(str);
        } catch (IOException e16) {
            e16.printStackTrace();
            ReportUtil.report("[" + VideoShelfPlayer.class.getSimpleName() + "] mVideoPlayer.setDataSource path = " + str + ", error msg = " + e16.toString());
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(surfaceHolder);
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void setLooping(boolean z16) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z16);
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void setSurface(Surface surface) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void setVideoShelfPlayerListener(IVideoShelfPlayerListener iVideoShelfPlayerListener) {
        this.mVideoShelfPlayerListener = iVideoShelfPlayerListener;
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void start() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void stop() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer.setOnErrorListener(null);
            this.mMediaPlayer.setOnCompletionListener(null);
            this.mMediaPlayer.setOnPreparedListener(null);
            this.mMediaPlayer.setOnVideoSizeChangedListener(null);
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void setDataSource(AssetManager assetManager, String str) {
        if (this.mMediaPlayer == null || assetManager == null || str == null) {
            return;
        }
        try {
            AssetFileDescriptor openFd = assetManager.openFd(str);
            this.mMediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
        } catch (IOException e16) {
            e16.printStackTrace();
            ReportUtil.report("[" + VideoShelfPlayer.class.getSimpleName() + "] mVideoPlayer.setDataSource(assets file) path = " + str + ", error msg = " + e16.toString());
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void surfaceUpdateSize() {
    }

    @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer
    public void setParam(String str, Object... objArr) {
    }
}
