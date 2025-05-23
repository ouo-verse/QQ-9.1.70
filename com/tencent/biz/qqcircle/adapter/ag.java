package com.tencent.biz.qqcircle.adapter;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleHotEventPolymerizationBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.widgets.feed.QCircleDefaultFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QFSPolymerizationFeedItemView;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ag extends com.tencent.biz.qqcircle.bizparts.a<e30.b> {
    private QCirclePolymerizationBean C;
    private b D;
    private boolean E;

    /* renamed from: m, reason: collision with root package name */
    private int f82620m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }

        private boolean l(e30.b bVar) {
            FeedCloudMeta$StFeed g16;
            View view = this.itemView;
            if (!(view instanceof BaseWidgetView) || !(((BaseWidgetView) view).getData() instanceof e30.b) || (g16 = ((e30.b) ((BaseWidgetView) this.itemView).getData()).g()) == null || bVar.g() == null || TextUtils.isEmpty(g16.f398449id.get()) || !g16.f398449id.get().equals(bVar.g().f398449id.get()) || g16.likeInfo.count.get() != bVar.g().likeInfo.count.get()) {
                return false;
            }
            return true;
        }

        public void m(e30.b bVar, QCircleExtraTypeInfo qCircleExtraTypeInfo, int i3) {
            if (l(bVar)) {
                return;
            }
            View view = this.itemView;
            if (!(view instanceof QFSPolymerizationFeedItemView)) {
                QLog.i("QFSPolymerizationFeedsBlock", 1, "itemView != QCircleWaterfallFeedItemView");
                return;
            }
            QFSPolymerizationFeedItemView qFSPolymerizationFeedItemView = (QFSPolymerizationFeedItemView) view;
            qFSPolymerizationFeedItemView.setExtraTypeInfo(qCircleExtraTypeInfo);
            qFSPolymerizationFeedItemView.setData(bVar, i3);
            qFSPolymerizationFeedItemView.setDataPosInList(i3);
            qFSPolymerizationFeedItemView.setInteractor(ag.this.getInteractor());
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void a(int i3, e30.b bVar, View view);
    }

    public ag(Bundle bundle) {
        super(bundle);
        this.E = true;
    }

    private void j0() {
        List<E> list = this.mDataList;
        if (list != 0 && list.size() != 0 && ((e30.b) this.mDataList.get(0)).g().dittoFeed.dittoId.get() == 10) {
            this.mDataList.remove(0);
            this.E = false;
            QLog.i("QFSPolymerizationFeedsBlock", 1, "checkRemoveHeaderTianShuBanner  remove tianshu banner");
        }
    }

    private void k0(e30.b bVar, int i3) {
        boolean z16;
        boolean equals = QCircleDaTongConstant.PageId.PG_XSJ_HOT_AGGREGATION_PAGE.equals(getReportBean().getDtPageId());
        QCirclePolymerizationBean qCirclePolymerizationBean = this.C;
        if (qCirclePolymerizationBean != null && (qCirclePolymerizationBean instanceof QCircleHotEventPolymerizationBean)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (equals && z16) {
            QCircleLpReportDc05507.DataBuilder c16 = ua0.c.c(bVar.g());
            c16.setPageId(303).setActionType(605).setSubActionType(1).setExt4(Integer.toString(i3 + 1));
            if (this.C.getHotEventInfo() != null) {
                c16.setExt2(this.C.getHotEventInfo().getId());
            }
            QCircleLpReportDc05507.report(c16);
        }
    }

    private void l0(View view, e30.b bVar) {
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.putAll(ua0.c.d(bVar));
        VideoReport.setElementParams(view, buildElementParams);
    }

    private boolean m0(RecyclerView recyclerView, int i3, int i16) {
        if (!(recyclerView.getLayoutManager() instanceof SafeGridLayoutManager) || i3 % i16 != 0) {
            return false;
        }
        return true;
    }

    private boolean n0(RecyclerView recyclerView, int i3, int i16) {
        if (!(recyclerView.getLayoutManager() instanceof SafeGridLayoutManager) || i3 >= i16) {
            return false;
        }
        return true;
    }

    private boolean o0(RecyclerView recyclerView, int i3, int i16) {
        if (!(recyclerView.getLayoutManager() instanceof SafeGridLayoutManager) || (i3 + 1) % i16 != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(int i3, e30.b bVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        b bVar2 = this.D;
        if (bVar2 != null) {
            bVar2.a(i3, bVar, view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<E> list = this.mDataList;
        if (list == 0) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i3;
        int i16;
        if (recyclerView != null && recyclerView.getAdapter() != null) {
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
            boolean m06 = m0(recyclerView, childLayoutPosition, 3);
            boolean o06 = o0(recyclerView, childLayoutPosition, 3);
            boolean n06 = n0(recyclerView, childLayoutPosition, 3);
            int dip2px = ViewUtils.dip2px(0.5f);
            int i17 = 0;
            if (m06) {
                i3 = 0;
            } else if (o06) {
                i3 = dip2px * 2;
            } else {
                i3 = dip2px;
            }
            if (o06) {
                i16 = 0;
            } else if (m06) {
                i16 = dip2px * 2;
            } else {
                i16 = dip2px;
            }
            if (n06) {
                i17 = ViewUtils.dip2px(28.0f);
            }
            rect.set(i3, i17, i16, dip2px * 3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        List<E> list = this.mDataList;
        if (list != 0 && list.size() > i3) {
            FeedCloudMeta$StFeed g16 = ((e30.b) this.mDataList.get(i3)).g();
            if (g16 == null || g16.dittoFeed.dittoId.get() != 0) {
                return 0;
            }
            return g16.type.get();
        }
        QLog.e("QFSPolymerizationFeedsBlock", 1, "getItemViewType()  return 0");
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return "QFSPolymerizationFeedsBlock";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getSpanCount(int i3) {
        return 1;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public String getUniqueKey() {
        return "polymerization_adapter_unique_key";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i3) {
        if (ab0.a.a(i3, getDataList())) {
            return;
        }
        final e30.b bVar = getDataList().get(i3);
        a aVar = (a) viewHolder;
        aVar.m(bVar, getQCircleExtraTypeInfo(), i3);
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.adapter.af
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ag.this.p0(i3, bVar, view);
            }
        });
        k0(bVar, i3);
        l0(viewHolder.itemView, bVar);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 != 2 && i3 != 3) {
            QLog.e("QFSPolymerizationFeedsBlock", 2, "onCreateViewHolder()  return new QCircleDefaultFeedWidget()");
            return new a(new QCircleDefaultFeedItemView(getContext(), i3));
        }
        QLog.i("QFSPolymerizationFeedsBlock", 1, "onCreateViewHolder()  viewType = " + i3);
        QFSPolymerizationFeedItemView qFSPolymerizationFeedItemView = new QFSPolymerizationFeedItemView(viewGroup.getContext());
        qFSPolymerizationFeedItemView.setReportBean(getReportBean());
        qFSPolymerizationFeedItemView.setViewType(this.f82620m);
        return new a(qFSPolymerizationFeedItemView);
    }

    public boolean q0(String str) {
        if (!TextUtils.isEmpty(str) && !RFSafeListUtils.isEmpty(getDataList())) {
            Iterator<e30.b> it = getDataList().iterator();
            int i3 = -1;
            while (it.hasNext()) {
                i3++;
                e30.b next = it.next();
                if (next != null && next.g() != null && TextUtils.equals(str, next.g().f398449id.get())) {
                    it.remove();
                    notifyItemRemoved(i3);
                    notifyItemRangeChanged(i3, getItemCount() - i3);
                    return true;
                }
            }
        }
        return false;
    }

    public ag r0(QCirclePolymerizationBean qCirclePolymerizationBean) {
        this.C = qCirclePolymerizationBean;
        return this;
    }

    public void s0(b bVar) {
        this.D = bVar;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void setDatas(List<e30.b> list) {
        this.mDataList.clear();
        if (list == null) {
            notifyDataSetChanged();
            return;
        }
        this.mDataList.addAll(list);
        j0();
        notifyItemRangeChanged(0, list.size());
    }

    public ag t0(int i3) {
        this.f82620m = i3;
        return this;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
