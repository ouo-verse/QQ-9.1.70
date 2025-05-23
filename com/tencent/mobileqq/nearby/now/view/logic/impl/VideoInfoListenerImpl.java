package com.tencent.mobileqq.nearby.now.view.logic.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.IStoryPlayController;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.IStoryRelayoutUtil;
import com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.IVideoPlayerView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.h;
import com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener;
import com.tencent.mobileqq.nearby.now.view.widget.HorizontalBallLoadingView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class VideoInfoListenerImpl implements IVideoPlayerView.b, IVideoInfoListener {
    private static final int RELAYOUT_INTERVAL_TIME = 500;
    private IShortVideoCommentsView mCommentsView;
    private h.b mHolder;
    private HorizontalBallLoadingView mHorizontalBallLoadingView;
    private boolean mNeedRelayoutPlayerView;
    private IStoryPlayController mPlayController;
    private int mVideoCoverHeight;
    private int mVideoCoverWidth;
    private final String TAG = "VideoInfoListener";
    int mOldPercent = -1;
    Runnable mShowLoadingRunable = new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.logic.impl.VideoInfoListenerImpl.3
        @Override // java.lang.Runnable
        public void run() {
            if (VideoInfoListenerImpl.this.mHorizontalBallLoadingView != null) {
                VideoInfoListenerImpl.this.mHorizontalBallLoadingView.setVisibility(0);
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoInfoListenerImpl.this.mHolder.f252896f.setVisibility(8);
            ((IVideoPlayerView) VideoInfoListenerImpl.this.mPlayController.getVideoPlayer()).stopPlayback(false);
            VideoInfoListenerImpl.this.mPlayController.startPlayVideo(VideoInfoListenerImpl.this.mPlayController.getCurrentIndex());
            if (VideoInfoListenerImpl.this.mHolder.f252894d != null) {
                VideoInfoListenerImpl.this.mHolder.f252894d.e(true);
            }
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener
    public void handleDeviceNavChange() {
        if (QLog.isColorLevel()) {
            QLog.d("VideoInfoListener", 2, "VideoInfoListenerImpl onLayoutChange");
        }
        if (this.mHolder.f252895e.getVisibility() == 0) {
            if (((h) this.mPlayController.getAdapter()).f252886h.size() <= this.mPlayController.getCurrentIndex() || ((h) this.mPlayController.getAdapter()).f252886h.get(this.mPlayController.getCurrentIndex()).f252703i0.size() <= 0) {
                return;
            }
            ((IStoryRelayoutUtil) QRoute.api(IStoryRelayoutUtil.class)).dynamicLayoutStoryImageContainerView(this.mHolder, ((h) this.mPlayController.getAdapter()).f252886h.get(this.mPlayController.getCurrentIndex()).f252703i0.get(0).f252714c, ((h) this.mPlayController.getAdapter()).f252886h.get(this.mPlayController.getCurrentIndex()).f252703i0.get(0).f252713b, ((h) this.mPlayController.getAdapter()).f252886h.get(this.mPlayController.getCurrentIndex()), this.mCommentsView);
            return;
        }
        if (this.mVideoCoverWidth <= 0 || this.mVideoCoverHeight <= 0) {
            return;
        }
        ((IStoryRelayoutUtil) QRoute.api(IStoryRelayoutUtil.class)).dynamicChangeStoryContainerView(this.mHolder, this.mVideoCoverWidth, this.mVideoCoverHeight);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener
    public void hideLoading() {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("hideLoading\uff1a mHorizontalBallLoadingView is null? : ");
            sb5.append(this.mHorizontalBallLoadingView == null);
            QLog.i("VideoInfoListener", 2, sb5.toString());
        }
        ThreadManager.getUIHandler().removeCallbacks(this.mShowLoadingRunable);
        HorizontalBallLoadingView horizontalBallLoadingView = this.mHorizontalBallLoadingView;
        if (horizontalBallLoadingView == null) {
            return;
        }
        horizontalBallLoadingView.setVisibility(8);
        this.mHorizontalBallLoadingView = null;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView.b
    public void onComplete() {
        if (QLog.isColorLevel()) {
            QLog.i("VideoInfoListener", 2, "onComplete");
        }
        if ((this.mPlayController.getContext() instanceof Activity) && ((Activity) this.mPlayController.getContext()).isFinishing()) {
            return;
        }
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.logic.impl.VideoInfoListenerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (!((VideoInfoListenerImpl.this.mPlayController.getContext() instanceof Activity) && ((Activity) VideoInfoListenerImpl.this.mPlayController.getContext()).isFinishing()) && VideoInfoListenerImpl.this.mHolder.f252891a >= 0 && VideoInfoListenerImpl.this.mHolder.f252891a < ((h) VideoInfoListenerImpl.this.mPlayController.getAdapter()).f252886h.size()) {
                    if (((StuffContainerView) VideoInfoListenerImpl.this.mPlayController.getStuffContainerView()).f252840f != null) {
                        if (VideoInfoListenerImpl.this.mPlayController.isNeedRepeat()) {
                            ((IVideoPlayerView) VideoInfoListenerImpl.this.mPlayController.getVideoPlayer()).restart();
                            if (QLog.isColorLevel()) {
                                QLog.i("VideoInfoListener", 2, "discovery page repeat mode and repeat the Vidoe!");
                                return;
                            }
                            return;
                        }
                        if (!VideoInfoListenerImpl.this.mCommentsView.canPlayNext()) {
                            ((IVideoPlayerView) VideoInfoListenerImpl.this.mPlayController.getVideoPlayer()).restart();
                            if (QLog.isColorLevel()) {
                                QLog.i("VideoInfoListener", 2, "repeat in Video Page!");
                                return;
                            }
                            return;
                        }
                        if (VideoInfoListenerImpl.this.mHolder.f252891a == ((h) VideoInfoListenerImpl.this.mPlayController.getAdapter()).f252886h.size() - 1) {
                            if (VideoInfoListenerImpl.this.mPlayController.getContext() instanceof Activity) {
                                ((Activity) VideoInfoListenerImpl.this.mPlayController.getContext()).finish();
                                return;
                            }
                            return;
                        }
                    }
                    VideoData videoData = ((h) VideoInfoListenerImpl.this.mPlayController.getAdapter()).f252886h.get(VideoInfoListenerImpl.this.mHolder.f252891a);
                    videoData.f252691b0 = 0;
                    videoData.f252699g0 = false;
                    VideoInfoListenerImpl.this.mPlayController.setCurrentIndex(VideoInfoListenerImpl.this.mPlayController.getCurrentIndex() + 1);
                    if (VideoInfoListenerImpl.this.mPlayController.getCurrentIndex() < ((h) VideoInfoListenerImpl.this.mPlayController.getAdapter()).f252886h.size()) {
                        ((StuffContainerView) VideoInfoListenerImpl.this.mPlayController.getStuffContainerView()).setCurrentItem(VideoInfoListenerImpl.this.mPlayController.getCurrentIndex(), true);
                    } else if (((com.tencent.mobileqq.nearby.now.model.a) VideoInfoListenerImpl.this.mPlayController.getBasePlayListDataModel()).f()) {
                        ((StuffContainerView) VideoInfoListenerImpl.this.mPlayController.getStuffContainerView()).h();
                    }
                }
            }
        }, 1000L);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView.b
    public void onCoverComplete(int i3, int i16, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("VideoInfoListener", 2, "onCoverComplete() called with: imageWidth = [" + i3 + "], imageHeight = [" + i16 + "], isSuc = [" + z16 + "]");
        }
        this.mVideoCoverWidth = i3;
        this.mVideoCoverHeight = i16;
        if (z16 && this.mNeedRelayoutPlayerView) {
            ((IStoryRelayoutUtil) QRoute.api(IStoryRelayoutUtil.class)).dynamicChangeStoryContainerView(this.mHolder, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView.b
    public void onDoingStartPlayback() {
        if (QLog.isColorLevel()) {
            QLog.i("VideoInfoListener", 2, "onDoingStartPlayback");
        }
        showLoading();
        this.mPlayController.updateVideoLabelState();
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView.b
    public void onDoingStopPlayback() {
        if (QLog.isColorLevel()) {
            QLog.i("VideoInfoListener", 2, "onDoingStopPlayback");
        }
        hideLoading();
        if (this.mCommentsView.isScrollTop()) {
            return;
        }
        this.mCommentsView.scrollToTop();
    }

    public void onPlayError() {
        this.mHolder.f252894d.e(false);
        hideLoading();
        QLog.e("VideoInfoListener", 1, "onPlayError");
        this.mHolder.f252896f.setVisibility(0);
        IShortVideoCommentsView iShortVideoCommentsView = this.mCommentsView;
        if (iShortVideoCommentsView != null && iShortVideoCommentsView.getmEmptyCloseBtn() != null) {
            this.mCommentsView.getmEmptyCloseBtn().setVisibility(0);
        }
        this.mHolder.f252896f.c();
        this.mHolder.f252896f.setOnRetryClickListener(new a());
    }

    public void onPlayRetry(long j3) {
        if (QLog.isColorLevel()) {
            QLog.i("VideoInfoListener", 2, "onPlayRetry");
        }
        hideLoading();
        if (this.mHolder != null) {
            QLog.e("VideoInfoListener", 1, "onPlayRetry mPlayController.mCurrentIndexis: " + this.mPlayController.getCurrentIndex());
            ((IVideoPlayerView) this.mPlayController.getVideoPlayer()).stopPlayback(false);
            IStoryPlayController iStoryPlayController = this.mPlayController;
            iStoryPlayController.startPlayVideo(iStoryPlayController.getCurrentIndex());
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView.b
    public void onStartPlaying() {
        if (QLog.isColorLevel()) {
            QLog.i("VideoInfoListener", 2, "onStartPlaying");
        }
        h.b bVar = this.mHolder;
        if (bVar != null) {
            bVar.f252896f.setVisibility(8);
            IShortVideoCommentsView iShortVideoCommentsView = this.mCommentsView;
            if (iShortVideoCommentsView != null && iShortVideoCommentsView.getmEmptyCloseBtn() != null && ((h) this.mPlayController.getAdapter()).f252886h.get(this.mHolder.f252891a).f252693d != 4) {
                this.mCommentsView.getmEmptyCloseBtn().setVisibility(8);
            }
            hideLoading();
            this.mPlayController.hideRootCover();
            this.mHolder.f252894d.e(true);
            int i3 = this.mHolder.f252891a;
            if (i3 < 0 || i3 >= ((h) this.mPlayController.getAdapter()).f252886h.size()) {
                return;
            }
            VideoData videoData = ((h) this.mPlayController.getAdapter()).f252886h.get(this.mHolder.f252891a);
            if (1 != videoData.f252693d && this.mPlayController.getCurrentIndex() == this.mHolder.f252891a) {
                videoData.f252699g0 = true;
                return;
            }
            return;
        }
        QLog.e("VideoInfoListener", 1, "mHolder == null!");
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView.b
    public void onStartPrepareVideo() {
        if (QLog.isColorLevel()) {
            QLog.i("VideoInfoListener", 2, "onStartPrepareVideo");
        }
        h.b bVar = this.mHolder;
        if (bVar == null) {
            return;
        }
        bVar.f252896f.setVisibility(8);
        IShortVideoCommentsView iShortVideoCommentsView = this.mCommentsView;
        if (iShortVideoCommentsView != null && iShortVideoCommentsView.getmEmptyCloseBtn() != null && ((h) this.mPlayController.getAdapter()).f252886h.get(this.mHolder.f252891a).f252693d != 4) {
            this.mCommentsView.getmEmptyCloseBtn().setVisibility(8);
        }
        h.b bVar2 = this.mHolder;
        if (bVar2 != null) {
            bVar2.f252894d.e(true);
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener
    public void scrollToTop() {
        this.mCommentsView.scrollToTop();
    }

    @Override // com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener
    public void showLoading() {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("showLoading\uff1a mHorizontalBallLoadingView is null? : ");
            sb5.append(this.mHorizontalBallLoadingView == null);
            QLog.i("VideoInfoListener", 2, sb5.toString());
        }
        this.mHorizontalBallLoadingView = (HorizontalBallLoadingView) this.mHolder.f252893c.findViewById(R.id.loading);
        ThreadManager.getUIHandler().postDelayed(this.mShowLoadingRunable, 1000L);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener
    public VideoInfoListenerImpl init(Object obj, IStoryPlayController iStoryPlayController, IShortVideoCommentsView iShortVideoCommentsView, boolean z16) {
        this.mHolder = (h.b) obj;
        this.mPlayController = iStoryPlayController;
        this.mCommentsView = iShortVideoCommentsView;
        this.mNeedRelayoutPlayerView = z16;
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView.b
    public void onPlayProgress(int i3) {
        if (i3 == 0 || this.mOldPercent == i3) {
            return;
        }
        this.mOldPercent = i3;
        if (i3 > 100) {
            i3 = 100;
        }
        if (this.mPlayController.isMultiProgressBar()) {
            ((StuffContainerView) this.mPlayController.getStuffContainerView()).D.b(this.mHolder.f252891a, i3);
        } else {
            ((StuffContainerView) this.mPlayController.getStuffContainerView()).D.b(0, i3);
        }
    }

    public void onPrepareCompleted() {
    }

    public void onPrepareProgress(int i3) {
    }
}
