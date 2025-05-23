package com.tencent.mobileqq.qzoneplayer.cover.widget;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoClickElement;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoData;
import com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c extends AbsCoverUI {

    /* renamed from: d, reason: collision with root package name */
    protected TextView f279370d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f279371e;

    /* renamed from: f, reason: collision with root package name */
    protected String f279372f;

    /* renamed from: h, reason: collision with root package name */
    protected String f279373h;

    public c(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected int getLayoutId() {
        return FeedVideoEnv.feedResources.getLayoutId(18);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void initChildView() {
        this.f279371e = (TextView) findViewById(FeedVideoEnv.feedResources.getViewId(617));
        this.f279370d = (TextView) findViewById(FeedVideoEnv.feedResources.getViewId(618));
        this.f279371e.setOnClickListener(this);
        this.f279370d.setOnClickListener(this);
        setVisibility(8);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public boolean isViewGroup() {
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.mBaseVideoClickListener != null) {
            if (view.getId() == FeedVideoEnv.feedResources.getViewId(617)) {
                this.mBaseVideoClickListener.onClick(view, isAdv(), VideoClickElement.COMPLETE_PAGE_RETRY_ICON, this.mPos, null);
            } else if (view.getId() == FeedVideoEnv.feedResources.getViewId(618)) {
                this.mBaseVideoClickListener.onClick(view, isAdv(), VideoClickElement.COMPLETE_PAGE_MORE_ICON, this.mPos, null);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onUpdate() {
        VideoData.BaseVideoCoverData baseVideoCoverData;
        VideoPlayInfo videoPlayInfo;
        VideoData videoData = this.mBaseVideoData;
        if (videoData != null && (baseVideoCoverData = videoData.baseVideoCoverData) != null && (videoPlayInfo = baseVideoCoverData.videoPlayInfo) != null) {
            if (videoPlayInfo.k()) {
                this.f279372f = FeedVideoEnv.feedResources.getString(1366);
                this.f279373h = FeedVideoEnv.feedResources.getString(1367);
                return;
            }
            return;
        }
        this.f279372f = FeedVideoEnv.feedResources.getString(1368);
        this.f279373h = FeedVideoEnv.feedResources.getString(1369);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public void reset() {
        super.reset();
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
    protected void onShowPauseView() {
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPlayCompleteView() {
        setVisibility(0);
        if (!TextUtils.isEmpty(this.f279372f)) {
            this.f279370d.setText(this.f279372f);
        }
        if (TextUtils.isEmpty(this.f279373h)) {
            return;
        }
        this.f279371e.setText(this.f279373h);
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
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowWaitView() {
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onUpdateUI() {
    }
}
