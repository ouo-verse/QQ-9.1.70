package com.tencent.widget.itemtouchhelper;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.f;
import com.tencent.widget.itemtouchhelper.ItemTouchUIUtilImpl;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    static IPatchRedirector $redirector_ = null;
    static final int ACTION_MODE_DRAG_MASK = 16711680;
    private static final int ACTION_MODE_IDLE_MASK = 255;
    static final int ACTION_MODE_SWIPE_MASK = 65280;
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    static final int ACTIVE_POINTER_ID_NONE = -1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    static final boolean DEBUG = false;
    static final int DIRECTION_FLAG_COUNT = 8;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    private static final int PIXELS_PER_SECOND = 1000;
    public static final int RIGHT = 8;
    public static final int START = 16;
    static final String TAG = "ItemTouchHelper";
    public static final int UP = 1;
    int mActionState;
    int mActivePointerId;
    Callback mCallback;
    private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback;
    private List<Integer> mDistances;
    private long mDragScrollStartTimeInMs;
    float mDx;
    float mDy;
    GestureDetectorCompat mGestureDetector;
    float mInitialTouchX;
    float mInitialTouchY;
    float mMaxSwipeVelocity;
    private final RecyclerView.OnItemTouchListener mOnItemTouchListener;
    View mOverdrawChild;
    int mOverdrawChildPosition;
    final List<View> mPendingCleanup;
    List<RecoverAnimation> mRecoverAnimations;
    RecyclerView mRecyclerView;
    final Runnable mScrollRunnable;
    RecyclerView.ViewHolder mSelected;
    int mSelectedFlags;
    float mSelectedStartX;
    float mSelectedStartY;
    private int mSlop;
    private List<RecyclerView.ViewHolder> mSwapTargets;
    float mSwipeEscapeVelocity;
    private final float[] mTmpPosition;
    private Rect mTmpRect;
    VelocityTracker mVelocityTracker;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class Callback {
        static IPatchRedirector $redirector_ = null;
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator;
        private static final Interpolator sDragViewScrollCapInterpolator;
        private static final ItemTouchUIUtil sUICallback;
        private int mCachedMaxScrollSpeed;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a implements Interpolator {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16))).floatValue();
                }
                return f16 * f16 * f16 * f16 * f16;
            }
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class b implements Interpolator {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16))).floatValue();
                }
                float f17 = f16 - 1.0f;
                return (f17 * f17 * f17 * f17 * f17) + 1.0f;
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56842);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 19)) {
                redirector.redirect((short) 19);
                return;
            }
            sDragScrollInterpolator = new a();
            sDragViewScrollCapInterpolator = new b();
            sUICallback = new ItemTouchUIUtilImpl.Lollipop();
        }

        public Callback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mCachedMaxScrollSpeed = -1;
            }
        }

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

        public static ItemTouchUIUtil getDefaultUIUtil() {
            return sUICallback;
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

        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, recyclerView, viewHolder, viewHolder2)).booleanValue();
            }
            return true;
        }

        public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder viewHolder, List<RecyclerView.ViewHolder> list, int i3, int i16) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 11, this, viewHolder, list, Integer.valueOf(i3), Integer.valueOf(i16));
            }
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

        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) recyclerView, (Object) viewHolder);
            } else {
                sUICallback.clearView(viewHolder.itemView);
            }
        }

        public int convertToAbsoluteDirection(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
            }
            int i17 = i3 & RELATIVE_DIR_FLAGS;
            if (i17 == 0) {
                return i3;
            }
            int i18 = i3 & (~i17);
            if (i16 == 0) {
                return i18 | (i17 >> 2);
            }
            int i19 = i17 >> 1;
            return i18 | ((-3158065) & i19) | ((i19 & RELATIVE_DIR_FLAGS) >> 2);
        }

        final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView));
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i3, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Long) iPatchRedirector.redirect((short) 17, this, recyclerView, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17))).longValue();
            }
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return 0;
        }

        public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Float) iPatchRedirector.redirect((short) 8, (Object) this, (Object) viewHolder)).floatValue();
            }
            return 0.5f;
        }

        public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);

        public float getSwipeEscapeVelocity(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Float) iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16))).floatValue();
            }
            return f16;
        }

        public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Float) iPatchRedirector.redirect((short) 7, (Object) this, (Object) viewHolder)).floatValue();
            }
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Float) iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16))).floatValue();
            }
            return f16;
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

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i3, int i16, int i17, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Integer) iPatchRedirector.redirect((short) 18, this, recyclerView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3))).intValue();
            }
            float f16 = 1.0f;
            int signum = (int) (((int) Math.signum(i16)) * getMaxDragScroll(recyclerView) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (Math.abs(i16) * 1.0f) / i3)));
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return true;
        }

        public boolean isLongPressDragEnabled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return true;
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f16, float f17, int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, this, canvas, recyclerView, viewHolder, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), Boolean.valueOf(z16));
            } else {
                sUICallback.onDraw(canvas, recyclerView, viewHolder.itemView, f16, f17, i3, z16);
            }
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f16, float f17, int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, this, canvas, recyclerView, viewHolder, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), Boolean.valueOf(z16));
            } else {
                sUICallback.onDrawOver(canvas, recyclerView, viewHolder.itemView, f16, f17, i3, z16);
            }
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

        public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2);

        /* JADX WARN: Multi-variable type inference failed */
        public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i3, RecyclerView.ViewHolder viewHolder2, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, recyclerView, viewHolder, Integer.valueOf(i3), viewHolder2, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
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

        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) viewHolder, i3);
            } else if (viewHolder != null) {
                sUICallback.onSelected(viewHolder.itemView);
            }
        }

        public abstract void onSwiped(RecyclerView.ViewHolder viewHolder, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        ItemTouchHelperGestureListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ItemTouchHelper.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            RecyclerView.ViewHolder childViewHolder;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent);
                return;
            }
            View findChildView = ItemTouchHelper.this.findChildView(motionEvent);
            if (findChildView != null && (childViewHolder = ItemTouchHelper.this.mRecyclerView.getChildViewHolder(findChildView)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class RecoverAnimation extends f {
        static IPatchRedirector $redirector_;
        final int mActionState;
        final int mAnimationType;
        boolean mEnded;
        private float mFraction;
        public boolean mIsPendingCleanup;
        boolean mOverridden;
        final float mStartDx;
        final float mStartDy;
        final float mTargetX;
        final float mTargetY;
        private final ValueAnimator mValueAnimator;
        final RecyclerView.ViewHolder mViewHolder;
        float mX;
        float mY;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ItemTouchHelper f384786d;

            a(ItemTouchHelper itemTouchHelper) {
                this.f384786d = itemTouchHelper;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecoverAnimation.this, (Object) itemTouchHelper);
                }
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                } else {
                    RecoverAnimation.this.setFraction(valueAnimator.getAnimatedFraction());
                }
            }
        }

        RecoverAnimation(RecyclerView.ViewHolder viewHolder, int i3, int i16, float f16, float f17, float f18, float f19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ItemTouchHelper.this, viewHolder, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
                return;
            }
            this.mOverridden = false;
            this.mEnded = false;
            this.mActionState = i16;
            this.mAnimationType = i3;
            this.mViewHolder = viewHolder;
            this.mStartDx = f16;
            this.mStartDy = f17;
            this.mTargetX = f18;
            this.mTargetY = f19;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator = ofFloat;
            ofFloat.addUpdateListener(new a(ItemTouchHelper.this));
            ofFloat.setTarget(viewHolder.itemView);
            ofFloat.addListener(this);
            setFraction(0.0f);
        }

        public void cancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.mValueAnimator.cancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) animator);
            } else {
                setFraction(1.0f);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) animator);
                return;
            }
            if (!this.mEnded) {
                this.mViewHolder.setIsRecyclable(true);
            }
            this.mEnded = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) animator);
            }
        }

        public void setDuration(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
            } else {
                this.mValueAnimator.setDuration(j3);
            }
        }

        public void setFraction(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
            } else {
                this.mFraction = f16;
            }
        }

        public void start() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.mViewHolder.setIsRecyclable(false);
                this.mValueAnimator.start();
            }
        }

        public void update() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
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
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class SimpleCallback extends Callback {
        static IPatchRedirector $redirector_;
        private int mDefaultDragDirs;
        private int mDefaultSwipeDirs;

        public SimpleCallback(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.mDefaultSwipeDirs = i16;
                this.mDefaultDragDirs = i3;
            }
        }

        public int getDragDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) recyclerView, (Object) viewHolder)).intValue();
            }
            return this.mDefaultDragDirs;
        }

        @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) recyclerView, (Object) viewHolder)).intValue();
            }
            return Callback.makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }

        public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) recyclerView, (Object) viewHolder)).intValue();
            }
            return this.mDefaultSwipeDirs;
        }

        public void setDefaultDragDirs(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.mDefaultDragDirs = i3;
            }
        }

        public void setDefaultSwipeDirs(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                this.mDefaultSwipeDirs = i3;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ViewDropHandler {
        void prepareForDrop(View view, View view2, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class a implements RecyclerView.OnItemTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ItemTouchHelper.this);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            RecoverAnimation findAnimation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, (Object) motionEvent)).booleanValue();
            }
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

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            } else {
                if (!z16) {
                    return;
                }
                ItemTouchHelper.this.select(null, 0);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) recyclerView, (Object) motionEvent);
                return;
            }
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
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class b extends RecoverAnimation {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f384789d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f384790e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(RecyclerView.ViewHolder viewHolder, int i3, int i16, float f16, float f17, float f18, float f19, int i17, RecyclerView.ViewHolder viewHolder2) {
            super(viewHolder, i3, i16, f16, f17, f18, f19);
            this.f384789d = i17;
            this.f384790e = viewHolder2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ItemTouchHelper.this, viewHolder, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Integer.valueOf(i17), viewHolder2);
            }
        }

        @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.RecoverAnimation, com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            super.onAnimationEnd(animator);
            if (this.mOverridden) {
                return;
            }
            if (this.f384789d <= 0) {
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                itemTouchHelper.mCallback.clearView(itemTouchHelper.mRecyclerView, this.f384790e);
            } else {
                ItemTouchHelper.this.mPendingCleanup.add(this.f384790e.itemView);
                this.mIsPendingCleanup = true;
                int i3 = this.f384789d;
                if (i3 > 0) {
                    ItemTouchHelper.this.postDispatchSwipe(this, i3);
                }
            }
            ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
            View view = itemTouchHelper2.mOverdrawChild;
            View view2 = this.f384790e.itemView;
            if (view == view2) {
                itemTouchHelper2.removeChildDrawingOrderCallbackIfNecessary(view2);
            }
        }
    }

    public ItemTouchHelper(Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) callback);
            return;
        }
        this.mPendingCleanup = new ArrayList();
        this.mTmpPosition = new float[2];
        this.mSelected = null;
        this.mActivePointerId = -1;
        this.mActionState = 0;
        this.mRecoverAnimations = new ArrayList();
        this.mScrollRunnable = new Runnable() { // from class: com.tencent.widget.itemtouchhelper.ItemTouchHelper.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ItemTouchHelper.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
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
        this.mChildDrawingOrderCallback = null;
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        this.mOnItemTouchListener = new a();
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

    private void initGestureDetector() {
        if (this.mGestureDetector != null) {
            return;
        }
        this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), new ItemTouchHelperGestureListener());
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
        initGestureDetector();
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView);
            return;
        }
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

    boolean checkSelectForSwipe(int i3, MotionEvent motionEvent, int i16) {
        RecyclerView.ViewHolder findSwipedView;
        int absoluteMovementFlags;
        if (this.mSelected != null || i3 != 2 || this.mActionState == 2 || !this.mCallback.isItemViewSwipeEnabled() || this.mRecyclerView.getScrollState() == 1 || (findSwipedView = findSwipedView(motionEvent)) == null || (absoluteMovementFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, findSwipedView) & 65280) >> 8) == 0) {
            return false;
        }
        float x16 = motionEvent.getX(i16);
        float y16 = motionEvent.getY(i16);
        float f16 = x16 - this.mInitialTouchX;
        float f17 = y16 - this.mInitialTouchY;
        float abs = Math.abs(f16);
        float abs2 = Math.abs(f17);
        int i17 = this.mSlop;
        if (abs < i17 && abs2 < i17) {
            return false;
        }
        if (abs > abs2) {
            if (f16 < 0.0f && (absoluteMovementFlags & 4) == 0) {
                return false;
            }
            if (f16 > 0.0f && (absoluteMovementFlags & 8) == 0) {
                return false;
            }
        } else {
            if (f17 < 0.0f && (absoluteMovementFlags & 1) == 0) {
                return false;
            }
            if (f17 > 0.0f && (absoluteMovementFlags & 2) == 0) {
                return false;
            }
        }
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        this.mActivePointerId = motionEvent.getPointerId(0);
        select(findSwipedView, 1);
        return true;
    }

    int endRecoverAnimation(RecyclerView.ViewHolder viewHolder, boolean z16) {
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder == viewHolder) {
                recoverAnimation.mOverridden |= z16;
                if (!recoverAnimation.mEnded) {
                    recoverAnimation.cancel();
                }
                this.mRecoverAnimations.remove(size);
                return recoverAnimation.mAnimationType;
            }
        }
        return 0;
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

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, rect, view, recyclerView, state);
        } else {
            rect.setEmpty();
        }
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

    @Override // android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        }
    }

    public void onChildViewDetachedFromWindow(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            return;
        }
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

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f16;
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, canvas, recyclerView, state);
            return;
        }
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

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f16;
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, canvas, recyclerView, state);
            return;
        }
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

    void postDispatchSwipe(RecoverAnimation recoverAnimation, int i3) {
        this.mRecyclerView.post(new Runnable(recoverAnimation, i3) { // from class: com.tencent.widget.itemtouchhelper.ItemTouchHelper.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ RecoverAnimation f384784d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f384785e;

            {
                this.f384784d = recoverAnimation;
                this.f384785e = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ItemTouchHelper.this, recoverAnimation, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                RecyclerView recyclerView = ItemTouchHelper.this.mRecyclerView;
                if (recyclerView != null && recyclerView.isAttachedToWindow()) {
                    RecoverAnimation recoverAnimation2 = this.f384784d;
                    if (!recoverAnimation2.mOverridden && recoverAnimation2.mViewHolder.getAdapterPosition() != -1) {
                        RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.mRecyclerView.getItemAnimator();
                        if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !ItemTouchHelper.this.hasRunningRecoverAnim()) {
                            ItemTouchHelper.this.mCallback.onSwiped(this.f384784d.mViewHolder, this.f384785e);
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

    /* JADX WARN: Removed duplicated region for block: B:36:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void select(RecyclerView.ViewHolder viewHolder, int i3) {
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
            this.mOverdrawChild = viewHolder.itemView;
            addChildDrawingOrderCallback();
        }
        int i18 = (1 << ((i3 * 8) + 8)) - 1;
        RecyclerView.ViewHolder viewHolder2 = this.mSelected;
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
                b bVar = new b(viewHolder2, i16, i17, f17, f18, f16, signum, swipeIfNecessary, viewHolder2);
                bVar.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, i16, f16 - f17, signum - f18));
                this.mRecoverAnimations.add(bVar);
                bVar.start();
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

    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) viewHolder);
            return;
        }
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

    public void startSwipe(RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) viewHolder);
            return;
        }
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

    private void addChildDrawingOrderCallback() {
    }
}
