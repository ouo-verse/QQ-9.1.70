package com.tencent.av.widget.shimmer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.widget.shimmer.a;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ShimmerTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.av.widget.shimmer.a f77232d;

    /* renamed from: e, reason: collision with root package name */
    int f77233e;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class OnDrawRunnable implements Runnable {
        OnDrawRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ShimmerTextView shimmerTextView = ShimmerTextView.this;
            int i3 = shimmerTextView.f77233e + 1;
            shimmerTextView.f77233e = i3;
            if (i3 >= 50) {
                shimmerTextView.f77233e = 0;
            }
            shimmerTextView.setGradientX((shimmerTextView.getWidth() * ShimmerTextView.this.f77233e) / 50);
            ShimmerTextView.this.postInvalidate();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends AccessibilityDelegateCompat {
        a() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setVisibleToUser(false);
        }
    }

    public ShimmerTextView(Context context) {
        super(context);
        this.f77233e = 0;
        com.tencent.av.widget.shimmer.a aVar = new com.tencent.av.widget.shimmer.a(this, getPaint(), null);
        this.f77232d = aVar;
        aVar.h(getCurrentTextColor());
        ViewCompat.setAccessibilityDelegate(this, new a());
    }

    public boolean a() {
        com.tencent.av.widget.shimmer.a aVar = this.f77232d;
        if (aVar != null && aVar.b()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setShimmering(true);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setShimmering(false);
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"WrongCall", "DrawAllocation"})
    public void onDraw(Canvas canvas) {
        com.tencent.av.widget.shimmer.a aVar = this.f77232d;
        if (aVar != null) {
            aVar.c();
        }
        super.onDraw(canvas);
        if (a()) {
            postDelayed(new OnDrawRunnable(), 40L);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        com.tencent.av.widget.shimmer.a aVar = this.f77232d;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void setAnimationSetupCallback(a.InterfaceC0776a interfaceC0776a) {
        this.f77232d.f(interfaceC0776a);
    }

    public void setGradientX(float f16) {
        this.f77232d.g(f16);
    }

    public void setPrimaryColor(int i3) {
        this.f77232d.h(i3);
    }

    public void setReflectionColor(int i3) {
        this.f77232d.i(i3);
    }

    public void setShimmering(boolean z16) {
        this.f77232d.j(z16);
        super.postInvalidate();
    }

    @Override // android.widget.TextView
    public void setTextColor(int i3) {
        super.setTextColor(i3);
        com.tencent.av.widget.shimmer.a aVar = this.f77232d;
        if (aVar != null) {
            aVar.h(getCurrentTextColor());
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        com.tencent.av.widget.shimmer.a aVar = this.f77232d;
        if (aVar != null) {
            aVar.h(getCurrentTextColor());
        }
    }

    public ShimmerTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f77233e = 0;
        com.tencent.av.widget.shimmer.a aVar = new com.tencent.av.widget.shimmer.a(this, getPaint(), attributeSet);
        this.f77232d = aVar;
        aVar.h(getCurrentTextColor());
        ViewCompat.setAccessibilityDelegate(this, new a());
    }

    public ShimmerTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f77233e = 0;
        com.tencent.av.widget.shimmer.a aVar = new com.tencent.av.widget.shimmer.a(this, getPaint(), attributeSet);
        this.f77232d = aVar;
        aVar.h(getCurrentTextColor());
        ViewCompat.setAccessibilityDelegate(this, new a());
    }
}
