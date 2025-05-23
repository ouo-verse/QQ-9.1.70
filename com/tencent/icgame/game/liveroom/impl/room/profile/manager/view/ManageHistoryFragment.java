package com.tencent.icgame.game.liveroom.impl.room.profile.manager.view;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qw0.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001;B\u0007\u00a2\u0006\u0004\b9\u0010:J\u0018\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J \u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020 H\u0016R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010)\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010$R*\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006<"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/profile/manager/view/ManageHistoryFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "rh", "Landroid/view/View;", "titleBarView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "qh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "position", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "", "isWrapContent", "", BdhLogUtil.LogTag.Tag_Conn, "J", "anchorID", "D", "roomID", "E", "subRoomID", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "mFragments", "Landroidx/viewpager/widget/ViewPager;", "G", "Landroidx/viewpager/widget/ViewPager;", "pagerView", "Lcom/tencent/icgame/game/liveroom/impl/room/profile/manager/view/NewPagerSlidingTabStrip;", "H", "Lcom/tencent/icgame/game/liveroom/impl/room/profile/manager/view/NewPagerSlidingTabStrip;", "tabView", "Lcom/tencent/icgame/game/liveroom/impl/room/profile/manager/view/CommonActionBar;", "I", "Lcom/tencent/icgame/game/liveroom/impl/room/profile/manager/view/CommonActionBar;", "commonActionBar", "<init>", "()V", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class ManageHistoryFragment extends QPublicBaseFragment implements ViewPager.OnPageChangeListener {

    /* renamed from: C, reason: from kotlin metadata */
    private long anchorID = -1;

    /* renamed from: D, reason: from kotlin metadata */
    private long roomID = -1;

    /* renamed from: E, reason: from kotlin metadata */
    private long subRoomID = -1;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ArrayList<Fragment> mFragments;

    /* renamed from: G, reason: from kotlin metadata */
    private ViewPager pagerView;

    /* renamed from: H, reason: from kotlin metadata */
    private NewPagerSlidingTabStrip tabView;

    /* renamed from: I, reason: from kotlin metadata */
    private CommonActionBar commonActionBar;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/profile/manager/view/ManageHistoryFragment$a;", "Landroidx/fragment/app/FragmentPagerAdapter;", "", "position", "", "getPageTitle", "getCount", "Landroidx/fragment/app/Fragment;", "getItem", "", "d", "Ljava/util/List;", "mFragmentPagers", "", "", "e", "[Ljava/lang/String;", "mTitles", "Landroidx/fragment/app/FragmentManager;", "fm", "<init>", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a extends FragmentPagerAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final List<Fragment> mFragmentPagers;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String[] mTitles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@Nullable FragmentManager fragmentManager, @Nullable List<? extends Fragment> list) {
            super(fragmentManager);
            Intrinsics.checkNotNull(fragmentManager);
            this.mFragmentPagers = list;
            this.mTitles = new String[]{"\u7981\u8a00\u5386\u53f2", "\u79fb\u51fa\u5386\u53f2"};
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return this.mTitles.length;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        @NotNull
        public Fragment getItem(int position) {
            List<Fragment> list = this.mFragmentPagers;
            Intrinsics.checkNotNull(list);
            return list.get(position);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NotNull
        public CharSequence getPageTitle(int position) {
            return this.mTitles[position];
        }
    }

    private final void qh(View titleBarView, Activity activity) {
        boolean z16 = true;
        if (ImmersiveUtils.isSupporImmersive() != 1) {
            z16 = false;
        }
        if (z16) {
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(activity);
            ViewGroup.LayoutParams layoutParams = titleBarView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + statusBarHeight, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            titleBarView.setLayoutParams(marginLayoutParams);
        }
    }

    private final ArrayList<Fragment> rh() {
        ArrayList<Fragment> arrayList = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putLong("anchorID", this.anchorID);
        bundle.putLong("roomID", this.roomID);
        bundle.putLong("subRoomID", this.subRoomID);
        HistoryBannedFragment historyBannedFragment = new HistoryBannedFragment();
        historyBannedFragment.setArguments(bundle);
        arrayList.add(historyBannedFragment);
        HistoryRemoveFragment historyRemoveFragment = new HistoryRemoveFragment();
        historyRemoveFragment.setArguments(bundle);
        arrayList.add(historyRemoveFragment);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(ManageHistoryFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.anchorID = requireArguments().getLong("anchorID", -1L);
        this.roomID = requireArguments().getLong("roomID", -1L);
        this.subRoomID = requireArguments().getLong("subRoomID", -1L);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fb9, container, false);
        View findViewById = inflate.findViewById(R.id.tabView);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.tabView)");
        this.tabView = (NewPagerSlidingTabStrip) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f221002t);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.pagerView)");
        this.pagerView = (ViewPager) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.u2g);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.commonActionBar)");
        this.commonActionBar = (CommonActionBar) findViewById3;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        CommonActionBar commonActionBar = this.commonActionBar;
        ViewPager viewPager = null;
        if (commonActionBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonActionBar");
            commonActionBar = null;
        }
        commonActionBar.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ManageHistoryFragment.sh(ManageHistoryFragment.this, view2);
            }
        });
        CommonActionBar commonActionBar2 = this.commonActionBar;
        if (commonActionBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonActionBar");
            commonActionBar2 = null;
        }
        commonActionBar2.setTitle(getResources().getString(R.string.f1643225i));
        CommonActionBar commonActionBar3 = this.commonActionBar;
        if (commonActionBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonActionBar");
            commonActionBar3 = null;
        }
        qh(commonActionBar3, getActivity());
        NewPagerSlidingTabStrip newPagerSlidingTabStrip = this.tabView;
        if (newPagerSlidingTabStrip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabView");
            newPagerSlidingTabStrip = null;
        }
        newPagerSlidingTabStrip.setIndicatorHeight(m.b(getContext(), 2.0f));
        NewPagerSlidingTabStrip newPagerSlidingTabStrip2 = this.tabView;
        if (newPagerSlidingTabStrip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabView");
            newPagerSlidingTabStrip2 = null;
        }
        newPagerSlidingTabStrip2.setIndictorTopMargin(m.b(getContext(), 1.0f));
        NewPagerSlidingTabStrip newPagerSlidingTabStrip3 = this.tabView;
        if (newPagerSlidingTabStrip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabView");
            newPagerSlidingTabStrip3 = null;
        }
        newPagerSlidingTabStrip3.setIndictorBottomMargin(0);
        NewPagerSlidingTabStrip newPagerSlidingTabStrip4 = this.tabView;
        if (newPagerSlidingTabStrip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabView");
            newPagerSlidingTabStrip4 = null;
        }
        newPagerSlidingTabStrip4.setIndicatorColor(Color.parseColor("#05D380"));
        NewPagerSlidingTabStrip newPagerSlidingTabStrip5 = this.tabView;
        if (newPagerSlidingTabStrip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabView");
            newPagerSlidingTabStrip5 = null;
        }
        newPagerSlidingTabStrip5.setTextSize(m.b(getContext(), 16.0f));
        NewPagerSlidingTabStrip newPagerSlidingTabStrip6 = this.tabView;
        if (newPagerSlidingTabStrip6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabView");
            newPagerSlidingTabStrip6 = null;
        }
        newPagerSlidingTabStrip6.setTypeface(null, 0);
        NewPagerSlidingTabStrip newPagerSlidingTabStrip7 = this.tabView;
        if (newPagerSlidingTabStrip7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabView");
            newPagerSlidingTabStrip7 = null;
        }
        newPagerSlidingTabStrip7.setSelectedTypeface(null, 0);
        NewPagerSlidingTabStrip newPagerSlidingTabStrip8 = this.tabView;
        if (newPagerSlidingTabStrip8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabView");
            newPagerSlidingTabStrip8 = null;
        }
        newPagerSlidingTabStrip8.setTabBackground(0);
        NewPagerSlidingTabStrip newPagerSlidingTabStrip9 = this.tabView;
        if (newPagerSlidingTabStrip9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabView");
            newPagerSlidingTabStrip9 = null;
        }
        newPagerSlidingTabStrip9.setTextColor(Color.parseColor("#05D380"));
        NewPagerSlidingTabStrip newPagerSlidingTabStrip10 = this.tabView;
        if (newPagerSlidingTabStrip10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabView");
            newPagerSlidingTabStrip10 = null;
        }
        newPagerSlidingTabStrip10.setUnSelectedTextColor(Color.parseColor("#999999"));
        NewPagerSlidingTabStrip newPagerSlidingTabStrip11 = this.tabView;
        if (newPagerSlidingTabStrip11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabView");
            newPagerSlidingTabStrip11 = null;
        }
        newPagerSlidingTabStrip11.setShouldExpand(true);
        NewPagerSlidingTabStrip newPagerSlidingTabStrip12 = this.tabView;
        if (newPagerSlidingTabStrip12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabView");
            newPagerSlidingTabStrip12 = null;
        }
        newPagerSlidingTabStrip12.setIndicatorWidth(m.b(getContext(), 100.0f));
        NewPagerSlidingTabStrip newPagerSlidingTabStrip13 = this.tabView;
        if (newPagerSlidingTabStrip13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabView");
            newPagerSlidingTabStrip13 = null;
        }
        newPagerSlidingTabStrip13.setOnPageChangeListener(this);
        this.mFragments = rh();
        ViewPager viewPager2 = this.pagerView;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerView");
            viewPager2 = null;
        }
        viewPager2.setAdapter(new a(getChildFragmentManager(), this.mFragments));
        NewPagerSlidingTabStrip newPagerSlidingTabStrip14 = this.tabView;
        if (newPagerSlidingTabStrip14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabView");
            newPagerSlidingTabStrip14 = null;
        }
        ViewPager viewPager3 = this.pagerView;
        if (viewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerView");
            viewPager3 = null;
        }
        newPagerSlidingTabStrip14.setViewPager(viewPager3);
        ViewPager viewPager4 = this.pagerView;
        if (viewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerView");
        } else {
            viewPager = viewPager4;
        }
        viewPager.setCurrentItem(0);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int position) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }
}
