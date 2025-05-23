package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes.dex */
public class HippyRecyclerViewBase extends RecyclerViewBase {
    private boolean isBatching;

    public HippyRecyclerViewBase(@NonNull Context context) {
        super(context);
    }

    public void disableRecycle(View view) {
        RecyclerView.ViewHolder viewHolder;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if ((layoutParams instanceof RecyclerView.LayoutParams) && (viewHolder = ((RecyclerView.LayoutParams) layoutParams).mViewHolder) != null) {
            viewHolder.setIsRecyclable(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerViewBase, androidx.recyclerview.widget.RecyclerView
    public void dispatchLayout() {
        if (!this.isBatching) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof HippyLinearLayoutManager) {
                ((HippyLinearLayoutManager) layoutManager).resetCache();
            }
            super.dispatchLayout();
        }
        this.mFirstLayoutComplete = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.RecyclerView
    public String exceptionLabel() {
        return super.exceptionLabel() + ",state:" + getStateInfo();
    }

    public String getStateInfo() {
        RecyclerView.State state = this.mState;
        if (state != null) {
            return state.toString();
        }
        return null;
    }

    public void onBatchComplete() {
        this.isBatching = false;
    }

    public void onBatchStart() {
        this.isBatching = true;
    }

    public void scrollToPositionWithOffset(int i3, int i16) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        if (this.mLayout == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i3, i16);
        } else {
            this.mLayout.scrollToPosition(i3);
        }
        awakenScrollBars();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMaxRecycledViews(int i3, int i16) {
        this.mRecycler.getRecycledViewPool().setMaxRecycledViews(i3, i16);
    }

    public HippyRecyclerViewBase(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HippyRecyclerViewBase(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
    }
}
