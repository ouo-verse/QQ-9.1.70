package com.tencent.mobileqq.wink.inspirationlibrary.part;

import android.view.View;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/a;", "Landroidx/recyclerview/widget/LinearSnapHelper;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "Landroid/view/View;", "targetView", "", "calculateDistanceToFinalSnap", "", "a", "Z", "isPadDevice", "", "b", "I", "itemWidth", "<init>", "(ZI)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends LinearSnapHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isPadDevice;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int itemWidth;

    public a(boolean z16, int i3) {
        this.isPadDevice = z16;
        this.itemWidth = i3;
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    @NotNull
    public int[] calculateDistanceToFinalSnap(@NotNull RecyclerView.LayoutManager layoutManager, @NotNull View targetView) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            int decoratedLeft = layoutManager.getDecoratedLeft(targetView) - layoutManager.getPaddingLeft();
            if (this.isPadDevice) {
                int i3 = this.itemWidth;
                if (decoratedLeft == i3) {
                    iArr[0] = 0;
                } else {
                    if (decoratedLeft > i3 / 2) {
                        decoratedLeft -= i3;
                    }
                    iArr[0] = decoratedLeft;
                }
            } else {
                iArr[0] = decoratedLeft;
            }
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = layoutManager.getDecoratedTop(targetView) - layoutManager.getPaddingTop();
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }
}
