package com.tencent.mobileqq.ai;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ai.main.AIAvatarMainFragment;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/ai/h;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "d", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "tabBar", "Lcom/tencent/mobileqq/widget/ViewPagerCompat;", "e", "Lcom/tencent/mobileqq/widget/ViewPagerCompat;", "viewPager", "<init>", "()V", "f", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class h extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final String[] f187666h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final Class<? extends QBaseFragment>[] f187667i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUIPageTabBar tabBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewPagerCompat viewPager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/ai/h$a;", "", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "TAB_FRAGMENT", "[Ljava/lang/Class;", "", "TAB_TITLE", "[Ljava/lang/String;", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ai.h$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/ai/h$b", "Landroidx/fragment/app/FragmentPagerAdapter;", "", "getCount", "position", "Landroidx/fragment/app/Fragment;", "getItem", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends FragmentPagerAdapter {
        static IPatchRedirector $redirector_;

        b(FragmentManager fragmentManager) {
            super(fragmentManager);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragmentManager);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return h.f187666h.length;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        @NotNull
        public Fragment getItem(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Fragment) iPatchRedirector.redirect((short) 3, (Object) this, position);
            }
            Object newInstance = h.f187667i[position].newInstance();
            Intrinsics.checkNotNullExpressionValue(newInstance, "TAB_FRAGMENT[position].newInstance()");
            return (Fragment) newInstance;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21533);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        f187666h = new String[]{"AI\u5934\u50cf", "\u4e2a\u6027\u5934\u50cf", "\u5934\u50cf\u6302\u4ef6"};
        f187667i = new Class[]{AIAvatarMainFragment.class, AIAvatarPersonalFragment.class, AIAvatarPendantFragment.class};
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c cVar = c.f187660a;
        QUIPageTabBar qUIPageTabBar = this$0.tabBar;
        if (qUIPageTabBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            qUIPageTabBar = null;
        }
        cVar.c(qUIPageTabBar);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.sfp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.ai_avatar_tab_bar)");
        this.tabBar = (QUIPageTabBar) findViewById;
        View findViewById2 = rootView.findViewById(R.id.sfr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.ai_avatar_view_pager)");
        ViewPagerCompat viewPagerCompat = (ViewPagerCompat) findViewById2;
        this.viewPager = viewPagerCompat;
        QUIPageTabBar qUIPageTabBar = null;
        if (viewPagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPagerCompat = null;
        }
        viewPagerCompat.setScrollable(false);
        ViewPagerCompat viewPagerCompat2 = this.viewPager;
        if (viewPagerCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPagerCompat2 = null;
        }
        String[] strArr = f187666h;
        viewPagerCompat2.setOffscreenPageLimit(strArr.length);
        QUIPageTabBar qUIPageTabBar2 = this.tabBar;
        if (qUIPageTabBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            qUIPageTabBar2 = null;
        }
        qUIPageTabBar2.setCheckedColor(ie0.a.f().h(getContext(), R.color.qui_common_brand_standard, 1000));
        QUIPageTabBar qUIPageTabBar3 = this.tabBar;
        if (qUIPageTabBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            qUIPageTabBar3 = null;
        }
        qUIPageTabBar3.setTabData(strArr);
        ViewPagerCompat viewPagerCompat3 = this.viewPager;
        if (viewPagerCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPagerCompat3 = null;
        }
        viewPagerCompat3.setAdapter(new b(getHostFragment().getChildFragmentManager()));
        QUIPageTabBar qUIPageTabBar4 = this.tabBar;
        if (qUIPageTabBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            qUIPageTabBar4 = null;
        }
        ViewPagerCompat viewPagerCompat4 = this.viewPager;
        if (viewPagerCompat4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPagerCompat4 = null;
        }
        qUIPageTabBar4.setViewPager(viewPagerCompat4);
        QUIPageTabBar qUIPageTabBar5 = this.tabBar;
        if (qUIPageTabBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
        } else {
            qUIPageTabBar = qUIPageTabBar5;
        }
        qUIPageTabBar.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ai.g
            @Override // java.lang.Runnable
            public final void run() {
                h.B9(h.this);
            }
        }, 200L);
    }
}
