package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalPushBoxHeaderView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalPushFeedBoxItemView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalPushFeedFinishItemView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalPushFeedLoadingItemView;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class m extends QFSPersonalFeedBaseAdapter {
    private com.tencent.biz.qqcircle.immersive.personal.bean.o D;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class a extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<m> f88391a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        private final GridLayoutManager.SpanSizeLookup f88392b;

        public a(m mVar, @NonNull GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.f88391a = new WeakReference<>(mVar);
            this.f88392b = spanSizeLookup;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i3) {
            m mVar = this.f88391a.get();
            if (mVar != null && mVar.getItemViewType(i3) == 102101) {
                return 3;
            }
            return this.f88392b.getSpanSize(i3);
        }
    }

    public m(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter
    public int getHeaderCount() {
        return s0() ? 1 : 0;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.mRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) this.mRecyclerView.getLayoutManager();
            gridLayoutManager.setSpanSizeLookup(new a(this, gridLayoutManager.getSpanSizeLookup()));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        View view = viewHolder.itemView;
        if (view instanceof QFSPersonalPushBoxHeaderView) {
            ((QFSPersonalPushBoxHeaderView) view).setData(this.D);
        } else {
            super.onBindViewHolder(viewHolder, i3);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter, com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        switch (i3) {
            case 102101:
                return new QFSPersonalFeedBaseAdapter.c(new QFSPersonalPushBoxHeaderView(getContext()));
            case 102102:
                return new QFSPersonalFeedBaseAdapter.c(new QFSPersonalPushFeedLoadingItemView(getContext()));
            case 102103:
                return new QFSPersonalFeedBaseAdapter.c(new QFSPersonalPushFeedBoxItemView(getContext()));
            case 102104:
                return new QFSPersonalFeedBaseAdapter.c(new QFSPersonalPushFeedFinishItemView(getContext()));
            default:
                return super.onCreateItemViewHolder(viewGroup, i3);
        }
    }

    public com.tencent.biz.qqcircle.immersive.personal.bean.o r0() {
        return this.D;
    }

    public boolean s0() {
        if (this.D != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return i3;
    }
}
