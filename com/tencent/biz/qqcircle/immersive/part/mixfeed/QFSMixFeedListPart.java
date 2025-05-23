package com.tencent.biz.qqcircle.immersive.part.mixfeed;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.ad;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseBlockPart;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.events.QFSRefreshSubTabEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSLayerTabPart;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedDividerView;
import com.tencent.biz.qqcircle.utils.cj;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.viewmodels.QFSMixFeedViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabClickSelfEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k30.b;
import qqcircle.QQCircleFeedBase$StTabInfo;
import t30.f;

/* loaded from: classes4.dex */
public class QFSMixFeedListPart extends QCircleBaseBlockPart implements SimpleEventReceiver {
    private v60.a C;
    private j20.a D;
    private RecyclerView E;
    private int F;
    private e G;

    /* renamed from: d, reason: collision with root package name */
    private ad f88187d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleTabInfo f88188e;

    /* renamed from: f, reason: collision with root package name */
    private int f88189f;

    /* renamed from: h, reason: collision with root package name */
    private String f88190h;

    /* renamed from: i, reason: collision with root package name */
    private QFSMixFeedViewModel f88191i;

    /* renamed from: m, reason: collision with root package name */
    private QCircleStatusView f88192m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QFSMixFeedListPart.this.f88187d != null && QFSMixFeedListPart.this.f88192m != null) {
                QFSMixFeedListPart.this.f88187d.onRefreshData();
                QFSMixFeedListPart.this.f88192m.setVisibility(8);
                QFSMixFeedListPart.this.ha();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Observer<UIStateData<List<e30.b>>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<List<e30.b>> uIStateData) {
            QFSMixFeedListPart.this.U9(uIStateData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements b.c {
        c() {
        }

        @Override // k30.b.c
        public void a(LoadInfo loadInfo, com.tencent.biz.qqcircle.bizparts.a<e30.b> aVar) {
            if (loadInfo.isLoadMoreState()) {
                QFSMixFeedListPart.this.X9();
            } else if (loadInfo.isRefreshState()) {
                QFSMixFeedListPart.this.ba();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d extends j20.a {
        d() {
        }

        @Override // j20.a
        public void c(String str, Object obj) {
            if (QFSMixFeedListPart.this.C != null) {
                QFSMixFeedListPart.this.C.onHandlerMessage(str, obj);
            }
            QFSMixFeedListPart.this.broadcastMessage(str, obj);
        }

        @Override // j20.a
        public boolean isContainerOnScreen() {
            if (QFSMixFeedListPart.this.getHostFragment() == null) {
                return false;
            }
            return QFSMixFeedListPart.this.getHostFragment().isResumed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class e implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QFSMixFeedListPart> f88197d;

        public e(QFSMixFeedListPart qFSMixFeedListPart) {
            this.f88197d = new WeakReference<>(qFSMixFeedListPart);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            WeakReference<QFSMixFeedListPart> weakReference = this.f88197d;
            if (weakReference != null && weakReference.get() != null) {
                this.f88197d.get().ca();
                this.f88197d.get().L9();
            } else {
                QLog.e("QFSMixFeedListPart", 1, "[onGlobalLayout] current mix feed list part not is null.");
            }
        }
    }

    public QFSMixFeedListPart(QCircleTabInfo qCircleTabInfo, int i3, int i16) {
        super(i3, null, 2, com.tencent.biz.qqcircle.immersive.views.mixfeed.d.f90915b);
        this.F = 0;
        this.f88188e = qCircleTabInfo;
        this.f88189f = i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void L9() {
        ViewTreeObserver viewTreeObserver;
        e eVar;
        RecyclerView recyclerView = this.E;
        if (recyclerView == null) {
            viewTreeObserver = null;
        } else {
            viewTreeObserver = recyclerView.getViewTreeObserver();
        }
        if (viewTreeObserver != null && (eVar = this.G) != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String N9() {
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo;
        if (!TextUtils.isEmpty(this.f88190h)) {
            return this.f88190h;
        }
        QCircleTabInfo qCircleTabInfo = this.f88188e;
        if (qCircleTabInfo != null && (qQCircleFeedBase$StTabInfo = qCircleTabInfo.mTab) != null) {
            int size = qQCircleFeedBase$StTabInfo.subTabInfo.size();
            int i3 = this.f88189f;
            if (size > i3) {
                this.f88190h = this.f88188e.mTab.subTabInfo.get(i3).tabName.get();
            }
        }
        return this.f88190h;
    }

    private void O9(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSRefreshSubTabEvent) {
            QFSRefreshSubTabEvent qFSRefreshSubTabEvent = (QFSRefreshSubTabEvent) simpleBaseEvent;
            if (qFSRefreshSubTabEvent.getCurrentPos() != this.f88189f) {
                return;
            }
            if (Y9()) {
                QLog.d("QFSMixFeedListPart", 1, N9() + "|mViewModel.refresh() return");
                return;
            }
            this.F = qFSRefreshSubTabEvent.getAnchor();
            QFSMixFeedViewModel qFSMixFeedViewModel = this.f88191i;
            if (qFSMixFeedViewModel != null) {
                qFSMixFeedViewModel.refresh();
            }
            scrollToTop();
            QLog.d("QFSMixFeedListPart", 1, N9() + "|onRefresh");
            return;
        }
        if ((simpleBaseEvent instanceof ASEngineTabClickSelfEvent) && ((QFSBaseFragment) getPartHost()).isResumed()) {
            scrollToTop();
            ba();
            QLog.d("QFSMixFeedListPart", 1, N9() + "|onRefresh by bottom selfClick");
        }
    }

    private void P9(UIStateData<List<e30.b>> uIStateData) {
        ad adVar = this.f88187d;
        if (adVar == null) {
            QLog.e(getTAG(), 1, N9() + " |handleEmptyRsp feed adapter is null!");
            return;
        }
        adVar.notifyLoadingComplete(true, uIStateData.getIsFinish());
        if (V9()) {
            QLog.e(getTAG(), 1, N9() + " |hasFeedContents do nothing");
        } else if (!uIStateData.getIsLoadMore()) {
            da(true, "");
        }
        if (uIStateData.getIsLoadMore()) {
            this.f88187d.getLoadInfo().setFinish(uIStateData.getIsFinish());
        }
    }

    private void R9(UIStateData<List<e30.b>> uIStateData) {
        ha();
        this.f88187d.q0(uIStateData.getData(), true, new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.mixfeed.QFSMixFeedListPart.4
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    private void S9(UIStateData<List<e30.b>> uIStateData) {
        List<e30.b> data = uIStateData.getData();
        if (data == null) {
            data = new ArrayList<>();
        }
        this.f88187d.q0(data, false, new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.mixfeed.QFSMixFeedListPart.3
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U9(UIStateData<List<e30.b>> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        int state = uIStateData.getState();
        if (state != 0) {
            if (state != 2 && state != 3) {
                if (state != 4) {
                    if (state != 6) {
                        if (state != 7) {
                            if (state != 8) {
                                return;
                            }
                        } else {
                            S9(uIStateData);
                            return;
                        }
                    }
                    R9(uIStateData);
                    return;
                }
                Q9(uIStateData);
                return;
            }
            T9(uIStateData);
            return;
        }
        P9(uIStateData);
    }

    private boolean V9() {
        ad adVar = this.f88187d;
        if (adVar != null && adVar.getItemCount() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X9() {
        if (Y9()) {
            QLog.d(getTAG(), 1, N9() + "|loadMore return");
            return;
        }
        QFSMixFeedViewModel qFSMixFeedViewModel = this.f88191i;
        if (qFSMixFeedViewModel != null) {
            qFSMixFeedViewModel.loadMoreForDisplaySurface(null);
        }
    }

    private boolean Y9() {
        if (QCirclePluginUtil.isNearBy(this.f88188e, this.f88189f) && !com.tencent.biz.qqcircle.c.e().k()) {
            return true;
        }
        return false;
    }

    private void Z9(long j3, String str) {
        if (!QCirclePluginUtil.isRequestSecurityHit(j3) && V9()) {
            cj.b(false, j3, str);
            return;
        }
        boolean z16 = !QCirclePluginUtil.isRequestSecurityHit(j3);
        this.f88187d.q0(new ArrayList(), true, null);
        ga(str, z16, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        if (Y9()) {
            QLog.d(getTAG(), 1, N9() + "|refreshData return");
            return;
        }
        ha();
        QFSMixFeedViewModel qFSMixFeedViewModel = this.f88191i;
        if (qFSMixFeedViewModel != null) {
            qFSMixFeedViewModel.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca() {
        if (this.F != 0 && getBlockContainer() != null && this.E != null) {
            RFWLog.i("QFSMixFeedListPart", RFWLog.USR, "[scrollToAnchor] -> mAnchor == " + this.F);
            if (this.E.isComputingLayout()) {
                RFWLog.i("QFSMixFeedListPart", RFWLog.USR, "[scrollToAnchor] -> recyclerView isComputingLayout");
                return;
            }
            SafeGridLayoutManager safeGridLayoutManager = (SafeGridLayoutManager) this.E.getLayoutManager();
            View view = null;
            if (safeGridLayoutManager != null) {
                for (int i3 = 0; i3 < safeGridLayoutManager.getChildCount(); i3++) {
                    View childAt = safeGridLayoutManager.getChildAt(i3);
                    if (this.F == 23 && (childAt instanceof QFSMixFeedDividerView)) {
                        view = childAt;
                    }
                    if (view != null) {
                        break;
                    }
                }
            }
            if (view == null) {
                RFWLog.i("QFSMixFeedListPart", RFWLog.USR, "[scrollToAnchor] -> targetView is null");
                return;
            }
            int top = view.getTop();
            if (top == 0) {
                RFWLog.i("QFSMixFeedListPart", RFWLog.USR, "[scrollToAnchor] -> top == 0");
                this.F = 0;
                return;
            }
            RFWLog.i("QFSMixFeedListPart", RFWLog.USR, "[scrollToAnchor] -> try to scroll by " + top);
            this.E.scrollBy(0, top);
        }
    }

    private void da(boolean z16, String str) {
        ea(z16, str, true);
    }

    private void ea(boolean z16, String str, boolean z17) {
        if (this.f88192m == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f88192m.y0(str, z17);
        } else if (z16) {
            this.f88192m.w0();
        } else {
            this.f88192m.o0();
        }
    }

    private void ga(String str, boolean z16, long j3) {
        if (this.f88192m == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f88192m.A0(str, z16, j3);
        } else {
            this.f88192m.w0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha() {
        QLog.d(getTAG(), 1, N9() + "|showRefreshAnimation");
        try {
            if (getBlockContainer() != null && getBlockContainer().getBlockMerger() != null) {
                getBlockContainer().getBlockMerger().k0();
            }
        } catch (Exception e16) {
            QLog.d(getTAG(), 1, N9() + "|showRefreshAnimation exception:" + e16.toString());
        }
    }

    private void ia() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.mixfeed.QFSMixFeedListPart.5
            @Override // java.lang.Runnable
            public void run() {
                if (QFSMixFeedListPart.this.getHostFragment() != null && QFSMixFeedListPart.this.getHostFragment().isResumed() && ((BlockPart) QFSMixFeedListPart.this).mBlockContainer != null && ((BlockPart) QFSMixFeedListPart.this).mBlockContainer.getRecyclerView() != null) {
                    QLog.e(QFSMixFeedListPart.this.getTAG(), 1, QFSMixFeedListPart.this.N9() + " |triggerDTTraversePage after data change!");
                    VideoReport.traversePage(((BlockPart) QFSMixFeedListPart.this).mBlockContainer.getRecyclerView());
                }
            }
        });
    }

    private void initViewModel() {
        QFSMixFeedViewModel qFSMixFeedViewModel = (QFSMixFeedViewModel) w20.a.j().getDisplaySurface(e30.b.class, QCirclePluginUtil.getSubTabViewModelKey(this.f88188e, this.f88189f));
        this.f88191i = qFSMixFeedViewModel;
        if (qFSMixFeedViewModel == null) {
            RFWLog.e("QFSMixFeedListPart", RFWLog.USR, "initViewModel null");
        } else {
            qFSMixFeedViewModel.getDisplaySurfaceData(null).observeForever(new b());
        }
    }

    private void scrollToTop() {
        RecyclerView recyclerView;
        if (getBlockContainer() != null && (recyclerView = this.E) != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    public void M9() {
        if (Y9()) {
            QLog.d(getTAG(), 1, N9() + "|refreshData return");
            return;
        }
        QFSMixFeedViewModel qFSMixFeedViewModel = this.f88191i;
        if (qFSMixFeedViewModel != null) {
            qFSMixFeedViewModel.h2();
        }
    }

    protected void Q9(UIStateData<List<e30.b>> uIStateData) {
        String msg2;
        if (uIStateData.getMsg() == null) {
            msg2 = h.a(R.string.f184743mp);
        } else {
            msg2 = uIStateData.getMsg();
        }
        QLog.e(getTAG(), 1, N9() + "|handleFeedDataRsp() return error\uff01errMsg:" + msg2);
        ad adVar = this.f88187d;
        if (adVar == null) {
            QLog.e(getTAG(), 1, N9() + "|handleErrorRsp feed adapter is null!");
            return;
        }
        adVar.notifyLoadingComplete(true, uIStateData.getIsFinish());
        Z9(uIStateData.getRetCode(), msg2);
    }

    protected void T9(UIStateData<List<e30.b>> uIStateData) {
        if (this.f88187d == null) {
            QLog.e(getTAG(), 1, N9() + "|handleNetSuccRsp feed adapter is null!");
            return;
        }
        if (uIStateData.getState() == 2) {
            QLog.d(getTAG(), 1, N9() + "|load data from cache");
        } else {
            this.f88187d.getLoadInfo().setFinish(uIStateData.getIsFinish());
            this.f88187d.notifyLoadingComplete(true, uIStateData.getIsFinish());
        }
        da(false, "");
        if (uIStateData.getIsLoadMore()) {
            this.f88187d.q0(uIStateData.getData(), false, null);
        } else {
            this.f88187d.q0(uIStateData.getData(), true, null);
        }
        ia();
    }

    protected void W9() {
        IStatusViewProvider statusViewProvider = getStatusViewProvider();
        if (!(statusViewProvider instanceof QCircleStatusView)) {
            return;
        }
        QCircleStatusView qCircleStatusView = (QCircleStatusView) statusViewProvider;
        this.f88192m = qCircleStatusView;
        qCircleStatusView.setOnRetryClickListener(new a());
    }

    protected void aa() {
        String str = QFSLayerTabPart.R;
        int i3 = this.f88189f;
        k30.b bVar = new k30.b(str, i3, 6, QCirclePluginUtil.getSubTabViewModelKey(this.f88188e, i3));
        bVar.g(getReportBean());
        bVar.h(this.f88188e);
        bVar.f(new c());
        this.f88187d = (ad) bVar.e();
        d dVar = new d();
        this.D = dVar;
        registerIoc(dVar, j20.a.class);
        this.mPeerBlocks.add(this.f88187d);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSRefreshSubTabEvent.class);
        arrayList.add(ASEngineTabClickSelfEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMixFeedListPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("qfs_refresh_data".equals(str)) {
            ba();
            return;
        }
        if ("qfs_show_refresh_ani".equals(str)) {
            getBlockContainer().getBlockMerger().k0();
        } else if ("qfs_change_loading_view_status".equals(str)) {
            this.f88187d.notifyLoadingComplete(true, false);
            da(false, "");
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QCircleBaseBlockPart, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (getBlockContainer() == null) {
            return;
        }
        getBlockContainer().setEnableRefresh(true);
        getBlockContainer().setEnableLoadMore(true);
        getBlockContainer().getBlockMerger().setTryToLoadMoreWhenNotFullScreen(2);
        this.E = getBlockContainer().getRecyclerView();
        this.G = new e(this);
        this.E.getViewTreeObserver().addOnGlobalLayoutListener(this.G);
        W9();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.C = (v60.a) getIocInterface(v60.a.class);
        SimpleEventBus.getInstance().registerReceiver(this);
        initViewModel();
        aa();
        QFSMixFeedViewModel qFSMixFeedViewModel = this.f88191i;
        if (qFSMixFeedViewModel != null) {
            qFSMixFeedViewModel.A2(f.U1(this.f88187d));
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        j20.a aVar = this.D;
        if (aVar != null) {
            aVar.d();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        L9();
        unregisterIoc(j20.a.class);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        j20.a aVar = this.D;
        if (aVar != null && aVar.b() != null) {
            Iterator<com.tencent.biz.qqcircle.immersive.views.mixfeed.a> it = this.D.b().iterator();
            while (it.hasNext()) {
                it.next().onPause();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        j20.a aVar = this.D;
        if (aVar != null && aVar.b() != null) {
            Iterator<com.tencent.biz.qqcircle.immersive.views.mixfeed.a> it = this.D.b().iterator();
            while (it.hasNext()) {
                it.next().onResume();
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        O9(simpleBaseEvent);
    }
}
