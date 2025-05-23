package com.tencent.biz.qqcircle.immersive.search;

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
import com.tencent.biz.qqcircle.comment.af;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.helpers.s;
import com.tencent.biz.qqcircle.immersive.QFSPanelProfileFragment;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSReleaseMiniFragmentEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSShowPersonalPanelEvent;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSAdjustBottomHeightEvent;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSSetViewPagerOrientationEvent;
import com.tencent.biz.qqcircle.immersive.utils.ax;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.utils.QFSHalfScreenFloatingView;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
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
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class QFSPersonalPanelPart extends com.tencent.biz.qqcircle.bizparts.b implements SimpleEventReceiver, View.OnClickListener, t40.e {
    private FeedCloudMeta$StFeed C;
    private ImageView D;
    private ImageView E;
    private ImageView F;
    private int G;
    private int H;
    private QUSBaseHalfScreenFloatingView.l I;

    /* renamed from: d, reason: collision with root package name */
    private QFSHalfScreenFloatingView f89849d;

    /* renamed from: e, reason: collision with root package name */
    private volatile QFSPanelProfileFragment f89850e;

    /* renamed from: f, reason: collision with root package name */
    private int f89851f;

    /* renamed from: h, reason: collision with root package name */
    protected int f89852h;

    /* renamed from: i, reason: collision with root package name */
    private int f89853i = 1;

    /* renamed from: m, reason: collision with root package name */
    private String f89854m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends com.tencent.mobileqq.widget.qus.e {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float f16, float f17) {
            if (QFSPersonalPanelPart.this.f89850e != null) {
                return QFSPersonalPanelPart.this.f89850e.Jh().canScrollVertically(-1);
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
            View inflate = LayoutInflater.from(QFSPersonalPanelPart.this.getContext()).inflate(R.layout.gmo, (ViewGroup) null, false);
            QFSPersonalPanelPart.this.W9(inflate);
            return inflate;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            return 2;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return QFSPersonalPanelPart.this.f89853i == 2 ? QFSPersonalPanelPart.this.P9() : QFSPersonalPanelPart.this.O9();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends com.tencent.mobileqq.widget.qus.a {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            VideoReport.traversePage(QFSPersonalPanelPart.this.f89849d);
            r.Z0(QFSPersonalPanelPart.this.getContext());
            Fragment hostFragment = QFSPersonalPanelPart.this.getHostFragment();
            if (hostFragment != null && hostFragment.isAdded() && QFSPersonalPanelPart.this.f89850e != null) {
                try {
                    hostFragment.getChildFragmentManager().beginTransaction().setMaxLifecycle(QFSPersonalPanelPart.this.f89850e, Lifecycle.State.RESUMED).commitAllowingStateLoss();
                } catch (Exception e16) {
                    QLog.e("QFSPersonalPanelPart", 1, "set state resumed error", e16);
                }
            }
            QFSPersonalPanelPart.this.ga();
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotalStart() {
            int i3;
            if (QFSPersonalPanelPart.this.f89850e == null) {
                QFSPersonalPanelPart.this.f89850e = new QFSPanelProfileFragment(QFSPersonalPanelPart.this);
                QFSPersonalPanelPart.this.f89850e.vi(QFSPersonalPanelPart.this.C, true);
                Fragment hostFragment = QFSPersonalPanelPart.this.getHostFragment();
                if (hostFragment != null && hostFragment.isAdded()) {
                    hostFragment.getChildFragmentManager().beginTransaction().replace(R.id.f4851207, QFSPersonalPanelPart.this.f89850e).commitAllowingStateLoss();
                }
            }
            QFSPersonalPanelPart.this.f89850e.ki(10);
            QFSPersonalPanelPart.this.f89850e.ti();
            if (QFSPersonalPanelPart.this.Z9()) {
                ax.g(QFSPersonalPanelPart.this.getContext(), false);
                SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(29, QFSPersonalPanelPart.this.f89854m, true));
                Context context = QFSPersonalPanelPart.this.getContext();
                s sVar = s.f84663a;
                if (context != null) {
                    i3 = context.hashCode();
                } else {
                    i3 = 0;
                }
                sVar.b(i3, true);
                SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(false, QFSPersonalPanelPart.this.getContext()));
                if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_change_personal_viewpager_orientation", true)) {
                    SimpleEventBus.getInstance().dispatchEvent(new QFSSetViewPagerOrientationEvent(0, QFSPersonalPanelPart.this.f89850e.hashCode()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements QUSBaseHalfScreenFloatingView.l {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
        public void onDismiss() {
            int i3;
            if (QFSPersonalPanelPart.this.Z9()) {
                Context context = QFSPersonalPanelPart.this.getContext();
                SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(29, QFSPersonalPanelPart.this.f89854m, false));
                if (context != null && !com.tencent.biz.qqcircle.helpers.i.f84624a.a(String.valueOf(context.hashCode()))) {
                    ax.g(QFSPersonalPanelPart.this.getContext(), true);
                }
                s sVar = s.f84663a;
                if (context != null) {
                    i3 = context.hashCode();
                } else {
                    i3 = 0;
                }
                sVar.b(i3, false);
                SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(true, QFSPersonalPanelPart.this.getContext()));
                if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_change_personal_viewpager_orientation", true) && QFSPersonalPanelPart.this.f89850e != null) {
                    SimpleEventBus.getInstance().dispatchEvent(new QFSSetViewPagerOrientationEvent(1, QFSPersonalPanelPart.this.f89850e.hashCode()));
                }
            }
            Fragment hostFragment = QFSPersonalPanelPart.this.getHostFragment();
            if (hostFragment != null && hostFragment.isAdded() && QFSPersonalPanelPart.this.f89850e != null) {
                try {
                    hostFragment.getChildFragmentManager().beginTransaction().setMaxLifecycle(QFSPersonalPanelPart.this.f89850e, Lifecycle.State.STARTED).commitAllowingStateLoss();
                } catch (Exception e16) {
                    QLog.e("QFSPersonalPanelPart", 1, "set state started error", e16);
                }
            }
            QFSPersonalPanelPart.this.ga();
            if (QFSPersonalPanelPart.this.I != null) {
                QFSPersonalPanelPart.this.I.onDismiss();
            }
            if (QFSPersonalPanelPart.this.f89849d != null) {
                QFSPersonalPanelPart.this.f89849d.r();
            }
            r.Z0(QFSPersonalPanelPart.this.getContext());
        }
    }

    private void M9() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f89849d;
        if (qFSHalfScreenFloatingView == null) {
            QLog.e(getTAG(), 1, "[dispatchAdjustBottomHeightEvent] half screen view is null");
        } else {
            qFSHalfScreenFloatingView.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.search.d
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPersonalPanelPart.this.X9();
                }
            });
        }
    }

    private int N9() {
        int i3 = this.f89852h;
        if (i3 != 0) {
            return i3;
        }
        int g16 = af.g(this.f89849d);
        this.f89852h = g16;
        return g16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int O9() {
        int i3 = this.f89851f;
        if (i3 != 0 && this.f89852h != 0) {
            return i3;
        }
        int screenWidth = DisplayUtil.getScreenWidth();
        int N9 = N9() - this.H;
        if (!bz.r()) {
            screenWidth = Math.min(N9, DisplayUtil.getScreenWidth());
            N9 = Math.max(N9, DisplayUtil.getScreenWidth());
        }
        int i16 = (int) (screenWidth * 0.5625f);
        int i17 = N9 - i16;
        if (i17 < i16) {
            i17 = (int) (N9 * 0.7d);
        }
        this.f89851f = i17;
        QLog.d("QFSPersonalPanelPart", 1, "[getHigherPanelHeight] higherPanelHeight: " + i17 + ", topSpaceHeight: " + i16 + ", screenHeight: " + N9);
        return i17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int P9() {
        return O9() / 2;
    }

    private void Q9(@NonNull QCircleFeedEvent qCircleFeedEvent) {
        if (qCircleFeedEvent.mState == 3 && !TextUtils.isEmpty(this.f89854m) && TextUtils.equals(qCircleFeedEvent.mTargetId, this.f89854m)) {
            R9();
        }
    }

    private void R9() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f89849d;
        if (qFSHalfScreenFloatingView == null) {
            return;
        }
        qFSHalfScreenFloatingView.t();
    }

    private void S9(QFSShowPersonalPanelEvent qFSShowPersonalPanelEvent) {
        View view;
        int panelModel;
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView;
        if (qFSShowPersonalPanelEvent == null) {
            return;
        }
        startInit();
        boolean z16 = true;
        if (qFSShowPersonalPanelEvent.getStFeed() != null && this.f89850e != null) {
            this.f89850e.vi(qFSShowPersonalPanelEvent.getStFeed(), true);
        }
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView2 = this.f89849d;
        if (qFSHalfScreenFloatingView2 != null && (qFSHalfScreenFloatingView2.getParent() instanceof View)) {
            view = (View) this.f89849d.getParent();
        } else {
            view = null;
        }
        if (view != null && view.getAlpha() < 1.0f) {
            view.setAlpha(1.0f);
        }
        if (qFSShowPersonalPanelEvent.getPanelModel() == 0) {
            panelModel = 1;
        } else {
            panelModel = qFSShowPersonalPanelEvent.getPanelModel();
        }
        if (panelModel != this.f89853i && (qFSHalfScreenFloatingView = this.f89849d) != null) {
            qFSHalfScreenFloatingView.L();
            this.f89853i = panelModel;
        } else {
            z16 = false;
        }
        if (this.f89849d != null) {
            if (qFSShowPersonalPanelEvent.isNeedMaskView()) {
                this.f89849d.U();
            } else {
                this.f89849d.r();
            }
        }
        ea(z16);
    }

    private void T9(QFSReleaseMiniFragmentEvent qFSReleaseMiniFragmentEvent) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_release_mini_when_switch_feed", false)) {
            return;
        }
        aa();
    }

    private void U9(@NonNull QFSShowPersonalPanelEvent qFSShowPersonalPanelEvent) {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        if (qFSShowPersonalPanelEvent.getHashCode() != getContext().hashCode()) {
            return;
        }
        String str = null;
        if (qFSShowPersonalPanelEvent.getStFeed() != null && qFSShowPersonalPanelEvent.getStFeed().poster != null) {
            feedCloudMeta$StUser = qFSShowPersonalPanelEvent.getStFeed().poster.get();
        } else {
            feedCloudMeta$StUser = null;
        }
        if (feedCloudMeta$StUser != null) {
            str = feedCloudMeta$StUser.f398463id.get();
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(getTAG(), 1, "[handleShowPersonalPanelEvent] uin is empty, return.");
            return;
        }
        this.f89854m = qFSShowPersonalPanelEvent.getFeedId();
        this.C = qFSShowPersonalPanelEvent.getStFeed();
        if (qFSShowPersonalPanelEvent.isShow()) {
            S9(qFSShowPersonalPanelEvent);
        } else {
            R9();
        }
    }

    private void V9(ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        if (aSEngineTabStatusEvent.getBusinessKey().equals(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_release_mini_when_exit_tab", true) && !aSEngineTabStatusEvent.isSelected()) {
            QLog.d("QFSPersonalPanelPart", 1, "receive onTab selected event");
            aa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W9(View view) {
        if (view == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.f485620b);
        this.D = imageView;
        imageView.setOnClickListener(this);
        this.E = (ImageView) view.findViewById(R.id.f486020f);
        this.F = (ImageView) view.findViewById(R.id.f485720c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X9() {
        if (this.f89850e == null) {
            QLog.e(getTAG(), 1, "[dispatchAdjustBottomHeightEvent] profile fragment is null");
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new QFSAdjustBottomHeightEvent(this.f89850e.hashCode()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y9() {
        this.f89849d.L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Z9() {
        if (this.G == 0) {
            return true;
        }
        return false;
    }

    private void aa() {
        R9();
        Fragment hostFragment = getHostFragment();
        if (hostFragment != null && hostFragment.isAdded() && this.f89850e != null) {
            hostFragment.getChildFragmentManager().beginTransaction().remove(this.f89850e).commitAllowingStateLoss();
            ba();
            this.f89850e = null;
        }
    }

    private void ba() {
        ImageView imageView = this.E;
        if (imageView != null) {
            imageView.setOnClickListener(null);
        }
        ImageView imageView2 = this.F;
        if (imageView2 != null) {
            imageView2.setOnClickListener(null);
        }
    }

    private void ea(boolean z16) {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f89849d;
        if (qFSHalfScreenFloatingView == null) {
            return;
        }
        qFSHalfScreenFloatingView.P(0);
        if (this.f89851f == 0 && this.f89849d.X() && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_adjust_personal_bottom_when_open_panel", true)) {
            M9();
        } else if (z16) {
            M9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga() {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.search.QFSPersonalPanelPart.4
            @Override // java.lang.Runnable
            public void run() {
                if (QFSPersonalPanelPart.this.f89850e == null) {
                    return;
                }
                QFSPersonalPanelPart.this.f89850e.registerDaTongReportPageId();
            }
        }, 200L);
    }

    private void handleTabStatusEvent(@NonNull ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        V9(aSEngineTabStatusEvent);
    }

    private void initHalfScreenView() {
        this.f89849d.q();
        this.f89849d.setIgnoreHorizontalMove(true);
        this.f89849d.setQUSDragFloatController(new a());
        this.f89849d.j(new b());
        this.f89849d.T(new c());
        if (this.f89849d.x() instanceof ViewGroup) {
            ((ViewGroup) this.f89849d.x()).setClipToPadding(false);
            ((ViewGroup) this.f89849d.x()).setClipChildren(false);
        }
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_mini_profile_adapt_navigation_bar", true)) {
            com.tencent.mobileqq.qui.b.f276860a.a(this.f89849d, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
        }
    }

    @Override // t40.e
    public ImageView A() {
        return this.E;
    }

    public void ca(int i3) {
        this.G = i3;
    }

    public void da(QUSBaseHalfScreenFloatingView.l lVar) {
        this.I = lVar;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSShowPersonalPanelEvent.class);
        arrayList.add(QCircleSelectTabEvent.class);
        arrayList.add(QCircleFeedEvent.class);
        arrayList.add(ASEngineTabStatusEvent.class);
        arrayList.add(QFSReleaseMiniFragmentEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        return R.id.f485920e;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalPanelPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f89849d;
        if (qFSHalfScreenFloatingView != null && qFSHalfScreenFloatingView.getVisibility() == 0) {
            R9();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && !fb0.a.a("QFSPersonalPanelPart_onClick") && view.getId() == R.id.f485620b) {
            R9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f89849d;
        if (qFSHalfScreenFloatingView == null) {
            return;
        }
        qFSHalfScreenFloatingView.L();
        this.f89851f = 0;
        this.f89852h = 0;
        this.f89849d.setTag(Boolean.valueOf(QCirclePanelStateEvent.isSpecifiedPanelShowing(29)));
        R9();
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.search.c
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalPanelPart.this.Y9();
            }
        }, this.f89849d.w());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        this.f89849d = (QFSHalfScreenFloatingView) view.findViewById(R.id.f4853209);
        initHalfScreenView();
        ((QCircleRoundCorneredRelativeLayout) this.f89849d.findViewById(R.id.f48171z_)).setRadius(cx.a(8.0f), cx.a(8.0f), 0.0f, 0.0f);
        this.f89850e = new QFSPanelProfileFragment(this);
        Fragment hostFragment = getHostFragment();
        if (hostFragment != null && hostFragment.isAdded()) {
            hostFragment.getChildFragmentManager().beginTransaction().replace(R.id.f4851207, this.f89850e).commitAllowingStateLoss();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.H = (int) getContext().getResources().getDimension(R.dimen.d0x);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSShowPersonalPanelEvent) {
            U9((QFSShowPersonalPanelEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleSelectTabEvent) {
            R9();
            return;
        }
        if (simpleBaseEvent instanceof QCircleFeedEvent) {
            Q9((QCircleFeedEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            handleTabStatusEvent((ASEngineTabStatusEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSReleaseMiniFragmentEvent) {
            T9((QFSReleaseMiniFragmentEvent) simpleBaseEvent);
        }
    }

    @Override // t40.e
    public ImageView t5() {
        return this.F;
    }
}
