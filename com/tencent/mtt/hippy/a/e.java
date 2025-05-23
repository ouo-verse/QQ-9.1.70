package com.tencent.mtt.hippy.a;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.utils.LogUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e extends ImageView implements ValueAnimator.AnimatorUpdateListener, ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    int f336951a;

    /* renamed from: b, reason: collision with root package name */
    int f336952b;

    /* renamed from: c, reason: collision with root package name */
    int f336953c;

    /* renamed from: d, reason: collision with root package name */
    int f336954d;

    /* renamed from: e, reason: collision with root package name */
    int f336955e;

    /* renamed from: f, reason: collision with root package name */
    int f336956f;

    /* renamed from: g, reason: collision with root package name */
    final int f336957g;

    /* renamed from: h, reason: collision with root package name */
    final int f336958h;

    /* renamed from: i, reason: collision with root package name */
    final int f336959i;

    /* renamed from: j, reason: collision with root package name */
    private int f336960j;

    /* renamed from: k, reason: collision with root package name */
    private int f336961k;

    public e(Context context) {
        super(context);
        this.f336960j = -1;
        this.f336961k = -1;
        this.f336953c = 0;
        this.f336954d = 0;
        this.f336955e = 0;
        this.f336956f = 0;
        this.f336958h = 30;
        this.f336959i = ViewConfiguration.getTouchSlop();
        this.f336957g = (int) a(context);
        b();
        setFocusable(true);
    }

    private void b() {
        a();
    }

    private ViewGroup.MarginLayoutParams getMarginLayoutParams() {
        if (getParent() != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                int i3 = this.f336957g;
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i3, i3);
                layoutParams2.topMargin = this.f336957g;
                return layoutParams2;
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                int i16 = this.f336957g;
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i16, i16);
                layoutParams3.topMargin = this.f336957g;
                return layoutParams3;
            }
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int i17 = this.f336957g;
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i17, i17);
                layoutParams4.topMargin = this.f336957g;
                return layoutParams4;
            }
            int i18 = this.f336957g;
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i18, i18);
            marginLayoutParams.topMargin = this.f336957g;
            return marginLayoutParams;
        }
        int i19 = this.f336957g;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i19, i19);
        marginLayoutParams2.topMargin = this.f336957g;
        return marginLayoutParams2;
    }

    float a(Context context) {
        return TypedValue.applyDimension(1, 30.0f, context.getResources().getDisplayMetrics());
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Number) {
            int intValue = ((Number) animatedValue).intValue();
            layout(intValue, getTop(), getWidth() + intValue, getBottom());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        ViewGroup viewGroup;
        setLayoutParams(getMarginLayoutParams());
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if ((parent instanceof HippyRootView) && (viewGroup = (ViewGroup) getRootView()) != parent) {
            ((HippyRootView) parent).removeView(this);
            viewGroup.addView(this);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f336960j = ((ViewGroup) getParent()).getWidth();
        this.f336961k = ((ViewGroup) getParent()).getHeight();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
    
        if (r0 != 3) goto L33;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ValueAnimator ofInt;
        int action = motionEvent.getAction();
        if (action != 0) {
            int i3 = 0;
            if (action != 1) {
                if (action == 2) {
                    int rawX = ((int) motionEvent.getRawX()) - this.f336951a;
                    int rawY = ((int) motionEvent.getRawY()) - this.f336952b;
                    int i16 = this.f336953c + rawX;
                    int i17 = this.f336955e + rawY;
                    int i18 = this.f336954d + rawX;
                    int i19 = this.f336956f + rawY;
                    if (i16 < 0) {
                        i18 = getWidth() + 0;
                        i16 = 0;
                    }
                    int i26 = this.f336960j;
                    if (i18 > i26) {
                        i16 = i26 - getWidth();
                        i18 = i26;
                    }
                    if (i17 < 0) {
                        i19 = getHeight() + 0;
                    } else {
                        i3 = i17;
                    }
                    int i27 = this.f336961k;
                    if (i19 > i27) {
                        i3 = i27 - getHeight();
                        i19 = i27;
                    }
                    layout(i16, i3, i18, i19);
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            if (getLeft() > this.f336960j / 2) {
                ofInt = ValueAnimator.ofInt(getLeft(), this.f336960j - getWidth());
            } else {
                ofInt = ValueAnimator.ofInt(getLeft(), 0);
            }
            ofInt.addUpdateListener(this);
            ofInt.start();
            int rawX2 = (int) motionEvent.getRawX();
            int rawY2 = (int) motionEvent.getRawY();
            if (Math.abs(this.f336951a - rawX2) > this.f336959i || Math.abs(this.f336952b - rawY2) > this.f336959i) {
                return true;
            }
        } else {
            getParent().requestDisallowInterceptTouchEvent(true);
            this.f336951a = (int) motionEvent.getRawX();
            this.f336952b = (int) motionEvent.getRawY();
            this.f336953c = getLeft();
            this.f336954d = getRight();
            this.f336955e = getTop();
            this.f336956f = getBottom();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void a() {
        int[] iArr = {R.attr.state_focused, R.attr.state_enabled};
        int parseColor = Color.parseColor("#ddd9d9");
        StateListDrawable stateListDrawable = new StateListDrawable();
        float f16 = this.f336957g / 2;
        RoundRectShape roundRectShape = new RoundRectShape(new float[]{f16, f16, f16, f16, f16, f16, f16, f16}, null, null);
        ShapeDrawable shapeDrawable = new ShapeDrawable(roundRectShape);
        shapeDrawable.getPaint().setColor(-16711936);
        stateListDrawable.addState(iArr, shapeDrawable);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(roundRectShape);
        shapeDrawable2.getPaint().setColor(parseColor);
        stateListDrawable.addState(new int[0], shapeDrawable2);
        setBackgroundDrawable(stateListDrawable);
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.mtt.hippy.a.e.1
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                boolean requestFocusFromTouch = e.this.requestFocusFromTouch();
                LogUtils.d(NodeProps.REQUEST_FOCUS, "requestFocusFromTouch result:" + requestFocusFromTouch);
                if (!requestFocusFromTouch) {
                    LogUtils.d(NodeProps.REQUEST_FOCUS, "requestFocus result:" + e.this.requestFocus());
                    return false;
                }
                return false;
            }
        });
    }
}
