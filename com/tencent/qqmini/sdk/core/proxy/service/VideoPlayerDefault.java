package com.tencent.qqmini.sdk.core.proxy.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes23.dex */
public class VideoPlayerDefault extends AbsVideoPlayer {
    private static final String TAG = "VideoPlayerDefault";
    private List<AbsVideoPlayer.OnCaptureImageListener> mOnCaptureImageListenerList;
    private int seekPosition;
    private int videoHeight;
    private int videoWidth;
    private MediaPlayer player = null;
    private View playerSurface = null;
    private Context context = null;
    private boolean isMute = false;
    private int scale = 1;
    private boolean prepared = false;
    private String url = null;

    private void callbackCaptureImageFailed() {
        List<AbsVideoPlayer.OnCaptureImageListener> list = this.mOnCaptureImageListenerList;
        if (list != null && list.size() > 0) {
            for (AbsVideoPlayer.OnCaptureImageListener onCaptureImageListener : this.mOnCaptureImageListenerList) {
                if (onCaptureImageListener != null) {
                    onCaptureImageListener.onCaptureImageFailed();
                }
            }
        }
    }

    private void callbackCaptureImageSucceed(Bitmap bitmap) {
        List<AbsVideoPlayer.OnCaptureImageListener> list = this.mOnCaptureImageListenerList;
        if (list != null && list.size() > 0) {
            for (AbsVideoPlayer.OnCaptureImageListener onCaptureImageListener : this.mOnCaptureImageListenerList) {
                if (onCaptureImageListener != null) {
                    onCaptureImageListener.onCaptureImageSucceed(bitmap);
                }
            }
        }
    }

    private View createPlayerSurface(boolean z16) {
        if (z16) {
            SurfaceView surfaceView = new SurfaceView(this.context);
            surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerDefault.7
                @Override // android.view.SurfaceHolder.Callback
                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    if (VideoPlayerDefault.this.player != null) {
                        VideoPlayerDefault.this.player.setSurface(surfaceHolder.getSurface());
                    }
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
                }
            });
            return surfaceView;
        }
        TextureView textureView = new TextureView(this.context);
        textureView.setSurfaceTextureListener(new a());
        return textureView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFitToFillAspectRatio(MediaPlayer mediaPlayer, int i3, int i16) {
        View view;
        if (mediaPlayer != null && i3 > 0 && i16 > 0 && (view = this.playerSurface) != null) {
            int width = view.getWidth();
            int height = this.playerSurface.getHeight();
            ViewGroup.LayoutParams layoutParams = this.playerSurface.getLayoutParams();
            if (i3 > i16) {
                layoutParams.width = width;
                layoutParams.height = (width * i16) / i3;
            } else {
                layoutParams.width = (i3 * height) / i16;
                layoutParams.height = height;
            }
            this.playerSurface.setLayoutParams(layoutParams);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public int captureImageInTime(int i3, int i16) {
        try {
            MediaPlayer mediaPlayer = this.player;
            if (mediaPlayer != null) {
                int currentPosition = mediaPlayer.getCurrentPosition();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                if (URLUtil.isNetworkUrl(this.url)) {
                    mediaMetadataRetriever.setDataSource(this.url, new HashMap());
                } else {
                    mediaMetadataRetriever.setDataSource(this.url);
                }
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(currentPosition, 3);
                if (frameAtTime != null && !frameAtTime.isRecycled()) {
                    int width = frameAtTime.getWidth();
                    int height = frameAtTime.getHeight();
                    if (width != 0 && height != 0) {
                        Matrix matrix = new Matrix();
                        matrix.postScale(i3 / width, i16 / height);
                        frameAtTime = Bitmap.createBitmap(frameAtTime, 0, 0, i3, i16, matrix, true);
                    }
                    callbackCaptureImageSucceed(frameAtTime);
                    return 0;
                }
                callbackCaptureImageFailed();
                return 0;
            }
            return 0;
        } catch (Throwable unused) {
            callbackCaptureImageFailed();
            return 0;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void createVideoView(Context context, AbsVideoPlayer.OnVideoViewInitListener onVideoViewInitListener, boolean z16) {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.player = null;
        }
        this.player = new ReportMediaPlayer();
        this.isMute = false;
        this.prepared = false;
        this.context = context;
        View createPlayerSurface = createPlayerSurface(z16);
        this.playerSurface = createPlayerSurface;
        if (onVideoViewInitListener != null) {
            onVideoViewInitListener.onVideoViewInit(createPlayerSurface);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public long getCurrentPostion() {
        if (this.player != null && this.prepared) {
            try {
                return r0.getCurrentPosition();
            } catch (IllegalStateException e16) {
                e16.printStackTrace();
            }
        }
        return 0L;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public long getDuration() {
        if (this.player != null) {
            try {
                return r0.getDuration();
            } catch (IllegalStateException e16) {
                QMLog.i(TAG, "getDuration", e16);
            }
        }
        return 0L;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public boolean getOutputMute() {
        return this.isMute;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public int getVideoHeight() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public int getVideoWidth() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null && this.prepared) {
            try {
                return mediaPlayer.isPlaying();
            } catch (IllegalStateException unused) {
            }
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public boolean isSuperPlayer() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void openMediaPlayerByUrl(Context context, long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void pause() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null && this.prepared) {
            try {
                mediaPlayer.pause();
            } catch (IllegalStateException e16) {
                QMLog.i(TAG, "pause", e16);
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void release() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void reset() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void seekTo(int i3) {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i3);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setLoopback(boolean z16) {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setOnCaptureImageListener(AbsVideoPlayer.OnCaptureImageListener onCaptureImageListener) {
        if (onCaptureImageListener != null) {
            if (this.mOnCaptureImageListenerList == null) {
                this.mOnCaptureImageListenerList = new ArrayList();
            }
            if (!this.mOnCaptureImageListenerList.contains(onCaptureImageListener)) {
                this.mOnCaptureImageListenerList.add(onCaptureImageListener);
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setOnCompletionListener(final AbsVideoPlayer.OnCompletionListener onCompletionListener) {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerDefault.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer2) {
                    AbsVideoPlayer.OnCompletionListener onCompletionListener2 = onCompletionListener;
                    if (onCompletionListener2 != null) {
                        onCompletionListener2.onCompletion(VideoPlayerDefault.this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setOnErrorListener(final AbsVideoPlayer.OnErrorListener onErrorListener) {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerDefault.4
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer2, int i3, int i16) {
                    AbsVideoPlayer.OnErrorListener onErrorListener2 = onErrorListener;
                    if (onErrorListener2 != null) {
                        onErrorListener2.onError(VideoPlayerDefault.this, i3, i16);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setOnInfoListener(final AbsVideoPlayer.OnInfoListener onInfoListener) {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerDefault.5
                @Override // android.media.MediaPlayer.OnInfoListener
                public boolean onInfo(MediaPlayer mediaPlayer2, int i3, int i16) {
                    AbsVideoPlayer.OnInfoListener onInfoListener2 = onInfoListener;
                    if (onInfoListener2 != null) {
                        onInfoListener2.onInfo(VideoPlayerDefault.this, i3, i16);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setOnSeekCompleteListener(final AbsVideoPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerDefault.6
                @Override // android.media.MediaPlayer.OnSeekCompleteListener
                public void onSeekComplete(MediaPlayer mediaPlayer2) {
                    AbsVideoPlayer.OnSeekCompleteListener onSeekCompleteListener2 = onSeekCompleteListener;
                    if (onSeekCompleteListener2 != null) {
                        onSeekCompleteListener2.onSeekComplete(VideoPlayerDefault.this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setOnVideoPreparedListener(final AbsVideoPlayer.OnVideoPreparedListener onVideoPreparedListener) {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerDefault.2
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer2) {
                    if (onVideoPreparedListener != null) {
                        VideoPlayerDefault.this.prepared = true;
                        onVideoPreparedListener.onVideoPrepared(VideoPlayerDefault.this);
                    }
                    if (VideoPlayerDefault.this.seekPosition > 0) {
                        VideoPlayerDefault.this.player.seekTo(VideoPlayerDefault.this.seekPosition);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public boolean setOutputMute(boolean z16) {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            this.isMute = z16;
            if (z16) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                return true;
            }
            mediaPlayer.setVolume(0.8f, 0.8f);
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setXYaxis(int i3) {
        this.scale = i3;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void start() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null && this.prepared && !mediaPlayer.isPlaying()) {
            this.player.start();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void stop() {
        try {
            MediaPlayer mediaPlayer = this.player;
            if (mediaPlayer != null && this.prepared) {
                mediaPlayer.stop();
            }
        } catch (IllegalStateException e16) {
            QMLog.i(TAG, "stop", e16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void openMediaPlayerByUrl(Context context, String str, long j3) {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            try {
                this.url = str;
                this.prepared = false;
                mediaPlayer.reset();
                this.player.setDataSource(str);
                this.player.prepareAsync();
                this.seekPosition = (int) j3;
                this.player.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerDefault.1
                    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer2, int i3, int i16) {
                        VideoPlayerDefault.this.videoWidth = i3;
                        VideoPlayerDefault.this.videoHeight = i16;
                        if (VideoPlayerDefault.this.scale == 0) {
                            VideoPlayerDefault.this.setFitToFillAspectRatio(mediaPlayer2, i3, i16);
                        }
                    }
                });
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void startPlayDanmu() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void stopPlayDanmu() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
            if (VideoPlayerDefault.this.player != null) {
                VideoPlayerDefault.this.player.setSurface(new Surface(surfaceTexture));
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setDataSource(String str) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setOnControllerClickListener(AbsVideoPlayer.OnControllerClickListener onControllerClickListener) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer
    public void setDrmDataSource(String str, String str2, String str3) {
    }
}
