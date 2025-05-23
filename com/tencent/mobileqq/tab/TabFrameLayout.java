package com.tencent.mobileqq.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2Util;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.cv;
import com.tencent.mobileqq.utils.ei;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import com.tencent.mobileqq.widget.QQTabLayout;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001\nB\u0019\u0012\u0006\u00105\u001a\u000204\u0012\b\u00107\u001a\u0004\u0018\u000106\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0014J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J0\u0010!\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0014R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/tab/TabFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/app/FrameFragment$c;", "", "onFinishInflate", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/view/View;", "a", "Lcom/tencent/mobileqq/fpsreport/a;", "l", "setOnDrawCompleteListener", "setFirstDrawTrue", "Lcom/tencent/mobileqq/app/FrameFragment;", "frameFragment", ColorRingJsPlugin.Method_SetUp, "Lcom/tencent/mobileqq/app/FrameFragment$e;", "tabSpec", "c", "jumpIndex", "b", "clearAllTabs", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "", "changed", "left", "top", "right", "bottom", "onLayout", "Landroidx/viewpager2/widget/ViewPager2;", "d", "Landroidx/viewpager2/widget/ViewPager2;", "mViewPager2", "Lcom/tencent/mobileqq/widget/QQTabLayout;", "e", "Lcom/tencent/mobileqq/widget/QQTabLayout;", "mTabLayout", "Lcom/tencent/mobileqq/activity/home/impl/e;", "f", "Lcom/tencent/mobileqq/activity/home/impl/e;", "mViewAdapter2", h.F, "Lcom/tencent/mobileqq/fpsreport/a;", "onDrawCompleteListener", "i", "Z", "isFirstDraw", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "QQActivity_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TabFrameLayout extends FrameLayout implements FrameFragment.c {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 mViewPager2;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QQTabLayout mTabLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.activity.home.impl.e mViewAdapter2;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.fpsreport.a onDrawCompleteListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstDraw;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/tab/TabFrameLayout$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "QQActivity_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tab.TabFrameLayout$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33244);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            setWillNotDraw(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(TabFrameLayout this$0, TabLayout.g tab, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        com.tencent.mobileqq.activity.home.impl.e eVar = this$0.mViewAdapter2;
        ViewGroup.LayoutParams layoutParams = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewAdapter2");
            eVar = null;
        }
        com.tencent.mobileqq.activity.home.impl.c l06 = eVar.l0(i3);
        tab.s(l06.k().getName());
        View e16 = tab.e();
        if (e16 != null) {
            ab.c(e16);
        }
        com.tencent.mobileqq.activity.home.impl.e eVar2 = this$0.mViewAdapter2;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewAdapter2");
            eVar2 = null;
        }
        String m3 = l06.m();
        Intrinsics.checkNotNullExpressionValue(m3, "bean.key");
        View k06 = eVar2.k0(m3);
        if (k06 != null) {
            layoutParams = k06.getLayoutParams();
        }
        if (layoutParams == null && k06 != null) {
            k06.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        }
        tab.p(k06);
        QLog.i("FrameUtil.TabFrameLayout", 1, "handleTabByConfig position=" + i3 + ", bean" + l06.m() + ", tab=" + tab + ", customView=" + tab.e());
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.c
    @NotNull
    public View a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ViewPager2 viewPager2 = this.mViewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            return null;
        }
        return viewPager2;
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.c
    public void b(int jumpIndex) {
        QQTabLayout qQTabLayout;
        ViewPager2 viewPager2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, jumpIndex);
            return;
        }
        QLog.i("FrameUtil.TabFrameLayout", 1, "handleTabByConfig jumpIndex:" + jumpIndex);
        ViewPager2 viewPager22 = this.mViewPager2;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager22 = null;
        }
        com.tencent.mobileqq.activity.home.impl.e eVar = this.mViewAdapter2;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewAdapter2");
            eVar = null;
        }
        viewPager22.setAdapter(eVar);
        ViewPager2 viewPager23 = this.mViewPager2;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager23 = null;
        }
        viewPager23.setUserInputEnabled(false);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tab_layout_9060_124373182", true)) {
            ViewPager2 viewPager24 = this.mViewPager2;
            if (viewPager24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
                viewPager24 = null;
            }
            ViewPager2Util.interceptAccessibility(viewPager24);
        }
        d.b bVar = new d.b() { // from class: com.tencent.mobileqq.tab.f
            @Override // com.google.android.material.tabs.d.b
            public final void a(TabLayout.g gVar, int i3) {
                TabFrameLayout.e(TabFrameLayout.this, gVar, i3);
            }
        };
        com.tencent.mobileqq.activity.home.impl.e eVar2 = this.mViewAdapter2;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewAdapter2");
            eVar2 = null;
        }
        int num_backgournd_icon = eVar2.getNUM_BACKGOURND_ICON();
        for (int i3 = 0; i3 < num_backgournd_icon; i3++) {
            TabLayout.g gVar = new TabLayout.g();
            gVar.p(new View(getContext()));
            QQTabLayout qQTabLayout2 = this.mTabLayout;
            if (qQTabLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
                qQTabLayout2 = null;
            }
            qQTabLayout2.L(gVar);
        }
        ViewPager2 viewPager25 = this.mViewPager2;
        if (viewPager25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager25 = null;
        }
        viewPager25.setCurrentItem(jumpIndex);
        QQTabLayout qQTabLayout3 = this.mTabLayout;
        if (qQTabLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            qQTabLayout = null;
        } else {
            qQTabLayout = qQTabLayout3;
        }
        ViewPager2 viewPager26 = this.mViewPager2;
        if (viewPager26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager2");
            viewPager2 = null;
        } else {
            viewPager2 = viewPager26;
        }
        new com.google.android.material.tabs.d(qQTabLayout, viewPager2, true, false, bVar).a();
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.c
    public void c(@NotNull FrameFragment.e tabSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) tabSpec);
            return;
        }
        Intrinsics.checkNotNullParameter(tabSpec, "tabSpec");
        com.tencent.mobileqq.activity.home.impl.e eVar = this.mViewAdapter2;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewAdapter2");
            eVar = null;
        }
        eVar.i0((g) tabSpec);
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.c
    public void clearAllTabs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QLog.i("FrameUtil.TabFrameLayout", 1, "clearAllTabs  this:" + System.identityHashCode(this) + ", " + Log.getStackTraceString(new Throwable()));
        QQTabLayout qQTabLayout = this.mTabLayout;
        com.tencent.mobileqq.activity.home.impl.e eVar = null;
        if (qQTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            qQTabLayout = null;
        }
        qQTabLayout.M();
        com.tencent.mobileqq.activity.home.impl.e eVar2 = this.mViewAdapter2;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewAdapter2");
        } else {
            eVar = eVar2;
        }
        eVar.j0();
    }

    @Override // android.view.View
    public void draw(@Nullable Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) canvas);
            return;
        }
        if (this.isFirstDraw) {
            ei.a(null, "Recent_Draw");
        }
        cv.d("TabFrameLayout draw start.");
        super.draw(canvas);
        cv.d("TabFrameLayout draw end.");
        if (this.isFirstDraw) {
            this.isFirstDraw = false;
            ei.a("Recent_Draw", null);
            com.tencent.mobileqq.fpsreport.a aVar = this.onDrawCompleteListener;
            if (aVar != null) {
                Intrinsics.checkNotNull(aVar);
                aVar.onDrawComplete();
            }
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onFinishInflate();
        View findViewById = findViewById(R.id.f919256h);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tab_view_pager2)");
        this.mViewPager2 = (ViewPager2) findViewById;
        View findViewById2 = findViewById(R.id.f917355z);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tab_layout_indicator)");
        this.mTabLayout = (QQTabLayout) findViewById2;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
            return;
        }
        if (this.isFirstDraw) {
            ei.a(null, "Recent_OnLayout");
        }
        cv.d("TabFrameLayout onLayout start.");
        super.onLayout(changed, left, top, right, bottom);
        cv.d("TabFrameLayout onLayout end.");
        if (this.isFirstDraw) {
            ei.a("Recent_OnLayout", null);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        cv.d("TabFrameLayout onMeasure start.");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        cv.d("TabFrameLayout onMeasure end.");
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.c
    public void setFirstDrawTrue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.isFirstDraw = true;
        }
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.c
    public void setOnDrawCompleteListener(@NotNull com.tencent.mobileqq.fpsreport.a l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) l3);
        } else {
            Intrinsics.checkNotNullParameter(l3, "l");
            this.onDrawCompleteListener = l3;
        }
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.c
    public void setup(@NotNull FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) frameFragment);
            return;
        }
        Intrinsics.checkNotNullParameter(frameFragment, "frameFragment");
        QLog.i("FrameUtil.TabFrameLayout", 1, ColorRingJsPlugin.Method_SetUp);
        this.mViewAdapter2 = new com.tencent.mobileqq.activity.home.impl.e(frameFragment);
    }
}
