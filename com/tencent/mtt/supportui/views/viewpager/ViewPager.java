package com.tencent.mtt.supportui.views.viewpager;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.mtt.supportui.utils.ViewCompatTool;
import com.tencent.mtt.supportui.views.ScrollChecker;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes21.dex */
public class ViewPager extends ViewGroup implements ScrollChecker.IScrollCheck {
    static final float BASELINE_FLING_VELOCITY = 2500.0f;
    static final int CLOSE_ENOUGH = 2;
    static final boolean DEBUG = false;
    static final int DEFAULT_GUTTER_SIZE = 25;
    static final int DEFAULT_OFFSCREEN_PAGES = 1;
    static final int DRAW_ORDER_DEFAULT = 0;
    static final int DRAW_ORDER_FORWARD = 1;
    static final int DRAW_ORDER_REVERSE = 2;
    static final float FLING_VELOCITY_INFLUENCE = 0.4f;
    static final int GALLERY_SCROLL_DURING = 500;
    static final int INVALID_POINTER = -1;
    static final int INVALID_SCREEN = -1;
    static final int MAX_SETTLE_DURATION = 600;
    static final int MIN_DISTANCE_FOR_FLING = 25;
    static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final int SNAP_VELOCITY = 600;
    static final String TAG = "ViewPager";
    protected boolean checkTouchSlop;
    boolean ignoreCheck;
    int mActivePointerId;
    ViewPagerAdapter mAdapter;
    OnAdapterChangeListener mAdapterChangeListener;
    private int mAutoScrollCustomDuration;
    int mBottomPageBounds;
    private boolean mCacheEnabled;
    boolean mCallPageChangedOnFirstLayout;
    boolean mCalledSuper;
    private boolean mCanScroll;
    private IDragChecker mChecker;
    int mChildHeightMeasureSpec;
    int mChildWidthMeasureSpec;
    int mCloseEnough;
    private boolean mConsumeNextTouchDown;
    int mCurItem;
    public int mCurrentScreen;
    Interpolator mCustomInterplater;
    int mDecorChildCount;
    int mDefaultGutterSize;
    private boolean mDisallowInterceptWhenDrag;
    int mDrawingOrder;
    ArrayList<View> mDrawingOrderedChildren;
    private boolean mEnableCatching;
    final Runnable mEndScrollRunnable;
    int mExpectedAdapterCount;
    long mFakeDragBeginTime;
    boolean mFakeDragging;
    private boolean mFirstDatasetChanged;
    boolean mFirstLayout;
    float mFirstOffset;
    protected int mFlingDistance;
    private boolean mFocusSearchEnabled;
    boolean mForceUnableToDrag;
    int mGutterSize;
    boolean mInLayout;
    float mInitialMotionX;
    float mInitialMotionY;
    OnPageChangeListener mInternalPageChangeListener;
    PagerInvalidateListener mInvalidateListener;
    boolean mIsBeingDragged;
    public boolean mIsUnableToDrag;
    private boolean mIsVertical;
    final ArrayList<ItemInfo> mItems;
    protected float mLastMotionX;
    protected float mLastMotionY;
    float mLastOffset;
    private boolean mLayoutNeeded;
    boolean mLeftDragOutSizeEnable;
    QBGalleryGlideBlankListener mLeftGlideBlankListener;
    Drawable mMarginDrawable;
    private float mMaxOffset;
    private int mMaxPage;
    protected int mMaximumVelocity;
    private float mMinOffset;
    private int mMinPage;
    protected int mMinimumVelocity;
    protected boolean mNeedRepopulate;
    int mNextScreen;
    PagerObserver mObserver;
    int mOffscreenPageLimit;
    OnPageChangeListener mOnPageChangeListener;
    OnPageReadyListener mOnPageReadyListener;
    private int mOri;
    int mPageCount;
    int mPageMargin;
    PageTransformer mPageTransformer;
    protected boolean mPopulatePending;
    private boolean mReLayoutOnAttachToWindow;
    Parcelable mRestoredAdapterState;
    ClassLoader mRestoredClassLoader;
    int mRestoredCurItem;
    boolean mRightDragOutSizeEnable;
    QBGalleryGlideBlankListener mRightGlideBlankListener;
    boolean mScrollEnabled;
    protected int mScrollState;
    boolean mScrollToNeedNotify;
    protected Scroller mScroller;
    boolean mScrollingCacheEnabled;
    private PageSelectedListener mSelectedListener;
    Method mSetChildrenDrawingOrderEnabled;
    final ItemInfo mTempItem;
    final Rect mTempRect;
    int mTopPageBounds;
    protected int mTouchSlop;
    private boolean mTouching;
    boolean mUpdateScreenNextCall;
    VelocityTracker mVelocityTracker;
    static final int[] LAYOUT_ATTRS = {R.attr.layout_gravity};
    static final Comparator<ItemInfo> COMPARATOR = new Comparator<ItemInfo>() { // from class: com.tencent.mtt.supportui.views.viewpager.ViewPager.1
        @Override // java.util.Comparator
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.position - itemInfo2.position;
        }
    };
    static final Interpolator sInterpolator = new Interpolator() { // from class: com.tencent.mtt.supportui.views.viewpager.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            float f17 = f16 - 1.0f;
            return (f17 * f17 * f17 * f17 * f17) + 1.0f;
        }
    };
    static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();

    /* loaded from: classes21.dex */
    interface Decor {
    }

    /* loaded from: classes21.dex */
    public interface IDragChecker {
        boolean checkStartDrag(float f16, float f17, float f18);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public static class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float sizeFactor;

        ItemInfo() {
        }

        public String toString() {
            return "position=" + this.position + ",scrolling=" + this.scrolling + ",sizeFactor=" + this.sizeFactor + ",offset=" + this.offset;
        }
    }

    /* loaded from: classes21.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        int childIndex;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;
        public float sizeFactor;
        boolean takeHeightspace;

        public LayoutParams() {
            super(-1, -1);
            this.sizeFactor = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.sizeFactor = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes21.dex */
    public interface OnAdapterChangeListener {
        void onAdapterChanged(ViewPagerAdapter viewPagerAdapter, ViewPagerAdapter viewPagerAdapter2);
    }

    /* loaded from: classes21.dex */
    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i3, int i16);

        void onPageScrolled(int i3, float f16, int i16);

        void onPageSelected(int i3);
    }

    /* loaded from: classes21.dex */
    public interface OnPageReadyListener {
        void onPageReady(int i3);
    }

    /* loaded from: classes21.dex */
    public interface PageSelectedListener {
        void onPageSelected(boolean z16, int i3);
    }

    /* loaded from: classes21.dex */
    public interface PageTransformer {
        void transformPage(View view, float f16);
    }

    /* loaded from: classes21.dex */
    public interface PagerInvalidateListener {
        void onInvalidate();

        void onPostInvalidate();
    }

    /* loaded from: classes21.dex */
    class PagerObserver extends DataSetObserver {
        PagerObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    /* loaded from: classes21.dex */
    public interface QBGalleryGlideBlankListener {
        boolean onGlideBlank(boolean z16);
    }

    /* loaded from: classes21.dex */
    public static class SavedState extends View.BaseSavedState {
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i3);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z16 = layoutParams.isDecor;
            return z16 != layoutParams2.isDecor ? z16 ? 1 : -1 : layoutParams.position - layoutParams2.position;
        }
    }

    public ViewPager(Context context) {
        this(context, false);
    }

    private int findNextPosition(boolean z16) {
        if (getWidth() == 0) {
            return 0;
        }
        if (z16) {
            return (getScrollX() / getWidth()) + 1;
        }
        return getScrollX() / getWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i3, int i16) {
        ItemInfo infoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i17 = 0; i17 < getChildCount(); i17++) {
                View childAt = getChildAt(i17);
                if (childAt != null && childAt.getVisibility() == 0 && (isGallery() || ((infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem))) {
                    childAt.addFocusables(arrayList, i3, i16);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i16 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
            return;
        }
        arrayList.add(this);
    }

    ItemInfo addNewItem(int i3, int i16) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.position = i3;
        itemInfo.object = this.mAdapter.instantiateItem((ViewGroup) this, i3);
        itemInfo.sizeFactor = this.mAdapter.getPageSize(i3);
        if (i16 >= 0 && i16 < this.mItems.size()) {
            this.mItems.add(i16, itemInfo);
        } else {
            this.mItems.add(itemInfo);
        }
        return itemInfo;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo infoForChild;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        boolean z16;
        if (view == null) {
            return;
        }
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z17 = layoutParams2.isDecor | (view instanceof Decor);
        layoutParams2.isDecor = z17;
        if (this.mInLayout) {
            if (!z17) {
                layoutParams2.needsMeasure = true;
                addViewInLayout(view, i3, layoutParams);
            } else {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
        } else {
            super.addView(view, i3, layoutParams);
        }
        if (view.getVisibility() != 8) {
            z16 = this.mScrollingCacheEnabled;
        } else {
            z16 = false;
        }
        view.setDrawingCacheEnabled(z16);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean arrowScroll(int i3) {
        boolean z16;
        View findNextFocus;
        boolean pageRight;
        if (!this.mFocusSearchEnabled) {
            return true;
        }
        View findFocus = findFocus();
        boolean z17 = false;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (parent instanceof ViewGroup) {
                        if (parent == this) {
                            z16 = true;
                            break;
                        }
                        parent = parent.getParent();
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        parent2.getClass();
                    }
                }
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i3);
            if (findNextFocus == null && findNextFocus != findFocus) {
                if (i3 == 17) {
                    int i16 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left;
                    int i17 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).left;
                    if (findFocus != null && i16 >= i17) {
                        pageRight = pageLeft();
                        z17 = pageRight;
                    }
                    pageRight = findNextFocus.requestFocus();
                    z17 = pageRight;
                } else if (i3 == 66) {
                    int i18 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left;
                    int i19 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).left;
                    if (findFocus != null && i18 <= i19) {
                        pageRight = pageRight();
                        z17 = pageRight;
                    }
                    pageRight = findNextFocus.requestFocus();
                    z17 = pageRight;
                }
            } else if (i3 == 17 && i3 != 1) {
                if (i3 == 66 || i3 == 2) {
                    z17 = pageRight();
                }
            } else {
                z17 = pageLeft();
            }
            if (z17) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i3));
            }
            return z17;
        }
        findFocus = null;
        findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i3);
        if (findNextFocus == null) {
        }
        if (i3 == 17) {
        }
        z17 = pageLeft();
        if (z17) {
        }
        return z17;
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    void calculatePageOffsets(ItemInfo itemInfo, int i3, ItemInfo itemInfo2) {
        float f16;
        float f17;
        float f18;
        int i16;
        int i17;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        int count = this.mAdapter.getCount();
        int clientSize = getClientSize();
        if (clientSize > 0) {
            f16 = this.mPageMargin / clientSize;
        } else {
            f16 = 0.0f;
        }
        if (itemInfo2 != null) {
            int i18 = itemInfo2.position;
            int i19 = itemInfo.position;
            if (i18 < i19) {
                float f19 = itemInfo2.offset + itemInfo2.sizeFactor + f16;
                int i26 = i18 + 1;
                int i27 = 0;
                while (i26 <= itemInfo.position && i27 < this.mItems.size()) {
                    while (true) {
                        itemInfo4 = this.mItems.get(i27);
                        if (i26 <= itemInfo4.position || i27 >= this.mItems.size() - 1) {
                            break;
                        } else {
                            i27++;
                        }
                    }
                    while (i26 < itemInfo4.position) {
                        f19 += this.mAdapter.getPageSize(i26) + f16;
                        i26++;
                    }
                    itemInfo4.offset = f19;
                    f19 += itemInfo4.sizeFactor + f16;
                    i26++;
                }
            } else if (i18 > i19) {
                int size = this.mItems.size() - 1;
                float f26 = itemInfo2.offset;
                while (true) {
                    i18--;
                    if (i18 < itemInfo.position || size < 0) {
                        break;
                    }
                    while (true) {
                        itemInfo3 = this.mItems.get(size);
                        if (i18 >= itemInfo3.position || size <= 0) {
                            break;
                        } else {
                            size--;
                        }
                    }
                    while (i18 > itemInfo3.position) {
                        f26 -= this.mAdapter.getPageSize(i18) + f16;
                        i18--;
                    }
                    f26 -= itemInfo3.sizeFactor + f16;
                    itemInfo3.offset = f26;
                }
            }
        }
        int size2 = this.mItems.size();
        float f27 = itemInfo.offset;
        int i28 = itemInfo.position;
        int i29 = i28 - 1;
        if (i28 == 0) {
            f17 = f27;
        } else {
            f17 = -3.4028235E38f;
        }
        this.mFirstOffset = f17;
        int i36 = count - 1;
        if (i28 == i36) {
            f18 = (itemInfo.sizeFactor + f27) - 1.0f;
        } else {
            f18 = Float.MAX_VALUE;
        }
        this.mLastOffset = f18;
        int i37 = i3 - 1;
        while (i37 >= 0) {
            ItemInfo itemInfo5 = this.mItems.get(i37);
            while (true) {
                i17 = itemInfo5.position;
                if (i29 <= i17) {
                    break;
                }
                f27 -= this.mAdapter.getPageSize(i29) + f16;
                i29--;
            }
            f27 -= itemInfo5.sizeFactor + f16;
            itemInfo5.offset = f27;
            if (i17 == 0) {
                this.mFirstOffset = f27;
            }
            i37--;
            i29--;
        }
        float f28 = itemInfo.offset + itemInfo.sizeFactor + f16;
        int i38 = itemInfo.position + 1;
        int i39 = i3 + 1;
        while (i39 < size2) {
            ItemInfo itemInfo6 = this.mItems.get(i39);
            while (true) {
                i16 = itemInfo6.position;
                if (i38 >= i16) {
                    break;
                }
                f28 += this.mAdapter.getPageSize(i38) + f16;
                i38++;
            }
            if (i16 == i36) {
                this.mLastOffset = (itemInfo6.sizeFactor + f28) - 1.0f;
            }
            itemInfo6.offset = f28;
            f28 += itemInfo6.sizeFactor + f16;
            i39++;
            i38++;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i3) {
        if (!this.mScrollEnabled) {
            return false;
        }
        return horizontalCanScroll(i3);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i3) {
        if (!this.mScrollEnabled) {
            return false;
        }
        return verticalCanScroll(i3);
    }

    public void cancelDrag() {
        this.ignoreCheck = false;
        endDrag();
        this.mScrollState = 0;
    }

    void changePage() {
        this.mCurrentScreen = Math.max(getLeftBoundPageIndex(), Math.min(this.mNextScreen, getRightBoundPageIndex()));
        this.mNextScreen = -1;
    }

    protected boolean checkChildCanScroll(int i3, int i16, int i17) {
        return ScrollChecker.canScroll(this, false, this.mIsVertical, i3, i16, i17);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    protected boolean checkStartDrag(float f16, float f17, float f18, float f19, boolean z16, boolean z17) {
        IDragChecker iDragChecker = this.mChecker;
        if (iDragChecker == null) {
            Log.d("PageScroller", "checkStartDrag,deltaX=" + f16 + ",deltaY=" + f17);
            if (this.mIsVertical) {
                if (!this.checkTouchSlop && f17 > f16) {
                    return true;
                }
                if (f17 > this.mTouchSlop && f17 > f16) {
                    return true;
                }
                return false;
            }
            if (!this.checkTouchSlop && f16 > f17) {
                return true;
            }
            if (f16 > this.mTouchSlop && f16 > f17) {
                return true;
            }
            return false;
        }
        return iDragChecker.checkStartDrag(f16, f17, this.mTouchSlop);
    }

    public Object childByPosition(int i3) {
        ItemInfo infoForPosition = infoForPosition(i3);
        if (infoForPosition != null) {
            return infoForPosition.object;
        }
        return null;
    }

    void completeScroll(boolean z16) {
        boolean z17;
        if (this.mScrollState == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            setScrollingCacheEnabled(false);
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
        }
        this.mPopulatePending = false;
        for (int i3 = 0; i3 < this.mItems.size(); i3++) {
            ItemInfo itemInfo = this.mItems.get(i3);
            if (itemInfo.scrolling) {
                itemInfo.scrolling = false;
                z17 = true;
            }
        }
        if (z17) {
            if (z16) {
                ViewCompatTool.postOnAnimation(this, this.mEndScrollRunnable);
            } else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        int i3;
        Log.d("ViewPager", "computeScroll,mNextScreen=" + this.mNextScreen);
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            Log.d("ViewPager", "computeScroll not finished");
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (this.mIsVertical) {
                    i3 = currY;
                } else {
                    i3 = currX;
                }
                if (!pageScrolled(i3) && !isGallery()) {
                    this.mScroller.abortAnimation();
                    if (this.mIsVertical) {
                        scrollTo(0, currY);
                    } else {
                        scrollTo(currX, 0);
                    }
                }
            }
            ViewCompatTool.postInvalidateOnAnimation(this);
            return;
        }
        if (this.mNextScreen != -1) {
            changePage();
            if (this.mScrollState == 0) {
                notifyScrollStateChanged(0, 0);
            }
            Log.d("ViewPager", "computeScroll changePage");
            setScrollState(0);
            return;
        }
        if (this.mScrollToNeedNotify) {
            this.mScrollToNeedNotify = false;
            if (this.mScrollState == 0) {
                notifyScrollStateChanged(0, 0);
            }
        }
        completeScroll(true);
    }

    public void consumeNextTouchDown() {
        this.mConsumeNextTouchDown = true;
    }

    void dataSetChanged() {
        boolean z16;
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        if (this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.mFirstDatasetChanged) {
            this.mFirstDatasetChanged = false;
            this.mCurItem = this.mAdapter.getInitialItemIndex();
        }
        int i3 = this.mCurItem;
        int i16 = 0;
        boolean z17 = false;
        while (i16 < this.mItems.size()) {
            ItemInfo itemInfo = this.mItems.get(i16);
            int itemPosition = this.mAdapter.getItemPosition(itemInfo.object);
            if ((itemPosition == -1 || itemPosition == itemInfo.position) && this.mAdapter.refreshItem(this, itemInfo.position, itemInfo.object) > 0) {
                itemInfo.sizeFactor = this.mAdapter.getPageSize(itemInfo.position);
                z16 = true;
            }
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i16);
                    i16--;
                    if (!z17) {
                        this.mAdapter.startUpdate((ViewGroup) this, this.mCurItem);
                        z17 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
                    int i17 = this.mCurItem;
                    if (i17 == itemInfo.position) {
                        i3 = Math.max(0, Math.min(i17, count - 1));
                    }
                } else {
                    int i18 = itemInfo.position;
                    if (i18 != itemPosition) {
                        if (i18 == this.mCurItem) {
                            i3 = itemPosition;
                        }
                        itemInfo.position = itemPosition;
                    }
                }
                z16 = true;
            }
            i16++;
        }
        if (z17) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z16) {
            int childCount = getChildCount();
            for (int i19 = 0; i19 < childCount; i19++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i19).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.sizeFactor = 0.0f;
                }
            }
            setCurrentItemInternal(i3, false, true);
            requestLayout();
        }
    }

    int determineTargetPage(int i3, float f16, int i16, int i17) {
        float f17;
        ItemInfo infoForPosition;
        ItemInfo infoForPosition2;
        if (Math.abs(i17) > this.mFlingDistance && Math.abs(i16) > this.mMinimumVelocity) {
            if (i16 <= 0) {
                i3++;
            }
        } else {
            if (i3 >= this.mCurItem) {
                f17 = 0.4f;
            } else {
                f17 = 0.6f;
            }
            i3 = (int) (i3 + f16 + f17);
        }
        if (this.mItems.size() > 0) {
            int i18 = this.mMinPage;
            if (i18 == Integer.MIN_VALUE) {
                infoForPosition = this.mItems.get(0);
            } else {
                infoForPosition = infoForPosition(i18);
            }
            int i19 = this.mMaxPage;
            if (i19 == Integer.MAX_VALUE) {
                infoForPosition2 = this.mItems.get(r4.size() - 1);
            } else {
                infoForPosition2 = infoForPosition(i19);
            }
            return Math.max(infoForPosition.position, Math.min(i3, infoForPosition2.position));
        }
        return i3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent) && !executeKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo infoForChild;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    float distanceInfluenceForSnapDuration(double d16) {
        return (float) Math.sin((d16 - 0.5d) * 0.4712389167638204d);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    void dumpItemInfos() {
        if (this.mItems != null) {
            for (int i3 = 0; i3 < this.mItems.size(); i3++) {
                Log.d("ViewPager", "index " + i3 + "--->" + this.mItems.get(i3).toString());
            }
        }
    }

    void enableLayers(boolean z16) {
        int i3;
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            if (z16) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            getChildAt(i16).setLayerType(i3, null);
        }
    }

    void endDrag() {
        Log.d("ViewPager", "endDrag");
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        this.checkTouchSlop = true;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void endFakeDrag() {
        int scrollX;
        float f16;
        float f17;
        if (this.mFakeDragging) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientSize = getClientSize();
            if (this.mIsVertical) {
                scrollX = getScrollY();
            } else {
                scrollX = getScrollX();
            }
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            int i3 = infoForCurrentScrollPosition.position;
            float f18 = ((scrollX / clientSize) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.sizeFactor;
            if (this.mIsVertical) {
                f16 = this.mLastMotionY;
                f17 = this.mInitialMotionY;
            } else {
                f16 = this.mLastMotionX;
                f17 = this.mInitialMotionX;
            }
            setCurrentItemInternal(determineTargetPage(i3, f18, xVelocity, (int) (f16 - f17)), true, true, 0, xVelocity);
            endDrag();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        int i3;
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            i3 = 2;
                        } else if (keyEvent.hasModifiers(1)) {
                            return arrowScroll(1);
                        }
                    }
                } else {
                    i3 = 66;
                }
            } else {
                i3 = 17;
            }
            return arrowScroll(i3);
        }
        return false;
    }

    public void fakeDragBy(float f16) {
        int scrollX;
        int clientWidth;
        float f17;
        float f18;
        if (this.mFakeDragging) {
            boolean z16 = this.mIsVertical;
            if (z16) {
                this.mLastMotionY += f16;
            } else {
                this.mLastMotionX += f16;
            }
            if (z16) {
                scrollX = getScrollY();
            } else {
                scrollX = getScrollX();
            }
            float f19 = scrollX - f16;
            if (this.mIsVertical) {
                clientWidth = getClientHeight();
            } else {
                clientWidth = getClientWidth();
            }
            float f26 = clientWidth;
            float f27 = this.mFirstOffset * f26;
            float f28 = this.mLastOffset * f26;
            ItemInfo itemInfo = this.mItems.get(0);
            ItemInfo itemInfo2 = this.mItems.get(r4.size() - 1);
            if (itemInfo.position != 0) {
                f27 = itemInfo.offset * f26;
            }
            if (itemInfo2.position != this.mAdapter.getCount() - 1) {
                f28 = itemInfo2.offset * f26;
            }
            if (f19 < f27) {
                f19 = f27;
            } else if (f19 > f28) {
                f19 = f28;
            }
            if (this.mIsVertical) {
                int i3 = (int) f19;
                this.mLastMotionY += f19 - i3;
                scrollTo(getScrollX(), i3);
            } else {
                int i16 = (int) f19;
                this.mLastMotionX += f19 - i16;
                scrollTo(i16, getScrollY());
            }
            pageScrolled((int) f19);
            long uptimeMillis = SystemClock.uptimeMillis();
            boolean z17 = this.mIsVertical;
            if (z17) {
                f17 = 0.0f;
            } else {
                f17 = this.mLastMotionX;
            }
            if (z17) {
                f18 = this.mLastMotionY;
            } else {
                f18 = 0.0f;
            }
            MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, uptimeMillis, 2, f17, f18, 0);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    @Override // android.view.View
    public void forceLayout() {
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public ViewPagerAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i16) {
        if (this.mDrawingOrder == 2) {
            i16 = (i3 - 1) - i16;
        }
        if (i16 >= this.mDrawingOrderedChildren.size()) {
            i16 = this.mDrawingOrderedChildren.size() - 1;
        }
        if (i16 < 0) {
            i16 = 0;
        }
        return ((LayoutParams) this.mDrawingOrderedChildren.get(i16).getLayoutParams()).childIndex;
    }

    Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        int bottom = view.getBottom();
        while (true) {
            rect.bottom = bottom;
            ViewParent parent = view.getParent();
            if (!(parent instanceof ViewGroup) || parent == this) {
                break;
            }
            view = (ViewGroup) parent;
            rect.left += view.getLeft();
            rect.right += view.getRight();
            rect.top += view.getTop();
            bottom = rect.bottom + view.getBottom();
        }
        return rect;
    }

    public int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    int getClientSize() {
        if (this.mIsVertical) {
            return getClientHeight();
        }
        return getClientWidth();
    }

    int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public Object getCurrentItemView() {
        ItemInfo infoForPosition = infoForPosition(this.mCurItem);
        if (infoForPosition != null) {
            return infoForPosition.object;
        }
        return null;
    }

    public int getCurrentPage() {
        if (isGallery()) {
            return this.mCurrentScreen;
        }
        return this.mCurItem;
    }

    protected int getGutterSize() {
        return this.mGutterSize;
    }

    public float getLastMotionX() {
        return this.mLastMotionX;
    }

    public float getLastMotionY() {
        return this.mLastMotionY;
    }

    protected int getLeftBoundPageIndex() {
        return 0;
    }

    protected int getLeftEdge() {
        return 0;
    }

    public int getNextScreen() {
        return this.mNextScreen;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageCount() {
        if (isGallery()) {
            return getChildCount();
        }
        ViewPagerAdapter viewPagerAdapter = this.mAdapter;
        if (viewPagerAdapter == null) {
            return 0;
        }
        return viewPagerAdapter.getCount();
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public PageSelectedListener getPageSelectedListener() {
        return this.mSelectedListener;
    }

    protected int getRightBoundPageIndex() {
        return getPageCount() - 1;
    }

    protected float getRightEdge() {
        int width;
        int pageCount = getPageCount();
        View childAt = getChildAt(pageCount);
        if (childAt != null) {
            width = childAt.getRight() - getWidth();
        } else {
            width = (pageCount - 1) * getWidth();
        }
        return width;
    }

    public float getTotalLength() {
        int width;
        float f16 = 0.0f;
        for (int i3 = 0; i3 < this.mAdapter.getCount(); i3++) {
            if (this.mIsVertical) {
                width = getHeight();
            } else {
                width = getWidth();
            }
            f16 += width * this.mAdapter.getPageSize(i3);
        }
        return f16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (r0 == (getPageCount() - 1)) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0021, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x002f, code lost:
    
        if (r0 == (getPageCount() - 1)) goto L15;
     */
    @Override // com.tencent.mtt.supportui.views.ScrollChecker.IScrollCheck
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean horizontalCanScroll(int i3) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (!this.mCanScroll || this.mIsVertical) {
            return false;
        }
        if (isGallery()) {
            int i16 = this.mCurrentScreen;
            if (i16 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        } else {
            int i17 = this.mCurItem;
            if (i17 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        if (i3 < 0 && (this.mLeftDragOutSizeEnable || !z16)) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (i3 > 0 && (this.mRightDragOutSizeEnable || !z17)) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (!z18 && !z19) {
            return false;
        }
        return true;
    }

    ItemInfo infoForAnyChild(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent != null && (parent instanceof View)) {
                    view = (View) parent;
                } else {
                    return null;
                }
            } else {
                return infoForChild(view);
            }
        }
    }

    ItemInfo infoForChild(View view) {
        for (int i3 = 0; i3 < this.mItems.size(); i3++) {
            ItemInfo itemInfo = this.mItems.get(i3);
            if (this.mAdapter.isViewFromObject(view, itemInfo.object)) {
                return itemInfo;
            }
        }
        return null;
    }

    ItemInfo infoForCurrentScrollPosition() {
        float f16;
        float f17;
        int i3;
        int scrollX;
        int clientSize = getClientSize();
        float f18 = 0.0f;
        if (clientSize > 0) {
            if (this.mIsVertical) {
                scrollX = getScrollY();
            } else {
                scrollX = getScrollX();
            }
            f16 = scrollX / clientSize;
        } else {
            f16 = 0.0f;
        }
        if (clientSize > 0) {
            f17 = this.mPageMargin / clientSize;
        } else {
            f17 = 0.0f;
        }
        int i16 = 0;
        boolean z16 = true;
        ItemInfo itemInfo = null;
        int i17 = -1;
        float f19 = 0.0f;
        while (i16 < this.mItems.size()) {
            ItemInfo itemInfo2 = this.mItems.get(i16);
            if (!z16 && itemInfo2.position != (i3 = i17 + 1)) {
                itemInfo2 = this.mTempItem;
                itemInfo2.offset = f18 + f19 + f17;
                itemInfo2.position = i3;
                itemInfo2.sizeFactor = this.mAdapter.getPageSize(i3);
                i16--;
            }
            ItemInfo itemInfo3 = itemInfo2;
            f18 = itemInfo3.offset;
            float f26 = itemInfo3.sizeFactor + f18 + f17;
            if (!z16 && f16 < f18) {
                return itemInfo;
            }
            if (f16 >= f26 && i16 != this.mItems.size() - 1) {
                int i18 = itemInfo3.position;
                float f27 = itemInfo3.sizeFactor;
                i16++;
                z16 = false;
                i17 = i18;
                f19 = f27;
                itemInfo = itemInfo3;
            } else {
                return itemInfo3;
            }
        }
        return itemInfo;
    }

    ItemInfo infoForPosition(int i3) {
        for (int i16 = 0; i16 < this.mItems.size(); i16++) {
            ItemInfo itemInfo = this.mItems.get(i16);
            if (itemInfo.position == i3) {
                return itemInfo;
            }
        }
        return null;
    }

    protected void initViewPager() {
        Scroller scroller;
        setWillNotDraw(false);
        ViewCompatTool.setDefaultLayotuDirection(this);
        setDescendantFocusability(262144);
        Context context = getContext();
        if (this.mCustomInterplater != null) {
            scroller = new Scroller(context, this.mCustomInterplater);
        } else {
            scroller = new Scroller(context, sInterpolator);
        }
        this.mScroller = scroller;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f16 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f16);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        int i3 = (int) (25.0f * f16);
        this.mFlingDistance = i3;
        this.mCloseEnough = (int) (f16 * 2.0f);
        this.mDefaultGutterSize = i3;
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.tencent.mtt.supportui.views.viewpager.ViewPager.4
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ViewPager.this.post(new Runnable() { // from class: com.tencent.mtt.supportui.views.viewpager.ViewPager.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i16;
                        ViewPager viewPager = ViewPager.this;
                        OnPageReadyListener onPageReadyListener = viewPager.mOnPageReadyListener;
                        if (onPageReadyListener != null) {
                            if (viewPager.isGallery()) {
                                i16 = ViewPager.this.mCurrentScreen;
                            } else {
                                i16 = ViewPager.this.mCurItem;
                            }
                            onPageReadyListener.onPageReady(i16);
                        }
                    }
                });
                ViewPager.this.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        PagerInvalidateListener pagerInvalidateListener = this.mInvalidateListener;
        if (pagerInvalidateListener != null) {
            pagerInvalidateListener.onInvalidate();
        }
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    public boolean isFirstLayout() {
        return this.mFirstLayout;
    }

    public boolean isGallery() {
        if (this.mAdapter == null) {
            return true;
        }
        return false;
    }

    protected boolean isGutterDrag(float f16, float f17) {
        if ((f16 < getGutterSize() && f17 > 0.0f) || (f16 > getWidth() - getGutterSize() && f17 < 0.0f)) {
            return true;
        }
        return false;
    }

    public boolean isIdle() {
        if (this.mScrollState == 0) {
            return true;
        }
        return false;
    }

    public boolean isScrollEnabled() {
        return this.mScrollEnabled;
    }

    public boolean isSettling() {
        if (this.mScrollState == 2) {
            return true;
        }
        return false;
    }

    protected void notifyScrollStateChanged(int i3, int i16) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i3, i16);
        }
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageScrollStateChanged(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mReLayoutOnAttachToWindow) {
            this.mFirstLayout = true;
            requestLayout();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        int i3 = configuration.orientation;
        if (i3 != this.mOri) {
            this.mLayoutNeeded = true;
        }
        this.mOri = i3;
        super.onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        float f16;
        float f17;
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int scrollX = getScrollX();
            float width = getWidth();
            float f18 = this.mPageMargin / width;
            int i16 = 0;
            ItemInfo itemInfo = this.mItems.get(0);
            float f19 = itemInfo.offset;
            int size = this.mItems.size();
            int i17 = itemInfo.position;
            int i18 = this.mItems.get(size - 1).position;
            while (i17 < i18) {
                while (true) {
                    i3 = itemInfo.position;
                    if (i17 <= i3 || i16 >= size) {
                        break;
                    }
                    i16++;
                    itemInfo = this.mItems.get(i16);
                }
                if (i17 == i3) {
                    float f26 = itemInfo.offset;
                    float f27 = itemInfo.sizeFactor;
                    f16 = (f26 + f27) * width;
                    f19 = f26 + f27 + f18;
                } else {
                    float pageSize = this.mAdapter.getPageSize(i17);
                    f16 = (f19 + pageSize) * width;
                    f19 += pageSize + f18;
                }
                int i19 = this.mPageMargin;
                if (i19 + f16 > scrollX) {
                    f17 = f18;
                    this.mMarginDrawable.setBounds((int) f16, this.mTopPageBounds, (int) (i19 + f16 + 0.5f), this.mBottomPageBounds);
                    this.mMarginDrawable.draw(canvas);
                } else {
                    f17 = f18;
                }
                if (f16 <= scrollX + r2) {
                    i17++;
                    f18 = f17;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r1v14 */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ?? r16;
        ViewParent parent;
        boolean z16;
        boolean z17;
        float f16;
        boolean z18;
        float f17;
        float f18;
        ViewParent parent2;
        int action = motionEvent.getAction() & 255;
        if (action == 0 && this.mConsumeNextTouchDown) {
            this.mConsumeNextTouchDown = false;
            return true;
        }
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (!this.mIsUnableToDrag && !this.mForceUnableToDrag) {
                    if (this.mIsBeingDragged) {
                        return true;
                    }
                } else {
                    Log.d("ViewPager", "onInterceptTouchEvent,resutl false due to mIsUnableToDrag");
                    return false;
                }
            }
            if (action != 0) {
                if (action != 2) {
                    if (action == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                } else {
                    int i3 = this.mActivePointerId;
                    if (i3 == -1) {
                        Log.d("PageScroller", "INVALID_POINTER");
                    } else {
                        int findPointerIndex = motionEvent.findPointerIndex(i3);
                        if (findPointerIndex != -1) {
                            float x16 = motionEvent.getX(findPointerIndex);
                            float f19 = x16 - this.mLastMotionX;
                            float abs = Math.abs(f19);
                            float y16 = motionEvent.getY(findPointerIndex);
                            float abs2 = Math.abs(y16 - this.mInitialMotionY);
                            float f26 = this.mLastMotionY;
                            float f27 = y16 - f26;
                            float f28 = this.mLastMotionX;
                            if (f19 < 0.0f) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (f27 < 0.0f) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (this.mIsVertical) {
                                if (!this.mScrollEnabled || (f27 != 0.0f && !isGutterDrag(f26, f27) && !this.ignoreCheck && checkChildCanScroll((int) f27, (int) x16, (int) y16))) {
                                    Log.v("ViewPager", "checkChildCanScroll failed,return false");
                                    this.mLastMotionX = x16;
                                    this.mLastMotionY = y16;
                                    this.mIsUnableToDrag = true;
                                    return false;
                                }
                            } else if (!this.mScrollEnabled || (f19 != 0.0f && !isGutterDrag(f28, f19) && !this.ignoreCheck && checkChildCanScroll((int) f19, (int) x16, (int) y16))) {
                                Log.v("ViewPager", "checkChildCanScroll failed,return false");
                                this.mLastMotionX = x16;
                                this.mLastMotionY = y16;
                                this.mIsUnableToDrag = true;
                                return false;
                            }
                            if (checkStartDrag(abs, abs2, f28, f26, z16, z17)) {
                                if (this.mIsVertical) {
                                    f16 = f27;
                                } else {
                                    f16 = f19;
                                }
                                if (f16 < 0.0f) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                if (onStartDrag(z18)) {
                                    this.mIsBeingDragged = true;
                                    setScrollState(1);
                                    if (this.mDisallowInterceptWhenDrag && (parent2 = getParent()) != null) {
                                        parent2.requestDisallowInterceptTouchEvent(true);
                                    }
                                    if (this.mIsVertical) {
                                        if (this.checkTouchSlop) {
                                            if (f27 > 0.0f) {
                                                f18 = this.mInitialMotionY + this.mTouchSlop;
                                            } else {
                                                f18 = this.mInitialMotionY - this.mTouchSlop;
                                            }
                                            this.mLastMotionY = f18;
                                        }
                                        this.mLastMotionX = x16;
                                    } else {
                                        if (this.checkTouchSlop) {
                                            if (f19 > 0.0f) {
                                                f17 = this.mInitialMotionX + this.mTouchSlop;
                                            } else {
                                                f17 = this.mInitialMotionX - this.mTouchSlop;
                                            }
                                            this.mLastMotionX = f17;
                                        }
                                        this.mLastMotionY = y16;
                                    }
                                    setScrollingCacheEnabled(true);
                                }
                            } else {
                                boolean z19 = this.mIsVertical;
                                if ((!z19 && abs2 > this.mTouchSlop) || (z19 && abs > this.mTouchSlop)) {
                                    this.mIsUnableToDrag = true;
                                }
                            }
                            if (this.mIsBeingDragged) {
                                if (this.mIsVertical) {
                                    x16 = y16;
                                }
                                if (performDrag(x16)) {
                                    ViewCompatTool.postInvalidateOnAnimation(this);
                                }
                            }
                        }
                    }
                }
            } else {
                this.ignoreCheck = false;
                float x17 = motionEvent.getX();
                this.mInitialMotionX = x17;
                this.mLastMotionX = x17;
                float y17 = motionEvent.getY();
                this.mInitialMotionY = y17;
                this.mLastMotionY = y17;
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsUnableToDrag = false;
                this.mScroller.computeScrollOffset();
                if (this.mEnableCatching && this.mScrollState == 2 && ((!this.mIsVertical && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) || (this.mIsVertical && this.mScroller.getFinalY() - this.mScroller.getCurrY() > this.mCloseEnough))) {
                    this.mScroller.abortAnimation();
                    if (this.mDisallowInterceptWhenDrag && (parent = getParent()) != null) {
                        r16 = 1;
                        parent.requestDisallowInterceptTouchEvent(true);
                    } else {
                        r16 = 1;
                    }
                    this.mPopulatePending = false;
                    populate();
                    this.mIsBeingDragged = r16;
                    setScrollState(r16);
                } else if (!isGallery()) {
                    completeScroll(false);
                    this.mIsBeingDragged = false;
                }
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            return this.mIsBeingDragged;
        }
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        this.ignoreCheck = false;
        this.checkTouchSlop = true;
        this.mActivePointerId = -1;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        int i26;
        int i27;
        ItemInfo infoForChild;
        int i28;
        boolean z17;
        int max;
        int i29;
        int childCount = getChildCount();
        int i36 = i17 - i3;
        int i37 = i18 - i16;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i38 = 0;
        int i39 = 0;
        while (true) {
            i19 = 8;
            if (i38 >= childCount) {
                break;
            }
            View childAt = getChildAt(i38);
            if (childAt != null && childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i46 = layoutParams.gravity;
                    int i47 = i46 & 7;
                    int i48 = i46 & 112;
                    if (i47 != 1) {
                        if (i47 != 3) {
                            if (i47 != 5) {
                                max = paddingLeft;
                            } else {
                                max = (i36 - paddingRight) - childAt.getMeasuredWidth();
                                paddingRight += childAt.getMeasuredWidth();
                            }
                        } else {
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                        }
                    } else {
                        max = Math.max((i36 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    if (i48 != 16) {
                        if (i48 != 48) {
                            if (i48 == 80) {
                                int measuredHeight = (i37 - paddingBottom) - childAt.getMeasuredHeight();
                                if (layoutParams.takeHeightspace) {
                                    paddingBottom += childAt.getMeasuredHeight();
                                }
                                i29 = paddingTop;
                                paddingTop = measuredHeight;
                            }
                            i29 = paddingTop;
                        } else {
                            if (layoutParams.takeHeightspace) {
                                i29 = childAt.getMeasuredHeight() + paddingTop;
                            }
                            i29 = paddingTop;
                        }
                    } else {
                        i29 = paddingTop;
                        paddingTop = Math.max((i37 - childAt.getMeasuredHeight()) / 2, paddingTop);
                    }
                    int i49 = max + scrollX;
                    childAt.layout(i49, paddingTop, childAt.getMeasuredWidth() + i49, childAt.getMeasuredHeight() + paddingTop);
                    i39++;
                    paddingTop = i29;
                }
            }
            i38++;
        }
        if (this.mIsVertical) {
            i26 = (i37 - paddingTop) - paddingBottom;
        } else {
            i26 = (i36 - paddingLeft) - paddingRight;
        }
        if (this.mAdapter == null) {
            int childCount2 = getChildCount();
            int i56 = 0;
            for (int i57 = 0; i57 < childCount2; i57++) {
                View childAt2 = getChildAt(i57);
                if (childAt2 != null && childAt2.getVisibility() != 8 && !((LayoutParams) childAt2.getLayoutParams()).isDecor) {
                    int i58 = i56 + i26;
                    childAt2.layout(i56, paddingTop, i58, childAt2.getMeasuredHeight() + paddingTop);
                    i56 = i58;
                }
            }
        } else {
            int i59 = 0;
            while (i59 < childCount) {
                View childAt3 = getChildAt(i59);
                if (childAt3 != null && childAt3.getVisibility() != i19) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                    if (!layoutParams2.isDecor && (infoForChild = infoForChild(childAt3)) != null) {
                        float f16 = i26;
                        int i65 = (int) (infoForChild.offset * f16);
                        boolean z18 = this.mIsVertical;
                        if (z18) {
                            i28 = i65 + paddingTop;
                        } else {
                            i28 = i65 + paddingLeft;
                        }
                        i27 = childCount;
                        if (layoutParams2.needsMeasure) {
                            layoutParams2.needsMeasure = false;
                            if (!z18) {
                                childAt3.measure(View.MeasureSpec.makeMeasureSpec((int) (f16 * layoutParams2.sizeFactor), 1073741824), View.MeasureSpec.makeMeasureSpec((i37 - paddingTop) - paddingBottom, 1073741824));
                            } else {
                                childAt3.measure(View.MeasureSpec.makeMeasureSpec((i36 - paddingLeft) - paddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (f16 * layoutParams2.sizeFactor), 1073741824));
                            }
                        }
                        if (this.mIsVertical) {
                            childAt3.layout(paddingLeft, i28, childAt3.getMeasuredWidth() + paddingLeft, childAt3.getMeasuredHeight() + i28);
                        } else {
                            childAt3.layout(i28, paddingTop, childAt3.getMeasuredWidth() + i28, childAt3.getMeasuredHeight() + paddingTop);
                        }
                        i59++;
                        childCount = i27;
                        i19 = 8;
                    }
                }
                i27 = childCount;
                i59++;
                childCount = i27;
                i19 = 8;
            }
        }
        this.mTopPageBounds = paddingTop;
        this.mBottomPageBounds = i37 - paddingBottom;
        this.mDecorChildCount = i39;
        this.mPageCount = getChildCount() - this.mDecorChildCount;
        if (this.mFirstLayout || this.mLayoutNeeded) {
            this.mLayoutNeeded = false;
            if (!isGallery()) {
                scrollToItem(this.mCurItem, false, 0, false);
            } else {
                scrollTo(getCurrentPage() * getWidth(), getScrollY());
            }
        }
        if (this.mUpdateScreenNextCall) {
            scrollTo(getCurrentPage() * getWidth(), getScrollY());
            z17 = false;
            this.mUpdateScreenNextCall = false;
        } else {
            z17 = false;
        }
        this.mFirstLayout = z17;
    }

    boolean onLeftGlideBlank() {
        QBGalleryGlideBlankListener qBGalleryGlideBlankListener = this.mLeftGlideBlankListener;
        if (qBGalleryGlideBlankListener != null && qBGalleryGlideBlankListener.onGlideBlank(true)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        LayoutParams layoutParams;
        int makeMeasureSpec;
        LayoutParams layoutParams2;
        boolean z16;
        int i18;
        setMeasuredDimension(View.getDefaultSize(0, i3), View.getDefaultSize(0, i16));
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        if (this.mIsVertical) {
            i17 = measuredHeight / 10;
        } else {
            i17 = measuredWidth / 10;
        }
        this.mGutterSize = Math.min(i17, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i19 = 0;
        while (true) {
            boolean z17 = true;
            int i26 = 1073741824;
            if (i19 >= childCount) {
                break;
            }
            View childAt = getChildAt(i19);
            if (childAt != null && childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.isDecor) {
                int i27 = layoutParams2.gravity;
                int i28 = i27 & 7;
                int i29 = i27 & 112;
                if (i29 != 48 && i29 != 80) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (i28 != 3 && i28 != 5) {
                    z17 = false;
                }
                int i36 = Integer.MIN_VALUE;
                if (z16) {
                    i18 = Integer.MIN_VALUE;
                    i36 = 1073741824;
                } else if (z17) {
                    i18 = 1073741824;
                } else {
                    i18 = Integer.MIN_VALUE;
                }
                int i37 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i37 != -2) {
                    if (i37 == -1) {
                        i37 = paddingLeft;
                    }
                    i36 = 1073741824;
                } else {
                    i37 = paddingLeft;
                }
                int i38 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i38 != -2) {
                    if (i38 == -1) {
                        i38 = measuredHeight2;
                    }
                } else {
                    i38 = measuredHeight2;
                    i26 = i18;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i37, i36), View.MeasureSpec.makeMeasureSpec(i38, i26));
                if (z16 && layoutParams2.takeHeightspace) {
                    measuredHeight2 -= childAt.getMeasuredHeight();
                }
            }
            i19++;
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i39 = 0; i39 < childCount2; i39++) {
            View childAt2 = getChildAt(i39);
            if (childAt2 != null && childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.isDecor)) {
                if (isGallery()) {
                    makeMeasureSpec = this.mChildWidthMeasureSpec;
                } else if (this.mIsVertical) {
                    childAt2.measure(this.mChildWidthMeasureSpec, View.MeasureSpec.makeMeasureSpec((int) (measuredHeight2 * layoutParams.sizeFactor), 1073741824));
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * layoutParams.sizeFactor), 1073741824);
                }
                childAt2.measure(makeMeasureSpec, this.mChildHeightMeasureSpec);
            }
        }
    }

    public boolean onOverScroll(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        if (this.mIsVertical) {
            if ((i18 != 0 || i16 >= 0) && (i18 != i26 || i16 <= 0)) {
                return true;
            }
        } else if ((i17 != 0 || i3 >= 0) && (i17 != i19 || i3 <= 0)) {
            return true;
        }
        onOverScrollSuccess();
        return true;
    }

    public void onOverScrollSuccess() {
        this.mIsUnableToDrag = false;
        this.ignoreCheck = true;
    }

    public boolean onOverScrollWithNativeContainer(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        if ((i17 == 0 && i3 < 0) || (i17 == i19 && i3 > 0)) {
            this.mIsUnableToDrag = false;
            return true;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onPageScrolled(int i3, float f16, int i16) {
        float left;
        int clientWidth;
        int max;
        int i17;
        int top;
        int max2;
        int i18;
        int left2;
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            getPaddingBottom();
            int width = getWidth();
            int height = getHeight();
            int childCount = getChildCount();
            for (int i19 = 0; i19 < childCount; i19++) {
                View childAt = getChildAt(i19);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    boolean z16 = this.mIsVertical;
                    int i26 = layoutParams.gravity;
                    if (!z16) {
                        int i27 = i26 & 7;
                        if (i27 != 1) {
                            if (i27 != 3) {
                                if (i27 != 5) {
                                    i18 = paddingLeft;
                                } else {
                                    max2 = (width - paddingRight) - childAt.getMeasuredWidth();
                                    paddingRight += childAt.getMeasuredWidth();
                                }
                            } else {
                                i18 = childAt.getWidth() + paddingLeft;
                            }
                            left2 = (paddingLeft + scrollX) - childAt.getLeft();
                            if (left2 != 0) {
                                childAt.offsetLeftAndRight(left2);
                            }
                            paddingLeft = i18;
                        } else {
                            max2 = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                        }
                        int i28 = paddingLeft;
                        paddingLeft = max2;
                        i18 = i28;
                        left2 = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left2 != 0) {
                        }
                        paddingLeft = i18;
                    } else {
                        int i29 = i26 & 112;
                        if (i29 != 16) {
                            if (i29 != 48) {
                                if (i29 != 80) {
                                    i17 = paddingTop;
                                } else {
                                    max = (height - paddingTop) - childAt.getMeasuredHeight();
                                    childAt.getMeasuredHeight();
                                }
                            } else {
                                i17 = childAt.getHeight() + paddingTop;
                            }
                            top = (paddingTop + scrollY) - childAt.getTop();
                            if (top != 0) {
                                childAt.offsetLeftAndRight(top);
                            }
                            paddingTop = i17;
                        } else {
                            max = Math.max((height - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i36 = paddingTop;
                        paddingTop = max;
                        i17 = i36;
                        top = (paddingTop + scrollY) - childAt.getTop();
                        if (top != 0) {
                        }
                        paddingTop = i17;
                    }
                }
            }
        }
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i3, f16, i16);
        }
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageScrolled(i3, f16, i16);
        }
        if (this.mPageTransformer != null) {
            if (!this.mIsVertical) {
                int scrollX2 = getScrollX();
                int childCount2 = getChildCount();
                for (int i37 = 0; i37 < childCount2; i37++) {
                    View childAt2 = getChildAt(i37);
                    if (!((LayoutParams) childAt2.getLayoutParams()).isDecor) {
                        if (this.mIsVertical) {
                            left = childAt2.getTop() - getScrollY();
                            clientWidth = getClientHeight();
                        } else {
                            left = childAt2.getLeft() - scrollX2;
                            clientWidth = getClientWidth();
                        }
                        this.mPageTransformer.transformPage(childAt2, left / clientWidth);
                    }
                }
            } else {
                int scrollY2 = getScrollY();
                int childCount3 = getChildCount();
                for (int i38 = 0; i38 < childCount3; i38++) {
                    View childAt3 = getChildAt(i38);
                    if (!((LayoutParams) childAt3.getLayoutParams()).isDecor) {
                        this.mPageTransformer.transformPage(childAt3, (childAt3.getTop() - scrollY2) / getClientHeight());
                    }
                }
            }
        }
        this.mCalledSuper = true;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i3, Rect rect) {
        int i16;
        int i17;
        int i18;
        ItemInfo infoForChild;
        int childCount = getChildCount();
        if ((i3 & 2) != 0) {
            i17 = childCount;
            i16 = 0;
            i18 = 1;
        } else {
            i16 = childCount - 1;
            i17 = -1;
            i18 = -1;
        }
        while (i16 != i17) {
            View childAt = getChildAt(i16);
            if (childAt != null && childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.requestFocus(i3, rect)) {
                return true;
            }
            i16 += i18;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ViewPagerAdapter viewPagerAdapter = this.mAdapter;
        if (viewPagerAdapter != null) {
            viewPagerAdapter.restoreState(savedState.adapterState, savedState.loader);
            setCurrentItemInternal(savedState.position, false, true);
        } else {
            this.mRestoredCurItem = savedState.position;
            this.mRestoredAdapterState = savedState.adapterState;
            this.mRestoredClassLoader = savedState.loader;
        }
    }

    boolean onRightGlideBlank() {
        QBGalleryGlideBlankListener qBGalleryGlideBlankListener = this.mRightGlideBlankListener;
        if (qBGalleryGlideBlankListener == null || !qBGalleryGlideBlankListener.onGlideBlank(false)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        ViewPagerAdapter viewPagerAdapter = this.mAdapter;
        if (viewPagerAdapter != null) {
            savedState.adapterState = viewPagerAdapter.saveState();
        }
        return savedState;
    }

    void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i3;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            if (actionIndex == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            try {
                this.mLastMotionX = motionEvent.getX(i3);
                this.mLastMotionY = motionEvent.getY(i3);
                this.mActivePointerId = motionEvent.getPointerId(i3);
            } catch (Exception unused) {
            }
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (i3 != i17) {
            recomputeScrollPosition(i3, i17, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onStartDrag(boolean z16) {
        int i3 = 1;
        if (this.mIsVertical) {
            if (!z16) {
                i3 = -1;
            }
            return verticalCanScroll(i3);
        }
        if (!z16) {
            i3 = -1;
        }
        return horizontalCanScroll(i3);
    }

    public void onTabPressed(int i3) {
        PageSelectedListener pageSelectedListener = this.mSelectedListener;
        if (pageSelectedListener != null) {
            pageSelectedListener.onPageSelected(true, i3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0152, code lost:
    
        if (r0 != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x010e, code lost:
    
        if (r0 != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0154, code lost:
    
        r0.requestDisallowInterceptTouchEvent(true);
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0111  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int pointerId;
        Scroller scroller;
        int i3;
        int scrollX;
        int i16;
        float xVelocity;
        float x16;
        float f16;
        float f17;
        boolean z16;
        float f18;
        ViewParent parent;
        boolean z17;
        float f19;
        if (this.mFakeDragging) {
            return true;
        }
        boolean z18 = false;
        if (this.mForceUnableToDrag) {
            return false;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                try {
                    if (action != 2) {
                        if (action != 3) {
                            if (action != 5) {
                                if (action == 6) {
                                    onSecondaryPointerUp(motionEvent);
                                    this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                                    this.mLastMotionY = motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
                                }
                            } else {
                                int actionIndex = motionEvent.getActionIndex();
                                try {
                                    this.mLastMotionX = motionEvent.getX(actionIndex);
                                    this.mLastMotionY = motionEvent.getY(actionIndex);
                                } catch (Exception unused) {
                                }
                                pointerId = motionEvent.getPointerId(actionIndex);
                            }
                        } else if (this.mIsBeingDragged) {
                            this.ignoreCheck = false;
                            if (isGallery()) {
                                upAction(0, motionEvent);
                            } else {
                                scrollToItem(this.mCurItem, true, 0, false);
                            }
                            this.mActivePointerId = -1;
                        }
                    } else {
                        if (!this.mIsBeingDragged) {
                            int i17 = this.mActivePointerId;
                            if (i17 != -1) {
                                int findPointerIndex = motionEvent.findPointerIndex(i17);
                                if (findPointerIndex != -1) {
                                    try {
                                        f16 = motionEvent.getX(findPointerIndex);
                                    } catch (Exception unused2) {
                                        f16 = 0.0f;
                                    }
                                    try {
                                        f17 = motionEvent.getY(findPointerIndex);
                                    } catch (Exception unused3) {
                                        f17 = 0.0f;
                                        float abs = Math.abs(f16 - this.mLastMotionX);
                                        float abs2 = Math.abs(f17 - this.mLastMotionY);
                                        if (!this.mIsVertical) {
                                        }
                                        Log.d("PageScroller,onTouch", "INVALID_POINTER");
                                        if (z18) {
                                        }
                                        return true;
                                    }
                                    float abs3 = Math.abs(f16 - this.mLastMotionX);
                                    float abs22 = Math.abs(f17 - this.mLastMotionY);
                                    if (!this.mIsVertical) {
                                        if (abs22 > this.mTouchSlop && abs22 > abs3 && this.mScrollEnabled) {
                                            if (f17 - this.mLastMotionY < 0.0f) {
                                                z17 = true;
                                            } else {
                                                z17 = false;
                                            }
                                            if (onStartDrag(z17)) {
                                                this.mIsBeingDragged = true;
                                                float f26 = this.mInitialMotionY;
                                                if (f17 - f26 > 0.0f) {
                                                    f19 = f26 + this.mTouchSlop;
                                                } else {
                                                    f19 = f26 - this.mTouchSlop;
                                                }
                                                this.mLastMotionY = f19;
                                                this.mLastMotionX = f16;
                                                setScrollState(1);
                                                if (this.mDisallowInterceptWhenDrag) {
                                                    parent = getParent();
                                                }
                                                setScrollingCacheEnabled(true);
                                            }
                                        }
                                    } else if (abs3 > this.mTouchSlop && abs3 > abs22 && this.mScrollEnabled) {
                                        if (f16 - this.mLastMotionX < 0.0f) {
                                            z16 = true;
                                        } else {
                                            z16 = false;
                                        }
                                        if (onStartDrag(z16)) {
                                            this.mIsBeingDragged = true;
                                            float f27 = this.mInitialMotionX;
                                            if (f16 - f27 > 0.0f) {
                                                f18 = f27 + this.mTouchSlop;
                                            } else {
                                                f18 = f27 - this.mTouchSlop;
                                            }
                                            this.mLastMotionX = f18;
                                            this.mLastMotionY = f17;
                                            setScrollState(1);
                                            if (this.mDisallowInterceptWhenDrag) {
                                                parent = getParent();
                                            }
                                            setScrollingCacheEnabled(true);
                                        }
                                    }
                                }
                            }
                            Log.d("PageScroller,onTouch", "INVALID_POINTER");
                        }
                        if (this.mIsBeingDragged) {
                            int i18 = this.mActivePointerId;
                            if (i18 != -1) {
                                int findPointerIndex2 = motionEvent.findPointerIndex(i18);
                                if (findPointerIndex2 != -1) {
                                    if (this.mIsVertical) {
                                        x16 = motionEvent.getY(findPointerIndex2);
                                    } else {
                                        x16 = motionEvent.getX(findPointerIndex2);
                                    }
                                    boolean performDrag = performDrag(x16) | false;
                                    try {
                                        if (this.mIsUnableToDrag) {
                                            ViewParent parent2 = getParent();
                                            if (parent2 != null) {
                                                parent2.requestDisallowInterceptTouchEvent(true);
                                            }
                                            return false;
                                        }
                                    } catch (Exception unused4) {
                                    }
                                    z18 = performDrag;
                                }
                            }
                            Log.d("PageScroller,onTouch", "INVALID_POINTER");
                        }
                    }
                } catch (Exception unused5) {
                }
                if (z18) {
                    ViewCompatTool.postInvalidateOnAnimation(this);
                }
                return true;
            }
            if (this.mIsBeingDragged) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    if (this.mIsVertical) {
                        xVelocity = velocityTracker.getYVelocity(this.mActivePointerId);
                    } else {
                        xVelocity = velocityTracker.getXVelocity(this.mActivePointerId);
                    }
                    i3 = (int) xVelocity;
                } else {
                    i3 = 0;
                }
                if (isGallery()) {
                    upAction(i3, motionEvent);
                } else {
                    this.mPopulatePending = true;
                    int clientSize = getClientSize();
                    if (this.mIsVertical) {
                        scrollX = getScrollY();
                    } else {
                        scrollX = getScrollX();
                    }
                    ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                    if (infoForCurrentScrollPosition != null) {
                        try {
                            int i19 = infoForCurrentScrollPosition.position;
                            float f28 = ((scrollX / clientSize) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.sizeFactor;
                            int findPointerIndex3 = motionEvent.findPointerIndex(this.mActivePointerId);
                            float x17 = motionEvent.getX(findPointerIndex3);
                            float y16 = motionEvent.getY(findPointerIndex3);
                            if (this.mIsVertical) {
                                i16 = (int) (y16 - this.mInitialMotionY);
                            } else {
                                i16 = (int) (x17 - this.mInitialMotionX);
                            }
                            int determineTargetPage = determineTargetPage(i19, f28, i3, i16);
                            this.mTouching = true;
                            setCurrentItemInternal(determineTargetPage, true, true, 0, i3);
                            this.mTouching = false;
                        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused6) {
                        }
                    }
                }
                Log.d("ViewPager", "ACTION_UP");
                this.mActivePointerId = -1;
                this.ignoreCheck = false;
            }
            if (z18) {
            }
            return true;
            endDrag();
            if (z18) {
            }
            return true;
        }
        if (this.mEnableCatching && (scroller = this.mScroller) != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            populate();
            this.mIsBeingDragged = true;
            setScrollState(1);
        }
        this.ignoreCheck = false;
        try {
            float x18 = motionEvent.getX();
            this.mInitialMotionX = x18;
            this.mLastMotionX = x18;
            float y17 = motionEvent.getY();
            this.mInitialMotionY = y17;
            this.mLastMotionY = y17;
        } catch (Exception unused7) {
        }
        pointerId = motionEvent.getPointerId(0);
        this.mActivePointerId = pointerId;
        if (z18) {
        }
        return true;
    }

    boolean pageLeft() {
        int i3 = this.mCurItem;
        if (i3 > 0) {
            setCurrentItem(i3 - 1, true);
            return true;
        }
        return false;
    }

    boolean pageRight() {
        ViewPagerAdapter viewPagerAdapter = this.mAdapter;
        if (viewPagerAdapter != null && this.mCurItem < viewPagerAdapter.getCount() - 1) {
            setCurrentItem(this.mCurItem + 1, true);
            return true;
        }
        return false;
    }

    protected boolean pageScrolled(int i3) {
        int clientSize = getClientSize();
        int i16 = this.mPageMargin + clientSize;
        ArrayList<ItemInfo> arrayList = this.mItems;
        if (arrayList != null && arrayList.size() == 0) {
            this.mCalledSuper = false;
            float f16 = i3 / clientSize;
            int i17 = this.mCurrentScreen;
            float f17 = f16 - i17;
            onPageScrolled(i17, f17, (int) (i16 * f17));
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        float f18 = clientSize;
        int i18 = infoForCurrentScrollPosition.position;
        float f19 = ((i3 / f18) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.sizeFactor + (this.mPageMargin / f18));
        this.mCalledSuper = false;
        onPageScrolled(i18, f19, 0);
        if (this.mCalledSuper) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01c6, code lost:
    
        if (r15 > r0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b3, code lost:
    
        if (r5 < r15) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b5, code lost:
    
        r5 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e0, code lost:
    
        if (r5 > r15) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x019d, code lost:
    
        if (r15 < r0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x019f, code lost:
    
        r15 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean performDrag(float f16) {
        boolean z16;
        boolean z17;
        float f17;
        boolean z18;
        float leftEdge;
        float rightEdge;
        float f18;
        boolean z19 = true;
        if (!this.mIsVertical) {
            float f19 = this.mLastMotionX - f16;
            this.mLastMotionX = f16;
            float scrollX = getScrollX();
            float f26 = scrollX + f19;
            int clientWidth = getClientWidth();
            if (this.mAdapter == null) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                getLeftEdge();
            }
            if (z18) {
                getRightEdge();
            }
            if (!z18) {
                float f27 = Float.MIN_VALUE;
                float f28 = Float.MAX_VALUE;
                for (int i3 = 0; i3 < this.mItems.size(); i3++) {
                    float f29 = this.mItems.get(i3).offset;
                    if (f29 < f28) {
                        f28 = f29;
                    }
                    if (f29 > f27) {
                        f27 = f29;
                    }
                }
                float f36 = clientWidth;
                float f37 = this.mMinOffset;
                if (f37 != Float.MIN_VALUE) {
                    f28 = f37;
                }
                leftEdge = f28 * f36;
                float f38 = this.mMaxOffset;
                if (f38 != Float.MAX_VALUE) {
                    f27 = f38;
                }
                rightEdge = f36 * f27;
                Log.d("ViewPager", this + "performDrag,scrollX=" + scrollX + ",leftBounds=" + leftEdge + ",rightBounds=" + rightEdge);
            } else {
                leftEdge = getLeftEdge();
                rightEdge = getRightEdge();
            }
            if (f26 < leftEdge) {
                if (!onLeftGlideBlank() && this.mLeftDragOutSizeEnable) {
                    f26 = (f26 - f19) + (f19 / 4.0f);
                    f18 = leftEdge - (clientWidth / 3);
                } else {
                    ViewParent parent = getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(false);
                    }
                    if (!this.mLeftDragOutSizeEnable) {
                        this.mIsUnableToDrag = true;
                    }
                    z19 = false;
                    f26 = leftEdge;
                }
                int i16 = (int) f26;
                this.mLastMotionX += f26 - i16;
                scrollTo(i16, getScrollY());
                pageScrolled(i16);
                return z19;
            }
            if (f26 > rightEdge) {
                if (!onRightGlideBlank() && this.mRightDragOutSizeEnable) {
                    f26 = (f26 - f19) + (f19 / 4.0f);
                    f18 = (clientWidth / 3) + rightEdge;
                } else {
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(false);
                    }
                    if (!this.mRightDragOutSizeEnable) {
                        this.mIsUnableToDrag = true;
                    }
                    z19 = false;
                    f26 = rightEdge;
                }
                int i162 = (int) f26;
                this.mLastMotionX += f26 - i162;
                scrollTo(i162, getScrollY());
                pageScrolled(i162);
                return z19;
            }
            z19 = false;
            int i1622 = (int) f26;
            this.mLastMotionX += f26 - i1622;
            scrollTo(i1622, getScrollY());
            pageScrolled(i1622);
            return z19;
        }
        float f39 = this.mLastMotionY - f16;
        Log.d("ViewPager", "performDrag,x=" + f16 + ",delta=" + f39 + ",mLasty=" + this.mLastMotionY);
        this.mLastMotionY = f16;
        float scrollY = ((float) getScrollY()) + f39;
        float clientSize = (float) getClientSize();
        float f46 = this.mFirstOffset * clientSize;
        float f47 = this.mLastOffset * clientSize;
        if (this.mItems.size() > 0) {
            ItemInfo itemInfo = this.mItems.get(0);
            ArrayList<ItemInfo> arrayList = this.mItems;
            ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
            if (itemInfo.position != 0) {
                f46 = itemInfo.offset * clientSize;
                z17 = false;
            } else {
                z17 = true;
            }
            if (itemInfo2.position != this.mAdapter.getCount() - 1) {
                f47 = itemInfo2.offset * clientSize;
                z16 = false;
            } else {
                z16 = true;
            }
        } else {
            z16 = true;
            z17 = true;
        }
        if (scrollY < f46 && z17) {
            if (!onLeftGlideBlank() && this.mLeftDragOutSizeEnable) {
                scrollY = (scrollY - f39) + (f39 / 4.0f);
                f17 = f46 - (r1 / 3);
            } else {
                ViewParent parent3 = getParent();
                if (parent3 != null) {
                    parent3.requestDisallowInterceptTouchEvent(false);
                }
                z19 = false;
                scrollY = f46;
            }
            int i17 = (int) scrollY;
            this.mLastMotionY += scrollY - i17;
            scrollTo(getScrollX(), i17);
            pageScrolled(i17);
            return z19;
        }
        if (scrollY > f47 && z16) {
            if (!onRightGlideBlank() && this.mRightDragOutSizeEnable) {
                scrollY = (scrollY - f39) + (f39 / 4.0f);
                f17 = (r1 / 3) + f47;
            } else {
                ViewParent parent4 = getParent();
                if (parent4 != null) {
                    parent4.requestDisallowInterceptTouchEvent(false);
                }
                z19 = false;
                scrollY = f47;
            }
            int i172 = (int) scrollY;
            this.mLastMotionY += scrollY - i172;
            scrollTo(getScrollX(), i172);
            pageScrolled(i172);
            return z19;
        }
        z19 = false;
        int i1722 = (int) scrollY;
        this.mLastMotionY += scrollY - i1722;
        scrollTo(getScrollX(), i1722);
        pageScrolled(i1722);
        return z19;
    }

    void populate() {
        populate(this.mCurItem);
    }

    public int positionForChild(View view) {
        ItemInfo infoForChild = infoForChild(view);
        if (infoForChild != null) {
            return infoForChild.position;
        }
        return 0;
    }

    @Override // android.view.View
    public void postInvalidate() {
        try {
            super.postInvalidate();
            PagerInvalidateListener pagerInvalidateListener = this.mInvalidateListener;
            if (pagerInvalidateListener != null) {
                pagerInvalidateListener.onPostInvalidate();
            }
        } catch (Exception unused) {
        }
    }

    void recomputeScrollPosition(int i3, int i16, int i17, int i18) {
        float f16;
        if (isGallery()) {
            return;
        }
        if (i16 > 0 && !this.mItems.isEmpty()) {
            int scrollX = (int) ((getScrollX() / (((i16 - getPaddingLeft()) - getPaddingRight()) + i18)) * (((i3 - getPaddingLeft()) - getPaddingRight()) + i17));
            scrollTo(scrollX, getScrollY());
            if (!this.mScroller.isFinished()) {
                int duration = this.mScroller.getDuration() - this.mScroller.timePassed();
                ItemInfo infoForPosition = infoForPosition(this.mCurItem);
                if (infoForPosition != null) {
                    this.mScroller.startScroll(scrollX, 0, (int) (infoForPosition.offset * i3), 0, duration);
                    return;
                }
                return;
            }
            return;
        }
        ItemInfo infoForPosition2 = infoForPosition(this.mCurItem);
        if (infoForPosition2 != null) {
            f16 = Math.min(infoForPosition2.offset, this.mLastOffset);
        } else {
            f16 = 0.0f;
        }
        int paddingLeft = (int) (f16 * ((i3 - getPaddingLeft()) - getPaddingRight()));
        if (paddingLeft != getScrollX()) {
            completeScroll(false);
            scrollTo(paddingLeft, getScrollY());
        }
    }

    void removeNonDecorViews() {
        int i3 = 0;
        while (i3 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i3).getLayoutParams()).isDecor) {
                removeViewAt(i3);
                i3--;
            }
            i3++;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isGallery()) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                if (view == getChildAt(i3)) {
                    if (i3 != this.mCurrentScreen) {
                        snapToScreen(i3, 0, true);
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
    }

    void scrollToItem(int i3, boolean z16, int i16, int i17, boolean z17, boolean z18) {
        OnPageChangeListener onPageChangeListener;
        OnPageChangeListener onPageChangeListener2;
        OnPageChangeListener onPageChangeListener3;
        OnPageChangeListener onPageChangeListener4;
        ItemInfo infoForPosition = infoForPosition(i3);
        int clientSize = infoForPosition != null ? (int) (getClientSize() * Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset))) : 0;
        if (z16) {
            if (this.mIsVertical) {
                smoothScrollTo(0, clientSize, i16, i17);
            } else {
                smoothScrollTo(clientSize, 0, i16, i17);
            }
            if (z17 && (onPageChangeListener4 = this.mOnPageChangeListener) != null) {
                onPageChangeListener4.onPageSelected(i3);
            }
            if (z17 && (onPageChangeListener3 = this.mInternalPageChangeListener) != null) {
                onPageChangeListener3.onPageSelected(i3);
            }
        } else {
            if (z17 && (onPageChangeListener2 = this.mOnPageChangeListener) != null) {
                onPageChangeListener2.onPageSelected(i3);
            }
            if (z17 && (onPageChangeListener = this.mInternalPageChangeListener) != null) {
                onPageChangeListener.onPageSelected(i3);
            }
            this.mScrollToNeedNotify = true;
            completeScroll(false);
            if (this.mIsVertical) {
                scrollTo(0, clientSize);
            } else {
                scrollTo(clientSize, 0);
            }
            pageScrolled(clientSize);
        }
        PageSelectedListener pageSelectedListener = this.mSelectedListener;
        if (pageSelectedListener == null || !z18) {
            return;
        }
        pageSelectedListener.onPageSelected(false, this.mCurItem);
    }

    public void setAdapter(ViewPagerAdapter viewPagerAdapter) {
        ViewPagerAdapter viewPagerAdapter2 = this.mAdapter;
        if (viewPagerAdapter2 != null) {
            viewPagerAdapter2.unregisterDataSetObserver(this.mObserver);
            this.mAdapter.startUpdate((ViewGroup) this, this.mCurItem);
            for (int i3 = 0; i3 < this.mItems.size(); i3++) {
                ItemInfo itemInfo = this.mItems.get(i3);
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        ViewPagerAdapter viewPagerAdapter3 = this.mAdapter;
        this.mAdapter = viewPagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (viewPagerAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver();
            }
            this.mAdapter.registerDataSetObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z16 = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (!z16) {
                populate();
            } else {
                requestLayout();
            }
        }
        OnAdapterChangeListener onAdapterChangeListener = this.mAdapterChangeListener;
        if (onAdapterChangeListener != null && viewPagerAdapter3 != viewPagerAdapter) {
            onAdapterChangeListener.onAdapterChanged(viewPagerAdapter3, viewPagerAdapter);
        }
    }

    public void setAutoScrollCustomDuration(int i3) {
        this.mAutoScrollCustomDuration = i3;
    }

    public void setCacheEnabled(boolean z16) {
        this.mCacheEnabled = z16;
    }

    public void setCallPageChangedOnFirstLayout(boolean z16) {
        this.mCallPageChangedOnFirstLayout = z16;
    }

    public void setCanScroll(boolean z16) {
        this.mCanScroll = z16;
    }

    public void setCurrentItem(int i3) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i3, !this.mFirstLayout, false);
    }

    protected void setCurrentItemInternal(int i3, boolean z16, boolean z17) {
        setCurrentItemInternal(i3, z16, z17, 0, 0);
    }

    public void setCurrentPage(int i3) {
        if (this.mCurrentScreen != i3) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            int max = Math.max(0, Math.min(i3, getPageCount() - 1));
            setScrollState(0);
            OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(max);
            }
            this.mCurrentScreen = max;
            Log.d("TMYGALLERY", "setCurrentPage,currScreen=" + this.mCurrentScreen);
            scrollTo(max * getWidth(), getScrollY());
            invalidate();
        }
    }

    public void setDisallowInterceptWhenDrag(boolean z16) {
        this.mDisallowInterceptWhenDrag = z16;
    }

    public void setDragChecker(IDragChecker iDragChecker) {
        this.mChecker = iDragChecker;
    }

    public void setEnableCatching(boolean z16) {
        this.mEnableCatching = z16;
    }

    public void setEnableReLayoutOnAttachToWindow(boolean z16) {
        this.mReLayoutOnAttachToWindow = z16;
    }

    public void setFirstLayoutParameter(boolean z16) {
        this.mFirstLayout = z16;
    }

    public void setFirstOffsetBy(View view) {
        ItemInfo infoForChild = infoForChild(view);
        if (infoForChild != null) {
            this.mMinOffset = infoForChild.offset;
            this.mMinPage = infoForChild.position;
        }
    }

    public void setFocusSearchEnabled(boolean z16) {
        this.mFocusSearchEnabled = z16;
    }

    protected void setForceUnableToDrag(boolean z16) {
        this.mForceUnableToDrag = z16;
    }

    public OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    public void setLastOffsetBy(View view) {
        ItemInfo infoForChild = infoForChild(view);
        if (infoForChild != null) {
            this.mMaxOffset = infoForChild.offset;
            this.mMaxPage = infoForChild.position;
        }
    }

    public void setLeftDragOutSizeEnabled(boolean z16) {
        this.mLeftDragOutSizeEnable = z16;
    }

    public void setLeftGlideBlankListener(QBGalleryGlideBlankListener qBGalleryGlideBlankListener) {
        this.mLeftGlideBlankListener = qBGalleryGlideBlankListener;
    }

    public void setOffscreenPageLimit(int i3) {
        if (i3 < 1) {
            i3 = 1;
        }
        if (i3 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i3;
            populate();
        }
    }

    public void setOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        this.mAdapterChangeListener = onAdapterChangeListener;
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setOnPageReadyListener(OnPageReadyListener onPageReadyListener) {
        this.mOnPageReadyListener = onPageReadyListener;
    }

    public void setPageMargin(int i3) {
        int i16 = this.mPageMargin;
        this.mPageMargin = i3;
        int width = getWidth();
        recomputeScrollPosition(width, width, i3, i16);
        requestLayout();
    }

    public void setPageMarginDrawable(int i3) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i3));
    }

    public void setPageSelectedListener(PageSelectedListener pageSelectedListener) {
        this.mSelectedListener = pageSelectedListener;
    }

    public void setPageTransformer(PageTransformer pageTransformer) {
        this.mPageTransformer = pageTransformer;
    }

    public void setPagerInvalidateListener(PagerInvalidateListener pagerInvalidateListener) {
        this.mInvalidateListener = pagerInvalidateListener;
    }

    public void setRightDragOutSizeEnabled(boolean z16) {
        this.mRightDragOutSizeEnable = z16;
    }

    public void setRightGlideBlankListener(QBGalleryGlideBlankListener qBGalleryGlideBlankListener) {
        this.mRightGlideBlankListener = qBGalleryGlideBlankListener;
    }

    public void setScrollEnabled(boolean z16) {
        this.mScrollEnabled = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setScrollState(int i3) {
        if (this.mScrollState == i3) {
            return;
        }
        if (i3 == 1 && this.mNextScreen != -1 && isGallery()) {
            this.mNextScreen = -1;
        }
        notifyScrollStateChanged(this.mScrollState, i3);
        if (i3 == 0) {
            this.mMinOffset = Float.MIN_VALUE;
            this.mMaxOffset = Float.MAX_VALUE;
            this.mMinPage = Integer.MIN_VALUE;
            this.mMaxPage = Integer.MAX_VALUE;
        }
        this.mScrollState = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setScrollingCacheEnabled(boolean z16) {
        if (this.mScrollingCacheEnabled != z16) {
            this.mScrollingCacheEnabled = z16;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && childAt.getVisibility() != 8) {
                    childAt.setDrawingCacheEnabled(z16);
                }
            }
        }
    }

    void smoothScrollTo(int i3, int i16, int i17, int i18) {
        int i19;
        int abs;
        if (getChildCount() != 0 && this.mAdapter != null) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int i26 = i3 - scrollX;
            int i27 = i16 - scrollY;
            if (i26 == 0 && i27 == 0) {
                completeScroll(false);
                populate();
                setScrollState(0);
                return;
            }
            setScrollingCacheEnabled(true);
            setScrollState(2);
            int clientSize = getClientSize();
            int i28 = clientSize / 2;
            float f16 = clientSize;
            float f17 = i28;
            float distanceInfluenceForSnapDuration = f17 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i26) * 1.0f) / f16)) * f17);
            if (i17 <= 0 && (this.mTouching || (i17 = this.mAutoScrollCustomDuration) < 0)) {
                int abs2 = Math.abs(i18);
                if (abs2 > 0) {
                    abs = Math.round(Math.abs(distanceInfluenceForSnapDuration / abs2) * 1000.0f) * 4;
                } else {
                    float pageSize = f16 * this.mAdapter.getPageSize(this.mCurItem);
                    if (this.mIsVertical) {
                        i19 = i27;
                    } else {
                        i19 = i26;
                    }
                    abs = (int) (((Math.abs(i19) / (pageSize + this.mPageMargin)) + 1.0f) * 100.0f);
                }
                i17 = Math.min(abs, 600);
            }
            this.mScroller.startScroll(scrollX, scrollY, i26, i27, i17);
            ViewCompatTool.postInvalidateOnAnimation(this);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    public void snapToScreen(int i3, int i16, boolean z16) {
        snapToScreen(i3, i16, z16, true);
    }

    void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                this.mDrawingOrderedChildren.add(getChildAt(i3));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    protected void stopScroller() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
    }

    void upAction(int i3, MotionEvent motionEvent) {
        int i16;
        boolean z16;
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (clientWidth == 0) {
            return;
        }
        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
        float f16 = this.mInitialMotionX;
        try {
            f16 = motionEvent.getX(findPointerIndex);
        } catch (Exception unused) {
        }
        if (Math.abs((int) (f16 - this.mInitialMotionX)) > this.mFlingDistance && Math.abs(i3) > this.mMinimumVelocity) {
            if (i3 < 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            i16 = findNextPosition(z16);
        } else {
            i16 = scrollX / clientWidth;
            if (scrollX - (i16 * clientWidth) > clientWidth * 0.5d) {
                i16++;
            }
        }
        snapToScreen(Math.min(Math.max(i16, getLeftBoundPageIndex()), getRightBoundPageIndex()), i3, true);
    }

    public void updateScreenNextCall() {
        this.mUpdateScreenNextCall = true;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.mMarginDrawable) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mtt.supportui.views.ScrollChecker.IScrollCheck
    public boolean verticalCanScroll(int i3) {
        if (!this.mCanScroll || !this.mIsVertical) {
            return false;
        }
        if (i3 < 0) {
            if (this.mCurItem <= 0) {
                return false;
            }
            return true;
        }
        if (i3 <= 0 || this.mCurItem >= getPageCount() - 1) {
            return false;
        }
        return true;
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context);
        this.mDisallowInterceptWhenDrag = true;
        this.mMinOffset = Float.MIN_VALUE;
        this.mMaxOffset = Float.MAX_VALUE;
        this.mMinPage = Integer.MIN_VALUE;
        this.mMaxPage = Integer.MAX_VALUE;
        this.mAutoScrollCustomDuration = -1;
        this.mNeedRepopulate = false;
        this.mItems = new ArrayList<>();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mScrollEnabled = true;
        this.mForceUnableToDrag = false;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mCallPageChangedOnFirstLayout = false;
        this.mEndScrollRunnable = new Runnable() { // from class: com.tencent.mtt.supportui.views.viewpager.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        this.mLeftDragOutSizeEnable = true;
        this.mRightDragOutSizeEnable = true;
        this.mNextScreen = -1;
        this.mCustomInterplater = null;
        this.mIsVertical = false;
        this.mCacheEnabled = false;
        this.mFirstDatasetChanged = true;
        this.ignoreCheck = false;
        this.mFocusSearchEnabled = true;
        this.checkTouchSlop = true;
        this.mCanScroll = true;
        this.mReLayoutOnAttachToWindow = true;
        this.mOri = Integer.MAX_VALUE;
        this.mEnableCatching = true;
        initViewPager();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    void populate(int i3) {
        populate(i3, false);
    }

    void scrollToItem(int i3, boolean z16, int i16, boolean z17) {
        scrollToItem(i3, z16, 0, i16, z17, this.mTouching);
    }

    public void setCurrentItem(int i3, boolean z16) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i3, z16, false);
    }

    void setCurrentItemInternal(int i3, boolean z16, boolean z17, int i16, int i17) {
        int i18;
        OnPageChangeListener onPageChangeListener;
        OnPageChangeListener onPageChangeListener2;
        ViewPagerAdapter viewPagerAdapter = this.mAdapter;
        if (viewPagerAdapter == null || viewPagerAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z17 && this.mCurItem == i3 && this.mItems.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i3 < 0) {
            i18 = 0;
        } else {
            if (i3 >= this.mAdapter.getCount()) {
                i3 = this.mAdapter.getCount() - 1;
            }
            i18 = i3;
        }
        int i19 = this.mOffscreenPageLimit;
        int i26 = this.mCurItem;
        if (i18 > i26 + i19 || i18 < i26 - i19) {
            for (int i27 = 0; i27 < this.mItems.size(); i27++) {
                this.mItems.get(i27).scrolling = true;
            }
        }
        boolean z18 = this.mCurItem != i18;
        if (!this.mFirstLayout) {
            populate(i18, true);
            scrollToItem(i18, z16, i16, i17, z18, this.mTouching);
            return;
        }
        this.mCurItem = i18;
        if ((z18 || this.mCallPageChangedOnFirstLayout) && (onPageChangeListener = this.mOnPageChangeListener) != null) {
            onPageChangeListener.onPageSelected(i18);
        }
        if ((z18 || this.mCallPageChangedOnFirstLayout) && (onPageChangeListener2 = this.mInternalPageChangeListener) != null) {
            onPageChangeListener2.onPageSelected(i18);
        }
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z16, PageTransformer pageTransformer) {
        if (isGallery()) {
            this.mPageTransformer = pageTransformer;
            return;
        }
        boolean z17 = pageTransformer != null;
        boolean z18 = z17 != (this.mPageTransformer != null);
        this.mPageTransformer = pageTransformer;
        setChildrenDrawingOrderEnabled(z17);
        if (z17) {
            this.mDrawingOrder = z16 ? 2 : 1;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z18) {
            populate();
        }
    }

    public void snapToScreen(int i3, int i16, boolean z16, boolean z17) {
        if (!z17) {
            setCurrentPage(i3);
            return;
        }
        int max = Math.max(0, Math.min(i3, getRightBoundPageIndex()));
        this.mNextScreen = max;
        Math.max(1, Math.abs(max - this.mCurrentScreen));
        int width = (getWidth() * max) - getScrollX();
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        Math.abs(i16);
        setScrollState(2);
        if (width == 0) {
            setScrollState(0);
        }
        this.mScroller.startScroll(getScrollX(), 0, width, 0, 500);
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(max);
        }
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageSelected(max);
        }
        invalidate();
    }

    public ViewPager(Context context, Interpolator interpolator) {
        this(context, false);
        this.mCustomInterplater = interpolator;
        initViewPager();
    }

    /* JADX WARN: Code restructure failed: missing block: B:135:0x016d, code lost:
    
        if (r10 >= 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x017b, code lost:
    
        if (r10 >= 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ed, code lost:
    
        if (r10 == r11) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0155, code lost:
    
        if (r10 >= 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0157, code lost:
    
        r11 = r17.mItems.get(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0160, code lost:
    
        r11 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void populate(int i3, boolean z16) {
        int i16;
        ItemInfo itemInfo;
        ItemInfo itemInfo2;
        String hexString;
        int i17 = this.mCurItem;
        if (i17 != i3) {
            i16 = i17 < i3 ? 66 : 17;
            itemInfo = infoForPosition(i17);
            this.mCurItem = i3;
        } else {
            i16 = 2;
            itemInfo = null;
        }
        ViewPagerAdapter viewPagerAdapter = this.mAdapter;
        if (viewPagerAdapter == null) {
            sortChildDrawingOrder();
            return;
        }
        if (this.mPopulatePending) {
            sortChildDrawingOrder();
            return;
        }
        viewPagerAdapter.startUpdate((ViewGroup) this, this.mCurItem);
        if (this.mCacheEnabled && z16) {
            for (int i18 = 0; i18 < this.mItems.size(); i18++) {
                ItemInfo itemInfo3 = this.mItems.get(i18);
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo3.position, itemInfo3.object);
            }
            this.mItems.clear();
        }
        int i19 = this.mOffscreenPageLimit;
        int max = Math.max(0, this.mCurItem - i19);
        int count = this.mAdapter.getCount();
        int min = Math.min(count - 1, this.mCurItem + i19);
        if (getWindowToken() == null || count == this.mExpectedAdapterCount) {
            int i26 = 0;
            while (true) {
                if (i26 >= this.mItems.size()) {
                    break;
                }
                itemInfo2 = this.mItems.get(i26);
                int i27 = itemInfo2.position;
                int i28 = this.mCurItem;
                if (i27 < i28) {
                    i26++;
                }
            }
            itemInfo2 = null;
            if (itemInfo2 == null && count > 0) {
                itemInfo2 = addNewItem(this.mCurItem, i26);
            }
            if (itemInfo2 != null) {
                int i29 = i26 - 1;
                ItemInfo itemInfo4 = i29 >= 0 ? this.mItems.get(i29) : null;
                int clientSize = getClientSize();
                float paddingTop = clientSize <= 0 ? 0.0f : (2.0f - itemInfo2.sizeFactor) + ((this.mIsVertical ? getPaddingTop() : getPaddingLeft()) / clientSize);
                float f16 = 0.0f;
                for (int i36 = this.mCurItem - 1; i36 >= 0; i36--) {
                    if (f16 >= paddingTop && i36 < max) {
                        if (itemInfo4 == null) {
                            break;
                        }
                        if (i36 == itemInfo4.position && !itemInfo4.scrolling) {
                            this.mItems.remove(i29);
                            this.mAdapter.destroyItem((ViewGroup) this, i36, itemInfo4.object);
                            i29--;
                            i26--;
                        }
                    } else if (itemInfo4 == null || i36 != itemInfo4.position) {
                        f16 += addNewItem(i36, i29 + 1).sizeFactor;
                        i26++;
                    } else {
                        f16 += itemInfo4.sizeFactor;
                        i29--;
                    }
                }
                float f17 = itemInfo2.sizeFactor;
                int i37 = i26 + 1;
                if (f17 < 2.0f) {
                    ItemInfo itemInfo5 = i37 < this.mItems.size() ? this.mItems.get(i37) : null;
                    float paddingBottom = clientSize <= 0 ? 0.0f : ((this.mIsVertical ? getPaddingBottom() : getPaddingRight()) / clientSize) + 2.0f;
                    int i38 = this.mCurItem;
                    while (true) {
                        i38++;
                        if (i38 >= count) {
                            break;
                        }
                        if (f17 >= paddingBottom && i38 > min) {
                            if (itemInfo5 == null) {
                                break;
                            }
                            if (i38 == itemInfo5.position && !itemInfo5.scrolling) {
                                this.mItems.remove(i37);
                                this.mAdapter.destroyItem((ViewGroup) this, i38, itemInfo5.object);
                                if (i37 < this.mItems.size()) {
                                }
                            }
                        } else if (itemInfo5 == null || i38 != itemInfo5.position) {
                            if (itemInfo5 != null) {
                                this.mAdapter.destroyItem((ViewGroup) this, itemInfo5.position, itemInfo5.object);
                            }
                            ItemInfo addNewItem = addNewItem(i38, i37);
                            i37++;
                            f17 += addNewItem.sizeFactor;
                            itemInfo5 = i37 < this.mItems.size() ? this.mItems.get(i37) : null;
                        } else {
                            f17 += itemInfo5.sizeFactor;
                            i37++;
                            if (i37 < this.mItems.size()) {
                            }
                        }
                    }
                }
                calculatePageOffsets(itemInfo2, i26, itemInfo);
            }
            this.mAdapter.setPrimaryItem((ViewGroup) this, this.mCurItem, itemInfo2 != null ? itemInfo2.object : null);
            this.mAdapter.finishUpdate((ViewGroup) this);
            int childCount = getChildCount();
            for (int i39 = 0; i39 < childCount; i39++) {
                View childAt = getChildAt(i39);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.childIndex = i39;
                ItemInfo infoForChild = infoForChild(childAt);
                if (infoForChild != null) {
                    layoutParams.sizeFactor = infoForChild.sizeFactor;
                    layoutParams.position = infoForChild.position;
                }
            }
            sortChildDrawingOrder();
            if (hasFocus()) {
                View findFocus = findFocus();
                ItemInfo infoForAnyChild = findFocus != null ? infoForAnyChild(findFocus) : null;
                if (infoForAnyChild == null || infoForAnyChild.position != this.mCurItem) {
                    for (int i46 = 0; i46 < getChildCount(); i46++) {
                        View childAt2 = getChildAt(i46);
                        ItemInfo infoForChild2 = infoForChild(childAt2);
                        if (infoForChild2 != null && infoForChild2.position == this.mCurItem && childAt2.requestFocus(i16)) {
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        try {
            hexString = getResources().getResourceName(getId());
        } catch (Resources.NotFoundException unused) {
            hexString = Integer.toHexString(getId());
        }
        throw new IllegalStateException("The application's QBPagerAdapter changed the adapter's contents without calling QBPagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + count + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
    }

    public void setCurrentItem(int i3, boolean z16, int i16) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i3, z16, false, i16, 0);
    }

    public ViewPager(Context context, boolean z16) {
        super(context);
        this.mDisallowInterceptWhenDrag = true;
        this.mMinOffset = Float.MIN_VALUE;
        this.mMaxOffset = Float.MAX_VALUE;
        this.mMinPage = Integer.MIN_VALUE;
        this.mMaxPage = Integer.MAX_VALUE;
        this.mAutoScrollCustomDuration = -1;
        this.mNeedRepopulate = false;
        this.mItems = new ArrayList<>();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mScrollEnabled = true;
        this.mForceUnableToDrag = false;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mCallPageChangedOnFirstLayout = false;
        this.mEndScrollRunnable = new Runnable() { // from class: com.tencent.mtt.supportui.views.viewpager.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        this.mLeftDragOutSizeEnable = true;
        this.mRightDragOutSizeEnable = true;
        this.mNextScreen = -1;
        this.mCustomInterplater = null;
        this.mCacheEnabled = false;
        this.mFirstDatasetChanged = true;
        this.ignoreCheck = false;
        this.mFocusSearchEnabled = true;
        this.checkTouchSlop = true;
        this.mCanScroll = true;
        this.mReLayoutOnAttachToWindow = true;
        this.mOri = Integer.MAX_VALUE;
        this.mEnableCatching = true;
        this.mIsVertical = z16;
        initViewPager();
    }

    /* loaded from: classes21.dex */
    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        @Override // com.tencent.mtt.supportui.views.viewpager.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
        }

        @Override // com.tencent.mtt.supportui.views.viewpager.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3, int i16) {
        }

        @Override // com.tencent.mtt.supportui.views.viewpager.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }
}
