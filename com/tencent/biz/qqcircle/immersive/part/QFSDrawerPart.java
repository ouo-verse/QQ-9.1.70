package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.broadcast.action.QCircleClearRedPointAction;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.events.QCircleLaunchFolderEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.hodor.QFSHodorCollectManager;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.events.QFSPersonalUserMedalRefreshEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSNoticeEntranceClickEvent;
import com.tencent.biz.qqcircle.immersive.part.QFSDrawerPart;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView;
import com.tencent.biz.qqcircle.widgets.QFSSafeDrawerLayout;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import trpcprotocol.feedcloud.sidebar.Bottom;
import trpcprotocol.feedcloud.sidebar.Drawer;
import trpcprotocol.feedcloud.sidebar.Header;
import trpcprotocol.feedcloud.sidebar.RedInfo;
import trpcprotocol.feedcloud.sidebar.RedType;

/* loaded from: classes4.dex */
public class QFSDrawerPart extends u implements SimpleEventReceiver, View.OnClickListener {
    private static final ArrayList<String> J;
    private com.tencent.biz.qqcircle.drawer.c C;
    private View D;
    private View E;
    private FrameLayout F;
    private LinearLayout G;
    private com.tencent.biz.qqcircle.drawer.j H;
    private boolean I = false;

    /* renamed from: d, reason: collision with root package name */
    private View f87350d;

    /* renamed from: e, reason: collision with root package name */
    private QFSSafeDrawerLayout f87351e;

    /* renamed from: f, reason: collision with root package name */
    private View f87352f;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup f87353h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView f87354i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.qqcircle.drawer.e f87355m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QFSDrawerPart.this.H != null) {
                QFSDrawerPart.this.H.T1(null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        J = arrayList;
        arrayList.add("https://m.xsj.qq.com/h5/qqzz/task-detail?_wwv=8704&_wv=16777217&_noMask=1&_bid=5104");
        arrayList.add("https://m.xsj.qq.com/h5/data-center-v2/analysis?_wwv=8704&_wv=16777217&_noMask=1&from_wecom=1&_bid=5104");
        arrayList.add("https://m.xsj.qq.com/h5/create-inspiration/home?_wv=3&_wwv=8193&xsj_h5_page_source=feed_info&_bid=4743");
        arrayList.add("https://m.xsj.qq.com/h5/personal/my-comments?_wv=3&_bid=5104");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J9(List<Bottom> list) {
        LinearLayout linearLayout = this.G;
        if (linearLayout == null) {
            return;
        }
        linearLayout.removeAllViews();
        if (RFSafeListUtils.isEmpty(list)) {
            this.G.setVisibility(8);
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            Bottom bottom = list.get(i3);
            View L9 = L9(bottom);
            this.G.addView(L9, new ViewGroup.LayoutParams(-2, -2));
            if (i3 != list.size() - 1) {
                this.G.addView(M9());
            }
            ca(L9, bottom.text);
        }
        this.G.setVisibility(0);
    }

    private void K9() {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSDrawerPart.3
            @Override // java.lang.Runnable
            public void run() {
                if (QFSDrawerPart.this.f87351e != null && QFSDrawerPart.this.f87353h != null) {
                    QLog.d(QFSDrawerPart.this.getTAG(), 1, "[closeDrawer]");
                    QFSDrawerPart.this.f87351e.closeDrawer(QFSDrawerPart.this.f87353h);
                    QFSDrawerPart.this.la();
                    return;
                }
                QLog.e(QFSDrawerPart.this.getTAG(), 1, "[closeDrawer] fail, view is null");
            }
        });
    }

    private View L9(Bottom bottom) {
        String str = bottom.text;
        final String str2 = bottom.schema;
        TextView textView = new TextView(getContext());
        textView.setTextSize(1, 13.0f);
        textView.setText(str);
        int a16 = com.tencent.biz.qqcircle.utils.cx.a(24.0f);
        textView.setPadding(a16, 0, a16, 0);
        textView.setTextColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_secondary));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.bb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSDrawerPart.this.Y9(str2, view);
            }
        });
        return textView;
    }

    private View M9() {
        View view = new View(getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(com.tencent.biz.qqcircle.utils.cx.a(1.0f), com.tencent.biz.qqcircle.utils.cx.a(12.0f)));
        view.setBackground(new ColorDrawable(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_border_standard)));
        return view;
    }

    private com.tencent.biz.qqcircle.drawer.h N9() {
        com.tencent.biz.qqcircle.drawer.e eVar = this.f87355m;
        if (eVar != null) {
            return eVar.i0();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O9() {
        if (this.f87351e == null) {
            QLog.e(getTAG(), 1, "[handleDrawerClosed] mDrawerLayout is null");
            return;
        }
        QLog.d(getTAG(), 1, "[handleDrawerClosed]");
        QCircleClearRedPointAction.d();
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(27, "", false, getContext()));
        if (X9()) {
            com.tencent.biz.qqcircle.immersive.utils.ax.j(getContext(), true, false, 100);
        }
        this.f87351e.setVisibility(8);
        ma();
        la();
        qa(false);
    }

    private void P9(ArrayList<com.tencent.biz.qqcircle.drawer.f> arrayList, Drawer drawer) {
        RedInfo redInfo;
        if (uq3.o.Y1("qcircle_disable_drawer_find_friend", false)) {
            QLog.d("QFSDrawerPart", 1, "should not show find friend entry unitedConfigTurnOff");
            return;
        }
        if (!uq3.k.a().c(QCircleCommonUtil.getCurrentAccount() + "_sp_key_drawer_find_friend_clicked", false)) {
            redInfo = new RedInfo(RedType.RED_TYPE_SMALL, 1, "");
        } else {
            redInfo = new RedInfo(RedType.RED_TYPE_NONE, 1, "");
        }
        arrayList.add(new com.tencent.biz.qqcircle.drawer.f(new Drawer(drawer.f437281id, drawer.type, drawer.title, drawer.subTitle, drawer.icon, redInfo, drawer.jumpInfo, drawer.navbar, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q9(UIStateData<Header> uIStateData) {
        int state = uIStateData.getState();
        if (state == 2 || state == 3) {
            if (uIStateData.getData() != null && uIStateData.getData().medalWall != null) {
                this.C.k0(new com.tencent.biz.qqcircle.drawer.d(uIStateData.getData(), QCirclePluginGlobalInfo.m()));
            } else {
                QLog.d("QFSDrawerPart", 1, "[handleGetHeaderResponse] header data is null. ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R9(UIStateData<List<Drawer>> uIStateData) {
        if (uIStateData == null) {
            QLog.e(getTAG(), 1, "[handleGetSideBarResponse] error, listUIStateData is null");
            return;
        }
        int state = uIStateData.getState();
        QLog.d(getTAG(), 1, "[handleGetSidebarResponse] state:" + state);
        if (state != 0) {
            if (state != 1) {
                if (state != 2 && state != 3) {
                    if (state != 4) {
                        return;
                    }
                } else {
                    ja();
                    S9(uIStateData);
                    return;
                }
            } else if (Z9()) {
                ja();
                return;
            } else {
                showLoadingView();
                return;
            }
        }
        if (Z9()) {
            ja();
        } else {
            ia();
        }
    }

    private void S9(UIStateData<List<Drawer>> uIStateData) {
        List<Drawer> data = uIStateData.getData();
        if (data == null) {
            QLog.e(getTAG(), 1, "[handleGetSidebarSuccess] drawers is null");
            return;
        }
        ArrayList<com.tencent.biz.qqcircle.drawer.f> arrayList = new ArrayList<>();
        for (Drawer drawer : data) {
            if (drawer != null) {
                if (drawer.f437281id == 14) {
                    P9(arrayList, drawer);
                } else {
                    arrayList.add(new com.tencent.biz.qqcircle.drawer.f(drawer));
                }
            }
        }
        QLog.d(getTAG(), 1, "[handleGetSidebarSuccess] drawers.size:" + data.size() + ", drawerInfo.size:" + arrayList.size());
        this.f87355m.setItems(arrayList);
    }

    private void T9(QCircleLaunchFolderEvent qCircleLaunchFolderEvent) {
        if (qCircleLaunchFolderEvent == null) {
            return;
        }
        boolean X9 = X9();
        QLog.d(getTAG(), 1, "[handleLaunchFolderEvent] receive launch folder event, curIsTabPage:" + X9 + ", event is jump tab page:" + qCircleLaunchFolderEvent.isJumpTabPage());
        if (X9 == qCircleLaunchFolderEvent.isJumpTabPage()) {
            K9();
        }
    }

    private void U9() {
        if (!W9()) {
            QLog.d("QFSDrawerPart", 1, "[handleMedalRefreshEvent] drawer is not open. ");
            return;
        }
        com.tencent.biz.qqcircle.drawer.j jVar = this.H;
        if (jVar != null) {
            jVar.T1(null);
        }
    }

    private void V9(QFSNoticeEntranceClickEvent qFSNoticeEntranceClickEvent) {
        ViewStub viewStub = (ViewStub) this.f87350d.findViewById(R.id.f369515y);
        if (viewStub != null && this.f87351e == null) {
            boolean ra5 = ra();
            QLog.d(getTAG(), 1, "[inflateView] useSimplifiedLoadingView:" + ra5);
            QFSSafeDrawerLayout qFSSafeDrawerLayout = (QFSSafeDrawerLayout) viewStub.inflate();
            this.f87351e = qFSSafeDrawerLayout;
            LinearLayout linearLayout = (LinearLayout) qFSSafeDrawerLayout.findViewById(R.id.f3669159);
            this.G = linearLayout;
            com.tencent.mobileqq.qui.b.f276860a.a(linearLayout, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
            ViewGroup viewGroup = (ViewGroup) this.f87351e.findViewById(R.id.f3663153);
            this.f87353h = viewGroup;
            viewGroup.setOnClickListener(this);
            View findViewById = this.f87351e.findViewById(R.id.f367415d);
            this.f87352f = findViewById;
            findViewById.setOnClickListener(this);
            this.D = this.f87351e.findViewById(R.id.f367015_);
            if (ra5) {
                this.E = new QCirclePanelLoadingView(this.f87353h.getContext());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                ((QCirclePanelLoadingView) this.E).k0();
                this.f87353h.addView(this.E, layoutParams);
            } else {
                ViewStub viewStub2 = (ViewStub) this.f87350d.findViewById(R.id.f367315c);
                if (viewStub2 != null) {
                    this.E = viewStub2.inflate();
                }
            }
            this.f87351e.addDrawerListener(new a());
            RecyclerView recyclerView = (RecyclerView) this.f87351e.findViewById(R.id.f368815r);
            this.f87354i = recyclerView;
            recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext()));
            this.f87354i.setItemAnimator(null);
            this.f87355m = new com.tencent.biz.qqcircle.drawer.e();
            this.C = new com.tencent.biz.qqcircle.drawer.c();
            this.f87354i.setAdapter(new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.C, this.f87355m}));
            pa();
            FrameLayout frameLayout = (FrameLayout) this.f87351e.findViewById(R.id.f369415x);
            this.F = frameLayout;
            frameLayout.addView(new QUIEmptyState.Builder(getContext()).setImageType(5).setDesc(com.tencent.biz.qqcircle.utils.h.a(R.string.f1920246d)).setButton(com.tencent.biz.qqcircle.utils.h.a(R.string.f189333z4), new b()).setHalfScreenState(true).setBackgroundColorType(0).build());
            ga(qFSNoticeEntranceClickEvent);
            da();
        }
    }

    private boolean X9() {
        return QCirclePluginUtil.isInLocalActivity(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y9(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!FastClickUtils.isFastDoubleClick("bottomItemFastClk", 500L)) {
            if (TextUtils.isEmpty(str)) {
                QLog.e("QFSDrawerPart", 1, "schema is null");
            } else {
                com.tencent.biz.qqcircle.launcher.c.j(getContext(), str, true);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private boolean Z9() {
        com.tencent.biz.qqcircle.drawer.e eVar = this.f87355m;
        if (eVar != null && eVar.getItemCount() > 0) {
            return true;
        }
        return false;
    }

    private void aa(QFSNoticeEntranceClickEvent qFSNoticeEntranceClickEvent) {
        int activityHashCode = getActivityHashCode();
        if (activityHashCode != 0 && activityHashCode == qFSNoticeEntranceClickEvent.getActivityHashCode()) {
            V9(qFSNoticeEntranceClickEvent);
            QFSSafeDrawerLayout qFSSafeDrawerLayout = this.f87351e;
            if (qFSSafeDrawerLayout != null && this.f87353h != null) {
                qFSSafeDrawerLayout.setVisibility(0);
                QLog.d(getTAG(), 1, "[openDrawer]");
                com.tencent.biz.qqcircle.drawer.j jVar = this.H;
                if (jVar != null) {
                    jVar.T1(qFSNoticeEntranceClickEvent.getStCommonExt());
                }
                QCircleClearRedPointAction.d();
                SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(27, "", true, getContext()));
                if (X9()) {
                    com.tencent.biz.qqcircle.immersive.utils.ax.j(getContext(), false, false, 100);
                }
                qa(true);
                this.f87351e.openDrawer(this.f87353h);
                ba();
                ma();
                QFSHodorCollectManager.f84689a.b("qfs_drawer_begin_business");
                return;
            }
            QLog.e(getTAG(), 1, "[openDrawer] view is null, not initView");
            return;
        }
        QLog.e(getTAG(), 1, "[openDrawer] activity hashCode is not equal, curHashCode:" + activityHashCode + ", eventHashCode:" + qFSNoticeEntranceClickEvent.getActivityHashCode());
    }

    private void ba() {
        if (this.I) {
            return;
        }
        this.I = true;
        QLog.d(getTAG(), 1, "[preloadWebView]");
        Iterator<String> it = J.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!((IQQWinkLaucher) QRoute.api(IQQWinkLaucher.class)).preloadWebView(next, true)) {
                QLog.e(getTAG(), 1, "[preloadWebView] error, preloadUrl:" + next);
            }
        }
    }

    private void ca(@NonNull View view, String str) {
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_MSG_DRAWER_BOTTOM_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_item_name", str);
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private void da() {
        VideoReport.setElementId(this.f87351e, QCircleDaTongConstant.ElementId.EM_XSJ_MSG_DRAWER_MODULE);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        VideoReport.setElementExposePolicy(this.f87351e, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this.f87351e, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.f87351e, ClickPolicy.REPORT_NONE);
        VideoReport.setElementParams(this.f87351e, buildElementParams);
    }

    private void ea() {
        com.tencent.biz.qqcircle.drawer.h N9 = N9();
        if (N9 != null) {
            N9.g(0);
        }
    }

    private void ga(QFSNoticeEntranceClickEvent qFSNoticeEntranceClickEvent) {
        View view;
        if (this.f87351e == null) {
            QLog.e(getTAG(), 1, "[setDrawerLayoutLogicParent] mDrawerLayout is null");
            return;
        }
        if (qFSNoticeEntranceClickEvent != null) {
            view = qFSNoticeEntranceClickEvent.getClickView();
        } else {
            view = null;
        }
        if (view == null) {
            QLog.e(getTAG(), 1, "[setDrawerLayoutLogicParent] clickView is null");
        } else {
            VideoReport.setLogicParent(this.f87351e, view);
        }
    }

    private void ha(boolean z16) {
        int i3;
        View view = this.E;
        if (view == null) {
            return;
        }
        if (view instanceof QCirclePanelLoadingView) {
            if (z16) {
                ((QCirclePanelLoadingView) view).n0();
                return;
            } else {
                ((QCirclePanelLoadingView) view).k0();
                return;
            }
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    private void ia() {
        if (this.F != null && this.D != null) {
            ha(false);
            this.F.setVisibility(0);
            this.D.setVisibility(8);
        }
    }

    private void initViewModel() {
        QFSBaseFragment hostFragment = getHostFragment();
        if (hostFragment == null) {
            QLog.e(getTAG(), 1, "[initViewModel] error, fragment is null");
            return;
        }
        QLog.d(getTAG(), 1, "[initViewModel] fragment.hashCode:" + hostFragment.hashCode());
        com.tencent.biz.qqcircle.drawer.j jVar = (com.tencent.biz.qqcircle.drawer.j) getHostFragment().getViewModel(com.tencent.biz.qqcircle.drawer.j.class);
        this.H = jVar;
        jVar.P1().observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.ay
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSDrawerPart.this.R9((UIStateData) obj);
            }
        });
        this.H.Q1().observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.az
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSDrawerPart.this.Q9((UIStateData) obj);
            }
        });
        this.H.O1().observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.ba
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSDrawerPart.this.J9((List) obj);
            }
        });
    }

    private void ja() {
        if (this.F != null && this.D != null) {
            ha(false);
            this.F.setVisibility(8);
            this.D.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la() {
        com.tencent.biz.qqcircle.drawer.h N9 = N9();
        if (N9 != null) {
            N9.f();
        }
    }

    private void ma() {
        VideoReport.traversePage(this.f87351e);
    }

    private void na() {
        ViewGroup viewGroup;
        QFSSafeDrawerLayout qFSSafeDrawerLayout = this.f87351e;
        if (qFSSafeDrawerLayout == null) {
            QLog.e(getTAG(), 1, "[triggerDrawerLayoutDetachAndAttach] drawer layout is null");
            return;
        }
        if (qFSSafeDrawerLayout.getParent() instanceof ViewGroup) {
            viewGroup = (ViewGroup) this.f87351e.getParent();
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            QLog.e(getTAG(), 1, "[triggerDrawerLayoutDetachAndAttach] drawer parent is null");
            return;
        }
        int indexOfChild = viewGroup.indexOfChild(this.f87351e);
        viewGroup.removeView(this.f87351e);
        viewGroup.addView(this.f87351e, indexOfChild);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa() {
        if (this.f87350d == null) {
            QLog.e(getTAG(), 1, "[updateColorWhenResume] mRootView is null");
            return;
        }
        if (!W9()) {
            QLog.d(getTAG(), 1, "[updateColorWhenResume] drawer is not opened");
            return;
        }
        Context hostContext = ASEngineUtils.getHostContext(getContext());
        if (hostContext instanceof Activity) {
            Window window = ((Activity) hostContext).getWindow();
            View view = this.f87350d;
            QUIImmersiveHelper.t(window, true, view, true, view);
        }
    }

    private void pa() {
        ViewGroup viewGroup = this.f87353h;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setPadding(viewGroup.getPaddingLeft(), DisplayUtil.getTopHeight(getContext()) + com.tencent.biz.qqcircle.utils.cx.a(8.0f), this.f87353h.getPaddingRight(), this.f87353h.getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa(boolean z16) {
        Context hostContext = ASEngineUtils.getHostContext(getContext());
        if (hostContext instanceof Activity) {
            if (z16) {
                Window window = ((Activity) hostContext).getWindow();
                ViewGroup viewGroup = this.f87353h;
                QUIImmersiveHelper.t(window, true, viewGroup, false, viewGroup);
                return;
            }
            QUIImmersiveHelper.u(((Activity) hostContext).getWindow(), true, true);
        }
    }

    private boolean ra() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_drawer_simplified_loading_view", false) || QCircleDeviceInfoUtils.getQQPerfDeviceLevel() == 1) {
            return false;
        }
        return true;
    }

    private void showLoadingView() {
        if (this.F != null && this.D != null) {
            ha(true);
            this.F.setVisibility(8);
            this.D.setVisibility(8);
        }
    }

    public boolean W9() {
        ViewGroup viewGroup;
        QFSSafeDrawerLayout qFSSafeDrawerLayout = this.f87351e;
        if (qFSSafeDrawerLayout != null && (viewGroup = this.f87353h) != null) {
            return qFSSafeDrawerLayout.isDrawerOpen(viewGroup);
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSNoticeEntranceClickEvent.class);
        arrayList.add(QCircleLaunchFolderEvent.class);
        arrayList.add(ASEngineTabStatusEvent.class);
        arrayList.add(QCircleConfigChangeEvent.class);
        arrayList.add(QFSPersonalUserMedalRefreshEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSDrawerPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return com.tencent.biz.qqcircle.drawer.i.c();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        boolean W9 = W9();
        QLog.d(getTAG(), 1, "[onBackEvent] isDrawerOpened:" + W9);
        if (W9) {
            K9();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewGroup viewGroup;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == null) {
            QLog.e(getTAG(), 1, "[onClick] click view is null");
        } else if (view.getId() == R.id.f367415d) {
            boolean W9 = W9();
            QLog.d(getTAG(), 1, "[onClick] click mask view, isDrawerOpened:" + W9);
            if (W9 && ((viewGroup = this.f87353h) == null || viewGroup.getVisibility() == 8)) {
                K9();
            } else {
                QLog.d(getTAG(), 1, "[onClick] close fail or drawer root is visible, but drawer content is not visible");
                O9();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f87350d = view;
        QLog.d(getTAG(), 1, "[onInitView] hashCode:" + hashCode());
        initViewModel();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        la();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        ea();
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.ax
            @Override // java.lang.Runnable
            public final void run() {
                QFSDrawerPart.this.oa();
            }
        }, 50L);
        if (W9() && X9()) {
            com.tencent.biz.qqcircle.immersive.utils.ax.j(getContext(), false, false, 100);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSNoticeEntranceClickEvent) {
            aa((QFSNoticeEntranceClickEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleLaunchFolderEvent) {
            T9((QCircleLaunchFolderEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            if (!((ASEngineTabStatusEvent) simpleBaseEvent).isSelected()) {
                QLog.d(getTAG(), 1, "[onReceiveEvent] receive tab status event, not selected");
                K9();
                return;
            }
            return;
        }
        if ((simpleBaseEvent instanceof QCircleConfigChangeEvent) && com.tencent.biz.qqcircle.utils.bz.r()) {
            QLog.d(getTAG(), 1, "[onReceiveEvent] config change event, and is pad or fold");
            na();
        } else if (simpleBaseEvent instanceof QFSPersonalUserMedalRefreshEvent) {
            U9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements DrawerLayout.DrawerListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            QFSDrawerPart.this.qa(true);
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerClosed(@NonNull View view) {
            QLog.d(QFSDrawerPart.this.getTAG(), 1, "[onDrawerClosed]");
            QFSDrawerPart.this.O9();
            QFSHodorCollectManager.f84689a.b("qfs_drawer_end_business");
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerOpened(@NonNull View view) {
            QLog.d(QFSDrawerPart.this.getTAG(), 1, "[onDrawerOpened]");
            view.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.bc
                @Override // java.lang.Runnable
                public final void run() {
                    QFSDrawerPart.a.this.b();
                }
            });
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerStateChanged(int i3) {
            QLog.d(QFSDrawerPart.this.getTAG(), 1, "[onDrawerStateChanged] newState:" + i3);
            if (i3 == 0 && !QFSDrawerPart.this.W9()) {
                QFSDrawerPart.this.O9();
            }
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerSlide(@NonNull View view, float f16) {
        }
    }
}
