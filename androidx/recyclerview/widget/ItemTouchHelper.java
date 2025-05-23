package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    static final int ACTION_MODE_DRAG_MASK = 16711680;
    private static final int ACTION_MODE_IDLE_MASK = 255;
    static final int ACTION_MODE_SWIPE_MASK = 65280;
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    private static final int ACTIVE_POINTER_ID_NONE = -1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    private static final boolean DEBUG = false;
    static final int DIRECTION_FLAG_COUNT = 8;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    private static final int PIXELS_PER_SECOND = 1000;
    public static final int RIGHT = 8;
    public static final int START = 16;
    private static final String TAG = "ItemTouchHelper";
    public static final int UP = 1;

    @NonNull
    Callback mCallback;
    private List<Integer> mDistances;
    private long mDragScrollStartTimeInMs;
    float mDx;
    float mDy;
    GestureDetectorCompat mGestureDetector;
    float mInitialTouchX;
    float mInitialTouchY;
    private ItemTouchHelperGestureListener mItemTouchHelperGestureListener;
    private float mMaxSwipeVelocity;
    RecyclerView mRecyclerView;
    int mSelectedFlags;
    private float mSelectedStartX;
    private float mSelectedStartY;
    private int mSlop;
    private List<RecyclerView.ViewHolder> mSwapTargets;
    private float mSwipeEscapeVelocity;
    private Rect mTmpRect;
    VelocityTracker mVelocityTracker;
    final List<View> mPendingCleanup = new ArrayList();
    private final float[] mTmpPosition = new float[2];
    RecyclerView.ViewHolder mSelected = null;
    int mActivePointerId = -1;
    private int mActionState = 0;
    List<RecoverAnimation> mRecoverAnimations = new ArrayList();
    final Runnable mScrollRunnable = new Runnable() { // from class: androidx.recyclerview.widget.ItemTouchHelper.1
        @Override // java.lang.Runnable
        public void run() {
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            if (itemTouchHelper.mSelected != null && itemTouchHelper.scrollIfNecessary()) {
                ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                RecyclerView.ViewHolder viewHolder = itemTouchHelper2.mSelected;
                if (viewHolder != null) {
                    itemTouchHelper2.moveIfNecessary(viewHolder);
                }
                ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                itemTouchHelper3.mRecyclerView.removeCallbacks(itemTouchHelper3.mScrollRunnable);
                ViewCompat.postOnAnimation(ItemTouchHelper.this.mRecyclerView, this);
            }
        }
    };
    private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback = null;
    View mOverdrawChild = null;
    int mOverdrawChildPosition = -1;
    private final RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: androidx.recyclerview.widget.ItemTouchHelper.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            int findPointerIndex;
            RecoverAnimation findAnimation;
            ItemTouchHelper.this.mGestureDetector.onTouchEvent(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                ItemTouchHelper.this.mActivePointerId = motionEvent.getPointerId(0);
                ItemTouchHelper.this.mInitialTouchX = motionEvent.getX();
                ItemTouchHelper.this.mInitialTouchY = motionEvent.getY();
                ItemTouchHelper.this.obtainVelocityTracker();
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (itemTouchHelper.mSelected == null && (findAnimation = itemTouchHelper.findAnimation(motionEvent)) != null) {
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.mInitialTouchX -= findAnimation.mX;
                    itemTouchHelper2.mInitialTouchY -= findAnimation.mY;
                    itemTouchHelper2.endRecoverAnimation(findAnimation.mViewHolder, true);
                    if (ItemTouchHelper.this.mPendingCleanup.remove(findAnimation.mViewHolder.itemView)) {
                        ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                        itemTouchHelper3.mCallback.clearView(itemTouchHelper3.mRecyclerView, findAnimation.mViewHolder);
                    }
                    ItemTouchHelper.this.select(findAnimation.mViewHolder, findAnimation.mActionState);
                    ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                    itemTouchHelper4.updateDxDy(motionEvent, itemTouchHelper4.mSelectedFlags, 0);
                }
            } else if (actionMasked != 3 && actionMasked != 1) {
                int i3 = ItemTouchHelper.this.mActivePointerId;
                if (i3 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i3)) >= 0) {
                    ItemTouchHelper.this.checkSelectForSwipe(actionMasked, motionEvent, findPointerIndex);
                }
            } else {
                ItemTouchHelper itemTouchHelper5 = ItemTouchHelper.this;
                itemTouchHelper5.mActivePointerId = -1;
                itemTouchHelper5.select(null, 0);
            }
            VelocityTracker velocityTracker = ItemTouchHelper.this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.mSelected != null) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z16) {
            if (!z16) {
                return;
            }
            ItemTouchHelper.this.select(null, 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            ItemTouchHelper.this.mGestureDetector.onTouchEvent(motionEvent);
            VelocityTracker velocityTracker = ItemTouchHelper.this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.mActivePointerId == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
            if (findPointerIndex >= 0) {
                ItemTouchHelper.this.checkSelectForSwipe(actionMasked, motionEvent, findPointerIndex);
            }
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            RecyclerView.ViewHolder viewHolder = itemTouchHelper.mSelected;
            if (viewHolder == null) {
                return;
            }
            int i3 = 0;
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            int actionIndex = motionEvent.getActionIndex();
                            int pointerId = motionEvent.getPointerId(actionIndex);
                            ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                            if (pointerId == itemTouchHelper2.mActivePointerId) {
                                if (actionIndex == 0) {
                                    i3 = 1;
                                }
                                itemTouchHelper2.mActivePointerId = motionEvent.getPointerId(i3);
                                ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                                itemTouchHelper3.updateDxDy(motionEvent, itemTouchHelper3.mSelectedFlags, actionIndex);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    VelocityTracker velocityTracker2 = itemTouchHelper.mVelocityTracker;
                    if (velocityTracker2 != null) {
                        velocityTracker2.clear();
                    }
                } else {
                    if (findPointerIndex >= 0) {
                        itemTouchHelper.updateDxDy(motionEvent, itemTouchHelper.mSelectedFlags, findPointerIndex);
                        ItemTouchHelper.this.moveIfNecessary(viewHolder);
                        ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                        itemTouchHelper4.mRecyclerView.removeCallbacks(itemTouchHelper4.mScrollRunnable);
                        ItemTouchHelper.this.mScrollRunnable.run();
                        ItemTouchHelper.this.mRecyclerView.invalidate();
                        return;
                    }
                    return;
                }
            }
            ItemTouchHelper.this.select(null, 0);
            ItemTouchHelper.this.mActivePointerId = -1;
        }
    };

    /* compiled from: P */
    /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$5, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass5 implements RecyclerView.ChildDrawingOrderCallback {
        AnonymousClass5() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback
        public int onGetChildDrawingOrder(int i3, int i16) {
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            View view = itemTouchHelper.mOverdrawChild;
            if (view == null) {
                return i16;
            }
            int i17 = itemTouchHelper.mOverdrawChildPosition;
            if (i17 == -1) {
                i17 = itemTouchHelper.mRecyclerView.indexOfChild(view);
                ItemTouchHelper.this.mOverdrawChildPosition = i17;
            }
            if (i16 == i3 - 1) {
                return i17;
            }
            if (i16 >= i17) {
                return i16 + 1;
            }
            return i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        private boolean mShouldReactToLongPress = true;

        ItemTouchHelperGestureListener() {
        }

        void doNotReactToLongPress() {
            this.mShouldReactToLongPress = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View findChildView;
            RecyclerView.ViewHolder childViewHolder;
            if (this.mShouldReactToLongPress && (findChildView = ItemTouchHelper.this.findChildView(motionEvent)) != null && (childViewHolder = ItemTouchHelper.this.mRecyclerView.getChildViewHolder(findChildView)) != null) {
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (!itemTouchHelper.mCallback.hasDragFlag(itemTouchHelper.mRecyclerView, childViewHolder)) {
                    return;
                }
                int pointerId = motionEvent.getPointerId(0);
                int i3 = ItemTouchHelper.this.mActivePointerId;
                if (pointerId == i3) {
                    int findPointerIndex = motionEvent.findPointerIndex(i3);
                    float x16 = motionEvent.getX(findPointerIndex);
                    float y16 = motionEvent.getY(findPointerIndex);
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.mInitialTouchX = x16;
                    itemTouchHelper2.mInitialTouchY = y16;
                    itemTouchHelper2.mDy = 0.0f;
                    itemTouchHelper2.mDx = 0.0f;
                    if (itemTouchHelper2.mCallback.isLongPressDragEnabled()) {
                        ItemTouchHelper.this.select(childViewHolder, 2);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class SimpleCallback extends Callback {
        private int mDefaultDragDirs;
        private int mDefaultSwipeDirs;

        public SimpleCallback(int i3, int i16) {
            this.mDefaultSwipeDirs = i16;
            this.mDefaultDragDirs = i3;
        }

        public int getDragDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.mDefaultDragDirs;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return Callback.makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }

        public int getSwipeDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.mDefaultSwipeDirs;
        }

        public void setDefaultDragDirs(int i3) {
            this.mDefaultDragDirs = i3;
        }

        public void setDefaultSwipeDirs(int i3) {
            this.mDefaultSwipeDirs = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface ViewDropHandler {
        void prepareForDrop(@NonNull View view, @NonNull View view2, int i3, int i16);
    }

    public ItemTouchHelper(@NonNull Callback callback) {
        this.mCallback = callback;
    }

    private int checkHorizontalSwipe(RecyclerView.ViewHolder viewHolder, int i3) {
        int i16;
        if ((i3 & 12) != 0) {
            int i17 = 8;
            if (this.mDx > 0.0f) {
                i16 = 8;
            } else {
                i16 = 4;
            }
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null && this.mActivePointerId > -1) {
                velocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
                float xVelocity = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
                float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                if (xVelocity <= 0.0f) {
                    i17 = 4;
                }
                float abs = Math.abs(xVelocity);
                if ((i17 & i3) != 0 && i16 == i17 && abs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && abs > Math.abs(yVelocity)) {
                    return i17;
                }
            }
            float width = this.mRecyclerView.getWidth() * this.mCallback.getSwipeThreshold(viewHolder);
            if ((i3 & i16) != 0 && Math.abs(this.mDx) > width) {
                return i16;
            }
            return 0;
        }
        return 0;
    }

    private int checkVerticalSwipe(RecyclerView.ViewHolder viewHolder, int i3) {
        int i16;
        if ((i3 & 3) != 0) {
            int i17 = 2;
            if (this.mDy > 0.0f) {
                i16 = 2;
            } else {
                i16 = 1;
            }
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null && this.mActivePointerId > -1) {
                velocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
                float xVelocity = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
                float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                if (yVelocity <= 0.0f) {
                    i17 = 1;
                }
                float abs = Math.abs(yVelocity);
                if ((i17 & i3) != 0 && i17 == i16 && abs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && abs > Math.abs(xVelocity)) {
                    return i17;
                }
            }
            float height = this.mRecyclerView.getHeight() * this.mCallback.getSwipeThreshold(viewHolder);
            if ((i3 & i16) != 0 && Math.abs(this.mDy) > height) {
                return i16;
            }
            return 0;
        }
        return 0;
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            this.mCallback.clearView(this.mRecyclerView, this.mRecoverAnimations.get(0).mViewHolder);
        }
        this.mRecoverAnimations.clear();
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        releaseVelocityTracker();
        stopGestureDetection();
    }

    private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = viewHolder;
        List<RecyclerView.ViewHolder> list = this.mSwapTargets;
        if (list == null) {
            this.mSwapTargets = new ArrayList();
            this.mDistances = new ArrayList();
        } else {
            list.clear();
            this.mDistances.clear();
        }
        int boundingBoxMargin = this.mCallback.getBoundingBoxMargin();
        int round = Math.round(this.mSelectedStartX + this.mDx) - boundingBoxMargin;
        int round2 = Math.round(this.mSelectedStartY + this.mDy) - boundingBoxMargin;
        int i3 = boundingBoxMargin * 2;
        int width = viewHolder2.itemView.getWidth() + round + i3;
        int height = viewHolder2.itemView.getHeight() + round2 + i3;
        int i16 = (round + width) / 2;
        int i17 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        int i18 = 0;
        while (i18 < childCount) {
            View childAt = layoutManager.getChildAt(i18);
            if (childAt != viewHolder2.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(childAt);
                if (this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, childViewHolder)) {
                    int abs = Math.abs(i16 - ((childAt.getLeft() + childAt.getRight()) / 2));
                    int abs2 = Math.abs(i17 - ((childAt.getTop() + childAt.getBottom()) / 2));
                    int i19 = (abs * abs) + (abs2 * abs2);
                    int size = this.mSwapTargets.size();
                    int i26 = 0;
                    for (int i27 = 0; i27 < size && i19 > this.mDistances.get(i27).intValue(); i27++) {
                        i26++;
                    }
                    this.mSwapTargets.add(i26, childViewHolder);
                    this.mDistances.add(i26, Integer.valueOf(i19));
                }
            }
            i18++;
            viewHolder2 = viewHolder;
        }
        return this.mSwapTargets;
    }

    private RecyclerView.ViewHolder findSwipedView(MotionEvent motionEvent) {
        View findChildView;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int i3 = this.mActivePointerId;
        if (i3 == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i3);
        float x16 = motionEvent.getX(findPointerIndex) - this.mInitialTouchX;
        float y16 = motionEvent.getY(findPointerIndex) - this.mInitialTouchY;
        float abs = Math.abs(x16);
        float abs2 = Math.abs(y16);
        int i16 = this.mSlop;
        if (abs < i16 && abs2 < i16) {
            return null;
        }
        if (abs > abs2 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if ((abs2 > abs && layoutManager.canScrollVertically()) || (findChildView = findChildView(motionEvent)) == null) {
            return null;
        }
        return this.mRecyclerView.getChildViewHolder(findChildView);
    }

    private void getSelectedDxDy(float[] fArr) {
        if ((this.mSelectedFlags & 12) != 0) {
            fArr[0] = (this.mSelectedStartX + this.mDx) - this.mSelected.itemView.getLeft();
        } else {
            fArr[0] = this.mSelected.itemView.getTranslationX();
        }
        if ((this.mSelectedFlags & 3) != 0) {
            fArr[1] = (this.mSelectedStartY + this.mDy) - this.mSelected.itemView.getTop();
        } else {
            fArr[1] = this.mSelected.itemView.getTranslationY();
        }
    }

    private static boolean hitTest(View view, float f16, float f17, float f18, float f19) {
        if (f16 >= f18 && f16 <= f18 + view.getWidth() && f17 >= f19 && f17 <= f19 + view.getHeight()) {
            return true;
        }
        return false;
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setupCallbacks() {
        this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.addOnChildAttachStateChangeListener(this);
        startGestureDetection();
    }

    private void startGestureDetection() {
        this.mItemTouchHelperGestureListener = new ItemTouchHelperGestureListener();
        this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), this.mItemTouchHelperGestureListener);
    }

    private void stopGestureDetection() {
        ItemTouchHelperGestureListener itemTouchHelperGestureListener = this.mItemTouchHelperGestureListener;
        if (itemTouchHelperGestureListener != null) {
            itemTouchHelperGestureListener.doNotReactToLongPress();
            this.mItemTouchHelperGestureListener = null;
        }
        if (this.mGestureDetector != null) {
            this.mGestureDetector = null;
        }
    }

    private int swipeIfNecessary(RecyclerView.ViewHolder viewHolder) {
        if (this.mActionState == 2) {
            return 0;
        }
        int movementFlags = this.mCallback.getMovementFlags(this.mRecyclerView, viewHolder);
        int convertToAbsoluteDirection = (this.mCallback.convertToAbsoluteDirection(movementFlags, ViewCompat.getLayoutDirection(this.mRecyclerView)) & 65280) >> 8;
        if (convertToAbsoluteDirection == 0) {
            return 0;
        }
        int i3 = (movementFlags & 65280) >> 8;
        if (Math.abs(this.mDx) > Math.abs(this.mDy)) {
            int checkHorizontalSwipe = checkHorizontalSwipe(viewHolder, convertToAbsoluteDirection);
            if (checkHorizontalSwipe > 0) {
                if ((i3 & checkHorizontalSwipe) == 0) {
                    return Callback.convertToRelativeDirection(checkHorizontalSwipe, ViewCompat.getLayoutDirection(this.mRecyclerView));
                }
                return checkHorizontalSwipe;
            }
            int checkVerticalSwipe = checkVerticalSwipe(viewHolder, convertToAbsoluteDirection);
            if (checkVerticalSwipe > 0) {
                return checkVerticalSwipe;
            }
        } else {
            int checkVerticalSwipe2 = checkVerticalSwipe(viewHolder, convertToAbsoluteDirection);
            if (checkVerticalSwipe2 > 0) {
                return checkVerticalSwipe2;
            }
            int checkHorizontalSwipe2 = checkHorizontalSwipe(viewHolder, convertToAbsoluteDirection);
            if (checkHorizontalSwipe2 > 0) {
                if ((i3 & checkHorizontalSwipe2) == 0) {
                    return Callback.convertToRelativeDirection(checkHorizontalSwipe2, ViewCompat.getLayoutDirection(this.mRecyclerView));
                }
                return checkHorizontalSwipe2;
            }
        }
        return 0;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.mSwipeEscapeVelocity = resources.getDimension(R.dimen.f159068vg);
            this.mMaxSwipeVelocity = resources.getDimension(R.dimen.f159067vf);
            setupCallbacks();
        }
    }

    void checkSelectForSwipe(int i3, MotionEvent motionEvent, int i16) {
        RecyclerView.ViewHolder findSwipedView;
        int absoluteMovementFlags;
        if (this.mSelected != null || i3 != 2 || this.mActionState == 2 || !this.mCallback.isItemViewSwipeEnabled() || this.mRecyclerView.getScrollState() == 1 || (findSwipedView = findSwipedView(motionEvent)) == null || (absoluteMovementFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, findSwipedView) & 65280) >> 8) == 0) {
            return;
        }
        float x16 = motionEvent.getX(i16);
        float y16 = motionEvent.getY(i16);
        float f16 = x16 - this.mInitialTouchX;
        float f17 = y16 - this.mInitialTouchY;
        float abs = Math.abs(f16);
        float abs2 = Math.abs(f17);
        int i17 = this.mSlop;
        if (abs < i17 && abs2 < i17) {
            return;
        }
        if (abs > abs2) {
            if (f16 < 0.0f && (absoluteMovementFlags & 4) == 0) {
                return;
            }
            if (f16 > 0.0f && (absoluteMovementFlags & 8) == 0) {
                return;
            }
        } else {
            if (f17 < 0.0f && (absoluteMovementFlags & 1) == 0) {
                return;
            }
            if (f17 > 0.0f && (absoluteMovementFlags & 2) == 0) {
                return;
            }
        }
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        this.mActivePointerId = motionEvent.getPointerId(0);
        select(findSwipedView, 1);
    }

    void endRecoverAnimation(RecyclerView.ViewHolder viewHolder, boolean z16) {
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder == viewHolder) {
                recoverAnimation.mOverridden |= z16;
                if (!recoverAnimation.mEnded) {
                    recoverAnimation.cancel();
                }
                this.mRecoverAnimations.remove(size);
                return;
            }
        }
    }

    RecoverAnimation findAnimation(MotionEvent motionEvent) {
        if (this.mRecoverAnimations.isEmpty()) {
            return null;
        }
        View findChildView = findChildView(motionEvent);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder.itemView == findChildView) {
                return recoverAnimation;
            }
        }
        return null;
    }

    View findChildView(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.mSelected;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            if (hitTest(view, x16, y16, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
                return view;
            }
        }
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            View view2 = recoverAnimation.mViewHolder.itemView;
            if (hitTest(view2, x16, y16, recoverAnimation.mX, recoverAnimation.mY)) {
                return view2;
            }
        }
        return this.mRecyclerView.findChildViewUnder(x16, y16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    boolean hasRunningRecoverAnim() {
        int size = this.mRecoverAnimations.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!this.mRecoverAnimations.get(i3).mEnded) {
                return true;
            }
        }
        return false;
    }

    void moveIfNecessary(RecyclerView.ViewHolder viewHolder) {
        if (this.mRecyclerView.isLayoutRequested() || this.mActionState != 2) {
            return;
        }
        float moveThreshold = this.mCallback.getMoveThreshold(viewHolder);
        int i3 = (int) (this.mSelectedStartX + this.mDx);
        int i16 = (int) (this.mSelectedStartY + this.mDy);
        if (Math.abs(i16 - viewHolder.itemView.getTop()) < viewHolder.itemView.getHeight() * moveThreshold && Math.abs(i3 - viewHolder.itemView.getLeft()) < viewHolder.itemView.getWidth() * moveThreshold) {
            return;
        }
        List<RecyclerView.ViewHolder> findSwapTargets = findSwapTargets(viewHolder);
        if (findSwapTargets.size() == 0) {
            return;
        }
        RecyclerView.ViewHolder chooseDropTarget = this.mCallback.chooseDropTarget(viewHolder, findSwapTargets, i3, i16);
        if (chooseDropTarget == null) {
            this.mSwapTargets.clear();
            this.mDistances.clear();
            return;
        }
        int adapterPosition = chooseDropTarget.getAdapterPosition();
        int adapterPosition2 = viewHolder.getAdapterPosition();
        if (this.mCallback.onMove(this.mRecyclerView, viewHolder, chooseDropTarget)) {
            this.mCallback.onMoved(this.mRecyclerView, viewHolder, adapterPosition2, chooseDropTarget, adapterPosition, i3, i16);
        }
    }

    void obtainVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.mVelocityTracker = VelocityTracker.obtain();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(@NonNull View view) {
        removeChildDrawingOrderCallbackIfNecessary(view);
        RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(view);
        if (childViewHolder == null) {
            return;
        }
        RecyclerView.ViewHolder viewHolder = this.mSelected;
        if (viewHolder != null && childViewHolder == viewHolder) {
            select(null, 0);
            return;
        }
        endRecoverAnimation(childViewHolder, false);
        if (this.mPendingCleanup.remove(childViewHolder.itemView)) {
            this.mCallback.clearView(this.mRecyclerView, childViewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f16;
        float f17;
        this.mOverdrawChildPosition = -1;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition);
            float[] fArr = this.mTmpPosition;
            float f18 = fArr[0];
            f17 = fArr[1];
            f16 = f18;
        } else {
            f16 = 0.0f;
            f17 = 0.0f;
        }
        this.mCallback.onDraw(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f16, f17);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f16;
        float f17;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition);
            float[] fArr = this.mTmpPosition;
            float f18 = fArr[0];
            f17 = fArr[1];
            f16 = f18;
        } else {
            f16 = 0.0f;
            f17 = 0.0f;
        }
        this.mCallback.onDrawOver(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f16, f17);
    }

    void postDispatchSwipe(final RecoverAnimation recoverAnimation, final int i3) {
        this.mRecyclerView.post(new Runnable() { // from class: androidx.recyclerview.widget.ItemTouchHelper.4
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = ItemTouchHelper.this.mRecyclerView;
                if (recyclerView != null && recyclerView.isAttachedToWindow()) {
                    RecoverAnimation recoverAnimation2 = recoverAnimation;
                    if (!recoverAnimation2.mOverridden && recoverAnimation2.mViewHolder.getAdapterPosition() != -1) {
                        RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.mRecyclerView.getItemAnimator();
                        if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !ItemTouchHelper.this.hasRunningRecoverAnim()) {
                            ItemTouchHelper.this.mCallback.onSwiped(recoverAnimation.mViewHolder, i3);
                        } else {
                            ItemTouchHelper.this.mRecyclerView.post(this);
                        }
                    }
                }
            }
        });
    }

    void removeChildDrawingOrderCallbackIfNecessary(View view) {
        if (view == this.mOverdrawChild) {
            this.mOverdrawChild = null;
            if (this.mChildDrawingOrderCallback != null) {
                this.mRecyclerView.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c1, code lost:
    
        if (r1 > 0) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0100 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean scrollIfNecessary() {
        long j3;
        int i3;
        int i16;
        int i17;
        int width;
        if (this.mSelected == null) {
            this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j16 = this.mDragScrollStartTimeInMs;
        if (j16 == Long.MIN_VALUE) {
            j3 = 0;
        } else {
            j3 = currentTimeMillis - j16;
        }
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (this.mTmpRect == null) {
            this.mTmpRect = new Rect();
        }
        layoutManager.calculateItemDecorationsForChild(this.mSelected.itemView, this.mTmpRect);
        if (layoutManager.canScrollHorizontally()) {
            int i18 = (int) (this.mSelectedStartX + this.mDx);
            int paddingLeft = (i18 - this.mTmpRect.left) - this.mRecyclerView.getPaddingLeft();
            float f16 = this.mDx;
            if (f16 < 0.0f && paddingLeft < 0) {
                i3 = paddingLeft;
            } else if (f16 > 0.0f && (width = ((i18 + this.mSelected.itemView.getWidth()) + this.mTmpRect.right) - (this.mRecyclerView.getWidth() - this.mRecyclerView.getPaddingRight())) > 0) {
                i3 = width;
            }
            if (layoutManager.canScrollVertically()) {
                int i19 = (int) (this.mSelectedStartY + this.mDy);
                int paddingTop = (i19 - this.mTmpRect.top) - this.mRecyclerView.getPaddingTop();
                float f17 = this.mDy;
                if (f17 < 0.0f && paddingTop < 0) {
                    i16 = paddingTop;
                } else if (f17 > 0.0f) {
                    i16 = ((i19 + this.mSelected.itemView.getHeight()) + this.mTmpRect.bottom) - (this.mRecyclerView.getHeight() - this.mRecyclerView.getPaddingBottom());
                }
                if (i3 != 0) {
                    i3 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getWidth(), i3, this.mRecyclerView.getWidth(), j3);
                }
                int i26 = i3;
                if (i16 != 0) {
                    i17 = i26;
                    i16 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getHeight(), i16, this.mRecyclerView.getHeight(), j3);
                } else {
                    i17 = i26;
                }
                if (i17 != 0 && i16 == 0) {
                    this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
                    return false;
                }
                if (this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
                    this.mDragScrollStartTimeInMs = currentTimeMillis;
                }
                this.mRecyclerView.scrollBy(i17, i16);
                return true;
            }
            i16 = 0;
            if (i3 != 0) {
            }
            int i262 = i3;
            if (i16 != 0) {
            }
            if (i17 != 0) {
            }
            if (this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
            }
            this.mRecyclerView.scrollBy(i17, i16);
            return true;
        }
        i3 = 0;
        if (layoutManager.canScrollVertically()) {
        }
        i16 = 0;
        if (i3 != 0) {
        }
        int i2622 = i3;
        if (i16 != 0) {
        }
        if (i17 != 0) {
        }
        if (this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
        }
        this.mRecyclerView.scrollBy(i17, i16);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void select(@Nullable RecyclerView.ViewHolder viewHolder, int i3) {
        boolean z16;
        boolean z17;
        ViewParent parent;
        boolean z18;
        int swipeIfNecessary;
        float f16;
        float signum;
        int i16;
        if (viewHolder == this.mSelected && i3 == this.mActionState) {
            return;
        }
        this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
        int i17 = this.mActionState;
        endRecoverAnimation(viewHolder, true);
        this.mActionState = i3;
        if (i3 == 2) {
            if (viewHolder != null) {
                this.mOverdrawChild = viewHolder.itemView;
                addChildDrawingOrderCallback();
            } else {
                throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
            }
        }
        int i18 = (1 << ((i3 * 8) + 8)) - 1;
        final RecyclerView.ViewHolder viewHolder2 = this.mSelected;
        if (viewHolder2 != null) {
            if (viewHolder2.itemView.getParent() != null) {
                if (i17 == 2) {
                    swipeIfNecessary = 0;
                } else {
                    swipeIfNecessary = swipeIfNecessary(viewHolder2);
                }
                releaseVelocityTracker();
                if (swipeIfNecessary != 1 && swipeIfNecessary != 2) {
                    if (swipeIfNecessary != 4 && swipeIfNecessary != 8 && swipeIfNecessary != 16 && swipeIfNecessary != 32) {
                        f16 = 0.0f;
                        signum = 0.0f;
                    } else {
                        signum = 0.0f;
                        f16 = Math.signum(this.mDx) * this.mRecyclerView.getWidth();
                    }
                } else {
                    f16 = 0.0f;
                    signum = Math.signum(this.mDy) * this.mRecyclerView.getHeight();
                }
                if (i17 == 2) {
                    i16 = 8;
                } else if (swipeIfNecessary > 0) {
                    i16 = 2;
                } else {
                    i16 = 4;
                }
                getSelectedDxDy(this.mTmpPosition);
                float[] fArr = this.mTmpPosition;
                float f17 = fArr[0];
                float f18 = fArr[1];
                final int i19 = swipeIfNecessary;
                RecoverAnimation recoverAnimation = new RecoverAnimation(viewHolder2, i16, i17, f17, f18, f16, signum) { // from class: androidx.recyclerview.widget.ItemTouchHelper.3
                    @Override // androidx.recyclerview.widget.ItemTouchHelper.RecoverAnimation, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (this.mOverridden) {
                            return;
                        }
                        if (i19 <= 0) {
                            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                            itemTouchHelper.mCallback.clearView(itemTouchHelper.mRecyclerView, viewHolder2);
                        } else {
                            ItemTouchHelper.this.mPendingCleanup.add(viewHolder2.itemView);
                            this.mIsPendingCleanup = true;
                            int i26 = i19;
                            if (i26 > 0) {
                                ItemTouchHelper.this.postDispatchSwipe(this, i26);
                            }
                        }
                        ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                        View view = itemTouchHelper2.mOverdrawChild;
                        View view2 = viewHolder2.itemView;
                        if (view == view2) {
                            itemTouchHelper2.removeChildDrawingOrderCallbackIfNecessary(view2);
                        }
                    }
                };
                recoverAnimation.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, i16, f16 - f17, signum - f18));
                this.mRecoverAnimations.add(recoverAnimation);
                recoverAnimation.start();
                z16 = true;
            } else {
                removeChildDrawingOrderCallbackIfNecessary(viewHolder2.itemView);
                this.mCallback.clearView(this.mRecyclerView, viewHolder2);
                z16 = false;
            }
            this.mSelected = null;
        } else {
            z16 = false;
        }
        if (viewHolder != null) {
            this.mSelectedFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, viewHolder) & i18) >> (this.mActionState * 8);
            this.mSelectedStartX = viewHolder.itemView.getLeft();
            this.mSelectedStartY = viewHolder.itemView.getTop();
            this.mSelected = viewHolder;
            if (i3 == 2) {
                z17 = false;
                viewHolder.itemView.performHapticFeedback(0);
                parent = this.mRecyclerView.getParent();
                if (parent != null) {
                    if (this.mSelected != null) {
                        z18 = true;
                    } else {
                        z18 = z17;
                    }
                    parent.requestDisallowInterceptTouchEvent(z18);
                }
                if (!z16) {
                    this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
                }
                this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
                this.mRecyclerView.invalidate();
            }
        }
        z17 = false;
        parent = this.mRecyclerView.getParent();
        if (parent != null) {
        }
        if (!z16) {
        }
        this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
        this.mRecyclerView.invalidate();
    }

    public void startDrag(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (!this.mCallback.hasDragFlag(this.mRecyclerView, viewHolder)) {
            Log.e(TAG, "Start drag has been called but dragging is not enabled");
            return;
        }
        if (viewHolder.itemView.getParent() != this.mRecyclerView) {
            Log.e(TAG, "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
            return;
        }
        obtainVelocityTracker();
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        select(viewHolder, 2);
    }

    public void startSwipe(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (!this.mCallback.hasSwipeFlag(this.mRecyclerView, viewHolder)) {
            Log.e(TAG, "Start swipe has been called but swiping is not enabled");
            return;
        }
        if (viewHolder.itemView.getParent() != this.mRecyclerView) {
            Log.e(TAG, "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
            return;
        }
        obtainVelocityTracker();
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        select(viewHolder, 1);
    }

    void updateDxDy(MotionEvent motionEvent, int i3, int i16) {
        float x16 = motionEvent.getX(i16);
        float y16 = motionEvent.getY(i16);
        float f16 = x16 - this.mInitialTouchX;
        this.mDx = f16;
        this.mDy = y16 - this.mInitialTouchY;
        if ((i3 & 4) == 0) {
            this.mDx = Math.max(0.0f, f16);
        }
        if ((i3 & 8) == 0) {
            this.mDx = Math.min(0.0f, this.mDx);
        }
        if ((i3 & 1) == 0) {
            this.mDy = Math.max(0.0f, this.mDy);
        }
        if ((i3 & 2) == 0) {
            this.mDy = Math.min(0.0f, this.mDy);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class Callback {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.ItemTouchHelper.Callback.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f16) {
                return f16 * f16 * f16 * f16 * f16;
            }
        };
        private static final Interpolator sDragViewScrollCapInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.ItemTouchHelper.Callback.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f16) {
                float f17 = f16 - 1.0f;
                return (f17 * f17 * f17 * f17 * f17) + 1.0f;
            }
        };
        private int mCachedMaxScrollSpeed = -1;

        public static int convertToRelativeDirection(int i3, int i16) {
            int i17;
            int i18 = i3 & ABS_HORIZONTAL_DIR_FLAGS;
            if (i18 == 0) {
                return i3;
            }
            int i19 = i3 & (~i18);
            if (i16 == 0) {
                i17 = i18 << 2;
            } else {
                int i26 = i18 << 1;
                i19 |= (-789517) & i26;
                i17 = (i26 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            }
            return i19 | i17;
        }

        @NonNull
        public static ItemTouchUIUtil getDefaultUIUtil() {
            return ItemTouchUIUtilImpl.INSTANCE;
        }

        private int getMaxDragScroll(RecyclerView recyclerView) {
            if (this.mCachedMaxScrollSpeed == -1) {
                this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(R.dimen.f159066ve);
            }
            return this.mCachedMaxScrollSpeed;
        }

        public static int makeFlag(int i3, int i16) {
            return i16 << (i3 * 8);
        }

        public static int makeMovementFlags(int i3, int i16) {
            return makeFlag(2, i3) | makeFlag(1, i16) | makeFlag(0, i16 | i3);
        }

        public boolean canDropOver(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        public RecyclerView.ViewHolder chooseDropTarget(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<RecyclerView.ViewHolder> list, int i3, int i16) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            int width = i3 + viewHolder.itemView.getWidth();
            int height = i16 + viewHolder.itemView.getHeight();
            int left2 = i3 - viewHolder.itemView.getLeft();
            int top2 = i16 - viewHolder.itemView.getTop();
            int size = list.size();
            RecyclerView.ViewHolder viewHolder2 = null;
            int i17 = -1;
            for (int i18 = 0; i18 < size; i18++) {
                RecyclerView.ViewHolder viewHolder3 = list.get(i18);
                if (left2 > 0 && (right = viewHolder3.itemView.getRight() - width) < 0 && viewHolder3.itemView.getRight() > viewHolder.itemView.getRight() && (abs4 = Math.abs(right)) > i17) {
                    viewHolder2 = viewHolder3;
                    i17 = abs4;
                }
                if (left2 < 0 && (left = viewHolder3.itemView.getLeft() - i3) > 0 && viewHolder3.itemView.getLeft() < viewHolder.itemView.getLeft() && (abs3 = Math.abs(left)) > i17) {
                    viewHolder2 = viewHolder3;
                    i17 = abs3;
                }
                if (top2 < 0 && (top = viewHolder3.itemView.getTop() - i16) > 0 && viewHolder3.itemView.getTop() < viewHolder.itemView.getTop() && (abs2 = Math.abs(top)) > i17) {
                    viewHolder2 = viewHolder3;
                    i17 = abs2;
                }
                if (top2 > 0 && (bottom = viewHolder3.itemView.getBottom() - height) < 0 && viewHolder3.itemView.getBottom() > viewHolder.itemView.getBottom() && (abs = Math.abs(bottom)) > i17) {
                    viewHolder2 = viewHolder3;
                    i17 = abs;
                }
            }
            return viewHolder2;
        }

        public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            ItemTouchUIUtilImpl.INSTANCE.clearView(viewHolder.itemView);
        }

        public int convertToAbsoluteDirection(int i3, int i16) {
            int i17;
            int i18 = i3 & RELATIVE_DIR_FLAGS;
            if (i18 == 0) {
                return i3;
            }
            int i19 = i3 & (~i18);
            if (i16 == 0) {
                i17 = i18 >> 2;
            } else {
                int i26 = i18 >> 1;
                i19 |= (-3158065) & i26;
                i17 = (i26 & RELATIVE_DIR_FLAGS) >> 2;
            }
            return i19 | i17;
        }

        final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView));
        }

        public long getAnimationDuration(@NonNull RecyclerView recyclerView, int i3, float f16, float f17) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                if (i3 == 8) {
                    return 200L;
                }
                return 250L;
            }
            if (i3 == 8) {
                return itemAnimator.getMoveDuration();
            }
            return itemAnimator.getRemoveDuration();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder);

        public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            if ((getAbsoluteMovementFlags(recyclerView, viewHolder) & 16711680) != 0) {
                return true;
            }
            return false;
        }

        boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            if ((getAbsoluteMovementFlags(recyclerView, viewHolder) & 65280) != 0) {
                return true;
            }
            return false;
        }

        public int interpolateOutOfBoundsScroll(@NonNull RecyclerView recyclerView, int i3, int i16, int i17, long j3) {
            int maxDragScroll = getMaxDragScroll(recyclerView);
            float f16 = 1.0f;
            int signum = (int) (((int) Math.signum(i16)) * maxDragScroll * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (Math.abs(i16) * 1.0f) / i3)));
            if (j3 <= 2000) {
                f16 = ((float) j3) / 2000.0f;
            }
            int interpolation = (int) (signum * sDragScrollInterpolator.getInterpolation(f16));
            if (interpolation == 0) {
                if (i16 > 0) {
                    return 1;
                }
                return -1;
            }
            return interpolation;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f16, float f17, int i3, boolean z16) {
            ItemTouchUIUtilImpl.INSTANCE.onDraw(canvas, recyclerView, viewHolder.itemView, f16, f17, i3, z16);
        }

        public void onChildDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f16, float f17, int i3, boolean z16) {
            ItemTouchUIUtilImpl.INSTANCE.onDrawOver(canvas, recyclerView, viewHolder.itemView, f16, f17, i3, z16);
        }

        void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i3, float f16, float f17) {
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                RecoverAnimation recoverAnimation = list.get(i16);
                recoverAnimation.update();
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, recoverAnimation.mActionState, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDraw(canvas, recyclerView, viewHolder, f16, f17, i3, true);
                canvas.restoreToCount(save2);
            }
        }

        void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i3, float f16, float f17) {
            int size = list.size();
            boolean z16 = false;
            for (int i16 = 0; i16 < size; i16++) {
                RecoverAnimation recoverAnimation = list.get(i16);
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, recoverAnimation.mActionState, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, viewHolder, f16, f17, i3, true);
                canvas.restoreToCount(save2);
            }
            for (int i17 = size - 1; i17 >= 0; i17--) {
                RecoverAnimation recoverAnimation2 = list.get(i17);
                boolean z17 = recoverAnimation2.mEnded;
                if (z17 && !recoverAnimation2.mIsPendingCleanup) {
                    list.remove(i17);
                } else if (!z17) {
                    z16 = true;
                }
            }
            if (z16) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2);

        /* JADX WARN: Multi-variable type inference failed */
        public void onMoved(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, int i3, @NonNull RecyclerView.ViewHolder viewHolder2, int i16, int i17, int i18) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i17, i18);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i16);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i16);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i16);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i16);
                }
            }
        }

        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int i3) {
            if (viewHolder != null) {
                ItemTouchUIUtilImpl.INSTANCE.onSelected(viewHolder.itemView);
            }
        }

        public abstract void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i3);

        public float getSwipeEscapeVelocity(float f16) {
            return f16;
        }

        public float getSwipeVelocityThreshold(float f16) {
            return f16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class RecoverAnimation implements Animator.AnimatorListener {
        final int mActionState;
        final int mAnimationType;
        private float mFraction;
        boolean mIsPendingCleanup;
        final float mStartDx;
        final float mStartDy;
        final float mTargetX;
        final float mTargetY;
        private final ValueAnimator mValueAnimator;
        final RecyclerView.ViewHolder mViewHolder;
        float mX;
        float mY;
        boolean mOverridden = false;
        boolean mEnded = false;

        RecoverAnimation(RecyclerView.ViewHolder viewHolder, int i3, int i16, float f16, float f17, float f18, float f19) {
            this.mActionState = i16;
            this.mAnimationType = i3;
            this.mViewHolder = viewHolder;
            this.mStartDx = f16;
            this.mStartDy = f17;
            this.mTargetX = f18;
            this.mTargetY = f19;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.recyclerview.widget.ItemTouchHelper.RecoverAnimation.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RecoverAnimation.this.setFraction(valueAnimator.getAnimatedFraction());
                }
            });
            ofFloat.setTarget(viewHolder.itemView);
            ofFloat.addListener(this);
            setFraction(0.0f);
        }

        public void cancel() {
            this.mValueAnimator.cancel();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            setFraction(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.mEnded) {
                this.mViewHolder.setIsRecyclable(true);
            }
            this.mEnded = true;
        }

        public void setDuration(long j3) {
            this.mValueAnimator.setDuration(j3);
        }

        public void setFraction(float f16) {
            this.mFraction = f16;
        }

        public void start() {
            this.mViewHolder.setIsRecyclable(false);
            this.mValueAnimator.start();
        }

        public void update() {
            float f16 = this.mStartDx;
            float f17 = this.mTargetX;
            if (f16 == f17) {
                this.mX = this.mViewHolder.itemView.getTranslationX();
            } else {
                this.mX = f16 + (this.mFraction * (f17 - f16));
            }
            float f18 = this.mStartDy;
            float f19 = this.mTargetY;
            if (f18 == f19) {
                this.mY = this.mViewHolder.itemView.getTranslationY();
            } else {
                this.mY = f18 + (this.mFraction * (f19 - f18));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    private void addChildDrawingOrderCallback() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(@NonNull View view) {
    }
}
