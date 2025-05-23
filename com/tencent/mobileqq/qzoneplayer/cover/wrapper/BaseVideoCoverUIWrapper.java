package com.tencent.mobileqq.qzoneplayer.cover.wrapper;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoPlayerEventCenter;
import com.tencent.mobileqq.qzoneplayer.cover.presenter.BaseVideoPresenter;
import com.tencent.mobileqq.qzoneplayer.cover.presenter.OnBaseVideoClickListener;
import com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;

/* compiled from: P */
/* loaded from: classes35.dex */
public abstract class BaseVideoCoverUIWrapper extends AbsCoverUI implements ICoverWrapper {
    protected ViewStub mCompletePageViewStub;
    protected FrameLayout mCoverContainer;
    protected ViewStub mDanmakuContainerViewStub;
    protected ViewStub mErrorPageViewStub;
    protected ViewStub mGdtVideoCompletePasterAdStub;
    protected ViewStub mLoadingViewStub;
    protected ViewStub mNetWarnPageViewStub;
    protected ViewStub mPlayIconContainerViewStub;
    protected ViewStub mVideoCoverViewStub;
    protected ViewStub mVideoFloatCompletePageViewStub;

    public BaseVideoCoverUIWrapper(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public void attachSubject(VideoPlayerEventCenter.ISubject iSubject) {
        super.attachSubject(iSubject);
        attachSubjectChild(iSubject);
    }

    protected abstract void attachSubjectChild(VideoPlayerEventCenter.ISubject iSubject);

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper
    public View getCover() {
        return this.mCoverContainer;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper
    public View getParentView() {
        return this.mParentView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public void initChildView() {
        this.mCoverContainer = (FrameLayout) findViewById(FeedVideoEnv.feedResources.getViewId(626));
        this.mErrorPageViewStub = (ViewStub) findViewById(FeedVideoEnv.feedResources.getViewId(621));
        this.mNetWarnPageViewStub = (ViewStub) findViewById(FeedVideoEnv.feedResources.getViewId(623));
        this.mCompletePageViewStub = (ViewStub) findViewById(FeedVideoEnv.feedResources.getViewId(619));
        this.mVideoFloatCompletePageViewStub = (ViewStub) findViewById(FeedVideoEnv.feedResources.getViewId(620));
        this.mLoadingViewStub = (ViewStub) findViewById(FeedVideoEnv.feedResources.getViewId(624));
        this.mVideoCoverViewStub = (ViewStub) findViewById(FeedVideoEnv.feedResources.getViewId(625));
        this.mPlayIconContainerViewStub = (ViewStub) findViewById(FeedVideoEnv.feedResources.getViewId(622));
        this.mDanmakuContainerViewStub = (ViewStub) findViewById(FeedVideoEnv.feedResources.getViewId(628));
        this.mGdtVideoCompletePasterAdStub = (ViewStub) findViewById(FeedVideoEnv.feedResources.getViewId(630));
    }

    protected abstract void initEvent(Context context, BaseVideo baseVideo, VideoPlayerEventCenter.ISubject iSubject);

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public void setOnBaseVideoElementClickListener(OnBaseVideoClickListener onBaseVideoClickListener) {
        super.setOnBaseVideoElementClickListener(onBaseVideoClickListener);
        setOnBaseVideoElementClickListenerChild(onBaseVideoClickListener);
    }

    protected abstract void setOnBaseVideoElementClickListenerChild(OnBaseVideoClickListener onBaseVideoClickListener);

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public abstract void setPresenter(BaseVideoPresenter baseVideoPresenter);

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowDefaultView(Message message) {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowErrorView() {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPauseView() {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPlayCompleteView() {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPlayFloatCompleteView() {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPlayingView() {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowRetryView() {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowStopView() {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowWaitView() {
    }
}
