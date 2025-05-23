package com.tencent.mtt.hippy.views.viewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.I18nUtil;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.supportui.views.viewpager.ViewPager;

/* loaded from: classes20.dex */
public class HippyViewPager extends ViewPager implements HippyViewBase {
    private static final String TAG = "HippyViewPager";
    private int mAxes;
    private Promise mCallBackPromise;
    private boolean mCaptured;
    private boolean mFirstUpdateChild;
    private NativeGestureDispatcher mGestureDispatcher;
    private final Handler mHandler;
    private final Runnable mMeasureAndLayout;
    private int mNestedScrollOffset;
    private ViewPagerPageChangeListener mPageListener;
    private final boolean mReNotifyOnAttach;
    private final int[] mScrollOffsetPair;

    public HippyViewPager(Context context) {
        super(context);
        this.mMeasureAndLayout = new Runnable() { // from class: com.tencent.mtt.hippy.views.viewpager.HippyViewPager.1
            @Override // java.lang.Runnable
            public void run() {
                HippyViewPager hippyViewPager = HippyViewPager.this;
                hippyViewPager.measure(View.MeasureSpec.makeMeasureSpec(hippyViewPager.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(HippyViewPager.this.getHeight(), 1073741824));
                HippyViewPager hippyViewPager2 = HippyViewPager.this;
                hippyViewPager2.layout(hippyViewPager2.getLeft(), HippyViewPager.this.getTop(), HippyViewPager.this.getRight(), HippyViewPager.this.getBottom());
            }
        };
        this.mFirstUpdateChild = true;
        this.mReNotifyOnAttach = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mCaptured = false;
        this.mScrollOffsetPair = new int[2];
        this.mNestedScrollOffset = 0;
        init(context, false);
    }

    private void init(Context context, boolean z16) {
        int i3 = 1;
        setCallPageChangedOnFirstLayout(true);
        setEnableReLayoutOnAttachToWindow(false);
        ViewPagerPageChangeListener viewPagerPageChangeListener = new ViewPagerPageChangeListener(this);
        this.mPageListener = viewPagerPageChangeListener;
        setOnPageChangeListener(viewPagerPageChangeListener);
        setAdapter(createAdapter(context));
        setLeftDragOutSizeEnabled(false);
        setRightDragOutSizeEnabled(false);
        setNestedScrollingEnabled(true);
        if (z16) {
            i3 = 2;
        }
        this.mAxes = i3;
        if (I18nUtil.isRTL()) {
            setRotationY(180.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addViewToAdapter(HippyViewPagerItem hippyViewPagerItem, int i3) {
        HippyViewPagerAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.addView(hippyViewPagerItem, i3);
        }
    }

    protected HippyViewPagerAdapter createAdapter(Context context) {
        return new HippyViewPagerAdapter((HippyInstanceContext) context, this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (hasNestedScrollingParent() && this.mNestedScrollOffset != 0) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            if (this.mAxes == 1) {
                obtain.offsetLocation(this.mNestedScrollOffset, 0.0f);
            } else {
                obtain.offsetLocation(0.0f, this.mNestedScrollOffset);
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(obtain);
            obtain.recycle();
            return dispatchTouchEvent;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.mtt.supportui.views.viewpager.ViewPager
    public void fakeDragBy(float f16) {
        if (isFakeDragging() || beginFakeDrag()) {
            super.fakeDragBy(f16);
        }
    }

    @Override // com.tencent.mtt.supportui.views.viewpager.ViewPager
    public HippyViewPagerAdapter getAdapter() {
        return (HippyViewPagerAdapter) super.getAdapter();
    }

    protected int getAdapterViewSize() {
        HippyViewPagerAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getItemViewSize();
        }
        return 0;
    }

    public Promise getCallBackPromise() {
        return this.mCallBackPromise;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return this.mGestureDispatcher;
    }

    public View getViewFromAdapter(int i3) {
        HippyViewPagerAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getViewAt(i3);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.viewpager.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogUtils.d(TAG, "onAttachedToWindow: " + hashCode() + ", childCount=" + getChildCount() + ", repopulate=" + this.mNeedRepopulate + ", renotifyOnAttach=false");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.viewpager.ViewPager, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtils.d(TAG, "onDetachedFromWindow: " + hashCode() + ", childCount=" + getChildCount() + ", repopulate=" + this.mNeedRepopulate + ", renotifyOnAttach=false");
    }

    @Override // com.tencent.mtt.supportui.views.viewpager.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isScrollEnabled() || getNestedScrollAxes() != 0) {
            return false;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1 || action == 3) {
                stopNestedScroll();
            }
        } else {
            this.mNestedScrollOffset = 0;
            startNestedScroll(this.mAxes);
        }
        return onInterceptTouchEvent;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f16, float f17) {
        return this.mCaptured;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(@NonNull View view, int i3, int i16, @NonNull int[] iArr) {
        if (this.mCaptured) {
            if (this.mAxes == 1) {
                fakeDragBy(-i3);
                iArr[0] = iArr[0] + i3;
                return;
            } else {
                fakeDragBy(-i16);
                iArr[1] = iArr[1] + i16;
                return;
            }
        }
        if (i3 != 0 || i16 != 0) {
            dispatchNestedPreScroll(i3, i16, iArr, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i3, int i16, int i17, int i18) {
        int i19;
        boolean canScrollVertically;
        if (!this.mCaptured) {
            int i26 = this.mAxes;
            if (i26 == 1 && i17 != 0) {
                canScrollVertically = canScrollHorizontally(i17);
            } else if (i26 == 2 && i18 != 0) {
                canScrollVertically = canScrollVertically(i18);
            }
            this.mCaptured = canScrollVertically;
        }
        if (this.mCaptured) {
            if (this.mAxes == 1) {
                i19 = -i17;
            } else {
                i19 = -i18;
            }
            fakeDragBy(i19);
            return;
        }
        if (i17 != 0 || i18 != 0) {
            dispatchNestedScroll(i3, i16, i17, i18, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i3) {
        super.onNestedScrollAccepted(view, view2, i3);
        startNestedScroll(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.viewpager.ViewPager
    public boolean onStartDrag(boolean z16) {
        if (super.onStartDrag(z16)) {
            this.mCaptured = true;
            return true;
        }
        return hasNestedScrollingParent();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i3) {
        if (!isScrollEnabled() || (this.mAxes & i3) == 0) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (isFakeDragging()) {
            endFakeDrag();
        }
        this.mCaptured = false;
        stopNestedScroll();
    }

    @Override // com.tencent.mtt.supportui.views.viewpager.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isScrollEnabled()) {
            return false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (onTouchEvent) {
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action == 1 || action == 3) {
                    this.mCaptured = false;
                    stopNestedScroll();
                }
            } else {
                this.mNestedScrollOffset = 0;
                startNestedScroll(this.mAxes);
            }
        }
        return onTouchEvent;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (I18nUtil.isRTL()) {
            view.setRotationY(180.0f);
        }
        super.onViewAdded(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.viewpager.ViewPager
    public boolean performDrag(float f16) {
        boolean z16;
        int i3;
        int round;
        boolean verticalCanScroll;
        if (!this.mCaptured) {
            if (this.mAxes == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                round = 0;
                i3 = Math.round(this.mLastMotionX - f16);
            } else {
                i3 = 0;
                round = Math.round(this.mLastMotionY - f16);
            }
            if (i3 == 0 && round == 0) {
                return false;
            }
            if (dispatchNestedPreScroll(i3, round, null, this.mScrollOffsetPair)) {
                if (z16) {
                    this.mNestedScrollOffset += this.mScrollOffsetPair[0];
                    this.mLastMotionX = f16;
                } else {
                    this.mNestedScrollOffset += this.mScrollOffsetPair[1];
                    this.mLastMotionY = f16;
                }
                return false;
            }
            if (z16) {
                verticalCanScroll = horizontalCanScroll(i3);
            } else {
                verticalCanScroll = verticalCanScroll(round);
            }
            this.mCaptured = verticalCanScroll;
            if (!verticalCanScroll) {
                if (dispatchNestedScroll(0, 0, i3, round, this.mScrollOffsetPair)) {
                    if (z16) {
                        this.mNestedScrollOffset += this.mScrollOffsetPair[0];
                        this.mLastMotionX = f16;
                    } else {
                        this.mNestedScrollOffset += this.mScrollOffsetPair[1];
                        this.mLastMotionY = f16;
                    }
                }
                return false;
            }
        }
        return super.performDrag(f16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeViewFromAdapter(HippyViewPagerItem hippyViewPagerItem) {
        HippyViewPagerAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.removeView(hippyViewPagerItem);
        }
    }

    public void setCallBackPromise(Promise promise) {
        this.mCallBackPromise = promise;
    }

    public void setChildCountAndUpdate(int i3) {
        LogUtils.d(TAG, "doUpdateInternal: " + hashCode() + ", childCount=" + i3);
        if (this.mFirstUpdateChild) {
            setFirstLayoutParameter(true);
            this.mFirstUpdateChild = false;
        }
        getAdapter().setChildSize(i3);
        getAdapter().notifyDataSetChanged();
        triggerRequestLayout();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
        this.mGestureDispatcher = nativeGestureDispatcher;
    }

    public void setInitialPageIndex(int i3) {
        getAdapter().setInitPageIndex(i3);
    }

    public void switchToPage(int i3, boolean z16) {
        LogUtils.d(TAG, "switchToPage: " + hashCode() + ", item=" + i3 + ", animated=" + z16);
        if (getAdapter().getCount() == 0) {
            LogUtils.d(TAG, "switchToPage: getAdapter().getCount() == 0");
            return;
        }
        if (getCurrentItem() != i3) {
            if (isSettling()) {
                setScrollingCacheEnabled(false);
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                }
                setScrollState(0);
            }
            setCurrentItem(i3, z16);
            return;
        }
        if (!isFirstLayout()) {
            this.mPageListener.onPageSelected(i3);
        }
    }

    public void triggerRequestLayout() {
        this.mHandler.post(this.mMeasureAndLayout);
    }

    public HippyViewPager(Context context, boolean z16) {
        super(context, z16);
        this.mMeasureAndLayout = new Runnable() { // from class: com.tencent.mtt.hippy.views.viewpager.HippyViewPager.1
            @Override // java.lang.Runnable
            public void run() {
                HippyViewPager hippyViewPager = HippyViewPager.this;
                hippyViewPager.measure(View.MeasureSpec.makeMeasureSpec(hippyViewPager.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(HippyViewPager.this.getHeight(), 1073741824));
                HippyViewPager hippyViewPager2 = HippyViewPager.this;
                hippyViewPager2.layout(hippyViewPager2.getLeft(), HippyViewPager.this.getTop(), HippyViewPager.this.getRight(), HippyViewPager.this.getBottom());
            }
        };
        this.mFirstUpdateChild = true;
        this.mReNotifyOnAttach = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mCaptured = false;
        this.mScrollOffsetPair = new int[2];
        this.mNestedScrollOffset = 0;
        init(context, z16);
    }
}
