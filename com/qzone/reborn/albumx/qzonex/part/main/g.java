package com.qzone.reborn.albumx.qzonex.part.main;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxSwitchTabEvent;
import com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxTabAlbumFragment;
import com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxTabPicFragment;
import com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxTabRecommendFragment;
import com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxTabVideoFragment;
import com.qzone.reborn.albumx.qzonex.view.x;
import com.qzone.reborn.base.o;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat;
import com.tencent.biz.qqcircle.richframework.widget.ViewPagerCompat;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.f;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nc.bn;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u001a\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J$\u0010!\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001f0\u001ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001f` H\u0016J\u0012\u0010\"\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R&\u00109\u001a\u0012\u0012\u0004\u0012\u0002060\u001ej\b\u0012\u0004\u0012\u000206` 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/main/g;", "Lcom/qzone/reborn/base/k;", "Lhb/i;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initViewModel", "K9", "J9", "H9", "I9", "", "Landroidx/fragment/app/Fragment;", "F9", "Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxSwitchTabEvent;", "event", "G9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Lnc/bn;", "A7", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onReceiveEvent", "Lcom/tencent/biz/qqcircle/richframework/widget/ViewPagerCompat;", "d", "Lcom/tencent/biz/qqcircle/richframework/widget/ViewPagerCompat;", "viewPager", "Lcom/qzone/reborn/base/o;", "e", "Lcom/qzone/reborn/base/o;", "pageAdapter", "Lcom/tencent/biz/qqcircle/richframework/widget/TabLayoutCompat;", "f", "Lcom/tencent/biz/qqcircle/richframework/widget/TabLayoutCompat;", "tabLayout", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", tl.h.F, "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "blurView", "i", "Lnc/bn;", "mainTabViewModel", "Lcom/qzone/reborn/albumx/qzonex/view/x;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "tabViewList", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g extends com.qzone.reborn.base.k implements hb.i, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewPagerCompat viewPager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private o pageAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TabLayoutCompat tabLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QQBlurViewWrapper blurView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private bn mainTabViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ArrayList<x> tabViewList = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/albumx/qzonex/part/main/g$b", "Lcom/tencent/biz/qqcircle/richframework/widget/TabLayoutCompat$j;", "Landroid/view/ViewGroup;", "tabView", "", "position", "Landroid/view/View;", "b", "Lcom/tencent/biz/qqcircle/richframework/widget/TabLayoutCompat$f;", "tab", "lastTab", "status", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements TabLayoutCompat.j {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.j
        public void a(TabLayoutCompat.f tab, TabLayoutCompat.f lastTab, int status) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            if (!ab0.a.a(tab.d(), g.this.tabViewList)) {
                ((x) g.this.tabViewList.get(tab.d())).c(tab.d());
                bn bnVar = g.this.mainTabViewModel;
                if (bnVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
                    bnVar = null;
                }
                bnVar.x2(tab.d());
            }
            if (lastTab == null || ab0.a.a(lastTab.d(), g.this.tabViewList)) {
                return;
            }
            ((x) g.this.tabViewList.get(lastTab.d())).d(lastTab.d());
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.j
        public View b(ViewGroup tabView, int position) {
            Intrinsics.checkNotNullParameter(tabView, "tabView");
            x xVar = new x(tabView);
            g.this.tabViewList.add(xVar);
            xVar.e(position);
            if (position == 0) {
                xVar.c(0);
            }
            return xVar.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String();
        }
    }

    private final void G9(QZAlbumxSwitchTabEvent event) {
        if (event.getTabType() < 0 || event.getTabType() > 3) {
            return;
        }
        ViewPagerCompat viewPagerCompat = this.viewPager;
        bn bnVar = null;
        if (viewPagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPagerCompat = null;
        }
        viewPagerCompat.setCurrentItem(event.getTabType(), false);
        bn bnVar2 = this.mainTabViewModel;
        if (bnVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
        } else {
            bnVar = bnVar2;
        }
        bnVar.x2(event.getTabType());
    }

    private final void H9() {
        com.tencent.mobileqq.qui.b bVar = com.tencent.mobileqq.qui.b.f276860a;
        TabLayoutCompat tabLayoutCompat = this.tabLayout;
        QQBlurViewWrapper qQBlurViewWrapper = null;
        if (tabLayoutCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayoutCompat = null;
        }
        bVar.a(tabLayoutCompat, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
        View findViewById = getPartRootView().findViewById(R.id.mq9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_albumx_view_blur)");
        QQBlurViewWrapper qQBlurViewWrapper2 = (QQBlurViewWrapper) findViewById;
        this.blurView = qQBlurViewWrapper2;
        if (qQBlurViewWrapper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            qQBlurViewWrapper2 = null;
        }
        com.tencent.mobileqq.qui.b.d(bVar, qQBlurViewWrapper2, 0, 2, null);
        int color = getContext().getResources().getColor(R.color.qui_common_bg_nav_bottom);
        ColorDrawable colorDrawable = new ColorDrawable(color);
        f.a aVar = new f.a(Build.VERSION.SDK_INT >= 24, 64.0f, null, color, colorDrawable, Integer.valueOf(R.drawable.qui_bg_nav_secondary));
        aVar.o(true);
        aVar.m(true);
        aVar.l(true);
        QQBlurViewWrapper qQBlurViewWrapper3 = this.blurView;
        if (qQBlurViewWrapper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            qQBlurViewWrapper3 = null;
        }
        qQBlurViewWrapper3.setBackground(colorDrawable);
        QQBlurViewWrapper qQBlurViewWrapper4 = this.blurView;
        if (qQBlurViewWrapper4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            qQBlurViewWrapper4 = null;
        }
        qQBlurViewWrapper4.a(aVar);
        QQBlurViewWrapper qQBlurViewWrapper5 = this.blurView;
        if (qQBlurViewWrapper5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
        } else {
            qQBlurViewWrapper = qQBlurViewWrapper5;
        }
        qQBlurViewWrapper.setEnableBlur(true);
    }

    private final void I9() {
        o oVar = this.pageAdapter;
        bn bnVar = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageAdapter");
            oVar = null;
        }
        oVar.f(F9(), x.INSTANCE.a());
        ViewPagerCompat viewPagerCompat = this.viewPager;
        if (viewPagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPagerCompat = null;
        }
        bn bnVar2 = this.mainTabViewModel;
        if (bnVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            bnVar2 = null;
        }
        viewPagerCompat.setCurrentItem(bnVar2.getTabIndex(), false);
        bn bnVar3 = this.mainTabViewModel;
        if (bnVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            bnVar3 = null;
        }
        bn bnVar4 = this.mainTabViewModel;
        if (bnVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
        } else {
            bnVar = bnVar4;
        }
        bnVar3.x2(bnVar.getTabIndex());
    }

    private final void J9() {
        View findViewById = getPartRootView().findViewById(R.id.mpx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026.qzone_albumx_tab_layout)");
        TabLayoutCompat tabLayoutCompat = (TabLayoutCompat) findViewById;
        this.tabLayout = tabLayoutCompat;
        ViewPagerCompat viewPagerCompat = null;
        if (tabLayoutCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayoutCompat = null;
        }
        tabLayoutCompat.setTabMode(1);
        TabLayoutCompat tabLayoutCompat2 = this.tabLayout;
        if (tabLayoutCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayoutCompat2 = null;
        }
        tabLayoutCompat2.setTabGravity(0);
        TabLayoutCompat tabLayoutCompat3 = this.tabLayout;
        if (tabLayoutCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayoutCompat3 = null;
        }
        tabLayoutCompat3.setSelectedTabIndicatorHeight(0);
        TabLayoutCompat tabLayoutCompat4 = this.tabLayout;
        if (tabLayoutCompat4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayoutCompat4 = null;
        }
        tabLayoutCompat4.setViewPagerTabEventListener(new b());
        TabLayoutCompat tabLayoutCompat5 = this.tabLayout;
        if (tabLayoutCompat5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayoutCompat5 = null;
        }
        ViewPagerCompat viewPagerCompat2 = this.viewPager;
        if (viewPagerCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPagerCompat = viewPagerCompat2;
        }
        tabLayoutCompat5.setupWithViewPager(viewPagerCompat);
    }

    private final void K9() {
        FragmentManager childFragmentManager = getHostFragment().getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "hostFragment.childFragmentManager");
        this.pageAdapter = new o(childFragmentManager);
        View findViewById = getPartRootView().findViewById(R.id.mq_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026.qzone_albumx_view_pager)");
        ViewPagerCompat viewPagerCompat = (ViewPagerCompat) findViewById;
        this.viewPager = viewPagerCompat;
        ViewPagerCompat viewPagerCompat2 = null;
        if (viewPagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPagerCompat = null;
        }
        o oVar = this.pageAdapter;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageAdapter");
            oVar = null;
        }
        viewPagerCompat.setAdapter(oVar);
        ViewPagerCompat viewPagerCompat3 = this.viewPager;
        if (viewPagerCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPagerCompat2 = viewPagerCompat3;
        }
        viewPagerCompat2.setOffscreenPageLimit(0);
        getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.main.f
            @Override // java.lang.Runnable
            public final void run() {
                g.L9(g.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPagerCompat viewPagerCompat = this$0.viewPager;
        if (viewPagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPagerCompat = null;
        }
        viewPagerCompat.setOffscreenPageLimit(x.INSTANCE.a().size() - 1);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(bn.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxMai\u2026TabViewModel::class.java)");
        bn bnVar = (bn) viewModel;
        this.mainTabViewModel = bnVar;
        if (bnVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            bnVar = null;
        }
        bnVar.l2(getActivity().getIntent());
        registerIoc(getPartRootView(), this, hb.i.class);
    }

    @Override // hb.i
    public bn A7() {
        bn bnVar = this.mainTabViewModel;
        if (bnVar != null) {
            return bnVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxMainPageTabPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        initViewModel();
        K9();
        J9();
        I9();
        H9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        unregisterIoc(hb.i.class);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZAlbumxSwitchTabEvent) {
            G9((QZAlbumxSwitchTabEvent) event);
        }
    }

    private final List<Fragment> F9() {
        List<Fragment> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new QZAlbumxTabAlbumFragment(), new QZAlbumxTabPicFragment(), new QZAlbumxTabVideoFragment());
        if (this.mainTabViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
        }
        bn bnVar = this.mainTabViewModel;
        if (bnVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            bnVar = null;
        }
        if (bnVar.k2()) {
            mutableListOf.add(new QZAlbumxTabRecommendFragment());
        }
        return mutableListOf;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZAlbumxSwitchTabEvent.class);
        return arrayListOf;
    }
}
