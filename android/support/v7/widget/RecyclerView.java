package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.os.TraceCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.widget.AdapterHelper;
import android.support.v7.widget.ChildHelper;
import android.support.v7.widget.ViewInfoStore;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.tencent.component.media.MtpConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.WnsNetworkConst;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild {
    private static final boolean DEBUG = false;
    private static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    private static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    private static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    private static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    private static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int VERTICAL = 1;
    private static final Interpolator sQuinticInterpolator;
    private RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    private OnItemTouchListener mActiveOnItemTouchListener;
    private Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    private boolean mAdapterUpdateDuringMeasure;
    private EdgeEffectCompat mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    private boolean mClipToPadding;
    private boolean mDataSetHasChangedAfterLayout;
    private int mEatRequestLayout;
    private int mEatenAccessibilityChangeFlags;
    private boolean mFirstLayoutComplete;
    private boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    private final ArrayList<ItemDecoration> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;

    @VisibleForTesting
    LayoutManager mLayout;
    private boolean mLayoutFrozen;
    private int mLayoutOrScrollCounter;
    private boolean mLayoutRequestEaten;
    private EdgeEffectCompat mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    private SavedState mPendingSavedState;
    private final boolean mPostUpdatesOnAnimation;
    private boolean mPostedAnimatorRunner;
    final Recycler mRecycler;
    private RecyclerListener mRecyclerListener;
    private EdgeEffectCompat mRightGlow;
    private final int[] mScrollConsumed;
    private float mScrollFactor;
    private OnScrollListener mScrollListener;
    private List<OnScrollListener> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private final NestedScrollingChildHelper mScrollingChildHelper;
    final State mState;
    private final Rect mTempRect;
    private EdgeEffectCompat mTopGlow;
    private int mTouchSlop;
    private final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    private final ViewFlinger mViewFlinger;
    private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class Adapter<VH extends ViewHolder> {
        private final AdapterDataObservable mObservable = new AdapterDataObservable();
        private boolean mHasStableIds = false;

        public final void bindViewHolder(VH vh5, int i3) {
            vh5.mPosition = i3;
            if (hasStableIds()) {
                vh5.mItemId = getItemId(i3);
            }
            vh5.setFlags(1, WnsNetworkConst.NETWORK_DISABLE);
            TraceCompat.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh5, i3, vh5.getUnmodifiedPayloads());
            vh5.clearPayload();
            TraceCompat.endSection();
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i3) {
            TraceCompat.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);
            VH onCreateViewHolder = onCreateViewHolder(viewGroup, i3);
            onCreateViewHolder.mItemViewType = i3;
            TraceCompat.endSection();
            return onCreateViewHolder;
        }

        public abstract int getItemCount();

        public long getItemId(int i3) {
            return -1L;
        }

        public int getItemViewType(int i3) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.mObservable.hasObservers();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.notifyChanged();
        }

        public final void notifyItemChanged(int i3) {
            this.mObservable.notifyItemRangeChanged(i3, 1);
        }

        public final void notifyItemInserted(int i3) {
            this.mObservable.notifyItemRangeInserted(i3, 1);
        }

        public final void notifyItemMoved(int i3, int i16) {
            this.mObservable.notifyItemMoved(i3, i16);
        }

        public final void notifyItemRangeChanged(int i3, int i16) {
            this.mObservable.notifyItemRangeChanged(i3, i16);
        }

        public final void notifyItemRangeInserted(int i3, int i16) {
            this.mObservable.notifyItemRangeInserted(i3, i16);
        }

        public final void notifyItemRangeRemoved(int i3, int i16) {
            this.mObservable.notifyItemRangeRemoved(i3, i16);
        }

        public final void notifyItemRemoved(int i3) {
            this.mObservable.notifyItemRangeRemoved(i3, 1);
        }

        public abstract void onBindViewHolder(VH vh5, int i3);

        public void onBindViewHolder(VH vh5, int i3, List<Object> list) {
            onBindViewHolder(vh5, i3);
            EventCollector.getInstance().onRecyclerBindViewHolder(vh5, i3, list, getItemId(i3));
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i3);

        public boolean onFailedToRecycleView(VH vh5) {
            return false;
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

        public final void notifyItemChanged(int i3, Object obj) {
            this.mObservable.notifyItemRangeChanged(i3, 1, obj);
        }

        public final void notifyItemRangeChanged(int i3, int i16, Object obj) {
            this.mObservable.notifyItemRangeChanged(i3, i16, obj);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public void onViewAttachedToWindow(VH vh5) {
        }

        public void onViewDetachedFromWindow(VH vh5) {
        }

        public void onViewRecycled(VH vh5) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
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

        public void notifyItemMoved(int i3, int i16) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i3, i16, 1);
            }
        }

        public void notifyItemRangeChanged(int i3, int i16) {
            notifyItemRangeChanged(i3, i16, null);
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

        public void notifyItemRangeChanged(int i3, int i16, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i3, i16, obj);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class AdapterDataObserver {
        public void onItemRangeChanged(int i3, int i16) {
        }

        public void onItemRangeChanged(int i3, int i16, Object obj) {
            onItemRangeChanged(i3, i16);
        }

        public void onChanged() {
        }

        public void onItemRangeInserted(int i3, int i16) {
        }

        public void onItemRangeRemoved(int i3, int i16) {
        }

        public void onItemRangeMoved(int i3, int i16, int i17) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class ItemAnimator {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        private ItemAnimatorListener mListener = null;
        private ArrayList<ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList<>();
        private long mAddDuration = 120;
        private long mRemoveDuration = 120;
        private long mMoveDuration = 250;
        private long mChangeDuration = 250;

        /* compiled from: P */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface AdapterChanges {
        }

        /* compiled from: P */
        /* loaded from: classes.dex */
        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes.dex */
        public interface ItemAnimatorListener {
            void onAnimationFinished(ViewHolder viewHolder);
        }

        /* compiled from: P */
        /* loaded from: classes.dex */
        public static class ItemHolderInfo {
            public int bottom;
            public int changeFlags;
            public int left;
            public int right;
            public int top;

            public ItemHolderInfo setFrom(ViewHolder viewHolder) {
                return setFrom(viewHolder, 0);
            }

            public ItemHolderInfo setFrom(ViewHolder viewHolder, int i3) {
                View view = viewHolder.itemView;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }

        static int buildAdapterChangeFlagsForAnimations(ViewHolder viewHolder) {
            int i3 = viewHolder.mFlags & 14;
            if (viewHolder.isInvalid()) {
                return 4;
            }
            if ((i3 & 4) == 0) {
                int oldPosition = viewHolder.getOldPosition();
                int adapterPosition = viewHolder.getAdapterPosition();
                if (oldPosition != -1 && adapterPosition != -1 && oldPosition != adapterPosition) {
                    return i3 | 2048;
                }
                return i3;
            }
            return i3;
        }

        public abstract boolean animateAppearance(@NonNull ViewHolder viewHolder, @Nullable ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateChange(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateDisappearance(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @Nullable ItemHolderInfo itemHolderInfo2);

        public abstract boolean animatePersistence(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder) {
            return true;
        }

        public final void dispatchAnimationFinished(ViewHolder viewHolder) {
            onAnimationFinished(viewHolder);
            ItemAnimatorListener itemAnimatorListener = this.mListener;
            if (itemAnimatorListener != null) {
                itemAnimatorListener.onAnimationFinished(viewHolder);
            }
        }

        public final void dispatchAnimationStarted(ViewHolder viewHolder) {
            onAnimationStarted(viewHolder);
        }

        public final void dispatchAnimationsFinished() {
            int size = this.mFinishedListeners.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.mFinishedListeners.get(i3).onAnimationsFinished();
            }
            this.mFinishedListeners.clear();
        }

        public abstract void endAnimation(ViewHolder viewHolder);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            boolean isRunning = isRunning();
            if (itemAnimatorFinishedListener != null) {
                if (!isRunning) {
                    itemAnimatorFinishedListener.onAnimationsFinished();
                } else {
                    this.mFinishedListeners.add(itemAnimatorFinishedListener);
                }
            }
            return isRunning;
        }

        public ItemHolderInfo obtainHolderInfo() {
            return new ItemHolderInfo();
        }

        @NonNull
        public ItemHolderInfo recordPostLayoutInformation(@NonNull State state, @NonNull ViewHolder viewHolder) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        @NonNull
        public ItemHolderInfo recordPreLayoutInformation(@NonNull State state, @NonNull ViewHolder viewHolder, int i3, @NonNull List<Object> list) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long j3) {
            this.mAddDuration = j3;
        }

        public void setChangeDuration(long j3) {
            this.mChangeDuration = j3;
        }

        void setListener(ItemAnimatorListener itemAnimatorListener) {
            this.mListener = itemAnimatorListener;
        }

        public void setMoveDuration(long j3) {
            this.mMoveDuration = j3;
        }

        public void setRemoveDuration(long j3) {
            this.mRemoveDuration = j3;
        }

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder, @NonNull List<Object> list) {
            return canReuseUpdatedViewHolder(viewHolder);
        }

        public void onAnimationFinished(ViewHolder viewHolder) {
        }

        public void onAnimationStarted(ViewHolder viewHolder) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        ItemAnimatorRestoreListener() {
        }

        @Override // android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorListener
        public void onAnimationFinished(ViewHolder viewHolder) {
            viewHolder.setIsRecyclable(true);
            if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
                viewHolder.mShadowedHolder = null;
            }
            viewHolder.mShadowingHolder = null;
            if (!viewHolder.shouldBeKeptAsChild() && !RecyclerView.this.removeAnimatingView(viewHolder.itemView) && viewHolder.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class ItemDecoration {
        @Deprecated
        public void getItemOffsets(Rect rect, int i3, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
            onDraw(canvas, recyclerView);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
            onDrawOver(canvas, recyclerView);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class LayoutManager {
        ChildHelper mChildHelper;
        private int mHeightSpec;
        RecyclerView mRecyclerView;

        @Nullable
        SmoothScroller mSmoothScroller;
        private int mWidthSpec;
        private boolean mRequestedSimpleAnimations = false;
        boolean mIsAttachedToWindow = false;
        private boolean mAutoMeasure = false;
        private boolean mMeasurementCacheEnabled = true;

        /* compiled from: P */
        /* loaded from: classes.dex */
        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        private void addViewInt(View view, int i3, boolean z16) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null) {
                return;
            }
            if (!z16 && !childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (!childViewHolderInt.wasReturnedFromScrap() && !childViewHolderInt.isScrap()) {
                if (view.getParent() == this.mRecyclerView) {
                    int indexOfChild = this.mChildHelper.indexOfChild(view);
                    if (i3 == -1) {
                        i3 = this.mChildHelper.getChildCount();
                    }
                    if (indexOfChild != -1) {
                        if (indexOfChild != i3) {
                            this.mRecyclerView.mLayout.moveView(indexOfChild, i3);
                        }
                    } else {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view));
                    }
                } else {
                    this.mChildHelper.addView(view, i3, false);
                    layoutParams.mInsetsDirty = true;
                    SmoothScroller smoothScroller = this.mSmoothScroller;
                    if (smoothScroller != null && smoothScroller.isRunning()) {
                        this.mSmoothScroller.onChildAttachedToWindow(view);
                    }
                }
            } else {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.attachViewToParent(view, i3, view.getLayoutParams(), false);
            }
            if (layoutParams.mPendingInvalidate) {
                childViewHolderInt.itemView.invalidate();
                layoutParams.mPendingInvalidate = false;
            }
        }

        public static int chooseSize(int i3, int i16, int i17) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (mode != Integer.MIN_VALUE) {
                if (mode == 1073741824) {
                    return size;
                }
            } else {
                i16 = Math.min(size, i16);
            }
            return Math.max(i16, i17);
        }

        private void detachViewInternal(int i3, View view) {
            this.mChildHelper.detachViewFromParent(i3);
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
        
            if (r3 >= 0) goto L8;
         */
        @Deprecated
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

        public static Properties getProperties(Context context, AttributeSet attributeSet, int i3, int i16) {
            Properties properties = new Properties();
            properties.orientation = 1;
            properties.spanCount = 1;
            properties.reverseLayout = false;
            properties.stackFromEnd = false;
            return properties;
        }

        private static boolean isMeasurementUpToDate(int i3, int i16, int i17) {
            int mode = View.MeasureSpec.getMode(i16);
            int size = View.MeasureSpec.getSize(i16);
            if (i17 > 0 && i3 != i17) {
                return false;
            }
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    return true;
                }
                if (mode != 1073741824 || size != i3) {
                    return false;
                }
                return true;
            }
            if (size < i3) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onSmoothScrollerStopped(SmoothScroller smoothScroller) {
            if (this.mSmoothScroller == smoothScroller) {
                this.mSmoothScroller = null;
            }
        }

        private void scrapOrRecycleView(Recycler recycler, int i3, View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                    removeViewAt(i3);
                    recycler.recycleViewHolderInternal(childViewHolderInt);
                } else {
                    detachViewAt(i3);
                    recycler.scrapView(view);
                    this.mRecyclerView.mViewInfoStore.onViewDetached(childViewHolderInt);
                }
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(View view, int i3, LayoutParams layoutParams) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null) {
                return;
            }
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            }
            this.mChildHelper.attachViewToParent(view, i3, layoutParams, childViewHolderInt.isRemoved());
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
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
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(recycler, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(View view, Recycler recycler) {
            scrapOrRecycleView(recycler, this.mChildHelper.indexOfChild(view), view);
        }

        public void detachAndScrapViewAt(int i3, Recycler recycler) {
            scrapOrRecycleView(recycler, i3, getChildAt(i3));
        }

        public void detachView(View view) {
            int indexOfChild = this.mChildHelper.indexOfChild(view);
            if (indexOfChild >= 0) {
                detachViewInternal(indexOfChild, view);
            }
        }

        public void detachViewAt(int i3) {
            detachViewInternal(i3, getChildAt(i3));
        }

        void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        void dispatchDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, recycler);
        }

        public void endAnimation(View view) {
            ViewHolder childViewHolderInt;
            if (this.mRecyclerView.mItemAnimator != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(view)) != null) {
                this.mRecyclerView.mItemAnimator.endAnimation(childViewHolderInt);
            }
        }

        @Nullable
        public View findContainingItemView(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.isHidden(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int i3) {
            int childCount = getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = getChildAt(i16);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i3 && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.isPreLayout() || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.bottom;
        }

        public View getChildAt(int i3) {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.getChildAt(i3);
            }
            return null;
        }

        public int getChildCount() {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.getChildCount();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && recyclerView.mClipToPadding) {
                return true;
            }
            return false;
        }

        public int getColumnCountForAccessibility(Recycler recycler, State state) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
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
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.isHidden(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getHeight() {
            return View.MeasureSpec.getSize(this.mHeightSpec);
        }

        public int getHeightMode() {
            return View.MeasureSpec.getMode(this.mHeightSpec);
        }

        public int getItemCount() {
            Adapter adapter;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                adapter = recyclerView.getAdapter();
            } else {
                adapter = null;
            }
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.mRecyclerView);
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.left;
        }

        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.mRecyclerView);
        }

        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.mRecyclerView);
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getPaddingEnd(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getPaddingStart(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.right;
        }

        public int getRowCountForAccessibility(Recycler recycler, State state) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollVertically()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getSelectionModeForAccessibility(Recycler recycler, State state) {
            return 0;
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.top;
        }

        public int getWidth() {
            return View.MeasureSpec.getSize(this.mWidthSpec);
        }

        public int getWidthMode() {
            return View.MeasureSpec.getMode(this.mWidthSpec);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i3).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && recyclerView.hasFocus()) {
                return true;
            }
            return false;
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent == recyclerView && recyclerView.indexOfChild(view) != -1) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt == null) {
                    return;
                }
                childViewHolderInt.addFlags(128);
                this.mRecyclerView.mViewInfoStore.removeViewHolder(childViewHolderInt);
                return;
            }
            throw new IllegalArgumentException("View should be fully attached to be ignored");
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && recyclerView.isFocused()) {
                return true;
            }
            return false;
        }

        public boolean isLayoutHierarchical(Recycler recycler, State state) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
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
            int i17 = i3 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i18 = i16 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i17, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i18, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(View view, int i3, int i16) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i17 = i3 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i18 = i16 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i17, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i18, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i3, int i16) {
            View childAt = getChildAt(i3);
            if (childAt != null) {
                detachViewAt(i3);
                attachView(childAt, i16);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i3);
            }
        }

        public void offsetChildrenHorizontal(int i3) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i3);
            }
        }

        public void offsetChildrenVertical(int i3) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i3);
            }
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i3, int i16) {
            return false;
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        @Nullable
        public View onFocusSearchFailed(View view, int i3, Recycler recycler, State state) {
            return null;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, accessibilityNodeInfoCompat);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, accessibilityNodeInfoCompat);
        }

        public View onInterceptFocusSearch(View view, int i3) {
            return null;
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i3, int i16) {
        }

        public void onLayoutChildren(Recycler recycler, State state) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onMeasure(Recycler recycler, State state, int i3, int i16) {
            this.mRecyclerView.defaultOnMeasure(i3, i16);
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean performAccessibilityAction(int i3, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i3, bundle);
        }

        public boolean performAccessibilityActionForItem(Recycler recycler, State state, View view, int i3, Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                ViewCompat.postOnAnimation(recyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.removeViewAt(childCount);
            }
        }

        public void removeAndRecycleAllViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(getChildAt(childCount));
                if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        void removeAndRecycleScrapInt(Recycler recycler) {
            int scrapCount = recycler.getScrapCount();
            for (int i3 = scrapCount - 1; i3 >= 0; i3--) {
                View scrapViewAt = recycler.getScrapViewAt(i3);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(scrapViewAt);
                if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(scrapViewAt, false);
                    }
                    ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
                    if (itemAnimator != null) {
                        itemAnimator.endAnimation(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    recycler.quickRecycleScrapView(scrapViewAt);
                }
            }
            recycler.clearScrap();
            if (scrapCount > 0) {
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

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void removeView(View view) {
            this.mChildHelper.removeView(view);
        }

        public void removeViewAt(int i3) {
            if (getChildAt(i3) != null) {
                this.mChildHelper.removeViewAt(i3);
            }
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z16) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int i3 = left - paddingLeft;
            int min = Math.min(0, i3);
            int i16 = top - paddingTop;
            int min2 = Math.min(0, i16);
            int i17 = width2 - width;
            int max = Math.max(0, i17);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() == 1) {
                if (max == 0) {
                    max = Math.max(min, i17);
                }
            } else {
                if (min == 0) {
                    min = Math.min(i3, max);
                }
                max = min;
            }
            if (min2 == 0) {
                min2 = Math.min(i16, max2);
            }
            if (max == 0 && min2 == 0) {
                return false;
            }
            if (z16) {
                recyclerView.scrollBy(max, min2);
            } else {
                recyclerView.smoothScrollBy(max, min2);
            }
            return true;
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int scrollHorizontallyBy(int i3, Recycler recycler, State state) {
            return 0;
        }

        public int scrollVerticallyBy(int i3, Recycler recycler, State state) {
            return 0;
        }

        public void setAutoMeasureEnabled(boolean z16) {
            this.mAutoMeasure = z16;
        }

        void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        void setMeasureSpecs(int i3, int i16) {
            this.mWidthSpec = i3;
            this.mHeightSpec = i16;
        }

        public void setMeasuredDimension(Rect rect, int i3, int i16) {
            setMeasuredDimension(chooseSize(i3, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i16, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        void setMeasuredDimensionFromChildren(int i3, int i16) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i3, i16);
                return;
            }
            int i17 = Integer.MIN_VALUE;
            int i18 = Integer.MAX_VALUE;
            int i19 = Integer.MIN_VALUE;
            int i26 = Integer.MAX_VALUE;
            for (int i27 = 0; i27 < childCount; i27++) {
                View childAt = getChildAt(i27);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int decoratedLeft = getDecoratedLeft(childAt) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                int decoratedRight = getDecoratedRight(childAt) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int decoratedTop = getDecoratedTop(childAt) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                int decoratedBottom = getDecoratedBottom(childAt) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                if (decoratedLeft < i26) {
                    i26 = decoratedLeft;
                }
                if (decoratedRight > i17) {
                    i17 = decoratedRight;
                }
                if (decoratedTop < i18) {
                    i18 = decoratedTop;
                }
                if (decoratedBottom > i19) {
                    i19 = decoratedBottom;
                }
            }
            this.mRecyclerView.mTempRect.set(i26, i18, i17, i19);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i3, i16);
        }

        public void setMeasurementCacheEnabled(boolean z16) {
            this.mMeasurementCacheEnabled = z16;
        }

        void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidthSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
                this.mHeightSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
                return;
            }
            this.mRecyclerView = recyclerView;
            this.mChildHelper = recyclerView.mChildHelper;
            this.mWidthSpec = View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824);
            this.mHeightSpec = View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean shouldMeasureChild(View view, int i3, int i16, LayoutParams layoutParams) {
            if (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getWidth(), i3, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i16, ((ViewGroup.MarginLayoutParams) layoutParams).height)) {
                return false;
            }
            return true;
        }

        boolean shouldMeasureTwice() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean shouldReMeasureChild(View view, int i3, int i16, LayoutParams layoutParams) {
            if (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getMeasuredWidth(), i3, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getMeasuredHeight(), i16, ((ViewGroup.MarginLayoutParams) layoutParams).height)) {
                return false;
            }
            return true;
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i3) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.mSmoothScroller;
            if (smoothScroller2 != null && smoothScroller != smoothScroller2 && smoothScroller2.isRunning()) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = smoothScroller;
            smoothScroller.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null) {
                return;
            }
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
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

        public void addDisappearingView(View view, int i3) {
            addViewInt(view, i3, true);
        }

        public void addView(View view, int i3) {
            addViewInt(view, i3, false);
        }

        @CallSuper
        public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            onDetachedFromWindow(recyclerView);
        }

        public void onInitializeAccessibilityEvent(Recycler recycler, State state, AccessibilityEvent accessibilityEvent) {
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || asRecord == null) {
                return;
            }
            boolean z16 = true;
            if (!ViewCompat.canScrollVertically(recyclerView, 1) && !ViewCompat.canScrollVertically(this.mRecyclerView, -1) && !ViewCompat.canScrollHorizontally(this.mRecyclerView, -1) && !ViewCompat.canScrollHorizontally(this.mRecyclerView, 1)) {
                z16 = false;
            }
            asRecord.setScrollable(z16);
            if (this.mRecyclerView.mAdapter != null) {
                asRecord.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
            }
        }

        public void onInitializeAccessibilityNodeInfo(Recycler recycler, State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (ViewCompat.canScrollVertically(this.mRecyclerView, -1) || ViewCompat.canScrollHorizontally(this.mRecyclerView, -1)) {
                accessibilityNodeInfoCompat.addAction(8192);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (ViewCompat.canScrollVertically(this.mRecyclerView, 1) || ViewCompat.canScrollHorizontally(this.mRecyclerView, 1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i3, int i16, Object obj) {
            onItemsUpdated(recyclerView, i3, i16);
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, State state, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public boolean performAccessibilityAction(Recycler recycler, State state, int i3, Bundle bundle) {
            int height;
            int width;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return false;
            }
            if (i3 == 4096) {
                height = ViewCompat.canScrollVertically(recyclerView, 1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                if (ViewCompat.canScrollHorizontally(this.mRecyclerView, 1)) {
                    width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                }
                width = 0;
            } else if (i3 != 8192) {
                height = 0;
                width = 0;
            } else {
                height = ViewCompat.canScrollVertically(recyclerView, -1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                if (ViewCompat.canScrollHorizontally(this.mRecyclerView, -1)) {
                    width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                }
                width = 0;
            }
            if (height == 0 && width == 0) {
                return false;
            }
            this.mRecyclerView.scrollBy(width, height);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean performAccessibilityActionForItem(View view, int i3, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i3, bundle);
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        
            if (r5 == 1073741824) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int getChildMeasureSpec(int i3, int i16, int i17, int i18, boolean z16) {
            int max = Math.max(0, i3 - i17);
            if (z16) {
                if (i18 < 0) {
                    if (i18 == -1) {
                        if (i16 != Integer.MIN_VALUE) {
                            if (i16 != 0) {
                            }
                        }
                        i18 = max;
                    }
                    i16 = 0;
                    i18 = 0;
                }
                i16 = 1073741824;
            } else {
                if (i18 < 0) {
                    if (i18 != -1) {
                        if (i18 == -2) {
                            if (i16 == Integer.MIN_VALUE || i16 == 1073741824) {
                                i18 = max;
                                i16 = Integer.MIN_VALUE;
                            } else {
                                i18 = max;
                                i16 = 0;
                            }
                        }
                        i16 = 0;
                        i18 = 0;
                    }
                    i18 = max;
                }
                i16 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(i18, i16);
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
        }

        public void attachView(View view, int i3) {
            attachView(view, i3, (LayoutParams) view.getLayoutParams());
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void setMeasuredDimension(int i3, int i16) {
            this.mRecyclerView.setMeasuredDimension(i3, i16);
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        @CallSuper
        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public void onScrollStateChanged(int i3) {
        }

        public void scrollToPosition(int i3) {
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter2) {
        }

        public void onItemsAdded(RecyclerView recyclerView, int i3, int i16) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i3, int i16) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i3, int i16, int i17) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(View view);

        void onChildViewDetachedFromWindow(View view);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z16);

        void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class RecycledViewPool {
        private static final int DEFAULT_MAX_SCRAP = 5;
        private SparseArray<ArrayList<ViewHolder>> mScrap = new SparseArray<>();
        private SparseIntArray mMaxScrap = new SparseIntArray();
        private int mAttachCount = 0;

        private ArrayList<ViewHolder> getScrapHeapForType(int i3) {
            ArrayList<ViewHolder> arrayList = this.mScrap.get(i3);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.mScrap.put(i3, arrayList);
                if (this.mMaxScrap.indexOfKey(i3) < 0) {
                    this.mMaxScrap.put(i3, 5);
                }
            }
            return arrayList;
        }

        void attach(Adapter adapter) {
            this.mAttachCount++;
        }

        public void clear() {
            this.mScrap.clear();
        }

        void detach() {
            this.mAttachCount--;
        }

        public ViewHolder getRecycledView(int i3) {
            ArrayList<ViewHolder> arrayList = this.mScrap.get(i3);
            if (arrayList != null && !arrayList.isEmpty()) {
                int size = arrayList.size() - 1;
                ViewHolder viewHolder = arrayList.get(size);
                arrayList.remove(size);
                return viewHolder;
            }
            return null;
        }

        void onAdapterChanged(Adapter adapter, Adapter adapter2, boolean z16) {
            if (adapter != null) {
                detach();
            }
            if (!z16 && this.mAttachCount == 0) {
                clear();
            }
            if (adapter2 != null) {
                attach(adapter2);
            }
        }

        public void putRecycledView(ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<ViewHolder> scrapHeapForType = getScrapHeapForType(itemViewType);
            if (this.mMaxScrap.get(itemViewType) <= scrapHeapForType.size()) {
                return;
            }
            viewHolder.resetInternal();
            scrapHeapForType.add(viewHolder);
        }

        public void setMaxRecycledViews(int i3, int i16) {
            this.mMaxScrap.put(i3, i16);
            ArrayList<ViewHolder> arrayList = this.mScrap.get(i3);
            if (arrayList != null) {
                while (arrayList.size() > i16) {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }

        int size() {
            int i3 = 0;
            for (int i16 = 0; i16 < this.mScrap.size(); i16++) {
                ArrayList<ViewHolder> valueAt = this.mScrap.valueAt(i16);
                if (valueAt != null) {
                    i3 += valueAt.size();
                }
            }
            return i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public final class Recycler {
        private static final int DEFAULT_CACHE_SIZE = 2;
        final ArrayList<ViewHolder> mAttachedScrap;
        final ArrayList<ViewHolder> mCachedViews;
        private ArrayList<ViewHolder> mChangedScrap;
        private RecycledViewPool mRecyclerPool;
        private final List<ViewHolder> mUnmodifiableAttachedScrap;
        private ViewCacheExtension mViewCacheExtension;
        private int mViewCacheMax;

        public Recycler() {
            ArrayList<ViewHolder> arrayList = new ArrayList<>();
            this.mAttachedScrap = arrayList;
            this.mChangedScrap = null;
            this.mCachedViews = new ArrayList<>();
            this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(arrayList);
            this.mViewCacheMax = 2;
        }

        private void attachAccessibilityDelegate(View view) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                if (!ViewCompat.hasAccessibilityDelegate(view)) {
                    ViewCompat.setAccessibilityDelegate(view, RecyclerView.this.mAccessibilityDelegate.getItemDelegate());
                }
            }
        }

        private void invalidateDisplayListInt(ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ViewGroup) {
                invalidateDisplayListInt((ViewGroup) view, false);
            }
        }

        void addViewHolderToRecycledViewPool(ViewHolder viewHolder) {
            ViewCompat.setAccessibilityDelegate(viewHolder.itemView, null);
            dispatchViewRecycled(viewHolder);
            viewHolder.mOwnerRecyclerView = null;
            getRecycledViewPool().putRecycledView(viewHolder);
        }

        public void bindViewToPosition(View view, int i3) {
            LayoutParams layoutParams;
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                int findPositionOffset = RecyclerView.this.mAdapterHelper.findPositionOffset(i3);
                if (findPositionOffset >= 0 && findPositionOffset < RecyclerView.this.mAdapter.getItemCount()) {
                    RecyclerView recyclerView = RecyclerView.this;
                    childViewHolderInt.mOwnerRecyclerView = recyclerView;
                    recyclerView.mAdapter.bindViewHolder(childViewHolderInt, findPositionOffset);
                    attachAccessibilityDelegate(view);
                    if (RecyclerView.this.mState.isPreLayout()) {
                        childViewHolderInt.mPreLayoutPosition = i3;
                    }
                    ViewGroup.LayoutParams layoutParams2 = childViewHolderInt.itemView.getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                        childViewHolderInt.itemView.setLayoutParams(layoutParams);
                    } else if (!RecyclerView.this.checkLayoutParams(layoutParams2)) {
                        layoutParams = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams2);
                        childViewHolderInt.itemView.setLayoutParams(layoutParams);
                    } else {
                        layoutParams = (LayoutParams) layoutParams2;
                    }
                    boolean z16 = true;
                    layoutParams.mInsetsDirty = true;
                    layoutParams.mViewHolder = childViewHolderInt;
                    if (childViewHolderInt.itemView.getParent() != null) {
                        z16 = false;
                    }
                    layoutParams.mPendingInvalidate = z16;
                    return;
                }
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i3 + "(offset:" + findPositionOffset + ").state:" + RecyclerView.this.mState.getItemCount());
            }
            throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
        }

        public void clear() {
            this.mAttachedScrap.clear();
            recycleAndClearCachedViews();
        }

        void clearOldPositions() {
            int size = this.mCachedViews.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.mCachedViews.get(i3).clearOldPosition();
            }
            int size2 = this.mAttachedScrap.size();
            for (int i16 = 0; i16 < size2; i16++) {
                this.mAttachedScrap.get(i16).clearOldPosition();
            }
            ArrayList<ViewHolder> arrayList = this.mChangedScrap;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i17 = 0; i17 < size3; i17++) {
                    this.mChangedScrap.get(i17).clearOldPosition();
                }
            }
        }

        void clearScrap() {
            this.mAttachedScrap.clear();
            ArrayList<ViewHolder> arrayList = this.mChangedScrap;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int convertPreLayoutPositionToPostLayout(int i3) {
            if (i3 >= 0 && i3 < RecyclerView.this.mState.getItemCount()) {
                if (!RecyclerView.this.mState.isPreLayout()) {
                    return i3;
                }
                return RecyclerView.this.mAdapterHelper.findPositionOffset(i3);
            }
            throw new IndexOutOfBoundsException("invalid position " + i3 + ". State item count is " + RecyclerView.this.mState.getItemCount());
        }

        void dispatchViewRecycled(ViewHolder viewHolder) {
            if (RecyclerView.this.mRecyclerListener != null) {
                RecyclerView.this.mRecyclerListener.onViewRecycled(viewHolder);
            }
            if (RecyclerView.this.mAdapter != null) {
                RecyclerView.this.mAdapter.onViewRecycled(viewHolder);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mState != null) {
                recyclerView.mViewInfoStore.removeViewHolder(viewHolder);
            }
        }

        ViewHolder getChangedScrapViewForPosition(int i3) {
            int size;
            int findPositionOffset;
            ArrayList<ViewHolder> arrayList = this.mChangedScrap;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i16 = 0; i16 < size; i16++) {
                    ViewHolder viewHolder = this.mChangedScrap.get(i16);
                    if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i3) {
                        viewHolder.addFlags(32);
                        return viewHolder;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (findPositionOffset = RecyclerView.this.mAdapterHelper.findPositionOffset(i3)) > 0 && findPositionOffset < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(findPositionOffset);
                    for (int i17 = 0; i17 < size; i17++) {
                        ViewHolder viewHolder2 = this.mChangedScrap.get(i17);
                        if (!viewHolder2.wasReturnedFromScrap() && viewHolder2.getItemId() == itemId) {
                            viewHolder2.addFlags(32);
                            return viewHolder2;
                        }
                    }
                }
            }
            return null;
        }

        RecycledViewPool getRecycledViewPool() {
            if (this.mRecyclerPool == null) {
                this.mRecyclerPool = new RecycledViewPool();
            }
            return this.mRecyclerPool;
        }

        int getScrapCount() {
            return this.mAttachedScrap.size();
        }

        public List<ViewHolder> getScrapList() {
            return this.mUnmodifiableAttachedScrap;
        }

        View getScrapViewAt(int i3) {
            return this.mAttachedScrap.get(i3).itemView;
        }

        ViewHolder getScrapViewForId(long j3, int i3, boolean z16) {
            for (int size = this.mAttachedScrap.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mAttachedScrap.get(size);
                if (viewHolder.getItemId() == j3 && !viewHolder.wasReturnedFromScrap()) {
                    if (i3 == viewHolder.getItemViewType()) {
                        viewHolder.addFlags(32);
                        if (viewHolder.isRemoved() && !RecyclerView.this.mState.isPreLayout()) {
                            viewHolder.setFlags(2, 14);
                        }
                        return viewHolder;
                    }
                    if (!z16) {
                        this.mAttachedScrap.remove(size);
                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                        quickRecycleScrapView(viewHolder.itemView);
                    }
                }
            }
            for (int size2 = this.mCachedViews.size() - 1; size2 >= 0; size2--) {
                ViewHolder viewHolder2 = this.mCachedViews.get(size2);
                if (viewHolder2.getItemId() == j3) {
                    if (i3 == viewHolder2.getItemViewType()) {
                        if (!z16) {
                            this.mCachedViews.remove(size2);
                        }
                        return viewHolder2;
                    }
                    if (!z16) {
                        recycleCachedViewAt(size2);
                    }
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x00d0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        ViewHolder getScrapViewForPosition(int i3, int i16, boolean z16) {
            int size;
            View findHiddenNonRemovedView;
            int size2 = this.mAttachedScrap.size();
            for (int i17 = 0; i17 < size2; i17++) {
                ViewHolder viewHolder = this.mAttachedScrap.get(i17);
                if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i3 && !viewHolder.isInvalid() && (RecyclerView.this.mState.mInPreLayout || !viewHolder.isRemoved())) {
                    if (i16 != -1 && viewHolder.getItemViewType() != i16) {
                        Log.e("RecyclerView", "Scrap view for position " + i3 + " isn't dirty but has wrong view type! (found " + viewHolder.getItemViewType() + " but expected " + i16 + ")");
                        if (z16 && (findHiddenNonRemovedView = RecyclerView.this.mChildHelper.findHiddenNonRemovedView(i3, i16)) != null) {
                            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(findHiddenNonRemovedView);
                            if (childViewHolderInt == null) {
                                return null;
                            }
                            RecyclerView.this.mChildHelper.unhide(findHiddenNonRemovedView);
                            int indexOfChild = RecyclerView.this.mChildHelper.indexOfChild(findHiddenNonRemovedView);
                            if (indexOfChild != -1) {
                                RecyclerView.this.mChildHelper.detachViewFromParent(indexOfChild);
                                scrapView(findHiddenNonRemovedView);
                                childViewHolderInt.addFlags(MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED);
                                return childViewHolderInt;
                            }
                            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt);
                        }
                        size = this.mCachedViews.size();
                        for (int i18 = 0; i18 < size; i18++) {
                            ViewHolder viewHolder2 = this.mCachedViews.get(i18);
                            if (!viewHolder2.isInvalid() && viewHolder2.getLayoutPosition() == i3) {
                                if (!z16) {
                                    this.mCachedViews.remove(i18);
                                }
                                return viewHolder2;
                            }
                        }
                        return null;
                    }
                    viewHolder.addFlags(32);
                    return viewHolder;
                }
            }
            if (z16) {
            }
            size = this.mCachedViews.size();
            while (i18 < size) {
            }
            return null;
        }

        public View getViewForPosition(int i3) {
            return getViewForPosition(i3, false);
        }

        void markItemDecorInsetsDirty() {
            int size = this.mCachedViews.size();
            for (int i3 = 0; i3 < size; i3++) {
                LayoutParams layoutParams = (LayoutParams) this.mCachedViews.get(i3).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.mInsetsDirty = true;
                }
            }
        }

        void markKnownViewsInvalid() {
            if (RecyclerView.this.mAdapter != null && RecyclerView.this.mAdapter.hasStableIds()) {
                int size = this.mCachedViews.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ViewHolder viewHolder = this.mCachedViews.get(i3);
                    if (viewHolder != null) {
                        viewHolder.addFlags(6);
                        viewHolder.addChangePayload(null);
                    }
                }
                return;
            }
            recycleAndClearCachedViews();
        }

        void offsetPositionRecordsForInsert(int i3, int i16) {
            int size = this.mCachedViews.size();
            for (int i17 = 0; i17 < size; i17++) {
                ViewHolder viewHolder = this.mCachedViews.get(i17);
                if (viewHolder != null && viewHolder.mPosition >= i3) {
                    viewHolder.offsetPosition(i16, true);
                }
            }
        }

        void offsetPositionRecordsForMove(int i3, int i16) {
            int i17;
            int i18;
            int i19;
            int i26;
            if (i3 < i16) {
                i17 = -1;
                i19 = i3;
                i18 = i16;
            } else {
                i17 = 1;
                i18 = i3;
                i19 = i16;
            }
            int size = this.mCachedViews.size();
            for (int i27 = 0; i27 < size; i27++) {
                ViewHolder viewHolder = this.mCachedViews.get(i27);
                if (viewHolder != null && (i26 = viewHolder.mPosition) >= i19 && i26 <= i18) {
                    if (i26 == i3) {
                        viewHolder.offsetPosition(i16 - i3, false);
                    } else {
                        viewHolder.offsetPosition(i17, false);
                    }
                }
            }
        }

        void offsetPositionRecordsForRemove(int i3, int i16, boolean z16) {
            int i17 = i3 + i16;
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mCachedViews.get(size);
                if (viewHolder != null) {
                    int i18 = viewHolder.mPosition;
                    if (i18 >= i17) {
                        viewHolder.offsetPosition(-i16, z16);
                    } else if (i18 >= i3) {
                        viewHolder.addFlags(8);
                        recycleCachedViewAt(size);
                    }
                }
            }
        }

        void onAdapterChanged(Adapter adapter, Adapter adapter2, boolean z16) {
            clear();
            getRecycledViewPool().onAdapterChanged(adapter, adapter2, z16);
        }

        void quickRecycleScrapView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.mScrapContainer = null;
                childViewHolderInt.mInChangeScrap = false;
                childViewHolderInt.clearReturnedFromScrapFlag();
                recycleViewHolderInternal(childViewHolderInt);
            }
        }

        void recycleAndClearCachedViews() {
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                recycleCachedViewAt(size);
            }
            this.mCachedViews.clear();
        }

        void recycleCachedViewAt(int i3) {
            addViewHolderToRecycledViewPool(this.mCachedViews.get(i3));
            this.mCachedViews.remove(i3);
        }

        public void recycleView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null) {
                return;
            }
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            recycleViewHolderInternal(childViewHolderInt);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x006f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void recycleViewHolderInternal(ViewHolder viewHolder) {
            boolean z16;
            boolean z17;
            boolean z18 = true;
            boolean z19 = false;
            if (!viewHolder.isScrap() && viewHolder.itemView.getParent() == null) {
                if (!viewHolder.isTmpDetached()) {
                    if (!viewHolder.shouldIgnore()) {
                        boolean doesTransientStatePreventRecycling = viewHolder.doesTransientStatePreventRecycling();
                        if (RecyclerView.this.mAdapter != null && doesTransientStatePreventRecycling && RecyclerView.this.mAdapter.onFailedToRecycleView(viewHolder)) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16 && !viewHolder.isRecyclable()) {
                            z18 = false;
                        } else {
                            if (!viewHolder.hasAnyOfTheFlags(14)) {
                                int size = this.mCachedViews.size();
                                if (size == this.mViewCacheMax && size > 0) {
                                    recycleCachedViewAt(0);
                                }
                                if (size < this.mViewCacheMax) {
                                    this.mCachedViews.add(viewHolder);
                                    z17 = true;
                                    if (z17) {
                                        addViewHolderToRecycledViewPool(viewHolder);
                                    } else {
                                        z18 = false;
                                    }
                                    z19 = z17;
                                }
                            }
                            z17 = false;
                            if (z17) {
                            }
                            z19 = z17;
                        }
                        RecyclerView.this.mViewInfoStore.removeViewHolder(viewHolder);
                        if (!z19 && !z18 && doesTransientStatePreventRecycling) {
                            viewHolder.mOwnerRecyclerView = null;
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
                }
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Scrapped or attached views may not be recycled. isScrap:");
            sb5.append(viewHolder.isScrap());
            sb5.append(" isAttached:");
            if (viewHolder.itemView.getParent() == null) {
                z18 = false;
            }
            sb5.append(z18);
            throw new IllegalArgumentException(sb5.toString());
        }

        void recycleViewInternal(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                recycleViewHolderInternal(childViewHolderInt);
            }
        }

        void scrapView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null) {
                return;
            }
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.mChangedScrap == null) {
                    this.mChangedScrap = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.mChangedScrap.add(childViewHolderInt);
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !RecyclerView.this.mAdapter.hasStableIds()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
            childViewHolderInt.setScrapContainer(this, false);
            this.mAttachedScrap.add(childViewHolderInt);
        }

        void setAdapterPositionsAsUnknown() {
            int size = this.mCachedViews.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewHolder viewHolder = this.mCachedViews.get(i3);
                if (viewHolder != null) {
                    viewHolder.addFlags(512);
                }
            }
        }

        void setRecycledViewPool(RecycledViewPool recycledViewPool) {
            RecycledViewPool recycledViewPool2 = this.mRecyclerPool;
            if (recycledViewPool2 != null) {
                recycledViewPool2.detach();
            }
            this.mRecyclerPool = recycledViewPool;
            if (recycledViewPool != null) {
                recycledViewPool.attach(RecyclerView.this.getAdapter());
            }
        }

        void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
            this.mViewCacheExtension = viewCacheExtension;
        }

        public void setViewCacheSize(int i3) {
            this.mViewCacheMax = i3;
            for (int size = this.mCachedViews.size() - 1; size >= 0 && this.mCachedViews.size() > i3; size--) {
                recycleCachedViewAt(size);
            }
        }

        void unscrapView(ViewHolder viewHolder) {
            if (viewHolder.mInChangeScrap) {
                this.mChangedScrap.remove(viewHolder);
            } else {
                this.mAttachedScrap.remove(viewHolder);
            }
            viewHolder.mScrapContainer = null;
            viewHolder.mInChangeScrap = false;
            viewHolder.clearReturnedFromScrapFlag();
        }

        boolean validateViewHolderForOffsetPosition(ViewHolder viewHolder) {
            if (viewHolder.isRemoved()) {
                return RecyclerView.this.mState.isPreLayout();
            }
            int i3 = viewHolder.mPosition;
            if (i3 >= 0 && i3 < RecyclerView.this.mAdapter.getItemCount()) {
                if (!RecyclerView.this.mState.isPreLayout() && RecyclerView.this.mAdapter.getItemViewType(viewHolder.mPosition) != viewHolder.getItemViewType()) {
                    return false;
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && viewHolder.getItemId() != RecyclerView.this.mAdapter.getItemId(viewHolder.mPosition)) {
                    return false;
                }
                return true;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder);
        }

        void viewRangeUpdate(int i3, int i16) {
            int layoutPosition;
            int i17 = i16 + i3;
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mCachedViews.get(size);
                if (viewHolder != null && (layoutPosition = viewHolder.getLayoutPosition()) >= i3 && layoutPosition < i17) {
                    viewHolder.addFlags(2);
                    recycleCachedViewAt(size);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0143  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x01b1  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x01db A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01bf  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01a6  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        View getViewForPosition(int i3, boolean z16) {
            ViewHolder viewHolder;
            boolean z17;
            boolean z18;
            ViewGroup.LayoutParams layoutParams;
            LayoutParams layoutParams2;
            ViewCacheExtension viewCacheExtension;
            View viewForPositionAndType;
            if (i3 >= 0 && i3 < RecyclerView.this.mState.getItemCount()) {
                ViewHolder viewHolder2 = null;
                if (RecyclerView.this.mState.isPreLayout()) {
                    viewHolder = getChangedScrapViewForPosition(i3);
                    if (viewHolder != null) {
                        z17 = true;
                        if (viewHolder == null || (viewHolder = getScrapViewForPosition(i3, -1, z16)) == null) {
                            viewHolder2 = viewHolder;
                        } else if (validateViewHolderForOffsetPosition(viewHolder)) {
                            viewHolder2 = viewHolder;
                            z17 = true;
                        } else if (!z16) {
                            viewHolder.addFlags(4);
                            if (viewHolder.isScrap()) {
                                RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                                viewHolder.unScrap();
                            } else if (viewHolder.wasReturnedFromScrap()) {
                                viewHolder.clearReturnedFromScrapFlag();
                            }
                            recycleViewHolderInternal(viewHolder);
                        }
                        if (viewHolder2 == null) {
                            int findPositionOffset = RecyclerView.this.mAdapterHelper.findPositionOffset(i3);
                            if (findPositionOffset >= 0 && findPositionOffset < RecyclerView.this.mAdapter.getItemCount()) {
                                int itemViewType = RecyclerView.this.mAdapter.getItemViewType(findPositionOffset);
                                if (RecyclerView.this.mAdapter.hasStableIds() && (viewHolder2 = getScrapViewForId(RecyclerView.this.mAdapter.getItemId(findPositionOffset), itemViewType, z16)) != null) {
                                    viewHolder2.mPosition = findPositionOffset;
                                    z17 = true;
                                }
                                if (viewHolder2 == null && (viewCacheExtension = this.mViewCacheExtension) != null && (viewForPositionAndType = viewCacheExtension.getViewForPositionAndType(this, i3, itemViewType)) != null) {
                                    viewHolder2 = RecyclerView.this.getChildViewHolder(viewForPositionAndType);
                                    if (viewHolder2 != null) {
                                        if (viewHolder2.shouldIgnore()) {
                                            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                        }
                                    } else {
                                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                    }
                                }
                                if (viewHolder2 == null) {
                                    ViewHolder recycledView = getRecycledViewPool().getRecycledView(itemViewType);
                                    if (recycledView != null) {
                                        recycledView.resetInternal();
                                        if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                                            invalidateDisplayListInt(recycledView);
                                        }
                                    }
                                    viewHolder2 = recycledView;
                                }
                                if (viewHolder2 == null) {
                                    viewHolder2 = RecyclerView.this.mAdapter.createViewHolder(RecyclerView.this, itemViewType);
                                }
                            } else {
                                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i3 + "(offset:" + findPositionOffset + ").state:" + RecyclerView.this.mState.getItemCount());
                            }
                        }
                        if (z17 && !RecyclerView.this.mState.isPreLayout() && viewHolder2.hasAnyOfTheFlags(8192)) {
                            viewHolder2.setFlags(0, 8192);
                            if (RecyclerView.this.mState.mRunSimpleAnimations) {
                                int buildAdapterChangeFlagsForAnimations = ItemAnimator.buildAdapterChangeFlagsForAnimations(viewHolder2) | 4096;
                                RecyclerView recyclerView = RecyclerView.this;
                                RecyclerView.this.recordAnimationInfoIfBouncedHiddenView(viewHolder2, recyclerView.mItemAnimator.recordPreLayoutInformation(recyclerView.mState, viewHolder2, buildAdapterChangeFlagsForAnimations, viewHolder2.getUnmodifiedPayloads()));
                            }
                        }
                        if (!RecyclerView.this.mState.isPreLayout() && viewHolder2.isBound()) {
                            viewHolder2.mPreLayoutPosition = i3;
                        } else if (viewHolder2.isBound() || viewHolder2.needsUpdate() || viewHolder2.isInvalid()) {
                            int findPositionOffset2 = RecyclerView.this.mAdapterHelper.findPositionOffset(i3);
                            RecyclerView recyclerView2 = RecyclerView.this;
                            viewHolder2.mOwnerRecyclerView = recyclerView2;
                            recyclerView2.mAdapter.bindViewHolder(viewHolder2, findPositionOffset2);
                            attachAccessibilityDelegate(viewHolder2.itemView);
                            if (RecyclerView.this.mState.isPreLayout()) {
                                viewHolder2.mPreLayoutPosition = i3;
                            }
                            z18 = true;
                            layoutParams = viewHolder2.itemView.getLayoutParams();
                            if (layoutParams == null) {
                                layoutParams2 = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                                viewHolder2.itemView.setLayoutParams(layoutParams2);
                            } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                                layoutParams2 = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams);
                                viewHolder2.itemView.setLayoutParams(layoutParams2);
                            } else {
                                layoutParams2 = (LayoutParams) layoutParams;
                            }
                            layoutParams2.mViewHolder = viewHolder2;
                            layoutParams2.mPendingInvalidate = !z17 && z18;
                            return viewHolder2.itemView;
                        }
                        z18 = false;
                        layoutParams = viewHolder2.itemView.getLayoutParams();
                        if (layoutParams == null) {
                        }
                        layoutParams2.mViewHolder = viewHolder2;
                        layoutParams2.mPendingInvalidate = !z17 && z18;
                        return viewHolder2.itemView;
                    }
                } else {
                    viewHolder = null;
                }
                z17 = false;
                if (viewHolder == null) {
                }
                viewHolder2 = viewHolder;
                if (viewHolder2 == null) {
                }
                if (z17) {
                    viewHolder2.setFlags(0, 8192);
                    if (RecyclerView.this.mState.mRunSimpleAnimations) {
                    }
                }
                if (!RecyclerView.this.mState.isPreLayout()) {
                }
                if (viewHolder2.isBound()) {
                }
                int findPositionOffset22 = RecyclerView.this.mAdapterHelper.findPositionOffset(i3);
                RecyclerView recyclerView22 = RecyclerView.this;
                viewHolder2.mOwnerRecyclerView = recyclerView22;
                recyclerView22.mAdapter.bindViewHolder(viewHolder2, findPositionOffset22);
                attachAccessibilityDelegate(viewHolder2.itemView);
                if (RecyclerView.this.mState.isPreLayout()) {
                }
                z18 = true;
                layoutParams = viewHolder2.itemView.getLayoutParams();
                if (layoutParams == null) {
                }
                layoutParams2.mViewHolder = viewHolder2;
                layoutParams2.mPendingInvalidate = !z17 && z18;
                return viewHolder2.itemView;
            }
            throw new IndexOutOfBoundsException("Invalid item position " + i3 + "(" + i3 + "). Item count:" + RecyclerView.this.mState.getItemCount());
        }

        private void invalidateDisplayListInt(ViewGroup viewGroup, boolean z16) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    invalidateDisplayListInt((ViewGroup) childAt, true);
                }
            }
            if (z16) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface RecyclerListener {
        void onViewRecycled(ViewHolder viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class RecyclerViewDataObserver extends AdapterDataObserver {
        RecyclerViewDataObserver() {
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapter.hasStableIds()) {
                RecyclerView.this.mState.mStructureChanged = true;
                RecyclerView.this.setDataSetChangedAfterLayout();
            } else {
                RecyclerView.this.mState.mStructureChanged = true;
                RecyclerView.this.setDataSetChangedAfterLayout();
            }
            if (!RecyclerView.this.mAdapterHelper.hasPendingUpdates()) {
                RecyclerView.this.requestLayout();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeChanged(i3, i16, obj)) {
                triggerUpdateProcessor();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i16) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeInserted(i3, i16)) {
                triggerUpdateProcessor();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i3, int i16, int i17) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeMoved(i3, i16, i17)) {
                triggerUpdateProcessor();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i16) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeRemoved(i3, i16)) {
                triggerUpdateProcessor();
            }
        }

        void triggerUpdateProcessor() {
            if (!RecyclerView.this.mPostUpdatesOnAnimation || !RecyclerView.this.mHasFixedSize || !RecyclerView.this.mIsAttached) {
                RecyclerView.this.mAdapterUpdateDuringMeasure = true;
                RecyclerView.this.requestLayout();
            } else {
                RecyclerView recyclerView = RecyclerView.this;
                ViewCompat.postOnAnimation(recyclerView, recyclerView.mUpdateChildViewsRunnable);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class SmoothScroller {
        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private boolean mRunning;
        private View mTargetView;
        private int mTargetPosition = -1;
        private final Action mRecyclingAction = new Action(0, 0);

        /* compiled from: P */
        /* loaded from: classes.dex */
        public static class Action {
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
            private boolean changed;
            private int consecutiveUpdates;
            private int mDuration;
            private int mDx;
            private int mDy;
            private Interpolator mInterpolator;
            private int mJumpToPosition;

            public Action(int i3, int i16) {
                this(i3, i16, Integer.MIN_VALUE, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void runIfNecessary(RecyclerView recyclerView) {
                int i3 = this.mJumpToPosition;
                if (i3 >= 0) {
                    this.mJumpToPosition = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i3);
                    this.changed = false;
                } else {
                    if (this.changed) {
                        validate();
                        if (this.mInterpolator == null) {
                            if (this.mDuration == Integer.MIN_VALUE) {
                                recyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy);
                            } else {
                                recyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration);
                            }
                        } else {
                            recyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
                        }
                        int i16 = this.consecutiveUpdates + 1;
                        this.consecutiveUpdates = i16;
                        if (i16 > 10) {
                            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.changed = false;
                        return;
                    }
                    this.consecutiveUpdates = 0;
                }
            }

            private void validate() {
                if (this.mInterpolator != null && this.mDuration < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.mDuration >= 1) {
                } else {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
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

            boolean hasJumpTarget() {
                if (this.mJumpToPosition >= 0) {
                    return true;
                }
                return false;
            }

            public void jumpTo(int i3) {
                this.mJumpToPosition = i3;
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

            public Action(int i3, int i16, int i17) {
                this(i3, i16, i17, null);
            }

            public Action(int i3, int i16, int i17, Interpolator interpolator) {
                this.mJumpToPosition = -1;
                this.changed = false;
                this.consecutiveUpdates = 0;
                this.mDx = i3;
                this.mDy = i16;
                this.mDuration = i17;
                this.mInterpolator = interpolator;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onAnimation(int i3, int i16) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (!this.mRunning || this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.runIfNecessary(recyclerView);
                    stop();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i3, i16, recyclerView.mState, this.mRecyclingAction);
                boolean hasJumpTarget = this.mRecyclingAction.hasJumpTarget();
                this.mRecyclingAction.runIfNecessary(recyclerView);
                if (hasJumpTarget) {
                    if (this.mRunning) {
                        this.mPendingInitialRun = true;
                        recyclerView.mViewFlinger.postOnAnimation();
                    } else {
                        stop();
                    }
                }
            }
        }

        public View findViewByPosition(int i3) {
            return this.mRecyclerView.mLayout.findViewByPosition(i3);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        @Nullable
        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
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

        void start(RecyclerView recyclerView, LayoutManager layoutManager) {
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = layoutManager;
            int i3 = this.mTargetPosition;
            if (i3 != -1) {
                recyclerView.mState.mTargetPosition = i3;
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
            this.mRecyclerView.mState.mTargetPosition = -1;
            this.mTargetView = null;
            this.mTargetPosition = -1;
            this.mPendingInitialRun = false;
            this.mRunning = false;
            this.mLayoutManager.onSmoothScrollerStopped(this);
            this.mLayoutManager = null;
            this.mRecyclerView = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class State {
        static final int STEP_ANIMATIONS = 4;
        static final int STEP_LAYOUT = 2;
        static final int STEP_START = 1;
        private SparseArray<Object> mData;
        private int mTargetPosition = -1;
        private int mLayoutStep = 1;
        int mItemCount = 0;
        private int mPreviousLayoutItemCount = 0;
        private int mDeletedInvisibleItemCountSincePreviousLayout = 0;
        private boolean mStructureChanged = false;
        private boolean mInPreLayout = false;
        private boolean mRunSimpleAnimations = false;
        private boolean mRunPredictiveAnimations = false;
        private boolean mTrackOldChangeHolders = false;
        private boolean mIsMeasuring = false;

        static /* synthetic */ int access$1712(State state, int i3) {
            int i16 = state.mDeletedInvisibleItemCountSincePreviousLayout + i3;
            state.mDeletedInvisibleItemCountSincePreviousLayout = i16;
            return i16;
        }

        void assertLayoutStep(int i3) {
            if ((this.mLayoutStep & i3) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i3) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
        }

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
            if (this.mTargetPosition != -1) {
                return true;
            }
            return false;
        }

        public boolean isMeasuring() {
            return this.mIsMeasuring;
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
            this.mTargetPosition = -1;
            SparseArray<Object> sparseArray = this.mData;
            if (sparseArray != null) {
                sparseArray.clear();
            }
            this.mItemCount = 0;
            this.mStructureChanged = false;
            this.mIsMeasuring = false;
            return this;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.mTargetPosition + ", mData=" + this.mData + ", mItemCount=" + this.mItemCount + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
        }

        public boolean willRunPredictiveAnimations() {
            return this.mRunPredictiveAnimations;
        }

        public boolean willRunSimpleAnimations() {
            return this.mRunSimpleAnimations;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class ViewCacheExtension {
        public abstract View getViewForPositionAndType(Recycler recycler, int i3, int i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class ViewFlinger implements Runnable {
        private int mLastFlingX;
        private int mLastFlingY;
        private ScrollerCompat mScroller;
        private Interpolator mInterpolator = RecyclerView.sQuinticInterpolator;
        private boolean mEatRunOnAnimationRequest = false;
        private boolean mReSchedulePostAnimationCallback = false;

        public ViewFlinger() {
            this.mScroller = ScrollerCompat.create(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
        }

        private int computeScrollDuration(int i3, int i16, int i17, int i18) {
            boolean z16;
            int height;
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
            RecyclerView recyclerView = RecyclerView.this;
            if (z16) {
                height = recyclerView.getWidth();
            } else {
                height = recyclerView.getHeight();
            }
            int i26 = height / 2;
            float f16 = height;
            float f17 = i26;
            float distanceInfluenceForSnapDuration = f17 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (sqrt2 * 1.0f) / f16)) * f17);
            if (sqrt > 0) {
                i19 = Math.round(Math.abs(distanceInfluenceForSnapDuration / sqrt) * 1000.0f) * 4;
            } else {
                if (!z16) {
                    abs = abs2;
                }
                i19 = (int) (((abs / f16) + 1.0f) * 300.0f);
            }
            return Math.min(i19, 2000);
        }

        private void disableRunOnAnimationRequests() {
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
        }

        private float distanceInfluenceForSnapDuration(float f16) {
            return (float) Math.sin((float) ((f16 - 0.5f) * 0.4712389167638204d));
        }

        private void enableRunOnAnimationRequests() {
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback) {
                postOnAnimation();
            }
        }

        public void fling(int i3, int i16) {
            RecyclerView.this.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            this.mScroller.fling(0, 0, i3, i16, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            postOnAnimation();
        }

        void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                ViewCompat.postOnAnimation(RecyclerView.this, this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:84:0x00fb, code lost:
        
            if (r12 > 0) goto L52;
         */
        /* JADX WARN: Removed duplicated region for block: B:70:0x00f7  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x010e A[ADDED_TO_REGION] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i3;
            int i16;
            int i17;
            int i18;
            int i19;
            boolean z16;
            boolean z17;
            boolean z18;
            if (RecyclerView.this.mLayout == null) {
                stop();
                return;
            }
            disableRunOnAnimationRequests();
            RecyclerView.this.consumePendingUpdateOperations();
            ScrollerCompat scrollerCompat = this.mScroller;
            SmoothScroller smoothScroller = RecyclerView.this.mLayout.mSmoothScroller;
            if (scrollerCompat.computeScrollOffset()) {
                int currX = scrollerCompat.getCurrX();
                int currY = scrollerCompat.getCurrY();
                int i26 = currX - this.mLastFlingX;
                int i27 = currY - this.mLastFlingY;
                this.mLastFlingX = currX;
                this.mLastFlingY = currY;
                if (RecyclerView.this.mAdapter != null) {
                    RecyclerView.this.eatRequestLayout();
                    RecyclerView.this.onEnterLayoutOrScroll();
                    TraceCompat.beginSection(RecyclerView.TRACE_SCROLL_TAG);
                    if (i26 != 0) {
                        RecyclerView recyclerView = RecyclerView.this;
                        i3 = recyclerView.mLayout.scrollHorizontallyBy(i26, recyclerView.mRecycler, recyclerView.mState);
                        i16 = i26 - i3;
                    } else {
                        i3 = 0;
                        i16 = 0;
                    }
                    if (i27 != 0) {
                        RecyclerView recyclerView2 = RecyclerView.this;
                        i17 = recyclerView2.mLayout.scrollVerticallyBy(i27, recyclerView2.mRecycler, recyclerView2.mState);
                        i18 = i27 - i17;
                    } else {
                        i17 = 0;
                        i18 = 0;
                    }
                    TraceCompat.endSection();
                    RecyclerView.this.repositionShadowingViews();
                    RecyclerView.this.onExitLayoutOrScroll();
                    RecyclerView.this.resumeRequestLayout(false);
                    if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                        int itemCount = RecyclerView.this.mState.getItemCount();
                        if (itemCount == 0) {
                            smoothScroller.stop();
                        } else if (smoothScroller.getTargetPosition() < itemCount) {
                            smoothScroller.onAnimation(i26 - i16, i27 - i18);
                        } else {
                            smoothScroller.setTargetPosition(itemCount - 1);
                            smoothScroller.onAnimation(i26 - i16, i27 - i18);
                        }
                    }
                } else {
                    i3 = 0;
                    i16 = 0;
                    i17 = 0;
                    i18 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (ViewCompat.getOverScrollMode(RecyclerView.this) != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i26, i27);
                }
                if (i16 != 0 || i18 != 0) {
                    int currVelocity = (int) scrollerCompat.getCurrVelocity();
                    if (i16 != currX) {
                        if (i16 < 0) {
                            i19 = -currVelocity;
                        } else if (i16 > 0) {
                            i19 = currVelocity;
                        }
                        if (i18 != currY) {
                            if (i18 < 0) {
                                currVelocity = -currVelocity;
                            }
                            if (ViewCompat.getOverScrollMode(RecyclerView.this) != 2) {
                                RecyclerView.this.absorbGlows(i19, currVelocity);
                            }
                            if ((i19 == 0 || i16 == currX || scrollerCompat.getFinalX() == 0) && (currVelocity != 0 || i18 == currY || scrollerCompat.getFinalY() == 0)) {
                                scrollerCompat.abortAnimation();
                            }
                        }
                        currVelocity = 0;
                        if (ViewCompat.getOverScrollMode(RecyclerView.this) != 2) {
                        }
                        if (i19 == 0) {
                        }
                        scrollerCompat.abortAnimation();
                    }
                    i19 = 0;
                    if (i18 != currY) {
                    }
                    currVelocity = 0;
                    if (ViewCompat.getOverScrollMode(RecyclerView.this) != 2) {
                    }
                    if (i19 == 0) {
                    }
                    scrollerCompat.abortAnimation();
                }
                if (i3 != 0 || i17 != 0) {
                    RecyclerView.this.dispatchOnScrolled(i3, i17);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                if (i27 != 0 && RecyclerView.this.mLayout.canScrollVertically() && i17 == i27) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (i26 != 0 && RecyclerView.this.mLayout.canScrollHorizontally() && i3 == i26) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if ((i26 != 0 || i27 != 0) && !z17 && !z16) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (scrollerCompat.isFinished() || !z18) {
                    RecyclerView.this.setScrollState(0);
                } else {
                    postOnAnimation();
                }
            }
            if (smoothScroller != null) {
                if (smoothScroller.isPendingInitialRun()) {
                    smoothScroller.onAnimation(0, 0);
                }
                if (!this.mReSchedulePostAnimationCallback) {
                    smoothScroller.stop();
                }
            }
            enableRunOnAnimationRequests();
        }

        public void smoothScrollBy(int i3, int i16) {
            smoothScrollBy(i3, i16, 0, 0);
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.mScroller.abortAnimation();
        }

        public void smoothScrollBy(int i3, int i16, int i17, int i18) {
            smoothScrollBy(i3, i16, computeScrollDuration(i3, i16, i17, i18));
        }

        public void smoothScrollBy(int i3, int i16, int i17) {
            smoothScrollBy(i3, i16, i17, RecyclerView.sQuinticInterpolator);
        }

        public void smoothScrollBy(int i3, int i16, int i17, Interpolator interpolator) {
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mScroller = ScrollerCompat.create(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            this.mScroller.startScroll(0, 0, i3, i16, i17);
            postOnAnimation();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class ViewHolder {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
        public final View itemView;
        private int mFlags;
        RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        ViewHolder mShadowedHolder = null;
        ViewHolder mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        private Recycler mScrapContainer = null;
        private boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        public ViewHolder(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean doesTransientStatePreventRecycling() {
            if ((this.mFlags & 16) == 0 && ViewCompat.hasTransientState(this.itemView)) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onEnteredHiddenState() {
            this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
            ViewCompat.setImportantForAccessibility(this.itemView, 4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onLeftHiddenState() {
            ViewCompat.setImportantForAccessibility(this.itemView, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean shouldBeKeptAsChild() {
            if ((this.mFlags & 16) != 0) {
                return true;
            }
            return false;
        }

        void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        void addFlags(int i3) {
            this.mFlags = i3 | this.mFlags;
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        void flagRemovedAndOffsetPosition(int i3, int i16, boolean z16) {
            addFlags(8);
            offsetPosition(i16, z16);
            this.mPosition = i3;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getAdapterPositionFor(this);
            }
            return -1;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i3 = this.mPreLayoutPosition;
            if (i3 == -1) {
                return this.mPosition;
            }
            return i3;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i3 = this.mPreLayoutPosition;
            if (i3 == -1) {
                return this.mPosition;
            }
            return i3;
        }

        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) == 0) {
                List<Object> list = this.mPayloads;
                if (list != null && list.size() != 0) {
                    return this.mUnmodifiedPayloads;
                }
                return FULLUPDATE_PAYLOADS;
            }
            return FULLUPDATE_PAYLOADS;
        }

        boolean hasAnyOfTheFlags(int i3) {
            if ((i3 & this.mFlags) != 0) {
                return true;
            }
            return false;
        }

        boolean isAdapterPositionUnknown() {
            if ((this.mFlags & 512) == 0 && !isInvalid()) {
                return false;
            }
            return true;
        }

        boolean isBound() {
            if ((this.mFlags & 1) != 0) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isInvalid() {
            if ((this.mFlags & 4) != 0) {
                return true;
            }
            return false;
        }

        public final boolean isRecyclable() {
            if ((this.mFlags & 16) == 0 && !ViewCompat.hasTransientState(this.itemView)) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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

        boolean isTmpDetached() {
            if ((this.mFlags & 256) != 0) {
                return true;
            }
            return false;
        }

        boolean isUpdated() {
            if ((this.mFlags & 2) != 0) {
                return true;
            }
            return false;
        }

        boolean needsUpdate() {
            if ((this.mFlags & 2) != 0) {
                return true;
            }
            return false;
        }

        void offsetPosition(int i3, boolean z16) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z16) {
                this.mPreLayoutPosition += i3;
            }
            this.mPosition += i3;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            }
        }

        void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        void setFlags(int i3, int i16) {
            this.mFlags = (i3 & i16) | (this.mFlags & (~i16));
        }

        public final void setIsRecyclable(boolean z16) {
            int i3;
            int i16 = this.mIsRecyclableCount;
            if (z16) {
                i3 = i16 - 1;
            } else {
                i3 = i16 + 1;
            }
            this.mIsRecyclableCount = i3;
            if (i3 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z16 && i3 == 1) {
                this.mFlags |= 16;
            } else if (z16 && i3 == 0) {
                this.mFlags &= -17;
            }
        }

        void setScrapContainer(Recycler recycler, boolean z16) {
            this.mScrapContainer = recycler;
            this.mInChangeScrap = z16;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean shouldIgnore() {
            if ((this.mFlags & 128) != 0) {
                return true;
            }
            return false;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            String str;
            StringBuilder sb5 = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb5.append(" scrap ");
                if (this.mInChangeScrap) {
                    str = "[changeScrap]";
                } else {
                    str = "[attachedScrap]";
                }
                sb5.append(str);
            }
            if (isInvalid()) {
                sb5.append(" invalid");
            }
            if (!isBound()) {
                sb5.append(" unbound");
            }
            if (needsUpdate()) {
                sb5.append(" update");
            }
            if (isRemoved()) {
                sb5.append(" removed");
            }
            if (shouldIgnore()) {
                sb5.append(" ignored");
            }
            if (isTmpDetached()) {
                sb5.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb5.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb5.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb5.append(" no parent");
            }
            sb5.append("}");
            return sb5.toString();
        }

        void unScrap() {
            this.mScrapContainer.unscrapView(this);
        }

        boolean wasReturnedFromScrap() {
            if ((this.mFlags & 32) != 0) {
                return true;
            }
            return false;
        }
    }

    static {
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new Interpolator() { // from class: android.support.v7.widget.RecyclerView.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f16) {
                float f17 = f16 - 1.0f;
                return (f17 * f17 * f17 * f17 * f17) + 1.0f;
            }
        };
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void addAnimatingView(ViewHolder viewHolder) {
        boolean z16;
        View view = viewHolder.itemView;
        if (view.getParent() == this) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mRecycler.unscrapView(getChildViewHolder(view));
        if (viewHolder.isTmpDetached()) {
            this.mChildHelper.attachViewToParent(view, -1, view.getLayoutParams(), true);
        } else if (!z16) {
            this.mChildHelper.addView(view, true);
        } else {
            this.mChildHelper.hide(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateAppearance(@NonNull ViewHolder viewHolder, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    private void animateChange(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z16, boolean z17) {
        viewHolder.setIsRecyclable(false);
        if (z16) {
            addAnimatingView(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z17) {
                addAnimatingView(viewHolder2);
            }
            viewHolder.mShadowedHolder = viewHolder2;
            addAnimatingView(viewHolder);
            this.mRecycler.unscrapView(viewHolder);
            viewHolder2.setIsRecyclable(false);
            viewHolder2.mShadowingHolder = viewHolder;
        }
        if (this.mItemAnimator.animateChange(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateDisappearance(@NonNull ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        addAnimatingView(viewHolder);
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null && !itemAnimator.canReuseUpdatedViewHolder(viewHolder, viewHolder.getUnmodifiedPayloads())) {
            return false;
        }
        return true;
    }

    private void cancelTouch() {
        resetTouch();
        setScrollState(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void considerReleasingGlowsOnScroll(int i3, int i16) {
        boolean z16;
        EdgeEffectCompat edgeEffectCompat = this.mLeftGlow;
        if (edgeEffectCompat != null && !edgeEffectCompat.isFinished() && i3 > 0) {
            z16 = this.mLeftGlow.onRelease();
        } else {
            z16 = false;
        }
        EdgeEffectCompat edgeEffectCompat2 = this.mRightGlow;
        if (edgeEffectCompat2 != null && !edgeEffectCompat2.isFinished() && i3 < 0) {
            z16 |= this.mRightGlow.onRelease();
        }
        EdgeEffectCompat edgeEffectCompat3 = this.mTopGlow;
        if (edgeEffectCompat3 != null && !edgeEffectCompat3.isFinished() && i16 > 0) {
            z16 |= this.mTopGlow.onRelease();
        }
        EdgeEffectCompat edgeEffectCompat4 = this.mBottomGlow;
        if (edgeEffectCompat4 != null && !edgeEffectCompat4.isFinished() && i16 < 0) {
            z16 |= this.mBottomGlow.onRelease();
        }
        if (z16) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete) {
            return;
        }
        if (this.mDataSetHasChangedAfterLayout) {
            TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            TraceCompat.endSection();
            return;
        }
        if (!this.mAdapterHelper.hasPendingUpdates()) {
            return;
        }
        if (this.mAdapterHelper.hasAnyUpdateTypes(4) && !this.mAdapterHelper.hasAnyUpdateTypes(11)) {
            TraceCompat.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
            eatRequestLayout();
            this.mAdapterHelper.preProcess();
            if (!this.mLayoutRequestEaten) {
                if (hasUpdatedView()) {
                    dispatchLayout();
                } else {
                    this.mAdapterHelper.consumePostponedUpdates();
                }
            }
            resumeRequestLayout(true);
            TraceCompat.endSection();
            return;
        }
        if (this.mAdapterHelper.hasPendingUpdates()) {
            TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            TraceCompat.endSection();
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i3, int i16) {
        ClassLoader classLoader;
        Constructor constructor;
        Object[] objArr;
        if (str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                String fullClassName = getFullClassName(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = classLoader.loadClass(fullClassName).asSubclass(LayoutManager.class);
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16)};
                    } catch (NoSuchMethodException e16) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        } catch (NoSuchMethodException e17) {
                            e17.initCause(e16);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e17);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (ClassCastException e18) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e18);
                } catch (ClassNotFoundException e19) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e19);
                } catch (IllegalAccessException e26) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e26);
                } catch (InstantiationException e27) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e27);
                } catch (InvocationTargetException e28) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e28);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void defaultOnMeasure(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            size = ViewCompat.getMinimumWidth(this);
        }
        if (mode2 != Integer.MIN_VALUE && mode2 != 1073741824) {
            size2 = ViewCompat.getMinimumHeight(this);
        }
        setMeasuredDimension(size, size2);
    }

    private boolean didChildRangeChange(int i3, int i16) {
        int layoutPosition;
        int childCount = this.mChildHelper.getChildCount();
        if (childCount == 0) {
            if (i3 != 0 || i16 != 0) {
                return true;
            }
            return false;
        }
        for (int i17 = 0; i17 < childCount; i17++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i17));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && ((layoutPosition = childViewHolderInt.getLayoutPosition()) < i3 || layoutPosition > i16)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchChildAttached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        Adapter adapter = this.mAdapter;
        if (adapter != null && childViewHolderInt != null) {
            adapter.onViewAttachedToWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewAttachedToWindow(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchChildDetached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.mAdapter;
        if (adapter != null && childViewHolderInt != null) {
            adapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    private void dispatchContentChangedIfNecessary() {
        int i3 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i3 != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            AccessibilityEventCompat.setContentChangeTypes(obtain, i3);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void dispatchLayoutStep1() {
        boolean z16 = true;
        this.mState.assertLayoutStep(1);
        this.mState.mIsMeasuring = false;
        eatRequestLayout();
        this.mViewInfoStore.clear();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        State state = this.mState;
        if (!state.mRunSimpleAnimations || !this.mItemsChanged) {
            z16 = false;
        }
        state.mTrackOldChangeHolders = z16;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        State state2 = this.mState;
        state2.mInPreLayout = state2.mRunPredictiveAnimations;
        this.mState.mItemCount = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.mRunSimpleAnimations) {
            int childCount = this.mChildHelper.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i3));
                if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.addToPreLayout(childViewHolderInt, this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt, ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.mTrackOldChangeHolders && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.addToOldChangeHolders(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.mRunPredictiveAnimations) {
            saveOldPositions();
            boolean z17 = this.mState.mStructureChanged;
            this.mState.mStructureChanged = false;
            this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
            this.mState.mStructureChanged = z17;
            for (int i16 = 0; i16 < this.mChildHelper.getChildCount(); i16++) {
                ViewHolder childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.getChildAt(i16));
                if (childViewHolderInt2 != null && !childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.isInPreLayout(childViewHolderInt2)) {
                    int buildAdapterChangeFlagsForAnimations = ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt2);
                    boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        buildAdapterChangeFlagsForAnimations |= 4096;
                    }
                    ItemAnimator.ItemHolderInfo recordPreLayoutInformation = this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt2, buildAdapterChangeFlagsForAnimations, childViewHolderInt2.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, recordPreLayoutInformation);
                    } else {
                        this.mViewInfoStore.addToAppearedInPreLayoutHolders(childViewHolderInt2, recordPreLayoutInformation);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        resumeRequestLayout(false);
        this.mState.mLayoutStep = 2;
    }

    private void dispatchLayoutStep2() {
        boolean z16;
        eatRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.assertLayoutStep(6);
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mItemCount = this.mAdapter.getItemCount();
        this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        this.mState.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
        this.mState.mStructureChanged = false;
        this.mPendingSavedState = null;
        State state = this.mState;
        if (state.mRunSimpleAnimations && this.mItemAnimator != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        state.mRunSimpleAnimations = z16;
        this.mState.mLayoutStep = 4;
        onExitLayoutOrScroll();
        resumeRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.assertLayoutStep(4);
        eatRequestLayout();
        this.mState.mLayoutStep = 1;
        if (this.mState.mRunSimpleAnimations) {
            int childCount = this.mChildHelper.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i3));
                if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    ItemAnimator.ItemHolderInfo recordPostLayoutInformation = this.mItemAnimator.recordPostLayoutInformation(this.mState, childViewHolderInt);
                    ViewHolder fromOldChangeHolders = this.mViewInfoStore.getFromOldChangeHolders(changedHolderKey);
                    if (fromOldChangeHolders != null && !fromOldChangeHolders.shouldIgnore()) {
                        boolean isDisappearing = this.mViewInfoStore.isDisappearing(fromOldChangeHolders);
                        boolean isDisappearing2 = this.mViewInfoStore.isDisappearing(childViewHolderInt);
                        ItemAnimator.ItemHolderInfo popFromPreLayout = this.mViewInfoStore.popFromPreLayout(fromOldChangeHolders);
                        this.mViewInfoStore.addToPostLayout(childViewHolderInt, recordPostLayoutInformation);
                        ItemAnimator.ItemHolderInfo popFromPostLayout = this.mViewInfoStore.popFromPostLayout(childViewHolderInt);
                        if (popFromPreLayout == null) {
                            handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, fromOldChangeHolders);
                        } else {
                            animateChange(fromOldChangeHolders, childViewHolderInt, popFromPreLayout, popFromPostLayout, isDisappearing, isDisappearing2);
                        }
                    } else {
                        this.mViewInfoStore.addToPostLayout(childViewHolderInt, recordPostLayoutInformation);
                    }
                }
            }
            this.mViewInfoStore.process(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        State state = this.mState;
        state.mPreviousLayoutItemCount = state.mItemCount;
        this.mDataSetHasChangedAfterLayout = false;
        this.mState.mRunSimpleAnimations = false;
        this.mState.mRunPredictiveAnimations = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        if (this.mRecycler.mChangedScrap != null) {
            this.mRecycler.mChangedScrap.clear();
        }
        resumeRequestLayout(false);
        this.mViewInfoStore.clear();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
    }

    private boolean dispatchOnItemTouch(MotionEvent motionEvent) {
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

    private boolean dispatchOnItemTouchIntercept(MotionEvent motionEvent) {
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

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int childCount = this.mChildHelper.getChildCount();
        if (childCount == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return;
        }
        int i3 = Integer.MAX_VALUE;
        int i16 = Integer.MIN_VALUE;
        for (int i17 = 0; i17 < childCount; i17++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i17));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i3) {
                    i3 = layoutPosition;
                }
                if (layoutPosition > i16) {
                    i16 = layoutPosition;
                }
            }
        }
        iArr[0] = i3;
        iArr[1] = i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAdapterPositionFor(ViewHolder viewHolder) {
        if (!viewHolder.hasAnyOfTheFlags(524) && viewHolder.isBound()) {
            return this.mAdapterHelper.applyPendingUpdatesToPosition(viewHolder.mPosition);
        }
        return -1;
    }

    static ViewHolder getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).mViewHolder;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private float getScrollFactor() {
        if (this.mScrollFactor == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                this.mScrollFactor = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            } else {
                return 0.0f;
            }
        }
        return this.mScrollFactor;
    }

    private void handleMissingPreInfoForChangeError(long j3, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i3));
            if (childViewHolderInt != null && childViewHolderInt != viewHolder && getChangedHolderKey(childViewHolderInt) == j3) {
                Adapter adapter = this.mAdapter;
                if (adapter != null && adapter.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder);
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder);
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder);
    }

    private boolean hasUpdatedView() {
        int childCount = this.mChildHelper.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new ChildHelper.Callback() { // from class: android.support.v7.widget.RecyclerView.5
            @Override // android.support.v7.widget.ChildHelper.Callback
            public void addView(View view, int i3) {
                RecyclerView.this.addView(view, i3);
                RecyclerView.this.dispatchChildAttached(view);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public void attachViewToParent(View view, int i3, ViewGroup.LayoutParams layoutParams) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt);
                    }
                    childViewHolderInt.clearTmpDetachFlag();
                }
                RecyclerView.this.attachViewToParent(view, i3, layoutParams);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public void detachViewFromParent(int i3) {
                ViewHolder childViewHolderInt;
                View childAt = getChildAt(i3);
                if (childAt != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt)) != null) {
                    if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt);
                    }
                    childViewHolderInt.addFlags(256);
                }
                RecyclerView.this.detachViewFromParent(i3);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public View getChildAt(int i3) {
                return RecyclerView.this.getChildAt(i3);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public int getChildCount() {
                return RecyclerView.this.getChildCount();
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public ViewHolder getChildViewHolder(View view) {
                return RecyclerView.getChildViewHolderInt(view);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public int indexOfChild(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public void onEnteredHiddenState(View view) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState();
                }
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public void onLeftHiddenState(View view) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState();
                }
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public void removeAllViews() {
                int childCount = getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    RecyclerView.this.dispatchChildDetached(getChildAt(i3));
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public void removeViewAt(int i3) {
                View childAt = RecyclerView.this.getChildAt(i3);
                if (childAt != null) {
                    RecyclerView.this.dispatchChildDetached(childAt);
                }
                RecyclerView.this.removeViewAt(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToPositionForSmoothScroller(int i3) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return;
        }
        layoutManager.scrollToPosition(i3);
        awakenScrollBars();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onExitLayoutOrScroll() {
        int i3 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i3;
        if (i3 < 1) {
            this.mLayoutOrScrollCounter = 0;
            dispatchContentChangedIfNecessary();
        }
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int i3;
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mScrollPointerId) {
            if (actionIndex == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.mScrollPointerId = MotionEventCompat.getPointerId(motionEvent, i3);
            int x16 = (int) (MotionEventCompat.getX(motionEvent, i3) + 0.5f);
            this.mLastTouchX = x16;
            this.mInitialTouchX = x16;
            int y16 = (int) (MotionEventCompat.getY(motionEvent, i3) + 0.5f);
            this.mLastTouchY = y16;
            this.mInitialTouchY = y16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        if (this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations()) {
            return true;
        }
        return false;
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z16;
        boolean z17;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.reset();
            markKnownViewsInvalid();
            this.mLayout.onItemsChanged(this);
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.preProcess();
        } else {
            this.mAdapterHelper.consumeUpdatesInOnePass();
        }
        boolean z18 = false;
        if (!this.mItemsAddedOrRemoved && !this.mItemsChanged) {
            z16 = false;
        } else {
            z16 = true;
        }
        State state = this.mState;
        if (this.mFirstLayoutComplete && this.mItemAnimator != null && ((this.mDataSetHasChangedAfterLayout || z16 || this.mLayout.mRequestedSimpleAnimations) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds()))) {
            z17 = true;
        } else {
            z17 = false;
        }
        state.mRunSimpleAnimations = z17;
        State state2 = this.mState;
        if (state2.mRunSimpleAnimations && z16 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z18 = true;
        }
        state2.mRunPredictiveAnimations = z18;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x007a, code lost:
    
        if (r6.mBottomGlow.onPull(r10 / getHeight(), 1.0f - (r7 / getWidth())) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003e, code lost:
    
        if (r6.mRightGlow.onPull(r8 / getWidth(), r9 / getHeight()) != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0020, code lost:
    
        if (r6.mLeftGlow.onPull((-r8) / getWidth(), 1.0f - (r9 / getHeight())) != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0022, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x005c, code lost:
    
        if (r6.mTopGlow.onPull((-r10) / getHeight(), r7 / getWidth()) != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void pullGlows(float f16, float f17, float f18, float f19) {
        boolean z16;
        boolean z17 = true;
        if (f17 < 0.0f) {
            ensureLeftGlow();
        } else {
            if (f17 > 0.0f) {
                ensureRightGlow();
            }
            z16 = false;
        }
        if (f19 < 0.0f) {
            ensureTopGlow();
        } else {
            if (f19 > 0.0f) {
                ensureBottomGlow();
            }
            z17 = z16;
        }
        if (z17 || f17 != 0.0f || f19 != 0.0f) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordAnimationInfoIfBouncedHiddenView(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.setFlags(0, 8192);
        if (this.mState.mTrackOldChangeHolders && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            this.mViewInfoStore.addToOldChangeHolders(getChangedHolderKey(viewHolder), viewHolder);
        }
        this.mViewInfoStore.addToPreLayout(viewHolder, itemHolderInfo);
    }

    private void releaseGlows() {
        boolean z16;
        EdgeEffectCompat edgeEffectCompat = this.mLeftGlow;
        if (edgeEffectCompat != null) {
            z16 = edgeEffectCompat.onRelease();
        } else {
            z16 = false;
        }
        EdgeEffectCompat edgeEffectCompat2 = this.mTopGlow;
        if (edgeEffectCompat2 != null) {
            z16 |= edgeEffectCompat2.onRelease();
        }
        EdgeEffectCompat edgeEffectCompat3 = this.mRightGlow;
        if (edgeEffectCompat3 != null) {
            z16 |= edgeEffectCompat3.onRelease();
        }
        EdgeEffectCompat edgeEffectCompat4 = this.mBottomGlow;
        if (edgeEffectCompat4 != null) {
            z16 |= edgeEffectCompat4.onRelease();
        }
        if (z16) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeAnimatingView(View view) {
        ViewHolder childViewHolderInt;
        eatRequestLayout();
        boolean removeViewIfHidden = this.mChildHelper.removeViewIfHidden(view);
        if (removeViewIfHidden && (childViewHolderInt = getChildViewHolderInt(view)) != null) {
            this.mRecycler.unscrapView(childViewHolderInt);
            this.mRecycler.recycleViewHolderInternal(childViewHolderInt);
        }
        resumeRequestLayout(!removeViewIfHidden);
        return removeViewIfHidden;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void repositionShadowingViews() {
        ViewHolder viewHolder;
        int childCount = this.mChildHelper.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.mChildHelper.getChildAt(i3);
            ViewHolder childViewHolder = getChildViewHolder(childAt);
            if (childViewHolder != null && (viewHolder = childViewHolder.mShadowingHolder) != null) {
                View view = viewHolder.itemView;
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private void resetTouch() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll();
        releaseGlows();
    }

    private void setAdapterInternal(Adapter adapter, boolean z16, boolean z17) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z16 || z17) {
            ItemAnimator itemAnimator = this.mItemAnimator;
            if (itemAnimator != null) {
                itemAnimator.endAnimations();
            }
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                layoutManager.removeAndRecycleAllViews(this.mRecycler);
                this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            }
            this.mRecycler.clear();
        }
        this.mAdapterHelper.reset();
        Adapter adapter3 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager2 = this.mLayout;
        if (layoutManager2 != null) {
            layoutManager2.onAdapterChanged(adapter3, this.mAdapter);
        }
        this.mRecycler.onAdapterChanged(adapter3, this.mAdapter, z16);
        this.mState.mStructureChanged = true;
        markKnownViewsInvalid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataSetChangedAfterLayout() {
        if (this.mDataSetHasChangedAfterLayout) {
            return;
        }
        this.mDataSetHasChangedAfterLayout = true;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i3 = 0; i3 < unfilteredChildCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(512);
            }
        }
        this.mRecycler.setAdapterPositionsAsUnknown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i3) {
        if (i3 == this.mScrollState) {
            return;
        }
        this.mScrollState = i3;
        if (i3 != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i3);
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.stop();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.stopSmoothScroller();
        }
    }

    void absorbGlows(int i3, int i16) {
        if (i3 < 0) {
            ensureLeftGlow();
            this.mLeftGlow.onAbsorb(-i3);
        } else if (i3 > 0) {
            ensureRightGlow();
            this.mRightGlow.onAbsorb(i3);
        }
        if (i16 < 0) {
            ensureTopGlow();
            this.mTopGlow.onAbsorb(-i16);
        } else if (i16 > 0) {
            ensureBottomGlow();
            this.mBottomGlow.onAbsorb(i16);
        }
        if (i3 != 0 || i16 != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i3, int i16) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, i3, i16)) {
            super.addFocusables(arrayList, i3, i16);
        }
    }

    public void addItemDecoration(ItemDecoration itemDecoration, int i3) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
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

    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(onChildAttachStateChangeListener);
    }

    public void addOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.add(onItemTouchListener);
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(onScrollListener);
    }

    void assertInLayoutOrScroll(String str) {
        if (!isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling");
            }
            throw new IllegalStateException(str);
        }
    }

    void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
            }
            throw new IllegalStateException(str);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams)) {
            return true;
        }
        return false;
    }

    void clearOldPositions() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i3 = 0; i3 < unfilteredChildCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.clearOldPositions();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        return this.mLayout.computeHorizontalScrollExtent(this.mState);
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        return this.mLayout.computeHorizontalScrollOffset(this.mState);
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        return this.mLayout.computeHorizontalScrollRange(this.mState);
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        return this.mLayout.computeVerticalScrollExtent(this.mState);
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        return this.mLayout.computeVerticalScrollOffset(this.mState);
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        return this.mLayout.computeVerticalScrollRange(this.mState);
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout != null) {
            this.mState.mIsMeasuring = false;
            onEnterLayoutOrScroll();
            if (this.mState.mLayoutStep == 1) {
                dispatchLayoutStep1();
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            } else if (!this.mAdapterHelper.hasUpdates() && this.mLayout.getWidth() == getWidth() && this.mLayout.getHeight() == getHeight()) {
                this.mLayout.setExactMeasureSpecsFrom(this);
            } else {
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            }
            dispatchLayoutStep3();
            onExitLayoutOrScroll();
            return;
        }
        Log.e("RecyclerView", "No layout manager attached; skipping layout");
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f16, float f17, boolean z16) {
        return this.mScrollingChildHelper.dispatchNestedFling(f16, f17, z16);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f16, float f17) {
        return this.mScrollingChildHelper.dispatchNestedPreFling(f16, f17);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2) {
        return this.mScrollingChildHelper.dispatchNestedPreScroll(i3, i16, iArr, iArr2);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr) {
        return this.mScrollingChildHelper.dispatchNestedScroll(i3, i16, i17, i18, iArr);
    }

    void dispatchOnScrollStateChanged(int i3) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onScrollStateChanged(i3);
        }
        onScrollStateChanged(i3);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, i3);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i3);
            }
        }
    }

    void dispatchOnScrolled(int i3, int i16) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        onScrolled(i3, i16);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, i3, i16);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i3, i16);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z16;
        int i3;
        boolean z17;
        boolean z18;
        int i16;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z19 = false;
        for (int i17 = 0; i17 < size; i17++) {
            this.mItemDecorations.get(i17).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffectCompat edgeEffectCompat = this.mLeftGlow;
        boolean z26 = true;
        if (edgeEffectCompat != null && !edgeEffectCompat.isFinished()) {
            int save = canvas.save();
            if (this.mClipToPadding) {
                i16 = getPaddingBottom();
            } else {
                i16 = 0;
            }
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + i16, 0.0f);
            EdgeEffectCompat edgeEffectCompat2 = this.mLeftGlow;
            if (edgeEffectCompat2 != null && edgeEffectCompat2.draw(canvas)) {
                z16 = true;
            } else {
                z16 = false;
            }
            canvas.restoreToCount(save);
        } else {
            z16 = false;
        }
        EdgeEffectCompat edgeEffectCompat3 = this.mTopGlow;
        if (edgeEffectCompat3 != null && !edgeEffectCompat3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffectCompat edgeEffectCompat4 = this.mTopGlow;
            if (edgeEffectCompat4 != null && edgeEffectCompat4.draw(canvas)) {
                z18 = true;
            } else {
                z18 = false;
            }
            z16 |= z18;
            canvas.restoreToCount(save2);
        }
        EdgeEffectCompat edgeEffectCompat5 = this.mRightGlow;
        if (edgeEffectCompat5 != null && !edgeEffectCompat5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            if (this.mClipToPadding) {
                i3 = getPaddingTop();
            } else {
                i3 = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate(-i3, -width);
            EdgeEffectCompat edgeEffectCompat6 = this.mRightGlow;
            if (edgeEffectCompat6 != null && edgeEffectCompat6.draw(canvas)) {
                z17 = true;
            } else {
                z17 = false;
            }
            z16 |= z17;
            canvas.restoreToCount(save3);
        }
        EdgeEffectCompat edgeEffectCompat7 = this.mBottomGlow;
        if (edgeEffectCompat7 != null && !edgeEffectCompat7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffectCompat edgeEffectCompat8 = this.mBottomGlow;
            if (edgeEffectCompat8 != null && edgeEffectCompat8.draw(canvas)) {
                z19 = true;
            }
            z16 |= z19;
            canvas.restoreToCount(save4);
        }
        if (z16 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.isRunning()) {
            z26 = z16;
        }
        if (z26) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j3) {
        return super.drawChild(canvas, view, j3);
    }

    void eatRequestLayout() {
        int i3 = this.mEatRequestLayout + 1;
        this.mEatRequestLayout = i3;
        if (i3 == 1 && !this.mLayoutFrozen) {
            this.mLayoutRequestEaten = false;
        }
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        EdgeEffectCompat edgeEffectCompat = new EdgeEffectCompat(getContext());
        this.mBottomGlow = edgeEffectCompat;
        if (this.mClipToPadding) {
            edgeEffectCompat.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectCompat.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        EdgeEffectCompat edgeEffectCompat = new EdgeEffectCompat(getContext());
        this.mLeftGlow = edgeEffectCompat;
        if (this.mClipToPadding) {
            edgeEffectCompat.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectCompat.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        EdgeEffectCompat edgeEffectCompat = new EdgeEffectCompat(getContext());
        this.mRightGlow = edgeEffectCompat;
        if (this.mClipToPadding) {
            edgeEffectCompat.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectCompat.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        EdgeEffectCompat edgeEffectCompat = new EdgeEffectCompat(getContext());
        this.mTopGlow = edgeEffectCompat;
        if (this.mClipToPadding) {
            edgeEffectCompat.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectCompat.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public View findChildViewUnder(float f16, float f17) {
        for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mChildHelper.getChildAt(childCount);
            float translationX = ViewCompat.getTranslationX(childAt);
            float translationY = ViewCompat.getTranslationY(childAt);
            if (f16 >= childAt.getLeft() + translationX && f16 <= childAt.getRight() + translationX && f17 >= childAt.getTop() + translationY && f17 <= childAt.getBottom() + translationY) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return r3;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        return null;
    }

    @Nullable
    public ViewHolder findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    public ViewHolder findViewHolderForAdapterPosition(int i3) {
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i16 = 0; i16 < unfilteredChildCount; i16++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i16));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i3) {
                return childViewHolderInt;
            }
        }
        return null;
    }

    public ViewHolder findViewHolderForItemId(long j3) {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i3 = 0; i3 < unfilteredChildCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i3));
            if (childViewHolderInt != null && childViewHolderInt.getItemId() == j3) {
                return childViewHolderInt;
            }
        }
        return null;
    }

    public ViewHolder findViewHolderForLayoutPosition(int i3) {
        return findViewHolderForPosition(i3, false);
    }

    @Deprecated
    public ViewHolder findViewHolderForPosition(int i3) {
        return findViewHolderForPosition(i3, false);
    }

    public boolean fling(int i3, int i16) {
        boolean z16;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.mLayoutFrozen) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (!canScrollHorizontally || Math.abs(i3) < this.mMinFlingVelocity) {
            i3 = 0;
        }
        if (!canScrollVertically || Math.abs(i16) < this.mMinFlingVelocity) {
            i16 = 0;
        }
        if (i3 == 0 && i16 == 0) {
            return false;
        }
        float f16 = i3;
        float f17 = i16;
        if (!dispatchNestedPreFling(f16, f17)) {
            if (!canScrollHorizontally && !canScrollVertically) {
                z16 = false;
            } else {
                z16 = true;
            }
            dispatchNestedFling(f16, f17, z16);
            if (z16) {
                int i17 = this.mMaxFlingVelocity;
                int max = Math.max(-i17, Math.min(i3, i17));
                int i18 = this.mMaxFlingVelocity;
                this.mViewFlinger.fling(max, Math.max(-i18, Math.min(i16, i18)));
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i3) {
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i3);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i3);
        if (findNextFocus == null && this.mAdapter != null && this.mLayout != null && !isComputingLayout() && !this.mLayoutFrozen) {
            eatRequestLayout();
            findNextFocus = this.mLayout.onFocusSearchFailed(view, i3, this.mRecycler, this.mState);
            resumeRequestLayout(false);
        }
        if (findNextFocus == null) {
            return super.focusSearch(view, i3);
        }
        return findNextFocus;
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

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.getBaseline();
        }
        return super.getBaseline();
    }

    long getChangedHolderKey(ViewHolder viewHolder) {
        if (this.mAdapter.hasStableIds()) {
            return viewHolder.getItemId();
        }
        return viewHolder.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i16) {
        ChildDrawingOrderCallback childDrawingOrderCallback = this.mChildDrawingOrderCallback;
        if (childDrawingOrderCallback == null) {
            return super.getChildDrawingOrder(i3, i16);
        }
        return childDrawingOrderCallback.onGetChildDrawingOrder(i3, i16);
    }

    public long getChildItemId(View view) {
        ViewHolder childViewHolderInt;
        Adapter adapter = this.mAdapter;
        if (adapter == null || !adapter.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public ViewHolder getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return getChildViewHolderInt(view);
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.mInsetsDirty) {
            return layoutParams.mDecorInsets;
        }
        Rect rect = layoutParams.mDecorInsets;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i3).getItemOffsets(this.mTempRect, view, this, this.mState);
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

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.mScrollingChildHelper.hasNestedScrollingParent();
    }

    public boolean hasPendingAdapterUpdates() {
        if (this.mFirstLayoutComplete && !this.mDataSetHasChangedAfterLayout && !this.mAdapterHelper.hasPendingUpdates()) {
            return false;
        }
        return true;
    }

    void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback() { // from class: android.support.v7.widget.RecyclerView.6
            void dispatchUpdate(AdapterHelper.UpdateOp updateOp) {
                int i3 = updateOp.cmd;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 4) {
                            if (i3 == 8) {
                                RecyclerView recyclerView = RecyclerView.this;
                                recyclerView.mLayout.onItemsMoved(recyclerView, updateOp.positionStart, updateOp.itemCount, 1);
                                return;
                            }
                            return;
                        }
                        RecyclerView recyclerView2 = RecyclerView.this;
                        recyclerView2.mLayout.onItemsUpdated(recyclerView2, updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                        return;
                    }
                    RecyclerView recyclerView3 = RecyclerView.this;
                    recyclerView3.mLayout.onItemsRemoved(recyclerView3, updateOp.positionStart, updateOp.itemCount);
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.mLayout.onItemsAdded(recyclerView4, updateOp.positionStart, updateOp.itemCount);
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            public ViewHolder findViewHolder(int i3) {
                ViewHolder findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i3, true);
                if (findViewHolderForPosition == null || RecyclerView.this.mChildHelper.isHidden(findViewHolderForPosition.itemView)) {
                    return null;
                }
                return findViewHolderForPosition;
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            public void markViewHoldersUpdated(int i3, int i16, Object obj) {
                RecyclerView.this.viewRangeUpdate(i3, i16, obj);
                RecyclerView.this.mItemsChanged = true;
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            public void offsetPositionsForAdd(int i3, int i16) {
                RecyclerView.this.offsetPositionRecordsForInsert(i3, i16);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            public void offsetPositionsForMove(int i3, int i16) {
                RecyclerView.this.offsetPositionRecordsForMove(i3, i16);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            public void offsetPositionsForRemovingInvisible(int i3, int i16) {
                RecyclerView.this.offsetPositionRecordsForRemove(i3, i16, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mItemsAddedOrRemoved = true;
                State.access$1712(recyclerView.mState, i16);
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            public void offsetPositionsForRemovingLaidOutOrNewView(int i3, int i16) {
                RecyclerView.this.offsetPositionRecordsForRemove(i3, i16, false);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            public void onDispatchFirstPass(AdapterHelper.UpdateOp updateOp) {
                dispatchUpdate(updateOp);
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            public void onDispatchSecondPass(AdapterHelper.UpdateOp updateOp) {
                dispatchUpdate(updateOp);
            }
        });
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            return true;
        }
        return false;
    }

    public boolean isAnimating() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null && itemAnimator.isRunning()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        if (this.mLayoutOrScrollCounter > 0) {
            return true;
        }
        return false;
    }

    public boolean isLayoutFrozen() {
        return this.mLayoutFrozen;
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mScrollingChildHelper.isNestedScrollingEnabled();
    }

    void markItemDecorInsetsDirty() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i3 = 0; i3 < unfilteredChildCount; i3++) {
            ((LayoutParams) this.mChildHelper.getUnfilteredChildAt(i3).getLayoutParams()).mInsetsDirty = true;
        }
        this.mRecycler.markItemDecorInsetsDirty();
    }

    void markKnownViewsInvalid() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i3 = 0; i3 < unfilteredChildCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.markKnownViewsInvalid();
    }

    public void offsetChildrenHorizontal(int i3) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            this.mChildHelper.getChildAt(i16).offsetLeftAndRight(i3);
        }
    }

    public void offsetChildrenVertical(int i3) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            this.mChildHelper.getChildAt(i16).offsetTopAndBottom(i3);
        }
    }

    void offsetPositionRecordsForInsert(int i3, int i16) {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i17 = 0; i17 < unfilteredChildCount; i17++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i17));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i3) {
                childViewHolderInt.offsetPosition(i16, false);
                this.mState.mStructureChanged = true;
            }
        }
        this.mRecycler.offsetPositionRecordsForInsert(i3, i16);
        requestLayout();
    }

    void offsetPositionRecordsForMove(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        if (i3 < i16) {
            i19 = -1;
            i18 = i3;
            i17 = i16;
        } else {
            i17 = i3;
            i18 = i16;
            i19 = 1;
        }
        for (int i27 = 0; i27 < unfilteredChildCount; i27++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i27));
            if (childViewHolderInt != null && (i26 = childViewHolderInt.mPosition) >= i18 && i26 <= i17) {
                if (i26 == i3) {
                    childViewHolderInt.offsetPosition(i16 - i3, false);
                } else {
                    childViewHolderInt.offsetPosition(i19, false);
                }
                this.mState.mStructureChanged = true;
            }
        }
        this.mRecycler.offsetPositionRecordsForMove(i3, i16);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i3, int i16, boolean z16) {
        int i17 = i3 + i16;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i18 = 0; i18 < unfilteredChildCount; i18++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i18));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i19 = childViewHolderInt.mPosition;
                if (i19 >= i17) {
                    childViewHolderInt.offsetPosition(-i16, z16);
                    this.mState.mStructureChanged = true;
                } else if (i19 >= i3) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i3 - 1, -i16, z16);
                    this.mState.mStructureChanged = true;
                }
            }
        }
        this.mRecycler.offsetPositionRecordsForRemove(i3, i16, z16);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        this.mIsAttached = true;
        this.mFirstLayoutComplete = false;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        this.mFirstLayoutComplete = false;
        stopScroll();
        this.mIsAttached = false;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.onDetach();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mItemDecorations.get(i3).onDraw(canvas, this, this.mState);
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f16;
        float f17;
        if (this.mLayout != null && !this.mLayoutFrozen && (MotionEventCompat.getSource(motionEvent) & 2) != 0 && motionEvent.getAction() == 8) {
            if (this.mLayout.canScrollVertically()) {
                f16 = -MotionEventCompat.getAxisValue(motionEvent, 9);
            } else {
                f16 = 0.0f;
            }
            if (this.mLayout.canScrollHorizontally()) {
                f17 = MotionEventCompat.getAxisValue(motionEvent, 10);
            } else {
                f17 = 0.0f;
            }
            if (f16 != 0.0f || f17 != 0.0f) {
                float scrollFactor = getScrollFactor();
                scrollByInternal((int) (f17 * scrollFactor), (int) (f16 * scrollFactor), motionEvent);
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e0  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        int i3;
        if (this.mLayoutFrozen) {
            return false;
        }
        if (dispatchOnItemTouchIntercept(motionEvent)) {
            cancelTouch();
            return true;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                onPointerUp(motionEvent);
                            }
                        } else {
                            this.mScrollPointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                            int x16 = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
                            this.mLastTouchX = x16;
                            this.mInitialTouchX = x16;
                            int y16 = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
                            this.mLastTouchY = y16;
                            this.mInitialTouchY = y16;
                        }
                    } else {
                        cancelTouch();
                    }
                } else {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mScrollPointerId);
                    if (findPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x17 = (int) (MotionEventCompat.getX(motionEvent, findPointerIndex) + 0.5f);
                    int y17 = (int) (MotionEventCompat.getY(motionEvent, findPointerIndex) + 0.5f);
                    if (this.mScrollState != 1) {
                        int i16 = x17 - this.mInitialTouchX;
                        int i17 = y17 - this.mInitialTouchY;
                        int i18 = -1;
                        if (canScrollHorizontally != 0) {
                            int abs = Math.abs(i16);
                            int i19 = this.mTouchSlop;
                            if (abs > i19) {
                                int i26 = this.mInitialTouchX;
                                if (i16 < 0) {
                                    i3 = -1;
                                } else {
                                    i3 = 1;
                                }
                                this.mLastTouchX = i26 + (i19 * i3);
                                z16 = true;
                                if (canScrollVertically) {
                                    int abs2 = Math.abs(i17);
                                    int i27 = this.mTouchSlop;
                                    if (abs2 > i27) {
                                        int i28 = this.mInitialTouchY;
                                        if (i17 >= 0) {
                                            i18 = 1;
                                        }
                                        this.mLastTouchY = i28 + (i27 * i18);
                                        z16 = true;
                                    }
                                }
                                if (z16) {
                                    setScrollState(1);
                                }
                            }
                        }
                        z16 = false;
                        if (canScrollVertically) {
                        }
                        if (z16) {
                        }
                    }
                }
            } else {
                this.mVelocityTracker.clear();
                stopNestedScroll();
            }
        } else {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            int x18 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x18;
            this.mInitialTouchX = x18;
            int y18 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y18;
            this.mInitialTouchY = y18;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i29 = canScrollHorizontally;
            if (canScrollVertically) {
                i29 = (canScrollHorizontally ? 1 : 0) | 2;
            }
            startNestedScroll(i29);
        }
        if (this.mScrollState != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        TraceCompat.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
        this.mFirstLayoutComplete = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            defaultOnMeasure(i3, i16);
            return;
        }
        boolean z16 = false;
        if (layoutManager.mAutoMeasure) {
            int mode = View.MeasureSpec.getMode(i3);
            int mode2 = View.MeasureSpec.getMode(i16);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z16 = true;
            }
            this.mLayout.onMeasure(this.mRecycler, this.mState, i3, i16);
            if (!z16 && this.mAdapter != null) {
                if (this.mState.mLayoutStep == 1) {
                    dispatchLayoutStep1();
                }
                this.mLayout.setMeasureSpecs(i3, i16);
                this.mState.mIsMeasuring = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i3, i16);
                if (this.mLayout.shouldMeasureTwice()) {
                    this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.mIsMeasuring = true;
                    dispatchLayoutStep2();
                    this.mLayout.setMeasuredDimensionFromChildren(i3, i16);
                    return;
                }
                return;
            }
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i3, i16);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            eatRequestLayout();
            processAdapterUpdatesAndSetAnimationFlags();
            if (this.mState.mRunPredictiveAnimations) {
                this.mState.mInPreLayout = true;
            } else {
                this.mAdapterHelper.consumeUpdatesInOnePass();
                this.mState.mInPreLayout = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            resumeRequestLayout(false);
        }
        Adapter adapter = this.mAdapter;
        if (adapter != null) {
            this.mState.mItemCount = adapter.getItemCount();
        } else {
            this.mState.mItemCount = 0;
        }
        eatRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, i3, i16);
        resumeRequestLayout(false);
        this.mState.mInPreLayout = false;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.getSuperState());
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && (parcelable2 = this.mPendingSavedState.mLayoutState) != null) {
            layoutManager.onRestoreInstanceState(parcelable2);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.copyFrom(savedState2);
        } else {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                savedState.mLayoutState = layoutManager.onSaveInstanceState();
            } else {
                savedState.mLayoutState = null;
            }
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (i3 != i17 || i16 != i18) {
            invalidateGlows();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f16;
        float f17;
        boolean z16;
        boolean z17 = false;
        if (this.mLayoutFrozen || this.mIgnoreMotionEventTillDown) {
            return false;
        }
        if (dispatchOnItemTouch(motionEvent)) {
            cancelTouch();
            return true;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        int[] iArr2 = this.mNestedOffsets;
        obtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                onPointerUp(motionEvent);
                            }
                        } else {
                            this.mScrollPointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                            int x16 = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
                            this.mLastTouchX = x16;
                            this.mInitialTouchX = x16;
                            int y16 = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
                            this.mLastTouchY = y16;
                            this.mInitialTouchY = y16;
                        }
                    } else {
                        cancelTouch();
                    }
                } else {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mScrollPointerId);
                    if (findPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x17 = (int) (MotionEventCompat.getX(motionEvent, findPointerIndex) + 0.5f);
                    int y17 = (int) (MotionEventCompat.getY(motionEvent, findPointerIndex) + 0.5f);
                    int i3 = this.mLastTouchX - x17;
                    int i16 = this.mLastTouchY - y17;
                    if (dispatchNestedPreScroll(i3, i16, this.mScrollConsumed, this.mScrollOffset)) {
                        int[] iArr3 = this.mScrollConsumed;
                        i3 -= iArr3[0];
                        i16 -= iArr3[1];
                        int[] iArr4 = this.mScrollOffset;
                        obtain.offsetLocation(iArr4[0], iArr4[1]);
                        int[] iArr5 = this.mNestedOffsets;
                        int i17 = iArr5[0];
                        int[] iArr6 = this.mScrollOffset;
                        iArr5[0] = i17 + iArr6[0];
                        iArr5[1] = iArr5[1] + iArr6[1];
                    }
                    if (this.mScrollState != 1) {
                        if (canScrollHorizontally != 0) {
                            int abs = Math.abs(i3);
                            int i18 = this.mTouchSlop;
                            if (abs > i18) {
                                if (i3 > 0) {
                                    i3 -= i18;
                                } else {
                                    i3 += i18;
                                }
                                z16 = true;
                                if (canScrollVertically) {
                                    int abs2 = Math.abs(i16);
                                    int i19 = this.mTouchSlop;
                                    if (abs2 > i19) {
                                        if (i16 > 0) {
                                            i16 -= i19;
                                        } else {
                                            i16 += i19;
                                        }
                                        z16 = true;
                                    }
                                }
                                if (z16) {
                                    setScrollState(1);
                                }
                            }
                        }
                        z16 = false;
                        if (canScrollVertically) {
                        }
                        if (z16) {
                        }
                    }
                    if (this.mScrollState == 1) {
                        int[] iArr7 = this.mScrollOffset;
                        this.mLastTouchX = x17 - iArr7[0];
                        this.mLastTouchY = y17 - iArr7[1];
                        if (canScrollHorizontally == 0) {
                            i3 = 0;
                        }
                        if (!canScrollVertically) {
                            i16 = 0;
                        }
                        if (scrollByInternal(i3, i16, obtain)) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            } else {
                this.mVelocityTracker.addMovement(obtain);
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
                if (canScrollHorizontally != 0) {
                    f16 = -VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mScrollPointerId);
                } else {
                    f16 = 0.0f;
                }
                if (canScrollVertically) {
                    f17 = -VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mScrollPointerId);
                } else {
                    f17 = 0.0f;
                }
                if ((f16 == 0.0f && f17 == 0.0f) || !fling((int) f16, (int) f17)) {
                    setScrollState(0);
                }
                resetTouch();
                z17 = true;
            }
        } else {
            this.mScrollPointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            int x18 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x18;
            this.mInitialTouchX = x18;
            int y18 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y18;
            this.mInitialTouchY = y18;
            int i26 = canScrollHorizontally;
            if (canScrollVertically) {
                i26 = (canScrollHorizontally ? 1 : 0) | 2;
            }
            startNestedScroll(i26);
        }
        if (!z17) {
            this.mVelocityTracker.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z16) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt);
            }
        }
        dispatchChildDetached(view);
        super.removeDetachedView(view, z16);
    }

    public void removeItemDecoration(ItemDecoration itemDecoration) {
        boolean z16;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(itemDecoration);
        if (this.mItemDecorations.isEmpty()) {
            if (ViewCompat.getOverScrollMode(this) == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            setWillNotDraw(z16);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(onChildAttachStateChangeListener);
    }

    public void removeOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.remove(onItemTouchListener);
        if (this.mActiveOnItemTouchListener == onItemTouchListener) {
            this.mActiveOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            this.mTempRect.set(0, 0, view2.getWidth(), view2.getHeight());
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                if (!layoutParams2.mInsetsDirty) {
                    Rect rect = layoutParams2.mDecorInsets;
                    Rect rect2 = this.mTempRect;
                    rect2.left -= rect.left;
                    rect2.right += rect.right;
                    rect2.top -= rect.top;
                    rect2.bottom += rect.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
            requestChildRectangleOnScreen(view, this.mTempRect, !this.mFirstLayoutComplete);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z16) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z16);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z16) {
        int size = this.mOnItemTouchListeners.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mOnItemTouchListeners.get(i3).onRequestDisallowInterceptTouchEvent(z16);
        }
        super.requestDisallowInterceptTouchEvent(z16);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mEatRequestLayout == 0 && !this.mLayoutFrozen) {
            super.requestLayout();
        } else {
            this.mLayoutRequestEaten = true;
        }
    }

    void resumeRequestLayout(boolean z16) {
        if (this.mEatRequestLayout < 1) {
            this.mEatRequestLayout = 1;
        }
        if (!z16) {
            this.mLayoutRequestEaten = false;
        }
        if (this.mEatRequestLayout == 1) {
            if (z16 && this.mLayoutRequestEaten && !this.mLayoutFrozen && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutFrozen) {
                this.mLayoutRequestEaten = false;
            }
        }
        this.mEatRequestLayout--;
    }

    void saveOldPositions() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i3 = 0; i3 < unfilteredChildCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i3, int i16) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutFrozen) {
            return;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (canScrollHorizontally || canScrollVertically) {
            if (!canScrollHorizontally) {
                i3 = 0;
            }
            if (!canScrollVertically) {
                i16 = 0;
            }
            scrollByInternal(i3, i16, null);
        }
    }

    boolean scrollByInternal(int i3, int i16, MotionEvent motionEvent) {
        int i17;
        int i18;
        int i19;
        int i26;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            eatRequestLayout();
            onEnterLayoutOrScroll();
            TraceCompat.beginSection(TRACE_SCROLL_TAG);
            if (i3 != 0) {
                i17 = this.mLayout.scrollHorizontallyBy(i3, this.mRecycler, this.mState);
                i18 = i3 - i17;
            } else {
                i17 = 0;
                i18 = 0;
            }
            if (i16 != 0) {
                i19 = this.mLayout.scrollVerticallyBy(i16, this.mRecycler, this.mState);
                i26 = i16 - i19;
            } else {
                i19 = 0;
                i26 = 0;
            }
            TraceCompat.endSection();
            repositionShadowingViews();
            onExitLayoutOrScroll();
            resumeRequestLayout(false);
        } else {
            i17 = 0;
            i18 = 0;
            i19 = 0;
            i26 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i17, i19, i18, i26, this.mScrollOffset)) {
            int i27 = this.mLastTouchX;
            int[] iArr = this.mScrollOffset;
            int i28 = iArr[0];
            this.mLastTouchX = i27 - i28;
            int i29 = this.mLastTouchY;
            int i36 = iArr[1];
            this.mLastTouchY = i29 - i36;
            if (motionEvent != null) {
                motionEvent.offsetLocation(i28, i36);
            }
            int[] iArr2 = this.mNestedOffsets;
            int i37 = iArr2[0];
            int[] iArr3 = this.mScrollOffset;
            iArr2[0] = i37 + iArr3[0];
            iArr2[1] = iArr2[1] + iArr3[1];
        } else if (ViewCompat.getOverScrollMode(this) != 2) {
            if (motionEvent != null) {
                pullGlows(motionEvent.getX(), i18, motionEvent.getY(), i26);
            }
            considerReleasingGlowsOnScroll(i3, i16);
        }
        if (i17 != 0 || i19 != 0) {
            dispatchOnScrolled(i17, i19);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i17 == 0 && i19 == 0) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i16) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i3) {
        if (this.mLayoutFrozen) {
            return;
        }
        stopScroll();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager.scrollToPosition(i3);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.mAccessibilityDelegate = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(Adapter adapter) {
        EventCollector.getInstance().onSetRecyclerViewAdapter(this);
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        boolean z16;
        if (childDrawingOrderCallback == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = childDrawingOrderCallback;
        if (childDrawingOrderCallback != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        setChildrenDrawingOrderEnabled(z16);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z16) {
        if (z16 != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z16;
        super.setClipToPadding(z16);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean z16) {
        this.mHasFixedSize = z16;
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.mItemAnimator;
        if (itemAnimator2 != null) {
            itemAnimator2.endAnimations();
            this.mItemAnimator.setListener(null);
        }
        this.mItemAnimator = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.setListener(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i3) {
        this.mRecycler.setViewCacheSize(i3);
    }

    public void setLayoutFrozen(boolean z16) {
        if (z16 != this.mLayoutFrozen) {
            assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
            if (!z16) {
                this.mLayoutFrozen = false;
                if (this.mLayoutRequestEaten && this.mLayout != null && this.mAdapter != null) {
                    requestLayout();
                }
                this.mLayoutRequestEaten = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutFrozen = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager == this.mLayout) {
            return;
        }
        stopScroll();
        LayoutManager layoutManager2 = this.mLayout;
        if (layoutManager2 != null) {
            if (this.mIsAttached) {
                layoutManager2.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
        }
        this.mRecycler.clear();
        this.mChildHelper.removeAllViewsUnfiltered();
        this.mLayout = layoutManager;
        if (layoutManager != null) {
            if (layoutManager.mRecyclerView == null) {
                layoutManager.setRecyclerView(this);
                if (this.mIsAttached) {
                    this.mLayout.dispatchAttachedToWindow(this);
                }
            } else {
                throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView: " + layoutManager.mRecyclerView);
            }
        }
        requestLayout();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z16) {
        this.mScrollingChildHelper.setNestedScrollingEnabled(z16);
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        this.mRecycler.setRecycledViewPool(recycledViewPool);
    }

    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.mRecyclerListener = recyclerListener;
    }

    public void setScrollingTouchSlop(int i3) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i3 != 0) {
            if (i3 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i3 + "; using default value");
            } else {
                this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
        this.mRecycler.setViewCacheExtension(viewCacheExtension);
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i3;
        int i16 = 0;
        if (!isComputingLayout()) {
            return false;
        }
        if (accessibilityEvent != null) {
            i3 = AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent);
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            i16 = i3;
        }
        this.mEatenAccessibilityChangeFlags |= i16;
        return true;
    }

    public void smoothScrollBy(int i3, int i16) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutFrozen) {
            return;
        }
        if (!layoutManager.canScrollHorizontally()) {
            i3 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i16 = 0;
        }
        if (i3 != 0 || i16 != 0) {
            this.mViewFlinger.smoothScrollBy(i3, i16);
        }
    }

    public void smoothScrollToPosition(int i3) {
        if (this.mLayoutFrozen) {
            return;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager.smoothScrollToPosition(this, this.mState, i3);
        }
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean startNestedScroll(int i3) {
        return this.mScrollingChildHelper.startNestedScroll(i3);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.mScrollingChildHelper.stopNestedScroll();
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    public void swapAdapter(Adapter adapter, boolean z16) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, true, z16);
        setDataSetChangedAfterLayout();
        requestLayout();
    }

    void viewRangeUpdate(int i3, int i16, Object obj) {
        int i17;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        int i18 = i3 + i16;
        for (int i19 = 0; i19 < unfilteredChildCount; i19++) {
            View unfilteredChildAt = this.mChildHelper.getUnfilteredChildAt(i19);
            ViewHolder childViewHolderInt = getChildViewHolderInt(unfilteredChildAt);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i17 = childViewHolderInt.mPosition) >= i3 && i17 < i18) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((LayoutParams) unfilteredChildAt.getLayoutParams()).mInsetsDirty = true;
            }
        }
        this.mRecycler.viewRangeUpdate(i3, i16);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.RecyclerView.SavedState.1
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

        /* JADX INFO: Access modifiers changed from: private */
        public void copyFrom(SavedState savedState) {
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

    public RecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    ViewHolder findViewHolderForPosition(int i3, boolean z16) {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i16 = 0; i16 < unfilteredChildCount; i16++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i16));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z16) {
                    if (childViewHolderInt.mPosition == i3) {
                        return childViewHolderInt;
                    }
                } else if (childViewHolderInt.getLayoutPosition() == i3) {
                    return childViewHolderInt;
                }
            }
        }
        return null;
    }

    public RecyclerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mObserver = new RecyclerViewDataObserver();
        this.mRecycler = new Recycler();
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new Runnable() { // from class: android.support.v7.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.mFirstLayoutComplete && !RecyclerView.this.isLayoutRequested()) {
                    if (RecyclerView.this.mLayoutFrozen) {
                        RecyclerView.this.mLayoutRequestEaten = true;
                    } else {
                        RecyclerView.this.consumePendingUpdateOperations();
                    }
                }
            }
        };
        this.mTempRect = new Rect();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mEatRequestLayout = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mLayoutOrScrollCounter = 0;
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScrollFactor = Float.MIN_VALUE;
        this.mViewFlinger = new ViewFlinger();
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mNestedOffsets = new int[2];
        this.mItemAnimatorRunner = new Runnable() { // from class: android.support.v7.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                ItemAnimator itemAnimator = RecyclerView.this.mItemAnimator;
                if (itemAnimator != null) {
                    itemAnimator.runPendingAnimations();
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback() { // from class: android.support.v7.widget.RecyclerView.4
            @Override // android.support.v7.widget.ViewInfoStore.ProcessCallback
            public void processAppeared(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // android.support.v7.widget.ViewInfoStore.ProcessCallback
            public void processDisappeared(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.mRecycler.unscrapView(viewHolder);
                RecyclerView.this.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // android.support.v7.widget.ViewInfoStore.ProcessCallback
            public void processPersistent(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                viewHolder.setIsRecyclable(false);
                if (RecyclerView.this.mDataSetHasChangedAfterLayout) {
                    if (RecyclerView.this.mItemAnimator.animateChange(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                        RecyclerView.this.postAnimationRunner();
                    }
                } else if (RecyclerView.this.mItemAnimator.animatePersistence(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            }

            @Override // android.support.v7.widget.ViewInfoStore.ProcessCallback
            public void unused(ViewHolder viewHolder) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mLayout.removeAndRecycleView(viewHolder.itemView, recyclerView.mRecycler);
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.mPostUpdatesOnAnimation = true;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(ViewCompat.getOverScrollMode(this) == 2);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        final Rect mDecorInsets;
        boolean mInsetsDirty;
        boolean mPendingInvalidate;
        ViewHolder mViewHolder;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public int getViewAdapterPosition() {
            return this.mViewHolder.getAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.getLayoutPosition();
        }

        public int getViewPosition() {
            return this.mViewHolder.getPosition();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.isUpdated();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.isRemoved();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.isInvalid();
        }

        public boolean viewNeedsUpdate() {
            return this.mViewHolder.needsUpdate();
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public void addItemDecoration(ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return false;
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z16) {
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onScrollStateChanged(int i3) {
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class OnScrollListener {
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
        }

        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
        }
    }

    public void onScrolled(int i3, int i16) {
    }
}
