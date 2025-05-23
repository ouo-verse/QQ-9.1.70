package com.tencent.mobileqq.wink.utils;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J2\u0010\f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0007J\"\u0010\r\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J2\u0010\u000e\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0007J:\u0010\u0010\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J(\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0004H\u0002R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/e;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "currentIndex", "targetPosition", "", "g", "", "smoothScroll", "fixScrollTime", tl.h.F, "i", "j", "snapPosition", "e", "Landroidx/recyclerview/widget/LinearLayoutManager;", "llm", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "scroller", "position", "c", "b", "Ljava/lang/Integer;", "getCurrentIndex", "()Ljava/lang/Integer;", "setCurrentIndex", "(Ljava/lang/Integer;)V", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f326707a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Integer currentIndex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J0\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0014\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/wink/utils/e$a", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "", "targetPos", "Landroid/graphics/PointF;", "computeScrollVectorForPosition", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateDtToFit", "Landroid/util/DisplayMetrics;", "displayMetrics", "", "calculateSpeedPerPixel", "dx", "calculateTimeForScrolling", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends LinearSmoothScroller {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f326709c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f326710d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f326711e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(LinearLayoutManager linearLayoutManager, int i3, boolean z16, Context context) {
            super(context);
            this.f326709c = linearLayoutManager;
            this.f326710d = i3;
            this.f326711e = z16;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
            int i3 = this.f326710d;
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

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(@NotNull DisplayMetrics displayMetrics) {
            Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
            return 50.0f / displayMetrics.densityDpi;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int dx5) {
            int coerceAtMost;
            if (!this.f326711e) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(200, super.calculateTimeForScrolling(dx5));
                return coerceAtMost;
            }
            return 100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        @Nullable
        public PointF computeScrollVectorForPosition(int targetPos) {
            float f16;
            int findFirstVisibleItemPosition = this.f326709c.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = this.f326709c.findLastVisibleItemPosition();
            if (targetPos < findFirstVisibleItemPosition) {
                f16 = -1.0f;
            } else if (targetPos > findLastVisibleItemPosition) {
                f16 = 1.0f;
            } else {
                f16 = 0.0f;
            }
            if (this.f326709c.getOrientation() == 0) {
                return new PointF(f16, 0.0f);
            }
            return new PointF(0.0f, f16);
        }
    }

    e() {
    }

    private final void c(final RecyclerView recyclerView, final LinearLayoutManager llm, final LinearSmoothScroller scroller, final int position) {
        if (!llm.isSmoothScrolling()) {
            llm.startSmoothScroll(scroller);
        } else {
            recyclerView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.utils.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.d(RecyclerView.this, llm, scroller, position);
                }
            }, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(RecyclerView recyclerView, LinearLayoutManager llm, LinearSmoothScroller scroller, int i3) {
        Intrinsics.checkNotNullParameter(recyclerView, "$recyclerView");
        Intrinsics.checkNotNullParameter(llm, "$llm");
        Intrinsics.checkNotNullParameter(scroller, "$scroller");
        f326707a.c(recyclerView, llm, scroller, i3);
    }

    @JvmStatic
    public static final void e(@Nullable final RecyclerView recyclerView, int currentIndex2, final int targetPosition, boolean smoothScroll, boolean fixScrollTime, int snapPosition) {
        int width;
        View findViewByPosition;
        if (recyclerView == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        final a aVar = new a(linearLayoutManager, snapPosition, fixScrollTime, recyclerView.getContext());
        if (smoothScroll) {
            currentIndex = Integer.valueOf(currentIndex2);
            recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.utils.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.f(LinearSmoothScroller.this, targetPosition, recyclerView, linearLayoutManager);
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
        f326707a.c(recyclerView, llm, scroller, i3);
    }

    @JvmStatic
    public static final void g(@Nullable RecyclerView recyclerView, int currentIndex2, int targetPosition) {
        h(recyclerView, currentIndex2, targetPosition, true, false);
    }

    @JvmStatic
    public static final void h(@Nullable RecyclerView recyclerView, int currentIndex2, int targetPosition, boolean smoothScroll, boolean fixScrollTime) {
        e(recyclerView, currentIndex2, targetPosition, smoothScroll, fixScrollTime, 2);
    }

    @JvmStatic
    public static final void i(@Nullable RecyclerView recyclerView, int currentIndex2, int targetPosition) {
        j(recyclerView, currentIndex2, targetPosition, true, false);
    }

    @JvmStatic
    public static final void j(@Nullable RecyclerView recyclerView, int currentIndex2, int targetPosition, boolean smoothScroll, boolean fixScrollTime) {
        e(recyclerView, currentIndex2, targetPosition, smoothScroll, fixScrollTime, -1);
    }
}
