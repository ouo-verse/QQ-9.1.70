package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Argus;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.richframework.argus.node.ArgusNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u00a8\u0006\r"}, d2 = {"Landroidx/recyclerview/widget/InflateHelper;", "", "()V", "getAdjustItemTypeAndLayoutId", "Landroidx/recyclerview/widget/ItemViewData;", "inflateView", "Landroid/view/View;", "layoutId", "", "isViewPager2ItemLayoutParams", "", "layoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class InflateHelper {

    @NotNull
    public static final InflateHelper INSTANCE = new InflateHelper();

    InflateHelper() {
    }

    private final boolean isViewPager2ItemLayoutParams(RecyclerView.LayoutParams layoutParams) {
        ViewParent viewParent;
        RecyclerView recyclerView;
        RecyclerView.ViewHolder viewHolder = layoutParams.mViewHolder;
        if (viewHolder != null && (recyclerView = viewHolder.mOwnerRecyclerView) != null) {
            viewParent = recyclerView.getParent();
        } else {
            viewParent = null;
        }
        return viewParent instanceof ViewPager2;
    }

    @Nullable
    public final ItemViewData getAdjustItemTypeAndLayoutId(@NotNull View inflateView, int layoutId) {
        Intrinsics.checkNotNullParameter(inflateView, "inflateView");
        View view = null;
        while (true) {
            if (inflateView.getLayoutParams() instanceof RecyclerView.LayoutParams) {
                ViewGroup.LayoutParams layoutParams = inflateView.getLayoutParams();
                if (layoutParams != null) {
                    if (!isViewPager2ItemLayoutParams((RecyclerView.LayoutParams) layoutParams)) {
                        view = inflateView;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                }
            }
            if (!(inflateView.getParent() instanceof View) || ((inflateView.getParent() instanceof ViewPager) && (inflateView.getParent() instanceof ViewPager2))) {
                break;
            }
            Object parent = inflateView.getParent();
            if (parent != null) {
                inflateView = (View) parent;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
        }
        if (view == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            RecyclerView.ViewHolder viewHolder = ((RecyclerView.LayoutParams) layoutParams2).mViewHolder;
            if (viewHolder != null) {
                int itemViewType = viewHolder.getItemViewType();
                RecyclerView recyclerView = viewHolder.mOwnerRecyclerView;
                if (recyclerView != null) {
                    ArgusNode findViewBlockNode$default = Argus.findViewBlockNode$default(Argus.INSTANCE, recyclerView, false, 2, null);
                    View view2 = viewHolder.itemView;
                    Intrinsics.checkNotNullExpressionValue(view2, "viewHolder.itemView");
                    return new ItemViewData(view.hashCode(), itemViewType, InflateHelperKt.getInflateResId(view2, true), findViewBlockNode$default);
                }
            }
            return null;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }
}
