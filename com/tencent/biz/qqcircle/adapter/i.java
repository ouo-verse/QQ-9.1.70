package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.widgets.polymerization.QCirclePatSamePolymerizationHeadView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i extends com.tencent.biz.qqcircle.bizparts.c {
    private QCirclePatSamePolymerizationHeadView C;

    public i(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QCirclePatSamePolymerizationHeadView qCirclePatSamePolymerizationHeadView = new QCirclePatSamePolymerizationHeadView(viewGroup.getContext());
        this.C = qCirclePatSamePolymerizationHeadView;
        qCirclePatSamePolymerizationHeadView.setReportBean(getReportBean());
        return this.C;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QCirclePatSamePolymerizationHeadBlock";
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        List<E> list = this.mDataList;
        if (list != 0 && list.size() >= 1 && this.C != null) {
            QLog.d("QCirclePatSamePolymerizationHeadBlock", 1, "QCirclePatSamePolymerizationHeadBlock setData i" + i3);
            if (this.mDataList.get(i3) instanceof QQCircleFeedBase$StFeedListBusiRspData) {
                this.C.setData(((QQCircleFeedBase$StFeedListBusiRspData) this.mDataList.get(i3)).fashionCopyPageData.get());
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
