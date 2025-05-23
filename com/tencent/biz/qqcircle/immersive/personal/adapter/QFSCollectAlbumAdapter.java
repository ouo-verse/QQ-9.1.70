package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSCollectAlbumItemView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$FeedAlbum;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCollectAlbumAdapter extends com.tencent.biz.qqcircle.bizparts.a<FeedCloudMeta$FeedAlbum> {

    /* renamed from: m, reason: collision with root package name */
    private c f88343m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f88345d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$FeedAlbum f88346e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f88347f;

        a(int i3, FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum, b bVar) {
            this.f88345d = i3;
            this.f88346e = feedCloudMeta$FeedAlbum;
            this.f88347f = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QFSCollectAlbumAdapter.this.f88343m != null) {
                QFSCollectAlbumAdapter.this.f88343m.a(this.f88345d, this.f88346e, this.f88347f.E);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.ViewHolder {
        public QCircleBaseWidgetView E;

        public b(@NonNull QCircleBaseWidgetView qCircleBaseWidgetView) {
            super(qCircleBaseWidgetView);
            this.E = qCircleBaseWidgetView;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface c {
        void a(int i3, FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum, QCircleBaseWidgetView qCircleBaseWidgetView);
    }

    public QFSCollectAlbumAdapter(Bundle bundle) {
        super(bundle);
    }

    private void k0(View view, FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum) {
        if (feedCloudMeta$FeedAlbum == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$FeedAlbum.owner.f398463id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, Long.valueOf(feedCloudMeta$FeedAlbum.f398441id.get()));
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_COLLECT_PRODUCT);
        VideoReport.setElementParams(view, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(final int i3) {
        RecyclerView recyclerView;
        if (i3 != 0 && (recyclerView = this.mRecyclerView) != null) {
            if (recyclerView.isComputingLayout()) {
                this.mRecyclerView.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.adapter.QFSCollectAlbumAdapter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSCollectAlbumAdapter.this.l0(i3 - 1);
                    }
                }, 20L);
                return;
            } else {
                notifyDataSetChanged();
                return;
            }
        }
        RFWLog.i("QFSCollectAlbumAdapter", RFWLog.USR, "safeNotify return count = " + i3);
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
        return "QFSCollectAlbumAdapter";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    public void m0(c cVar) {
        this.f88343m = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) int i3) {
        if (viewHolder instanceof b) {
            FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum = (FeedCloudMeta$FeedAlbum) this.mDataList.get(i3);
            b bVar = (b) viewHolder;
            bVar.E.setData(feedCloudMeta$FeedAlbum, i3);
            viewHolder.itemView.setOnClickListener(new a(i3, feedCloudMeta$FeedAlbum, bVar));
            k0(viewHolder.itemView, feedCloudMeta$FeedAlbum);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new b(new QFSCollectAlbumItemView(viewGroup.getContext()));
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void setDatas(List<FeedCloudMeta$FeedAlbum> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        l0(5);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
