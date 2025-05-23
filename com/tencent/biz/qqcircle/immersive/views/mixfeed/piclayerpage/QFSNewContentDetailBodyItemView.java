package com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage;

import android.content.Context;
import android.content.res.Configuration;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSNewContentDetailBodyItemView extends QCircleBaseWidgetView<FeedCloudMeta$StFeed> {

    /* renamed from: d, reason: collision with root package name */
    private final m f90958d;

    public QFSNewContentDetailBodyItemView(@NonNull Context context, @NonNull QCircleInitBean qCircleInitBean) {
        super(context);
        this.f90958d = new m();
        l0(qCircleInitBean);
    }

    private void l0(@NonNull QCircleInitBean qCircleInitBean) {
        this.f90958d.c(new h(qCircleInitBean));
        this.f90958d.c(new d());
        this.f90958d.i(this);
    }

    public void f() {
        this.f90958d.j();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gjs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSNewContentDetailBodyItemView";
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        this.f90958d.f(feedCloudMeta$StFeed, i3);
    }

    public void m0() {
        this.f90958d.k();
    }

    public void n0() {
        this.f90958d.l();
    }

    public void o0() {
        this.f90958d.m();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f90958d.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f90958d.g(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f90958d.h();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void setParentView(ViewGroup viewGroup) {
        super.setParentView(viewGroup);
        this.f90958d.n(this.mParentView);
    }
}
