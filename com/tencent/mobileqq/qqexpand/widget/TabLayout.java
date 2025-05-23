package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/* compiled from: P */
/* loaded from: classes35.dex */
public class TabLayout extends HorizontalScrollView {

    /* renamed from: d, reason: collision with root package name */
    protected float f264187d;

    /* renamed from: e, reason: collision with root package name */
    protected float f264188e;

    /* renamed from: f, reason: collision with root package name */
    protected float f264189f;

    /* renamed from: h, reason: collision with root package name */
    protected float f264190h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f264191i;

    /* renamed from: m, reason: collision with root package name */
    private a f264192m;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface a {
        View a(int i3);

        int b();

        Rect c(int i3);

        int d();

        int getCount();
    }

    public TabLayout(Context context) {
        super(context);
        c();
    }

    public ViewGroup b() {
        return this.f264191i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f264188e = 0.0f;
            this.f264187d = 0.0f;
            this.f264189f = motionEvent.getX();
            this.f264190h = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            this.f264187d += Math.abs(x16 - this.f264189f);
            this.f264188e += Math.abs(y16 - this.f264190h);
            this.f264189f = x16;
            this.f264190h = y16;
            getParent().requestDisallowInterceptTouchEvent(this.f264187d > this.f264188e);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void c() {
        setOverScrollMode(2);
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f264191i = linearLayout;
        linearLayout.setOrientation(0);
        addView(this.f264191i, new ViewGroup.LayoutParams(-1, -1));
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public void a(a aVar) {
        int count;
        int b16;
        int i3;
        if (aVar == null || (count = aVar.getCount()) <= 0) {
            return;
        }
        this.f264192m = aVar;
        this.f264191i.removeAllViews();
        if (count <= aVar.d()) {
            setFillViewport(true);
            i3 = 1;
            b16 = 0;
        } else {
            b16 = aVar.b();
            setFillViewport(false);
            i3 = 0;
        }
        for (int i16 = 0; i16 < count; i16++) {
            View a16 = aVar.a(i16);
            if (a16 != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b16, -1, i3);
                Rect c16 = aVar.c(i16);
                layoutParams.leftMargin = c16.left;
                layoutParams.topMargin = c16.top;
                layoutParams.rightMargin = c16.right;
                layoutParams.bottomMargin = c16.bottom;
                this.f264191i.addView(a16, layoutParams);
            }
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c();
    }
}
