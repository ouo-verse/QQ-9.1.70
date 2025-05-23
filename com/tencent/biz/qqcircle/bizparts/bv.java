package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.fragments.QFSPolymerizationPanelFragment;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSShowPolymerizationPanelEvent;
import com.tencent.biz.qqcircle.utils.QFSHalfScreenFloatingView;
import com.tencent.biz.qqcircle.widgets.QCircleRoundCorneredRelativeLayout;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bv extends com.tencent.biz.qqcircle.bizparts.b implements SimpleEventReceiver, View.OnClickListener, t40.g {
    private ImageView C;
    private ImageView D;
    private int E = 0;
    private QCirclePolymerizationBean F;

    /* renamed from: d, reason: collision with root package name */
    private QFSHalfScreenFloatingView f82974d;

    /* renamed from: e, reason: collision with root package name */
    private volatile QFSPolymerizationPanelFragment f82975e;

    /* renamed from: f, reason: collision with root package name */
    protected int f82976f;

    /* renamed from: h, reason: collision with root package name */
    private String f82977h;

    /* renamed from: i, reason: collision with root package name */
    private FeedCloudMeta$StFeed f82978i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f82979m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends com.tencent.mobileqq.widget.qus.e {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float f16, float f17) {
            if (bv.this.f82975e != null) {
                return bv.this.f82975e.Ch().canScrollVertically(-1);
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float f16, float f17) {
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF57419d() {
            View inflate = LayoutInflater.from(bv.this.getContext()).inflate(R.layout.gnr, (ViewGroup) null, false);
            bv.this.P9(inflate);
            return inflate;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            return 2;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return bv.this.K9();
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
            VideoReport.traversePage(bv.this.f82974d);
            com.tencent.biz.qqcircle.immersive.utils.r.Z0(bv.this.getContext());
            Fragment hostFragment = bv.this.getHostFragment();
            if (hostFragment != null && hostFragment.isAdded() && bv.this.f82975e != null) {
                try {
                    hostFragment.getChildFragmentManager().beginTransaction().setMaxLifecycle(bv.this.f82975e, Lifecycle.State.RESUMED).commitAllowingStateLoss();
                } catch (Exception e16) {
                    QLog.e("QFSPolymerizationPanelPart", 1, "set state resumed error", e16);
                }
            }
            bv.this.V9();
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotalStart() {
            int i3;
            if (bv.this.f82975e == null) {
                bv.this.f82975e = new QFSPolymerizationPanelFragment(bv.this);
                bv.this.f82975e.Dh(bv.this.F);
                Fragment hostFragment = bv.this.getHostFragment();
                if (hostFragment != null && hostFragment.isAdded()) {
                    hostFragment.getChildFragmentManager().beginTransaction().replace(R.id.cks, bv.this.f82975e).commitAllowingStateLoss();
                }
            }
            if (bv.this.S9()) {
                com.tencent.biz.qqcircle.immersive.utils.ax.g(bv.this.getContext(), false);
                SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(40, bv.this.f82977h, true));
                Context context = bv.this.getContext();
                com.tencent.biz.qqcircle.helpers.v vVar = com.tencent.biz.qqcircle.helpers.v.f84667a;
                if (context != null) {
                    i3 = context.hashCode();
                } else {
                    i3 = 0;
                }
                vVar.b(i3, true);
                SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(false, context));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements QUSBaseHalfScreenFloatingView.l {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
        public void onDismiss() {
            int i3;
            if (bv.this.S9()) {
                Context context = bv.this.getContext();
                if (context != null && !com.tencent.biz.qqcircle.helpers.i.f84624a.a(String.valueOf(context.hashCode()))) {
                    com.tencent.biz.qqcircle.immersive.utils.ax.g(bv.this.getContext(), true);
                }
                SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(40, bv.this.f82977h, false));
                com.tencent.biz.qqcircle.helpers.v vVar = com.tencent.biz.qqcircle.helpers.v.f84667a;
                if (context != null) {
                    i3 = context.hashCode();
                } else {
                    i3 = 0;
                }
                vVar.b(i3, false);
                SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(true, bv.this.getContext()));
            }
            Fragment hostFragment = bv.this.getHostFragment();
            if (hostFragment != null && hostFragment.isAdded() && bv.this.f82975e != null) {
                try {
                    hostFragment.getChildFragmentManager().beginTransaction().setMaxLifecycle(bv.this.f82975e, Lifecycle.State.STARTED).commitAllowingStateLoss();
                } catch (Exception e16) {
                    QLog.e("QFSPolymerizationPanelPart", 1, "set state started error", e16);
                }
            }
            bv.this.V9();
            if (bv.this.f82974d != null) {
                bv.this.f82974d.r();
            }
            com.tencent.biz.qqcircle.immersive.utils.r.Z0(bv.this.getContext());
        }
    }

    private int J9() {
        int i3 = this.f82976f;
        if (i3 != 0) {
            return i3;
        }
        int g16 = com.tencent.biz.qqcircle.comment.af.g(this.f82974d);
        this.f82976f = g16;
        return g16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int K9() {
        int screenWidth = DisplayUtil.getScreenWidth();
        int J9 = J9();
        if (!com.tencent.biz.qqcircle.utils.bz.r()) {
            screenWidth = Math.min(J9, DisplayUtil.getScreenWidth());
            J9 = Math.max(J9, DisplayUtil.getScreenWidth());
        }
        int i3 = (int) (screenWidth * 0.5625f);
        int commentBottomBarHeightUncaredVisible = (J9 - i3) - getCommentBottomBarHeightUncaredVisible();
        if (commentBottomBarHeightUncaredVisible < i3) {
            commentBottomBarHeightUncaredVisible = ((int) (J9 * 0.7d)) - getCommentBottomBarHeightUncaredVisible();
        }
        QLog.d("QFSPolymerizationPanelPart", 1, "[getHigherPanelHeight] higherPanelHeight: " + commentBottomBarHeightUncaredVisible + ", topSpaceHeight: " + i3 + ", screenHeight: " + J9);
        return commentBottomBarHeightUncaredVisible;
    }

    private void L9(@NonNull QCircleFeedEvent qCircleFeedEvent) {
        if (qCircleFeedEvent.mState == 3 && !TextUtils.isEmpty(this.f82977h) && TextUtils.equals(qCircleFeedEvent.mTargetId, this.f82977h)) {
            M9();
        }
    }

    private void M9() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f82974d;
        if (qFSHalfScreenFloatingView == null) {
            return;
        }
        qFSHalfScreenFloatingView.t();
    }

    private void N9(QFSShowPolymerizationPanelEvent qFSShowPolymerizationPanelEvent) {
        if (qFSShowPolymerizationPanelEvent == null) {
            return;
        }
        startInit();
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f82974d;
        if (qFSHalfScreenFloatingView != null) {
            qFSHalfScreenFloatingView.r();
            this.f82974d.P(0);
        }
    }

    private void O9(@NonNull QFSShowPolymerizationPanelEvent qFSShowPolymerizationPanelEvent) {
        if (qFSShowPolymerizationPanelEvent.getHashCode() != getContext().hashCode()) {
            return;
        }
        FeedCloudMeta$StFeed stFeed = qFSShowPolymerizationPanelEvent.getStFeed();
        if (this.f82978i != stFeed) {
            T9();
        }
        this.f82978i = stFeed;
        this.f82977h = stFeed.f398449id.get();
        this.F = qFSShowPolymerizationPanelEvent.getBean();
        if (qFSShowPolymerizationPanelEvent.isShow()) {
            N9(qFSShowPolymerizationPanelEvent);
        } else {
            M9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P9(View view) {
        if (view == null) {
            return;
        }
        this.f82979m = (ImageView) view.findViewById(R.id.f44171og);
        this.C = (ImageView) view.findViewById(R.id.y_s);
        this.D = (ImageView) view.findViewById(R.id.f165970y94);
        this.f82979m.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q9() {
        this.f82974d.L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R9() {
        if (this.f82975e == null) {
            return;
        }
        this.f82975e.registerDaTongReportPageId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S9() {
        if (this.E == 0) {
            return true;
        }
        return false;
    }

    private void T9() {
        M9();
        Fragment hostFragment = getHostFragment();
        if (hostFragment != null && hostFragment.isAdded() && this.f82975e != null) {
            hostFragment.getChildFragmentManager().beginTransaction().remove(this.f82975e).commitAllowingStateLoss();
            U9();
            this.f82975e = null;
        }
    }

    private void U9() {
        ImageView imageView = this.C;
        if (imageView != null) {
            imageView.setOnClickListener(null);
        }
        ImageView imageView2 = this.D;
        if (imageView2 != null) {
            imageView2.setOnClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V9() {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.bu
            @Override // java.lang.Runnable
            public final void run() {
                bv.this.R9();
            }
        }, 200L);
    }

    private int getCommentBottomBarHeightUncaredVisible() {
        return (int) getActivity().getResources().getDimension(R.dimen.d0x);
    }

    private void handleTabStatusEvent(@NonNull ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        if (aSEngineTabStatusEvent.getBusinessKey().equals(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE) && !aSEngineTabStatusEvent.isSelected()) {
            QLog.d("QFSPolymerizationPanelPart", 1, "receive onTab selected event");
            T9();
        }
    }

    private void initHalfScreenView() {
        this.f82974d.q();
        this.f82974d.setIgnoreHorizontalMove(true);
        this.f82974d.setQUSDragFloatController(new a());
        this.f82974d.j(new b());
        this.f82974d.T(new c());
        if (this.f82974d.x() instanceof ViewGroup) {
            ((ViewGroup) this.f82974d.x()).setClipToPadding(false);
            ((ViewGroup) this.f82974d.x()).setClipChildren(false);
        }
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_mini_profile_adapt_navigation_bar", true)) {
            com.tencent.mobileqq.qui.b.f276860a.a(this.f82974d, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
        }
    }

    @Override // t40.g
    @NonNull
    public ImageView A() {
        return this.C;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSShowPolymerizationPanelEvent.class);
        arrayList.add(QCircleSelectTabEvent.class);
        arrayList.add(QCircleFeedEvent.class);
        arrayList.add(ASEngineTabStatusEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        return R.id.f493222d;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPolymerizationPanelPart";
    }

    @Override // t40.g
    @NonNull
    public ImageView k2() {
        return this.D;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f82974d;
        if (qFSHalfScreenFloatingView != null && qFSHalfScreenFloatingView.getVisibility() == 0) {
            M9();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && !fb0.a.a("QFSPolymerizationPanelPart_onClick") && view.getId() == R.id.f44171og) {
            M9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f82974d;
        if (qFSHalfScreenFloatingView == null) {
            return;
        }
        this.f82976f = 0;
        qFSHalfScreenFloatingView.setTag(Boolean.valueOf(QCirclePanelStateEvent.isSpecifiedPanelShowing(40)));
        M9();
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.bt
            @Override // java.lang.Runnable
            public final void run() {
                bv.this.Q9();
            }
        }, this.f82974d.w());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        this.f82974d = (QFSHalfScreenFloatingView) view.findViewById(R.id.f4925227);
        initHalfScreenView();
        ((QCircleRoundCorneredRelativeLayout) this.f82974d.findViewById(R.id.f4924226)).setRadius(com.tencent.biz.qqcircle.utils.cx.a(8.0f), com.tencent.biz.qqcircle.utils.cx.a(8.0f), 0.0f, 0.0f);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSShowPolymerizationPanelEvent) {
            O9((QFSShowPolymerizationPanelEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleSelectTabEvent) {
            M9();
        } else if (simpleBaseEvent instanceof QCircleFeedEvent) {
            L9((QCircleFeedEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            handleTabStatusEvent((ASEngineTabStatusEvent) simpleBaseEvent);
        }
    }

    @Override // t40.g
    @NonNull
    public ImageView v6() {
        return this.f82979m;
    }
}
