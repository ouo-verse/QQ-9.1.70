package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {
    private static final boolean DEBUG = false;
    private static final String TAG = "SimpleItemAnimator";
    boolean mSupportsChangeAnimations = true;

    public abstract boolean animateAdd(RecyclerView.ViewHolder viewHolder);

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    public boolean animateAppearance(@NonNull RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i3;
        int i16;
        if (itemHolderInfo != null && ((i3 = itemHolderInfo.left) != (i16 = itemHolderInfo2.left) || itemHolderInfo.top != itemHolderInfo2.top)) {
            return animateMove(viewHolder, i3, itemHolderInfo.top, i16, itemHolderInfo2.top);
        }
        return animateAdd(viewHolder);
    }

    public abstract boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i3, int i16, int i17, int i18);

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    public boolean animateChange(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i3;
        int i16;
        int i17 = itemHolderInfo.left;
        int i18 = itemHolderInfo.top;
        if (viewHolder2.shouldIgnore()) {
            int i19 = itemHolderInfo.left;
            i16 = itemHolderInfo.top;
            i3 = i19;
        } else {
            i3 = itemHolderInfo2.left;
            i16 = itemHolderInfo2.top;
        }
        return animateChange(viewHolder, viewHolder2, i17, i18, i3, i16);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    public boolean animateDisappearance(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i3;
        int i16;
        int i17;
        int i18 = 0;
        if (itemHolderInfo == null) {
            i3 = 0;
        } else {
            i3 = itemHolderInfo.left;
        }
        if (itemHolderInfo != null) {
            i18 = itemHolderInfo.top;
        }
        int i19 = i18;
        View view = viewHolder.itemView;
        if (itemHolderInfo2 == null) {
            i16 = view.getLeft();
        } else {
            i16 = itemHolderInfo2.left;
        }
        int i26 = i16;
        if (itemHolderInfo2 == null) {
            i17 = view.getTop();
        } else {
            i17 = itemHolderInfo2.top;
        }
        int i27 = i17;
        if (!viewHolder.isRemoved() && (i3 != i26 || i19 != i27)) {
            view.layout(i26, i27, view.getWidth() + i26, view.getHeight() + i27);
            return animateMove(viewHolder, i3, i19, i26, i27);
        }
        return animateRemove(viewHolder);
    }

    public abstract boolean animateMove(RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18);

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    public boolean animatePersistence(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i3 = itemHolderInfo.left;
        int i16 = itemHolderInfo2.left;
        if (i3 == i16 && itemHolderInfo.top == itemHolderInfo2.top) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        return animateMove(viewHolder, i3, itemHolderInfo.top, i16, itemHolderInfo2.top);
    }

    public abstract boolean animateRemove(RecyclerView.ViewHolder viewHolder);

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (this.mSupportsChangeAnimations && !viewHolder.isInvalid()) {
            return false;
        }
        return true;
    }

    public final void dispatchAddFinished(RecyclerView.ViewHolder viewHolder) {
        onAddFinished(viewHolder);
        dispatchAnimationFinished(viewHolder);
    }

    public final void dispatchAddStarting(RecyclerView.ViewHolder viewHolder) {
        onAddStarting(viewHolder);
    }

    public final void dispatchChangeFinished(RecyclerView.ViewHolder viewHolder, boolean z16) {
        onChangeFinished(viewHolder, z16);
        dispatchAnimationFinished(viewHolder);
    }

    public final void dispatchChangeStarting(RecyclerView.ViewHolder viewHolder, boolean z16) {
        onChangeStarting(viewHolder, z16);
    }

    public final void dispatchMoveFinished(RecyclerView.ViewHolder viewHolder) {
        onMoveFinished(viewHolder);
        dispatchAnimationFinished(viewHolder);
    }

    public final void dispatchMoveStarting(RecyclerView.ViewHolder viewHolder) {
        onMoveStarting(viewHolder);
    }

    public final void dispatchRemoveFinished(RecyclerView.ViewHolder viewHolder) {
        onRemoveFinished(viewHolder);
        dispatchAnimationFinished(viewHolder);
    }

    public final void dispatchRemoveStarting(RecyclerView.ViewHolder viewHolder) {
        onRemoveStarting(viewHolder);
    }

    public boolean getSupportsChangeAnimations() {
        return this.mSupportsChangeAnimations;
    }

    public void setSupportsChangeAnimations(boolean z16) {
        this.mSupportsChangeAnimations = z16;
    }

    public void onAddFinished(RecyclerView.ViewHolder viewHolder) {
    }

    public void onAddStarting(RecyclerView.ViewHolder viewHolder) {
    }

    public void onMoveFinished(RecyclerView.ViewHolder viewHolder) {
    }

    public void onMoveStarting(RecyclerView.ViewHolder viewHolder) {
    }

    public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
    }

    public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
    }

    public void onChangeFinished(RecyclerView.ViewHolder viewHolder, boolean z16) {
    }

    public void onChangeStarting(RecyclerView.ViewHolder viewHolder, boolean z16) {
    }
}
