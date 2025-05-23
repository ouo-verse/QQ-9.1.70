package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes.dex */
public class RecyclerViewBase extends RecyclerView {
    private boolean enableOverDrag;
    protected HippyOverPullHelper overPullHelper;
    protected HippyOverPullListener overPullListener;
    protected VelocityTracker velocityTracker;

    public RecyclerViewBase(@NonNull Context context) {
        super(context);
        init();
    }

    private int getCachedViewHolderCount() {
        int size = this.mRecycler.mAttachedScrap.size() + this.mRecycler.mCachedViews.size();
        for (int i3 = 0; i3 < this.mRecycler.getRecycledViewPool().mScrap.size(); i3++) {
            size += this.mRecycler.getRecycledViewPool().mScrap.valueAt(i3).mScrapHeap.size();
        }
        return size;
    }

    public boolean didStructureChange() {
        return this.mState.didStructureChange();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void dispatchLayout() {
        super.dispatchLayout();
    }

    public void enableOverPullIfNeeded() {
        boolean z16;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null) {
            z16 = layoutManager.canScrollVertically();
        } else {
            z16 = false;
        }
        if (this.enableOverDrag && z16) {
            if (this.overPullHelper == null) {
                this.overPullHelper = new HippyOverPullHelper(this);
            }
            this.overPullHelper.setOverPullListener(this.overPullListener);
        } else {
            HippyOverPullHelper hippyOverPullHelper = this.overPullHelper;
            if (hippyOverPullHelper != null) {
                hippyOverPullHelper.destroy();
            }
            this.overPullHelper = null;
        }
    }

    public ArrayList<RecyclerView.ViewHolder> getCachedViewHolders() {
        ArrayList<RecyclerView.ViewHolder> arrayList = new ArrayList<>();
        arrayList.addAll(this.mRecycler.mAttachedScrap);
        arrayList.addAll(this.mRecycler.mCachedViews);
        for (int i3 = 0; i3 < this.mRecycler.getRecycledViewPool().mScrap.size(); i3++) {
            arrayList.addAll(this.mRecycler.getRecycledViewPool().mScrap.valueAt(i3).mScrapHeap);
        }
        return arrayList;
    }

    public View getChildAtWithCaches(int i3) {
        ArrayList<RecyclerView.ViewHolder> cachedViewHolders = getCachedViewHolders();
        if (i3 < cachedViewHolders.size()) {
            return cachedViewHolders.get(i3).itemView;
        }
        return getChildAt(i3 - cachedViewHolders.size());
    }

    public int getChildCountWithCaches() {
        return getCachedViewHolderCount() + getChildCount();
    }

    public int getFirstChildPosition() {
        View view;
        if (getChildCount() > 0) {
            view = getChildAt(0);
        } else {
            view = null;
        }
        return getChildLayoutPosition(view);
    }

    public RecyclerView.ViewHolder getFistChildViewHolder() {
        View childAt = getChildAt(0);
        if (childAt != null && (childAt.getLayoutParams() instanceof RecyclerView.LayoutParams)) {
            return ((RecyclerView.LayoutParams) childAt.getLayoutParams()).mViewHolder;
        }
        return null;
    }

    public int getLashChildPosition() {
        View view;
        if (getChildCount() > 0) {
            view = getChildAt(getChildCount() - 1);
        } else {
            view = null;
        }
        return getChildLayoutPosition(view);
    }

    public int getOverPullDownOffset() {
        HippyOverPullHelper hippyOverPullHelper = this.overPullHelper;
        if (hippyOverPullHelper != null) {
            return hippyOverPullHelper.getOverPullDownOffset();
        }
        return 0;
    }

    public int getOverPullState() {
        HippyOverPullHelper hippyOverPullHelper = this.overPullHelper;
        if (hippyOverPullHelper != null) {
            return hippyOverPullHelper.getOverPullState();
        }
        return 0;
    }

    public int getOverPullUpOffset() {
        HippyOverPullHelper hippyOverPullHelper = this.overPullHelper;
        if (hippyOverPullHelper != null) {
            return hippyOverPullHelper.getOverPullUpOffset();
        }
        return 0;
    }

    public VelocityTracker getVelocityTracker() {
        if (this.velocityTracker == null) {
            try {
                Field declaredField = RecyclerView.class.getDeclaredField("mVelocityTracker");
                declaredField.setAccessible(true);
                this.velocityTracker = (VelocityTracker) declaredField.get(this);
            } catch (IllegalAccessException | NoSuchFieldException e16) {
                e16.printStackTrace();
            }
        }
        return this.velocityTracker;
    }

    public RecyclerView.ViewHolder getViewHolderForPosition(int i3) {
        View viewForPosition = this.mRecycler.getViewForPosition(i3);
        if (viewForPosition.getLayoutParams() instanceof RecyclerView.LayoutParams) {
            return ((RecyclerView.LayoutParams) viewForPosition.getLayoutParams()).mViewHolder;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void invalidateGlows() {
        super.invalidateGlows();
    }

    public boolean isDataChangedWithoutNotify() {
        if (getAdapter().getItemCount() != this.mState.getItemCount()) {
            return true;
        }
        return false;
    }

    public boolean isEnableOverDrag() {
        return this.enableOverDrag;
    }

    public boolean isOverPulling() {
        int overPullState = getOverPullState();
        if (overPullState == 1 || overPullState == 2 || overPullState == 4) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        HippyOverPullHelper hippyOverPullHelper = this.overPullHelper;
        if (hippyOverPullHelper != null && hippyOverPullHelper.onTouchEvent(motionEvent)) {
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        HippyOverPullHelper hippyOverPullHelper2 = this.overPullHelper;
        if (hippyOverPullHelper2 != null) {
            hippyOverPullHelper2.handleEventUp(motionEvent);
        }
        return onTouchEvent;
    }

    public void recycleAndClearCachedViews() {
        this.mRecycler.recycleAndClearCachedViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
    }

    public void setEnableOverPull(boolean z16) {
        this.enableOverDrag = z16;
        enableOverPullIfNeeded();
    }

    public void setOverPullListener(HippyOverPullListener hippyOverPullListener) {
        this.overPullListener = hippyOverPullListener;
        HippyOverPullHelper hippyOverPullHelper = this.overPullHelper;
        if (hippyOverPullHelper != null) {
            hippyOverPullHelper.setOverPullListener(hippyOverPullListener);
        }
    }

    public void smoothScrollBy(int i3, int i16, int i17) {
        smoothScrollBy(i3, i16, null, i17);
    }

    public RecyclerViewBase(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public RecyclerViewBase(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
    }
}
