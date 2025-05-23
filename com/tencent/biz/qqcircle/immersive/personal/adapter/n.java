package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalSelectCollectBoxItemView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class n extends com.tencent.biz.qqcircle.bizparts.a<FeedCloudFavoritessvr$FavoritesInfo> {
    private static final int D = cx.a(18.0f);
    private com.tencent.biz.qqcircle.immersive.personal.bean.r C;

    /* renamed from: m, reason: collision with root package name */
    private b f88393m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f88394d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FeedCloudFavoritessvr$FavoritesInfo f88395e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f88396f;

        a(int i3, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, c cVar) {
            this.f88394d = i3;
            this.f88395e = feedCloudFavoritessvr$FavoritesInfo;
            this.f88396f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (n.this.f88393m != null) {
                n.this.f88393m.a(this.f88394d, this.f88395e, this.f88396f.E);
            }
            n.this.k0(true, this.f88395e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void a(int i3, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, QCircleBaseWidgetView qCircleBaseWidgetView);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c extends RecyclerView.ViewHolder {
        public QCircleBaseWidgetView E;

        public c(@NonNull QCircleBaseWidgetView qCircleBaseWidgetView) {
            super(qCircleBaseWidgetView);
            this.E = qCircleBaseWidgetView;
        }
    }

    public n(Bundle bundle) {
        super(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(boolean z16, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo) {
        String str;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_COLLECT_FOLDER_ITEM);
        if (this.C.a() != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_ID, Long.valueOf(this.C.a().f398434id.get()));
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_LIST_COLLECT_FOLDER_ID, Long.valueOf(feedCloudFavoritessvr$FavoritesInfo.f398434id.get()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_NAME, feedCloudFavoritessvr$FavoritesInfo.title.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CHOOSE_COLLECT_FOLDER_POPUP_SOURCE, Integer.valueOf(com.tencent.biz.qqcircle.immersive.personal.utils.j.f(this.C.c())));
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            buildElementParams.put("xsj_custom_pgid", qCircleReportBean.getDtPageId());
        }
        if (z16) {
            str = "ev_xsj_abnormal_clck";
        } else {
            str = "ev_xsj_abnormal_imp";
        }
        VideoReport.reportEvent(str, buildElementParams);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<E> list = this.mDataList;
        if (list != 0) {
            return list.size();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.bottom = D;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return "QFSPersonalSelectCollectBoxAdapter";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    public void l0(b bVar) {
        this.f88393m = bVar;
    }

    public void m0(com.tencent.biz.qqcircle.immersive.personal.bean.r rVar) {
        this.C = rVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (i3 >= this.mDataList.size()) {
            return;
        }
        FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo = (FeedCloudFavoritessvr$FavoritesInfo) this.mDataList.get(i3);
        c cVar = (c) viewHolder;
        cVar.E.setData(feedCloudFavoritessvr$FavoritesInfo, i3);
        viewHolder.itemView.setOnClickListener(new a(i3, feedCloudFavoritessvr$FavoritesInfo, cVar));
        k0(false, feedCloudFavoritessvr$FavoritesInfo);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QFSPersonalSelectCollectBoxItemView qFSPersonalSelectCollectBoxItemView = new QFSPersonalSelectCollectBoxItemView(viewGroup.getContext());
        qFSPersonalSelectCollectBoxItemView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return new c(qFSPersonalSelectCollectBoxItemView);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
