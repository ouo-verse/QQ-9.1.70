package com.tencent.biz.subscribe.comment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.Scroller;

/* compiled from: P */
/* loaded from: classes5.dex */
public class WorkSpaceView extends FrameLayout {
    private static final double H = Math.tan(Math.toRadians(30.0d));
    private VelocityTracker C;
    private a D;
    private int E;
    private boolean F;
    private Handler G;

    /* renamed from: d, reason: collision with root package name */
    private int f95969d;

    /* renamed from: e, reason: collision with root package name */
    private int f95970e;

    /* renamed from: f, reason: collision with root package name */
    private float f95971f;

    /* renamed from: h, reason: collision with root package name */
    private float f95972h;

    /* renamed from: i, reason: collision with root package name */
    private Scroller f95973i;

    /* renamed from: m, reason: collision with root package name */
    private int f95974m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(int i3);
    }

    public WorkSpaceView(Context context) {
        this(context, null);
    }

    private void c() {
        int width = getWidth();
        d((getScrollX() + (width / 2)) / width);
    }

    public void a(int i3) {
        boolean z16 = true;
        int max = Math.max(0, Math.min(i3, getChildCount() - 1));
        if (max == this.f95969d) {
            z16 = false;
        }
        this.f95970e = max;
        View focusedChild = getFocusedChild();
        if (focusedChild != null && z16 && focusedChild == getChildAt(this.f95969d)) {
            focusedChild.clearFocus();
        }
        int width = (getWidth() * max) - getScrollX();
        this.f95973i.startScroll(getScrollX(), 0, width, 0, Math.abs(width) * 2);
        a aVar = this.D;
        if (aVar != null) {
            aVar.a(max);
        }
        invalidate();
    }

    public int b() {
        return this.f95969d;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f95973i.computeScrollOffset()) {
            scrollTo(this.f95973i.getCurrX(), this.f95973i.getCurrY());
            postInvalidate();
            return;
        }
        int i3 = this.f95970e;
        if (i3 != -1) {
            this.f95969d = Math.max(0, Math.min(i3, getChildCount() - 1));
            this.f95970e = -1;
        }
    }

    public void d(int i3) {
        if (!this.f95973i.isFinished()) {
            return;
        }
        a(i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View view, int i3) {
        if (i3 == 17) {
            if (b() > 0) {
                d(b() - 1);
                return true;
            }
        } else if (i3 == 66 && b() < getChildCount() - 1) {
            d(b() + 1);
            return true;
        }
        return super.dispatchUnhandledMove(view, i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
    
        if (r0 != 3) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        byte b16;
        byte b17;
        int action = motionEvent.getAction();
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int abs = (int) Math.abs(x16 - this.f95971f);
                    int abs2 = (int) Math.abs(y16 - this.f95972h);
                    int i3 = this.E;
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
                    double d16 = abs2 / abs;
                    if ((b16 != false || b17 != false) && d16 < H) {
                        if (b16 != false) {
                            this.f95974m = 1;
                        }
                        if (this.F) {
                            this.F = false;
                            getChildAt(this.f95969d).cancelLongPress();
                        }
                    }
                }
            }
            this.f95974m = 0;
            this.F = false;
        } else {
            this.f95971f = x16;
            this.f95972h = y16;
            this.F = true;
            this.f95974m = !this.f95973i.isFinished() ? 1 : 0;
        }
        if (this.f95974m == 0) {
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        if (r0 != 3) goto L46;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i3;
        if (this.C == null) {
            this.C = VelocityTracker.obtain();
        }
        this.C.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x16 = motionEvent.getX();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.f95974m == 1) {
                        int i16 = (int) (this.f95971f - x16);
                        this.f95971f = x16;
                        int scrollX = getScrollX();
                        if (i16 < 0) {
                            if (scrollX > 0) {
                                scrollBy(Math.max(-scrollX, i16), 0);
                            }
                        } else if (i16 > 0) {
                            int right = (getChildAt(getChildCount() - 1).getRight() - scrollX) - getWidth();
                            if (right > 0) {
                                scrollBy(Math.min(right, i16), 0);
                            }
                            Message obtain = Message.obtain();
                            obtain.what = 0;
                            this.G.sendMessage(obtain);
                        }
                    }
                }
            }
            if (this.f95974m == 1) {
                VelocityTracker velocityTracker = this.C;
                velocityTracker.computeCurrentVelocity(1000);
                int xVelocity = (int) velocityTracker.getXVelocity();
                if (xVelocity > 500 && (i3 = this.f95969d) > 0) {
                    d(i3 - 1);
                } else if (xVelocity < -500 && this.f95969d < getChildCount() - 1) {
                    d(this.f95969d + 1);
                } else {
                    c();
                }
                VelocityTracker velocityTracker2 = this.C;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.C = null;
                }
            }
            this.f95974m = 0;
        } else {
            if (!this.f95973i.isFinished()) {
                this.f95973i.abortAnimation();
            }
            this.f95971f = x16;
            this.f95974m = 1;
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
        if (indexOfChild(view) == this.f95969d && this.f95973i.isFinished()) {
            return false;
        }
        return true;
    }

    public void setAllowLongPress(boolean z16) {
        this.F = z16;
    }

    public void setHandler(Handler handler) {
        this.G = handler;
    }

    public void setOnScreenChangeListener(a aVar) {
        this.D = aVar;
    }

    public WorkSpaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WorkSpaceView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f95970e = -1;
        this.f95974m = 0;
        this.f95973i = new Scroller(getContext());
        this.f95969d = 0;
        this.E = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
