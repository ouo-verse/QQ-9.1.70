package com.tencent.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HorizontalListView extends android.widget.AdapterView<ListAdapter> {
    static IPatchRedirector $redirector_ = null;
    private static final String BUNDLE_ID_CURRENT_X = "BUNDLE_ID_CURRENT_X";
    private static final String BUNDLE_ID_PARENT_STATE = "BUNDLE_ID_PARENT_STATE";
    public static final boolean DEBUG;
    protected static final int INSERT_AT_END_OF_LIST = -1;
    protected static final int INSERT_AT_START_OF_LIST = 0;
    private static final int INVALID_POINTER = -1;
    public static final String TAG = "HorizontalListView";
    public static final int TAG_VIEW_TYPE;
    static final int TOUCH_MODE_DONE_WAITING = 2;
    static final int TOUCH_MODE_DOWN = 0;
    static final int TOUCH_MODE_FLING = 4;
    static final int TOUCH_MODE_OVERFLING = 6;
    static final int TOUCH_MODE_OVERSCROLL = 5;
    static final int TOUCH_MODE_REST = -1;
    static final int TOUCH_MODE_SCROLL = 3;
    static final int TOUCH_MODE_TAP = 1;
    public int MIN_SPACE;
    protected boolean isFromRightToLeft;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private DataSetObserver mAdapterDataObserver;
    private ContextMenu.ContextMenuInfo mContextMenuInfo;
    protected int mCurrentScrollState;
    protected int mCurrentX;
    protected int mCurrentlySelectedAdapterIndex;
    protected boolean mDataChanged;
    private Runnable mDelayedLayout;
    protected int mDisplayOffset;
    private Drawable mDivider;
    protected int mDividerWidth;
    private Runnable mFlingRunnable;
    private boolean mHasNotifiedRunningLowOnData;
    private int mHeight;
    private int mHeightMeasureSpec;
    private boolean mIsBeingDragged;
    private int mLastAccessibilityScrollEventFromIndex;
    private int mLastAccessibilityScrollEventToIndex;
    private float mLastMotionX;
    protected int mLeftViewAdapterIndex;
    protected int mMaxX;
    private int mMaximumVelocity;
    protected int mMinX;
    private int mMinimumVelocity;
    private int mMotionPosition;
    private int mMotionX;
    private int mMotionY;
    protected int mNextX;
    private OnItemScrollEventListener mOnItemScrollEventListener;
    private OnScrollLinstener mOnScrollLinstener;
    private OnScrollStateChangedListener mOnScrollStateChangedListener;
    private CheckForLongPress mPendingCheckForLongPress;
    private Runnable mPendingCheckForTap;
    private PerformClick mPerformClick;
    Runnable mPositionScrollAfterLayout;
    PositionScroller mPositionScroller;
    private Rect mRect;
    private RecycleListener mRecycleListener;
    private List<Queue<View>> mRemovedViewsCache;
    private Integer mRestoreX;
    protected int mRightViewAdapterIndex;
    private RunningOutOfDataListener mRunningOutOfDataListener;
    private int mRunningOutOfDataThreshold;
    protected OverScroller mScroller;
    protected boolean mStayDisplayOffsetZero;
    private Rect mTouchFrame;
    int mTouchMode;
    private Runnable mTouchModeReset;
    protected int mTouchSlop;
    private boolean mTransTouchState2Parent;
    private VelocityTracker mVelocityTracker;
    private View mViewBeingTouched;
    private int mWidth;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class CheckForLongPress extends WindowRunnnable implements Runnable {
        static IPatchRedirector $redirector_;

        CheckForLongPress() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HorizontalListView.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (!HorizontalListView.this.needTtransTouchStateToParen()) {
                int i3 = HorizontalListView.this.mMotionPosition;
                HorizontalListView horizontalListView = HorizontalListView.this;
                View childAt = horizontalListView.getChildAt(i3 - horizontalListView.getFirstVisiblePosition());
                if (childAt != null) {
                    int i16 = HorizontalListView.this.mMotionPosition;
                    HorizontalListView horizontalListView2 = HorizontalListView.this;
                    long itemId = horizontalListView2.mAdapter.getItemId(horizontalListView2.mMotionPosition);
                    if (sameWindow()) {
                        HorizontalListView horizontalListView3 = HorizontalListView.this;
                        if (!horizontalListView3.mDataChanged) {
                            z16 = horizontalListView3.performLongPress(childAt, i16, itemId);
                        }
                    }
                }
                z16 = false;
            } else {
                z16 = ((View) HorizontalListView.this.getParent()).performLongClick();
            }
            if (z16) {
                HorizontalListView horizontalListView4 = HorizontalListView.this;
                horizontalListView4.mTouchMode = -1;
                horizontalListView4.unpressTouchedView();
                return;
            }
            HorizontalListView.this.mTouchMode = 2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    final class CheckForTap implements Runnable {
        static IPatchRedirector $redirector_;

        CheckForTap() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HorizontalListView.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            HorizontalListView horizontalListView = HorizontalListView.this;
            if (horizontalListView.mTouchMode == 0) {
                horizontalListView.mTouchMode = 1;
                if (horizontalListView.needTtransTouchStateToParen()) {
                    childAt = (View) HorizontalListView.this.getParent();
                } else {
                    HorizontalListView horizontalListView2 = HorizontalListView.this;
                    childAt = horizontalListView2.getChildAt(horizontalListView2.mMotionPosition - HorizontalListView.this.getFirstVisiblePosition());
                }
                if (HorizontalListView.this.needTtransTouchStateToParen() || (childAt != null && !childAt.hasFocusable())) {
                    HorizontalListView horizontalListView3 = HorizontalListView.this;
                    if (!horizontalListView3.mDataChanged || horizontalListView3.needTtransTouchStateToParen()) {
                        HorizontalListView.this.updateTouchedView(childAt);
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        if (!HorizontalListView.this.needTtransTouchStateToParen()) {
                            childAt = HorizontalListView.this;
                        }
                        if (childAt.isLongClickable()) {
                            if (HorizontalListView.this.mPendingCheckForLongPress == null) {
                                HorizontalListView horizontalListView4 = HorizontalListView.this;
                                horizontalListView4.mPendingCheckForLongPress = new CheckForLongPress();
                            }
                            HorizontalListView.this.mPendingCheckForLongPress.rememberWindowAttachCount();
                            HorizontalListView horizontalListView5 = HorizontalListView.this;
                            horizontalListView5.postDelayed(horizontalListView5.mPendingCheckForLongPress, longPressTimeout);
                            return;
                        }
                        HorizontalListView.this.mTouchMode = 2;
                        return;
                    }
                    HorizontalListView.this.mTouchMode = 2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class HorizontalAdapterDataObserver extends DataSetObserver {
        static IPatchRedirector $redirector_;

        HorizontalAdapterDataObserver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HorizontalListView.this);
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            HorizontalListView horizontalListView = HorizontalListView.this;
            horizontalListView.mDataChanged = true;
            horizontalListView.mHasNotifiedRunningLowOnData = false;
            HorizontalListView.this.unpressTouchedView();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                HorizontalListView.this.mHasNotifiedRunningLowOnData = false;
                HorizontalListView.this.unpressTouchedView();
                HorizontalListView.this.reset(true);
                HorizontalListView.this.invalidate();
                HorizontalListView.this.requestLayout();
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnItemScrollEventListener {
        void onItemScrollNonVisible(int i3, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnScrollLinstener {
        void onScroll();
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnScrollStateChangedListener {
        public static final int SCROLL_STATE_FLING = 4099;
        public static final int SCROLL_STATE_IDLE = 4097;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 4098;

        void onScrollStateChanged(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class PerformClick extends WindowRunnnable implements Runnable {
        static IPatchRedirector $redirector_;
        int mClickMotionPosition;

        PerformClick() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HorizontalListView.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (HorizontalListView.this.needTtransTouchStateToParen()) {
                ((View) HorizontalListView.this.getParent()).performClick();
                return;
            }
            HorizontalListView horizontalListView = HorizontalListView.this;
            if (horizontalListView.mDataChanged) {
                return;
            }
            ListAdapter listAdapter = horizontalListView.mAdapter;
            int i3 = this.mClickMotionPosition;
            if (listAdapter != null && i3 != -1 && i3 < listAdapter.getCount() && sameWindow()) {
                HorizontalListView horizontalListView2 = HorizontalListView.this;
                View childAt = horizontalListView2.getChildAt(i3 - horizontalListView2.getFirstVisiblePosition());
                if (childAt != null) {
                    HorizontalListView.this.performItemClick(childAt, i3, listAdapter.getItemId(i3));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class PositionScroller implements Runnable {
        static IPatchRedirector $redirector_ = null;
        private static final int MOVE_DOWN_BOUND = 3;
        private static final int MOVE_DOWN_POS = 1;
        private static final int MOVE_OFFSET = 5;
        private static final int MOVE_UP_BOUND = 4;
        private static final int MOVE_UP_POS = 2;
        private static final int SCROLL_DURATION = 2000;
        private int mBoundPos;
        private final int mExtraScroll;
        private int mLastSeenPos;
        private int mMode;
        private int mOffsetFromStart;
        private int mScrollDuration;
        private int mTargetPos;

        PositionScroller() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HorizontalListView.this);
            } else {
                this.mExtraScroll = ViewConfiguration.get(HorizontalListView.this.getContext()).getScaledFadingEdgeLength();
            }
        }

        @TargetApi(16)
        void postOnAnimation(Runnable runnable) {
            try {
                HorizontalListView.this.postOnAnimation(runnable);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            int i16;
            int width;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            HorizontalListView.this.getHeight();
            HorizontalListView horizontalListView = HorizontalListView.this;
            if (!horizontalListView.isFromRightToLeft) {
                i3 = horizontalListView.mLeftViewAdapterIndex;
            } else {
                i3 = horizontalListView.mRightViewAdapterIndex;
            }
            if (this.mMode == 5) {
                if (this.mLastSeenPos == i3) {
                    postOnAnimation(this);
                    return;
                }
                this.mLastSeenPos = i3;
                int childCount = horizontalListView.getChildCount();
                int i17 = this.mTargetPos;
                int i18 = 1;
                int i19 = (i3 + childCount) - 1;
                if (i17 < i3) {
                    i16 = (i3 - i17) + 1;
                } else if (i17 > i19) {
                    i16 = i17 - i19;
                } else {
                    i16 = 0;
                }
                float min = Math.min(Math.abs(i16 / childCount), 1.0f);
                HorizontalListView horizontalListView2 = HorizontalListView.this;
                if (horizontalListView2.isFromRightToLeft) {
                    i18 = -1;
                }
                float f16 = min * i18;
                if (i17 < i3) {
                    HorizontalListView.this.smoothScrollBy((int) (horizontalListView2.getWidth() * f16), (int) (this.mScrollDuration * Math.abs(f16)));
                    postOnAnimation(this);
                    return;
                }
                if (i17 > i19) {
                    HorizontalListView.this.smoothScrollBy((int) ((-horizontalListView2.getWidth()) * f16), (int) (this.mScrollDuration * Math.abs(f16)));
                    postOnAnimation(this);
                    return;
                }
                View childAt = horizontalListView2.getChildAt(i17 - i3);
                HorizontalListView horizontalListView3 = HorizontalListView.this;
                if (!horizontalListView3.isFromRightToLeft) {
                    width = -childAt.getLeft();
                } else {
                    width = horizontalListView3.getWidth() - childAt.getRight();
                }
                HorizontalListView.this.smoothScrollBy(width - this.mOffsetFromStart, (int) (this.mScrollDuration * (Math.abs(r0) / HorizontalListView.this.getWidth())));
            }
        }

        void scrollToVisible(int i3, int i16) {
            scrollToVisible(i3, 0, i16);
        }

        void start(int i3) {
            start(i3, 0, 2000);
        }

        void startWithOffset(int i3, int i16, int i17) {
            int paddingRight;
            int i18;
            int width;
            int i19;
            stop();
            HorizontalListView horizontalListView = HorizontalListView.this;
            if (horizontalListView.mDataChanged) {
                horizontalListView.mPositionScrollAfterLayout = new Runnable(i3, i16, i17) { // from class: com.tencent.widget.HorizontalListView.PositionScroller.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f384603d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f384604e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ int f384605f;

                    {
                        this.f384603d = i3;
                        this.f384604e = i16;
                        this.f384605f = i17;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, PositionScroller.this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            PositionScroller.this.startWithOffset(this.f384603d, this.f384604e, this.f384605f);
                        }
                    }
                };
                return;
            }
            int childCount = horizontalListView.getChildCount();
            if (childCount == 0) {
                return;
            }
            HorizontalListView horizontalListView2 = HorizontalListView.this;
            if (!horizontalListView2.isFromRightToLeft) {
                paddingRight = horizontalListView2.getPaddingLeft();
            } else {
                paddingRight = horizontalListView2.getPaddingRight();
            }
            int i26 = i16 + paddingRight;
            int max = Math.max(0, Math.min(HorizontalListView.this.mAdapter.getCount() - 1, i3));
            this.mTargetPos = max;
            this.mOffsetFromStart = i26;
            this.mBoundPos = -1;
            this.mLastSeenPos = -1;
            this.mMode = 5;
            HorizontalListView horizontalListView3 = HorizontalListView.this;
            if (!horizontalListView3.isFromRightToLeft) {
                i18 = horizontalListView3.mLeftViewAdapterIndex;
            } else {
                i18 = horizontalListView3.mRightViewAdapterIndex;
            }
            int i27 = (i18 + childCount) - 1;
            if (max < i18) {
                i19 = i18 - max;
            } else if (max > i27) {
                i19 = max - i27;
            } else {
                View childAt = horizontalListView3.getChildAt(max - i18);
                HorizontalListView horizontalListView4 = HorizontalListView.this;
                if (!horizontalListView4.isFromRightToLeft) {
                    width = -childAt.getLeft();
                } else {
                    width = horizontalListView4.getWidth() - childAt.getRight();
                }
                HorizontalListView.this.smoothScrollBy(width - i26, i17);
                return;
            }
            float f16 = i19 / childCount;
            if (f16 >= 1.0f) {
                i17 = (int) (i17 / f16);
            }
            this.mScrollDuration = i17;
            this.mLastSeenPos = -1;
            postOnAnimation(this);
        }

        void stop() {
            HorizontalListView.this.removeCallbacks(this);
        }

        void scrollToVisible(int i3, int i16, int i17) {
            int left;
            HorizontalListView horizontalListView = HorizontalListView.this;
            int i18 = horizontalListView.mLeftViewAdapterIndex;
            int childCount = (horizontalListView.getChildCount() + i18) - 1;
            View childAt = HorizontalListView.this.getChildAt(0);
            if (i3 >= i18 && i3 <= childCount) {
                left = HorizontalListView.this.getChildAt(i3 - i18).getLeft() - Math.abs(childAt.getLeft());
            } else {
                left = ((i3 - i18) * (HorizontalListView.this.getChildAt(1).getLeft() - childAt.getLeft())) + childAt.getLeft();
            }
            if (left == 0) {
                return;
            }
            HorizontalListView.this.smoothScrollBy(-(left + i16), i17);
        }

        void start(int i3, int i16) {
            start(i3, i16, 2000);
        }

        void start(int i3, int i16, int i17) {
            int i18;
            stop();
            HorizontalListView horizontalListView = HorizontalListView.this;
            if (horizontalListView.mDataChanged) {
                horizontalListView.mPositionScrollAfterLayout = new Runnable(i3, i16) { // from class: com.tencent.widget.HorizontalListView.PositionScroller.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f384600d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f384601e;

                    {
                        this.f384600d = i3;
                        this.f384601e = i16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, PositionScroller.this, Integer.valueOf(i3), Integer.valueOf(i16));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            PositionScroller.this.start(this.f384600d, this.f384601e);
                        }
                    }
                };
                return;
            }
            int childCount = horizontalListView.getChildCount();
            if (childCount == 0) {
                return;
            }
            HorizontalListView horizontalListView2 = HorizontalListView.this;
            int i19 = !horizontalListView2.isFromRightToLeft ? horizontalListView2.mLeftViewAdapterIndex : horizontalListView2.mRightViewAdapterIndex;
            int i26 = (childCount + i19) - 1;
            int max = Math.max(0, Math.min(horizontalListView2.mAdapter.getCount() - 1, i3));
            if (max < i19) {
                i18 = i19 - max;
            } else {
                if (max <= i26) {
                    scrollToVisible(max, i17);
                    return;
                }
                i18 = max - i26;
            }
            int i27 = i18 + 1;
            if (i27 > 0) {
                this.mScrollDuration = i17 * (i27 / (i26 - i19));
            } else {
                this.mScrollDuration = i17;
            }
            this.mTargetPos = max;
            scrollToVisible(max, i16, this.mScrollDuration);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface RecycleListener {
        void onRecycle(View view);

        void onViewRecycled(View view);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface RunningOutOfDataListener {
        void onRunningOutOfData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class WindowRunnnable {
        static IPatchRedirector $redirector_;
        private int mOriginalAttachCount;

        WindowRunnnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HorizontalListView.this);
            }
        }

        public void rememberWindowAttachCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.mOriginalAttachCount = HorizontalListView.this.getWindowAttachCount();
            }
        }

        public boolean sameWindow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (HorizontalListView.this.hasWindowFocus() && HorizontalListView.this.getWindowAttachCount() == this.mOriginalAttachCount) {
                return true;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40326);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 74)) {
            redirector.redirect((short) 74);
        } else {
            DEBUG = false;
            TAG_VIEW_TYPE = R.string.f170384pb;
        }
    }

    public HorizontalListView(Context context) {
        this(context, null, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
    }

    private void checkSpringback() {
        if (DEBUG) {
            log("checkSpringback", Integer.valueOf(this.mTouchMode));
        }
        if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new Runnable() { // from class: com.tencent.widget.HorizontalListView.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) HorizontalListView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    HorizontalListView horizontalListView = HorizontalListView.this;
                    if (horizontalListView.mTouchMode != -1 || horizontalListView.mActivePointerId != -1 || !HorizontalListView.this.mScroller.isFinished()) {
                        return;
                    }
                    boolean z16 = HorizontalListView.DEBUG;
                    if (z16) {
                        HorizontalListView horizontalListView2 = HorizontalListView.this;
                        horizontalListView2.log("mFlingRunnable", Integer.valueOf(horizontalListView2.mTouchMode));
                    }
                    HorizontalListView horizontalListView3 = HorizontalListView.this;
                    OverScroller overScroller = horizontalListView3.mScroller;
                    int scrollX = horizontalListView3.getScrollX();
                    HorizontalListView horizontalListView4 = HorizontalListView.this;
                    int i3 = scrollX + horizontalListView4.mNextX;
                    int scrollY = horizontalListView4.getScrollY();
                    int i16 = HorizontalListView.this.mNextX;
                    if (overScroller.springBack(i3, scrollY, i16, i16, 0, 0)) {
                        HorizontalListView horizontalListView5 = HorizontalListView.this;
                        horizontalListView5.mTouchMode = 6;
                        if (z16) {
                            horizontalListView5.log("mFlingRunnable", "TOUCH_MODE_OVERFLING");
                        }
                        HorizontalListView.this.setCurrentScrollState(4099);
                        HorizontalListView.this.invalidate();
                    }
                }
            };
        }
        removeCallbacks(this.mFlingRunnable);
        getHandler().post(this.mFlingRunnable);
    }

    private void determineIfLowOnData() {
        ListAdapter listAdapter;
        if (this.mRunningOutOfDataListener != null && (listAdapter = this.mAdapter) != null && listAdapter.getCount() - (this.mRightViewAdapterIndex + 1) < this.mRunningOutOfDataThreshold && !this.mHasNotifiedRunningLowOnData) {
            this.mHasNotifiedRunningLowOnData = true;
            this.mRunningOutOfDataListener.onRunningOutOfData();
        }
    }

    private void drawDivider(Canvas canvas, Rect rect) {
        Drawable drawable = this.mDivider;
        if (drawable != null) {
            drawable.setBounds(rect);
            this.mDivider.draw(canvas);
        }
    }

    private void drawDividers(Canvas canvas) {
        int childCount = getChildCount();
        Rect rect = this.mRect;
        rect.top = getPaddingTop();
        Rect rect2 = this.mRect;
        rect2.bottom = rect2.top + getRenderHeight();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (i3 != childCount - 1 || !isLastItemInAdapter(this.mRightViewAdapterIndex)) {
                View childAt = getChildAt(i3);
                rect.left = childAt.getRight();
                rect.right = childAt.getRight() + this.mDividerWidth;
                if (rect.left < getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight()) {
                    rect.right = getWidth() - getPaddingRight();
                }
                drawDivider(canvas, rect);
                if (i3 == 0 && childAt.getLeft() > getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                    rect.right = childAt.getLeft();
                    drawDivider(canvas, rect);
                }
            }
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
    }

    private ViewGroup.LayoutParams getLayoutParams(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return new ViewGroup.LayoutParams(-2, -1);
        }
        return layoutParams;
    }

    private int getRenderHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getRenderWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private boolean inChild(int i3, int i16) {
        View childAt;
        View childAt2;
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollX = getScrollX();
        if (this.isFromRightToLeft) {
            childAt = getChildAt(getChildCount() - 1);
        } else {
            childAt = getChildAt(0);
        }
        if (this.isFromRightToLeft) {
            childAt2 = getChildAt(0);
        } else {
            childAt2 = getChildAt(getChildCount() - 1);
        }
        if (i3 < childAt.getLeft() - scrollX || i16 < childAt.getTop() || i3 >= childAt2.getRight() - scrollX || i16 >= childAt2.getBottom()) {
            return false;
        }
        return true;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void initializeRecycledViewCache(int i3) {
        this.mRemovedViewsCache.clear();
        for (int i16 = 0; i16 < i3; i16++) {
            this.mRemovedViewsCache.add(new LinkedList());
        }
    }

    private boolean isItemViewTypeValid(int i3) {
        if (i3 >= 0 && i3 < this.mRemovedViewsCache.size()) {
            return true;
        }
        return false;
    }

    private void markViewType(View view, int i3) {
        int i16;
        try {
            i16 = this.mAdapter.getItemViewType(i3);
        } catch (Throwable th5) {
            th5.printStackTrace();
            i16 = -1;
        }
        if (view != null && isItemViewTypeValid(i16)) {
            view.setTag(TAG_VIEW_TYPE, Integer.valueOf(i16));
        }
    }

    private void measureChild(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = getLayoutParams(view);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, getPaddingTop() + getPaddingBottom(), layoutParams.height);
        int i3 = layoutParams.width;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    private int measureWidthOfChildren(int i3, int i16, int i17, int i18) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return getPaddingLeft() + getPaddingRight();
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i19 = this.mDividerWidth;
        if (i19 <= 0 || this.mDivider == null) {
            i19 = 0;
        }
        if (i16 == -1) {
            i16 = listAdapter.getCount() - 1;
        }
        while (i3 <= i16) {
            View obtainView = obtainView(i3);
            if (obtainView != null) {
                measureChild(obtainView);
                if (i3 > 0) {
                    paddingLeft += i19;
                }
                paddingLeft += obtainView.getMeasuredWidth();
                recycleView(i3, obtainView);
                if (paddingLeft > i17) {
                    return i17;
                }
            } else if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "measureWidthOfChildren obtainView is null");
            }
            i3++;
        }
        return paddingLeft;
    }

    private View obtainView(int i3) {
        View recycledView = getRecycledView(i3);
        setTag(R.id.d8_, Boolean.TRUE);
        View view = this.mAdapter.getView(i3, recycledView, this);
        markViewType(view, i3);
        if (recycledView != null && view != recycledView) {
            recycleView(i3, recycledView);
        }
        if (view != null) {
            setItemViewLayoutParams(view, i3);
        }
        return view;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i3;
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            if (action == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.mLastMotionX = motionEvent.getX(i3);
            this.mActivePointerId = motionEvent.getPointerId(i3);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
            this.mMotionX = (int) motionEvent.getX(i3);
            this.mMotionY = (int) motionEvent.getY(i3);
        }
    }

    private void onSizeChange() {
        setLayoutDirection(this.isFromRightToLeft);
    }

    private void reMeasureChilds() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            measureChild(getChildAt(i3));
        }
    }

    private void recycleBeforeRemoveAll() {
        int lastVisiblePosition = getLastVisiblePosition();
        for (int firstVisiblePosition = getFirstVisiblePosition(); firstVisiblePosition >= 0 && firstVisiblePosition <= lastVisiblePosition; firstVisiblePosition++) {
            View child = getChild(firstVisiblePosition);
            if (child != null) {
                RecycleListener recycleListener = this.mRecycleListener;
                if (recycleListener != null) {
                    recycleListener.onRecycle(child);
                }
                recycleView(firstVisiblePosition, child);
            }
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private int reviseOverScrollByTouch(int i3, int i16) {
        int scrollX = getScrollX();
        if (getScrollX() > 0 && getScrollX() > i16) {
            scrollX = getScrollX() - i16;
        }
        int width = getWidth();
        if (i3 * scrollX < 0) {
            return i3;
        }
        if (width == 0) {
            return i3;
        }
        return (((width - Math.abs(scrollX)) * i3) / width) / 2;
    }

    private void scrollIfNeeded(float f16, int i3) {
        int i16;
        int i17 = i3;
        int i18 = this.mMaxX;
        int i19 = this.mMinX;
        int overScrollMode = getOverScrollMode();
        boolean z16 = true;
        if (overScrollMode != 0 && (overScrollMode != 1 || i18 <= 0)) {
            z16 = false;
        }
        int scrollX = getScrollX();
        int i26 = this.mNextX;
        int i27 = scrollX + i26;
        int i28 = i27 + i17;
        if (i27 < i19 || i27 > i18) {
            i17 = reviseOverScrollByTouch(i17, i18);
        }
        if (z16 && (i28 < i19 || i28 > i18)) {
            int scrollX2 = i28 - getScrollX();
            if (i28 < i19) {
                i16 = scrollX2 - i19;
            } else {
                i16 = scrollX2 - i18;
            }
            overScrollBy(i16, 0, getScrollX(), 0, 0, 0, getWidth() - this.MIN_SPACE, 0, true);
        } else {
            if (i27 != i26) {
                scrollTo(0, 0);
            }
            this.mNextX += i17;
        }
        if (i28 < i19) {
            this.mNextX = i19;
        } else if (i28 > i18) {
            this.mNextX = i18;
        }
        if (i26 != this.mNextX) {
            unpressTouchedView();
            requestLayout();
        }
        this.mLastMotionX = f16;
    }

    private void setItemViewLayoutParams(View view, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unpressTouchedView() {
        View view = this.mViewBeingTouched;
        if (view != null) {
            view.setPressed(false);
            this.mViewBeingTouched = null;
        }
        setPressed(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTouchedView(View view) {
        if (this.mViewBeingTouched != view) {
            unpressTouchedView();
            this.mViewBeingTouched = view;
        }
        View view2 = this.mViewBeingTouched;
        if (view2 != null) {
            view2.setPressed(true);
        }
        setPressed(true);
    }

    protected void addAndMeasureChild(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) view, i3);
        } else {
            addViewInLayout(view, i3, getLayoutParams(view), true);
            measureChild(view);
        }
    }

    protected boolean checkScrollToChild() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this)).booleanValue();
        }
        if (!this.mStayDisplayOffsetZero) {
            return false;
        }
        if (this.isFromRightToLeft ? Math.abs(this.mCurrentX - this.mMinX) < this.mTouchSlop : Math.abs(this.mCurrentX - this.mMaxX) < this.mTouchSlop) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            int i3 = this.mMaxX;
            this.mCurrentX = i3;
            this.mNextX = i3;
            invalidate();
            return false;
        }
        int i16 = this.mTouchSlop;
        int i17 = this.mDisplayOffset;
        if (i16 + i17 >= 0) {
            this.mNextX += i17;
            invalidate();
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        int i18 = this.mNextX + this.mDisplayOffset;
        int measuredWidth = childAt.getMeasuredWidth();
        if (this.mDisplayOffset <= (-((measuredWidth / 2) + 0.5d))) {
            i18 += measuredWidth;
        }
        if (!this.mScroller.springBack(getScrollX() + this.mNextX, 0, i18, i18, 0, 0)) {
            return false;
        }
        if (DEBUG) {
            log("checkScrollToChild", Integer.valueOf(this.mTouchMode), Integer.valueOf(i18));
        }
        invalidate();
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
            return;
        }
        boolean z18 = true;
        if (this.mScroller.computeScrollOffset()) {
            int scrollX = getScrollX() + this.mNextX;
            int currX = this.mScroller.getCurrX();
            int i3 = this.mNextX;
            if (DEBUG) {
                log("computeScroll", "MOVING", Integer.valueOf(scrollX), Integer.valueOf(currX));
            }
            if (scrollX != currX) {
                int i16 = this.mMaxX;
                int i17 = this.mMinX;
                int overScrollMode = getOverScrollMode();
                if (overScrollMode != 0 && (overScrollMode != 1 || i16 <= 0)) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (z17 && (currX < i17 || currX > i16)) {
                    int width = getWidth() - this.MIN_SPACE;
                    if ((currX >= i17 || currX >= (-width) || currX >= scrollX) && (i16 == Integer.MAX_VALUE || currX <= i16 + width || currX <= scrollX)) {
                        z18 = false;
                    }
                    if (z18) {
                        this.mScroller.abortAnimation();
                        OverScroller overScroller = this.mScroller;
                        int scrollX2 = this.mNextX + getScrollX();
                        int scrollY = getScrollY();
                        int i18 = this.mNextX;
                        overScroller.springBack(scrollX2, scrollY, i18, i18, 0, 0);
                    } else {
                        overScrollBy(currX - scrollX, 0, getScrollX(), getScrollY(), 0, 0, width, 0, false);
                    }
                } else {
                    if (scrollX != i3) {
                        scrollTo(0, 0);
                    }
                    this.mNextX += currX - scrollX;
                }
                if (currX < i17) {
                    this.mNextX = i17;
                } else if (currX > i16) {
                    this.mNextX = i16;
                }
            } else if (Math.abs(getScrollX()) < this.mTouchSlop) {
                this.mNextX = scrollX;
                scrollTo(0, 0);
            } else {
                checkSpringback();
            }
            if (i3 != this.mNextX) {
                unpressTouchedView();
                requestLayout();
            }
            awakenScrollBars();
            postInvalidate();
            return;
        }
        int scrollX3 = getScrollX();
        int i19 = this.mCurrentScrollState;
        if (i19 != 4099 && (i19 != 4097 || this.mMaxX != this.mNextX || scrollX3 == 0)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (DEBUG && QLog.isDevelopLevel()) {
            log("computeScroll", "over", Integer.valueOf(this.mCurrentScrollState), Boolean.valueOf(z16));
        }
        if (z16) {
            this.mTouchMode = -1;
            if (Math.abs(scrollX3) < this.mTouchSlop) {
                scrollTo(0, 0);
                setCurrentScrollState(4097);
            } else {
                checkSpringback();
            }
        }
    }

    ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i3, long j3) {
        return new AdapterView.AdapterContextMenuInfo(view, i3, j3);
    }

    protected boolean determineBorderMaxX() {
        View rightmostChild;
        View leftmostChild;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        if (this.isFromRightToLeft) {
            if (isLastItemInAdapter(this.mLeftViewAdapterIndex) && (leftmostChild = getLeftmostChild()) != null) {
                int i3 = this.mMinX;
                int left = this.mCurrentX + (leftmostChild.getLeft() - getPaddingLeft());
                this.mMinX = left;
                if (left > 0) {
                    this.mMinX = Integer.MIN_VALUE;
                }
                if (this.mMinX != i3) {
                    return true;
                }
            }
        } else if (isLastItemInAdapter(this.mRightViewAdapterIndex) && (rightmostChild = getRightmostChild()) != null) {
            int i16 = this.mMaxX;
            int right = (this.mCurrentX + (rightmostChild.getRight() - getPaddingLeft())) - getRenderWidth();
            this.mMaxX = right;
            if (right < 0) {
                this.mMaxX = 0;
            }
            if (this.mMaxX != i16) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) canvas);
        } else {
            try {
                super.dispatchDraw(canvas);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, z16);
        }
    }

    protected void fillList(int i3) {
        int i16;
        boolean z16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3);
            return;
        }
        int i18 = 0;
        if (this.isFromRightToLeft) {
            View leftmostChild = getLeftmostChild();
            if (leftmostChild != null) {
                i17 = leftmostChild.getLeft();
                z16 = false;
            } else {
                z16 = true;
                i17 = 0;
            }
            fillListLeft(i17, i3, z16);
            View rightmostChild = getRightmostChild();
            if (rightmostChild != null) {
                i18 = rightmostChild.getRight();
            }
            fillListRight(i18, i3);
            return;
        }
        View rightmostChild2 = getRightmostChild();
        if (rightmostChild2 != null) {
            i16 = rightmostChild2.getRight();
        } else {
            i16 = 0;
        }
        fillListRight(i16, i3);
        View leftmostChild2 = getLeftmostChild();
        if (leftmostChild2 != null) {
            i18 = leftmostChild2.getLeft();
        }
        fillListLeft(i18, i3);
    }

    protected void fillListLeft(int i3, int i16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        while ((i3 + i16) - this.mDividerWidth > 0 && (i17 = this.mLeftViewAdapterIndex) >= 1) {
            int i18 = i17 - 1;
            this.mLeftViewAdapterIndex = i18;
            View obtainView = obtainView(i18, false);
            if (obtainView == null) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "fillListLeft obtainView is null");
                }
            } else {
                addAndMeasureChild(obtainView, 0);
                i3 -= this.mLeftViewAdapterIndex == 0 ? obtainView.getMeasuredWidth() : this.mDividerWidth + obtainView.getMeasuredWidth();
                this.mDisplayOffset -= i3 + i16 == 0 ? obtainView.getMeasuredWidth() : obtainView.getMeasuredWidth() + this.mDividerWidth;
                if (DEBUG) {
                    log("fillListLeft", "mLeftViewAdapterIndex", Integer.valueOf(this.mLeftViewAdapterIndex));
                }
            }
        }
    }

    protected void fillListRight(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int measuredWidth;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.isFromRightToLeft) {
            while (i3 + i16 + this.mDividerWidth < getWidth() && (i18 = this.mRightViewAdapterIndex) >= 1) {
                int i26 = i18 - 1;
                this.mRightViewAdapterIndex = i26;
                View view = this.mAdapter.getView(i26, getRecycledView(i26), this);
                addAndMeasureChild(view, 0);
                if (this.mRightViewAdapterIndex == 0) {
                    i19 = 0;
                } else {
                    i19 = this.mDividerWidth;
                }
                i3 += i19 + view.getMeasuredWidth();
                int i27 = this.mDisplayOffset;
                if (getWidth() - (i3 + i16) == 0) {
                    measuredWidth = view.getMeasuredWidth();
                } else {
                    measuredWidth = view.getMeasuredWidth() + this.mDividerWidth;
                }
                this.mDisplayOffset = i27 - measuredWidth;
            }
            return;
        }
        while (i3 + i16 + this.mDividerWidth < getWidth() && this.mRightViewAdapterIndex + 1 < this.mAdapter.getCount()) {
            int i28 = this.mRightViewAdapterIndex + 1;
            this.mRightViewAdapterIndex = i28;
            if (this.mLeftViewAdapterIndex < 0) {
                this.mLeftViewAdapterIndex = i28;
            }
            View obtainView = obtainView(i28, false);
            if (obtainView == null) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "fillListRight obtainView is null");
                }
            } else {
                addAndMeasureChild(obtainView, -1);
                if (this.mRightViewAdapterIndex == 0) {
                    i17 = 0;
                } else {
                    i17 = this.mDividerWidth;
                }
                i3 += i17 + obtainView.getMeasuredWidth();
                determineIfLowOnData();
                if (DEBUG) {
                    log("fillListRight", "mRightViewAdapterIndex", Integer.valueOf(this.mRightViewAdapterIndex));
                }
            }
        }
    }

    int findMotionColumn(int i3) {
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i16 = childCount - 1; i16 >= 0; i16--) {
                if (i3 >= getChildAt(i16).getLeft()) {
                    return getFirstVisiblePosition() + i16;
                }
            }
            return -1;
        }
        return -1;
    }

    public void fling(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, i3);
            return;
        }
        this.mTouchMode = 6;
        setCurrentScrollState(4099);
        if (getChildCount() > 0) {
            this.mScroller.fling(getScrollX() + this.mNextX, 0, getFlingVelocity(i3), 0, this.mMinX, this.mMaxX, 0, 0, Math.max(0, getWidth() / 2), 0);
            requestLayout();
        }
    }

    public View getChild(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (View) iPatchRedirector.redirect((short) 40, (Object) this, i3);
        }
        int i16 = this.mLeftViewAdapterIndex;
        if (i3 >= i16 && i3 <= this.mRightViewAdapterIndex) {
            return getChildAt(i3 - i16);
        }
        return null;
    }

    @Override // android.view.View
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (ContextMenu.ContextMenuInfo) iPatchRedirector.redirect((short) 57, (Object) this);
        }
        return this.mContextMenuInfo;
    }

    public int getCurrentX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mCurrentX;
    }

    @Override // android.widget.AdapterView
    public int getFirstVisiblePosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Integer) iPatchRedirector.redirect((short) 42, (Object) this)).intValue();
        }
        if (this.isFromRightToLeft) {
            return this.mRightViewAdapterIndex;
        }
        return this.mLeftViewAdapterIndex;
    }

    protected int getFlingVelocity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Integer) iPatchRedirector.redirect((short) 53, (Object) this, i3)).intValue();
        }
        return i3;
    }

    @Override // android.widget.AdapterView
    public int getLastVisiblePosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Integer) iPatchRedirector.redirect((short) 43, (Object) this)).intValue();
        }
        if (this.isFromRightToLeft) {
            return this.mLeftViewAdapterIndex;
        }
        return this.mRightViewAdapterIndex;
    }

    protected View getLeftmostChild() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (View) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        if (this.isFromRightToLeft) {
            i3 = getChildCount() - 1;
        } else {
            i3 = 0;
        }
        return getChildAt(i3);
    }

    @Override // android.view.View
    @TargetApi(9)
    public int getOverScrollMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return super.getOverScrollMode();
    }

    protected View getRecycledView(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (View) iPatchRedirector.redirect((short) 26, (Object) this, i3);
        }
        try {
            i16 = this.mAdapter.getItemViewType(i3);
        } catch (Throwable th5) {
            th5.printStackTrace();
            i16 = -1;
        }
        if (isItemViewTypeValid(i16)) {
            return this.mRemovedViewsCache.get(i16).poll();
        }
        return null;
    }

    protected View getRightmostChild() {
        int childCount;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (View) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        if (this.isFromRightToLeft) {
            childCount = 0;
        } else {
            childCount = getChildCount() - 1;
        }
        return getChildAt(childCount);
    }

    protected float getScrollerFriction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Float) iPatchRedirector.redirect((short) 17, (Object) this)).floatValue();
        }
        return 0.005f;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (View) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return getChild(this.mCurrentlySelectedAdapterIndex);
    }

    @TargetApi(9)
    protected void initView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            initView(false);
        } else {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    protected boolean isLastItemInAdapter(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this, i3)).booleanValue();
        }
        if (i3 == this.mAdapter.getCount() - 1) {
            return true;
        }
        return false;
    }

    public void log(String str, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, (Object) str, (Object) objArr);
            return;
        }
        if (DEBUG && QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder(200);
            sb5.setLength(0);
            sb5.append(str);
            sb5.append(", mDisplayOffset = ");
            sb5.append(this.mDisplayOffset);
            sb5.append(", mMaxX = ");
            sb5.append(this.mMaxX);
            sb5.append(", mMinX = ");
            sb5.append(this.mMinX);
            sb5.append(", mCurrentX = ");
            sb5.append(this.mCurrentX);
            sb5.append(", mNextX = ");
            sb5.append(this.mNextX);
            sb5.append(", mScrollX = ");
            sb5.append(getScrollX());
            sb5.append(", mLeftViewAdapterIndex= ");
            sb5.append(this.mLeftViewAdapterIndex);
            sb5.append(", mRightViewAdapterIndex = ");
            sb5.append(this.mRightViewAdapterIndex);
            if (objArr != null && objArr.length > 0) {
                for (Object obj : objArr) {
                    sb5.append(",");
                    sb5.append(obj);
                }
            }
            QLog.i(TAG, 4, sb5.toString());
        }
    }

    public boolean needTtransTouchStateToParen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (this.mTransTouchState2Parent && (getParent() instanceof View)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) canvas);
            return;
        }
        try {
            super.onDraw(canvas);
            drawDividers(canvas);
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    @TargetApi(16)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int count;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, (Object) accessibilityNodeInfo);
            return;
        }
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(android.widget.AbsListView.class.getName());
        if (isEnabled()) {
            if (getFirstVisiblePosition() > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter == null) {
                count = 0;
            } else {
                count = listAdapter.getCount();
            }
            if (getLastVisiblePosition() < count - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        int i3 = action & 255;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 6) {
                            onSecondaryPointerUp(motionEvent);
                        }
                    }
                } else {
                    int i16 = this.mActivePointerId;
                    if (i16 != -1) {
                        float x16 = motionEvent.getX(motionEvent.findPointerIndex(i16));
                        if (((int) Math.abs(x16 - this.mLastMotionX)) > this.mTouchSlop) {
                            this.mIsBeingDragged = true;
                            this.mLastMotionX = x16;
                            initVelocityTrackerIfNotExists();
                            this.mVelocityTracker.addMovement(motionEvent);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            recycleVelocityTracker();
            OverScroller overScroller = this.mScroller;
            int scrollX = getScrollX() + this.mNextX;
            int scrollY = getScrollY();
            int i17 = this.mNextX;
            if (overScroller.springBack(scrollX, scrollY, i17, i17, 0, 0)) {
                this.mTouchMode = 6;
                setCurrentScrollState(4099);
                invalidate();
            } else {
                this.mTouchMode = -1;
                setCurrentScrollState(4097);
            }
            unpressTouchedView();
        } else {
            float x17 = motionEvent.getX();
            if (!inChild((int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.mIsBeingDragged = false;
                recycleVelocityTracker();
            } else {
                this.mLastMotionX = x17;
                this.mActivePointerId = motionEvent.getPointerId(0);
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                this.mIsBeingDragged = !this.mScroller.isFinished();
                setCurrentScrollState(4097);
            }
        }
        if (this.mIsBeingDragged || super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    @SuppressLint({"WrongCall"})
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.mAdapter == null) {
            return;
        }
        invalidate();
        if (this.mDataChanged) {
            recycleBeforeRemoveAll();
            int i19 = this.mCurrentX;
            initView(this.isFromRightToLeft);
            removeAllViewsInLayout();
            this.mNextX = i19;
            this.mDataChanged = false;
            Runnable runnable = this.mPositionScrollAfterLayout;
            if (runnable != null) {
                post(runnable);
                this.mPositionScrollAfterLayout = null;
            }
        }
        Integer num = this.mRestoreX;
        if (num != null) {
            this.mNextX = num.intValue();
            this.mRestoreX = null;
        }
        int i26 = this.mNextX;
        int i27 = this.mMinX;
        if (i26 < i27) {
            this.mNextX = i27;
        } else {
            int i28 = this.mMaxX;
            if (i26 > i28) {
                this.mNextX = i28;
            }
        }
        reMeasureChilds();
        int i29 = this.mCurrentX - this.mNextX;
        removeNonVisibleChildren(i29);
        fillList(i29);
        positionChildren(i29);
        this.mCurrentX = this.mNextX;
        OnScrollLinstener onScrollLinstener = this.mOnScrollLinstener;
        if (onScrollLinstener != null) {
            onScrollLinstener.onScroll();
        }
        if (determineBorderMaxX()) {
            onLayout(z16, i3, i16, i17, i18);
            return;
        }
        View rightmostChild = getRightmostChild();
        if (rightmostChild != null && rightmostChild.getRight() + this.mDividerWidth < getRenderWidth() && this.mRightViewAdapterIndex < this.mAdapter.getCount() - 1) {
            onLayout(z16, i3, i16, i17, i18);
        } else if (!this.mScroller.isFinished()) {
            ViewCompat.postOnAnimation(this, this.mDelayedLayout);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a2  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i3, int i16) {
        int count;
        int i17;
        int i18;
        int i19;
        int i26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            count = 0;
        } else {
            count = listAdapter.getCount();
        }
        if (count > 0 && (mode2 == 0 || mode2 == Integer.MIN_VALUE || mode == 0)) {
            View obtainView = obtainView(0);
            if (obtainView != null) {
                measureChild(obtainView, i3, i16);
                i17 = obtainView.getMeasuredWidth();
                i18 = obtainView.getMeasuredHeight();
                recycleView(0, obtainView);
                if (mode2 == 0 && mode2 != Integer.MIN_VALUE) {
                    this.mHeightMeasureSpec = i16;
                } else {
                    size2 = (getVerticalFadingEdgeLength() * 2) + getPaddingTop() + getPaddingBottom() + i18;
                    this.mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(size2, mode2);
                }
                if (mode != 0) {
                    size = getPaddingLeft() + getPaddingRight() + i17 + getVerticalScrollbarWidth();
                } else if (mode == Integer.MIN_VALUE) {
                    size = measureWidthOfChildren(0, -1, size, -1);
                }
                setMeasuredDimension(size, size2);
                i19 = this.mWidth;
                if ((i19 != 0 && i19 != size) || ((i26 = this.mHeight) != 0 && i26 != size2)) {
                    onSizeChange();
                }
                this.mWidth = size;
                this.mHeight = size2;
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "onMeasure obtainView is null");
            }
        }
        i17 = 0;
        i18 = 0;
        if (mode2 == 0) {
        }
        size2 = (getVerticalFadingEdgeLength() * 2) + getPaddingTop() + getPaddingBottom() + i18;
        this.mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(size2, mode2);
        if (mode != 0) {
        }
        setMeasuredDimension(size, size2);
        i19 = this.mWidth;
        if (i19 != 0) {
            onSizeChange();
            this.mWidth = size;
            this.mHeight = size2;
        }
        onSizeChange();
        this.mWidth = size;
        this.mHeight = size2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onOverScrolled(int i3, int i16, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            super.scrollTo(i3, i16);
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) parcelable);
        } else if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mRestoreX = Integer.valueOf(bundle.getInt(BUNDLE_ID_CURRENT_X));
            super.onRestoreInstanceState(bundle.getParcelable(BUNDLE_ID_PARENT_STATE));
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Parcelable) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_ID_PARENT_STATE, super.onSaveInstanceState());
        bundle.putInt(BUNDLE_ID_CURRENT_X, this.mCurrentX);
        return bundle;
    }

    @Override // android.view.View
    @TargetApi(8)
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        boolean z16;
        Runnable runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Boolean) iPatchRedirector.redirect((short) 49, (Object) this, (Object) motionEvent)).booleanValue();
        }
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                onSecondaryPointerUp(motionEvent);
                                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                                if (findPointerIndex < motionEvent.getPointerCount() && -1 != findPointerIndex) {
                                    this.mLastMotionX = motionEvent.getX(findPointerIndex);
                                }
                                int pointToPosition = pointToPosition(this.mMotionX, this.mMotionY);
                                if (pointToPosition >= 0) {
                                    this.mMotionPosition = pointToPosition;
                                }
                            }
                        } else {
                            int action2 = (motionEvent.getAction() & 65280) >> 8;
                            float x16 = motionEvent.getX(action2);
                            float y16 = motionEvent.getY(action2);
                            this.mLastMotionX = x16;
                            this.mActivePointerId = motionEvent.getPointerId(action2);
                            int i3 = (int) x16;
                            this.mMotionX = i3;
                            int i16 = (int) y16;
                            this.mMotionY = i16;
                            int pointToPosition2 = pointToPosition(i3, i16);
                            if (pointToPosition2 >= 0) {
                                this.mMotionPosition = pointToPosition2;
                            }
                        }
                    } else {
                        unpressTouchedView();
                        if (this.mIsBeingDragged && getChildCount() > 0) {
                            OverScroller overScroller = this.mScroller;
                            int scrollX = getScrollX() + this.mNextX;
                            int scrollY = getScrollY();
                            int i17 = this.mNextX;
                            if (overScroller.springBack(scrollX, scrollY, i17, i17, 0, 0)) {
                                this.mTouchMode = 6;
                                setCurrentScrollState(4099);
                                invalidate();
                            } else {
                                setCurrentScrollState(4097);
                            }
                            this.mActivePointerId = -1;
                            endDrag();
                        }
                        int i18 = this.mTouchMode;
                        if (i18 != 5 && i18 != 6) {
                            this.mTouchMode = -1;
                            unpressTouchedView();
                            Handler handler = getHandler();
                            if (handler != null) {
                                handler.removeCallbacks(this.mPendingCheckForLongPress);
                            }
                        }
                        if (DEBUG) {
                            log("onTouchEvent", "CANCEL", Integer.valueOf(this.mTouchMode));
                        }
                    }
                } else {
                    int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex2 != -1) {
                        float x17 = motionEvent.getX(findPointerIndex2);
                        int i19 = (int) (this.mLastMotionX - x17);
                        if (!this.mIsBeingDragged && Math.abs(i19) > this.mTouchSlop) {
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                            this.mIsBeingDragged = true;
                            i19 = i19 > 0 ? i19 - this.mTouchSlop : i19 + this.mTouchSlop;
                        }
                        if (this.mIsBeingDragged) {
                            int i26 = this.mTouchMode;
                            if (i26 != 0 && i26 != 1 && i26 != 2) {
                                if (i26 == 3 || i26 == 5) {
                                    if (getScrollX() != 0) {
                                        this.mTouchMode = 5;
                                    } else {
                                        this.mTouchMode = 3;
                                    }
                                }
                            } else {
                                Handler handler2 = getHandler();
                                if (handler2 != null) {
                                    handler2.removeCallbacks(this.mPendingCheckForLongPress);
                                }
                                Runnable runnable2 = this.mTouchModeReset;
                                if (runnable2 != null) {
                                    removeCallbacks(runnable2);
                                }
                                unpressTouchedView();
                                if (getScrollX() != 0) {
                                    this.mTouchMode = 5;
                                } else {
                                    this.mTouchMode = 3;
                                }
                            }
                            setCurrentScrollState(4098);
                            scrollIfNeeded(x17, i19);
                        }
                    }
                }
            } else {
                if (this.mIsBeingDragged || Math.abs(getScrollX()) > this.mTouchSlop) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                    if (getChildCount() > 0) {
                        if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                            fling(-xVelocity);
                        } else {
                            OverScroller overScroller2 = this.mScroller;
                            int scrollX2 = this.mNextX + getScrollX();
                            int scrollY2 = getScrollY();
                            int i27 = this.mNextX;
                            if (overScroller2.springBack(scrollX2, scrollY2, i27, i27, 0, 0)) {
                                this.mTouchMode = 6;
                                setCurrentScrollState(4099);
                                invalidate();
                            } else {
                                setCurrentScrollState(4097);
                            }
                        }
                    } else {
                        setCurrentScrollState(4097);
                    }
                    this.mActivePointerId = -1;
                    endDrag();
                }
                int i28 = this.mTouchMode;
                if (i28 != 0 && i28 != 1 && i28 != 2) {
                    if (i28 != 3) {
                        if (i28 == 5) {
                            this.mTouchMode = -1;
                        }
                    } else {
                        this.mTouchMode = -1;
                    }
                } else {
                    int i29 = this.mMotionPosition;
                    View childAt = getChildAt(i29 - getFirstVisiblePosition());
                    float x18 = motionEvent.getX();
                    if (x18 > getPaddingLeft() && x18 < getWidth() - getPaddingRight()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (this.mPerformClick == null) {
                        this.mPerformClick = new PerformClick();
                    }
                    PerformClick performClick = this.mPerformClick;
                    performClick.mClickMotionPosition = i29;
                    performClick.rememberWindowAttachCount();
                    if (childAt != null && !childAt.hasFocusable() && z16) {
                        if (this.mTouchMode != 0) {
                            unpressTouchedView();
                            Runnable runnable3 = this.mTouchModeReset;
                            if (runnable3 != null) {
                                removeCallbacks(runnable3);
                            }
                        }
                        int i36 = this.mTouchMode;
                        if (i36 != 0 && i36 != 1) {
                            if (!this.mDataChanged && this.mAdapter.isEnabled(i29)) {
                                performClick.run();
                            }
                        } else {
                            Handler handler3 = getHandler();
                            if (handler3 != null) {
                                if (this.mTouchMode == 0) {
                                    runnable = this.mPendingCheckForTap;
                                } else {
                                    runnable = this.mPendingCheckForLongPress;
                                }
                                handler3.removeCallbacks(runnable);
                            }
                            if (!this.mDataChanged && this.mAdapter.isEnabled(i29)) {
                                this.mTouchMode = 1;
                                if (needTtransTouchStateToParen()) {
                                    updateTouchedView((View) getParent());
                                } else {
                                    updateTouchedView(childAt);
                                }
                                Runnable runnable4 = this.mTouchModeReset;
                                if (runnable4 != null) {
                                    removeCallbacks(runnable4);
                                }
                                Runnable runnable5 = new Runnable(performClick) { // from class: com.tencent.widget.HorizontalListView.2
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ PerformClick f384599d;

                                    {
                                        this.f384599d = performClick;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HorizontalListView.this, (Object) performClick);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        HorizontalListView horizontalListView = HorizontalListView.this;
                                        horizontalListView.mTouchMode = -1;
                                        horizontalListView.unpressTouchedView();
                                        if (!HorizontalListView.this.mDataChanged) {
                                            this.f384599d.run();
                                        }
                                        HorizontalListView.this.mTouchModeReset = null;
                                    }
                                };
                                this.mTouchModeReset = runnable5;
                                postDelayed(runnable5, ViewConfiguration.getPressedStateDuration());
                            } else {
                                this.mTouchMode = -1;
                            }
                            return true;
                        }
                    } else {
                        performClick.run();
                    }
                    this.mTouchMode = -1;
                }
                setPressed(false);
                invalidate();
                Handler handler4 = getHandler();
                if (handler4 != null) {
                    handler4.removeCallbacks(this.mPendingCheckForLongPress);
                }
                if (DEBUG) {
                    log("onTouchEvent", "UP", Integer.valueOf(this.mTouchMode));
                }
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.mTouchMode == 6) {
                this.mTouchMode = 5;
                this.mMotionX = (int) motionEvent.getX();
                this.mMotionY = (int) motionEvent.getY();
            } else {
                if (needTtransTouchStateToParen()) {
                    this.mTouchMode = 0;
                    if (this.mPendingCheckForTap == null) {
                        this.mPendingCheckForTap = new CheckForTap();
                    }
                    postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                    this.mMotionPosition = getFirstVisiblePosition();
                } else {
                    int pointToPosition3 = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (!this.mDataChanged) {
                        if (this.mTouchMode != 4 && pointToPosition3 >= 0 && getAdapter().isEnabled(pointToPosition3)) {
                            this.mTouchMode = 0;
                            if (this.mPendingCheckForTap == null) {
                                this.mPendingCheckForTap = new CheckForTap();
                            }
                            postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                        } else if (this.mTouchMode == 4) {
                            this.mTouchMode = 3;
                            pointToPosition3 = findMotionColumn((int) motionEvent.getX());
                        }
                    }
                    this.mMotionPosition = pointToPosition3;
                }
                this.mMotionX = (int) motionEvent.getX();
                this.mMotionY = (int) motionEvent.getY();
            }
            boolean z17 = !this.mScroller.isFinished();
            this.mIsBeingDragged = z17;
            if (z17 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            this.mLastMotionX = motionEvent.getX();
            this.mActivePointerId = motionEvent.getPointerId(0);
            setCurrentScrollState(4097);
            if (DEBUG) {
                log("onTouchEvent", "DOWN", Boolean.valueOf(this.mIsBeingDragged));
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b7  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        int i29;
        boolean z27;
        boolean z28;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Boolean) iPatchRedirector.redirect((short) 54, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Boolean.valueOf(z16))).booleanValue();
        }
        int overScrollMode = getOverScrollMode();
        if (computeHorizontalScrollRange() > computeHorizontalScrollExtent()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (computeVerticalScrollRange() > computeVerticalScrollExtent()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (overScrollMode != 0 && (overScrollMode != 1 || !z17)) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (overScrollMode != 0 && (overScrollMode != 1 || !z18)) {
            z26 = false;
        } else {
            z26 = true;
        }
        int i36 = i17 + i3;
        if (!z19) {
            i27 = 0;
        }
        int i37 = i18 + i16;
        if (!z26) {
            i28 = 0;
        }
        int i38 = -i27;
        int i39 = Integer.MAX_VALUE;
        if (i27 == Integer.MAX_VALUE) {
            i29 = Integer.MAX_VALUE;
        } else {
            i29 = i27 + i19;
        }
        int i46 = -i28;
        if (i28 != Integer.MAX_VALUE) {
            i39 = i28 + i26;
        }
        if (i36 > i29) {
            i36 = i29;
        } else if (i36 < i38) {
            i36 = i38;
        } else {
            z27 = false;
            if (i37 <= i39) {
                i37 = i39;
            } else if (i37 < i46) {
                i37 = i46;
            } else {
                z28 = false;
                onOverScrolled(i36, i37, z27, z28);
                if (z27 && !z28) {
                    return false;
                }
                return true;
            }
            z28 = true;
            onOverScrolled(i36, i37, z27, z28);
            if (z27) {
            }
            return true;
        }
        z27 = true;
        if (i37 <= i39) {
        }
        z28 = true;
        onOverScrolled(i36, i37, z27, z28);
        if (z27) {
        }
        return true;
    }

    @Override // android.view.View
    @TargetApi(16)
    public boolean performAccessibilityAction(int i3, Bundle bundle) {
        int count;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Boolean) iPatchRedirector.redirect((short) 66, (Object) this, i3, (Object) bundle)).booleanValue();
        }
        if (super.performAccessibilityAction(i3, bundle)) {
            return true;
        }
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            count = 0;
        } else {
            count = listAdapter.getCount();
        }
        if (i3 != 4096) {
            if (i3 != 8192 || !isEnabled() || getFirstVisiblePosition() <= 0) {
                return false;
            }
            scrollIfNeeded(this.mLastMotionX, -((getWidth() - getPaddingLeft()) - getPaddingRight()));
            return true;
        }
        if (!isEnabled() || getLastVisiblePosition() >= count - 1) {
            return false;
        }
        scrollIfNeeded(this.mLastMotionX, (getWidth() - getPaddingLeft()) - getPaddingRight());
        return true;
    }

    boolean performLongPress(View view, int i3, long j3) {
        boolean z16;
        AdapterView.OnItemLongClickListener onItemLongClickListener = getOnItemLongClickListener();
        if (onItemLongClickListener != null) {
            z16 = onItemLongClickListener.onItemLongClick(this, view, i3, j3);
        } else {
            z16 = false;
        }
        if (!z16) {
            this.mContextMenuInfo = createContextMenuInfo(view, i3, j3);
            z16 = super.showContextMenuForChild(this);
        }
        if (z16) {
            performHapticFeedback(0);
        }
        return z16;
    }

    public int pointToPosition(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return ((Integer) iPatchRedirector.redirect((short) 62, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        Rect rect = this.mTouchFrame;
        if (rect == null) {
            rect = new Rect();
            this.mTouchFrame = rect;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i3, i16)) {
                    return getFirstVisiblePosition() + childCount;
                }
            }
        }
        return -1;
    }

    protected void positionChildren(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, i3);
            return;
        }
        int childCount = getChildCount();
        if (childCount > 0) {
            int i16 = 0;
            if (DEBUG) {
                log("positionChildren", Integer.valueOf(this.mDisplayOffset), Integer.valueOf(i3), Integer.valueOf(this.mDisplayOffset + i3));
            }
            if (this.isFromRightToLeft) {
                this.mDisplayOffset -= i3;
                int width = getWidth() - this.mDisplayOffset;
                while (i16 < childCount) {
                    View childAt = getChildAt(i16);
                    int paddingRight = getPaddingRight() + width;
                    int measuredWidth = paddingRight - childAt.getMeasuredWidth();
                    int paddingTop = getPaddingTop();
                    childAt.layout(measuredWidth, paddingTop, paddingRight, childAt.getMeasuredHeight() + paddingTop);
                    width -= childAt.getMeasuredWidth() + this.mDividerWidth;
                    i16++;
                }
                return;
            }
            if (this.mLeftViewAdapterIndex == 0) {
                this.mMinX = this.mDisplayOffset + this.mCurrentX;
            }
            int i17 = this.mDisplayOffset + i3;
            this.mDisplayOffset = i17;
            while (i16 < childCount) {
                View childAt2 = getChildAt(i16);
                int paddingLeft = getPaddingLeft() + i17;
                int paddingTop2 = getPaddingTop();
                childAt2.layout(paddingLeft, paddingTop2, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + paddingTop2);
                i17 += childAt2.getMeasuredWidth() + this.mDividerWidth;
                i16++;
            }
        }
    }

    protected void recycleView(int i3, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3, (Object) view);
            return;
        }
        int i16 = -1;
        try {
            Object tag = view.getTag(TAG_VIEW_TYPE);
            if (tag instanceof Integer) {
                i16 = ((Integer) tag).intValue();
            }
            if (!isItemViewTypeValid(i16)) {
                i16 = this.mAdapter.getItemViewType(i3);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (isItemViewTypeValid(i16)) {
            this.mRemovedViewsCache.get(i16).offer(view);
            RecycleListener recycleListener = this.mRecycleListener;
            if (recycleListener != null) {
                recycleListener.onViewRecycled(view);
            }
        }
    }

    protected void removeNonVisibleChildren(int i3) {
        int measuredWidth;
        int measuredWidth2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, i3);
            return;
        }
        if (this.isFromRightToLeft) {
            View rightmostChild = getRightmostChild();
            while (rightmostChild != null && rightmostChild.getLeft() + i3 >= getWidth()) {
                int i16 = this.mDisplayOffset;
                if (isLastItemInAdapter(this.mRightViewAdapterIndex)) {
                    measuredWidth2 = rightmostChild.getMeasuredWidth();
                } else {
                    measuredWidth2 = this.mDividerWidth + rightmostChild.getMeasuredWidth();
                }
                this.mDisplayOffset = i16 + measuredWidth2;
                recycleView(this.mRightViewAdapterIndex, rightmostChild);
                removeViewInLayout(rightmostChild);
                this.mRightViewAdapterIndex++;
                rightmostChild = getRightmostChild();
            }
            View leftmostChild = getLeftmostChild();
            while (leftmostChild != null && leftmostChild.getRight() + i3 <= 0) {
                recycleView(this.mLeftViewAdapterIndex, leftmostChild);
                removeViewInLayout(leftmostChild);
                this.mLeftViewAdapterIndex--;
                leftmostChild = getLeftmostChild();
            }
            return;
        }
        View leftmostChild2 = getLeftmostChild();
        while (leftmostChild2 != null && leftmostChild2.getRight() + i3 <= 0) {
            int i17 = this.mDisplayOffset;
            if (isLastItemInAdapter(this.mLeftViewAdapterIndex)) {
                measuredWidth = leftmostChild2.getMeasuredWidth();
            } else {
                measuredWidth = this.mDividerWidth + leftmostChild2.getMeasuredWidth();
            }
            this.mDisplayOffset = i17 + measuredWidth;
            recycleView(this.mLeftViewAdapterIndex, leftmostChild2);
            removeViewInLayout(leftmostChild2);
            OnItemScrollEventListener onItemScrollEventListener = this.mOnItemScrollEventListener;
            if (onItemScrollEventListener != null) {
                onItemScrollEventListener.onItemScrollNonVisible(this.mLeftViewAdapterIndex, true);
            }
            this.mLeftViewAdapterIndex++;
            leftmostChild2 = getLeftmostChild();
        }
        View rightmostChild2 = getRightmostChild();
        while (rightmostChild2 != null && rightmostChild2.getLeft() + i3 >= getWidth()) {
            recycleView(this.mRightViewAdapterIndex, rightmostChild2);
            removeViewInLayout(rightmostChild2);
            OnItemScrollEventListener onItemScrollEventListener2 = this.mOnItemScrollEventListener;
            if (onItemScrollEventListener2 != null) {
                onItemScrollEventListener2.onItemScrollNonVisible(this.mRightViewAdapterIndex, false);
            }
            this.mRightViewAdapterIndex--;
            rightmostChild2 = getRightmostChild();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, z16);
            return;
        }
        if (z16) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reset(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
            return;
        }
        if (z16) {
            recycleBeforeRemoveAll();
        }
        initView(this.isFromRightToLeft);
        removeAllViewsInLayout();
        requestLayout();
    }

    public void resetCurrentX(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mCurrentX = i3;
        }
    }

    public int scrollBy2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return ((Integer) iPatchRedirector.redirect((short) 67, (Object) this, i3)).intValue();
        }
        int i16 = this.mNextX;
        int i17 = i16 + i3;
        if (i17 < 0) {
            return -1;
        }
        if (i17 > this.mMaxX) {
            return 1;
        }
        this.mScroller.startScroll(i16, 0, i3, 0, 20);
        setCurrentScrollState(4098);
        requestLayout();
        return 0;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, i3);
            return;
        }
        if (i3 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.mLastAccessibilityScrollEventFromIndex == firstVisiblePosition && this.mLastAccessibilityScrollEventToIndex == lastVisiblePosition) {
                return;
            }
            this.mLastAccessibilityScrollEventFromIndex = firstVisiblePosition;
            this.mLastAccessibilityScrollEventToIndex = lastVisiblePosition;
        }
        super.sendAccessibilityEvent(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCurrentScrollState(int i3) {
        OnScrollStateChangedListener onScrollStateChangedListener;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, i3);
            return;
        }
        if (this.mStayDisplayOffsetZero && (i16 = this.mCurrentScrollState) != i3 && i3 == 4097) {
            if (i16 != 4098) {
                if (i16 == 4099 && checkScrollToChild() && DEBUG) {
                    log("setCurrentScrollState", "SCROLL_STATE_FLING");
                }
            } else if (checkScrollToChild()) {
                if (DEBUG) {
                    log("setCurrentScrollState", "SCROLL_STATE_TOUCH_SCROLL");
                }
                i3 = 4099;
            }
        }
        if (this.mCurrentScrollState != i3 && (onScrollStateChangedListener = this.mOnScrollStateChangedListener) != null) {
            onScrollStateChangedListener.onScrollStateChanged(i3);
        }
        this.mCurrentScrollState = i3;
    }

    public void setDivider(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) drawable);
            return;
        }
        this.mDivider = drawable;
        if (drawable != null) {
            setDividerWidth(drawable.getIntrinsicWidth());
        } else {
            setDividerWidth(0);
        }
    }

    public void setDividerWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        this.mDividerWidth = i3;
        requestLayout();
        invalidate();
    }

    public void setLayoutDirection(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        this.isFromRightToLeft = z16;
        if (z16) {
            this.mMaxX = 0;
            this.mMinX = Integer.MIN_VALUE;
        } else {
            this.mMaxX = Integer.MAX_VALUE;
            this.mMinX = 0;
        }
    }

    public void setOnItemScollEventListener(OnItemScrollEventListener onItemScrollEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) onItemScrollEventListener);
        } else {
            this.mOnItemScrollEventListener = onItemScrollEventListener;
        }
    }

    public void setOnScrollListener(OnScrollLinstener onScrollLinstener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) onScrollLinstener);
        } else {
            this.mOnScrollLinstener = onScrollLinstener;
        }
    }

    public void setOnScrollStateChangedListener(OnScrollStateChangedListener onScrollStateChangedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) onScrollStateChangedListener);
        } else {
            this.mOnScrollStateChangedListener = onScrollStateChangedListener;
        }
    }

    @Override // android.view.View
    @TargetApi(9)
    public void setOverScrollMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            super.setOverScrollMode(i3);
        }
    }

    public void setRecycleListener(RecycleListener recycleListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this, (Object) recycleListener);
        } else {
            this.mRecycleListener = recycleListener;
        }
    }

    public void setRestoreX(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.mRestoreX = Integer.valueOf(i3);
        }
    }

    public void setRunningOutOfDataListener(RunningOutOfDataListener runningOutOfDataListener, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) runningOutOfDataListener, i3);
        } else {
            this.mRunningOutOfDataListener = runningOutOfDataListener;
            this.mRunningOutOfDataThreshold = i3;
        }
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.mCurrentlySelectedAdapterIndex = i3;
        }
    }

    public void setStayDisplayOffsetZero(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
        } else {
            this.mStayDisplayOffsetZero = z16;
        }
    }

    public void setTransTouchStateToParent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.mTransTouchState2Parent = z16;
        }
    }

    public void smoothScrollBy(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mTouchMode = 4;
        setCurrentScrollState(4099);
        int i17 = this.mCurrentX;
        if (this.mScroller.isFinished()) {
            i17 = getScrollX() + this.mNextX;
        }
        this.mScroller.startScroll(i17, 0, -i3, 0, i16);
        this.mLastMotionX = 0.0f;
        recycleVelocityTracker();
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void smoothScrollToPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, i3);
            return;
        }
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new PositionScroller();
        }
        this.mPositionScroller.start(i3);
    }

    public void smoothScrollToPositionFromLeftOrRight(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new PositionScroller();
        }
        this.mPositionScroller.startWithOffset(i3, i16, i17);
    }

    public HorizontalListView(Context context, boolean z16) {
        this(context, null, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, Boolean.valueOf(z16));
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) ? this.mAdapter : (ListAdapter) iPatchRedirector.redirect((short) 25, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @TargetApi(9)
    public void initView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
            return;
        }
        OverScroller overScroller = new OverScroller(getContext());
        this.mScroller = overScroller;
        overScroller.setFriction(getScrollerFriction());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setLayoutDirection(z16);
        this.mCurrentX = 0;
        this.mNextX = 0;
        this.mLeftViewAdapterIndex = -1;
        this.mRightViewAdapterIndex = -1;
        this.mDisplayOffset = 0;
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        this.mTouchMode = -1;
        setCurrentScrollState(4097);
        this.mAdapterDataObserver = new HorizontalAdapterDataObserver();
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) listAdapter);
            return;
        }
        ListAdapter listAdapter2 = this.mAdapter;
        if (listAdapter2 != null) {
            try {
                listAdapter2.unregisterDataSetObserver(this.mAdapterDataObserver);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        if (listAdapter != null) {
            this.mHasNotifiedRunningLowOnData = false;
            this.mAdapter = listAdapter;
            listAdapter.registerDataSetObserver(this.mAdapterDataObserver);
        }
        ListAdapter listAdapter3 = this.mAdapter;
        if (listAdapter3 != null) {
            initializeRecycledViewCache(listAdapter3.getViewTypeCount());
        }
        reset(false);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet, boolean z16) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, attributeSet, Boolean.valueOf(z16));
            return;
        }
        this.MIN_SPACE = 50;
        this.mRemovedViewsCache = new ArrayList();
        this.mDataChanged = false;
        this.mRect = new Rect();
        this.mViewBeingTouched = null;
        this.mDividerWidth = 0;
        this.mDivider = null;
        this.mRestoreX = null;
        this.mMaxX = Integer.MAX_VALUE;
        this.mMinX = 0;
        this.mRunningOutOfDataListener = null;
        this.mRunningOutOfDataThreshold = 0;
        this.mHasNotifiedRunningLowOnData = false;
        this.mOnScrollStateChangedListener = null;
        this.mOnItemScrollEventListener = null;
        this.mOnScrollLinstener = null;
        this.mCurrentScrollState = 4097;
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        this.mTouchMode = -1;
        this.mContextMenuInfo = null;
        this.mTransTouchState2Parent = false;
        this.mStayDisplayOffsetZero = false;
        this.isFromRightToLeft = false;
        this.mDelayedLayout = new Runnable() { // from class: com.tencent.widget.HorizontalListView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HorizontalListView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    HorizontalListView.this.requestLayout();
                }
            }
        };
        setOverScrollMode(0);
        initView(z16);
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    public void smoothScrollToPosition(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new PositionScroller();
        }
        this.mPositionScroller.start(i3, i16);
    }

    private View obtainView(int i3, boolean z16) {
        View recycledView = getRecycledView(i3);
        setTag(R.id.d8_, Boolean.valueOf(z16));
        View view = this.mAdapter.getView(i3, recycledView, this);
        markViewType(view, i3);
        if (recycledView != null && view != recycledView) {
            recycleView(i3, recycledView);
        }
        if (view != null) {
            setItemViewLayoutParams(view, i3);
        }
        return view;
    }

    public void smoothScrollToPosition(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new PositionScroller();
        }
        this.mPositionScroller.start(i3, i16, i17);
    }

    protected void fillListLeft(int i3, int i16, boolean z16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        while (true) {
            if ((!z16 && (i3 + i16) - this.mDividerWidth <= 0) || this.mLeftViewAdapterIndex + 1 >= this.mAdapter.getCount()) {
                return;
            }
            int i18 = this.mLeftViewAdapterIndex + 1;
            this.mLeftViewAdapterIndex = i18;
            if (this.mRightViewAdapterIndex < 0) {
                this.mRightViewAdapterIndex = i18;
            }
            View view = this.mAdapter.getView(i18, getRecycledView(i18), this);
            addAndMeasureChild(view, -1);
            if (this.mLeftViewAdapterIndex == 0) {
                i17 = getWidth() - view.getMeasuredWidth();
            } else {
                i17 = -(this.mDividerWidth + view.getMeasuredWidth());
            }
            i3 += i17;
            z16 = false;
        }
    }
}
