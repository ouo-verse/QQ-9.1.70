package com.tencent.richframework.gallery.widget;

import android.view.View;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/richframework/gallery/widget/OffsetPageSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "mOffset", "", "(I)V", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "Companion", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class OffsetPageSnapHelper extends PagerSnapHelper {
    private final int mOffset;

    public OffsetPageSnapHelper(int i3) {
        this.mOffset = i3;
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    @NotNull
    public int[] calculateDistanceToFinalSnap(@NotNull RecyclerView.LayoutManager layoutManager, @NotNull View targetView) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        int[] calculateDistanceToFinalSnap = super.calculateDistanceToFinalSnap(layoutManager, targetView);
        int i3 = RFWLog.USR;
        StringBuilder sb5 = new StringBuilder();
        Intrinsics.checkNotNull(calculateDistanceToFinalSnap);
        sb5.append(String.valueOf(calculateDistanceToFinalSnap[0]));
        sb5.append(" ");
        sb5.append(calculateDistanceToFinalSnap[1]);
        RFWLog.i("OffsetPageSnapHelper", i3, sb5.toString());
        calculateDistanceToFinalSnap[0] = calculateDistanceToFinalSnap[0] + this.mOffset;
        return calculateDistanceToFinalSnap;
    }
}
