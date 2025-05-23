package com.tencent.biz.subscribe.widget.relativevideo;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StQQSubscriptionPageData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleServiceDiscoverHeadView extends BaseWidgetView<FeedCloudMeta$StFeed> {
    private View E;
    private TextView F;
    private LinearLayout G;

    public QCircleServiceDiscoverHeadView(@NonNull @android.support.annotation.NonNull Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
        try {
            qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        final QQCircleFeedBase$StQQSubscriptionPageData qQCircleFeedBase$StQQSubscriptionPageData = qQCircleFeedBase$StFeedListBusiRspData.qqSubscriptionPageData;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.relativevideo.b
            @Override // java.lang.Runnable
            public final void run() {
                QCircleServiceDiscoverHeadView.this.z(qQCircleFeedBase$StQQSubscriptionPageData);
            }
        });
    }

    private void x(View view, int i3) {
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_DYH_MORE_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (i3 == 46) {
            VideoReport.setPageId(this, QCircleDaTongConstant.PageId.PG_DYH_EXPLORE_PAGE);
        } else if (i3 == 45) {
            VideoReport.setPageId(this, QCircleDaTongConstant.PageId.PG_DYH_FOLLOWING_PAGE);
        }
        VideoReport.setElementParams(view, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(QQCircleFeedBase$StQQSubscriptionPageData qQCircleFeedBase$StQQSubscriptionPageData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), qQCircleFeedBase$StQQSubscriptionPageData.viewMoreJumpUrl.get());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(final QQCircleFeedBase$StQQSubscriptionPageData qQCircleFeedBase$StQQSubscriptionPageData) {
        TextView textView = this.F;
        if (textView != null && this.G != null) {
            textView.setText(qQCircleFeedBase$StQQSubscriptionPageData.title.get());
            if (TextUtils.isEmpty(qQCircleFeedBase$StQQSubscriptionPageData.viewMoreJumpUrl.get())) {
                this.G.setVisibility(8);
            } else {
                this.G.setVisibility(0);
                this.G.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.subscribe.widget.relativevideo.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QCircleServiceDiscoverHeadView.this.y(qQCircleFeedBase$StQQSubscriptionPageData, view);
                    }
                });
            }
        }
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected int i() {
        return R.layout.fsb;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void p(Context context, View view) {
        this.E = view;
        this.F = (TextView) view.findViewById(R.id.f83394jf);
        this.G = (LinearLayout) view.findViewById(R.id.f83364jc);
    }

    public void setData(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, int i3, boolean z16) {
        if (z16 && (feedCloudRead$StGetFeedListRsp == null || feedCloudRead$StGetFeedListRsp.vecFeed.size() == 0)) {
            this.E.setVisibility(8);
        } else if (z16) {
            this.E.setVisibility(0);
            v(feedCloudRead$StGetFeedListRsp, i3);
        }
    }

    public void v(final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, int i3) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.subscribe.widget.relativevideo.a
            @Override // java.lang.Runnable
            public final void run() {
                QCircleServiceDiscoverHeadView.this.A(feedCloudRead$StGetFeedListRsp);
            }
        });
        x(this.G, i3);
    }

    public QCircleServiceDiscoverHeadView(@NonNull @android.support.annotation.NonNull Context context, @Nullable @android.support.annotation.Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QCircleServiceDiscoverHeadView(@NonNull @android.support.annotation.NonNull Context context, @Nullable @android.support.annotation.Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
    }
}
