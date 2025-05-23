package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;

/* loaded from: classes23.dex */
public interface IVideoPlayer {
    void captureImageInTime(int i3, int i16);

    void createVideoView(AbsVideoPlayer.OnVideoViewInitListener onVideoViewInitListener, boolean z16);

    long getCurrentPostion();

    long getDuration();

    boolean getOutputMute();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void openMediaPlayerByUrl(Activity activity, String str, long j3);

    void openMediaPlayerByUrl(Activity activity, String str, long j3, String str2, String str3, Boolean bool);

    void pause();

    void release();

    void seekTo(int i3);

    void setOnCaptureImageListener(AbsVideoPlayer.OnCaptureImageListener onCaptureImageListener);

    void setupPlayer(MiniAppVideoConfig miniAppVideoConfig, MiniAppVideoPlayerListenerHolder miniAppVideoPlayerListenerHolder);

    void start();

    void startPlayDanmu();

    void stop();

    boolean updateMute(MiniAppVideoConfig miniAppVideoConfig);

    void updateObjFit(MiniAppVideoConfig miniAppVideoConfig);
}
