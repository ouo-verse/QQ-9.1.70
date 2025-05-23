package com.tencent.qui.quilistitem;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001e\u0010\u001fJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/qui/quilistitem/p;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "spaceHeight", "", "e", "Z", "getHasTopSpace", "()Z", "b", "(Z)V", "hasTopSpace", "f", "getHasBottomSpace", "a", "hasBottomSpace", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;ZZ)V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final class p extends RecyclerView.ItemDecoration {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int spaceHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasTopSpace;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasBottomSpace;

    @JvmOverloads
    public p(@NotNull Context context, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.hasTopSpace = z16;
        this.hasBottomSpace = z17;
        this.spaceHeight = context.getResources().getDimensionPixelSize(R.dimen.da7);
    }

    public final void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.hasBottomSpace = z16;
        }
    }

    public final void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.hasTopSpace = z16;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, outRect, view, parent, state);
            return;
        }
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter != null) {
            QUIListItemAdapter qUIListItemAdapter = (QUIListItemAdapter) adapter;
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (this.hasTopSpace && childAdapterPosition == 0) {
                outRect.top = this.spaceHeight;
            }
            if (childAdapterPosition >= 0 && childAdapterPosition < qUIListItemAdapter.getItemCount() - 1 && qUIListItemAdapter.j0(childAdapterPosition).d() != qUIListItemAdapter.j0(childAdapterPosition + 1).d()) {
                outRect.bottom = this.spaceHeight;
            }
            if (this.hasBottomSpace && childAdapterPosition == qUIListItemAdapter.getItemCount() - 1) {
                outRect.bottom = this.spaceHeight;
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.qui.quilistitem.QUIListItemAdapter");
    }
}
