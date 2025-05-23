package com.tencent.biz.qqcircle.richframework.widget;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

@TargetApi(14)
/* loaded from: classes5.dex */
public class PressDarkImageView extends ImageView {

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f92069h = {R.attr.fromAlpha, R.attr.toAlpha};

    /* renamed from: d, reason: collision with root package name */
    public float f92070d;

    /* renamed from: e, reason: collision with root package name */
    public float f92071e;

    /* renamed from: f, reason: collision with root package name */
    public int f92072f;

    public PressDarkImageView(Context context) {
        this(context, null, 0);
    }

    public void a() {
        if (this.f92072f == 1) {
            super.clearColorFilter();
        } else {
            super.setImageAlpha((int) (this.f92070d * 255.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (isPressed()) {
            if (this.f92072f == 1) {
                super.setColorFilter(436207616);
                return;
            } else {
                super.setImageAlpha((int) (this.f92071e * 255.0f));
                return;
            }
        }
        a();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public PressDarkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PressDarkImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f92070d = 1.0f;
        this.f92071e = 0.5f;
        this.f92072f = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f92069h);
        this.f92070d = obtainStyledAttributes.getFloat(0, this.f92070d);
        this.f92071e = obtainStyledAttributes.getFloat(1, this.f92071e);
        obtainStyledAttributes.recycle();
    }
}
