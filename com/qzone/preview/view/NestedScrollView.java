package com.qzone.preview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.qzone.proxy.feedcomponent.util.g;
import com.qzone.proxy.feedcomponent.util.j;

/* compiled from: P */
/* loaded from: classes39.dex */
public class NestedScrollView extends ScrollView {
    private int C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private int f50055d;

    /* renamed from: e, reason: collision with root package name */
    private a f50056e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f50057f;

    /* renamed from: h, reason: collision with root package name */
    private float f50058h;

    /* renamed from: i, reason: collision with root package name */
    public int f50059i;

    /* renamed from: m, reason: collision with root package name */
    private Scroller f50060m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
        void onScrollChanged(int i3, int i16, int i17, int i18);
    }

    public NestedScrollView(Context context) {
        super(context);
        this.f50055d = g.a(100.0f);
        this.f50059i = 0;
        this.D = true;
        this.f50060m = new Scroller(context);
    }

    private int c(int i3) {
        if (i3 >= 0) {
            return 2;
        }
        return 1;
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f50060m.computeScrollOffset()) {
            scrollTo(this.f50060m.getCurrX(), this.f50060m.getCurrY());
            postInvalidate();
        }
    }

    public void d(int i3, int i16, int i17) {
        this.f50060m.startScroll(getScrollX(), getScrollY(), i3, i16, i17);
        invalidate();
    }

    public void e(int i3, int i16, int i17) {
        d(i3 - getScrollX(), i16 - getScrollY(), i17);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        j.a("NestScrollView", 4, "onInterceptTouchEvent  scrollY = " + getScrollY());
        if (getScrollY() >= this.f50055d) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, final int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        a aVar = this.f50056e;
        if (aVar != null) {
            aVar.onScrollChanged(i3, i16, i17, i18);
        }
        this.C = i16;
        if (this.D) {
            postDelayed(new Runnable() { // from class: com.qzone.preview.view.NestedScrollView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i16 != NestedScrollView.this.C || NestedScrollView.this.getScrollY() >= NestedScrollView.this.f50055d || NestedScrollView.this.getScrollY() <= 0) {
                        return;
                    }
                    NestedScrollView nestedScrollView = NestedScrollView.this;
                    int i19 = nestedScrollView.f50059i;
                    if (i19 == 1) {
                        nestedScrollView.e(0, nestedScrollView.f50055d, 500);
                        NestedScrollView.this.invalidate();
                    } else if (i19 == 2) {
                        nestedScrollView.e(0, 0, 500);
                        NestedScrollView.this.invalidate();
                    }
                }
            }, 200L);
        }
        this.f50059i = c(i18 - i16);
        j.a("NestScrollView", 4, "onScrollChanged  mScrollY = " + i16 + "oldY = " + i18);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y16 = motionEvent.getY();
        if (action == 1) {
            this.f50057f = false;
        } else if (action == 2) {
            float f16 = y16 - this.f50058h;
            this.f50057f = true;
            j.a("NestScrollView", 4, "onTouchEvent  mScrollY = " + getScrollY() + "dy = " + f16 + "picHeight =" + this.f50055d);
            if (getScrollY() >= this.f50055d && f16 < 0.0f) {
                motionEvent.setAction(0);
                dispatchTouchEvent(motionEvent);
            }
            this.f50058h = y16;
        } else if (action == 3) {
            this.f50057f = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAutoScorll(boolean z16) {
        this.D = z16;
    }

    public void setHeaderHeight(int i3) {
        this.f50055d = i3;
    }

    public void setScrollChangeListener(a aVar) {
        this.f50056e = aVar;
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f50055d = g.a(100.0f);
        this.f50059i = 0;
        this.D = true;
        this.f50060m = new Scroller(context);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f50055d = g.a(100.0f);
        this.f50059i = 0;
        this.D = true;
        this.f50060m = new Scroller(context);
    }
}
