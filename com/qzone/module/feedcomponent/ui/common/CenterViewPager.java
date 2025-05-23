package com.qzone.module.feedcomponent.ui.common;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.widget.EdgeEffectCompat;
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
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Gallery;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes39.dex */
public abstract class CenterViewPager extends ViewGroup {
    static final int CLOSE_ENOUGH = 2;
    static final boolean DEBUG = false;
    static final int DEFAULT_GUTTER_SIZE = 16;
    static final int DEFAULT_OFFSCREEN_PAGES = 1;
    static final int DRAW_ORDER_DEFAULT = 0;
    static final int DRAW_ORDER_FORWARD = 1;
    static final int DRAW_ORDER_REVERSE = 2;
    static final int INVALID_POINTER = -1;
    static final int MAX_SETTLE_DURATION = 600;
    static final int MIN_DISTANCE_FOR_FLING = 25;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "ViewPager";
    static final boolean USE_CACHE = false;
    int mActivePointerId;
    protected PagerAdapter mAdapter;
    OnAdapterChangeListener mAdapterChangeListener;
    protected boolean mBoderAlignMode;
    int mBottomPageBounds;
    boolean mCalledSuper;
    protected boolean mCenterLockEnabled;
    int mChildHeightMeasureSpec;
    int mChildWidthMeasureSpec;
    boolean mClickAutoScrollMode;
    int mCloseEnough;
    int mCurItem;
    int mDecorChildCount;
    int mDefaultGutterSize;
    int mDrawingOrder;
    ArrayList<View> mDrawingOrderedChildren;
    protected boolean mEnableScroll;
    final Runnable mEndScrollRunnable;
    long mFakeDragBeginTime;
    boolean mFakeDragging;
    boolean mFirstLayout;
    float mFirstOffset;
    int mFlingDistance;
    int mGutterSize;
    boolean mIgnoreGutter;
    boolean mInLayout;
    float mInitialMotionX;
    OnPageChangeListener mInternalPageChangeListener;
    boolean mIsBeingDragged;
    boolean mIsUnableToDrag;
    final ArrayList<ItemInfo> mItems;
    float mLastMotionX;
    float mLastMotionY;
    float mLastOffset;
    EdgeEffectCompat mLeftEdge;
    Drawable mMarginDrawable;
    boolean mMatchChildHeightToViewPager;
    int mMaximumVelocity;
    int mMinimumVelocity;
    boolean mNeedCalculatePageOffsets;
    PagerObserver mObserver;
    int mOffscreenPageLimit;
    OnPageChangeListener mOnPageChangeListener;
    int mPageMargin;
    protected float mPageSpace;
    PageTransformer mPageTransformer;
    boolean mPopulatePending;
    Parcelable mRestoredAdapterState;
    ClassLoader mRestoredClassLoader;
    int mRestoredCurItem;
    EdgeEffectCompat mRightEdge;
    int mScrollState;
    Scroller mScroller;
    boolean mScrollingCacheEnabled;
    int mSeenPositionMax;
    int mSeenPositionMin;
    final ItemInfo mTempItem;
    final Rect mTempRect;
    int mTopPageBounds;
    int mTouchSlop;
    VelocityTracker mVelocityTracker;
    static final int[] LAYOUT_ATTRS = {R.attr.layout_gravity};
    static final Comparator<ItemInfo> COMPARATOR = new Comparator<ItemInfo>() { // from class: com.qzone.module.feedcomponent.ui.common.CenterViewPager.1
        @Override // java.util.Comparator
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.position - itemInfo2.position;
        }
    };
    static final Interpolator sInterpolator = new Interpolator() { // from class: com.qzone.module.feedcomponent.ui.common.CenterViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            float f17 = f16 - 1.0f;
            return (f17 * f17 * f17 * f17 * f17) + 1.0f;
        }
    };
    static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();

    /* loaded from: classes39.dex */
    interface Decor {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public static class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        ItemInfo() {
        }
    }

    /* loaded from: classes39.dex */
    interface OnAdapterChangeListener {
        void onAdapterChanged(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* loaded from: classes39.dex */
    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i3);

        void onPageScrolled(int i3, float f16, int i16);

        void onPageSelected(int i3);
    }

    /* loaded from: classes39.dex */
    public interface PageTransformer {
        void transformPage(View view, float f16);
    }

    /* loaded from: classes39.dex */
    private class PagerObserver extends DataSetObserver {
        PagerObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CenterViewPager.this.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            CenterViewPager.this.dataSetChanged();
        }
    }

    /* loaded from: classes39.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: com.qzone.module.feedcomponent.ui.common.CenterViewPager.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        });
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
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

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z16 = layoutParams.isDecor;
            if (z16 != layoutParams2.isDecor) {
                return z16 ? 1 : -1;
            }
            return layoutParams.position - layoutParams2.position;
        }
    }

    public CenterViewPager(Context context) {
        super(context);
        this.mPageSpace = 0.0f;
        this.mEnableScroll = true;
        this.mItems = new ArrayList<>();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mEndScrollRunnable = new Runnable() { // from class: com.qzone.module.feedcomponent.ui.common.CenterViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                CenterViewPager.this.setScrollState(0);
                CenterViewPager.this.populate();
            }
        };
        this.mMatchChildHeightToViewPager = true;
        this.mScrollState = 0;
        initViewPager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float subAllItemWidthFactor() {
        ArrayList<ItemInfo> arrayList = this.mItems;
        float f16 = 0.0f;
        if (arrayList != null) {
            Iterator<ItemInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                f16 += it.next().widthFactor;
            }
        }
        return f16;
    }

    ItemInfo addNewItem(int i3, int i16) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.position = i3;
        itemInfo.object = this.mAdapter.instantiateItem((ViewGroup) this, i3);
        itemInfo.widthFactor = this.mAdapter.getPageWidth(i3);
        if (i16 >= 0 && i16 < this.mItems.size()) {
            this.mItems.add(i16, itemInfo);
        } else {
            this.mItems.add(itemInfo);
        }
        return itemInfo;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.isDecor |= view instanceof Decor;
        }
        if (this.mInLayout) {
            if (layoutParams2 != null && layoutParams2.isDecor) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            if (layoutParams2 != null) {
                layoutParams2.needsMeasure = true;
            }
            addViewInLayout(view, i3, layoutParams);
            return;
        }
        super.addView(view, i3, layoutParams);
    }

    public boolean arrowScroll(int i3) {
        boolean pageLeft;
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i3);
        if (findNextFocus == null || findNextFocus == findFocus) {
            if (i3 == 17 || i3 == 1) {
                pageLeft = pageLeft();
            } else {
                if (i3 == 66 || i3 == 2) {
                    pageLeft = pageRight();
                }
                pageLeft = false;
            }
        } else if (i3 == 17) {
            int i16 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left;
            int i17 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).left;
            if (findFocus != null && i16 >= i17) {
                pageLeft = pageLeft();
            } else {
                pageLeft = findNextFocus.requestFocus();
            }
        } else {
            if (i3 == 66) {
                int i18 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left;
                int i19 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).left;
                if (findFocus != null && i18 <= i19) {
                    pageLeft = pageRight();
                } else {
                    pageLeft = findNextFocus.requestFocus();
                }
            }
            pageLeft = false;
        }
        if (pageLeft) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i3));
        }
        return pageLeft;
    }

    public void autoScrollMode(boolean z16) {
        this.mClickAutoScrollMode = z16;
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
        int i16;
        int i17;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        int count = this.mAdapter.getCount();
        int width = getWidth();
        float f16 = width > 0 ? this.mPageMargin / width : 0.0f;
        if (itemInfo2 != null) {
            int i18 = itemInfo2.position;
            int i19 = itemInfo.position;
            if (i18 < i19) {
                float f17 = itemInfo2.offset + itemInfo2.widthFactor + f16;
                int i26 = i18 + 1;
                int i27 = 0;
                while (i26 <= itemInfo.position && i27 < this.mItems.size()) {
                    ItemInfo itemInfo5 = this.mItems.get(i27);
                    while (true) {
                        itemInfo4 = itemInfo5;
                        if (i26 <= itemInfo4.position || i27 >= this.mItems.size() - 1) {
                            break;
                        }
                        i27++;
                        itemInfo5 = this.mItems.get(i27);
                    }
                    while (i26 < itemInfo4.position) {
                        f17 += this.mAdapter.getPageWidth(i26) + f16;
                        i26++;
                    }
                    itemInfo4.offset = f17;
                    f17 += itemInfo4.widthFactor + f16;
                    i26++;
                }
            } else if (i18 > i19) {
                int size = this.mItems.size() - 1;
                float f18 = itemInfo2.offset;
                while (true) {
                    i18--;
                    if (i18 < itemInfo.position || size < 0) {
                        break;
                    }
                    ItemInfo itemInfo6 = this.mItems.get(size);
                    while (true) {
                        itemInfo3 = itemInfo6;
                        if (i18 >= itemInfo3.position || size <= 0) {
                            break;
                        }
                        size--;
                        itemInfo6 = this.mItems.get(size);
                    }
                    while (i18 > itemInfo3.position) {
                        f18 -= this.mAdapter.getPageWidth(i18) + f16;
                        i18--;
                    }
                    f18 -= itemInfo3.widthFactor + f16;
                    itemInfo3.offset = f18;
                }
            }
        }
        int size2 = this.mItems.size();
        float f19 = itemInfo.offset;
        int i28 = itemInfo.position;
        int i29 = i28 - 1;
        this.mFirstOffset = i28 == 0 ? f19 : -3.4028235E38f;
        int i36 = count - 1;
        this.mLastOffset = i28 == i36 ? (itemInfo.widthFactor + f19) - 1.0f : Float.MAX_VALUE;
        int i37 = i3 - 1;
        while (i37 >= 0) {
            ItemInfo itemInfo7 = this.mItems.get(i37);
            while (true) {
                i17 = itemInfo7.position;
                if (i29 <= i17) {
                    break;
                }
                f19 -= this.mAdapter.getPageWidth(i29) + f16;
                i29--;
            }
            f19 -= itemInfo7.widthFactor + f16;
            itemInfo7.offset = f19;
            if (i17 == 0) {
                this.mFirstOffset = f19;
            }
            i37--;
            i29--;
        }
        float f26 = itemInfo.offset + itemInfo.widthFactor + f16;
        int i38 = itemInfo.position + 1;
        int i39 = i3 + 1;
        while (i39 < size2) {
            ItemInfo itemInfo8 = this.mItems.get(i39);
            while (true) {
                i16 = itemInfo8.position;
                if (i38 >= i16) {
                    break;
                }
                f26 += this.mAdapter.getPageWidth(i38) + f16;
                i38++;
            }
            if (i16 == i36) {
                this.mLastOffset = (itemInfo8.widthFactor + f26) - 1.0f;
            }
            itemInfo8.offset = f26;
            f26 += itemInfo8.widthFactor + f16;
            i39++;
            i38++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    void completeScroll(boolean z16) {
        boolean z17 = this.mScrollState == 2;
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
                ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
            } else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!pageScrolled(currX)) {
                    this.mScroller.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        completeScroll(true);
    }

    void dataSetChanged() {
        int i3 = this.mCurItem;
        int i16 = 0;
        boolean z16 = false;
        while (i16 < this.mItems.size()) {
            ItemInfo itemInfo = this.mItems.get(i16);
            int itemPosition = this.mAdapter.getItemPosition(itemInfo.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i16);
                    i16--;
                    if (!z16) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z16 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
                    int i17 = this.mCurItem;
                    if (i17 == itemInfo.position) {
                        i3 = Math.max(0, Math.min(i17, this.mAdapter.getCount() - 1));
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
            }
            i16++;
        }
        if (z16) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        int childCount = getChildCount();
        for (int i19 = 0; i19 < childCount; i19++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i19).getLayoutParams();
            if (!layoutParams.isDecor) {
                layoutParams.widthFactor = 0.0f;
            }
        }
        setCurrentItemInternal(i3, false, true);
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        if (r4 > 0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int determineTargetPage(int i3, float f16, int i16, int i17) {
        if (Math.abs(i17) <= this.mFlingDistance || Math.abs(i16) <= this.mMinimumVelocity) {
            int i18 = this.mSeenPositionMin;
            if (i18 < 0 || i18 >= i3 || f16 >= 0.5f) {
                int i19 = this.mSeenPositionMax;
                i3 = (i19 < 0 || i19 <= i3 + 1 || f16 < 0.5f) ? (int) (i3 + f16 + 0.5f) : i3 - 1;
            }
            i3++;
        }
        if (this.mItems.size() <= 0) {
            return i3;
        }
        return Math.max(this.mItems.get(0).position, Math.min(i3, this.mItems.get(r4.size() - 1).position));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo infoForChild;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        boolean z16 = false;
        if (overScrollMode != 0 && (overScrollMode != 1 || (pagerAdapter = this.mAdapter) == null || pagerAdapter.getCount() <= 1)) {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        } else {
            if (!this.mLeftEdge.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.mFirstOffset * width);
                this.mLeftEdge.setSize(height, width);
                z16 = false | this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.mRightEdge.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.mLastOffset + 1.0f)) * width2);
                this.mRightEdge.setSize(height2, width2);
                z16 |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        if (z16) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
            this.mPopulatePending = true;
            int width = getWidth();
            int scrollX = getScrollX();
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((scrollX / width) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
            endDrag();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return arrowScroll(17);
            }
            if (keyCode == 22) {
                return arrowScroll(66);
            }
            if (keyCode == 61) {
                if (KeyEventCompat.hasNoModifiers(keyEvent)) {
                    return arrowScroll(2);
                }
                if (KeyEventCompat.hasModifiers(keyEvent, 1)) {
                    return arrowScroll(1);
                }
            }
        }
        return false;
    }

    public void fakeDragBy(float f16) {
        if (this.mFakeDragging) {
            this.mLastMotionX += f16;
            float scrollX = getScrollX() - f16;
            float width = getWidth();
            float f17 = this.mFirstOffset * width;
            float f18 = this.mLastOffset * width;
            ItemInfo itemInfo = this.mItems.get(0);
            ItemInfo itemInfo2 = this.mItems.get(r4.size() - 1);
            if (itemInfo.position != 0) {
                f17 = itemInfo.offset * width;
            }
            if (itemInfo2.position != this.mAdapter.getCount() - 1) {
                f18 = itemInfo2.offset * width;
            }
            if (scrollX < f17) {
                scrollX = f17;
            } else if (scrollX > f18) {
                scrollX = f18;
            }
            int i3 = (int) scrollX;
            this.mLastMotionX += scrollX - i3;
            scrollTo(i3, getScrollY());
            pageScrolled(i3);
            MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    ItemInfo findItemInfoByPos(int i3) {
        if (this.mItems == null) {
            return null;
        }
        for (int i16 = 0; i16 < this.mItems.size(); i16++) {
            ItemInfo itemInfo = this.mItems.get(i16);
            int i17 = itemInfo.position;
            if (i17 >= i3) {
                if (i17 == i3) {
                    return itemInfo;
                }
                return null;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i16) {
        if (this.mDrawingOrder == 2) {
            i16 = (i3 - 1) - i16;
        }
        return ((LayoutParams) this.mDrawingOrderedChildren.get(i16).getLayoutParams()).childIndex;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    float getPageSpace() {
        return getWidth() * this.mPageSpace;
    }

    ItemInfo infoForAnyChild(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return infoForChild(view);
            }
        }
    }

    ItemInfo infoForCurrentScrollPosition() {
        int i3;
        int width = getWidth();
        float f16 = 0.0f;
        float scrollX = width > 0 ? getScrollX() / width : 0.0f;
        float f17 = width > 0 ? this.mPageMargin / width : 0.0f;
        int i16 = 0;
        boolean z16 = true;
        ItemInfo itemInfo = null;
        int i17 = -1;
        float f18 = 0.0f;
        while (i16 < this.mItems.size()) {
            ItemInfo itemInfo2 = this.mItems.get(i16);
            if (!z16 && itemInfo2.position != (i3 = i17 + 1)) {
                itemInfo2 = this.mTempItem;
                itemInfo2.offset = f16 + f18 + f17;
                itemInfo2.position = i3;
                itemInfo2.widthFactor = this.mAdapter.getPageWidth(i3);
                i16--;
            }
            ItemInfo itemInfo3 = itemInfo2;
            f16 = itemInfo3.offset;
            float f19 = itemInfo3.widthFactor + f16 + f17;
            if (!z16 && scrollX < f16) {
                return itemInfo;
            }
            if (scrollX < f19 || i16 == this.mItems.size() - 1) {
                return itemInfo3;
            }
            int i18 = itemInfo3.position;
            float f26 = itemInfo3.widthFactor;
            i16++;
            z16 = false;
            i17 = i18;
            f18 = f26;
            itemInfo = itemInfo3;
        }
        return itemInfo != null ? itemInfo : new ItemInfo();
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    boolean isGutterDrag(float f16, float f17) {
        return (f16 < ((float) this.mGutterSize) && f17 > 0.0f) || (f16 > ((float) (getWidth() - this.mGutterSize)) && f17 < 0.0f);
    }

    public boolean ismMatchChildHeightToViewPager() {
        return this.mMatchChildHeightToViewPager;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onPageScrolled(int i3, float f16, int i16) {
        int max;
        int i17;
        int left;
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt = getChildAt(i18);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i19 = layoutParams.gravity & 7;
                    if (i19 == 1) {
                        max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    } else {
                        if (i19 == 3) {
                            i17 = childAt.getWidth() + paddingLeft;
                        } else if (i19 != 5) {
                            i17 = paddingLeft;
                        } else {
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = i17;
                    }
                    int i26 = max;
                    i17 = paddingLeft;
                    paddingLeft = i26;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                    }
                    paddingLeft = i17;
                }
            }
        }
        int i27 = this.mSeenPositionMin;
        if (i27 < 0 || i3 < i27) {
            this.mSeenPositionMin = i3;
        }
        if (this.mSeenPositionMax < 0 || Math.ceil(i3 + f16) > this.mSeenPositionMax) {
            this.mSeenPositionMax = i3 + 1;
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
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i28 = 0; i28 < childCount2; i28++) {
                View childAt2 = getChildAt(i28);
                if (!((LayoutParams) childAt2.getLayoutParams()).isDecor) {
                    this.mPageTransformer.transformPage(childAt2, (childAt2.getLeft() - scrollX2) / getWidth());
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
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.requestFocus(i3, rect)) {
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
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.adapterState, savedState.loader);
            setCurrentItemInternal(savedState.position, false, true);
        } else {
            this.mRestoredCurItem = savedState.position;
            this.mRestoredAdapterState = savedState.adapterState;
            this.mRestoredClassLoader = savedState.loader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            savedState.adapterState = pagerAdapter.saveState();
        }
        return savedState;
    }

    void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            int i3 = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = MotionEventCompat.getX(motionEvent, i3);
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i3);
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
            int i19 = this.mPageMargin;
            recomputeScrollPosition(i3, i17, i19, i19);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        boolean onRelease;
        boolean onRelease2;
        if (this.mFakeDragging) {
            return true;
        }
        boolean z16 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.mAdapter) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            populate();
            this.mIsBeingDragged = true;
            setScrollState(1);
            float x16 = motionEvent.getX();
            this.mInitialMotionX = x16;
            this.mLastMotionX = x16;
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.mIsBeingDragged) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                    float x17 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                    float abs = Math.abs(x17 - this.mLastMotionX);
                    float abs2 = Math.abs(MotionEventCompat.getY(motionEvent, findPointerIndex) - this.mLastMotionY);
                    int i3 = this.mTouchSlop;
                    if (abs > i3 && abs > abs2) {
                        this.mIsBeingDragged = true;
                        float f16 = this.mInitialMotionX;
                        this.mLastMotionX = x17 - f16 > 0.0f ? f16 + i3 : f16 - i3;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                    }
                }
                if (this.mIsBeingDragged) {
                    z16 = false | performDrag(MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    this.mLastMotionX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                } else if (action == 6) {
                    onSecondaryPointerUp(motionEvent);
                    this.mLastMotionX = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId));
                }
            } else if (this.mIsBeingDragged) {
                scrollToItem(this.mCurItem, true, 0, false);
                this.mActivePointerId = -1;
                endDrag();
                onRelease = this.mLeftEdge.onRelease();
                onRelease2 = this.mRightEdge.onRelease();
                z16 = onRelease | onRelease2;
            }
        } else if (this.mIsBeingDragged) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
            this.mPopulatePending = true;
            int width = getWidth();
            int scrollX = getScrollX();
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((scrollX / width) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor, xVelocity, (int) (MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
            this.mActivePointerId = -1;
            endDrag();
            onRelease = this.mLeftEdge.onRelease();
            onRelease2 = this.mRightEdge.onRelease();
            z16 = onRelease | onRelease2;
        }
        if (z16) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    boolean pageLeft() {
        int i3 = this.mCurItem;
        if (i3 <= 0) {
            return false;
        }
        setCurrentItem(i3 - 1, true);
        return true;
    }

    boolean pageRight() {
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter == null || this.mCurItem >= pagerAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    boolean pageScrolled(int i3) {
        if (this.mItems.size() == 0) {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        int width = getWidth();
        int i16 = this.mPageMargin;
        int i17 = width + i16;
        float f16 = width;
        int i18 = infoForCurrentScrollPosition.position;
        float f17 = ((i3 / f16) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + (i16 / f16));
        this.mCalledSuper = false;
        onPageScrolled(i18, f17, (int) (i17 * f17));
        if (this.mCalledSuper) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    boolean performDrag(float f16) {
        boolean z16;
        float f17 = this.mLastMotionX - f16;
        this.mLastMotionX = f16;
        float scrollX = getScrollX() + f17;
        float width = getWidth();
        float f18 = this.mFirstOffset * width;
        float f19 = this.mLastOffset * width;
        ItemInfo itemInfo = this.mItems.get(0);
        ArrayList<ItemInfo> arrayList = this.mItems;
        boolean z17 = true;
        ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
        if (itemInfo.position != 0) {
            f18 = itemInfo.offset * width;
            z16 = false;
        } else {
            z16 = true;
        }
        if (itemInfo2.position != this.mAdapter.getCount() - 1) {
            f19 = itemInfo2.offset * width;
            z17 = false;
        }
        if (scrollX < f18) {
            r4 = z16 ? this.mLeftEdge.onPull(Math.abs(f18 - scrollX) / width) : false;
            scrollX = f18;
        } else if (scrollX > f19) {
            r4 = z17 ? this.mRightEdge.onPull(Math.abs(scrollX - f19) / width) : false;
            scrollX = f19;
        }
        int i3 = (int) scrollX;
        this.mLastMotionX += scrollX - i3;
        if (this.mEnableScroll) {
            scrollTo(i3, getScrollY());
        }
        pageScrolled(i3);
        return r4;
    }

    void populate() {
        populate(this.mCurItem);
    }

    void scrollToItem(int i3, boolean z16, int i16, boolean z17) {
        scrollToItem(i3, z16, i16, z17, false);
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        Log.d("ViewPager", "sssssssssssssssssssssssss::setAdapter");
        PagerAdapter pagerAdapter2 = this.mAdapter;
        if (pagerAdapter2 != null) {
            pagerAdapter2.unregisterDataSetObserver(this.mObserver);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i3 = 0; i3 < this.mItems.size(); i3++) {
                ItemInfo itemInfo = this.mItems.get(i3);
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            Log.d("ViewPager", "sssssssssssssssssssssssss::I am");
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.mAdapter;
        this.mAdapter = pagerAdapter;
        if (pagerAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver();
            }
            this.mAdapter.registerDataSetObserver(this.mObserver);
            this.mPopulatePending = false;
            this.mFirstLayout = true;
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else {
                populate();
            }
        }
        OnAdapterChangeListener onAdapterChangeListener = this.mAdapterChangeListener;
        if (onAdapterChangeListener == null || pagerAdapter3 == pagerAdapter) {
            return;
        }
        onAdapterChangeListener.onAdapterChanged(pagerAdapter3, pagerAdapter);
    }

    public void setCenterModeChildren(boolean z16, boolean z17) {
        this.mBoderAlignMode = z16;
        this.mCenterLockEnabled = z17;
        if (z17) {
            this.mPageSpace = (1.0f - this.mAdapter.getPageWidth(0)) / 2.0f;
        }
    }

    void setCurrentItem(int i3) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i3, !this.mFirstLayout, false);
    }

    public void setCurrentItemInCenter(int i3) {
        setCurrentItem(i3);
        scrollToItem(i3, !this.mFirstLayout, 0, false);
    }

    public void setCurrentItemInternal(int i3, boolean z16, boolean z17) {
        setCurrentItemInternal(i3, z16, z17, 0);
    }

    public void setEnableScroll(boolean z16) {
        this.mEnableScroll = z16;
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    void setOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        this.mAdapterChangeListener = onAdapterChangeListener;
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setPageMargin(int i3) {
        int i16 = this.mPageMargin;
        this.mPageMargin = i3;
        int width = getWidth();
        recomputeScrollPosition(width, width, i3, i16);
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

    void setScrollState(int i3) {
        if (this.mScrollState == i3) {
            return;
        }
        this.mScrollState = i3;
        if (i3 == 1) {
            this.mSeenPositionMax = -1;
            this.mSeenPositionMin = -1;
        }
        if (this.mPageTransformer != null) {
            enableLayers(i3 != 0);
        }
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i3);
        }
    }

    void setScrollingCacheEnabled(boolean z16) {
        if (this.mScrollingCacheEnabled != z16) {
            this.mScrollingCacheEnabled = z16;
        }
    }

    public void setmMatchChildHeightToViewPager(boolean z16) {
        this.mMatchChildHeightToViewPager = z16;
    }

    void smoothScrollTo(int i3, int i16) {
        smoothScrollTo(i3, i16, 0);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }

    /* loaded from: classes39.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        int childIndex;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;
        float widthFactor;

        public LayoutParams() {
            super(-1, -1);
            this.widthFactor = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.widthFactor = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, CenterViewPager.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo infoForChild;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    protected boolean canScroll(View view, boolean z16, int i3, int i16, int i17) {
        int i18;
        if (view instanceof Gallery) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i19 = i16 + scrollX;
                if (i19 >= childAt.getLeft() && i19 < childAt.getRight() && (i18 = i17 + scrollY) >= childAt.getTop() && i18 < childAt.getBottom() && canScroll(childAt, true, i3, i19 - childAt.getLeft(), i18 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z16 && ViewCompat.canScrollHorizontally(view, -i3);
    }

    void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
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

    ItemInfo infoForPosition(int i3) {
        for (int i16 = 0; i16 < this.mItems.size(); i16++) {
            ItemInfo itemInfo = this.mItems.get(i16);
            if (itemInfo.position == i3) {
                return itemInfo;
            }
        }
        return null;
    }

    void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffectCompat(context);
        this.mRightEdge = new EdgeEffectCompat(context);
        float f16 = context.getResources().getDisplayMetrics().density;
        this.mFlingDistance = (int) (25.0f * f16);
        this.mCloseEnough = (int) (2.0f * f16);
        this.mDefaultGutterSize = (int) (f16 * 16.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i17;
        setMeasuredDimension(View.getDefaultSize(0, i3), View.getDefaultSize(0, i16));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i18 = 0;
        while (true) {
            boolean z16 = true;
            int i19 = 1073741824;
            if (i18 >= childCount) {
                break;
            }
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.isDecor) {
                int i26 = layoutParams2.gravity;
                int i27 = i26 & 7;
                int i28 = i26 & 112;
                boolean z17 = i28 == 48 || i28 == 80;
                if (i27 != 3 && i27 != 5) {
                    z16 = false;
                }
                int i29 = Integer.MIN_VALUE;
                if (z17) {
                    i17 = Integer.MIN_VALUE;
                    i29 = 1073741824;
                } else {
                    i17 = z16 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i36 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i36 != -2) {
                    if (i36 == -1) {
                        i36 = paddingLeft;
                    }
                    i29 = 1073741824;
                } else {
                    i36 = paddingLeft;
                }
                int i37 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i37 == -2) {
                    i37 = measuredHeight;
                    i19 = i17;
                } else if (i37 == -1) {
                    i37 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i36, i29), View.MeasureSpec.makeMeasureSpec(i37, i19));
                if (z17) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z16) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i18++;
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        if (this.mMatchChildHeightToViewPager) {
            this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        }
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i38 = 0; i38 < childCount2; i38++) {
            View childAt2 = getChildAt(i38);
            if (childAt2.getVisibility() != 8 && (layoutParams = (LayoutParams) childAt2.getLayoutParams()) != null && !layoutParams.isDecor) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * layoutParams.widthFactor), 1073741824), this.mChildHeightMeasureSpec);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        if (r9 == r10) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void populate(int i3) {
        ItemInfo itemInfo;
        ItemInfo itemInfo2;
        ItemInfo infoForChild;
        ItemInfo itemInfo3;
        int i16 = this.mCurItem;
        if (i16 != i3) {
            itemInfo = infoForPosition(i16);
            this.mCurItem = i3;
        } else {
            itemInfo = null;
        }
        if (this.mAdapter == null || this.mPopulatePending || getWindowToken() == null) {
            return;
        }
        this.mAdapter.startUpdate((ViewGroup) this);
        int i17 = this.mOffscreenPageLimit;
        int max = Math.max(0, this.mCurItem - i17);
        int count = this.mAdapter.getCount();
        int min = Math.min(count - 1, this.mCurItem + i17);
        int i18 = 0;
        while (true) {
            if (i18 >= this.mItems.size()) {
                break;
            }
            itemInfo2 = this.mItems.get(i18);
            int i19 = itemInfo2.position;
            int i26 = this.mCurItem;
            if (i19 < i26) {
                i18++;
            }
        }
        itemInfo2 = null;
        if (itemInfo2 == null && count > 0) {
            itemInfo2 = addNewItem(this.mCurItem, i18);
        }
        if (itemInfo2 != null) {
            int i27 = i18 - 1;
            ItemInfo itemInfo4 = i27 >= 0 ? this.mItems.get(i27) : null;
            float f16 = 2.0f - itemInfo2.widthFactor;
            float f17 = 0.0f;
            for (int i28 = this.mCurItem - 1; i28 >= 0; i28--) {
                if (f17 >= f16 && i28 < max) {
                    if (itemInfo4 == null) {
                        break;
                    }
                    if (i28 == itemInfo4.position && !itemInfo4.scrolling) {
                        this.mItems.remove(i27);
                        this.mAdapter.destroyItem((ViewGroup) this, i28, itemInfo4.object);
                        i27--;
                        i18--;
                        if (i27 >= 0) {
                            itemInfo3 = this.mItems.get(i27);
                            itemInfo4 = itemInfo3;
                        }
                        itemInfo3 = null;
                        itemInfo4 = itemInfo3;
                    }
                } else if (itemInfo4 != null && i28 == itemInfo4.position) {
                    f17 += itemInfo4.widthFactor;
                    i27--;
                    if (i27 >= 0) {
                        itemInfo3 = this.mItems.get(i27);
                        itemInfo4 = itemInfo3;
                    }
                    itemInfo3 = null;
                    itemInfo4 = itemInfo3;
                } else {
                    f17 += addNewItem(i28, i27 + 1).widthFactor;
                    i18++;
                    if (i27 >= 0) {
                        itemInfo3 = this.mItems.get(i27);
                        itemInfo4 = itemInfo3;
                    }
                    itemInfo3 = null;
                    itemInfo4 = itemInfo3;
                }
            }
            float f18 = itemInfo2.widthFactor;
            int i29 = i18 + 1;
            if (f18 < 2.0f) {
                ItemInfo itemInfo5 = i29 < this.mItems.size() ? this.mItems.get(i29) : null;
                for (int i36 = this.mCurItem + 1; i36 < count; i36++) {
                    if (f18 >= 2.0f && i36 > min) {
                        if (itemInfo5 == null) {
                            break;
                        }
                        if (i36 == itemInfo5.position && !itemInfo5.scrolling) {
                            this.mItems.remove(i29);
                            this.mAdapter.destroyItem((ViewGroup) this, i36, itemInfo5.object);
                            if (i29 < this.mItems.size()) {
                                itemInfo5 = this.mItems.get(i29);
                            }
                            itemInfo5 = null;
                        }
                    } else if (itemInfo5 != null && i36 == itemInfo5.position) {
                        f18 += itemInfo5.widthFactor;
                        i29++;
                        if (i29 < this.mItems.size()) {
                            itemInfo5 = this.mItems.get(i29);
                        }
                        itemInfo5 = null;
                    } else {
                        ItemInfo addNewItem = addNewItem(i36, i29);
                        i29++;
                        f18 += addNewItem.widthFactor;
                        if (i29 < this.mItems.size()) {
                            itemInfo5 = this.mItems.get(i29);
                        }
                        itemInfo5 = null;
                    }
                }
            }
            calculatePageOffsets(itemInfo2, i18, itemInfo);
        }
        this.mAdapter.setPrimaryItem((ViewGroup) this, this.mCurItem, itemInfo2 != null ? itemInfo2.object : null);
        this.mAdapter.finishUpdate((ViewGroup) this);
        boolean z16 = this.mDrawingOrder != 0;
        if (z16) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
        }
        int childCount = getChildCount();
        for (int i37 = 0; i37 < childCount; i37++) {
            View childAt = getChildAt(i37);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            layoutParams.childIndex = i37;
            if (!layoutParams.isDecor && layoutParams.widthFactor == 0.0f && (infoForChild = infoForChild(childAt)) != null) {
                layoutParams.widthFactor = infoForChild.widthFactor;
                layoutParams.position = infoForChild.position;
            }
            if (z16) {
                this.mDrawingOrderedChildren.add(childAt);
            }
        }
        if (z16) {
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
        if (hasFocus()) {
            View findFocus = findFocus();
            ItemInfo infoForAnyChild = findFocus != null ? infoForAnyChild(findFocus) : null;
            if (infoForAnyChild == null || infoForAnyChild.position != this.mCurItem) {
                for (int i38 = 0; i38 < getChildCount(); i38++) {
                    View childAt2 = getChildAt(i38);
                    ItemInfo infoForChild2 = infoForChild(childAt2);
                    if (infoForChild2 != null && infoForChild2.position == this.mCurItem && childAt2.requestFocus(2)) {
                        return;
                    }
                }
            }
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

    void scrollToItem(final int i3, boolean z16, int i16, boolean z17, boolean z18) {
        final int i17;
        OnPageChangeListener onPageChangeListener;
        OnPageChangeListener onPageChangeListener2;
        OnPageChangeListener onPageChangeListener3;
        OnPageChangeListener onPageChangeListener4;
        float f16;
        float max;
        ItemInfo infoForPosition = infoForPosition(i3);
        if (infoForPosition != null) {
            int width = getWidth();
            float f17 = this.mLastOffset;
            if (f17 <= 0.0f && this.mCenterLockEnabled) {
                this.mLastOffset = -(this.mPageSpace * 2.0f);
            } else if (f17 < 0.0f && subAllItemWidthFactor() < 1.0f) {
                this.mLastOffset = 0.0f;
            }
            if (i3 == 0) {
                if (this.mBoderAlignMode) {
                    f16 = width;
                    max = Math.min(infoForPosition.offset, this.mLastOffset);
                } else {
                    f16 = width;
                    max = Math.min(infoForPosition.offset - this.mPageSpace, this.mLastOffset);
                }
            } else if (i3 == this.mAdapter.getCount() - 1) {
                if (this.mBoderAlignMode) {
                    f16 = width;
                    max = Math.min(infoForPosition.offset, this.mLastOffset);
                } else {
                    f16 = width;
                    max = Math.min(infoForPosition.offset, this.mLastOffset) + this.mPageSpace;
                }
            } else if (this.mCenterLockEnabled) {
                f16 = width;
                max = Math.max(this.mFirstOffset, Math.min(infoForPosition.offset - this.mPageSpace, this.mLastOffset));
            } else {
                f16 = width;
                max = Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset));
            }
            i17 = (int) (f16 * max);
        } else {
            i17 = 0;
        }
        if (z16) {
            smoothScrollTo(i17, 0, i16);
            if (z17 && (onPageChangeListener4 = this.mOnPageChangeListener) != null) {
                onPageChangeListener4.onPageSelected(i3);
            }
            if (!z17 || (onPageChangeListener3 = this.mInternalPageChangeListener) == null) {
                return;
            }
            onPageChangeListener3.onPageSelected(i3);
            return;
        }
        if (z17 && (onPageChangeListener2 = this.mOnPageChangeListener) != null) {
            onPageChangeListener2.onPageSelected(i3);
        }
        if (z17 && (onPageChangeListener = this.mInternalPageChangeListener) != null) {
            onPageChangeListener.onPageSelected(i3);
        }
        completeScroll(false);
        if (this.mCenterLockEnabled) {
            if (z18 && (i3 == this.mAdapter.getCount() - 1 || i3 == 0)) {
                post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.common.CenterViewPager.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (i17 == 0) {
                            if (i3 == 0) {
                                if (CenterViewPager.this.subAllItemWidthFactor() < 1.0f) {
                                    CenterViewPager centerViewPager = CenterViewPager.this;
                                    centerViewPager.scrollTo(i17 - ((int) centerViewPager.getPageSpace()), 0);
                                    return;
                                } else {
                                    CenterViewPager centerViewPager2 = CenterViewPager.this;
                                    centerViewPager2.scrollTo(i17 - (centerViewPager2.mBoderAlignMode ? 0 : (int) centerViewPager2.getPageSpace()), 0);
                                    return;
                                }
                            }
                            if (CenterViewPager.this.mAdapter != null) {
                                int width2 = (int) (r0.getWidth() * (1.0f - CenterViewPager.this.mAdapter.getPageWidth(0)));
                                CenterViewPager centerViewPager3 = CenterViewPager.this;
                                int i18 = i17;
                                if (!centerViewPager3.mBoderAlignMode) {
                                    width2 = 0;
                                }
                                centerViewPager3.scrollTo(i18 - width2, 0);
                                return;
                            }
                            return;
                        }
                        if (CenterViewPager.this.subAllItemWidthFactor() < 1.0f && i17 < (-((int) CenterViewPager.this.getPageSpace()))) {
                            CenterViewPager centerViewPager4 = CenterViewPager.this;
                            centerViewPager4.scrollTo(-((int) centerViewPager4.getPageSpace()), 0);
                        } else {
                            CenterViewPager.this.scrollTo(i17, 0);
                        }
                    }
                });
                return;
            } else {
                post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.common.CenterViewPager.5
                    @Override // java.lang.Runnable
                    public void run() {
                        int i18 = i17;
                        if (i18 == 0) {
                            CenterViewPager centerViewPager = CenterViewPager.this;
                            centerViewPager.scrollTo(i18 - ((int) centerViewPager.getPageSpace()), 0);
                        } else {
                            CenterViewPager.this.scrollTo(i18, 0);
                        }
                    }
                });
                return;
            }
        }
        scrollTo(i17, 0);
    }

    void setCurrentItemInternal(int i3, boolean z16, boolean z17, int i16) {
        int i17;
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null && pagerAdapter.getCount() > 0) {
            if (!z17 && this.mCurItem == i3 && this.mItems.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i3 < 0) {
                i17 = 0;
            } else {
                if (i3 >= this.mAdapter.getCount()) {
                    i3 = this.mAdapter.getCount() - 1;
                }
                i17 = i3;
            }
            int i18 = this.mOffscreenPageLimit;
            int i19 = this.mCurItem;
            if (i17 > i19 + i18 || i17 < i19 - i18) {
                for (int i26 = 0; i26 < this.mItems.size(); i26++) {
                    this.mItems.get(i26).scrolling = true;
                }
            }
            boolean z18 = this.mCurItem != i17;
            populate(i17);
            scrollToItem(i17, z16, i16, z18, z17);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    void smoothScrollTo(int i3, int i16, int i17) {
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i18 = i3 - scrollX;
        int i19 = i16 - scrollY;
        if (i18 == 0 && i19 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int width = getWidth();
        int i26 = width / 2;
        float f16 = width;
        float f17 = i26;
        float distanceInfluenceForSnapDuration = f17 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i18) * 1.0f) / f16)) * f17);
        int abs2 = Math.abs(i17);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(distanceInfluenceForSnapDuration / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i18) / ((f16 * this.mAdapter.getPageWidth(this.mCurItem)) + this.mPageMargin)) + 1.0f) * 100.0f);
        }
        this.mScroller.startScroll(scrollX, scrollY, i18, i19, Math.min(abs, 600));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void enableCenterLockOfChilds() {
        setCenterModeChildren(false, true);
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
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        float f16;
        float f17;
        super.onDraw(canvas);
        if (this.mPageMargin <= 0 || this.mMarginDrawable == null || this.mItems.size() <= 0 || this.mAdapter == null) {
            return;
        }
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
                float f27 = itemInfo.widthFactor;
                f16 = (f26 + f27) * width;
                f19 = f26 + f27 + f18;
            } else {
                float pageWidth = this.mAdapter.getPageWidth(i17);
                f16 = (f19 + pageWidth) * width;
                f19 += pageWidth + f18;
            }
            int i19 = this.mPageMargin;
            if (i19 + f16 > scrollX) {
                f17 = f18;
                this.mMarginDrawable.setBounds((int) f16, this.mTopPageBounds, (int) (i19 + f16 + 0.5f), this.mBottomPageBounds);
                this.mMarginDrawable.draw(canvas);
            } else {
                f17 = f18;
            }
            if (f16 > scrollX + r2) {
                return;
            }
            i17++;
            f18 = f17;
        }
    }

    void recomputeScrollPosition(int i3, int i16, int i17, int i18) {
        if (i16 > 0 && !this.mItems.isEmpty()) {
            int scrollX = (int) ((getScrollX() / (i16 + i18)) * (i17 + i3));
            scrollTo(scrollX, getScrollY());
            if (this.mScroller.isFinished()) {
                return;
            }
            int duration = this.mScroller.getDuration() - this.mScroller.timePassed();
            ItemInfo infoForPosition = infoForPosition(this.mCurItem);
            if (infoForPosition != null) {
                this.mScroller.startScroll(scrollX, 0, (int) (infoForPosition.offset * i3), 0, duration);
                return;
            }
            return;
        }
        ItemInfo infoForPosition2 = infoForPosition(this.mCurItem);
        int min = (int) ((infoForPosition2 != null ? Math.min(infoForPosition2.offset, this.mLastOffset) : 0.0f) * i3);
        if (min != getScrollX()) {
            completeScroll(false);
            scrollTo(min, getScrollY());
        }
    }

    public void setCurrentItem(int i3, boolean z16) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i3, z16, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i3, int i16) {
        ItemInfo infoForChild;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i17 = 0; i17 < getChildCount(); i17++) {
                View childAt = getChildAt(i17);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                    childAt.addFocusables(arrayList, i3, i16);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i16 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View view;
        int i3;
        float f16;
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.mIsBeingDragged) {
                    return true;
                }
                if (this.mIsUnableToDrag) {
                    return false;
                }
            }
            if (action == 0) {
                float x16 = motionEvent.getX();
                this.mInitialMotionX = x16;
                this.mLastMotionX = x16;
                this.mLastMotionY = motionEvent.getY();
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                this.mIsUnableToDrag = false;
                this.mScroller.computeScrollOffset();
                if (this.mScrollState == 2 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    populate();
                    this.mIsBeingDragged = true;
                    setScrollState(1);
                } else {
                    completeScroll(false);
                    this.mIsBeingDragged = false;
                }
            } else if (action == 2) {
                int i16 = this.mActivePointerId;
                if (i16 != -1) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i16);
                    float x17 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                    float f17 = x17 - this.mLastMotionX;
                    float abs = Math.abs(f17);
                    float y16 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                    float abs2 = Math.abs(y16 - this.mLastMotionY);
                    if (f17 != 0.0f && !isGutterDrag(this.mLastMotionX, f17) && canScroll(this, false, (int) f17, (int) x17, (int) y16)) {
                        this.mLastMotionX = x17;
                        this.mInitialMotionX = x17;
                        this.mLastMotionY = y16;
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                    int i17 = this.mTouchSlop;
                    if (abs > i17 && abs > abs2) {
                        this.mIsBeingDragged = true;
                        setScrollState(1);
                        if (f17 > 0.0f) {
                            f16 = this.mInitialMotionX + this.mTouchSlop;
                        } else {
                            f16 = this.mInitialMotionX - this.mTouchSlop;
                        }
                        this.mLastMotionX = f16;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > i17) {
                        this.mIsUnableToDrag = true;
                    }
                    if (this.mIsBeingDragged && performDrag(x17)) {
                        ViewCompat.postInvalidateOnAnimation(this);
                    }
                }
            } else if (action == 6) {
                onSecondaryPointerUp(motionEvent);
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            return this.mIsBeingDragged;
        }
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        this.mActivePointerId = -1;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        if (action == 1 && this.mClickAutoScrollMode) {
            float x18 = motionEvent.getX();
            ItemInfo findItemInfoByPos = findItemInfoByPos(this.mCurItem);
            if (findItemInfoByPos != null) {
                Object obj = findItemInfoByPos.object;
                if (!(obj instanceof View) || (view = (View) obj) == null) {
                    return false;
                }
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                if (x18 < iArr[0] && (i3 = this.mCurItem) > 0) {
                    setCurrentItem(i3 - 1, true);
                    return true;
                }
                if (x18 > r2 + view.getMeasuredWidth() && this.mCurItem <= this.mItems.size() - 1) {
                    setCurrentItem(this.mCurItem + 1, true);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a7  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        ItemInfo infoForChild;
        int max;
        int i19;
        int max2;
        int i26;
        int i27 = 1;
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount = getChildCount();
        int i28 = i17 - i3;
        int i29 = i18 - i16;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        if (subAllItemWidthFactor() < 1.0f && !this.mCenterLockEnabled) {
            scrollTo(0, 0);
        }
        int i36 = 0;
        int i37 = 0;
        while (i36 < childCount) {
            View childAt = getChildAt(i36);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i38 = layoutParams.gravity;
                    int i39 = i38 & 7;
                    int i46 = i38 & 112;
                    if (i39 == i27) {
                        max = Math.max((i28 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    } else {
                        if (i39 == 3) {
                            i19 = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i39 != 5) {
                            i19 = paddingLeft;
                        } else {
                            max = (i28 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i46 != 16) {
                            max2 = Math.max((i29 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        } else {
                            if (i46 == 48) {
                                i26 = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i46 != 80) {
                                i26 = paddingTop;
                            } else {
                                max2 = (i29 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i47 = paddingLeft + scrollX;
                            childAt.layout(i47, paddingTop, childAt.getMeasuredWidth() + i47, paddingTop + childAt.getMeasuredHeight());
                            i37++;
                            paddingLeft = i19;
                            paddingTop = i26;
                        }
                        int i48 = max2;
                        i26 = paddingTop;
                        paddingTop = i48;
                        int i472 = paddingLeft + scrollX;
                        childAt.layout(i472, paddingTop, childAt.getMeasuredWidth() + i472, paddingTop + childAt.getMeasuredHeight());
                        i37++;
                        paddingLeft = i19;
                        paddingTop = i26;
                    }
                    int i49 = paddingLeft;
                    paddingLeft = max;
                    i19 = i49;
                    if (i46 != 16) {
                    }
                    int i482 = max2;
                    i26 = paddingTop;
                    paddingTop = i482;
                    int i4722 = paddingLeft + scrollX;
                    childAt.layout(i4722, paddingTop, childAt.getMeasuredWidth() + i4722, paddingTop + childAt.getMeasuredHeight());
                    i37++;
                    paddingLeft = i19;
                    paddingTop = i26;
                }
            }
            i36++;
            i27 = 1;
        }
        for (int i56 = 0; i56 < childCount; i56++) {
            View childAt2 = getChildAt(i56);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.isDecor && (infoForChild = infoForChild(childAt2)) != null) {
                    int i57 = ((int) (i28 * infoForChild.offset)) + paddingLeft;
                    if (layoutParams2.needsMeasure) {
                        layoutParams2.needsMeasure = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (((i28 - paddingLeft) - paddingRight) * layoutParams2.widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec((i29 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i57, paddingTop, childAt2.getMeasuredWidth() + i57, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.mTopPageBounds = paddingTop;
        this.mBottomPageBounds = i29 - paddingBottom;
        this.mDecorChildCount = i37;
        this.mFirstLayout = false;
    }

    public void setOffscreenPageLimit(int i3) {
        if (i3 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i3 + " too small; defaulting to 1");
            i3 = 1;
        }
        if (i3 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i3;
            populate();
        }
    }

    public void setPageMarginDrawable(int i3) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i3));
    }

    public void setPageTransformer(boolean z16, PageTransformer pageTransformer) {
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

    float distanceInfluenceForSnapDuration(float f16) {
        return (float) Math.sin((float) ((f16 - 0.5f) * 0.4712389167638204d));
    }

    public CenterViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPageSpace = 0.0f;
        this.mEnableScroll = true;
        this.mItems = new ArrayList<>();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mEndScrollRunnable = new Runnable() { // from class: com.qzone.module.feedcomponent.ui.common.CenterViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                CenterViewPager.this.setScrollState(0);
                CenterViewPager.this.populate();
            }
        };
        this.mMatchChildHeightToViewPager = true;
        this.mScrollState = 0;
        initViewPager();
    }

    /* loaded from: classes39.dex */
    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        @Override // com.qzone.module.feedcomponent.ui.common.CenterViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // com.qzone.module.feedcomponent.ui.common.CenterViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
        }

        @Override // com.qzone.module.feedcomponent.ui.common.CenterViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }

    void enableLayers(boolean z16) {
    }
}
