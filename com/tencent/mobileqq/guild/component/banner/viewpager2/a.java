package com.tencent.mobileqq.guild.component.banner.viewpager2;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/component/banner/viewpager2/a;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;", "createScroller", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "realRecyclerView", "", "b", UserInfo.SEX_FEMALE, "()F", "c", "(F)V", "millisecondsPerInch", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;F)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends PagerSnapHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView realRecyclerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float millisecondsPerInch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/component/banner/viewpager2/a$b", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "Landroid/view/View;", "targetView", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$Action;", "action", "", "onTargetFound", "Landroid/util/DisplayMetrics;", "displayMetrics", "", "calculateSpeedPerPixel", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends LinearSmoothScroller {
        b(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(@NotNull DisplayMetrics displayMetrics) {
            Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
            return a.this.getMillisecondsPerInch() / displayMetrics.densityDpi;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(@NotNull View targetView, @NotNull RecyclerView.State state, @NotNull RecyclerView.SmoothScroller.Action action) {
            int coerceAtLeast;
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(action, "action");
            if (!a.this.realRecyclerView.isAttachedToWindow()) {
                return;
            }
            a aVar = a.this;
            RecyclerView.LayoutManager layoutManager = aVar.realRecyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager);
            int[] calculateDistanceToFinalSnap = aVar.calculateDistanceToFinalSnap(layoutManager, targetView);
            Intrinsics.checkNotNull(calculateDistanceToFinalSnap);
            int i3 = calculateDistanceToFinalSnap[0];
            int i16 = calculateDistanceToFinalSnap[1];
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(Math.abs(i3), Math.abs(i16));
            int calculateTimeForDeceleration = calculateTimeForDeceleration(coerceAtLeast);
            if (calculateTimeForDeceleration > 0) {
                action.update(i3, i16, calculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    public a(@NotNull RecyclerView realRecyclerView, float f16) {
        Intrinsics.checkNotNullParameter(realRecyclerView, "realRecyclerView");
        this.realRecyclerView = realRecyclerView;
        this.millisecondsPerInch = f16;
    }

    /* renamed from: b, reason: from getter */
    public final float getMillisecondsPerInch() {
        return this.millisecondsPerInch;
    }

    public final void c(float f16) {
        this.millisecondsPerInch = f16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public RecyclerView.SmoothScroller createScroller(@NotNull RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        return new b(this.realRecyclerView.getContext());
    }
}
