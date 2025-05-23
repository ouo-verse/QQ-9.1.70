package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.widgets.polymerization.QCircleSchoolPolymerizationHeadView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j extends com.tencent.biz.qqcircle.bizparts.c {
    private QCircleSchoolPolymerizationHeadView C;
    private QCirclePolymerizationBean D;

    public j(Bundle bundle) {
        super(bundle);
        if (bundle != null) {
            this.D = (QCirclePolymerizationBean) bundle.getSerializable("key_block_bundle_bean");
        }
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QCircleSchoolPolymerizationHeadView qCircleSchoolPolymerizationHeadView = new QCircleSchoolPolymerizationHeadView(viewGroup.getContext(), this.D);
        this.C = qCircleSchoolPolymerizationHeadView;
        qCircleSchoolPolymerizationHeadView.setReportBean(getReportBean());
        return this.C;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QCircleSchoolPolymerizationHeadBlock";
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        List<E> list = this.mDataList;
        if (list != 0 && list.size() >= 1 && this.C != null) {
            QLog.d("QCircleSchoolPolymerizationHeadBlock", 1, "QCircleSchoolPolymerizationHeadView setData i" + i3);
            if (this.mDataList.get(i3) instanceof QQCircleFeedBase$StFeedListBusiRspData) {
                this.C.setData(((QQCircleFeedBase$StFeedListBusiRspData) this.mDataList.get(i3)).schoolPageData.get());
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
