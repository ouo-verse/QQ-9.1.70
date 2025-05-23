package com.tencent.mobileqq.nearby.now.view;

import android.support.annotation.IntRange;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IVideoPlayerView extends QRouteApi {

    /* loaded from: classes15.dex */
    public interface a {
    }

    /* loaded from: classes15.dex */
    public interface b {
        void onComplete();

        void onCoverComplete(int i3, int i16, boolean z16);

        void onDoingStartPlayback();

        void onDoingStopPlayback();

        void onPlayProgress(int i3);

        void onStartPlaying();

        void onStartPrepareVideo();
    }

    r92.a createVideoView();

    long getCurrentPosition();

    long getDownloadOffset();

    long getDuration();

    long getFileSize();

    int getPlayerType();

    String getmLastUrl();

    int getmPlayerType();

    void hideDownloadProgress();

    void initWidgetView(RelativeLayout relativeLayout);

    boolean isPlaying();

    boolean isVideoCached();

    void pause();

    void play(RelativeLayout relativeLayout, VideoData videoData, Object obj);

    void play(VideoData videoData);

    boolean restart();

    void resume();

    void seekTo(@IntRange(from = 0) long j3);

    void setCoverVisibility(int i3);

    void setOnVideoInfoListener(IVideoInfoListener iVideoInfoListener);

    void setProgressCallbackInterval(long j3);

    void setShowLoadingWhenLoadingCoverListener(a aVar);

    void setVideoPlayViewVisibility(int i3);

    void setmLastUrl(String str);

    void setmPlayerType(int i3);

    void stopPlayback(boolean z16);

    void suspend();
}
