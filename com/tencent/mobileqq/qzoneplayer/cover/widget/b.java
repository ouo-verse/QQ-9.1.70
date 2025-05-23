package com.tencent.mobileqq.qzoneplayer.cover.widget;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoClickElement;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoData;
import com.tencent.mobileqq.qzoneplayer.cover.presenter.BaseVideoPresenter;
import com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes35.dex */
public class b extends AbsCoverUI {
    protected boolean C;

    /* renamed from: d, reason: collision with root package name */
    protected ImageView f279364d;

    /* renamed from: e, reason: collision with root package name */
    protected LinearLayout f279365e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f279366f;

    /* renamed from: h, reason: collision with root package name */
    protected LinearLayout f279367h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f279368i;

    /* renamed from: m, reason: collision with root package name */
    protected TextView f279369m;

    public b(Context context) {
        super(context);
        this.f279366f = false;
        this.C = false;
    }

    protected void b() {
        BaseVideoCover.CoverWarnType coverWarnType;
        ImageView imageView;
        LinearLayout linearLayout;
        VideoData videoData;
        VideoData.BaseVideoCoverData baseVideoCoverData;
        VideoPlayInfo videoPlayInfo;
        if (isParentInit()) {
            BaseVideoPresenter baseVideoPresenter = this.mBaseVideoPresenter;
            if (baseVideoPresenter != null) {
                coverWarnType = baseVideoPresenter.getWarnType();
            } else {
                coverWarnType = BaseVideoCover.CoverWarnType.DEFAULT;
            }
            BaseVideoPresenter baseVideoPresenter2 = this.mBaseVideoPresenter;
            boolean z16 = baseVideoPresenter2 != null && baseVideoPresenter2.isVideoPicMixMode();
            if (BaseVideoCover.CoverWarnType.DEFAULT != coverWarnType && !z16) {
                a(false, z16);
                return;
            }
            if (this.mParentView.getHeight() > FeedVideoEnv.dp60 && this.mParentView.getWidth() > FeedVideoEnv.dp60 && (videoData = this.mBaseVideoData) != null && (baseVideoCoverData = videoData.baseVideoCoverData) != null && (videoPlayInfo = baseVideoCoverData.videoPlayInfo) != null && videoPlayInfo.videoStatus != 3) {
                this.mParentView.setBackgroundColor(0);
                if (this.f279366f) {
                    a(true, z16);
                    return;
                }
                return;
            }
            if (!this.C || (imageView = this.f279364d) == null || imageView.getVisibility() != 0 || (linearLayout = this.f279367h) == null) {
                return;
            }
            linearLayout.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected int getLayoutId() {
        return FeedVideoEnv.feedResources.getLayoutId(21);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void initChildView() {
        this.f279364d = (ImageView) findViewById(FeedVideoEnv.feedResources.getViewId(613));
        this.f279365e = (LinearLayout) findViewById(FeedVideoEnv.feedResources.getViewId(627));
        this.f279364d.setImageDrawable(FeedVideoEnv.playerResources.getDrawable(1094));
        this.f279367h = (LinearLayout) findViewById(FeedVideoEnv.feedResources.getViewId(PlayerResources.ViewId.OPEN_FREE_TRAFFIC_CONTAINER));
        this.f279368i = (TextView) findViewById(FeedVideoEnv.feedResources.getViewId(582));
        TextView textView = (TextView) findViewById(FeedVideoEnv.feedResources.getViewId(583));
        this.f279369m = textView;
        textView.getPaint().setFlags(8);
        this.f279369m.setOnClickListener(this);
        this.f279364d.setOnClickListener(this);
        this.f279365e.setOnClickListener(this);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mParentView.getLayoutParams();
        layoutParams.gravity = 17;
        this.mParentView.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == FeedVideoEnv.feedResources.getViewId(613)) {
            this.mBaseVideoClickListener.onClick(view, isAdv(), VideoClickElement.VIDEO_PLAY, this.mPos, null);
        } else if (view.getId() == FeedVideoEnv.feedResources.getViewId(627)) {
            this.mBaseVideoClickListener.onClick(view, isAdv(), VideoClickElement.VIDEO_FREE_TRAFFIC_PLAY, this.mPos, null);
        } else if (view.getId() == FeedVideoEnv.feedResources.getViewId(583)) {
            this.mBaseVideoClickListener.onClick(view, isAdv(), VideoClickElement.VIDEO_OPEN_FREE_TRAFFIC, this.mPos, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPauseView() {
        BaseVideoPresenter baseVideoPresenter = this.mBaseVideoPresenter;
        if (baseVideoPresenter == null || baseVideoPresenter.getPresenterType() == 1) {
            return;
        }
        setVisibility(0);
        b();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onUpdateUI() {
        b();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public void reset() {
        super.reset();
    }

    public void setOpenFreeTrafficText(String str, String str2) {
        TextView textView = this.f279368i;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.f279369m;
        if (textView2 != null) {
            textView2.setText(str2);
        }
    }

    public void setShowOpenFreeTraffic(boolean z16) {
        this.C = z16;
    }

    public void setShowPlayIcon(boolean z16) {
        this.f279366f = z16;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowDefaultView(Message message) {
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowErrorView() {
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPlayCompleteView() {
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPlayFloatCompleteView() {
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPlayingView() {
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowRetryView() {
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowStopView() {
        setVisibility(0);
        b();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowWaitView() {
        setVisibility(4);
    }

    private void a(boolean z16, boolean z17) {
        int i3 = 8;
        if (z16) {
            BaseVideoPresenter baseVideoPresenter = this.mBaseVideoPresenter;
            if (baseVideoPresenter != null) {
                if (baseVideoPresenter.isFreeTraffic()) {
                    this.f279365e.setVisibility(0);
                    this.f279364d.setVisibility(8);
                    this.f279367h.setVisibility(8);
                    return;
                }
                this.f279365e.setVisibility(8);
                this.f279364d.setVisibility(0);
                LinearLayout linearLayout = this.f279367h;
                if (this.C && !z17) {
                    i3 = 0;
                }
                linearLayout.setVisibility(i3);
                return;
            }
            return;
        }
        this.f279365e.setVisibility(8);
        this.f279364d.setVisibility(8);
        this.f279367h.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onUpdate() {
    }
}
