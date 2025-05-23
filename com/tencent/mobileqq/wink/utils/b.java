package com.tencent.mobileqq.wink.utils;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J2\u0010\f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0007J,\u0010\u000f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007J<\u0010\u0010\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007JB\u0010\u0012\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007J(\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0004H\u0002R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/utils/b;", "", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "", "currentIndex", "targetPosition", "", "e", "", "smoothScroll", "fixScrollTime", "f", "", "scrollSpeed", tl.h.F, "j", "snapPosition", "c", "Landroid/support/v7/widget/LinearLayoutManager;", "llm", "Landroid/support/v7/widget/LinearSmoothScroller;", "scroller", "position", "b", "Ljava/lang/Integer;", "getCurrentIndex", "()Ljava/lang/Integer;", "setCurrentIndex", "(Ljava/lang/Integer;)V", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f326694a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Integer currentIndex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J0\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0014\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/wink/utils/b$a", "Landroid/support/v7/widget/LinearSmoothScroller;", "", "targetPos", "Landroid/graphics/PointF;", "computeScrollVectorForPosition", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateDtToFit", "Landroid/util/DisplayMetrics;", "displayMetrics", "", "calculateSpeedPerPixel", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends LinearSmoothScroller {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f326696a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f326697b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f326698c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(LinearLayoutManager linearLayoutManager, int i3, float f16, Context context) {
            super(context);
            this.f326696a = linearLayoutManager;
            this.f326697b = i3;
            this.f326698c = f16;
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
            int i3 = this.f326697b;
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
            return (50.0f / this.f326698c) / displayMetrics.densityDpi;
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        @Nullable
        public PointF computeScrollVectorForPosition(int targetPos) {
            float f16;
            int findFirstVisibleItemPosition = this.f326696a.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = this.f326696a.findLastVisibleItemPosition();
            if (targetPos < findFirstVisibleItemPosition) {
                f16 = -1.0f;
            } else if (targetPos > findLastVisibleItemPosition) {
                f16 = 1.0f;
            } else {
                f16 = 0.0f;
            }
            if (this.f326696a.getOrientation() == 0) {
                return new PointF(f16, 0.0f);
            }
            return new PointF(0.0f, f16);
        }
    }

    b() {
    }

    private final void b(RecyclerView recyclerView, LinearLayoutManager llm, LinearSmoothScroller scroller, int position) {
        llm.startSmoothScroll(scroller);
    }

    @JvmStatic
    public static final void c(@Nullable final RecyclerView recyclerView, int currentIndex2, final int targetPosition, boolean smoothScroll, boolean fixScrollTime, int snapPosition, float scrollSpeed) {
        int width;
        View findViewByPosition;
        if (recyclerView == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        final a aVar = new a(linearLayoutManager, snapPosition, scrollSpeed, recyclerView.getContext());
        if (smoothScroll) {
            currentIndex = Integer.valueOf(currentIndex2);
            recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.utils.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.d(LinearSmoothScroller.this, targetPosition, recyclerView, linearLayoutManager);
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
    public static final void d(LinearSmoothScroller scroller, int i3, RecyclerView recyclerView, LinearLayoutManager llm) {
        Intrinsics.checkNotNullParameter(scroller, "$scroller");
        Intrinsics.checkNotNullParameter(llm, "$llm");
        scroller.setTargetPosition(i3);
        f326694a.b(recyclerView, llm, scroller, i3);
    }

    @JvmStatic
    public static final void e(@Nullable RecyclerView recyclerView, int currentIndex2, int targetPosition) {
        f(recyclerView, currentIndex2, targetPosition, true, false);
    }

    @JvmStatic
    public static final void f(@Nullable RecyclerView recyclerView, int currentIndex2, int targetPosition, boolean smoothScroll, boolean fixScrollTime) {
        c(recyclerView, currentIndex2, targetPosition, smoothScroll, fixScrollTime, 2, 1.0f);
    }

    @JvmStatic
    @JvmOverloads
    public static final void g(@Nullable RecyclerView recyclerView, int i3, int i16) {
        k(recyclerView, i3, i16, 0.0f, 8, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void h(@Nullable RecyclerView recyclerView, int currentIndex2, int targetPosition, float scrollSpeed) {
        j(recyclerView, currentIndex2, targetPosition, true, false, scrollSpeed);
    }

    @JvmStatic
    @JvmOverloads
    public static final void i(@Nullable RecyclerView recyclerView, int i3, int i16, boolean z16, boolean z17) {
        l(recyclerView, i3, i16, z16, z17, 0.0f, 32, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void j(@Nullable RecyclerView recyclerView, int currentIndex2, int targetPosition, boolean smoothScroll, boolean fixScrollTime, float scrollSpeed) {
        c(recyclerView, currentIndex2, targetPosition, smoothScroll, fixScrollTime, -1, scrollSpeed);
    }

    public static /* synthetic */ void k(RecyclerView recyclerView, int i3, int i16, float f16, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            f16 = 1.0f;
        }
        h(recyclerView, i3, i16, f16);
    }

    public static /* synthetic */ void l(RecyclerView recyclerView, int i3, int i16, boolean z16, boolean z17, float f16, int i17, Object obj) {
        if ((i17 & 32) != 0) {
            f16 = 1.0f;
        }
        j(recyclerView, i3, i16, z16, z17, f16);
    }
}
