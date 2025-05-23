package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBottomWidget;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends com.tencent.biz.qqcircle.bizparts.c {
    private QFSPersonalBottomWidget C;

    public b(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSPersonalBottomWidget qFSPersonalBottomWidget = new QFSPersonalBottomWidget(viewGroup.getContext(), (QFSPersonalDetailsFragment) getParentFragment(), viewGroup, getReportBean());
        this.C = qFSPersonalBottomWidget;
        return qFSPersonalBottomWidget;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSPersonalBottomBlock";
    }

    public void i0() {
        QFSPersonalBottomWidget qFSPersonalBottomWidget = this.C;
        if (qFSPersonalBottomWidget != null) {
            qFSPersonalBottomWidget.y0(true);
        }
    }

    public QFSPersonalBottomWidget j0() {
        return this.C;
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        super.onBindViewHolder(viewHolder, i3);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return super.onCreateViewHolder(viewGroup, i3);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
