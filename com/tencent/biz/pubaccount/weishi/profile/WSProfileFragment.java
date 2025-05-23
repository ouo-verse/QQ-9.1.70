package com.tencent.biz.pubaccount.weishi.profile;

import NS_KING_SOCIALIZE_META.stShareInfo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.weishi.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.profile.header.WSProfileHeaderView;
import com.tencent.biz.pubaccount.weishi.ui.WSBehaviorSuite$HeaderBehavior;
import com.tencent.biz.pubaccount.weishi.util.af;
import com.tencent.biz.pubaccount.weishi.util.ak;
import com.tencent.biz.pubaccount.weishi.util.az;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.verticalvideo.view.WSSwipeRefreshLayout;
import com.tencent.biz.pubaccount.weishi.view.WSViewPager;
import com.tencent.biz.pubaccount.weishi.view.tab.WSTabLayout;
import com.tencent.biz.pubaccount.weishi.z;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.open.base.ToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes32.dex */
public class WSProfileFragment extends WSBaseFragment<com.tencent.biz.pubaccount.weishi.profile.d, com.tencent.biz.pubaccount.weishi.profile.c> implements com.tencent.biz.pubaccount.weishi.profile.d, wz.c, SwipeRefreshLayout.OnRefreshListener {
    private WSSwipeRefreshLayout M;
    private View N;
    private WSTabLayout P;
    private com.tencent.biz.pubaccount.weishi.view.tab.a Q;
    private com.tencent.biz.pubaccount.weishi.view.tab.a R;
    private WSProfileHeaderView S;
    private com.tencent.biz.pubaccount.weishi.profile.header.f T;
    private com.tencent.biz.pubaccount.weishi.profile.header.d U;
    private com.tencent.biz.pubaccount.weishi.profile.header.c V;
    private WSViewPager W;
    private l10.b X;
    private List<QBaseFragment> Y;
    private z00.b Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f81254a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f81255b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f81256c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f81257d0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements k {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.profile.WSProfileFragment.k
        public void a(WSProfileWorksFragment wSProfileWorksFragment) {
            wSProfileWorksFragment.resetData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements k {
        b() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.profile.WSProfileFragment.k
        public void a(WSProfileWorksFragment wSProfileWorksFragment) {
            wSProfileWorksFragment.Zh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements WSSwipeRefreshLayout.a {
        c() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.view.WSSwipeRefreshLayout.a
        public boolean a() {
            return false;
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.view.WSSwipeRefreshLayout.a
        public boolean b() {
            return !WSProfileFragment.this.f81255b0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements z00.c {
        d() {
        }

        @Override // z00.c
        public void a() {
            WSProfileFragment.this.ni();
        }

        @Override // z00.c
        public void b() {
            WSProfileFragment.this.oi();
        }

        @Override // z00.c
        public void c() {
            WSProfileFragment.this.mi();
        }

        @Override // z00.c
        public void onBackClick() {
            WSProfileFragment.this.getQBaseActivity().doOnBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements com.tencent.biz.pubaccount.weishi.ui.b {
        e() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.ui.b
        public void a(float f16, int i3) {
            WSProfileFragment.this.Z.p(i3);
            WSProfileFragment wSProfileFragment = WSProfileFragment.this;
            wSProfileFragment.ph(wSProfileFragment.Z.getIsToolbarIconBlack());
            WSProfileFragment.this.M.setEnabled(i3 == 0);
            WSProfileFragment.this.W.requestDisallowInterceptTouchEvent(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class g implements ViewPager.OnPageChangeListener {
        g() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            WSProfileFragment.this.f81255b0 = i3 == 1;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            WSProfileFragment wSProfileFragment = WSProfileFragment.this;
            if (wSProfileFragment.L) {
                wSProfileFragment.R.d(f16);
                WSProfileFragment.this.Q.d(bb.D(f16, 0.0f) ? 0.0f : 1.0f - f16);
            } else {
                wSProfileFragment.Q.c(f16);
                WSProfileFragment.this.R.c(bb.D(f16, 0.0f) ? 0.0f : 1.0f - f16);
            }
            WSProfileFragment.this.P.x0(i3, f16);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            TabLayoutCompat.f z16 = WSProfileFragment.this.P.z(i3);
            if (z16 != null) {
                z16.j();
            }
            WSProfileFragment.this.Wh(i3);
            ((com.tencent.biz.pubaccount.weishi.profile.c) ((WSBaseFragment) WSProfileFragment.this).E).m0(i3);
            WSProfileFragment.this.Bh(i3 == 0);
        }
    }

    /* loaded from: classes32.dex */
    class h implements l10.c {
        h() {
        }

        @Override // l10.c
        public void onCancel() {
            WSProfileFragment.this.X.dismiss();
        }

        @Override // l10.c
        public void onConfirm() {
            WSProfileFragment.this.X.dismiss();
            WSProfileFragment.this.T.c();
        }
    }

    /* loaded from: classes32.dex */
    class i implements k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f81267a;

        i(String str) {
            this.f81267a = str;
        }

        @Override // com.tencent.biz.pubaccount.weishi.profile.WSProfileFragment.k
        public void a(WSProfileWorksFragment wSProfileWorksFragment) {
            wSProfileWorksFragment.di(this.f81267a);
        }
    }

    /* loaded from: classes32.dex */
    class j implements k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f81269a;

        j(String str) {
            this.f81269a = str;
        }

        @Override // com.tencent.biz.pubaccount.weishi.profile.WSProfileFragment.k
        public void a(WSProfileWorksFragment wSProfileWorksFragment) {
            wSProfileWorksFragment.ci(this.f81269a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public interface k {
        void a(WSProfileWorksFragment wSProfileWorksFragment);
    }

    public static WSProfileFragment Th(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        WSProfileFragment wSProfileFragment = new WSProfileFragment();
        wSProfileFragment.setArguments(bundle2);
        return wSProfileFragment;
    }

    private WSSwipeRefreshLayout.a Yh() {
        return new c();
    }

    private com.tencent.biz.pubaccount.weishi.ui.b Zh() {
        return new e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior, com.tencent.biz.pubaccount.weishi.ui.WSBehaviorSuite$ScrollingViewBehavior] */
    private void ci() {
        this.Z.i();
        int f16 = this.Z.f();
        WSBehaviorSuite$HeaderBehavior wSBehaviorSuite$HeaderBehavior = new WSBehaviorSuite$HeaderBehavior();
        wSBehaviorSuite$HeaderBehavior.w(f16);
        wSBehaviorSuite$HeaderBehavior.v(Zh());
        ((CoordinatorLayout.LayoutParams) this.N.getLayoutParams()).setBehavior(wSBehaviorSuite$HeaderBehavior);
        ?? r16 = new CoordinatorLayout.Behavior<View>() { // from class: com.tencent.biz.pubaccount.weishi.ui.WSBehaviorSuite$ScrollingViewBehavior

            /* renamed from: g, reason: collision with root package name and from kotlin metadata */
            private View scrollableChild;

            /* renamed from: h, reason: collision with root package name and from kotlin metadata */
            private int toolbarHeight;

            private final View b(List<? extends View> dependencies) {
                for (View view : dependencies) {
                    if (g(view)) {
                        return view;
                    }
                }
                return null;
            }

            private final View d(View view) {
                if (view instanceof RecyclerView) {
                    return view;
                }
                if (!(view instanceof ViewGroup)) {
                    return null;
                }
                if (!(view instanceof ViewPager) && !(view instanceof android.support.v4.view.ViewPager)) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View d16 = d(viewGroup.getChildAt(i3));
                        if (d16 != null) {
                            return d16;
                        }
                    }
                    return null;
                }
                return d(e((ViewGroup) view));
            }

            private final View e(ViewGroup view) {
                if (view.getChildCount() == 0) {
                    return null;
                }
                if (view instanceof ViewPager) {
                    return view.getChildAt(((ViewPager) view).getCurrentItem());
                }
                if (view instanceof android.support.v4.view.ViewPager) {
                    return view.getChildAt(((android.support.v4.view.ViewPager) view).getCurrentItem());
                }
                return null;
            }

            private final boolean f(View view) {
                if (view instanceof NestedScrollView) {
                    NestedScrollView nestedScrollView = (NestedScrollView) view;
                    if (nestedScrollView.getScrollY() != nestedScrollView.getChildAt(0).getHeight() - nestedScrollView.getHeight()) {
                        return false;
                    }
                } else if ((view instanceof RecyclerView) && ((RecyclerView) view).canScrollVertically(1)) {
                    return false;
                }
                return true;
            }

            private final boolean g(View view) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                return (view instanceof LinearLayout) && (layoutParams instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof WSBehaviorSuite$HeaderBehavior);
            }

            public final void h(int height) {
                this.toolbarHeight = height;
            }

            @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
            public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(child, "child");
                Intrinsics.checkNotNullParameter(dependency, "dependency");
                return g(dependency);
            }

            @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
            public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(child, "child");
                Intrinsics.checkNotNullParameter(dependency, "dependency");
                ViewCompat.offsetTopAndBottom(child, dependency.getBottom() - child.getTop());
                return true;
            }

            @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
            public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(child, "child");
                List<View> dependencies = parent.getDependencies(child);
                Intrinsics.checkNotNullExpressionValue(dependencies, "parent.getDependencies(child)");
                View b16 = b(dependencies);
                if (b16 == null) {
                    return super.onLayoutChild(parent, child, layoutDirection);
                }
                ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
                CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                int paddingLeft = parent.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                int bottom = b16.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                child.layout(paddingLeft, bottom, child.getMeasuredWidth() + paddingLeft, child.getMeasuredHeight() + bottom);
                return true;
            }

            @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
            public boolean onMeasureChild(CoordinatorLayout parent, View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(child, "child");
                int i3 = child.getLayoutParams().height;
                if (i3 != -1 && i3 != -2) {
                    return false;
                }
                int size = View.MeasureSpec.getSize(parentHeightMeasureSpec);
                List<View> dependencies = parent.getDependencies(child);
                Intrinsics.checkNotNullExpressionValue(dependencies, "parent.getDependencies(child)");
                View b16 = b(dependencies);
                if (b16 != null) {
                    size -= b16.getMeasuredHeight() - c((ViewGroup) b16);
                }
                parent.onMeasureChild(child, parentWidthMeasureSpec, widthUsed, View.MeasureSpec.makeMeasureSpec(size, i3 == -1 ? 1073741824 : Integer.MIN_VALUE), heightUsed);
                return true;
            }

            @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
            public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
                Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
                Intrinsics.checkNotNullParameter(child, "child");
                Intrinsics.checkNotNullParameter(target, "target");
                Intrinsics.checkNotNullParameter(consumed, "consumed");
                if (f(this.scrollableChild)) {
                    return;
                }
                View view = this.scrollableChild;
                Intrinsics.checkNotNull(view);
                view.scrollBy(0, -dyUnconsumed);
                consumed[1] = dyUnconsumed;
            }

            @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
            public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int axes, int type) {
                Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
                Intrinsics.checkNotNullParameter(child, "child");
                Intrinsics.checkNotNullParameter(directTargetChild, "directTargetChild");
                Intrinsics.checkNotNullParameter(target, "target");
                this.scrollableChild = d(child);
            }

            @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
            public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int axes, int type) {
                Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
                Intrinsics.checkNotNullParameter(child, "child");
                Intrinsics.checkNotNullParameter(directTargetChild, "directTargetChild");
                Intrinsics.checkNotNullParameter(target, "target");
                return g(target) && axes == 2;
            }

            private final int c(ViewGroup header) {
                int measuredHeight;
                View childAt = header.getChildAt(0);
                if (childAt == null || (measuredHeight = childAt.getMeasuredHeight() - this.toolbarHeight) < 0) {
                    return 0;
                }
                return measuredHeight;
            }
        };
        r16.h(f16);
        ((CoordinatorLayout.LayoutParams) this.W.getLayoutParams()).setBehavior(r16);
    }

    private void ei() {
        this.S.setPresenter(Xh(false));
    }

    private void fi() {
        this.M.setProgressViewOffset(true, 0, ImmersiveUtils.getStatusBarHeight(getBaseActivity()) + ba.f81731f);
        this.M.setOnInterceptTouchEventListener(Yh());
        this.M.setOnRefreshListener(this);
    }

    private void gi() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a20.c("\u4f5c\u54c1").i(true).j(16));
        arrayList.add(new a20.c("\u8d5e").i(true).j(16));
        this.P.n0(arrayList, new f());
        this.Q = (com.tencent.biz.pubaccount.weishi.view.tab.a) this.P.z(0).f();
        this.R = (com.tencent.biz.pubaccount.weishi.view.tab.a) this.P.z(1).f();
        hi(this.Q.f());
        hi(this.R.f());
        if (this.L) {
            this.R.d(0.1f);
            this.Q.d(1.0f);
        } else {
            this.Q.c(0.1f);
            this.R.c(1.0f);
        }
    }

    private void hi(TextView textView) {
        textView.getLayoutParams().width = -2;
        textView.setHorizontallyScrolling(false);
    }

    private void ii(View view) {
        z00.b bVar = new z00.b(view);
        this.Z = bVar;
        bVar.l(((com.tencent.biz.pubaccount.weishi.profile.c) this.E).k());
        this.Z.k(((com.tencent.biz.pubaccount.weishi.profile.c) this.E).j0());
        this.Z.j(new d());
    }

    private void initViewPager() {
        this.W.addOnPageChangeListener(new g());
        ArrayList arrayList = new ArrayList();
        this.Y = arrayList;
        arrayList.add(WSProfileWorksFragment.Ph(1, getFrom()));
        this.Y.add(WSProfileWorksFragment.Ph(2, getFrom()));
        this.W.setAdapter(new com.tencent.biz.pubaccount.weishi.h(getChildFragmentManager(), this.Y));
        this.W.setCanScrollHorizontally(true);
        this.W.setScrollable(true);
        if (((com.tencent.biz.pubaccount.weishi.profile.c) this.E).S()) {
            k5();
        }
    }

    private boolean ji() {
        return this.K && this.f81257d0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi() {
        bb.O(requireContext());
        com.tencent.biz.pubaccount.weishi.profile.b.k(((com.tencent.biz.pubaccount.weishi.profile.c) this.E).q0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni() {
        if (TextUtils.isEmpty(this.f81254a0)) {
            this.f81254a0 = af.b();
        }
        z.h(requireContext(), this.f81254a0);
        com.tencent.biz.pubaccount.weishi.profile.b.n(((com.tencent.biz.pubaccount.weishi.profile.c) this.E).getFrom(), ((com.tencent.biz.pubaccount.weishi.profile.c) this.E).q0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi() {
        stShareInfo shareInfo;
        stSimpleMetaPerson person;
        String str;
        com.tencent.biz.pubaccount.weishi.profile.c presenter = getPresenter();
        if (presenter == null || (shareInfo = presenter.getShareInfo()) == null || (person = presenter.getPerson()) == null) {
            return;
        }
        j10.a aVar = new j10.a();
        aVar.f409064b = 3;
        aVar.f409063a = vi(person, shareInfo);
        aVar.f409065c = 3;
        if (presenter.r0()) {
            str = "homepage_main";
        } else {
            str = "homepage_guest";
        }
        aVar.f409067e = str;
        aVar.f409069g = "share";
        aVar.f409072j = true;
        aVar.f409073k = false;
        HashMap hashMap = new HashMap();
        hashMap.put("homepage_from", com.tencent.biz.pubaccount.weishi.profile.b.g(((com.tencent.biz.pubaccount.weishi.profile.c) this.E).getFrom()));
        aVar.f409071i = hashMap;
        az.A(this.C, aVar);
        com.tencent.biz.pubaccount.weishi.profile.b.s(presenter.getFrom(), presenter.q0());
    }

    private void pi() {
        si(new b());
    }

    public static void qi(Context context, stSimpleMetaPerson stsimplemetaperson) {
        Intent intent = new Intent();
        intent.putExtra("key_person", stsimplemetaperson);
        intent.putExtra("from", "click_avatar");
        intent.putExtra(MiniAppPlugin.ATTR_PAGE_TYPE, 2);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        PublicFragmentActivity.start(context, intent, WSProfileFragment.class);
    }

    public static void ri(Context context, String str, String str2) {
        Intent intent = new Intent();
        if (str == null) {
            str = "";
        }
        intent.putExtra("key_pid", str);
        intent.putExtra("from", str2);
        intent.putExtra(MiniAppPlugin.ATTR_PAGE_TYPE, 2);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        PublicFragmentActivity.start(context, intent, WSProfileFragment.class);
    }

    private void scrollToTop() {
        ((WSBehaviorSuite$HeaderBehavior) ((CoordinatorLayout.LayoutParams) this.N.getLayoutParams()).getBehavior()).t((LinearLayout) this.N);
    }

    private void ui() {
        this.W.setCurrentItem(0);
        si(new a());
    }

    private stSimpleMetaFeed vi(stSimpleMetaPerson stsimplemetaperson, stShareInfo stshareinfo) {
        stSimpleMetaFeed stsimplemetafeed = new stSimpleMetaFeed();
        stsimplemetafeed.share_info = stshareinfo;
        stsimplemetafeed.poster = stsimplemetaperson;
        stsimplemetafeed.poster_id = stsimplemetaperson.f25130id;
        return stsimplemetafeed;
    }

    @Override // v00.b
    public void O0(int i3, String str) {
        ToastUtil.a().e(str);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.d
    public void Oe(int i3) {
        WSProfileHeaderView wSProfileHeaderView = this.S;
        if (wSProfileHeaderView == null) {
            return;
        }
        wSProfileHeaderView.f().h(i3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.b
    /* renamed from: Uh, reason: merged with bridge method [inline-methods] */
    public com.tencent.biz.pubaccount.weishi.profile.c V() {
        return y00.c.b().a(bi(getArguments()));
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        ((com.tencent.biz.pubaccount.weishi.profile.c) this.E).b(wSSimpleBaseEvent);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.d
    public void ba(String str, boolean z16) {
        List<QBaseFragment> list = this.Y;
        if (list == null || list.size() == 0) {
            return;
        }
        ((WSProfileWorksFragment) this.Y.get(0)).ai(str, z16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.d
    public void g5() {
        if (this.X == null) {
            l10.b bVar = new l10.b(requireContext());
            this.X = bVar;
            bVar.f(new h());
        }
        if (this.X.isShowing()) {
            return;
        }
        this.X.show();
    }

    @Override // wz.c
    public ArrayList<Class> getEventClass() {
        return ((com.tencent.biz.pubaccount.weishi.profile.c) this.E).getEventClass();
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.d
    public String getFrom() {
        return ((com.tencent.biz.pubaccount.weishi.profile.c) this.E).getFrom();
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.d
    public void h2() {
        this.Z.l(((com.tencent.biz.pubaccount.weishi.profile.c) this.E).k());
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.d
    public void h6(String str) {
        si(new i(str));
    }

    @Override // v00.b
    public void hideLoading() {
        WSSwipeRefreshLayout wSSwipeRefreshLayout = this.M;
        if (wSSwipeRefreshLayout == null) {
            return;
        }
        wSSwipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.d
    public void ja(int i3) {
        WSProfileHeaderView wSProfileHeaderView = this.S;
        if (wSProfileHeaderView == null) {
            return;
        }
        wSProfileHeaderView.f().b(i3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.d
    public void k5() {
        final WSProfileWorksFragment wSProfileWorksFragment = (WSProfileWorksFragment) this.Y.get(0);
        if (wSProfileWorksFragment.getView() != null) {
            wSProfileWorksFragment.Cb();
        } else {
            this.W.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.profile.WSProfileFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    wSProfileWorksFragment.Cb();
                }
            });
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.d
    public void n(int i3) {
        WSProfileHeaderView wSProfileHeaderView = this.S;
        if (wSProfileHeaderView == null) {
            return;
        }
        wSProfileHeaderView.f().n(i3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.d
    public void nb(stSimpleMetaPerson stsimplemetaperson, boolean z16) {
        if (this.S == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.profile.header.f Xh = Xh(z16);
        this.T = Xh;
        this.S.setPresenter(Xh);
        this.T.i(stsimplemetaperson);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.d
    public void oh(String str) {
        si(new j(str));
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ba.B(configuration, "WSProfileFragment");
        com.tencent.biz.pubaccount.weishi.profile.header.d dVar = this.U;
        if (dVar != null) {
            dVar.I(configuration);
        }
        com.tencent.biz.pubaccount.weishi.profile.header.c cVar = this.V;
        if (cVar != null) {
            cVar.I(configuration);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        wz.b.b().d(this);
        ((com.tencent.biz.pubaccount.weishi.profile.c) this.E).o0(getArguments());
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        wz.b.b().f(this);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f81256c0) {
            com.tencent.biz.pubaccount.weishi.profile.b.u(((com.tencent.biz.pubaccount.weishi.profile.c) this.E).getFrom(), ((com.tencent.biz.pubaccount.weishi.profile.c) this.E).q0());
        }
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        ((com.tencent.biz.pubaccount.weishi.profile.c) this.E).l0();
        pi();
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        wh();
        if (this.f81256c0) {
            com.tencent.biz.pubaccount.weishi.profile.b.t(((com.tencent.biz.pubaccount.weishi.profile.c) this.E).getFrom(), ((com.tencent.biz.pubaccount.weishi.profile.c) this.E).q0());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f81257d0 = true;
        Vh(view);
        ii(view);
        gi();
        ei();
        ci();
        initViewPager();
        fi();
        di(view);
        if (((com.tencent.biz.pubaccount.weishi.profile.c) this.E).z()) {
            setUserVisibleHint(true);
        }
        ((com.tencent.biz.pubaccount.weishi.profile.c) this.E).W(ji());
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.d
    public void p(int i3) {
        WSProfileHeaderView wSProfileHeaderView = this.S;
        if (wSProfileHeaderView == null) {
            return;
        }
        wSProfileHeaderView.f().p(i3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.d
    public void reset() {
        this.S.f().reset();
        this.Z.m(null);
        this.M.setRefreshing(false);
        t4(0, 0, true);
        scrollToTop();
        ui();
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        if (this.f81257d0) {
            this.f81256c0 = ji();
            ((com.tencent.biz.pubaccount.weishi.profile.c) this.E).W(ji());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.d
    public void t4(int i3, int i16, boolean z16) {
        String str;
        com.tencent.biz.pubaccount.weishi.view.tab.a aVar = this.Q;
        if (aVar == null || this.R == null || aVar.f() == null || this.R.f() == null) {
            return;
        }
        this.Q.f().setText("\u4f5c\u54c1 " + ak.a(i3));
        TextView f16 = this.R.f();
        if (!((com.tencent.biz.pubaccount.weishi.profile.c) this.E).r0() && !z16) {
            str = "\u8d5e";
        } else {
            str = "\u8d5e " + ak.a(i16);
        }
        f16.setCompoundDrawables(null, null, z16 ? null : ai(), null);
        f16.setCompoundDrawablePadding(ba.f81732g);
        f16.setText(str);
        if (this.Y.size() > 0) {
            ((WSProfileWorksFragment) this.Y.get(0)).fi(i3);
            ((WSProfileWorksFragment) this.Y.get(0)).ei(true);
        }
        if (this.Y.size() > 1) {
            ((WSProfileWorksFragment) this.Y.get(1)).fi(i16);
            ((WSProfileWorksFragment) this.Y.get(1)).ei(z16);
        }
    }

    public void ti(stSimpleMetaPerson stsimplemetaperson, String str) {
        ((com.tencent.biz.pubaccount.weishi.profile.c) this.E).T(stsimplemetaperson, str);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.d
    public void x9() {
        ph(this.Z.getIsToolbarIconBlack());
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.d
    public void z4(String str) {
        this.Z.m(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wh(int i3) {
        for (int i16 = 0; i16 < this.Y.size(); i16++) {
            ActivityResultCaller activityResultCaller = (QBaseFragment) this.Y.get(i16);
            if (activityResultCaller instanceof com.tencent.biz.pubaccount.weishi.ui.a) {
                com.tencent.biz.pubaccount.weishi.ui.a aVar = (com.tencent.biz.pubaccount.weishi.ui.a) activityResultCaller;
                if (i3 == i16) {
                    aVar.Cb();
                } else {
                    aVar.Y0();
                }
            }
        }
    }

    private void si(k kVar) {
        for (int i3 = 0; i3 < this.Y.size(); i3++) {
            QBaseFragment qBaseFragment = this.Y.get(i3);
            if (qBaseFragment instanceof WSProfileWorksFragment) {
                kVar.a((WSProfileWorksFragment) qBaseFragment);
            }
        }
    }

    public void ki(boolean z16) {
        this.f81256c0 = true;
        ((com.tencent.biz.pubaccount.weishi.profile.c) this.E).u(z16);
        ((WSProfileWorksFragment) this.Y.get(0)).Cb();
        ph(this.Z.getIsToolbarIconBlack());
        com.tencent.biz.pubaccount.weishi.profile.b.t(((com.tencent.biz.pubaccount.weishi.profile.c) this.E).getFrom(), ((com.tencent.biz.pubaccount.weishi.profile.c) this.E).q0());
    }

    public void li() {
        this.f81256c0 = false;
        ph(false);
        com.tencent.biz.pubaccount.weishi.profile.b.u(((com.tencent.biz.pubaccount.weishi.profile.c) this.E).getFrom(), ((com.tencent.biz.pubaccount.weishi.profile.c) this.E).q0());
    }

    private com.tencent.biz.pubaccount.weishi.profile.header.f Xh(boolean z16) {
        if (z16) {
            if (this.U == null) {
                this.U = new com.tencent.biz.pubaccount.weishi.profile.header.d(this);
            }
            return this.U;
        }
        if (this.V == null) {
            this.V = new com.tencent.biz.pubaccount.weishi.profile.header.c(this);
        }
        return this.V;
    }

    private void Vh(View view) {
        this.S = (WSProfileHeaderView) view.findViewById(R.id.p5e);
        this.P = (WSTabLayout) view.findViewById(R.id.p6o);
        this.W = (WSViewPager) view.findViewById(R.id.f163277p90);
        this.N = view.findViewById(R.id.p4z);
        this.M = (WSSwipeRefreshLayout) view.findViewById(R.id.p6i);
    }

    private Drawable ai() {
        Drawable l3 = ba.l(R.drawable.f159772go0);
        int i3 = ba.f81736k;
        l3.setBounds(0, 0, i3, i3);
        return l3;
    }

    private void di(View view) {
        View findViewById = view.findViewById(R.id.p8v);
        findViewById.getLayoutParams().height += ImmersiveUtils.getStatusBarHeight(getContext());
        findViewById.setVisibility(8);
    }

    private int bi(Bundle bundle) {
        if (bundle == null) {
            return 2;
        }
        return bundle.getInt(MiniAppPlugin.ATTR_PAGE_TYPE, 2);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.d0v, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements WSTabLayout.e {
        f() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.view.tab.WSTabLayout.e
        public void a(com.tencent.biz.pubaccount.weishi.view.tab.a aVar) {
            if (aVar.e() == null) {
                return;
            }
            WSProfileFragment.this.W.setCurrentItem(aVar.e().d());
        }

        @Override // com.tencent.biz.pubaccount.weishi.view.tab.WSTabLayout.e
        public void b(com.tencent.biz.pubaccount.weishi.view.tab.a aVar) {
        }
    }
}
