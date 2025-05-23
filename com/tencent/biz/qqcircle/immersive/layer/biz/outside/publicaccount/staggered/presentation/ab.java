package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.viewholder.QFSPublicAccountFollowUsersItemViewFactory;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/ab;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "a", "Landroid/graphics/Rect;", "outRect", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "verticalSpacePx", "e", "horizontalSpacePx", "<init>", "(II)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ab extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int verticalSpacePx;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int horizontalSpacePx;

    public ab(int i3, int i16) {
        this.verticalSpacePx = i3;
        this.horizontalSpacePx = i16;
    }

    private final boolean a(View view, RecyclerView parent) {
        RecyclerView.Adapter adapter;
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition == -1 || (adapter = parent.getAdapter()) == null || adapter.getItemViewType(childAdapterPosition) != QFSPublicAccountFollowUsersItemViewFactory.ItemType.FOLLOW_USERS_ITEM_TYPE.getType()) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = this.verticalSpacePx;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        StaggeredGridLayoutManager.LayoutParams layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
        if (layoutParams2.getSpanIndex() == -1) {
            return;
        }
        if (layoutParams2.isFullSpan()) {
            if (a(view, parent)) {
                outRect.left = 0;
                outRect.right = 0;
                return;
            } else {
                int i3 = this.horizontalSpacePx;
                outRect.left = i3;
                outRect.right = i3;
                return;
            }
        }
        if (layoutParams2.getSpanIndex() % 2 == 0) {
            int i16 = this.horizontalSpacePx;
            outRect.left = i16;
            outRect.right = i16 / 2;
        } else {
            int i17 = this.horizontalSpacePx;
            outRect.left = i17 / 2;
            outRect.right = i17;
        }
    }
}
