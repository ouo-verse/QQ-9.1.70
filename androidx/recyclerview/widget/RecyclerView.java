package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
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
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.TraceCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.ViewBoundsCheck;
import androidx.recyclerview.widget.ViewInfoStore;
import com.gcloudsdk.gcloud.voice.GCloudVoiceErrorCode;
import com.tencent.component.media.MtpConstants;
import cooperation.qzone.util.WnsNetworkConst;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator;
    RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;

    @NonNull
    private EdgeEffectFactory mEdgeEffectFactory;
    boolean mEnableFastScroller;

    @VisibleForTesting
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private OnItemTouchListener mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<ItemDecoration> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;

    @VisibleForTesting
    LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;

    @VisibleForTesting
    final List<ViewHolder> mPendingAccessibilityImportanceChange;
    private SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final Recycler mRecycler;
    RecyclerListener mRecyclerListener;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private OnScrollListener mScrollListener;
    private List<OnScrollListener> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final State mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final ViewFlinger mViewFlinger;
    private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;
    private static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = true;
    static final boolean POST_UPDATES_ON_ANIMATION = true;
    static final boolean ALLOW_THREAD_GAP_WORK = true;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class Adapter<VH extends ViewHolder> {
        private final AdapterDataObservable mObservable = new AdapterDataObservable();
        private boolean mHasStableIds = false;

        public final void bindViewHolder(@NonNull VH vh5, int i3) {
            vh5.mPosition = i3;
            if (hasStableIds()) {
                vh5.mItemId = getItemId(i3);
            }
            vh5.setFlags(1, WnsNetworkConst.NETWORK_DISABLE);
            TraceCompat.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh5, i3, vh5.getUnmodifiedPayloads());
            vh5.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh5.itemView.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).mInsetsDirty = true;
            }
            TraceCompat.endSection();
        }

        @NonNull
        public final VH createViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            try {
                TraceCompat.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i3);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i3;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                TraceCompat.endSection();
            }
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

        public abstract void onBindViewHolder(@NonNull VH vh5, int i3);

        public void onBindViewHolder(@NonNull VH vh5, int i3, @NonNull List<Object> list) {
            onBindViewHolder(vh5, i3);
        }

        @NonNull
        public abstract VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3);

        public boolean onFailedToRecycleView(@NonNull VH vh5) {
            return false;
        }

        public void registerAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            this.mObservable.registerObserver(adapterDataObserver);
        }

        public void setHasStableIds(boolean z16) {
            if (!hasObservers()) {
                this.mHasStableIds = z16;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void unregisterAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            this.mObservable.unregisterObserver(adapterDataObserver);
        }

        public final void notifyItemChanged(int i3, @Nullable Object obj) {
            this.mObservable.notifyItemRangeChanged(i3, 1, obj);
        }

        public final void notifyItemRangeChanged(int i3, int i16, @Nullable Object obj) {
            this.mObservable.notifyItemRangeChanged(i3, i16, obj);
        }

        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public void onViewAttachedToWindow(@NonNull VH vh5) {
        }

        public void onViewDetachedFromWindow(@NonNull VH vh5) {
        }

        public void onViewRecycled(@NonNull VH vh5) {
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

        public void notifyItemRangeChanged(int i3, int i16, @Nullable Object obj) {
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

        public void onItemRangeChanged(int i3, int i16, @Nullable Object obj) {
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
    public static class EdgeEffectFactory {
        public static final int DIRECTION_BOTTOM = 3;
        public static final int DIRECTION_LEFT = 0;
        public static final int DIRECTION_RIGHT = 2;
        public static final int DIRECTION_TOP = 1;

        /* compiled from: P */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface EdgeDirection {
        }

        @NonNull
        protected EdgeEffect createEdgeEffect(@NonNull RecyclerView recyclerView, int i3) {
            return new EdgeEffect(recyclerView.getContext());
        }
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
            void onAnimationFinished(@NonNull ViewHolder viewHolder);
        }

        /* compiled from: P */
        /* loaded from: classes.dex */
        public static class ItemHolderInfo {
            public int bottom;
            public int changeFlags;
            public int left;
            public int right;
            public int top;

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder viewHolder) {
                return setFrom(viewHolder, 0);
            }

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder viewHolder, int i3) {
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

        public final void dispatchAnimationFinished(@NonNull ViewHolder viewHolder) {
            onAnimationFinished(viewHolder);
            ItemAnimatorListener itemAnimatorListener = this.mListener;
            if (itemAnimatorListener != null) {
                itemAnimatorListener.onAnimationFinished(viewHolder);
            }
        }

        public final void dispatchAnimationStarted(@NonNull ViewHolder viewHolder) {
            onAnimationStarted(viewHolder);
        }

        public final void dispatchAnimationsFinished() {
            int size = this.mFinishedListeners.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.mFinishedListeners.get(i3).onAnimationsFinished();
            }
            this.mFinishedListeners.clear();
        }

        public abstract void endAnimation(@NonNull ViewHolder viewHolder);

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

        public final boolean isRunning(@Nullable ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
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

        @NonNull
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

        public void onAnimationFinished(@NonNull ViewHolder viewHolder) {
        }

        public void onAnimationStarted(@NonNull ViewHolder viewHolder) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        ItemAnimatorRestoreListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorListener
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
        public void getItemOffsets(@NonNull Rect rect, int i3, @NonNull RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull State state) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }

        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            onDraw(canvas, recyclerView);
        }

        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            onDrawOver(canvas, recyclerView);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class LayoutManager {
        boolean mAutoMeasure;
        ChildHelper mChildHelper;
        private int mHeight;
        private int mHeightMode;
        ViewBoundsCheck mHorizontalBoundCheck;
        private final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback;
        boolean mIsAttachedToWindow;
        private boolean mItemPrefetchEnabled;
        private boolean mMeasurementCacheEnabled;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations;

        @Nullable
        SmoothScroller mSmoothScroller;
        ViewBoundsCheck mVerticalBoundCheck;
        private final ViewBoundsCheck.Callback mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;

        /* compiled from: P */
        /* loaded from: classes.dex */
        public interface LayoutPrefetchRegistry {
            void addPosition(int i3, int i16);
        }

        /* compiled from: P */
        /* loaded from: classes.dex */
        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        public LayoutManager() {
            ViewBoundsCheck.Callback callback = new ViewBoundsCheck.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.1
                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public View getChildAt(int i3) {
                    return LayoutManager.this.getChildAt(i3);
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getChildEnd(View view) {
                    return LayoutManager.this.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).rightMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getChildStart(View view) {
                    return LayoutManager.this.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getParentEnd() {
                    return LayoutManager.this.getWidth() - LayoutManager.this.getPaddingRight();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getParentStart() {
                    return LayoutManager.this.getPaddingLeft();
                }
            };
            this.mHorizontalBoundCheckCallback = callback;
            ViewBoundsCheck.Callback callback2 = new ViewBoundsCheck.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.2
                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public View getChildAt(int i3) {
                    return LayoutManager.this.getChildAt(i3);
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getChildEnd(View view) {
                    return LayoutManager.this.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getChildStart(View view) {
                    return LayoutManager.this.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).topMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getParentEnd() {
                    return LayoutManager.this.getHeight() - LayoutManager.this.getPaddingBottom();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getParentStart() {
                    return LayoutManager.this.getPaddingTop();
                }
            };
            this.mVerticalBoundCheckCallback = callback2;
            this.mHorizontalBoundCheck = new ViewBoundsCheck(callback);
            this.mVerticalBoundCheck = new ViewBoundsCheck(callback2);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        private void addViewInt(View view, int i3, boolean z16) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
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
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
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
                if (mode != 1073741824) {
                    return Math.max(i16, i17);
                }
                return size;
            }
            return Math.min(size, Math.max(i16, i17));
        }

        private void detachViewInternal(int i3, @NonNull View view) {
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

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] iArr = new int[2];
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
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public static Properties getProperties(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.RecyclerView, i3, i16);
            properties.orientation = obtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_orientation, 1);
            properties.spanCount = obtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_spanCount, 1);
            properties.reverseLayout = obtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_reverseLayout, false);
            properties.stackFromEnd = obtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i3, int i16) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            if (rect.left - i3 >= width || rect.right - i3 <= paddingLeft || rect.top - i16 >= height || rect.bottom - i16 <= paddingTop) {
                return false;
            }
            return true;
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

        private void scrapOrRecycleView(Recycler recycler, int i3, View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                removeViewAt(i3);
                recycler.recycleViewHolderInternal(childViewHolderInt);
            } else {
                detachViewAt(i3);
                recycler.scrapView(view);
                this.mRecyclerView.mViewInfoStore.onViewDetached(childViewHolderInt);
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

        public void attachView(@NonNull View view, int i3, LayoutParams layoutParams) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            }
            this.mChildHelper.attachViewToParent(view, i3, layoutParams, childViewHolderInt.isRemoved());
        }

        public void calculateItemDecorationsForChild(@NonNull View view, @NonNull Rect rect) {
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

        public int computeHorizontalScrollExtent(@NonNull State state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(@NonNull State state) {
            return 0;
        }

        public int computeHorizontalScrollRange(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollExtent(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollOffset(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollRange(@NonNull State state) {
            return 0;
        }

        public void detachAndScrapAttachedViews(@NonNull Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(recycler, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(@NonNull View view, @NonNull Recycler recycler) {
            scrapOrRecycleView(recycler, this.mChildHelper.indexOfChild(view), view);
        }

        public void detachAndScrapViewAt(int i3, @NonNull Recycler recycler) {
            scrapOrRecycleView(recycler, i3, getChildAt(i3));
        }

        public void detachView(@NonNull View view) {
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
            ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
            if (itemAnimator != null) {
                itemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(view));
            }
        }

        @Nullable
        public View findContainingItemView(@NonNull View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.isHidden(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        @Nullable
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

        public int getBottomDecorationHeight(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.bottom;
        }

        @Nullable
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

        public int getColumnCountForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getDecoratedBottom(@NonNull View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(@NonNull View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(@NonNull View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(@NonNull View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(@NonNull View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(@NonNull View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        @Nullable
        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.isHidden(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        @Px
        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
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

        public int getItemViewType(@NonNull View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.mRecyclerView);
        }

        public int getLeftDecorationWidth(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.left;
        }

        @Px
        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.mRecyclerView);
        }

        @Px
        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.mRecyclerView);
        }

        @Px
        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        @Px
        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getPaddingEnd(recyclerView);
            }
            return 0;
        }

        @Px
        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        @Px
        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        @Px
        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getPaddingStart(recyclerView);
            }
            return 0;
        }

        @Px
        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.right;
        }

        public int getRowCountForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollVertically()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getSelectionModeForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            return 0;
        }

        public int getTopDecorationHeight(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.top;
        }

        public void getTransformedBoundingBox(@NonNull View view, boolean z16, @NonNull Rect rect) {
            Matrix matrix;
            if (z16) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        @Px
        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
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

        public void ignoreView(@NonNull View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent == recyclerView && recyclerView.indexOfChild(view) != -1) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                childViewHolderInt.addFlags(128);
                this.mRecyclerView.mViewInfoStore.removeViewHolder(childViewHolderInt);
            } else {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
            }
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

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(@NonNull Recycler recycler, @NonNull State state) {
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

        public boolean isViewPartiallyVisible(@NonNull View view, boolean z16, boolean z17) {
            boolean z18;
            if (this.mHorizontalBoundCheck.isViewWithinBoundFlags(view, GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_PUNISHED) && this.mVerticalBoundCheck.isViewWithinBoundFlags(view, GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_PUNISHED)) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z16) {
                return z18;
            }
            return !z18;
        }

        public void layoutDecorated(@NonNull View view, int i3, int i16, int i17, int i18) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            view.layout(i3 + rect.left, i16 + rect.top, i17 - rect.right, i18 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(@NonNull View view, int i3, int i16, int i17, int i18) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.mDecorInsets;
            view.layout(i3 + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i16 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i17 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i18 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public void measureChild(@NonNull View view, int i3, int i16) {
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

        public void measureChildWithMargins(@NonNull View view, int i3, int i16) {
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
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i3 + this.mRecyclerView.toString());
            }
        }

        public void offsetChildrenHorizontal(@Px int i3) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i3);
            }
        }

        public void offsetChildrenVertical(@Px int i3) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i3);
            }
        }

        public boolean onAddFocusables(@NonNull RecyclerView recyclerView, @NonNull ArrayList<View> arrayList, int i3, int i16) {
            return false;
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        @Nullable
        public View onFocusSearchFailed(@NonNull View view, int i3, @NonNull Recycler recycler, @NonNull State state) {
            return null;
        }

        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
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

        @Nullable
        public View onInterceptFocusSearch(@NonNull View view, int i3) {
            return null;
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i3, int i16) {
        }

        public void onLayoutChildren(Recycler recycler, State state) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onMeasure(@NonNull Recycler recycler, @NonNull State state, int i3, int i16) {
            this.mRecyclerView.defaultOnMeasure(i3, i16);
        }

        @Deprecated
        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull View view, @Nullable View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        @Nullable
        public Parcelable onSaveInstanceState() {
            return null;
        }

        void onSmoothScrollerStopped(SmoothScroller smoothScroller) {
            if (this.mSmoothScroller == smoothScroller) {
                this.mSmoothScroller = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean performAccessibilityAction(int i3, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i3, bundle);
        }

        public boolean performAccessibilityActionForItem(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, int i3, @Nullable Bundle bundle) {
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

        public void removeAndRecycleAllViews(@NonNull Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        void removeAndRecycleScrapInt(Recycler recycler) {
            int scrapCount = recycler.getScrapCount();
            for (int i3 = scrapCount - 1; i3 >= 0; i3--) {
                View scrapViewAt = recycler.getScrapViewAt(i3);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(scrapViewAt);
                if (!childViewHolderInt.shouldIgnore()) {
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

        public void removeAndRecycleView(@NonNull View view, @NonNull Recycler recycler) {
            removeView(view);
            recycler.recycleView(view);
        }

        public void removeAndRecycleViewAt(int i3, @NonNull Recycler recycler) {
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

        public void removeDetachedView(@NonNull View view) {
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

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z16) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z16, false);
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

        @Deprecated
        public void setAutoMeasureEnabled(boolean z16) {
            this.mAutoMeasure = z16;
        }

        void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final void setItemPrefetchEnabled(boolean z16) {
            if (z16 != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z16;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }

        void setMeasureSpecs(int i3, int i16) {
            this.mWidth = View.MeasureSpec.getSize(i3);
            int mode = View.MeasureSpec.getMode(i3);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i16);
            int mode2 = View.MeasureSpec.getMode(i16);
            this.mHeightMode = mode2;
            if (mode2 == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mHeight = 0;
            }
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
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i28 = rect.left;
                if (i28 < i26) {
                    i26 = i28;
                }
                int i29 = rect.right;
                if (i29 > i17) {
                    i17 = i29;
                }
                int i36 = rect.top;
                if (i36 < i18) {
                    i18 = i36;
                }
                int i37 = rect.bottom;
                if (i37 > i19) {
                    i19 = i37;
                }
            }
            this.mRecyclerView.mTempRect.set(i26, i18, i17, i19);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i3, i16);
        }

        public void setMeasurementCacheEnabled(boolean z16) {
            this.mMeasurementCacheEnabled = z16;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
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

        public void stopIgnoringView(@NonNull View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
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

        public void onInitializeAccessibilityEvent(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z16 = true;
            if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                z16 = false;
            }
            accessibilityEvent.setScrollable(z16);
            Adapter adapter = this.mRecyclerView.mAdapter;
            if (adapter != null) {
                accessibilityEvent.setItemCount(adapter.getItemCount());
            }
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i3, int i16, @Nullable Object obj) {
            onItemsUpdated(recyclerView, i3, i16);
        }

        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull State state, @NonNull View view, @Nullable View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public boolean performAccessibilityAction(@NonNull Recycler recycler, @NonNull State state, int i3, @Nullable Bundle bundle) {
            int height;
            int width;
            int i16;
            int i17;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return false;
            }
            if (i3 == 4096) {
                height = recyclerView.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.mRecyclerView.canScrollHorizontally(1)) {
                    width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    i16 = height;
                    i17 = width;
                }
                i16 = height;
                i17 = 0;
            } else if (i3 != 8192) {
                i17 = 0;
                i16 = 0;
            } else {
                height = recyclerView.canScrollVertically(-1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.mRecyclerView.canScrollHorizontally(-1)) {
                    width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                    i16 = height;
                    i17 = width;
                }
                i16 = height;
                i17 = 0;
            }
            if (i16 == 0 && i17 == 0) {
                return false;
            }
            this.mRecyclerView.smoothScrollBy(i17, i16, null, Integer.MIN_VALUE, true);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean performAccessibilityActionForItem(@NonNull View view, int i3, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i3, bundle);
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z16, boolean z17) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i3 = childRectangleOnScreenScrollAmount[0];
            int i16 = childRectangleOnScreenScrollAmount[1];
            if ((z17 && !isFocusedChildVisibleAfterScrolling(recyclerView, i3, i16)) || (i3 == 0 && i16 == 0)) {
                return false;
            }
            if (z16) {
                recyclerView.scrollBy(i3, i16);
            } else {
                recyclerView.smoothScrollBy(i3, i16);
            }
            return true;
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

        public void onInitializeAccessibilityNodeInfoForItem(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
        }

        public void attachView(@NonNull View view, int i3) {
            attachView(view, i3, (LayoutParams) view.getLayoutParams());
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void setMeasuredDimension(int i3, int i16) {
            this.mRecyclerView.setMeasuredDimension(i3, i16);
        }

        public void attachView(@NonNull View view) {
            attachView(view, -1);
        }

        @CallSuper
        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        public void onItemsChanged(@NonNull RecyclerView recyclerView) {
        }

        public void onLayoutCompleted(State state) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public void onScrollStateChanged(int i3) {
        }

        public void scrollToPosition(int i3) {
        }

        public void collectInitialPrefetchPositions(int i3, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void onAdapterChanged(@Nullable Adapter adapter, @Nullable Adapter adapter2) {
        }

        public void onItemsAdded(@NonNull RecyclerView recyclerView, int i3, int i16) {
        }

        public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i3, int i16) {
        }

        public void collectAdjacentPrefetchPositions(int i3, int i16, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void onItemsMoved(@NonNull RecyclerView recyclerView, int i3, int i16, int i17) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(@NonNull View view);

        void onChildViewDetachedFromWindow(@NonNull View view);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class OnFlingListener {
        public abstract boolean onFling(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z16);

        void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Orientation {
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class RecycledViewPool {
        private static final int DEFAULT_MAX_SCRAP = 5;
        SparseArray<ScrapData> mScrap = new SparseArray<>();
        private int mAttachCount = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes.dex */
        public static class ScrapData {
            final ArrayList<ViewHolder> mScrapHeap = new ArrayList<>();
            int mMaxScrap = 5;
            long mCreateRunningAverageNs = 0;
            long mBindRunningAverageNs = 0;
        }

        private ScrapData getScrapDataForType(int i3) {
            ScrapData scrapData = this.mScrap.get(i3);
            if (scrapData == null) {
                ScrapData scrapData2 = new ScrapData();
                this.mScrap.put(i3, scrapData2);
                return scrapData2;
            }
            return scrapData;
        }

        void attach() {
            this.mAttachCount++;
        }

        public void clear() {
            for (int i3 = 0; i3 < this.mScrap.size(); i3++) {
                this.mScrap.valueAt(i3).mScrapHeap.clear();
            }
        }

        void detach() {
            this.mAttachCount--;
        }

        void factorInBindTime(int i3, long j3) {
            ScrapData scrapDataForType = getScrapDataForType(i3);
            scrapDataForType.mBindRunningAverageNs = runningAverage(scrapDataForType.mBindRunningAverageNs, j3);
        }

        void factorInCreateTime(int i3, long j3) {
            ScrapData scrapDataForType = getScrapDataForType(i3);
            scrapDataForType.mCreateRunningAverageNs = runningAverage(scrapDataForType.mCreateRunningAverageNs, j3);
        }

        @Nullable
        public ViewHolder getRecycledView(int i3) {
            ScrapData scrapData = this.mScrap.get(i3);
            if (scrapData != null && !scrapData.mScrapHeap.isEmpty()) {
                ArrayList<ViewHolder> arrayList = scrapData.mScrapHeap;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                        return arrayList.remove(size);
                    }
                }
                return null;
            }
            return null;
        }

        public int getRecycledViewCount(int i3) {
            return getScrapDataForType(i3).mScrapHeap.size();
        }

        void onAdapterChanged(Adapter adapter, Adapter adapter2, boolean z16) {
            if (adapter != null) {
                detach();
            }
            if (!z16 && this.mAttachCount == 0) {
                clear();
            }
            if (adapter2 != null) {
                attach();
            }
        }

        public void putRecycledView(ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<ViewHolder> arrayList = getScrapDataForType(itemViewType).mScrapHeap;
            if (this.mScrap.get(itemViewType).mMaxScrap <= arrayList.size()) {
                return;
            }
            viewHolder.resetInternal();
            arrayList.add(viewHolder);
        }

        long runningAverage(long j3, long j16) {
            if (j3 == 0) {
                return j16;
            }
            return ((j3 / 4) * 3) + (j16 / 4);
        }

        public void setMaxRecycledViews(int i3, int i16) {
            ScrapData scrapDataForType = getScrapDataForType(i3);
            scrapDataForType.mMaxScrap = i16;
            ArrayList<ViewHolder> arrayList = scrapDataForType.mScrapHeap;
            while (arrayList.size() > i16) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        int size() {
            int i3 = 0;
            for (int i16 = 0; i16 < this.mScrap.size(); i16++) {
                ArrayList<ViewHolder> arrayList = this.mScrap.valueAt(i16).mScrapHeap;
                if (arrayList != null) {
                    i3 += arrayList.size();
                }
            }
            return i3;
        }

        boolean willBindInTime(int i3, long j3, long j16) {
            long j17 = getScrapDataForType(i3).mBindRunningAverageNs;
            if (j17 != 0 && j3 + j17 >= j16) {
                return false;
            }
            return true;
        }

        boolean willCreateInTime(int i3, long j3, long j16) {
            long j17 = getScrapDataForType(i3).mCreateRunningAverageNs;
            if (j17 != 0 && j3 + j17 >= j16) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public final class Recycler {
        static final int DEFAULT_CACHE_SIZE = 2;
        final ArrayList<ViewHolder> mAttachedScrap;
        final ArrayList<ViewHolder> mCachedViews;
        ArrayList<ViewHolder> mChangedScrap;
        RecycledViewPool mRecyclerPool;
        private int mRequestedCacheMax;
        private final List<ViewHolder> mUnmodifiableAttachedScrap;
        private ViewCacheExtension mViewCacheExtension;
        int mViewCacheMax;

        public Recycler() {
            ArrayList<ViewHolder> arrayList = new ArrayList<>();
            this.mAttachedScrap = arrayList;
            this.mChangedScrap = null;
            this.mCachedViews = new ArrayList<>();
            this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(arrayList);
            this.mRequestedCacheMax = 2;
            this.mViewCacheMax = 2;
        }

        private void attachAccessibilityDelegateOnBind(ViewHolder viewHolder) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = viewHolder.itemView;
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.mAccessibilityDelegate;
                if (recyclerViewAccessibilityDelegate == null) {
                    return;
                }
                AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
                if (itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                    ((RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate).saveOriginalDelegate(view);
                }
                ViewCompat.setAccessibilityDelegate(view, itemDelegate);
            }
        }

        private void invalidateDisplayListInt(ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ViewGroup) {
                invalidateDisplayListInt((ViewGroup) view, false);
            }
        }

        private boolean tryBindViewHolderByDeadline(@NonNull ViewHolder viewHolder, int i3, int i16, long j3) {
            viewHolder.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = viewHolder.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j3 != Long.MAX_VALUE && !this.mRecyclerPool.willBindInTime(itemViewType, nanoTime, j3)) {
                return false;
            }
            RecyclerView.this.mAdapter.bindViewHolder(viewHolder, i3);
            this.mRecyclerPool.factorInBindTime(viewHolder.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            attachAccessibilityDelegateOnBind(viewHolder);
            if (RecyclerView.this.mState.isPreLayout()) {
                viewHolder.mPreLayoutPosition = i16;
                return true;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void addViewHolderToRecycledViewPool(@NonNull ViewHolder viewHolder, boolean z16) {
            AccessibilityDelegateCompat accessibilityDelegateCompat;
            RecyclerView.clearNestedRecyclerViewIfNotNested(viewHolder);
            View view = viewHolder.itemView;
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.mAccessibilityDelegate;
            if (recyclerViewAccessibilityDelegate != null) {
                AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
                if (itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                    accessibilityDelegateCompat = ((RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate).getAndRemoveOriginalDelegateForItem(view);
                } else {
                    accessibilityDelegateCompat = null;
                }
                ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompat);
            }
            if (z16) {
                dispatchViewRecycled(viewHolder);
            }
            viewHolder.mOwnerRecyclerView = null;
            getRecycledViewPool().putRecycledView(viewHolder);
        }

        public void bindViewToPosition(@NonNull View view, int i3) {
            LayoutParams layoutParams;
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                int findPositionOffset = RecyclerView.this.mAdapterHelper.findPositionOffset(i3);
                if (findPositionOffset >= 0 && findPositionOffset < RecyclerView.this.mAdapter.getItemCount()) {
                    tryBindViewHolderByDeadline(childViewHolderInt, findPositionOffset, i3, Long.MAX_VALUE);
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
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i3 + "(offset:" + findPositionOffset + ").state:" + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
            }
            throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter" + RecyclerView.this.exceptionLabel());
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
            throw new IndexOutOfBoundsException("invalid position " + i3 + ". State item count is " + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
        }

        void dispatchViewRecycled(@NonNull ViewHolder viewHolder) {
            RecyclerListener recyclerListener = RecyclerView.this.mRecyclerListener;
            if (recyclerListener != null) {
                recyclerListener.onViewRecycled(viewHolder);
            }
            Adapter adapter = RecyclerView.this.mAdapter;
            if (adapter != null) {
                adapter.onViewRecycled(viewHolder);
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

        /* JADX INFO: Access modifiers changed from: package-private */
        public RecycledViewPool getRecycledViewPool() {
            if (this.mRecyclerPool == null) {
                this.mRecyclerPool = new RecycledViewPool();
            }
            return this.mRecyclerPool;
        }

        int getScrapCount() {
            return this.mAttachedScrap.size();
        }

        @NonNull
        public List<ViewHolder> getScrapList() {
            return this.mUnmodifiableAttachedScrap;
        }

        ViewHolder getScrapOrCachedViewForId(long j3, int i3, boolean z16) {
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
            int size2 = this.mCachedViews.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                ViewHolder viewHolder2 = this.mCachedViews.get(size2);
                if (viewHolder2.getItemId() == j3 && !viewHolder2.isAttachedToTransitionOverlay()) {
                    if (i3 == viewHolder2.getItemViewType()) {
                        if (!z16) {
                            this.mCachedViews.remove(size2);
                        }
                        return viewHolder2;
                    }
                    if (!z16) {
                        recycleCachedViewAt(size2);
                        return null;
                    }
                }
            }
        }

        ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int i3, boolean z16) {
            View findHiddenNonRemovedView;
            int size = this.mAttachedScrap.size();
            for (int i16 = 0; i16 < size; i16++) {
                ViewHolder viewHolder = this.mAttachedScrap.get(i16);
                if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i3 && !viewHolder.isInvalid() && (RecyclerView.this.mState.mInPreLayout || !viewHolder.isRemoved())) {
                    viewHolder.addFlags(32);
                    return viewHolder;
                }
            }
            if (!z16 && (findHiddenNonRemovedView = RecyclerView.this.mChildHelper.findHiddenNonRemovedView(i3)) != null) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(findHiddenNonRemovedView);
                RecyclerView.this.mChildHelper.unhide(findHiddenNonRemovedView);
                int indexOfChild = RecyclerView.this.mChildHelper.indexOfChild(findHiddenNonRemovedView);
                if (indexOfChild != -1) {
                    RecyclerView.this.mChildHelper.detachViewFromParent(indexOfChild);
                    scrapView(findHiddenNonRemovedView);
                    childViewHolderInt.addFlags(MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED);
                    return childViewHolderInt;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
            }
            int size2 = this.mCachedViews.size();
            for (int i17 = 0; i17 < size2; i17++) {
                ViewHolder viewHolder2 = this.mCachedViews.get(i17);
                if (!viewHolder2.isInvalid() && viewHolder2.getLayoutPosition() == i3 && !viewHolder2.isAttachedToTransitionOverlay()) {
                    if (!z16) {
                        this.mCachedViews.remove(i17);
                    }
                    return viewHolder2;
                }
            }
            return null;
        }

        View getScrapViewAt(int i3) {
            return this.mAttachedScrap.get(i3).itemView;
        }

        @NonNull
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
            int size = this.mCachedViews.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewHolder viewHolder = this.mCachedViews.get(i3);
                if (viewHolder != null) {
                    viewHolder.addFlags(6);
                    viewHolder.addChangePayload(null);
                }
            }
            Adapter adapter = RecyclerView.this.mAdapter;
            if (adapter == null || !adapter.hasStableIds()) {
                recycleAndClearCachedViews();
            }
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

        /* JADX INFO: Access modifiers changed from: package-private */
        public void onAdapterChanged(Adapter adapter, Adapter adapter2, boolean z16) {
            clear();
            getRecycledViewPool().onAdapterChanged(adapter, adapter2, z16);
        }

        void quickRecycleScrapView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            recycleViewHolderInternal(childViewHolderInt);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void recycleAndClearCachedViews() {
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                recycleCachedViewAt(size);
            }
            this.mCachedViews.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.clearPrefetchPositions();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void recycleCachedViewAt(int i3) {
            addViewHolderToRecycledViewPool(this.mCachedViews.get(i3), true);
            this.mCachedViews.remove(i3);
        }

        public void recycleView(@NonNull View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            recycleViewHolderInternal(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator != null && !childViewHolderInt.isRecyclable()) {
                RecyclerView.this.mItemAnimator.endAnimation(childViewHolderInt);
            }
        }

        void recycleViewHolderInternal(ViewHolder viewHolder) {
            boolean z16;
            boolean z17;
            boolean z18 = false;
            boolean z19 = true;
            if (!viewHolder.isScrap() && viewHolder.itemView.getParent() == null) {
                if (!viewHolder.isTmpDetached()) {
                    if (!viewHolder.shouldIgnore()) {
                        boolean doesTransientStatePreventRecycling = viewHolder.doesTransientStatePreventRecycling();
                        Adapter adapter = RecyclerView.this.mAdapter;
                        if (adapter != null && doesTransientStatePreventRecycling && adapter.onFailedToRecycleView(viewHolder)) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16 && !viewHolder.isRecyclable()) {
                            z19 = false;
                        } else {
                            if (this.mViewCacheMax > 0 && !viewHolder.hasAnyOfTheFlags(526)) {
                                int size = this.mCachedViews.size();
                                if (size >= this.mViewCacheMax && size > 0) {
                                    recycleCachedViewAt(0);
                                    size--;
                                }
                                if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(viewHolder.mPosition)) {
                                    int i3 = size - 1;
                                    while (i3 >= 0) {
                                        if (!RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(this.mCachedViews.get(i3).mPosition)) {
                                            break;
                                        } else {
                                            i3--;
                                        }
                                    }
                                    size = i3 + 1;
                                }
                                this.mCachedViews.add(size, viewHolder);
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (!z17) {
                                addViewHolderToRecycledViewPool(viewHolder, true);
                            } else {
                                z19 = false;
                            }
                            z18 = z17;
                        }
                        RecyclerView.this.mViewInfoStore.removeViewHolder(viewHolder);
                        if (!z18 && !z19 && doesTransientStatePreventRecycling) {
                            viewHolder.mOwnerRecyclerView = null;
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
                }
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder + RecyclerView.this.exceptionLabel());
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Scrapped or attached views may not be recycled. isScrap:");
            sb5.append(viewHolder.isScrap());
            sb5.append(" isAttached:");
            if (viewHolder.itemView.getParent() != null) {
                z18 = true;
            }
            sb5.append(z18);
            sb5.append(RecyclerView.this.exceptionLabel());
            throw new IllegalArgumentException(sb5.toString());
        }

        void scrapView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.mChangedScrap == null) {
                    this.mChangedScrap = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.mChangedScrap.add(childViewHolderInt);
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !RecyclerView.this.mAdapter.hasStableIds()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
            }
            childViewHolderInt.setScrapContainer(this, false);
            this.mAttachedScrap.add(childViewHolderInt);
        }

        void setRecycledViewPool(RecycledViewPool recycledViewPool) {
            RecycledViewPool recycledViewPool2 = this.mRecyclerPool;
            if (recycledViewPool2 != null) {
                recycledViewPool2.detach();
            }
            this.mRecyclerPool = recycledViewPool;
            if (recycledViewPool != null && RecyclerView.this.getAdapter() != null) {
                this.mRecyclerPool.attach();
            }
        }

        void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
            this.mViewCacheExtension = viewCacheExtension;
        }

        public void setViewCacheSize(int i3) {
            this.mRequestedCacheMax = i3;
            updateViewCacheSize();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x018a  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x01a7  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x01ca  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0203  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x022d A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0211  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x01d9  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ViewHolder tryGetViewHolderForPositionByDeadline(int i3, boolean z16, long j3) {
            ViewHolder viewHolder;
            boolean z17;
            ViewHolder viewHolder2;
            boolean z18;
            boolean tryBindViewHolderByDeadline;
            ViewGroup.LayoutParams layoutParams;
            LayoutParams layoutParams2;
            RecyclerView findNestedRecyclerView;
            ViewCacheExtension viewCacheExtension;
            View viewForPositionAndType;
            if (i3 >= 0 && i3 < RecyclerView.this.mState.getItemCount()) {
                boolean z19 = true;
                if (RecyclerView.this.mState.isPreLayout()) {
                    viewHolder = getChangedScrapViewForPosition(i3);
                    if (viewHolder != null) {
                        z17 = true;
                        if (viewHolder == null && (viewHolder = getScrapOrHiddenOrCachedHolderForPosition(i3, z16)) != null) {
                            if (validateViewHolderForOffsetPosition(viewHolder)) {
                                if (!z16) {
                                    viewHolder.addFlags(4);
                                    if (viewHolder.isScrap()) {
                                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                                        viewHolder.unScrap();
                                    } else if (viewHolder.wasReturnedFromScrap()) {
                                        viewHolder.clearReturnedFromScrapFlag();
                                    }
                                    recycleViewHolderInternal(viewHolder);
                                }
                                viewHolder = null;
                            } else {
                                z17 = true;
                            }
                        }
                        if (viewHolder == null) {
                            int findPositionOffset = RecyclerView.this.mAdapterHelper.findPositionOffset(i3);
                            if (findPositionOffset >= 0 && findPositionOffset < RecyclerView.this.mAdapter.getItemCount()) {
                                int itemViewType = RecyclerView.this.mAdapter.getItemViewType(findPositionOffset);
                                if (RecyclerView.this.mAdapter.hasStableIds() && (viewHolder = getScrapOrCachedViewForId(RecyclerView.this.mAdapter.getItemId(findPositionOffset), itemViewType, z16)) != null) {
                                    viewHolder.mPosition = findPositionOffset;
                                    z17 = true;
                                }
                                if (viewHolder == null && (viewCacheExtension = this.mViewCacheExtension) != null && (viewForPositionAndType = viewCacheExtension.getViewForPositionAndType(this, i3, itemViewType)) != null) {
                                    viewHolder = RecyclerView.this.getChildViewHolder(viewForPositionAndType);
                                    if (viewHolder != null) {
                                        if (viewHolder.shouldIgnore()) {
                                            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + RecyclerView.this.exceptionLabel());
                                        }
                                    } else {
                                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + RecyclerView.this.exceptionLabel());
                                    }
                                }
                                if (viewHolder == null) {
                                    ViewHolder recycledView = getRecycledViewPool().getRecycledView(itemViewType);
                                    if (recycledView != null) {
                                        recycledView.resetInternal();
                                        if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                                            invalidateDisplayListInt(recycledView);
                                        }
                                    }
                                    viewHolder = recycledView;
                                }
                                if (viewHolder == null) {
                                    long nanoTime = RecyclerView.this.getNanoTime();
                                    if (j3 != Long.MAX_VALUE && !this.mRecyclerPool.willCreateInTime(itemViewType, nanoTime, j3)) {
                                        return null;
                                    }
                                    RecyclerView recyclerView = RecyclerView.this;
                                    ViewHolder createViewHolder = recyclerView.mAdapter.createViewHolder(recyclerView, itemViewType);
                                    if (RecyclerView.ALLOW_THREAD_GAP_WORK && (findNestedRecyclerView = RecyclerView.findNestedRecyclerView(createViewHolder.itemView)) != null) {
                                        createViewHolder.mNestedRecyclerView = new WeakReference<>(findNestedRecyclerView);
                                    }
                                    this.mRecyclerPool.factorInCreateTime(itemViewType, RecyclerView.this.getNanoTime() - nanoTime);
                                    viewHolder2 = createViewHolder;
                                    z18 = z17;
                                    if (z18 && !RecyclerView.this.mState.isPreLayout() && viewHolder2.hasAnyOfTheFlags(8192)) {
                                        viewHolder2.setFlags(0, 8192);
                                        if (RecyclerView.this.mState.mRunSimpleAnimations) {
                                            int buildAdapterChangeFlagsForAnimations = ItemAnimator.buildAdapterChangeFlagsForAnimations(viewHolder2) | 4096;
                                            RecyclerView recyclerView2 = RecyclerView.this;
                                            RecyclerView.this.recordAnimationInfoIfBouncedHiddenView(viewHolder2, recyclerView2.mItemAnimator.recordPreLayoutInformation(recyclerView2.mState, viewHolder2, buildAdapterChangeFlagsForAnimations, viewHolder2.getUnmodifiedPayloads()));
                                        }
                                    }
                                    if (!RecyclerView.this.mState.isPreLayout() && viewHolder2.isBound()) {
                                        viewHolder2.mPreLayoutPosition = i3;
                                    } else if (viewHolder2.isBound() || viewHolder2.needsUpdate() || viewHolder2.isInvalid()) {
                                        tryBindViewHolderByDeadline = tryBindViewHolderByDeadline(viewHolder2, RecyclerView.this.mAdapterHelper.findPositionOffset(i3), i3, j3);
                                        layoutParams = viewHolder2.itemView.getLayoutParams();
                                        if (layoutParams != null) {
                                            layoutParams2 = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                                            viewHolder2.itemView.setLayoutParams(layoutParams2);
                                        } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                                            layoutParams2 = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams);
                                            viewHolder2.itemView.setLayoutParams(layoutParams2);
                                        } else {
                                            layoutParams2 = (LayoutParams) layoutParams;
                                        }
                                        layoutParams2.mViewHolder = viewHolder2;
                                        if (z18 || !tryBindViewHolderByDeadline) {
                                            z19 = false;
                                        }
                                        layoutParams2.mPendingInvalidate = z19;
                                        return viewHolder2;
                                    }
                                    tryBindViewHolderByDeadline = false;
                                    layoutParams = viewHolder2.itemView.getLayoutParams();
                                    if (layoutParams != null) {
                                    }
                                    layoutParams2.mViewHolder = viewHolder2;
                                    if (z18) {
                                    }
                                    z19 = false;
                                    layoutParams2.mPendingInvalidate = z19;
                                    return viewHolder2;
                                }
                            } else {
                                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i3 + "(offset:" + findPositionOffset + ").state:" + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
                            }
                        }
                        viewHolder2 = viewHolder;
                        z18 = z17;
                        if (z18) {
                            viewHolder2.setFlags(0, 8192);
                            if (RecyclerView.this.mState.mRunSimpleAnimations) {
                            }
                        }
                        if (!RecyclerView.this.mState.isPreLayout()) {
                        }
                        if (viewHolder2.isBound()) {
                        }
                        tryBindViewHolderByDeadline = tryBindViewHolderByDeadline(viewHolder2, RecyclerView.this.mAdapterHelper.findPositionOffset(i3), i3, j3);
                        layoutParams = viewHolder2.itemView.getLayoutParams();
                        if (layoutParams != null) {
                        }
                        layoutParams2.mViewHolder = viewHolder2;
                        if (z18) {
                        }
                        z19 = false;
                        layoutParams2.mPendingInvalidate = z19;
                        return viewHolder2;
                    }
                } else {
                    viewHolder = null;
                }
                z17 = false;
                if (viewHolder == null) {
                    if (validateViewHolderForOffsetPosition(viewHolder)) {
                    }
                }
                if (viewHolder == null) {
                }
                viewHolder2 = viewHolder;
                z18 = z17;
                if (z18) {
                }
                if (!RecyclerView.this.mState.isPreLayout()) {
                }
                if (viewHolder2.isBound()) {
                }
                tryBindViewHolderByDeadline = tryBindViewHolderByDeadline(viewHolder2, RecyclerView.this.mAdapterHelper.findPositionOffset(i3), i3, j3);
                layoutParams = viewHolder2.itemView.getLayoutParams();
                if (layoutParams != null) {
                }
                layoutParams2.mViewHolder = viewHolder2;
                if (z18) {
                }
                z19 = false;
                layoutParams2.mPendingInvalidate = z19;
                return viewHolder2;
            }
            throw new IndexOutOfBoundsException("Invalid item position " + i3 + "(" + i3 + "). Item count:" + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
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

        /* JADX INFO: Access modifiers changed from: package-private */
        public void updateViewCacheSize() {
            int i3;
            LayoutManager layoutManager = RecyclerView.this.mLayout;
            if (layoutManager != null) {
                i3 = layoutManager.mPrefetchMaxCountObserved;
            } else {
                i3 = 0;
            }
            this.mViewCacheMax = this.mRequestedCacheMax + i3;
            for (int size = this.mCachedViews.size() - 1; size >= 0 && this.mCachedViews.size() > this.mViewCacheMax; size--) {
                recycleCachedViewAt(size);
            }
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
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder + RecyclerView.this.exceptionLabel());
        }

        void viewRangeUpdate(int i3, int i16) {
            int i17;
            int i18 = i16 + i3;
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mCachedViews.get(size);
                if (viewHolder != null && (i17 = viewHolder.mPosition) >= i3 && i17 < i18) {
                    viewHolder.addFlags(2);
                    recycleCachedViewAt(size);
                }
            }
        }

        View getViewForPosition(int i3, boolean z16) {
            return tryGetViewHolderForPositionByDeadline(i3, z16, Long.MAX_VALUE).itemView;
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
        void onViewRecycled(@NonNull ViewHolder viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class RecyclerViewDataObserver extends AdapterDataObserver {
        RecyclerViewDataObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mState.mStructureChanged = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (!RecyclerView.this.mAdapterHelper.hasPendingUpdates()) {
                RecyclerView.this.requestLayout();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeChanged(i3, i16, obj)) {
                triggerUpdateProcessor();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i16) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeInserted(i3, i16)) {
                triggerUpdateProcessor();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i3, int i16, int i17) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeMoved(i3, i16, i17)) {
                triggerUpdateProcessor();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i16) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeRemoved(i3, i16)) {
                triggerUpdateProcessor();
            }
        }

        void triggerUpdateProcessor() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                    ViewCompat.postOnAnimation(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.mAdapterUpdateDuringMeasure = true;
            recyclerView2.requestLayout();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class SmoothScroller {
        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private boolean mRunning;
        private boolean mStarted;
        private View mTargetView;
        private int mTargetPosition = -1;
        private final Action mRecyclingAction = new Action(0, 0);

        /* compiled from: P */
        /* loaded from: classes.dex */
        public static class Action {
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
            private boolean mChanged;
            private int mConsecutiveUpdates;
            private int mDuration;
            private int mDx;
            private int mDy;
            private Interpolator mInterpolator;
            private int mJumpToPosition;

            public Action(@Px int i3, @Px int i16) {
                this(i3, i16, Integer.MIN_VALUE, null);
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

            @Px
            public int getDx() {
                return this.mDx;
            }

            @Px
            public int getDy() {
                return this.mDy;
            }

            @Nullable
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

            void runIfNecessary(RecyclerView recyclerView) {
                int i3 = this.mJumpToPosition;
                if (i3 >= 0) {
                    this.mJumpToPosition = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i3);
                    this.mChanged = false;
                } else {
                    if (this.mChanged) {
                        validate();
                        recyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
                        int i16 = this.mConsecutiveUpdates + 1;
                        this.mConsecutiveUpdates = i16;
                        if (i16 > 10) {
                            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.mChanged = false;
                        return;
                    }
                    this.mConsecutiveUpdates = 0;
                }
            }

            public void setDuration(int i3) {
                this.mChanged = true;
                this.mDuration = i3;
            }

            public void setDx(@Px int i3) {
                this.mChanged = true;
                this.mDx = i3;
            }

            public void setDy(@Px int i3) {
                this.mChanged = true;
                this.mDy = i3;
            }

            public void setInterpolator(@Nullable Interpolator interpolator) {
                this.mChanged = true;
                this.mInterpolator = interpolator;
            }

            public void update(@Px int i3, @Px int i16, int i17, @Nullable Interpolator interpolator) {
                this.mDx = i3;
                this.mDy = i16;
                this.mDuration = i17;
                this.mInterpolator = interpolator;
                this.mChanged = true;
            }

            public Action(@Px int i3, @Px int i16, int i17) {
                this(i3, i16, i17, null);
            }

            public Action(@Px int i3, @Px int i16, int i17, @Nullable Interpolator interpolator) {
                this.mJumpToPosition = -1;
                this.mChanged = false;
                this.mConsecutiveUpdates = 0;
                this.mDx = i3;
                this.mDy = i16;
                this.mDuration = i17;
                this.mInterpolator = interpolator;
            }
        }

        /* compiled from: P */
        /* loaded from: classes.dex */
        public interface ScrollVectorProvider {
            @Nullable
            PointF computeScrollVectorForPosition(int i3);
        }

        @Nullable
        public PointF computeScrollVectorForPosition(int i3) {
            Object layoutManager = getLayoutManager();
            if (layoutManager instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i3);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
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
        public void normalize(@NonNull PointF pointF) {
            float f16 = pointF.x;
            float f17 = pointF.y;
            float sqrt = (float) Math.sqrt((f16 * f16) + (f17 * f17));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void onAnimation(int i3, int i16) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null) {
                float f16 = computeScrollVectorForPosition.x;
                if (f16 != 0.0f || computeScrollVectorForPosition.y != 0.0f) {
                    recyclerView.scrollStep((int) Math.signum(f16), (int) Math.signum(computeScrollVectorForPosition.y), null);
                }
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
                if (hasJumpTarget && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.postOnAnimation();
                }
            }
        }

        protected void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        protected abstract void onSeekTargetStep(@Px int i3, @Px int i16, @NonNull State state, @NonNull Action action);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(@NonNull View view, @NonNull State state, @NonNull Action action);

        public void setTargetPosition(int i3) {
            this.mTargetPosition = i3;
        }

        void start(RecyclerView recyclerView, LayoutManager layoutManager) {
            recyclerView.mViewFlinger.stop();
            if (this.mStarted) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
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
                this.mStarted = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void stop() {
            if (!this.mRunning) {
                return;
            }
            this.mRunning = false;
            onStop();
            this.mRecyclerView.mState.mTargetPosition = -1;
            this.mTargetView = null;
            this.mTargetPosition = -1;
            this.mPendingInitialRun = false;
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
        long mFocusedItemId;
        int mFocusedItemPosition;
        int mFocusedSubChildId;
        int mRemainingScrollHorizontal;
        int mRemainingScrollVertical;
        int mTargetPosition = -1;
        int mPreviousLayoutItemCount = 0;
        int mDeletedInvisibleItemCountSincePreviousLayout = 0;
        int mLayoutStep = 1;
        int mItemCount = 0;
        boolean mStructureChanged = false;
        boolean mInPreLayout = false;
        boolean mTrackOldChangeHolders = false;
        boolean mIsMeasuring = false;
        boolean mRunSimpleAnimations = false;
        boolean mRunPredictiveAnimations = false;

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

        public int getRemainingScrollHorizontal() {
            return this.mRemainingScrollHorizontal;
        }

        public int getRemainingScrollVertical() {
            return this.mRemainingScrollVertical;
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

        /* JADX INFO: Access modifiers changed from: package-private */
        public void prepareForNestedPrefetch(Adapter adapter) {
            this.mLayoutStep = 1;
            this.mItemCount = adapter.getItemCount();
            this.mInPreLayout = false;
            this.mTrackOldChangeHolders = false;
            this.mIsMeasuring = false;
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

        public String toString() {
            return "State{mTargetPosition=" + this.mTargetPosition + ", mData=" + this.mData + ", mItemCount=" + this.mItemCount + ", mIsMeasuring=" + this.mIsMeasuring + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
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
        @Nullable
        public abstract View getViewForPositionAndType(@NonNull Recycler recycler, int i3, int i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class ViewFlinger implements Runnable {
        private boolean mEatRunOnAnimationRequest;
        Interpolator mInterpolator;
        private int mLastFlingX;
        private int mLastFlingY;
        OverScroller mOverScroller;
        private boolean mReSchedulePostAnimationCallback;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ViewFlinger() {
            Interpolator interpolator = RecyclerView.sQuinticInterpolator;
            this.mInterpolator = interpolator;
            this.mEatRunOnAnimationRequest = false;
            this.mReSchedulePostAnimationCallback = false;
            this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator);
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

        private float distanceInfluenceForSnapDuration(float f16) {
            return (float) Math.sin((f16 - 0.5f) * 0.47123894f);
        }

        private void internalPostOnAnimation() {
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(RecyclerView.this, this);
        }

        public void fling(int i3, int i16) {
            RecyclerView.this.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            Interpolator interpolator = this.mInterpolator;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.mInterpolator = interpolator2;
                this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.mOverScroller.fling(0, 0, i3, i16, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            postOnAnimation();
        }

        void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
            } else {
                internalPostOnAnimation();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            int i16;
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            int i17;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                stop();
                return;
            }
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.mOverScroller;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i18 = currX - this.mLastFlingX;
                int i19 = currY - this.mLastFlingY;
                this.mLastFlingX = currX;
                this.mLastFlingY = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(i18, i19, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    i18 -= iArr2[0];
                    i19 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i18, i19);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(i18, i19, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    i16 = iArr4[0];
                    i3 = iArr4[1];
                    i18 -= i16;
                    i19 -= i3;
                    SmoothScroller smoothScroller = recyclerView4.mLayout.mSmoothScroller;
                    if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                        int itemCount = RecyclerView.this.mState.getItemCount();
                        if (itemCount == 0) {
                            smoothScroller.stop();
                        } else if (smoothScroller.getTargetPosition() >= itemCount) {
                            smoothScroller.setTargetPosition(itemCount - 1);
                            smoothScroller.onAnimation(i16, i3);
                        } else {
                            smoothScroller.onAnimation(i16, i3);
                        }
                    }
                } else {
                    i3 = 0;
                    i16 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i16, i3, i18, i19, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.mReusableIntPair;
                int i26 = i18 - iArr6[0];
                int i27 = i19 - iArr6[1];
                if (i16 != 0 || i3 != 0) {
                    recyclerView6.dispatchOnScrolled(i16, i3);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                if (overScroller.getCurrX() == overScroller.getFinalX()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (overScroller.getCurrY() == overScroller.getFinalY()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!overScroller.isFinished() && ((!z16 && i26 == 0) || (!z17 && i27 == 0))) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                SmoothScroller smoothScroller2 = RecyclerView.this.mLayout.mSmoothScroller;
                if (smoothScroller2 != null && smoothScroller2.isPendingInitialRun()) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (!z19 && z18) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (i26 < 0) {
                            i17 = -currVelocity;
                        } else if (i26 > 0) {
                            i17 = currVelocity;
                        } else {
                            i17 = 0;
                        }
                        if (i27 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i27 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i17, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.clearPrefetchPositions();
                    }
                } else {
                    postOnAnimation();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    GapWorker gapWorker = recyclerView7.mGapWorker;
                    if (gapWorker != null) {
                        gapWorker.postFromTraversal(recyclerView7, i16, i3);
                    }
                }
            }
            SmoothScroller smoothScroller3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (smoothScroller3 != null && smoothScroller3.isPendingInitialRun()) {
                smoothScroller3.onAnimation(0, 0);
            }
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback) {
                internalPostOnAnimation();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.stopNestedScroll(1);
            }
        }

        public void smoothScrollBy(int i3, int i16, int i17, @Nullable Interpolator interpolator) {
            if (i17 == Integer.MIN_VALUE) {
                i17 = computeScrollDuration(i3, i16, 0, 0);
            }
            int i18 = i17;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            RecyclerView.this.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, i3, i16, i18);
            postOnAnimation();
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.mOverScroller.abortAnimation();
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
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;

        @NonNull
        public final View itemView;
        int mFlags;
        WeakReference<RecyclerView> mNestedRecyclerView;
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
        Recycler mScrapContainer = null;
        boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        @VisibleForTesting
        int mPendingAccessibilityState = -1;

        public ViewHolder(@NonNull View view) {
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

        boolean doesTransientStatePreventRecycling() {
            if ((this.mFlags & 16) == 0 && ViewCompat.hasTransientState(this.itemView)) {
                return true;
            }
            return false;
        }

        void flagRemovedAndOffsetPosition(int i3, int i16, boolean z16) {
            addFlags(8);
            offsetPosition(i16, z16);
            this.mPosition = i3;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionFor(this);
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

        /* JADX INFO: Access modifiers changed from: package-private */
        public List<Object> getUnmodifiedPayloads() {
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

        boolean isAttachedToTransitionOverlay() {
            if (this.itemView.getParent() != null && this.itemView.getParent() != this.mOwnerRecyclerView) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isBound() {
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

        void onEnteredHiddenState(RecyclerView recyclerView) {
            int i3 = this.mPendingAccessibilityState;
            if (i3 != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i3;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
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
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
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

        boolean shouldBeKeptAsChild() {
            if ((this.mFlags & 16) != 0) {
                return true;
            }
            return false;
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
            String simpleName;
            String str;
            if (getClass().isAnonymousClass()) {
                simpleName = "ViewHolder";
            } else {
                simpleName = getClass().getSimpleName();
            }
            StringBuilder sb5 = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
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

        /* JADX INFO: Access modifiers changed from: package-private */
        public void unScrap() {
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
        sQuinticInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.RecyclerView.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f16) {
                float f17 = f16 - 1.0f;
                return (f17 * f17 * f17 * f17 * f17) + 1.0f;
            }
        };
    }

    public RecyclerView(@NonNull Context context) {
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

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    static void clearNestedRecyclerViewIfNotNested(@NonNull ViewHolder viewHolder) {
        WeakReference<RecyclerView> weakReference = viewHolder.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == viewHolder.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                if (parent instanceof View) {
                    recyclerView = (View) parent;
                } else {
                    recyclerView = null;
                }
            }
            viewHolder.mNestedRecyclerView = null;
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i3, int i16) {
        ClassLoader classLoader;
        Constructor constructor;
        Object[] objArr;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String fullClassName = getFullClassName(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(fullClassName, false, classLoader).asSubclass(LayoutManager.class);
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

    private boolean didChildRangeChange(int i3, int i16) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        if (iArr[0] == i3 && iArr[1] == i16) {
            return false;
        }
        return true;
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
        fillRemainingScrollValues(this.mState);
        this.mState.mIsMeasuring = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.clear();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        State state = this.mState;
        if (!state.mRunSimpleAnimations || !this.mItemsChanged) {
            z16 = false;
        }
        state.mTrackOldChangeHolders = z16;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        state.mInPreLayout = state.mRunPredictiveAnimations;
        state.mItemCount = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.mRunSimpleAnimations) {
            int childCount = this.mChildHelper.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i3));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.addToPreLayout(childViewHolderInt, this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt, ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.mTrackOldChangeHolders && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.addToOldChangeHolders(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.mRunPredictiveAnimations) {
            saveOldPositions();
            State state2 = this.mState;
            boolean z17 = state2.mStructureChanged;
            state2.mStructureChanged = false;
            this.mLayout.onLayoutChildren(this.mRecycler, state2);
            this.mState.mStructureChanged = z17;
            for (int i16 = 0; i16 < this.mChildHelper.getChildCount(); i16++) {
                ViewHolder childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.getChildAt(i16));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.isInPreLayout(childViewHolderInt2)) {
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
        stopInterceptRequestLayout(false);
        this.mState.mLayoutStep = 2;
    }

    private void dispatchLayoutStep2() {
        boolean z16;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.assertLayoutStep(6);
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mItemCount = this.mAdapter.getItemCount();
        State state = this.mState;
        state.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        state.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, state);
        State state2 = this.mState;
        state2.mStructureChanged = false;
        this.mPendingSavedState = null;
        if (state2.mRunSimpleAnimations && this.mItemAnimator != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        state2.mRunSimpleAnimations = z16;
        state2.mLayoutStep = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.assertLayoutStep(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        State state = this.mState;
        state.mLayoutStep = 1;
        if (state.mRunSimpleAnimations) {
            for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(childCount));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    ItemAnimator.ItemHolderInfo recordPostLayoutInformation = this.mItemAnimator.recordPostLayoutInformation(this.mState, childViewHolderInt);
                    ViewHolder fromOldChangeHolders = this.mViewInfoStore.getFromOldChangeHolders(changedHolderKey);
                    if (fromOldChangeHolders != null && !fromOldChangeHolders.shouldIgnore()) {
                        boolean isDisappearing = this.mViewInfoStore.isDisappearing(fromOldChangeHolders);
                        boolean isDisappearing2 = this.mViewInfoStore.isDisappearing(childViewHolderInt);
                        if (isDisappearing && fromOldChangeHolders == childViewHolderInt) {
                            this.mViewInfoStore.addToPostLayout(childViewHolderInt, recordPostLayoutInformation);
                        } else {
                            ItemAnimator.ItemHolderInfo popFromPreLayout = this.mViewInfoStore.popFromPreLayout(fromOldChangeHolders);
                            this.mViewInfoStore.addToPostLayout(childViewHolderInt, recordPostLayoutInformation);
                            ItemAnimator.ItemHolderInfo popFromPostLayout = this.mViewInfoStore.popFromPostLayout(childViewHolderInt);
                            if (popFromPreLayout == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, fromOldChangeHolders);
                            } else {
                                animateChange(fromOldChangeHolders, childViewHolderInt, popFromPreLayout, popFromPostLayout, isDisappearing, isDisappearing2);
                            }
                        }
                    } else {
                        this.mViewInfoStore.addToPostLayout(childViewHolderInt, recordPostLayoutInformation);
                    }
                }
            }
            this.mViewInfoStore.process(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        State state2 = this.mState;
        state2.mPreviousLayoutItemCount = state2.mItemCount;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        state2.mRunSimpleAnimations = false;
        state2.mRunPredictiveAnimations = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList<ViewHolder> arrayList = this.mRecycler.mChangedScrap;
        if (arrayList != null) {
            arrayList.clear();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager.mPrefetchMaxObservedInInitialPrefetch) {
            layoutManager.mPrefetchMaxCountObserved = 0;
            layoutManager.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.updateViewCacheSize();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.clear();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        OnItemTouchListener onItemTouchListener = this.mInterceptingOnItemTouchListener;
        if (onItemTouchListener == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        onItemTouchListener.onTouchEvent(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i3 = 0; i3 < size; i3++) {
            OnItemTouchListener onItemTouchListener = this.mOnItemTouchListeners.get(i3);
            if (onItemTouchListener.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int childCount = this.mChildHelper.getChildCount();
        if (childCount == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i3 = Integer.MAX_VALUE;
        int i16 = Integer.MIN_VALUE;
        for (int i17 = 0; i17 < childCount; i17++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i17));
            if (!childViewHolderInt.shouldIgnore()) {
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

    @Nullable
    static RecyclerView findNestedRecyclerView(@NonNull View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i3));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    @Nullable
    private View findNextViewToFocus() {
        ViewHolder findViewHolderForAdapterPosition;
        State state = this.mState;
        int i3 = state.mFocusedItemPosition;
        if (i3 == -1) {
            i3 = 0;
        }
        int itemCount = state.getItemCount();
        for (int i16 = i3; i16 < itemCount; i16++) {
            ViewHolder findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i16);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
        int min = Math.min(itemCount, i3);
        do {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
        } while (!findViewHolderForAdapterPosition.itemView.hasFocusable());
        return findViewHolderForAdapterPosition.itemView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewHolder getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).mViewHolder;
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.mDecorInsets;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id5 = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id5 = view.getId();
            }
        }
        return id5;
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

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long j3, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i3));
            if (childViewHolderInt != viewHolder && getChangedHolderKey(childViewHolderInt) == j3) {
                Adapter adapter = this.mAdapter;
                if (adapter != null && adapter.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder + exceptionLabel());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder + exceptionLabel());
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

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (ViewCompat.getImportantForAutofill(this) == 0) {
            ViewCompat.setImportantForAutofill(this, 8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new ChildHelper.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.5
            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void addView(View view, int i3) {
                RecyclerView.this.addView(view, i3);
                RecyclerView.this.dispatchChildAttached(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void attachViewToParent(View view, int i3, ViewGroup.LayoutParams layoutParams) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                    childViewHolderInt.clearTmpDetachFlag();
                }
                RecyclerView.this.attachViewToParent(view, i3, layoutParams);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void detachViewFromParent(int i3) {
                ViewHolder childViewHolderInt;
                View childAt = getChildAt(i3);
                if (childAt != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt)) != null) {
                    if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                    childViewHolderInt.addFlags(256);
                }
                RecyclerView.this.detachViewFromParent(i3);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public View getChildAt(int i3) {
                return RecyclerView.this.getChildAt(i3);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public int getChildCount() {
                return RecyclerView.this.getChildCount();
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public ViewHolder getChildViewHolder(View view) {
                return RecyclerView.getChildViewHolderInt(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public int indexOfChild(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void onEnteredHiddenState(View view) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void onLeftHiddenState(View view) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void removeAllViews() {
                int childCount = getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void removeViewAt(int i3) {
                View childAt = RecyclerView.this.getChildAt(i3);
                if (childAt != null) {
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i3);
            }
        });
    }

    private boolean isPreferredNextFocus(View view, View view2, int i3) {
        int i16;
        int i17;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c16 = '\uffff';
        if (this.mLayout.getLayoutDirection() == 1) {
            i16 = -1;
        } else {
            i16 = 1;
        }
        Rect rect = this.mTempRect;
        int i18 = rect.left;
        Rect rect2 = this.mTempRect2;
        int i19 = rect2.left;
        if ((i18 < i19 || rect.right <= i19) && rect.right < rect2.right) {
            i17 = 1;
        } else {
            int i26 = rect.right;
            int i27 = rect2.right;
            if ((i26 > i27 || i18 >= i27) && i18 > i19) {
                i17 = -1;
            } else {
                i17 = 0;
            }
        }
        int i28 = rect.top;
        int i29 = rect2.top;
        if ((i28 < i29 || rect.bottom <= i29) && rect.bottom < rect2.bottom) {
            c16 = 1;
        } else {
            int i36 = rect.bottom;
            int i37 = rect2.bottom;
            if ((i36 <= i37 && i28 < i37) || i28 <= i29) {
                c16 = 0;
            }
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 17) {
                    if (i3 != 33) {
                        if (i3 != 66) {
                            if (i3 == 130) {
                                if (c16 <= 0) {
                                    return false;
                                }
                                return true;
                            }
                            throw new IllegalArgumentException("Invalid direction: " + i3 + exceptionLabel());
                        }
                        if (i17 <= 0) {
                            return false;
                        }
                        return true;
                    }
                    if (c16 >= 0) {
                        return false;
                    }
                    return true;
                }
                if (i17 >= 0) {
                    return false;
                }
                return true;
            }
            if (c16 <= 0 && (c16 != 0 || i17 * i16 < 0)) {
                return false;
            }
            return true;
        }
        if (c16 >= 0 && (c16 != 0 || i17 * i16 > 0)) {
            return false;
        }
        return true;
    }

    private void onPointerUp(MotionEvent motionEvent) {
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

    private boolean predictiveItemAnimationsEnabled() {
        if (this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations()) {
            return true;
        }
        return false;
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z16;
        boolean z17;
        boolean z18;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.reset();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.preProcess();
        } else {
            this.mAdapterHelper.consumeUpdatesInOnePass();
        }
        boolean z19 = false;
        if (!this.mItemsAddedOrRemoved && !this.mItemsChanged) {
            z16 = false;
        } else {
            z16 = true;
        }
        State state = this.mState;
        if (this.mFirstLayoutComplete && this.mItemAnimator != null && (((z18 = this.mDataSetHasChangedAfterLayout) || z16 || this.mLayout.mRequestedSimpleAnimations) && (!z18 || this.mAdapter.hasStableIds()))) {
            z17 = true;
        } else {
            z17 = false;
        }
        state.mRunSimpleAnimations = z17;
        State state2 = this.mState;
        if (state2.mRunSimpleAnimations && z16 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z19 = true;
        }
        state2.mRunPredictiveAnimations = z19;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void pullGlows(float f16, float f17, float f18, float f19) {
        boolean z16;
        boolean z17 = true;
        if (f17 < 0.0f) {
            ensureLeftGlow();
            EdgeEffectCompat.onPull(this.mLeftGlow, (-f17) / getWidth(), 1.0f - (f18 / getHeight()));
        } else if (f17 > 0.0f) {
            ensureRightGlow();
            EdgeEffectCompat.onPull(this.mRightGlow, f17 / getWidth(), f18 / getHeight());
        } else {
            z16 = false;
            if (f19 >= 0.0f) {
                ensureTopGlow();
                EdgeEffectCompat.onPull(this.mTopGlow, (-f19) / getHeight(), f16 / getWidth());
            } else if (f19 > 0.0f) {
                ensureBottomGlow();
                EdgeEffectCompat.onPull(this.mBottomGlow, f19 / getHeight(), 1.0f - (f16 / getWidth()));
            } else {
                z17 = z16;
            }
            if (!z17 || f17 != 0.0f || f19 != 0.0f) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            return;
        }
        z16 = true;
        if (f19 >= 0.0f) {
        }
        if (!z17) {
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    private void recoverFocusFromState() {
        ViewHolder viewHolder;
        View findViewById;
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (IGNORE_DETACHED_FOCUSED_CHILD && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                        if (this.mChildHelper.getChildCount() == 0) {
                            requestFocus();
                            return;
                        }
                    } else if (!this.mChildHelper.isHidden(focusedChild)) {
                        return;
                    }
                }
                View view = null;
                if (this.mState.mFocusedItemId != -1 && this.mAdapter.hasStableIds()) {
                    viewHolder = findViewHolderForItemId(this.mState.mFocusedItemId);
                } else {
                    viewHolder = null;
                }
                if (viewHolder != null && !this.mChildHelper.isHidden(viewHolder.itemView) && viewHolder.itemView.hasFocusable()) {
                    view = viewHolder.itemView;
                } else if (this.mChildHelper.getChildCount() > 0) {
                    view = findNextViewToFocus();
                }
                if (view != null) {
                    int i3 = this.mState.mFocusedSubChildId;
                    if (i3 != -1 && (findViewById = view.findViewById(i3)) != null && findViewById.isFocusable()) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void releaseGlows() {
        boolean z16;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z16 = this.mLeftGlow.isFinished();
        } else {
            z16 = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z16 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z16 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z16 |= this.mBottomGlow.isFinished();
        }
        if (z16) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void requestChildOnScreen(@NonNull View view, @Nullable View view2) {
        View view3;
        boolean z16;
        if (view2 != null) {
            view3 = view2;
        } else {
            view3 = view;
        }
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
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
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        LayoutManager layoutManager = this.mLayout;
        Rect rect3 = this.mTempRect;
        boolean z17 = !this.mFirstLayoutComplete;
        if (view2 == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        layoutManager.requestChildRectangleOnScreen(this, view, rect3, z17, z16);
    }

    private void resetFocusInfo() {
        State state = this.mState;
        state.mFocusedItemId = -1L;
        state.mFocusedItemPosition = -1;
        state.mFocusedSubChildId = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        View view;
        long j3;
        int adapterPosition;
        ViewHolder viewHolder = null;
        if (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) {
            view = getFocusedChild();
        } else {
            view = null;
        }
        if (view != null) {
            viewHolder = findContainingViewHolder(view);
        }
        if (viewHolder == null) {
            resetFocusInfo();
            return;
        }
        State state = this.mState;
        if (this.mAdapter.hasStableIds()) {
            j3 = viewHolder.getItemId();
        } else {
            j3 = -1;
        }
        state.mFocusedItemId = j3;
        State state2 = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            adapterPosition = -1;
        } else if (viewHolder.isRemoved()) {
            adapterPosition = viewHolder.mOldPosition;
        } else {
            adapterPosition = viewHolder.getAdapterPosition();
        }
        state2.mFocusedItemPosition = adapterPosition;
        this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(viewHolder.itemView);
    }

    private void setAdapterInternal(@Nullable Adapter adapter, boolean z16, boolean z17) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z16 || z17) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.reset();
        Adapter adapter3 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onAdapterChanged(adapter3, this.mAdapter);
        }
        this.mRecycler.onAdapterChanged(adapter3, this.mAdapter, z16);
        this.mState.mStructureChanged = true;
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.stop();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.stopSmoothScroller();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void absorbGlows(int i3, int i16) {
        if (i3 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i3);
            }
        }
        if (i16 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i16);
            }
        } else if (i16 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i16);
            }
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

    public void addItemDecoration(@NonNull ItemDecoration itemDecoration, int i3) {
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

    public void addOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(onChildAttachStateChangeListener);
    }

    public void addOnItemTouchListener(@NonNull OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.add(onItemTouchListener);
    }

    public void addOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(onScrollListener);
    }

    void animateAppearance(@NonNull ViewHolder viewHolder, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    void animateDisappearance(@NonNull ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        addAnimatingView(viewHolder);
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    void assertInLayoutOrScroll(String str) {
        if (!isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str + exceptionLabel());
        }
    }

    void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str);
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null && !itemAnimator.canReuseUpdatedViewHolder(viewHolder, viewHolder.getUnmodifiedPayloads())) {
            return false;
        }
        return true;
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
            if (!childViewHolderInt.shouldIgnore()) {
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

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        return this.mLayout.computeHorizontalScrollExtent(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        return this.mLayout.computeHorizontalScrollOffset(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        return this.mLayout.computeHorizontalScrollRange(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        return this.mLayout.computeVerticalScrollExtent(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        return this.mLayout.computeVerticalScrollOffset(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        return this.mLayout.computeVerticalScrollRange(this.mState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void considerReleasingGlowsOnScroll(int i3, int i16) {
        boolean z16;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null && !edgeEffect.isFinished() && i3 > 0) {
            this.mLeftGlow.onRelease();
            z16 = this.mLeftGlow.isFinished();
        } else {
            z16 = false;
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i3 < 0) {
            this.mRightGlow.onRelease();
            z16 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i16 > 0) {
            this.mTopGlow.onRelease();
            z16 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i16 < 0) {
            this.mBottomGlow.onRelease();
            z16 |= this.mBottomGlow.isFinished();
        }
        if (z16) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void consumePendingUpdateOperations() {
        if (this.mFirstLayoutComplete && !this.mDataSetHasChangedAfterLayout) {
            if (!this.mAdapterHelper.hasPendingUpdates()) {
                return;
            }
            if (this.mAdapterHelper.hasAnyUpdateTypes(4) && !this.mAdapterHelper.hasAnyUpdateTypes(11)) {
                TraceCompat.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.preProcess();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.consumePostponedUpdates();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
                TraceCompat.endSection();
                return;
            }
            if (this.mAdapterHelper.hasPendingUpdates()) {
                TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                TraceCompat.endSection();
                return;
            }
            return;
        }
        TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
    }

    void defaultOnMeasure(int i3, int i16) {
        setMeasuredDimension(LayoutManager.chooseSize(i3, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(i16, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    }

    void dispatchChildAttached(View view) {
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

    void dispatchChildDetached(View view) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        State state = this.mState;
        state.mIsMeasuring = false;
        if (state.mLayoutStep == 1) {
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
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f16, float f17, boolean z16) {
        return getScrollingChildHelper().dispatchNestedFling(f16, f17, z16);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f16, float f17) {
        return getScrollingChildHelper().dispatchNestedPreFling(f16, f17);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i3, i16, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i3, i16, i17, i18, iArr);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchOnScrolled(int i3, int i16) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i3, scrollY - i16);
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
        this.mDispatchScrollCounter--;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int i3;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.mPendingAccessibilityImportanceChange.get(size);
            if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore() && (i3 = viewHolder.mPendingAccessibilityState) != -1) {
                ViewCompat.setImportantForAccessibility(viewHolder.itemView, i3);
                viewHolder.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
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
        EdgeEffect edgeEffect = this.mLeftGlow;
        boolean z26 = true;
        if (edgeEffect != null && !edgeEffect.isFinished()) {
            int save = canvas.save();
            if (this.mClipToPadding) {
                i16 = getPaddingBottom();
            } else {
                i16 = 0;
            }
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + i16, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            if (edgeEffect2 != null && edgeEffect2.draw(canvas)) {
                z16 = true;
            } else {
                z16 = false;
            }
            canvas.restoreToCount(save);
        } else {
            z16 = false;
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            if (edgeEffect4 != null && edgeEffect4.draw(canvas)) {
                z18 = true;
            } else {
                z18 = false;
            }
            z16 |= z18;
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            if (this.mClipToPadding) {
                i3 = getPaddingTop();
            } else {
                i3 = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate(-i3, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            if (edgeEffect6 != null && edgeEffect6.draw(canvas)) {
                z17 = true;
            } else {
                z17 = false;
            }
            z16 |= z17;
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
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

    void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 3);
        this.mBottomGlow = createEdgeEffect;
        if (this.mClipToPadding) {
            createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 0);
        this.mLeftGlow = createEdgeEffect;
        if (this.mClipToPadding) {
            createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 2);
        this.mRightGlow = createEdgeEffect;
        if (this.mClipToPadding) {
            createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 1);
        this.mTopGlow = createEdgeEffect;
        if (this.mClipToPadding) {
            createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    final void fillRemainingScrollValues(State state) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.mOverScroller;
            state.mRemainingScrollHorizontal = overScroller.getFinalX() - overScroller.getCurrX();
            state.mRemainingScrollVertical = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            state.mRemainingScrollHorizontal = 0;
            state.mRemainingScrollVertical = 0;
        }
    }

    @Nullable
    public View findChildViewUnder(float f16, float f17) {
        for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mChildHelper.getChildAt(childCount);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
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
    public View findContainingItemView(@NonNull View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        return null;
    }

    @Nullable
    public ViewHolder findContainingViewHolder(@NonNull View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    @Nullable
    public ViewHolder findViewHolderForAdapterPosition(int i3) {
        ViewHolder viewHolder = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i16 = 0; i16 < unfilteredChildCount; i16++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i16));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i3) {
                if (this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                    viewHolder = childViewHolderInt;
                } else {
                    return childViewHolderInt;
                }
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long j3) {
        Adapter adapter = this.mAdapter;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.hasStableIds()) {
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            for (int i3 = 0; i3 < unfilteredChildCount; i3++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i3));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j3) {
                    if (this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                        viewHolder = childViewHolderInt;
                    } else {
                        return childViewHolderInt;
                    }
                }
            }
        }
        return viewHolder;
    }

    @Nullable
    public ViewHolder findViewHolderForLayoutPosition(int i3) {
        return findViewHolderForPosition(i3, false);
    }

    @Nullable
    @Deprecated
    public ViewHolder findViewHolderForPosition(int i3) {
        return findViewHolderForPosition(i3, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean fling(int i3, int i16) {
        boolean z16;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.mLayoutSuppressed) {
            return false;
        }
        int canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (canScrollHorizontally == 0 || Math.abs(i3) < this.mMinFlingVelocity) {
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
            if (canScrollHorizontally == 0 && !canScrollVertically) {
                z16 = false;
            } else {
                z16 = true;
            }
            dispatchNestedFling(f16, f17, z16);
            OnFlingListener onFlingListener = this.mOnFlingListener;
            if (onFlingListener != null && onFlingListener.onFling(i3, i16)) {
                return true;
            }
            if (z16) {
                if (canScrollVertically) {
                    canScrollHorizontally = (canScrollHorizontally == true ? 1 : 0) | 2;
                }
                startNestedScroll(canScrollHorizontally, 1);
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
        boolean z16;
        View view2;
        boolean z17;
        boolean z18;
        boolean z19;
        int i16;
        int i17;
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i3);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z26 = true;
        if (this.mAdapter != null && this.mLayout != null && !isComputingLayout() && !this.mLayoutSuppressed) {
            z16 = true;
        } else {
            z16 = false;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z16 && (i3 == 2 || i3 == 1)) {
            if (this.mLayout.canScrollVertically()) {
                if (i3 == 2) {
                    i17 = 130;
                } else {
                    i17 = 33;
                }
                if (focusFinder.findNextFocus(this, view, i17) == null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i3 = i17;
                }
            } else {
                z17 = false;
            }
            if (!z17 && this.mLayout.canScrollHorizontally()) {
                if (this.mLayout.getLayoutDirection() == 1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (i3 == 2) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z18 ^ z19) {
                    i16 = 66;
                } else {
                    i16 = 17;
                }
                if (focusFinder.findNextFocus(this, view, i16) != null) {
                    z26 = false;
                }
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i3 = i16;
                }
                z17 = z26;
            }
            if (z17) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i3, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i3);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i3);
            if (findNextFocus == null && z16) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.onFocusSearchFailed(view, i3, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 != null && !view2.hasFocusable()) {
            if (getFocusedChild() == null) {
                return super.focusSearch(view, i3);
            }
            requestChildOnScreen(view2, null);
            return view;
        }
        if (!isPreferredNextFocus(view, view2, i3)) {
            return super.focusSearch(view, i3);
        }
        return view2;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    @Nullable
    public Adapter getAdapter() {
        return this.mAdapter;
    }

    int getAdapterPositionFor(ViewHolder viewHolder) {
        if (!viewHolder.hasAnyOfTheFlags(524) && viewHolder.isBound()) {
            return this.mAdapterHelper.applyPendingUpdatesToPosition(viewHolder.mPosition);
        }
        return -1;
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

    public int getChildAdapterPosition(@NonNull View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i3, int i16) {
        ChildDrawingOrderCallback childDrawingOrderCallback = this.mChildDrawingOrderCallback;
        if (childDrawingOrderCallback == null) {
            return super.getChildDrawingOrder(i3, i16);
        }
        return childDrawingOrderCallback.onGetChildDrawingOrder(i3, i16);
    }

    public long getChildItemId(@NonNull View view) {
        ViewHolder childViewHolderInt;
        Adapter adapter = this.mAdapter;
        if (adapter == null || !adapter.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(@NonNull View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(@NonNull View view) {
        return getChildAdapterPosition(view);
    }

    public ViewHolder getChildViewHolder(@NonNull View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return getChildViewHolderInt(view);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    @Nullable
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    @NonNull
    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    @Nullable
    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.mInsetsDirty) {
            return layoutParams.mDecorInsets;
        }
        if (this.mState.isPreLayout() && (layoutParams.isItemChanged() || layoutParams.isViewInvalid())) {
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

    @NonNull
    public ItemDecoration getItemDecorationAt(int i3) {
        int itemDecorationCount = getItemDecorationCount();
        if (i3 >= 0 && i3 < itemDecorationCount) {
            return this.mItemDecorations.get(i3);
        }
        throw new IndexOutOfBoundsException(i3 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    @Nullable
    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    @Nullable
    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    @NonNull
    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean hasPendingAdapterUpdates() {
        if (this.mFirstLayoutComplete && !this.mDataSetHasChangedAfterLayout && !this.mAdapterHelper.hasPendingUpdates()) {
            return false;
        }
        return true;
    }

    void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.6
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

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public ViewHolder findViewHolder(int i3) {
                ViewHolder findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i3, true);
                if (findViewHolderForPosition == null || RecyclerView.this.mChildHelper.isHidden(findViewHolderForPosition.itemView)) {
                    return null;
                }
                return findViewHolderForPosition;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void markViewHoldersUpdated(int i3, int i16, Object obj) {
                RecyclerView.this.viewRangeUpdate(i3, i16, obj);
                RecyclerView.this.mItemsChanged = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void offsetPositionsForAdd(int i3, int i16) {
                RecyclerView.this.offsetPositionRecordsForInsert(i3, i16);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void offsetPositionsForMove(int i3, int i16) {
                RecyclerView.this.offsetPositionRecordsForMove(i3, i16);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void offsetPositionsForRemovingInvisible(int i3, int i16) {
                RecyclerView.this.offsetPositionRecordsForRemove(i3, i16, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mItemsAddedOrRemoved = true;
                recyclerView.mState.mDeletedInvisibleItemCountSincePreviousLayout += i16;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void offsetPositionsForRemovingLaidOutOrNewView(int i3, int i16) {
                RecyclerView.this.offsetPositionRecordsForRemove(i3, i16, false);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void onDispatchFirstPass(AdapterHelper.UpdateOp updateOp) {
                dispatchUpdate(updateOp);
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void onDispatchSecondPass(AdapterHelper.UpdateOp updateOp) {
                dispatchUpdate(updateOp);
            }
        });
    }

    @VisibleForTesting
    void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(com.tencent.mobileqq.R.dimen.car), resources.getDimensionPixelSize(com.tencent.mobileqq.R.dimen.cat), resources.getDimensionPixelOffset(com.tencent.mobileqq.R.dimen.cas));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidateGlows() {
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

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    void jumpToPositionForSmoothScroller(int i3) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(i3);
        awakenScrollBars();
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

    public void offsetChildrenHorizontal(@Px int i3) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            this.mChildHelper.getChildAt(i16).offsetLeftAndRight(i3);
        }
    }

    public void offsetChildrenVertical(@Px int i3) {
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
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
    
        if (r1 >= 30.0f) goto L22;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onAttachedToWindow() {
        float f16;
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean z16 = true;
        this.mIsAttached = true;
        if (!this.mFirstLayoutComplete || isLayoutRequested()) {
            z16 = false;
        }
        this.mFirstLayoutComplete = z16;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            ThreadLocal<GapWorker> threadLocal = GapWorker.sGapWorker;
            GapWorker gapWorker = threadLocal.get();
            this.mGapWorker = gapWorker;
            if (gapWorker == null) {
                this.mGapWorker = new GapWorker();
                Display display = ViewCompat.getDisplay(this);
                if (!isInEditMode() && display != null) {
                    f16 = display.getRefreshRate();
                }
                f16 = 60.0f;
                GapWorker gapWorker2 = this.mGapWorker;
                gapWorker2.mFrameIntervalNs = 1.0E9f / f16;
                threadLocal.set(gapWorker2);
            }
            this.mGapWorker.add(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        GapWorker gapWorker;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        stopScroll();
        this.mIsAttached = false;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.onDetach();
        if (ALLOW_THREAD_GAP_WORK && (gapWorker = this.mGapWorker) != null) {
            gapWorker.remove(this);
            this.mGapWorker = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mItemDecorations.get(i3).onDraw(canvas, this, this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f16;
        float f17;
        if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                if (this.mLayout.canScrollVertically()) {
                    f16 = -motionEvent.getAxisValue(9);
                } else {
                    f16 = 0.0f;
                }
                if (this.mLayout.canScrollHorizontally()) {
                    f17 = motionEvent.getAxisValue(10);
                    if (f16 == 0.0f || f17 != 0.0f) {
                        scrollByInternal((int) (f17 * this.mScaledHorizontalScrollFactor), (int) (f16 * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
                f17 = 0.0f;
                if (f16 == 0.0f) {
                }
                scrollByInternal((int) (f17 * this.mScaledHorizontalScrollFactor), (int) (f16 * this.mScaledVerticalScrollFactor), motionEvent);
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.mLayout.canScrollVertically()) {
                        f16 = -axisValue;
                        f17 = 0.0f;
                        if (f16 == 0.0f) {
                        }
                        scrollByInternal((int) (f17 * this.mScaledHorizontalScrollFactor), (int) (f16 * this.mScaledVerticalScrollFactor), motionEvent);
                    } else if (this.mLayout.canScrollHorizontally()) {
                        f17 = axisValue;
                        f16 = 0.0f;
                        if (f16 == 0.0f) {
                        }
                        scrollByInternal((int) (f17 * this.mScaledHorizontalScrollFactor), (int) (f16 * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
                f16 = 0.0f;
                f17 = 0.0f;
                if (f16 == 0.0f) {
                }
                scrollByInternal((int) (f17 * this.mScaledHorizontalScrollFactor), (int) (f16 * this.mScaledVerticalScrollFactor), motionEvent);
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
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
                    } else {
                        cancelScroll();
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                    if (findPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x17 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y17 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    if (this.mScrollState != 1) {
                        int i3 = x17 - this.mInitialTouchX;
                        int i16 = y17 - this.mInitialTouchY;
                        if (canScrollHorizontally != 0 && Math.abs(i3) > this.mTouchSlop) {
                            this.mLastTouchX = x17;
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (canScrollVertically && Math.abs(i16) > this.mTouchSlop) {
                            this.mLastTouchY = y17;
                            z16 = true;
                        }
                        if (z16) {
                            setScrollState(1);
                        }
                    }
                }
            } else {
                this.mVelocityTracker.clear();
                stopNestedScroll(0);
            }
        } else {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x18 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x18;
            this.mInitialTouchX = x18;
            int y18 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y18;
            this.mInitialTouchY = y18;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i17 = canScrollHorizontally;
            if (canScrollVertically) {
                i17 = (canScrollHorizontally ? 1 : 0) | 2;
            }
            startNestedScroll(i17, 0);
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
        if (layoutManager.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i3);
            int mode2 = View.MeasureSpec.getMode(i16);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i3, i16);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z16 = true;
            }
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
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            processAdapterUpdatesAndSetAnimationFlags();
            onExitLayoutOrScroll();
            State state = this.mState;
            if (state.mRunPredictiveAnimations) {
                state.mInPreLayout = true;
            } else {
                this.mAdapterHelper.consumeUpdatesInOnePass();
                this.mState.mInPreLayout = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.mRunPredictiveAnimations) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        Adapter adapter = this.mAdapter;
        if (adapter != null) {
            this.mState.mItemCount = adapter.getItemCount();
        } else {
            this.mState.mItemCount = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, i3, i16);
        stopInterceptRequestLayout(false);
        this.mState.mInPreLayout = false;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i3, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i3, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (i3 != i17 || i16 != i18) {
            invalidateGlows();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fb  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f16;
        float f17;
        int i3;
        int i16;
        int i17;
        int i18;
        boolean z16;
        boolean z17 = false;
        if (this.mLayoutSuppressed || this.mIgnoreMotionEventTillDown) {
            return false;
        }
        if (dispatchToOnItemTouchListeners(motionEvent)) {
            cancelScroll();
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
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
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
                            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                            int x16 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                            this.mLastTouchX = x16;
                            this.mInitialTouchX = x16;
                            int y16 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                            this.mLastTouchY = y16;
                            this.mInitialTouchY = y16;
                        }
                    } else {
                        cancelScroll();
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                    if (findPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x17 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y17 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    int i19 = this.mLastTouchX - x17;
                    int i26 = this.mLastTouchY - y17;
                    if (this.mScrollState != 1) {
                        if (canScrollHorizontally != 0) {
                            if (i19 > 0) {
                                i19 = Math.max(0, i19 - this.mTouchSlop);
                            } else {
                                i19 = Math.min(0, i19 + this.mTouchSlop);
                            }
                            if (i19 != 0) {
                                z16 = true;
                                if (canScrollVertically) {
                                    if (i26 > 0) {
                                        i26 = Math.max(0, i26 - this.mTouchSlop);
                                    } else {
                                        i26 = Math.min(0, i26 + this.mTouchSlop);
                                    }
                                    if (i26 != 0) {
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
                    int i27 = i19;
                    int i28 = i26;
                    if (this.mScrollState == 1) {
                        int[] iArr3 = this.mReusableIntPair;
                        iArr3[0] = 0;
                        iArr3[1] = 0;
                        if (canScrollHorizontally != 0) {
                            i3 = i27;
                        } else {
                            i3 = 0;
                        }
                        if (canScrollVertically) {
                            i16 = i28;
                        } else {
                            i16 = 0;
                        }
                        if (dispatchNestedPreScroll(i3, i16, iArr3, this.mScrollOffset, 0)) {
                            int[] iArr4 = this.mReusableIntPair;
                            i27 -= iArr4[0];
                            i28 -= iArr4[1];
                            int[] iArr5 = this.mNestedOffsets;
                            int i29 = iArr5[0];
                            int[] iArr6 = this.mScrollOffset;
                            iArr5[0] = i29 + iArr6[0];
                            iArr5[1] = iArr5[1] + iArr6[1];
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        int i36 = i28;
                        int[] iArr7 = this.mScrollOffset;
                        this.mLastTouchX = x17 - iArr7[0];
                        this.mLastTouchY = y17 - iArr7[1];
                        if (canScrollHorizontally != 0) {
                            i17 = i27;
                        } else {
                            i17 = 0;
                        }
                        if (canScrollVertically) {
                            i18 = i36;
                        } else {
                            i18 = 0;
                        }
                        if (scrollByInternal(i17, i18, motionEvent)) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        GapWorker gapWorker = this.mGapWorker;
                        if (gapWorker != null && (i27 != 0 || i36 != 0)) {
                            gapWorker.postFromTraversal(this, i27, i36);
                        }
                    }
                }
            } else {
                this.mVelocityTracker.addMovement(obtain);
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
                if (canScrollHorizontally != 0) {
                    f16 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
                } else {
                    f16 = 0.0f;
                }
                if (canScrollVertically) {
                    f17 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
                } else {
                    f17 = 0.0f;
                }
                if ((f16 == 0.0f && f17 == 0.0f) || !fling((int) f16, (int) f17)) {
                    setScrollState(0);
                }
                resetScroll();
                z17 = true;
            }
        } else {
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x18 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x18;
            this.mInitialTouchX = x18;
            int y18 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y18;
            this.mInitialTouchY = y18;
            int i37 = canScrollHorizontally;
            if (canScrollVertically) {
                i37 = (canScrollHorizontally ? 1 : 0) | 2;
            }
            startNestedScroll(i37, 0);
        }
        if (!z17) {
            this.mVelocityTracker.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    void processDataSetCompletelyChanged(boolean z16) {
        this.mDispatchItemsChangedEvent = z16 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void recordAnimationInfoIfBouncedHiddenView(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.setFlags(0, 8192);
        if (this.mState.mTrackOldChangeHolders && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            this.mViewInfoStore.addToOldChangeHolders(getChangedHolderKey(viewHolder), viewHolder);
        }
        this.mViewInfoStore.addToPreLayout(viewHolder, itemHolderInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeAndRecycleViews() {
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

    boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean removeViewIfHidden = this.mChildHelper.removeViewIfHidden(view);
        if (removeViewIfHidden) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.unscrapView(childViewHolderInt);
            this.mRecycler.recycleViewHolderInternal(childViewHolderInt);
        }
        stopInterceptRequestLayout(!removeViewIfHidden);
        return removeViewIfHidden;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z16) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z16);
    }

    public void removeItemDecoration(@NonNull ItemDecoration itemDecoration) {
        boolean z16;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(itemDecoration);
        if (this.mItemDecorations.isEmpty()) {
            if (getOverScrollMode() == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            setWillNotDraw(z16);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i3) {
        int itemDecorationCount = getItemDecorationCount();
        if (i3 >= 0 && i3 < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i3));
            return;
        }
        throw new IndexOutOfBoundsException(i3 + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(onChildAttachStateChangeListener);
    }

    public void removeOnItemTouchListener(@NonNull OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.remove(onItemTouchListener);
        if (this.mInterceptingOnItemTouchListener == onItemTouchListener) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    void repositionShadowingViews() {
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

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
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
        if (this.mInterceptRequestLayoutDepth == 0 && !this.mLayoutSuppressed) {
            super.requestLayout();
        } else {
            this.mLayoutWasDefered = true;
        }
    }

    void saveOldPositions() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i3 = 0; i3 < unfilteredChildCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i3));
            if (!childViewHolderInt.shouldIgnore()) {
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
        if (this.mLayoutSuppressed) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean scrollByInternal(int i3, int i16, MotionEvent motionEvent) {
        int i17;
        int i18;
        int i19;
        int i26;
        boolean z16;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i3, i16, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i27 = iArr2[0];
            int i28 = iArr2[1];
            i17 = i28;
            i18 = i27;
            i19 = i3 - i27;
            i26 = i16 - i28;
        } else {
            i17 = 0;
            i18 = 0;
            i19 = 0;
            i26 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i18, i17, i19, i26, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i29 = iArr4[0];
        int i36 = i19 - i29;
        int i37 = iArr4[1];
        int i38 = i26 - i37;
        if (i29 == 0 && i37 == 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        int i39 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        int i46 = iArr5[0];
        this.mLastTouchX = i39 - i46;
        int i47 = this.mLastTouchY;
        int i48 = iArr5[1];
        this.mLastTouchY = i47 - i48;
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + i46;
        iArr6[1] = iArr6[1] + i48;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !MotionEventCompat.isFromSource(motionEvent, 8194)) {
                pullGlows(motionEvent.getX(), i36, motionEvent.getY(), i38);
            }
            considerReleasingGlowsOnScroll(i3, i16);
        }
        if (i18 != 0 || i17 != 0) {
            dispatchOnScrolled(i18, i17);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (z16 || i18 != 0 || i17 != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scrollStep(int i3, int i16, @Nullable int[] iArr) {
        int i17;
        int i18;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        TraceCompat.beginSection(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        if (i3 != 0) {
            i17 = this.mLayout.scrollHorizontallyBy(i3, this.mRecycler, this.mState);
        } else {
            i17 = 0;
        }
        if (i16 != 0) {
            i18 = this.mLayout.scrollVerticallyBy(i16, this.mRecycler, this.mState);
        } else {
            i18 = 0;
        }
        TraceCompat.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = i17;
            iArr[1] = i18;
        }
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i16) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i3) {
        if (this.mLayoutSuppressed) {
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

    public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.mAccessibilityDelegate = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(@Nullable Adapter adapter) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable ChildDrawingOrderCallback childDrawingOrderCallback) {
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

    @VisibleForTesting
    boolean setChildImportantForAccessibilityInternal(ViewHolder viewHolder, int i3) {
        if (isComputingLayout()) {
            viewHolder.mPendingAccessibilityState = i3;
            this.mPendingAccessibilityImportanceChange.add(viewHolder);
            return false;
        }
        ViewCompat.setImportantForAccessibility(viewHolder.itemView, i3);
        return true;
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

    public void setEdgeEffectFactory(@NonNull EdgeEffectFactory edgeEffectFactory) {
        this.mEdgeEffectFactory = edgeEffectFactory;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z16) {
        this.mHasFixedSize = z16;
    }

    public void setItemAnimator(@Nullable ItemAnimator itemAnimator) {
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

    @Deprecated
    public void setLayoutFrozen(boolean z16) {
        suppressLayout(z16);
    }

    public void setLayoutManager(@Nullable LayoutManager layoutManager) {
        if (layoutManager == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            ItemAnimator itemAnimator = this.mItemAnimator;
            if (itemAnimator != null) {
                itemAnimator.endAnimations();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            this.mRecycler.clear();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            this.mRecycler.clear();
        }
        this.mChildHelper.removeAllViewsUnfiltered();
        this.mLayout = layoutManager;
        if (layoutManager != null) {
            if (layoutManager.mRecyclerView == null) {
                layoutManager.setRecyclerView(this);
                if (this.mIsAttached) {
                    this.mLayout.dispatchAttachedToWindow(this);
                }
            } else {
                throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.mRecyclerView.exceptionLabel());
            }
        }
        this.mRecycler.updateViewCacheSize();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z16) {
        getScrollingChildHelper().setNestedScrollingEnabled(z16);
    }

    public void setOnFlingListener(@Nullable OnFlingListener onFlingListener) {
        this.mOnFlingListener = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(@Nullable OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z16) {
        this.mPreserveFocusAfterLayout = z16;
    }

    public void setRecycledViewPool(@Nullable RecycledViewPool recycledViewPool) {
        this.mRecycler.setRecycledViewPool(recycledViewPool);
    }

    public void setRecyclerListener(@Nullable RecyclerListener recyclerListener) {
        this.mRecyclerListener = recyclerListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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

    public void setScrollingTouchSlop(int i3) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i3 != 0) {
            if (i3 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i3 + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(@Nullable ViewCacheExtension viewCacheExtension) {
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

    public void smoothScrollBy(@Px int i3, @Px int i16) {
        smoothScrollBy(i3, i16, null);
    }

    public void smoothScrollToPosition(int i3) {
        if (this.mLayoutSuppressed) {
            return;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager.smoothScrollToPosition(this, this.mState, i3);
        }
    }

    void startInterceptRequestLayout() {
        int i3 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i3;
        if (i3 == 1 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i3) {
        return getScrollingChildHelper().startNestedScroll(i3);
    }

    void stopInterceptRequestLayout(boolean z16) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z16 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z16 && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z16) {
        if (z16 != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z16) {
                this.mLayoutSuppressed = false;
                if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public void swapAdapter(@Nullable Adapter adapter, boolean z16) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, true, z16);
        processDataSetCompletelyChanged(true);
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

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mobileqq.R.attr.b5q);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2, int i17) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i3, i16, iArr, iArr2, i17);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr, int i19) {
        return getScrollingChildHelper().dispatchNestedScroll(i3, i16, i17, i18, iArr, i19);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    ViewHolder findViewHolderForPosition(int i3, boolean z16) {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        ViewHolder viewHolder = null;
        for (int i16 = 0; i16 < unfilteredChildCount; i16++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i16));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z16) {
                    if (childViewHolderInt.mPosition != i3) {
                        continue;
                    }
                    if (this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    viewHolder = childViewHolderInt;
                } else {
                    if (childViewHolderInt.getLayoutPosition() != i3) {
                        continue;
                    }
                    if (this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                    }
                }
            }
        }
        return viewHolder;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i3) {
        return getScrollingChildHelper().hasNestedScrollingParent(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onExitLayoutOrScroll(boolean z16) {
        int i3 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i3;
        if (i3 < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z16) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    public void smoothScrollBy(@Px int i3, @Px int i16, @Nullable Interpolator interpolator) {
        smoothScrollBy(i3, i16, interpolator, Integer.MIN_VALUE);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i3, int i16) {
        return getScrollingChildHelper().startNestedScroll(i3, i16);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i3) {
        getScrollingChildHelper().stopNestedScroll(i3);
    }

    /* compiled from: P */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.recyclerview.widget.RecyclerView.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        Parcelable mLayoutState;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mLayoutState = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        void copyFrom(SavedState savedState) {
            this.mLayoutState = savedState.mLayoutState;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeParcelable(this.mLayoutState, 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mObserver = new RecyclerViewDataObserver();
        this.mRecycler = new Recycler();
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mFirstLayoutComplete && !recyclerView.isLayoutRequested()) {
                    RecyclerView recyclerView2 = RecyclerView.this;
                    if (!recyclerView2.mIsAttached) {
                        recyclerView2.requestLayout();
                    } else if (recyclerView2.mLayoutSuppressed) {
                        recyclerView2.mLayoutWasDefered = true;
                    } else {
                        recyclerView2.consumePendingUpdateOperations();
                    }
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new EdgeEffectFactory();
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new GapWorker.LayoutPrefetchRegistryImpl() : null;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                ItemAnimator itemAnimator = RecyclerView.this.mItemAnimator;
                if (itemAnimator != null) {
                    itemAnimator.runPendingAnimations();
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback() { // from class: androidx.recyclerview.widget.RecyclerView.4
            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void processAppeared(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void processDisappeared(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.mRecycler.unscrapView(viewHolder);
                RecyclerView.this.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void processPersistent(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                viewHolder.setIsRecyclable(false);
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mDataSetHasChangedAfterLayout) {
                    if (recyclerView.mItemAnimator.animateChange(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                        RecyclerView.this.postAnimationRunner();
                    }
                } else if (recyclerView.mItemAnimator.animatePersistence(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void unused(ViewHolder viewHolder) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mLayout.removeAndRecycleView(viewHolder.itemView, recyclerView.mRecycler);
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        int[] iArr = androidx.recyclerview.R.styleable.RecyclerView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i3, 0);
        int i16 = Build.VERSION.SDK_INT;
        if (i16 >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, i3, 0);
        }
        String string = obtainStyledAttributes.getString(androidx.recyclerview.R.styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_android_clipToPadding, true);
        boolean z16 = obtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = z16;
        if (z16) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i3, 0);
        int[] iArr2 = NESTED_SCROLLING_ATTRS;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i3, 0);
        if (i16 >= 29) {
            saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes2, i3, 0);
        }
        boolean z17 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z17);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr, int i19, @NonNull int[] iArr2) {
        getScrollingChildHelper().dispatchNestedScroll(i3, i16, i17, i18, iArr, i19, iArr2);
    }

    public void smoothScrollBy(@Px int i3, @Px int i16, @Nullable Interpolator interpolator, int i17) {
        smoothScrollBy(i3, i16, interpolator, i17, false);
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

        @Deprecated
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
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    void smoothScrollBy(@Px int i3, @Px int i16, @Nullable Interpolator interpolator, int i17, boolean z16) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        if (!layoutManager.canScrollHorizontally()) {
            i3 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i16 = 0;
        }
        if (i3 == 0 && i16 == 0) {
            return;
        }
        if (i17 == Integer.MIN_VALUE || i17 > 0) {
            if (z16) {
                int i18 = i3 != 0 ? 1 : 0;
                if (i16 != 0) {
                    i18 |= 2;
                }
                startNestedScroll(i18, 1);
            }
            this.mViewFlinger.smoothScrollBy(i3, i16, i17, interpolator);
            return;
        }
        scrollBy(i3, i16);
    }

    public void addItemDecoration(@NonNull ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z16) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        }
    }

    public void onChildAttachedToWindow(@NonNull View view) {
    }

    public void onChildDetachedFromWindow(@NonNull View view) {
    }

    public void onScrollStateChanged(int i3) {
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class OnScrollListener {
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
        }

        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
        }
    }

    public void onScrolled(@Px int i3, @Px int i16) {
    }
}
