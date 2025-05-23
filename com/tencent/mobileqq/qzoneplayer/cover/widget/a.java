package com.tencent.mobileqq.qzoneplayer.cover.widget;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.qzone.widget.AsyncImageView;
import com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a extends AbsCoverUI {

    /* renamed from: d, reason: collision with root package name */
    private AsyncImageView f279360d;

    /* renamed from: e, reason: collision with root package name */
    private AsyncImageView f279361e;

    /* renamed from: f, reason: collision with root package name */
    private Button f279362f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f279363h;

    public a(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected int getLayoutId() {
        return FeedVideoEnv.feedResources.getLayoutId(23);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void initChildView() {
        this.f279360d = (AsyncImageView) findViewById(FeedVideoEnv.feedResources.getViewId(631));
        this.f279361e = (AsyncImageView) findViewById(FeedVideoEnv.feedResources.getViewId(634));
        this.f279362f = (Button) findViewById(FeedVideoEnv.feedResources.getViewId(632));
        this.f279363h = (TextView) findViewById(FeedVideoEnv.feedResources.getViewId(633));
        this.f279361e.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_video_paster_adv_feedback_icon.png");
        this.f279360d.setOnClickListener(this);
        this.f279361e.setOnClickListener(this);
        this.f279362f.setOnClickListener(this);
        this.f279363h.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
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
        setVisibility(4);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPlayFloatCompleteView() {
        setVisibility(0);
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
    protected void onShowPlayingView() {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onUpdate() {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public void reset() {
    }
}
