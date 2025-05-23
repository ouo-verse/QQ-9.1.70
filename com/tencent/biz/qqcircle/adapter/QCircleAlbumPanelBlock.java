package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.album.view.QCircleAlbumItemView;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class QCircleAlbumPanelBlock extends com.tencent.biz.qqcircle.bizparts.a<b40.a> {
    private z30.a C;
    private QCircleAlbumItemView.a D;

    /* renamed from: m, reason: collision with root package name */
    private RecyclerView f82584m;

    /* loaded from: classes4.dex */
    class a implements z30.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b40.a f82586d;

        a(b40.a aVar) {
            this.f82586d = aVar;
        }

        @Override // z30.a
        public void onClick(View view, int i3, int i16, Object obj) {
            if (QCircleAlbumPanelBlock.this.C != null) {
                if (QCircleAlbumPanelBlock.this.D != null) {
                    QCircleAlbumPanelBlock.this.u0(view, this.f82586d.e(), this.f82586d.k(), QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM);
                }
                QCircleAlbumPanelBlock.this.C.onClick(view, i3, i16, obj);
                return;
            }
            QLog.e("QCircleAlbumPanelBlock", 1, "[onClick] element click listener should not be null.");
        }
    }

    /* loaded from: classes4.dex */
    private static class b extends RecyclerView.ViewHolder {
        public b(@NonNull View view) {
            super(view);
        }

        public void l(int i3, b40.a aVar, z30.a aVar2) {
            View view = this.itemView;
            if (view instanceof QCircleAlbumItemView) {
                ((QCircleAlbumItemView) view).setOnAlbumElementClickListener(aVar2);
                ((QCircleAlbumItemView) this.itemView).bindData(aVar, i3);
            }
        }
    }

    public QCircleAlbumPanelBlock(Bundle bundle, QCircleAlbumItemView.a aVar) {
        super(bundle);
        this.D = aVar;
    }

    private void q0(View view, b40.a aVar) {
        if (view != null && aVar != null) {
            FeedCloudMeta$StFeed e16 = aVar.e();
            if (e16 == null) {
                return;
            }
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_CP_WORKS);
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_feed_id", e16.f398449id.get());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, aVar.k());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, e16.poster.f398463id.get());
            VideoReport.setElementParams(view, hashMap);
            VideoReport.setElementReuseIdentifier(view, "em_xsj_cp_works_" + e16.f398449id.get());
            return;
        }
        QLog.d("QCircleAlbumPanelBlock", 1, "[bindDtReport] itemView == null || feed == null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        RecyclerView recyclerView = this.f82584m;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setItemAnimator(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(int i3, int i16) {
        notifyItemRangeInserted(i3, i16 - i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(int i3) {
        notifyItemRangeInserted(0, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(View view, FeedCloudMeta$StFeed feedCloudMeta$StFeed, Long l3, String str) {
        String dtPageId;
        String g16;
        if (view != null && feedCloudMeta$StFeed != null) {
            QCircleReportBean reportBean = getReportBean();
            if (reportBean == null) {
                dtPageId = QCircleDaTongConstant.PageId.BASE;
            } else {
                dtPageId = reportBean.getDtPageId();
            }
            QCircleAlbumItemView.a aVar = this.D;
            if (aVar == null) {
                g16 = null;
            } else {
                g16 = bj.g(aVar.f84831d);
            }
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("dt_pgid", dtPageId);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, l3);
            buildElementParams.put("xsj_feed_id", bj.g(feedCloudMeta$StFeed));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TARGET_FEED_ID, g16);
            VideoReport.setElementParams(view, buildElementParams);
            VideoReport.setElementId(view, str);
            VideoReport.reportEvent("dt_clck", view, buildElementParams);
            return;
        }
        QLog.d("QCircleAlbumPanelBlock", 1, "[bindConfigItemDtReport] itemView == null || feed == null.");
    }

    private void v0(View view, FeedCloudMeta$StFeed feedCloudMeta$StFeed, Long l3, String str) {
        String dtPageId;
        String g16;
        if (view != null && feedCloudMeta$StFeed != null) {
            QCircleReportBean reportBean = getReportBean();
            if (reportBean == null) {
                dtPageId = QCircleDaTongConstant.PageId.BASE;
            } else {
                dtPageId = reportBean.getDtPageId();
            }
            QCircleAlbumItemView.a aVar = this.D;
            if (aVar == null) {
                g16 = null;
            } else {
                g16 = bj.g(aVar.f84831d);
            }
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("dt_pgid", dtPageId);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, l3);
            buildElementParams.put("xsj_feed_id", bj.g(feedCloudMeta$StFeed));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TARGET_FEED_ID, g16);
            VideoReport.setElementParams(view, buildElementParams);
            VideoReport.setElementId(view, str);
            VideoReport.reportEvent("dt_imp", view, buildElementParams);
            return;
        }
        QLog.d("QCircleAlbumPanelBlock", 1, "[bindConfigItemDtReport] itemView == null || feed == null.");
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<E> list = this.mDataList;
        if (list == 0) {
            return 0;
        }
        return list.size();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return "QCircleAlbumPanelBlock";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    public void o0(List<b40.a> list) {
        final int size = this.mDataList.size();
        this.mDataList.clear();
        this.mDataList.addAll(list);
        final int size2 = this.mDataList.size();
        RecyclerView recyclerView = this.f82584m;
        if (recyclerView != null) {
            if (recyclerView.isComputingLayout()) {
                this.f82584m.post(new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCircleAlbumPanelBlock.this.s0(size, size2);
                    }
                });
            } else {
                notifyItemRangeInserted(size, size2 - size);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        List<E> list = this.mDataList;
        if (list != 0 && list.size() > i3) {
            b40.a aVar = (b40.a) this.mDataList.get(i3);
            if (aVar != null && aVar.e() != null) {
                ((b) viewHolder).l(i3, aVar, new a(aVar));
                QCircleAlbumItemView.a aVar2 = this.D;
                if (aVar2 != null && aVar2.f84832e == 2) {
                    v0(viewHolder.itemView, aVar.e(), aVar.k(), QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM);
                    return;
                } else {
                    q0(viewHolder.itemView, aVar);
                    return;
                }
            }
            QLog.d("QCircleAlbumPanelBlock", 1, "[onBindViewHolder] album feed is null, end flow.");
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QCircleAlbumItemView qCircleAlbumItemView = new QCircleAlbumItemView(viewGroup.getContext(), this.D);
        qCircleAlbumItemView.setReportBean(getReportBean());
        return new b(qCircleAlbumItemView);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        this.f82584m = getParentRecyclerView();
    }

    public void p0(List<b40.a> list) {
        int num_backgournd_icon = getNUM_BACKGOURND_ICON();
        this.mDataList.clear();
        this.mDataList.addAll(list);
        final int size = this.mDataList.size() - num_backgournd_icon;
        RecyclerView recyclerView = this.f82584m;
        if (recyclerView != null) {
            if (recyclerView.isComputingLayout()) {
                this.f82584m.post(new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCircleAlbumPanelBlock.this.t0(size);
                    }
                });
            } else {
                notifyItemRangeInserted(0, size);
            }
        }
    }

    public void setData(List<b40.a> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        w0(true);
    }

    public void w0(final boolean z16) {
        RecyclerView recyclerView = this.f82584m;
        if (recyclerView != null) {
            if (recyclerView.isComputingLayout()) {
                this.f82584m.post(new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.QCircleAlbumPanelBlock.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z16) {
                            QCircleAlbumPanelBlock.this.r0();
                        }
                        QCircleAlbumPanelBlock.this.notifyDataSetChanged();
                    }
                });
                return;
            }
            if (z16) {
                r0();
            }
            notifyDataSetChanged();
        }
    }

    public void x0(z30.a aVar) {
        this.C = aVar;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }
}
