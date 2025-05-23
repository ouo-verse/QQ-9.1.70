package ba;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00172\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lba/o;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "", "hasHeadView", "", "a", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "getItemOffsets", "d", "Z", "getHasHeaderView", "()Z", "setHasHeaderView", "(Z)V", "hasHeaderView", "<init>", "e", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class o extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean hasHeaderView;

    public o(boolean z16) {
        this.hasHeaderView = z16;
    }

    public final void a(boolean hasHeadView) {
        this.hasHeaderView = hasHeadView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int childAdapterPosition;
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        if (this.hasHeaderView) {
            childAdapterPosition = parent.getChildAdapterPosition(view) - 1;
        } else {
            childAdapterPosition = parent.getChildAdapterPosition(view);
        }
        if (childAdapterPosition % 2 == 0) {
            outRect.left = ViewUtils.dpToPx(16.0f);
            outRect.right = ViewUtils.dpToPx(8.0f);
        } else {
            outRect.left = ViewUtils.dpToPx(8.0f);
            outRect.right = ViewUtils.dpToPx(16.0f);
        }
        boolean z16 = this.hasHeaderView;
        if (z16 && childAdapterPosition == -1) {
            outRect.top = 0;
            outRect.bottom = 0;
        } else if (childAdapterPosition >= 2) {
            outRect.top = ViewUtils.dpToPx(10.0f);
            outRect.bottom = ViewUtils.dpToPx(10.0f);
        } else if (z16) {
            outRect.top = ViewUtils.dpToPx(16.0f);
            outRect.bottom = ViewUtils.dpToPx(10.0f);
        } else {
            outRect.top = 0;
            outRect.bottom = ViewUtils.dpToPx(10.0f);
        }
    }
}
