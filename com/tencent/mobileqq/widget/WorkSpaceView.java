package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.app.FrameHelperActivity;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WorkSpaceView extends FrameLayout {
    private int C;
    private VelocityTracker D;
    private b E;
    private int F;
    private boolean G;
    private Handler H;
    boolean I;
    private boolean J;

    /* renamed from: d, reason: collision with root package name */
    int f316584d;

    /* renamed from: e, reason: collision with root package name */
    private int f316585e;

    /* renamed from: f, reason: collision with root package name */
    private int f316586f;

    /* renamed from: h, reason: collision with root package name */
    private float f316587h;

    /* renamed from: i, reason: collision with root package name */
    private float f316588i;

    /* renamed from: m, reason: collision with root package name */
    private Scroller f316589m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 == 1) {
                    WorkSpaceView.this.H.removeMessages(0);
                }
            } else {
                WorkSpaceView workSpaceView = WorkSpaceView.this;
                int i16 = ((com.tencent.mobileqq.struct.a) workSpaceView.getChildAt(workSpaceView.f316584d).getTag()).f290272d * 1000;
                if (WorkSpaceView.this.getChildCount() > 1 && WorkSpaceView.this.getWidth() > 0) {
                    WorkSpaceView workSpaceView2 = WorkSpaceView.this;
                    workSpaceView2.e(workSpaceView2.b() + 1);
                }
                WorkSpaceView.this.H.sendEmptyMessageDelayed(0, i16);
            }
            super.handleMessage(message);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void a(int i3);
    }

    public WorkSpaceView(Context context) {
        this(context, null);
    }

    private boolean c(int i3) {
        if (i3 >= 0 && i3 < getChildCount()) {
            return true;
        }
        return false;
    }

    private void d() {
        int width = getWidth();
        e((getScrollX() + (width / 2)) / width);
    }

    public int b() {
        return this.f316584d;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f316589m.computeScrollOffset()) {
            scrollTo(this.f316589m.getCurrX(), this.f316589m.getCurrY());
            postInvalidate();
            return;
        }
        int i3 = this.f316586f;
        if (i3 != -2) {
            if (i3 == -1) {
                int childCount = getChildCount() - 1;
                this.f316584d = childCount;
                scrollTo(childCount * getWidth(), getScrollY());
            } else if (i3 == getChildCount()) {
                this.f316584d = 0;
                scrollTo(0, getScrollY());
            } else {
                this.f316584d = Math.max(0, Math.min(this.f316586f, getChildCount() - 1));
            }
            this.f316586f = -2;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        boolean z16;
        int min;
        int i3 = 0;
        boolean z17 = true;
        if (this.C != 1 && this.f316586f == -2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (canvas != null && getChildAt(this.f316584d) != null) {
                drawChild(canvas, getChildAt(this.f316584d), getDrawingTime());
                return;
            }
            return;
        }
        long drawingTime = getDrawingTime();
        int width = getWidth();
        float scrollX = getScrollX() / width;
        boolean z18 = this.I;
        int childCount = getChildCount();
        if (scrollX < 0.0f && z18) {
            min = childCount - 1;
            z17 = false;
        } else {
            min = Math.min((int) scrollX, childCount - 1);
            int i16 = min + 1;
            if (z18) {
                if (childCount != 0) {
                    i16 %= childCount;
                }
            } else {
                z17 = false;
            }
            i3 = i16;
        }
        if (c(min)) {
            if (i3 == 0 && !z17) {
                canvas.translate(-r10, 0.0f);
                drawChild(canvas, getChildAt(min), drawingTime);
                canvas.translate(childCount * width, 0.0f);
            } else {
                drawChild(canvas, getChildAt(min), drawingTime);
            }
        }
        if (scrollX != min && c(i3)) {
            if (z18 && i3 == 0 && z17) {
                canvas.translate(childCount * width, 0.0f);
                drawChild(canvas, getChildAt(i3), drawingTime);
                canvas.translate(-r7, 0.0f);
                return;
            }
            drawChild(canvas, getChildAt(i3), drawingTime);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View view, int i3) {
        if (i3 == 17) {
            if (b() > 0) {
                e(b() - 1);
                return true;
            }
        } else if (i3 == 66 && b() < getChildCount() - 1) {
            e(b() + 1);
            return true;
        }
        return super.dispatchUnhandledMove(view, i3);
    }

    public void e(int i3) {
        boolean z16 = true;
        if (!this.I) {
            f(i3, true);
            return;
        }
        if (!this.f316589m.isFinished()) {
            return;
        }
        int max = Math.max(-1, Math.min(i3, getChildCount()));
        if (max == this.f316584d) {
            z16 = false;
        }
        this.f316586f = max;
        View focusedChild = getFocusedChild();
        if (focusedChild != null && z16 && focusedChild == getChildAt(this.f316584d)) {
            focusedChild.clearFocus();
        }
        this.f316589m.startScroll(getScrollX(), 0, (getWidth() * max) - getScrollX(), 0, 400);
        b bVar = this.E;
        if (bVar != null) {
            bVar.a(max);
        }
        invalidate();
    }

    public void f(int i3, boolean z16) {
        if (!this.f316589m.isFinished()) {
            return;
        }
        boolean z17 = true;
        int max = Math.max(0, Math.min(i3, getChildCount() - 1));
        if (max == this.f316584d) {
            z17 = false;
        }
        this.f316586f = max;
        View focusedChild = getFocusedChild();
        if (focusedChild != null && z17 && focusedChild == getChildAt(this.f316584d)) {
            focusedChild.clearFocus();
        }
        this.f316589m.startScroll(getScrollX(), 0, (getWidth() * max) - getScrollX(), 0, 400);
        b bVar = this.E;
        if (bVar != null) {
            bVar.a(max);
        }
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        byte b16;
        byte b17;
        int action = motionEvent.getAction();
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int abs = (int) Math.abs(x16 - this.f316587h);
                    int abs2 = (int) Math.abs(y16 - this.f316588i);
                    int i3 = this.F;
                    if (abs > i3) {
                        b16 = true;
                    } else {
                        b16 = false;
                    }
                    if (abs2 > i3) {
                        b17 = true;
                    } else {
                        b17 = false;
                    }
                    if (b16 == false && b17 == false) {
                        this.C = 0;
                    } else {
                        this.C = 1;
                    }
                }
            } else {
                this.C = 0;
            }
        } else {
            this.f316587h = x16;
            this.f316588i = y16;
            this.G = true;
            this.C = !this.f316589m.isFinished() ? 1 : 0;
        }
        if (action == 0) {
            FrameHelperActivity.gj(false, "WorkSpaceView");
        } else if (action == 1 || action == 3) {
            FrameHelperActivity.gj(true, "WorkSpaceView");
        }
        if (this.C == 0) {
            return false;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int childCount = getChildCount();
        int i19 = 0;
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt = getChildAt(i26);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = getMeasuredWidth() + i19;
                childAt.layout(i19, 0, measuredWidth, getMeasuredHeight());
                i19 = measuredWidth;
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int childCount = getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            getChildAt(i17).measure(i3, i16);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
    
        if (r0 != 3) goto L54;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i3;
        int i16;
        View childAt;
        if (!this.J) {
            return false;
        }
        if (this.D == null) {
            this.D = VelocityTracker.obtain();
        }
        this.D.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x16 = motionEvent.getX();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.C == 1) {
                        int i17 = (int) (this.f316587h - x16);
                        this.f316587h = x16;
                        int scrollX = getScrollX();
                        if (i17 < 0) {
                            if (scrollX > 0) {
                                scrollBy(Math.max(-scrollX, i17), 0);
                            } else if (scrollX > (-getWidth())) {
                                scrollBy(i17, 0);
                            }
                        } else if (i17 > 0) {
                            int childCount = getChildCount();
                            if (childCount > 0 && (childAt = getChildAt(childCount - 1)) != null) {
                                i16 = childAt.getRight() - scrollX;
                            } else {
                                i16 = 0;
                            }
                            if (i16 > 0) {
                                scrollBy(Math.min(i16, i17), 0);
                            }
                        }
                    }
                }
            }
            if (this.C == 1) {
                VelocityTracker velocityTracker = this.D;
                velocityTracker.computeCurrentVelocity(1000);
                int xVelocity = (int) velocityTracker.getXVelocity();
                if (xVelocity > 500 && (i3 = this.f316584d) > -1) {
                    e(i3 - 1);
                } else if (xVelocity < -500 && this.f316584d < getChildCount()) {
                    e(this.f316584d + 1);
                } else {
                    d();
                }
                VelocityTracker velocityTracker2 = this.D;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.D = null;
                }
            }
            this.C = 0;
        } else {
            if (!this.f316589m.isFinished()) {
                this.f316589m.abortAnimation();
            }
            this.f316587h = x16;
            this.C = 1;
        }
        if (action == 0) {
            FrameHelperActivity.gj(false, "WorkSpaceView");
        } else if (action == 1 || action == 3) {
            FrameHelperActivity.gj(true, "WorkSpaceView");
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        Rect rect = new Rect();
        view2.getDrawingRect(rect);
        view2.requestRectangleOnScreen(rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z16) {
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == this.f316584d && this.f316589m.isFinished()) {
            return false;
        }
        e(indexOfChild);
        return true;
    }

    public void setCircle(boolean z16) {
        this.I = z16;
    }

    public void setOnScreenChangeListener(b bVar) {
        this.E = bVar;
    }

    public WorkSpaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WorkSpaceView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316585e = 0;
        this.f316586f = -2;
        this.C = 0;
        this.H = new a();
        this.I = true;
        this.J = true;
        this.f316589m = new Scroller(getContext(), new AccelerateDecelerateInterpolator());
        this.f316584d = this.f316585e;
        this.F = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
