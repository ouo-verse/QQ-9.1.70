package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.polymerization.QFSPolymerizationTagBottomView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class aj extends com.tencent.biz.qqcircle.bizparts.c {
    private QFSPolymerizationTagBottomView C;

    public aj(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSPolymerizationTagBottomView qFSPolymerizationTagBottomView = new QFSPolymerizationTagBottomView(viewGroup.getContext(), getParentRecyclerView());
        this.C = qFSPolymerizationTagBottomView;
        return qFSPolymerizationTagBottomView;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSPolymerizationTagBottomBlock";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
