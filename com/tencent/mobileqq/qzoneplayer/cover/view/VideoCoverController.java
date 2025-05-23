package com.tencent.mobileqq.qzoneplayer.cover.view;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoClickElement;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoData;
import com.tencent.mobileqq.qzoneplayer.cover.presenter.BaseVideoPresenter;
import com.tencent.mobileqq.qzoneplayer.cover.presenter.OnBaseVideoClickListener;
import com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes35.dex */
public class VideoCoverController extends AbsCoverUI {
    public static final String LOG_TAG = "VideoCoverController";
    protected BaseVideo mBaseVideo;
    protected VideoCoverView mVideoCoverView;

    public VideoCoverController(Context context, BaseVideo baseVideo) {
        super(context);
        this.mBaseVideo = baseVideo;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected int getLayoutId() {
        return FeedVideoEnv.feedResources.getLayoutId(19);
    }

    public int getPicHeight() {
        return this.mVideoCoverView.getPicHeight();
    }

    public int getPicWidth() {
        return this.mVideoCoverView.getPicWidth();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public View getView() {
        return this.mVideoCoverView;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void initChildView() {
        VideoCoverView videoCoverView = new VideoCoverView(this.mContext);
        this.mVideoCoverView = videoCoverView;
        videoCoverView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mVideoCoverView.setBaseVideo(this.mBaseVideo);
        addView(this.mVideoCoverView);
    }

    protected boolean isShowVideoCover() {
        BaseVideo baseVideo = this.mBaseVideo;
        return baseVideo != null && baseVideo.isShowCoverImage();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        OnBaseVideoClickListener onBaseVideoClickListener = this.mBaseVideoClickListener;
        if (onBaseVideoClickListener != null) {
            onBaseVideoClickListener.onClick(view, isAdv(), VideoClickElement.BASE_COVER, this.mPos, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowDefaultView(Message message) {
        showCover();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowErrorView() {
        showCover();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPauseView() {
        showCover();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPlayCompleteView() {
        showCover();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPlayFloatCompleteView() {
        showCover();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPlayingView() {
        showCover();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowRetryView() {
        showCover();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowStopView() {
        showCover();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowWaitView() {
        showCover();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public void reset() {
        super.reset();
        this.mVideoCoverView.reset();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public void setData(VideoData videoData) {
        super.setData(videoData);
        this.mVideoCoverView.setData(videoData);
    }

    public void setMaxWidth(int i3) {
        this.mVideoCoverView.setMaxWidth(i3);
    }

    public void setOnCoverSizeChangeListener(OnCoverSizeChangeListener onCoverSizeChangeListener) {
        this.mVideoCoverView.setOnCoverSizeChangeListener(onCoverSizeChangeListener);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public void setPos(int i3) {
        super.setPos(i3);
        this.mVideoCoverView.n(i3);
    }

    protected void showCover() {
        BaseVideoPresenter baseVideoPresenter;
        if (isShowVideoCover()) {
            setVisibility(0);
            if (this.mVideoCoverView == null || (baseVideoPresenter = this.mBaseVideoPresenter) == null) {
                return;
            }
            if (!baseVideoPresenter.isFullScreenMode()) {
                this.mVideoCoverView.setOnClickListener(this);
                return;
            } else {
                this.mVideoCoverView.setOnClickListener(null);
                this.mVideoCoverView.setClickable(false);
                return;
            }
        }
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onUpdate() {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onUpdateUI() {
    }
}
