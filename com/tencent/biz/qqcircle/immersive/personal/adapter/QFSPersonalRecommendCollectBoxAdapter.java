package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSRecommendCollectBoxItemView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSPersonalRecommendCollectBoxAdapter extends com.tencent.biz.qqcircle.bizparts.a<FeedCloudFavoritessvr$FavoritesInfo> {

    /* renamed from: m, reason: collision with root package name */
    private b f88376m;

    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f88378d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FeedCloudFavoritessvr$FavoritesInfo f88379e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f88380f;

        a(int i3, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, c cVar) {
            this.f88378d = i3;
            this.f88379e = feedCloudFavoritessvr$FavoritesInfo;
            this.f88380f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QFSPersonalRecommendCollectBoxAdapter.this.f88376m != null) {
                QFSPersonalRecommendCollectBoxAdapter.this.f88376m.a(this.f88378d, this.f88379e, this.f88380f.E);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i3, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, QCircleBaseWidgetView qCircleBaseWidgetView);
    }

    /* loaded from: classes4.dex */
    public static class c extends RecyclerView.ViewHolder {
        public QCircleBaseWidgetView E;

        public c(@NonNull QCircleBaseWidgetView qCircleBaseWidgetView) {
            super(qCircleBaseWidgetView);
            this.E = qCircleBaseWidgetView;
        }
    }

    public QFSPersonalRecommendCollectBoxAdapter(Bundle bundle) {
        super(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(final int i3) {
        RecyclerView recyclerView;
        if (i3 != 0 && (recyclerView = this.mRecyclerView) != null) {
            if (recyclerView.isComputingLayout()) {
                this.mRecyclerView.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalRecommendCollectBoxAdapter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSPersonalRecommendCollectBoxAdapter.this.k0(i3 - 1);
                    }
                }, 20L);
                return;
            } else {
                notifyDataSetChanged();
                return;
            }
        }
        RFWLog.i("QFSPersonalRecommendCollectBoxAdapter", RFWLog.USR, "safeNotify return count = " + i3);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<E> list = this.mDataList;
        if (list != 0) {
            return list.size();
        }
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return "QFSPersonalRecommendCollectBoxAdapter";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    public void l0(b bVar) {
        this.f88376m = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) int i3) {
        if (viewHolder instanceof c) {
            FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo = (FeedCloudFavoritessvr$FavoritesInfo) this.mDataList.get(i3);
            c cVar = (c) viewHolder;
            cVar.E.setData(feedCloudFavoritessvr$FavoritesInfo, i3);
            viewHolder.itemView.setOnClickListener(new a(i3, feedCloudFavoritessvr$FavoritesInfo, cVar));
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new c(new QFSRecommendCollectBoxItemView(viewGroup.getContext()));
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void setDatas(List<FeedCloudFavoritessvr$FavoritesInfo> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        k0(5);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
