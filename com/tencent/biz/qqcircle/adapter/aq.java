package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.widgets.search.QFSSearchTopHashTagResultView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import feedcloud.FeedCloudRead$StSearchMixTag;

/* compiled from: P */
/* loaded from: classes4.dex */
public class aq extends com.tencent.biz.qqcircle.bizparts.c {
    private QFSSearchTopHashTagResultView C;
    private QFSSearchInfo D;
    private String E;

    public aq(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSSearchTopHashTagResultView qFSSearchTopHashTagResultView = new QFSSearchTopHashTagResultView(viewGroup.getContext(), this.D);
        this.C = qFSSearchTopHashTagResultView;
        qFSSearchTopHashTagResultView.setTransferInfo(this.E);
        return this.C;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSSearchTopHashTagResultBlock";
    }

    public void i0(String str) {
        this.E = str;
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (RFSafeListUtils.isEmpty(this.mDataList) || i3 < 0 || this.mDataList.size() <= i3 || this.C == null || !(this.mDataList.get(i3) instanceof FeedCloudRead$StSearchMixTag)) {
            return;
        }
        this.C.setData((FeedCloudRead$StSearchMixTag) this.mDataList.get(i3));
    }

    public void setCurrentSearchInfo(QFSSearchInfo qFSSearchInfo) {
        this.D = qFSSearchInfo;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
