package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.view.View;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.viewpager.widget.ViewPager;
import com.qzone.reborn.intimate.fragment.QZoneIntimateSpaceAlbumListFragment;
import com.qzone.reborn.intimate.fragment.QZoneIntimateSpaceFeedFragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import common.config.service.QzoneConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u001c\u0010\u0017\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00130\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/qzone/reborn/intimate/part/cg;", "Lcom/qzone/reborn/base/k;", "", "initViewModel", "E9", "", "position", "I9", "H9", "", "Landroidx/fragment/app/Fragment;", "D9", "Landroid/view/View;", "view", "G9", "F9", "scrollToTop", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "Lnk/at;", "d", "Lnk/at;", "mMainTabViewModel", "Lcom/qzone/reborn/base/o;", "e", "Lcom/qzone/reborn/base/o;", "mAdapter", "Lcom/tencent/mobileqq/widget/ViewPagerCompat;", "f", "Lcom/tencent/mobileqq/widget/ViewPagerCompat;", "mViewPager", "Lcom/tencent/mobileqq/widget/TabLayoutCompat;", tl.h.F, "Lcom/tencent/mobileqq/widget/TabLayoutCompat;", "mTabLayout", "i", "Ljava/util/List;", "mTitles", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class cg extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private nk.at mMainTabViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.base.o mAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewPagerCompat mViewPager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TabLayoutCompat mTabLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private List<String> mTitles;

    public cg() {
        List<String> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("\u52a8\u6001", QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE);
        this.mTitles = mutableListOf;
    }

    private final void E9() {
        com.qzone.reborn.base.o oVar = this.mAdapter;
        nk.at atVar = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            oVar = null;
        }
        oVar.f(D9(), this.mTitles);
        ViewPagerCompat viewPagerCompat = this.mViewPager;
        if (viewPagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPagerCompat = null;
        }
        viewPagerCompat.addOnPageChangeListener(new b());
        ViewPagerCompat viewPagerCompat2 = this.mViewPager;
        if (viewPagerCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPagerCompat2 = null;
        }
        nk.at atVar2 = this.mMainTabViewModel;
        if (atVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainTabViewModel");
        } else {
            atVar = atVar2;
        }
        viewPagerCompat2.setCurrentItem(atVar.getMTabIndex(), false);
        I9(0);
        H9();
    }

    private final void G9(View view) {
        FragmentManager childFragmentManager = getHostFragment().getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "hostFragment.childFragmentManager");
        this.mAdapter = new com.qzone.reborn.base.o(childFragmentManager);
        View findViewById = view.findViewById(R.id.n6b);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.qzone_intimate_view_pager)");
        ViewPagerCompat viewPagerCompat = (ViewPagerCompat) findViewById;
        this.mViewPager = viewPagerCompat;
        com.qzone.reborn.base.o oVar = null;
        if (viewPagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPagerCompat = null;
        }
        com.qzone.reborn.base.o oVar2 = this.mAdapter;
        if (oVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            oVar = oVar2;
        }
        viewPagerCompat.setAdapter(oVar);
    }

    private final void H9() {
        com.qzone.reborn.base.o oVar = this.mAdapter;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            oVar = null;
        }
        if (oVar.d().isEmpty()) {
            return;
        }
        com.qzone.reborn.base.o oVar2 = this.mAdapter;
        if (oVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            oVar2 = null;
        }
        for (Fragment fragment : oVar2.d()) {
            if (fragment instanceof qj.k) {
                nk.at atVar = this.mMainTabViewModel;
                if (atVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMainTabViewModel");
                    atVar = null;
                }
                List<qj.k> Z1 = atVar.Z1();
                if (Z1 != null) {
                    Z1.add(fragment);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(int position) {
        com.qzone.reborn.base.o oVar = this.mAdapter;
        nk.at atVar = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            oVar = null;
        }
        ActivityResultCaller activityResultCaller = (Fragment) oVar.d().get(position);
        if (activityResultCaller instanceof qj.n) {
            nk.at atVar2 = this.mMainTabViewModel;
            if (atVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMainTabViewModel");
            } else {
                atVar = atVar2;
            }
            atVar.h2((qj.n) activityResultCaller);
        }
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(nk.at.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026TabViewModel::class.java)");
        this.mMainTabViewModel = (nk.at) viewModel;
    }

    private final void scrollToTop() {
        com.qzone.reborn.base.o oVar = this.mAdapter;
        ViewPagerCompat viewPagerCompat = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            oVar = null;
        }
        List<Fragment> d16 = oVar.d();
        ViewPagerCompat viewPagerCompat2 = this.mViewPager;
        if (viewPagerCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        } else {
            viewPagerCompat = viewPagerCompat2;
        }
        ActivityResultCaller activityResultCaller = (Fragment) d16.get(viewPagerCompat.getCurrentItem());
        if (activityResultCaller instanceof qj.m) {
            qj.m mVar = (qj.m) activityResultCaller;
            if (mVar.fa()) {
                mVar.W5();
                return;
            }
        }
        IPartHost partHost = getPartHost();
        if (partHost instanceof qj.m) {
            qj.m mVar2 = (qj.m) partHost;
            if (mVar2.fa()) {
                mVar2.W5();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        if (Intrinsics.areEqual(action, "QZONE_INTIMATE_SCROLL_TOP")) {
            scrollToTop();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initViewModel();
        G9(rootView);
        F9(rootView);
        E9();
    }

    private final List<Fragment> D9() {
        List<Fragment> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new QZoneIntimateSpaceFeedFragment(), new QZoneIntimateSpaceAlbumListFragment());
        return mutableListOf;
    }

    private final void F9(View view) {
        View findViewById = view.findViewById(R.id.n5w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.qzone_intimate_tab_layout)");
        TabLayoutCompat tabLayoutCompat = (TabLayoutCompat) findViewById;
        this.mTabLayout = tabLayoutCompat;
        TabLayoutCompat tabLayoutCompat2 = null;
        if (tabLayoutCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat = null;
        }
        ViewPagerCompat viewPagerCompat = this.mViewPager;
        if (viewPagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPagerCompat = null;
        }
        tabLayoutCompat.setupWithViewPager(viewPagerCompat);
        TabLayoutCompat tabLayoutCompat3 = this.mTabLayout;
        if (tabLayoutCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat3 = null;
        }
        tabLayoutCompat3.setRequestedTabMinWidth(ef.d.b(120));
        TabLayoutCompat tabLayoutCompat4 = this.mTabLayout;
        if (tabLayoutCompat4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat4 = null;
        }
        tabLayoutCompat4.setTabMode(1);
        TabLayoutCompat tabLayoutCompat5 = this.mTabLayout;
        if (tabLayoutCompat5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat5 = null;
        }
        tabLayoutCompat5.setSelectedTabIndicatorHeight(ef.d.b(3));
        TabLayoutCompat tabLayoutCompat6 = this.mTabLayout;
        if (tabLayoutCompat6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat6 = null;
        }
        tabLayoutCompat6.setSelectedTabIndicatorPaddingLeft(ef.d.b(44));
        TabLayoutCompat tabLayoutCompat7 = this.mTabLayout;
        if (tabLayoutCompat7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat7 = null;
        }
        tabLayoutCompat7.setSelectedTabIndicatorPaddingRight(ef.d.b(44));
        TabLayoutCompat tabLayoutCompat8 = this.mTabLayout;
        if (tabLayoutCompat8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat8 = null;
        }
        tabLayoutCompat8.setSelectedTabIndicatorPaddingBottom(ef.d.b(10));
        TabLayoutCompat tabLayoutCompat9 = this.mTabLayout;
        if (tabLayoutCompat9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat9 = null;
        }
        tabLayoutCompat9.setTabTextSize(ef.d.d(16));
        Activity activity = getActivity();
        if (activity != null) {
            TabLayoutCompat tabLayoutCompat10 = this.mTabLayout;
            if (tabLayoutCompat10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
                tabLayoutCompat10 = null;
            }
            tabLayoutCompat10.setSelectedTabIndicatorColor(activity.getColor(R.color.qui_common_brand_standard));
            TabLayoutCompat tabLayoutCompat11 = this.mTabLayout;
            if (tabLayoutCompat11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            } else {
                tabLayoutCompat2 = tabLayoutCompat11;
            }
            tabLayoutCompat2.setTabTextColors(activity.getColor(R.color.qui_common_text_primary), activity.getColor(R.color.qui_common_brand_standard));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/intimate/part/cg$b", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            cg.this.I9(position);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}
