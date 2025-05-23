package com.tencent.biz.subscribe.part.extendsblock;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.part.block.base.d;
import com.tencent.biz.subscribe.part.extendsblock.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HorizontalRvInnerView extends RecyclerViewCompat {

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.biz.subscribe.part.extendsblock.a f96204d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayoutManager f96205e;

    /* renamed from: f, reason: collision with root package name */
    private a f96206f;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends com.tencent.biz.subscribe.part.block.base.a {
        public a() {
        }

        @Override // com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (HorizontalRvInnerView.this.f96204d != null) {
                return HorizontalRvInnerView.this.f96204d.i0();
            }
            return 0;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
            if (!ArrayUtils.isOutOfArrayIndex(i3, this.f96195d) && HorizontalRvInnerView.this.f96204d != null) {
                HorizontalRvInnerView.this.f96204d.j0(viewHolder, i3);
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public a.C0970a onCreateViewHolder(ViewGroup viewGroup, int i3) {
            if (HorizontalRvInnerView.this.f96204d != null) {
                return HorizontalRvInnerView.this.f96204d.k0(viewGroup, i3);
            }
            return null;
        }
    }

    public HorizontalRvInnerView(Context context, com.tencent.biz.subscribe.part.extendsblock.a aVar) {
        super(context);
        this.f96204d = aVar;
        setDescendantFocusability(393216);
        a aVar2 = new a();
        this.f96206f = aVar2;
        setAdapter(aVar2);
        d dVar = new d(getContext(), 0, false);
        this.f96205e = dVar;
        setLayoutManager(dVar);
        setOverScrollMode(2);
    }

    public void setData(ArrayList arrayList) {
        a aVar = this.f96206f;
        if (aVar != null) {
            aVar.t(arrayList);
        }
    }

    public void setOrientation(int i3) {
        LinearLayoutManager linearLayoutManager = this.f96205e;
        if (linearLayoutManager != null) {
            linearLayoutManager.setOrientation(i3);
        }
    }

    public HorizontalRvInnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
