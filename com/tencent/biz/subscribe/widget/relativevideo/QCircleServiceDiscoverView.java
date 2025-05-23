package com.tencent.biz.subscribe.widget.relativevideo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.bizdapters.SubscribeQCircleFeedsAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleServiceDiscoverView extends BaseWidgetView {
    private RecyclerView E;
    private LinearLayout F;
    private SubscribeQCircleFeedsAdapter G;

    public QCircleServiceDiscoverView(@NonNull Context context) {
        super(context);
    }

    private void u(View view, int i3) {
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
    public /* synthetic */ void v(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
        try {
            qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        SubscribeQCircleFeedsAdapter subscribeQCircleFeedsAdapter = this.G;
        if (subscribeQCircleFeedsAdapter != null) {
            subscribeQCircleFeedsAdapter.q0(qQCircleFeedBase$StFeedListBusiRspData.entrySchema.get());
        }
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected int i() {
        return R.layout.fsa;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void p(Context context, View view) {
        this.E = (RecyclerView) view.findViewById(R.id.f83374jd);
        this.E.setLayoutManager(new SafeGridLayoutManager(getContext(), 2));
        this.F = (LinearLayout) view.findViewById(R.id.f83384je);
        SubscribeQCircleFeedsAdapter subscribeQCircleFeedsAdapter = new SubscribeQCircleFeedsAdapter();
        this.G = subscribeQCircleFeedsAdapter;
        this.E.setAdapter(subscribeQCircleFeedsAdapter);
    }

    public void setData(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, int i3, boolean z16) {
        int size;
        if (this.G != null && this.F != null) {
            if (z16 && (feedCloudRead$StGetFeedListRsp == null || feedCloudRead$StGetFeedListRsp.vecFeed.size() == 0)) {
                this.F.setVisibility(8);
                return;
            }
            if (feedCloudRead$StGetFeedListRsp == null) {
                QLog.e("SCF-QCircleServiceFolderView", 1, "[setData] rsp should not be null.");
                return;
            }
            List<FeedCloudMeta$StFeed> list = feedCloudRead$StGetFeedListRsp.vecFeed.get();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[setData] init data count: ");
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            sb5.append(size);
            QLog.e("SCF-QCircleServiceFolderView", 1, sb5.toString());
            if (z16) {
                this.G.setDatas(list);
                this.F.setVisibility(0);
                t(feedCloudRead$StGetFeedListRsp, i3);
            } else {
                this.G.addAll(list);
            }
            this.G.s0(i3);
            this.G.p0(feedCloudRead$StGetFeedListRsp.feedAttchInfo.get());
            this.G.r0(feedCloudRead$StGetFeedListRsp.isFirstLogin.get());
            u(this.F, i3);
        }
    }

    public void t(final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, int i3) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.subscribe.widget.relativevideo.d
            @Override // java.lang.Runnable
            public final void run() {
                QCircleServiceDiscoverView.this.v(feedCloudRead$StGetFeedListRsp);
            }
        });
    }

    public QCircleServiceDiscoverView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void c(Object obj) {
    }
}
