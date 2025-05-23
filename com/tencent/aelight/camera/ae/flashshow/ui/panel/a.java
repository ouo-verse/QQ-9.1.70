package com.tencent.aelight.camera.ae.flashshow.ui.panel;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J0\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0014\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/a;", "Landroid/support/v7/widget/LinearSmoothScroller;", "", "p0", "Landroid/graphics/PointF;", "computeScrollVectorForPosition", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateDtToFit", "Landroid/util/DisplayMetrics;", "displayMetrics", "", "calculateSpeedPerPixel", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
final class a extends LinearSmoothScroller {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.support.v7.widget.LinearSmoothScroller
    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // android.support.v7.widget.LinearSmoothScroller
    public PointF computeScrollVectorForPosition(int p06) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        PointF computeScrollVectorForPosition = ((LinearLayoutManager) layoutManager).computeScrollVectorForPosition(p06);
        Intrinsics.checkNotNullExpressionValue(computeScrollVectorForPosition, "layoutManager as LinearL\u2026rollVectorForPosition(p0)");
        return computeScrollVectorForPosition;
    }

    @Override // android.support.v7.widget.LinearSmoothScroller
    public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
        return ((boxStart + boxEnd) / 2) - ((viewStart + viewEnd) / 2);
    }
}
