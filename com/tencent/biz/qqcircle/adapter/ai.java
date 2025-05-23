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
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.qqcircle.widgets.feed.QCircleDefaultFeedItemView;
import com.tencent.biz.qqcircle.widgets.polymerization.QFSPolymerizationTagFeedItemView;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ai extends com.tencent.biz.qqcircle.bizparts.a<e30.b> {
    private c C;
    private QCirclePolymerizationBean D;

    /* renamed from: m, reason: collision with root package name */
    private int f82624m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends QFSAsyncUtils.Callback<Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f82625a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e30.b f82626b;

        a(View view, e30.b bVar) {
            this.f82625a = view;
            this.f82626b = bVar;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        public Void doBackgroundAction(Void... voidArr) {
            String a16;
            VideoReport.setElementId(this.f82625a, QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.d(this.f82626b));
            if (ai.this.D.getTagTabType() == 0) {
                a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f196084gc);
            } else {
                a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f196094gd);
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TAB_TITLE, a16);
            VideoReport.setElementExposePolicy(this.f82625a, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this.f82625a, EndExposurePolicy.REPORT_ALL);
            VideoReport.setElementParams(this.f82625a, buildElementParams);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder {
        public b(@NonNull View view) {
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
            if (!(view instanceof QFSPolymerizationTagFeedItemView)) {
                QLog.i("QFSPolymerizationTagBaseFeedsBlock", 1, "itemView != QFSPolymerizationTagFeedItemView");
                return;
            }
            QFSPolymerizationTagFeedItemView qFSPolymerizationTagFeedItemView = (QFSPolymerizationTagFeedItemView) view;
            qFSPolymerizationTagFeedItemView.setExtraTypeInfo(qCircleExtraTypeInfo);
            qFSPolymerizationTagFeedItemView.setData(bVar, i3);
            qFSPolymerizationTagFeedItemView.setDataPosInList(i3);
            qFSPolymerizationTagFeedItemView.setInteractor(ai.this.getInteractor());
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface c {
        void a(int i3, e30.b bVar, View view);
    }

    public ai(Bundle bundle) {
        super(bundle);
    }

    private void k0(e30.b bVar, int i3) {
        boolean z16;
        boolean equals = QCircleDaTongConstant.PageId.PG_XSJ_HOT_AGGREGATION_PAGE.equals(getReportBean().getDtPageId());
        QCirclePolymerizationBean qCirclePolymerizationBean = this.D;
        if (qCirclePolymerizationBean != null && (qCirclePolymerizationBean instanceof QCircleHotEventPolymerizationBean)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (equals && z16) {
            QCircleLpReportDc05507.DataBuilder c16 = ua0.c.c(bVar.g());
            c16.setPageId(303).setActionType(605).setSubActionType(1).setExt4(Integer.toString(i3 + 1));
            if (this.D.getHotEventInfo() != null) {
                c16.setExt2(this.D.getHotEventInfo().getId());
            }
            QCircleLpReportDc05507.report(c16);
        }
    }

    private void l0(View view, e30.b bVar) {
        QFSAsyncUtils.executeSub(new a(view, bVar), new Void[0]);
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
        c cVar = this.C;
        if (cVar != null) {
            cVar.a(i3, bVar, view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        if (getDataList() != null) {
            return getDataList().size();
        }
        return 0;
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
            n0(recyclerView, childLayoutPosition, 3);
            int dip2px = ViewUtils.dip2px(0.5f);
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
            rect.set(i3, 0, i16, dip2px * 3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        List<E> list = this.mDataList;
        if (list != 0 && list.size() > i3) {
            FeedCloudMeta$StFeed g16 = ((e30.b) this.mDataList.get(i3)).g();
            if (g16.dittoFeed.dittoId.get() != 0) {
                QLog.i("QFSPolymerizationTagBaseFeedsBlock", 1, "getItemViewType()  return 0 , data.dittoFeed.dittoId = " + g16.dittoFeed.dittoId.get() + " , position = " + i3);
                return 0;
            }
            return g16.type.get();
        }
        QLog.e("QFSPolymerizationTagBaseFeedsBlock", 1, "getItemViewType()  return 0");
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return "QFSPolymerizationTagBaseFeedsBlock";
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i3) {
        if (getDataList() != null && i3 < getDataList().size()) {
            final e30.b bVar = getDataList().get(i3);
            b bVar2 = (b) viewHolder;
            bVar2.m(bVar, getQCircleExtraTypeInfo(), i3);
            bVar2.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.adapter.ah
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ai.this.p0(i3, bVar, view);
                }
            });
            k0(bVar, i3);
            l0(viewHolder.itemView, bVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 != 2 && i3 != 3) {
            QLog.e("QFSPolymerizationTagBaseFeedsBlock", 2, "onCreateViewHolder()  return new QCircleDefaultFeedWidget()");
            return new b(new QCircleDefaultFeedItemView(getContext(), i3));
        }
        QLog.i("QFSPolymerizationTagBaseFeedsBlock", 1, "onCreateViewHolder()  viewType = " + i3);
        QFSPolymerizationTagFeedItemView qFSPolymerizationTagFeedItemView = new QFSPolymerizationTagFeedItemView(viewGroup.getContext());
        qFSPolymerizationTagFeedItemView.setReportBean(getReportBean());
        qFSPolymerizationTagFeedItemView.setViewType(this.f82624m);
        return new b(qFSPolymerizationTagFeedItemView);
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
                    notifyItemRangeChanged(i3, getNUM_BACKGOURND_ICON() - i3);
                    return true;
                }
            }
        }
        return false;
    }

    public ai r0(QCirclePolymerizationBean qCirclePolymerizationBean) {
        this.D = qCirclePolymerizationBean;
        return this;
    }

    public void s0(c cVar) {
        this.C = cVar;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void setDatas(List<e30.b> list) {
        this.mDataList.clear();
        if (list == null) {
            notifyDataSetChanged();
        } else {
            this.mDataList.addAll(list);
            notifyItemRangeChanged(0, list.size());
        }
    }

    public ai t0(int i3) {
        this.f82624m = i3;
        return this;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
