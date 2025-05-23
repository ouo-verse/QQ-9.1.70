package com.tencent.timi.game.liveroom.impl.room.match;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.PremadesTeamServerOuterClass$RoomTabInfo;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0002+\tB\u0019\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b(\u0010)J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\b\u0018\u00010\u001cR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006,"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceTabViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Landroidx/fragment/app/FragmentManager;", "fm", "", "Ltrpc/yes/common/PremadesTeamServerOuterClass$RoomTabInfo;", "tabs", "", "setData", "c", "Landroid/view/MotionEvent;", "ev", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", "dispatchTouchEvent", "", "direction", "canScrollHorizontally", "canScrollVertically", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "getTouchViewGroup", "()Landroid/view/ViewGroup;", "setTouchViewGroup", "(Landroid/view/ViewGroup;)V", "touchViewGroup", "Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceTabViewPager$c;", "e", "Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceTabViewPager$c;", "viewPagerAdapter", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "f", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "logger", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", h.F, "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TGAudienceTabViewPager extends ViewPager {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final String f377942i = "ViewPagerAdapter";

    /* renamed from: m, reason: collision with root package name */
    private static final boolean f377943m = true;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup touchViewGroup;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c viewPagerAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi logger;

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0016\u0010\u0011\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\u0014\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0018H\u0016R(\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010&\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\"\u001a\u0004\b\u001b\u0010#\"\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceTabViewPager$c;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "", "getCount", "position", "Landroidx/fragment/app/Fragment;", "getItem", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "instantiateItem", "object", "", "destroyItem", "", "Ltrpc/yes/common/PremadesTeamServerOuterClass$RoomTabInfo;", "list", "f", "", "getPageWidth", "setPrimaryItem", "obj", "getItemPosition", "startUpdate", "Landroid/view/View;", "finishUpdate", "", "d", "Ljava/util/List;", "e", "()Ljava/util/List;", "setMDataList", "(Ljava/util/List;)V", "mDataList", "Landroidx/fragment/app/Fragment;", "()Landroidx/fragment/app/Fragment;", "setMCurrentPrimaryItem", "(Landroidx/fragment/app/Fragment;)V", "mCurrentPrimaryItem", "", "Z", "mHasFinishUpdate", "Landroidx/fragment/app/FragmentManager;", "fm", "<init>", "(Lcom/tencent/timi/game/liveroom/impl/room/match/TGAudienceTabViewPager;Landroidx/fragment/app/FragmentManager;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    private final class c extends FragmentStatePagerAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<PremadesTeamServerOuterClass$RoomTabInfo> mDataList;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Fragment mCurrentPrimaryItem;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean mHasFinishUpdate;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ TGAudienceTabViewPager f377951h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull TGAudienceTabViewPager tGAudienceTabViewPager, FragmentManager fm5) {
            super(fm5);
            Intrinsics.checkNotNullParameter(fm5, "fm");
            this.f377951h = tGAudienceTabViewPager;
            this.mDataList = new ArrayList();
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final Fragment getMCurrentPrimaryItem() {
            return this.mCurrentPrimaryItem;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(object, "object");
            if (QLog.isColorLevel()) {
                QLog.d(TGAudienceTabViewPager.f377942i, 2, "destroyItem() called with: container = [" + container + "], position = [" + position + "], object = [" + object + "]");
            }
            super.destroyItem(container, position, object);
        }

        @NotNull
        public final List<PremadesTeamServerOuterClass$RoomTabInfo> e() {
            return this.mDataList;
        }

        public final void f(@Nullable List<PremadesTeamServerOuterClass$RoomTabInfo> list) {
            if (list != null) {
                List<PremadesTeamServerOuterClass$RoomTabInfo> list2 = this.mDataList;
                Intrinsics.checkNotNull(list2);
                list2.clear();
                List<PremadesTeamServerOuterClass$RoomTabInfo> list3 = this.mDataList;
                Intrinsics.checkNotNull(list3);
                list3.addAll(list);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(@NotNull View container) {
            Intrinsics.checkNotNullParameter(container, "container");
            super.finishUpdate(container);
            this.mHasFinishUpdate = true;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            List<PremadesTeamServerOuterClass$RoomTabInfo> list = this.mDataList;
            Intrinsics.checkNotNull(list);
            return list.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        @NotNull
        public Fragment getItem(int position) {
            if (position < this.mDataList.size()) {
                PremadesTeamServerOuterClass$RoomTabInfo premadesTeamServerOuterClass$RoomTabInfo = this.mDataList.get(position);
                if (this.mDataList.get(position).tab_type.get() == 0) {
                    return new TGLiveDefaultFragment();
                }
                Intent intent = new Intent();
                intent.putExtra("url", premadesTeamServerOuterClass$RoomTabInfo.h5_link.get());
                intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_NONE, true);
                TGLiveMatchWebViewFragment browserFragment = TGLiveMatchWebViewFragment.Bh(intent);
                browserFragment.Ch(premadesTeamServerOuterClass$RoomTabInfo.h5_link.get());
                browserFragment.Dh(position);
                QLog.i(TGAudienceTabViewPager.f377942i, 1, "createFragment for url:" + premadesTeamServerOuterClass$RoomTabInfo.h5_link.get());
                Intrinsics.checkNotNullExpressionValue(browserFragment, "browserFragment");
                return browserFragment;
            }
            return new TGLiveDefaultFragment();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            if (obj instanceof TGLiveMatchWebViewFragment) {
                TGLiveMatchWebViewFragment tGLiveMatchWebViewFragment = (TGLiveMatchWebViewFragment) obj;
                if (tGLiveMatchWebViewFragment.Ah() < this.mDataList.size() && TextUtils.equals(this.mDataList.get(tGLiveMatchWebViewFragment.Ah()).h5_link.get(), tGLiveMatchWebViewFragment.zh())) {
                    return -1;
                }
                return -2;
            }
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int position) {
            return super.getPageWidth(position);
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        @NotNull
        public Object instantiateItem(@NotNull ViewGroup container, int position) {
            Intrinsics.checkNotNullParameter(container, "container");
            if (QLog.isColorLevel()) {
                QLog.d(TGAudienceTabViewPager.f377942i, 2, "instantiateItem() called with: container = [" + container + "], position = [" + position + "]");
            }
            Object instantiateItem = super.instantiateItem(container, position);
            Intrinsics.checkNotNullExpressionValue(instantiateItem, "super.instantiateItem(container, position)");
            return instantiateItem;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(object, "object");
            super.setPrimaryItem(container, position, object);
            this.mCurrentPrimaryItem = (Fragment) object;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void startUpdate(@NotNull ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            super.startUpdate(container);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TGAudienceTabViewPager(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.logger = (IAegisLogApi) api;
        addOnPageChangeListener(new a());
    }

    @NotNull
    public final List<PremadesTeamServerOuterClass$RoomTabInfo> c() {
        c cVar = this.viewPagerAdapter;
        if (cVar != null) {
            Intrinsics.checkNotNull(cVar);
            return cVar.e();
        }
        return new ArrayList();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int direction) {
        Fragment fragment;
        View view;
        int i3;
        c cVar = this.viewPagerAdapter;
        TGLiveMatchWebViewFragment tGLiveMatchWebViewFragment = null;
        if (cVar != null) {
            fragment = cVar.getMCurrentPrimaryItem();
        } else {
            fragment = null;
        }
        if (fragment instanceof TGLiveMatchWebViewFragment) {
            tGLiveMatchWebViewFragment = (TGLiveMatchWebViewFragment) fragment;
        }
        if (tGLiveMatchWebViewFragment != null) {
            try {
                CustomWebView webView = tGLiveMatchWebViewFragment.getWebView();
                if (webView != null && (view = webView.getView()) != null) {
                    if (direction > 0) {
                        i3 = 1;
                    } else {
                        i3 = -1;
                    }
                    return view.canScrollHorizontally(i3);
                }
                return false;
            } catch (IllegalStateException e16) {
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w(f377942i, "canScrollHorizontally exception:" + e16);
            }
        }
        return super.canScrollHorizontally(direction);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        Fragment fragment;
        c cVar = this.viewPagerAdapter;
        TGLiveMatchWebViewFragment tGLiveMatchWebViewFragment = null;
        if (cVar != null) {
            fragment = cVar.getMCurrentPrimaryItem();
        } else {
            fragment = null;
        }
        if (fragment instanceof TGLiveMatchWebViewFragment) {
            tGLiveMatchWebViewFragment = (TGLiveMatchWebViewFragment) fragment;
        }
        if (tGLiveMatchWebViewFragment != null) {
            return true;
        }
        return super.canScrollVertically(direction);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        return super.dispatchTouchEvent(ev5);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent ev5) {
        try {
            return super.onInterceptTouchEvent(ev5);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent ev5) {
        try {
            return super.onTouchEvent(ev5);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public final void setData(@NotNull FragmentManager fm5, @Nullable List<PremadesTeamServerOuterClass$RoomTabInfo> tabs) {
        boolean z16;
        Intrinsics.checkNotNullParameter(fm5, "fm");
        List<PremadesTeamServerOuterClass$RoomTabInfo> list = tabs;
        int i3 = 1;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && tabs.size() > 1) {
            setVisibility(0);
            if (!f377943m) {
                i3 = tabs.size() - 1;
            }
            this.logger.i(f377942i, "limit:" + i3);
            setOffscreenPageLimit(i3);
            c cVar = new c(this, fm5);
            this.viewPagerAdapter = cVar;
            setAdapter(cVar);
            c cVar2 = this.viewPagerAdapter;
            if (cVar2 != null) {
                cVar2.f(tabs);
            }
            c cVar3 = this.viewPagerAdapter;
            if (cVar3 != null) {
                cVar3.notifyDataSetChanged();
                return;
            }
            return;
        }
        setVisibility(8);
    }

    public final void setTouchViewGroup(@Nullable ViewGroup viewGroup) {
        this.touchViewGroup = viewGroup;
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/match/TGAudienceTabViewPager$a", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            Fragment fragment;
            View view;
            c cVar = TGAudienceTabViewPager.this.viewPagerAdapter;
            TGLiveMatchWebViewFragment tGLiveMatchWebViewFragment = null;
            if (cVar != null) {
                fragment = cVar.getMCurrentPrimaryItem();
            } else {
                fragment = null;
            }
            if (fragment instanceof TGLiveMatchWebViewFragment) {
                tGLiveMatchWebViewFragment = (TGLiveMatchWebViewFragment) fragment;
            }
            if (tGLiveMatchWebViewFragment != null) {
                TGAudienceTabViewPager tGAudienceTabViewPager = TGAudienceTabViewPager.this;
                CustomWebView webView = tGLiveMatchWebViewFragment.getWebView();
                if (webView != null && (view = webView.getView()) != null) {
                    view.invalidate();
                }
                CustomWebView webView2 = tGLiveMatchWebViewFragment.getWebView();
                if (webView2 instanceof TGLiveTouchWebView) {
                    ((TGLiveTouchWebView) webView2).setViewPager(tGAudienceTabViewPager);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}
