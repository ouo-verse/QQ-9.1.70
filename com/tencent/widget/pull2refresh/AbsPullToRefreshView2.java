package com.tencent.widget.pull2refresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.az;
import com.tencent.widget.pull2refresh.anim.DefaultAnimManager;
import com.tencent.widget.pull2refresh.anim.IAnimManager;

/* loaded from: classes27.dex */
public abstract class AbsPullToRefreshView2 extends LinearLayout implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final int CHANGE_STATE_TO_READY = 0;
    private static final int HANDLE_MOV_HEAD_TO = 1;
    private static final int REFRESH_TIME_OUT = 2;
    private static final int RESET_VIEW_POS = 3;
    public static final int STATE_HEADER_REFRESHING = 1;
    public static final int STATE_HEADER_REFRESH_FAILED = 3;
    public static final int STATE_HEADER_REFRESH_SUCCESS = 2;
    public static final int STATE_HEADER_RELEASE_TO_READY = 5;
    public static final int STATE_HEADER_RELEASE_TO_REFRESH = 4;
    public static final int STATE_READY = 0;
    public static final int STATE_RELEASE_TODEFAULT = 6;
    public static final String TAG = "AbsPullToRefreshView2";
    public static final int Y_X_RATIO = 5;
    protected boolean isRefreshing;
    private float lastTouchX;
    private float lastTouchY;
    protected IAnimManager mAnimManager;
    private int mAnimSpeed;
    protected View mFooterView;
    private Handler mHandler;
    private Drawable mHeaderBgDrawable;
    private int mHeaderHeight;
    protected View mHeaderView;
    private int mHeaderVisibleHeight;
    private int mMaxVelocity;
    private int mPreFrameHeight;
    private int mState;
    private PullToRefreshListener pullToRefreshListener;

    public AbsPullToRefreshView2(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mState = 0;
        this.isRefreshing = false;
        this.mAnimSpeed = 10;
        this.lastTouchY = -1.0f;
        this.lastTouchX = -1.0f;
        init();
    }

    private void addViewToHeader(View view) {
        if (view == null) {
            return;
        }
        measureView(view);
        this.mHeaderVisibleHeight = configHeaderVisibleHeight();
        this.mHeaderHeight = view.getMeasuredHeight();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.mHeaderHeight);
        layoutParams.topMargin = -this.mHeaderHeight;
        super.addView(view, layoutParams);
    }

    private void clearAnima() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(3);
    }

    private int getHeaderCurPos() {
        return ((LinearLayout.LayoutParams) this.mHeaderView.getLayoutParams()).topMargin;
    }

    private void init() {
        initAnimBaseManager();
        super.setOrientation(1);
        this.mState = 0;
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.mHeaderView = generateHeaderView();
        this.mFooterView = generateFooterView();
        this.mPreFrameHeight = az.a(getContext(), 15.0f);
        this.mMaxVelocity = ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity();
        addViewToHeader(this.mHeaderView);
        setWillNotDraw(false);
    }

    private void log(String str) {
        Log.d(TAG, str);
    }

    private void measureView(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i3 = layoutParams.height;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private void moveHeaderBy(int i3) {
        log("moveHeaderBy dy=" + i3);
        if (i3 == 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mHeaderView.getLayoutParams();
        layoutParams.topMargin -= i3;
        this.mHeaderView.setLayoutParams(layoutParams);
        invalidate();
    }

    private void moveHeaderSmoothlyBy(int i3) {
        log("moveHeaderSmoothlyBy dy=" + i3);
        if (Math.abs(i3) > this.mPreFrameHeight * 2) {
            return;
        }
        moveHeaderBy(i3);
    }

    private void moveHeaderTo(int i3, int i16) {
        log("moveHeaderTo:" + i3 + ",duration=" + i16 + ",getHeaderCurPos()=" + getHeaderCurPos());
        if (i3 == getHeaderCurPos()) {
            return;
        }
        this.mHandler.removeMessages(1);
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(1, i3, i16));
    }

    private void notifyHeaderRefreshStateChange(int i3) {
        PullToRefreshListener pullToRefreshListener = this.pullToRefreshListener;
        if (pullToRefreshListener == null) {
            return;
        }
        if (i3 != 1) {
            int i16 = 0;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            int abs = 100 - Math.abs((int) (((getHeaderCurPos() * 1.0f) / (-this.mHeaderHeight)) * 100.0f));
                            if (abs >= 0) {
                                i16 = abs;
                            }
                            if (!this.isRefreshing) {
                                this.pullToRefreshListener.onNotCompleteVisable(this.mHeaderView, i16);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (!this.isRefreshing) {
                        pullToRefreshListener.onViewCompleteVisable(this.mHeaderView);
                        return;
                    }
                    return;
                }
                if (this.isRefreshing) {
                    pullToRefreshListener.onRefreshCompleted(this.mHeaderView, false);
                    Handler handler = this.mHandler;
                    handler.sendMessageDelayed(handler.obtainMessage(0), 1000L);
                }
                this.isRefreshing = false;
                this.mHandler.removeMessages(2);
                return;
            }
            if (this.isRefreshing) {
                pullToRefreshListener.onRefreshCompleted(this.mHeaderView, true);
                Handler handler2 = this.mHandler;
                handler2.sendMessageDelayed(handler2.obtainMessage(0), 0L);
            }
            this.isRefreshing = false;
            this.mHandler.removeMessages(2);
            return;
        }
        if (!this.isRefreshing) {
            this.isRefreshing = true;
            pullToRefreshListener.onViewCompleteVisableAndReleased(this.mHeaderView);
        }
    }

    private void shieldedConflictTouchEvent(boolean z16) {
        clearContentViewClickEvent(z16);
        getParent().requestDisallowInterceptTouchEvent(true);
    }

    private void stopLoadingState(long j3) {
        if (this.isRefreshing) {
            this.pullToRefreshListener.onRefreshCompleted(this.mHeaderView, true);
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(0), j3);
            this.isRefreshing = false;
            this.mHandler.removeMessages(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void changeToState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        if (this.mState == i3 && i3 != 5) {
            return;
        }
        log("change to state:" + i3);
        this.mState = i3;
        if (i3 != 0) {
            if (i3 == 1) {
                moveHeaderTo(this.mHeaderVisibleHeight - this.mHeaderHeight, 200);
            }
        } else {
            moveHeaderTo(-this.mHeaderHeight, 200);
            this.mHandler.removeMessages(2);
        }
        notifyHeaderRefreshStateChange(this.mState);
    }

    protected abstract void clearContentViewClickEvent(boolean z16);

    protected int configHeaderVisibleHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return az.a(getContext(), 60.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
    
        if (r0 != 3) goto L67;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x16 = this.lastTouchX - motionEvent.getX();
                    float y16 = this.lastTouchY - motionEvent.getY();
                    int headerCurPos = getHeaderCurPos();
                    log("dispatchTouchEvent: move getY=" + motionEvent.getY() + ",isScroll2Top()()=" + isScroll2Top() + ",mHeaderHeight=" + this.mHeaderHeight + ",currentHeaderPos=" + headerCurPos + ",dy=" + y16 + ",dx=" + x16);
                    this.lastTouchX = motionEvent.getX();
                    this.lastTouchY = motionEvent.getY();
                    if (Math.abs(y16) / Math.abs(x16) < 5.0f) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        if (isScroll2Top() && y16 < 0.0f) {
                            moveHeaderSmoothlyBy(((int) y16) / 2);
                            shieldedConflictTouchEvent(true);
                        } else {
                            int i3 = this.mHeaderHeight;
                            if (headerCurPos > (-i3)) {
                                if (motionEvent.getPointerCount() > 1) {
                                    shieldedConflictTouchEvent(true);
                                } else if (Math.abs(y16) > 0.0f) {
                                    float f16 = headerCurPos - y16;
                                    int i16 = this.mHeaderHeight;
                                    if (f16 < (-i16)) {
                                        y16 = headerCurPos + i16;
                                    }
                                    moveHeaderSmoothlyBy((int) y16);
                                    shieldedConflictTouchEvent(true);
                                }
                            } else if (headerCurPos < (-i3)) {
                                if (motionEvent.getPointerCount() > 1) {
                                    shieldedConflictTouchEvent(true);
                                } else if (Math.abs(y16) > 0.0f) {
                                    float f17 = headerCurPos - y16;
                                    int i17 = this.mHeaderHeight;
                                    if (f17 > (-i17)) {
                                        y16 = headerCurPos + i17;
                                    }
                                    moveHeaderSmoothlyBy((int) y16);
                                    shieldedConflictTouchEvent(true);
                                }
                            } else {
                                shieldedConflictTouchEvent(false);
                            }
                        }
                        int headerCurPos2 = getHeaderCurPos();
                        int i18 = this.mHeaderVisibleHeight;
                        int i19 = this.mHeaderHeight;
                        if (headerCurPos2 > i18 - i19) {
                            changeToState(4);
                        } else if (headerCurPos2 > (-i19)) {
                            changeToState(5);
                        } else if (headerCurPos2 < (-i19)) {
                            changeToState(6);
                        }
                    }
                }
            }
            log("dispatchTouchEvent: *******up****** mState=" + this.mState);
            getParent().requestDisallowInterceptTouchEvent(false);
            this.lastTouchY = -1.0f;
            this.lastTouchX = -1.0f;
            int i26 = this.mState;
            if (i26 == 4) {
                changeToState(1);
            } else if (i26 == 5) {
                changeToState(0);
            } else if (i26 == 6) {
                changeToState(0);
            } else if (getHeaderCurPos() != (-this.mHeaderHeight)) {
                Handler handler = this.mHandler;
                handler.sendMessage(handler.obtainMessage(3));
            }
        } else {
            log("dispatchTouchEvent: ------down------ getY=" + motionEvent.getY());
            clearAnima();
            this.lastTouchX = motionEvent.getX();
            this.lastTouchY = motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected abstract View generateFooterView();

    protected abstract View generateHeaderView();

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        moveHeaderTo(-this.mHeaderHeight, 100);
                        this.mHandler.removeMessages(2);
                    }
                } else {
                    changeToState(3);
                }
            } else {
                int i16 = message.arg1;
                int i17 = message.arg2;
                int headerCurPos = i16 - getHeaderCurPos();
                int i18 = this.mAnimSpeed;
                int i19 = (headerCurPos * i18) / i17;
                int i26 = i17 - i18;
                if (i26 > 0 && (i19 != 0 || getHeaderCurPos() - i16 <= 0)) {
                    moveHeaderBy(-i19);
                    Handler handler = this.mHandler;
                    handler.sendMessageDelayed(handler.obtainMessage(1, i16, i26), this.mAnimSpeed);
                } else {
                    moveHeaderBy(getHeaderCurPos() - i16);
                }
            }
        } else {
            changeToState(0);
        }
        return true;
    }

    protected void initAnimBaseManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            setAnimType(new DefaultAnimManager(getContext()));
        }
    }

    protected abstract boolean isScroll2Bottom();

    protected abstract boolean isScroll2Top();

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        IAnimManager iAnimManager = this.mAnimManager;
        if (iAnimManager != null) {
            iAnimManager.onDestroy();
            this.mAnimManager = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            super.onDetachedFromWindow();
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) canvas);
            return;
        }
        int headerCurPos = getHeaderCurPos() + this.mHeaderHeight;
        if (headerCurPos > 0 && (drawable = this.mHeaderBgDrawable) != null) {
            drawable.setBounds(0, 0, getWidth(), headerCurPos);
            this.mHeaderBgDrawable.draw(canvas);
        }
        super.onDraw(canvas);
    }

    public void pullRefreshCompleted(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else if (z16) {
            changeToState(2);
        } else {
            changeToState(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rebound() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (isScroll2Top()) {
            this.mHandler.removeMessages(3);
            moveHeaderTo((this.mHeaderVisibleHeight / 2) - this.mHeaderHeight, 100);
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(3), 100L);
            return;
        }
        if (isScroll2Bottom()) {
            this.mHandler.removeMessages(3);
            moveHeaderTo((-this.mHeaderHeight) - this.mHeaderVisibleHeight, 100);
            Handler handler2 = this.mHandler;
            handler2.sendMessageDelayed(handler2.obtainMessage(3), 100L);
        }
    }

    public void setAnimType(IAnimManager iAnimManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iAnimManager);
            return;
        }
        IAnimManager iAnimManager2 = this.mAnimManager;
        if (iAnimManager2 != null && iAnimManager2.isSkinAnimManager()) {
            this.mAnimManager.onDestroy();
        }
        this.mAnimManager = iAnimManager;
    }

    public void setPullHeaderBgDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
        } else {
            this.mHeaderBgDrawable = drawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPullToRefreshListener(PullToRefreshListener pullToRefreshListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) pullToRefreshListener);
        } else {
            this.pullToRefreshListener = pullToRefreshListener;
        }
    }

    public void showRefreshResult(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), str);
        } else if (this.mAnimManager != null && this.isRefreshing) {
            stopLoadingState(1500L);
            this.mAnimManager.showRefreshResult(z16, str);
        }
    }

    public AbsPullToRefreshView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mState = 0;
        this.isRefreshing = false;
        this.mAnimSpeed = 10;
        this.lastTouchY = -1.0f;
        this.lastTouchX = -1.0f;
        init();
    }

    @TargetApi(11)
    public AbsPullToRefreshView2(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mState = 0;
        this.isRefreshing = false;
        this.mAnimSpeed = 10;
        this.lastTouchY = -1.0f;
        this.lastTouchX = -1.0f;
        init();
    }
}
