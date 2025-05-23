package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSAdjustBottomHeightEvent;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSSetViewPagerOrientationEvent;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSUserResetEvent;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.immersive.personal.model.QFSPersonalTabIndexManager;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.theme.SkinnableView;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSPersonalBottomWidget extends QCircleBaseWidgetView implements LifecycleOwner, n60.a, SimpleEventReceiver, SkinnableView {
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.e C;
    private ViewPager2 D;
    private com.tencent.biz.qqcircle.immersive.personal.adapter.i E;
    private LinearLayout F;
    private View G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private final ViewGroup M;
    private int N;
    private RFWNavigationBarImmersiveHelper.NavigationBarHeightChangeCallback P;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<n60.b> f89206d;

    /* renamed from: e, reason: collision with root package name */
    private int f89207e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.r f89208f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.t f89209h;

    /* renamed from: i, reason: collision with root package name */
    private final QFSPersonalDetailsFragment f89210i;

    /* renamed from: m, reason: collision with root package name */
    private final LifecycleRegistry f89211m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Observer<QFSPersonalInfo> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QFSPersonalInfo qFSPersonalInfo) {
            QFSPersonalBottomWidget.this.C.T1(QFSPersonalBottomWidget.this.f89208f.L2());
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
            QFSPersonalBottomWidget.this.P0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends v.a {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public List<String> a() {
            return Arrays.asList("update_version_op_mask", "key_version_extend_base_info");
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        @SuppressLint({"SetTextI18n"})
        public void d(@NonNull w wVar) {
            QFSPersonalBottomWidget.this.Q0(wVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d extends ViewPager2.OnPageChangeCallback {
        d() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            if (QFSPersonalBottomWidget.this.f89208f == null) {
                return;
            }
            if (i3 == QFSPersonalBottomWidget.this.H) {
                QFSPersonalBottomWidget.this.f89208f.j3("qfs_personal_tab_product");
            } else if (i3 == QFSPersonalBottomWidget.this.L) {
                QFSPersonalBottomWidget.this.f89208f.j3("qfs_personal_tab_private_prods");
            } else if (i3 == QFSPersonalBottomWidget.this.J) {
                QFSPersonalBottomWidget.this.f89208f.j3("qfs_personal_tab_pushed");
            } else if (i3 == QFSPersonalBottomWidget.this.I) {
                QFSPersonalBottomWidget.this.f89208f.j3("qfs_personal_tab_praised");
            } else if (i3 == QFSPersonalBottomWidget.this.K) {
                QFSPersonalBottomWidget.this.f89208f.j3("qfs_personal_tab_collect");
            }
            QFSPersonalBottomWidget.this.P0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e extends ViewPager2.OnPageChangeCallback {
        e() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i3) {
            super.onPageScrollStateChanged(i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            boolean z16;
            if (QFSPersonalBottomWidget.this.C != null) {
                com.tencent.biz.qqcircle.immersive.personal.viewmodel.e eVar = QFSPersonalBottomWidget.this.C;
                if (i3 == QFSPersonalBottomWidget.this.H) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                eVar.S1(z16);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSPersonalBottomWidget> f89217a;

        public f(QFSPersonalBottomWidget qFSPersonalBottomWidget) {
            this.f89217a = new WeakReference<>(qFSPersonalBottomWidget);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            String str2;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            QFSPersonalBottomWidget qFSPersonalBottomWidget = this.f89217a.get();
            if (qFSPersonalBottomWidget != null && qFSPersonalBottomWidget.f89208f != null && qFSPersonalBottomWidget.f89208f.p2().getValue() != null) {
                if (qFSPersonalBottomWidget.f89208f.p2().getValue().intValue() == 20101) {
                    str2 = "time";
                } else {
                    str2 = "like";
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRODUCT_ORDER_BUTTON, str2);
            }
            return buildElementParams;
        }
    }

    public QFSPersonalBottomWidget(@NonNull Context context, QFSPersonalDetailsFragment qFSPersonalDetailsFragment, @NonNull ViewGroup viewGroup, QCircleReportBean qCircleReportBean) {
        super(context);
        this.H = 0;
        this.I = 1;
        this.J = 2;
        this.K = 3;
        this.L = -1;
        this.N = 0;
        this.P = new RFWNavigationBarImmersiveHelper.NavigationBarHeightChangeCallback() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.g
            @Override // com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper.NavigationBarHeightChangeCallback
            public final void onChange(int i3, int i16, int i17) {
                QFSPersonalBottomWidget.this.N0(i3, i16, i17);
            }
        };
        this.f89210i = qFSPersonalDetailsFragment;
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.f89211m = lifecycleRegistry;
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        this.D = (ViewPager2) findViewById(R.id.f57372n5);
        this.M = viewGroup;
        setReportBean(qCircleReportBean);
        com.tencent.mobileqq.qui.b.f276860a.k(getContext(), getFragment(), this.P);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_personal_bottom_delay_get_height_9090", true)) {
            y0(false);
        } else if (K0()) {
            z0(viewGroup.getHeight() - ImmersiveUtils.dpToPx(5.0f));
        } else {
            x0((int) ((viewGroup.getHeight() - getContext().getResources().getDimension(R.dimen.f159414d43)) - ImmersiveUtils.getStatusBarHeight(getContext())));
        }
        F0(this);
        J0();
        G0();
        H0();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void A0(int i3) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, i3);
        } else {
            layoutParams.height = i3;
        }
        setLayoutParams(layoutParams);
    }

    private int B0(@NonNull QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean.getSchemeAttrs() == null || !qCircleInitBean.getSchemeAttrs().containsKey(QCircleSchemeAttr.MainPage.SELECT_TAB_INDEX)) {
            return -1;
        }
        try {
            String str = qCircleInitBean.getSchemeAttrs().get(QCircleSchemeAttr.MainPage.SELECT_TAB_INDEX);
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (Exception e16) {
            QLog.e("FSPersonalBottomWidget", 1, "getSelectTabIndex parse num error:" + e16.getMessage());
            return -1;
        }
    }

    private void C0(@NonNull QFSAdjustBottomHeightEvent qFSAdjustBottomHeightEvent) {
        QFSPersonalDetailsFragment qFSPersonalDetailsFragment;
        if (this.M != null && (qFSPersonalDetailsFragment = this.f89210i) != null && qFSPersonalDetailsFragment.hashCode() == qFSAdjustBottomHeightEvent.getHashCode()) {
            this.M.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.f
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPersonalBottomWidget.this.M0();
                }
            });
        }
    }

    private void D0(QFSUserResetEvent qFSUserResetEvent) {
        if (this.E != null && this.f89210i != null && qFSUserResetEvent.getUnique() == this.f89210i.hashCode()) {
            this.E = null;
            this.D.setAdapter(null);
        }
    }

    private void E0(@NonNull QFSSetViewPagerOrientationEvent qFSSetViewPagerOrientationEvent) {
        ViewPager2 viewPager2;
        QFSPersonalDetailsFragment qFSPersonalDetailsFragment = this.f89210i;
        if (qFSPersonalDetailsFragment != null && qFSPersonalDetailsFragment.hashCode() == qFSSetViewPagerOrientationEvent.getHashCode() && (viewPager2 = this.D) != null) {
            viewPager2.setOrientation(qFSSetViewPagerOrientationEvent.getOrientation());
        }
    }

    private void F0(View view) {
        this.F = (LinearLayout) view.findViewById(R.id.f46251u3);
        this.G = view.findViewById(R.id.f1186974u);
        O0();
        VideoReport.setElementId(this.F, QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT_ORDER_BUTTON);
        VideoReport.setEventDynamicParams(this.F, new f(this));
    }

    private void G0() {
        LifecycleOwner lifecycleOwner;
        this.f89208f = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(this.f89210i, com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        this.C = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.e) getViewModel(this.f89210i, com.tencent.biz.qqcircle.immersive.personal.viewmodel.e.class);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_personal_use_fragment_lifecycle", true)) {
            lifecycleOwner = this.f89210i;
        } else {
            lifecycleOwner = this;
        }
        this.f89208f.g2().observe(lifecycleOwner, new a());
        this.f89208f.o2().observe(lifecycleOwner, new b());
        Iterator<n60.b> it = this.f89206d.iterator();
        while (it.hasNext()) {
            it.next().j(this.f89210i);
        }
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.t) getViewModel(this.f89210i, com.tencent.biz.qqcircle.immersive.personal.viewmodel.t.class);
        this.f89209h = tVar;
        tVar.O1().c(this.f89210i, new c());
    }

    private void H0() {
        this.D.registerOnPageChangeCallback(new d());
        this.D.registerOnPageChangeCallback(new e());
    }

    private void I0() {
        QCircleInitBean qCircleInitBean;
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.f89208f;
        if (rVar != null && rVar.L2()) {
            QFSPersonalDetailsFragment qFSPersonalDetailsFragment = this.f89210i;
            if (qFSPersonalDetailsFragment != null) {
                qCircleInitBean = qFSPersonalDetailsFragment.getQCircleInitBean();
            } else {
                qCircleInitBean = null;
            }
            if (qCircleInitBean == null) {
                return;
            }
            int i3 = qCircleInitBean.getExtraTypeInfo().sourceType;
            int B0 = B0(qCircleInitBean);
            if (QFSPersonalTabIndexManager.f88726a.h() && this.L != -1 && B0 > 0) {
                RFWLog.i("FSPersonalBottomWidget", RFWLog.USR, "[initViewPagerPos] -> need update tab index, original selectIndex = " + B0);
                B0++;
            }
            RFWLog.i("FSPersonalBottomWidget", RFWLog.DEV, "[initViewPagerPos] -> sourceType = " + i3 + ", selectIndex = " + B0);
            if (i3 != 20109 && i3 != 20108 && B0 != this.K) {
                int i16 = this.H;
                if (B0 == i16) {
                    this.D.setCurrentItem(i16, false);
                    return;
                }
                int i17 = this.L;
                if (i17 != -1 && B0 == i17) {
                    this.D.setCurrentItem(i17, false);
                    return;
                }
                int i18 = this.I;
                if (B0 == i18) {
                    this.D.setCurrentItem(i18, false);
                    return;
                }
                int i19 = this.J;
                if (B0 == i19) {
                    this.D.setCurrentItem(i19, false);
                    return;
                }
                return;
            }
            this.D.setCurrentItem(this.K, false);
        }
    }

    private void J0() {
        ArrayList<n60.b> arrayList = new ArrayList<>();
        this.f89206d = arrayList;
        arrayList.add(new n60.r(this));
        Iterator<n60.b> it = this.f89206d.iterator();
        while (it.hasNext()) {
            it.next().o();
        }
    }

    private boolean K0() {
        QFSPersonalDetailsFragment qFSPersonalDetailsFragment = this.f89210i;
        if (qFSPersonalDetailsFragment != null && qFSPersonalDetailsFragment.Zh()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(boolean z16) {
        int height = this.M.getHeight();
        int dimension = (int) ((height - getContext().getResources().getDimension(R.dimen.f159414d43)) - ImmersiveUtils.getStatusBarHeight(getContext()));
        QLog.d("FSPersonalBottomWidget", 1, "[adjustHeight] viewGroupHeight:", Integer.valueOf(height), " ,configChange:", Boolean.valueOf(z16));
        if (K0()) {
            if (z16 && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_adjust_personal_bottom_height_in_phone", false) && !bz.r()) {
                QLog.d("FSPersonalBottomWidget", 1, "adjustMiniBottomWidgetHeight: return");
                return;
            } else {
                z0(height - ImmersiveUtils.dpToPx(5.0f));
                return;
            }
        }
        x0(dimension);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0() {
        int height = this.M.getHeight();
        QLog.d("FSPersonalBottomWidget", 1, "[adjustHeightIfConfigChangeNew] viewGroupHeight:", Integer.valueOf(height));
        z0(height - ImmersiveUtils.dpToPx(5.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(int i3, int i16, int i17) {
        this.N = i3;
        y0(false);
    }

    private void O0() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setColors(new int[]{getContext().getResources().getColor(R.color.ajr), QFSQUIUtilsKt.d(getContext(), R.color.qui_common_bg_bottom_light)});
        this.G.setBackground(gradientDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar;
        ViewPager2 viewPager2;
        if (this.F == null) {
            return;
        }
        if (com.tencent.biz.qqcircle.manager.i.a("qfs_personal_entrance_show") && (rVar = this.f89208f) != null && rVar.o2().getValue() != null && this.f89208f.o2().getValue().getData() != null && TextUtils.equals(this.f89208f.t2(), "qfs_personal_tab_product") && this.f89208f.o2().getValue().getData().size() > 1 && (viewPager2 = this.D) != null && viewPager2.getCurrentItem() == 0) {
            this.F.setVisibility(8);
        } else {
            this.F.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(w wVar) {
        if (!wVar.x() && this.E == null) {
            int i3 = 0;
            if (!com.tencent.biz.qqcircle.manager.i.a("qfs_personal_entrance_show")) {
                if (wVar.z()) {
                    this.H = -1;
                    this.J = -1;
                    this.I = 0;
                    this.K = 1;
                } else {
                    this.H = 0;
                    this.J = -1;
                    this.I = -1;
                    this.K = -1;
                }
            } else if (wVar.z()) {
                QFSPersonalTabIndexManager qFSPersonalTabIndexManager = QFSPersonalTabIndexManager.f88726a;
                if (qFSPersonalTabIndexManager.h()) {
                    QLog.d("FSPersonalBottomWidget", 1, "owner state hit exp show private_prods tab.");
                    this.H = 0;
                    this.L = qFSPersonalTabIndexManager.e();
                    this.I = qFSPersonalTabIndexManager.d();
                    this.J = qFSPersonalTabIndexManager.f();
                    this.K = qFSPersonalTabIndexManager.b();
                } else {
                    this.H = 0;
                    this.I = 1;
                    this.J = 2;
                    this.K = 3;
                }
            } else {
                boolean u16 = wVar.u(6);
                boolean u17 = wVar.u(8);
                boolean u18 = wVar.u(19);
                if (!u16) {
                    this.I = 1;
                    i3 = 1;
                }
                if (!u17) {
                    i3++;
                    this.J = i3;
                }
                if (!u18) {
                    i3++;
                    this.K = i3;
                }
                if (u16) {
                    i3++;
                    this.I = i3;
                }
                if (u17) {
                    i3++;
                    this.J = i3;
                }
                if (u18) {
                    this.K = i3 + 1;
                }
            }
            com.tencent.biz.qqcircle.immersive.personal.adapter.i iVar = new com.tencent.biz.qqcircle.immersive.personal.adapter.i(this.f89210i);
            this.E = iVar;
            iVar.i0(this.H, this.L, this.J, this.I, this.K);
            this.D.setAdapter(this.E);
            I0();
        }
    }

    private void x0(int i3) {
        QLog.d("FSPersonalBottomWidget", 1, "[adjustBottomWidgetHeight] h: " + i3 + ", mNavigationHeight: " + this.N);
        int i16 = i3 - this.N;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, i16);
        } else {
            layoutParams.height = i16;
        }
        this.f89207e = i16;
        setLayoutParams(layoutParams);
    }

    private void z0(int i3) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_mini_profile_adapt_navigation_bar", true)) {
            x0(i3);
        } else {
            A0(i3);
        }
    }

    @Override // n60.a
    public int F() {
        return getPageId();
    }

    @Override // n60.a
    public int K() {
        return getParentPageId();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSUserResetEvent.class);
        arrayList.add(QFSSetViewPagerOrientationEvent.class);
        arrayList.add(QFSAdjustBottomHeightEvent.class);
        return arrayList;
    }

    @Override // n60.a
    public BasePartFragment getFragment() {
        return this.f89210i;
    }

    @Override // n60.a
    public QCircleInitBean getInitBean() {
        QFSPersonalDetailsFragment qFSPersonalDetailsFragment = this.f89210i;
        if (qFSPersonalDetailsFragment != null && qFSPersonalDetailsFragment.getQCircleInitBean() != null) {
            return this.f89210i.getQCircleInitBean();
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gl7;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f89211m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPersonalBottomWidget";
    }

    @Override // n60.a
    public QCircleReportBean m() {
        return getReportBean();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f89211m.setCurrentState(Lifecycle.State.STARTED);
        Iterator<n60.b> it = this.f89206d.iterator();
        while (it.hasNext()) {
            it.next().l();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f89211m.setCurrentState(Lifecycle.State.DESTROYED);
        Iterator<n60.b> it = this.f89206d.iterator();
        while (it.hasNext()) {
            it.next().n();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        QLog.d("FSPersonalBottomWidget", 2, "onInterceptTouchEvent hashCode" + hashCode());
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && z30.b.f451838b.b(motionEvent)) {
                return false;
            }
        } else {
            this.D.setUserInputEnabled(!z30.b.f451838b.b(motionEvent));
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        QLog.d("FSPersonalBottomWidget", 2, "onInterceptTouchEvent handle " + onInterceptTouchEvent);
        return onInterceptTouchEvent;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSUserResetEvent) {
            D0((QFSUserResetEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSSetViewPagerOrientationEvent) {
            E0((QFSSetViewPagerOrientationEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSAdjustBottomHeightEvent) {
            C0((QFSAdjustBottomHeightEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        O0();
    }

    public void y0(final boolean z16) {
        Runnable runnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.h
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalBottomWidget.this.L0(z16);
            }
        };
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_personal_bottom_delay_get_height_9090", true)) {
            this.M.postDelayed(runnable, 20L);
        } else {
            this.M.post(runnable);
        }
    }

    @Override // n60.a
    public View z() {
        return this;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(Object obj) {
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
