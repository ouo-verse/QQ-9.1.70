package com.tencent.biz.qqcircle.immersive.aggregation.widget;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.QFSFlowAggregationFragment;
import com.tencent.biz.qqcircle.immersive.aggregation.QFSFlowAggregationViewModel;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StImage;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StUnifiedTagPageData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSAggregationUnifiedTagHeadWidget extends QFSAggregationHeadWidgetView {
    private QFSFlowAggregationFragment C;
    private SquareImageView D;
    private TextView E;
    private TextView F;
    private QQCircleFeedBase$StUnifiedTagPageData G;
    private QFSFlowAggregationViewModel H;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Observer<UIStateData<QQCircleFeedBase$StFeedListBusiRspData>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<QQCircleFeedBase$StFeedListBusiRspData> uIStateData) {
            QFSAggregationUnifiedTagHeadWidget.this.n0(uIStateData);
        }
    }

    public QFSAggregationUnifiedTagHeadWidget(@NonNull Context context, QFSFlowAggregationFragment qFSFlowAggregationFragment) {
        super(context);
        initView();
        this.C = qFSFlowAggregationFragment;
        o0();
    }

    private void initView() {
        this.D = (SquareImageView) findViewById(R.id.duw);
        this.E = (TextView) findViewById(R.id.kbs);
        this.F = (TextView) findViewById(R.id.f107316a3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(UIStateData<QQCircleFeedBase$StFeedListBusiRspData> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        int state = uIStateData.getState();
        if (state == 2 || state == 3) {
            p0(uIStateData.getData());
        }
    }

    private void p0(QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData) {
        if (qQCircleFeedBase$StFeedListBusiRspData == null) {
            return;
        }
        this.G = qQCircleFeedBase$StFeedListBusiRspData.unifiedTagPageData.get();
        q0();
        r0();
    }

    private void q0() {
        FeedCloudMeta$StImage feedCloudMeta$StImage = this.G.pageIcon;
        if (feedCloudMeta$StImage != null && feedCloudMeta$StImage.picUrl != null) {
            Option targetView = Option.obtain().setUrl(this.G.pageIcon.picUrl.get()).setFailDrawable(getContext().getResources().getDrawable(R.drawable.onq)).setLoadingDrawable(getContext().getResources().getDrawable(R.drawable.onq)).setTargetView(this.D);
            QCircleFeedPicLoader.setViewWidthHeight(targetView, this.D);
            QCircleFeedPicLoader.g().loadImage(targetView);
        }
    }

    private void r0() {
        this.E.setText(this.G.title.get());
        this.F.setText(this.G.desc.get());
    }

    @Override // com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationHeadWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g7n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationHeadWidgetView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSAggregationUnifiedTagHeadWidget";
    }

    protected void o0() {
        QFSFlowAggregationViewModel qFSFlowAggregationViewModel = (QFSFlowAggregationViewModel) getViewModel(this.C, QFSFlowAggregationViewModel.class);
        this.H = qFSFlowAggregationViewModel;
        qFSFlowAggregationViewModel.X1().observe(this, new a());
    }
}
