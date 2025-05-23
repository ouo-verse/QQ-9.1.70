package com.qzone.reborn.groupalbum.part;

import aa.f;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.viewpager.widget.ViewPager;
import com.qzone.reborn.groupalbum.event.GroupAlbumMainPageTabChangeEvent;
import com.qzone.reborn.groupalbum.fragment.GroupAlbumAlbumListFragment;
import com.qzone.reborn.groupalbum.fragment.GroupAlbumFeedFragment;
import com.qzone.reborn.groupalbum.viewmodel.aj;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 62\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u001c\u0010\u0018\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001e0\u001dH\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/j;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initViewModel", "H9", "G9", "F9", "", "Landroidx/fragment/app/Fragment;", "D9", "", "position", "I9", "Lcom/qzone/reborn/groupalbum/event/GroupAlbumMainPageTabChangeEvent;", "event", "E9", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "onReceiveEvent", "Lcom/qzone/reborn/groupalbum/viewmodel/aj;", "d", "Lcom/qzone/reborn/groupalbum/viewmodel/aj;", "mMainTabViewModel", "Lcom/tencent/mobileqq/widget/ViewPagerCompat;", "e", "Lcom/tencent/mobileqq/widget/ViewPagerCompat;", "mViewPager", "Lcom/qzone/reborn/base/o;", "f", "Lcom/qzone/reborn/base/o;", "mAdapter", "Lcom/tencent/mobileqq/widget/TabLayoutCompat;", tl.h.F, "Lcom/tencent/mobileqq/widget/TabLayoutCompat;", "mTabLayout", "i", "Ljava/util/List;", "mTitles", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class j extends com.qzone.reborn.base.k implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private aj mMainTabViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewPagerCompat mViewPager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.base.o mAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TabLayoutCompat mTabLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private List<String> mTitles;

    public j() {
        List<String> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("\u7fa4\u52a8\u6001", "\u7fa4\u76f8\u518c");
        this.mTitles = mutableListOf;
    }

    private final void E9(GroupAlbumMainPageTabChangeEvent event) {
        com.qzone.reborn.base.o oVar = this.mAdapter;
        aj ajVar = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            oVar = null;
        }
        if (oVar.d().size() <= event.getTabId()) {
            RFWLog.w("GroupAlbumMainPageBodyPart", RFWLog.USR, "event tabId error ");
            return;
        }
        aj ajVar2 = this.mMainTabViewModel;
        if (ajVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainTabViewModel");
            ajVar2 = null;
        }
        ajVar2.Z1(event.getTabId());
        ViewPagerCompat viewPagerCompat = this.mViewPager;
        if (viewPagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPagerCompat = null;
        }
        aj ajVar3 = this.mMainTabViewModel;
        if (ajVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainTabViewModel");
        } else {
            ajVar = ajVar3;
        }
        viewPagerCompat.setCurrentItem(ajVar.getMTabIndex(), false);
    }

    private final void F9() {
        com.qzone.reborn.base.o oVar = this.mAdapter;
        aj ajVar = null;
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
        aj ajVar2 = this.mMainTabViewModel;
        if (ajVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainTabViewModel");
        } else {
            ajVar = ajVar2;
        }
        viewPagerCompat2.setCurrentItem(ajVar.getMTabIndex(), false);
    }

    private final void G9() {
        View findViewById = getPartRootView().findViewById(R.id.k8m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.group_album_tab_layout)");
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
        f.Companion companion = aa.f.INSTANCE;
        TabLayoutCompat tabLayoutCompat4 = this.mTabLayout;
        if (tabLayoutCompat4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat4 = null;
        }
        tabLayoutCompat3.setRequestedTabMinWidth(companion.b(tabLayoutCompat4.getContext(), ef.d.b(100)));
        TabLayoutCompat tabLayoutCompat5 = this.mTabLayout;
        if (tabLayoutCompat5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat5 = null;
        }
        tabLayoutCompat5.setTabMode(1);
        TabLayoutCompat tabLayoutCompat6 = this.mTabLayout;
        if (tabLayoutCompat6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat6 = null;
        }
        TabLayoutCompat tabLayoutCompat7 = this.mTabLayout;
        if (tabLayoutCompat7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat7 = null;
        }
        tabLayoutCompat6.setSelectedTabIndicatorHeight(companion.b(tabLayoutCompat7.getContext(), ef.d.b(3)));
        TabLayoutCompat tabLayoutCompat8 = this.mTabLayout;
        if (tabLayoutCompat8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat8 = null;
        }
        TabLayoutCompat tabLayoutCompat9 = this.mTabLayout;
        if (tabLayoutCompat9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat9 = null;
        }
        tabLayoutCompat8.setSelectedTabIndicatorPaddingLeft(companion.b(tabLayoutCompat9.getContext(), ef.d.b(32)));
        TabLayoutCompat tabLayoutCompat10 = this.mTabLayout;
        if (tabLayoutCompat10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat10 = null;
        }
        TabLayoutCompat tabLayoutCompat11 = this.mTabLayout;
        if (tabLayoutCompat11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat11 = null;
        }
        tabLayoutCompat10.setSelectedTabIndicatorPaddingRight(companion.b(tabLayoutCompat11.getContext(), ef.d.b(32)));
        TabLayoutCompat tabLayoutCompat12 = this.mTabLayout;
        if (tabLayoutCompat12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat12 = null;
        }
        TabLayoutCompat tabLayoutCompat13 = this.mTabLayout;
        if (tabLayoutCompat13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat13 = null;
        }
        tabLayoutCompat12.setSelectedTabIndicatorPaddingBottom(companion.b(tabLayoutCompat13.getContext(), ef.d.b(10)));
        TabLayoutCompat tabLayoutCompat14 = this.mTabLayout;
        if (tabLayoutCompat14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat14 = null;
        }
        TabLayoutCompat tabLayoutCompat15 = this.mTabLayout;
        if (tabLayoutCompat15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayoutCompat15 = null;
        }
        tabLayoutCompat14.setTabTextSize(companion.b(tabLayoutCompat15.getContext(), ef.d.d(16)));
        Activity activity = getActivity();
        if (activity != null) {
            TabLayoutCompat tabLayoutCompat16 = this.mTabLayout;
            if (tabLayoutCompat16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
                tabLayoutCompat16 = null;
            }
            tabLayoutCompat16.setSelectedTabIndicatorColor(activity.getColor(R.color.qui_common_icon_aio_nav_active));
            TabLayoutCompat tabLayoutCompat17 = this.mTabLayout;
            if (tabLayoutCompat17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
                tabLayoutCompat17 = null;
            }
            tabLayoutCompat17.setTabTextColors(activity.getColor(R.color.qui_common_text_primary), activity.getColor(R.color.qui_common_icon_aio_nav_active));
        }
        TabLayoutCompat tabLayoutCompat18 = this.mTabLayout;
        if (tabLayoutCompat18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        } else {
            tabLayoutCompat2 = tabLayoutCompat18;
        }
        companion.a(tabLayoutCompat2);
    }

    private final void H9() {
        FragmentManager childFragmentManager = getHostFragment().getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "hostFragment.childFragmentManager");
        this.mAdapter = new com.qzone.reborn.base.o(childFragmentManager);
        View findViewById = getPartRootView().findViewById(R.id.k8r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.group_album_view_pager)");
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(int position) {
        com.qzone.reborn.base.o oVar = this.mAdapter;
        aj ajVar = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            oVar = null;
        }
        oVar.d().get(position);
        aj ajVar2 = this.mMainTabViewModel;
        if (ajVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainTabViewModel");
        } else {
            ajVar = ajVar2;
        }
        ajVar.Z1(position);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(aj.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumM\u2026TabViewModel::class.java)");
        this.mMainTabViewModel = (aj) viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumMainPageBodyPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        initViewModel();
        H9();
        G9();
        F9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof GroupAlbumMainPageTabChangeEvent) {
            E9((GroupAlbumMainPageTabChangeEvent) event);
        }
    }

    private final List<Fragment> D9() {
        List<Fragment> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new GroupAlbumFeedFragment(), new GroupAlbumAlbumListFragment());
        return mutableListOf;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GroupAlbumMainPageTabChangeEvent.class);
        return arrayListOf;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/groupalbum/part/j$b", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            j.this.I9(position);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}
