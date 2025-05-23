package com.tencent.mm.ui.widget.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import com.tencent.luggage.wxa.fp.b;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WeImageButton extends b {

    /* renamed from: a, reason: collision with root package name */
    public int f153325a;

    /* renamed from: b, reason: collision with root package name */
    public int f153326b;

    /* renamed from: c, reason: collision with root package name */
    public float f153327c;

    /* renamed from: d, reason: collision with root package name */
    public int f153328d;

    /* renamed from: e, reason: collision with root package name */
    public int f153329e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f153330f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f153331g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f153332h;

    public WeImageButton(Context context) {
        super(context, null);
        this.f153327c = 1.0f;
        this.f153328d = 255;
        this.f153329e = 255;
        this.f153330f = true;
        this.f153331g = false;
        this.f153332h = true;
        a(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        int color = context.getResources().getColor(R.color.ar9);
        this.f153326b = color;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.WeImageBtn);
            this.f153325a = obtainStyledAttributes.getColor(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.WeImageBtn_btnIconColor, this.f153326b);
            this.f153327c = obtainStyledAttributes.getFloat(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.WeImageBtn_btnIconAlpha, 1.0f);
            obtainStyledAttributes.recycle();
            return;
        }
        this.f153325a = color;
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int i3 = this.f153328d;
        if (isPressed()) {
            i3 = 127;
        } else if (isEnabled()) {
            i3 = this.f153328d;
        }
        if (!isEnabled() || !isFocusable()) {
            i3 = 255;
        }
        if (i3 != this.f153329e) {
            this.f153329e = i3;
            if (getDrawable() != null) {
                getDrawable().setAlpha(i3);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        super.onDraw(canvas);
        if (this.f153331g && this.f153330f) {
            getDrawable().clearColorFilter();
            this.f153331g = false;
            this.f153330f = false;
            return;
        }
        if (!this.f153332h && getDrawable() != null && this.f153330f) {
            getDrawable().clearColorFilter();
            this.f153330f = false;
            return;
        }
        if (this.f153332h && getDrawable() != null && this.f153330f) {
            int i16 = this.f153325a;
            if (i16 != 0) {
                i3 = (16777215 & i16) | (-16777216);
            } else {
                i3 = i16;
            }
            int alpha = Color.alpha(i16);
            float f16 = this.f153327c;
            if (f16 != 1.0f) {
                alpha = (int) (f16 * 255.0f);
            }
            getDrawable().setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_ATOP));
            if (this.f153325a != 0) {
                this.f153328d = alpha;
                getDrawable().setAlpha(alpha);
            }
            this.f153330f = false;
        }
    }

    public void setIconColor(int i3) {
        this.f153325a = i3;
        this.f153330f = true;
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        setIconColor(this.f153325a);
    }

    public WeImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f153327c = 1.0f;
        this.f153328d = 255;
        this.f153329e = 255;
        this.f153330f = true;
        this.f153331g = false;
        this.f153332h = true;
        a(context, attributeSet);
    }

    public WeImageButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f153327c = 1.0f;
        this.f153328d = 255;
        this.f153329e = 255;
        this.f153330f = true;
        this.f153331g = false;
        this.f153332h = true;
        a(context, attributeSet);
    }
}
