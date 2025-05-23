package com.tencent.mm.ui.widget.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.fp.c;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WeImageView extends c {

    /* renamed from: a, reason: collision with root package name */
    public int f153333a;

    /* renamed from: b, reason: collision with root package name */
    public float f153334b;

    /* renamed from: c, reason: collision with root package name */
    public int f153335c;

    /* renamed from: d, reason: collision with root package name */
    public int f153336d;

    /* renamed from: e, reason: collision with root package name */
    public int f153337e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f153338f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f153339g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f153340h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f153341i;

    public WeImageView(Context context) {
        super(context);
        this.f153334b = 1.0f;
        this.f153336d = 255;
        this.f153337e = 255;
        this.f153338f = true;
        this.f153339g = false;
        this.f153340h = true;
        this.f153341i = false;
        a(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        int color = context.getResources().getColor(R.color.ar9);
        this.f153335c = color;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.WeImageView);
            this.f153333a = obtainStyledAttributes.getColor(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.WeImageView_iconColor, this.f153335c);
            this.f153334b = obtainStyledAttributes.getFloat(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.WeImageView_iconAlpha, 1.0f);
            obtainStyledAttributes.recycle();
            return;
        }
        this.f153333a = color;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int i3 = this.f153336d;
        if (isPressed()) {
            i3 = 127;
        } else if (isEnabled()) {
            i3 = this.f153336d;
        }
        if (!isEnabled() || !isFocusable()) {
            i3 = 255;
        }
        if (isPressed() && this.f153341i) {
            i3 = (int) (this.f153336d * 0.5d);
        }
        if (i3 != this.f153337e) {
            this.f153337e = i3;
            if (getDrawable() != null) {
                getDrawable().setAlpha(i3);
            }
        }
    }

    public int getIconColor() {
        return this.f153333a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        super.onDraw(canvas);
        if (this.f153339g && this.f153338f) {
            getDrawable().mutate().clearColorFilter();
            this.f153339g = false;
            this.f153338f = false;
            return;
        }
        if (!this.f153340h && getDrawable() != null && this.f153338f) {
            getDrawable().mutate().clearColorFilter();
            this.f153338f = false;
            return;
        }
        if (this.f153340h && getDrawable() != null && this.f153338f) {
            int i16 = this.f153333a;
            if (i16 != 0) {
                i3 = (16777215 & i16) | (-16777216);
            } else {
                i3 = i16;
            }
            int alpha = Color.alpha(i16);
            float f16 = this.f153334b;
            if (f16 != 1.0f) {
                alpha = (int) (f16 * 255.0f);
            }
            getDrawable().mutate().setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_ATOP));
            if (this.f153333a != 0) {
                this.f153336d = alpha;
                getDrawable().setAlpha(alpha);
            }
            this.f153338f = false;
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (getContentDescription() == null && !isClickable()) {
            setImportantForAccessibility(2);
        }
    }

    public void setClearColorFilter(boolean z16) {
        this.f153339g = z16;
        this.f153338f = true;
        invalidate();
    }

    public void setEnableColorFilter(boolean z16) {
        if (this.f153340h != z16) {
            this.f153340h = z16;
            this.f153338f = true;
            invalidate();
        }
    }

    public void setEnableHighlight(boolean z16) {
        this.f153341i = z16;
    }

    public void setIconAlpha(float f16) {
        this.f153334b = f16;
        this.f153338f = true;
        invalidate();
    }

    public void setIconColor(int i3) {
        this.f153333a = i3;
        this.f153338f = true;
        invalidate();
    }

    public void setImageResource(@DrawableRes int i3, @ColorRes int i16) {
        setImageResource(i3);
        setIconColor(getContext().getResources().getColor(i16));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        setIconColor(this.f153333a);
    }

    public void setIconColor(int i3, float f16) {
        this.f153333a = i3;
        this.f153334b = f16;
        this.f153338f = true;
        invalidate();
    }

    public WeImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f153334b = 1.0f;
        this.f153336d = 255;
        this.f153337e = 255;
        this.f153338f = true;
        this.f153339g = false;
        this.f153340h = true;
        this.f153341i = false;
        a(context, attributeSet);
    }

    public WeImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f153334b = 1.0f;
        this.f153336d = 255;
        this.f153337e = 255;
        this.f153338f = true;
        this.f153339g = false;
        this.f153340h = true;
        this.f153341i = false;
        a(context, attributeSet);
    }
}
