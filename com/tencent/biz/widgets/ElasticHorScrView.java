package com.tencent.biz.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ElasticHorScrView extends HorizontalScrollView {
    protected final double C;
    protected int D;
    protected boolean E;

    /* renamed from: d, reason: collision with root package name */
    protected View f97686d;

    /* renamed from: e, reason: collision with root package name */
    protected ViewGroup f97687e;

    /* renamed from: f, reason: collision with root package name */
    protected Rect f97688f;

    /* renamed from: h, reason: collision with root package name */
    protected float f97689h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f97690i;

    /* renamed from: m, reason: collision with root package name */
    protected final int f97691m;

    public ElasticHorScrView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f97688f = new Rect();
        this.f97690i = false;
        this.f97691m = 300;
        this.C = 2.5d;
        this.D = 0;
        this.E = true;
    }

    private void a() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.f97686d.getLeft(), this.f97688f.left, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.f97686d.setAnimation(translateAnimation);
        View view = this.f97686d;
        Rect rect = this.f97688f;
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
        this.f97688f.setEmpty();
    }

    private void b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.E) {
                        this.f97689h = motionEvent.getX();
                        this.E = false;
                    }
                    float f16 = this.f97689h;
                    int i3 = (int) ((f16 - r7) / 2.5d);
                    this.f97689h = motionEvent.getX();
                    if (d()) {
                        if (this.f97688f.isEmpty()) {
                            this.f97688f.set(this.f97686d.getLeft(), this.f97686d.getTop(), this.f97686d.getRight(), this.f97686d.getBottom());
                        }
                        int measuredWidth = this.f97686d.getMeasuredWidth() - getWidth();
                        int scrollX = getScrollX();
                        Log.v("test", "inner.getLeft()" + this.f97686d.getLeft() + "distanceX" + i3 + "inner.getRight()" + this.f97686d.getRight());
                        if ((scrollX == 0 && i3 < 0) || (measuredWidth == scrollX && i3 > 0)) {
                            View view = this.f97686d;
                            view.layout(view.getLeft() - i3, this.f97686d.getTop(), this.f97686d.getRight() - i3, this.f97686d.getBottom());
                            return;
                        }
                        return;
                    }
                    scrollBy(i3, 0);
                    return;
                }
                return;
            }
            if (c()) {
                a();
            }
            this.E = true;
            return;
        }
        this.f97689h = motionEvent.getX();
    }

    private boolean c() {
        return !this.f97688f.isEmpty();
    }

    private boolean d() {
        int measuredWidth = this.f97686d.getMeasuredWidth() - getWidth();
        int scrollX = getScrollX();
        if (scrollX != 0 && measuredWidth != scrollX) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        if (getChildCount() > 0 && (getChildAt(0) instanceof ViewGroup)) {
            this.f97687e = (ViewGroup) getChildAt(0);
        }
        if (this.f97687e.getChildCount() > 0) {
            this.f97686d = this.f97687e.getChildAt(0);
        }
        super.onFinishInflate();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f97690i) {
            return false;
        }
        b(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public void setMove(boolean z16) {
        this.f97690i = z16;
    }

    public ElasticHorScrView(Context context) {
        super(context);
        this.f97688f = new Rect();
        this.f97690i = false;
        this.f97691m = 300;
        this.C = 2.5d;
        this.D = 0;
        this.E = true;
    }
}
