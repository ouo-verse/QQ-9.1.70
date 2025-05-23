package com.tencent.mobileqq.colornote.swipe;

import android.R;
import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SwipeBackLayout extends FrameLayout {
    protected static final int MSG_FINISH_ACTIVITY = 1;
    private static final String TAG = "SwipeBackLayout";
    public static int WEBVIEW_LEFT_SWIPE_SCOPE;
    protected boolean allowedSliding;
    protected int downX;
    protected int downY;
    private boolean isFinish;
    protected volatile boolean isFling;
    private boolean isScrolledRight;
    protected boolean isSilding;
    private boolean isStopped;
    public int leftSwipeScope;
    private b listener;
    private Activity mActivity;
    protected View mContentView;
    protected Context mContext;
    protected boolean mEnableSwipe;
    protected GestureDetector mGestureDetector;
    protected final c mHandler;
    protected com.tencent.mobileqq.colornote.swipe.a mOnPageSwipeListener;
    protected Scroller mScroller;
    protected int mTouchSlop;
    private Animator mTransitionAnim;
    private List<ViewPager> mViewPagers;
    protected int mViewWidth;
    private boolean readyToSlide;
    protected int screenWidth;
    protected int tempX;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    protected class a extends GestureDetector.SimpleOnGestureListener {
        protected a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (motionEvent != null && motionEvent2 != null) {
                float x16 = motionEvent.getX() - motionEvent2.getX();
                float abs = Math.abs((motionEvent.getY() - motionEvent2.getY()) / x16);
                SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
                if (swipeBackLayout.allowedSliding && f16 >= 200.0f) {
                    if (x16 < 0.0f && abs < 0.5f) {
                        if (swipeBackLayout.mContext instanceof Activity) {
                            swipeBackLayout.isFling = true;
                            SwipeBackLayout.this.scrollRight();
                        } else {
                            swipeBackLayout.scrollRight();
                        }
                    }
                    return super.onFling(motionEvent, motionEvent2, f16, f17);
                }
                return super.onFling(motionEvent, motionEvent2, f16, f17);
            }
            return super.onFling(motionEvent, motionEvent2, f16, f17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void onSwipe(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<SwipeBackLayout> f201714a;

        c(SwipeBackLayout swipeBackLayout) {
            this.f201714a = new WeakReference<>(swipeBackLayout);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SwipeBackLayout swipeBackLayout = this.f201714a.get();
            if (message.what != 1) {
                super.handleMessage(message);
                return;
            }
            if (!swipeBackLayout.isStopped) {
                swipeBackLayout.isStopped = true;
                if (swipeBackLayout.mContext instanceof Activity) {
                    if (QLog.isColorLevel()) {
                        QLog.d(SwipeBackLayout.TAG, 2, "SwipeBackLayout finish()");
                    }
                    swipeBackLayout.isFling = true;
                    ((Activity) swipeBackLayout.mContext).finish();
                }
            }
        }
    }

    public SwipeBackLayout(Context context) {
        super(context);
        this.mViewPagers = new LinkedList();
        this.allowedSliding = false;
        this.readyToSlide = true;
        this.isStopped = false;
        this.isScrolledRight = false;
        this.mEnableSwipe = true;
        this.mHandler = new c(this);
        this.mContext = context;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mScroller = new Scroller(context);
        this.screenWidth = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
        this.mGestureDetector = new GestureDetector(context, new a());
        this.leftSwipeScope = dp2px(90.0f, context.getResources());
    }

    private void doActionMove(MotionEvent motionEvent) {
        b bVar;
        if (this.allowedSliding && this.mEnableSwipe) {
            int rawX = (int) motionEvent.getRawX();
            int i3 = this.tempX - rawX;
            if (rawX - this.downX > this.mTouchSlop && Math.abs(((int) motionEvent.getRawY()) - this.downY) < this.mTouchSlop) {
                if (!this.isSilding && (bVar = this.listener) != null) {
                    bVar.onSwipe(true);
                }
                this.isSilding = true;
            }
            if (!this.readyToSlide) {
                return;
            }
            this.tempX = rawX;
            if (rawX - this.downX > 0 && this.isSilding) {
                if (this.mContentView.getScrollX() + i3 > 0) {
                    i3 = -this.mContentView.getScrollX();
                }
                this.mContentView.scrollBy(i3, 0);
            }
        }
    }

    private void doActionUp(MotionEvent motionEvent) {
        if (this.allowedSliding && this.mEnableSwipe && this.readyToSlide) {
            this.isSilding = false;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "event.getRawX():" + motionEvent.getRawX() + "screenWidth:" + this.screenWidth + "mViewWidth:" + this.mViewWidth);
            }
            if (motionEvent.getRawX() - this.downX >= this.screenWidth / 2) {
                this.isFinish = true;
                if (this.mContentView.getScrollX() != 0) {
                    scrollRight();
                }
                b bVar = this.listener;
                if (bVar != null) {
                    bVar.onSwipe(false);
                    return;
                }
                return;
            }
            postDelayed(new Runnable() { // from class: com.tencent.mobileqq.colornote.swipe.SwipeBackLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.d(SwipeBackLayout.TAG, 2, "isFling:" + SwipeBackLayout.this.isFling);
                    }
                    if (!SwipeBackLayout.this.isFling) {
                        SwipeBackLayout.this.scrollOrigin();
                    }
                    if (SwipeBackLayout.this.listener != null) {
                        SwipeBackLayout.this.listener.onSwipe(false);
                    }
                }
            }, 100L);
            this.isFinish = false;
        }
    }

    public static int dp2px(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    private void getAllViewPager(List<ViewPager> list, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt instanceof ViewPager) {
                list.add((ViewPager) childAt);
            } else if (childAt instanceof ViewGroup) {
                getAllViewPager(list, (ViewGroup) childAt);
            }
        }
    }

    private void setContentView(View view) {
        this.mContentView = (View) view.getParent();
    }

    public void attachToActivity(Activity activity) {
        this.mActivity = activity;
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{R.attr.windowBackground});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View childAt = viewGroup.getChildAt(0);
        if (childAt == null) {
            return;
        }
        childAt.setBackgroundResource(resourceId);
        viewGroup.removeView(childAt);
        addView(childAt);
        setContentView(childAt);
        viewGroup.addView(this, 0);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.mContentView.scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
            if (this.mScroller.isFinished() && this.isFinish) {
                scrollRight();
            }
        }
    }

    public void disableSwipe() {
        this.mEnableSwipe = false;
    }

    public void enableSwipe() {
        this.mEnableSwipe = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fastScrollOrigin() {
        try {
            int scrollX = this.mContentView.getScrollX();
            this.mScroller.startScroll(scrollX, 0, -scrollX, 0, Math.abs(scrollX) / 2);
            postInvalidate();
            com.tencent.mobileqq.colornote.swipe.a aVar = this.mOnPageSwipeListener;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Exception unused) {
        }
    }

    protected ViewPager getTouchViewPager(List<ViewPager> list, MotionEvent motionEvent) {
        if (list != null && list.size() != 0) {
            Rect rect = new Rect();
            for (ViewPager viewPager : list) {
                viewPager.getHitRect(rect);
                if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return viewPager;
                }
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        ViewPager touchViewPager = getTouchViewPager(this.mViewPagers, motionEvent);
        if (touchViewPager != null && touchViewPager.getCurrentItem() != 0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && this.allowedSliding && this.mEnableSwipe && ((int) motionEvent.getRawX()) - this.downX > this.mTouchSlop && Math.abs(((int) motionEvent.getRawY()) - this.downY) < this.mTouchSlop) {
                return true;
            }
        } else {
            this.allowedSliding = false;
            int rawX = (int) motionEvent.getRawX();
            this.tempX = rawX;
            this.downX = rawX;
            this.downY = (int) motionEvent.getRawY();
            if (this.downX < this.leftSwipeScope) {
                this.allowedSliding = true;
            }
        }
        if (this.mEnableSwipe && (gestureDetector = this.mGestureDetector) != null) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (z16) {
            this.mViewWidth = getWidth();
            getAllViewPager(this.mViewPagers, this);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        int action = motionEvent.getAction();
        if (action == 0) {
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                doActionMove(motionEvent);
            }
        } else {
            doActionUp(motionEvent);
        }
        if (this.mEnableSwipe && (gestureDetector = this.mGestureDetector) != null) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void scrollOrigin() {
        try {
            int scrollX = this.mContentView.getScrollX();
            this.mScroller.startScroll(this.mContentView.getScrollX(), 0, -scrollX, 0, Math.abs(scrollX));
            postInvalidate();
            com.tencent.mobileqq.colornote.swipe.a aVar = this.mOnPageSwipeListener;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void scrollRight() {
        if (this.isScrolledRight) {
            return;
        }
        this.isScrolledRight = true;
        int scrollX = this.mViewWidth + this.mContentView.getScrollX();
        int i3 = (int) (((scrollX * 1.0d) / this.mViewWidth) * 700.0d);
        try {
            this.mScroller.startScroll(this.mContentView.getScrollX(), 0, (-scrollX) + 1, 0, Math.abs(i3));
        } catch (Exception unused) {
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "SwipeBackLayout scrollRight viewwithd=" + this.mViewWidth + "  startx+ " + this.mContentView.getScrollX() + "  left width = " + (-scrollX) + "  duration=" + i3);
        }
        this.mHandler.sendEmptyMessageDelayed(1, 200L);
        postInvalidate();
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.mGestureDetector = gestureDetector;
    }

    public void setOnSwipeListener(b bVar) {
        this.listener = bVar;
    }

    public void setReadyToSlide(boolean z16) {
        this.readyToSlide = z16;
    }

    public void setTransitionAnim(Animator animator) {
        this.mTransitionAnim = animator;
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
