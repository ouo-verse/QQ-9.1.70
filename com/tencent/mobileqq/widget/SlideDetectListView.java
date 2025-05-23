package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SlideDetectListView extends XListView implements u {
    private ArrayList<Integer> C;
    protected int D;
    protected int E;
    int F;
    protected boolean G;
    protected boolean H;
    protected GestureDetector.SimpleOnGestureListener I;
    protected GestureDetector J;
    protected boolean K;
    float L;
    private c M;
    private AbsListView.OnScrollListener N;
    private AbsListView.OnScrollListener P;

    /* renamed from: d, reason: collision with root package name */
    int f316283d;

    /* renamed from: e, reason: collision with root package name */
    boolean f316284e;

    /* renamed from: f, reason: collision with root package name */
    boolean f316285f;

    /* renamed from: h, reason: collision with root package name */
    View f316286h;

    /* renamed from: i, reason: collision with root package name */
    int f316287i;

    /* renamed from: m, reason: collision with root package name */
    int f316288m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (!SlideDetectListView.this.G) {
                return false;
            }
            if (f16 > 0.0f && Math.abs(f16) > Math.abs(f17) * 2.0f) {
                SlideDetectListView slideDetectListView = SlideDetectListView.this;
                if ((slideDetectListView.f316288m == 0 || slideDetectListView.H) && !slideDetectListView.f316284e) {
                    float abs = Math.abs(f16);
                    SlideDetectListView slideDetectListView2 = SlideDetectListView.this;
                    if (abs > slideDetectListView2.F) {
                        slideDetectListView2.f316287i = slideDetectListView2.h0(slideDetectListView2.f316283d);
                        SlideDetectListView slideDetectListView3 = SlideDetectListView.this;
                        slideDetectListView3.f316286h = slideDetectListView3.g0(slideDetectListView3.f316287i);
                        SlideDetectListView slideDetectListView4 = SlideDetectListView.this;
                        if (slideDetectListView4.f316286h != null) {
                            slideDetectListView4.f316284e = true;
                            slideDetectListView4.setPressed(false);
                            SlideDetectListView.this.f316286h.setPressed(false);
                            if (SlideDetectListView.this.M != null) {
                                SlideDetectListView slideDetectListView5 = SlideDetectListView.this;
                                int headerViewsCount = slideDetectListView5.f316287i - slideDetectListView5.getHeaderViewsCount();
                                c cVar = SlideDetectListView.this.M;
                                SlideDetectListView slideDetectListView6 = SlideDetectListView.this;
                                cVar.c(slideDetectListView6, slideDetectListView6.f316286h, headerViewsCount);
                            }
                            SlideDetectListView.this.f316283d = 0;
                        } else {
                            slideDetectListView4.f316285f = true;
                        }
                        return true;
                    }
                }
            }
            if (Math.abs(f16) > Math.abs(f17) * 2.0f) {
                SlideDetectListView.this.f316285f = true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements AbsListView.OnScrollListener {
        b() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            if (SlideDetectListView.this.N != null) {
                SlideDetectListView.this.N.onScroll(absListView, i3, i16, i17);
            }
            if (SlideDetectListView.this.P != null) {
                SlideDetectListView.this.P.onScroll(absListView, i3, i16, i17);
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            SlideDetectListView slideDetectListView = SlideDetectListView.this;
            slideDetectListView.f316288m = i3;
            if (slideDetectListView.N != null) {
                SlideDetectListView.this.N.onScrollStateChanged(absListView, i3);
            }
            if (SlideDetectListView.this.P != null) {
                SlideDetectListView.this.P.onScrollStateChanged(absListView, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
        void c(SlideDetectListView slideDetectListView, View view, int i3);

        void d(SlideDetectListView slideDetectListView, View view, int i3);
    }

    public SlideDetectListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316283d = 0;
        this.f316284e = false;
        this.f316285f = false;
        this.f316288m = 0;
        this.C = new ArrayList<>();
        this.E = -1;
        this.G = true;
        this.H = false;
        this.I = new a();
        this.J = null;
        this.K = false;
        this.L = 0.0f;
        this.M = null;
        this.N = null;
        this.P = null;
        super.setOnScrollListener(new b());
        this.F = ViewConfiguration.getTouchSlop() + 2;
    }

    @Override // com.tencent.widget.ListView
    public void addFooterView(View view, Object obj, boolean z16) {
        this.C.add(Integer.valueOf(view.hashCode()));
        super.addFooterView(view, obj, z16);
    }

    @Override // com.tencent.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z16) {
        this.C.add(Integer.valueOf(view.hashCode()));
        super.addHeaderView(view, obj, z16);
    }

    public void e0() {
        if (this.f316284e) {
            View view = this.f316286h;
            if (view != null) {
                view.setPressed(false);
                c cVar = this.M;
                if (cVar != null) {
                    cVar.d(this, this.f316286h, this.f316287i - getHeaderViewsCount());
                }
            }
            this.f316284e = false;
            this.f316286h = null;
        }
    }

    public void f0() {
        e0();
    }

    protected View g0(int i3) {
        if (i3 != -1) {
            try {
                return getChildAt(i3 - getFirstVisiblePosition());
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return null;
    }

    protected int h0(int i3) {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (!isStackFromBottom()) {
                for (int i16 = 0; i16 < childCount; i16++) {
                    View childAt = getChildAt(i16);
                    if (i3 <= childAt.getBottom()) {
                        if (this.C.contains(Integer.valueOf(childAt.hashCode()))) {
                            return -1;
                        }
                        int firstVisiblePosition = i16 + getFirstVisiblePosition();
                        if (isOverscrollHeadVisiable()) {
                            return firstVisiblePosition - 1;
                        }
                        return firstVisiblePosition;
                    }
                }
            } else {
                for (int i17 = childCount - 1; i17 >= 0; i17--) {
                    View childAt2 = getChildAt(i17);
                    if (i3 >= childAt2.getTop()) {
                        if (this.C.contains(Integer.valueOf(childAt2.hashCode()))) {
                            return -1;
                        }
                        int firstVisiblePosition2 = i17 + getFirstVisiblePosition();
                        if (isOverscrollHeadVisiable()) {
                            return firstVisiblePosition2 - 1;
                        }
                        return firstVisiblePosition2;
                    }
                }
            }
        }
        return -1;
    }

    public View i0() {
        return this.f316286h;
    }

    public void j0() {
        this.f316283d = 0;
        this.f316284e = false;
        this.f316286h = null;
        this.K = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00c6  */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        if (this.J == null) {
            GestureDetector gestureDetector = new GestureDetector(getContext(), this.I, new Handler(Looper.getMainLooper()));
            this.J = gestureDetector;
            gestureDetector.setIsLongpressEnabled(false);
        }
        this.J.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                this.f316285f = false;
            }
        } else {
            int y16 = (int) motionEvent.getY();
            this.f316283d = y16;
            this.K = false;
            int h06 = h0(y16);
            if (this.f316286h != null && g0(h06) == this.f316286h) {
                if (motionEvent.getX() >= this.f316286h.getWidth() - this.D) {
                    if (this.E > 0 && this.f316286h.getHeight() > 0) {
                        int top = this.f316286h.getTop() + (this.f316286h.getHeight() / 2);
                        int i3 = this.E;
                        int i16 = (i3 / 2) + top;
                        int i17 = top - (i3 / 2);
                        int i18 = this.f316283d;
                        if (i18 > i16 || i18 < i17) {
                            if (QLog.isColorLevel()) {
                                QLog.d("SlideDetectListView", 2, "accurate in delete:ycenter:" + top + ",motionheight:" + this.f316286h.getHeight() + "deleareaHeight:" + this.E);
                            }
                            z16 = false;
                            if (z16) {
                                this.K = true;
                                return false;
                            }
                        }
                    }
                    z16 = true;
                    if (z16) {
                    }
                }
            } else if (this.f316284e) {
                return true;
            }
        }
        if (this.K) {
            return false;
        }
        if (this.f316283d == 0 || this.f316284e) {
            return true;
        }
        if (this.f316285f) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.L = motionEvent.getY();
            if (this.f316284e) {
                View view = this.f316286h;
                if (view != null) {
                    view.setPressed(false);
                    c cVar = this.M;
                    if (cVar != null) {
                        cVar.d(this, this.f316286h, this.f316287i - getHeaderViewsCount());
                    }
                }
                this.f316284e = false;
                this.f316286h = null;
                return false;
            }
        }
        if (this.f316283d != 0 && !this.f316284e) {
            return super.onTouchEvent(motionEvent);
        }
        setPressed(false);
        View view2 = this.f316286h;
        if (view2 != null) {
            view2.setPressed(false);
        }
        return true;
    }

    @Override // com.tencent.widget.ListView
    public boolean removeFooterView(View view) {
        this.C.remove(Integer.valueOf(view.hashCode()));
        return super.removeFooterView(view);
    }

    @Override // com.tencent.widget.ListView
    public boolean removeHeaderView(View view) {
        this.C.remove(Integer.valueOf(view.hashCode()));
        return super.removeHeaderView(view);
    }

    public void setCanSlide(boolean z16) {
        this.G = z16;
    }

    public void setCheckStateWhenSlide(boolean z16) {
        this.H = !z16;
    }

    public void setDeleteAreaDim(int i3, int i16) {
        this.D = i3;
        this.E = i16;
    }

    public void setDeleteAreaWidth(int i3) {
        this.D = i3;
    }

    @Override // com.tencent.mobileqq.widget.u
    public void setMotionView(View view, int i3) {
        this.f316286h = view;
        this.f316287i = i3 + getHeaderViewsCount();
        if (this.f316286h != null) {
            this.f316284e = true;
        }
    }

    public void setOnScrollGroupFloatingListener(AbsListView.OnScrollListener onScrollListener) {
        this.P = onScrollListener;
    }

    public void setOnScrollToTopListener(AbsListView.OnScrollListener onScrollListener) {
        this.N = onScrollListener;
    }

    public void setOnSlideListener(c cVar) {
        this.M = cVar;
    }

    @Override // com.tencent.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
    }
}
