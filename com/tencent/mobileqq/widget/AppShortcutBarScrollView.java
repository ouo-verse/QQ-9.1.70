package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AppShortcutBarScrollView extends HorizontalScrollView {

    /* renamed from: d, reason: collision with root package name */
    protected View f315417d;

    /* renamed from: e, reason: collision with root package name */
    protected Rect f315418e;

    /* renamed from: f, reason: collision with root package name */
    protected float f315419f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f315420h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f315421i;

    /* renamed from: m, reason: collision with root package name */
    protected a f315422m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void onScroll();
    }

    public AppShortcutBarScrollView(Context context) {
        super(context);
        this.f315418e = new Rect();
        this.f315420h = false;
        this.f315421i = true;
    }

    private void a() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.f315417d.getLeft(), this.f315418e.left, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        this.f315417d.setAnimation(translateAnimation);
        View view = this.f315417d;
        Rect rect = this.f315418e;
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
        this.f315418e.setEmpty();
    }

    private void b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.f315421i) {
                        this.f315419f = motionEvent.getX();
                        this.f315421i = false;
                    }
                    float f16 = this.f315419f;
                    int i3 = (int) ((f16 - r7) / 2.5d);
                    this.f315419f = motionEvent.getX();
                    if (d()) {
                        if (this.f315418e.isEmpty()) {
                            this.f315418e.set(this.f315417d.getLeft(), this.f315417d.getTop(), this.f315417d.getRight(), this.f315417d.getBottom());
                        }
                        int measuredWidth = this.f315417d.getMeasuredWidth() - getWidth();
                        int scrollX = getScrollX();
                        if ((scrollX == 0 && i3 < 0) || (measuredWidth == scrollX && i3 > 0)) {
                            View view = this.f315417d;
                            view.layout(view.getLeft() - i3, this.f315417d.getTop(), this.f315417d.getRight() - i3, this.f315417d.getBottom());
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
            this.f315421i = true;
            return;
        }
        this.f315419f = motionEvent.getX();
    }

    private boolean c() {
        return !this.f315418e.isEmpty();
    }

    private boolean d() {
        int measuredWidth = this.f315417d.getMeasuredWidth() - getWidth();
        int scrollX = getScrollX();
        if (scrollX != 0 && measuredWidth != scrollX) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            this.f315417d = getChildAt(0);
        }
        super.onFinishInflate();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (motionEvent.getAction() == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        if (motionEvent.getAction() == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        if (!this.f315420h) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        a aVar = this.f315422m;
        if (aVar != null) {
            aVar.onScroll();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f315420h) {
            return false;
        }
        b(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public void setInnerView(View view) {
        this.f315417d = view;
    }

    public void setMove(boolean z16) {
        this.f315420h = z16;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.f315422m = aVar;
    }

    public AppShortcutBarScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315418e = new Rect();
        this.f315420h = false;
        this.f315421i = true;
    }

    public AppShortcutBarScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315418e = new Rect();
        this.f315420h = false;
        this.f315421i = true;
    }
}
