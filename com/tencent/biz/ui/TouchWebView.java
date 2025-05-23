package com.tencent.biz.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebViewCallbackClient;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TouchWebView extends CustomWebView implements WebViewCallbackClient {
    protected e helper;

    /* renamed from: l, reason: collision with root package name */
    OnOverScrollHandler f97013l;
    GestureDetector mGesture;
    public float mLastYUp;
    GestureDetector.OnGestureListener mOnGesture;
    private final ArrayList<OnOverScrolledListener> mOverScrolledListenerArrayList;
    private ArrayList<OnScrollChangedListener> mScrollChangedListenerArrayList;
    private OnScrollChangedListener mScrollListenerForBiz;
    public int mTotalYoffset;
    protected boolean overscroll;
    boolean overscrolling;

    /* renamed from: t, reason: collision with root package name */
    OnScrollChangedListener f97014t;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnOverScrollHandler {
        void onBack();

        void onOverScroll(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnOverScrolledListener {
        void onOverScrolled(int i3, int i16, boolean z16, boolean z17, View view);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnScrollChangedListener {
        void onScrollChanged(int i3, int i16, int i17, int i18, View view);
    }

    public TouchWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScrollChangedListenerArrayList = new ArrayList<>();
        this.mOverScrolledListenerArrayList = new ArrayList<>();
        this.mLastYUp = 0.0f;
        this.overscrolling = false;
        this.mOnGesture = new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.biz.ui.TouchWebView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                TouchWebView.this.getClass();
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                OnOverScrollHandler onOverScrollHandler;
                TouchWebView touchWebView = TouchWebView.this;
                if (((touchWebView.overscroll && f17 < 0.0f) || touchWebView.overscrolling) && (onOverScrollHandler = touchWebView.f97013l) != null) {
                    onOverScrollHandler.onOverScroll((int) (f17 / 1.5d));
                    TouchWebView.this.overscrolling = true;
                }
                if (TouchWebView.this.getParent() instanceof RefreshView) {
                    RefreshView refreshView = (RefreshView) TouchWebView.this.getParent();
                    if (refreshView.getScrollY() >= 0) {
                        TouchWebView touchWebView2 = TouchWebView.this;
                        if (touchWebView2.f97013l != null && touchWebView2.overscrolling) {
                            if (QLog.isDevelopLevel()) {
                                QLog.i(CustomWebView.TAG, 2, "RefreshView scrollY: " + refreshView.getScrollY());
                            }
                            TouchWebView.this.f97013l.onBack();
                            TouchWebView touchWebView3 = TouchWebView.this;
                            touchWebView3.overscrolling = false;
                            touchWebView3.overscroll = false;
                        }
                    }
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }
        };
        this.mTotalYoffset = 0;
        init();
    }

    @SuppressLint({"InlinedApi"})
    private void init() {
        this.mGesture = new GestureDetector(getContext(), this.mOnGesture);
        setWebViewCallbackClient(this);
        setFadingEdgeLength(0);
        if (getX5WebViewExtension() == null) {
            getSettings().setMixedContentMode(0);
        }
    }

    public void addOverScrolledListener(OnOverScrolledListener onOverScrolledListener) {
        if (onOverScrolledListener != null && !this.mOverScrolledListenerArrayList.contains(onOverScrolledListener)) {
            this.mOverScrolledListenerArrayList.add(onOverScrolledListener);
        }
    }

    public void addScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        if (onScrollChangedListener != null && !this.mScrollChangedListenerArrayList.contains(onScrollChangedListener)) {
            this.mScrollChangedListenerArrayList.add(onScrollChangedListener);
        }
    }

    public void clearScrollChangedListener() {
        this.mScrollChangedListenerArrayList.clear();
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public void computeScroll(View view) {
        super.super_computeScroll();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        this.mGesture.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            OnOverScrollHandler onOverScrollHandler = this.f97013l;
            if (onOverScrollHandler != null && this.overscrolling) {
                onOverScrollHandler.onBack();
                this.overscrolling = false;
                this.overscroll = false;
            }
            this.mLastYUp = motionEvent.getY();
        }
        if (this.overscrolling) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            OnOverScrollHandler onOverScrollHandler2 = this.f97013l;
            if (onOverScrollHandler2 != null) {
                onOverScrollHandler2.onBack();
                this.overscrolling = false;
                this.overscroll = false;
            }
            return true;
        }
        return super.super_dispatchTouchEvent(motionEvent);
    }

    public boolean inOverScroll() {
        return this.overscroll;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        return super.super_onInterceptTouchEvent(motionEvent);
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public void onOverScrolled(int i3, int i16, boolean z16, boolean z17, View view) {
        if (i16 <= 0) {
            this.overscroll = true;
        } else {
            this.overscroll = false;
        }
        super.super_onOverScrolled(i3, i16, z16, z17);
        Iterator<OnOverScrolledListener> it = this.mOverScrolledListenerArrayList.iterator();
        while (it.hasNext()) {
            OnOverScrolledListener next = it.next();
            if (next != null) {
                next.onOverScrolled(i3, i16, z16, z17, view);
            }
        }
    }

    public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
        super.super_onScrollChanged(i3, i16, i17, i18);
        this.mTotalYoffset += i16 - i18;
        OnScrollChangedListener onScrollChangedListener = this.f97014t;
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged(i3, i16, i17, i18, view);
        }
        OnScrollChangedListener onScrollChangedListener2 = this.mScrollListenerForBiz;
        if (onScrollChangedListener2 != null) {
            onScrollChangedListener2.onScrollChanged(i3, i16, i17, i18, view);
        }
        ArrayList<OnScrollChangedListener> arrayList = this.mScrollChangedListenerArrayList;
        if (arrayList != null) {
            Iterator<OnScrollChangedListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onScrollChanged(i3, i16, i17, i18, view);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.overscrolling) {
            return true;
        }
        return super.super_onTouchEvent(motionEvent);
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16, View view) {
        return super.super_overScrollBy(i3, i16, i17, i18, i19, i26, i27, i28, z16);
    }

    public void removeOverScrolledListener(OnOverScrolledListener onOverScrolledListener) {
        this.mOverScrolledListenerArrayList.remove(onOverScrolledListener);
    }

    public void removeScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        this.mScrollChangedListenerArrayList.remove(onScrollChangedListener);
    }

    @Override // com.tencent.biz.pubaccount.CustomWebView, com.tencent.biz.pubaccount.SuperWebView
    public void resetForReuse() {
        setOnOverScrollHandler(null);
        setOnScrollChangedListener(null);
        clearScrollChangedListener();
        super.resetForReuse();
    }

    public void setOnOverScrollHandler(OnOverScrollHandler onOverScrollHandler) {
        this.f97013l = onOverScrollHandler;
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        this.f97014t = onScrollChangedListener;
    }

    public void setOnScrollChangedListenerForBiz(OnScrollChangedListener onScrollChangedListener) {
        this.mScrollListenerForBiz = onScrollChangedListener;
    }

    public TouchWebView(Context context) {
        super(context);
        this.mScrollChangedListenerArrayList = new ArrayList<>();
        this.mOverScrolledListenerArrayList = new ArrayList<>();
        this.mLastYUp = 0.0f;
        this.overscrolling = false;
        this.mOnGesture = new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.biz.ui.TouchWebView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                TouchWebView.this.getClass();
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                OnOverScrollHandler onOverScrollHandler;
                TouchWebView touchWebView = TouchWebView.this;
                if (((touchWebView.overscroll && f17 < 0.0f) || touchWebView.overscrolling) && (onOverScrollHandler = touchWebView.f97013l) != null) {
                    onOverScrollHandler.onOverScroll((int) (f17 / 1.5d));
                    TouchWebView.this.overscrolling = true;
                }
                if (TouchWebView.this.getParent() instanceof RefreshView) {
                    RefreshView refreshView = (RefreshView) TouchWebView.this.getParent();
                    if (refreshView.getScrollY() >= 0) {
                        TouchWebView touchWebView2 = TouchWebView.this;
                        if (touchWebView2.f97013l != null && touchWebView2.overscrolling) {
                            if (QLog.isDevelopLevel()) {
                                QLog.i(CustomWebView.TAG, 2, "RefreshView scrollY: " + refreshView.getScrollY());
                            }
                            TouchWebView.this.f97013l.onBack();
                            TouchWebView touchWebView3 = TouchWebView.this;
                            touchWebView3.overscrolling = false;
                            touchWebView3.overscroll = false;
                        }
                    }
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }
        };
        this.mTotalYoffset = 0;
        init();
    }

    public void setWebViewHelper(e eVar) {
    }
}
