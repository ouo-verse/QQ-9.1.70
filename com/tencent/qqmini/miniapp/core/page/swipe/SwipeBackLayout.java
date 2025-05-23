package com.tencent.qqmini.miniapp.core.page.swipe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.miniapp.core.page.swipe.ViewDragHelper;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.TouchInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SwipeBackLayout extends FrameLayout {
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    private static Deque<TouchInfo> touchInfoList = new LinkedList();
    private int lastX;
    private int lastY;
    private boolean mAllowedSliding;
    private Callback mCallback;
    private View mCapturedView;
    private View mChildView;
    private int mContentHeight;
    protected View mContentView;
    private int mContentWidth;
    private long mDownTime;
    private int mDownX;
    private int mDownY;
    private boolean mEnable;
    private volatile boolean mIsClose;
    private int mLeftMoveDistance;
    protected PageGestureProxy mPageGuestProxy;
    private int mScrimColor;
    private float mScrimOpacity;
    private float mScrollPercent;
    private Drawable mShadowDrawable;
    private int mTouchSlop;
    private ViewDragHelper mViewDragHelper;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface Callback {
        void onMoveAppBrandToBack();

        void onSwipeFinish();
    }

    public SwipeBackLayout(Context context) {
        super(context);
        this.mAllowedSliding = false;
        this.mScrimColor = DEFAULT_SCRIM_COLOR;
        this.mEnable = true;
        init();
    }

    private void bringToBackground() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onMoveAppBrandToBack();
            resetCaptureViewState();
        }
    }

    private void drawScrim(Canvas canvas, View view) {
        int i3 = (this.mScrimColor & 16777215) | (((int) ((((-16777216) & r0) >>> 24) * this.mScrimOpacity)) << 24);
        canvas.clipRect(0, 0, view.getLeft(), getHeight());
        canvas.drawColor(i3);
    }

    private void drawShadow(Canvas canvas, View view) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        Drawable drawable = this.mShadowDrawable;
        drawable.setBounds(rect.left - drawable.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
        this.mShadowDrawable.draw(canvas);
    }

    public static List<TouchInfo> getTouchInfoList() {
        return new ArrayList(touchInfoList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleViewReleased(MotionEvent motionEvent) {
        if (motionEvent.getRawX() > this.mContentWidth / 2) {
            bringToBackground();
            this.mIsClose = true;
        } else {
            this.mViewDragHelper.settleCapturedViewAt(0, 0);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        this.mScrimOpacity = 1.0f - this.mScrollPercent;
        ViewDragHelper viewDragHelper = this.mViewDragHelper;
        if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        if (actionMasked == 0) {
            this.mDownTime = SystemClock.uptimeMillis();
            this.mDownX = x16;
            this.mDownY = y16;
        } else if (actionMasked == 1) {
            touchInfoList.offer(new TouchInfo(this.mDownX, this.mDownY, x16, y16, SystemClock.uptimeMillis() - this.mDownTime));
            while (touchInfoList.size() > 10) {
                touchInfoList.poll();
            }
            try {
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).updateTouchInfoList(new ArrayList<>(touchInfoList));
            } catch (Throwable th5) {
                QMLog.e("SwipeBackLayout", "dispatchTouchEvent-updateTouchInfoList-failed", th5);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        return super.drawChild(canvas, view, j3);
    }

    void init() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.swipe.SwipeBackLayout.1
            @Override // java.lang.Runnable
            public void run() {
                SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
                if (swipeBackLayout.mPageGuestProxy == null) {
                    swipeBackLayout.mPageGuestProxy = (PageGestureProxy) ProxyManager.get(PageGestureProxy.class);
                }
                PageGestureProxy pageGestureProxy = SwipeBackLayout.this.mPageGuestProxy;
                if (pageGestureProxy != null) {
                    pageGestureProxy.onPageWebViewInit();
                }
            }
        });
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() == 1) {
            this.mChildView = getChildAt(0);
            return;
        }
        throw new IllegalStateException("SwipeBackLayout can host only one direct child");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
    
        if (java.lang.Math.abs(r0 - r7.lastX) > java.lang.Math.abs(r2 - r7.lastY)) goto L20;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mEnable) {
            return false;
        }
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z16 = true;
        if (action != 0) {
            if (action != 1 && action == 2) {
            }
            z16 = false;
        } else {
            if (Math.abs(x16) >= DisplayUtil.getDensity(getContext()) * 30.0f) {
                z16 = false;
            }
            this.mAllowedSliding = z16;
        }
        this.lastX = x16;
        this.lastY = y16;
        if (!z16) {
            return false;
        }
        ViewDragHelper viewDragHelper = this.mViewDragHelper;
        if (viewDragHelper != null && this.mAllowedSliding) {
            return viewDragHelper.shouldInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.mContentWidth = this.mContentView.getMeasuredWidth();
        this.mContentHeight = this.mChildView.getMeasuredHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mEnable) {
            return false;
        }
        PageGestureProxy pageGestureProxy = this.mPageGuestProxy;
        if (pageGestureProxy != null && this.mAllowedSliding) {
            pageGestureProxy.onProcessTouchEvent(motionEvent);
        }
        ViewDragHelper viewDragHelper = this.mViewDragHelper;
        if (viewDragHelper != null && this.mAllowedSliding) {
            viewDragHelper.processTouchEvent(motionEvent);
            ViewCompat.postInvalidateOnAnimation(this);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void resetCaptureViewState() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.swipe.SwipeBackLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (SwipeBackLayout.this.mViewDragHelper != null && SwipeBackLayout.this.mCapturedView != null) {
                    SwipeBackLayout.this.mViewDragHelper.settleCapturedViewImmediately(SwipeBackLayout.this.mCapturedView, 0, 0);
                }
            }
        }, 200L);
    }

    public void setContentView(View view) {
        this.mContentView = view;
    }

    public void setScrollDirection(int i3) {
        ViewDragHelper viewDragHelper = this.mViewDragHelper;
        if (viewDragHelper != null) {
            viewDragHelper.setScrollDirection(i3);
        }
    }

    public void setSwipeBackCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setSwipeBackEnable(boolean z16) {
        this.mEnable = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setViewDragHelper(ViewGroup viewGroup, View view) {
        this.mChildView = view;
        ViewDragHelper create = ViewDragHelper.create(viewGroup, 1.0f, new ViewDragHelper.Callback() { // from class: com.tencent.qqmini.miniapp.core.page.swipe.SwipeBackLayout.2
            @Override // com.tencent.qqmini.miniapp.core.page.swipe.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View view2, int i3, int i16) {
                if (i3 < 0) {
                    return 0;
                }
                return Math.min(i3, SwipeBackLayout.this.mContentWidth);
            }

            @Override // com.tencent.qqmini.miniapp.core.page.swipe.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view2, int i3, int i16) {
                if (SwipeBackLayout.this.mViewDragHelper.getScrollDirction() != 2 || i3 < 0) {
                    return 0;
                }
                return Math.min(i3, SwipeBackLayout.this.mContentHeight);
            }

            @Override // com.tencent.qqmini.miniapp.core.page.swipe.ViewDragHelper.Callback
            public int getViewHorizontalDragRange(View view2) {
                return SwipeBackLayout.this.mContentWidth;
            }

            @Override // com.tencent.qqmini.miniapp.core.page.swipe.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View view2) {
                return SwipeBackLayout.this.mContentHeight;
            }

            @Override // com.tencent.qqmini.miniapp.core.page.swipe.ViewDragHelper.Callback
            public void onViewPositionChanged(View view2, int i3, int i16, int i17, int i18) {
                SwipeBackLayout.this.mScrollPercent = Math.abs(i3 / (r1.mChildView.getWidth() + SwipeBackLayout.this.mShadowDrawable.getIntrinsicWidth()));
                SwipeBackLayout.this.mLeftMoveDistance = i3;
                if (SwipeBackLayout.this.mIsClose && SwipeBackLayout.this.mLeftMoveDistance == SwipeBackLayout.this.mContentWidth && SwipeBackLayout.this.mCallback != null) {
                    SwipeBackLayout.this.mCallback.onSwipeFinish();
                }
            }

            @Override // com.tencent.qqmini.miniapp.core.page.swipe.ViewDragHelper.Callback
            public void onViewReleased(View view2, float f16, float f17, MotionEvent motionEvent) {
                SwipeBackLayout.this.mCapturedView = view2;
                if (SwipeBackLayout.this.mViewDragHelper.getScrollDirction() == 1) {
                    if (SwipeBackLayout.this.mLeftMoveDistance >= SwipeBackLayout.this.mContentWidth / 10) {
                        SwipeBackLayout.this.mIsClose = true;
                        SwipeBackLayout.this.mViewDragHelper.settleCapturedViewAt(SwipeBackLayout.this.mContentWidth, view2.getTop());
                    } else {
                        SwipeBackLayout.this.mViewDragHelper.settleCapturedViewAt(0, view2.getTop());
                    }
                }
                SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
                PageGestureProxy pageGestureProxy = swipeBackLayout.mPageGuestProxy;
                if (pageGestureProxy != null) {
                    if (pageGestureProxy.onViewReleasedAndNeedScrollOriginPosition(motionEvent)) {
                        SwipeBackLayout.this.mViewDragHelper.settleCapturedViewAt(0, 0);
                    } else if (SwipeBackLayout.this.mViewDragHelper.getScrollDirction() == 2) {
                        SwipeBackLayout.this.handleViewReleased(motionEvent);
                    }
                } else if (swipeBackLayout.mViewDragHelper.getScrollDirction() == 2) {
                    SwipeBackLayout.this.handleViewReleased(motionEvent);
                }
                SwipeBackLayout.this.invalidate();
            }

            @Override // com.tencent.qqmini.miniapp.core.page.swipe.ViewDragHelper.Callback
            public boolean tryCaptureView(View view2, int i3) {
                if (view2 == SwipeBackLayout.this.mChildView) {
                    return true;
                }
                return false;
            }
        });
        this.mViewDragHelper = create;
        create.setEdgeTrackingEnabled(1);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mShadowDrawable = getResources().getDrawable(R.drawable.mini_sdk_swipe_shadow_left);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAllowedSliding = false;
        this.mScrimColor = DEFAULT_SCRIM_COLOR;
        this.mEnable = true;
        init();
    }
}
