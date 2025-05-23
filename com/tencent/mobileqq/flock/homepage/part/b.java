package com.tencent.mobileqq.flock.homepage.part;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/flock/homepage/part/b;", "Lcom/tencent/mobileqq/flock/base/b;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "action", "", "args", "handleBroadcastMessage", "Lcom/google/android/material/tabs/TabLayout;", "d", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "Landroidx/viewpager2/widget/ViewPager2;", "e", "Landroidx/viewpager2/widget/ViewPager2;", "pager", "<init>", "()V", "f", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b extends com.tencent.mobileqq.flock.base.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TabLayout tabLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 pager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/flock/homepage/part/b$a;", "", "", "ACTION_MSG_INIT", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.homepage.part.b$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/flock/homepage/part/b$b", "Lcom/google/android/material/tabs/TabLayout$d;", "Lcom/google/android/material/tabs/TabLayout$g;", "tab", "", "onTabSelected", "onTabUnselected", "onTabReselected", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.homepage.part.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C7606b implements TabLayout.d {
        static IPatchRedirector $redirector_;

        C7606b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(@Nullable TabLayout.g tab) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) tab);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(@Nullable TabLayout.g tab) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) tab);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(@Nullable TabLayout.g tab) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) tab);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46472);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z9(TabLayout.g tab, int i3) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        if (i3 != 0) {
            if (i3 == 1) {
                tab.t("\u53c2\u4e0e");
                return;
            }
            return;
        }
        tab.t("\u53d1\u5e03");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) action, args);
            return;
        }
        if (Intrinsics.areEqual(action, "ACTION_MSG_INIT")) {
            TabLayout tabLayout = this.tabLayout;
            ViewPager2 viewPager2 = null;
            if (tabLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                tabLayout = null;
            }
            tabLayout.setVisibility(0);
            ViewPager2 viewPager22 = this.pager;
            if (viewPager22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pager");
                viewPager22 = null;
            }
            viewPager22.setVisibility(0);
            if (args instanceof Integer) {
                ViewPager2 viewPager23 = this.pager;
                if (viewPager23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pager");
                } else {
                    viewPager2 = viewPager23;
                }
                viewPager2.setCurrentItem(((Number) args).intValue() - 1, false);
                return;
            }
            QLog.e("FlockHomePageBodyPart", 1, "handleBroadcastMessage error:" + args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.f915855k);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tabLayout)");
            this.tabLayout = (TabLayout) findViewById;
            View findViewById2 = rootView.findViewById(R.id.fho);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.pager)");
            this.pager = (ViewPager2) findViewById2;
        }
        ViewPager2 viewPager2 = this.pager;
        TabLayout tabLayout = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
            viewPager2 = null;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        viewPager2.setAdapter(new com.tencent.mobileqq.flock.homepage.adapter.a((FragmentActivity) activity));
        TabLayout tabLayout2 = this.tabLayout;
        if (tabLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayout2 = null;
        }
        ViewPager2 viewPager22 = this.pager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
            viewPager22 = null;
        }
        new com.google.android.material.tabs.d(tabLayout2, viewPager22, new d.b() { // from class: com.tencent.mobileqq.flock.homepage.part.a
            @Override // com.google.android.material.tabs.d.b
            public final void a(TabLayout.g gVar, int i3) {
                b.z9(gVar, i3);
            }
        }).a();
        TabLayout tabLayout3 = this.tabLayout;
        if (tabLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        } else {
            tabLayout = tabLayout3;
        }
        tabLayout.f(new C7606b());
    }
}
