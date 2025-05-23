package com.tencent.qqnt.chathistory.ui.shortvideo.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/shortvideo/adapter/c;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "mMinPageVisibleWidth", "<init>", "()V", "e", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c extends RecyclerView.ItemDecoration {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final String f353849f = "QCHV-ChatHistoryShortVideoItemDecoration";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mMinPageVisibleWidth;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        int dimensionPixelSize;
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        if (view.getId() == R.id.f84754n4) {
            return;
        }
        if (this.mMinPageVisibleWidth == 0) {
            this.mMinPageVisibleWidth = (view.getResources().getDisplayMetrics().widthPixels - view.getResources().getDimensionPixelSize(R.dimen.c_1)) / 2;
        }
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (parent.getAdapter() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        if (childAdapterPosition == 0) {
            dimensionPixelSize = this.mMinPageVisibleWidth;
        } else {
            dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.f158728ni);
        }
        layoutParams2.setMargins(dimensionPixelSize, view.getResources().getDimensionPixelSize(R.dimen.f158728ni), 0, 0);
        view.setLayoutParams(layoutParams2);
    }
}
