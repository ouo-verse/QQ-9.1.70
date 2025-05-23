package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

/* loaded from: classes23.dex */
public abstract class AbsVideoPlayer {
    public static final int PLAYER_INFO_ENDOF_BUFFERING = 22;
    public static final int PLAYER_INFO_START_BUFFERING = 21;

    /* loaded from: classes23.dex */
    public interface OnCaptureImageListener {
        void onCaptureImageFailed();

        void onCaptureImageSucceed(Bitmap bitmap);
    }

    /* loaded from: classes23.dex */
    public interface OnCompletionListener {
        void onCompletion(AbsVideoPlayer absVideoPlayer);
    }

    /* loaded from: classes23.dex */
    public interface OnControllerClickListener {
        void onAttationClick(AbsVideoPlayer absVideoPlayer);

        void onBackClick(AbsVideoPlayer absVideoPlayer);

        void onBackOnFullScreenClick(AbsVideoPlayer absVideoPlayer);

        void onCacheClick(AbsVideoPlayer absVideoPlayer);

        void onFeedbackClick(AbsVideoPlayer absVideoPlayer);

        void onFullScreenClick(AbsVideoPlayer absVideoPlayer);
    }

    /* loaded from: classes23.dex */
    public interface OnErrorListener {
        boolean onError(AbsVideoPlayer absVideoPlayer, int i3, int i16);
    }

    /* loaded from: classes23.dex */
    public interface OnInfoListener {
        boolean onInfo(AbsVideoPlayer absVideoPlayer, int i3, int i16);
    }

    /* loaded from: classes23.dex */
    public interface OnSeekCompleteListener {
        void onSeekComplete(AbsVideoPlayer absVideoPlayer);
    }

    /* loaded from: classes23.dex */
    public interface OnVideoPreparedListener {
        void onVideoPrepared(AbsVideoPlayer absVideoPlayer);
    }

    /* loaded from: classes23.dex */
    public interface OnVideoViewInitListener {
        void onVideoViewInit(View view);
    }

    public abstract int captureImageInTime(int i3, int i16);

    public abstract void createVideoView(Context context, OnVideoViewInitListener onVideoViewInitListener, boolean z16);

    public abstract long getCurrentPostion();

    public abstract long getDuration();

    public abstract boolean getOutputMute();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract boolean isPlaying();

    public abstract boolean isSuperPlayer();

    public abstract void openMediaPlayerByUrl(Context context, long j3);

    public abstract void openMediaPlayerByUrl(Context context, String str, long j3);

    public abstract void pause();

    public abstract void release();

    public abstract void reset();

    public abstract void seekTo(int i3);

    public abstract void setDataSource(String str);

    public abstract void setDrmDataSource(String str, String str2, String str3);

    public abstract void setLoopback(boolean z16);

    public abstract void setOnCaptureImageListener(OnCaptureImageListener onCaptureImageListener);

    public abstract void setOnCompletionListener(OnCompletionListener onCompletionListener);

    public abstract void setOnControllerClickListener(OnControllerClickListener onControllerClickListener);

    public abstract void setOnErrorListener(OnErrorListener onErrorListener);

    public abstract void setOnInfoListener(OnInfoListener onInfoListener);

    public abstract void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    public abstract void setOnVideoPreparedListener(OnVideoPreparedListener onVideoPreparedListener);

    public abstract boolean setOutputMute(boolean z16);

    public abstract void setXYaxis(int i3);

    public abstract void start();

    public abstract void startPlayDanmu();

    public abstract void stop();

    public abstract void stopPlayDanmu();
}
