package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.events.QFSDeleteBtnShowEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedAdapter;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSLayerFeedPosSyncEvent;
import com.tencent.biz.qqcircle.immersive.utils.ad;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StRecentWatchPageData;

/* loaded from: classes4.dex */
public class QFSPersonalFeedGridFragment extends QFSBaseFragment {
    private BlockPart E;
    private com.tencent.biz.qqcircle.immersive.personal.part.y F;
    private com.tencent.biz.qqcircle.immersive.personal.part.s G;
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.l H;
    protected RecyclerView I;
    private QFSPersonalFeedAdapter J;
    private com.tencent.biz.qqcircle.immersive.personal.bean.b K;
    protected int L = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            if (QFSPersonalFeedGridFragment.this.Fh(recyclerView)) {
                recyclerView.stopScroll();
            }
            if (recyclerView.getLayoutManager() instanceof SafeGridLayoutManager) {
                SafeGridLayoutManager safeGridLayoutManager = (SafeGridLayoutManager) recyclerView.getLayoutManager();
                QFSPersonalFeedGridFragment.this.L = ((safeGridLayoutManager.findFirstVisibleItemPosition() + safeGridLayoutManager.findLastVisibleItemPosition()) / 2) / 3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Observer<QQCircleFeedBase$StFeedListBusiRspData> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData) {
            QQCircleFeedBase$StRecentWatchPageData qQCircleFeedBase$StRecentWatchPageData;
            if (qQCircleFeedBase$StFeedListBusiRspData != null && (qQCircleFeedBase$StRecentWatchPageData = qQCircleFeedBase$StFeedListBusiRspData.recentWatchPageData) != null && !TextUtils.isEmpty(qQCircleFeedBase$StRecentWatchPageData.bottomContent.get())) {
                QFSPersonalFeedGridFragment.this.Lh(qQCircleFeedBase$StFeedListBusiRspData.recentWatchPageData.bottomContent.get());
            }
        }
    }

    private void Ah(QFSLayerFeedPosSyncEvent qFSLayerFeedPosSyncEvent) {
        QLog.i("QFSPersonalFeedGridFragment", 1, "QFSLayerFeedPosSyncEvent position = " + qFSLayerFeedPosSyncEvent.getPos());
        if (this.K != null && this.J != null && this.H != null && qFSLayerFeedPosSyncEvent.getPageCode() == hashCode()) {
            ad.f(this.J.t0(), this.I, null, qFSLayerFeedPosSyncEvent);
        }
    }

    private void Bh(UIStateData<List<e30.b>> uIStateData) {
        if (this.H != null && this.K != null && this.J != null && uIStateData != null && uIStateData.getData() != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<e30.b> it = uIStateData.getData().iterator();
            while (it.hasNext()) {
                arrayList.add(new com.tencent.biz.qqcircle.immersive.personal.bean.k(this.H.R1(), it.next(), this.K.b()));
            }
            this.J.setDatas(arrayList);
            this.J.notifyLoadingComplete(true, uIStateData.getIsFinish());
            this.G.hideLoadingView();
            this.F.E9();
            SimpleEventBus.getInstance().dispatchEvent(new QFSDeleteBtnShowEvent(true));
        }
    }

    private void Ch() {
        this.J.setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.m
            @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
            public final void onLoadData(LoadInfo loadInfo, Object obj) {
                QFSPersonalFeedGridFragment.this.Gh(loadInfo, (QFSPersonalFeedAdapter) obj);
            }
        });
        this.J.M0(new QFSPersonalFeedAdapter.f() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.n
            @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedAdapter.f
            public final void a(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.k kVar, QCircleBaseWidgetView qCircleBaseWidgetView) {
                QFSPersonalFeedGridFragment.this.Hh(i3, kVar, qCircleBaseWidgetView);
            }
        });
        NestScrollRecyclerView parentRecyclerView = this.J.getParentRecyclerView();
        this.I = parentRecyclerView;
        parentRecyclerView.addOnScrollListener(new a());
    }

    private void Dh() {
        this.E.getBlockContainer().getRecyclerView().setNestedScrollingEnabled(true);
        this.E.getBlockContainer().setEnableRefresh(false);
        this.E.getBlockContainer().setEnableLoadMore(true);
        this.E.getBlockContainer().setParentFragment(this);
        Lh(xh());
    }

    private void Eh() {
        if (this.K.b() == 20107) {
            this.H.U1(new com.tencent.biz.qqcircle.immersive.personal.interceptor.d());
            this.H.X1(new com.tencent.biz.qqcircle.immersive.personal.interceptor.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gh(LoadInfo loadInfo, QFSPersonalFeedAdapter qFSPersonalFeedAdapter) {
        if (this.H != null && loadInfo.isLoadMoreState()) {
            this.H.T1(this.K.b(), 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hh(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.k kVar, QCircleBaseWidgetView qCircleBaseWidgetView) {
        if (FastClickUtils.isFastDoubleClick("fast_click_personal_detail_publish")) {
            return;
        }
        vh(i3, kVar, qCircleBaseWidgetView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ih(UIStateData uIStateData) {
        int state = uIStateData.getState();
        if (state != 0) {
            if (state != 1) {
                if (state != 2 && state != 3) {
                    if (state == 4) {
                        zh(uIStateData);
                        return;
                    }
                    return;
                }
                Bh(uIStateData);
                return;
            }
            if (((List) uIStateData.getData()).isEmpty()) {
                this.G.showLoadingView();
                return;
            }
            return;
        }
        yh();
    }

    private List<MultiViewBlock> Jh() {
        ArrayList arrayList = new ArrayList();
        QFSPersonalFeedAdapter qFSPersonalFeedAdapter = new QFSPersonalFeedAdapter(new Bundle());
        this.J = qFSPersonalFeedAdapter;
        arrayList.add(qFSPersonalFeedAdapter);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh(String str) {
        if (this.K != null && this.J != null && !TextUtils.isEmpty(str) && this.K.b() == 20107) {
            this.J.getBlockMerger().setNoMoreHint(str);
        }
    }

    private void initViewModel() {
        if (getParentFragment() instanceof IPartHost) {
            this.H = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.l) getViewModel((IPartHost) getParentFragment(), null, com.tencent.biz.qqcircle.immersive.personal.viewmodel.l.class);
        } else {
            this.H = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.l) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.l.class);
        }
        w20.a.j().registerDisplaySurface(this.H.S1(), this.H);
        this.H.Q1().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalFeedGridFragment.this.Ih((UIStateData) obj);
            }
        });
        this.H.P1().observe(this, new b());
        if (this.K == null) {
            return;
        }
        Eh();
        this.H.W1(this.K);
        this.H.T1(this.K.b(), 1);
        com.tencent.biz.qqcircle.immersive.personal.part.y yVar = this.F;
        if (yVar == null) {
            return;
        }
        yVar.Q9();
    }

    private void vh(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.k kVar, QCircleBaseWidgetView qCircleBaseWidgetView) {
        if (kVar != null && qCircleBaseWidgetView != null && this.H != null) {
            QCircleLayerBean wh5 = wh(i3, kVar);
            int[] iArr = new int[2];
            qCircleBaseWidgetView.getLocationInWindow(iArr);
            QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
            int i16 = iArr[0];
            wh5.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i16, iArr[1], qCircleBaseWidgetView.getWidth() + i16, iArr[1] + qCircleBaseWidgetView.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(kVar.a()));
            wh5.setPrePersonalPageUin(this.H.R1());
            com.tencent.biz.qqcircle.launcher.c.u(getContext(), wh5);
        }
    }

    private String xh() {
        try {
            return String.format(com.tencent.biz.qqcircle.utils.h.a(R.string.f194574c_), Integer.valueOf(uq3.c.G4()));
        } catch (Exception e16) {
            QLog.e("QFSPersonalFeedGridFragment", 1, e16, new Object[0]);
            return "";
        }
    }

    private void yh() {
        this.F.M9(((QCircleBaseFragment) this).mContentView.getContext().getString(R.string.f194564c9), "");
        SimpleEventBus.getInstance().dispatchEvent(new QFSDeleteBtnShowEvent(false));
    }

    private void zh(UIStateData<List<e30.b>> uIStateData) {
        this.F.P9(uIStateData.getMsg(), uIStateData.getRetCode());
    }

    protected boolean Fh(RecyclerView recyclerView) {
        if (recyclerView == null || recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() < recyclerView.computeVerticalScrollRange()) {
            return false;
        }
        return true;
    }

    public void Kh(com.tencent.biz.qqcircle.immersive.personal.bean.b bVar) {
        if (bVar == null) {
            return;
        }
        this.K = bVar;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        BlockPart blockPart = new BlockPart(R.id.f4850206, Jh(), 2, 3);
        this.E = blockPart;
        arrayList.add(blockPart);
        com.tencent.biz.qqcircle.immersive.personal.part.s sVar = new com.tencent.biz.qqcircle.immersive.personal.part.s();
        this.G = sVar;
        arrayList.add(sVar);
        com.tencent.biz.qqcircle.immersive.personal.part.y yVar = new com.tencent.biz.qqcircle.immersive.personal.part.y();
        this.F = yVar;
        yVar.K9(true);
        arrayList.add(this.F);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168728gm3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_RECENT_WATCHED_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QFSLayerFeedPosSyncEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalFeedGridFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSLayerFeedPosSyncEvent) {
            Ah((QFSLayerFeedPosSyncEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        Dh();
        initViewModel();
        Ch();
    }

    public QCircleLayerBean wh(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        com.tencent.biz.qqcircle.immersive.personal.bean.b bVar = this.K;
        if (bVar != null) {
            qCircleLayerBean.setSourceType(bVar.b());
            qCircleInitBean.setSourceType(this.K.b());
        }
        if (kVar != null) {
            qCircleLayerBean.setFeed(kVar.b());
        }
        qCircleLayerBean.setDataPosInList(i3);
        qCircleLayerBean.setTransInitBean(qCircleInitBean);
        qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
        qCircleLayerBean.setGlobalViewModelKey(this.H.S1());
        qCircleLayerBean.setPageCode(hashCode());
        return qCircleLayerBean;
    }
}
