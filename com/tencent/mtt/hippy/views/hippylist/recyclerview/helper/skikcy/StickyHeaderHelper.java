package com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.skikcy;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewBase;

/* compiled from: P */
/* loaded from: classes20.dex */
public class StickyHeaderHelper extends RecyclerView.OnScrollListener implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final int INVALID_POSITION = -1;
    private View currentHeaderView;
    private final IHeaderAttachListener headerAttachListener;
    private IHeaderHost headerHost;
    private RecyclerView.ViewHolder headerOrgViewHolder;
    private boolean isUpdateStickyHolderWhenLayout;
    private int orientation;
    private RecyclerViewBase recyclerView;
    private StickViewListener stickViewListener;
    private IStickyItemsProvider stickyItemsProvider;
    private StickyViewFactory stickyViewFactory;
    private boolean orgViewHolderCanRecyclable = false;
    private int currentStickPos = -1;

    public StickyHeaderHelper(RecyclerViewBase recyclerViewBase, IStickyItemsProvider iStickyItemsProvider, IHeaderAttachListener iHeaderAttachListener, IHeaderHost iHeaderHost) {
        this.recyclerView = recyclerViewBase;
        this.headerAttachListener = iHeaderAttachListener;
        this.stickyItemsProvider = iStickyItemsProvider;
        this.stickyViewFactory = new StickyViewFactory(recyclerViewBase);
        this.headerHost = iHeaderHost;
        this.orientation = recyclerViewBase.getLayoutManager().canScrollVertically() ? 1 : 0;
    }

    private void attachSticky(int i3) {
        int i16;
        if (i3 != -1) {
            this.headerOrgViewHolder = this.stickyViewFactory.getHeaderForPosition(i3);
            this.currentStickPos = i3;
            Log.d("returnHeader", "attachSticky:" + this.headerOrgViewHolder);
            View childAt = ((ViewGroup) this.headerOrgViewHolder.itemView).getChildAt(0);
            this.currentHeaderView = childAt;
            removeViewFromParent(childAt);
            this.orgViewHolderCanRecyclable = this.headerOrgViewHolder.isRecyclable();
            this.headerOrgViewHolder.setIsRecyclable(false);
            this.currentHeaderView.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 0);
            ViewGroup.LayoutParams layoutParams2 = this.headerOrgViewHolder.itemView.getLayoutParams();
            if (layoutParams2 != null) {
                i16 = layoutParams2.height;
            } else {
                i16 = -2;
            }
            layoutParams.height = i16;
            this.headerHost.addOnLayoutListener(this);
            this.headerHost.attachHeader(this.currentHeaderView, layoutParams);
            notifyStickAttached(i3);
        }
    }

    private View findNextSticky(int i3) {
        for (int i16 = 0; i16 < this.recyclerView.getChildCount(); i16++) {
            View childAt = this.recyclerView.getChildAt(i16);
            int childLayoutPosition = this.recyclerView.getChildLayoutPosition(childAt);
            if (childLayoutPosition > i3 && this.stickyItemsProvider.isStickyPosition(childLayoutPosition)) {
                return childAt;
            }
        }
        return null;
    }

    private float getOffset(View view) {
        float x16;
        int width;
        View view2 = this.currentHeaderView;
        if (view2 != null && view != null) {
            if (this.orientation == 1) {
                if (view.getY() < view2.getHeight()) {
                    x16 = view.getY();
                    width = view2.getHeight();
                    return x16 - width;
                }
            } else {
                if (view2.isShown()) {
                    return -view2.getWidth();
                }
                if (view.getX() < view2.getWidth()) {
                    x16 = view2.getX();
                    width = view2.getWidth();
                    return x16 - width;
                }
            }
        }
        return 0.0f;
    }

    private boolean headerAwayFromEdge(View view) {
        if (view != null) {
            if (this.orientation == 1) {
                if (view.getY() < 0.0f) {
                    return true;
                }
            } else if (view.getX() < 0.0f) {
                return true;
            }
        }
        return false;
    }

    private void notifyStickAttached(int i3) {
        StickViewListener stickViewListener = this.stickViewListener;
        if (stickViewListener != null) {
            stickViewListener.onStickAttached(i3);
        }
    }

    private void notifyStickDetached() {
        StickViewListener stickViewListener = this.stickViewListener;
        if (stickViewListener != null) {
            stickViewListener.onStickDetached(this.currentStickPos);
        }
    }

    private void offsetSticky() {
        if (this.headerOrgViewHolder != null) {
            float offset = getOffset(findNextSticky(this.currentStickPos));
            if (this.orientation == 1) {
                this.currentHeaderView.setTranslationY(offset);
            } else {
                this.currentHeaderView.setTranslationX(offset);
            }
        }
    }

    private void removeViewFromParent(View view) {
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    private void returnHeaderBackToList() {
        this.headerOrgViewHolder.setIsRecyclable(this.orgViewHolderCanRecyclable);
        IHeaderAttachListener iHeaderAttachListener = this.headerAttachListener;
        if (iHeaderAttachListener != null) {
            iHeaderAttachListener.onHeaderDetached(this.headerOrgViewHolder, this.currentHeaderView);
            return;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.recyclerView.findViewHolderForAdapterPosition(this.headerOrgViewHolder.getAdapterPosition());
        if (findViewHolderForAdapterPosition != null) {
            View view = findViewHolderForAdapterPosition.itemView;
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup.getChildCount() <= 0) {
                    viewGroup.addView(this.currentHeaderView);
                }
            }
        }
    }

    private void updateStickHolder() {
        if (this.headerOrgViewHolder != null) {
            this.recyclerView.getAdapter().onBindViewHolder(this.headerOrgViewHolder, this.currentStickPos);
        }
    }

    public void detachSticky() {
        if (this.headerOrgViewHolder != null) {
            removeViewFromParent(this.currentHeaderView);
            this.currentHeaderView.setTranslationY(0.0f);
            this.currentHeaderView.setTranslationX(0.0f);
            returnHeaderBackToList();
            this.headerHost.removeOnLayoutListener(this);
            notifyStickDetached();
        }
        this.currentStickPos = -1;
        this.headerOrgViewHolder = null;
    }

    public int getStickyItemPosition() {
        int i3;
        int i16 = -1;
        if (this.recyclerView.getChildCount() <= 0) {
            return -1;
        }
        int firstChildPosition = this.recyclerView.getFirstChildPosition();
        View childAt = this.recyclerView.getChildAt(0);
        if (childAt.getY() < 0.0f) {
            i3 = firstChildPosition - 1;
            while (true) {
                if (i3 >= 0) {
                    if (this.stickyItemsProvider.isStickyPosition(i3)) {
                        break;
                    }
                } else {
                    i3 = -1;
                    break;
                }
                i3--;
            }
            if (i3 != -1) {
                if (i3 != this.recyclerView.getFirstChildPosition()) {
                    return i3;
                }
                if (headerAwayFromEdge(childAt)) {
                    i16 = i3;
                }
                return i16;
            }
            return i3;
        }
        i3--;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view = this.currentHeaderView;
        if (view != null) {
            view.setVisibility(0);
            offsetSticky();
            if (this.isUpdateStickyHolderWhenLayout) {
                updateStickHolder();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
        int stickyItemPosition = getStickyItemPosition();
        if (this.currentStickPos != stickyItemPosition) {
            detachSticky();
            attachSticky(stickyItemPosition);
        }
        offsetSticky();
    }

    public void setStickViewListener(StickViewListener stickViewListener) {
        this.stickViewListener = stickViewListener;
    }

    public void setUpdateStickyViewWhenLayout(boolean z16) {
        this.isUpdateStickyHolderWhenLayout = z16;
    }
}
