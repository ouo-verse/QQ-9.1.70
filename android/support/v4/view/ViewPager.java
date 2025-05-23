package android.support.v4.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
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
import android.widget.Scroller;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private int mActivePointerId;
    private PagerAdapter mAdapter;
    private OnAdapterChangeListener mAdapterChangeListener;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    private int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private boolean mEdgeEffectEnabled;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mIgnoreGutter;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffectCompat mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private OnPageChangeListener mOnPageChangeListener;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffectCompat mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private static final int[] LAYOUT_ATTRS = {R.attr.layout_gravity};
    private static final Comparator<ItemInfo> COMPARATOR = new Comparator<ItemInfo>() { // from class: android.support.v4.view.ViewPager.1
        @Override // java.util.Comparator
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.position - itemInfo2.position;
        }
    };
    private static final Interpolator sInterpolator = new Interpolator() { // from class: android.support.v4.view.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            float f17 = f16 - 1.0f;
            return (f17 * f17 * f17 * f17 * f17) + 1.0f;
        }
    };
    private static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();

    /* loaded from: classes.dex */
    interface Decor {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        ItemInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        MyAccessibilityDelegate() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            boolean z16;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            if (ViewPager.this.mAdapter != null && ViewPager.this.mAdapter.getCount() > 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            accessibilityNodeInfoCompat.setScrollable(z16);
            if (ViewPager.this.mAdapter != null && ViewPager.this.mCurItem >= 0 && ViewPager.this.mCurItem < ViewPager.this.mAdapter.getCount() - 1) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (ViewPager.this.mAdapter != null && ViewPager.this.mCurItem > 0 && ViewPager.this.mCurItem < ViewPager.this.mAdapter.getCount()) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            if (super.performAccessibilityAction(view, i3, bundle)) {
                return true;
            }
            if (i3 != 4096) {
                if (i3 != 8192 || ViewPager.this.mAdapter == null || ViewPager.this.mCurItem <= 0 || ViewPager.this.mCurItem >= ViewPager.this.mAdapter.getCount()) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.mCurItem - 1);
                return true;
            }
            if (ViewPager.this.mAdapter == null || ViewPager.this.mCurItem < 0 || ViewPager.this.mCurItem >= ViewPager.this.mAdapter.getCount() - 1) {
                return false;
            }
            ViewPager viewPager2 = ViewPager.this;
            viewPager2.setCurrentItem(viewPager2.mCurItem + 1);
            return true;
        }
    }

    /* loaded from: classes.dex */
    interface OnAdapterChangeListener {
        void onAdapterChanged(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* loaded from: classes.dex */
    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i3);

        void onPageScrolled(int i3, float f16, int i16);

        void onPageSelected(int i3);
    }

    /* loaded from: classes.dex */
    public interface PageTransformer {
        void transformPage(View view, float f16);
    }

    /* loaded from: classes.dex */
    private class PagerObserver extends DataSetObserver {
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

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: android.support.v4.view.ViewPager.SavedState.1
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
    /* loaded from: classes.dex */
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

    public ViewPager(Context context) {
        super(context);
        this.mItems = new ArrayList<>();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new Runnable() { // from class: android.support.v4.view.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    private void calculatePageOffsets(ItemInfo itemInfo, int i3, ItemInfo itemInfo2) {
        float f16;
        float f17;
        float f18;
        int i16;
        int i17;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f16 = this.mPageMargin / clientWidth;
        } else {
            f16 = 0.0f;
        }
        if (itemInfo2 != null) {
            int i18 = itemInfo2.position;
            int i19 = itemInfo.position;
            if (i18 < i19) {
                float f19 = itemInfo2.offset + itemInfo2.widthFactor + f16;
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
                        f19 += this.mAdapter.getPageWidth(i26) + f16;
                        i26++;
                    }
                    itemInfo4.offset = f19;
                    f19 += itemInfo4.widthFactor + f16;
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
                        f26 -= this.mAdapter.getPageWidth(i18) + f16;
                        i18--;
                    }
                    f26 -= itemInfo3.widthFactor + f16;
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
            f18 = (itemInfo.widthFactor + f27) - 1.0f;
        } else {
            f18 = Float.MAX_VALUE;
        }
        this.mLastOffset = f18;
        int i37 = i3 - 1;
        while (i37 >= 0) {
            ItemInfo itemInfo7 = this.mItems.get(i37);
            while (true) {
                i17 = itemInfo7.position;
                if (i29 <= i17) {
                    break;
                }
                f27 -= this.mAdapter.getPageWidth(i29) + f16;
                i29--;
            }
            f27 -= itemInfo7.widthFactor + f16;
            itemInfo7.offset = f27;
            if (i17 == 0) {
                this.mFirstOffset = f27;
            }
            i37--;
            i29--;
        }
        float f28 = itemInfo.offset + itemInfo.widthFactor + f16;
        int i38 = itemInfo.position + 1;
        int i39 = i3 + 1;
        while (i39 < size2) {
            ItemInfo itemInfo8 = this.mItems.get(i39);
            while (true) {
                i16 = itemInfo8.position;
                if (i38 >= i16) {
                    break;
                }
                f28 += this.mAdapter.getPageWidth(i38) + f16;
                i38++;
            }
            if (i16 == i36) {
                this.mLastOffset = (itemInfo8.widthFactor + f28) - 1.0f;
            }
            itemInfo8.offset = f28;
            f28 += itemInfo8.widthFactor + f16;
            i39++;
            i38++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void completeScroll(boolean z16) {
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
                ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
            } else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    private int determineTargetPage(int i3, float f16, int i16, int i17) {
        float f17;
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
            return Math.max(this.mItems.get(0).position, Math.min(i3, this.mItems.get(r4.size() - 1).position));
        }
        return i3;
    }

    private void dispatchOnPageSelected(int i3) {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(i16);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i3);
                }
            }
        }
    }

    private void enableLayers(boolean z16) {
        int i3;
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            if (z16) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            ViewCompat.setLayerType(getChildAt(i16), i3, null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
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

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private ItemInfo infoForCurrentScrollPosition() {
        float f16;
        float f17;
        int i3;
        int clientWidth = getClientWidth();
        float f18 = 0.0f;
        if (clientWidth > 0) {
            f16 = getScrollX() / clientWidth;
        } else {
            f16 = 0.0f;
        }
        if (clientWidth > 0) {
            f17 = this.mPageMargin / clientWidth;
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
                itemInfo2.widthFactor = this.mAdapter.getPageWidth(i3);
                i16--;
            }
            ItemInfo itemInfo3 = itemInfo2;
            f18 = itemInfo3.offset;
            float f26 = itemInfo3.widthFactor + f18 + f17;
            if (!z16 && f16 < f18) {
                return itemInfo;
            }
            if (f16 >= f26 && i16 != this.mItems.size() - 1) {
                int i18 = itemInfo3.position;
                float f27 = itemInfo3.widthFactor;
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

    private boolean isGutterDrag(float f16, float f17) {
        if ((f16 < this.mGutterSize && f17 > 0.0f) || (f16 > getWidth() - this.mGutterSize && f17 < 0.0f)) {
            return true;
        }
        return false;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i3;
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            if (actionIndex == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.mLastMotionX = MotionEventCompat.getX(motionEvent, i3);
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i3);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int i3) {
        if (this.mItems.size() == 0) {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        int clientWidth = getClientWidth();
        int i16 = this.mPageMargin;
        int i17 = clientWidth + i16;
        float f16 = clientWidth;
        int i18 = infoForCurrentScrollPosition.position;
        float f17 = ((i3 / f16) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + (i16 / f16));
        this.mCalledSuper = false;
        onPageScrolled(i18, f17, (int) (i17 * f17));
        if (this.mCalledSuper) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean performDrag(float f16) {
        boolean z16;
        float f17 = this.mLastMotionX - f16;
        this.mLastMotionX = f16;
        float scrollX = getScrollX() + f17;
        float clientWidth = getClientWidth();
        float f18 = this.mFirstOffset * clientWidth;
        float f19 = this.mLastOffset * clientWidth;
        boolean z17 = false;
        ItemInfo itemInfo = this.mItems.get(0);
        ArrayList<ItemInfo> arrayList = this.mItems;
        boolean z18 = true;
        ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
        if (itemInfo.position != 0) {
            f18 = itemInfo.offset * clientWidth;
            z16 = false;
        } else {
            z16 = true;
        }
        if (itemInfo2.position != this.mAdapter.getCount() - 1) {
            f19 = itemInfo2.offset * clientWidth;
            z18 = false;
        }
        if (scrollX < f18) {
            if (z16 && this.mEdgeEffectEnabled) {
                z17 = this.mLeftEdge.onPull(Math.abs(f18 - scrollX) / clientWidth);
            }
            scrollX = f18;
        } else if (scrollX > f19) {
            if (z18 && this.mEdgeEffectEnabled) {
                z17 = this.mRightEdge.onPull(Math.abs(scrollX - f19) / clientWidth);
            }
            scrollX = f19;
        }
        int i3 = (int) scrollX;
        this.mLastMotionX += scrollX - i3;
        scrollTo(i3, getScrollY());
        pageScrolled(i3);
        return z17;
    }

    private void recomputeScrollPosition(int i3, int i16, int i17, int i18) {
        float f16;
        if (i16 > 0 && !this.mItems.isEmpty()) {
            int scrollX = (int) ((getScrollX() / (((i16 - getPaddingLeft()) - getPaddingRight()) + i18)) * (((i3 - getPaddingLeft()) - getPaddingRight()) + i17));
            scrollTo(scrollX, getScrollY());
            if (!this.mScroller.isFinished()) {
                this.mScroller.startScroll(scrollX, 0, (int) (infoForPosition(this.mCurItem).offset * i3), 0, this.mScroller.getDuration() - this.mScroller.timePassed());
                return;
            }
            return;
        }
        ItemInfo infoForPosition = infoForPosition(this.mCurItem);
        if (infoForPosition != null) {
            f16 = Math.min(infoForPosition.offset, this.mLastOffset);
        } else {
            f16 = 0.0f;
        }
        int paddingLeft = (int) (f16 * ((i3 - getPaddingLeft()) - getPaddingRight()));
        if (paddingLeft != getScrollX()) {
            completeScroll(false);
            scrollTo(paddingLeft, getScrollY());
        }
    }

    private void removeNonDecorViews() {
        int i3 = 0;
        while (i3 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i3).getLayoutParams()).isDecor) {
                removeViewAt(i3);
                i3--;
            }
            i3++;
        }
    }

    private void scrollToItem(int i3, boolean z16, int i16, boolean z17) {
        int i17;
        OnPageChangeListener onPageChangeListener;
        OnPageChangeListener onPageChangeListener2;
        OnPageChangeListener onPageChangeListener3;
        OnPageChangeListener onPageChangeListener4;
        ItemInfo infoForPosition = infoForPosition(i3);
        if (infoForPosition != null) {
            i17 = (int) (getClientWidth() * Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset)));
        } else {
            i17 = 0;
        }
        if (z16) {
            smoothScrollTo(i17, 0, i16);
            if (z17 && (onPageChangeListener4 = this.mOnPageChangeListener) != null) {
                onPageChangeListener4.onPageSelected(i3);
            }
            if (z17) {
                dispatchOnPageSelected(i3);
            }
            if (z17 && (onPageChangeListener3 = this.mInternalPageChangeListener) != null) {
                onPageChangeListener3.onPageSelected(i3);
                return;
            }
            return;
        }
        if (z17 && (onPageChangeListener2 = this.mOnPageChangeListener) != null) {
            onPageChangeListener2.onPageSelected(i3);
        }
        if (z17) {
            dispatchOnPageSelected(i3);
        }
        if (z17 && (onPageChangeListener = this.mInternalPageChangeListener) != null) {
            onPageChangeListener.onPageSelected(i3);
        }
        completeScroll(false);
        scrollTo(i17, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i3) {
        boolean z16;
        if (this.mScrollState == i3) {
            return;
        }
        this.mScrollState = i3;
        if (this.mPageTransformer != null) {
            if (i3 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            enableLayers(z16);
        }
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i3);
        }
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListeners.get(i16);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrollStateChanged(i3);
                }
            }
        }
    }

    private void setScrollingCacheEnabled(boolean z16) {
        if (this.mScrollingCacheEnabled != z16) {
            this.mScrollingCacheEnabled = z16;
        }
    }

    private void sortChildDrawingOrderPrivate() {
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

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i3, int i16) {
        ItemInfo infoForChild;
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
        itemInfo.widthFactor = this.mAdapter.getPageWidth(i3);
        if (i16 >= 0 && i16 < this.mItems.size()) {
            this.mItems.add(i16, itemInfo);
        } else {
            this.mItems.add(itemInfo);
        }
        return itemInfo;
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(onPageChangeListener);
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

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z16 = layoutParams2.isDecor | (view instanceof Decor);
        layoutParams2.isDecor = z16;
        if (this.mInLayout) {
            if (!z16) {
                layoutParams2.needsMeasure = true;
                addViewInLayout(view, i3, layoutParams);
                return;
            }
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        super.addView(view, i3, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean arrowScroll(int i3) {
        boolean z16;
        View findNextFocus;
        boolean requestFocus;
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
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb5.append(" => ");
                        sb5.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb5.toString());
                }
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i3);
            if (findNextFocus == null && findNextFocus != findFocus) {
                if (i3 == 17) {
                    int i16 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left;
                    int i17 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).left;
                    if (findFocus != null && i16 >= i17) {
                        requestFocus = pageLeft();
                    } else {
                        requestFocus = findNextFocus.requestFocus();
                    }
                } else if (i3 == 66) {
                    int i18 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left;
                    int i19 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).left;
                    if (findFocus != null && i18 <= i19) {
                        requestFocus = pageRight();
                    } else {
                        requestFocus = findNextFocus.requestFocus();
                    }
                }
                z17 = requestFocus;
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

    protected boolean canScroll(View view, boolean z16, int i3, int i16, int i17) {
        int i18;
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
        if (z16 && ViewCompat.canScrollHorizontally(view, -i3)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    public void clearOnPageChangeListeners() {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
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
        boolean z16;
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        if (this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = this.mCurItem;
        int i16 = 0;
        boolean z17 = false;
        while (i16 < this.mItems.size()) {
            ItemInfo itemInfo = this.mItems.get(i16);
            int itemPosition = this.mAdapter.getItemPosition(itemInfo.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i16);
                    i16--;
                    if (!z17) {
                        this.mAdapter.startUpdate((ViewGroup) this);
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
                    layoutParams.widthFactor = 0.0f;
                }
            }
            setCurrentItemInternal(i3, false, true);
            requestLayout();
        }
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
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    float distanceInfluenceForSnapDuration(float f16) {
        return (float) Math.sin((float) ((f16 - 0.5f) * 0.4712389167638204d));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        if (!this.mEdgeEffectEnabled) {
            return;
        }
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
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((scrollX / clientWidth) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
            endDrag();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (KeyEventCompat.hasNoModifiers(keyEvent)) {
                            return arrowScroll(2);
                        }
                        if (KeyEventCompat.hasModifiers(keyEvent, 1)) {
                            return arrowScroll(1);
                        }
                    }
                } else {
                    return arrowScroll(66);
                }
            } else {
                return arrowScroll(17);
            }
        }
        return false;
    }

    public void fakeDragBy(float f16) {
        if (this.mFakeDragging) {
            this.mLastMotionX += f16;
            float scrollX = getScrollX() - f16;
            float clientWidth = getClientWidth();
            float f17 = this.mFirstOffset * clientWidth;
            float f18 = this.mLastOffset * clientWidth;
            ItemInfo itemInfo = this.mItems.get(0);
            ItemInfo itemInfo2 = this.mItems.get(r4.size() - 1);
            if (itemInfo.position != 0) {
                f17 = itemInfo.offset * clientWidth;
            }
            if (itemInfo2.position != this.mAdapter.getCount() - 1) {
                f18 = itemInfo2.offset * clientWidth;
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
        float f16 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.mMinimumVelocity = (int) (400.0f * f16);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setEdgeEffectEnabled(false);
        this.mFlingDistance = (int) (25.0f * f16);
        this.mCloseEnough = (int) (2.0f * f16);
        this.mDefaultGutterSize = (int) (f16 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
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
                if (f16 <= scrollX + r2) {
                    i17++;
                    f18 = f17;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
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
            if (action != 0) {
                if (action != 2) {
                    if (action == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                } else {
                    int i3 = this.mActivePointerId;
                    if (i3 != -1) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i3);
                        float x16 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                        float f17 = x16 - this.mLastMotionX;
                        float abs = Math.abs(f17);
                        float y16 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                        float abs2 = Math.abs(y16 - this.mInitialMotionY);
                        if (f17 != 0.0f && !isGutterDrag(this.mLastMotionX, f17) && canScroll(this, false, (int) f17, (int) x16, (int) y16)) {
                            this.mLastMotionX = x16;
                            this.mLastMotionY = y16;
                            this.mIsUnableToDrag = true;
                            return false;
                        }
                        int i16 = this.mTouchSlop;
                        if (abs > i16 && abs * 0.5f > abs2) {
                            this.mIsBeingDragged = true;
                            setScrollState(1);
                            if (f17 > 0.0f) {
                                f16 = this.mInitialMotionX + this.mTouchSlop;
                            } else {
                                f16 = this.mInitialMotionX - this.mTouchSlop;
                            }
                            this.mLastMotionX = f16;
                            this.mLastMotionY = y16;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > i16) {
                            this.mIsUnableToDrag = true;
                        }
                        if (this.mIsBeingDragged && performDrag(x16)) {
                            ViewCompat.postInvalidateOnAnimation(this);
                        }
                    }
                }
            } else {
                float x17 = motionEvent.getX();
                this.mInitialMotionX = x17;
                this.mLastMotionX = x17;
                float y17 = motionEvent.getY();
                this.mInitialMotionY = y17;
                this.mLastMotionY = y17;
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
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        boolean z17;
        ItemInfo infoForChild;
        int max;
        int i19;
        int max2;
        int i26;
        int childCount = getChildCount();
        int i27 = i17 - i3;
        int i28 = i18 - i16;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i29 = 0;
        for (int i36 = 0; i36 < childCount; i36++) {
            View childAt = getChildAt(i36);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i37 = layoutParams.gravity;
                    int i38 = i37 & 7;
                    int i39 = i37 & 112;
                    if (i38 != 1) {
                        if (i38 != 3) {
                            if (i38 != 5) {
                                i19 = paddingLeft;
                            } else {
                                max = (i27 - paddingRight) - childAt.getMeasuredWidth();
                                paddingRight += childAt.getMeasuredWidth();
                            }
                        } else {
                            i19 = childAt.getMeasuredWidth() + paddingLeft;
                        }
                        if (i39 == 16) {
                            if (i39 != 48) {
                                if (i39 != 80) {
                                    i26 = paddingTop;
                                } else {
                                    max2 = (i28 - paddingBottom) - childAt.getMeasuredHeight();
                                    paddingBottom += childAt.getMeasuredHeight();
                                }
                            } else {
                                i26 = childAt.getMeasuredHeight() + paddingTop;
                            }
                            int i46 = paddingLeft + scrollX;
                            childAt.layout(i46, paddingTop, childAt.getMeasuredWidth() + i46, paddingTop + childAt.getMeasuredHeight());
                            i29++;
                            paddingTop = i26;
                            paddingLeft = i19;
                        } else {
                            max2 = Math.max((i28 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i47 = max2;
                        i26 = paddingTop;
                        paddingTop = i47;
                        int i462 = paddingLeft + scrollX;
                        childAt.layout(i462, paddingTop, childAt.getMeasuredWidth() + i462, paddingTop + childAt.getMeasuredHeight());
                        i29++;
                        paddingTop = i26;
                        paddingLeft = i19;
                    } else {
                        max = Math.max((i27 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i48 = max;
                    i19 = paddingLeft;
                    paddingLeft = i48;
                    if (i39 == 16) {
                    }
                    int i472 = max2;
                    i26 = paddingTop;
                    paddingTop = i472;
                    int i4622 = paddingLeft + scrollX;
                    childAt.layout(i4622, paddingTop, childAt.getMeasuredWidth() + i4622, paddingTop + childAt.getMeasuredHeight());
                    i29++;
                    paddingTop = i26;
                    paddingLeft = i19;
                }
            }
        }
        int i49 = (i27 - paddingLeft) - paddingRight;
        for (int i56 = 0; i56 < childCount; i56++) {
            View childAt2 = getChildAt(i56);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.isDecor && (infoForChild = infoForChild(childAt2)) != null) {
                    float f16 = i49;
                    int i57 = ((int) (infoForChild.offset * f16)) + paddingLeft;
                    if (layoutParams2.needsMeasure) {
                        layoutParams2.needsMeasure = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f16 * layoutParams2.widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec((i28 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i57, paddingTop, childAt2.getMeasuredWidth() + i57, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.mTopPageBounds = paddingTop;
        this.mBottomPageBounds = i28 - paddingBottom;
        this.mDecorChildCount = i29;
        if (this.mFirstLayout) {
            z17 = false;
            scrollToItem(this.mCurItem, false, 0, false);
        } else {
            z17 = false;
        }
        this.mFirstLayout = z17;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        boolean z16;
        int i17;
        setMeasuredDimension(View.getDefaultSize(0, i3), View.getDefaultSize(0, i16));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i18 = 0;
        while (true) {
            boolean z17 = true;
            int i19 = 1073741824;
            if (i18 >= childCount) {
                break;
            }
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.isDecor) {
                int i26 = layoutParams2.gravity;
                int i27 = i26 & 7;
                int i28 = i26 & 112;
                if (i28 != 48 && i28 != 80) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (i27 != 3 && i27 != 5) {
                    z17 = false;
                }
                int i29 = Integer.MIN_VALUE;
                if (z16) {
                    i17 = Integer.MIN_VALUE;
                    i29 = 1073741824;
                } else if (z17) {
                    i17 = 1073741824;
                } else {
                    i17 = Integer.MIN_VALUE;
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
                if (i37 != -2) {
                    if (i37 == -1) {
                        i37 = measuredHeight;
                    }
                } else {
                    i37 = measuredHeight;
                    i19 = i17;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i36, i29), View.MeasureSpec.makeMeasureSpec(i37, i19));
                if (z16) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z17) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i18++;
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i38 = 0; i38 < childCount2; i38++) {
            View childAt2 = getChildAt(i38);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.isDecor)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * layoutParams.widthFactor), 1073741824), this.mChildHeightMeasureSpec);
            }
        }
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
                    if (i19 != 1) {
                        if (i19 != 3) {
                            if (i19 != 5) {
                                i17 = paddingLeft;
                            } else {
                                max = (width - paddingRight) - childAt.getMeasuredWidth();
                                paddingRight += childAt.getMeasuredWidth();
                            }
                        } else {
                            i17 = childAt.getWidth() + paddingLeft;
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = i17;
                    } else {
                        max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
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
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i27 = 0; i27 < size; i27++) {
                OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(i27);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(i3, f16, i16);
                }
            }
        }
        OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListener;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageScrolled(i3, f16, i16);
        }
        OnPageChangeListener onPageChangeListener3 = this.mInternalPageChangeListener;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageScrolled(i3, f16, i16);
        }
        if (this.mPageTransformer != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i28 = 0; i28 < childCount2; i28++) {
                View childAt2 = getChildAt(i28);
                if (!((LayoutParams) childAt2.getLayoutParams()).isDecor) {
                    this.mPageTransformer.transformPage(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
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
        float f16;
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
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                onSecondaryPointerUp(motionEvent);
                                this.mLastMotionX = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId));
                            }
                        } else {
                            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                            this.mLastMotionX = MotionEventCompat.getX(motionEvent, actionIndex);
                            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                        }
                    } else if (this.mIsBeingDragged) {
                        scrollToItem(this.mCurItem, true, 0, false);
                        this.mActivePointerId = -1;
                        endDrag();
                        if (this.mEdgeEffectEnabled) {
                            onRelease = this.mLeftEdge.onRelease();
                            onRelease2 = this.mRightEdge.onRelease();
                            z16 = onRelease | onRelease2;
                        }
                    }
                } else {
                    if (!this.mIsBeingDragged) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                        float x16 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                        float abs = Math.abs(x16 - this.mLastMotionX);
                        float y16 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                        float abs2 = Math.abs(y16 - this.mLastMotionY);
                        int i3 = this.mTouchSlop;
                        if (abs > i3 && abs > abs2) {
                            this.mIsBeingDragged = true;
                            float f17 = this.mInitialMotionX;
                            if (x16 - f17 > 0.0f) {
                                f16 = f17 + i3;
                            } else {
                                f16 = f17 - i3;
                            }
                            this.mLastMotionX = f16;
                            this.mLastMotionY = y16;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                        }
                    }
                    if (this.mIsBeingDragged) {
                        z16 = false | performDrag(MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId)));
                    }
                }
            } else if (this.mIsBeingDragged) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((scrollX / clientWidth) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor, xVelocity, (int) (MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
                this.mActivePointerId = -1;
                endDrag();
                if (this.mEdgeEffectEnabled) {
                    onRelease = this.mLeftEdge.onRelease();
                    onRelease2 = this.mRightEdge.onRelease();
                    z16 = onRelease | onRelease2;
                }
            }
        } else {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            populate();
            this.mIsBeingDragged = true;
            setScrollState(1);
            float x17 = motionEvent.getX();
            this.mInitialMotionX = x17;
            this.mLastMotionX = x17;
            float y17 = motionEvent.getY();
            this.mInitialMotionY = y17;
            this.mLastMotionY = y17;
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
        }
        if (z16) {
            ViewCompat.postInvalidateOnAnimation(this);
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
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null && this.mCurItem < pagerAdapter.getCount() - 1) {
            setCurrentItem(this.mCurItem + 1, true);
            return true;
        }
        return false;
    }

    void populate() {
        populate(this.mCurItem);
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(onPageChangeListener);
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

    public void setAdapter(PagerAdapter pagerAdapter) {
        EventCollector.getInstance().onSetViewPagerAdapter(this);
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
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.mAdapter;
        this.mAdapter = pagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (pagerAdapter != null) {
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
        if (onAdapterChangeListener != null && pagerAdapter3 != pagerAdapter) {
            onAdapterChangeListener.onAdapterChanged(pagerAdapter3, pagerAdapter);
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z16) {
        if (this.mSetChildrenDrawingOrderEnabled == null) {
            try {
                this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e16) {
                Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e16);
            }
        }
        try {
            this.mSetChildrenDrawingOrderEnabled.invoke(this, Boolean.valueOf(z16));
        } catch (Exception e17) {
            Log.e("ViewPager", "Error changing children drawing order", e17);
        }
    }

    public void setCurrentItem(int i3) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i3, !this.mFirstLayout, false);
    }

    void setCurrentItemInternal(int i3, boolean z16, boolean z17) {
        setCurrentItemInternal(i3, z16, z17, 0);
    }

    void setEdgeEffectEnabled(boolean z16) {
        if (this.mEdgeEffectEnabled != z16) {
            if (z16) {
                Context context = getContext();
                this.mLeftEdge = new EdgeEffectCompat(context);
                this.mRightEdge = new EdgeEffectCompat(context);
            } else {
                this.mLeftEdge = null;
                this.mRightEdge = null;
            }
            this.mEdgeEffectEnabled = z16;
        }
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
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

    public void setPageTransformer(boolean z16, PageTransformer pageTransformer) {
        boolean z17;
        boolean z18;
        boolean z19;
        int i3 = 1;
        if (pageTransformer != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.mPageTransformer != null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 != z18) {
            z19 = true;
        } else {
            z19 = false;
        }
        this.mPageTransformer = pageTransformer;
        setChildrenDrawingOrderEnabledCompat(z17);
        if (z17) {
            if (z16) {
                i3 = 2;
            }
            this.mDrawingOrder = i3;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z19) {
            populate();
        }
    }

    void smoothScrollTo(int i3, int i16) {
        smoothScrollTo(i3, i16, 0);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.mMarginDrawable) {
            return false;
        }
        return true;
    }

    /* loaded from: classes.dex */
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
    
        if (r10 == r11) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void populate(int i3) {
        int i16;
        ItemInfo itemInfo;
        String hexString;
        ItemInfo itemInfo2;
        ItemInfo infoForChild;
        ItemInfo itemInfo3;
        int i17 = this.mCurItem;
        if (i17 != i3) {
            i16 = i17 < i3 ? 66 : 17;
            itemInfo = infoForPosition(i17);
            this.mCurItem = i3;
        } else {
            i16 = 2;
            itemInfo = null;
        }
        if (this.mAdapter == null) {
            sortChildDrawingOrderPrivate();
            return;
        }
        if (this.mPopulatePending) {
            sortChildDrawingOrderPrivate();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        this.mAdapter.startUpdate((ViewGroup) this);
        int i18 = this.mOffscreenPageLimit;
        int max = Math.max(0, this.mCurItem - i18);
        int count = this.mAdapter.getCount();
        int min = Math.min(count - 1, this.mCurItem + i18);
        if (count == this.mExpectedAdapterCount) {
            int i19 = 0;
            while (true) {
                if (i19 >= this.mItems.size()) {
                    break;
                }
                itemInfo2 = this.mItems.get(i19);
                int i26 = itemInfo2.position;
                int i27 = this.mCurItem;
                if (i26 < i27) {
                    i19++;
                }
            }
            itemInfo2 = null;
            if (itemInfo2 == null && count > 0) {
                itemInfo2 = addNewItem(this.mCurItem, i19);
            }
            if (itemInfo2 != null) {
                int i28 = i19 - 1;
                ItemInfo itemInfo4 = i28 >= 0 ? this.mItems.get(i28) : null;
                float paddingLeft = (2.0f - itemInfo2.widthFactor) + (getPaddingLeft() / getClientWidth());
                float f16 = 0.0f;
                for (int i29 = this.mCurItem - 1; i29 >= 0; i29--) {
                    if (f16 >= paddingLeft && i29 < max) {
                        if (itemInfo4 == null) {
                            break;
                        }
                        if (i29 == itemInfo4.position && !itemInfo4.scrolling) {
                            this.mItems.remove(i28);
                            this.mAdapter.destroyItem((ViewGroup) this, i29, itemInfo4.object);
                            i28--;
                            i19--;
                            if (i28 >= 0) {
                                itemInfo3 = this.mItems.get(i28);
                                itemInfo4 = itemInfo3;
                            }
                            itemInfo3 = null;
                            itemInfo4 = itemInfo3;
                        }
                    } else if (itemInfo4 != null && i29 == itemInfo4.position) {
                        f16 += itemInfo4.widthFactor;
                        i28--;
                        if (i28 >= 0) {
                            itemInfo3 = this.mItems.get(i28);
                            itemInfo4 = itemInfo3;
                        }
                        itemInfo3 = null;
                        itemInfo4 = itemInfo3;
                    } else {
                        f16 += addNewItem(i29, i28 + 1).widthFactor;
                        i19++;
                        if (i28 >= 0) {
                            itemInfo3 = this.mItems.get(i28);
                            itemInfo4 = itemInfo3;
                        }
                        itemInfo3 = null;
                        itemInfo4 = itemInfo3;
                    }
                }
                float f17 = itemInfo2.widthFactor;
                int i36 = i19 + 1;
                if (f17 < 2.0f) {
                    ItemInfo itemInfo5 = i36 < this.mItems.size() ? this.mItems.get(i36) : null;
                    float paddingRight = (getPaddingRight() / getClientWidth()) + 2.0f;
                    int i37 = this.mCurItem;
                    while (true) {
                        i37++;
                        if (i37 >= count) {
                            break;
                        }
                        if (f17 >= paddingRight && i37 > min) {
                            if (itemInfo5 == null) {
                                break;
                            }
                            if (i37 == itemInfo5.position && !itemInfo5.scrolling) {
                                this.mItems.remove(i36);
                                this.mAdapter.destroyItem((ViewGroup) this, i37, itemInfo5.object);
                                if (i36 < this.mItems.size()) {
                                    itemInfo5 = this.mItems.get(i36);
                                }
                            }
                        } else if (itemInfo5 != null && i37 == itemInfo5.position) {
                            f17 += itemInfo5.widthFactor;
                            i36++;
                            if (i36 < this.mItems.size()) {
                                itemInfo5 = this.mItems.get(i36);
                            }
                        } else {
                            ItemInfo addNewItem = addNewItem(i37, i36);
                            i36++;
                            f17 += addNewItem.widthFactor;
                            itemInfo5 = i36 < this.mItems.size() ? this.mItems.get(i36) : null;
                        }
                    }
                }
                calculatePageOffsets(itemInfo2, i19, itemInfo);
            }
            this.mAdapter.setPrimaryItem((ViewGroup) this, this.mCurItem, itemInfo2 != null ? itemInfo2.object : null);
            this.mAdapter.finishUpdate((ViewGroup) this);
            int childCount = getChildCount();
            for (int i38 = 0; i38 < childCount; i38++) {
                View childAt = getChildAt(i38);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.childIndex = i38;
                if (!layoutParams.isDecor && layoutParams.widthFactor == 0.0f && (infoForChild = infoForChild(childAt)) != null) {
                    layoutParams.widthFactor = infoForChild.widthFactor;
                    layoutParams.position = infoForChild.position;
                }
            }
            sortChildDrawingOrderPrivate();
            if (hasFocus()) {
                View findFocus = findFocus();
                ItemInfo infoForAnyChild = findFocus != null ? infoForAnyChild(findFocus) : null;
                if (infoForAnyChild == null || infoForAnyChild.position != this.mCurItem) {
                    for (int i39 = 0; i39 < getChildCount(); i39++) {
                        View childAt2 = getChildAt(i39);
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
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + count + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
    }

    void setCurrentItemInternal(int i3, boolean z16, boolean z17, int i16) {
        OnPageChangeListener onPageChangeListener;
        OnPageChangeListener onPageChangeListener2;
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null && pagerAdapter.getCount() > 0) {
            if (!z17 && this.mCurItem == i3 && this.mItems.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i3 < 0) {
                i3 = 0;
            } else if (i3 >= this.mAdapter.getCount()) {
                i3 = this.mAdapter.getCount() - 1;
            }
            int i17 = this.mOffscreenPageLimit;
            int i18 = this.mCurItem;
            if (i3 > i18 + i17 || i3 < i18 - i17) {
                for (int i19 = 0; i19 < this.mItems.size(); i19++) {
                    this.mItems.get(i19).scrolling = true;
                }
            }
            boolean z18 = this.mCurItem != i3;
            if (this.mFirstLayout) {
                this.mCurItem = i3;
                if (z18 && (onPageChangeListener2 = this.mOnPageChangeListener) != null) {
                    onPageChangeListener2.onPageSelected(i3);
                }
                if (z18 && this.mOnPageChangeListeners != null) {
                    dispatchOnPageSelected(i3);
                }
                if (z18 && (onPageChangeListener = this.mInternalPageChangeListener) != null) {
                    onPageChangeListener.onPageSelected(i3);
                }
                requestLayout();
                return;
            }
            populate(i3);
            scrollToItem(i3, z16, i16, z18);
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
        int clientWidth = getClientWidth();
        int i26 = clientWidth / 2;
        float f16 = clientWidth;
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

    public void setCurrentItem(int i3, boolean z16) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i3, z16, false);
    }

    public void setPageMarginDrawable(int i3) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i3));
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItems = new ArrayList<>();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new Runnable() { // from class: android.support.v4.view.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    /* loaded from: classes.dex */
    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }
}
