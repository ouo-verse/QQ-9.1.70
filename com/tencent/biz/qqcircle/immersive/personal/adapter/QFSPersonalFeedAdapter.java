package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.album.view.QFSPersonalAlbumEntranceView;
import com.tencent.biz.qqcircle.immersive.album.view.QFSPersonalAlbumGuildCreateView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalDittoFeedGuildItemView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalFeedItemView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalJustSeeFeedItemView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalOilCouponFeedItemView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalOutBoxFeedItemBaseView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalOutBoxFeedItemGuideView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalOutBoxFeedItemView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import z30.b;

/* loaded from: classes4.dex */
public class QFSPersonalFeedAdapter extends com.tencent.biz.qqcircle.bizparts.a<com.tencent.biz.qqcircle.immersive.personal.bean.k> implements b.a {
    private b40.d C;
    private boolean D;
    private d E;
    private com.tencent.biz.qqcircle.immersive.personal.publishguide.h F;
    private int G;
    private String H;

    /* renamed from: m, reason: collision with root package name */
    private f f88362m;

    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f88364d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.qqcircle.immersive.personal.bean.k f88365e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f88366f;

        a(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.k kVar, e eVar) {
            this.f88364d = i3;
            this.f88365e = kVar;
            this.f88366f = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QFSPersonalFeedAdapter.this.f88362m != null) {
                QFSPersonalFeedAdapter.this.D = false;
                QFSPersonalFeedAdapter.this.f88362m.a(this.f88364d, this.f88365e, this.f88366f.E);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.ViewHolder {
        public b(@NonNull View view) {
            super(view);
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends RecyclerView.ViewHolder {
        public QFSPersonalAlbumEntranceView E;

        public c(@NonNull View view) {
            super(view);
            this.E = (QFSPersonalAlbumEntranceView) view;
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends e {
        private final QFSPersonalOutBoxFeedItemBaseView F;

        public d(@NonNull @NotNull QFSPersonalOutBoxFeedItemBaseView qFSPersonalOutBoxFeedItemBaseView) {
            super(qFSPersonalOutBoxFeedItemBaseView);
            this.F = qFSPersonalOutBoxFeedItemBaseView;
        }

        public void l() {
            QFSPersonalOutBoxFeedItemBaseView qFSPersonalOutBoxFeedItemBaseView = this.F;
            if (qFSPersonalOutBoxFeedItemBaseView != null) {
                qFSPersonalOutBoxFeedItemBaseView.p0();
            }
        }

        public void m() {
            QFSPersonalOutBoxFeedItemBaseView qFSPersonalOutBoxFeedItemBaseView = this.F;
            if (qFSPersonalOutBoxFeedItemBaseView != null) {
                qFSPersonalOutBoxFeedItemBaseView.q0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends RecyclerView.ViewHolder {
        public QCircleBaseWidgetView E;

        public e(@NonNull QCircleBaseWidgetView qCircleBaseWidgetView) {
            super(qCircleBaseWidgetView);
            this.E = qCircleBaseWidgetView;
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.k kVar, QCircleBaseWidgetView qCircleBaseWidgetView);
    }

    /* loaded from: classes4.dex */
    private static class g extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSPersonalFeedAdapter> f88368a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        private final GridLayoutManager.SpanSizeLookup f88369b;

        public g(QFSPersonalFeedAdapter qFSPersonalFeedAdapter, @NonNull GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.f88368a = new WeakReference<>(qFSPersonalFeedAdapter);
            this.f88369b = spanSizeLookup;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i3) {
            QFSPersonalFeedAdapter qFSPersonalFeedAdapter = this.f88368a.get();
            if (qFSPersonalFeedAdapter != null && (qFSPersonalFeedAdapter.x0(i3) || qFSPersonalFeedAdapter.w0(i3) || qFSPersonalFeedAdapter.D0(i3))) {
                return qFSPersonalFeedAdapter.getViewTypeCount();
            }
            return this.f88369b.getSpanSize(i3);
        }
    }

    public QFSPersonalFeedAdapter(Bundle bundle) {
        super(bundle);
        this.D = true;
        this.G = -1;
        this.H = "";
    }

    private boolean B0(RecyclerView recyclerView, int i3, int i16) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return false;
        }
        if (!u0() && !R0() && !v0()) {
            if (i3 % i16 != 0) {
                return false;
            }
            return true;
        }
        if (i3 % i16 != 1) {
            return false;
        }
        return true;
    }

    private boolean C0(RecyclerView recyclerView, int i3, int i16) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return false;
        }
        if (!u0() && !R0() && !v0()) {
            if ((i3 + 1) % i16 != 0) {
                return false;
            }
            return true;
        }
        if ((i3 + 1) % i16 != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D0(int i3) {
        if (i3 == 0 && getItemViewType(i3) == 100106 && R0()) {
            return true;
        }
        return false;
    }

    private boolean F0() {
        List<E> list = this.mDataList;
        if (list != 0 && list.size() != 0) {
            Iterator it = this.mDataList.iterator();
            while (it.hasNext()) {
                if (A0((com.tencent.biz.qqcircle.immersive.personal.bean.k) it.next())) {
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }

    private void H0(View view, com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        switch (kVar.m()) {
            case AudienceReportConst.EVENT_ID_ENTER_ROOM_SUCCESS /* 100101 */:
                I0(view, kVar);
                return;
            case AudienceReportConst.EVENT_ID_ENTER_ROOM_FAILURE /* 100102 */:
                J0(view, kVar);
                return;
            case 100107:
                K0(view, kVar);
                return;
            default:
                return;
        }
    }

    private void I0(View view, com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        if (kVar == null) {
            return;
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRODUCT_LOOK_FINISHED, "no");
        buildElementParams.put("xsj_feed_id", kVar.d());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_SET_TOP, Integer.valueOf(kVar.q() ? 1 : 0));
        buildElementParams.put("xsj_tab_name", this.H);
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementReuseIdentifier(view, kVar.d());
    }

    private void J0(View view, com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        if (kVar == null) {
            return;
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRODUCT_LOOK_FINISHED, "yes");
        buildElementParams.put("xsj_feed_id", kVar.d());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_SET_TOP, Integer.valueOf(kVar.q() ? 1 : 0));
        buildElementParams.put("xsj_tab_name", this.H);
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementReuseIdentifier(view, kVar.d());
    }

    private void K0(View view, com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        if (kVar == null) {
            return;
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_HEATING_TICKET_PROFILE);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_HEATING_TICKET_ID, kVar.b().promoteInfo.ticketID);
        buildElementParams.put("xsj_feed_id", kVar.d());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, kVar.n());
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementReuseIdentifier(view, kVar.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(final int i3) {
        RecyclerView recyclerView;
        if (i3 != 0 && (recyclerView = this.mRecyclerView) != null) {
            if (recyclerView.isComputingLayout()) {
                this.mRecyclerView.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedAdapter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSPersonalFeedAdapter.this.L0(i3 - 1);
                    }
                }, 20L);
                return;
            } else {
                notifyDataSetChanged();
                return;
            }
        }
        RFWLog.i("QFSPersonalFeedAdapter", RFWLog.USR, "safeNotify return count = " + i3);
    }

    private boolean R0() {
        com.tencent.biz.qqcircle.immersive.personal.publishguide.h hVar = this.F;
        if (hVar != null && hVar.c() && com.tencent.biz.qqcircle.manager.i.a("qfs_personal_entrance_show")) {
            return true;
        }
        return false;
    }

    private void q0() {
        if (!R0()) {
            return;
        }
        com.tencent.biz.qqcircle.immersive.personal.bean.k kVar = new com.tencent.biz.qqcircle.immersive.personal.bean.k(null, null, 0);
        if (this.mDataList.isEmpty()) {
            this.mDataList.add(0, kVar);
            return;
        }
        if (((com.tencent.biz.qqcircle.immersive.personal.bean.k) this.mDataList.get(0)).m() == 100106) {
            return;
        }
        Iterator it = this.mDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (((com.tencent.biz.qqcircle.immersive.personal.bean.k) it.next()).m() == 100106) {
                it.remove();
                break;
            }
        }
        this.mDataList.add(0, kVar);
    }

    private void r0(@NonNull RecyclerView.ViewHolder viewHolder) {
        c cVar = (c) viewHolder;
        b40.d dVar = this.C;
        if (dVar != null) {
            cVar.E.setUserAlbum(dVar);
        }
    }

    private void s0(e eVar, com.tencent.biz.qqcircle.immersive.personal.bean.k kVar, int i3) {
        eVar.E.setData(kVar, i3);
    }

    private boolean u0() {
        b40.d dVar = this.C;
        if (dVar != null && dVar.a() != null && !this.C.a().isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean v0() {
        b40.d dVar = this.C;
        if (dVar == null || dVar.a() == null || this.C.a().isEmpty()) {
            return false;
        }
        for (int i3 = 0; i3 < this.C.a().size() && i3 <= 2; i3++) {
            b40.a aVar = this.C.a().get(i3);
            if (aVar.f() != null && aVar.f().album.status.get() == 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w0(int i3) {
        if (getItemViewType(i3) == 100109) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x0(int i3) {
        if (getItemViewType(i3) == 100104) {
            return true;
        }
        return false;
    }

    private boolean z0(int i3) {
        if (i3 != 100103 && i3 != 100108) {
            return false;
        }
        return true;
    }

    public boolean A0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        return z0(kVar.m());
    }

    public void E0() {
        if (F0()) {
            L0(5);
        }
    }

    public void M0(f fVar) {
        this.f88362m = fVar;
    }

    public void N0(@NonNull com.tencent.biz.qqcircle.immersive.personal.publishguide.h hVar) {
        this.F = hVar;
        if (this.G != -1) {
            if (hVar.c()) {
                notifyItemChanged(this.G);
                return;
            }
            if (getItemViewType(0) == 100106) {
                this.mDataList.remove(0);
            }
            notifyItemRemoved(this.G);
            return;
        }
        if (hVar.c()) {
            q0();
            L0(5);
        }
    }

    public void O0(String str) {
        this.H = str;
    }

    public void Q0(b40.d dVar) {
        this.C = dVar;
        L0(5);
    }

    @Override // z30.b.a
    public boolean a(MotionEvent motionEvent) {
        return R0();
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
        int i3;
        int i16;
        if (recyclerView != null && recyclerView.getAdapter() != null) {
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
            boolean B0 = B0(recyclerView, childLayoutPosition, 3);
            boolean C0 = C0(recyclerView, childLayoutPosition, 3);
            int a16 = cx.a(0.5f);
            if (B0) {
                i3 = 0;
            } else if (C0) {
                i3 = a16 * 2;
            } else {
                i3 = a16;
            }
            if (C0) {
                i16 = 0;
            } else if (B0) {
                i16 = a16 * 2;
            } else {
                i16 = a16;
            }
            rect.set(i3, 0, i16, a16 * 3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 <= this.mDataList.size() - 1 && i3 >= 0) {
            com.tencent.biz.qqcircle.immersive.personal.bean.k kVar = (com.tencent.biz.qqcircle.immersive.personal.bean.k) this.mDataList.get(i3);
            if (kVar.m() == 100107 && com.tencent.biz.qqcircle.immersive.utils.r.v0(kVar.n()) && kVar.p() == 20101) {
                return 100107;
            }
            return kVar.m();
        }
        return AudienceReportConst.EVENT_ID_ENTER_ROOM_SUCCESS;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return "FSPersonalFeedAdapter";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 3;
    }

    public void o0(ArrayList<com.tencent.biz.qqcircle.immersive.personal.bean.k> arrayList) {
        Iterator it = this.mDataList.iterator();
        while (it.hasNext()) {
            if (!A0((com.tencent.biz.qqcircle.immersive.personal.bean.k) it.next())) {
                it.remove();
            }
        }
        if (arrayList != null) {
            this.mDataList.addAll(arrayList);
        }
        L0(5);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.mRecyclerView.getLayoutManager() instanceof SafeGridLayoutManager) {
            SafeGridLayoutManager safeGridLayoutManager = (SafeGridLayoutManager) this.mRecyclerView.getLayoutManager();
            safeGridLayoutManager.setSpanSizeLookup(new g(this, safeGridLayoutManager.getSpanSizeLookup()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) int i3) {
        if (getItemViewType(i3) == 100104) {
            r0(viewHolder);
            return;
        }
        if (getItemViewType(i3) == 100109) {
            return;
        }
        if (getItemViewType(i3) == 100106) {
            this.G = i3;
            this.F.a(viewHolder);
        } else {
            if (z0(getItemViewType(i3))) {
                s0((e) viewHolder, (com.tencent.biz.qqcircle.immersive.personal.bean.k) this.mDataList.get(i3), i3);
                return;
            }
            com.tencent.biz.qqcircle.immersive.personal.bean.k kVar = (com.tencent.biz.qqcircle.immersive.personal.bean.k) this.mDataList.get(i3);
            e eVar = (e) viewHolder;
            eVar.E.setData(kVar, i3);
            eVar.E.setOnClickListener(new a(i3, kVar, eVar));
            H0(viewHolder.itemView, kVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        switch (i3) {
            case AudienceReportConst.EVENT_ID_ENTER_ROOM_FAILURE /* 100102 */:
                return new e(new QFSPersonalJustSeeFeedItemView(viewGroup.getContext()));
            case AudienceReportConst.EVENT_ID_PLAY_START /* 100103 */:
                d dVar = new d(new QFSPersonalOutBoxFeedItemView(viewGroup.getContext()));
                this.E = dVar;
                return dVar;
            case 100104:
                return new c(new QFSPersonalAlbumEntranceView(viewGroup.getContext()));
            case 100105:
            default:
                return new e(new QFSPersonalFeedItemView(viewGroup.getContext()));
            case 100106:
                return this.F.b(viewGroup);
            case 100107:
                return new e(new QFSPersonalOilCouponFeedItemView(viewGroup.getContext()));
            case 100108:
                d dVar2 = new d(new QFSPersonalOutBoxFeedItemGuideView(viewGroup.getContext()));
                this.E = dVar2;
                return dVar2;
            case AudienceReportConst.EVENT_ID_BUFFER_START /* 100109 */:
                return new b(new QFSPersonalAlbumGuildCreateView(viewGroup.getContext()));
            case AudienceReportConst.EVENT_ID_BUFFER_END /* 100110 */:
                return new e(new QFSPersonalDittoFeedGuildItemView(viewGroup.getContext()));
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        z30.b.f451838b.c(this);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        d dVar = this.E;
        if (dVar != null) {
            dVar.l();
        }
        z30.b.f451838b.a(this);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        d dVar = this.E;
        if (dVar != null) {
            dVar.m();
        }
    }

    public void p0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        if (kVar == null) {
            return;
        }
        if (this.mDataList.size() == 0) {
            this.mDataList.add(kVar);
            L0(5);
            return;
        }
        com.tencent.biz.qqcircle.immersive.personal.bean.k kVar2 = (com.tencent.biz.qqcircle.immersive.personal.bean.k) this.mDataList.get(0);
        F0();
        if (kVar2.m() != 100104 && kVar2.m() != 100106) {
            if (kVar2.m() == 100109) {
                this.mDataList.add(Math.min(this.mDataList.size(), 2), kVar);
            } else {
                this.mDataList.add(0, kVar);
            }
        } else {
            this.mDataList.add(1, kVar);
        }
        L0(5);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void setDatas(List<com.tencent.biz.qqcircle.immersive.personal.bean.k> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        L0(5);
    }

    public List<e30.b> t0() {
        ArrayList arrayList = new ArrayList();
        List<com.tencent.biz.qqcircle.immersive.personal.bean.k> dataList = getDataList();
        if (dataList != null && dataList.size() != 0) {
            for (com.tencent.biz.qqcircle.immersive.personal.bean.k kVar : dataList) {
                if (kVar.c() == null) {
                    arrayList.add(new e30.b(new FeedCloudMeta$StFeed()));
                } else {
                    arrayList.add(kVar.c());
                }
            }
        }
        return arrayList;
    }

    public boolean y0(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        if (kVar.m() == 100110) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
