package com.tencent.mobileqq.qzoneplayer.cover.view;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a extends AbsCoverUI {

    /* renamed from: d, reason: collision with root package name */
    public LoadingView f279359d;

    public a(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected int getLayoutId() {
        return FeedVideoEnv.feedResources.getLayoutId(19);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void initChildView() {
        LoadingView loadingView = new LoadingView(this.mContext);
        this.f279359d = loadingView;
        addView(loadingView);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f279359d.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 17;
        this.f279359d.setLayoutParams(layoutParams);
        setVisibility(8);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    public void reset() {
        super.reset();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowDefaultView(Message message) {
        setVisibility(4);
        this.f279359d.d();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowErrorView() {
        setVisibility(4);
        this.f279359d.d();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPauseView() {
        setVisibility(4);
        this.f279359d.d();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPlayCompleteView() {
        setVisibility(4);
        this.f279359d.d();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPlayFloatCompleteView() {
        setVisibility(4);
        this.f279359d.d();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPlayingView() {
        setVisibility(4);
        this.f279359d.d();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowRetryView() {
        setVisibility(4);
        this.f279359d.d();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowStopView() {
        setVisibility(4);
        this.f279359d.d();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowWaitView() {
        setVisibility(0);
        this.f279359d.c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onUpdate() {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onUpdateUI() {
    }
}
