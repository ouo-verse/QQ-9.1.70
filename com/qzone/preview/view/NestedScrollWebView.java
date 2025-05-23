package com.qzone.preview.view;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.proxy.feedcomponent.util.j;
import com.tencent.biz.ui.TouchWebView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class NestedScrollWebView extends TouchWebView {
    public int C;
    private boolean D;
    private int E;
    private final int[] F;
    private int G;
    private NestedScrollView H;
    private boolean I;
    private int J;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements TouchWebView.OnScrollChangedListener {
        a() {
        }

        @Override // com.tencent.biz.ui.TouchWebView.OnScrollChangedListener
        public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
            j.a("NestedScrollWebView", 4, "onScrollChanged  mScrollY = " + i16 + "oldY = " + i18 + "mIsBeingDragged == " + NestedScrollWebView.this.D);
            NestedScrollWebView nestedScrollWebView = NestedScrollWebView.this;
            nestedScrollWebView.C = nestedScrollWebView.u(i18 - i16);
            NestedScrollWebView nestedScrollWebView2 = NestedScrollWebView.this;
            if (nestedScrollWebView2.C != 2 || i16 != 0 || nestedScrollWebView2.v() == null || NestedScrollWebView.this.D) {
                return;
            }
            NestedScrollWebView.this.v().smoothScrollTo(0, (NestedScrollWebView.this.J * 4) / 5);
        }
    }

    public NestedScrollWebView(Context context) {
        super(context);
        this.C = 0;
        this.D = false;
        this.F = new int[2];
        this.G = -1;
        init();
    }

    private void init() {
        setOnScrollChangedListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u(int i3) {
        if (i3 >= 0) {
            return 2;
        }
        if (i3 < 0) {
            return 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NestedScrollView v() {
        if (this.H == null) {
            this.H = (NestedScrollView) getParent().getParent();
        }
        return this.H;
    }

    private void w(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (MotionEventCompat.getPointerId(motionEvent, action) == this.G) {
            this.G = MotionEventCompat.getPointerId(motionEvent, action == 0 ? 1 : 0);
        }
    }

    @Override // com.tencent.biz.ui.TouchWebView, com.tencent.smtt.sdk.WebViewCallbackClient
    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        j.a("NestedScrollWebView", 4, "dispatchTouchEvent  getScrollY() = " + getScrollY() + "getWebScrollY == " + getWebScrollY());
        this.C = 0;
        if (actionMasked == 0) {
            this.I = false;
            this.E = (int) (motionEvent.getY() + 0.5f);
            this.G = MotionEventCompat.getPointerId(motionEvent, 0);
            this.D = false;
            return super_dispatchTouchEvent(motionEvent);
        }
        if (actionMasked == 1) {
            this.D = false;
            this.G = -1;
            return super_dispatchTouchEvent(motionEvent);
        }
        if (actionMasked != 2) {
            if (actionMasked == 3) {
                this.D = false;
            } else {
                if (actionMasked == 5) {
                    this.I = false;
                    this.E = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
                    this.G = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    return super_dispatchTouchEvent(motionEvent);
                }
                if (actionMasked == 6) {
                    this.D = false;
                    w(motionEvent);
                    this.E = (int) (MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.G)) + 0.5f);
                    return super_dispatchTouchEvent(motionEvent);
                }
            }
            return super_dispatchTouchEvent(motionEvent);
        }
        this.D = true;
        int y16 = (int) (MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.G)) + 0.5f);
        int i3 = y16 - this.E;
        if (i3 != 0) {
            this.C = u(i3);
        }
        this.E = y16 - this.F[1];
        if (this.C == 2 && getWebScrollY() == 0 && v() != null) {
            if (!this.I) {
                this.I = true;
                motionEvent.setAction(0);
            }
            v().onTouchEvent(motionEvent);
            return true;
        }
        return super_dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.biz.ui.TouchWebView, com.tencent.smtt.sdk.WebViewCallbackClient
    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        return super.onInterceptTouchEvent(motionEvent, view);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setHeaderHeight(int i3) {
        this.J = i3;
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = 0;
        this.D = false;
        this.F = new int[2];
        this.G = -1;
        init();
    }
}
