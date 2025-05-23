package com.tencent.biz.qqcircle.immersive.aggregation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalFeedHintView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSAggregationBottomHintView extends QCircleBaseWidgetView {

    /* renamed from: d, reason: collision with root package name */
    private QFSPersonalFeedHintView f84770d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f84771e;

    /* renamed from: f, reason: collision with root package name */
    private View f84772f;

    /* renamed from: h, reason: collision with root package name */
    private AlphaAnimation f84773h;

    public QFSAggregationBottomHintView(@NonNull Context context) {
        this(context, null);
    }

    private void initView() {
        this.f84770d = (QFSPersonalFeedHintView) findViewById(R.id.f371416g);
        this.f84771e = (FrameLayout) findViewById(R.id.f41821i4);
        this.f84772f = findViewById(R.id.f46341ub);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g7e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSAggregationBottomHintView";
    }

    public void k0() {
        this.f84770d.o0();
        this.f84771e.setVisibility(8);
        this.f84772f.clearAnimation();
    }

    public void l0(String str, String str2) {
        this.f84770d.B0(str, str2);
        this.f84771e.setVisibility(8);
    }

    public void m0(String str, String str2) {
        this.f84770d.C0(str, str2);
        this.f84771e.setVisibility(8);
    }

    public void n0() {
        this.f84770d.setVisibility(8);
        this.f84771e.setVisibility(0);
        if (this.f84773h == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.5f);
            this.f84773h = alphaAnimation;
            alphaAnimation.setRepeatMode(2);
            this.f84773h.setRepeatCount(Integer.MAX_VALUE);
            this.f84773h.setDuration(1000L);
        }
        this.f84772f.startAnimation(this.f84773h);
    }

    public QFSAggregationBottomHintView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSAggregationBottomHintView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initView();
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(Object obj) {
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
