package com.tencent.biz.subscribe.widget.relativevideo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.bizdapters.SubscribeQCircleFeedsAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StQQSubscriptionPageData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleServiceFolderView extends BaseWidgetView {
    private LinearLayout E;
    private RecyclerView F;
    private TextView G;
    private LinearLayout H;
    private SubscribeQCircleFeedsAdapter I;

    public QCircleServiceFolderView(@NonNull Context context) {
        super(context);
    }

    private void v(View view, int i3) {
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
    public /* synthetic */ void w(QQCircleFeedBase$StQQSubscriptionPageData qQCircleFeedBase$StQQSubscriptionPageData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), qQCircleFeedBase$StQQSubscriptionPageData.viewMoreJumpUrl.get());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(final QQCircleFeedBase$StQQSubscriptionPageData qQCircleFeedBase$StQQSubscriptionPageData) {
        TextView textView = this.G;
        if (textView != null && this.H != null) {
            textView.setText(qQCircleFeedBase$StQQSubscriptionPageData.title.get());
            if (TextUtils.isEmpty(qQCircleFeedBase$StQQSubscriptionPageData.viewMoreJumpUrl.get())) {
                this.H.setVisibility(8);
            } else {
                this.H.setVisibility(0);
                this.H.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.subscribe.widget.relativevideo.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QCircleServiceFolderView.this.w(qQCircleFeedBase$StQQSubscriptionPageData, view);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
        try {
            qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        SubscribeQCircleFeedsAdapter subscribeQCircleFeedsAdapter = this.I;
        if (subscribeQCircleFeedsAdapter != null) {
            subscribeQCircleFeedsAdapter.q0(qQCircleFeedBase$StFeedListBusiRspData.entrySchema.get());
        }
        final QQCircleFeedBase$StQQSubscriptionPageData qQCircleFeedBase$StQQSubscriptionPageData = qQCircleFeedBase$StFeedListBusiRspData.qqSubscriptionPageData;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.relativevideo.f
            @Override // java.lang.Runnable
            public final void run() {
                QCircleServiceFolderView.this.x(qQCircleFeedBase$StQQSubscriptionPageData);
            }
        });
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected int i() {
        return R.layout.fsc;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void p(Context context, View view) {
        this.E = (LinearLayout) view.findViewById(R.id.f83384je);
        this.F = (RecyclerView) view.findViewById(R.id.f83374jd);
        this.F.setLayoutManager(new SafeGridLayoutManager(getContext(), 2));
        this.G = (TextView) view.findViewById(R.id.f83394jf);
        this.H = (LinearLayout) view.findViewById(R.id.f83364jc);
        SubscribeQCircleFeedsAdapter subscribeQCircleFeedsAdapter = new SubscribeQCircleFeedsAdapter();
        this.I = subscribeQCircleFeedsAdapter;
        this.F.setAdapter(subscribeQCircleFeedsAdapter);
    }

    public void setData(final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, int i3) {
        int size;
        if (this.I != null && this.E != null) {
            if (feedCloudRead$StGetFeedListRsp != null && feedCloudRead$StGetFeedListRsp.vecFeed.size() != 0) {
                List<FeedCloudMeta$StFeed> list = feedCloudRead$StGetFeedListRsp.vecFeed.get();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[setData] init data count: ");
                if (list == null) {
                    size = 0;
                } else {
                    size = list.size();
                }
                sb5.append(size);
                QLog.d("SCF-QCircleServiceFolderView", 1, sb5.toString());
                this.I.setDatas(list);
                this.I.s0(i3);
                this.I.p0(feedCloudRead$StGetFeedListRsp.feedAttchInfo.get());
                this.I.r0(feedCloudRead$StGetFeedListRsp.isFirstLogin.get());
                this.E.setVisibility(0);
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.subscribe.widget.relativevideo.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCircleServiceFolderView.this.y(feedCloudRead$StGetFeedListRsp);
                    }
                });
                v(this.H, i3);
                return;
            }
            this.E.setVisibility(8);
        }
    }

    public QCircleServiceFolderView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void c(Object obj) {
    }
}
