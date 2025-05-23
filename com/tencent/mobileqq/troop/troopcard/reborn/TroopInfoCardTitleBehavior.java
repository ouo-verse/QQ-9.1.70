package com.tencent.mobileqq.troop.troopcard.reborn;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.am;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0017\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/TroopInfoCardTitleBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Landroid/view/View;", "child", "", "isCollapsed", "", "d", "g", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "layoutDirection", "onLayoutChild", "dependency", "layoutDependsOn", "onDependentViewChanged", "Z", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "backBtn", "i", "moreBtn", "Landroid/widget/TextView;", "j", "Landroid/widget/TextView;", "troopNameNavTv", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "k", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "collapsingToolbarLayout", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "l", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopInfoCardTitleBehavior extends CoordinatorLayout.Behavior<View> {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: m, reason: collision with root package name */
    private static final int f299493m;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isCollapsed;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView backBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView moreBtn;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView troopNameNavTv;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CollapsingToolbarLayout collapsingToolbarLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/TroopInfoCardTitleBehavior$a;", "", "", "ANIMATION_DURATION", "J", "", "TAG", "Ljava/lang/String;", "", "TOGGLE_TITLE_BAR_MIN_OFFSET", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.TroopInfoCardTitleBehavior$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56980);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
            f299493m = am.a(-50.0f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopInfoCardTitleBehavior(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attrs);
        }
    }

    private final void d(View child, boolean isCollapsed) {
        int i3;
        int color;
        int i16;
        float f16;
        QLog.i("TroopInfoCardTitleBehavior", 1, "animateChanges isCollapsed=" + isCollapsed);
        if (isCollapsed) {
            i3 = R.drawable.skin_header_bar_bg;
        } else {
            i3 = R.drawable.kyv;
        }
        int i17 = -1;
        if (isCollapsed) {
            color = -1;
        } else {
            color = child.getResources().getColor(R.color.skin_bar_text);
        }
        if (isCollapsed) {
            i17 = child.getResources().getColor(R.color.skin_bar_text);
        }
        if (isCollapsed) {
            i16 = 0;
        } else {
            i16 = R.drawable.kyt;
        }
        float f17 = 0.0f;
        if (isCollapsed) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        if (isCollapsed) {
            f17 = 1.0f;
        }
        ImageView imageView = this.backBtn;
        if (imageView != null) {
            imageView.setBackgroundResource(i16);
        }
        ImageView imageView2 = this.moreBtn;
        if (imageView2 != null) {
            imageView2.setBackgroundResource(i16);
        }
        child.setBackgroundResource(i3);
        child.setPadding(am.a(16.0f), ImmersiveUtils.getStatusBarHeight(child.getContext()), am.a(16.0f), 0);
        ValueAnimator ofArgb = ValueAnimator.ofArgb(color, i17);
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TroopInfoCardTitleBehavior.e(TroopInfoCardTitleBehavior.this, valueAnimator);
            }
        });
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f16, f17);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TroopInfoCardTitleBehavior.f(TroopInfoCardTitleBehavior.this, valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofArgb, ofFloat);
        animatorSet.setDuration(300L);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(TroopInfoCardTitleBehavior this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.backBtn;
        if (imageView != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            imageView.setColorFilter(((Integer) animatedValue).intValue());
        }
        ImageView imageView2 = this$0.moreBtn;
        if (imageView2 != null) {
            Object animatedValue2 = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Int");
            imageView2.setColorFilter(((Integer) animatedValue2).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(TroopInfoCardTitleBehavior this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.troopNameNavTv;
        if (textView != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            textView.setAlpha(((Float) animatedValue).floatValue());
        }
    }

    private final void g(View child) {
        child.setBackgroundColor(0);
        ImageView imageView = this.backBtn;
        if (imageView != null) {
            imageView.setBackgroundResource(R.drawable.kyt);
        }
        ImageView imageView2 = this.moreBtn;
        if (imageView2 != null) {
            imageView2.setBackgroundResource(R.drawable.kyt);
        }
        ImageView imageView3 = this.backBtn;
        if (imageView3 != null) {
            imageView3.setColorFilter(-1);
        }
        ImageView imageView4 = this.moreBtn;
        if (imageView4 != null) {
            imageView4.setColorFilter(-1);
        }
        TextView textView = this.troopNameNavTv;
        if (textView != null) {
            textView.setAlpha(0.0f);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(@NotNull CoordinatorLayout parent, @NotNull View child, @NotNull View dependency) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, parent, child, dependency)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        return dependency instanceof AppBarLayout;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(@NotNull CoordinatorLayout parent, @NotNull View child, @NotNull View dependency) {
        AppBarLayout appBarLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, parent, child, dependency)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        if (dependency instanceof AppBarLayout) {
            appBarLayout = (AppBarLayout) dependency;
        } else {
            appBarLayout = null;
        }
        if (appBarLayout == null) {
            return false;
        }
        float y16 = appBarLayout.getY();
        int i3 = f299493m;
        if (y16 <= i3 && !this.isCollapsed) {
            this.isCollapsed = true;
            d(child, true);
        } else if (y16 > i3 && this.isCollapsed) {
            this.isCollapsed = false;
            d(child, false);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NotNull CoordinatorLayout parent, @NotNull View child, int layoutDirection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, parent, child, Integer.valueOf(layoutDirection))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (this.backBtn == null || this.moreBtn == null || this.collapsingToolbarLayout == null || this.troopNameNavTv == null) {
            this.backBtn = (ImageView) child.findViewById(R.id.a47);
            this.moreBtn = (ImageView) child.findViewById(R.id.ezy);
            this.troopNameNavTv = (TextView) child.findViewById(R.id.f102925z8);
            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) parent.findViewById(R.id.u0k);
            this.collapsingToolbarLayout = collapsingToolbarLayout;
            if (collapsingToolbarLayout != null) {
                collapsingToolbarLayout.setMinimumHeight(am.a(44.0f) + ImmersiveUtils.getStatusBarHeight(parent.getContext()));
            }
            g(child);
            QLog.i("TroopInfoCardTitleBehavior", 1, "onLayoutChild, initView");
        }
        return super.onLayoutChild(parent, child, layoutDirection);
    }
}
