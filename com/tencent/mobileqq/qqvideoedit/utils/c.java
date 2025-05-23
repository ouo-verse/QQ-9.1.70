package com.tencent.mobileqq.qqvideoedit.utils;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ2\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007J2\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007J:\u0010\u000e\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0004H\u0007J(\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0002R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/utils/c;", "", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "", "currentIndex", "targetPosition", "", "smoothScroll", "fixScrollTime", "", "g", tl.h.F, "snapPosition", "e", "Landroid/support/v7/widget/LinearLayoutManager;", "llm", "Landroid/support/v7/widget/LinearSmoothScroller;", "scroller", "position", "c", "b", "Ljava/lang/Integer;", "getCurrentIndex", "()Ljava/lang/Integer;", "setCurrentIndex", "(Ljava/lang/Integer;)V", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f276241a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Integer currentIndex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J0\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0014\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/qqvideoedit/utils/c$a", "Landroid/support/v7/widget/LinearSmoothScroller;", "", "targetPos", "Landroid/graphics/PointF;", "computeScrollVectorForPosition", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateDtToFit", "Landroid/util/DisplayMetrics;", "displayMetrics", "", "calculateSpeedPerPixel", "dx", "calculateTimeForScrolling", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends LinearSmoothScroller {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f276243a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f276244b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f276245c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(LinearLayoutManager linearLayoutManager, int i3, boolean z16, Context context) {
            super(context);
            this.f276243a = linearLayoutManager;
            this.f276244b = i3;
            this.f276245c = z16;
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
            int i3 = this.f276244b;
            if (i3 != -1) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return super.calculateDtToFit(viewStart, viewEnd, boxStart, boxEnd, 0);
                    }
                    return (boxStart + ((boxEnd - boxStart) / 2)) - (viewStart + ((viewEnd - viewStart) / 2));
                }
                return super.calculateDtToFit(viewStart, viewEnd, boxStart, boxEnd, 1);
            }
            return super.calculateDtToFit(viewStart, viewEnd, boxStart, boxEnd, -1);
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        protected float calculateSpeedPerPixel(@NotNull DisplayMetrics displayMetrics) {
            Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
            return 50.0f / displayMetrics.densityDpi;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v7.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int dx5) {
            int coerceAtMost;
            if (!this.f276245c) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(200, super.calculateTimeForScrolling(dx5));
                return coerceAtMost;
            }
            return 100;
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        @Nullable
        public PointF computeScrollVectorForPosition(int targetPos) {
            float f16;
            int findFirstVisibleItemPosition = this.f276243a.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = this.f276243a.findLastVisibleItemPosition();
            if (targetPos < findFirstVisibleItemPosition) {
                f16 = -1.0f;
            } else if (targetPos > findLastVisibleItemPosition) {
                f16 = 1.0f;
            } else {
                f16 = 0.0f;
            }
            if (this.f276243a.getOrientation() == 0) {
                return new PointF(f16, 0.0f);
            }
            return new PointF(0.0f, f16);
        }
    }

    c() {
    }

    private final void c(final RecyclerView recyclerView, final LinearLayoutManager llm, final LinearSmoothScroller scroller, final int position) {
        if (!llm.isSmoothScrolling()) {
            llm.startSmoothScroll(scroller);
        } else {
            recyclerView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.utils.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.d(RecyclerView.this, llm, scroller, position);
                }
            }, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(RecyclerView recyclerView, LinearLayoutManager llm, LinearSmoothScroller scroller, int i3) {
        Intrinsics.checkNotNullParameter(recyclerView, "$recyclerView");
        Intrinsics.checkNotNullParameter(llm, "$llm");
        Intrinsics.checkNotNullParameter(scroller, "$scroller");
        f276241a.c(recyclerView, llm, scroller, i3);
    }

    @JvmStatic
    public static final void e(@Nullable final RecyclerView recyclerView, int currentIndex2, final int targetPosition, boolean smoothScroll, boolean fixScrollTime, int snapPosition) {
        int width;
        View findViewByPosition;
        if (recyclerView == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        final a aVar = new a(linearLayoutManager, snapPosition, fixScrollTime, recyclerView.getContext());
        if (smoothScroll) {
            currentIndex = Integer.valueOf(currentIndex2);
            recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.utils.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.f(LinearSmoothScroller.this, targetPosition, recyclerView, linearLayoutManager);
                }
            });
            return;
        }
        if (snapPosition != 1) {
            if (snapPosition == 2 && (findViewByPosition = linearLayoutManager.findViewByPosition(linearLayoutManager.findFirstCompletelyVisibleItemPosition())) != null) {
                width = (recyclerView.getWidth() / 2) - (findViewByPosition.getWidth() / 2);
            }
            width = 0;
        } else {
            View findViewByPosition2 = linearLayoutManager.findViewByPosition(linearLayoutManager.findFirstCompletelyVisibleItemPosition());
            if (findViewByPosition2 != null) {
                width = recyclerView.getWidth() - findViewByPosition2.getWidth();
            }
            width = 0;
        }
        linearLayoutManager.scrollToPositionWithOffset(targetPosition, width);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(LinearSmoothScroller scroller, int i3, RecyclerView recyclerView, LinearLayoutManager llm) {
        Intrinsics.checkNotNullParameter(scroller, "$scroller");
        Intrinsics.checkNotNullParameter(llm, "$llm");
        scroller.setTargetPosition(i3);
        f276241a.c(recyclerView, llm, scroller, i3);
    }

    @JvmStatic
    public static final void g(@Nullable RecyclerView recyclerView, int currentIndex2, int targetPosition, boolean smoothScroll, boolean fixScrollTime) {
        e(recyclerView, currentIndex2, targetPosition, smoothScroll, fixScrollTime, 2);
    }

    @JvmStatic
    public static final void h(@Nullable RecyclerView recyclerView, int currentIndex2, int targetPosition, boolean smoothScroll, boolean fixScrollTime) {
        e(recyclerView, currentIndex2, targetPosition, smoothScroll, fixScrollTime, -1);
    }
}
