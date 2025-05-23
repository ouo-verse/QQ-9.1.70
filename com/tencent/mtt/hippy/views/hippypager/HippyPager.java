package com.tencent.mtt.hippy.views.hippypager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.hippypager.transform.VerticalPageTransformer;
import com.tencent.mtt.hippy.views.viewpager.HippyViewPagerItem;
import com.tencent.mtt.supportui.views.ScrollChecker;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes20.dex */
public class HippyPager extends ViewPager implements HippyViewBase {
    private static final String TAG = "HippyViewPager";
    private Promise callBackPromise;
    private boolean dataUpdated;
    private boolean firstUpdateChild;
    private NativeGestureDispatcher gestureDispatcher;
    private final Handler handler;
    private boolean ignoreCheck;
    private boolean isFirstLayoutSucceed;
    private boolean isVertical;
    private Runnable measureAndLayout;
    private PageSelectNotifier pageSelectNotifier;
    private boolean scrollEnabled;
    private Scroller scroller;

    public HippyPager(Context context) {
        super(context);
        this.handler = new Handler(Looper.getMainLooper());
        this.scrollEnabled = true;
        this.firstUpdateChild = true;
        this.isVertical = false;
        this.dataUpdated = false;
        this.isFirstLayoutSucceed = false;
        this.pageSelectNotifier = new PageSelectNotifier();
        this.measureAndLayout = new Runnable() { // from class: com.tencent.mtt.hippy.views.hippypager.a
            @Override // java.lang.Runnable
            public final void run() {
                HippyPager.this.lambda$new$0();
            }
        };
        init();
    }

    private void init() {
        addOnPageChangeListener(new HippyPagerPageChangeListener(this));
        setAdapter(createAdapter());
        initViewPager();
        initScroller();
    }

    private void initScroller() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            this.scroller = (Scroller) declaredField.get(this);
        } catch (IllegalAccessException | NoSuchFieldException e16) {
            e16.printStackTrace();
        }
    }

    private void invokeSetIsUnableToDrag(boolean z16) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mIsUnableToDrag");
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.valueOf(z16));
        } catch (IllegalAccessException | NoSuchFieldException e16) {
            e16.printStackTrace();
        }
    }

    private void invokeSetScrollState(int i3) {
        try {
            Method declaredMethod = ViewPager.class.getDeclaredMethod("setScrollState", Integer.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, Integer.valueOf(i3));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void invokeSetScrollingCacheEnabled(boolean z16) {
        try {
            Method declaredMethod = ViewPager.class.getDeclaredMethod("setScrollingCacheEnabled", Boolean.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, Boolean.valueOf(z16));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        if (readyToLayout()) {
            measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
            layout(getLeft(), getTop(), getRight(), getBottom());
        }
    }

    private boolean readyToLayout() {
        if (this.dataUpdated && getWindowToken() != null) {
            return true;
        }
        return false;
    }

    private void resetIgnoreCheck(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.ignoreCheck = false;
        }
    }

    private void setDefaultItem(int i3) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mCurItem");
            declaredField.setAccessible(true);
            declaredField.setInt(this, i3);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void setFirstLayout(boolean z16) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mFirstLayout");
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.valueOf(z16));
        } catch (IllegalAccessException | NoSuchFieldException e16) {
            e16.printStackTrace();
        }
    }

    private void stopAnimationAndScrollToFinal() {
        if (!this.scroller.isFinished()) {
            invokeSetScrollingCacheEnabled(false);
            Scroller scroller = this.scroller;
            if (scroller != null) {
                scroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.scroller.getCurrX();
                int currY = this.scroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                }
            }
            invokeSetScrollState(0);
        }
    }

    private MotionEvent swapXY(MotionEvent motionEvent) {
        float width = getWidth();
        float height = getHeight();
        motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
        return motionEvent;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void addOnPageChangeListener(@NonNull ViewPager.OnPageChangeListener onPageChangeListener) {
        super.addOnPageChangeListener(onPageChangeListener);
        this.pageSelectNotifier.addOnPageChangeListener(onPageChangeListener);
    }

    public void addViewToAdapter(HippyViewPagerItem hippyViewPagerItem, int i3) {
        HippyPagerAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.addView(hippyViewPagerItem, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager
    public boolean canScroll(View view, boolean z16, int i3, int i16, int i17) {
        if (this.ignoreCheck) {
            return false;
        }
        if (!ScrollChecker.canScroll(view, z16, this.isVertical, i3, i16, i17) && !super.canScroll(view, z16, i3, i16, i17)) {
            return false;
        }
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i3) {
        if (!this.scrollEnabled) {
            return false;
        }
        return super.canScrollHorizontally(i3);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i3) {
        if (!this.scrollEnabled) {
            return false;
        }
        return super.canScrollVertically(i3);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void clearOnPageChangeListeners() {
        super.clearOnPageChangeListeners();
        this.pageSelectNotifier.clearOnPageChangeListeners();
    }

    protected HippyPagerAdapter createAdapter() {
        return new HippyPagerAdapter(this);
    }

    protected int getAdapterViewSize() {
        HippyPagerAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getItemViewSize();
        }
        return 0;
    }

    public Promise getCallBackPromise() {
        return this.callBackPromise;
    }

    public Object getCurrentItemView() {
        if (getAdapter() != null) {
            return getAdapter().getCurrentItemObj();
        }
        return null;
    }

    public int getCurrentPage() {
        return getCurrentItem();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return this.gestureDispatcher;
    }

    public int getPageCount() {
        if (getAdapter() == null) {
            return 0;
        }
        return getAdapter().getF373114d();
    }

    public View getViewFromAdapter(int i3) {
        HippyPagerAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getViewAt(i3);
        }
        return null;
    }

    protected void initViewPager() {
        if (this.isVertical) {
            setPageTransformer(true, new VerticalPageTransformer());
            setOverScrollMode(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setFirstLayout(false);
        if (!this.isFirstLayoutSucceed) {
            triggerRequestLayout();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        resetIgnoreCheck(motionEvent);
        if (!this.scrollEnabled) {
            return false;
        }
        if (this.isVertical) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(swapXY(motionEvent));
            swapXY(motionEvent);
            return onInterceptTouchEvent;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.isFirstLayoutSucceed = readyToLayout();
    }

    public boolean onOverScroll(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        if (this.isVertical) {
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
        invokeSetIsUnableToDrag(false);
        this.ignoreCheck = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        resetIgnoreCheck(motionEvent);
        if (!this.scrollEnabled) {
            return false;
        }
        if (this.isVertical) {
            return super.onTouchEvent(swapXY(motionEvent));
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void removeOnPageChangeListener(@NonNull ViewPager.OnPageChangeListener onPageChangeListener) {
        super.removeOnPageChangeListener(onPageChangeListener);
        this.pageSelectNotifier.removeOnPageChangeListener(onPageChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeViewFromAdapter(HippyViewPagerItem hippyViewPagerItem) {
        HippyPagerAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.removeView(hippyViewPagerItem);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        triggerRequestLayout();
    }

    public void setCallBackPromise(Promise promise) {
        this.callBackPromise = promise;
    }

    public void setChildCountAndUpdate(int i3) {
        LogUtils.d(TAG, "doUpdateInternal: " + hashCode() + ", childCount=" + i3);
        this.dataUpdated = true;
        getAdapter().setChildSize(i3);
        getAdapter().notifyDataSetChanged();
        triggerRequestLayout();
        if (this.firstUpdateChild) {
            this.pageSelectNotifier.notifyPageSelected(getCurrentItem());
            this.firstUpdateChild = false;
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
        this.gestureDispatcher = nativeGestureDispatcher;
    }

    public void setInitialPageIndex(int i3) {
        LogUtils.d(TAG, getClass().getName() + " setInitialPageIndex=" + i3);
        setCurrentItem(i3);
        setDefaultItem(i3);
    }

    public void setOverflow(String str) {
        boolean z16;
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            if (!str.equals("hidden")) {
                if (str.equals(NodeProps.VISIBLE)) {
                    z16 = false;
                }
            } else {
                z16 = true;
            }
            setClipChildren(z16);
        }
        invalidate();
    }

    public void setScrollEnabled(boolean z16) {
        this.scrollEnabled = z16;
    }

    public void switchToPage(int i3, boolean z16) {
        if (getAdapter() != null && getAdapter().getF373114d() != 0) {
            if (getCurrentItem() != i3) {
                stopAnimationAndScrollToFinal();
                setCurrentItem(i3, z16);
                return;
            } else {
                if (!this.firstUpdateChild) {
                    this.pageSelectNotifier.notifyPageSelected(i3);
                    return;
                }
                return;
            }
        }
        setDefaultItem(i3);
    }

    public void triggerRequestLayout() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this.measureAndLayout);
            this.handler.post(this.measureAndLayout);
        }
    }

    public HippyPager(Context context, boolean z16) {
        super(context);
        this.handler = new Handler(Looper.getMainLooper());
        this.scrollEnabled = true;
        this.firstUpdateChild = true;
        this.isVertical = false;
        this.dataUpdated = false;
        this.isFirstLayoutSucceed = false;
        this.pageSelectNotifier = new PageSelectNotifier();
        this.measureAndLayout = new Runnable() { // from class: com.tencent.mtt.hippy.views.hippypager.a
            @Override // java.lang.Runnable
            public final void run() {
                HippyPager.this.lambda$new$0();
            }
        };
        this.isVertical = z16;
        init();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public HippyPagerAdapter getAdapter() {
        return (HippyPagerAdapter) super.getAdapter();
    }
}
