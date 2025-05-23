package com.tencent.mobileqq.widget.listitem;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\f\u00a2\u0006\u0004\b\"\u0010#J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/p;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "Z", "getHasTopSpace", "()Z", "b", "(Z)V", "hasTopSpace", "e", "getHasBottomSpace", "a", "hasBottomSpace", "", "f", "I", "getSpaceHeight", "()I", "c", "(I)V", "spaceHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;ZZ)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class p extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean hasTopSpace;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasBottomSpace;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int spaceHeight;

    @JvmOverloads
    public p(@NotNull Context context, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.hasTopSpace = z16;
        this.hasBottomSpace = z17;
        this.spaceHeight = context.getResources().getDimensionPixelSize(R.dimen.da7);
    }

    public final void a(boolean z16) {
        this.hasBottomSpace = z16;
    }

    public final void b(boolean z16) {
        this.hasTopSpace = z16;
    }

    public final void c(int i3) {
        this.spaceHeight = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.Adapter adapter = parent.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.widget.listitem.QUIListItemAdapter");
        QUIListItemAdapter qUIListItemAdapter = (QUIListItemAdapter) adapter;
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (this.hasTopSpace && childAdapterPosition == 0) {
            outRect.top = this.spaceHeight;
        }
        if (childAdapterPosition >= 0 && childAdapterPosition < qUIListItemAdapter.getNUM_BACKGOURND_ICON() - 1 && qUIListItemAdapter.j0(childAdapterPosition).getCom.tencent.mobileqq.vas.vipav.api.VipFunCallConstants.KEY_GROUP java.lang.String() != qUIListItemAdapter.j0(childAdapterPosition + 1).getCom.tencent.mobileqq.vas.vipav.api.VipFunCallConstants.KEY_GROUP java.lang.String()) {
            outRect.bottom = this.spaceHeight;
        }
        if (this.hasBottomSpace && childAdapterPosition == qUIListItemAdapter.getNUM_BACKGOURND_ICON() - 1) {
            outRect.bottom = this.spaceHeight;
        }
    }
}
