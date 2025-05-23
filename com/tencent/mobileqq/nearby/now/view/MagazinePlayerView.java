package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.nearby.now.view.IVideoPlayerView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes33.dex */
public class MagazinePlayerView extends VideoPlayerView implements d {
    private String TAG;
    public com.tencent.mobileqq.nearby.now.a callBack;
    private long mPlayTime;
    long mProgressInterval;
    public VideoData mVideoData;

    public MagazinePlayerView(Context context, com.tencent.mobileqq.nearby.now.a aVar, QQAppInterface qQAppInterface) {
        super(context, qQAppInterface);
        this.TAG = "MagazinePlayerView";
        this.callBack = aVar;
    }

    public com.tencent.mobileqq.nearby.now.a getCallBack() {
        return this.callBack;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.d
    public VideoData getVideoData() {
        return this.mVideoData;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.VideoPlayerView, com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void pause() {
        if (this.mVideoData == null) {
            QLog.w(this.TAG, 2, "pasue mShortVideoInfo is null!!");
        } else {
            super.pause();
        }
    }

    public void play(RelativeLayout relativeLayout, VideoData videoData, e eVar) {
        if (QLog.isColorLevel()) {
            QLog.i(this.TAG, 2, "play() called with: rootView = [" + relativeLayout + "], videoData = [" + videoData + "]");
        }
        this.mVideoData = videoData;
        this.mReultListener = eVar;
        if (videoData.f252693d == 1) {
            initWidgetView(relativeLayout);
            this.mPlayTime = 0L;
            this.ivCover.setVisibility(0);
            hideDownloadProgress();
            ((IImageLoader) QRoute.api(IImageLoader.class)).displayImage(this.ivCover, videoData.f252700h, new ColorDrawable(0), new ColorDrawable(0), (URLDrawable.URLDrawableListener) null);
            this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.MagazinePlayerView.1
                @Override // java.lang.Runnable
                public void run() {
                    ((IVideoPlayerView.b) MagazinePlayerView.this.mVideoInfoListener).onStartPrepareVideo();
                    MagazinePlayerView magazinePlayerView = MagazinePlayerView.this;
                    magazinePlayerView.isPlaying = true;
                    ((IVideoPlayerView.b) magazinePlayerView.mVideoInfoListener).onStartPlaying();
                }
            });
            return;
        }
        super.play(relativeLayout, videoData, (Object) eVar);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.VideoPlayerView, com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void resume() {
        VideoData videoData = this.mVideoData;
        if (videoData == null || videoData.f252693d == 1) {
            return;
        }
        com.tencent.mobileqq.nearby.now.a aVar = this.callBack;
        if (aVar != null) {
            aVar.o4();
        }
        super.resume();
    }

    public void setCallBack(com.tencent.mobileqq.nearby.now.a aVar) {
        this.callBack = aVar;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.VideoPlayerView, com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void setProgressCallbackInterval(long j3) {
        if (this.mVideoData.f252693d == 1) {
            this.mProgressInterval = j3;
        } else {
            super.setProgressCallbackInterval(j3);
        }
    }

    public void setVideoData(VideoData videoData) {
        this.mVideoData = videoData;
    }

    public void start() {
        r92.a aVar = this.mPlayer;
        if (aVar != null) {
            aVar.start();
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.VideoPlayerView, com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void stopPlayback(boolean z16) {
        super.stopPlayback(z16);
    }
}
