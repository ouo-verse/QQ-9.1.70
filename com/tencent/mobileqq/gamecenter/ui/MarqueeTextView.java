package com.tencent.mobileqq.gamecenter.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes12.dex */
public class MarqueeTextView extends TextView implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private int f213269d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f213270e;

    /* renamed from: f, reason: collision with root package name */
    private int f213271f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f213272h;

    public MarqueeTextView(Context context) {
        super(context);
        this.f213270e = false;
        this.f213272h = false;
    }

    private void e() {
        this.f213271f = (int) getPaint().measureText(getText().toString());
    }

    public void f() {
        this.f213270e = false;
        removeCallbacks(this);
        post(this);
    }

    public void g() {
        this.f213270e = true;
        removeCallbacks(this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f213272h) {
            e();
            this.f213272h = true;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i3 = this.f213269d + 2;
        this.f213269d = i3;
        scrollTo(i3, 0);
        if (this.f213270e) {
            return;
        }
        if (getScrollX() >= this.f213271f) {
            int i16 = -getMeasuredWidth();
            scrollTo(i16, 0);
            this.f213269d = i16;
        }
        postDelayed(this, 10L);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (!TextUtils.isEmpty(charSequence)) {
            f();
        }
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f213270e = false;
        this.f213272h = false;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f213270e = false;
        this.f213272h = false;
    }
}
