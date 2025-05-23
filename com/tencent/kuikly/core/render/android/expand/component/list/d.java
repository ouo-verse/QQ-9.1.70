package com.tencent.kuikly.core.render.android.expand.component.list;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 .2\u00020\u0001:\u0002\u000f\u000eB*\u0012!\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00110'\u00a2\u0006\u0004\b1\u00102J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tH\u0002J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tH\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\u001b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010!R\u0014\u0010$\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010#R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010%R/\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00110'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010+R\u0016\u00100\u001a\u0004\u0018\u00010-8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/list/d;", "Landroidx/recyclerview/widget/SnapHelper;", "", "velocityX", "velocityY", "", "i", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "Landroid/view/View;", "d", "", "c", "targetView", "b", "a", "isForwardFling", "", tl.h.F, "e", "view", "g", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "attachToRecyclerView", "calculateDistanceToFinalSnap", "findSnapView", "findTargetSnapPosition", "onFling", "Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView;", "Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView;", "krRecyclerView", "Lcom/tencent/kuikly/core/render/android/expand/component/list/d$b;", "Lcom/tencent/kuikly/core/render/android/expand/component/list/d$b;", "scroller", "[I", "distanceToFinalSnap", "I", "currentPageIndex", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "Lkotlin/jvm/functions/Function1;", "pageIndexChangeBlock", "Landroid/view/ViewGroup;", "f", "()Landroid/view/ViewGroup;", "hrContentView", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class d extends SnapHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private KRRecyclerView krRecyclerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private b scroller;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int[] distanceToFinalSnap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int currentPageIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function1<Integer, Unit> pageIndexChangeBlock;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/list/d$b;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "", "dx", "dy", "b", "Landroid/view/animation/DecelerateInterpolator;", "a", "Landroid/util/DisplayMetrics;", "displayMetrics", "", "calculateSpeedPerPixel", "calculateTimeForScrolling", "Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView;", "mRecyclerView", "<init>", "(Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView;)V", "c", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b extends LinearSmoothScroller {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull KRRecyclerView mRecyclerView) {
            super(mRecyclerView.getContext());
            Intrinsics.checkNotNullParameter(mRecyclerView, "mRecyclerView");
        }

        @NotNull
        public final DecelerateInterpolator a() {
            DecelerateInterpolator mDecelerateInterpolator = this.mDecelerateInterpolator;
            Intrinsics.checkNotNullExpressionValue(mDecelerateInterpolator, "mDecelerateInterpolator");
            return mDecelerateInterpolator;
        }

        public final int b(int dx5, int dy5) {
            int coerceAtLeast;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(Math.abs(dx5), Math.abs(dy5));
            return calculateTimeForDeceleration(coerceAtLeast);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(@NotNull DisplayMetrics displayMetrics) {
            Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
            return 100.0f / displayMetrics.densityDpi;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int dx5) {
            return Math.min(100, super.calculateTimeForScrolling(dx5));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull Function1<? super Integer, Unit> pageIndexChangeBlock) {
        Intrinsics.checkNotNullParameter(pageIndexChangeBlock, "pageIndexChangeBlock");
        this.pageIndexChangeBlock = pageIndexChangeBlock;
        this.distanceToFinalSnap = new int[2];
    }

    private final int a(RecyclerView.LayoutManager layoutManager, View targetView) {
        return g(targetView, layoutManager) - e(layoutManager);
    }

    private final int[] b(View targetView, RecyclerView.LayoutManager layoutManager) {
        int a16 = a(layoutManager, targetView);
        if (layoutManager.canScrollVertically()) {
            int[] iArr = this.distanceToFinalSnap;
            iArr[0] = 0;
            iArr[1] = a16;
        } else {
            int[] iArr2 = this.distanceToFinalSnap;
            iArr2[0] = a16;
            iArr2[1] = 0;
        }
        return this.distanceToFinalSnap;
    }

    private final int[] c(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
        int findTargetSnapPosition = findTargetSnapPosition(layoutManager, velocityX, velocityY);
        if (layoutManager.canScrollVertically()) {
            int[] iArr = this.distanceToFinalSnap;
            iArr[0] = 0;
            iArr[1] = findTargetSnapPosition;
        } else {
            int[] iArr2 = this.distanceToFinalSnap;
            iArr2[0] = findTargetSnapPosition;
            iArr2[1] = 0;
        }
        return this.distanceToFinalSnap;
    }

    private final View d(RecyclerView.LayoutManager layoutManager) {
        ViewGroup f16 = f();
        View view = null;
        if (f16 != null && f16.getChildCount() != 0) {
            int e16 = e(layoutManager);
            int childCount = f16.getChildCount();
            int i3 = Integer.MAX_VALUE;
            for (int i16 = 0; i16 < childCount; i16++) {
                View child = f16.getChildAt(i16);
                Intrinsics.checkNotNullExpressionValue(child, "child");
                int abs = Math.abs(g(child, layoutManager) - e16);
                if (abs < i3) {
                    view = child;
                    i3 = abs;
                }
            }
        }
        return view;
    }

    private final int e(RecyclerView.LayoutManager layoutManager) {
        int h16;
        int left;
        KRRecyclerView kRRecyclerView = this.krRecyclerView;
        ViewGroup f16 = f();
        if (kRRecyclerView != null && f16 != null) {
            if (layoutManager.canScrollVertically()) {
                h16 = com.tencent.kuikly.core.render.android.css.ktx.b.g(kRRecyclerView) / 2;
                left = f16.getTop();
            } else {
                h16 = com.tencent.kuikly.core.render.android.css.ktx.b.h(kRRecyclerView) / 2;
                left = f16.getLeft();
            }
            return h16 + (-left);
        }
        return 0;
    }

    private final ViewGroup f() {
        View view;
        KRRecyclerView kRRecyclerView = this.krRecyclerView;
        View view2 = null;
        if (kRRecyclerView != null) {
            view = kRRecyclerView.getChildAt(0);
        } else {
            view = null;
        }
        if (view instanceof ViewGroup) {
            view2 = view;
        }
        return (ViewGroup) view2;
    }

    private final int g(View view, RecyclerView.LayoutManager layoutManager) {
        int h16;
        int left;
        if (layoutManager.canScrollVertically()) {
            h16 = com.tencent.kuikly.core.render.android.css.ktx.b.g(view) / 2;
            left = view.getTop();
        } else {
            h16 = com.tencent.kuikly.core.render.android.css.ktx.b.h(view) / 2;
            left = view.getLeft();
        }
        return h16 + left;
    }

    private final void h(View targetView, RecyclerView.LayoutManager layoutManager) {
        int left;
        int h16;
        boolean canScrollVertically = layoutManager.canScrollVertically();
        if (canScrollVertically) {
            left = targetView.getTop();
        } else {
            left = targetView.getLeft();
        }
        if (canScrollVertically) {
            h16 = com.tencent.kuikly.core.render.android.css.ktx.b.g(targetView);
        } else {
            h16 = com.tencent.kuikly.core.render.android.css.ktx.b.h(targetView);
        }
        int i3 = left / h16;
        if (i3 != this.currentPageIndex) {
            this.pageIndexChangeBlock.invoke(Integer.valueOf(i3));
            this.currentPageIndex = i3;
        }
    }

    private final boolean i(int velocityX, int velocityY) {
        RecyclerView.LayoutManager layoutManager;
        int i3;
        DecelerateInterpolator decelerateInterpolator;
        KRRecyclerView kRRecyclerView = this.krRecyclerView;
        if (kRRecyclerView == null || (layoutManager = kRRecyclerView.getLayoutManager()) == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(layoutManager, "krRecyclerView?.layoutManager ?: return false");
        int[] c16 = c(layoutManager, velocityX, velocityY);
        b bVar = this.scroller;
        if (bVar != null) {
            i3 = bVar.b(c16[0], c16[1]);
        } else {
            i3 = Integer.MIN_VALUE;
        }
        b bVar2 = this.scroller;
        if (bVar2 != null) {
            decelerateInterpolator = bVar2.a();
        } else {
            decelerateInterpolator = null;
        }
        if (i3 == 0) {
            return false;
        }
        KRRecyclerView kRRecyclerView2 = this.krRecyclerView;
        if (kRRecyclerView2 != null) {
            kRRecyclerView2.smoothScrollBy(c16[0], c16[1], decelerateInterpolator, i3);
        }
        return true;
    }

    private final boolean isForwardFling(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
        if (layoutManager.canScrollHorizontally()) {
            if (velocityX > 0) {
                return true;
            }
        } else if (velocityY > 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        super.attachToRecyclerView(recyclerView);
        if (recyclerView != null) {
            KRRecyclerView kRRecyclerView = (KRRecyclerView) recyclerView;
            this.krRecyclerView = kRRecyclerView;
            this.scroller = new b(kRRecyclerView);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerView");
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @NotNull
    public int[] calculateDistanceToFinalSnap(@NotNull RecyclerView.LayoutManager layoutManager, @NotNull View targetView) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        return b(targetView, layoutManager);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(@NotNull RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        View d16 = d(layoutManager);
        if (d16 != null) {
            h(d16, layoutManager);
        }
        return d16;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(@NotNull RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        ViewGroup f16 = f();
        if (f16 == null || f16.getChildCount() == 0) {
            return -1;
        }
        int childCount = f16.getChildCount();
        View view = null;
        int i3 = Integer.MAX_VALUE;
        int i16 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i17 = 0; i17 < childCount; i17++) {
            View child = f16.getChildAt(i17);
            Intrinsics.checkNotNullExpressionValue(child, "child");
            int a16 = a(layoutManager, child);
            if (a16 <= 0 && a16 > i16) {
                view2 = child;
                i16 = a16;
            }
            if (a16 >= 0 && a16 < i3) {
                view = child;
                i3 = a16;
            }
        }
        boolean isForwardFling = isForwardFling(layoutManager, velocityX, velocityY);
        if (isForwardFling && view != null) {
            h(view, layoutManager);
            return i3;
        }
        if (isForwardFling || view2 == null) {
            return -1;
        }
        h(view2, layoutManager);
        return i16;
    }

    @Override // androidx.recyclerview.widget.SnapHelper, androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public boolean onFling(int velocityX, int velocityY) {
        KRRecyclerView kRRecyclerView = this.krRecyclerView;
        if (kRRecyclerView == null) {
            return false;
        }
        int minFlingVelocity = kRRecyclerView.getMinFlingVelocity();
        if (Math.abs(velocityY) <= minFlingVelocity && Math.abs(velocityX) <= minFlingVelocity) {
            return false;
        }
        return i(velocityX, velocityY);
    }
}
