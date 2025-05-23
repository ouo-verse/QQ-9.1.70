package com.tencent.widget;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.LongSparseArray;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.RequiresApi;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimateUtils;
import com.tencent.util.QQViewCompatUtil;
import com.tencent.util.ReflectionUtil;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AdapterView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes27.dex */
public abstract class AbsListView extends AdapterView<ListAdapter> implements TextWatcher, ViewTreeObserver.OnGlobalLayoutListener, Filter.FilterListener, ViewTreeObserver.OnTouchModeChangeListener {
    static IPatchRedirector $redirector_ = null;
    private static final int CHECK_POSITION_SEARCH_DISTANCE = 20;
    public static final int CHOICE_MODE_MULTIPLE = 2;
    public static final int CHOICE_MODE_MULTIPLE_MODAL = 3;
    public static final int CHOICE_MODE_NONE = 0;
    public static final int CHOICE_MODE_SINGLE = 1;
    public static final int INVALID_POINTER = -1;
    static final int LAYOUT_FORCE_BOTTOM = 3;
    static final int LAYOUT_FORCE_TOP = 1;
    static final int LAYOUT_MOVE_SELECTION = 6;
    static final int LAYOUT_NORMAL = 0;
    static final int LAYOUT_SET_SELECTION = 2;
    static final int LAYOUT_SPECIFIC = 4;
    static final int LAYOUT_SPECIFIC_BOTTOM = 100;
    static final int LAYOUT_SYNC = 5;
    private static final int[] LISTVIEW_STYLEABLE;
    private static final int[] NOTHING;
    static final int OVERSCROLL_LIMIT_DIVISOR = 3;
    private static final int OVER_FLING_DISTANCE = 30;
    public static final int OVER_SCROLL_TOUCH_MODE_FAST = 1;
    public static final int OVER_SCROLL_TOUCH_MODE_NORMAL = 0;
    public static final int OVER_SCROLL_TOUCH_MODE_SMOOTH = 2;
    private static final boolean PROFILE_FLINGING = false;
    private static final boolean PROFILE_SCROLLING = false;
    protected static final int TOUCH_MODE_DONE_WAITING = 2;
    protected static final int TOUCH_MODE_DOWN = 0;
    protected static final int TOUCH_MODE_FLING = 4;
    private static final int TOUCH_MODE_OFF = 1;
    private static final int TOUCH_MODE_ON = 0;
    protected static final int TOUCH_MODE_OVERFLING = 6;
    protected static final int TOUCH_MODE_OVERSCROLL = 5;
    protected static final int TOUCH_MODE_REST = -1;
    protected static final int TOUCH_MODE_SCROLL = 3;
    protected static final int TOUCH_MODE_TAP = 1;
    private static final int TOUCH_MODE_UNKNOWN = -1;
    public static final int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2;
    public static final int TRANSCRIPT_MODE_DISABLED = 0;
    public static final int TRANSCRIPT_MODE_NORMAL = 1;
    private int mActivePointerId;
    ListAdapter mAdapter;
    int mBottomOverflingDistance;
    private MoveToBottomScroller mBottomScroller;
    int mCacheColorHint;
    boolean mCachingActive;
    boolean mCachingStarted;
    private boolean mCallbackOnUnClickItem;
    SparseBooleanArray mCheckStates;
    LongSparseArray<Integer> mCheckedIdStates;
    int mCheckedItemCount;
    ActionMode mChoiceActionMode;
    int mChoiceMode;
    private Runnable mClearScrollingCache;
    private ContextMenu.ContextMenuInfo mContextMenuInfo;
    AdapterDataSetObserver mDataSetObserver;
    private InputConnection mDefInputConnection;
    private boolean mDeferNotifyDataSetChanged;
    private float mDensityScale;
    private int mDirection;
    private boolean mDisableOverScrollTop;
    boolean mDrawSelectorOnTop;
    private boolean mEdgeEffectEnabled;
    public EdgeEffect mEdgeGlowBottom;
    public EdgeEffect mEdgeGlowTop;
    public boolean mEnableStory;
    boolean mFastScrollEnabled;
    FastScroller mFastScroller;
    private boolean mFiltered;
    private int mFirstPositionDistanceGuess;
    private boolean mFlingProfilingStarted;
    private FlingRunnable mFlingRunnable;
    private Object mFlingStrictSpan;
    public boolean mForContacts;
    public boolean mForHongBao;
    public boolean mForStory;
    private boolean mForceTranscriptScroll;
    private boolean mGlobalLayoutListenerAddedFilter;
    private int mGlowPaddingLeft;
    private int mGlowPaddingRight;
    boolean mIsAttached;
    private boolean mIsChildViewEnabled;
    private boolean mIsNeedScrollPositionTop;
    final boolean[] mIsScrap;
    private int mLastAccessibilityScrollEventFromIndex;
    private int mLastAccessibilityScrollEventToIndex;
    private int mLastHandledItemCount;
    private int mLastPositionDistanceGuess;
    private int mLastScrollState;
    private int mLastTouchMode;
    int mLastY;
    int mLayoutMode;
    protected Rect mListPadding;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    int mMotionCorrection;
    int mMotionPosition;
    int mMotionViewNewTop;
    int mMotionViewOriginalTop;
    int mMotionX;
    int mMotionY;
    MultiChoiceModeWrapper mMultiChoiceModeCallback;
    private boolean mNeedCheckSpringback;
    private OnOverScrollListener mOnOverScrollListener;
    private OnScrollButtomListener mOnScrollButtomListener;
    private OnScrollListener mOnScrollListener;
    private ArrayList<OnScrollListener> mOnScrollListenerList;
    private int mOverScrollMode;
    private int mOverScrollTouchMode;
    int mOverscrollDistance;
    int mOverscrollMax;
    private CheckForKeyLongPress mPendingCheckForKeyLongPress;
    private CheckForLongPress mPendingCheckForLongPress;
    private Runnable mPendingCheckForTap;
    private PerformClick mPerformClick;
    PopupWindow mPopup;
    private boolean mPopupHidden;
    PositionScroller mPositionScroller;
    private InputConnectionWrapper mPublicInputConnection;
    final RecycleBin mRecycler;
    int mResurrectToPosition;
    View mScrollDown;
    private boolean mScrollProfilingStarted;
    private Object mScrollStrictSpan;
    protected boolean mScrollToBottom;
    View mScrollUp;
    boolean mScrollingCacheEnabled;
    int mSelectedTop;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    Drawable mSelector;
    int mSelectorPosition;
    Rect mSelectorRect;
    private boolean mSmoothScrollbarEnabled;
    boolean mStackFromBottom;
    EditText mTextFilter;
    private boolean mTextFilterEnabled;
    int mTopOverflingDistance;
    private Rect mTouchFrame;
    protected int mTouchMode;
    private Runnable mTouchModeReset;
    private int mTouchSlop;
    private int mTranscriptMode;
    private float mVelocityScale;
    private VelocityTracker mVelocityTracker;
    int mWidthMeasureSpec;
    Method method;
    private OnNestedScrollingListener onNestedScrollingListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class AdapterDataSetObserver extends AdapterView<ListAdapter>.AdapterDataSetObserver {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AdapterDataSetObserver() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsListView.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.AdapterDataSetObserver, android.database.DataSetObserver
        public void onChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onChanged();
            FastScroller fastScroller = AbsListView.this.mFastScroller;
            if (fastScroller != null) {
                fastScroller.onSectionsChanged();
            }
        }

        @Override // com.tencent.widget.AdapterView.AdapterDataSetObserver, android.database.DataSetObserver
        public void onInvalidated() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            super.onInvalidated();
            FastScroller fastScroller = AbsListView.this.mFastScroller;
            if (fastScroller != null) {
                fastScroller.onSectionsChanged();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class CheckForKeyLongPress extends WindowRunnnable implements Runnable {
        static IPatchRedirector $redirector_;

        CheckForKeyLongPress() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsListView.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsListView absListView;
            int i3;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (AbsListView.this.isPressed() && (i3 = (absListView = AbsListView.this).mSelectedPosition) >= 0) {
                View childAt = absListView.getChildAt(i3 - absListView.mFirstPosition);
                AbsListView absListView2 = AbsListView.this;
                if (!absListView2.mDataChanged) {
                    if (sameWindow()) {
                        AbsListView absListView3 = AbsListView.this;
                        z16 = absListView3.performLongPress(childAt, absListView3.mSelectedPosition, absListView3.mSelectedRowId);
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        AbsListView.this.setPressed(false);
                        childAt.setPressed(false);
                        return;
                    }
                    return;
                }
                absListView2.setPressed(false);
                if (childAt != null) {
                    childAt.setPressed(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class CheckForLongPress extends WindowRunnnable implements Runnable {
        static IPatchRedirector $redirector_;

        CheckForLongPress() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsListView.this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AbsListView absListView = AbsListView.this;
            View childAt = absListView.getChildAt(absListView.mMotionPosition - absListView.mFirstPosition);
            if (childAt != null) {
                AbsListView absListView2 = AbsListView.this;
                int i3 = absListView2.mMotionPosition;
                long itemId = absListView2.mAdapter.getItemId(i3);
                if (sameWindow()) {
                    AbsListView absListView3 = AbsListView.this;
                    if (!absListView3.mDataChanged) {
                        z16 = absListView3.performLongPress(childAt, i3, itemId);
                        if (!z16) {
                            AbsListView absListView4 = AbsListView.this;
                            absListView4.mTouchMode = -1;
                            absListView4.setPressed(false);
                            childAt.setPressed(false);
                            return;
                        }
                        AbsListView.this.mTouchMode = 2;
                        return;
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    final class CheckForTap implements Runnable {
        static IPatchRedirector $redirector_;

        CheckForTap() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsListView.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Drawable current;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AbsListView absListView = AbsListView.this;
            if (absListView.mTouchMode == 0) {
                absListView.mTouchMode = 1;
                View childAt = absListView.getChildAt(absListView.mMotionPosition - absListView.mFirstPosition);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsListView absListView2 = AbsListView.this;
                    absListView2.mLayoutMode = 0;
                    if (!absListView2.mDataChanged) {
                        childAt.setPressed(true);
                        AbsListView.this.setPressed(true);
                        AbsListView.this.layoutChildren();
                        AbsListView absListView3 = AbsListView.this;
                        absListView3.positionSelector(absListView3.mMotionPosition, childAt);
                        AbsListView.this.refreshDrawableState();
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        boolean isLongClickable = AbsListView.this.isLongClickable();
                        Drawable drawable = AbsListView.this.mSelector;
                        if (drawable != null && (current = drawable.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                            if (isLongClickable) {
                                ((TransitionDrawable) current).startTransition(longPressTimeout);
                            } else {
                                ((TransitionDrawable) current).resetTransition();
                            }
                        }
                        if (isLongClickable) {
                            if (AbsListView.this.mPendingCheckForLongPress == null) {
                                AbsListView absListView4 = AbsListView.this;
                                absListView4.mPendingCheckForLongPress = new CheckForLongPress();
                            }
                            AbsListView.this.mPendingCheckForLongPress.rememberWindowAttachCount();
                            AbsListView absListView5 = AbsListView.this;
                            absListView5.postDelayed(absListView5.mPendingCheckForLongPress, longPressTimeout);
                            return;
                        }
                        AbsListView.this.mTouchMode = 2;
                        return;
                    }
                    absListView2.mTouchMode = 2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class FlingRunnable implements Runnable {
        static IPatchRedirector $redirector_ = null;
        private static final int FLYWHEEL_TIMEOUT = 40;
        private final Runnable mCheckFlywheel;
        private int mLastFlingY;
        private final OverScroller mScroller;

        FlingRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsListView.this);
            } else {
                this.mCheckFlywheel = new Runnable() { // from class: com.tencent.widget.AbsListView.FlingRunnable.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlingRunnable.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    @TargetApi(8)
                    public void run() {
                        float yVelocity;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            int i3 = AbsListView.this.mActivePointerId;
                            VelocityTracker velocityTracker = AbsListView.this.mVelocityTracker;
                            OverScroller overScroller = FlingRunnable.this.mScroller;
                            if (velocityTracker != null && i3 != -1) {
                                velocityTracker.computeCurrentVelocity(1000, AbsListView.this.mMaximumVelocity);
                                if (VersionUtils.isrFroyo()) {
                                    yVelocity = velocityTracker.getYVelocity(i3);
                                } else {
                                    yVelocity = velocityTracker.getYVelocity();
                                }
                                float f16 = -yVelocity;
                                if (Math.abs(f16) >= AbsListView.this.mMinimumVelocity && overScroller.isScrollingInDirection(0.0f, f16)) {
                                    AbsListView.this.postDelayed(this, 40L);
                                    return;
                                }
                                FlingRunnable.this.endFling();
                                AbsListView absListView = AbsListView.this;
                                absListView.mTouchMode = 3;
                                absListView.reportScrollStateChange(1);
                                return;
                            }
                            return;
                        }
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                };
                this.mScroller = new OverScroller(AbsListView.this.getContext());
            }
        }

        private void preceedFling(int i3) {
            AbsListView.this.invalidate();
            this.mLastFlingY = i3;
            AbsListView.this.postOnAnimation(this);
            if (AbsListView.this.mOnOverScrollListener != null) {
                AbsListView.this.mOnOverScrollListener.onOverScroll(i3);
            }
        }

        @TargetApi(9)
        void edgeReached(int i3) {
            int i16;
            int i17;
            AbsListView absListView = AbsListView.this;
            if (absListView.mForHongBao) {
                i16 = absListView.getSpringbackOffset();
            } else {
                i16 = 0;
            }
            OverScroller overScroller = this.mScroller;
            AbsListView absListView2 = AbsListView.this;
            if (i3 > 0) {
                i17 = absListView2.mTopOverflingDistance;
            } else {
                i17 = absListView2.mBottomOverflingDistance;
            }
            overScroller.notifyVerticalEdgeReached(i3, i16, i17);
            int overScrollMode = AbsListView.this.getOverScrollMode();
            if (overScrollMode != 0 && (overScrollMode != 1 || AbsListView.this.contentFits())) {
                AbsListView absListView3 = AbsListView.this;
                absListView3.mTouchMode = -1;
                PositionScroller positionScroller = absListView3.mPositionScroller;
                if (positionScroller != null) {
                    positionScroller.stop();
                }
                if (AbsListView.this.mBottomScroller != null) {
                    AbsListView.this.mBottomScroller.stop();
                }
            } else {
                AbsListView.this.mTouchMode = 6;
                int currVelocity = (int) this.mScroller.getCurrVelocity();
                AbsListView absListView4 = AbsListView.this;
                EdgeEffect edgeEffect = absListView4.mEdgeGlowTop;
                if (edgeEffect != null) {
                    if (i3 > 0) {
                        edgeEffect.onAbsorb(currVelocity);
                    } else {
                        absListView4.mEdgeGlowBottom.onAbsorb(currVelocity);
                    }
                }
            }
            AbsListView.this.invalidate();
            AbsListView.this.postOnAnimation(this);
        }

        void endFling() {
            AbsListView absListView = AbsListView.this;
            absListView.mTouchMode = -1;
            absListView.removeCallbacks(this);
            AbsListView.this.removeCallbacks(this.mCheckFlywheel);
            AbsListView.this.reportScrollStateChange(0);
            AbsListView.this.clearScrollingCache();
            this.mScroller.abortAnimation();
            if (AbsListView.this.mFlingStrictSpan != null) {
                AbsListView absListView2 = AbsListView.this;
                absListView2.mFlingStrictSpan = absListView2.finishSpan(absListView2.mFlingStrictSpan);
            }
            if (AbsListView.this.mOnOverScrollListener != null) {
                AbsListView.this.mOnOverScrollListener.onOverScroll(0);
            }
        }

        void flywheelTouch() {
            AbsListView.this.postDelayed(this.mCheckFlywheel, 40L);
        }

        @Override // java.lang.Runnable
        @TargetApi(9)
        public void run() {
            int max;
            int i3;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            int i16 = AbsListView.this.mTouchMode;
            boolean z17 = true;
            if (i16 != 3) {
                if (i16 != 4) {
                    if (i16 != 6) {
                        endFling();
                        return;
                    }
                    OverScroller overScroller = this.mScroller;
                    if (overScroller.computeScrollOffset()) {
                        int scrollY = AbsListView.this.getScrollY();
                        int currY = overScroller.getCurrY();
                        AbsListView absListView = AbsListView.this;
                        if (absListView.overScrollBy(0, currY - scrollY, 0, scrollY, 0, 0, 0, absListView.mOverscrollDistance, false)) {
                            if (scrollY <= 0 && currY > 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (scrollY < 0 || currY >= 0) {
                                z17 = false;
                            }
                            if (!z16 && !z17) {
                                startSpringback(0);
                            }
                            int currVelocity = (int) overScroller.getCurrVelocity();
                            if (z17) {
                                currVelocity = -currVelocity;
                            }
                            overScroller.abortAnimation();
                            start(currVelocity);
                        } else {
                            AbsListView.this.invalidate();
                            AbsListView.this.postOnAnimation(this);
                            if (AbsListView.this.mOnOverScrollListener != null) {
                                AbsListView.this.mOnOverScrollListener.onOverScroll(currY);
                            }
                        }
                    } else {
                        endFling();
                    }
                    return;
                }
            } else if (this.mScroller.isFinished()) {
                return;
            }
            AdapterView.traceBegin("AbsListView.FlingRunable.onfling");
            try {
                AbsListView absListView2 = AbsListView.this;
                if (absListView2.mDataChanged) {
                    absListView2.layoutChildren();
                }
                AbsListView absListView3 = AbsListView.this;
                if (absListView3.mItemCount != 0 && absListView3.getChildCount() != 0) {
                    OverScroller overScroller2 = this.mScroller;
                    boolean computeScrollOffset = overScroller2.computeScrollOffset();
                    int currY2 = overScroller2.getCurrY();
                    int i17 = this.mLastFlingY - currY2;
                    if (i17 > 0) {
                        AbsListView absListView4 = AbsListView.this;
                        absListView4.mMotionPosition = absListView4.mFirstPosition;
                        AbsListView.this.mMotionViewOriginalTop = absListView4.getChildAt(0).getTop();
                        max = Math.min(((AbsListView.this.getHeight() - AbsListView.this.getPaddingBottom()) - AbsListView.this.getPaddingTop()) - 1, i17);
                    } else {
                        int childCount = AbsListView.this.getChildCount() - 1;
                        AbsListView absListView5 = AbsListView.this;
                        absListView5.mMotionPosition = absListView5.mFirstPosition + childCount;
                        AbsListView.this.mMotionViewOriginalTop = absListView5.getChildAt(childCount).getTop();
                        max = Math.max(-(((AbsListView.this.getHeight() - AbsListView.this.getPaddingBottom()) - AbsListView.this.getPaddingTop()) - 1), i17);
                    }
                    AbsListView absListView6 = AbsListView.this;
                    View childAt = absListView6.getChildAt(absListView6.mMotionPosition - absListView6.mFirstPosition);
                    if (childAt != null) {
                        i3 = childAt.getTop();
                    } else {
                        i3 = 0;
                    }
                    if (!AbsListView.this.trackMotionScroll(max, max) || max == 0) {
                        z17 = false;
                    }
                    if (z17) {
                        if (childAt != null) {
                            if (AbsListView.this.onNestedScrollingListener != null && AbsListView.this.onNestedScrollingListener.onNestedScrolling(max) == max) {
                                preceedFling(currY2);
                            } else {
                                int i18 = -(max - (childAt.getTop() - i3));
                                if (!AbsListView.this.mForHongBao || i18 <= 0) {
                                    if (computeScrollOffset) {
                                        edgeReached(i18);
                                        i18 = this.mScroller.getCurrY();
                                    }
                                    AbsListView absListView7 = AbsListView.this;
                                    absListView7.overScrollBy(0, i18, 0, absListView7.getScrollY(), 0, 0, 0, AbsListView.this.mOverscrollDistance, false);
                                }
                            }
                        }
                    } else if (computeScrollOffset && !z17) {
                        preceedFling(currY2);
                    } else {
                        endFling();
                    }
                    return;
                }
                endFling();
            } finally {
                AdapterView.traceEnd();
            }
        }

        void start(int i3) {
            int i16;
            if (i3 < 0) {
                i16 = Integer.MAX_VALUE;
            } else {
                i16 = 0;
            }
            int i17 = i16;
            this.mLastFlingY = i17;
            this.mScroller.fling(0, i17, 0, i3, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsListView absListView = AbsListView.this;
            absListView.mTouchMode = 4;
            absListView.postOnAnimation(this);
            if (AbsListView.this.mFlingStrictSpan == null) {
                AbsListView absListView2 = AbsListView.this;
                absListView2.mFlingStrictSpan = absListView2.enterCriticalSpan("AbsListView-fling");
            }
        }

        void startOverfling(int i3) {
            this.mScroller.fling(0, AbsListView.this.getScrollY(), 0, i3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, AbsListView.this.getHeight());
            AbsListView absListView = AbsListView.this;
            absListView.mTouchMode = 6;
            absListView.invalidate();
            AbsListView.this.postOnAnimation(this);
        }

        void startScroll(int i3, int i16) {
            int i17;
            if (i3 < 0) {
                i17 = Integer.MAX_VALUE;
            } else {
                i17 = 0;
            }
            int i18 = i17;
            this.mLastFlingY = i18;
            this.mScroller.startScroll(0, i18, 0, i3, i16);
            AbsListView absListView = AbsListView.this;
            absListView.mTouchMode = 4;
            absListView.postOnAnimation(this);
        }

        void startScrollImmediately(int i3, int i16) {
            float f16;
            int i17;
            int i18;
            this.mScroller.computeScrollOffset();
            int currY = this.mLastFlingY - this.mScroller.getCurrY();
            if (currY != 0) {
                i17 = -currY;
            } else {
                Interpolator interpolator = this.mScroller.getInterpolator();
                if (interpolator != null) {
                    f16 = interpolator.getInterpolation(16.0f / i16);
                } else {
                    float f17 = 1.0f - (16.0f / i16);
                    f16 = 1.0f - (f17 * f17);
                }
                i17 = ((int) f16) * i3;
            }
            if (i3 < 0) {
                i18 = Integer.MAX_VALUE;
            } else {
                i18 = 0;
            }
            this.mLastFlingY = i18;
            this.mScroller.startScroll(0, i18 + i17, 0, i3 - i17, i16);
            AbsListView absListView = AbsListView.this;
            absListView.mTouchMode = 4;
            absListView.invalidate();
            AbsListView.this.removeCallbacks(this);
            AbsListView.this.postOnAnimation(this);
        }

        void startSpringback(int i3) {
            if (this.mScroller.springBack(0, AbsListView.this.getScrollY(), i3, i3, i3, i3)) {
                AbsListView absListView = AbsListView.this;
                absListView.mTouchMode = 6;
                absListView.invalidate();
                AbsListView.this.postOnAnimation(this);
            } else {
                AbsListView absListView2 = AbsListView.this;
                absListView2.mTouchMode = -1;
                absListView2.reportScrollStateChange(0);
            }
            if (AbsListView.this.mOnOverScrollListener != null) {
                AbsListView.this.mOnOverScrollListener.onOverScroll(AbsListView.this.getScrollY());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        static IPatchRedirector $redirector_;

        @ViewDebug.ExportedProperty(category = "list")
        boolean forceAdd;

        @ViewDebug.ExportedProperty(category = "list")
        boolean recycledHeaderFooter;
        public int scrappedFromPosition;

        @ViewDebug.ExportedProperty(category = "list", mapping = {@ViewDebug.IntToString(from = -1, to = "ITEM_VIEW_TYPE_IGNORE"), @ViewDebug.IntToString(from = -2, to = "ITEM_VIEW_TYPE_HEADER_OR_FOOTER")})
        public int viewType;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }

        public LayoutParams(int i3, int i16, int i17) {
            super(i3, i16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.viewType = i17;
            } else {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class MoveToBottomScroller implements Runnable {
        static IPatchRedirector $redirector_ = null;
        private static final int SCROLL_DURATION = 400;
        private static final int STATUS_ACCERLERING = 0;
        private static final int STATUS_DECERLERING = 1;
        private static final int STATUS_UNIFORM = 2;
        private static final int STATUS_VISCOUS_FLUID = 3;
        private int lastMotionY;
        private float mAccerleration;
        private float mCurrVelocity;
        private int mDistance;
        private int mDuration;
        private float mMaxVeloctiy;
        private long mStartTime;
        private int mStatus;
        private int mTargetPosition;
        private boolean mUseViscousFluid;

        MoveToBottomScroller() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsListView.this);
            } else {
                this.lastMotionY = 0;
                this.mUseViscousFluid = false;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            float f16;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AdapterView.traceBegin("AbsListView.MoveToBottomScroller.run");
            try {
                int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
                int i16 = this.mStatus;
                if (i16 != 0) {
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 != 3) {
                                i3 = 0;
                            } else {
                                int i17 = this.mDuration;
                                if (currentAnimationTimeMillis > i17) {
                                    int i18 = -(this.mDistance - this.lastMotionY);
                                    AbsListView.this.trackMotionScroll(i18, i18);
                                    return;
                                }
                                f16 = AnimateUtils.viscousFluid(currentAnimationTimeMillis / i17) * this.mDistance;
                                i3 = (int) f16;
                            }
                        } else {
                            float f17 = this.mMaxVeloctiy;
                            i3 = (int) ((currentAnimationTimeMillis * f17) - ((f17 * 400.0f) / 8.0f));
                        }
                    } else {
                        if (currentAnimationTimeMillis > this.mDuration) {
                            int i19 = -(this.mDistance - this.lastMotionY);
                            AbsListView.this.trackMotionScroll(i19, i19);
                            return;
                        } else {
                            float f18 = this.mCurrVelocity - (this.mAccerleration * currentAnimationTimeMillis);
                            this.mCurrVelocity = f18;
                            i3 = (int) (this.mDistance - ((f18 * (r1 - currentAnimationTimeMillis)) / 2.0f));
                        }
                    }
                } else if (currentAnimationTimeMillis > 100) {
                    float f19 = this.mMaxVeloctiy;
                    this.mCurrVelocity = f19;
                    this.mAccerleration = 0.0f;
                    this.mStatus = 2;
                    i3 = (int) ((currentAnimationTimeMillis * f19) - ((f19 * 400.0f) / 8.0f));
                } else {
                    float f26 = currentAnimationTimeMillis;
                    float f27 = this.mAccerleration * f26;
                    this.mCurrVelocity = f27;
                    f16 = (f27 * f26) / 2.0f;
                    i3 = (int) f16;
                }
                int i26 = -(i3 - this.lastMotionY);
                if (!AbsListView.this.trackMotionScroll(i26, i26)) {
                    int childCount = AbsListView.this.getChildCount();
                    AbsListView absListView = AbsListView.this;
                    int i27 = absListView.mFirstPosition;
                    int i28 = this.mStatus;
                    if (i28 != 3 && i28 != 1 && (i27 + childCount) - 1 >= this.mTargetPosition) {
                        int bottom = absListView.getBottom() - AbsListView.this.getTop();
                        AbsListView absListView2 = AbsListView.this;
                        int bottom2 = absListView2.getChildAt(childCount - 1).getBottom() - (bottom - absListView2.mListPadding.bottom);
                        this.mDistance = bottom2;
                        if (bottom2 == 0) {
                            stop();
                            return;
                        }
                        int i29 = 400 - currentAnimationTimeMillis;
                        this.mDuration = i29;
                        if (i29 < 100) {
                            this.mDuration = 100;
                        }
                        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                        this.lastMotionY = 0;
                        if (this.mCurrVelocity * 1000.0f > AbsListView.this.mMinimumVelocity && !this.mUseViscousFluid) {
                            this.mStatus = 1;
                            int i36 = this.mDuration;
                            float f28 = (this.mDistance * 2.0f) / i36;
                            this.mCurrVelocity = f28;
                            this.mAccerleration = f28 / i36;
                        } else {
                            this.mStatus = 3;
                        }
                    }
                    AbsListView.this.postOnAnimation(this);
                } else {
                    stop();
                }
            } finally {
                AdapterView.traceEnd();
            }
        }

        void start() {
            AbsListView absListView = AbsListView.this;
            int childCount = absListView.mFirstPosition + absListView.getChildCount();
            boolean z16 = true;
            AbsListView absListView2 = AbsListView.this;
            int i3 = (absListView2.mItemCount - (childCount - 1)) - 1;
            if (i3 == 0) {
                int bottom = absListView2.getBottom() - AbsListView.this.getTop();
                AbsListView absListView3 = AbsListView.this;
                int bottom2 = absListView3.getChildAt(absListView3.getChildCount() - 1).getBottom() - (bottom - absListView3.mListPadding.bottom);
                this.mDistance = bottom2;
                if (bottom2 == 0) {
                    stop();
                    return;
                }
                this.mDuration = 400;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                this.lastMotionY = 0;
                this.mStatus = 3;
                AbsListView.this.postOnAnimation(this);
                return;
            }
            float height = ((absListView2.getHeight() * i3) / AbsListView.this.getChildCount()) / 300.0f;
            this.mMaxVeloctiy = height;
            this.mAccerleration = height / 100.0f;
            this.mCurrVelocity = 0.0f;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStatus = 0;
            this.lastMotionY = 0;
            AbsListView absListView4 = AbsListView.this;
            this.mTargetPosition = absListView4.mItemCount - 1;
            if (i3 != 1) {
                z16 = false;
            }
            this.mUseViscousFluid = z16;
            absListView4.postOnAnimation(this);
        }

        void stop() {
            AbsListView.this.removeCallbacks(this);
            AbsListView.this.mScrollToBottom = false;
        }
    }

    /* compiled from: P */
    @SuppressLint({"NewApi"})
    /* loaded from: classes27.dex */
    public interface MultiChoiceModeListener extends ActionMode.Callback {
        void onItemCheckedStateChanged(ActionMode actionMode, int i3, long j3, boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @SuppressLint({"NewApi"})
    /* loaded from: classes27.dex */
    public class MultiChoiceModeWrapper implements MultiChoiceModeListener {
        static IPatchRedirector $redirector_;
        private MultiChoiceModeListener mWrapped;

        MultiChoiceModeWrapper() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsListView.this);
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) actionMode, (Object) menuItem)).booleanValue();
            }
            return this.mWrapped.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) actionMode, (Object) menu)).booleanValue();
            }
            if (!this.mWrapped.onCreateActionMode(actionMode, menu)) {
                return false;
            }
            AbsListView.this.setLongClickable(false);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) actionMode);
                return;
            }
            this.mWrapped.onDestroyActionMode(actionMode);
            AbsListView absListView = AbsListView.this;
            absListView.mChoiceActionMode = null;
            absListView.clearChoices();
            AbsListView absListView2 = AbsListView.this;
            absListView2.mDataChanged = true;
            absListView2.rememberSyncState();
            AbsListView.this.requestLayout();
            AbsListView.this.setLongClickable(true);
        }

        @Override // com.tencent.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i3, long j3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, actionMode, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16));
                return;
            }
            this.mWrapped.onItemCheckedStateChanged(actionMode, i3, j3, z16);
            if (AbsListView.this.getCheckedItemCount() == 0) {
                actionMode.finish();
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) actionMode, (Object) menu)).booleanValue();
            }
            return this.mWrapped.onPrepareActionMode(actionMode, menu);
        }

        public void setWrapped(MultiChoiceModeListener multiChoiceModeListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) multiChoiceModeListener);
            } else {
                this.mWrapped = multiChoiceModeListener;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnNestedScrollingListener {
        int onNestedScrolling(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnOverScrollListener {
        void onOverScroll(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnScrollButtomListener {
        void onScrollToButtom(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        void onScroll(AbsListView absListView, int i3, int i16, int i17);

        void onScrollStateChanged(AbsListView absListView, int i3);
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsListView.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AbsListView absListView = AbsListView.this;
            if (absListView.mDataChanged) {
                return;
            }
            ListAdapter listAdapter = absListView.mAdapter;
            int i3 = this.mClickMotionPosition;
            boolean isValidPosition = absListView.isValidPosition(i3, listAdapter.getCount());
            if (listAdapter != null) {
                if ((isValidPosition || AbsListView.this.mCallbackOnUnClickItem) && sameWindow()) {
                    AbsListView absListView2 = AbsListView.this;
                    View childAt = absListView2.getChildAt(i3 - absListView2.mFirstPosition);
                    if (childAt != null || AbsListView.this.mCallbackOnUnClickItem) {
                        AbsListView absListView3 = AbsListView.this;
                        if (isValidPosition) {
                            j3 = listAdapter.getItemId(i3);
                        } else {
                            j3 = 0;
                        }
                        absListView3.performItemClick(childAt, i3, j3);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class PositionScroller implements Runnable {
        static IPatchRedirector $redirector_ = null;
        private static final int MOVE_DOWN_BOUND = 3;
        private static final int MOVE_DOWN_POS = 1;
        private static final int MOVE_OFFSET = 5;
        private static final int MOVE_UP_BOUND = 4;
        private static final int MOVE_UP_POS = 2;
        private static final int SCROLL_DURATION = 400;
        private int mBoundPos;
        private final int mExtraScroll;
        private int mLastSeenPos;
        private int mMode;
        private int mOffsetFromTop;
        private int mScrollDuration;
        private int mTargetPos;

        PositionScroller() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsListView.this);
            } else {
                this.mExtraScroll = ViewConfiguration.get(AbsListView.this.getContext()).getScaledFadingEdgeLength();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            int height = AbsListView.this.getHeight();
            AbsListView absListView = AbsListView.this;
            int i17 = absListView.mFirstPosition;
            int i18 = this.mMode;
            int i19 = 0;
            if (i18 != 1) {
                if (i18 != 2) {
                    if (i18 != 3) {
                        if (i18 != 4) {
                            if (i18 == 5) {
                                if (this.mLastSeenPos == i17) {
                                    absListView.postOnAnimation(this);
                                    return;
                                }
                                this.mLastSeenPos = i17;
                                int childCount = absListView.getChildCount();
                                int i26 = this.mTargetPos;
                                int i27 = (i17 + childCount) - 1;
                                if (i26 < i17) {
                                    i19 = (i17 - i26) + 1;
                                } else if (i26 > i27) {
                                    i19 = i26 - i27;
                                }
                                float min = Math.min(Math.abs(i19 / childCount), 1.0f);
                                if (i26 < i17) {
                                    AbsListView.this.smoothScrollBy((int) ((-r1.getHeight()) * min), this.mScrollDuration);
                                    AbsListView.this.postOnAnimation(this);
                                    return;
                                } else if (i26 > i27) {
                                    AbsListView.this.smoothScrollBy((int) (r1.getHeight() * min), this.mScrollDuration);
                                    AbsListView.this.postOnAnimation(this);
                                    return;
                                } else {
                                    int top = AbsListView.this.getChildAt(i26 - i17).getTop() - this.mOffsetFromTop;
                                    AbsListView.this.smoothScrollBy(top, Math.abs((int) (this.mScrollDuration * (top / AbsListView.this.getHeight()))));
                                    return;
                                }
                            }
                            return;
                        }
                        int childCount2 = absListView.getChildCount() - 2;
                        if (childCount2 < 0) {
                            return;
                        }
                        int i28 = i17 + childCount2;
                        if (i28 == this.mLastSeenPos) {
                            AbsListView.this.postOnAnimation(this);
                            return;
                        }
                        View childAt = AbsListView.this.getChildAt(childCount2);
                        int height2 = childAt.getHeight();
                        int top2 = childAt.getTop();
                        int i29 = height - top2;
                        this.mLastSeenPos = i28;
                        if (i28 > this.mBoundPos) {
                            AbsListView.this.smoothScrollBy(-(i29 - this.mExtraScroll), this.mScrollDuration);
                            AbsListView.this.postOnAnimation(this);
                            return;
                        }
                        int i36 = height - this.mExtraScroll;
                        int i37 = top2 + height2;
                        if (i36 > i37) {
                            AbsListView.this.smoothScrollBy(-(i36 - i37), this.mScrollDuration);
                            return;
                        }
                        return;
                    }
                    int childCount3 = absListView.getChildCount();
                    if (i17 != this.mBoundPos && childCount3 > 1) {
                        int i38 = childCount3 + i17;
                        AbsListView absListView2 = AbsListView.this;
                        if (i38 < absListView2.mItemCount) {
                            int i39 = i17 + 1;
                            if (i39 == this.mLastSeenPos) {
                                absListView2.postOnAnimation(this);
                                return;
                            }
                            View childAt2 = absListView2.getChildAt(1);
                            int height3 = childAt2.getHeight();
                            int top3 = childAt2.getTop();
                            int i46 = this.mExtraScroll;
                            if (i39 < this.mBoundPos) {
                                AbsListView.this.smoothScrollBy(Math.max(0, (height3 + top3) - i46), this.mScrollDuration);
                                this.mLastSeenPos = i39;
                                AbsListView.this.postOnAnimation(this);
                                return;
                            } else {
                                if (top3 > i46) {
                                    AbsListView.this.smoothScrollBy(top3 - i46, this.mScrollDuration);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(AdapterView.TAG, 2, " MOVE_UP_POS:firstPos=", Integer.valueOf(i17), " mLastSeenPos=", Integer.valueOf(this.mLastSeenPos), " mTargetPos", Integer.valueOf(this.mTargetPos));
                }
                if (i17 == this.mLastSeenPos && i17 <= this.mTargetPos) {
                    return;
                }
                if (AbsListView.this.mIsNeedScrollPositionTop && this.mTargetPos == 0) {
                    int childCount4 = AbsListView.this.getChildCount();
                    AbsListView absListView3 = AbsListView.this;
                    int i47 = 30;
                    if (absListView3.mItemCount > 30 && (i17 + childCount4) - 1 > (childCount4 * 3) - 1) {
                        int i48 = (this.mScrollDuration * childCount4) / 2;
                        if (i48 >= 30) {
                            i47 = i48;
                        }
                        int height4 = absListView3.getHeight();
                        AbsListView absListView4 = AbsListView.this;
                        Rect rect = absListView4.mListPadding;
                        absListView4.smoothScrollBy(-((height4 - rect.top) - rect.bottom), i47);
                        if (QLog.isColorLevel()) {
                            QLog.d(AdapterView.TAG, 2, "fight.scroolTop..firstPos = " + i17 + ",targetPos = " + this.mTargetPos + ",duration = " + i47 + ",childCount " + childCount4);
                        }
                        this.mLastSeenPos = i17;
                        AbsListView.this.postOnAnimation(this);
                        return;
                    }
                }
                View childAt3 = AbsListView.this.getChildAt(0);
                if (childAt3 == null) {
                    return;
                }
                int top4 = childAt3.getTop();
                if (i17 > 0) {
                    i16 = this.mExtraScroll;
                } else {
                    i16 = AbsListView.this.mListPadding.top;
                }
                AbsListView.this.smoothScrollBy(top4 - i16, this.mScrollDuration);
                this.mLastSeenPos = i17;
                if (i17 > this.mTargetPos) {
                    AbsListView.this.postOnAnimation(this);
                    return;
                }
                return;
            }
            int childCount5 = absListView.getChildCount() - 1;
            int i49 = i17 + childCount5;
            if (childCount5 < 0) {
                return;
            }
            if (!AbsListView.this.mIsNeedScrollPositionTop && i49 == this.mLastSeenPos) {
                AbsListView.this.postOnAnimation(this);
                return;
            }
            if (AbsListView.this.mIsNeedScrollPositionTop && i49 >= (i3 = this.mTargetPos) && i17 <= i3) {
                AbsListView.this.smoothScrollBy(AbsListView.this.getChildAt(i3 - i17).getTop(), 200);
                if (QLog.isColorLevel()) {
                    QLog.d(AdapterView.TAG, 2, "fight.scroolTop..firstPos = " + i17 + ",targetPos = " + this.mTargetPos);
                    return;
                }
                return;
            }
            View childAt4 = AbsListView.this.getChildAt(childCount5);
            int height5 = childAt4.getHeight();
            int top5 = height - childAt4.getTop();
            AbsListView absListView5 = AbsListView.this;
            int i56 = top5 - absListView5.mListPadding.bottom;
            if (i49 < this.mTargetPos && i49 < absListView5.mItemCount - 1) {
                i19 = this.mExtraScroll;
            }
            absListView5.smoothScrollBy((height5 - i56) + i19, this.mScrollDuration);
            this.mLastSeenPos = i49;
            if (i49 < this.mTargetPos) {
                AbsListView.this.postOnAnimation(this);
            }
        }

        void start(int i3) {
            int i16;
            stop();
            AbsListView absListView = AbsListView.this;
            int i17 = absListView.mFirstPosition;
            int childCount = (absListView.getChildCount() + i17) - 1;
            if (i3 <= i17) {
                i16 = (i17 - i3) + 1;
                this.mMode = 2;
            } else if (i3 < childCount) {
                if (!AbsListView.this.mIsNeedScrollPositionTop) {
                    return;
                }
                i16 = i3 - i17;
                this.mMode = 1;
            } else {
                i16 = (i3 - childCount) + 1;
                this.mMode = 1;
            }
            if (i16 > 0) {
                this.mScrollDuration = 400 / i16;
            } else {
                this.mScrollDuration = 400;
            }
            this.mTargetPos = i3;
            this.mBoundPos = -1;
            this.mLastSeenPos = -1;
            AbsListView.this.postOnAnimation(this);
        }

        void startWithOffset(int i3, int i16) {
            startWithOffset(i3, i16, 400);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void stop() {
            AbsListView.this.removeCallbacks(this);
            if (AbsListView.this.mBottomScroller != null) {
                AbsListView.this.mBottomScroller.stop();
            }
        }

        void startWithOffset(int i3, int i16, int i17) {
            int i18;
            stop();
            this.mTargetPos = i3;
            this.mOffsetFromTop = i16;
            this.mBoundPos = -1;
            this.mLastSeenPos = -1;
            this.mMode = 5;
            AbsListView absListView = AbsListView.this;
            int i19 = absListView.mFirstPosition;
            int childCount = absListView.getChildCount();
            int i26 = (i19 + childCount) - 1;
            if (i3 < i19) {
                i18 = i19 - i3;
            } else {
                if (i3 <= i26) {
                    AbsListView.this.smoothScrollBy(AbsListView.this.getChildAt(i3 - i19).getTop() - i16, i17);
                    return;
                }
                i18 = i3 - i26;
            }
            this.mScrollDuration = (int) (i17 / (i18 / childCount));
            this.mLastSeenPos = -1;
            AbsListView.this.postOnAnimation(this);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void start(int i3, int i16) {
            int i17;
            int i18;
            int i19;
            stop();
            if (i16 == -1) {
                start(i3);
                return;
            }
            AbsListView absListView = AbsListView.this;
            int i26 = absListView.mFirstPosition;
            int childCount = (absListView.getChildCount() + i26) - 1;
            if (i3 > i26) {
                if (i3 < childCount || (i17 = i16 - i26) < 1) {
                    return;
                }
                i18 = (i3 - childCount) + 1;
                i19 = i17 - 1;
                if (i19 < i18) {
                    this.mMode = 3;
                    if (i19 <= 0) {
                    }
                    this.mTargetPos = i3;
                    this.mBoundPos = i16;
                    this.mLastSeenPos = -1;
                    AbsListView.this.postOnAnimation(this);
                }
                this.mMode = 1;
                i19 = i18;
                if (i19 <= 0) {
                }
                this.mTargetPos = i3;
                this.mBoundPos = i16;
                this.mLastSeenPos = -1;
                AbsListView.this.postOnAnimation(this);
            }
            int i27 = childCount - i16;
            if (i27 < 1) {
                return;
            }
            i19 = (i26 - i3) + 1;
            i18 = i27 - 1;
            if (i18 < i19) {
                this.mMode = 4;
                i19 = i18;
                if (i19 <= 0) {
                    this.mScrollDuration = 400 / i19;
                } else {
                    this.mScrollDuration = 400;
                }
                this.mTargetPos = i3;
                this.mBoundPos = i16;
                this.mLastSeenPos = -1;
                AbsListView.this.postOnAnimation(this);
            }
            this.mMode = 2;
            if (i19 <= 0) {
            }
            this.mTargetPos = i3;
            this.mBoundPos = i16;
            this.mLastSeenPos = -1;
            AbsListView.this.postOnAnimation(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class RecycleBin {
        static IPatchRedirector $redirector_;
        private View[] mActiveViews;
        private ArrayList<View> mCurrentScrap;
        private int mFirstActivePosition;
        private RecyclerListener mRecyclerListener;
        private ArrayList<View>[] mScrapViews;
        private int mViewTypeCount;

        RecycleBin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsListView.this);
            } else {
                this.mActiveViews = new View[0];
            }
        }

        private void pruneScrapViews() {
            int length = this.mActiveViews.length;
            int i3 = this.mViewTypeCount;
            ArrayList<View>[] arrayListArr = this.mScrapViews;
            for (int i16 = 0; i16 < i3; i16++) {
                ArrayList<View> arrayList = arrayListArr[i16];
                int size = arrayList.size();
                int i17 = size - length;
                int i18 = size - 1;
                int i19 = 0;
                while (i19 < i17) {
                    AbsListView.this.removeDetachedView(arrayList.remove(i18), false);
                    i19++;
                    i18--;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void addScrapView(View view, int i3) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (!(layoutParams instanceof LayoutParams)) {
                QLog.e(AdapterView.TAG, 1, "addScrapView fail, layoutParams in not subtype of AbsListView.LayoutParams");
                return;
            }
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int i16 = layoutParams2.viewType;
            if (!shouldRecycleViewType(i16)) {
                if (i16 != -2) {
                    AbsListView.this.removeDetachedView(view, false);
                    return;
                }
                return;
            }
            layoutParams2.scrappedFromPosition = i3;
            if (this.mViewTypeCount == 1) {
                AbsListView.this.dispatchStartTemporaryDetachForView(view);
                this.mCurrentScrap.add(view);
            } else {
                AbsListView.this.dispatchStartTemporaryDetachForView(view);
                ArrayList<View>[] arrayListArr = this.mScrapViews;
                if (i16 < arrayListArr.length) {
                    arrayListArr[i16].add(view);
                }
            }
            RecyclerListener recyclerListener = this.mRecyclerListener;
            if (recyclerListener != null) {
                recyclerListener.onMovedToScrapHeap(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void clear() {
            int i3 = this.mViewTypeCount;
            if (i3 == 1) {
                ArrayList<View> arrayList = this.mCurrentScrap;
                int size = arrayList.size();
                for (int i16 = 0; i16 < size; i16++) {
                    AbsListView.this.removeDetachedView(arrayList.remove((size - 1) - i16), false);
                }
                return;
            }
            for (int i17 = 0; i17 < i3; i17++) {
                ArrayList<View> arrayList2 = this.mScrapViews[i17];
                int size2 = arrayList2.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    AbsListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i18), false);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void fillActiveViews(int i3, int i16) {
            if (this.mActiveViews.length < i3) {
                this.mActiveViews = new View[i3];
            }
            this.mFirstActivePosition = i16;
            View[] viewArr = this.mActiveViews;
            for (int i17 = 0; i17 < i3; i17++) {
                View childAt = AbsListView.this.getChildAt(i17);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.viewType != -2) {
                    viewArr[i17] = childAt;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View getActiveView(int i3) {
            int i16 = i3 - this.mFirstActivePosition;
            View[] viewArr = this.mActiveViews;
            if (i16 < 0 || i16 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i16];
            viewArr[i16] = null;
            return view;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View getScrapView(int i3) {
            ArrayList<View>[] arrayListArr;
            if (this.mViewTypeCount == 1) {
                return AbsListView.this.retrieveFromScrap(this.mCurrentScrap, i3);
            }
            int itemViewType = AbsListView.this.mAdapter.getItemViewType(i3);
            if (itemViewType >= 0 && (arrayListArr = this.mScrapViews) != null && itemViewType < arrayListArr.length) {
                return AbsListView.this.retrieveFromScrap(arrayListArr[itemViewType], i3);
            }
            return null;
        }

        public void markChildrenDirty() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            int i3 = this.mViewTypeCount;
            if (i3 == 1) {
                ArrayList<View> arrayList = this.mCurrentScrap;
                int size = arrayList.size();
                for (int i16 = 0; i16 < size; i16++) {
                    arrayList.get(i16).forceLayout();
                }
                return;
            }
            for (int i17 = 0; i17 < i3; i17++) {
                ArrayList<View> arrayList2 = this.mScrapViews[i17];
                int size2 = arrayList2.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    arrayList2.get(i18).forceLayout();
                }
            }
        }

        void reclaimScrapViews(List<View> list) {
            int i3 = this.mViewTypeCount;
            if (i3 == 1) {
                list.addAll(this.mCurrentScrap);
                return;
            }
            ArrayList<View>[] arrayListArr = this.mScrapViews;
            for (int i16 = 0; i16 < i3; i16++) {
                list.addAll(arrayListArr[i16]);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void scrapActiveViews() {
            boolean z16;
            boolean z17;
            View[] viewArr = this.mActiveViews;
            if (this.mRecyclerListener != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.mViewTypeCount > 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            ArrayList<View> arrayList = this.mCurrentScrap;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    int i3 = layoutParams.viewType;
                    viewArr[length] = null;
                    if (!shouldRecycleViewType(i3)) {
                        if (i3 != -2) {
                            AbsListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z17) {
                            arrayList = this.mScrapViews[i3];
                        }
                        AbsListView.this.dispatchStartTemporaryDetachForView(view);
                        layoutParams.scrappedFromPosition = this.mFirstActivePosition + length;
                        arrayList.add(view);
                        if (z16) {
                            this.mRecyclerListener.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            pruneScrapViews();
        }

        void setCacheColorHint(int i3) {
            int i16 = this.mViewTypeCount;
            if (i16 == 1) {
                ArrayList<View> arrayList = this.mCurrentScrap;
                int size = arrayList.size();
                for (int i17 = 0; i17 < size; i17++) {
                    arrayList.get(i17).setDrawingCacheBackgroundColor(i3);
                }
            } else {
                for (int i18 = 0; i18 < i16; i18++) {
                    ArrayList<View> arrayList2 = this.mScrapViews[i18];
                    int size2 = arrayList2.size();
                    for (int i19 = 0; i19 < size2; i19++) {
                        arrayList2.get(i19).setDrawingCacheBackgroundColor(i3);
                    }
                }
            }
            for (View view : this.mActiveViews) {
                if (view != null) {
                    view.setDrawingCacheBackgroundColor(i3);
                }
            }
        }

        public void setViewTypeCount(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (i3 >= 1) {
                ArrayList<View>[] arrayListArr = new ArrayList[i3];
                for (int i16 = 0; i16 < i3; i16++) {
                    arrayListArr[i16] = new ArrayList<>();
                }
                this.mViewTypeCount = i3;
                this.mCurrentScrap = arrayListArr[0];
                this.mScrapViews = arrayListArr;
                return;
            }
            throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
        }

        public boolean shouldRecycleViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
            }
            if (i3 >= 0) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface RecyclerListener {
        void onMovedToScrapHeap(View view);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface SelectionBoundsAdjuster {
        void adjustListItemSelectionBounds(Rect rect);
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsListView.this);
            }
        }

        public void rememberWindowAttachCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.mOriginalAttachCount = AbsListView.this.getWindowAttachCount();
            }
        }

        public boolean sameWindow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (AbsListView.this.hasWindowFocus() && AbsListView.this.getWindowAttachCount() == this.mOriginalAttachCount) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class a extends InputConnectionWrapper {
        static IPatchRedirector $redirector_;

        a(InputConnection inputConnection, boolean z16) {
            super(inputConnection, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AbsListView.this, inputConnection, Boolean.valueOf(z16));
            }
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean performEditorAction(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
            }
            if (i3 != 6) {
                return false;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) AbsListView.this.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(AbsListView.this.getWindowToken(), 0);
                return true;
            }
            return true;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean reportFullscreenMode(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, z16)).booleanValue();
            }
            return AbsListView.this.mDefInputConnection.reportFullscreenMode(z16);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) keyEvent)).booleanValue();
            }
            return AbsListView.this.mDefInputConnection.sendKeyEvent(keyEvent);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38013);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 171)) {
            redirector.redirect((short) 171);
        } else {
            LISTVIEW_STYLEABLE = new int[]{R.attr.listSelector, R.attr.drawSelectorOnTop, R.attr.stackFromBottom, R.attr.scrollingCache, R.attr.textFilterEnabled, R.attr.transcriptMode, R.attr.cacheColorHint, R.attr.fastScrollEnabled, R.attr.smoothScrollbar, R.attr.choiceMode, R.attr.fastScrollAlwaysVisible};
            NOTHING = new int[]{0};
        }
    }

    public AbsListView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.mChoiceMode = 0;
        this.mLayoutMode = 0;
        this.mEdgeEffectEnabled = false;
        this.mDeferNotifyDataSetChanged = false;
        this.mDrawSelectorOnTop = false;
        this.mSelectorPosition = -1;
        this.mSelectorRect = new Rect();
        this.mRecycler = new RecycleBin();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mListPadding = new Rect();
        this.mWidthMeasureSpec = 0;
        this.mTouchMode = -1;
        this.mSelectedTop = 0;
        this.mOnScrollListenerList = new ArrayList<>();
        this.mSmoothScrollbarEnabled = true;
        this.mResurrectToPosition = -1;
        this.mContextMenuInfo = null;
        this.mLastTouchMode = -1;
        this.mScrollProfilingStarted = false;
        this.mFlingProfilingStarted = false;
        this.mScrollStrictSpan = null;
        this.mFlingStrictSpan = null;
        this.mForHongBao = false;
        this.mForContacts = false;
        this.mEnableStory = false;
        this.mForStory = false;
        this.mLastScrollState = 0;
        this.mVelocityScale = 1.0f;
        this.mIsScrap = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        this.mOverScrollTouchMode = 0;
        this.mCallbackOnUnClickItem = false;
        this.mDisableOverScrollTop = false;
        this.method = null;
        this.mNeedCheckSpringback = false;
        initAbsListView();
        setVerticalScrollBarEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(AdapterView.getStyleableValues("View"));
        QQViewCompatUtil.refelctViewInitializeScrollbars(this, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    private boolean acceptFilter() {
        if (this.mTextFilterEnabled && (getAdapter() instanceof Filterable) && ((Filterable) getAdapter()).getFilter() != null) {
            return true;
        }
        return false;
    }

    private boolean checkScrap(ArrayList<View> arrayList) {
        boolean z16 = true;
        if (arrayList == null) {
            return true;
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = arrayList.get(i3);
            if (view.getParent() != null) {
                z16 = false;
            }
            if (indexOfChild(view) >= 0) {
                z16 = false;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScrollingCache() {
        if (this.mClearScrollingCache == null) {
            this.mClearScrollingCache = new Runnable() { // from class: com.tencent.widget.AbsListView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsListView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    AbsListView absListView = AbsListView.this;
                    if (absListView.mCachingStarted) {
                        absListView.mCachingActive = false;
                        absListView.mCachingStarted = false;
                        absListView.setChildrenDrawnWithCacheEnabled(false);
                        if ((AbsListView.this.getQQPersistentDrawingCache() & 2) == 0) {
                            AbsListView.this.setChildrenDrawingCacheEnabled(false);
                        }
                        if (!AbsListView.this.isAlwaysDrawnWithCacheEnabled()) {
                            AbsListView.this.invalidate();
                        }
                    }
                }
            };
        }
        Handler handler = getHandler();
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(this.mClearScrollingCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean contentFits() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.mItemCount) {
            return false;
        }
        if (getChildAt(0).getTop() >= this.mListPadding.top && getChildAt(childCount - 1).getBottom() <= getHeight() - this.mListPadding.bottom) {
            return true;
        }
        return false;
    }

    private void createScrollingCache() {
        if (this.mScrollingCacheEnabled && !this.mCachingStarted) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.mCachingActive = true;
            this.mCachingStarted = true;
        }
    }

    private void createTextFilter(boolean z16) {
        if (this.mPopup == null) {
            Context context = getContext();
            PopupWindow popupWindow = new PopupWindow(context);
            EditText editText = (EditText) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.tencent.mobileqq.R.layout.c2d, (ViewGroup) null);
            this.mTextFilter = editText;
            editText.setRawInputType(177);
            this.mTextFilter.setImeOptions(268435456);
            this.mTextFilter.addTextChangedListener(this);
            popupWindow.setFocusable(false);
            popupWindow.setTouchable(false);
            popupWindow.setInputMethodMode(2);
            popupWindow.setContentView(this.mTextFilter);
            popupWindow.setWidth(-2);
            popupWindow.setHeight(-2);
            popupWindow.setBackgroundDrawable(null);
            this.mPopup = popupWindow;
            getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.mGlobalLayoutListenerAddedFilter = true;
        }
        if (z16) {
            this.mPopup.setAnimationStyle(com.tencent.mobileqq.R.style.f173306p);
        } else {
            this.mPopup.setAnimationStyle(com.tencent.mobileqq.R.style.f173307q);
        }
    }

    private void dismissPopup() {
        PopupWindow popupWindow = this.mPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchStartTemporaryDetachForView(View view) {
        onDetachChildView(view);
        try {
            if (this.method == null) {
                this.method = View.class.getMethod("dispatchStartTemporaryDetach", new Class[0]);
            }
            this.method.invoke(view, new Object[0]);
        } catch (Exception unused) {
            view.onStartTemporaryDetach();
        }
    }

    private void drawSelector(Canvas canvas) {
        if (!this.mSelectorRect.isEmpty()) {
            Drawable drawable = this.mSelector;
            drawable.setBounds(this.mSelectorRect);
            drawable.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(9)
    public Object enterCriticalSpan(String str) {
        return null;
    }

    private void finishGlows() {
        EdgeEffect edgeEffect = this.mEdgeGlowTop;
        if (edgeEffect != null) {
            edgeEffect.finish();
            this.mEdgeGlowBottom.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(9)
    public Object finishSpan(Object obj) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getDistance(Rect rect, Rect rect2, int i3) {
        int width;
        int height;
        int width2;
        int i16;
        int height2;
        int i17;
        if (i3 != 1 && i3 != 2) {
            if (i3 != 17) {
                if (i3 != 33) {
                    if (i3 != 66) {
                        if (i3 == 130) {
                            width = rect.left + (rect.width() / 2);
                            height = rect.bottom;
                            width2 = rect2.left + (rect2.width() / 2);
                            i17 = rect2.top;
                        } else {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
                        }
                    } else {
                        width = rect.right;
                        height = (rect.height() / 2) + rect.top;
                        width2 = rect2.left;
                        i16 = rect2.top;
                        height2 = rect2.height() / 2;
                    }
                } else {
                    width = rect.left + (rect.width() / 2);
                    height = rect.top;
                    width2 = rect2.left + (rect2.width() / 2);
                    i17 = rect2.bottom;
                }
                int i18 = width2 - width;
                int i19 = i17 - height;
                return (i19 * i19) + (i18 * i18);
            }
            width = rect.left;
            height = (rect.height() / 2) + rect.top;
            width2 = rect2.right;
            i16 = rect2.top;
            height2 = rect2.height() / 2;
        } else {
            width = rect.right + (rect.width() / 2);
            height = (rect.height() / 2) + rect.top;
            width2 = rect2.left + (rect2.width() / 2);
            i16 = rect2.top;
            height2 = rect2.height() / 2;
        }
        i17 = height2 + i16;
        int i182 = width2 - width;
        int i192 = i17 - height;
        return (i192 * i192) + (i182 * i182);
    }

    @TargetApi(9)
    private void initAbsListView() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        float f16 = getResources().getDisplayMetrics().density;
        this.mOverscrollDistance = (int) ((0.0f * f16) + 0.5f);
        int i3 = (int) ((f16 * 30.0f) + 0.5f);
        this.mBottomOverflingDistance = i3;
        this.mTopOverflingDistance = i3;
        this.mDensityScale = getContext().getResources().getDisplayMetrics().density;
        setOverScrollMode(0);
        setVerticalFadingEdgeEnabled(false);
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidPosition(int i3, int i16) {
        if (this.mItemCount > 0 && i3 != -1 && i3 < i16) {
            return true;
        }
        return false;
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
            this.mMotionX = (int) motionEvent.getX(i3);
            this.mMotionY = (int) motionEvent.getY(i3);
            this.mMotionCorrection = 0;
            this.mActivePointerId = motionEvent.getPointerId(i3);
        }
    }

    private void positionPopup() {
        int i3 = getResources().getDisplayMetrics().heightPixels;
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int height = ((i3 - iArr[1]) - getHeight()) + ((int) (this.mDensityScale * 20.0f));
        if (!this.mPopup.isShowing()) {
            this.mPopup.showAtLocation(this, 81, iArr[0], height);
        } else {
            this.mPopup.update(iArr[0], height, -1, -1);
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private int reviseOverScrollByTouch(int i3) {
        if (getScrollY() * i3 < 0) {
            return i3;
        }
        int i16 = this.mLayoutHeight;
        if (i16 == 0) {
            return i3;
        }
        int i17 = this.mOverScrollTouchMode;
        if (i17 == 2) {
            return i3;
        }
        if (i17 == 1) {
            return ((((i16 - Math.abs(getScrollY())) * i3) / this.mLayoutHeight) * 2) / 3;
        }
        return (((i16 - Math.abs(getScrollY())) * i3) / this.mLayoutHeight) / 2;
    }

    @TargetApi(9)
    private void scrollIfNeeded(int i3) {
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int childCount;
        int i29;
        boolean z16;
        boolean z17;
        int i36;
        VelocityTracker velocityTracker;
        ViewParent parent;
        int i37 = i3 - this.mMotionY;
        int i38 = i37 - this.mMotionCorrection;
        int i39 = this.mLastY;
        if (i39 != Integer.MIN_VALUE) {
            i16 = i3 - i39;
        } else {
            i16 = i38;
        }
        int i46 = this.mTouchMode;
        if (i46 == 3) {
            if (this.mScrollStrictSpan == null) {
                this.mScrollStrictSpan = enterCriticalSpan("AbsListView-scroll");
            }
            if (i3 != this.mLastY) {
                if (!hasBooleanFlag(524288) && Math.abs(i37) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                int i47 = this.mMotionPosition;
                if (i47 >= 0) {
                    childCount = i47 - this.mFirstPosition;
                } else {
                    childCount = getChildCount() / 2;
                }
                View childAt = getChildAt(childCount);
                if (childAt != null) {
                    i29 = childAt.getTop();
                } else {
                    i29 = 0;
                }
                if (i16 != 0) {
                    z16 = trackMotionScroll(i38, i16);
                } else {
                    z16 = false;
                }
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    int top = childAt2.getTop();
                    if (z16) {
                        int i48 = (-i16) - (top - i29);
                        int reviseOverScrollByTouch = reviseOverScrollByTouch(i48);
                        if (this.mForHongBao && reviseOverScrollByTouch > 0) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        if (z17) {
                            i36 = 0;
                            overScrollBy(0, reviseOverScrollByTouch, 0, getScrollY(), 0, 0, 0, this.mOverscrollDistance, true);
                        } else {
                            i36 = 0;
                        }
                        if (Math.abs(this.mOverscrollDistance) == Math.abs(getScrollY()) && (velocityTracker = this.mVelocityTracker) != null) {
                            velocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (z17 && (overScrollMode == 0 || (overScrollMode == 1 && !contentFits()))) {
                            this.mDirection = i36;
                            this.mTouchMode = 5;
                            EdgeEffect edgeEffect = this.mEdgeGlowTop;
                            if (edgeEffect != null) {
                                if (i37 > 0) {
                                    edgeEffect.onPull(i48 / getHeight());
                                    if (!this.mEdgeGlowBottom.isFinished()) {
                                        this.mEdgeGlowBottom.onRelease();
                                    }
                                } else if (i37 < 0) {
                                    this.mEdgeGlowBottom.onPull(i48 / getHeight());
                                    if (!this.mEdgeGlowTop.isFinished()) {
                                        this.mEdgeGlowTop.onRelease();
                                    }
                                }
                            }
                        }
                    }
                    this.mMotionY = i3;
                    invalidate();
                }
                this.mLastY = i3;
                return;
            }
            return;
        }
        if (i46 == 5 && i3 != i39) {
            int scrollY = getScrollY();
            int i49 = scrollY - i16;
            if (i3 > this.mLastY) {
                i17 = 1;
            } else {
                i17 = -1;
            }
            if (this.mDirection == 0) {
                this.mDirection = i17;
            }
            int i56 = -i16;
            if ((i49 < 0 && scrollY >= 0) || (i49 > 0 && scrollY <= 0)) {
                int i57 = -scrollY;
                i19 = i16 + i57;
                i18 = i57;
            } else {
                i18 = i56;
                i19 = 0;
            }
            if (i18 != 0) {
                i26 = i19;
                int i58 = i18;
                i27 = i17;
                overScrollBy(0, reviseOverScrollByTouch(i18), 0, getScrollY(), 0, 0, 0, this.mOverscrollDistance, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !contentFits())) {
                    EdgeEffect edgeEffect2 = this.mEdgeGlowTop;
                    if (edgeEffect2 != null) {
                        if (i37 > 0) {
                            edgeEffect2.onPull(i58 / getHeight());
                            if (!this.mEdgeGlowBottom.isFinished()) {
                                this.mEdgeGlowBottom.onRelease();
                            }
                        } else if (i37 < 0) {
                            this.mEdgeGlowBottom.onPull(i58 / getHeight());
                            if (!this.mEdgeGlowTop.isFinished()) {
                                this.mEdgeGlowTop.onRelease();
                            }
                        }
                    }
                    invalidate();
                }
            } else {
                i26 = i19;
                i27 = i17;
            }
            if (i26 != 0) {
                setScrollY(0);
                invalidateParentIfNeeded();
                if (i26 != 0) {
                    trackMotionScroll(i26, i26);
                }
                this.mTouchMode = 3;
                int findClosestMotionRow = findClosestMotionRow(i3);
                this.mMotionCorrection = 0;
                View childAt3 = getChildAt(findClosestMotionRow - this.mFirstPosition);
                if (childAt3 != null) {
                    i28 = childAt3.getTop();
                } else {
                    i28 = 0;
                }
                this.mMotionViewOriginalTop = i28;
                this.mMotionY = i3;
                this.mMotionPosition = findClosestMotionRow;
            }
            this.mLastY = i3;
            this.mDirection = i27;
        }
    }

    private void showPopup() {
        if (getWindowVisibility() == 0) {
            createTextFilter(true);
            positionPopup();
            checkFocus();
        }
    }

    private void useDefaultSelector() {
        setSelector(getResources().getDrawable(R.drawable.list_selector_background));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abordFling() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 161)) {
            iPatchRedirector.redirect((short) 161, (Object) this);
            return;
        }
        FlingRunnable flingRunnable = this.mFlingRunnable;
        if (flingRunnable != null) {
            flingRunnable.endFling();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(api = 16)
    public void addChildrenForAccessibility(ArrayList<View> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, (Object) arrayList);
            return;
        }
        try {
            super.addChildrenForAccessibility(arrayList);
        } catch (IllegalArgumentException unused) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    if (QQViewCompatUtil.refelctViewIncludeForAccessibility(childAt)) {
                        arrayList.add(childAt);
                    } else {
                        childAt.addChildrenForAccessibility(arrayList);
                    }
                }
            }
        }
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) onScrollListener);
        } else {
            this.mOnScrollListenerList.add(onScrollListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 114)) {
            iPatchRedirector.redirect((short) 114, (Object) this, (Object) arrayList);
            return;
        }
        int childCount = getChildCount();
        int i3 = this.mFirstPosition;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return;
        }
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (listAdapter.isEnabled(i3 + i16)) {
                arrayList.add(childAt);
            }
            childAt.addTouchables(arrayList);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 140)) {
            iPatchRedirector.redirect((short) 140, (Object) this, (Object) editable);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 138)) {
            iPatchRedirector.redirect((short) 138, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 134)) {
            return ((Boolean) iPatchRedirector.redirect((short) 134, (Object) this, (Object) view)).booleanValue();
        }
        if (view == this.mTextFilter) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 145)) {
            return ((Boolean) iPatchRedirector.redirect((short) 145, (Object) this, (Object) layoutParams)).booleanValue();
        }
        return layoutParams instanceof LayoutParams;
    }

    public void clearChoices() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        SparseBooleanArray sparseBooleanArray = this.mCheckStates;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
        LongSparseArray<Integer> longSparseArray = this.mCheckedIdStates;
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
        this.mCheckedItemCount = 0;
    }

    public void clearTextFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 135)) {
            iPatchRedirector.redirect((short) 135, (Object) this);
            return;
        }
        if (this.mFiltered) {
            this.mTextFilter.setText("");
            this.mFiltered = false;
            PopupWindow popupWindow = this.mPopup;
            if (popupWindow != null && popupWindow.isShowing()) {
                dismissPopup();
            }
        }
    }

    @Override // android.view.View
    protected int computeVerticalScrollExtent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Integer) iPatchRedirector.redirect((short) 54, (Object) this)).intValue();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            return 0;
        }
        if (!this.mSmoothScrollbarEnabled) {
            return 1;
        }
        int i3 = childCount * 100;
        View childAt = getChildAt(0);
        int top = childAt.getTop();
        int height = childAt.getHeight();
        if (height > 0) {
            i3 += (top * 100) / height;
        }
        View childAt2 = getChildAt(childCount - 1);
        int bottom = childAt2.getBottom();
        int height2 = childAt2.getHeight();
        if (height2 > 0) {
            return i3 - (((bottom - getHeight()) * 100) / height2);
        }
        return i3;
    }

    @Override // android.view.View
    protected int computeVerticalScrollOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Integer) iPatchRedirector.redirect((short) 55, (Object) this)).intValue();
        }
        int i3 = this.mFirstPosition;
        int childCount = getChildCount();
        int i16 = 0;
        if (i3 >= 0 && childCount > 0) {
            if (this.mSmoothScrollbarEnabled) {
                View childAt = getChildAt(0);
                int top = childAt.getTop();
                int height = childAt.getHeight();
                if (height > 0) {
                    return Math.max((i3 * 100) - ((top * 100) / height), 0);
                }
            } else {
                int i17 = this.mItemCount;
                if (i3 != 0) {
                    if (i3 + childCount == i17) {
                        i16 = i17;
                    } else {
                        i16 = (childCount / 2) + i3;
                    }
                }
                return (int) (i3 + (childCount * (i16 / i17)));
            }
        }
        return 0;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Integer) iPatchRedirector.redirect((short) 56, (Object) this)).intValue();
        }
        if (this.mSmoothScrollbarEnabled) {
            return Math.max(this.mItemCount * 100, 0);
        }
        return this.mItemCount;
    }

    @TargetApi(11)
    void confirmCheckedPositionsById() {
        ActionMode actionMode;
        boolean z16;
        MultiChoiceModeWrapper multiChoiceModeWrapper;
        this.mCheckStates.clear();
        int i3 = 0;
        boolean z17 = false;
        while (i3 < this.mCheckedIdStates.size()) {
            long keyAt = this.mCheckedIdStates.keyAt(i3);
            int intValue = this.mCheckedIdStates.valueAt(i3).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.mItemCount);
                while (true) {
                    if (max < min) {
                        if (keyAt == this.mAdapter.getItemId(max)) {
                            this.mCheckStates.put(max, true);
                            this.mCheckedIdStates.setValueAt(i3, Integer.valueOf(max));
                            z16 = true;
                            break;
                        }
                        max++;
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    this.mCheckedIdStates.delete(keyAt);
                    i3--;
                    this.mCheckedItemCount--;
                    ActionMode actionMode2 = this.mChoiceActionMode;
                    if (actionMode2 != null && (multiChoiceModeWrapper = this.mMultiChoiceModeCallback) != null) {
                        multiChoiceModeWrapper.onItemCheckedStateChanged(actionMode2, intValue, keyAt, false);
                    }
                    z17 = true;
                }
            } else {
                this.mCheckStates.put(intValue, true);
            }
            i3++;
        }
        if (z17 && (actionMode = this.mChoiceActionMode) != null) {
            actionMode.invalidate();
        }
    }

    ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i3, long j3) {
        return new AdapterView.AdapterContextMenuInfo(view, i3, j3);
    }

    public void deferNotifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 152)) {
            iPatchRedirector.redirect((short) 152, (Object) this);
        } else {
            this.mDeferNotifyDataSetChanged = true;
        }
    }

    public void disableOverScrollTop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 167)) {
            iPatchRedirector.redirect((short) 167, (Object) this, z16);
        } else {
            this.mDisableOverScrollTop = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, (Object) canvas);
            return;
        }
        boolean hasBooleanFlag = hasBooleanFlag(34);
        if (hasBooleanFlag) {
            i3 = canvas.save();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            canvas.clipRect(getPaddingLeft() + scrollX, getPaddingTop() + scrollY, ((scrollX + getRight()) - getLeft()) - getPaddingRight(), ((scrollY + getBottom()) - getTop()) - getPaddingBottom());
            setBooleanFlag(34, true);
        } else {
            i3 = 0;
        }
        boolean z16 = this.mDrawSelectorOnTop;
        if (!z16) {
            drawSelector(canvas);
        }
        super.dispatchDraw(canvas);
        if (z16) {
            drawSelector(canvas);
        }
        if (hasBooleanFlag) {
            canvas.restoreToCount(i3);
            setBooleanFlag(34, true);
        }
    }

    protected void dispatchFinishTemporaryDetachForView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 157)) {
            iPatchRedirector.redirect((short) 157, (Object) this, (Object) view);
            return;
        }
        try {
            View.class.getMethod("dispatchFinishTemporaryDetach", new Class[0]).invoke(view, new Object[0]);
        } catch (Exception unused) {
            view.onFinishTemporaryDetach();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            iPatchRedirector.redirect((short) 96, (Object) this, z16);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action;
        int springbackOffset;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 164)) {
            return ((Boolean) iPatchRedirector.redirect((short) 164, (Object) this, (Object) motionEvent)).booleanValue();
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (this.mNeedCheckSpringback && (((action = motionEvent.getAction() & 255) == 1 || action == 3) && this.mTouchMode == -1 && Math.abs(getScrollY()) > this.mTouchSlop)) {
            if (this.mFlingRunnable == null) {
                this.mFlingRunnable = new FlingRunnable();
            }
            if (!this.mForHongBao && !this.mForStory) {
                springbackOffset = 0;
            } else {
                springbackOffset = getSpringbackOffset();
            }
            if (this.mForStory) {
                if (springbackOffset != getScrollY()) {
                    this.mFlingRunnable.startSpringback(springbackOffset);
                }
            } else {
                this.mFlingRunnable.startSpringback(springbackOffset);
            }
            if (QLog.isColorLevel()) {
                QLog.i("ListViewOverScroll", 2, this.mForHongBao + "| absList dispatchTouchEvent, getScrollY():" + getScrollY() + " targetY: " + springbackOffset);
            }
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doSpringBack(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 160)) {
            iPatchRedirector.redirect((short) 160, (Object) this, i3);
            return;
        }
        if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new FlingRunnable();
        }
        this.mFlingRunnable.startSpringback(i3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 110)) {
            iPatchRedirector.redirect((short) 110, (Object) this, (Object) canvas);
            return;
        }
        super.draw(canvas);
        if (this.mEdgeGlowTop != null) {
            int scrollY = getScrollY();
            if (!this.mEdgeGlowTop.isFinished()) {
                int save = canvas.save();
                Rect rect = this.mListPadding;
                int i3 = rect.left + this.mGlowPaddingLeft;
                int width = (getWidth() - i3) - (rect.right + this.mGlowPaddingRight);
                canvas.translate(i3, Math.min(0, this.mFirstPositionDistanceGuess + scrollY));
                this.mEdgeGlowTop.setSize(width, getHeight());
                if (this.mEdgeGlowTop.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.mEdgeGlowBottom.isFinished()) {
                int save2 = canvas.save();
                Rect rect2 = this.mListPadding;
                int width2 = (getWidth() - (rect2.left + this.mGlowPaddingLeft)) - (rect2.right + this.mGlowPaddingRight);
                int height = getHeight();
                canvas.translate((-width2) + r4, Math.max(height, scrollY + this.mLastPositionDistanceGuess));
                canvas.rotate(180.0f, width2, 0.0f);
                this.mEdgeGlowBottom.setSize(width2, height);
                if (this.mEdgeGlowBottom.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
        if (this.mFastScroller != null) {
            int scrollY2 = getScrollY();
            if (scrollY2 != 0) {
                int save3 = canvas.save();
                canvas.translate(0.0f, scrollY2);
                this.mFastScroller.draw(canvas);
                canvas.restoreToCount(save3);
                return;
            }
            this.mFastScroller.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this);
        } else {
            super.drawableStateChanged();
            updateSelectorState();
        }
    }

    abstract void fillGap(boolean z16);

    /* JADX INFO: Access modifiers changed from: protected */
    public int findClosestMotionRow(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 128)) {
            return ((Integer) iPatchRedirector.redirect((short) 128, (Object) this, i3)).intValue();
        }
        if (getChildCount() == 0) {
            return -1;
        }
        int findMotionRow = findMotionRow(i3);
        if (findMotionRow == -1) {
            return (this.mFirstPosition + r0) - 1;
        }
        return findMotionRow;
    }

    abstract int findMotionRow(int i3);

    protected void flingForCancel() {
        float yVelocity;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
            iPatchRedirector.redirect((short) 104, (Object) this);
            return;
        }
        int childCount = getChildCount();
        if (childCount > 0) {
            int top = getChildAt(0).getTop();
            int bottom = getChildAt(childCount - 1).getBottom();
            int i16 = this.mListPadding.top;
            int height = getHeight() - this.mListPadding.bottom;
            int i17 = this.mFirstPosition;
            if (i17 == 0 && top >= i16 && i17 + childCount < this.mItemCount && bottom <= getHeight() - height) {
                this.mTouchMode = -1;
                reportScrollStateChange(0);
                return;
            }
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            if (VersionUtils.isrFroyo()) {
                yVelocity = velocityTracker.getYVelocity(this.mActivePointerId);
            } else {
                yVelocity = velocityTracker.getYVelocity();
            }
            int i18 = (int) (yVelocity * this.mVelocityScale);
            if (Math.abs(i18) > this.mMinimumVelocity && (((i3 = this.mFirstPosition) != 0 || top != i16 - this.mOverscrollDistance) && (i3 + childCount != this.mItemCount || bottom != height + this.mOverscrollDistance))) {
                if (this.mFlingRunnable == null) {
                    this.mFlingRunnable = new FlingRunnable();
                }
                reportScrollStateChange(2);
                this.mFlingRunnable.start(-i18);
                return;
            }
            this.mTouchMode = -1;
            reportScrollStateChange(0);
            FlingRunnable flingRunnable = this.mFlingRunnable;
            if (flingRunnable != null) {
                flingRunnable.endFling();
            }
            PositionScroller positionScroller = this.mPositionScroller;
            if (positionScroller != null) {
                positionScroller.stop();
            }
            MoveToBottomScroller moveToBottomScroller = this.mBottomScroller;
            if (moveToBottomScroller != null) {
                moveToBottomScroller.stop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 142)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 142, (Object) this);
        }
        return new LayoutParams(-1, -2, 0);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Float) iPatchRedirector.redirect((short) 59, (Object) this)).floatValue();
        }
        int childCount = getChildCount();
        float bottomFadingEdgeStrength = super.getBottomFadingEdgeStrength();
        if (childCount == 0) {
            return bottomFadingEdgeStrength;
        }
        if ((this.mFirstPosition + childCount) - 1 < this.mItemCount - 1) {
            return 1.0f;
        }
        int bottom = getChildAt(childCount - 1).getBottom();
        int height = getHeight();
        float verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (bottom > height - getPaddingBottom()) {
            return ((bottom - height) + getPaddingBottom()) / verticalFadingEdgeLength;
        }
        return bottomFadingEdgeStrength;
    }

    @Override // android.view.View
    protected int getBottomPaddingOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return ((Integer) iPatchRedirector.redirect((short) 74, (Object) this)).intValue();
        }
        if (hasBooleanFlag(34)) {
            return 0;
        }
        return getPaddingBottom();
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 150)) {
            return ((Integer) iPatchRedirector.redirect((short) 150, (Object) this)).intValue();
        }
        return this.mCacheColorHint;
    }

    public int getCheckedItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.mCheckedItemCount;
    }

    public long[] getCheckedItemIds() {
        LongSparseArray<Integer> longSparseArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (long[]) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        if (this.mChoiceMode != 0 && (longSparseArray = this.mCheckedIdStates) != null && this.mAdapter != null) {
            int size = longSparseArray.size();
            long[] jArr = new long[size];
            for (int i3 = 0; i3 < size; i3++) {
                jArr[i3] = longSparseArray.keyAt(i3);
            }
            return jArr;
        }
        return new long[0];
    }

    public int getCheckedItemPosition() {
        SparseBooleanArray sparseBooleanArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        if (this.mChoiceMode == 1 && (sparseBooleanArray = this.mCheckStates) != null && sparseBooleanArray.size() == 1) {
            return this.mCheckStates.keyAt(0);
        }
        return -1;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (SparseBooleanArray) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (this.mChoiceMode != 0) {
            return this.mCheckStates;
        }
        return null;
    }

    public int getChoiceMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.mChoiceMode;
    }

    @Override // android.view.View
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            return (ContextMenu.ContextMenuInfo) iPatchRedirector.redirect((short) 91, (Object) this);
        }
        return this.mContextMenuInfo;
    }

    public float getFlingVelocity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 165)) {
            return ((Float) iPatchRedirector.redirect((short) 165, (Object) this)).floatValue();
        }
        FlingRunnable flingRunnable = this.mFlingRunnable;
        if (flingRunnable != null && flingRunnable.mScroller != null) {
            return this.mFlingRunnable.mScroller.getCurrVelocity();
        }
        return -1.0f;
    }

    public float getFlingVelocityY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 166)) {
            return ((Float) iPatchRedirector.redirect((short) 166, (Object) this)).floatValue();
        }
        FlingRunnable flingRunnable = this.mFlingRunnable;
        if (flingRunnable != null && flingRunnable.mScroller != null) {
            return this.mFlingRunnable.mScroller.getCurrVelocityY();
        }
        return -1.0f;
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) rect);
            return;
        }
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.getParent() == this) {
            selectedView.getFocusedRect(rect);
            offsetDescendantRectToMyCoords(selectedView, rect);
        } else {
            super.getFocusedRect(rect);
        }
    }

    int getFooterViewsCount() {
        return 0;
    }

    int getHeaderViewsCount() {
        return 0;
    }

    @Override // android.view.View
    protected int getLeftPaddingOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return ((Integer) iPatchRedirector.redirect((short) 71, (Object) this)).intValue();
        }
        if (hasBooleanFlag(34)) {
            return 0;
        }
        return -getPaddingLeft();
    }

    public int getListPaddingBottom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return ((Integer) iPatchRedirector.redirect((short) 65, (Object) this)).intValue();
        }
        return this.mListPadding.bottom;
    }

    public int getListPaddingLeft() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Integer) iPatchRedirector.redirect((short) 66, (Object) this)).intValue();
        }
        return this.mListPadding.left;
    }

    public int getListPaddingRight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return ((Integer) iPatchRedirector.redirect((short) 67, (Object) this)).intValue();
        }
        return this.mListPadding.right;
    }

    public int getListPaddingTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return ((Integer) iPatchRedirector.redirect((short) 64, (Object) this)).intValue();
        }
        return this.mListPadding.top;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            return ((Integer) iPatchRedirector.redirect((short) 99, (Object) this)).intValue();
        }
        return 0;
    }

    public OnScrollListener getOnScrollListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (OnScrollListener) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this.mOnScrollListener;
    }

    @Override // android.view.View
    public int getOverScrollMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 159)) {
            return ((Integer) iPatchRedirector.redirect((short) 159, (Object) this)).intValue();
        }
        return this.mOverScrollMode;
    }

    public int getRemainFlingDisY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 117)) {
            return ((Integer) iPatchRedirector.redirect((short) 117, (Object) this)).intValue();
        }
        FlingRunnable flingRunnable = this.mFlingRunnable;
        if (flingRunnable != null) {
            return flingRunnable.mScroller.getFinalY() - this.mFlingRunnable.mScroller.getCurrY();
        }
        return -1;
    }

    @Override // android.view.View
    protected int getRightPaddingOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return ((Integer) iPatchRedirector.redirect((short) 73, (Object) this)).intValue();
        }
        if (hasBooleanFlag(34)) {
            return 0;
        }
        return getPaddingRight();
    }

    @Override // com.tencent.widget.AdapterView
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (View) iPatchRedirector.redirect((short) 63, (Object) this);
        }
        int i16 = this.mItemCount;
        if (i16 > 0 && (i3 = this.mSelectedPosition) >= 0 && i3 < i16) {
            return getChildAt(i3 - this.mFirstPosition);
        }
        return null;
    }

    public Drawable getSelector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return (Drawable) iPatchRedirector.redirect((short) 79, (Object) this);
        }
        return this.mSelector;
    }

    @Override // android.view.View
    public int getSolidColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 148)) {
            return ((Integer) iPatchRedirector.redirect((short) 148, (Object) this)).intValue();
        }
        return this.mCacheColorHint;
    }

    protected int getSpringbackOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            return ((Integer) iPatchRedirector.redirect((short) 107, (Object) this)).intValue();
        }
        return 0;
    }

    public CharSequence getTextFilter() {
        EditText editText;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (CharSequence) iPatchRedirector.redirect((short) 51, (Object) this);
        }
        if (this.mTextFilterEnabled && (editText = this.mTextFilter) != null) {
            return editText.getText();
        }
        return null;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Float) iPatchRedirector.redirect((short) 58, (Object) this)).floatValue();
        }
        int childCount = getChildCount();
        float topFadingEdgeStrength = super.getTopFadingEdgeStrength();
        if (childCount == 0) {
            return topFadingEdgeStrength;
        }
        if (this.mFirstPosition > 0) {
            return 1.0f;
        }
        int top = getChildAt(0).getTop();
        float verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (top < getPaddingTop()) {
            return (-(top - getPaddingTop())) / verticalFadingEdgeLength;
        }
        return topFadingEdgeStrength;
    }

    @Override // android.view.View
    protected int getTopPaddingOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return ((Integer) iPatchRedirector.redirect((short) 72, (Object) this)).intValue();
        }
        if (hasBooleanFlag(34)) {
            return 0;
        }
        return -getPaddingTop();
    }

    public int getTranscriptMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 147)) {
            return ((Integer) iPatchRedirector.redirect((short) 147, (Object) this)).intValue();
        }
        return this.mTranscriptMode;
    }

    @Override // android.view.View
    public int getVerticalScrollbarWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        if (isFastScrollAlwaysVisible()) {
            return Math.max(super.getVerticalScrollbarWidth(), this.mFastScroller.getWidth());
        }
        return super.getVerticalScrollbarWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AdapterView
    public void handleDataChanged() {
        int i3;
        ListAdapter listAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 130)) {
            iPatchRedirector.redirect((short) 130, (Object) this);
            return;
        }
        int i16 = this.mItemCount;
        int i17 = this.mLastHandledItemCount;
        this.mLastHandledItemCount = i16;
        if (this.mChoiceMode != 0 && (listAdapter = this.mAdapter) != null && listAdapter.hasStableIds()) {
            confirmCheckedPositionsById();
        }
        int i18 = 3;
        if (i16 > 0) {
            if (this.mNeedSync) {
                this.mNeedSync = false;
                int i19 = this.mTranscriptMode;
                if (i19 == 2) {
                    this.mScrollToBottom = true;
                } else if (i19 == 1) {
                    if (this.mForceTranscriptScroll) {
                        this.mForceTranscriptScroll = false;
                        this.mScrollToBottom = true;
                    } else if (getChildCount() > 0) {
                        int childCount = getChildCount();
                        int height = getHeight() - getPaddingBottom();
                        View childAt = getChildAt(childCount - 1);
                        if (childAt != null) {
                            i3 = childAt.getBottom();
                        } else {
                            i3 = height;
                        }
                        if (this.mFirstPosition + childCount >= i17 && i3 <= height) {
                            this.mLayoutMode = 3;
                            return;
                        }
                    }
                }
                int i26 = this.mSyncMode;
                if (i26 != 0) {
                    if (i26 != 1) {
                        if (i26 == 2) {
                            this.mLayoutMode = 5;
                            this.mSyncPosition = Math.max(Math.min(this.mSyncPosition, i16 - 1), 0);
                            return;
                        }
                    } else {
                        this.mLayoutMode = 5;
                        this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i16 - 1);
                        return;
                    }
                } else {
                    if (isInTouchMode()) {
                        this.mLayoutMode = 5;
                        this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i16 - 1);
                        return;
                    }
                    int findSyncPosition = findSyncPosition();
                    if (findSyncPosition >= 0 && lookForSelectablePosition(findSyncPosition, true) == findSyncPosition) {
                        this.mSyncPosition = findSyncPosition;
                        if (this.mSyncHeight == getHeight()) {
                            this.mLayoutMode = 5;
                        } else {
                            this.mLayoutMode = 2;
                        }
                        setNextSelectedPositionInt(findSyncPosition);
                        return;
                    }
                }
            }
            if (!isInTouchMode()) {
                int selectedItemPosition = getSelectedItemPosition();
                if (selectedItemPosition >= i16) {
                    selectedItemPosition = i16 - 1;
                }
                if (selectedItemPosition < 0) {
                    selectedItemPosition = 0;
                }
                int lookForSelectablePosition = lookForSelectablePosition(selectedItemPosition, true);
                if (lookForSelectablePosition >= 0) {
                    setNextSelectedPositionInt(lookForSelectablePosition);
                    return;
                }
                int lookForSelectablePosition2 = lookForSelectablePosition(selectedItemPosition, false);
                if (lookForSelectablePosition2 >= 0) {
                    setNextSelectedPositionInt(lookForSelectablePosition2);
                    return;
                }
            } else if (this.mResurrectToPosition >= 0) {
                return;
            }
        }
        if (!this.mStackFromBottom) {
            i18 = 1;
        }
        this.mLayoutMode = i18;
        this.mSelectedPosition = -1;
        this.mSelectedRowId = Long.MIN_VALUE;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedRowId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mSelectorPosition = -1;
        checkSelectionChanged();
    }

    public boolean hasTextFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 136)) {
            return ((Boolean) iPatchRedirector.redirect((short) 136, (Object) this)).booleanValue();
        }
        return this.mFiltered;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hideSelector() {
        int i3 = this.mSelectedPosition;
        if (i3 != -1) {
            if (this.mLayoutMode != 4) {
                this.mResurrectToPosition = i3;
            }
            int i16 = this.mNextSelectedPosition;
            if (i16 >= 0 && i16 != i3) {
                this.mResurrectToPosition = i16;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.mSelectedTop = 0;
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this, (Object) drawable);
        } else if (verifyDrawable(drawable)) {
            invalidate(drawable.getBounds());
        }
    }

    public void invalidateViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 129)) {
            iPatchRedirector.redirect((short) 129, (Object) this);
            return;
        }
        this.mDataChanged = true;
        rememberSyncState();
        requestLayout();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invokeOnItemScrollListener() {
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller != null) {
            fastScroller.onScroll(this, this.mFirstPosition, getChildCount(), this.mItemCount);
        }
        OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(this, this.mFirstPosition, getChildCount(), this.mItemCount);
        }
        Iterator<OnScrollListener> it = this.mOnScrollListenerList.iterator();
        while (it.hasNext()) {
            it.next().onScroll(this, this.mFirstPosition, getChildCount(), this.mItemCount);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    public boolean isFastScrollAlwaysVisible() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        if (this.mFastScrollEnabled && this.mFastScroller.isAlwaysShowEnabled()) {
            return true;
        }
        return false;
    }

    @ViewDebug.ExportedProperty
    public boolean isFastScrollEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.mFastScrollEnabled;
    }

    protected boolean isInFilterMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 132)) {
            return ((Boolean) iPatchRedirector.redirect((short) 132, (Object) this)).booleanValue();
        }
        return this.mFiltered;
    }

    public boolean isItemChecked(int i3) {
        SparseBooleanArray sparseBooleanArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, i3)).booleanValue();
        }
        if (this.mChoiceMode != 0 && (sparseBooleanArray = this.mCheckStates) != null) {
            return sparseBooleanArray.get(i3);
        }
        return false;
    }

    @Override // android.view.View
    protected boolean isPaddingOffsetRequired() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return ((Boolean) iPatchRedirector.redirect((short) 70, (Object) this)).booleanValue();
        }
        return hasBooleanFlag(34);
    }

    @ViewDebug.ExportedProperty
    public boolean isScrollingCacheEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        return this.mScrollingCacheEnabled;
    }

    @ViewDebug.ExportedProperty
    public boolean isSmoothScrollbarEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        return this.mSmoothScrollbarEnabled;
    }

    @ViewDebug.ExportedProperty
    public boolean isStackFromBottom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this)).booleanValue();
        }
        return this.mStackFromBottom;
    }

    @ViewDebug.ExportedProperty
    public boolean isTextFilterEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Boolean) iPatchRedirector.redirect((short) 43, (Object) this)).booleanValue();
        }
        return this.mTextFilterEnabled;
    }

    protected boolean isVerticalScrollBarHidden() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller != null && fastScroller.isVisible()) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, (Object) this);
            return;
        }
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mSelector;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void keyPressed() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.mSelector;
            Rect rect = this.mSelectorRect;
            if (drawable != null) {
                if ((isFocused() || touchModeDrawsInPressedState()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                    if (childAt != null) {
                        if (childAt.hasFocusable()) {
                            return;
                        } else {
                            childAt.setPressed(true);
                        }
                    }
                    setPressed(true);
                    boolean isLongClickable = isLongClickable();
                    Drawable current = drawable.getCurrent();
                    if (current != null && (current instanceof TransitionDrawable)) {
                        if (isLongClickable) {
                            ((TransitionDrawable) current).startTransition(ViewConfiguration.getLongPressTimeout());
                        } else {
                            ((TransitionDrawable) current).resetTransition();
                        }
                    }
                    if (isLongClickable && !this.mDataChanged) {
                        if (this.mPendingCheckForKeyLongPress == null) {
                            this.mPendingCheckForKeyLongPress = new CheckForKeyLongPress();
                        }
                        this.mPendingCheckForKeyLongPress.rememberWindowAttachCount();
                        postDelayed(this.mPendingCheckForKeyLongPress, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this);
        }
    }

    protected AdapterDataSetObserver newObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            return (AdapterDataSetObserver) iPatchRedirector.redirect((short) 87, (Object) this);
        }
        return new AdapterDataSetObserver();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View obtainView(int i3, boolean[] zArr) {
        View view;
        zArr[0] = false;
        View scrapView = this.mRecycler.getScrapView(i3);
        if (scrapView != null) {
            view = this.mAdapter.getView(i3, scrapView, this);
            try {
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
            } catch (Exception unused) {
            }
            if (view != scrapView) {
                this.mRecycler.addScrapView(scrapView, i3);
                int i16 = this.mCacheColorHint;
                if (i16 != 0) {
                    view.setDrawingCacheBackgroundColor(i16);
                }
            } else {
                zArr[0] = true;
                dispatchFinishTemporaryDetachForView(view);
            }
        } else {
            view = this.mAdapter.getView(i3, null, this);
            int i17 = this.mCacheColorHint;
            if (i17 != 0 && view != null) {
                view.setDrawingCacheBackgroundColor(i17);
            }
            if (view != null && ViewCompat.getImportantForAccessibility(view) == 0) {
                ViewCompat.setImportantForAccessibility(view, 1);
            }
        }
        onAttachChildView(view);
        return view;
    }

    protected void onAttachChildView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 169)) {
            iPatchRedirector.redirect((short) 169, (Object) this, (Object) view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        viewTreeObserver.addOnTouchModeChangeListener(this);
        if (this.mTextFilterEnabled && this.mPopup != null && !this.mGlobalLayoutListenerAddedFilter) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.mAdapter != null && this.mDataSetObserver == null) {
            AdapterDataSetObserver newObserver = newObserver();
            this.mDataSetObserver = newObserver;
            this.mAdapter.registerDataSetObserver(newObserver);
            this.mDataChanged = true;
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
            requestLayout();
        }
        this.mIsAttached = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            return (int[]) iPatchRedirector.redirect((short) 82, (Object) this, i3);
        }
        if (this.mIsChildViewEnabled) {
            return super.onCreateDrawableState(i3);
        }
        int i16 = ViewGroup.ENABLED_STATE_SET[0];
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        int length = onCreateDrawableState.length - 1;
        while (true) {
            if (length >= 0) {
                if (onCreateDrawableState[length] == i16) {
                    break;
                }
                length--;
            } else {
                length = -1;
                break;
            }
        }
        if (length >= 0) {
            System.arraycopy(onCreateDrawableState, length + 1, onCreateDrawableState, length, (onCreateDrawableState.length - length) - 1);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 133)) {
            return (InputConnection) iPatchRedirector.redirect((short) 133, (Object) this, (Object) editorInfo);
        }
        if (isTextFilterEnabled()) {
            createTextFilter(false);
            if (this.mPublicInputConnection == null) {
                this.mDefInputConnection = new BaseInputConnection(this, false);
                this.mPublicInputConnection = new a(this.mTextFilter.onCreateInputConnection(editorInfo), true);
            }
            editorInfo.inputType = 177;
            editorInfo.imeOptions = 6;
            return this.mPublicInputConnection;
        }
        return null;
    }

    protected void onDetachChildView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 170)) {
            iPatchRedirector.redirect((short) 170, (Object) this, (Object) view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        AdapterDataSetObserver adapterDataSetObserver;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        dismissPopup();
        try {
            this.mRecycler.clear();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        viewTreeObserver.removeOnTouchModeChangeListener(this);
        if (this.mTextFilterEnabled && this.mPopup != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this);
            this.mGlobalLayoutListenerAddedFilter = false;
        }
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && (adapterDataSetObserver = this.mDataSetObserver) != null) {
            try {
                listAdapter.unregisterDataSetObserver(adapterDataSetObserver);
            } catch (Exception e17) {
                QLog.e(AdapterView.TAG, 1, "onDetachedFromWindow unregisterDataSetObserver fail.", e17);
            }
            this.mDataSetObserver = null;
        }
        Object obj = this.mScrollStrictSpan;
        if (obj != null) {
            this.mScrollStrictSpan = finishSpan(obj);
        }
        Object obj2 = this.mFlingStrictSpan;
        if (obj2 != null) {
            this.mFlingStrictSpan = finishSpan(obj2);
        }
        FlingRunnable flingRunnable = this.mFlingRunnable;
        if (flingRunnable != null) {
            removeCallbacks(flingRunnable);
        }
        PositionScroller positionScroller = this.mPositionScroller;
        if (positionScroller != null) {
            positionScroller.stop();
        }
        MoveToBottomScroller moveToBottomScroller = this.mBottomScroller;
        if (moveToBottomScroller != null) {
            moveToBottomScroller.stop();
        }
        Runnable runnable = this.mClearScrollingCache;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        PerformClick performClick = this.mPerformClick;
        if (performClick != null) {
            removeCallbacks(performClick);
        }
        Runnable runnable2 = this.mTouchModeReset;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
            this.mTouchModeReset = null;
        }
        this.mIsAttached = false;
    }

    @Override // android.view.View
    protected void onDisplayHint(int i3) {
        PopupWindow popupWindow;
        boolean z16;
        PopupWindow popupWindow2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 131)) {
            iPatchRedirector.redirect((short) 131, (Object) this, i3);
            return;
        }
        super.onDisplayHint(i3);
        if (i3 != 0) {
            if (i3 == 4 && (popupWindow2 = this.mPopup) != null && popupWindow2.isShowing()) {
                dismissPopup();
            }
        } else if (this.mFiltered && (popupWindow = this.mPopup) != null && !popupWindow.isShowing()) {
            showPopup();
        }
        if (i3 == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mPopupHidden = z16;
    }

    protected void onDrawVerticalScrollBar(Canvas canvas, Drawable drawable, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, this, canvas, drawable, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            drawable.setBounds(i3, i16 + getScrollY(), i17, i18 + getScrollY());
            drawable.draw(canvas);
        }
    }

    @Override // android.widget.Filter.FilterListener
    public void onFilterComplete(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 141)) {
            iPatchRedirector.redirect((short) 141, (Object) this, i3);
        } else if (this.mSelectedPosition < 0 && i3 > 0) {
            this.mResurrectToPosition = -1;
            resurrectSelection();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z16, int i3, Rect rect) {
        ListAdapter listAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, Boolean.valueOf(z16), Integer.valueOf(i3), rect);
            return;
        }
        super.onFocusChanged(z16, i3, rect);
        if (z16 && this.mSelectedPosition < 0 && !isInTouchMode()) {
            if (!this.mIsAttached && (listAdapter = this.mAdapter) != null) {
                this.mDataChanged = true;
                this.mOldItemCount = this.mItemCount;
                this.mItemCount = listAdapter.getCount();
            }
            resurrectSelection();
        }
    }

    @Override // android.view.View
    @TargetApi(12)
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 109)) {
            return ((Boolean) iPatchRedirector.redirect((short) 109, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && this.mTouchMode == -1) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int verticalScrollFactor = (int) (axisValue * getVerticalScrollFactor());
                if (!trackMotionScroll(verticalScrollFactor, verticalScrollFactor)) {
                    return true;
                }
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        PopupWindow popupWindow;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 137)) {
            iPatchRedirector.redirect((short) 137, (Object) this);
            return;
        }
        if (isShown()) {
            if (this.mFiltered && (popupWindow = this.mPopup) != null && !popupWindow.isShowing() && !this.mPopupHidden) {
                showPopup();
                return;
            }
            return;
        }
        PopupWindow popupWindow2 = this.mPopup;
        if (popupWindow2 != null && popupWindow2.isShowing()) {
            dismissPopup();
        }
    }

    @Override // com.tencent.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) accessibilityEvent);
        } else {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(android.widget.AbsListView.class.getName());
        }
    }

    @Override // com.tencent.widget.AdapterView, android.view.View
    @TargetApi(16)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) accessibilityNodeInfo);
            return;
        }
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(android.widget.AbsListView.class.getName());
        if (isEnabled()) {
            if (getFirstVisiblePosition() > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (getLastVisiblePosition() < getCount() - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 113)) {
            return ((Boolean) iPatchRedirector.redirect((short) 113, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller != null && fastScroller.onInterceptTouchEvent(motionEvent)) {
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
                } else if (this.mTouchMode == 0) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    if (this.mDataChanged) {
                        layoutChildren();
                    }
                    int y16 = (int) motionEvent.getY(findPointerIndex);
                    initVelocityTrackerIfNotExists();
                    this.mVelocityTracker.addMovement(motionEvent);
                    if (startScrollIfNeeded(y16)) {
                        return true;
                    }
                }
            }
            this.mTouchMode = -1;
            this.mActivePointerId = -1;
            recycleVelocityTracker();
            reportScrollStateChange(0);
        } else {
            int i16 = this.mTouchMode;
            if (i16 != 6 && i16 != 5) {
                int x16 = (int) motionEvent.getX();
                int y17 = (int) motionEvent.getY();
                this.mActivePointerId = motionEvent.getPointerId(0);
                int findClosestMotionRow = findClosestMotionRow(y17);
                if (i16 != 4 && findClosestMotionRow >= 0) {
                    this.mMotionViewOriginalTop = getChildAt(findClosestMotionRow - this.mFirstPosition).getTop();
                    this.mMotionX = x16;
                    this.mMotionY = y17;
                    this.mMotionPosition = findClosestMotionRow;
                    this.mTouchMode = 0;
                    clearScrollingCache();
                }
                this.mLastY = Integer.MIN_VALUE;
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                if (i16 == 4) {
                    return true;
                }
            } else {
                this.mMotionCorrection = 0;
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            return ((Boolean) iPatchRedirector.redirect((short) 94, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        int i16;
        ListAdapter listAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            return ((Boolean) iPatchRedirector.redirect((short) 95, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 23 || i3 == 66) {
            if (!isEnabled()) {
                return true;
            }
            if (isClickable() && isPressed() && (i16 = this.mSelectedPosition) >= 0 && (listAdapter = this.mAdapter) != null && i16 < listAdapter.getCount()) {
                View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                if (childAt != null) {
                    performItemClick(childAt, this.mSelectedPosition, this.mSelectedRowId);
                    childAt.setPressed(false);
                }
                setPressed(false);
                return true;
            }
        }
        return super.onKeyUp(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        int i26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        AdapterView.traceBegin("AbsListView.onLayout");
        try {
            super.onLayout(z16, i3, i16, i17, i18);
            this.mInLayout = true;
            if (z16) {
                int childCount = getChildCount();
                for (int i27 = 0; i27 < childCount; i27++) {
                    getChildAt(i27).forceLayout();
                }
                this.mRecycler.markChildrenDirty();
            }
            FastScroller fastScroller = this.mFastScroller;
            if (fastScroller != null && (i19 = this.mItemCount) != (i26 = this.mOldItemCount)) {
                fastScroller.onItemCountChanged(i26, i19);
            }
            layoutChildren();
            this.mInLayout = false;
            this.mOverscrollMax = (i18 - i16) / 3;
            if (this.mScrollToBottom) {
                if (this.mBottomScroller == null) {
                    this.mBottomScroller = new MoveToBottomScroller();
                }
                this.mBottomScroller.start();
            }
        } finally {
            AdapterView.traceEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        int childCount;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.mSelector == null) {
            useDefaultSelector();
        }
        Rect rect = this.mListPadding;
        rect.left = this.mSelectionLeftPadding + getPaddingLeft();
        rect.top = this.mSelectionTopPadding + getPaddingTop();
        rect.right = this.mSelectionRightPadding + getPaddingRight();
        rect.bottom = this.mSelectionBottomPadding + getPaddingBottom();
        if (this.mTranscriptMode == 1 && (childCount = getChildCount()) > 0) {
            int height = getHeight() - getPaddingBottom();
            View childAt = getChildAt(childCount - 1);
            if (childAt != null) {
                i17 = childAt.getBottom();
            } else {
                i17 = height;
            }
            if (this.mFirstPosition + childCount >= this.mLastHandledItemCount && i17 <= height) {
                z16 = true;
            }
            this.mForceTranscriptScroll = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onOverScrolled(int i3, int i16, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            iPatchRedirector.redirect((short) 108, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (getScrollY() != i16) {
            onScrollChanged(getScrollX(), i16, getScrollX(), getScrollY());
            setScrollY(i16);
            invalidateParentIfNeeded();
            try {
                awakenScrollBars();
            } catch (Throwable th5) {
                QLog.e(AdapterView.TAG, 1, "onOverScrolled error:" + th5.getMessage());
            }
        }
    }

    public void onRemoteAdapterDisconnected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 153)) {
            iPatchRedirector.redirect((short) 153, (Object) this);
        }
    }

    @Override // android.view.View
    @TargetApi(11)
    public void onRestoreInstanceState(Parcelable parcelable) {
        MultiChoiceModeWrapper multiChoiceModeWrapper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mDataChanged = true;
        this.mSyncHeight = savedState.height;
        long j3 = savedState.selectedId;
        if (j3 >= 0) {
            this.mNeedSync = true;
            this.mSyncRowId = j3;
            this.mSyncPosition = savedState.position;
            int i3 = savedState.viewTop;
            this.mSpecificTop = i3;
            this.mSpecificBottom = i3;
            this.mSyncMode = 0;
        } else if (savedState.firstId >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.mSelectorPosition = -1;
            int i16 = savedState.position;
            if (i16 != Integer.MAX_VALUE) {
                this.mNeedSync = true;
                this.mSyncRowId = savedState.firstId;
                if (!this.mStackFromBottom) {
                    this.mSyncPosition = i16;
                    this.mSpecificTop = savedState.viewTop;
                    this.mSyncMode = 1;
                } else {
                    this.mSyncPosition = i16;
                    this.mSpecificBottom = savedState.viewTop;
                    this.mSyncMode = 2;
                }
            }
        }
        setFilterText(savedState.filter);
        SparseBooleanArray sparseBooleanArray = savedState.checkState;
        if (sparseBooleanArray != null) {
            this.mCheckStates = sparseBooleanArray;
        }
        LongSparseArray<Integer> longSparseArray = savedState.checkIdState;
        if (longSparseArray != null) {
            this.mCheckedIdStates = longSparseArray;
        }
        this.mCheckedItemCount = savedState.checkedItemCount;
        if (VersionUtils.isHoneycomb() && savedState.inActionMode && this.mChoiceMode == 3 && (multiChoiceModeWrapper = this.mMultiChoiceModeCallback) != null) {
            this.mChoiceActionMode = startActionMode(multiChoiceModeWrapper);
        }
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z16;
        EditText editText;
        Editable text;
        int top;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (Parcelable) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        dismissPopup();
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        boolean z17 = true;
        if (getChildCount() > 0 && this.mItemCount > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        savedState.height = this.mLayoutHeight;
        if (this.mSelectedPosition >= 0) {
            savedState.selectedId = this.mNextSelectedRowId;
            if (z16) {
                savedState.position = getSelectedItemPosition();
                View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                if (childAt != null) {
                    if (this.mStackFromBottom) {
                        top = this.mLayoutHeight - childAt.getBottom();
                    } else {
                        top = childAt.getTop();
                    }
                    savedState.viewTop = top;
                }
                savedState.firstId = -1L;
            }
        } else if (!this.mStackFromBottom) {
            if (z16 && this.mFirstPosition >= 0) {
                savedState.viewTop = getChildAt(0).getTop();
                int i3 = this.mFirstPosition;
                int i16 = this.mItemCount;
                if (i3 >= i16) {
                    i3 = i16 - 1;
                }
                savedState.position = i3;
                savedState.firstId = this.mAdapter.getItemId(i3);
            } else {
                savedState.viewTop = 0;
                savedState.firstId = -1L;
                savedState.position = 0;
            }
        } else if (z16 && this.mFirstPosition >= 0) {
            int childCount = getChildCount();
            int i17 = this.mFirstPosition;
            int i18 = i17 != -1 ? (i17 + childCount) - 1 : -1;
            View childAt2 = getChildAt(childCount - 1);
            savedState.viewTop = this.mLayoutHeight - childAt2.getBottom();
            int i19 = this.mItemCount;
            if (i18 >= i19) {
                i18 = i19 - 1;
            }
            if (childAt2.getBottom() <= this.mLayoutHeight - this.mListPadding.bottom && this.mTranscriptMode == 1) {
                savedState.position = Integer.MAX_VALUE;
            } else {
                savedState.position = i18;
            }
            savedState.firstId = this.mAdapter.getItemId(i18);
        } else {
            savedState.viewTop = 0;
            savedState.firstId = -1L;
            savedState.position = 0;
        }
        savedState.filter = null;
        if (this.mFiltered && (editText = this.mTextFilter) != null && (text = editText.getText()) != null) {
            savedState.filter = text.toString();
        }
        if (this.mChoiceMode != 3 || this.mChoiceActionMode == null) {
            z17 = false;
        }
        savedState.inActionMode = z17;
        SparseBooleanArray sparseBooleanArray = this.mCheckStates;
        if (sparseBooleanArray != null) {
            savedState.checkState = sparseBooleanArray.clone();
        }
        if (this.mCheckedIdStates != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.mCheckedIdStates.size();
            for (int i26 = 0; i26 < size; i26++) {
                longSparseArray.put(this.mCheckedIdStates.keyAt(i26), this.mCheckedIdStates.valueAt(i26));
            }
            savedState.checkIdState = longSparseArray;
        }
        savedState.checkedItemCount = this.mCheckedItemCount;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        PopupWindow popupWindow;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (getWindowVisibility() == 0) {
            z16 = true;
        }
        if (this.mFiltered && z16 && (popupWindow = this.mPopup) != null && popupWindow.isShowing()) {
            positionPopup();
        }
        if (getChildCount() > 0) {
            this.mDataChanged = true;
            rememberSyncState();
        }
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller != null) {
            fastScroller.onSizeChanged(i3, i16, i17, i18);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 139)) {
            iPatchRedirector.redirect((short) 139, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (this.mPopup != null && isTextFilterEnabled()) {
            int length = charSequence.length();
            boolean isShowing = this.mPopup.isShowing();
            if (!isShowing && length > 0) {
                showPopup();
                this.mFiltered = true;
            } else if (isShowing && length == 0) {
                dismissPopup();
                this.mFiltered = false;
            }
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter instanceof Filterable) {
                Filter filter = ((Filterable) listAdapter).getFilter();
                if (filter != null) {
                    filter.filter(charSequence, this);
                    return;
                }
                throw new IllegalStateException("You cannot call onTextChanged with a non filterable adapter");
            }
        }
    }

    @Override // android.view.View
    @TargetApi(8)
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        Drawable current;
        Runnable runnable;
        float yVelocity;
        int i3;
        float yVelocity2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            return ((Boolean) iPatchRedirector.redirect((short) 103, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int i16 = 0;
        if (!isEnabled()) {
            if (isClickable() || isLongClickable()) {
                return true;
            }
            return false;
        }
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller != null && fastScroller.onTouchEvent(motionEvent)) {
            return true;
        }
        TouchDelegate touchDelegate = getTouchDelegate();
        if (touchDelegate != null) {
            touchDelegate.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(motionEvent);
        int i17 = action & 255;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 != 3) {
                        if (i17 != 5) {
                            if (i17 == 6 && VersionUtils.isrFroyo()) {
                                onSecondaryPointerUp(motionEvent);
                                int i18 = this.mMotionX;
                                int i19 = this.mMotionY;
                                int pointToPosition = pointToPosition(i18, i19);
                                if (pointToPosition >= 0) {
                                    this.mMotionViewOriginalTop = getChildAt(pointToPosition - this.mFirstPosition).getTop();
                                    this.mMotionPosition = pointToPosition;
                                }
                                this.mLastY = i19;
                            }
                        } else if (VersionUtils.isrFroyo()) {
                            int actionIndex = motionEvent.getActionIndex();
                            int pointerId = motionEvent.getPointerId(actionIndex);
                            int x16 = (int) motionEvent.getX(actionIndex);
                            int y16 = (int) motionEvent.getY(actionIndex);
                            this.mMotionCorrection = 0;
                            this.mActivePointerId = pointerId;
                            this.mMotionX = x16;
                            this.mMotionY = y16;
                            int pointToPosition2 = pointToPosition(x16, y16);
                            if (pointToPosition2 >= 0) {
                                this.mMotionViewOriginalTop = getChildAt(pointToPosition2 - this.mFirstPosition).getTop();
                                this.mMotionPosition = pointToPosition2;
                            }
                            this.mLastY = y16;
                        }
                    } else {
                        int i26 = this.mTouchMode;
                        if (i26 != 5) {
                            if (i26 != 6) {
                                if (this.mForContacts && i26 == 3) {
                                    flingForCancel();
                                } else {
                                    this.mTouchMode = -1;
                                    setPressed(false);
                                    View childAt = getChildAt(this.mMotionPosition - this.mFirstPosition);
                                    if (childAt != null) {
                                        childAt.setPressed(false);
                                    }
                                    clearScrollingCache();
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.mPendingCheckForLongPress);
                                    }
                                    recycleVelocityTracker();
                                }
                            }
                        } else {
                            if (this.mFlingRunnable == null) {
                                this.mFlingRunnable = new FlingRunnable();
                            }
                            this.mFlingRunnable.startSpringback(0);
                        }
                        EdgeEffect edgeEffect = this.mEdgeGlowTop;
                        if (edgeEffect != null) {
                            edgeEffect.onRelease();
                            this.mEdgeGlowBottom.onRelease();
                        }
                        this.mActivePointerId = -1;
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                    } else {
                        i16 = findPointerIndex;
                    }
                    if (this.mDataChanged) {
                        layoutChildren();
                    }
                    int y17 = (int) motionEvent.getY(i16);
                    int i27 = this.mTouchMode;
                    if (i27 != 0 && i27 != 1 && i27 != 2) {
                        if (i27 == 3 || i27 == 5) {
                            scrollIfNeeded(y17);
                        }
                    } else {
                        startScrollIfNeeded(y17);
                    }
                }
            } else {
                int i28 = this.mTouchMode;
                if (i28 != 0 && i28 != 1 && i28 != 2) {
                    if (i28 != 3) {
                        if (i28 == 5) {
                            if (this.mFlingRunnable == null) {
                                this.mFlingRunnable = new FlingRunnable();
                            }
                            reportScrollStateChange(2);
                            this.mFlingRunnable.startSpringback(getSpringbackOffset());
                            VelocityTracker velocityTracker = this.mVelocityTracker;
                            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            if (VersionUtils.isrFroyo()) {
                                yVelocity2 = velocityTracker.getYVelocity(this.mActivePointerId);
                            } else {
                                yVelocity2 = velocityTracker.getYVelocity();
                            }
                            onTouchUpWithYVelocity((int) (yVelocity2 * this.mVelocityScale), (int) motionEvent.getY());
                        }
                    } else {
                        int childCount = getChildCount();
                        if (childCount > 0) {
                            int top = getChildAt(0).getTop();
                            int bottom = getChildAt(childCount - 1).getBottom();
                            int i29 = this.mListPadding.top;
                            int height = getHeight() - this.mListPadding.bottom;
                            int i36 = this.mFirstPosition;
                            if (i36 == 0 && top >= i29 && i36 + childCount < this.mItemCount && bottom <= getHeight() - height) {
                                this.mTouchMode = -1;
                                reportScrollStateChange(0);
                            } else {
                                VelocityTracker velocityTracker2 = this.mVelocityTracker;
                                velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                if (VersionUtils.isrFroyo()) {
                                    yVelocity = velocityTracker2.getYVelocity(this.mActivePointerId);
                                } else {
                                    yVelocity = velocityTracker2.getYVelocity();
                                }
                                int i37 = (int) (yVelocity * this.mVelocityScale);
                                if (Math.abs(i37) > this.mMinimumVelocity && (((i3 = this.mFirstPosition) != 0 || top != i29 - this.mOverscrollDistance) && (i3 + childCount != this.mItemCount || bottom != height + this.mOverscrollDistance))) {
                                    if (this.mFlingRunnable == null) {
                                        this.mFlingRunnable = new FlingRunnable();
                                    }
                                    reportScrollStateChange(2);
                                    this.mFlingRunnable.start(-i37);
                                } else {
                                    this.mTouchMode = -1;
                                    reportScrollStateChange(0);
                                    FlingRunnable flingRunnable = this.mFlingRunnable;
                                    if (flingRunnable != null) {
                                        flingRunnable.endFling();
                                    }
                                    PositionScroller positionScroller = this.mPositionScroller;
                                    if (positionScroller != null) {
                                        positionScroller.stop();
                                    }
                                    MoveToBottomScroller moveToBottomScroller = this.mBottomScroller;
                                    if (moveToBottomScroller != null) {
                                        moveToBottomScroller.stop();
                                    }
                                }
                            }
                        } else {
                            this.mTouchMode = -1;
                            reportScrollStateChange(0);
                        }
                    }
                } else {
                    int i38 = this.mMotionPosition;
                    View childAt2 = getChildAt(i38 - this.mFirstPosition);
                    float x17 = motionEvent.getX();
                    if (x17 > this.mListPadding.left && x17 < getWidth() - this.mListPadding.right) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (this.mPerformClick == null) {
                        this.mPerformClick = new PerformClick();
                    }
                    PerformClick performClick = this.mPerformClick;
                    performClick.mClickMotionPosition = i38;
                    performClick.rememberWindowAttachCount();
                    if (childAt2 != null && !childAt2.hasFocusable() && z16) {
                        if (this.mTouchMode != 0) {
                            childAt2.setPressed(false);
                        }
                        this.mResurrectToPosition = i38;
                        int i39 = this.mTouchMode;
                        if (i39 != 0 && i39 != 1) {
                            if (!this.mDataChanged && this.mAdapter.isEnabled(i38)) {
                                performClick.run();
                            }
                        } else {
                            Handler handler2 = getHandler();
                            if (handler2 != null) {
                                if (this.mTouchMode == 0) {
                                    runnable = this.mPendingCheckForTap;
                                } else {
                                    runnable = this.mPendingCheckForLongPress;
                                }
                                handler2.removeCallbacks(runnable);
                            }
                            this.mLayoutMode = 0;
                            if (!this.mDataChanged && this.mAdapter.isEnabled(i38)) {
                                this.mTouchMode = 1;
                                setSelectedPositionInt(this.mMotionPosition);
                                layoutChildren();
                                childAt2.setPressed(true);
                                positionSelector(this.mMotionPosition, childAt2);
                                setPressed(true);
                                Drawable drawable = this.mSelector;
                                if (drawable != null && (current = drawable.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                    ((TransitionDrawable) current).resetTransition();
                                }
                                Runnable runnable2 = this.mTouchModeReset;
                                if (runnable2 != null) {
                                    removeCallbacks(runnable2);
                                }
                                Runnable runnable3 = new Runnable(childAt2, performClick) { // from class: com.tencent.widget.AbsListView.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ View f384504d;

                                    /* renamed from: e, reason: collision with root package name */
                                    final /* synthetic */ PerformClick f384505e;

                                    {
                                        this.f384504d = childAt2;
                                        this.f384505e = performClick;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, this, AbsListView.this, childAt2, performClick);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        AbsListView.this.mTouchMode = -1;
                                        this.f384504d.setPressed(false);
                                        AbsListView.this.setPressed(false);
                                        if (!AbsListView.this.mDataChanged) {
                                            this.f384505e.run();
                                        }
                                        AbsListView.this.mTouchModeReset = null;
                                    }
                                };
                                this.mTouchModeReset = runnable3;
                                postDelayed(runnable3, ViewConfiguration.getPressedStateDuration());
                            } else {
                                this.mTouchMode = -1;
                                updateSelectorState();
                            }
                            return true;
                        }
                    } else {
                        performClick.run();
                    }
                    this.mTouchMode = -1;
                    updateSelectorState();
                }
                setPressed(false);
                EdgeEffect edgeEffect2 = this.mEdgeGlowTop;
                if (edgeEffect2 != null) {
                    edgeEffect2.onRelease();
                    this.mEdgeGlowBottom.onRelease();
                }
                invalidate();
                Handler handler3 = getHandler();
                if (handler3 != null) {
                    handler3.removeCallbacks(this.mPendingCheckForLongPress);
                }
                recycleVelocityTracker();
                this.mActivePointerId = -1;
                Object obj = this.mScrollStrictSpan;
                if (obj != null) {
                    this.mScrollStrictSpan = finishSpan(obj);
                }
            }
        } else {
            if (this.mTouchMode != 6) {
                this.mActivePointerId = motionEvent.getPointerId(0);
                int x18 = (int) motionEvent.getX();
                int y18 = (int) motionEvent.getY();
                int pointToPosition3 = pointToPosition(x18, getScrollY() + y18);
                if (!this.mDataChanged) {
                    if (this.mTouchMode != 4 && pointToPosition3 >= 0 && getAdapter().isEnabled(pointToPosition3)) {
                        this.mTouchMode = 0;
                        if (this.mPendingCheckForTap == null) {
                            this.mPendingCheckForTap = new CheckForTap();
                        }
                        postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                    } else if (this.mTouchMode == 4) {
                        createScrollingCache();
                        this.mFlingRunnable.endFling();
                        this.mTouchMode = 3;
                        this.mMotionCorrection = 0;
                        pointToPosition3 = findMotionRow(y18);
                        this.mFlingRunnable.flywheelTouch();
                    }
                }
                if (pointToPosition3 >= 0) {
                    this.mMotionViewOriginalTop = getChildAt(pointToPosition3 - this.mFirstPosition).getTop();
                }
                this.mMotionX = x18;
                this.mMotionY = y18;
                this.mMotionPosition = pointToPosition3;
                this.mLastY = Integer.MIN_VALUE;
            } else {
                this.mFlingRunnable.endFling();
                PositionScroller positionScroller2 = this.mPositionScroller;
                if (positionScroller2 != null) {
                    positionScroller2.stop();
                }
                MoveToBottomScroller moveToBottomScroller2 = this.mBottomScroller;
                if (moveToBottomScroller2 != null) {
                    moveToBottomScroller2.stop();
                }
                this.mTouchMode = 5;
                this.mMotionX = (int) motionEvent.getX();
                int y19 = (int) motionEvent.getY();
                this.mLastY = y19;
                this.mMotionY = y19;
                this.mMotionCorrection = 0;
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mDirection = 0;
            }
            if (performButtonActionOnTouchDown(motionEvent) && this.mTouchMode == 0) {
                removeCallbacks(this.mPendingCheckForTap);
            }
        }
        return true;
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            iPatchRedirector.redirect((short) 102, (Object) this, z16);
            return;
        }
        if (z16) {
            hideSelector();
            if (getHeight() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            updateSelectorState();
            return;
        }
        int i3 = this.mTouchMode;
        if (i3 == 5 || i3 == 6) {
            if (this.mFlingRunnable != null && getScrollY() == 0) {
                this.mFlingRunnable.endFling();
            }
            PositionScroller positionScroller = this.mPositionScroller;
            if (positionScroller != null) {
                positionScroller.stop();
            }
            MoveToBottomScroller moveToBottomScroller = this.mBottomScroller;
            if (moveToBottomScroller != null) {
                moveToBottomScroller.stop();
            }
            if (getScrollY() != 0) {
                setScrollY(0);
                ReflectionUtil.invokeMethod(this, "android.view.View", "invalidateParentCaches", new Object[0]);
                finishGlows();
                invalidate();
            }
        }
    }

    public void onTouchUpWithYVelocity(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            iPatchRedirector.redirect((short) 106, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, (Object) this, z16);
            return;
        }
        super.onWindowFocusChanged(z16);
        int i3 = !isInTouchMode() ? 1 : 0;
        if (!z16) {
            if (!this.mForHongBao && !this.mForStory) {
                setChildrenDrawingCacheEnabled(false);
                FlingRunnable flingRunnable = this.mFlingRunnable;
                if (flingRunnable != null) {
                    removeCallbacks(flingRunnable);
                    this.mFlingRunnable.endFling();
                    PositionScroller positionScroller = this.mPositionScroller;
                    if (positionScroller != null) {
                        positionScroller.stop();
                    }
                    MoveToBottomScroller moveToBottomScroller = this.mBottomScroller;
                    if (moveToBottomScroller != null) {
                        moveToBottomScroller.stop();
                    }
                    resetScrollY();
                }
                dismissPopup();
                if (i3 == 1) {
                    this.mResurrectToPosition = this.mSelectedPosition;
                }
            }
        } else {
            if (this.mFiltered && !this.mPopupHidden) {
                showPopup();
            }
            int i16 = this.mLastTouchMode;
            if (i3 != i16 && i16 != -1) {
                if (i3 == 1) {
                    resurrectSelection();
                } else {
                    hideSelector();
                    this.mLayoutMode = 0;
                    layoutChildren();
                }
            }
        }
        this.mLastTouchMode = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b0  */
    @Override // android.view.View
    @TargetApi(9)
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 158)) {
            return ((Boolean) iPatchRedirector.redirect((short) 158, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Boolean.valueOf(z16))).booleanValue();
        }
        int i36 = this.mOverScrollMode;
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
        if (i36 != 0 && (i36 != 1 || !z17)) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (i36 != 0 && (i36 != 1 || !z18)) {
            z26 = false;
        } else {
            z26 = true;
        }
        int i37 = i17 + i3;
        if (!z19) {
            i27 = 0;
        }
        int i38 = i18 + i16;
        if (!z26) {
            i28 = 0;
        }
        int i39 = -i27;
        int i46 = i27 + i19;
        if (this.mDisableOverScrollTop) {
            i29 = 0;
        } else {
            i29 = -i28;
        }
        int i47 = i28 + i26;
        if (i37 > i46) {
            i37 = i46;
        } else if (i37 < i39) {
            i37 = i39;
        } else {
            z27 = false;
            if (i38 <= i47) {
                i38 = i47;
            } else if (i38 < i29) {
                i38 = i29;
            } else {
                z28 = false;
                if (this.mForHongBao || i38 <= 0) {
                    onOverScrolled(i37, i38, z27, z28);
                }
                if (z27 && !z28) {
                    return false;
                }
                return true;
            }
            z28 = true;
            if (this.mForHongBao) {
            }
            onOverScrolled(i37, i38, z27, z28);
            if (z27) {
            }
            return true;
        }
        z27 = true;
        if (i38 <= i47) {
        }
        z28 = true;
        if (this.mForHongBao) {
        }
        onOverScrolled(i37, i38, z27, z28);
        if (z27) {
        }
        return true;
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this, i3, (Object) bundle)).booleanValue();
        }
        if (super.performAccessibilityAction(i3, bundle)) {
            return true;
        }
        if (i3 != 4096) {
            if (i3 != 8192 || !isEnabled() || this.mFirstPosition <= 0) {
                return false;
            }
            int height = getHeight();
            Rect rect = this.mListPadding;
            smoothScrollBy(-((height - rect.top) - rect.bottom), 400);
            return true;
        }
        if (!isEnabled() || getLastVisiblePosition() >= getCount() - 1) {
            return false;
        }
        int height2 = getHeight();
        Rect rect2 = this.mListPadding;
        smoothScrollBy((height2 - rect2.top) - rect2.bottom, 400);
        return true;
    }

    @TargetApi(14)
    protected boolean performButtonActionOnTouchDown(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 156)) {
            return ((Boolean) iPatchRedirector.redirect((short) 156, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (VersionUtils.isIceScreamSandwich() && (motionEvent.getButtonState() & 2) != 0 && showContextMenu(motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.widget.AdapterView
    public boolean performItemClick(View view, int i3, long j3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        if (isValidPosition(i3, getAdapter().getCount()) && (i16 = this.mChoiceMode) != 0) {
            if (i16 != 2 && (i16 != 3 || this.mChoiceActionMode == null)) {
                if (i16 == 1) {
                    if (!this.mCheckStates.get(i3, false)) {
                        this.mCheckStates.clear();
                        this.mCheckStates.put(i3, true);
                        if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                            this.mCheckedIdStates.clear();
                            this.mCheckedIdStates.put(this.mAdapter.getItemId(i3), Integer.valueOf(i3));
                        }
                        this.mCheckedItemCount = 1;
                    } else if (this.mCheckStates.size() == 0 || !this.mCheckStates.valueAt(0)) {
                        this.mCheckedItemCount = 0;
                    }
                }
            } else {
                boolean z18 = !this.mCheckStates.get(i3, false);
                this.mCheckStates.put(i3, z18);
                if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                    if (z18) {
                        this.mCheckedIdStates.put(this.mAdapter.getItemId(i3), Integer.valueOf(i3));
                    } else {
                        this.mCheckedIdStates.delete(this.mAdapter.getItemId(i3));
                    }
                }
                if (z18) {
                    this.mCheckedItemCount++;
                } else {
                    this.mCheckedItemCount--;
                }
                ActionMode actionMode = this.mChoiceActionMode;
                if (actionMode != null) {
                    this.mMultiChoiceModeCallback.onItemCheckedStateChanged(actionMode, i3, j3, z18);
                    this.mDataChanged = true;
                    rememberSyncState();
                    requestLayout();
                    z17 = z16;
                    z16 = true;
                }
            }
            z16 = true;
            this.mDataChanged = true;
            rememberSyncState();
            requestLayout();
            z17 = z16;
            z16 = true;
        }
        if (z17) {
            return z16 | super.performItemClick(view, i3, j3);
        }
        return z16;
    }

    @TargetApi(11)
    boolean performLongPress(View view, int i3, long j3) {
        boolean z16;
        if (this.mChoiceMode == 3) {
            if (VersionUtils.isHoneycomb() && this.mChoiceActionMode == null) {
                ActionMode startActionMode = startActionMode(this.mMultiChoiceModeCallback);
                this.mChoiceActionMode = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i3, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        AdapterView.OnItemLongClickListener onItemLongClickListener = this.mOnItemLongClickListener;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            return ((Integer) iPatchRedirector.redirect((short) 97, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        Rect rect = this.mTouchFrame;
        if (rect == null) {
            rect = new Rect();
            this.mTouchFrame = rect;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt != null && childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i3, i16)) {
                    return this.mFirstPosition + childCount;
                }
            }
        }
        return -1;
    }

    public long pointToRowId(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            return ((Long) iPatchRedirector.redirect((short) 98, this, Integer.valueOf(i3), Integer.valueOf(i16))).longValue();
        }
        int pointToPosition = pointToPosition(i3, i16);
        if (pointToPosition >= 0) {
            return this.mAdapter.getItemId(pointToPosition);
        }
        return Long.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void positionSelector(int i3, View view) {
        if (i3 != -1) {
            this.mSelectorPosition = i3;
        }
        Rect rect = this.mSelectorRect;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof SelectionBoundsAdjuster) {
            ((SelectionBoundsAdjuster) view).adjustListItemSelectionBounds(rect);
        }
        positionSelector(rect.left, rect.top, rect.right, rect.bottom);
        boolean z16 = this.mIsChildViewEnabled;
        if (view.isEnabled() != z16) {
            this.mIsChildViewEnabled = !z16;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    public void reclaimViews(List<View> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 151)) {
            iPatchRedirector.redirect((short) 151, (Object) this, (Object) list);
            return;
        }
        int childCount = getChildCount();
        RecyclerListener recyclerListener = this.mRecycler.mRecyclerListener;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams != null && this.mRecycler.shouldRecycleViewType(layoutParams.viewType)) {
                list.add(childAt);
                if (recyclerListener != null) {
                    recyclerListener.onMovedToScrapHeap(childAt);
                }
            }
        }
        this.mRecycler.reclaimScrapViews(list);
        removeAllViewsInLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int reconcileSelectedPosition() {
        int i3 = this.mSelectedPosition;
        if (i3 < 0) {
            i3 = this.mResurrectToPosition;
        }
        return Math.min(Math.max(0, i3), this.mItemCount - 1);
    }

    @Override // com.tencent.widget.AdapterView
    void rememberSyncState() {
        if (getChildCount() > 0) {
            this.mNeedSync = true;
            this.mSyncHeight = this.mLayoutHeight;
            int i3 = this.mSelectedPosition;
            if (i3 >= 0) {
                View childAt = getChildAt(i3 - this.mFirstPosition);
                this.mSyncRowId = this.mNextSelectedRowId;
                this.mSyncPosition = this.mNextSelectedPosition;
                if (childAt != null) {
                    this.mSpecificTop = childAt.getTop();
                    this.mSpecificBottom = this.mLayoutHeight - childAt.getBottom();
                }
                this.mSyncMode = 0;
                return;
            }
            if ((getScrollY() == 0 && !this.mStackFromBottom) || getScrollY() < 0) {
                View childAt2 = getChildAt(0);
                ListAdapter adapter = getAdapter();
                int i16 = this.mFirstPosition;
                if (i16 >= 0 && i16 < adapter.getCount()) {
                    this.mSyncRowId = adapter.getItemId(this.mFirstPosition);
                } else {
                    this.mSyncRowId = -1L;
                }
                this.mSyncPosition = this.mFirstPosition;
                if (childAt2 != null) {
                    this.mSpecificTop = childAt2.getTop();
                    this.mSpecificBottom = this.mLayoutHeight - childAt2.getBottom();
                }
                this.mSyncMode = 1;
                return;
            }
            ListAdapter adapter2 = getAdapter();
            int childCount = getChildCount();
            int i17 = this.mFirstPosition;
            int i18 = -1;
            if (i17 != -1) {
                i18 = (i17 + childCount) - 1;
            }
            View childAt3 = getChildAt(childCount - 1);
            if (i18 >= 0 && i18 < adapter2.getCount()) {
                this.mSyncRowId = adapter2.getItemId(i18);
            } else {
                this.mSyncRowId = -1L;
            }
            this.mSyncPosition = i18;
            if (childAt3 != null) {
                this.mSpecificTop = childAt3.getTop();
                this.mSpecificBottom = this.mLayoutHeight - childAt3.getBottom();
            }
            this.mSyncMode = 2;
        }
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) onScrollListener);
        } else {
            this.mOnScrollListenerList.remove(onScrollListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportScrollStateChange(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 115)) {
            iPatchRedirector.redirect((short) 115, (Object) this, i3);
            return;
        }
        if (i3 != this.mLastScrollState) {
            this.mLastScrollState = i3;
            OnScrollListener onScrollListener = this.mOnScrollListener;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(this, i3);
            }
            Iterator<OnScrollListener> it = this.mOnScrollListenerList.iterator();
            while (it.hasNext()) {
                it.next().onScrollStateChanged(this, i3);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 112)) {
            iPatchRedirector.redirect((short) 112, (Object) this, z16);
            return;
        }
        if (z16) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z16);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this);
        } else if (!this.mBlockLayoutRequests && !this.mInLayout) {
            rememberSyncState();
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestLayoutIfNecessary() {
        if (getChildCount() > 0) {
            resetList();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetList() {
        removeAllViewsInLayout();
        this.mFirstPosition = 0;
        this.mDataChanged = true;
        this.mNeedSync = false;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.mSelectedTop = 0;
        this.mSelectorPosition = -1;
        this.mSelectorRect.setEmpty();
        invalidate();
    }

    protected void resetScrollY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            iPatchRedirector.redirect((short) 89, (Object) this);
        } else if (getScrollY() != 0) {
            setScrollY(0);
            ReflectionUtil.invokeMethod(this, "android.view.View", "invalidateParentCaches", new Object[0]);
            finishGlows();
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean resurrectSelection() {
        boolean z16;
        int i3;
        int i16;
        PositionScroller positionScroller;
        MoveToBottomScroller moveToBottomScroller;
        int lookForSelectablePosition;
        int childCount = getChildCount();
        if (childCount <= 0) {
            return false;
        }
        int i17 = this.mListPadding.top;
        int bottom = (getBottom() - getTop()) - this.mListPadding.bottom;
        int i18 = this.mFirstPosition;
        int i19 = this.mResurrectToPosition;
        if (i19 >= i18 && i19 < i18 + childCount) {
            View childAt = getChildAt(i19 - i18);
            i3 = childAt.getTop();
            int bottom2 = childAt.getBottom();
            if (i3 < i17) {
                i3 = i17 + getVerticalFadingEdgeLength();
            } else if (bottom2 > bottom) {
                i3 = (bottom - childAt.getMeasuredHeight()) - getVerticalFadingEdgeLength();
            }
        } else if (i19 < i18) {
            int i26 = 0;
            int i27 = 0;
            while (true) {
                if (i26 < childCount) {
                    i3 = getChildAt(i26).getTop();
                    if (i26 == 0) {
                        if (i18 > 0 || i3 < i17) {
                            i17 += getVerticalFadingEdgeLength();
                        }
                        i27 = i3;
                    }
                    if (i3 >= i17) {
                        i19 = i26 + i18;
                        break;
                    }
                    i26++;
                } else {
                    i3 = i27;
                    i19 = i18;
                    break;
                }
            }
        } else {
            int i28 = this.mItemCount;
            int i29 = i18 + childCount;
            int i36 = i29 - 1;
            int i37 = childCount - 1;
            int i38 = i37;
            int i39 = 0;
            while (true) {
                if (i38 >= 0) {
                    View childAt2 = getChildAt(i38);
                    int top = childAt2.getTop();
                    int bottom3 = childAt2.getBottom();
                    if (i38 == i37) {
                        if (i29 < i28 || bottom3 > bottom) {
                            bottom -= getVerticalFadingEdgeLength();
                        }
                        i39 = top;
                    }
                    if (bottom3 <= bottom) {
                        i19 = i18 + i38;
                        z16 = false;
                        i3 = top;
                        break;
                    }
                    i38--;
                } else {
                    z16 = false;
                    i19 = i36;
                    i3 = i39;
                    break;
                }
            }
            i16 = -1;
            this.mResurrectToPosition = -1;
            removeCallbacks(this.mFlingRunnable);
            positionScroller = this.mPositionScroller;
            if (positionScroller != null) {
                positionScroller.stop();
            }
            moveToBottomScroller = this.mBottomScroller;
            if (moveToBottomScroller != null) {
                moveToBottomScroller.stop();
            }
            this.mTouchMode = -1;
            clearScrollingCache();
            this.mSpecificTop = i3;
            lookForSelectablePosition = lookForSelectablePosition(i19, z16);
            if (lookForSelectablePosition >= i18 && lookForSelectablePosition <= getLastVisiblePosition()) {
                this.mLayoutMode = 4;
                updateSelectorState();
                setSelectionInt(lookForSelectablePosition);
                invokeOnItemScrollListener();
                i16 = lookForSelectablePosition;
            }
            reportScrollStateChange(0);
            if (i16 >= 0) {
                return false;
            }
            return true;
        }
        z16 = true;
        i16 = -1;
        this.mResurrectToPosition = -1;
        removeCallbacks(this.mFlingRunnable);
        positionScroller = this.mPositionScroller;
        if (positionScroller != null) {
        }
        moveToBottomScroller = this.mBottomScroller;
        if (moveToBottomScroller != null) {
        }
        this.mTouchMode = -1;
        clearScrollingCache();
        this.mSpecificTop = i3;
        lookForSelectablePosition = lookForSelectablePosition(i19, z16);
        if (lookForSelectablePosition >= i18) {
            this.mLayoutMode = 4;
            updateSelectorState();
            setSelectionInt(lookForSelectablePosition);
            invokeOnItemScrollListener();
            i16 = lookForSelectablePosition;
        }
        reportScrollStateChange(0);
        if (i16 >= 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean resurrectSelectionIfNeeded() {
        if (this.mSelectedPosition < 0 && resurrectSelection()) {
            updateSelectorState();
            return true;
        }
        return false;
    }

    protected View retrieveFromScrap(ArrayList<View> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 155)) {
            return (View) iPatchRedirector.redirect((short) 155, (Object) this, (Object) arrayList, i3);
        }
        int size = arrayList.size();
        if (size > 0) {
            for (int i16 = 0; i16 < size; i16++) {
                View view = arrayList.get(i16);
                if (((LayoutParams) view.getLayoutParams()).scrappedFromPosition == i3) {
                    arrayList.remove(i16);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, i3);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sendToTextFilter(int i3, int i16, KeyEvent keyEvent) {
        boolean z16;
        boolean z17;
        boolean z18;
        PopupWindow popupWindow;
        KeyEvent keyEvent2;
        if (!acceptFilter()) {
            return false;
        }
        if (i3 != 4) {
            if (i3 != 62) {
                if (i3 != 66) {
                    switch (i3) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            break;
                        default:
                            z17 = false;
                            z18 = true;
                            break;
                    }
                }
                z18 = false;
                z17 = false;
            } else {
                z18 = this.mFiltered;
                z17 = false;
            }
        } else {
            if (this.mFiltered && (popupWindow = this.mPopup) != null && popupWindow.isShowing()) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                } else if (keyEvent.getAction() == 1 && keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    this.mTextFilter.setText("");
                }
                z16 = true;
                z17 = z16;
                z18 = false;
            }
            z16 = false;
            z17 = z16;
            z18 = false;
        }
        if (z18) {
            createTextFilter(true);
            if (keyEvent.getRepeatCount() > 0) {
                keyEvent2 = KeyEvent.changeTimeRepeat(keyEvent, keyEvent.getEventTime(), 0);
            } else {
                keyEvent2 = keyEvent;
            }
            int action = keyEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        return this.mTextFilter.onKeyMultiple(i3, i16, keyEvent);
                    }
                    return z17;
                }
                return this.mTextFilter.onKeyUp(i3, keyEvent2);
            }
            return this.mTextFilter.onKeyDown(i3, keyEvent2);
        }
        return z17;
    }

    public void setCacheColorHint(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 149)) {
            iPatchRedirector.redirect((short) 149, (Object) this, i3);
            return;
        }
        if (i3 != this.mCacheColorHint) {
            this.mCacheColorHint = i3;
            int childCount = getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                getChildAt(i16).setDrawingCacheBackgroundColor(i3);
            }
            this.mRecycler.setCacheColorHint(i3);
        }
    }

    public void setCallbackOnUnClickItem(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.mCallbackOnUnClickItem = z16;
        }
    }

    @TargetApi(11)
    public void setChoiceMode(int i3) {
        ListAdapter listAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        this.mChoiceMode = i3;
        ActionMode actionMode = this.mChoiceActionMode;
        if (actionMode != null) {
            actionMode.finish();
            this.mChoiceActionMode = null;
        }
        if (this.mChoiceMode != 0) {
            if (this.mCheckStates == null) {
                this.mCheckStates = new SparseBooleanArray();
            }
            if (this.mCheckedIdStates == null && (listAdapter = this.mAdapter) != null && listAdapter.hasStableIds()) {
                this.mCheckedIdStates = new LongSparseArray<>();
            }
            if (this.mChoiceMode == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setDrawSelectorOnTop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, z16);
        } else {
            this.mDrawSelectorOnTop = z16;
        }
    }

    public void setEdgeEffectEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        if (this.mEdgeEffectEnabled != z16) {
            if (z16) {
                if (this.mOverScrollMode != 2 && this.mEdgeGlowTop == null) {
                    Context context = getContext();
                    this.mEdgeGlowTop = new EdgeEffect(context);
                    this.mEdgeGlowBottom = new EdgeEffect(context);
                }
            } else {
                this.mEdgeGlowTop = null;
                this.mEdgeGlowBottom = null;
            }
            this.mEdgeEffectEnabled = z16;
        }
    }

    public void setFastScrollAlwaysVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
            return;
        }
        if (z16 && !this.mFastScrollEnabled) {
            setFastScrollEnabled(true);
        }
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller != null) {
            fastScroller.setAlwaysShow(z16);
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeOpaqueFlags", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, new Object[0]);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(AdapterView.TAG, 2, e16.getMessage(), e16);
            }
        }
        try {
            Method declaredMethod2 = View.class.getDeclaredMethod("recomputePadding", new Class[0]);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(this, new Object[0]);
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.e(AdapterView.TAG, 2, e17.getMessage(), e17);
            }
        }
    }

    public void setFastScrollEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
            return;
        }
        this.mFastScrollEnabled = z16;
        if (z16) {
            if (this.mFastScroller == null) {
                this.mFastScroller = new FastScroller(getContext(), this);
            }
        } else {
            FastScroller fastScroller = this.mFastScroller;
            if (fastScroller != null) {
                fastScroller.stop();
                this.mFastScroller = null;
            }
        }
    }

    public void setFilterText(String str) {
        Filter filter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) str);
            return;
        }
        if (this.mTextFilterEnabled && !TextUtils.isEmpty(str)) {
            createTextFilter(false);
            this.mTextFilter.setText(str);
            this.mTextFilter.setSelection(str.length());
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter instanceof Filterable) {
                if (this.mPopup == null && (filter = ((Filterable) listAdapter).getFilter()) != null) {
                    filter.filter(str);
                }
                this.mFiltered = true;
                this.mDataSetObserver.clearSavedState();
            }
        }
    }

    public void setFriction(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 119)) {
            iPatchRedirector.redirect((short) 119, this, Float.valueOf(f16));
            return;
        }
        if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new FlingRunnable();
        }
        this.mFlingRunnable.mScroller.setFriction(f16);
    }

    public void setInterpolator(Interpolator interpolator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 118)) {
            iPatchRedirector.redirect((short) 118, (Object) this, (Object) interpolator);
            return;
        }
        FlingRunnable flingRunnable = this.mFlingRunnable;
        if (flingRunnable != null) {
            flingRunnable.mScroller.setInterpolator(interpolator);
        }
    }

    public void setIsNeedScrollPositionTop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 168)) {
            iPatchRedirector.redirect((short) 168, (Object) this, z16);
        } else {
            this.mIsNeedScrollPositionTop = z16;
        }
    }

    @TargetApi(11)
    public void setItemChecked(int i3, boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (this.mChoiceMode == 0) {
            return;
        }
        if (VersionUtils.isHoneycomb() && z16 && this.mChoiceMode == 3 && this.mChoiceActionMode == null) {
            this.mChoiceActionMode = startActionMode(this.mMultiChoiceModeCallback);
        }
        int i16 = this.mChoiceMode;
        if (i16 != 2 && i16 != 3) {
            if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z16 || isItemChecked(i3)) {
                this.mCheckStates.clear();
                if (z17) {
                    this.mCheckedIdStates.clear();
                }
            }
            if (z16) {
                this.mCheckStates.put(i3, true);
                if (z17) {
                    this.mCheckedIdStates.put(this.mAdapter.getItemId(i3), Integer.valueOf(i3));
                }
                this.mCheckedItemCount = 1;
            } else if (this.mCheckStates.size() == 0 || !this.mCheckStates.valueAt(0)) {
                this.mCheckedItemCount = 0;
            }
        } else {
            boolean z18 = this.mCheckStates.get(i3);
            this.mCheckStates.put(i3, z16);
            if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                if (z16) {
                    this.mCheckedIdStates.put(this.mAdapter.getItemId(i3), Integer.valueOf(i3));
                } else {
                    this.mCheckedIdStates.delete(this.mAdapter.getItemId(i3));
                }
            }
            if (z18 != z16) {
                if (z16) {
                    this.mCheckedItemCount++;
                } else {
                    this.mCheckedItemCount--;
                }
            }
            if (this.mChoiceActionMode != null) {
                this.mMultiChoiceModeCallback.onItemCheckedStateChanged(this.mChoiceActionMode, i3, this.mAdapter.getItemId(i3), z16);
            }
        }
        if (!this.mInLayout && !this.mBlockLayoutRequests) {
            this.mDataChanged = true;
            rememberSyncState();
            requestLayout();
        }
    }

    public void setMaxOverScrollTopDistance(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mBottomOverflingDistance = (int) ((getResources().getDisplayMetrics().density * i3) + 0.5f);
        }
    }

    public void setMaximumVelocity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 162)) {
            iPatchRedirector.redirect((short) 162, (Object) this, i3);
        } else {
            this.mMaximumVelocity = i3;
        }
    }

    public void setMultiChoiceModeListener(MultiChoiceModeListener multiChoiceModeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) multiChoiceModeListener);
            return;
        }
        if (this.mMultiChoiceModeCallback == null) {
            this.mMultiChoiceModeCallback = new MultiChoiceModeWrapper();
        }
        this.mMultiChoiceModeCallback.setWrapped(multiChoiceModeListener);
    }

    public void setNeedCheckSpringback(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 163)) {
            iPatchRedirector.redirect((short) 163, (Object) this, z16);
        } else {
            this.mNeedCheckSpringback = z16;
        }
    }

    public void setOnNestedScrollingListener(OnNestedScrollingListener onNestedScrollingListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) onNestedScrollingListener);
        } else {
            this.onNestedScrollingListener = onNestedScrollingListener;
        }
    }

    public void setOnOverScrollListener(OnOverScrollListener onOverScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) onOverScrollListener);
        } else {
            this.mOnOverScrollListener = onOverScrollListener;
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) onScrollListener);
        } else {
            this.mOnScrollListener = onScrollListener;
            invokeOnItemScrollListener();
        }
    }

    public void setOnScrollToButtomListener(OnScrollButtomListener onScrollButtomListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) onScrollButtomListener);
        } else {
            this.mOnScrollButtomListener = onScrollButtomListener;
        }
    }

    public void setOverScrollEffectPadding(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 111)) {
            iPatchRedirector.redirect((short) 111, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mGlowPaddingLeft = i3;
            this.mGlowPaddingRight = i16;
        }
    }

    public void setOverScrollFlingMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 116)) {
            iPatchRedirector.redirect((short) 116, (Object) this, i3);
            return;
        }
        if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new FlingRunnable();
        }
        this.mFlingRunnable.mScroller.setFlingMode(i3);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("Invalid overscroll mode " + i3);
        }
        if (i3 != 2) {
            if (this.mEdgeGlowTop == null && this.mEdgeEffectEnabled) {
                Context context = getContext();
                try {
                    this.mEdgeGlowTop = new EdgeEffect(context);
                    this.mEdgeGlowBottom = new EdgeEffect(context);
                } catch (Throwable unused) {
                }
            }
        } else {
            this.mEdgeGlowTop = null;
            this.mEdgeGlowBottom = null;
        }
        this.mOverScrollMode = i3;
    }

    public void setOverScrollTouchMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            iPatchRedirector.redirect((short) 101, (Object) this, i3);
            return;
        }
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException(" mode error " + i3);
        }
        this.mOverScrollTouchMode = i3;
    }

    public void setRecyclerListener(RecyclerListener recyclerListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 154)) {
            this.mRecycler.mRecyclerListener = recyclerListener;
        } else {
            iPatchRedirector.redirect((short) 154, (Object) this, (Object) recyclerListener);
        }
    }

    public void setScrollIndicators(View view, View view2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, (Object) view, (Object) view2);
        } else {
            this.mScrollUp = view;
            this.mScrollDown = view2;
        }
    }

    public void setScrollingCacheEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, z16);
            return;
        }
        if (this.mScrollingCacheEnabled && !z16) {
            clearScrollingCache();
        }
        this.mScrollingCacheEnabled = z16;
    }

    abstract void setSelectionInt(int i3);

    public void setSelector(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 77)) {
            setSelector(getResources().getDrawable(i3));
        } else {
            iPatchRedirector.redirect((short) 77, (Object) this, i3);
        }
    }

    public void setSmoothScrollbarEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
        } else {
            this.mSmoothScrollbarEnabled = z16;
        }
    }

    public void setStackFromBottom(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, z16);
        } else if (this.mStackFromBottom != z16) {
            this.mStackFromBottom = z16;
            requestLayoutIfNecessary();
        }
    }

    public void setStackFromBottomWithoutRequestLayoutIfNecessary(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, z16);
        } else if (this.mStackFromBottom != z16) {
            this.mStackFromBottom = z16;
        }
    }

    public void setTextFilterEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, z16);
        } else {
            this.mTextFilterEnabled = z16;
        }
    }

    public void setTranscriptMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 146)) {
            iPatchRedirector.redirect((short) 146, (Object) this, i3);
        } else {
            this.mTranscriptMode = i3;
        }
    }

    public void setVelocityScale(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 120)) {
            iPatchRedirector.redirect((short) 120, this, Float.valueOf(f16));
        } else {
            this.mVelocityScale = f16;
        }
    }

    @Override // android.view.View
    public void setVerticalScrollbarPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
            return;
        }
        super.setVerticalScrollbarPosition(i3);
        FastScroller fastScroller = this.mFastScroller;
        if (fastScroller != null) {
            fastScroller.setScrollbarPosition(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldShowSelector() {
        if ((hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState()) {
            return true;
        }
        return false;
    }

    public boolean showContextMenu(float f16, float f17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            return ((Boolean) iPatchRedirector.redirect((short) 92, this, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3))).booleanValue();
        }
        int pointToPosition = pointToPosition((int) f16, (int) f17);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.mFirstPosition);
            if (childAt != null) {
                this.mContextMenuInfo = createContextMenuInfo(childAt, pointToPosition, itemId);
                return super.showContextMenuForChild(this);
            }
        }
        return super.showContextMenu();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            return ((Boolean) iPatchRedirector.redirect((short) 93, (Object) this, (Object) view)).booleanValue();
        }
        int positionForView = getPositionForView(view);
        boolean z16 = false;
        if (positionForView < 0) {
            return false;
        }
        long itemId = this.mAdapter.getItemId(positionForView);
        AdapterView.OnItemLongClickListener onItemLongClickListener = this.mOnItemLongClickListener;
        if (onItemLongClickListener != null) {
            z16 = onItemLongClickListener.onItemLongClick(this, view, positionForView, itemId);
        }
        if (!z16) {
            this.mContextMenuInfo = createContextMenuInfo(getChildAt(positionForView - this.mFirstPosition), positionForView, itemId);
            return super.showContextMenuForChild(view);
        }
        return z16;
    }

    public void smoothScrollBy(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 125)) {
            iPatchRedirector.redirect((short) 125, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new FlingRunnable();
        }
        int i17 = this.mFirstPosition;
        int childCount = getChildCount();
        int i18 = (i17 + childCount) - 1;
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (i3 != 0 && this.mItemCount != 0 && childCount != 0 && ((i17 != 0 || getChildAt(0).getTop() != paddingTop || i3 >= 0) && (i18 != this.mItemCount - 1 || getChildAt(childCount - 1).getBottom() != height || i3 <= 0))) {
            reportScrollStateChange(2);
            this.mFlingRunnable.startScroll(i3, i16);
            return;
        }
        this.mFlingRunnable.endFling();
        PositionScroller positionScroller = this.mPositionScroller;
        if (positionScroller != null) {
            positionScroller.stop();
        }
        MoveToBottomScroller moveToBottomScroller = this.mBottomScroller;
        if (moveToBottomScroller != null) {
            moveToBottomScroller.stop();
        }
    }

    public void smoothScrollByImmediately(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 126)) {
            iPatchRedirector.redirect((short) 126, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new FlingRunnable();
        }
        int i17 = this.mFirstPosition;
        int childCount = getChildCount();
        int i18 = (i17 + childCount) - 1;
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (i3 != 0 && this.mItemCount != 0 && childCount != 0 && ((i17 != 0 || getChildAt(0).getTop() != paddingTop || i3 >= 0) && (i18 != this.mItemCount - 1 || getChildAt(childCount - 1).getBottom() != height || i3 <= 0))) {
            reportScrollStateChange(2);
            this.mFlingRunnable.startScrollImmediately(i3, i16);
            return;
        }
        this.mFlingRunnable.endFling();
        PositionScroller positionScroller = this.mPositionScroller;
        if (positionScroller != null) {
            positionScroller.stop();
        }
        MoveToBottomScroller moveToBottomScroller = this.mBottomScroller;
        if (moveToBottomScroller != null) {
            moveToBottomScroller.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void smoothScrollByOffset(int i3) {
        int i16;
        View childAt;
        if (i3 < 0) {
            i16 = getFirstVisiblePosition();
        } else if (i3 > 0) {
            i16 = getLastVisiblePosition();
        } else {
            i16 = -1;
        }
        if (i16 > -1 && (childAt = getChildAt(i16 - getFirstVisiblePosition())) != null) {
            if (childAt.getGlobalVisibleRect(new Rect())) {
                float width = (r2.width() * r2.height()) / (childAt.getWidth() * childAt.getHeight());
                if (i3 < 0 && width < 0.75f) {
                    i16++;
                } else if (i3 > 0 && width < 0.75f) {
                    i16--;
                }
            }
            smoothScrollToPosition(Math.max(0, Math.min(getCount(), i16 + i3)));
        }
    }

    public void smoothScrollToPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 121)) {
            iPatchRedirector.redirect((short) 121, (Object) this, i3);
            return;
        }
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new PositionScroller();
        }
        this.mPositionScroller.start(i3);
    }

    public void smoothScrollToPositionFromTop(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 122)) {
            iPatchRedirector.redirect((short) 122, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new PositionScroller();
        }
        this.mPositionScroller.startWithOffset(i3, i16, i17);
    }

    public void springBackTo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            iPatchRedirector.redirect((short) 105, (Object) this, i3);
            return;
        }
        if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new FlingRunnable();
        }
        this.mFlingRunnable.startSpringback(i3);
    }

    public boolean startScrollIfNeeded(int i3) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            return ((Boolean) iPatchRedirector.redirect((short) 100, (Object) this, i3)).booleanValue();
        }
        int i17 = i3 - this.mMotionY;
        int abs = Math.abs(i17);
        if (getScrollY() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((z16 && !this.mForHongBao && !this.mForStory) || abs > this.mTouchSlop) {
            z17 = true;
        } else {
            z17 = false;
        }
        if ((getNestedScrollAxes() & 2) != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z17 || z18) {
            return false;
        }
        createScrollingCache();
        if (z16) {
            this.mTouchMode = 5;
            this.mMotionCorrection = 0;
        } else {
            this.mTouchMode = 3;
            if (i17 > 0) {
                i16 = this.mTouchSlop;
            } else {
                i16 = -this.mTouchSlop;
            }
            this.mMotionCorrection = i16;
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.mPendingCheckForLongPress);
        }
        setPressed(false);
        View childAt = getChildAt(this.mMotionPosition - this.mFirstPosition);
        if (childAt != null) {
            childAt.setPressed(false);
        }
        reportScrollStateChange(1);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        scrollIfNeeded(i3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean touchModeDrawsInPressedState() {
        int i3 = this.mTouchMode;
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    public boolean trackMotionScroll(int i3, int i16) {
        int i17;
        int i18;
        int min;
        int min2;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        int i19;
        int i26;
        int i27;
        int i28;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 127)) {
            return ((Boolean) iPatchRedirector.redirect((short) 127, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        AdapterView.traceBegin("AbsListView.trackMotionScroll");
        try {
            int top = getChildAt(0).getTop();
            int i29 = childCount - 1;
            int bottom = getChildAt(i29).getBottom();
            Rect rect = this.mListPadding;
            if (hasBooleanFlag(34)) {
                i17 = rect.top;
                i18 = rect.bottom;
            } else {
                i17 = 0;
                i18 = 0;
            }
            int i36 = i17 - top;
            int height = bottom - (getHeight() - i18);
            int height2 = (getHeight() - getPaddingBottom()) - getPaddingTop();
            if (i3 < 0) {
                min = Math.max(-(height2 - 1), i3);
            } else {
                min = Math.min(height2 - 1, i3);
            }
            if (i16 < 0) {
                min2 = Math.max(-(height2 - 1), i16);
            } else {
                min2 = Math.min(height2 - 1, i16);
            }
            int i37 = this.mFirstPosition;
            if (i37 == 0) {
                this.mFirstPositionDistanceGuess = top - rect.top;
            } else {
                this.mFirstPositionDistanceGuess += min2;
            }
            int i38 = i37 + childCount;
            int i39 = this.mItemCount;
            if (i38 == i39) {
                this.mLastPositionDistanceGuess = rect.bottom + bottom;
            } else {
                this.mLastPositionDistanceGuess += min2;
            }
            if (i37 == 0 && top >= rect.top && min2 >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (i38 == i39 && bottom <= getHeight() - rect.bottom && min2 <= 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z16 && !z17) {
                if (min2 < 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                boolean isInTouchMode = isInTouchMode();
                if (isInTouchMode) {
                    hideSelector();
                }
                int headerViewsCount = getHeaderViewsCount();
                int footerViewsCount = this.mItemCount - getFooterViewsCount();
                if (z19) {
                    int i46 = -min2;
                    if (hasBooleanFlag(34)) {
                        i46 += rect.top;
                    }
                    int i47 = 0;
                    i26 = 0;
                    while (i47 < childCount) {
                        View childAt = getChildAt(i47);
                        if (childAt.getBottom() >= i46) {
                            break;
                        }
                        i26++;
                        int i48 = i37 + i47;
                        if (i48 >= headerViewsCount && i48 < footerViewsCount) {
                            i28 = childCount;
                            this.mRecycler.addScrapView(childAt, i48);
                        } else {
                            i28 = childCount;
                        }
                        i47++;
                        childCount = i28;
                    }
                    i19 = 0;
                } else {
                    int height3 = getHeight() - min2;
                    if (hasBooleanFlag(34)) {
                        height3 -= rect.bottom;
                    }
                    i19 = 0;
                    i26 = 0;
                    while (i29 >= 0) {
                        View childAt2 = getChildAt(i29);
                        if (childAt2.getTop() <= height3) {
                            break;
                        }
                        i26++;
                        int i49 = i37 + i29;
                        if (i49 >= headerViewsCount && i49 < footerViewsCount) {
                            this.mRecycler.addScrapView(childAt2, i49);
                        }
                        int i56 = i29;
                        i29--;
                        i19 = i56;
                    }
                }
                this.mMotionViewNewTop = this.mMotionViewOriginalTop + min;
                this.mBlockLayoutRequests = true;
                if (i26 > 0) {
                    detachViewsFromParent(i19, i26);
                }
                offsetChildrenTopAndBottomWrap(min2);
                if (z19) {
                    this.mFirstPosition += i26;
                }
                invalidate();
                int abs = Math.abs(min2);
                if (i36 < abs || height < abs) {
                    fillGap(z19);
                }
                if (!isInTouchMode && (i27 = this.mSelectedPosition) != -1) {
                    int i57 = i27 - this.mFirstPosition;
                    if (i57 >= 0 && i57 < getChildCount()) {
                        positionSelector(this.mSelectedPosition, getChildAt(i57));
                    }
                } else {
                    int i58 = this.mSelectorPosition;
                    if (i58 != -1) {
                        int i59 = i58 - this.mFirstPosition;
                        if (i59 >= 0 && i59 < getChildCount()) {
                            positionSelector(-1, getChildAt(i59));
                        }
                    } else {
                        this.mSelectorRect.setEmpty();
                    }
                }
                this.mBlockLayoutRequests = false;
                invokeOnItemScrollListener();
                awakenScrollBars();
                return false;
            }
            OnScrollButtomListener onScrollButtomListener = this.mOnScrollButtomListener;
            if (onScrollButtomListener != null && min2 <= 0) {
                onScrollButtomListener.onScrollToButtom(min2);
            }
            if (min2 != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            return z18;
        } finally {
            AdapterView.traceEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateScrollIndicators() {
        boolean z16;
        boolean z17;
        int i3;
        int i16 = 4;
        boolean z18 = true;
        if (this.mScrollUp != null) {
            if (this.mFirstPosition > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17 && getChildCount() > 0) {
                if (getChildAt(0).getTop() < this.mListPadding.top) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            }
            View view = this.mScrollUp;
            if (z17) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            view.setVisibility(i3);
        }
        if (this.mScrollDown != null) {
            int childCount = getChildCount();
            if (this.mFirstPosition + childCount < this.mItemCount) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && childCount > 0) {
                if (getChildAt(childCount - 1).getBottom() <= getBottom() - this.mListPadding.bottom) {
                    z18 = false;
                }
                z16 = z18;
            }
            View view2 = this.mScrollDown;
            if (z16) {
                i16 = 0;
            }
            view2.setVisibility(i16);
        }
    }

    void updateSelectorState() {
        if (this.mSelector != null) {
            if (shouldShowSelector()) {
                this.mSelector.setState(getDrawableState());
            } else {
                this.mSelector.setState(NOTHING);
            }
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            return ((Boolean) iPatchRedirector.redirect((short) 83, (Object) this, (Object) drawable)).booleanValue();
        }
        if (this.mSelector != drawable && !super.verifyDrawable(drawable)) {
            return false;
        }
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class SavedState extends View.BaseSavedState {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<SavedState> CREATOR;
        LongSparseArray<Integer> checkIdState;
        SparseBooleanArray checkState;
        int checkedItemCount;
        String filter;
        long firstId;
        int height;
        boolean inActionMode;
        public int position;
        long selectedId;
        int viewTop;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a implements Parcelable.Creator<SavedState> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (SavedState) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (SavedState[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return new SavedState[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38010);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                CREATOR = new a();
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.selectedId = -1L;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) parcelable);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " firstId=" + this.firstId + " viewTop=" + this.viewTop + " position=" + this.position + " height=" + this.height + " filter=" + this.filter + " checkState=" + this.checkState + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
                return;
            }
            super.writeToParcel(parcel, i3);
            parcel.writeLong(this.selectedId);
            parcel.writeLong(this.firstId);
            parcel.writeInt(this.viewTop);
            parcel.writeInt(this.position);
            parcel.writeInt(this.height);
            parcel.writeString(this.filter);
            parcel.writeByte(this.inActionMode ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.checkedItemCount);
            parcel.writeSparseBooleanArray(this.checkState);
            LongSparseArray<Integer> longSparseArray = this.checkIdState;
            if (longSparseArray != null) {
                i16 = longSparseArray.size();
            } else {
                i16 = 0;
            }
            parcel.writeInt(i16);
            for (int i17 = 0; i17 < i16; i17++) {
                parcel.writeLong(this.checkIdState.keyAt(i17));
                parcel.writeInt(this.checkIdState.valueAt(i17).intValue());
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                return;
            }
            this.selectedId = -1L;
            this.selectedId = parcel.readLong();
            this.firstId = parcel.readLong();
            this.viewTop = parcel.readInt();
            this.position = parcel.readInt();
            this.height = parcel.readInt();
            this.filter = parcel.readString();
            this.inActionMode = parcel.readByte() != 0;
            this.checkedItemCount = parcel.readInt();
            this.checkState = parcel.readSparseBooleanArray();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                this.checkIdState = new LongSparseArray<>();
                for (int i3 = 0; i3 < readInt; i3++) {
                    this.checkIdState.put(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 143)) ? new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 143, (Object) this, (Object) layoutParams);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.widget.AdapterView
    @android.support.annotation.RequiresApi(api = 16)
    public void setAdapter(ListAdapter listAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) listAdapter);
            return;
        }
        if (listAdapter != null && this.mChoiceMode != 0 && this.mAdapter.hasStableIds() && this.mCheckedIdStates == null) {
            this.mCheckedIdStates = new LongSparseArray<>();
        }
        SparseBooleanArray sparseBooleanArray = this.mCheckStates;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
        LongSparseArray<Integer> longSparseArray = this.mCheckedIdStates;
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public void setSelector(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this, (Object) drawable);
            return;
        }
        Drawable drawable2 = this.mSelector;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.mSelector);
        }
        this.mSelector = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.mSelectionLeftPadding = rect.left;
        this.mSelectionTopPadding = rect.top;
        this.mSelectionRightPadding = rect.right;
        this.mSelectionBottomPadding = rect.bottom;
        drawable.setCallback(this);
        updateSelectorState();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 144)) ? new LayoutParams(getContext(), attributeSet) : (LayoutParams) iPatchRedirector.redirect((short) 144, (Object) this, (Object) attributeSet);
    }

    public void smoothScrollToPosition(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 124)) {
            iPatchRedirector.redirect((short) 124, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new PositionScroller();
        }
        this.mPositionScroller.start(i3, i16);
    }

    public void smoothScrollToPositionFromTop(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 123)) {
            iPatchRedirector.redirect((short) 123, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new PositionScroller();
        }
        this.mPositionScroller.startWithOffset(i3, i16);
    }

    private void positionSelector(int i3, int i16, int i17, int i18) {
        this.mSelectorRect.set(i3 - this.mSelectionLeftPadding, i16 - this.mSelectionTopPadding, i17 + this.mSelectionRightPadding, i18 + this.mSelectionBottomPadding);
    }

    public AbsListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.absListViewStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
    }

    public AbsListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mChoiceMode = 0;
        this.mLayoutMode = 0;
        this.mEdgeEffectEnabled = false;
        this.mDeferNotifyDataSetChanged = false;
        this.mDrawSelectorOnTop = false;
        this.mSelectorPosition = -1;
        this.mSelectorRect = new Rect();
        this.mRecycler = new RecycleBin();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mListPadding = new Rect();
        this.mWidthMeasureSpec = 0;
        this.mTouchMode = -1;
        this.mSelectedTop = 0;
        this.mOnScrollListenerList = new ArrayList<>();
        this.mSmoothScrollbarEnabled = true;
        this.mResurrectToPosition = -1;
        this.mContextMenuInfo = null;
        this.mLastTouchMode = -1;
        this.mScrollProfilingStarted = false;
        this.mFlingProfilingStarted = false;
        this.mScrollStrictSpan = null;
        this.mFlingStrictSpan = null;
        this.mForHongBao = false;
        this.mForContacts = false;
        this.mEnableStory = false;
        this.mForStory = false;
        this.mLastScrollState = 0;
        this.mVelocityScale = 1.0f;
        this.mIsScrap = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        this.mOverScrollTouchMode = 0;
        this.mCallbackOnUnClickItem = false;
        this.mDisableOverScrollTop = false;
        this.method = null;
        this.mNeedCheckSpringback = false;
        initAbsListView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LISTVIEW_STYLEABLE, i3, 0);
        try {
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            if (drawable != null) {
                setSelector(drawable);
            }
        } catch (Throwable th5) {
            QLog.e(AdapterView.TAG, 1, "AbsListView init error:" + th5.getMessage());
        }
        this.mDrawSelectorOnTop = obtainStyledAttributes.getBoolean(1, false);
        setStackFromBottom(obtainStyledAttributes.getBoolean(2, false));
        setScrollingCacheEnabled(obtainStyledAttributes.getBoolean(3, true));
        setTextFilterEnabled(obtainStyledAttributes.getBoolean(4, false));
        setTranscriptMode(obtainStyledAttributes.getInt(5, 0));
        setCacheColorHint(obtainStyledAttributes.getColor(6, 0));
        setFastScrollEnabled(obtainStyledAttributes.getBoolean(7, false));
        setSmoothScrollbarEnabled(obtainStyledAttributes.getBoolean(8, true));
        setChoiceMode(obtainStyledAttributes.getInt(9, 0));
        setFastScrollAlwaysVisible(obtainStyledAttributes.getBoolean(10, false));
        obtainStyledAttributes.recycle();
    }
}
