package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.biz.qqcircle.beans.QCircleTagChallengeInfo;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSTopicChallengeBannerClickEvent;
import com.tencent.biz.qqcircle.utils.QFSHalfScreenFloatingView;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import s70.b;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ar extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener, SimpleEventReceiver {
    public static final String G = "com.tencent.biz.qqcircle.immersive.part.ar";
    private static final int H = com.tencent.biz.qqcircle.utils.cx.a(212.0f);
    private QCircleBlockContainer C;
    private View D;
    private com.tencent.biz.qqcircle.adapter.n E;
    private s70.b F;

    /* renamed from: d, reason: collision with root package name */
    private View f87708d;

    /* renamed from: e, reason: collision with root package name */
    private ViewStub f87709e;

    /* renamed from: f, reason: collision with root package name */
    private View f87710f;

    /* renamed from: h, reason: collision with root package name */
    private View f87711h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f87712i;

    /* renamed from: m, reason: collision with root package name */
    private QFSHalfScreenFloatingView f87713m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends com.tencent.mobileqq.widget.qus.e {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float f16, float f17) {
            if (ar.this.C != null && ar.this.C.getRecyclerView() != null) {
                return ar.this.C.getRecyclerView().canScrollVertically(-1);
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float f16, float f17) {
            boolean z16;
            boolean z17;
            if (ar.this.f87711h != null && ar.this.f87711h.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (ar.this.D != null && ar.this.D.getVisibility() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z16 && !z17) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF57419d() {
            return LayoutInflater.from(ar.this.f87713m.getContext()).inflate(R.layout.g6_, (ViewGroup) null, false);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return (int) (DisplayUtil.getInstantScreenHeight(ar.this.f87713m.getContext()) * 0.7d);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends com.tencent.mobileqq.widget.qus.a {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            if (ar.this.F != null && ar.this.F.Q1().getValue() != null) {
                ar.this.X9(ar.this.F.N1());
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotalStart() {
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(16, "", true));
            com.tencent.biz.qqcircle.immersive.utils.ax.h(ar.this.getContext(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            ar.this.F.X1(ar.this.F.O1() + i16);
            super.onScrolled(recyclerView, i3, i16);
        }
    }

    private void K9() {
        int i3;
        if (com.tencent.biz.qqcircle.utils.bz.k() && this.f87713m != null) {
            int min = Math.min(com.tencent.biz.qqcircle.utils.cx.g(), com.tencent.biz.qqcircle.utils.cx.f());
            QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f87713m;
            if (com.tencent.biz.qqcircle.utils.bz.o()) {
                i3 = com.tencent.biz.qqcircle.utils.cx.j(min);
            } else {
                i3 = 0;
            }
            qFSHalfScreenFloatingView.setMaxWidthDp(i3);
        }
    }

    private boolean M9() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f87713m;
        if (qFSHalfScreenFloatingView != null && qFSHalfScreenFloatingView.getVisibility() == 0) {
            this.f87713m.t();
            return true;
        }
        return false;
    }

    private void N9(Object obj) {
        s70.b bVar;
        if ((obj instanceof e30.b) && (bVar = this.F) != null) {
            bVar.Q1().setValue(c40.d.c((e30.b) obj));
        }
    }

    private void O9() {
        this.F.R1().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.al
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ar.this.S9((List) obj);
            }
        });
        this.F.P1().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.am
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ar.this.T9((b.a) obj);
            }
        });
        this.F.Q1().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.an
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ar.this.U9((QCircleTagChallengeInfo) obj);
            }
        });
        this.C.getRecyclerView().addOnScrollListener(new c());
    }

    private boolean P9() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f87713m;
        if (qFSHalfScreenFloatingView != null && qFSHalfScreenFloatingView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q9(LoadInfo loadInfo, Object obj) {
        if (loadInfo.isLoadMoreState()) {
            W9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R9() {
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(16, "", false));
        com.tencent.biz.qqcircle.immersive.utils.ax.h(getContext(), true);
        this.f87713m.L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S9(List list) {
        if (list != null && list.size() > 0) {
            Z9(false, false);
            int N1 = this.F.N1();
            if (this.F.H) {
                this.E.l0(list, N1);
                return;
            } else {
                this.E.q3(list, N1);
                return;
            }
        }
        Z9(false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T9(b.a aVar) {
        if (aVar.getCurrentState() == 4) {
            this.E.notifyLoadingComplete(aVar.f433416a, aVar.isFinish());
        } else {
            this.E.getLoadInfo().setFinish(aVar.isFinish());
            this.E.getLoadInfo().setCurrentState(aVar.getCurrentState());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U9(QCircleTagChallengeInfo qCircleTagChallengeInfo) {
        if (qCircleTagChallengeInfo != null) {
            this.E.n0(this.F.M1(qCircleTagChallengeInfo.mTagId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V9(int i3) {
        if (i3 <= 1) {
            this.C.getRecyclerView().scrollToPosition(0);
            return;
        }
        int O1 = this.F.O1();
        int i16 = H;
        this.C.getRecyclerView().scrollBy(0, (((i3 - 1) * i16) + (i16 / 2)) - O1);
    }

    private void W9() {
        this.F.loadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X9(final int i3) {
        if (this.E.getDataList().size() > 0 && i3 >= 0) {
            this.C.getRecyclerView().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.aq
                @Override // java.lang.Runnable
                public final void run() {
                    ar.this.V9(i3);
                }
            });
        }
    }

    private void Y9() {
        this.F.U1();
    }

    private void Z9(boolean z16, boolean z17) {
        View view = this.D;
        if (view != null && this.C != null) {
            int i3 = 0;
            if (z16) {
                view.setVisibility(0);
                this.C.setVisibility(8);
            } else {
                view.setVisibility(8);
                this.C.setVisibility(0);
            }
            View view2 = this.f87711h;
            if (view2 != null) {
                if (!z17) {
                    i3 = 8;
                }
                view2.setVisibility(i3);
            }
        }
    }

    private void aa() {
        QCircleBlockContainer qCircleBlockContainer = this.C;
        if (qCircleBlockContainer != null && this.f87710f != null && this.f87713m != null) {
            qCircleBlockContainer.getBlockMerger().resetTryToLoadMoreCount();
            this.f87710f.setVisibility(0);
            this.f87713m.P(0);
        }
    }

    private void init() {
        this.f87709e = (ViewStub) getPartRootView().findViewById(R.id.f100215rw);
        this.F = (s70.b) getViewModel(s70.b.class);
        initView();
        initBlockContainer();
        O9();
        Y9();
    }

    private void initBlockContainer() {
        this.C.setLayoutManagerType(1, 1);
        this.C.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        this.C.setEnableLoadMore(true);
        this.C.setEnableRefresh(false);
        this.C.setParentFragment(getHostFragment());
        this.C.getRecyclerView().setNestedScrollingEnabled(true);
        ArrayList<MultiViewBlock> arrayList = new ArrayList<>();
        com.tencent.biz.qqcircle.adapter.n nVar = new com.tencent.biz.qqcircle.adapter.n(null);
        this.E = nVar;
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            nVar.setReportBean(qCircleReportBean);
        }
        this.E.setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: com.tencent.biz.qqcircle.immersive.part.ao
            @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
            public final void onLoadData(LoadInfo loadInfo, Object obj) {
                ar.this.Q9(loadInfo, obj);
            }
        });
        arrayList.add(this.E);
        this.C.getRecyclerView().setItemAnimator(new EnhanceItemAnimator());
        if (this.C.getRecyclerView().getItemAnimator() instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) this.C.getRecyclerView().getItemAnimator()).setSupportsChangeAnimations(false);
        }
        this.C.registerBlock(arrayList);
        this.C.start();
    }

    private void initHalfScreenView() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f87713m;
        if (qFSHalfScreenFloatingView == null) {
            return;
        }
        qFSHalfScreenFloatingView.q();
        this.f87713m.v(false);
        K9();
        this.f87713m.setQUSDragFloatController(new a());
        this.f87713m.j(new b());
        this.f87713m.T(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.biz.qqcircle.immersive.part.ap
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                ar.this.R9();
            }
        });
    }

    private void initView() {
        View inflate = this.f87709e.inflate();
        this.f87710f = inflate;
        this.f87713m = (QFSHalfScreenFloatingView) inflate.findViewById(R.id.f55802iw);
        initHalfScreenView();
        this.f87708d = this.f87710f.findViewById(R.id.f100205rv);
        this.D = this.f87710f.findViewById(R.id.f32960v6);
        View findViewById = this.f87710f.findViewById(R.id.f32950v5);
        this.f87711h = findViewById;
        TextView textView = (TextView) findViewById.findViewById(R.id.f166327f13);
        this.f87712i = textView;
        textView.setText(R.string.f182993hz);
        this.C = (QCircleBlockContainer) this.f87710f.findViewById(R.id.f32930v3);
    }

    public void L9() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.f87708d, QCircleDaTongConstant.PageId.PG_XSJ_TOPIC_CHALLENGE_RANKING_PAGE);
        VideoReport.setPageParams(this.f87708d, new QCircleDTParamBuilder().buildPageParams(getTAG()));
        VideoReport.setElementDynamicParams(this.f87708d, new QCircleDTParamBuilder().buildElementDynamicParams());
        VideoReport.setEventDynamicParams(this.f87708d, new QCircleDTParamBuilder().buildDynamicParams());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        arrayList.add(QFSTopicChallengeBannerClickEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return G;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("layer_notify_part_update_feed".equals(str)) {
            N9(obj);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (!M9() && !super.onBackEvent()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        K9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        init();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        M9();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSTopicChallengeBannerClickEvent) {
            QLog.d(G, 1, "[onReceiveEvent] receive QFSTopicChallengeBannerClickEvent");
            if (P9()) {
                M9();
            } else {
                if (this.F.R1().getValue() == null || this.F.R1().getValue().size() == 0) {
                    Y9();
                }
                aa();
            }
            L9();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
