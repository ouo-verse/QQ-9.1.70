package com.tencent.mtt.supportui.views.recyclerview;

import android.content.Context;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import com.tencent.mtt.supportui.utils.ViewCompatTool;
import com.tencent.mtt.supportui.utils.struct.ArrayMap;
import com.tencent.mtt.supportui.utils.struct.Pools;
import com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class RecyclerViewBase extends ViewGroup {
    protected static final int AUTO_SCROLL_DELAY_DURATION = 800;
    public static final boolean DEBUG = false;
    public static final int DIRECTION_DOWN = 1;
    public static final int DIRECTION_UP = -1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    static final boolean ENABLE_PREDICTIVE_ANIMATIONS = false;
    public static final int HORIZONTAL = 0;
    static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    public static final int LAYOUT_TYPE_GRID = 2;
    public static final int LAYOUT_TYPE_LIST = 1;
    public static final int LAYOUT_TYPE_WATERFALL = 3;
    static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = Integer.MIN_VALUE;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerViewBase";
    private static final int TOUCH_DOWN_WHEN_SETTING_CHECK_INTERVAL = 50;
    public static final int TRAVERSAL_PURPOSE_ITEMCHANGE = 1991103;
    public static final int TRAVERSAL_PURPOSE_MODECHANGE = 1991102;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator = new Interpolator() { // from class: com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.3
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            float f17 = f16 - 1.0f;
            return (f17 * f17 * f17 * f17 * f17) + 1.0f;
        }
    };
    private IBlockTouchListener blockTouchListener;
    public boolean checkNotifyFooterOnRelease;
    public boolean filterCheckNotifyFooterAppeared;
    protected boolean forceBlockTouch;
    protected boolean isAutoScrolling;
    OnItemTouchListener mActiveOnItemTouchListener;
    public Adapter<ViewHolder> mAdapter;
    boolean mAdapterUpdateDuringMeasure;
    public boolean mAnimatingBlockTouch;
    int mAnimatingViewIndex;
    int mAnimatingViewPos;
    int mAnimatingViewPrevPos;
    protected AutoScrollRunnable mAutoScrollRunnable;
    protected boolean mBlockScroll;
    private boolean mDisallowParentInterceptTouchEventWhenDrag;
    protected boolean mDownOverScrollEnabled;
    boolean mEatRequestLayout;
    private boolean mEnableRecyclerViewTouchListener;
    protected boolean mEnterCalled;
    protected int mEnterPos;
    protected boolean mExchangeFromBigger;
    protected boolean mExitCalled;
    protected int mExitPos;
    boolean mHasFixedSize;
    boolean mHasSuspentedItem;
    protected boolean mHorizontalCanScroll;
    boolean mInPreLayout;
    protected int mInitialTouchX;
    protected int mInitialTouchY;
    boolean mIsAttached;
    protected boolean mIsChangingMode;
    boolean mIsTouching;
    protected Runnable mItemAnimatorRunner;
    final ArrayList<ItemDecoration> mItemDecorations;
    protected boolean mItemsAddedOrRemoved;
    protected boolean mItemsChanged;
    protected int mLastTouchX;
    protected int mLastTouchY;
    public LayoutManager mLayout;
    boolean mLayoutRequestEaten;
    public int mLayoutType;
    final int mMaxFlingVelocity;
    final int mMinFlingVelocity;
    public int mNeedStopAtTitleIndex;
    int mNumAnimatingViews;
    final RecyclerViewDataObserver mObserver;
    public int mOffsetX;
    public int mOffsetY;
    final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    final ArrayList<UpdateOp> mPendingLayoutUpdates;
    SavedState mPendingSavedState;
    final ArrayList<UpdateOp> mPendingUpdates;
    final boolean mPostUpdatesOnAnimation;
    protected boolean mPostedAnimatorRunner;
    protected Recycler mRecycler;
    OnScrollListener mScrollListener;
    protected int mScrollPointerId;
    protected boolean mScrollRunnablePosted;
    protected int mScrollState;
    private boolean mShouldPrebindItem;
    public final State mState;
    boolean mStopAtTitle;
    final Rect mTempRect;
    private Runnable mTouchDownWhenSettlingCheckRunnable;
    private boolean mTouchDownWhenSettlingFlag;
    private int mTouchEventState;
    protected final int mTouchSlop;
    protected boolean mUpOverScrollEnabled;
    final Runnable mUpdateChildViewsRunnable;
    Pools.Pool<UpdateOp> mUpdateOpPool;
    boolean mUseRepeatableSuspensionMode;
    protected VelocityTracker mVelocityTracker;
    protected boolean mVerticalCanScroll;
    public final ViewFlinger mViewFlinger;
    public boolean needNotifyFooter;
    public boolean optimizeHeaderRefresh;
    int[] tmpResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        AdapterDataObservable() {
        }

        public boolean hasObservers() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void notifyChanged() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public void notifyItemRangeChanged(int i3, int i16) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i3, i16);
            }
        }

        public void notifyItemRangeInserted(int i3, int i16) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i3, i16);
            }
        }

        public void notifyItemRangeRemoved(int i3, int i16) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i3, i16);
            }
        }

        public void notifyItemsRemoved(ArrayList<Integer> arrayList) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemsRemoved(arrayList);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class AutoScrollRunnable implements Runnable {
        public boolean cancel;
        public int dir = -1;

        public AutoScrollRunnable() {
        }

        public void cancelPost(boolean z16) {
            this.cancel = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            if (this.dir > 0) {
                z16 = RecyclerViewBase.this.mDownOverScrollEnabled;
            } else {
                z16 = RecyclerViewBase.this.mUpOverScrollEnabled;
            }
            RecyclerViewBase.this.setOverScrollEnabled(false);
            RecyclerViewBase recyclerViewBase = RecyclerViewBase.this;
            recyclerViewBase.scrollBy(0, recyclerViewBase.getAutoScrollVelocity() * this.dir);
            if (!this.cancel) {
                RecyclerViewBase.this.postDelayed(this, 16L);
            }
            RecyclerViewBase.this.setOverScrollEnabled(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class ItemHolderInfo {
        public ViewHolder holder;
        public int left;
        public int top;

        ItemHolderInfo(ViewHolder viewHolder, int i3, int i16, int i17, int i18, int i19) {
            this.holder = viewHolder;
            this.left = i3;
            this.top = i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static abstract class LayoutManager {
        public static final int INVALID_OFFSET = Integer.MIN_VALUE;
        public RecyclerViewBase mRecyclerView;
        public SmoothScroller mSmoothScroller;
        public boolean mPreventFixGap = false;
        public int mPendingScrollPosition = Integer.MIN_VALUE;
        protected int mPendingScrollPositionOffset = Integer.MIN_VALUE;

        /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
        
            if (r3 >= 0) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int getChildMeasureSpec(int i3, int i16, int i17, boolean z16) {
            int i18 = i3 - i16;
            int i19 = 0;
            int max = Math.max(0, i18);
            if (!z16) {
                if (i17 < 0) {
                    if (i17 == -1) {
                        i17 = max;
                    } else {
                        if (i17 == -2) {
                            i19 = Integer.MIN_VALUE;
                            i17 = max;
                        }
                        i17 = 0;
                    }
                }
                i19 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(i17, i19);
        }

        public void addView(View view) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            int i3 = this.mRecyclerView.mAnimatingViewIndex;
            if (i3 < 0) {
                i3 = -1;
            }
            addView(view, i3);
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            if (layoutParams != null) {
                return true;
            }
            return false;
        }

        public int computeHorizontalScrollExtent(State state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(State state) {
            return 0;
        }

        public int computeHorizontalScrollRange(State state) {
            return 0;
        }

        public int computeVerticalScrollExtent(State state) {
            return 0;
        }

        public int computeVerticalScrollOffset(State state) {
            return 0;
        }

        public int computeVerticalScrollRange(State state) {
            return 0;
        }

        public void detachAndScrapAttachedViews(Recycler recycler) {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase != null && recyclerViewBase.needAdvancedStopDetachChildView()) {
                return;
            }
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                detachViewAt(childCount);
                if (childAt instanceof RecyclerViewItem) {
                    recycler.scrapView(childAt);
                }
            }
        }

        public void detachAndScrapView(View view, Recycler recycler) {
            detachView(view);
            recycler.scrapView(view);
        }

        public void detachAndScrapViewAt(int i3, Recycler recycler) {
            View childAt = getChildAt(i3);
            detachViewAt(i3);
            recycler.scrapView(childAt);
        }

        public void detachView(View view) {
            if (view == null) {
                return;
            }
            if (view == this.mRecyclerView.findFocus()) {
                this.mRecyclerView.clearChildFocus(view);
            }
            if (view.hasFocus()) {
                view.clearFocus();
            }
            this.mRecyclerView.detachViewFromParent(view);
        }

        public void detachViewAt(int i3) {
            View childAt = this.mRecyclerView.getChildAt(i3);
            if (childAt == null) {
                return;
            }
            if (childAt == this.mRecyclerView.findFocus()) {
                this.mRecyclerView.clearChildFocus(childAt);
            }
            if (!(childAt instanceof IRecyclerViewFooter)) {
                this.mRecyclerView.detachViewFromParent(i3);
            } else {
                this.mRecyclerView.removeView(childAt);
            }
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            int i16 = recyclerViewBase.mAnimatingViewIndex;
            if (i16 >= 0) {
                recyclerViewBase.mAnimatingViewIndex = i16 - 1;
            }
        }

        public View findViewByPosition(int i3) {
            int childCount = getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = getChildAt(i16);
                if (getPosition(childAt) == i3) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public View getChildAt(int i3) {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase != null) {
                return recyclerViewBase.getChildAt(i3);
            }
            return null;
        }

        public View getChildClosestToEndByOrder() {
            return null;
        }

        public View getChildClosestToEndInScreen() {
            return null;
        }

        public View getChildClosestToStartByOrder() {
            return null;
        }

        public View getChildClosestToStartInScreen() {
            return null;
        }

        public int getChildCount() {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase != null) {
                return recyclerViewBase.getChildCount() - this.mRecyclerView.mNumAnimatingViews;
            }
            return 0;
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + ((LayoutParams) view.getLayoutParams()).mDecorInsets.bottom;
        }

        public int getDecoratedEnd(View view) {
            return 0;
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - ((LayoutParams) view.getLayoutParams()).mDecorInsets.left;
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + ((LayoutParams) view.getLayoutParams()).mDecorInsets.right;
        }

        public int getDecoratedStart(View view) {
            return 0;
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - ((LayoutParams) view.getLayoutParams()).mDecorInsets.top;
        }

        public View getFirstItemAfterOffset(int i3) {
            int childCount = getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = getChildAt(i16);
                if (getDecoratedStart(childAt) > i3) {
                    return childAt;
                }
            }
            return null;
        }

        public View getFirstItemBeforeOffset(int i3) {
            int childCount = getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = getChildAt(i16);
                if (getDecoratedStart(childAt) < i3) {
                    return childAt;
                }
            }
            return null;
        }

        public int getHeight() {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase != null) {
                return recyclerViewBase.getHeight();
            }
            return 0;
        }

        public int getItemCount() {
            Adapter adapter;
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase != null) {
                adapter = recyclerViewBase.getAdapter();
            } else {
                adapter = null;
            }
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getLayoutType() {
            return 1;
        }

        public int getMinimumHeight() {
            return ViewCompatTool.getMinimumHeight(this.mRecyclerView);
        }

        public int getMinimumWidth() {
            return ViewCompatTool.getMinimumWidth(this.mRecyclerView);
        }

        public int getPaddingBottom() {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase != null) {
                return recyclerViewBase.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase != null) {
                return recyclerViewBase.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase != null) {
                return recyclerViewBase.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase != null) {
                return recyclerViewBase.getPaddingTop();
            }
            return 0;
        }

        public int getPendingOffset() {
            return 0;
        }

        public int getPendingPosition() {
            return 0;
        }

        public int getPosition(View view) {
            if (view != null && view.getLayoutParams() != null) {
                return ((LayoutParams) view.getLayoutParams()).getViewPosition();
            }
            return Integer.MIN_VALUE;
        }

        public int getTotalHeight() {
            return Integer.MIN_VALUE;
        }

        public int getWidth() {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase != null) {
                return recyclerViewBase.getWidth();
            }
            return 0;
        }

        public boolean hasFocus() {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase != null && recyclerViewBase.hasFocus()) {
                return true;
            }
            return false;
        }

        public boolean isFocused() {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase != null && recyclerViewBase.isFocused()) {
                return true;
            }
            return false;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            if (smoothScroller != null && smoothScroller.isRunning()) {
                return true;
            }
            return false;
        }

        public void layoutDecorated(View view, int i3, int i16, int i17, int i18) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            view.layout(i3 + rect.left, i16 + rect.top, i17 - rect.right, i18 - rect.bottom);
        }

        public void measureChild(View view, int i3, int i16) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            view.measure(getChildMeasureSpec(getWidth(), getPaddingLeft() + getPaddingRight() + i3 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally()), getChildMeasureSpec(getHeight(), getPaddingTop() + getPaddingBottom() + i16 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically()));
        }

        public void measureChildWithMargins(View view, int i3, int i16) {
            LayoutParams generateDefaultLayoutParams;
            if (view == null) {
                return;
            }
            if (view.getLayoutParams() != null) {
                generateDefaultLayoutParams = (LayoutParams) view.getLayoutParams();
            } else {
                generateDefaultLayoutParams = generateDefaultLayoutParams();
            }
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i17 = i3 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i18 = i16 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            view.measure(getChildMeasureSpec(getWidth(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).rightMargin + i17, ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).width, canScrollHorizontally()), getChildMeasureSpec(getHeight(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).topMargin + ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).bottomMargin + i18, ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).height, canScrollVertically()));
        }

        public void offsetChildrenHorizontal(int i3) {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase != null) {
                recyclerViewBase.offsetChildrenHorizontal(i3);
            }
        }

        public void offsetChildrenVertical(int i3) {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase != null) {
                recyclerViewBase.offsetChildrenVertical(i3);
            }
        }

        public boolean onAddFocusables(RecyclerViewBase recyclerViewBase, ArrayList<View> arrayList, int i3, int i16) {
            return false;
        }

        public LayoutParams onCreateItemLayoutParams(RecyclerView.ViewHolderWrapper viewHolderWrapper, int i3, int i16, int i17) {
            return new LayoutParams(-2, -2);
        }

        public View onFocusSearchFailed(View view, int i3, Recycler recycler, State state) {
            return null;
        }

        public View onInterceptFocusSearch(View view, int i3) {
            return null;
        }

        public void onMeasure(Recycler recycler, State state, int i3, int i16) {
            int mode = View.MeasureSpec.getMode(i3);
            int mode2 = View.MeasureSpec.getMode(i16);
            int size = View.MeasureSpec.getSize(i3);
            int size2 = View.MeasureSpec.getSize(i16);
            if (mode != Integer.MIN_VALUE && mode != 1073741824) {
                size = getMinimumWidth();
            }
            if (mode2 != Integer.MIN_VALUE && mode2 != 1073741824) {
                size2 = getMinimumHeight();
            }
            setMeasuredDimension(size, size2);
        }

        public boolean onRequestChildFocus(RecyclerViewBase recyclerViewBase, View view, View view2) {
            return false;
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        void onSmoothScrollerStopped(SmoothScroller smoothScroller) {
            if (this.mSmoothScroller == smoothScroller) {
                this.mSmoothScroller = null;
            }
        }

        public void removeAllViews() {
            Adapter adapter = this.mRecyclerView.getAdapter();
            int childCount = this.mRecyclerView.getChildCount() - this.mRecyclerView.mNumAnimatingViews;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.mRecyclerView.getChildAt(i3);
                if (adapter != null) {
                    adapter.onViewDetachedFromWindow(RecyclerViewBase.getChildViewHolderInt(childAt));
                }
                this.mRecyclerView.onChildDetachedFromWindow(childAt);
            }
            for (int i16 = childCount - 1; i16 >= 0; i16--) {
                this.mRecyclerView.removeViewAt(i16);
                RecyclerViewBase recyclerViewBase = this.mRecyclerView;
                int i17 = recyclerViewBase.mAnimatingViewIndex;
                if (i17 >= 0) {
                    recyclerViewBase.mAnimatingViewIndex = i17 - 1;
                }
            }
        }

        void removeAndRecycleAllViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                removeAndRecycleViewAt(childCount, recycler);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void removeAndRecycleScrapInt(Recycler recycler, boolean z16, boolean z17) {
            int scrapCount = recycler.getScrapCount();
            for (int i3 = 0; i3 < scrapCount; i3++) {
                View scrapViewAt = recycler.getScrapViewAt(i3);
                if (scrapViewAt instanceof RecyclerViewItem) {
                    if (z16) {
                        this.mRecyclerView.removeDetachedView(scrapViewAt, false);
                    }
                    if (z17) {
                        recycler.quickRecycleScrapView(scrapViewAt);
                    }
                }
            }
            recycler.clearScrap();
            if (z16 && scrapCount > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(View view, Recycler recycler) {
            removeView(view);
            recycler.recycleView(view);
        }

        public void removeAndRecycleViewAt(int i3, Recycler recycler) {
            View childAt = getChildAt(i3);
            removeViewAt(i3);
            recycler.recycleView(childAt);
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void removeView(View view) {
            Adapter adapter = this.mRecyclerView.getAdapter();
            if (adapter != null) {
                adapter.onViewDetachedFromWindow(RecyclerViewBase.getChildViewHolderInt(view));
            }
            this.mRecyclerView.onChildDetachedFromWindow(view);
            this.mRecyclerView.removeView(view);
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            int i3 = recyclerViewBase.mAnimatingViewIndex;
            if (i3 >= 0) {
                recyclerViewBase.mAnimatingViewIndex = i3 - 1;
            }
        }

        public void removeViewAt(int i3) {
            ViewHolder viewHolder;
            View childAt = this.mRecyclerView.getChildAt(i3);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams != null && (layoutParams instanceof LayoutParams) && (viewHolder = ((LayoutParams) layoutParams).mViewHolder) != null) {
                    int i16 = viewHolder.mViewType;
                    if (i16 == -2) {
                        State state = this.mRecyclerView.mState;
                        state.mFooterCountInScreen--;
                    }
                    if (i16 == -1) {
                        State state2 = this.mRecyclerView.mState;
                        state2.mHeaderCountInScreen--;
                    }
                }
                Adapter adapter = this.mRecyclerView.getAdapter();
                if (adapter != null) {
                    adapter.onViewDetachedFromWindow(RecyclerViewBase.getChildViewHolderInt(childAt));
                }
                this.mRecyclerView.onChildDetachedFromWindow(childAt);
                this.mRecyclerView.removeViewAt(i3);
                RecyclerViewBase recyclerViewBase = this.mRecyclerView;
                int i17 = recyclerViewBase.mAnimatingViewIndex;
                if (i17 >= 0) {
                    recyclerViewBase.mAnimatingViewIndex = i17 - 1;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
        
            r8.scrollBy(r1, r9);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean requestChildRectangleOnScreen(RecyclerViewBase recyclerViewBase, View view, Rect rect, boolean z16) {
            try {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                int width = getWidth() - getPaddingRight();
                int height = getHeight() - getPaddingBottom();
                int left = view.getLeft() + rect.left;
                int top = view.getTop() + rect.top;
                int i3 = rect.right + left;
                int i16 = rect.bottom + top;
                int min = Math.min(0, left - paddingLeft);
                int min2 = Math.min(0, top - paddingTop);
                int max = Math.max(0, i3 - width);
                int max2 = Math.max(0, i16 - height);
                if (min == 0) {
                    min = max;
                }
                if (min2 == 0) {
                    min2 = max2;
                }
                if (min == 0 && min2 == 0) {
                    return false;
                }
                recyclerViewBase.smoothScrollBy(min, min2, false);
                if (recyclerViewBase.needNotifyFooter && !recyclerViewBase.checkNotifyFooterOnRelease) {
                    recyclerViewBase.needNotifyFooter = false;
                    recyclerViewBase.mRecycler.notifyLastFooterAppeared();
                    return true;
                }
                return true;
            } catch (StackOverflowError unused) {
                return false;
            }
        }

        public void requestLayout() {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase != null) {
                recyclerViewBase.requestLayout();
            }
        }

        public int scrollHorizontallyBy(int i3, Recycler recycler, State state) {
            return 0;
        }

        public abstract void scrollToPositionWithOffset(int i3, int i16);

        public int scrollVerticallyBy(int i3, Recycler recycler, State state) {
            return 0;
        }

        public void setMeasuredDimension(int i3, int i16) {
            this.mRecyclerView.setMeasuredDimension(i3, i16);
        }

        public void startSmoothScroll(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.mSmoothScroller;
            if (smoothScroller2 != null && smoothScroller != smoothScroller2 && smoothScroller2.isRunning()) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = smoothScroller;
            smoothScroller.start(this.mRecyclerView, this);
        }

        void stopSmoothScroller() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            if (smoothScroller != null) {
                smoothScroller.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public void addView(View view, int i3) {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase == null) {
                return;
            }
            int i16 = recyclerViewBase.mAnimatingViewIndex;
            if (i16 >= 0) {
                if (i3 > i16) {
                    throw new IndexOutOfBoundsException("index=" + i3 + " count=" + this.mRecyclerView.mAnimatingViewIndex);
                }
                recyclerViewBase.mAnimatingViewIndex = i16 + 1;
            }
            ViewHolder childViewHolderInt = RecyclerViewBase.getChildViewHolderInt(view);
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
                this.mRecyclerView.attachViewToParent(view, i3, view.getLayoutParams());
                return;
            }
            this.mRecyclerView.addView(view, i3);
            ((LayoutParams) view.getLayoutParams()).mInsetsDirty = true;
            Adapter adapter = this.mRecyclerView.getAdapter();
            if (adapter != null) {
                adapter.onViewAttachedToWindow(RecyclerViewBase.getChildViewHolderInt(view));
            }
            this.mRecyclerView.onChildAttachedToWindow(view);
            SmoothScroller smoothScroller = this.mSmoothScroller;
            if (smoothScroller == null || !smoothScroller.isRunning()) {
                return;
            }
            this.mSmoothScroller.onChildAttachedToWindow(view);
        }

        public void attachView(View view, int i3) {
            attachView(view, i3, (LayoutParams) view.getLayoutParams());
        }

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
        }

        public void attachView(View view, int i3, LayoutParams layoutParams) {
            this.mRecyclerView.attachViewToParent(view, i3, layoutParams);
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            int i16 = recyclerViewBase.mAnimatingViewIndex;
            if (i16 >= 0) {
                recyclerViewBase.mAnimatingViewIndex = i16 + 1;
            }
        }

        public void clear() {
        }

        public void onAttachedToWindow(RecyclerViewBase recyclerViewBase) {
        }

        public void onDetachedFromWindow(RecyclerViewBase recyclerViewBase) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public void scrollToPosition(int i3) {
        }

        public void calculateOffsetMap(SparseIntArray sparseIntArray, int i3) {
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter2) {
        }

        public void onLayoutChildren(Recycler recycler, State state) {
        }

        public void onItemsAdded(RecyclerViewBase recyclerViewBase, int i3, int i16) {
        }

        public void onItemsRemoved(RecyclerViewBase recyclerViewBase, int i3, int i16) {
        }

        public void scrollToPositionWidthGravity(int i3, int i16, int i17) {
        }

        public void smoothScrollToPosition(RecyclerViewBase recyclerViewBase, State state, int i3) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        protected final Rect mDecorInsets;
        protected boolean mInsetsDirty;
        public ViewHolder mViewHolder;

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
        }

        public int getViewPosition() {
            ViewHolder viewHolder = this.mViewHolder;
            if (viewHolder == null) {
                return 0;
            }
            return viewHolder.mPosition;
        }

        public boolean isItemRemoved() {
            ViewHolder viewHolder = this.mViewHolder;
            if (viewHolder == null) {
                return true;
            }
            return viewHolder.isRemoved();
        }

        public boolean isViewInvalid() {
            ViewHolder viewHolder = this.mViewHolder;
            if (viewHolder == null) {
                return false;
            }
            return viewHolder.isInvalid();
        }

        public boolean viewNeedsUpdate() {
            ViewHolder viewHolder = this.mViewHolder;
            if (viewHolder == null) {
                return false;
            }
            return viewHolder.needsUpdate();
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(RecyclerViewBase recyclerViewBase, MotionEvent motionEvent);

        void onTouchEvent(RecyclerViewBase recyclerViewBase, MotionEvent motionEvent);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface OnScrollFinishListener {
        void onScrollFinished();
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface OnScrollListener {
        void onScrollStateChanged(int i3, int i16);

        void onScrolled(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class RecycledViewPool {
        public SparseArray<ViewHolderArrayList> mScrap = new SparseArray<>();
        protected SparseIntArray mMaxScrap = new SparseIntArray();
        int mAttachCount = 0;
        public int DEFAULT_MAX_SCRAP = 10;

        void attach(Adapter adapter) {
            this.mAttachCount++;
        }

        public void clear() {
            this.mScrap.clear();
        }

        void detach() {
            this.mAttachCount--;
        }

        public String dump() {
            return "";
        }

        public ViewHolder getRecycledView(int i3, String str) {
            ViewHolderArrayList viewHolderArrayList = this.mScrap.get(i3);
            if (viewHolderArrayList != null && !viewHolderArrayList.isEmpty()) {
                Log.d(RecyclerViewBase.TAG, "getRecycledView--> scrapHeap.size : " + viewHolderArrayList.size());
                ViewHolder viewHolder = (ViewHolder) viewHolderArrayList.get(viewHolderArrayList.size() + (-1));
                if (!TextUtils.isEmpty(str)) {
                    int i16 = 0;
                    while (true) {
                        if (i16 >= viewHolderArrayList.size()) {
                            break;
                        }
                        ViewHolder viewHolder2 = (ViewHolder) viewHolderArrayList.get(i16);
                        if (TextUtils.equals(str, viewHolder2.mHolderReuseKey)) {
                            Log.d(RecyclerViewBase.TAG, "getRecycledView-->reqReuseKey: " + str + ",found key:" + viewHolder2.mHolderReuseKey);
                            viewHolder = viewHolder2;
                            break;
                        }
                        i16++;
                    }
                }
                viewHolder.mHolderReuseKey = str;
                viewHolderArrayList.remove(viewHolder);
                return viewHolder;
            }
            return null;
        }

        public ArrayList<ViewHolder> getScrapHeapForType(int i3) {
            ViewHolderArrayList viewHolderArrayList = this.mScrap.get(i3);
            if (viewHolderArrayList == null) {
                viewHolderArrayList = new ViewHolderArrayList();
                this.mScrap.put(i3, viewHolderArrayList);
                if (this.mMaxScrap.indexOfKey(i3) < 0) {
                    this.mMaxScrap.put(i3, this.DEFAULT_MAX_SCRAP);
                }
            }
            return viewHolderArrayList;
        }

        void onAdapterChanged(Adapter adapter, Adapter adapter2) {
            if (this.mAttachCount == 1) {
                clear();
            }
        }

        public void putRecycledView(ViewHolder viewHolder, Adapter adapter) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<ViewHolder> scrapHeapForType = getScrapHeapForType(itemViewType);
            if (this.mMaxScrap.get(itemViewType) <= scrapHeapForType.size()) {
                if (adapter != null) {
                    adapter.onViewAbandon(viewHolder);
                }
            } else {
                viewHolder.mPosition = Integer.MIN_VALUE;
                viewHolder.mOldPosition = Integer.MIN_VALUE;
                viewHolder.mItemId = -1L;
                viewHolder.clearFlagsForSharedPool();
                scrapHeapForType.add(viewHolder);
            }
        }

        public void setMaxRecycledViews(int i3, int i16, Adapter adapter) {
            this.mMaxScrap.put(i3, i16);
            ViewHolderArrayList viewHolderArrayList = this.mScrap.get(i3);
            if (viewHolderArrayList != null) {
                while (viewHolderArrayList.size() > i16) {
                    ViewHolder remove = viewHolderArrayList.remove(viewHolderArrayList.size() - 1);
                    if (adapter != null) {
                        adapter.onViewAbandon(remove);
                    }
                }
            }
        }

        @Deprecated
        public void setMaxScrapNum(int i3) {
            if (i3 <= this.DEFAULT_MAX_SCRAP) {
                return;
            }
            this.DEFAULT_MAX_SCRAP = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class RecyclerViewDataObserver extends AdapterDataObserver {
        RecyclerViewDataObserver() {
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.AdapterDataObserver
        public void onChanged() {
            int i3;
            RecyclerViewBase.this.markKnownViewsInvalid();
            RecyclerViewBase.this.removeAnimatingViews();
            RecyclerViewBase recyclerViewBase = RecyclerViewBase.this;
            State state = recyclerViewBase.mState;
            state.mDataChanged = true;
            state.mStructureChanged = true;
            View childClosestToStartByOrder = recyclerViewBase.mLayout.getChildClosestToStartByOrder();
            if (childClosestToStartByOrder != null) {
                int pendingPosition = RecyclerViewBase.this.mLayout.getPendingPosition();
                int pendingOffset = RecyclerViewBase.this.mLayout.getPendingOffset();
                if (pendingPosition == Integer.MIN_VALUE) {
                    pendingPosition = RecyclerViewBase.this.mLayout.getPosition(childClosestToStartByOrder);
                    if (pendingOffset == Integer.MIN_VALUE) {
                        int decoratedStart = RecyclerViewBase.this.mLayout.getDecoratedStart(childClosestToStartByOrder);
                        if (RecyclerViewBase.this.mLayout.canScrollHorizontally()) {
                            i3 = RecyclerViewBase.this.mState.mCustomHeaderWidth;
                        } else {
                            i3 = RecyclerViewBase.this.mState.mCustomHeaderHeight;
                        }
                        pendingOffset = decoratedStart + i3;
                    }
                }
                RecyclerViewBase.this.scrollToPositionWithOffset(RecyclerViewBase.this.validateAnchorItemPosition(pendingPosition), pendingOffset);
                return;
            }
            RecyclerViewBase.this.requestLayout();
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16) {
            RecyclerViewBase recyclerViewBase = RecyclerViewBase.this;
            recyclerViewBase.postAdapterUpdate(recyclerViewBase.obtainUpdateOp(2, i3, i16));
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i16) {
            RecyclerViewBase recyclerViewBase = RecyclerViewBase.this;
            recyclerViewBase.postAdapterUpdate(recyclerViewBase.obtainUpdateOp(0, i3, i16));
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i16) {
            RecyclerViewBase recyclerViewBase = RecyclerViewBase.this;
            recyclerViewBase.postAdapterUpdate(recyclerViewBase.obtainUpdateOp(1, i3, i16));
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.AdapterDataObserver
        public void onItemsRemoved(ArrayList<Integer> arrayList) {
            UpdateOp obtainUpdateOp = RecyclerViewBase.this.obtainUpdateOp(1, -1, -1);
            obtainUpdateOp.mRemovePositions = arrayList;
            RecyclerViewBase.this.postAdapterUpdate(obtainUpdateOp);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };
        Parcelable mLayoutState;

        SavedState(Parcel parcel) {
            super(parcel);
            this.mLayoutState = parcel.readParcelable(LayoutManager.class.getClassLoader());
        }

        void copyFrom(SavedState savedState) {
            this.mLayoutState = savedState.mLayoutState;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeParcelable(this.mLayoutState, 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static abstract class SmoothScroller {
        LayoutManager mLayoutManager;
        boolean mPendingInitialRun;
        RecyclerViewBase mRecyclerView;
        boolean mRunning;
        View mTargetView;
        int mTargetPosition = Integer.MIN_VALUE;
        final Action mRecyclingAction = new Action(0, 0);

        /* compiled from: P */
        /* loaded from: classes21.dex */
        public static class Action {
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
            boolean changed;
            int consecutiveUpdates;
            int mDuration;
            int mDx;
            int mDy;
            Interpolator mInterpolator;

            public Action(int i3, int i16) {
                this(i3, i16, Integer.MIN_VALUE, null);
            }

            public int getDuration() {
                return this.mDuration;
            }

            public int getDx() {
                return this.mDx;
            }

            public int getDy() {
                return this.mDy;
            }

            public Interpolator getInterpolator() {
                return this.mInterpolator;
            }

            void runInNecessary(RecyclerViewBase recyclerViewBase) {
                if (this.changed) {
                    validate();
                    Interpolator interpolator = this.mInterpolator;
                    if (interpolator == null) {
                        int i3 = this.mDuration;
                        ViewFlinger viewFlinger = recyclerViewBase.mViewFlinger;
                        if (i3 == Integer.MIN_VALUE) {
                            viewFlinger.smoothScrollBy(this.mDx, this.mDy, false);
                        } else {
                            viewFlinger.smoothScrollBy(this.mDx, this.mDy, i3, false);
                        }
                    } else {
                        recyclerViewBase.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, interpolator, false);
                    }
                    this.consecutiveUpdates++;
                    this.changed = false;
                    return;
                }
                this.consecutiveUpdates = 0;
            }

            public void setDuration(int i3) {
                this.changed = true;
                this.mDuration = i3;
            }

            public void setDx(int i3) {
                this.changed = true;
                this.mDx = i3;
            }

            public void setDy(int i3) {
                this.changed = true;
                this.mDy = i3;
            }

            public void setInterpolator(Interpolator interpolator) {
                this.changed = true;
                this.mInterpolator = interpolator;
            }

            public void update(int i3, int i16, int i17, Interpolator interpolator) {
                this.mDx = i3;
                this.mDy = i16;
                this.mDuration = i17;
                this.mInterpolator = interpolator;
                this.changed = true;
            }

            void validate() {
                if (this.mInterpolator != null && this.mDuration < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.mDuration >= 1) {
                } else {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public Action(int i3, int i16, int i17) {
                this(i3, i16, i17, null);
            }

            public Action(int i3, int i16, int i17, Interpolator interpolator) {
                this.changed = false;
                this.consecutiveUpdates = 0;
                this.mDx = i3;
                this.mDy = i16;
                this.mDuration = i17;
                this.mInterpolator = interpolator;
            }
        }

        public View findViewByPosition(int i3) {
            return this.mRecyclerView.mLayout.findViewByPosition(i3);
        }

        public int getChildCount() {
            return this.mRecyclerView.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildPosition(view);
        }

        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        public void instantScrollToPosition(int i3) {
            this.mRecyclerView.scrollToPosition(i3);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void normalize(PointF pointF) {
            float f16 = pointF.x;
            float f17 = pointF.y;
            double sqrt = Math.sqrt((f16 * f16) + (f17 * f17));
            pointF.x = (float) (pointF.x / sqrt);
            pointF.y = (float) (pointF.y / sqrt);
        }

        void onAnimation(int i3, int i16) {
            if (!this.mRunning || this.mTargetPosition == Integer.MIN_VALUE) {
                stop();
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, this.mRecyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.runInNecessary(this.mRecyclerView);
                    stop();
                } else {
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i3, i16, this.mRecyclerView.mState, this.mRecyclingAction);
                this.mRecyclingAction.runInNecessary(this.mRecyclerView);
            }
        }

        protected void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        protected abstract void onSeekTargetStep(int i3, int i16, State state, Action action);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(View view, State state, Action action);

        public void setTargetPosition(int i3) {
            this.mTargetPosition = i3;
        }

        void start(RecyclerViewBase recyclerViewBase, LayoutManager layoutManager) {
            this.mRecyclerView = recyclerViewBase;
            this.mLayoutManager = layoutManager;
            int i3 = this.mTargetPosition;
            if (i3 != Integer.MIN_VALUE) {
                recyclerViewBase.mState.mTargetPosition = i3;
                this.mRunning = true;
                this.mPendingInitialRun = true;
                this.mTargetView = findViewByPosition(getTargetPosition());
                onStart();
                this.mRecyclerView.mViewFlinger.postOnAnimation();
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void stop() {
            if (!this.mRunning) {
                return;
            }
            onStop();
            this.mRecyclerView.mState.mTargetPosition = Integer.MIN_VALUE;
            this.mTargetView = null;
            this.mTargetPosition = Integer.MIN_VALUE;
            this.mPendingInitialRun = false;
            this.mRunning = false;
            this.mLayoutManager.onSmoothScrollerStopped(this);
            this.mLayoutManager = null;
            this.mRecyclerView = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class State {
        SparseArray<Object> mData;
        public int mTotalHeight;
        int mTargetPosition = Integer.MIN_VALUE;
        ArrayMap<ViewHolder, ItemHolderInfo> mPreLayoutHolderMap = new ArrayMap<>();
        ArrayMap<ViewHolder, ItemHolderInfo> mPostLayoutHolderMap = new ArrayMap<>();
        public boolean mDataChanged = false;
        public int mItemCount = 0;
        public int mHeaderCount = 0;
        public boolean overscroll = true;
        public int mFooterCount = 0;
        int mPreviousLayoutItemCount = 0;
        int mDeletedInvisibleItemCountSincePreviousLayout = 0;
        boolean mStructureChanged = false;
        boolean mInPreLayout = false;
        public int mHeaderCountInScreen = 0;
        public int mFooterCountInScreen = 0;
        public int mCustomHeaderHeight = 0;
        public int mCustomFooterHeight = 0;
        public int mCustomHeaderWidth = 0;
        public int mCustomFooterWidth = 0;

        public boolean didStructureChange() {
            return this.mStructureChanged;
        }

        public <T> T get(int i3) {
            SparseArray<Object> sparseArray = this.mData;
            if (sparseArray == null) {
                return null;
            }
            return (T) sparseArray.get(i3);
        }

        public int getItemCount() {
            if (this.mInPreLayout) {
                return this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;
            }
            return this.mItemCount;
        }

        public int getTargetScrollPosition() {
            return this.mTargetPosition;
        }

        public boolean hasTargetScrollPosition() {
            if (this.mTargetPosition != Integer.MIN_VALUE) {
                return true;
            }
            return false;
        }

        public boolean isPreLayout() {
            return this.mInPreLayout;
        }

        public void put(int i3, Object obj) {
            if (this.mData == null) {
                this.mData = new SparseArray<>();
            }
            this.mData.put(i3, obj);
        }

        public void remove(int i3) {
            SparseArray<Object> sparseArray = this.mData;
            if (sparseArray == null) {
                return;
            }
            sparseArray.remove(i3);
        }

        State reset() {
            this.mTargetPosition = Integer.MIN_VALUE;
            SparseArray<Object> sparseArray = this.mData;
            if (sparseArray != null) {
                sparseArray.clear();
            }
            this.mItemCount = 0;
            this.mHeaderCount = 0;
            this.mFooterCount = 0;
            this.mStructureChanged = false;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class UpdateOp {
        public static final int ADD = 0;
        static final int POOL_SIZE = 30;
        public static final int REMOVE = 1;
        public static final int UPDATE = 2;
        public int cmd;
        public int itemCount;
        public ArrayList<Integer> mRemovePositions = null;
        public int positionStart;

        public UpdateOp(int i3, int i16, int i17) {
            this.cmd = i3;
            this.positionStart = i16;
            this.itemCount = i17;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class ViewFlinger implements Runnable {
        int mLastFlingX;
        int mLastFlingY;
        public OnScrollFinishListener mScrollFinishListener;
        Scroller mScroller;
        Interpolator mInterpolator = RecyclerViewBase.sQuinticInterpolator;
        boolean mCareSpringBackMaxDistance = false;
        boolean mEatRunOnAnimationRequest = false;
        boolean mReSchedulePostAnimationCallback = false;
        public int mTargetPosition = Integer.MAX_VALUE;

        public ViewFlinger() {
            this.mScroller = new Scroller(RecyclerViewBase.this.getContext());
        }

        private void reportFinishState() {
            if (this.mScrollFinishListener != null) {
                if (RecyclerViewBase.this.checkShouldCallScrollFinish(this.mScroller, this.mTargetPosition)) {
                    this.mScrollFinishListener.onScrollFinished();
                }
                this.mScrollFinishListener = null;
                this.mTargetPosition = Integer.MAX_VALUE;
            }
        }

        int computeScrollDuration(int i3, int i16, int i17, int i18) {
            boolean z16;
            int height;
            float f16;
            int i19;
            int abs = Math.abs(i3);
            int abs2 = Math.abs(i16);
            if (abs > abs2) {
                z16 = true;
            } else {
                z16 = false;
            }
            int sqrt = (int) Math.sqrt((i17 * i17) + (i18 * i18));
            int sqrt2 = (int) Math.sqrt((i3 * i3) + (i16 * i16));
            RecyclerViewBase recyclerViewBase = RecyclerViewBase.this;
            if (z16) {
                height = recyclerViewBase.getWidth();
            } else {
                height = recyclerViewBase.getHeight();
            }
            int i26 = height / 2;
            if (height != 0) {
                f16 = Math.min(1.0f, (sqrt2 * 1.0f) / height);
            } else {
                f16 = 1.0f;
            }
            float f17 = i26;
            float distanceInfluenceForSnapDuration = f17 + (distanceInfluenceForSnapDuration(f16) * f17);
            if (sqrt > 0) {
                i19 = Math.round(Math.abs(distanceInfluenceForSnapDuration / sqrt) * 1000.0f) * 4;
            } else {
                if (!z16) {
                    abs = abs2;
                }
                float f18 = abs;
                if (height != 0) {
                    i19 = (int) (((f18 / height) + 1.0f) * 300.0f);
                } else {
                    i19 = 300;
                }
            }
            return Math.min(i19, 2000);
        }

        void disableRunOnAnimationRequests() {
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
        }

        float distanceInfluenceForSnapDuration(double d16) {
            return (float) Math.sin((d16 - 0.5d) * 0.4712389167638204d);
        }

        void enableRunOnAnimationRequests() {
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback) {
                postOnAnimation();
            }
        }

        public void fling(int i3, int i16) {
            this.mCareSpringBackMaxDistance = true;
            RecyclerViewBase.this.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            this.mScroller.fling(0, 0, i3, i16, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            postOnAnimation();
        }

        public Scroller getScroller() {
            return this.mScroller;
        }

        public void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
            } else {
                ViewCompatTool.postOnAnimation(RecyclerViewBase.this, this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            int i16;
            int i17;
            RecyclerViewBase.this.consumePendingUpdateOperations();
            Scroller scroller = this.mScroller;
            SmoothScroller smoothScroller = RecyclerViewBase.this.mLayout.mSmoothScroller;
            if (scroller.computeScrollOffset()) {
                int currX = scroller.getCurrX();
                int currY = scroller.getCurrY();
                int i18 = currX - this.mLastFlingX;
                int i19 = currY - this.mLastFlingY;
                this.mLastFlingX = currX;
                this.mLastFlingY = currY;
                RecyclerViewBase recyclerViewBase = RecyclerViewBase.this;
                if (recyclerViewBase.mAdapter != null) {
                    recyclerViewBase.eatRequestLayout();
                    if (i18 != 0) {
                        int i26 = RecyclerViewBase.this.computeDxDy(i18, 0, this.mCareSpringBackMaxDistance, scroller, false)[0];
                        RecyclerViewBase recyclerViewBase2 = RecyclerViewBase.this;
                        i3 = i26;
                        i16 = i26 - recyclerViewBase2.mLayout.scrollHorizontallyBy(i26, recyclerViewBase2.mRecycler, recyclerViewBase2.mState);
                    } else {
                        i3 = i18;
                        i16 = 0;
                    }
                    if (i19 != 0) {
                        int i27 = RecyclerViewBase.this.computeDxDy(0, i19, this.mCareSpringBackMaxDistance, scroller, false)[1];
                        RecyclerViewBase recyclerViewBase3 = RecyclerViewBase.this;
                        i17 = i27 - recyclerViewBase3.mLayout.scrollVerticallyBy(i27, recyclerViewBase3.mRecycler, recyclerViewBase3.mState);
                        i19 = i27;
                    } else {
                        i17 = 0;
                    }
                    if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                        smoothScroller.onAnimation(i3 - i16, i19 - i17);
                    }
                    RecyclerViewBase.this.resumeRequestLayout(false);
                    i18 = i3;
                }
                if (!RecyclerViewBase.this.mItemDecorations.isEmpty()) {
                    RecyclerViewBase.this.invalidate();
                }
                RecyclerViewBase.this.checkRefreshHeadOnFlingRun();
                OnScrollListener onScrollListener = RecyclerViewBase.this.mScrollListener;
                if (onScrollListener != null && (currX != 0 || currY != 0)) {
                    onScrollListener.onScrolled(i18, i19);
                }
                RecyclerViewBase.this.invalidate();
            }
            if (smoothScroller != null && smoothScroller.isPendingInitialRun()) {
                smoothScroller.onAnimation(0, 0);
            }
            if (scroller.isFinished()) {
                reportFinishState();
                RecyclerViewBase.this.handleRefreshHeadOnFlingRunEnd();
                RecyclerViewBase.this.setScrollState(0);
                RecyclerViewBase.this.releaseGlows(!this.mScroller.isFling(), false);
                RecyclerViewBase.this.resetStopAtTitle();
                return;
            }
            postOnAnimation();
        }

        public void smoothScrollBy(int i3, int i16, int i17, int i18, boolean z16) {
            smoothScrollBy(i3, i16, computeScrollDuration(i3, i16, i17, i18), z16);
        }

        public void stop() {
            this.mScroller.abortAnimation();
            reportFinishState();
            RecyclerViewBase.this.removeCallbacks(this);
        }

        public void smoothScrollBy(int i3, int i16, int i17, Interpolator interpolator, boolean z16) {
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mScroller = new Scroller(RecyclerViewBase.this.getContext());
            }
            this.mCareSpringBackMaxDistance = z16;
            RecyclerViewBase.this.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            this.mScroller.startScroll(0, 0, i3, i16, i17);
            postOnAnimation();
        }

        public void smoothScrollBy(int i3, int i16, int i17, boolean z16) {
            smoothScrollBy(i3, i16, i17, RecyclerViewBase.sQuinticInterpolator, z16);
        }

        public void smoothScrollBy(int i3, int i16, boolean z16) {
            smoothScrollBy(i3, i16, 0, 0, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static abstract class ViewHolder {
        protected static final int FLAG_BOUND = 1;
        protected static final int FLAG_INVALID = 4;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        public static final int FLAG_UPDATE = 2;
        public static final int TYPE_CUSTOM_FOOTER = -5;
        public static final int TYPE_CUSTOM_HEADERE = -4;
        public static final int TYPE_FOOTER = -2;
        public static final int TYPE_HEADERE = -1;
        public static final int TYPE_NORMAL = -3;
        public final View itemView;
        public View mContent;
        public ContentHolder mContentHolder;
        protected int mFlags;
        protected RecyclerViewBase mParent;
        public boolean mPosDirty;
        public int mPosition = Integer.MIN_VALUE;
        public int mOldPosition = Integer.MIN_VALUE;
        public long mItemId = -1;
        public int mItemViewType = -1;
        public int mViewType = -3;
        public boolean mForceBind = false;
        public boolean mBindNextTime = false;
        int mIsRecyclableCount = 0;
        Recycler mScrapContainer = null;
        public String mHolderReuseKey = null;

        public ViewHolder(View view, RecyclerViewBase recyclerViewBase) {
            this.mParent = recyclerViewBase;
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        public void addFlags(int i3) {
            this.mFlags = i3 | this.mFlags;
        }

        public boolean canChangeOrder() {
            return false;
        }

        public void clearFlagsForSharedPool() {
            this.mFlags = 0;
        }

        void clearOldPosition() {
            this.mOldPosition = Integer.MIN_VALUE;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public int getPosition() {
            int i3 = this.mOldPosition;
            if (i3 == Integer.MIN_VALUE) {
                return this.mPosition;
            }
            return i3;
        }

        public abstract void inTraversals(int i3);

        public boolean isBound() {
            if ((this.mFlags & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean isInvalid() {
            if ((this.mFlags & 4) != 0) {
                return true;
            }
            return false;
        }

        public final boolean isRecyclable() {
            if ((this.mFlags & 16) == 0) {
                return true;
            }
            return false;
        }

        public boolean isRemoved() {
            if ((this.mFlags & 8) != 0) {
                return true;
            }
            return false;
        }

        boolean isScrap() {
            if (this.mScrapContainer != null) {
                return true;
            }
            return false;
        }

        public boolean needsUpdate() {
            if ((this.mFlags & 2) != 0) {
                return true;
            }
            return false;
        }

        public void offsetPosition(int i3) {
            if (this.mOldPosition == Integer.MIN_VALUE) {
                this.mOldPosition = this.mPosition;
            }
            this.mPosition += i3;
        }

        void setFlags(int i3, int i16) {
            this.mFlags = (i3 & i16) | (this.mFlags & (~i16));
        }

        public final void setIsRecyclable(boolean z16) {
            int i3;
            int i16;
            int i17 = this.mIsRecyclableCount;
            if (z16) {
                i3 = i17 - 1;
            } else {
                i3 = i17 + 1;
            }
            this.mIsRecyclableCount = i3;
            if (i3 < 0) {
                this.mIsRecyclableCount = 0;
                return;
            }
            if (!z16 && i3 == 1) {
                i16 = this.mFlags | 16;
            } else if (z16 && i3 == 0) {
                i16 = this.mFlags & (-17);
            } else {
                return;
            }
            this.mFlags = i16;
        }

        public final void setItemViewType(int i3) {
            this.mItemViewType = i3;
        }

        public void setScrapContainer(Recycler recycler) {
            this.mScrapContainer = recycler;
        }

        public String toString() {
            StringBuilder sb5 = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId);
            if (isScrap()) {
                sb5.append(" scrap");
            }
            if (isInvalid()) {
                sb5.append(" invalid");
            }
            if (!isBound()) {
                sb5.append(" unbound");
            }
            if (needsUpdate()) {
                sb5.append(" updateStyle");
            }
            if (isRemoved()) {
                sb5.append(" removed");
            }
            sb5.append(" type=" + this.mItemViewType);
            sb5.append("}");
            return sb5.toString();
        }

        void unScrap() {
            this.mScrapContainer.unscrapView(this);
            this.mScrapContainer = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class ViewHolderArrayList extends ArrayList<ViewHolder> {
        @Override // java.util.AbstractCollection
        public String toString() {
            return Arrays.toString(toArray());
        }
    }

    public RecyclerViewBase(Context context) {
        super(context);
        this.mObserver = new RecyclerViewDataObserver();
        this.mRecycler = new Recycler();
        this.needNotifyFooter = false;
        this.mUpdateChildViewsRunnable = new Runnable() { // from class: com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.1
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerViewBase.this.mPendingUpdates.isEmpty()) {
                    RecyclerViewBase.this.setRecyclerViewTouchEnabled(true);
                    return;
                }
                RecyclerViewBase.this.eatRequestLayout();
                RecyclerViewBase.this.updateChildViews();
                RecyclerViewBase.this.traversal(RecyclerViewBase.TRAVERSAL_PURPOSE_ITEMCHANGE);
                RecyclerViewBase.this.resumeRequestLayout(true);
                RecyclerViewBase recyclerViewBase = RecyclerViewBase.this;
                if (!recyclerViewBase.mPostedAnimatorRunner) {
                    recyclerViewBase.setRecyclerViewTouchEnabled(true);
                }
            }
        };
        this.mTempRect = new Rect();
        this.mPendingUpdates = new ArrayList<>();
        this.mPendingLayoutUpdates = new ArrayList<>();
        this.mUpdateOpPool = new Pools.SimplePool(30);
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mOffsetY = 0;
        this.mOffsetX = 0;
        this.mBlockScroll = false;
        this.optimizeHeaderRefresh = false;
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mViewFlinger = new ViewFlinger();
        this.mShouldPrebindItem = false;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mAnimatingViewIndex = -1;
        this.mNumAnimatingViews = 0;
        this.mAnimatingViewPos = -1;
        this.mAnimatingViewPrevPos = -1;
        this.mInPreLayout = false;
        this.mPostedAnimatorRunner = false;
        this.mItemAnimatorRunner = new Runnable() { // from class: com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.2
            @Override // java.lang.Runnable
            public void run() {
                RecyclerViewBase recyclerViewBase = RecyclerViewBase.this;
                recyclerViewBase.forceBlockTouch = true;
                recyclerViewBase.mPostedAnimatorRunner = false;
            }
        };
        this.filterCheckNotifyFooterAppeared = false;
        this.mNeedStopAtTitleIndex = -1;
        this.mStopAtTitle = false;
        this.mIsChangingMode = false;
        this.mEnableRecyclerViewTouchListener = false;
        this.mDisallowParentInterceptTouchEventWhenDrag = true;
        this.mUseRepeatableSuspensionMode = true;
        this.mTouchDownWhenSettlingFlag = false;
        this.mTouchDownWhenSettlingCheckRunnable = null;
        this.mTouchEventState = 1;
        this.tmpResult = new int[2];
        this.isAutoScrolling = false;
        this.mHorizontalCanScroll = true;
        this.mVerticalCanScroll = true;
        this.mPostUpdatesOnAnimation = true;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(false);
        setHasFixedSize(true);
        this.mAutoScrollRunnable = new AutoScrollRunnable();
        this.mTouchDownWhenSettlingCheckRunnable = new Runnable() { // from class: com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.4
            @Override // java.lang.Runnable
            public void run() {
                RecyclerViewBase recyclerViewBase;
                VelocityTracker velocityTracker;
                if (RecyclerViewBase.this.mTouchDownWhenSettlingFlag) {
                    RecyclerViewBase.this.mTouchDownWhenSettlingFlag = false;
                    if (RecyclerViewBase.this.mTouchEventState == 0) {
                        RecyclerViewBase.this.stopScroll();
                        return;
                    }
                    if (RecyclerViewBase.this.mTouchEventState == 2 && (velocityTracker = (recyclerViewBase = RecyclerViewBase.this).mVelocityTracker) != null) {
                        velocityTracker.computeCurrentVelocity(1000, recyclerViewBase.mMaxFlingVelocity);
                        float abs = Math.abs(RecyclerViewBase.this.mVelocityTracker.getYVelocity());
                        RecyclerViewBase recyclerViewBase2 = RecyclerViewBase.this;
                        if (abs < (recyclerViewBase2.mMaxFlingVelocity * 2) / 3) {
                            recyclerViewBase2.stopScroll();
                        }
                    }
                }
            }
        };
    }

    private void disableHolderRecyclable(int i3) {
        ViewHolder findViewHolderForPosition = findViewHolderForPosition(i3, true);
        if (findViewHolderForPosition != null) {
            findViewHolderForPosition.setIsRecyclable(false);
        } else {
            this.mState.mDeletedInvisibleItemCountSincePreviousLayout++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ViewHolder getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).mViewHolder;
    }

    public void addAnimatingView(View view) {
        addAnimatingView(view, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i3, int i16) {
        if (!this.mLayout.onAddFocusables(this, arrayList, i3, i16)) {
            super.addFocusables(arrayList, i3, i16);
        }
    }

    public void addItemDecoration(ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }

    public void addOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.add(onItemTouchListener);
    }

    public void addOnItemTouchListenerToFront(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.add(0, onItemTouchListener);
    }

    protected void animateAppearance(ViewHolder viewHolder, Rect rect, int i3, int i16) {
        View view = viewHolder.itemView;
        if (rect != null && rect.left == i3) {
            int i17 = rect.top;
        }
        viewHolder.setIsRecyclable(false);
    }

    protected void animateDisappearance(ItemHolderInfo itemHolderInfo) {
        View view = itemHolderInfo.holder.itemView;
        addAnimatingView(view);
        int i3 = itemHolderInfo.left;
        int i16 = itemHolderInfo.top;
        int left = view.getLeft();
        int top = view.getTop();
        if (i3 == left && i16 == top) {
            itemHolderInfo.holder.setIsRecyclable(false);
        } else {
            itemHolderInfo.holder.setIsRecyclable(false);
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        }
    }

    protected boolean canChangeOrder(int i3) {
        ViewHolder findViewHolderForPosition = findViewHolderForPosition(i3, true);
        if (findViewHolderForPosition != null) {
            return findViewHolderForPosition.canChangeOrder();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean canTranversal(int i3, ViewHolder viewHolder) {
        return true;
    }

    public void cancelTouch() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        releaseGlows(false, true);
        setScrollState(0);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams)) {
            return true;
        }
        return false;
    }

    protected boolean checkShouldCallScrollFinish(Scroller scroller, int i3) {
        if (scroller.getCurrY() == i3) {
            return true;
        }
        return false;
    }

    protected boolean checkShouldConsumePendingUpdates() {
        return true;
    }

    protected boolean checkShouldInvalidateInScroll() {
        return true;
    }

    protected boolean checkShouldStopScroll() {
        return false;
    }

    void clearOldPositions() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(getChildAt(i3));
            if (childViewHolderInt != null) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.clearOldPositions();
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x00b0, code lost:
    
        if (r18 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f7, code lost:
    
        if (r18 != null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f9, code lost:
    
        r18.forceFinished(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0125, code lost:
    
        if (r18 != null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0162, code lost:
    
        if (r18 != null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0179, code lost:
    
        if (r18 != null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
    
        if (r18 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0048, code lost:
    
        if (r18 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002e, code lost:
    
        r18.forceFinished(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0074, code lost:
    
        if (r18 != null) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int[] computeDxDy(int i3, int i16, boolean z16, Scroller scroller, boolean z17) {
        int i17;
        int i18;
        int height;
        int width;
        int i19;
        int[] iArr = this.tmpResult;
        iArr[0] = i3;
        iArr[1] = i16;
        int springBackMaxDistance = getSpringBackMaxDistance();
        boolean z18 = this.mUpOverScrollEnabled;
        boolean z19 = this.mDownOverScrollEnabled;
        boolean changeUpOverScrollEnableOnComputeDxDy = changeUpOverScrollEnableOnComputeDxDy(i3, i16, z16, scroller, z17, z18);
        if (i3 != 0) {
            int i26 = this.mOffsetX;
            if (i26 + i3 < 0) {
                if (!changeUpOverScrollEnableOnComputeDxDy) {
                    i17 = -i26;
                } else {
                    if (i26 >= 0 || i3 > 0 || (i19 = i3 / 3) == 0 || !z17) {
                        i19 = i3;
                    }
                    if (i26 + i19 <= (-springBackMaxDistance) && z16) {
                        i17 = (-i26) - springBackMaxDistance;
                    } else {
                        i17 = i19;
                    }
                }
            } else if (i26 + i3 > this.mState.mTotalHeight - getWidth()) {
                if (!z19) {
                    if (this.mState.mTotalHeight <= getWidth()) {
                        i17 = 0;
                    } else {
                        i17 = (this.mState.mTotalHeight - getWidth()) - this.mOffsetX;
                    }
                } else {
                    if (this.mOffsetX <= this.mState.mTotalHeight - getWidth() || i3 < 0 || (i17 = i3 / 3) == 0 || !z17) {
                        i17 = i3;
                    }
                    if (this.mState.mTotalHeight <= getWidth()) {
                        width = 0;
                    } else {
                        width = this.mState.mTotalHeight - getWidth();
                    }
                    int i27 = this.mOffsetX;
                    if (i27 + i17 >= width + springBackMaxDistance && z16) {
                        i17 = (-i27) + width + springBackMaxDistance;
                    }
                }
            }
            if (i16 != 0) {
                int i28 = this.mOffsetY;
                if (i28 + i16 <= 0) {
                    if (!changeUpOverScrollEnableOnComputeDxDy) {
                        int i29 = i16 + i28;
                        int i36 = -i28;
                        if (scroller != null && scroller.isFling()) {
                            onFlingToTopEdge(scroller.getCurrVelocity(), i29);
                        } else if (this.mIsTouching) {
                            onScrollToTopEdge();
                        }
                        if (scroller != null) {
                            scroller.forceFinished(true);
                        }
                        i18 = i36;
                    } else {
                        if (i28 >= 0 || i16 > 0 || (i18 = i16 / 3) == 0 || !z17) {
                            i18 = i16;
                        }
                        if (i28 + i18 <= (-springBackMaxDistance) && z16) {
                            i18 = (-i28) - springBackMaxDistance;
                        }
                    }
                } else if (i28 + i16 > this.mState.mTotalHeight - getHeight()) {
                    if (!z19) {
                        if (this.mState.mTotalHeight <= getHeight()) {
                            i18 = 0;
                        } else {
                            i18 = (this.mState.mTotalHeight - getHeight()) - this.mOffsetY;
                        }
                    } else {
                        if (this.mOffsetY <= this.mState.mTotalHeight - getHeight() || i16 < 0 || (i18 = i16 / 3) == 0 || !z17) {
                            i18 = i16;
                        }
                        if (this.mState.mTotalHeight <= getHeight()) {
                            height = 0;
                        } else {
                            height = this.mState.mTotalHeight - getHeight();
                        }
                        int i37 = this.mOffsetY;
                        if (i37 + i18 >= height + springBackMaxDistance && z16) {
                            i18 = (-i37) + height + springBackMaxDistance;
                        }
                    }
                } else if (this.mStopAtTitle && this.mNeedStopAtTitleIndex != -1) {
                    int stopPosition = getStopPosition();
                    int i38 = this.mOffsetY;
                    if (i38 + i16 < stopPosition) {
                        i18 = stopPosition - i38;
                    }
                }
                iArr[0] = i17;
                iArr[1] = i18;
                return iArr;
            }
            i18 = i16;
            iArr[0] = i17;
            iArr[1] = i18;
            return iArr;
        }
        i17 = i3;
        if (i16 != 0) {
        }
        i18 = i16;
        iArr[0] = i17;
        iArr[1] = i18;
        return iArr;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        if (this.mLayout.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        if (this.mLayout.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.mLayout.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    protected int computeVerticalScrollExtent() {
        if (this.mLayout.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    protected int computeVerticalScrollOffset() {
        if (this.mLayout.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        if (this.mLayout.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    protected void consumePendingUpdateOperations() {
        if (this.mPendingUpdates.size() > 0) {
            this.mUpdateChildViewsRunnable.run();
        }
    }

    public ViewHolder createViewHolder(View view, RecyclerViewBase recyclerViewBase) {
        return null;
    }

    protected boolean dirtyInRange(int i3, int i16) {
        int i17;
        RecyclerView.ViewHolderWrapper viewHolderWrapper;
        int firstVisibleItemPos = getFirstVisibleItemPos();
        if (firstVisibleItemPos == -1) {
            return true;
        }
        int i18 = i3 - firstVisibleItemPos;
        int i19 = i16 - firstVisibleItemPos;
        if (i18 >= i19) {
            i17 = i19;
        } else {
            i17 = i18;
        }
        int i26 = (i18 + i19) - i17;
        while (i17 <= i26) {
            RecyclerViewItem recyclerViewItem = (RecyclerViewItem) getChildAtInItem(i17);
            if (recyclerViewItem != null && (viewHolderWrapper = recyclerViewItem.mHolder) != null && viewHolderWrapper.mPosDirty) {
                return true;
            }
            i17++;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dispatchLayout() {
        if (this.mAdapter == null) {
            return;
        }
        eatRequestLayout();
        if (this.mItemsAddedOrRemoved || this.mItemsChanged || this.mState.mStructureChanged) {
            this.mAdapter.dataChanged();
        }
        boolean isAnimateChangeSimple = isAnimateChangeSimple(false, false);
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        this.mState.mCustomHeaderHeight = this.mAdapter.getCustomHeaderViewHeight();
        this.mState.mCustomFooterHeight = this.mAdapter.getCustomFooterViewHeight();
        this.mState.mCustomHeaderWidth = this.mAdapter.getCustomHeaderViewWidth();
        this.mState.mCustomFooterWidth = this.mAdapter.getCustomFooterViewWidth();
        State state = this.mState;
        state.mInPreLayout = false;
        state.mItemCount = this.mAdapter.getItemCount();
        this.mState.mTotalHeight = this.mAdapter.getListTotalHeight();
        this.mState.mHeaderCount = this.mAdapter.getHeaderViewCount();
        this.mState.mFooterCount = this.mAdapter.getFooterViewCount();
        if (isAnimateChangeSimple) {
            this.mState.mPreLayoutHolderMap.clear();
            this.mState.mPostLayoutHolderMap.clear();
            int childCountInItem = getChildCountInItem();
            for (int i3 = 0; i3 < childCountInItem; i3++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(getChildAtInItem(i3));
                View view = childViewHolderInt.itemView;
                this.mState.mPreLayoutHolderMap.put(childViewHolderInt, new ItemHolderInfo(childViewHolderInt, view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), childViewHolderInt.mPosition));
            }
        }
        clearOldPositions();
        dispatchLayoutUpdates();
        this.mState.mItemCount = this.mAdapter.getItemCount();
        State state2 = this.mState;
        state2.mHeaderCountInScreen = 0;
        state2.mFooterCountInScreen = 0;
        state2.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, state2);
        this.mState.mStructureChanged = false;
        this.mPendingSavedState = null;
        boolean isAnimateChangeSimple2 = isAnimateChangeSimple(true, isAnimateChangeSimple);
        if (isAnimateChangeSimple2) {
            int childCountInItem2 = getChildCountInItem();
            for (int i16 = 0; i16 < childCountInItem2; i16++) {
                ViewHolder childViewHolderInt2 = getChildViewHolderInt(getChildAtInItem(i16));
                View view2 = childViewHolderInt2.itemView;
                this.mState.mPostLayoutHolderMap.put(childViewHolderInt2, new ItemHolderInfo(childViewHolderInt2, view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom(), childViewHolderInt2.mPosition));
            }
            for (int size = this.mState.mPreLayoutHolderMap.size() - 1; size >= 0; size--) {
                if (!this.mState.mPostLayoutHolderMap.containsKey(this.mState.mPreLayoutHolderMap.keyAt(size))) {
                    ItemHolderInfo valueAt = this.mState.mPreLayoutHolderMap.valueAt(size);
                    this.mState.mPreLayoutHolderMap.removeAt(size);
                    removeDetachedView(valueAt.holder.itemView, false);
                    this.mRecycler.unscrapView(valueAt.holder);
                    animateDisappearance(valueAt);
                }
            }
            int size2 = this.mState.mPostLayoutHolderMap.size();
            if (size2 > 0) {
                for (int i17 = size2 - 1; i17 >= 0; i17--) {
                    ViewHolder keyAt = this.mState.mPostLayoutHolderMap.keyAt(i17);
                    ItemHolderInfo valueAt2 = this.mState.mPostLayoutHolderMap.valueAt(i17);
                    if (this.mState.mPreLayoutHolderMap.isEmpty() || !this.mState.mPreLayoutHolderMap.containsKey(keyAt)) {
                        this.mState.mPostLayoutHolderMap.removeAt(i17);
                        animateAppearance(keyAt, null, valueAt2.left, valueAt2.top);
                    }
                }
            }
            int size3 = this.mState.mPostLayoutHolderMap.size();
            for (int i18 = 0; i18 < size3; i18++) {
                ViewHolder keyAt2 = this.mState.mPostLayoutHolderMap.keyAt(i18);
                handleLayoutHolder(keyAt2, this.mState.mPreLayoutHolderMap.get(keyAt2), this.mState.mPostLayoutHolderMap.valueAt(i18));
            }
        }
        resumeRequestLayout(false);
        handleDispatchLayoutEnd();
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler, true, true);
        State state3 = this.mState;
        state3.mPreviousLayoutItemCount = state3.mItemCount;
        state3.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        if (!this.mPostedAnimatorRunner) {
            setRecyclerViewTouchEnabled(true);
        }
        if (isAnimateChangeSimple2 && !this.mPostedAnimatorRunner) {
            handleRangeItemsChangedWithNoAnimation();
        }
    }

    void dispatchLayoutUpdates() {
        int size = this.mPendingLayoutUpdates.size();
        for (int i3 = 0; i3 < size; i3++) {
            UpdateOp updateOp = this.mPendingLayoutUpdates.get(i3);
            int i16 = updateOp.cmd;
            if (i16 != 0) {
                if (i16 == 1) {
                    this.mLayout.onItemsRemoved(this, updateOp.positionStart, updateOp.itemCount);
                }
            } else {
                this.mLayout.onItemsAdded(this, updateOp.positionStart, updateOp.itemCount);
            }
            recycleUpdateOp(updateOp);
        }
        this.mPendingLayoutUpdates.clear();
    }

    boolean dispatchOnItemTouch(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        OnItemTouchListener onItemTouchListener = this.mActiveOnItemTouchListener;
        if (onItemTouchListener != null) {
            if (action == 0) {
                this.mActiveOnItemTouchListener = null;
            } else {
                onItemTouchListener.onTouchEvent(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.mActiveOnItemTouchListener = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.mOnItemTouchListeners.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnItemTouchListener onItemTouchListener2 = this.mOnItemTouchListeners.get(i3);
                if (onItemTouchListener2.onInterceptTouchEvent(this, motionEvent)) {
                    this.mActiveOnItemTouchListener = onItemTouchListener2;
                    return true;
                }
            }
        }
        return false;
    }

    boolean dispatchOnItemTouchIntercept(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.mActiveOnItemTouchListener = null;
        }
        int size = this.mOnItemTouchListeners.size();
        for (int i3 = 0; i3 < size; i3++) {
            OnItemTouchListener onItemTouchListener = this.mOnItemTouchListeners.get(i3);
            if (onItemTouchListener.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.mActiveOnItemTouchListener = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mItemDecorations.get(i3).onDrawOver(canvas, this);
        }
    }

    protected void eatRequestLayout() {
        if (!this.mEatRequestLayout) {
            this.mEatRequestLayout = true;
            this.mLayoutRequestEaten = false;
        }
    }

    protected void enter(int i3) {
        int i16;
        int i17;
        this.mEnterPos = i3;
        boolean z16 = true;
        this.mEnterCalled = true;
        if (this.mExitCalled && i3 != (i16 = this.mExitPos)) {
            if (i3 > i16) {
                i17 = i16;
            } else {
                i17 = i3;
            }
            if ((i3 + i16) - i17 != i16) {
                z16 = false;
            }
            this.mExchangeFromBigger = z16;
            this.mEnterCalled = false;
            this.mExitCalled = false;
        }
    }

    protected void exit(int i3) {
        int i16;
        int i17;
        this.mExitPos = i3;
        boolean z16 = true;
        this.mExitCalled = true;
        if (this.mEnterCalled && (i16 = this.mEnterPos) != i3) {
            if (i16 > i3) {
                i17 = i3;
            } else {
                i17 = i16;
            }
            if ((i16 + i3) - i17 != i3) {
                z16 = false;
            }
            this.mExchangeFromBigger = z16;
            this.mEnterCalled = false;
            this.mExitCalled = false;
        }
    }

    public View findChildViewUnder(float f16, float f17) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f16 >= childAt.getLeft() + translationX && f16 <= childAt.getRight() + translationX && f17 >= childAt.getTop() + translationY && f17 <= childAt.getBottom() + translationY) {
                return childAt;
            }
        }
        return null;
    }

    public int findNextSuspentedPos(int i3) {
        return -1;
    }

    int findPositionOffset(int i3) {
        int size = this.mPendingLayoutUpdates.size();
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            UpdateOp updateOp = this.mPendingLayoutUpdates.get(i17);
            if (updateOp.positionStart <= i3) {
                int i18 = updateOp.cmd;
                if (i18 == 1) {
                    i16 -= updateOp.itemCount;
                } else if (i18 == 0) {
                    i16 += updateOp.itemCount;
                }
            }
        }
        return i3 + i16;
    }

    public int findPrevSuspentedPos(int i3) {
        return -1;
    }

    public View findViewByPosition(int i3) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.findViewByPosition(i3);
        }
        return null;
    }

    public ViewHolder findViewHolderForItemId(long j3) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(getChildAt(i3));
            if (childViewHolderInt != null && childViewHolderInt.getItemId() == j3) {
                return childViewHolderInt;
            }
        }
        return this.mRecycler.findViewHolderForItemId(j3);
    }

    public ViewHolder findViewHolderForPosition(int i3) {
        return findViewHolderForPosition(i3, false);
    }

    public boolean fling(int i3, int i16) {
        if (Math.abs(i3) < this.mMinFlingVelocity) {
            i3 = 0;
        }
        if (Math.abs(i16) < this.mMinFlingVelocity) {
            i16 = 0;
        }
        int i17 = this.mMaxFlingVelocity;
        int max = Math.max(-i17, Math.min(i3, i17));
        int i18 = this.mMaxFlingVelocity;
        int max2 = Math.max(-i18, Math.min(i16, i18));
        if (max == 0 && max2 == 0) {
            return false;
        }
        this.mViewFlinger.fling(max, max2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i3) {
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i3);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i3);
        if (findNextFocus == null && this.mAdapter != null) {
            eatRequestLayout();
            findNextFocus = this.mLayout.onFocusSearchFailed(view, i3, this.mRecycler, this.mState);
            resumeRequestLayout(false);
        }
        if (findNextFocus == null) {
            return super.focusSearch(view, i3);
        }
        return findNextFocus;
    }

    public void forceCancelTouch() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        setScrollState(0);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public View getAnimatingView(int i3, int i16) {
        if (this.mNumAnimatingViews > 0) {
            for (int i17 = this.mAnimatingViewIndex; i17 < getChildCount(); i17++) {
                View childAt = getChildAt(i17);
                ViewHolder childViewHolder = getChildViewHolder(childAt);
                if (childViewHolder != null && childViewHolder.getPosition() == i3 && (i16 == -1 || childViewHolder.getItemViewType() == i16)) {
                    return childAt;
                }
            }
            return null;
        }
        return null;
    }

    protected int getAutoScrollVelocity() {
        return 9;
    }

    public int getCachedTotalHeight() {
        return this.mState.mTotalHeight;
    }

    public ArrayList<ViewHolder> getCachedViews() {
        return this.mRecycler.mCachedViews;
    }

    public View getChildAtInItem(int i3) {
        if (i3 < getChildCount()) {
            return super.getChildAt(i3 + this.mState.mHeaderCountInScreen);
        }
        return null;
    }

    public int getChildCountInItem() {
        int childCount = super.getChildCount();
        State state = this.mState;
        return (childCount - state.mHeaderCountInScreen) - state.mFooterCountInScreen;
    }

    public long getChildItemId(View view) {
        ViewHolder childViewHolderInt;
        Adapter<ViewHolder> adapter = this.mAdapter;
        if (adapter == null || !adapter.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildPosition(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getPosition();
        }
        return Integer.MIN_VALUE;
    }

    public ViewHolder getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return getChildViewHolderInt(view);
    }

    public int getFirstVisibleItemPos() {
        for (int i3 = 0; i3 < getChildCountInItem(); i3++) {
            View childAtInItem = getChildAtInItem(i3);
            if (childAtInItem instanceof RecyclerViewItem) {
                return ((RecyclerViewItem) childAtInItem).mHolder.mPosition;
            }
        }
        return -1;
    }

    int getFirstVisibleItemPosWithHeader() {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof RecyclerViewItem) {
                return ((RecyclerViewItem) childAt).mHolder.mPosition;
            }
        }
        return Integer.MAX_VALUE;
    }

    public int getHeightBefore(int i3) {
        return 0;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.mInsetsDirty) {
            return layoutParams.mDecorInsets;
        }
        Rect rect = layoutParams.mDecorInsets;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i3).getItemOffsets(this.mTempRect, layoutParams.getViewPosition(), this);
            int i16 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i16 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.mInsetsDirty = false;
        return rect;
    }

    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public int getOffsetY() {
        return this.mOffsetY;
    }

    public boolean getOverScrollEnabled() {
        return this.mUpOverScrollEnabled;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public Recycler getRecycler() {
        return this.mRecycler;
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSpringBackMaxDistance() {
        return 120;
    }

    int getStopPosition() {
        int i3 = 0;
        for (int headerViewCount = this.mAdapter.getHeaderViewCount(); headerViewCount > this.mNeedStopAtTitleIndex; headerViewCount--) {
            i3 += this.mAdapter.getHeaderViewHeight(headerViewCount);
        }
        return i3;
    }

    public int getTotalHeight() {
        return this.mState.mTotalHeight;
    }

    protected int getViewIndex(View view) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (getChildAt(i3) == view) {
                return i3;
            }
        }
        return -1;
    }

    protected void handleLayoutHolder(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2) {
        if (itemHolderInfo != null && itemHolderInfo2 != null) {
            if (itemHolderInfo.left != itemHolderInfo2.left || itemHolderInfo.top != itemHolderInfo2.top) {
                viewHolder.setIsRecyclable(false);
            }
        }
    }

    protected void handleViewRangeUpdate(ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
        this.mAdapter.bindViewHolder(viewHolder, viewHolder.getPosition(), true, this.mLayoutType, this.mAdapter.getCardItemViewType(viewHolder.getPosition()));
        this.mItemsChanged = true;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public boolean hasNoItem() {
        Adapter<ViewHolder> adapter = this.mAdapter;
        if (adapter != null && adapter.getItemCount() == 0 && this.mAdapter.getFooterViewCount() == 0 && this.mAdapter.getHeaderViewCount() == 0) {
            return true;
        }
        return false;
    }

    public boolean hasSuspentedItem() {
        return this.mHasSuspentedItem;
    }

    protected boolean isAnimateChangeSimple(boolean z16, boolean z17) {
        return false;
    }

    public boolean isBlockScroll() {
        return this.mBlockScroll;
    }

    public boolean isInOverScrollArea() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            if (this.mOffsetX <= this.mState.mTotalHeight - getWidth() && this.mOffsetX >= 0) {
                return false;
            }
            return true;
        }
        if (this.mOffsetY <= this.mState.mTotalHeight - getHeight() && this.mOffsetY >= 0) {
            return false;
        }
        return true;
    }

    public boolean isRefreshing() {
        return false;
    }

    public boolean isRepeatableSuspensionMode() {
        return this.mUseRepeatableSuspensionMode;
    }

    public boolean isScrolling() {
        int i3 = this.mScrollState;
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    protected boolean isTouchStopWhenFastFling() {
        return true;
    }

    protected boolean isTransformedTouchPointInView(float f16, float f17, RecyclerViewItem recyclerViewItem, PointF pointF) {
        float scrollX = (f16 - getScrollX()) - recyclerViewItem.getLeft();
        float scrollY = (f17 - getScrollY()) - recyclerViewItem.getTop();
        boolean isPointInView = recyclerViewItem.isPointInView(scrollX, scrollY);
        if (isPointInView && pointF != null) {
            pointF.set(scrollX, scrollY);
        }
        return isPointInView;
    }

    void layoutAnimationViews() {
        LayoutManager layoutManager;
        int childCount = getChildCount();
        int i3 = this.mAnimatingViewIndex;
        if (i3 != -1) {
            int max = Math.max(0, Math.min(childCount, i3));
            this.mAnimatingViewIndex = max;
            View childAt = getChildAt(max);
            if (childAt != null && (layoutManager = this.mLayout) != null) {
                layoutManager.measureChildWithMargins(childAt, 0, 0);
                this.mLayout.layoutDecorated(childAt, 0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }
    }

    void markItemDecorInsetsDirty() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ((LayoutParams) getChildAt(i3).getLayoutParams()).mInsetsDirty = true;
        }
    }

    protected void markKnownViewsInvalid() {
        int childCountInItem = getChildCountInItem();
        for (int i3 = 0; i3 < childCountInItem; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(getChildAtInItem(i3));
            if (childViewHolderInt != null) {
                childViewHolderInt.addFlags(6);
            }
        }
        this.mRecycler.markKnownViewsInvalid();
    }

    protected boolean needAdvancedStopDetachChildView() {
        return false;
    }

    public UpdateOp obtainUpdateOp(int i3, int i16, int i17) {
        UpdateOp acquire = this.mUpdateOpPool.acquire();
        if (acquire == null) {
            return new UpdateOp(i3, i16, i17);
        }
        acquire.cmd = i3;
        acquire.positionStart = i16;
        acquire.itemCount = i17;
        acquire.mRemovePositions = null;
        return acquire;
    }

    public void offsetChildrenHorizontal(int i3) {
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            getChildAt(i16).offsetLeftAndRight(i3);
        }
    }

    public void offsetChildrenVertical(int i3) {
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            getChildAt(i16).offsetTopAndBottom(i3);
        }
    }

    void offsetPositionRecordsForInsert(int i3, int i16) {
        int childCount = getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(getChildAt(i17));
            if (childViewHolderInt != null && childViewHolderInt.mPosition >= i3) {
                childViewHolderInt.offsetPosition(i16);
                this.mState.mStructureChanged = true;
            }
        }
        this.mRecycler.offsetPositionRecordsForInsert(i3, i16);
        requestLayout();
    }

    protected void offsetPositionRecordsForRemove(int i3, int i16, boolean z16) {
        int i17 = i3 + i16;
        int childCount = getChildCount();
        for (int i18 = 0; i18 < childCount; i18++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(getChildAt(i18));
            if (childViewHolderInt != null) {
                int i19 = childViewHolderInt.mPosition;
                if (i19 >= i17) {
                    childViewHolderInt.offsetPosition(-i16);
                } else if (i19 >= i3) {
                    childViewHolderInt.addFlags(8);
                }
                this.mState.mStructureChanged = true;
            }
        }
        this.mRecycler.offsetPositionRecordsForRemove(i3, i16);
        if (z16) {
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttached = true;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        Adapter<ViewHolder> adapter = this.mAdapter;
        if (adapter != null) {
            adapter.onViewAttached();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsAttached = false;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onDetachedFromWindow(this);
        }
        removeCallbacks(this.mItemAnimatorRunner);
        Adapter<ViewHolder> adapter = this.mAdapter;
        if (adapter != null) {
            adapter.onViewDetached();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            int size = this.mItemDecorations.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.mItemDecorations.get(i3).onDraw(canvas, this);
            }
        } catch (IllegalArgumentException | RuntimeException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011a  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        int actionMasked;
        boolean z17;
        int i3;
        if (this.mAnimatingBlockTouch || shouldStopOnInterceptTouchEvent(motionEvent, this.mState.mTotalHeight, this.mUpOverScrollEnabled)) {
            return true;
        }
        if (this.mScrollState != 1) {
            boolean dispatchOnItemTouchIntercept = dispatchOnItemTouchIntercept(motionEvent);
            if (dispatchOnItemTouchIntercept && motionEvent.getAction() != 0) {
                cancelTouch();
                return true;
            }
            if (dispatchOnItemTouchIntercept) {
                z16 = true;
                boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
                boolean canScrollVertically = this.mLayout.canScrollVertically();
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                this.mVelocityTracker.addMovement(motionEvent);
                actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked != 5) {
                                if (actionMasked == 6) {
                                    onPointerUp(motionEvent);
                                }
                            } else {
                                this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                                int x16 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                                this.mLastTouchX = x16;
                                this.mInitialTouchX = x16;
                                int y16 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                                this.mLastTouchY = y16;
                                this.mInitialTouchY = y16;
                            }
                        } else {
                            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                            if (findPointerIndex < 0) {
                                return false;
                            }
                            if (!this.mBlockScroll) {
                                float x17 = motionEvent.getX(findPointerIndex);
                                float y17 = motionEvent.getY(findPointerIndex);
                                if (this.mScrollState != 1) {
                                    float f16 = x17 - this.mInitialTouchX;
                                    float f17 = y17 - this.mInitialTouchY;
                                    int i16 = -1;
                                    if (canScrollHorizontally && Math.abs(f16) > this.mTouchSlop && Math.abs(f16) > Math.abs(f17)) {
                                        int i17 = this.mInitialTouchX;
                                        int i18 = this.mTouchSlop;
                                        if (f16 < 0.0f) {
                                            i3 = -1;
                                        } else {
                                            i3 = 1;
                                        }
                                        this.mLastTouchX = i17 + (i18 * i3);
                                        z17 = true;
                                    } else {
                                        z17 = false;
                                    }
                                    if (canScrollVertically && Math.abs(f17) > this.mTouchSlop && Math.abs(f17) > Math.abs(f16)) {
                                        int i19 = this.mInitialTouchY;
                                        int i26 = this.mTouchSlop;
                                        if (f17 >= 0.0f) {
                                            i16 = 1;
                                        }
                                        this.mLastTouchY = i19 + (i26 * i16);
                                        z17 = true;
                                    }
                                    if (z17 && onStartScroll((int) Math.abs(f17))) {
                                        if (this.mDisallowParentInterceptTouchEventWhenDrag) {
                                            getParent().requestDisallowInterceptTouchEvent(true);
                                        }
                                        setScrollState(1);
                                    }
                                }
                            }
                        }
                    } else {
                        this.mVelocityTracker.clear();
                    }
                } else {
                    this.mScrollPointerId = motionEvent.getPointerId(0);
                    int x18 = (int) (motionEvent.getX() + 0.5f);
                    this.mLastTouchX = x18;
                    this.mInitialTouchX = x18;
                    int y18 = (int) (motionEvent.getY() + 0.5f);
                    this.mLastTouchY = y18;
                    this.mInitialTouchY = y18;
                    if (z16) {
                        return true;
                    }
                    if (this.mScrollState == 2) {
                        setScrollState(1);
                        resetStopAtTitle();
                    }
                }
                if (this.mScrollState != 1) {
                    return true;
                }
                return false;
            }
        }
        z16 = false;
        boolean canScrollHorizontally2 = this.mLayout.canScrollHorizontally();
        boolean canScrollVertically2 = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
        }
        this.mVelocityTracker.addMovement(motionEvent);
        actionMasked = motionEvent.getActionMasked();
        int actionIndex2 = motionEvent.getActionIndex();
        if (actionMasked == 0) {
        }
        if (this.mScrollState != 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (z16) {
            Adapter<ViewHolder> adapter = this.mAdapter;
            if (adapter != null) {
                adapter.dataChanged();
            }
            handleOnLayoutChange();
        }
        if (z16 && this.mIsChangingMode) {
            this.mIsChangingMode = false;
            this.mRecycler.recycleCachedViews();
        }
        this.mStopAtTitle = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.mAdapterUpdateDuringMeasure) {
            eatRequestLayout();
            updateChildViews();
            this.mAdapterUpdateDuringMeasure = false;
            resumeRequestLayout(false);
        }
        Adapter<ViewHolder> adapter = this.mAdapter;
        if (adapter != null) {
            this.mState.mItemCount = adapter.getItemCount();
            this.mState.mHeaderCount = this.mAdapter.getHeaderViewCount();
            this.mState.mFooterCount = this.mAdapter.getFooterViewCount();
        }
        this.mLayout.onMeasure(this.mRecycler, this.mState, i3, i16);
    }

    void onPointerUp(MotionEvent motionEvent) {
        int i3;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            if (actionIndex == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.mScrollPointerId = motionEvent.getPointerId(i3);
            int x16 = (int) (motionEvent.getX(i3) + 0.5f);
            this.mLastTouchX = x16;
            this.mInitialTouchX = x16;
            int y16 = (int) (motionEvent.getY(i3) + 0.5f);
            this.mLastTouchY = y16;
            this.mInitialTouchY = y16;
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (parcelable != null && (parcelable instanceof BaseLayoutManager.SavedState)) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            super.onRestoreInstanceState(savedState.getSuperState());
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null && (parcelable2 = this.mPendingSavedState.mLayoutState) != null) {
                layoutManager.onRestoreInstanceState(parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelable;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.copyFrom(savedState2);
        } else {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                parcelable = layoutManager.onSaveInstanceState();
            } else {
                parcelable = null;
            }
            savedState.mLayoutState = parcelable;
        }
        return savedState;
    }

    public boolean onStartScroll(int i3) {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e1  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        float f16;
        float f17;
        int i3;
        int i16;
        boolean z18;
        int i17;
        if (!this.mBlockScroll && this.mLayout.canScrollHorizontally()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!this.mBlockScroll && this.mLayout.canScrollVertically()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.mAnimatingBlockTouch || shouldStopOnTouchEvent(motionEvent, this.mState.mTotalHeight, this.mUpOverScrollEnabled)) {
            return true;
        }
        if (this.mScrollState != 1 && dispatchOnItemTouch(motionEvent)) {
            cancelTouch();
            return true;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                onPointerUp(motionEvent);
                            }
                        } else {
                            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                            int x16 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                            this.mLastTouchX = x16;
                            this.mInitialTouchX = x16;
                            int y16 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                            this.mLastTouchY = y16;
                            this.mInitialTouchY = y16;
                        }
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    this.mTouchEventState = 2;
                    this.mIsTouching = true;
                    int x17 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y17 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    if (this.mScrollState != 1) {
                        int i18 = x17 - this.mInitialTouchX;
                        int i19 = y17 - this.mInitialTouchY;
                        int i26 = -1;
                        if (z16) {
                            int abs = Math.abs(i18);
                            int i27 = this.mTouchSlop;
                            if (abs > i27) {
                                int i28 = this.mInitialTouchX;
                                if (i18 < 0) {
                                    i17 = -1;
                                } else {
                                    i17 = 1;
                                }
                                this.mLastTouchX = i28 + (i27 * i17);
                                z18 = true;
                                if (z17) {
                                    int abs2 = Math.abs(i19);
                                    int i29 = this.mTouchSlop;
                                    if (abs2 > i29) {
                                        int i36 = this.mInitialTouchY;
                                        if (i19 >= 0) {
                                            i26 = 1;
                                        }
                                        this.mLastTouchY = i36 + (i29 * i26);
                                        z18 = true;
                                    }
                                }
                                if (z18) {
                                    if (this.mDisallowParentInterceptTouchEventWhenDrag && getParent() != null) {
                                        getParent().requestDisallowInterceptTouchEvent(true);
                                    }
                                    setScrollState(1);
                                }
                            }
                        }
                        z18 = false;
                        if (z17) {
                        }
                        if (z18) {
                        }
                    }
                    if (this.mScrollState == 1) {
                        int i37 = x17 - this.mLastTouchX;
                        int i38 = y17 - this.mLastTouchY;
                        if (z16) {
                            i3 = -i37;
                        } else {
                            i3 = 0;
                        }
                        if (z17) {
                            i16 = -i38;
                        } else {
                            i16 = 0;
                        }
                        scrollByInternal(i3, i16);
                        if (this.needNotifyFooter && !this.checkNotifyFooterOnRelease && (!shouldPrebindItem() || this.mOffsetY + getHeight() >= getTotalHeight())) {
                            this.needNotifyFooter = false;
                            Recycler recycler = this.mRecycler;
                            if (recycler != null) {
                                recycler.notifyLastFooterAppeared();
                            }
                        }
                        onTouchMove(x17, y17);
                    }
                    this.mLastTouchX = x17;
                    this.mLastTouchY = y17;
                }
            }
            this.mTouchEventState = 1;
            this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
            if (z16) {
                f16 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
            } else {
                f16 = 0.0f;
            }
            if (z17) {
                f17 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
            } else {
                f17 = 0.0f;
            }
            if ((f16 == 0.0f && f17 == 0.0f) || !fling((int) f16, (int) f17)) {
                resetStopAtTitle();
                setScrollState(0);
                handleOnTouchUpEventWhenStartFling(f16, f17);
            }
            if (this.mEnableRecyclerViewTouchListener && Math.abs(motionEvent.getX() - this.mInitialTouchX) < this.mTouchSlop && Math.abs(motionEvent.getY() - this.mInitialTouchY) < this.mTouchSlop && actionMasked == 1) {
                notifyRecyclerViewTouchEvent(motionEvent);
            }
            handleCustomClickEvent(motionEvent);
            this.mVelocityTracker.clear();
            releaseGlows(true, true);
        } else {
            this.mTouchEventState = 0;
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x18 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x18;
            this.mInitialTouchX = x18;
            int y18 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y18;
            this.mInitialTouchY = y18;
            if (!isTouchStopWhenFastFling()) {
                removeCallbacks(this.mTouchDownWhenSettlingCheckRunnable);
                postDelayed(this.mTouchDownWhenSettlingCheckRunnable, 50L);
            }
            if (getAdapter() != null) {
                getAdapter().onSuddenStop();
            }
        }
        this.mIsTouching = false;
        return true;
    }

    public void postAdapterUpdate(UpdateOp updateOp) {
        this.mPendingUpdates.add(updateOp);
        if (this.mPendingUpdates.size() == 1) {
            setRecyclerViewTouchEnabled(false);
            if (this.mPostUpdatesOnAnimation && this.mHasFixedSize && this.mIsAttached) {
                ViewCompatTool.postOnAnimation(this, this.mUpdateChildViewsRunnable);
            } else {
                this.mAdapterUpdateDuringMeasure = true;
                requestLayout();
            }
        }
    }

    protected void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            ViewCompatTool.postOnAnimation(this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    protected boolean predictiveItemAnimationsEnabled() {
        return false;
    }

    void recycleUpdateOp(UpdateOp updateOp) {
        this.mUpdateOpPool.release(updateOp);
    }

    protected void refreshCachedViews() {
        traversal(TRAVERSAL_PURPOSE_MODECHANGE);
    }

    protected void releaseGlows(boolean z16, boolean z17) {
        State state = this.mState;
        if ((state.mCustomHeaderHeight != 0 || state.mCustomFooterHeight != 0 || this.mOffsetY < 0 || getHeight() > this.mState.mTotalHeight) && shouldStopReleaseGlows(z16, z17)) {
            return;
        }
        if (this.mLayout.canScrollHorizontally()) {
            releaseGlowsForHorizontal();
        } else {
            releaseGlowsForVertical();
        }
    }

    protected void releaseGlowsForHorizontal() {
        if (this.mOffsetX >= this.mState.mCustomHeaderWidth) {
            int width = getWidth();
            int i3 = this.mState.mTotalHeight;
            if (width <= i3) {
                if (this.mOffsetX > i3 - getWidth()) {
                    smoothScrollBy((this.mState.mTotalHeight - getWidth()) - this.mOffsetX, 0);
                    return;
                }
                return;
            }
        }
        scrollToTop(null);
    }

    protected void releaseGlowsForVertical() {
        State state = this.mState;
        int i3 = state.mTotalHeight;
        if (this.mOffsetY >= state.mCustomHeaderHeight && getHeight() <= i3) {
            if (this.mOffsetY > i3 - getHeight()) {
                smoothScrollBy(0, (i3 - getHeight()) - this.mOffsetY);
                return;
            }
            if (this.mOffsetY >= i3 - getHeight() && this.needNotifyFooter) {
                if (shouldPrebindItem() && this.mOffsetY + getHeight() != i3) {
                    return;
                }
                this.needNotifyFooter = false;
                this.checkNotifyFooterOnRelease = false;
                this.mRecycler.notifyLastFooterAppeared();
                return;
            }
            return;
        }
        scrollToTop(null);
    }

    public void removeAnimatingView(View view) {
        removeAnimatingView(view, false);
    }

    void removeAnimatingViews() {
        int childCount = getChildCount();
        View[] viewArr = new View[childCount];
        for (int i3 = 0; i3 < childCount; i3++) {
            viewArr[i3] = getChildAt(i3);
        }
        for (int i16 = 0; i16 < childCount; i16++) {
            removeAnimatingView(viewArr[i16]);
        }
    }

    public void removeItemDecoration(ItemDecoration itemDecoration) {
        this.mItemDecorations.remove(itemDecoration);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.remove(onItemTouchListener);
        if (this.mActiveOnItemTouchListener == onItemTouchListener) {
            this.mActiveOnItemTouchListener = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        LayoutManager layoutManager;
        if (view2 != null && (layoutManager = this.mLayout) != null && !layoutManager.onRequestChildFocus(this, view, view2)) {
            this.mTempRect.set(0, 0, view2.getWidth(), view2.getHeight());
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
            requestChildRectangleOnScreen(view, this.mTempRect, true);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z16) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z16);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.mEatRequestLayout) {
            super.requestLayout();
        } else {
            this.mLayoutRequestEaten = true;
        }
    }

    void resetStopAtTitle() {
        if (this.mNeedStopAtTitleIndex != -1) {
            boolean z16 = false;
            if (this.mStopAtTitle) {
                if (this.mOffsetY != getStopPosition()) {
                    return;
                }
            } else if (this.mOffsetY >= getStopPosition()) {
                if (getHeight() + getStopPosition() < this.mState.mTotalHeight) {
                    z16 = true;
                }
            } else {
                return;
            }
            this.mStopAtTitle = z16;
        }
    }

    protected void resumeRequestLayout(boolean z16) {
        if (this.mEatRequestLayout) {
            if (z16 && this.mLayoutRequestEaten && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            this.mEatRequestLayout = false;
            this.mLayoutRequestEaten = false;
        }
    }

    @Override // android.view.View
    public void scrollBy(int i3, int i16) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i3 = 0;
                }
                if (!canScrollVertically) {
                    i16 = 0;
                }
                scrollByInternal(i3, i16);
                return;
            }
            return;
        }
        throw new IllegalStateException("Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    }

    void scrollByInternal(int i3, int i16) {
        int i17;
        int i18;
        if (checkShouldConsumePendingUpdates()) {
            consumePendingUpdateOperations();
        }
        if (checkShouldStopScroll()) {
            return;
        }
        int i19 = 0;
        if (this.mAdapter != null) {
            eatRequestLayout();
            if (i3 != 0) {
                i3 = computeDxDy(i3, 0, false, null, true)[0];
                i18 = i3 - this.mLayout.scrollHorizontallyBy(i3, this.mRecycler, this.mState);
            } else {
                i18 = 0;
            }
            if (i16 != 0) {
                i16 = computeDxDy(0, i16, false, null, true)[1];
                i17 = i16 - this.mLayout.scrollVerticallyBy(i16, this.mRecycler, this.mState);
            } else {
                i17 = 0;
            }
            resumeRequestLayout(false);
            i19 = i18;
        } else {
            i17 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        invalidateRefreshHeader();
        pullGlows(i19, i17);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null && (i3 != 0 || i16 != 0)) {
            onScrollListener.onScrolled(i3, i16);
        }
        if (checkShouldInvalidateInScroll()) {
            invalidate();
        }
        pullGlows(i19, i17);
        OnScrollListener onScrollListener2 = this.mScrollListener;
        if (onScrollListener2 != null && (i3 != 0 || i16 != 0)) {
            onScrollListener2.onScrolled(i3, i16);
        }
        awakenScrollBars();
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i16) {
        throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
    }

    public void scrollToPosition(int i3) {
        stopScroll();
        this.mLayout.scrollToPosition(i3);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrolled((int) getX(), i3);
        }
    }

    public void scrollToPositionWithGravity(int i3, int i16, int i17) {
        stopScroll();
        this.mLayout.scrollToPositionWidthGravity(i3, i16, i17);
    }

    public void scrollToPositionWithOffset(int i3, int i16) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.scrollToPositionWithOffset(i3, i16);
        }
    }

    public void scrollToTop(OnScrollFinishListener onScrollFinishListener) {
        ViewFlinger viewFlinger;
        int i3;
        int i16;
        if (this.mLayout.canScrollHorizontally()) {
            smoothScrollBy((-this.mOffsetX) + this.mState.mCustomHeaderWidth, 0, false, true);
            viewFlinger = this.mViewFlinger;
            viewFlinger.mScrollFinishListener = onScrollFinishListener;
            i3 = -this.mOffsetX;
            i16 = this.mState.mCustomHeaderWidth;
        } else {
            smoothScrollBy(0, (-this.mOffsetY) + this.mState.mCustomHeaderHeight, false, true);
            viewFlinger = this.mViewFlinger;
            viewFlinger.mScrollFinishListener = onScrollFinishListener;
            i3 = -this.mOffsetY;
            i16 = this.mState.mCustomHeaderHeight;
        }
        viewFlinger.mTargetPosition = i3 + i16;
    }

    public void scrollToTopAtOnce() {
        Adapter<ViewHolder> adapter = this.mAdapter;
        if (adapter == null) {
            return;
        }
        int[] beginPositionWithOffset = adapter.getBeginPositionWithOffset(0);
        scrollToPosition(beginPositionWithOffset[0], beginPositionWithOffset[1]);
    }

    public void setAdapter(Adapter adapter) {
        Adapter<ViewHolder> adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mObserver);
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler, true, true);
        }
        Adapter<ViewHolder> adapter3 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
        }
        LayoutManager layoutManager2 = this.mLayout;
        if (layoutManager2 != null) {
            layoutManager2.onAdapterChanged(adapter3, this.mAdapter);
        }
        this.mRecycler.onAdapterChanged(adapter3, this.mAdapter);
        this.mState.mStructureChanged = true;
        markKnownViewsInvalid();
        requestLayout();
    }

    public void setBlockScroll(boolean z16) {
        this.mBlockScroll = z16;
    }

    public void setBlockTouchListener(IBlockTouchListener iBlockTouchListener) {
        this.blockTouchListener = iBlockTouchListener;
    }

    public void setCanScroll(boolean z16, boolean z17) {
        this.mHorizontalCanScroll = z16;
        this.mVerticalCanScroll = z17;
    }

    public void setChildrenEnabled(int i3, int i16, boolean z16) {
        int childCount = getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            getChildAt(i17).setEnabled(z16);
        }
    }

    public void setDisallowParentInterceptTouchEventWhenDrag(boolean z16) {
        this.mDisallowParentInterceptTouchEventWhenDrag = z16;
    }

    public void setEnableRecyclerViewTouchEventListener(boolean z16) {
        this.mEnableRecyclerViewTouchListener = z16;
    }

    public void setHasFixedSize(boolean z16) {
        this.mHasFixedSize = z16;
    }

    public void setHasSuspentedItem(boolean z16) {
        this.mHasSuspentedItem = z16;
    }

    public void setItemViewCacheSize(int i3) {
        this.mRecycler.setViewCacheSize(i3);
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        this.mLayoutType = layoutManager.getLayoutType();
        if (layoutManager == this.mLayout) {
            return;
        }
        Adapter<ViewHolder> adapter = this.mAdapter;
        if (adapter != null) {
            adapter.reset();
        }
        this.mRecycler.clear();
        removeAllViews();
        LayoutManager layoutManager2 = this.mLayout;
        if (layoutManager2 != null) {
            if (this.mIsAttached) {
                layoutManager2.onDetachedFromWindow(this);
            }
            this.mLayout.mRecyclerView = null;
        }
        this.mLayout = layoutManager;
        if (layoutManager.mRecyclerView == null) {
            layoutManager.mRecyclerView = this;
            if (this.mIsAttached) {
                layoutManager.onAttachedToWindow(this);
            }
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView: " + layoutManager.mRecyclerView);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setOverScrollEnabled(boolean z16) {
        this.mUpOverScrollEnabled = z16;
        this.mDownOverScrollEnabled = z16;
    }

    public void setPrebindItem(boolean z16) {
        this.mShouldPrebindItem = z16;
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        this.mRecycler.setRecycledViewPool(recycledViewPool);
    }

    public void setRecyclerViewTouchEnabled(boolean z16) {
        boolean z17;
        if (z16 && !this.forceBlockTouch) {
            z17 = false;
        } else {
            z17 = true;
        }
        this.mAnimatingBlockTouch = z17;
        IBlockTouchListener iBlockTouchListener = this.blockTouchListener;
        if (iBlockTouchListener != null) {
            iBlockTouchListener.onRecyclerViewTouchEnabled(!z17);
        }
    }

    public void setRepeatableSuspensionMode(boolean z16) {
        this.mUseRepeatableSuspensionMode = z16;
    }

    void setScrollState(int i3) {
        int i16 = this.mScrollState;
        if (i3 == i16) {
            return;
        }
        this.mScrollState = i3;
        if (i3 != 2) {
            if (!isTouchStopWhenFastFling() && i16 == 2 && i3 == 1) {
                this.mTouchDownWhenSettlingFlag = true;
            } else {
                stopScroll();
            }
        }
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(i16, i3);
        }
    }

    public boolean shouldPrebindItem() {
        return this.mShouldPrebindItem;
    }

    protected boolean shouldStopOnInterceptTouchEvent(MotionEvent motionEvent, int i3, boolean z16) {
        return false;
    }

    protected boolean shouldStopOnTouchEvent(MotionEvent motionEvent, int i3, boolean z16) {
        return false;
    }

    protected boolean shouldStopReleaseGlows(boolean z16, boolean z17) {
        return false;
    }

    public void smoothScrollBy(int i3, int i16) {
        smoothScrollBy(i3, i16, true);
    }

    public void smoothScrollToPosition(int i3) {
        this.mLayout.smoothScrollToPosition(this, this.mState, i3);
    }

    public void stopScroll() {
        this.mViewFlinger.stop();
        this.mLayout.stopSmoothScroller();
    }

    public void traversal(int i3) {
        int childCount = getChildCount();
        if (i3 != 1991102 && childCount > 0) {
            for (int i16 = 0; i16 < childCount; i16++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(getChildAt(i16));
                if (childViewHolderInt != null && canTranversal(i3, childViewHolderInt)) {
                    childViewHolderInt.inTraversals(i3);
                }
            }
        }
        int size = this.mRecycler.mAttachedScrap.size();
        for (int i17 = 0; i17 < size; i17++) {
            ViewHolder viewHolder = this.mRecycler.mAttachedScrap.get(i17);
            if (viewHolder != null && canTranversal(i3, viewHolder)) {
                viewHolder.inTraversals(i3);
            }
        }
        int size2 = this.mRecycler.mCachedViews.size();
        for (int i18 = 0; i18 < size2; i18++) {
            ViewHolder viewHolder2 = this.mRecycler.mCachedViews.get(i18);
            if (viewHolder2 != null && canTranversal(i3, viewHolder2)) {
                viewHolder2.inTraversals(i3);
            }
        }
        int size3 = this.mRecycler.mUnmodifiableAttachedScrap.size();
        for (int i19 = 0; i19 < size3; i19++) {
            ViewHolder viewHolder3 = this.mRecycler.mUnmodifiableAttachedScrap.get(i19);
            if (viewHolder3 != null && canTranversal(i3, viewHolder3)) {
                viewHolder3.inTraversals(i3);
            }
        }
        int size4 = getRecycledViewPool().mScrap.size();
        for (int i26 = 0; i26 < size4; i26++) {
            ViewHolderArrayList valueAt = getRecycledViewPool().mScrap.valueAt(i26);
            if (valueAt != null) {
                int size5 = valueAt.size();
                for (int i27 = 0; i27 < size5; i27++) {
                    ViewHolder viewHolder4 = valueAt.get(i27);
                    if (viewHolder4 != null) {
                        viewHolder4.inTraversals(i3);
                    }
                }
            }
        }
    }

    void updateChildViews() {
        int i3;
        int size = this.mPendingUpdates.size();
        for (int i16 = 0; i16 < size; i16++) {
            UpdateOp updateOp = this.mPendingUpdates.get(i16);
            int i17 = updateOp.cmd;
            if (i17 != 0) {
                if (i17 != 1) {
                    if (i17 == 2) {
                        viewRangeUpdate(updateOp.positionStart, updateOp.itemCount);
                    }
                    this.mPendingLayoutUpdates.add(updateOp);
                } else {
                    ArrayList<Integer> arrayList = updateOp.mRemovePositions;
                    if (arrayList != null) {
                        Iterator<Integer> it = arrayList.iterator();
                        while (it.hasNext()) {
                            Integer next = it.next();
                            disableHolderRecyclable(next.intValue());
                            offsetPositionRecordsForRemove(next.intValue(), 1, false);
                        }
                        requestLayout();
                    } else {
                        int i18 = 0;
                        while (true) {
                            i3 = updateOp.itemCount;
                            if (i18 >= i3) {
                                break;
                            }
                            disableHolderRecyclable(updateOp.positionStart + i18);
                            i18++;
                        }
                        offsetPositionRecordsForRemove(updateOp.positionStart, i3, true);
                    }
                }
            } else {
                offsetPositionRecordsForInsert(updateOp.positionStart, updateOp.itemCount);
            }
            this.mItemsAddedOrRemoved = true;
            this.mPendingLayoutUpdates.add(updateOp);
        }
        this.mPendingUpdates.clear();
    }

    public int validateAnchorItemPosition(int i3) {
        Adapter<ViewHolder> adapter = this.mAdapter;
        if (adapter == null) {
            return i3;
        }
        int headerViewCount = adapter.getHeaderViewCount();
        int footerViewCount = this.mAdapter.getFooterViewCount();
        int i16 = -headerViewCount;
        if (i3 < 0 && this.mAdapter.headerMayChange()) {
            return i16;
        }
        if (i3 < footerViewCount + this.mAdapter.getItemCount() && i3 > i16) {
            return i3;
        }
        return i16;
    }

    protected void viewRangeUpdate(int i3, int i16) {
        int i17;
        int childCount = getChildCount();
        int i18 = i3 + i16;
        for (int i19 = 0; i19 < childCount; i19++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(getChildAt(i19));
            if (childViewHolderInt != null && (i17 = childViewHolderInt.mPosition) >= i3 && i17 < i18) {
                handleViewRangeUpdate(childViewHolderInt, i3, i18, i17, i16);
            }
        }
        this.mRecycler.viewRangeUpdate(i3, i16);
    }

    public void addAnimatingView(View view, boolean z16) {
        boolean z17;
        if (this.mNumAnimatingViews > 0) {
            for (int i3 = this.mAnimatingViewIndex; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == view) {
                    z17 = true;
                    break;
                }
            }
        }
        z17 = false;
        if (!z17) {
            this.mNumAnimatingViews++;
            if (z16) {
                addViewInLayout(view, -1, view.getLayoutParams(), true);
            } else {
                addView(view);
            }
            this.mAnimatingViewIndex = getChildCount() - this.mNumAnimatingViews;
        }
        this.mRecycler.unscrapView(getChildViewHolder(view));
    }

    public void addItemDecoration(ItemDecoration itemDecoration, int i3) {
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i3 < 0) {
            this.mItemDecorations.add(itemDecoration);
        } else {
            this.mItemDecorations.add(i3, itemDecoration);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    ViewHolder findViewHolderForPosition(int i3, boolean z16) {
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(getChildAt(i16));
            if (childViewHolderInt != null) {
                if (z16) {
                    if (childViewHolderInt.mPosition == i3) {
                        return childViewHolderInt;
                    }
                } else if (childViewHolderInt.getPosition() == i3) {
                    return childViewHolderInt;
                }
            }
        }
        return this.mRecycler.findViewHolderForPosition(i3);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public void removeAnimatingView(View view, boolean z16) {
        int i3;
        int i16;
        if (this.mNumAnimatingViews > 0) {
            for (int i17 = this.mAnimatingViewIndex; i17 < getChildCount(); i17++) {
                if (getChildAt(i17) == view) {
                    if (z16) {
                        removeViewInLayout(view);
                    } else if (getAdapter() == null || !getAdapter().hasCustomRecycler() || (i3 = this.mAnimatingViewPos) < 0 || i3 != this.mAnimatingViewPrevPos) {
                        removeViewAt(i17);
                    }
                    int i18 = this.mNumAnimatingViews - 1;
                    this.mNumAnimatingViews = i18;
                    if (i18 == 0) {
                        this.mAnimatingViewIndex = -1;
                    }
                    if (getAdapter() == null || !getAdapter().hasCustomRecycler() || (i16 = this.mAnimatingViewPos) < 0 || i16 != this.mAnimatingViewPrevPos || z16) {
                        this.mRecycler.recycleView(view);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void scrollToPosition(int i3, int i16) {
        stopScroll();
        this.mLayout.scrollToPositionWithOffset(i3, i16);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrolled((int) getX(), i3);
        }
    }

    public void setOverScrollEnabled(boolean z16, boolean z17) {
        this.mUpOverScrollEnabled = z16;
        this.mDownOverScrollEnabled = z17;
    }

    public void smoothScrollBy(int i3, int i16, boolean z16) {
        smoothScrollBy(i3, i16, z16, false);
    }

    public void smoothScrollBy(int i3, int i16, boolean z16, boolean z17) {
        if (i3 == 0 && i16 == 0) {
            return;
        }
        if (!this.mState.mStructureChanged || z17) {
            this.mViewFlinger.smoothScrollBy(i3, i16, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static abstract class Adapter<VH extends ViewHolder> {
        public static final int LOCATION_BOTTOM = 3;
        public static final int LOCATION_LEFT = 0;
        public static final int LOCATION_RIGHT = 2;
        public static final int LOCATION_TOP = 1;
        protected boolean mDataChanged = true;
        final AdapterDataObservable mObservable = new AdapterDataObservable();
        boolean mHasStableIds = false;
        protected boolean mSuspentionDataChanged = false;

        public final void bindViewHolder(VH vh5, int i3, boolean z16, int i16, int i17) {
            vh5.mPosition = i3;
            if (hasStableIds()) {
                vh5.mItemId = getItemId(i3);
            }
            if (z16) {
                onBindViewHolder(vh5, i3, i16, i17);
            }
            vh5.setFlags(1, 7);
        }

        public int calcPreloadThresholdWithItemNumber() {
            return 0;
        }

        public final VH createSuspendViewHolderWithPos(RecyclerViewBase recyclerViewBase, int i3, int i16) {
            VH onCreateSuspendViewHolderWithPos = onCreateSuspendViewHolderWithPos(recyclerViewBase, i3, i16);
            if (onCreateSuspendViewHolderWithPos == null) {
                return null;
            }
            onCreateSuspendViewHolderWithPos.mItemViewType = i16;
            return onCreateSuspendViewHolderWithPos;
        }

        public final VH createViewHolder(RecyclerViewBase recyclerViewBase, int i3) {
            VH onCreateViewHolder = onCreateViewHolder(recyclerViewBase, i3);
            if (onCreateViewHolder == null) {
                return null;
            }
            onCreateViewHolder.mItemViewType = i3;
            return onCreateViewHolder;
        }

        public final VH createViewHolderWithPos(RecyclerViewBase recyclerViewBase, int i3, int i16) {
            VH onCreateViewHolderWithPos = onCreateViewHolderWithPos(recyclerViewBase, i3, i16);
            if (onCreateViewHolderWithPos == null) {
                return null;
            }
            onCreateViewHolderWithPos.mItemViewType = i16;
            return onCreateViewHolderWithPos;
        }

        public void dataChanged() {
            this.mDataChanged = true;
            this.mSuspentionDataChanged = true;
        }

        public boolean doDeleteItem() {
            return true;
        }

        public ViewHolder findBestHolderForPosition(int i3, Recycler recycler) {
            return null;
        }

        public int findNextSuspentedPos(int i3) {
            return -1;
        }

        public int findPrevSuspentedPos(int i3) {
            return -1;
        }

        public ViewHolder findSuspendHolderForPosition(int i3, Recycler recycler) {
            return null;
        }

        public abstract int[] getBeginPositionWithOffset(int i3);

        public int getCardItemViewType(int i3) {
            return 0;
        }

        public abstract int getCustomFooterViewHeight();

        public abstract int getCustomFooterViewWidth();

        public abstract int getCustomHeaderViewHeight();

        public abstract int getCustomHeaderViewWidth();

        public int getDefaultFooterHeight() {
            return 0;
        }

        public abstract View getFooterView(int i3);

        public abstract int getFooterViewCount();

        public abstract int getFooterViewHeight(int i3);

        public abstract boolean getFooterViewInBottomMode();

        public abstract View getHeaderView(int i3);

        public abstract int getHeaderViewCount();

        public abstract int getHeaderViewHeight(int i3);

        public abstract int getHeightBefore(int i3);

        public abstract int getItemCount();

        public abstract int getItemHeight(int i3);

        public long getItemId(int i3) {
            return -1L;
        }

        public abstract int getItemMaigin(int i3, int i16);

        public int getItemViewType(int i3) {
            return 0;
        }

        public int getListTotalHeight() {
            int i3 = 0;
            if (getHeaderViewCount() > 0) {
                int headerViewCount = getHeaderViewCount();
                for (int i16 = 1; i16 <= headerViewCount; i16++) {
                    i3 += getHeaderViewHeight(i16);
                }
            }
            if (getFooterViewCount() > 0) {
                int footerViewCount = getFooterViewCount();
                for (int i17 = 1; i17 <= footerViewCount; i17++) {
                    i3 += getFooterViewHeight(i17);
                }
            }
            return getTotalHeight() + i3;
        }

        public int getMarginBetweenItem(int i3, int i16) {
            return 0;
        }

        public int getMarginCloseToParentH(int i3, int i16) {
            return 0;
        }

        public int getMarginCloseToParentV(int i3, int i16) {
            return 0;
        }

        public int getPreloadThresholdInItemNumber() {
            return 0;
        }

        public int getPreloadThresholdInPixels() {
            return 0;
        }

        public abstract int getTotalHeight();

        public String getViewHolderReUseKey(int i3) {
            return null;
        }

        public boolean hasCustomRecycler() {
            return false;
        }

        public final boolean hasObservers() {
            return this.mObservable.hasObservers();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public boolean headerMayChange() {
            return false;
        }

        public boolean isDividerItem(int i3) {
            return false;
        }

        public boolean isSuspentedItem(int i3) {
            return false;
        }

        public void notifyDataSetChanged() {
            this.mObservable.notifyChanged();
        }

        public void notifyItemChanged(int i3) {
            this.mObservable.notifyItemRangeChanged(i3, 1);
        }

        public void notifyItemInserted(int i3) {
            this.mObservable.notifyItemRangeInserted(i3, 1);
        }

        public void notifyItemRangeChanged(int i3, int i16) {
            this.mObservable.notifyItemRangeChanged(i3, i16);
        }

        public void notifyItemRangeInserted(int i3, int i16) {
            this.mObservable.notifyItemRangeInserted(i3, i16);
        }

        public void notifyItemRangeRemoved(int i3, int i16) {
            this.mObservable.notifyItemRangeRemoved(i3, i16);
        }

        public void notifyItemRemoved(int i3) {
            this.mObservable.notifyItemRangeRemoved(i3, 1);
        }

        public void notifyItemsRemoved(ArrayList<Integer> arrayList) {
            this.mObservable.notifyItemsRemoved(arrayList);
        }

        public boolean notifyOrderChanged(int i3, int i16) {
            return true;
        }

        public abstract void onBindViewHolder(VH vh5, int i3, int i16, int i17);

        public VH onCreateSuspendViewHolderWithPos(RecyclerViewBase recyclerViewBase, int i3, int i16) {
            return null;
        }

        public abstract VH onCreateViewHolder(RecyclerViewBase recyclerViewBase, int i3);

        public VH onCreateViewHolderWithPos(RecyclerViewBase recyclerViewBase, int i3, int i16) {
            return null;
        }

        public void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.registerObserver(adapterDataObserver);
        }

        public void setHasStableIds(boolean z16) {
            if (!hasObservers()) {
                this.mHasStableIds = z16;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.unregisterObserver(adapterDataObserver);
        }

        public void notifyEndReached() {
        }

        public void notifyLastFooterAppeared() {
        }

        public void onPreload() {
        }

        public void onSuddenStop() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void onViewAttached() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void onViewDetached() {
        }

        public void reset() {
        }

        public void startRefreshData() {
        }

        public void onItemDeleted(int i3) {
        }

        public void onItemsFill(int i3) {
        }

        protected void onViewAbandon(VH vh5) {
        }

        public void onViewAttachedToWindow(VH vh5) {
        }

        public void onViewDetachedFromWindow(VH vh5) {
        }

        protected void onViewRecycled(VH vh5) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static abstract class AdapterDataObserver {
        public void onChanged() {
        }

        public void onItemsRemoved(ArrayList<Integer> arrayList) {
        }

        public void onItemRangeChanged(int i3, int i16) {
        }

        public void onItemRangeInserted(int i3, int i16) {
        }

        public void onItemRangeRemoved(int i3, int i16) {
        }
    }

    protected void checkRefreshHeadOnFlingRun() {
    }

    protected void handleDispatchLayoutEnd() {
    }

    protected void handleOnLayoutChange() {
    }

    protected void handleRangeItemsChangedWithNoAnimation() {
    }

    protected void handleRefreshHeadOnFlingRunEnd() {
    }

    protected void invalidateRefreshHeader() {
    }

    protected void onScrollToTopEdge() {
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class Recycler {
        static final int DEFAULT_CACHE_SIZE = 2;
        public final ArrayList<ViewHolder> mAttachedScrap;
        public final ArrayList<ViewHolder> mCachedViews;
        public RecycledViewPool mRecyclerPool;
        final List<ViewHolder> mUnmodifiableAttachedScrap;
        int mViewCacheMax;

        public Recycler() {
            ArrayList<ViewHolder> arrayList = new ArrayList<>();
            this.mAttachedScrap = arrayList;
            this.mCachedViews = new ArrayList<>();
            this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(arrayList);
            this.mViewCacheMax = 2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void dispatchViewStateChange(View view, int i3) {
            if (view instanceof IViewRecycleStateListener) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ((IViewRecycleStateListener) view).onRecycle();
                    }
                } else {
                    ((IViewRecycleStateListener) view).onUse();
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i16 = 0; i16 < childCount; i16++) {
                    dispatchViewStateChange(viewGroup.getChildAt(i16), i3);
                }
            }
        }

        protected boolean checkShouldValidateViewHolder() {
            return true;
        }

        public void clear() {
            this.mAttachedScrap.clear();
            recycleCachedViews();
        }

        void clearOldPositions() {
            int size = this.mCachedViews.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.mCachedViews.get(i3).clearOldPosition();
            }
        }

        void clearScrap() {
            this.mAttachedScrap.clear();
        }

        public void dispatchViewRecycled(ViewHolder viewHolder) {
            Adapter<ViewHolder> adapter = RecyclerViewBase.this.mAdapter;
            if (adapter != null) {
                adapter.onViewRecycled(viewHolder);
            }
            dispatchViewStateChange(viewHolder.mContentHolder.mContentView, 2);
        }

        public String dump() {
            return "";
        }

        ViewHolder findViewHolderForItemId(long j3) {
            if (!RecyclerViewBase.this.mAdapter.hasStableIds()) {
                return null;
            }
            int size = this.mCachedViews.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewHolder viewHolder = this.mCachedViews.get(i3);
                if (viewHolder != null && viewHolder.getItemId() == j3) {
                    this.mCachedViews.remove(i3);
                    return viewHolder;
                }
            }
            return null;
        }

        ViewHolder findViewHolderForPosition(int i3) {
            int size = this.mCachedViews.size();
            for (int i16 = 0; i16 < size; i16++) {
                ViewHolder viewHolder = this.mCachedViews.get(i16);
                if (viewHolder != null && viewHolder.getPosition() == i3) {
                    this.mCachedViews.remove(i16);
                    return viewHolder;
                }
            }
            return null;
        }

        public View getFooterForPosition(int i3) {
            View scrapFooterView = getScrapFooterView(i3 - 1);
            if (scrapFooterView != null) {
                return scrapFooterView;
            }
            return RecyclerViewBase.this.mAdapter.getFooterView(i3);
        }

        public View getHeaderForPosition(int i3) {
            return RecyclerViewBase.this.mAdapter.getHeaderView(i3);
        }

        public RecycledViewPool getRecycledViewPool() {
            if (this.mRecyclerPool == null) {
                this.mRecyclerPool = new RecycledViewPool();
            }
            return this.mRecyclerPool;
        }

        int getScrapCount() {
            return this.mAttachedScrap.size();
        }

        public View getScrapFooterView(int i3) {
            int size = this.mAttachedScrap.size();
            for (int i16 = 0; i16 < size; i16++) {
                ViewHolder viewHolder = this.mAttachedScrap.get(i16);
                if (viewHolder != null && viewHolder.mPosition == i3 && (viewHolder.itemView instanceof IRecyclerViewFooter)) {
                    this.mAttachedScrap.remove(i16);
                    return viewHolder.itemView;
                }
            }
            return null;
        }

        public List<ViewHolder> getScrapList() {
            return this.mUnmodifiableAttachedScrap;
        }

        View getScrapViewAt(int i3) {
            return this.mAttachedScrap.get(i3).itemView;
        }

        ViewHolder getScrapViewForId(long j3, int i3) {
            int size = this.mAttachedScrap.size();
            int i16 = 0;
            while (true) {
                if (i16 >= size) {
                    break;
                }
                ViewHolder viewHolder = this.mAttachedScrap.get(i16);
                if (viewHolder.getItemId() == j3) {
                    if (i3 == viewHolder.getItemViewType()) {
                        this.mAttachedScrap.remove(i16);
                        viewHolder.setScrapContainer(null);
                        return viewHolder;
                    }
                } else {
                    i16++;
                }
            }
            int size2 = this.mCachedViews.size();
            for (int i17 = 0; i17 < size2; i17++) {
                ViewHolder viewHolder2 = this.mCachedViews.get(i17);
                if (viewHolder2.getItemId() == j3) {
                    this.mCachedViews.remove(i17);
                    return viewHolder2;
                }
            }
            return getRecycledViewPool().getRecycledView(i3, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0091 A[EDGE_INSN: B:39:0x0091->B:35:0x0091 BREAK  A[LOOP:1: B:20:0x0054->B:23:0x008e], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        ViewHolder getScrapViewForPosition(int i3, int i16) {
            RecyclerViewBase recyclerViewBase;
            int size;
            int size2 = this.mAttachedScrap.size();
            int i17 = 0;
            for (int i18 = 0; i18 < size2; i18++) {
                ViewHolder viewHolder = this.mAttachedScrap.get(i18);
                if (viewHolder.getPosition() == i3 && !viewHolder.isInvalid() && (RecyclerViewBase.this.mInPreLayout || !viewHolder.isRemoved())) {
                    if (i16 == -1 || viewHolder.getItemViewType() == i16) {
                        this.mAttachedScrap.remove(i18);
                        viewHolder.setScrapContainer(null);
                        return viewHolder;
                    }
                    recyclerViewBase = RecyclerViewBase.this;
                    if (recyclerViewBase.mNumAnimatingViews != 0) {
                        handleAnimatingViewInGetScrapView(recyclerViewBase.getAnimatingView(i3, i16));
                    }
                    size = this.mCachedViews.size();
                    while (true) {
                        if (i17 < size) {
                            break;
                        }
                        ViewHolder viewHolder2 = this.mCachedViews.get(i17);
                        if (viewHolder2.getPosition() == i3) {
                            this.mCachedViews.remove(i17);
                            if (!viewHolder2.isInvalid() && (i16 == -1 || viewHolder2.getItemViewType() == i16)) {
                                return viewHolder2;
                            }
                            dispatchViewRecycled(viewHolder2);
                            if (viewHolder2.isRecyclable()) {
                                getRecycledViewPool().putRecycledView(viewHolder2, RecyclerViewBase.this.mAdapter);
                            }
                        } else {
                            i17++;
                        }
                    }
                    if (i16 != -1) {
                        return null;
                    }
                    return getRecycledViewPool().getRecycledView(i16, RecyclerViewBase.this.mAdapter.getViewHolderReUseKey(i3));
                }
            }
            recyclerViewBase = RecyclerViewBase.this;
            if (recyclerViewBase.mNumAnimatingViews != 0) {
            }
            size = this.mCachedViews.size();
            while (true) {
                if (i17 < size) {
                }
                i17++;
            }
            if (i16 != -1) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x00a0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public View getSuspendViewForPosition(int i3) {
            ViewHolder viewHolder;
            ContentHolder contentHolder;
            RecyclerViewBase recyclerViewBase = RecyclerViewBase.this;
            if (recyclerViewBase.mAdapter == null) {
                return null;
            }
            int findPositionOffset = recyclerViewBase.findPositionOffset(i3);
            if (RecyclerViewBase.this.mAdapter.hasCustomRecycler()) {
                viewHolder = RecyclerViewBase.this.mAdapter.findSuspendHolderForPosition(findPositionOffset, this);
            } else {
                viewHolder = null;
            }
            if (viewHolder == null) {
                if (findPositionOffset < 0 || findPositionOffset >= RecyclerViewBase.this.mAdapter.getItemCount()) {
                    return null;
                }
                RecyclerViewBase recyclerViewBase2 = RecyclerViewBase.this;
                Adapter<ViewHolder> adapter = recyclerViewBase2.mAdapter;
                viewHolder = adapter.createSuspendViewHolderWithPos(recyclerViewBase2, findPositionOffset, adapter.getItemViewType(findPositionOffset));
            }
            if (viewHolder == null) {
                return null;
            }
            if (viewHolder.mBindNextTime || viewHolder.mForceBind || (!viewHolder.isRemoved() && (!viewHolder.isBound() || viewHolder.needsUpdate()))) {
                viewHolder.mBindNextTime = false;
                Adapter<ViewHolder> adapter2 = RecyclerViewBase.this.mAdapter;
                boolean z16 = !viewHolder.isBound();
                RecyclerViewBase recyclerViewBase3 = RecyclerViewBase.this;
                adapter2.bindViewHolder(viewHolder, findPositionOffset, z16, recyclerViewBase3.mLayoutType, recyclerViewBase3.mAdapter.getCardItemViewType(findPositionOffset));
            }
            ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = RecyclerViewBase.this.generateDefaultLayoutParams();
            } else {
                if (!RecyclerViewBase.this.checkLayoutParams(layoutParams)) {
                    layoutParams = RecyclerViewBase.this.generateLayoutParams(layoutParams);
                }
                ((LayoutParams) layoutParams).mViewHolder = viewHolder;
                contentHolder = viewHolder.mContentHolder;
                if (contentHolder != null) {
                    dispatchViewStateChange(contentHolder.mContentView, 1);
                }
                return viewHolder.itemView;
            }
            viewHolder.itemView.setLayoutParams(layoutParams);
            ((LayoutParams) layoutParams).mViewHolder = viewHolder;
            contentHolder = viewHolder.mContentHolder;
            if (contentHolder != null) {
            }
            return viewHolder.itemView;
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x00d6  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public View getViewForPosition(int i3) {
            ViewHolder viewHolderForPosition;
            ContentHolder contentHolder;
            View currentSuspentionView;
            RecyclerViewBase recyclerViewBase = RecyclerViewBase.this;
            if (recyclerViewBase.mAdapter == null) {
                return null;
            }
            int findPositionOffset = recyclerViewBase.findPositionOffset(i3);
            if ((RecyclerViewBase.this.getLayoutManager() instanceof BaseLayoutManager) && !RecyclerViewBase.this.isRepeatableSuspensionMode() && (currentSuspentionView = ((BaseLayoutManager) RecyclerViewBase.this.getLayoutManager()).getCurrentSuspentionView()) != null && findPositionOffset == ((BaseLayoutManager) RecyclerViewBase.this.getLayoutManager()).getCurrentSuspentionPosition()) {
                ViewHolder childViewHolder = RecyclerViewBase.this.getChildViewHolder(currentSuspentionView);
                if (childViewHolder != null) {
                    childViewHolder.setIsRecyclable(true);
                }
                ((BaseLayoutManager) RecyclerViewBase.this.getLayoutManager()).removeSuspentions();
            }
            if (RecyclerViewBase.this.mAdapter.hasCustomRecycler()) {
                viewHolderForPosition = RecyclerViewBase.this.mAdapter.findBestHolderForPosition(findPositionOffset, this);
            } else {
                viewHolderForPosition = getViewHolderForPosition(findPositionOffset);
            }
            if (viewHolderForPosition == null) {
                if (findPositionOffset < 0 || findPositionOffset >= RecyclerViewBase.this.mAdapter.getItemCount()) {
                    return null;
                }
                RecyclerViewBase recyclerViewBase2 = RecyclerViewBase.this;
                Adapter<ViewHolder> adapter = recyclerViewBase2.mAdapter;
                viewHolderForPosition = adapter.createViewHolderWithPos(recyclerViewBase2, findPositionOffset, adapter.getItemViewType(findPositionOffset));
                if (viewHolderForPosition == null) {
                    RecyclerViewBase recyclerViewBase3 = RecyclerViewBase.this;
                    Adapter<ViewHolder> adapter2 = recyclerViewBase3.mAdapter;
                    viewHolderForPosition = adapter2.createViewHolder(recyclerViewBase3, adapter2.getItemViewType(findPositionOffset));
                }
                if (viewHolderForPosition != null) {
                    viewHolderForPosition.mHolderReuseKey = RecyclerViewBase.this.mAdapter.getViewHolderReUseKey(findPositionOffset);
                } else {
                    throw new RuntimeException("Must implement onCreateContentView or onCreateContentViewWithPos in your adapter");
                }
            }
            handleBindViewHolderInGetView(viewHolderForPosition, findPositionOffset);
            ViewGroup.LayoutParams layoutParams = viewHolderForPosition.itemView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = RecyclerViewBase.this.generateDefaultLayoutParams();
            } else {
                if (!RecyclerViewBase.this.checkLayoutParams(layoutParams)) {
                    layoutParams = RecyclerViewBase.this.generateLayoutParams(layoutParams);
                }
                ((LayoutParams) layoutParams).mViewHolder = viewHolderForPosition;
                contentHolder = viewHolderForPosition.mContentHolder;
                if (contentHolder != null) {
                    dispatchViewStateChange(contentHolder.mContentView, 1);
                }
                return viewHolderForPosition.itemView;
            }
            viewHolderForPosition.itemView.setLayoutParams(layoutParams);
            ((LayoutParams) layoutParams).mViewHolder = viewHolderForPosition;
            contentHolder = viewHolderForPosition.mContentHolder;
            if (contentHolder != null) {
            }
            return viewHolderForPosition.itemView;
        }

        public ViewHolder getViewHolderForPosition(int i3) {
            ViewHolder scrapViewForPosition;
            ViewHolder scrapViewForPosition2 = getScrapViewForPosition(i3, -1);
            if (scrapViewForPosition2 != null) {
                if (checkShouldValidateViewHolder() && !validateViewHolderForOffsetPosition(scrapViewForPosition2, i3)) {
                    RecyclerViewBase.this.removeDetachedView(scrapViewForPosition2.itemView, false);
                    quickRecycleScrapView(scrapViewForPosition2.itemView);
                    int itemViewType = RecyclerViewBase.this.mAdapter.getItemViewType(i3);
                    if (RecyclerViewBase.this.mAdapter.hasStableIds()) {
                        scrapViewForPosition = getScrapViewForId(RecyclerViewBase.this.mAdapter.getItemId(i3), itemViewType);
                    } else {
                        scrapViewForPosition = getScrapViewForPosition(i3, itemViewType);
                    }
                    return scrapViewForPosition;
                }
                return scrapViewForPosition2;
            }
            return getRecycledViewPool().getRecycledView(RecyclerViewBase.this.mAdapter.getItemViewType(i3), RecyclerViewBase.this.mAdapter.getViewHolderReUseKey(i3));
        }

        protected void handleBindViewHolderInGetView(ViewHolder viewHolder, int i3) {
            if (!viewHolder.mBindNextTime && !viewHolder.mForceBind) {
                if (!viewHolder.isRemoved()) {
                    if (viewHolder.isBound() && !viewHolder.needsUpdate()) {
                        return;
                    }
                } else {
                    return;
                }
            }
            viewHolder.mBindNextTime = false;
            RecyclerViewBase recyclerViewBase = RecyclerViewBase.this;
            Adapter<ViewHolder> adapter = recyclerViewBase.mAdapter;
            adapter.bindViewHolder(viewHolder, i3, true, recyclerViewBase.mLayoutType, adapter.getCardItemViewType(i3));
        }

        void markKnownViewsInvalid() {
            int size = this.mCachedViews.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewHolder viewHolder = this.mCachedViews.get(i3);
                if (viewHolder != null) {
                    viewHolder.addFlags(6);
                }
            }
            recycleCachedViews();
        }

        public void notifyLastFooterAppeared() {
            Adapter<ViewHolder> adapter = RecyclerViewBase.this.mAdapter;
            if (adapter != null) {
                adapter.notifyLastFooterAppeared();
            }
        }

        protected void offsetPositionRecordsForInsert(int i3, int i16) {
            int size = this.mCachedViews.size();
            for (int i17 = 0; i17 < size; i17++) {
                ViewHolder viewHolder = this.mCachedViews.get(i17);
                if (viewHolder != null && viewHolder.getPosition() >= i3) {
                    viewHolder.offsetPosition(i16);
                }
            }
        }

        protected void offsetPositionRecordsForRemove(int i3, int i16) {
            int i17 = i3 + i16;
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mCachedViews.get(size);
                if (viewHolder != null) {
                    if (viewHolder.getPosition() >= i17) {
                        viewHolder.offsetPosition(-i16);
                    } else if (viewHolder.getPosition() >= i3) {
                        this.mCachedViews.remove(size);
                        dispatchViewRecycled(viewHolder);
                        getRecycledViewPool().putRecycledView(viewHolder, RecyclerViewBase.this.mAdapter);
                    }
                }
            }
        }

        void onAdapterChanged(Adapter adapter, Adapter adapter2) {
            clear();
            getRecycledViewPool().onAdapterChanged(adapter, adapter2);
        }

        void quickRecycleScrapView(View view) {
            ViewHolder childViewHolderInt = RecyclerViewBase.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            recycleViewHolder(childViewHolderInt);
        }

        void recycleCachedViews() {
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mCachedViews.get(size);
                if (viewHolder.isRecyclable()) {
                    dispatchViewRecycled(viewHolder);
                    getRecycledViewPool().putRecycledView(viewHolder, RecyclerViewBase.this.mAdapter);
                }
                this.mCachedViews.remove(size);
            }
        }

        public void recycleView(View view) {
            recycleViewHolder(RecyclerViewBase.getChildViewHolderInt(view));
        }

        void recycleViewHolder(ViewHolder viewHolder) {
            if (viewHolder == null || viewHolder.mViewType != -3) {
                return;
            }
            if (!viewHolder.isScrap() && viewHolder.itemView.getParent() == null) {
                boolean z16 = false;
                if (!viewHolder.isInvalid() && (RecyclerViewBase.this.mInPreLayout || !viewHolder.isRemoved())) {
                    if (this.mCachedViews.size() == this.mViewCacheMax && !this.mCachedViews.isEmpty()) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= this.mCachedViews.size()) {
                                break;
                            }
                            ViewHolder viewHolder2 = this.mCachedViews.get(i3);
                            if (viewHolder2.isRecyclable()) {
                                this.mCachedViews.remove(i3);
                                dispatchViewRecycled(viewHolder2);
                                getRecycledViewPool().putRecycledView(viewHolder2, RecyclerViewBase.this.mAdapter);
                                break;
                            }
                            i3++;
                        }
                    }
                    if (this.mCachedViews.size() < this.mViewCacheMax) {
                        this.mCachedViews.add(viewHolder);
                        z16 = true;
                    }
                }
                if (!z16 && viewHolder.isRecyclable()) {
                    dispatchViewRecycled(viewHolder);
                    getRecycledViewPool().putRecycledView(viewHolder, RecyclerViewBase.this.mAdapter);
                }
                RecyclerViewBase.this.mState.mPreLayoutHolderMap.remove(viewHolder);
                RecyclerViewBase.this.mState.mPostLayoutHolderMap.remove(viewHolder);
                return;
            }
            throw new IllegalArgumentException("Scrapped or attached views may not be recycled.");
        }

        void scrapView(View view) {
            ViewHolder childViewHolderInt = RecyclerViewBase.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.setScrapContainer(this);
                this.mAttachedScrap.add(childViewHolderInt);
            }
        }

        void setRecycledViewPool(RecycledViewPool recycledViewPool) {
            RecycledViewPool recycledViewPool2 = this.mRecyclerPool;
            if (recycledViewPool2 != null) {
                recycledViewPool2.detach();
            }
            this.mRecyclerPool = recycledViewPool;
            if (recycledViewPool != null) {
                recycledViewPool.attach(RecyclerViewBase.this.getAdapter());
            }
        }

        public void setViewCacheSize(int i3) {
            this.mViewCacheMax = i3;
            while (this.mCachedViews.size() > i3) {
                this.mCachedViews.remove(r0.size() - 1);
            }
        }

        void unscrapView(ViewHolder viewHolder) {
            this.mAttachedScrap.remove(viewHolder);
            viewHolder.mScrapContainer = null;
        }

        public void updateHolderPositionWhenDelete(int i3) {
            int i16;
            if (i3 >= 0) {
                int size = this.mCachedViews.size();
                for (int i17 = 0; i17 < size; i17++) {
                    ViewHolder viewHolder = this.mCachedViews.get(i17);
                    int i18 = viewHolder.mPosition;
                    if (i18 > i3) {
                        viewHolder.mPosition = i18 - 1;
                    }
                }
                int size2 = this.mAttachedScrap.size();
                for (int i19 = 0; i19 < size2; i19++) {
                    ViewHolder viewHolder2 = this.mAttachedScrap.get(i19);
                    int i26 = viewHolder2.mPosition;
                    if (i26 > i3) {
                        viewHolder2.mPosition = i26 - 1;
                    }
                }
                int itemViewType = RecyclerViewBase.this.getAdapter().getItemViewType(i3);
                ViewHolderArrayList viewHolderArrayList = getRecycledViewPool().mScrap.get(itemViewType);
                if (viewHolderArrayList != null && !viewHolderArrayList.isEmpty()) {
                    Iterator<ViewHolder> it = viewHolderArrayList.iterator();
                    while (it.hasNext()) {
                        ViewHolder next = it.next();
                        if (next.getItemViewType() == itemViewType && (i16 = next.mPosition) > i3) {
                            next.mPosition = i16 - 1;
                        }
                    }
                }
            }
        }

        boolean validateViewHolderForOffsetPosition(ViewHolder viewHolder, int i3) {
            if (viewHolder.isRemoved()) {
                return true;
            }
            if (i3 < 0 || i3 >= RecyclerViewBase.this.mAdapter.getItemCount() || RecyclerViewBase.this.mAdapter.getItemViewType(i3) != viewHolder.getItemViewType()) {
                return false;
            }
            if (!RecyclerViewBase.this.mAdapter.hasStableIds() || viewHolder.getItemId() == RecyclerViewBase.this.mAdapter.getItemId(i3)) {
                return true;
            }
            return false;
        }

        void viewRangeUpdate(int i3, int i16) {
            int position;
            int i17 = i16 + i3;
            int size = this.mCachedViews.size();
            for (int i18 = 0; i18 < size; i18++) {
                ViewHolder viewHolder = this.mCachedViews.get(i18);
                if (viewHolder != null && (position = viewHolder.getPosition()) >= i3 && position < i17) {
                    viewHolder.addFlags(2);
                }
            }
        }

        protected void handleAnimatingViewInGetScrapView(View view) {
        }
    }

    public void checkNotifyFooterAppearWithFewChild(int i3) {
    }

    protected void handleCustomClickEvent(MotionEvent motionEvent) {
    }

    public void notifyRecyclerViewTouchEvent(MotionEvent motionEvent) {
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onItemsFill(int i3) {
    }

    public void setEnableHorizontalDrag(boolean z16) {
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static abstract class ItemDecoration {
        public void getItemOffsets(Rect rect, int i3, RecyclerViewBase recyclerViewBase) {
            rect.set(0, 0, 0, 0);
        }

        public void onDraw(Canvas canvas, RecyclerViewBase recyclerViewBase) {
        }

        public void onDrawOver(Canvas canvas, RecyclerViewBase recyclerViewBase) {
        }
    }

    void absorbGlows(int i3, int i16) {
    }

    protected void handleOnTouchUpEventWhenStartFling(float f16, float f17) {
    }

    protected void onFlingToTopEdge(float f16, int i3) {
    }

    protected void onTouchMove(int i3, int i16) {
    }

    void pullGlows(int i3, int i16) {
    }

    public void handleInTraversal(int i3, int i16, View view) {
    }

    protected boolean changeUpOverScrollEnableOnComputeDxDy(int i3, int i16, boolean z16, Scroller scroller, boolean z17, boolean z18) {
        return z18;
    }
}
