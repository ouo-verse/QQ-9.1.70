package com.qzone.reborn.feedx.itemview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.qzone.reborn.feedx.itemview.QZoneFeedxEmptyPageView;
import com.qzone.reborn.feedx.viewmodel.t;
import com.qzone.reborn.feedx.viewmodel.w;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneEmptyOrForbiddenView extends QZoneBaseWidgetView {

    /* renamed from: e, reason: collision with root package name */
    private Context f54815e;

    /* renamed from: f, reason: collision with root package name */
    private QZoneFeedxEmptyPageView f54816f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f54817h;

    /* renamed from: i, reason: collision with root package name */
    private QZoneUserHomeQuestionPageView f54818i;

    /* renamed from: m, reason: collision with root package name */
    private View f54819m;

    public QZoneEmptyOrForbiddenView(Context context) {
        super(context);
        this.f54815e = context;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        n0(this);
    }

    private void m0() {
        if (this.f54818i == null) {
            QZoneUserHomeQuestionPageView qZoneUserHomeQuestionPageView = new QZoneUserHomeQuestionPageView(this.f54815e);
            this.f54818i = qZoneUserHomeQuestionPageView;
            addView(qZoneUserHomeQuestionPageView);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f129616j;
    }

    public void o0(boolean z16) {
        View view = this.f54819m;
        if (view != null) {
            view.setBackgroundResource(z16 ? R.drawable.lvj : R.drawable.qui_common_bg_bottom_light_bg);
        }
        QZoneUserHomeQuestionPageView qZoneUserHomeQuestionPageView = this.f54818i;
        if (qZoneUserHomeQuestionPageView != null) {
            qZoneUserHomeQuestionPageView.D0(z16);
        }
        QZoneFeedxEmptyPageView qZoneFeedxEmptyPageView = this.f54816f;
        if (qZoneFeedxEmptyPageView != null) {
            qZoneFeedxEmptyPageView.y0(z16);
        }
    }

    public void onDestroy() {
        QZoneUserHomeQuestionPageView qZoneUserHomeQuestionPageView = this.f54818i;
        if (qZoneUserHomeQuestionPageView != null) {
            qZoneUserHomeQuestionPageView.onDestroy();
        }
    }

    public void setEmptyPageViewVisibility(boolean z16, QZoneFeedxEmptyPageView.a aVar) {
        QZoneFeedxEmptyPageView qZoneFeedxEmptyPageView = this.f54816f;
        if (qZoneFeedxEmptyPageView == null) {
            return;
        }
        qZoneFeedxEmptyPageView.setEmptyPageViewBuilder(aVar, this.f54817h);
        this.f54816f.setEmptyPageContainerVisibility(z16);
    }

    public void setQuestionPageViewVisibility(boolean z16, x6.a aVar, w wVar, t tVar) {
        if (z16) {
            if (this.f54818i == null) {
                m0();
            }
            this.f54818i.setUserHomeViewModel(wVar);
            this.f54818i.setForbiddenPageViewModel(tVar);
            this.f54818i.setUserInfoData(aVar);
            this.f54818i.setVisibility(0);
            return;
        }
        QZoneUserHomeQuestionPageView qZoneUserHomeQuestionPageView = this.f54818i;
        if (qZoneUserHomeQuestionPageView != null) {
            qZoneUserHomeQuestionPageView.setVisibility(8);
        }
    }

    private void n0(View view) {
        if (view == null) {
            return;
        }
        this.f54819m = view;
        this.f54816f = new QZoneFeedxEmptyPageView(this.f54815e);
        this.f54817h = (LinearLayout) view.findViewById(R.id.f20528m);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
