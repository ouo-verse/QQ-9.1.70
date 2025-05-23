package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalPraisedItemView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalPushFeedBoxItemView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSPersonalFeedBaseAdapter extends com.tencent.biz.qqcircle.bizparts.a<com.tencent.biz.qqcircle.immersive.personal.bean.e> {
    private String C;

    /* renamed from: m, reason: collision with root package name */
    protected b f88370m;

    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f88372d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.qqcircle.immersive.personal.bean.e f88373e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f88374f;

        a(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, c cVar) {
            this.f88372d = i3;
            this.f88373e = eVar;
            this.f88374f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            b bVar = QFSPersonalFeedBaseAdapter.this.f88370m;
            if (bVar != null) {
                bVar.a(this.f88372d, this.f88373e, this.f88374f.E);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, QCircleBaseWidgetView qCircleBaseWidgetView);
    }

    /* loaded from: classes4.dex */
    public static class c extends RecyclerView.ViewHolder {
        public QCircleBaseWidgetView E;

        public c(@NonNull QCircleBaseWidgetView qCircleBaseWidgetView) {
            super(qCircleBaseWidgetView);
            this.E = qCircleBaseWidgetView;
        }
    }

    public QFSPersonalFeedBaseAdapter(Bundle bundle) {
        super(bundle);
        this.C = "";
    }

    private void m0(View view, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar) {
        if (eVar == null) {
            return;
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRODUCT_LOOK_FINISHED, "no");
        buildElementParams.put("xsj_feed_id", eVar.d());
        buildElementParams.put("xsj_tab_name", this.C);
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementReuseIdentifier(view, eVar.d());
    }

    public int getHeaderCount() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i3;
        int headerCount = getHeaderCount();
        List<E> list = this.mDataList;
        if (list != 0) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        return headerCount + i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childLayoutPosition;
        int i3;
        int i16;
        if (recyclerView == null || recyclerView.getAdapter() == null || (childLayoutPosition = recyclerView.getChildLayoutPosition(view) - getHeaderCount()) < 0) {
            return;
        }
        boolean j06 = j0(recyclerView, childLayoutPosition, 3);
        boolean k06 = k0(recyclerView, childLayoutPosition, 3);
        int a16 = cx.a(0.5f);
        if (j06) {
            i3 = 0;
        } else if (k06) {
            i3 = a16 * 2;
        } else {
            i3 = a16;
        }
        if (k06) {
            i16 = 0;
        } else if (j06) {
            i16 = a16 * 2;
        } else {
            i16 = a16;
        }
        rect.set(i3, 0, i16, a16 * 3);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return "QFSPersonalFeedBaseAdapter";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    public List<e30.b> i0() {
        ArrayList arrayList = new ArrayList();
        List<com.tencent.biz.qqcircle.immersive.personal.bean.e> dataList = getDataList();
        if (dataList != null && dataList.size() != 0) {
            for (com.tencent.biz.qqcircle.immersive.personal.bean.e eVar : dataList) {
                if (eVar.c() == null) {
                    arrayList.add(new e30.b(new FeedCloudMeta$StFeed()));
                } else {
                    arrayList.add(eVar.c());
                }
            }
        }
        return arrayList;
    }

    protected boolean j0(RecyclerView recyclerView, int i3, int i16) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager) || i3 % i16 != 0) {
            return false;
        }
        return true;
    }

    protected boolean k0(RecyclerView recyclerView, int i3, int i16) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager) || (i3 + 1) % i16 != 0) {
            return false;
        }
        return true;
    }

    protected void l0(View view, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, int i3) {
        if (view instanceof QFSPersonalPushFeedBoxItemView) {
            return;
        }
        m0(view, eVar);
    }

    public void n0() {
        o0(5);
    }

    public void o0(final int i3) {
        RecyclerView recyclerView;
        if (i3 != 0 && (recyclerView = this.mRecyclerView) != null) {
            if (recyclerView.isComputingLayout()) {
                this.mRecyclerView.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSPersonalFeedBaseAdapter.this.o0(i3 - 1);
                    }
                }, 20L);
                return;
            } else {
                notifyDataSetChanged();
                return;
            }
        }
        RFWLog.i("QFSPersonalFeedBaseAdapter", RFWLog.USR, "safeNotify return count = " + i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) int i3) {
        int headerCount = i3 - getHeaderCount();
        if (headerCount >= this.mDataList.size()) {
            return;
        }
        com.tencent.biz.qqcircle.immersive.personal.bean.e eVar = (com.tencent.biz.qqcircle.immersive.personal.bean.e) this.mDataList.get(headerCount);
        c cVar = (c) viewHolder;
        cVar.E.setData(eVar, headerCount);
        cVar.E.setOnClickListener(new a(headerCount, eVar, cVar));
        l0(viewHolder.itemView, eVar, headerCount);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new c(new QFSPersonalPraisedItemView(viewGroup.getContext()));
    }

    public void p0(b bVar) {
        this.f88370m = bVar;
    }

    public void q0(String str) {
        this.C = str;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void setDatas(List<com.tencent.biz.qqcircle.immersive.personal.bean.e> list) {
        this.mDataList.clear();
        if (list != null) {
            this.mDataList.addAll(list);
        }
        n0();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
