package com.tencent.biz.qqcircle.immersive.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.LoadingUtil;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerRefreshHeaderView extends QCircleBaseWidgetView implements b {
    private String C;
    private Runnable D;

    /* renamed from: d, reason: collision with root package name */
    private String f89636d;

    /* renamed from: e, reason: collision with root package name */
    private String f89637e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f89638f;

    /* renamed from: h, reason: collision with root package name */
    private QFSPageTurnContainer.j f89639h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f89640i;

    /* renamed from: m, reason: collision with root package name */
    private String f89641m;

    public QFSLayerRefreshHeaderView(@NonNull Context context) {
        this(context, null);
    }

    private void o0(View view) {
        this.f89638f = (TextView) view.findViewById(R.id.f109086ev);
        ImageView imageView = (ImageView) view.findViewById(R.id.efs);
        this.f89640i = imageView;
        imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
        this.f89641m = getResources().getString(R.string.f195984g3);
        this.f89637e = getResources().getString(R.string.f195974g2);
        this.f89636d = getResources().getString(R.string.f196004g5);
        this.C = getResources().getString(R.string.f195994g4);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public /* synthetic */ int B() {
        return a.a(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void C(QFSPullRefreshLayout qFSPullRefreshLayout, boolean z16) {
        RFWThreadManager.getUIHandler().postDelayed(this.D, 300L);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void D(QFSPullRefreshLayout qFSPullRefreshLayout, float f16) {
        if (f16 >= 1.0f) {
            this.f89638f.setText(this.C);
        } else {
            this.f89638f.setText(this.f89641m);
        }
        if (f16 < 0.5d) {
            setVisibility(8);
        } else {
            this.f89638f.setAlpha((f16 - 0.5f) * 2.0f);
            setVisibility(0);
            this.f89638f.setVisibility(0);
        }
        invalidate();
        QFSPageTurnContainer.j jVar = this.f89639h;
        if (jVar != null) {
            jVar.c(false, f16);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void U(QFSPullRefreshLayout qFSPullRefreshLayout) {
        this.f89638f.setText(this.f89641m);
        invalidate();
        QFSPageTurnContainer.j jVar = this.f89639h;
        if (jVar != null) {
            jVar.a(false);
        }
        QLog.d("QFSLayerRefreshHeaderView", 1, "onStart");
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public int b0() {
        return cx.a(48.0f);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gg7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return null;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void release() {
        super.release();
        RFWThreadManager.getUIHandler().removeCallbacks(this.D);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void s(QFSPullRefreshLayout qFSPullRefreshLayout) {
        this.f89638f.setText(this.f89637e);
        this.f89640i.setVisibility(0);
        invalidate();
        QFSPageTurnContainer.j jVar = this.f89639h;
        if (jVar != null) {
            jVar.b(false);
        }
        QLog.d("QFSLayerRefreshHeaderView", 1, HippyScrollViewEventHelper.EVENT_TYPE_REFRESH);
    }

    public void setCustomLoadingText(String str) {
        this.f89637e = str;
    }

    public void setCustomLooseFreshText(String str) {
        this.C = str;
    }

    public void setCustomPullFreshText(String str) {
        this.f89641m = str;
    }

    public void setCustomRefreshSuccessText(String str) {
        this.f89636d = str;
    }

    public void setOnRefreshViewStatusListener(QFSPageTurnContainer.j jVar) {
        this.f89639h = jVar;
    }

    public QFSLayerRefreshHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.refresh.QFSLayerRefreshHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QFSLayerRefreshHeaderView.this.f89640i != null && QFSLayerRefreshHeaderView.this.f89638f != null) {
                    QFSLayerRefreshHeaderView.this.f89638f.setText(QFSLayerRefreshHeaderView.this.f89636d);
                    QFSLayerRefreshHeaderView.this.f89638f.setVisibility(8);
                    QFSLayerRefreshHeaderView.this.f89640i.clearAnimation();
                    QFSLayerRefreshHeaderView.this.f89640i.setVisibility(8);
                    QFSLayerRefreshHeaderView.this.invalidate();
                    if (QFSLayerRefreshHeaderView.this.f89639h != null) {
                        QFSLayerRefreshHeaderView.this.f89639h.onComplete(false);
                    }
                    QLog.d("QFSLayerRefreshHeaderView", 1, "onComplete");
                }
            }
        };
        o0(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public View getRefreshView() {
        return this;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(Object obj) {
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void A(float f16, boolean z16) {
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
