package com.tencent.mobileqq.qzoneplayer.cover.widget;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoClickElement;
import com.tencent.mobileqq.qzoneplayer.cover.presenter.BaseVideoPresenter;
import com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes35.dex */
public class d extends AbsCoverUI {
    protected ImageView C;
    protected ImageView D;
    protected ImageView E;
    protected boolean F;

    /* renamed from: d, reason: collision with root package name */
    protected LinearLayout f279374d;

    /* renamed from: e, reason: collision with root package name */
    protected LinearLayout f279375e;

    /* renamed from: f, reason: collision with root package name */
    protected LinearLayout f279376f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f279377h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f279378i;

    /* renamed from: m, reason: collision with root package name */
    protected TextView f279379m;

    public d(Context context) {
        super(context);
        this.F = false;
    }

    private void d() {
        if (!a()) {
            if (this.F) {
                this.f279375e.setVisibility(8);
                this.f279376f.setVisibility(8);
                this.f279374d.setVisibility(0);
                return;
            } else {
                this.f279375e.setVisibility(0);
                this.f279376f.setVisibility(0);
                this.f279374d.setVisibility(0);
                b();
                return;
            }
        }
        this.f279375e.setVisibility(0);
        this.f279376f.setVisibility(8);
        this.f279374d.setVisibility(0);
    }

    protected boolean a() {
        BaseVideoPresenter baseVideoPresenter = this.mBaseVideoPresenter;
        return baseVideoPresenter != null && baseVideoPresenter.isLandscapeMode();
    }

    protected void b() {
        int coverWidth;
        int i3 = FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH * 3;
        int i16 = FeedVideoEnv.dp60;
        int i17 = i3 + (i16 * 2);
        if (this.mParentView.getWidth() != 0) {
            coverWidth = this.mParentView.getWidth();
        } else {
            coverWidth = this.mBaseVideoPresenter.getCoverWidth();
        }
        if (this.mParentView.getWidth() != 0 && this.mParentView.getWidth() < i17) {
            i16 = (this.mParentView.getWidth() - ((this.f279374d.getWidth() + this.f279375e.getWidth()) + this.f279376f.getWidth())) / 2;
        } else if (this.mParentView.getWidth() == 0 && coverWidth < i17) {
            i16 = (coverWidth - (FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH * 3)) / 2;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f279375e.getLayoutParams();
        marginLayoutParams.leftMargin = i16;
        this.f279375e.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f279376f.getLayoutParams();
        marginLayoutParams2.leftMargin = i16;
        this.f279376f.setLayoutParams(marginLayoutParams2);
    }

    public void c(boolean z16) {
        this.F = z16;
        updateUI();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected int getLayoutId() {
        return FeedVideoEnv.feedResources.getLayoutId(15);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void initChildView() {
        this.f279374d = (LinearLayout) findViewById(FeedVideoEnv.feedResources.getViewId(607));
        this.f279375e = (LinearLayout) findViewById(FeedVideoEnv.feedResources.getViewId(608));
        this.f279376f = (LinearLayout) findViewById(FeedVideoEnv.feedResources.getViewId(609));
        this.f279377h = (TextView) findViewById(FeedVideoEnv.feedResources.getViewId(604));
        this.f279378i = (TextView) findViewById(FeedVideoEnv.feedResources.getViewId(605));
        this.f279379m = (TextView) findViewById(FeedVideoEnv.feedResources.getViewId(606));
        this.C = (ImageView) findViewById(FeedVideoEnv.feedResources.getViewId(601));
        this.D = (ImageView) findViewById(FeedVideoEnv.feedResources.getViewId(602));
        this.E = (ImageView) findViewById(FeedVideoEnv.feedResources.getViewId(603));
        this.C.setImageDrawable(FeedVideoEnv.getFloatReplayDrawable());
        this.D.setImageDrawable(FeedVideoEnv.getFloatRedPacketDrawable());
        this.E.setImageDrawable(FeedVideoEnv.getFloatMoreDrawable());
        this.f279377h.setText(FeedVideoEnv.feedResources.getString(1380));
        this.f279378i.setText(FeedVideoEnv.feedResources.getString(1379));
        this.f279379m.setText(FeedVideoEnv.feedResources.getString(1378));
        this.f279374d.setOnClickListener(this);
        this.f279375e.setOnClickListener(this);
        this.f279376f.setOnClickListener(this);
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.mBaseVideoClickListener != null) {
            if (view.getId() == FeedVideoEnv.feedResources.getViewId(607)) {
                this.mBaseVideoClickListener.onClick(view, isAdv(), VideoClickElement.FLOAT_COMPLETE_PAGE_REPLAY, this.mPos, null);
            } else if (view.getId() == FeedVideoEnv.feedResources.getViewId(608)) {
                this.mBaseVideoClickListener.onClick(view, isAdv(), VideoClickElement.FLOAT_COMPLETE_PAGE_REDPOCKET, this.mPos, null);
            } else if (view.getId() == FeedVideoEnv.feedResources.getViewId(609)) {
                this.mBaseVideoClickListener.onClick(view, isAdv(), VideoClickElement.FLOAT_COMPLETE_PAGE_MORE, this.mPos, null);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onShowPlayFloatCompleteView() {
        BaseVideoPresenter baseVideoPresenter = this.mBaseVideoPresenter;
        if (baseVideoPresenter != null && baseVideoPresenter.mIsShowVideoFloatCompletePage) {
            setVisibility(0);
            d();
        } else {
            setVisibility(4);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onUpdateUI() {
        d();
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

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI, com.tencent.mobileqq.qzoneplayer.video.Recycleable
    public void onRecycled() {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsCoverUI
    protected void onUpdate() {
    }
}
