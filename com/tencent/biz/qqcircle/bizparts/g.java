package com.tencent.biz.qqcircle.bizparts;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleHostPushListHeadWidget;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g extends c {
    private QCircleHostPushListHeadWidget C;
    private FeedCloudMeta$StFeed D;

    public g(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QCircleHostPushListHeadWidget qCircleHostPushListHeadWidget = new QCircleHostPushListHeadWidget(getContext());
        this.C = qCircleHostPushListHeadWidget;
        qCircleHostPushListHeadWidget.setData(this.D);
        return this.C;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QCircleHostPushListHeadBlock";
    }

    public void i0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.f398449id != null) {
            this.D = feedCloudMeta$StFeed;
            QCircleHostPushListHeadWidget qCircleHostPushListHeadWidget = this.C;
            if (qCircleHostPushListHeadWidget != null) {
                qCircleHostPushListHeadWidget.setData(feedCloudMeta$StFeed);
            }
        }
    }

    public void j0(int i3) {
        QCircleHostPushListHeadWidget qCircleHostPushListHeadWidget = this.C;
        if (qCircleHostPushListHeadWidget == null) {
            return;
        }
        qCircleHostPushListHeadWidget.setHostEmptyViewVisibility(i3);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
