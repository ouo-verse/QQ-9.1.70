package com.tencent.biz.qqcircle.bizparts;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.adapter.h;
import com.tencent.biz.qqcircle.bizparts.z;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSHeaderRefreshEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFollowTabLiveListEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSLiveStatusChangedEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSLockRateStatusChangeEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.requests.QCircleLivingAnchorListRequest;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$StGetUserFollowLivingListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class z extends com.tencent.biz.qqcircle.bizparts.b implements SimpleEventReceiver {
    private static int Q;
    private QFSPageTurnContainer C;
    private FrameLayout D;
    private ViewGroup E;
    private TextView F;
    private ImageView G;
    private List<FeedCloudMeta$StUser> H;
    private View I;
    private IAegisLogApi J;
    private QCircleLivingAnchorListRequest K;

    /* renamed from: e, reason: collision with root package name */
    private boolean f83127e;

    /* renamed from: f, reason: collision with root package name */
    private ViewStub f83128f;

    /* renamed from: h, reason: collision with root package name */
    private View f83129h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView f83130i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.qqcircle.adapter.h f83131m;

    /* renamed from: d, reason: collision with root package name */
    private boolean f83126d = false;
    private boolean L = true;
    private boolean M = false;
    private ValueAnimator N = null;
    private ValueAnimator P = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            z.this.f83126d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            z.this.ca();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetUserFollowLivingListRsp> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(boolean z16, long j3, FeedCloudRead$StGetUserFollowLivingListRsp feedCloudRead$StGetUserFollowLivingListRsp) {
            z.this.N9(z16, j3, feedCloudRead$StGetUserFollowLivingListRsp);
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, final boolean z16, final long j3, String str, final FeedCloudRead$StGetUserFollowLivingListRsp feedCloudRead$StGetUserFollowLivingListRsp) {
            z.this.C.post(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.aa
                @Override // java.lang.Runnable
                public final void run() {
                    z.c.this.b(z16, j3, feedCloudRead$StGetUserFollowLivingListRsp);
                }
            });
        }
    }

    private void H9() {
        if (getPartRootView() != null && this.f83128f == null) {
            this.C = (QFSPageTurnContainer) getPartRootView().findViewById(R.id.f165301vg1);
            Q = com.tencent.biz.qqcircle.utils.cx.j(DisplayUtil.getTopHeight(getContext())) + 161 + 10;
        }
    }

    private void I9() {
        this.J.i("QCircleTopLiveListPart", 1, "dismissLiveList");
        ViewGroup viewGroup = this.E;
        if (viewGroup != null && this.D != null) {
            viewGroup.setVisibility(8);
            this.D.setVisibility(8);
            this.f83127e = false;
            ga(0);
            da(120);
            Y9(false);
        }
    }

    private void K9(QFSHeaderRefreshEvent qFSHeaderRefreshEvent) {
        if (qFSHeaderRefreshEvent.getTabType() != 1) {
            return;
        }
        X9();
    }

    private void L9(QFSLiveStatusChangedEvent qFSLiveStatusChangedEvent) {
        if (this.H == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.H.size(); i3++) {
            if (qFSLiveStatusChangedEvent.getFinishLiveUins().contains(this.H.get(i3).f398463id.get())) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.H.remove(((Integer) it.next()).intValue());
            }
            this.f83131m.notifyDataSetChanged();
        }
        if (this.H.isEmpty()) {
            I9();
        }
    }

    private void M9(QFSLockRateStatusChangeEvent qFSLockRateStatusChangeEvent) {
        if (this.E == null || !qFSLockRateStatusChangeEvent.getIsFollowPage()) {
            return;
        }
        if (qFSLockRateStatusChangeEvent.getIsLockRate()) {
            if (this.E.getVisibility() == 0) {
                this.E.setVisibility(8);
                this.M = true;
                return;
            }
            return;
        }
        if (this.M) {
            this.E.setVisibility(0);
            this.M = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N9(boolean z16, long j3, FeedCloudRead$StGetUserFollowLivingListRsp feedCloudRead$StGetUserFollowLivingListRsp) {
        this.J.i("QCircleTopLiveListPart", 1, "handleRsp isSuccess =" + z16 + ",retCode=" + j3);
        if (z16 && j3 == 0) {
            if (feedCloudRead$StGetUserFollowLivingListRsp.userlist.size() > 0) {
                this.J.i("QCircleTopLiveListPart", 1, "handleRsp livingListRsp.userlist.size=" + feedCloudRead$StGetUserFollowLivingListRsp.userlist.get().size());
                List<FeedCloudMeta$StUser> list = feedCloudRead$StGetUserFollowLivingListRsp.userlist.get();
                for (FeedCloudMeta$StUser feedCloudMeta$StUser : list) {
                    this.J.i("QCircleTopLiveListPart", 1, "icon=" + feedCloudMeta$StUser.icon.iconUrl.get() + ",nick=" + feedCloudMeta$StUser.nick.get() + ",jumpUrl=" + feedCloudMeta$StUser.jumpUrl.get());
                }
                if (R9(list.size())) {
                    list.subList(0, 10);
                    list.add(J9());
                }
                P9();
                ea(list);
                return;
            }
            I9();
            this.J.e("QCircleTopLiveListPart", 1, "handleRsp livingListRsp.userlist==null");
            return;
        }
        I9();
    }

    private void O9() {
        if (this.I != null) {
            return;
        }
        View inflate = ((ViewStub) getPartRootView().findViewById(R.id.f30770p9)).inflate();
        this.I = inflate;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.height = DisplayUtil.dip2px(getContext(), 22.0f);
        this.I.setLayoutParams(layoutParams);
        this.I.setVisibility(8);
        this.E = (ViewGroup) getPartRootView().findViewById(R.id.f31460r4);
        this.F = (TextView) getPartRootView().findViewById(R.id.f31440r2);
        this.G = (ImageView) getPartRootView().findViewById(R.id.f31430r1);
        this.E.setOnClickListener(new b());
    }

    private void P9() {
        this.f83128f = (ViewStub) getPartRootView().findViewById(R.id.f30780p_);
        Q9();
        O9();
    }

    private void Q9() {
        if (this.f83129h != null) {
            return;
        }
        View inflate = this.f83128f.inflate();
        this.f83129h = inflate;
        inflate.setVisibility(8);
        this.f83130i = (RecyclerView) this.f83129h.findViewById(R.id.f9175561);
        FrameLayout frameLayout = (FrameLayout) this.f83129h.findViewById(R.id.vct);
        this.D = frameLayout;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.topMargin = DisplayUtil.getTopHeight(getContext()) + DisplayUtil.dip2px(getContext(), 54.0f);
        this.D.setLayoutParams(layoutParams);
        this.f83130i.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ArrayList arrayList = new ArrayList();
        this.H = arrayList;
        com.tencent.biz.qqcircle.adapter.h hVar = new com.tencent.biz.qqcircle.adapter.h(arrayList);
        this.f83131m = hVar;
        this.f83130i.setAdapter(hVar);
        this.C.setActionDownEventListener(new QFSPageTurnContainer.g() { // from class: com.tencent.biz.qqcircle.bizparts.u
            @Override // com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.g
            public final boolean a() {
                boolean S9;
                S9 = z.this.S9();
                return S9;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean S9() {
        this.J.i("QCircleTopLiveListPart", 1, "isChildDisallowInterceptListener, isShowLiveList " + this.f83127e);
        if (this.f83127e) {
            ca();
        }
        return this.f83127e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T9(ValueAnimator valueAnimator) {
        ga(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U9(ValueAnimator valueAnimator) {
        da(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V9() {
        this.D.setVisibility(8);
        this.F.setText("\u6b63\u5728\u76f4\u64ad");
        this.f83127e = false;
        this.L = false;
        Y9(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W9() {
        this.D.setVisibility(0);
        this.F.setText("\u4e0a\u6ed1\u5173\u95ed");
        this.f83127e = true;
        this.L = true;
        Y9(true);
    }

    private void X9() {
        this.K = new QCircleLivingAnchorListRequest();
        VSNetworkHelper.getInstance().sendRequest(this.K, new c());
    }

    private void Y9(boolean z16) {
        SimpleEventBus.getInstance().dispatchEvent(new QFSFollowTabLiveListEvent(z16));
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(34, "", z16));
    }

    private void Z9(boolean z16) {
        if (z16) {
            this.N = ValueAnimator.ofInt(0, 161);
            this.P = ValueAnimator.ofInt(120, Q);
        } else {
            this.N = ValueAnimator.ofInt(161, 0);
            this.P = ValueAnimator.ofInt(Q, 120);
        }
        this.N.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.bizparts.x
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                z.this.T9(valueAnimator);
            }
        });
        this.P.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.bizparts.y
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                z.this.U9(valueAnimator);
            }
        });
        this.N.setDuration(400L);
        this.N.start();
        this.P.setDuration(400L);
        this.f83126d = true;
        this.P.addListener(new a());
        this.P.start();
    }

    private void aa() {
        QLog.i("QCircleTopLiveListPart", 1, "startLiveAnimation");
        try {
            if (this.f83130i != null) {
                for (int i3 = 0; i3 < this.f83130i.getChildCount(); i3++) {
                    RecyclerView recyclerView = this.f83130i;
                    RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i3));
                    if (childViewHolder instanceof h.a) {
                        ((h.a) childViewHolder).o();
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("QCircleTopLiveListPart", 1, "startLiveAnimation exception:", e16);
        }
    }

    private void ba() {
        QLog.i("QCircleTopLiveListPart", 1, "stopLiveAnimation");
        try {
            if (this.f83130i != null) {
                for (int i3 = 0; i3 < this.f83130i.getChildCount(); i3++) {
                    RecyclerView recyclerView = this.f83130i;
                    RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i3));
                    if (childViewHolder instanceof h.a) {
                        ((h.a) childViewHolder).p();
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("QCircleTopLiveListPart", 1, "stopLiveAnimation exception:", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca() {
        this.J.e("QCircleTopLiveListPart", 1, "switchLiveStatus isShowLiveList = " + this.f83127e + ", isAnimating = " + this.f83126d);
        FrameLayout frameLayout = this.D;
        if (frameLayout != null && !this.f83126d) {
            if (this.f83127e) {
                frameLayout.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.this.V9();
                    }
                }, 200L);
                Z9(false);
            } else {
                frameLayout.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.this.W9();
                    }
                }, 200L);
                Z9(true);
            }
            this.G.animate().rotationBy(180.0f);
        }
    }

    private void da(int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.E.getLayoutParams();
        layoutParams.topMargin = DisplayUtil.dip2px(getContext(), i3);
        this.E.setLayoutParams(layoutParams);
    }

    private void ea(List<FeedCloudMeta$StUser> list) {
        this.J.i("QCircleTopLiveListPart", 1, "showLiveList=" + this.f83127e);
        boolean z16 = this.L;
        this.f83127e = z16;
        if (z16) {
            ga(161);
            da(Q);
            this.E.setVisibility(0);
            this.D.setVisibility(0);
            Y9(true);
        } else {
            ga(0);
            da(120);
            this.E.setVisibility(0);
            this.D.setVisibility(8);
            Y9(false);
        }
        this.H.clear();
        this.H.addAll(list);
        this.f83131m.notifyDataSetChanged();
    }

    private void ga(int i3) {
        this.C.setTranslationY(DisplayUtil.dip2px(getContext(), i3));
    }

    FeedCloudMeta$StUser J9() {
        FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
        feedCloudMeta$StUser.type.set(1);
        return feedCloudMeta$StUser;
    }

    boolean R9(int i3) {
        if (i3 >= 10) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSHeaderRefreshEvent.class);
        arrayList.add(QFSLiveStatusChangedEvent.class);
        arrayList.add(QFSLockRateStatusChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleTopLiveListPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Object getMessage(String str, Object obj) {
        if (TextUtils.equals(str, "qfs_action_top_live_status")) {
            return Boolean.valueOf(this.f83127e);
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return com.tencent.biz.qqcircle.manager.i.a("qfs_live_entrance_show");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        H9();
        this.J = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        if (this.K != null) {
            VSNetworkHelper.getInstance().cancelRequest(getContext(), this.K.getContextHashCode());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QLog.i("QCircleTopLiveListPart", 1, "onPartPause");
        ba();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        this.J.i("QCircleTopLiveListPart", 1, "onPartResume");
        X9();
        aa();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSHeaderRefreshEvent) {
            K9((QFSHeaderRefreshEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSLiveStatusChangedEvent) {
            L9((QFSLiveStatusChangedEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSLockRateStatusChangeEvent) {
            M9((QFSLockRateStatusChangeEvent) simpleBaseEvent);
        }
    }
}
