package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.comment.QFSCommentFeedDescItemView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class u extends com.tencent.biz.qqcircle.bizparts.c {
    private QFSCommentFeedDescItemView C;
    private FeedCloudMeta$StFeed D;
    private com.tencent.biz.qqcircle.widgets.comment.c E;

    public u(Bundle bundle) {
        super(bundle);
    }

    private void l0(@NonNull QFSCommentItemInfo qFSCommentItemInfo, @NonNull QFSCommentInfo qFSCommentInfo) {
        if (qFSCommentInfo.mFrom == 1) {
            qFSCommentItemInfo.mContentLimitLines = 3;
            qFSCommentItemInfo.mDefaultExpanded = true;
        } else {
            qFSCommentItemInfo.mContentLimitLines = 3;
            qFSCommentItemInfo.mDefaultExpanded = false;
        }
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSCommentFeedDescItemView qFSCommentFeedDescItemView = new QFSCommentFeedDescItemView(viewGroup.getContext());
        this.C = qFSCommentFeedDescItemView;
        qFSCommentFeedDescItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.C.setReportBean(getReportBean());
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getFixedViewTypeOffset() {
        return 100000;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        if (RFSafeListUtils.isEmpty(this.mDataList)) {
            return super.getItemId(i3);
        }
        if (this.mDataList.get(0) == null) {
            return super.getItemId(i3);
        }
        return r0.hashCode();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSCommentFeedDescBlock";
    }

    public QFSCommentItemInfo i0() {
        if (RFSafeListUtils.isEmpty(this.mDataList) || !(this.mDataList.get(0) instanceof QFSCommentItemInfo)) {
            return null;
        }
        QFSCommentItemInfo qFSCommentItemInfo = (QFSCommentItemInfo) this.mDataList.get(0);
        if (qFSCommentItemInfo.type != 1) {
            return null;
        }
        return qFSCommentItemInfo;
    }

    public void j0(com.tencent.biz.qqcircle.widgets.comment.c cVar) {
        this.E = cVar;
    }

    public void k0(QFSCommentInfo qFSCommentInfo, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.D = feedCloudMeta$StFeed;
        QFSCommentItemInfo i06 = i0();
        if (i06 == null) {
            i06 = new QFSCommentItemInfo(1);
            i06.comment = new FeedCloudMeta$StComment();
        }
        l0(i06, qFSCommentInfo);
        this.mDataList.add(0, i06);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        List<E> list = this.mDataList;
        if (list != 0 && list.size() >= 1 && this.C != null && (this.mDataList.get(i3) instanceof QFSCommentItemInfo)) {
            this.C.setFeed(this.D);
            this.C.setOnCommentElementClickListener(this.E);
            this.C.bindData((QFSCommentItemInfo) this.mDataList.get(i3), i3);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
