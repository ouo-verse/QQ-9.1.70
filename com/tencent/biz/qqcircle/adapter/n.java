package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleTopicRankItemInfo;
import com.tencent.biz.qqcircle.immersive.views.QCircleTopicFeedItemView;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class n extends com.tencent.biz.qqcircle.bizparts.a<QCircleTopicRankItemInfo> {
    public static final String C = "com.tencent.biz.qqcircle.adapter.n";

    /* renamed from: m, reason: collision with root package name */
    private RecyclerView f82657m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private class b extends RecyclerView.ViewHolder {
        public b(@NonNull View view) {
            super(view);
        }
    }

    public n(Bundle bundle) {
        super(bundle);
    }

    private void j0() {
        RecyclerView recyclerView = this.f82657m;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setItemAnimator(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(boolean z16) {
        if (z16) {
            j0();
        }
        notifyDataSetChanged();
    }

    private void m0(final boolean z16) {
        RecyclerView recyclerView = this.f82657m;
        if (recyclerView != null) {
            if (recyclerView.isComputingLayout()) {
                this.f82657m.post(new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.this.k0(z16);
                    }
                });
                return;
            }
            if (z16) {
                j0();
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<E> list = this.mDataList;
        if (list != 0) {
            return list.size();
        }
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return C;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    public void l0(List<QCircleTopicRankItemInfo> list, int i3) {
        int size = this.mDataList.size();
        int size2 = list.size();
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyItemRangeInserted(size, size2 - 1);
        n0(i3);
    }

    public void n0(int i3) {
        if (i3 < 0) {
            return;
        }
        int i16 = 0;
        while (true) {
            if (i16 < this.mDataList.size()) {
                if (((QCircleTopicRankItemInfo) this.mDataList.get(i16)).isIsPlaying()) {
                    break;
                } else {
                    i16++;
                }
            } else {
                i16 = -1;
                break;
            }
        }
        if (i16 != -1) {
            ((QCircleTopicRankItemInfo) this.mDataList.get(i16)).setIsPlaying(false);
            notifyItemChanged(i16);
        }
        if (this.mDataList.size() > i3) {
            ((QCircleTopicRankItemInfo) this.mDataList.get(i3)).setIsPlaying(true);
            notifyItemChanged(i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        ((QCircleTopicFeedItemView) viewHolder.itemView).bindData((QCircleTopicRankItemInfo) this.mDataList.get(i3), i3);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QCircleTopicFeedItemView qCircleTopicFeedItemView = new QCircleTopicFeedItemView(viewGroup.getContext());
        qCircleTopicFeedItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new b(qCircleTopicFeedItemView);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        NestScrollRecyclerView parentRecyclerView = getParentRecyclerView();
        this.f82657m = parentRecyclerView;
        parentRecyclerView.addOnScrollListener(new a());
    }

    public void q3(List<QCircleTopicRankItemInfo> list, int i3) {
        super.setDatas(list);
        n0(i3);
        m0(true);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }
}
