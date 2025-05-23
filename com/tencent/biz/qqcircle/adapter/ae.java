package com.tencent.biz.qqcircle.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.polymerization.QFSPolymerizationBottomView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ae extends com.tencent.biz.qqcircle.bizparts.c {
    private QFSPolymerizationBottomView C;

    public ae(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSPolymerizationBottomView qFSPolymerizationBottomView = new QFSPolymerizationBottomView(viewGroup.getContext(), getParentRecyclerView());
        this.C = qFSPolymerizationBottomView;
        return qFSPolymerizationBottomView;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSPolymerizationBottomBlock";
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QFSPolymerizationBottomView qFSPolymerizationBottomView = this.C;
        if (qFSPolymerizationBottomView != null) {
            qFSPolymerizationBottomView.onPause();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QFSPolymerizationBottomView qFSPolymerizationBottomView = this.C;
        if (qFSPolymerizationBottomView != null) {
            qFSPolymerizationBottomView.onResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
