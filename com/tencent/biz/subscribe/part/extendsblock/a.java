package com.tencent.biz.subscribe.part.extendsblock;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.base.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a extends MultiViewBlock {
    private HorizontalRvInnerView J;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.subscribe.part.extendsblock.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0970a extends RecyclerView.ViewHolder {
        public C0970a(View view) {
            super(view);
        }
    }

    public a(Bundle bundle) {
        super(bundle);
    }

    public abstract int i0();

    public abstract void j0(RecyclerView.ViewHolder viewHolder, int i3);

    public abstract C0970a k0(ViewGroup viewGroup, int i3);

    public abstract void l0(HorizontalRvInnerView horizontalRvInnerView);

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder.itemView instanceof HorizontalRvInnerView) {
            this.J.setData(r());
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        HorizontalRvInnerView horizontalRvInnerView = new HorizontalRvInnerView(viewGroup.getContext(), this);
        this.J = horizontalRvInnerView;
        horizontalRvInnerView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        a.C0969a c0969a = new a.C0969a(this.J);
        c0969a.setIsRecyclable(false);
        l0(this.J);
        return c0969a;
    }

    @Override // com.tencent.biz.subscribe.part.block.base.a
    public void t(ArrayList arrayList) {
        r().clear();
        r().addAll(arrayList);
        HorizontalRvInnerView horizontalRvInnerView = this.J;
        if (horizontalRvInnerView != null) {
            horizontalRvInnerView.setData(arrayList);
        }
    }
}
