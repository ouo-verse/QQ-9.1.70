package com.tencent.biz.subscribe.bizdapters;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.a;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e extends we0.a {
    private RelativePersonalBottomView L;
    private a.d M;

    public e(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void f0(String str, a.d dVar) {
        super.f0(str, dVar);
        this.M = dVar;
        RelativePersonalBottomView relativePersonalBottomView = this.L;
        if (relativePersonalBottomView != null) {
            relativePersonalBottomView.c(dVar);
        }
    }

    @Override // we0.a
    protected BaseWidgetView i0(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        RelativePersonalBottomView relativePersonalBottomView = new RelativePersonalBottomView(viewGroup.getContext(), multiViewBlock);
        this.L = relativePersonalBottomView;
        return relativePersonalBottomView;
    }

    public int j0() {
        RelativePersonalBottomView relativePersonalBottomView = this.L;
        if (relativePersonalBottomView != null) {
            return relativePersonalBottomView.A();
        }
        return 0;
    }

    @Override // we0.a, android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        RelativePersonalBottomView relativePersonalBottomView = this.L;
        if (relativePersonalBottomView != null) {
            relativePersonalBottomView.c(this.M);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void U(com.tencent.biz.subscribe.part.block.base.b bVar) {
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void a0(Bundle bundle) {
    }
}
