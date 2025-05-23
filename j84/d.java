package j84;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.utils.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lj84/d;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroid/support/v7/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/support/v7/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "PADDING_SIDE", "e", "MARGIN", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int PADDING_SIDE = i.a(15.6f);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int MARGIN = i.a(10.4f);

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        parent.getLayoutManager();
        int childLayoutPosition = parent.getChildLayoutPosition(view);
        int itemCount = state.getItemCount() - 1;
        if (childLayoutPosition == -1) {
            return;
        }
        if (view.getLayoutParams() instanceof GridLayoutManager.LayoutParams) {
            if (childLayoutPosition % 2 == 0) {
                outRect.left = this.PADDING_SIDE;
            } else {
                outRect.left = this.MARGIN;
                outRect.right = this.PADDING_SIDE;
            }
        } else if (childLayoutPosition == 0) {
            outRect.left = this.PADDING_SIDE;
        } else {
            if (childLayoutPosition == itemCount) {
                outRect.right = this.PADDING_SIDE;
            }
            outRect.left = this.MARGIN;
        }
        outRect.bottom = i.a(20.8f);
    }
}
