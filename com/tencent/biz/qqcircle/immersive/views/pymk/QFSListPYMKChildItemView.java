package com.tencent.biz.qqcircle.immersive.views.pymk;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import fb0.a;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes4.dex */
public class QFSListPYMKChildItemView extends QCircleBaseWidgetView<FeedCloudMeta$StFeed> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private RoundCorneredRelativeLayout f91015d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f91016e;

    /* renamed from: f, reason: collision with root package name */
    private FeedCloudMeta$StFeed f91017f;

    /* renamed from: h, reason: collision with root package name */
    private int f91018h;

    /* renamed from: i, reason: collision with root package name */
    private String f91019i;

    public QFSListPYMKChildItemView(Context context) {
        super(context);
        initView();
    }

    private void k0() {
        int g16 = (cx.g() - (cx.a(16.0f) * 3)) / 3;
        QLog.d("QFSListPYMKChildItemView", 4, "adjustViewSize:" + g16);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f91015d.getLayoutParams();
        layoutParams.width = g16;
        this.f91015d.setLayoutParams(layoutParams);
    }

    private void m0(QCircleBaseWidgetView qCircleBaseWidgetView) {
        if (qCircleBaseWidgetView == null) {
            return;
        }
        QCircleLayerBean n06 = n0();
        int[] iArr = new int[2];
        qCircleBaseWidgetView.getLocationInWindow(iArr);
        QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
        int i3 = iArr[0];
        n06.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i3, iArr[1], qCircleBaseWidgetView.getWidth() + i3, iArr[1] + qCircleBaseWidgetView.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(this.f91017f.cover.picUrl.get()));
        if (this.f91016e != null) {
            n06.getTransitionAnimBean().setCoverDrawable(this.f91016e.getDrawable());
        }
        c.u(getContext(), n06);
    }

    private void o0() {
        if (a.a("QFSListPYMKChildItemView")) {
            return;
        }
        m0(this);
        QLog.d("QFSListPYMKChildItemView", 4, "openDetailActivity:");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gpn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSListPYMKChildItemView";
    }

    protected void initView() {
        this.f91015d = (RoundCorneredRelativeLayout) findViewById(R.id.f512527l);
        ImageView imageView = (ImageView) findViewById(R.id.f512627m);
        this.f91016e = imageView;
        imageView.setOnClickListener(this);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        this.f91017f = feedCloudMeta$StFeed;
        this.f91018h = i3;
        int a16 = cx.a(4.0f);
        k0();
        float f16 = a16;
        this.f91015d.setRadius(f16, f16, f16, f16);
        Option targetView = Option.obtain().setUrl(feedCloudMeta$StFeed.cover.picUrl.get()).setTargetView(this.f91016e);
        targetView.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        QCircleFeedPicLoader.g().loadImage(targetView);
    }

    public QCircleLayerBean n0() {
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleLayerBean.setFeed(this.f91017f);
        qCircleLayerBean.setDataPosInList(this.f91018h);
        qCircleLayerBean.setTransInitBean(qCircleInitBean);
        qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
        qCircleLayerBean.setGlobalViewModelKey(this.f91019i);
        return qCircleLayerBean;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f512627m) {
            o0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setViewModelKey(String str) {
        this.f91019i = str;
    }
}
