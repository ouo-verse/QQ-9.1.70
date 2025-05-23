package com.tencent.biz.qqcircle.immersive.part;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.adapter.z;
import com.tencent.biz.qqcircle.immersive.events.QFSPublishShareBannerCloseEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSResetPublishShareBannerShowTimeEvent;
import com.tencent.biz.qqcircle.immersive.part.QFSTopPopShareBannerPart;
import com.tencent.biz.qqcircle.widgets.QCirclePublishCallbackHelper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QCircleFeedOptEvent;
import com.tencent.mobileqq.qqforward.api.RecentContactListener;
import com.tencent.mobileqq.qqforward.api.RecentUserBean;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
public class QFSTopPopShareBannerPart extends u implements View.OnClickListener, SimpleEventReceiver {
    public static final int K = com.tencent.biz.qqcircle.utils.cx.a(-184.0f);
    public static final int L = com.tencent.biz.qqcircle.utils.cx.j(18.0f);
    public static final int M = com.tencent.biz.qqcircle.utils.cx.j(12.0f);
    public static final int N = com.tencent.biz.qqcircle.utils.cx.j(20.0f);
    public static final int P = com.tencent.biz.qqcircle.utils.cx.j(20.0f);
    public static final int Q = com.tencent.biz.qqcircle.utils.cx.j(20.0f);
    public static final int R = com.tencent.biz.qqcircle.utils.cx.j(33.0f);
    private com.tencent.biz.qqcircle.immersive.viewmodel.wink.f C;
    private com.tencent.biz.qqcircle.widgets.a D;
    private List<RecentUserBean> E;
    private boolean F = false;
    private boolean G = false;
    private int H = -1;
    private boolean I = false;
    Runnable J = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSTopPopShareBannerPart.1
        @Override // java.lang.Runnable
        public void run() {
            if (QFSTopPopShareBannerPart.this.G) {
                QFSTopPopShareBannerPart.this.G = false;
                QFSTopPopShareBannerPart.this.ma();
            } else {
                QFSTopPopShareBannerPart.this.W9();
            }
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f87629d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView f87630e;

    /* renamed from: f, reason: collision with root package name */
    private e f87631f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f87632h;

    /* renamed from: i, reason: collision with root package name */
    private View f87633i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.adapter.z f87634m;

    /* loaded from: classes4.dex */
    class a implements Observer<List<e40.o>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<e40.o> list) {
            QFSTopPopShareBannerPart.this.S9();
            QFSTopPopShareBannerPart.this.f87634m.setDatas(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements RecentContactListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qqforward.api.RecentContactListener
        public void onResult(List<RecentUserBean> list) {
            int i3;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("initViewModel... [onResult] recentUserList:");
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            QLog.d("QFSTopPopShareBannerPart", 1, sb5.toString());
            QFSTopPopShareBannerPart.this.E = list;
            QFSTopPopShareBannerPart.this.C.P1(QFSTopPopShareBannerPart.this.getActivity(), list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class e extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final int f87641d;

        /* renamed from: e, reason: collision with root package name */
        final int f87642e;

        /* renamed from: f, reason: collision with root package name */
        final int f87643f;

        public e(int i3, int i16, int i17) {
            this.f87641d = i3;
            this.f87642e = i16;
            this.f87643f = i17;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (recyclerView.getAdapter() == null) {
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.f87641d;
                rect.right = this.f87642e / 2;
            } else if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 1) {
                rect.left = this.f87642e / 2;
                rect.right = this.f87643f;
            } else {
                int i3 = this.f87642e;
                rect.left = i3 / 2;
                rect.right = i3 / 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q9(View view, int i3, int i16, boolean z16) {
        if (this.I) {
            if (z16) {
                view.setVisibility(8);
            }
        } else {
            if (view.getVisibility() != 0) {
                return;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", ViewUtils.dpToPx(i3), ViewUtils.dpToPx(i16));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat);
            animatorSet.setDuration(240L);
            animatorSet.start();
            animatorSet.addListener(new d(z16, view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R9(e40.o oVar) {
        com.tencent.biz.qqcircle.immersive.viewmodel.wink.f fVar = this.C;
        if (fVar == null) {
            QLog.e("QFSTopPopShareBannerPart", 1, "forward failed by view model is null");
            return;
        }
        try {
            FeedCloudMeta$StFeed value = fVar.O1().getValue();
            if (value == null) {
                QLog.w("QFSTopPopShareBannerPart", 1, "forward failed, publish feed data is empty");
                return;
            }
            QCircleShareInfo c16 = com.tencent.biz.qqcircle.immersive.utils.au.c(value);
            c16.feed = value;
            c16.silentShareType = la(oVar.b());
            if (oVar.b() != 2) {
                c16.mShareUin = oVar.c();
                c16.mShareUinType = oVar.b();
                c16.mShareUinName = oVar.a();
            }
            broadcastMessage("share_action_silent_share", c16);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("QFSTopPopShareBannerPart", 1, "forward failed:" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S9() {
        String M1 = this.C.M1();
        if (M1.equals("experiment_a")) {
            this.f87633i.setVisibility(0);
            this.f87631f = new e(L, N, M);
            VideoReport.setElementId(this.f87633i, QCircleDaTongConstant.ElementId.EM_XSJ_PYLIST_AT_BUTTON);
        } else if (M1.equals("experiment_b")) {
            this.f87631f = new e(P, R, Q);
            this.f87633i.setVisibility(8);
        }
        this.f87630e.addItemDecoration(this.f87631f);
    }

    private void T9(QCircleFeedOptEvent qCircleFeedOptEvent) {
        QLog.i("QFSTopPopShareBannerPart", 1, "[handleFeedOptEvent]");
        this.C.T1(qCircleFeedOptEvent.getFeed());
        if (com.tencent.biz.qqcircle.immersive.viewmodel.wink.f.Q1(qCircleFeedOptEvent.getFeed())) {
            QLog.d("QFSTopPopShareBannerPart", 1, "[handleFeedOptEvent]:is secret feed");
            return;
        }
        if (ha()) {
            FrameLayout frameLayout = this.f87629d;
            if (frameLayout != null && frameLayout.getVisibility() == 0) {
                getMainHandler().removeCallbacks(this.J);
                ma();
                return;
            } else {
                ia();
                return;
            }
        }
        QLog.i("QFSTopPopShareBannerPart", 1, "[handleFeedOptEvent]: not ShowInThisTab");
        V9();
    }

    private void U9(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            this.H = intValue;
            QLog.d("QFSTopPopShareBannerPart", 1, "[handleTabChangedEvent]... type:", Integer.valueOf(intValue));
        }
    }

    private void V9() {
        if (this.f87629d == null) {
            return;
        }
        getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.ga
            @Override // java.lang.Runnable
            public final void run() {
                QFSTopPopShareBannerPart.this.Z9();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W9() {
        if (this.f87629d == null) {
            return;
        }
        getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.gb
            @Override // java.lang.Runnable
            public final void run() {
                QFSTopPopShareBannerPart.this.aa();
            }
        });
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(6, "", false));
    }

    private boolean X9() {
        return !"".equals(this.C.M1());
    }

    private boolean Y9(List<RecentUserBean> list) {
        String U3 = uq3.c.U3();
        if (list.isEmpty()) {
            QLog.d("QFSTopPopShareBannerPart", 1, "isExperimentOpenForContentLayer... no RecentUsers");
            U3 = "";
        }
        return !"".equals(U3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z9() {
        this.f87629d.setVisibility(8);
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(6, "", false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aa() {
        Q9(this.f87629d, 0, K, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ba(QCircleInitBean qCircleInitBean) {
        if (!com.tencent.biz.qqcircle.immersive.viewmodel.wink.f.Q1(qCircleInitBean.getFeed())) {
            this.C.T1(qCircleInitBean.getFeed());
            this.F = true;
            na();
            ia();
            return;
        }
        QLog.d("QFSTopPopShareBannerPart", 1, "[showShareFriendsBannerIfNeed]:is secret feed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ca(final QCircleInitBean qCircleInitBean, List list) {
        if (this.C != null && getActivity() != null && Y9(list) && !this.F) {
            getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.gc
                @Override // java.lang.Runnable
                public final void run() {
                    QFSTopPopShareBannerPart.this.ba(qCircleInitBean);
                }
            });
        }
    }

    private void da() {
        if (fb0.a.a("QFSTopPopShareBannerPart") || this.C == null) {
            return;
        }
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        qFSCommentInfo.mFeed = this.C.O1().getValue();
        qFSCommentInfo.mHintText = getContext().getString(R.string.f1647826r);
        qFSCommentInfo.mReportBean = getReportBean();
        QFSCommentInfo.ActionBean actionBean = new QFSCommentInfo.ActionBean();
        actionBean.mNeedShowAt = true;
        qFSCommentInfo.mActionBean = actionBean;
        broadcastMessage("comment_panel_show", qFSCommentInfo);
    }

    private void ea() {
        if (this.D == null) {
            b bVar = new b();
            this.D = bVar;
            QCirclePublishCallbackHelper.f93064a.i(bVar, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga() {
        String dtPageId;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_SHARE_PANEL_TOP);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYLIST_TYPE, 1);
        if (getReportBean() == null) {
            dtPageId = "";
        } else {
            dtPageId = getReportBean().getDtPageId();
        }
        buildElementParams.put("xsj_custom_pgid", dtPageId);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    private boolean ha() {
        return com.tencent.biz.qqcircle.immersive.utils.r.q0(this.H);
    }

    private void ia() {
        if (this.f87629d == null) {
            QLog.e("QFSTopPopShareBannerPart", 1, "show err, mBannerView is null.");
        } else {
            getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSTopPopShareBannerPart.5
                @Override // java.lang.Runnable
                public void run() {
                    QFSTopPopShareBannerPart.this.f87629d.setVisibility(0);
                    SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(6, "", true));
                    QFSTopPopShareBannerPart.this.ga();
                    QFSTopPopShareBannerPart qFSTopPopShareBannerPart = QFSTopPopShareBannerPart.this;
                    qFSTopPopShareBannerPart.Q9(qFSTopPopShareBannerPart.f87629d, QFSTopPopShareBannerPart.K, 0, false);
                }
            });
            ma();
        }
    }

    private void initViewModel() {
        this.C = (com.tencent.biz.qqcircle.immersive.viewmodel.wink.f) getViewModel(com.tencent.biz.qqcircle.immersive.viewmodel.wink.f.class);
        com.tencent.biz.qqcircle.immersive.utils.bp.f90195c.c(new c());
    }

    private void ja() {
        int i3;
        try {
            Bundle extras = getActivity().getIntent().getExtras();
            Objects.requireNonNull(extras);
            final QCircleInitBean qCircleInitBean = (QCircleInitBean) extras.get("key_bundle_common_init_bean");
            if (qCircleInitBean != null) {
                i3 = qCircleInitBean.getExtraTypeInfo().sourceType;
            } else {
                i3 = 0;
            }
            QLog.d("QFSTopPopShareBannerPart", 1, "showShareFriendsBannerIfNeed... sourceType:" + i3);
            if (i3 == 59 && qCircleInitBean.getFeed() != null) {
                com.tencent.biz.qqcircle.immersive.utils.bp.f90195c.c(new RecentContactListener() { // from class: com.tencent.biz.qqcircle.immersive.part.fz
                    @Override // com.tencent.mobileqq.qqforward.api.RecentContactListener
                    public final void onResult(List list) {
                        QFSTopPopShareBannerPart.this.ca(qCircleInitBean, list);
                    }
                });
                return;
            }
            QLog.d("QFSTopPopShareBannerPart", 1, "[showShareFriendsBannerIfNeed], sourceType:" + i3);
        } catch (Exception e16) {
            QLog.e("QFSTopPopShareBannerPart", 1, "show ShareFriendsBanner failed with:" + e16.getMessage());
        }
    }

    private int la(int i3) {
        if (i3 == 0 || i3 == 1) {
            return 2;
        }
        if (i3 != 2) {
            return -1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ma() {
        getMainHandler().postDelayed(this.J, 7000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na() {
        if (this.f87629d == null) {
            QLog.d("QFSTopPopShareBannerPart", 1, "tryInitView...");
            startInit();
        }
    }

    private void oa() {
        com.tencent.biz.qqcircle.widgets.a aVar = this.D;
        if (aVar != null) {
            QCirclePublishCallbackHelper.f93064a.v(aVar);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QCircleFeedOptEvent.class);
        arrayList.add(QFSPublishShareBannerCloseEvent.class);
        arrayList.add(QFSResetPublishShareBannerShowTimeEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        return R.id.f55762is;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSTopPopShareBannerPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        if (TextUtils.equals(str, "tab_changed_new_layer")) {
            U9(obj);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.f55722io && id5 != R.id.f55712in) {
            if (id5 == R.id.f55752ir) {
                QLog.i("QFSTopPopShareBannerPart", 1, "QFSTopPopShareBannerPart @ click");
                da();
            }
        } else {
            V9();
            SimpleEventBus.getInstance().dispatchEvent(new QFSPublishShareBannerCloseEvent());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        String dtPageId;
        super.onInitView(view);
        FrameLayout frameLayout = (FrameLayout) getPartRootView().findViewById(R.id.f55712in);
        this.f87629d = frameLayout;
        if (frameLayout == null) {
            QLog.e("QFSTopPopShareBannerPart", 1, "banner inflate failed");
            return;
        }
        this.f87630e = (RecyclerView) frameLayout.findViewById(R.id.f55772it);
        this.f87632h = (ImageView) this.f87629d.findViewById(R.id.f55722io);
        this.f87633i = this.f87629d.findViewById(R.id.f55752ir);
        this.f87632h.setOnClickListener(this);
        this.f87629d.setOnClickListener(this);
        this.f87633i.setOnClickListener(this);
        com.tencent.biz.qqcircle.immersive.adapter.z zVar = new com.tencent.biz.qqcircle.immersive.adapter.z(getContext());
        this.f87634m = zVar;
        zVar.n0(new z.b() { // from class: com.tencent.biz.qqcircle.immersive.part.fy
            @Override // com.tencent.biz.qqcircle.immersive.adapter.z.b
            public final void a(e40.o oVar) {
                QFSTopPopShareBannerPart.this.R9(oVar);
            }
        });
        com.tencent.biz.qqcircle.immersive.adapter.z zVar2 = this.f87634m;
        if (getReportBean() == null) {
            dtPageId = "";
        } else {
            dtPageId = getReportBean().getDtPageId();
        }
        zVar2.m0(dtPageId);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.f87630e.setLayoutManager(linearLayoutManager);
        this.f87630e.setAdapter(this.f87634m);
        this.C.N1().observe(getHostFragment(), new a());
        if (this.E != null) {
            this.C.P1(getActivity(), this.E);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
        ea();
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        super.onPartDestroy(activity);
        oa();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        ja();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (this.C == null) {
            return;
        }
        if (!X9()) {
            QLog.i("QFSTopPopShareBannerPart", 1, "isExperimentOpen false");
            return;
        }
        if (simpleBaseEvent instanceof QCircleFeedOptEvent) {
            T9((QCircleFeedOptEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSPublishShareBannerCloseEvent) {
            V9();
        } else if (simpleBaseEvent instanceof QFSResetPublishShareBannerShowTimeEvent) {
            this.G = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends com.tencent.biz.qqcircle.widgets.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            QFSTopPopShareBannerPart.this.na();
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onTaskStateChanged(@NonNull TaskInfo taskInfo) {
            QLog.d("QFSTopPopShareBannerPart", 1, "onTaskStateChanged, taskId:" + taskInfo.getTaskId());
            if (QFSTopPopShareBannerPart.this.f87629d == null) {
                QFSTopPopShareBannerPart.this.getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.gd
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSTopPopShareBannerPart.b.this.b();
                    }
                });
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onProgressChanged(@NonNull TaskInfo taskInfo) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f87638d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f87639e;

        d(boolean z16, View view) {
            this.f87638d = z16;
            this.f87639e = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            QFSTopPopShareBannerPart.this.I = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f87638d) {
                this.f87639e.setVisibility(8);
            }
            QFSTopPopShareBannerPart.this.I = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSTopPopShareBannerPart.this.I = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
