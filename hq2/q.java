package hq2;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableColorStateList;
import hq2.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.QActivityLifecycleCallbacks;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00052\u00020\u0001:\u0002\u001d\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016\u00a8\u0006\u001f"}, d2 = {"Lhq2/q;", "Lmqq/app/QActivityLifecycleCallbacks;", "Landroid/view/View;", "root", "Landroidx/recyclerview/widget/RecyclerView;", "d", "", "searchTitle", "recyclerView", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "", "f", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "onProcessForeground", "onProcessBackground", "<init>", "()V", "a", "b", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class q implements QActivityLifecycleCallbacks {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J8\u0010\u0012\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0016H\u0002J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0002R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006%"}, d2 = {"Lhq2/q$a;", "", "Landroid/view/View;", "root", "c", "Landroid/graphics/drawable/StateListDrawable;", "stateListDrawable", "", "Lhq2/q$b;", "f", "view", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/GradientDrawable;", "solidDrawable", "drawableStateList", "src", "", "g", "drawable", "Landroid/content/res/ColorStateList;", "d", "Landroid/graphics/drawable/Drawable;", "e", "b", "", "FLASH_START_TIME", "J", "SCROLL_DELAY_TIME", "", "SCROLL_MAX_TIME", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: hq2.q$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final View c(View root) {
            View c16;
            if (!(root instanceof ViewGroup)) {
                return null;
            }
            ViewGroup viewGroup = (ViewGroup) root;
            if (viewGroup.getChildCount() <= 0) {
                return null;
            }
            if (viewGroup.getBackground() != null) {
                return root;
            }
            int childCount = viewGroup.getChildCount();
            if (childCount >= 0) {
                int i3 = 0;
                while (true) {
                    View childAt = viewGroup.getChildAt(i3);
                    if (childAt != null && (c16 = q.INSTANCE.c(childAt)) != null) {
                        return c16;
                    }
                    if (i3 == childCount) {
                        break;
                    }
                    i3++;
                }
            }
            return null;
        }

        private final ColorStateList d(GradientDrawable drawable) {
            ColorStateList c16;
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (Build.VERSION.SDK_INT >= 24) {
                c16 = com.tencent.theme.utils.a.a(drawable);
                Intrinsics.checkNotNullExpressionValue(c16, "{\n                Gradie\u2026r(drawable)\n            }");
            } else {
                c16 = com.tencent.theme.utils.a.c(constantState);
                Intrinsics.checkNotNullExpressionValue(c16, "{\n                Gradie\u2026rV23(state)\n            }");
            }
            if (c16 instanceof SkinnableColorStateList) {
                return c16;
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0082  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final List<b> f(StateListDrawable stateListDrawable) {
            DrawableContainer.DrawableContainerState drawableContainerState;
            int[][] iArr;
            int childCount;
            int stateCount;
            int[] stateSet;
            Drawable stateDrawable;
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            if (Build.VERSION.SDK_INT >= 29) {
                stateCount = stateListDrawable.getStateCount();
                while (i3 < stateCount) {
                    stateSet = stateListDrawable.getStateSet(i3);
                    Intrinsics.checkNotNullExpressionValue(stateSet, "stateListDrawable.getStateSet(i)");
                    stateDrawable = stateListDrawable.getStateDrawable(i3);
                    if (stateDrawable != null) {
                        b bVar = new b();
                        bVar.d(stateSet);
                        bVar.c(stateDrawable);
                        arrayList.add(bVar);
                    }
                    i3++;
                }
            } else {
                try {
                    Object b16 = com.tencent.biz.qui.quicommon.d.b(stateListDrawable, "android.graphics.drawable.StateListDrawable", "mStateListState", null);
                    Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type android.graphics.drawable.DrawableContainer.DrawableContainerState");
                    drawableContainerState = (DrawableContainer.DrawableContainerState) b16;
                } catch (Throwable th5) {
                    th = th5;
                    drawableContainerState = null;
                }
                try {
                    Object b17 = com.tencent.biz.qui.quicommon.d.b(drawableContainerState, "android.graphics.drawable.StateListDrawable$StateListState", "mStateSets", null);
                    Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type kotlin.Array<kotlin.IntArray?>");
                    iArr = (int[][]) b17;
                } catch (Throwable th6) {
                    th = th6;
                    QLog.e("SearchPageRouteMonitor", 1, "parseStateListDrawable exception :" + th);
                    iArr = null;
                    if (drawableContainerState != null) {
                        childCount = drawableContainerState.getChildCount();
                        while (i3 < childCount) {
                        }
                    }
                    return arrayList;
                }
                if (drawableContainerState != null && iArr != null) {
                    childCount = drawableContainerState.getChildCount();
                    while (i3 < childCount) {
                        int[] iArr2 = i3 < iArr.length ? iArr[i3] : null;
                        Drawable child = drawableContainerState.getChild(i3);
                        if (iArr2 != null && child != null) {
                            b bVar2 = new b();
                            bVar2.d(iArr2);
                            bVar2.c(child);
                            arrayList.add(bVar2);
                        }
                        i3++;
                    }
                }
            }
            return arrayList;
        }

        private final void g(final View view, Context context, final GradientDrawable solidDrawable, final List<b> drawableStateList, StateListDrawable src) {
            QLog.d("SearchPageRouteMonitor", 1, "startFlashAnimation");
            final ColorStateList d16 = d(solidDrawable);
            if (d16 == null) {
                return;
            }
            ColorStateList withAlpha = context.getColorStateList(R.color.qui_common_brand_light).withAlpha(0);
            Intrinsics.checkNotNullExpressionValue(withAlpha, "context.getColorStateLis\u2026brand_light).withAlpha(0)");
            ColorStateList colorStateList = context.getColorStateList(R.color.qui_common_brand_light);
            Intrinsics.checkNotNullExpressionValue(colorStateList, "context.getColorStateLis\u2026r.qui_common_brand_light)");
            ValueAnimator ofArgb = ValueAnimator.ofArgb(withAlpha.getDefaultColor(), colorStateList.getDefaultColor(), withAlpha.getDefaultColor(), colorStateList.getDefaultColor(), withAlpha.getDefaultColor());
            Intrinsics.checkNotNullExpressionValue(ofArgb, "ofArgb(\n                \u2026tColor,\n                )");
            ofArgb.setDuration(2000L);
            ofArgb.setInterpolator(new LinearInterpolator());
            ofArgb.addListener(new C10465a(view, src));
            ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: hq2.p
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    q.Companion.h(d16, solidDrawable, drawableStateList, view, valueAnimator);
                }
            });
            ofArgb.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(ColorStateList bottomColor, GradientDrawable solidDrawable, List drawableStateList, View view, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(bottomColor, "$bottomColor");
            Intrinsics.checkNotNullParameter(solidDrawable, "$solidDrawable");
            Intrinsics.checkNotNullParameter(drawableStateList, "$drawableStateList");
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            solidDrawable.setColor(new ColorStateList(new int[][]{new int[0]}, new int[]{com.tencent.biz.qui.quicommon.a.a(bottomColor.getDefaultColor(), ((Integer) animatedValue).intValue())}));
            StateListDrawable stateListDrawable = new StateListDrawable();
            Iterator it = drawableStateList.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.getDrawable() instanceof GradientDrawable) {
                    bVar.c(solidDrawable);
                }
                stateListDrawable.addState(bVar.getStateSet(), bVar.getDrawable());
            }
            if (view == null) {
                return;
            }
            view.setBackground(stateListDrawable);
        }

        public final void b(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            View c16 = c(view);
            if (c16 == null) {
                return;
            }
            Drawable background = c16.getBackground();
            if (!(background instanceof StateListDrawable)) {
                QLog.e("SearchPageRouteMonitor", 1, "checkAndStartAnimation background is not StateListDrawable");
                return;
            }
            StateListDrawable stateListDrawable = (StateListDrawable) background;
            List<b> f16 = f(stateListDrawable);
            for (b bVar : f16) {
                if (bVar.getDrawable() instanceof GradientDrawable) {
                    GradientDrawable gradientDrawable = (GradientDrawable) e(bVar.getDrawable());
                    if (gradientDrawable == null) {
                        QLog.e("SearchPageRouteMonitor", 1, "tintStateListDrawable ");
                        return;
                    }
                    Context context = c16.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "backgroundView.context");
                    g(c16, context, gradientDrawable, f16, stateListDrawable);
                    return;
                }
            }
        }

        Companion() {
        }

        private final Drawable e(Drawable drawable) {
            Drawable drawable2;
            if (drawable == null) {
                return null;
            }
            if (drawable instanceof SkinnableBitmapDrawable) {
                drawable2 = ((SkinnableBitmapDrawable) drawable).mutate2();
            } else {
                if (drawable.getConstantState() != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    Drawable newDrawable = constantState != null ? constantState.newDrawable() : null;
                    if (newDrawable != null) {
                        drawable2 = newDrawable.mutate();
                    }
                }
                drawable2 = null;
            }
            if (drawable2 == null || drawable2 == drawable || drawable2.getConstantState() == drawable.getConstantState()) {
                return null;
            }
            return drawable2;
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"hq2/q$a$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: hq2.q$a$a, reason: collision with other inner class name */
        /* loaded from: classes38.dex */
        public static final class C10465a implements Animator.AnimatorListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f405935d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ StateListDrawable f405936e;

            C10465a(View view, StateListDrawable stateListDrawable) {
                this.f405935d = view;
                this.f405936e = stateListDrawable;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                View view = this.f405935d;
                if (view == null) {
                    return;
                }
                view.setBackground(this.f405936e);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lhq2/q$b;", "", "", "a", "[I", "b", "()[I", "d", "([I)V", "stateSet", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "c", "(Landroid/graphics/drawable/Drawable;)V", "drawable", "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int[] stateSet;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private Drawable drawable;

        /* renamed from: a, reason: from getter */
        public final Drawable getDrawable() {
            return this.drawable;
        }

        /* renamed from: b, reason: from getter */
        public final int[] getStateSet() {
            return this.stateSet;
        }

        public final void c(Drawable drawable) {
            this.drawable = drawable;
        }

        public final void d(int[] iArr) {
            this.stateSet = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J0\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"hq2/q$c", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "", "dx", "calculateTimeForScrolling", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateDtToFit", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c extends LinearSmoothScroller {
        c(BaseApplication baseApplication) {
            super(baseApplication);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int dx5) {
            int calculateTimeForScrolling = super.calculateTimeForScrolling(dx5) * 2;
            QLog.d("SearchPageRouteMonitor", 2, "calculateTimeForScrolling :" + calculateTimeForScrolling);
            if (calculateTimeForScrolling > 200) {
                return 200;
            }
            return calculateTimeForScrolling;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
            return ((boxStart + boxEnd) / 2) - ((viewStart + viewEnd) / 2);
        }
    }

    private final RecyclerView d(View root) {
        RecyclerView d16;
        if (!(root instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) root;
        if (viewGroup.getChildCount() <= 0) {
            return null;
        }
        if (root instanceof RecyclerView) {
            QLog.d("SearchPageRouteMonitor", 2, "found recycle view");
            RecyclerView recyclerView = (RecyclerView) root;
            if (recyclerView.getAdapter() instanceof QUIListItemAdapter) {
                QLog.d("SearchPageRouteMonitor", 2, "found findQUIListView");
                return recyclerView;
            }
        }
        int childCount = viewGroup.getChildCount();
        if (childCount >= 0) {
            int i3 = 0;
            while (true) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != null && (d16 = d(childAt)) != null) {
                    return d16;
                }
                if (i3 == childCount) {
                    break;
                }
                i3++;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Activity activity, q this$0, String str) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = true;
        QLog.d("SearchPageRouteMonitor", 1, "onActivityResumed class name: " + activity);
        Window window = activity.getWindow();
        RecyclerView d16 = this$0.d(window != null ? window.getDecorView() : null);
        if (d16 != null) {
            if (str != null && str.length() != 0) {
                z16 = false;
            }
            if (z16) {
                return;
            }
            Intent intent = activity.getIntent();
            if (intent != null) {
                intent.putExtra("setting_search_title", "");
            }
            RecyclerView.Adapter adapter = d16.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.widget.listitem.QUIListItemAdapter");
            this$0.f(str, d16, (QUIListItemAdapter) adapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "$pair");
        View i3 = ((com.tencent.mobileqq.widget.listitem.a) pair.getSecond()).i();
        if (i3 != null) {
            INSTANCE.b(i3);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = activity.getIntent();
        final String stringExtra = intent != null ? intent.getStringExtra("setting_search_title") : null;
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: hq2.k
            @Override // java.lang.Runnable
            public final void run() {
                q.e(activity, this, stringExtra);
            }
        }, 400L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    private final void f(String searchTitle, RecyclerView recyclerView, QUIListItemAdapter adapter) {
        RecyclerView.LayoutManager layoutManager;
        final Pair<Integer, com.tencent.mobileqq.widget.listitem.a<?>> k06 = adapter != null ? adapter.k0(searchTitle) : null;
        if (k06 != null) {
            c cVar = new c(BaseApplication.context);
            cVar.setTargetPosition(k06.getFirst().intValue());
            if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
                layoutManager.startSmoothScroll(cVar);
            }
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: hq2.l
                @Override // java.lang.Runnable
                public final void run() {
                    q.g(Pair.this);
                }
            }, 300L);
        }
    }

    @Override // mqq.app.QActivityLifecycleCallbacks
    public void onProcessBackground() {
    }

    @Override // mqq.app.QActivityLifecycleCallbacks
    public void onProcessForeground() {
    }
}
