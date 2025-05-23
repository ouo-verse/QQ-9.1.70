package com.tencent.mobileqq.qzoneplayer.cover.wrapper;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qzoneplayer.cover.controller.CoverUIControllerFactory;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoData;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoPlayerEventCenter;
import com.tencent.mobileqq.qzoneplayer.cover.presenter.BaseVideoPresenter;
import com.tencent.mobileqq.qzoneplayer.cover.presenter.OnBaseVideoClickListener;
import com.tencent.mobileqq.qzoneplayer.cover.view.VideoCoverController;
import com.tencent.mobileqq.qzoneplayer.cover.view.VideoCoverView;
import com.tencent.mobileqq.qzoneplayer.cover.widget.ErrorTipsPage;
import com.tencent.mobileqq.qzoneplayer.cover.widget.NetChangeWarnPage;
import com.tencent.mobileqq.qzoneplayer.cover.widget.b;
import com.tencent.mobileqq.qzoneplayer.cover.widget.c;
import com.tencent.mobileqq.qzoneplayer.cover.widget.d;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.qzoneplayer.video.PictureUrl;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a extends BaseVideoCoverUIWrapper {
    protected VideoCoverController C;
    protected b D;
    protected com.tencent.mobileqq.qzoneplayer.cover.widget.a E;

    /* renamed from: d, reason: collision with root package name */
    protected BaseVideo f279380d;

    /* renamed from: e, reason: collision with root package name */
    protected ErrorTipsPage f279381e;

    /* renamed from: f, reason: collision with root package name */
    protected NetChangeWarnPage f279382f;

    /* renamed from: h, reason: collision with root package name */
    protected c f279383h;

    /* renamed from: i, reason: collision with root package name */
    protected d f279384i;

    /* renamed from: m, reason: collision with root package name */
    protected com.tencent.mobileqq.qzoneplayer.cover.view.a f279385m;

    public a(Context context, BaseVideo baseVideo, VideoPlayerEventCenter.ISubject iSubject) {
        super(context);
        this.f279380d = baseVideo;
        initUI(context);
        initEvent(context, baseVideo, iSubject);
    }

    public void a(View view) {
        VideoCoverController videoCoverController = this.C;
        if (videoCoverController == null || !(videoCoverController.getView() instanceof VideoCoverView)) {
            return;
        }
        ((VideoCoverView) this.C.getView()).setRelativeView(view);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.BaseVideoCoverUIWrapper
    protected void attachSubjectChild(VideoPlayerEventCenter.ISubject iSubject) {
        this.f279381e.attachSubject(iSubject);
        this.f279382f.attachSubject(iSubject);
        this.f279383h.attachSubject(iSubject);
        this.f279384i.attachSubject(iSubject);
        this.f279385m.attachSubject(iSubject);
        this.C.attachSubject(iSubject);
        this.D.attachSubject(iSubject);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper
    public View getBaseCover() {
        return this.C.getView();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected int getLayoutId() {
        return FeedVideoEnv.feedResources.getLayoutId(20);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper
    public int getPicHeight() {
        return this.C.getPicHeight();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper
    public int getPicWidth() {
        return this.C.getPicWidth();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper
    public HashMap<String, Boolean> getPlayOnWifiMap() {
        return BaseVideoCover.getPlayOnWifiMap();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper
    public BaseVideoCover.CoverWarnType getWarnType() {
        return this.mBaseVideoPresenter.getWarnType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.BaseVideoCoverUIWrapper, com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public void initChildView() {
        super.initChildView();
        this.f279381e = (ErrorTipsPage) CoverUIControllerFactory.create(this.mContext, this.mErrorPageViewStub, this.f279380d, 5);
        this.f279382f = (NetChangeWarnPage) CoverUIControllerFactory.create(this.mContext, this.mNetWarnPageViewStub, this.f279380d, 3);
        this.f279383h = (c) CoverUIControllerFactory.create(this.mContext, this.mCompletePageViewStub, this.f279380d, 6);
        this.f279384i = (d) CoverUIControllerFactory.create(this.mContext, this.mVideoFloatCompletePageViewStub, this.f279380d, 4);
        this.f279385m = (com.tencent.mobileqq.qzoneplayer.cover.view.a) CoverUIControllerFactory.create(this.mContext, this.mLoadingViewStub, this.f279380d, 1);
        this.C = (VideoCoverController) CoverUIControllerFactory.create(this.mContext, this.mVideoCoverViewStub, this.f279380d, 2);
        this.D = (b) CoverUIControllerFactory.create(this.mContext, this.mPlayIconContainerViewStub, this.f279380d, 7);
        this.E = (com.tencent.mobileqq.qzoneplayer.cover.widget.a) CoverUIControllerFactory.create(this.mContext, this.mGdtVideoCompletePasterAdStub, this.f279380d, 8);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.BaseVideoCoverUIWrapper
    protected void initEvent(Context context, BaseVideo baseVideo, VideoPlayerEventCenter.ISubject iSubject) {
        com.tencent.mobileqq.qzoneplayer.cover.presenter.a aVar = new com.tencent.mobileqq.qzoneplayer.cover.presenter.a(this.f279380d, this);
        this.mBaseVideoPresenter = aVar;
        setOnBaseVideoElementClickListener(aVar);
        setPresenter(this.mBaseVideoPresenter);
        attachSubject(iSubject);
        this.C.setOnCoverSizeChangeListener(this.mBaseVideoPresenter);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper
    public void reportStoreIconToLp(int i3, int i16) {
        this.mBaseVideoPresenter.reportStoreIconToLp(i3, i16);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public void reset() {
        super.reset();
        this.mBaseVideoPresenter.reset();
        this.C.reset();
        this.f279382f.reset();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper
    public void setCoverWarnType(BaseVideoCover.CoverWarnType coverWarnType) {
        this.mBaseVideoPresenter.setCoverWarnType(coverWarnType);
        this.f279382f.updateUI();
        this.D.updateUI();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public void setData(VideoData videoData) {
        super.setData(videoData);
        this.f279381e.setData(videoData);
        this.f279382f.setData(videoData);
        this.f279383h.setData(videoData);
        this.f279384i.setData(videoData);
        this.f279385m.setData(videoData);
        this.C.setData(videoData);
        this.D.setData(videoData);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper
    public void setJustShowReplyIcon(boolean z16) {
        this.f279384i.c(z16);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper
    public void setLoadFailedText(String str) {
        this.f279381e.setLoadFailedText(str);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper
    public void setMaxWidth(int i3) {
        this.C.setMaxWidth(i3);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.BaseVideoCoverUIWrapper
    protected void setOnBaseVideoElementClickListenerChild(OnBaseVideoClickListener onBaseVideoClickListener) {
        this.f279381e.setOnBaseVideoElementClickListener(onBaseVideoClickListener);
        this.f279382f.setOnBaseVideoElementClickListener(onBaseVideoClickListener);
        this.f279383h.setOnBaseVideoElementClickListener(onBaseVideoClickListener);
        this.f279384i.setOnBaseVideoElementClickListener(onBaseVideoClickListener);
        this.f279385m.setOnBaseVideoElementClickListener(onBaseVideoClickListener);
        this.C.setOnBaseVideoElementClickListener(onBaseVideoClickListener);
        this.D.setOnBaseVideoElementClickListener(onBaseVideoClickListener);
        this.E.setOnBaseVideoElementClickListener(onBaseVideoClickListener);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper
    public void setOpenFreeTrafficText(String str, String str2) {
        b bVar = this.D;
        if (bVar != null) {
            bVar.setOpenFreeTrafficText(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper
    public void setPicInfo(PictureUrl pictureUrl, String str, VideoPlayInfo videoPlayInfo) {
        VideoData videoData = new VideoData();
        VideoData.BaseVideoCoverData baseVideoCoverData = new VideoData.BaseVideoCoverData();
        videoData.baseVideoCoverData = baseVideoCoverData;
        baseVideoCoverData.picUrl = pictureUrl;
        baseVideoCoverData.timeDes = str;
        baseVideoCoverData.videoPlayInfo = videoPlayInfo;
        setData(videoData);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper
    public void setPicInfoOnCoverThread(PictureUrl pictureUrl, String str, VideoPlayInfo videoPlayInfo) {
        VideoData videoData = new VideoData();
        VideoData.BaseVideoCoverData baseVideoCoverData = new VideoData.BaseVideoCoverData();
        videoData.baseVideoCoverData = baseVideoCoverData;
        baseVideoCoverData.picUrl = pictureUrl;
        baseVideoCoverData.timeDes = str;
        baseVideoCoverData.videoPlayInfo = videoPlayInfo;
        setData(videoData);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.BaseVideoCoverUIWrapper, com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public void setPresenter(BaseVideoPresenter baseVideoPresenter) {
        this.f279381e.setPresenter(baseVideoPresenter);
        this.f279382f.setPresenter(baseVideoPresenter);
        this.f279383h.setPresenter(baseVideoPresenter);
        this.f279384i.setPresenter(baseVideoPresenter);
        this.f279385m.setPresenter(baseVideoPresenter);
        this.C.setPresenter(baseVideoPresenter);
        this.D.setPresenter(baseVideoPresenter);
        this.E.setPresenter(baseVideoPresenter);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper
    public void setShowOpenFreeTraffic(boolean z16) {
        b bVar = this.D;
        if (bVar != null) {
            bVar.setShowOpenFreeTraffic(z16);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper
    public void setShowPlayIcon(boolean z16) {
        this.D.setShowPlayIcon(z16);
        this.D.updateUI();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onUpdate() {
    }
}
